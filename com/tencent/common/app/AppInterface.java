package com.tencent.common.app;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQLifecycleBusinessObserver;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.transfile.InitHwEngineValue;
import com.tencent.mobileqq.transfile.InjectHelper;
import com.tencent.mobileqq.vas.theme.SimpleTintManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.inject.MqqInjectorManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class AppInterface extends AppRuntime {
    static IPatchRedirector $redirector_;
    private final ConcurrentHashMap<String, BusinessHandler> allHandler;
    protected MobileQQ app;
    private final List<BusinessObserver> bgObservers;
    private MqqHandler defaultHandler;
    private final List<BusinessObserver> defaultObservers;
    protected final ConcurrentHashMap<Class, MqqHandler> handlerMap;
    protected HwEngine mHwEngine;
    protected String processName;
    private final List<BusinessObserver> uiObservers;

    public AppInterface(MobileQQ mobileQQ, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) mobileQQ, (Object) str);
            return;
        }
        this.uiObservers = new CopyOnWriteArrayList();
        this.bgObservers = new CopyOnWriteArrayList();
        this.defaultObservers = new CopyOnWriteArrayList();
        this.allHandler = new ConcurrentHashMap<>();
        this.processName = "";
        this.handlerMap = new ConcurrentHashMap<>();
        this.defaultHandler = new MqqHandler(Looper.getMainLooper());
        this.app = mobileQQ;
        this.processName = str;
    }

    private void destroyBusinessObserverList() {
        if (QLog.isDevelopLevel()) {
            QLog.d("mqq", 4, "onDestroy, uiObservers size:", Integer.valueOf(this.uiObservers.size()), ", bgObservers size:", Integer.valueOf(this.uiObservers.size()), ", defaultObservers size:", Integer.valueOf(this.defaultObservers.size()));
        }
        synchronized (this.uiObservers) {
            this.uiObservers.clear();
        }
        synchronized (this.bgObservers) {
            this.bgObservers.clear();
        }
        synchronized (this.defaultObservers) {
            this.defaultObservers.clear();
        }
        synchronized (this.allHandler) {
            Iterator<Map.Entry<String, BusinessHandler>> it = this.allHandler.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    BusinessHandler value = it.next().getValue();
                    if (value != null) {
                        value.onDestroy();
                    }
                } catch (Exception e16) {
                    QLog.d("mqq", 1, "handler destroy fail", e16);
                }
            }
        }
    }

    private void invokeSkin() throws Exception {
        SimpleTintManager.class.getMethod("checkSkinEngineInit", new Class[0]).invoke(SimpleTintManager.class.getMethod(WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, new Class[0]).invoke(SimpleTintManager.class, new Object[0]), new Object[0]);
    }

    private void removeOriginObserver(List<BusinessObserver> list, QQLifecycleBusinessObserver qQLifecycleBusinessObserver) {
        synchronized (list) {
            int indexOf = list.indexOf(qQLifecycleBusinessObserver);
            if (indexOf >= 0) {
                BusinessObserver remove = list.remove(indexOf);
                if (remove instanceof QQLifecycleBusinessObserver) {
                    ((QQLifecycleBusinessObserver) remove).markObserverRemove();
                }
            }
        }
    }

    public void addDefaultObservers(@NotNull BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) businessObserver);
            return;
        }
        synchronized (this.defaultObservers) {
            QQLifecycleBusinessObserver qQLifecycleBusinessObserver = new QQLifecycleBusinessObserver(businessObserver);
            if (!this.defaultObservers.contains(qQLifecycleBusinessObserver)) {
                this.defaultObservers.add(qQLifecycleBusinessObserver);
            }
        }
    }

    public void addObserver(BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            addObserver(businessObserver, false);
        } else {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) businessObserver);
        }
    }

    public boolean containObserver(BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, this, businessObserver, Boolean.valueOf(z16))).booleanValue();
        }
        QQLifecycleBusinessObserver qQLifecycleBusinessObserver = new QQLifecycleBusinessObserver(businessObserver);
        if (z16) {
            return this.bgObservers.contains(qQLifecycleBusinessObserver);
        }
        return this.uiObservers.contains(qQLifecycleBusinessObserver);
    }

    protected BusinessHandler createHandler(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (BusinessHandler) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        }
        BusinessHandler businessHandler = null;
        try {
            for (Constructor<?> constructor : Class.forName(str).getDeclaredConstructors()) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if (parameterTypes.length == 1 && AppInterface.class.isAssignableFrom(parameterTypes[0])) {
                    constructor.setAccessible(true);
                    BusinessHandler businessHandler2 = (BusinessHandler) constructor.newInstance(this);
                    try {
                        com.tencent.mobileqq.service.a.d(str, businessHandler2.getCommandList());
                        businessHandler = businessHandler2;
                    } catch (Exception e16) {
                        e = e16;
                        businessHandler = businessHandler2;
                        QLog.e("mqq", 1, e, new Object[0]);
                        if (MqqInjectorManager.instance().isPublicVersion()) {
                            if (e instanceof InvocationTargetException) {
                                QLog.e("mqq", 1, ((InvocationTargetException) e).getTargetException(), new Object[0]);
                            }
                        } else if (MqqInjectorManager.instance().isDebugVersion()) {
                            throw new IllegalStateException("BusinessHandler: Use Wrong Constructor", e);
                        }
                        return businessHandler;
                    }
                }
            }
        } catch (Exception e17) {
            e = e17;
        }
        return businessHandler;
    }

    @Override // mqq.app.AppRuntime
    public abstract BaseApplication getApp();

    public abstract int getAppid();

    public BusinessHandler getBusinessHandler(String str) {
        BusinessHandler businessHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (BusinessHandler) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        }
        BusinessHandler businessHandler2 = this.allHandler.get(str);
        if (businessHandler2 != null) {
            return businessHandler2;
        }
        long currentTimeMillis = System.currentTimeMillis();
        QLog.dAsync("BusinessHandler", 1, "getBusinessHandler " + str + " start " + currentTimeMillis);
        synchronized (this.allHandler) {
            businessHandler = this.allHandler.get(str);
            if (businessHandler == null && (businessHandler = createHandler(str)) != null) {
                this.allHandler.put(str, businessHandler);
            }
        }
        QLog.dAsync("BusinessHandler", 1, "getBusinessHandler " + str + " end " + (System.currentTimeMillis() - currentTimeMillis));
        return businessHandler;
    }

    public List<BusinessObserver> getBusinessObserver(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        if (i3 == 1) {
            return this.uiObservers;
        }
        if (i3 == 2) {
            return this.bgObservers;
        }
        return this.defaultObservers;
    }

    @Override // mqq.app.AppRuntime
    public abstract String getCurrentAccountUin();

    public String getCurrentNickname() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "";
    }

    public MqqHandler getHandler(Class cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MqqHandler) iPatchRedirector.redirect((short) 6, (Object) this, (Object) cls);
        }
        if (this.handlerMap.get(cls) != null) {
            return this.handlerMap.get(cls);
        }
        return this.defaultHandler;
    }

    public MqqHandler getHandlerWithoutDefault(Class cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MqqHandler) iPatchRedirector.redirect((short) 7, (Object) this, (Object) cls);
        }
        return this.handlerMap.get(cls);
    }

    public HwEngine getHwEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HwEngine) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (this.mHwEngine == null) {
            InitHwEngineValue initHwEngineValue = new InitHwEngineValue();
            this.mHwEngine = new HwEngine(getApplication(), getCurrentAccountUin(), getAppid(), new InjectHelper(), initHwEngineValue.localId, initHwEngineValue.switchIpv6);
        }
        return this.mHwEngine;
    }

    public MobileQQServiceBase getMobileQQService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (MobileQQServiceBase) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        if (MobileQQ.sProcessId != 1) {
            try {
                invokeSkin();
            } catch (Exception e16) {
                QLog.d("mqq", 1, "appinterface on create error : ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        this.handlerMap.clear();
        this.defaultHandler.removeCallbacksAndMessages(null);
        destroyBusinessObserverList();
    }

    public void receiveToService(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        MobileQQServiceBase mobileQQService = getMobileQQService();
        if (mobileQQService != null) {
            mobileQQService.handleResponse(fromServiceMsg.isSuccess(), toServiceMsg, fromServiceMsg, null);
        }
    }

    public void removeHandler(Class cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) cls);
        } else {
            this.handlerMap.remove(cls);
        }
    }

    public void removeObserver(BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) businessObserver);
        } else {
            if (businessObserver == null) {
                return;
            }
            QQLifecycleBusinessObserver qQLifecycleBusinessObserver = new QQLifecycleBusinessObserver(businessObserver);
            removeOriginObserver(this.uiObservers, qQLifecycleBusinessObserver);
            removeOriginObserver(this.bgObservers, qQLifecycleBusinessObserver);
            removeOriginObserver(this.defaultObservers, qQLifecycleBusinessObserver);
        }
    }

    public void sendToService(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) toServiceMsg);
            return;
        }
        MobileQQServiceBase mobileQQService = getMobileQQService();
        if (mobileQQService != null) {
            mobileQQService.handleRequest(toServiceMsg);
        }
    }

    public void setHandler(Class cls, MqqHandler mqqHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cls, (Object) mqqHandler);
        } else if (mqqHandler == null) {
            this.handlerMap.remove(cls);
        } else {
            this.handlerMap.put(cls, mqqHandler);
        }
    }

    public void addObserver(BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, businessObserver, Boolean.valueOf(z16));
            return;
        }
        if (businessObserver == null) {
            if (MqqInjectorManager.instance().isDebugVersion()) {
                throw new RuntimeException("addObserver NPE");
            }
            return;
        }
        QQLifecycleBusinessObserver qQLifecycleBusinessObserver = new QQLifecycleBusinessObserver(businessObserver);
        if (z16) {
            synchronized (this.bgObservers) {
                if (!this.bgObservers.contains(qQLifecycleBusinessObserver)) {
                    this.bgObservers.add(qQLifecycleBusinessObserver);
                }
            }
            return;
        }
        synchronized (this.uiObservers) {
            if (!this.uiObservers.contains(qQLifecycleBusinessObserver)) {
                this.uiObservers.add(qQLifecycleBusinessObserver);
            }
        }
    }
}
