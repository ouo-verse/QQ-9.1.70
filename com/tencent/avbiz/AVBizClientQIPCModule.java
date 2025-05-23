package com.tencent.avbiz;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.avbiz.Constants;
import com.tencent.avbiz.IModule;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.HashSet;
import mqq.util.WeakReference;

/* loaded from: classes3.dex */
class AVBizClientQIPCModule extends QIPCModule implements IModule, IModule.FocusChangeListener {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private WeakReference<IModule.FocusChangeListener> mListenerWeakRef;
    private final String mProcessName;
    private Handler mWorkThreadHandler;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36318);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            TAG = AVBizClientQIPCModule.class.getSimpleName();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AVBizClientQIPCModule(String str, String str2) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        } else {
            this.mListenerWeakRef = new WeakReference<>(null);
            this.mProcessName = str2;
        }
    }

    private Handler getWorkThreadHandler() {
        if (this.mWorkThreadHandler == null) {
            this.mWorkThreadHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        }
        return this.mWorkThreadHandler;
    }

    @Override // com.tencent.avbiz.IModule
    public void abandonAVFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "module abandonAVFocus, name[" + this.name + "]");
        }
        Bundle bundle = new Bundle();
        bundle.putString("module_name", this.name);
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), AVBizServerQIPCModule.NAME, Constants.Action.ABANDON_AV_FOCUS, bundle);
    }

    @Override // com.tencent.avbiz.IModule
    public void asyncAbandonAVFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "module asyncAbandonAVFocus, name[" + this.name + "]");
        }
        getWorkThreadHandler().post(new Runnable() { // from class: com.tencent.avbiz.AVBizClientQIPCModule.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AVBizClientQIPCModule.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    AVBizClientQIPCModule.this.abandonAVFocus();
                }
            }
        });
    }

    @Override // com.tencent.avbiz.IModule
    public void asyncCheckAVFocus(IModule.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "module asyncCheckAVFocus, name[" + this.name + "]");
        }
        getWorkThreadHandler().post(new Runnable(new WeakReference(aVar)) { // from class: com.tencent.avbiz.AVBizClientQIPCModule.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ WeakReference f77361d;

            {
                this.f77361d = r5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AVBizClientQIPCModule.this, (Object) r5);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                String checkAVFocus = AVBizClientQIPCModule.this.checkAVFocus();
                IModule.a aVar2 = (IModule.a) this.f77361d.get();
                if (aVar2 != null) {
                    aVar2.onResponse(checkAVFocus);
                }
            }
        });
    }

    @Override // com.tencent.avbiz.IModule
    public void asyncRequestAVFocus(IModule.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "module asyncRequestAVFocus, name[" + this.name + "], mProcessName[" + this.mProcessName + "]");
        }
        getWorkThreadHandler().post(new Runnable(new WeakReference(aVar)) { // from class: com.tencent.avbiz.AVBizClientQIPCModule.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ WeakReference f77360d;

            {
                this.f77360d = r5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AVBizClientQIPCModule.this, (Object) r5);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                String requestAVFocus = AVBizClientQIPCModule.this.requestAVFocus();
                IModule.a aVar2 = (IModule.a) this.f77360d.get();
                if (aVar2 != null) {
                    aVar2.onResponse(requestAVFocus);
                }
            }
        });
    }

    @Override // com.tencent.avbiz.IModule
    public String checkAVFocus() {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "module checkAVFocus, name[" + this.name + "]");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("module_name", this.name);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), AVBizServerQIPCModule.NAME, Constants.Action.CHECK_AV_FOCUS, bundle2);
        if (callServer != null && (bundle = callServer.data) != null) {
            return bundle.getString(Constants.Key.CHECK_FOCUS_RESULT);
        }
        return Constants.Result.EMPTY_BUNDLE;
    }

    @Override // com.tencent.avbiz.IModule
    public HashMap<Long, String> getFocusBusiness() {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashMap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "module getFocusBusiness, name[" + this.name + "]");
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), AVBizServerQIPCModule.NAME, Constants.Action.GET_FOCUS_BUSINESS, new Bundle());
        if (callServer != null && (bundle = callServer.data) != null) {
            return (HashMap) bundle.getSerializable(Constants.Key.GET_FOCUS_BIZ_RESULT);
        }
        return null;
    }

    @Override // com.tencent.avbiz.IModule
    public HashSet<String> getInQueueBusiness() {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (HashSet) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "module getInQueueBusiness, name[" + this.name + "]");
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), AVBizServerQIPCModule.NAME, Constants.Action.GET_IN_QUEUE_BUSINESS, new Bundle());
        if (callServer != null && (bundle = callServer.data) != null) {
            return (HashSet) bundle.getSerializable(Constants.Key.GET_IN_QUEUE_BIZ_RESULT);
        }
        return null;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 11, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "onCall, name[" + this.name + "], action[" + str + "]");
        }
        if (Constants.Action.NOTIFY_FOCUS_LOSS.equals(str)) {
            onFocusLoss();
            return null;
        }
        if (Constants.Action.NOTIFY_FOCUS_GAIN.equals(str)) {
            onFocusGain();
            return null;
        }
        return null;
    }

    @Override // com.tencent.avbiz.IModule.FocusChangeListener
    public void onFocusGain() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        IModule.FocusChangeListener focusChangeListener = this.mListenerWeakRef.get();
        if (focusChangeListener != null) {
            focusChangeListener.onFocusGain();
        }
    }

    @Override // com.tencent.avbiz.IModule.FocusChangeListener
    public void onFocusLoss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        IModule.FocusChangeListener focusChangeListener = this.mListenerWeakRef.get();
        if (focusChangeListener != null) {
            focusChangeListener.onFocusLoss();
        }
    }

    @Override // com.tencent.avbiz.IModule
    public String requestAVFocus() {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "module requestAVFocus, name[" + this.name + "], mProcessName[" + this.mProcessName + "]");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("module_name", this.name);
        bundle2.putString("process_name", this.mProcessName);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), AVBizServerQIPCModule.NAME, Constants.Action.REQUEST_AV_FOCUS, bundle2);
        if (callServer != null && (bundle = callServer.data) != null) {
            return bundle.getString(Constants.Key.REQUEST_FOCUS_RESULT);
        }
        return Constants.Result.EMPTY_BUNDLE;
    }

    @Override // com.tencent.avbiz.IModule
    public void setListener(IModule.FocusChangeListener focusChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) focusChangeListener);
        } else {
            this.mListenerWeakRef = new WeakReference<>(focusChangeListener);
        }
    }
}
