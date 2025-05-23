package com.tencent.mobileqq.emoticonview.ipc;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IPopupEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.AbsEmoRuntimeServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.AbsHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.AbsManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmotionRoamingDBManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommercialDrainageManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmotionSearchManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavEmoRoamingHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingDBManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FontManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.GameCenterManagerImpProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.MqqHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.PopupEmotionSearchManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.QQMessageFacadeProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.RedTouchManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.SVIPHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VasQuickUpdateManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqManagerServiceProxy;
import com.tencent.mobileqq.model.api.ICommercialDrainageManagerService;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;

/* loaded from: classes12.dex */
public class QQEmoticonMainPanelApp implements IEmoticonMainPanelApp {
    static IPatchRedirector $redirector_ = null;
    private static final int GAMECENTER_MANAGER;
    private static final String TAG = "QQEmoticonMainPanelApp";
    private static boolean sInit;
    private BaseQQAppInterface mApp;
    protected EntityManager mEntityManager;
    protected EntityManagerFactory mEntityManagerFactory;
    protected int mExternalPanelheight;
    private QQMessageFacadeProxy mMessageFacadeProxy;
    private final ConcurrentHashMap<String, AbsHandlerProxy<? extends BusinessHandler>> mProxyHandlerMap;
    private final ConcurrentHashMap<Integer, AbsManagerProxy<? extends Manager>> mProxyManagerMap;
    private final ConcurrentHashMap<Class, AbsEmoRuntimeServiceProxy<? extends IRuntimeService>> mProxyRuntimeMap;
    private final AppRuntime mRuntime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51184);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            sInit = false;
            GAMECENTER_MANAGER = ((IEmosmService) QRoute.api(IEmosmService.class)).getManagerID(IEmosmService.GAMECENTER_MANAGER);
        }
    }

    public QQEmoticonMainPanelApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mProxyHandlerMap = new ConcurrentHashMap<>();
        this.mProxyManagerMap = new ConcurrentHashMap<>();
        this.mProxyRuntimeMap = new ConcurrentHashMap<>();
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.mRuntime = waitAppRuntime;
        if (waitAppRuntime instanceof BaseQQAppInterface) {
            this.mApp = (BaseQQAppInterface) waitAppRuntime;
        }
        init();
    }

    private AbsHandlerProxy createHandlerProxy(String str) {
        if (CameraEmoRoamingHandler.f194459e.equals(str)) {
            return new CameraEmoRoamingHandlerProxy(this.mApp);
        }
        if (EmoticonHandler.F.equals(str)) {
            return new EmoticonHandlerProxy(this.mApp);
        }
        if (VipComicMqqHandler.f204459e.equals(str)) {
            return new VipComicMqqHandlerProxy(this.mApp);
        }
        if (str != null && str.equals(((ISVIPHandlerProxy) QRoute.api(ISVIPHandlerProxy.class)).getImplClassName())) {
            return new SVIPHandlerProxy(this.mApp);
        }
        if (FavEmoRoamingHandler.f194632e.equals(str)) {
            return new FavEmoRoamingHandlerProxy(this.mApp);
        }
        return null;
    }

    private AbsManagerProxy createMangerProxy(int i3) {
        if (GAMECENTER_MANAGER == i3) {
            return new GameCenterManagerImpProxy(this.mApp);
        }
        return null;
    }

    private AbsEmoRuntimeServiceProxy<? extends IRuntimeService> createRuntimeServiceProxy(Class cls) {
        if (cls == IEmotionSearchManagerService.class) {
            return new EmotionSearchManagerServiceProxy(this.mApp);
        }
        if (cls == IFavroamingManagerService.class) {
            return new FavroamingManagerServiceProxy(this.mApp);
        }
        if (cls == ICommercialDrainageManagerService.class) {
            return new CommercialDrainageManagerServiceProxy(this.mApp);
        }
        if (cls == IEmoticonManagerService.class) {
            return new EmoticonManagerServiceProxy(this.mApp, this.mEntityManager);
        }
        if (cls == ICameraEmotionRoamingDBManagerService.class) {
            return new CameraEmotionRoamingDBManagerServiceProxy(this.mApp);
        }
        if (cls == ICameraEmoRoamingManagerService.class) {
            return new CameraEmoRoamingManagerServiceProxy(this.mApp);
        }
        if (cls == IEmojiManagerService.class) {
            return new EmojiManagerServiceProxy(this.mApp);
        }
        if (cls == IFavroamingDBManagerService.class) {
            return new FavroamingDBManagerServiceProxy(this.mApp);
        }
        if (cls == IVipComicMqqManagerService.class) {
            return new VipComicMqqManagerServiceProxy(this.mApp);
        }
        if (cls == ICommonUsedSystemEmojiManagerService.class) {
            return new CommonUsedSystemEmojiManagerServiceProxy(this.mApp);
        }
        if (cls == IRedTouchManager.class) {
            return new RedTouchManagerProxy(this.mApp);
        }
        if (cls == IFontManagerService.class) {
            return new FontManagerProxy(this.mApp);
        }
        if (cls == IVasQuickUpdateService.class) {
            return new VasQuickUpdateManagerProxy(this.mApp);
        }
        if (cls == IPopupEmotionSearchManagerService.class) {
            return new PopupEmotionSearchManagerServiceProxy(this.mApp);
        }
        return null;
    }

    private void init() {
        if (this.mApp == null) {
            EntityManagerFactory entityManagerFactory = this.mRuntime.getEntityManagerFactory(getAccount());
            this.mEntityManagerFactory = entityManagerFactory;
            this.mEntityManager = entityManagerFactory.createEntityManager();
        }
    }

    public static boolean isMainProcess() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    public void addObserver(BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) businessObserver);
            return;
        }
        BaseQQAppInterface baseQQAppInterface = this.mApp;
        if (baseQQAppInterface != null) {
            baseQQAppInterface.addObserver(businessObserver);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp
    public String getAccount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mRuntime.getAccount();
    }

    public Context getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Context) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mRuntime.getApplication();
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp
    public AppRuntime getAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        BaseQQAppInterface baseQQAppInterface = this.mApp;
        if (baseQQAppInterface != null) {
            return baseQQAppInterface;
        }
        return this.mRuntime;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp
    public Context getApplication() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Context) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mRuntime.getApplication();
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp
    public String getCurrentAccountUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        BaseQQAppInterface baseQQAppInterface = this.mApp;
        if (baseQQAppInterface != null) {
            return baseQQAppInterface.getCurrentAccountUin();
        }
        return this.mRuntime.getAccount();
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp
    public String getCurrentUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        BaseQQAppInterface baseQQAppInterface = this.mApp;
        if (baseQQAppInterface != null) {
            return baseQQAppInterface.getCurrentUin();
        }
        return getQQCurrentUin();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (EntityManagerFactory) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        BaseQQAppInterface baseQQAppInterface = this.mApp;
        if (baseQQAppInterface != null) {
            return baseQQAppInterface.getEntityManagerFactory();
        }
        return this.mEntityManagerFactory;
    }

    public int getExternalPanelheight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        if (this.mApp != null) {
            return ((IEmosmService) QRoute.api(IEmosmService.class)).getExternalPanelheight();
        }
        int i3 = this.mExternalPanelheight;
        if (i3 != 0) {
            return i3;
        }
        int i16 = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", EmoticonMainPanelIpcModule.ACTION_EXTERNALPANEL_HEIGHT, null).data.getInt("height");
        this.mExternalPanelheight = i16;
        return i16;
    }

    public String getQQCurrentUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        if (!"0".equals(getCurrentAccountUin())) {
            return getCurrentAccountUin();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp
    public AbsEmoRuntimeServiceProxy<? extends IRuntimeService> getRuntimeService(Class cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AbsEmoRuntimeServiceProxy) iPatchRedirector.redirect((short) 9, (Object) this, (Object) cls);
        }
        AbsEmoRuntimeServiceProxy<? extends IRuntimeService> absEmoRuntimeServiceProxy = this.mProxyRuntimeMap.get(cls);
        if (absEmoRuntimeServiceProxy == null) {
            synchronized (AbsManagerProxy.class) {
                AbsEmoRuntimeServiceProxy<? extends IRuntimeService> absEmoRuntimeServiceProxy2 = this.mProxyRuntimeMap.get(cls);
                if (absEmoRuntimeServiceProxy2 != null) {
                    return absEmoRuntimeServiceProxy2;
                }
                absEmoRuntimeServiceProxy = createRuntimeServiceProxy(cls);
                if (absEmoRuntimeServiceProxy != null) {
                    this.mProxyRuntimeMap.put(cls, absEmoRuntimeServiceProxy);
                }
            }
        }
        return absEmoRuntimeServiceProxy;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp
    public <T extends IRuntimeService> T getService(Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (T) iPatchRedirector.redirect((short) 10, (Object) this, (Object) cls);
        }
        BaseQQAppInterface baseQQAppInterface = this.mApp;
        if (baseQQAppInterface == null) {
            return null;
        }
        return (T) baseQQAppInterface.getRuntimeService(cls, "");
    }

    public void registerOtherProcessCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (isMainProcess() || sInit) {
            return;
        }
        sInit = true;
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQEmoticonMainPanelApp.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QQEmoticonMainPanelApp.this.getExternalPanelheight();
                }
            }
        });
        QIPCClientHelper.getInstance().register(EmoticonMainPanelChildIpcModule.getInstance());
        Bundle bundle = new Bundle();
        bundle.putString("process_name", MobileQQ.processName);
        QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", EmoticonMainPanelChildIpcModule.OTHER_RIGISTER_CALLBACK, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQEmoticonMainPanelApp.this);
                }
            }

            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eIPCResult);
                    return;
                }
                if (eIPCResult != null && eIPCResult.isSuccess()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(QQEmoticonMainPanelApp.TAG, 4, "registerOtherProcessCallback suc.");
                        return;
                    }
                    return;
                }
                QLog.e(QQEmoticonMainPanelApp.TAG, 4, "registerOtherProcessCallback fail.");
            }
        });
    }

    public void removeObserver(BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) businessObserver);
            return;
        }
        BaseQQAppInterface baseQQAppInterface = this.mApp;
        if (baseQQAppInterface != null) {
            baseQQAppInterface.removeObserver(businessObserver);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp
    public AbsHandlerProxy<? extends BusinessHandler> getBusinessHandler(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AbsHandlerProxy) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        AbsHandlerProxy<? extends BusinessHandler> absHandlerProxy = this.mProxyHandlerMap.get(str);
        if (absHandlerProxy == null) {
            synchronized (AbsHandlerProxy.class) {
                AbsHandlerProxy<? extends BusinessHandler> absHandlerProxy2 = this.mProxyHandlerMap.get(str);
                if (absHandlerProxy2 != null) {
                    return absHandlerProxy2;
                }
                absHandlerProxy = createHandlerProxy(str);
                if (absHandlerProxy != null) {
                    this.mProxyHandlerMap.put(str, absHandlerProxy);
                }
            }
        }
        return absHandlerProxy;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp
    public MqqHandlerProxy getHandler(Class cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) ? new MqqHandlerProxy(this.mApp, cls) : (MqqHandlerProxy) iPatchRedirector.redirect((short) 17, (Object) this, (Object) cls);
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp
    public AbsManagerProxy<? extends Manager> getManager(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AbsManagerProxy) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        AbsManagerProxy<? extends Manager> absManagerProxy = this.mProxyManagerMap.get(Integer.valueOf(i3));
        if (absManagerProxy == null) {
            synchronized (AbsManagerProxy.class) {
                AbsManagerProxy<? extends Manager> absManagerProxy2 = this.mProxyManagerMap.get(Integer.valueOf(i3));
                if (absManagerProxy2 != null) {
                    return absManagerProxy2;
                }
                absManagerProxy = createMangerProxy(i3);
                if (absManagerProxy != null) {
                    this.mProxyManagerMap.put(Integer.valueOf(i3), absManagerProxy);
                }
            }
        }
        return absManagerProxy;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp
    public QQMessageFacadeProxy getMessageFacade() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (QQMessageFacadeProxy) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        if (this.mMessageFacadeProxy == null) {
            this.mMessageFacadeProxy = new QQMessageFacadeProxy(this.mApp);
        }
        return this.mMessageFacadeProxy;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp
    public BaseQQAppInterface getQQAppInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.mApp : (BaseQQAppInterface) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    public QQEmoticonMainPanelApp(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.mProxyHandlerMap = new ConcurrentHashMap<>();
        this.mProxyManagerMap = new ConcurrentHashMap<>();
        this.mProxyRuntimeMap = new ConcurrentHashMap<>();
        appRuntime = appRuntime == null ? MobileQQ.sMobileQQ.waitAppRuntime(null) : appRuntime;
        this.mRuntime = appRuntime;
        if (appRuntime instanceof BaseQQAppInterface) {
            this.mApp = (BaseQQAppInterface) appRuntime;
        }
        init();
    }

    public QQEmoticonMainPanelApp(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseQQAppInterface);
            return;
        }
        this.mProxyHandlerMap = new ConcurrentHashMap<>();
        this.mProxyManagerMap = new ConcurrentHashMap<>();
        this.mProxyRuntimeMap = new ConcurrentHashMap<>();
        if (baseQQAppInterface != null) {
            this.mApp = baseQQAppInterface;
            this.mRuntime = baseQQAppInterface;
        } else {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            this.mRuntime = waitAppRuntime;
            if (waitAppRuntime instanceof BaseQQAppInterface) {
                this.mApp = (BaseQQAppInterface) waitAppRuntime;
            }
        }
        init();
    }
}
