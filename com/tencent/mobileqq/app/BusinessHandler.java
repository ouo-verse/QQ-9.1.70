package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class BusinessHandler extends BaseBusinessHandler {
    static IPatchRedirector $redirector_ = null;
    public static final int BG_OBSERVERS = 2;
    public static final int DEFAULT_OBSERVER = 0;
    private static final String TAG = "BusinessHandler";
    public static final int UI_OBSERVERS = 1;
    private static final MqqHandler bgHandler;
    private static final MqqHandler uiHandler;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40858);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            uiHandler = new MqqHandler(Looper.getMainLooper());
            bgHandler = ThreadManager.getSubThreadHandler();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BusinessHandler(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.appRuntime = appInterface;
        }
    }

    private void dispatchMessage(int i3, boolean z16, Object obj, boolean z17, BusinessObserver businessObserver, MqqHandler mqqHandler) {
        Runnable runnable = new Runnable(businessObserver, i3, z16, obj) { // from class: com.tencent.mobileqq.app.BusinessHandler.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Object val$data;
            final /* synthetic */ BusinessObserver val$destObserver;
            final /* synthetic */ boolean val$isSuccess;
            final /* synthetic */ int val$type;

            {
                this.val$destObserver = businessObserver;
                this.val$type = i3;
                this.val$isSuccess = z16;
                this.val$data = obj;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, BusinessHandler.this, businessObserver, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    this.val$destObserver.onUpdate(this.val$type, this.val$isSuccess, this.val$data);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(BusinessHandler.TAG, 2, "onUpdate fail", e16);
                    }
                }
            }
        };
        if (z17) {
            mqqHandler.postAtFrontOfQueue(runnable);
        } else {
            mqqHandler.post(runnable);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return null;
    }

    public List<BusinessObserver> getObservers(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        return this.appRuntime.getBusinessObserver(i3);
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getPushCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getPushPBCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return null;
    }

    protected boolean isAssignableFrom(BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) businessObserver)).booleanValue();
        }
        Class<? extends BusinessObserver> observerClass = observerClass();
        if (observerClass == null) {
            return false;
        }
        if (businessObserver instanceof QQLifecycleBusinessObserver) {
            return observerClass.isAssignableFrom(((QQLifecycleBusinessObserver) businessObserver).getBusinessObserverClass());
        }
        return observerClass.isAssignableFrom(businessObserver.getClass());
    }

    public void notifyUI(ToServiceMsg toServiceMsg, int i3, boolean z16, Object obj) {
        BusinessObserver remove;
        MqqHandler mqqHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        Bundle bundle = toServiceMsg.extraData;
        String str = BaseBusinessHandler.SEQ_KEY;
        if (bundle.containsKey(str)) {
            long j3 = toServiceMsg.extraData.getLong(str);
            synchronized (this.uiObserverMap) {
                remove = this.uiObserverMap.remove(Long.valueOf(j3));
                mqqHandler = uiHandler;
            }
            if (remove == null) {
                synchronized (this.bgObserverMap) {
                    remove = this.bgObserverMap.remove(Long.valueOf(j3));
                    mqqHandler = bgHandler;
                }
            }
            BusinessObserver businessObserver = remove;
            MqqHandler mqqHandler2 = mqqHandler;
            if (businessObserver != null) {
                dispatchMessage(i3, z16, obj, false, businessObserver, mqqHandler2);
                return;
            }
        }
        notifyUI(i3, z16, obj);
    }

    protected abstract Class<? extends BusinessObserver> observerClass();

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    public final void notifyUI(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            notifyUI(i3, z16, obj, false);
        } else {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        }
    }

    public void notifyUI(int i3, boolean z16, Object obj, boolean z17) {
        long currentTimeMillis;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj, Boolean.valueOf(z17));
            return;
        }
        List<BusinessObserver> observers = getObservers(0);
        if (observers != null && !observers.isEmpty()) {
            for (BusinessObserver businessObserver : observers) {
                if (isAssignableFrom(businessObserver)) {
                    try {
                        currentTimeMillis = System.currentTimeMillis();
                    } catch (Exception e16) {
                        e = e16;
                    }
                    try {
                        businessObserver.onUpdate(i3, z16, obj);
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 100 && QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "defaultObserver onUpdate cost:" + currentTimeMillis2, new Exception("run too long!"));
                        }
                    } catch (Exception e17) {
                        e = e17;
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "onUpdate fail", e);
                        }
                    }
                }
            }
        }
        List<BusinessObserver> observers2 = getObservers(1);
        if (observers2 != null && observers2.size() > 0) {
            for (BusinessObserver businessObserver2 : observers2) {
                if (isAssignableFrom(businessObserver2)) {
                    dispatchMessage(i3, z16, obj, z17, businessObserver2, uiHandler);
                }
            }
        }
        List<BusinessObserver> observers3 = getObservers(2);
        if (observers3 == null || observers3.size() <= 0) {
            return;
        }
        for (BusinessObserver businessObserver3 : observers3) {
            if (isAssignableFrom(businessObserver3)) {
                dispatchMessage(i3, z16, obj, z17, businessObserver3, bgHandler);
            }
        }
    }
}
