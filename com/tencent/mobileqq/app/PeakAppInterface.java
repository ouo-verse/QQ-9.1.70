package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.api.IAEEditorProcess;
import com.tencent.aelight.camera.api.IPeakJceService;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.qqstory.api.IAsyncControl;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.TransitionHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.faultreport.FaultTracker;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.profilecard.bussiness.photowall.constant.PhotoWallConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.server.PeakAudioTransHandler;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import com.tencent.mobileqq.wink.api.IWinkMultiExportAPI;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.utils.FdSanUtil;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.IToolProcEventListener;
import mqq.manager.Manager;

/* loaded from: classes11.dex */
public class PeakAppInterface extends BaseToolAppInterface implements IToolProcEventListener {
    static IPatchRedirector $redirector_;
    public static final String G;
    public static final String H;
    public static final String I;
    public static final String J;
    public static final String K;
    public static final String L;
    private boolean C;
    private ConcurrentHashMap<Integer, Manager> D;
    private com.tencent.mobileqq.persistence.g E;
    private BroadcastReceiver F;

    /* renamed from: d, reason: collision with root package name */
    private EntityManagerFactory f194890d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f194891e;

    /* renamed from: f, reason: collision with root package name */
    private String f194892f;

    /* renamed from: h, reason: collision with root package name */
    private QQStoryContext f194893h;

    /* renamed from: i, reason: collision with root package name */
    private rm2.b f194894i;

    /* renamed from: m, reason: collision with root package name */
    private IPeakJceService f194895m;

    /* loaded from: classes11.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PeakAppInterface.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent != null && "tencent.peak.q2v.AudioTransPush".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("rsptype", 0);
                byte[] byteArrayExtra = intent.getByteArrayExtra("rspbody");
                QLog.d("PeakAppInterface", 2, "ACTION_AUDIO_TRANS_PUSH rsptype=" + intExtra + "|" + byteArrayExtra.length);
                ((PeakAudioTransHandler) PeakAppInterface.this.getBusinessHandler(PeakAppInterface.G)).I2(intExtra, byteArrayExtra);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69861);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
            return;
        }
        G = PeakAudioTransHandler.class.getName();
        H = TransitionHandler.class.getName();
        I = ((IAEClassManager) QRoute.api(IAEClassManager.class)).getCameraPeakServiceHandlerClass().getName();
        J = ((IAEClassManager) QRoute.api(IAEClassManager.class)).getCameraPeakPBServiceHandlerClass().getName();
        K = ((IAEClassManager) QRoute.api(IAEClassManager.class)).getAEEditorDataServiceHandlerClass().getName();
        L = ((IAEClassManager) QRoute.api(IAEClassManager.class)).getWinkPhotoWallHandlerCLass().getName();
    }

    public PeakAppInterface(BaseApplicationImpl baseApplicationImpl, String str) {
        super(baseApplicationImpl, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseApplicationImpl, (Object) str);
            return;
        }
        this.f194891e = false;
        this.f194892f = "";
        this.C = false;
        this.D = new ConcurrentHashMap<>(5);
        this.F = new a();
    }

    private boolean f(BaseApplication baseApplication, Intent intent) {
        ms.a.c("PeakAppInterface", "exitPeakRunTime");
        String action = intent.getAction();
        if (action == null || !action.equals("com.tencent.process.exit")) {
            return false;
        }
        boolean hasRunningTask = ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).hasRunningTask();
        ms.a.c("PeakAppInterface", "isGenerateWorking" + hasRunningTask);
        return hasRunningTask;
    }

    private boolean j() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("tencent.peak.q2v.AudioTransPush");
        this.app.registerReceiver(this.F, intentFilter);
        if (this.app.registerReceiver(this.F, intentFilter) != null) {
            return true;
        }
        return false;
    }

    private static boolean l() {
        QLog.i("PeakAppInterface", 2, "[shouldSetFdSanErrorLevel] is false");
        return false;
    }

    public com.tencent.mobileqq.persistence.g g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.persistence.g) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (this.E == null) {
            String currentAccountUin = getCurrentAccountUin();
            this.E = new com.tencent.mobileqq.persistence.g(((QQEntityManagerFactory) getEntityManagerFactory(currentAccountUin)).build(currentAccountUin), currentAccountUin);
        }
        return this.E;
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BaseApplication) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return AppSetting.f();
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return getAccount();
    }

    @Override // com.tencent.common.app.AppInterface
    public String getCurrentNickname() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.f194892f;
    }

    @Override // mqq.app.AppRuntime
    public EntityManagerFactory getEntityManagerFactory(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (EntityManagerFactory) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        if (this.f194890d == null) {
            this.f194890d = com.tencent.mobileqq.persistence.l.d(getAccount(), super.getEntityManagerFactory());
        }
        return this.f194890d;
    }

    @Override // mqq.app.AppRuntime
    public Manager getManager(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Manager) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        Manager manager = this.D.get(Integer.valueOf(i3));
        if (manager == null) {
            if (this.D.get(Integer.valueOf(i3)) != null) {
                manager = this.D.get(Integer.valueOf(i3));
            } else if (manager != null) {
                this.D.put(Integer.valueOf(i3), manager);
            }
        }
        if (manager == null) {
            return super.getManager(i3);
        }
        return manager;
    }

    @Override // mqq.app.AppRuntime
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "peak";
    }

    @Override // mqq.app.AppRuntime
    public SQLiteDatabase getReadableDatabase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        String currentAccountUin = getCurrentAccountUin();
        SQLiteOpenHelper build = ((QQEntityManagerFactory) getEntityManagerFactory(currentAccountUin)).build(currentAccountUin);
        if (build != null) {
            return build.getReadableDatabase();
        }
        return null;
    }

    public QQStoryContext h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (QQStoryContext) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f194893h;
    }

    @Override // mqq.app.AppRuntime
    public boolean highPriorityWhenBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        boolean hasRunningTask = ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).hasRunningTask();
        QLog.e("PeakAppInterface", 1, "highPriorityWhenBackground:" + hasRunningTask);
        return hasRunningTask;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QQStoryContext qQStoryContext = new QQStoryContext();
        this.f194893h = qQStoryContext;
        qQStoryContext.j();
    }

    public void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else {
            this.f194892f = str;
        }
    }

    @Override // mqq.app.IToolProcEventListener
    public void onBeforeExitProc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        ms.a.c("PeakAppInterface", "onBeforeExitProc");
        FaultTracker.n().t();
        ((IAEEditorProcess) QRoute.api(IAEEditorProcess.class)).clean();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        QLog.i("PeakAppInterface", 1, "onCreate");
        if (l()) {
            try {
                FdSanUtil.b(3);
            } catch (Throwable th5) {
                QLog.w("PeakAppInterface", 1, "[onCreate] setFdSanErrorLevel fail, err=" + th5);
            }
        }
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).initialize();
        ((IWinkAPI) QRoute.api(IWinkAPI.class)).initWinkLruCache();
        i();
        this.C = j();
        this.f194894i = new rm2.b(this);
        this.f194895m = (IPeakJceService) getRuntimeService(IPeakJceService.class, "all");
        ((IAsyncControl) QRoute.api(IAsyncControl.class)).startPeakPreLoadAsyncStep();
        DtSdkInitStep.initDTSDK(0);
        FaultTracker.n().u(new com.tencent.mobileqq.faultreport.TrackerFilter.e());
        QQSysFaceUtil.checkInitQQSysAndEmojiResMgr();
        QLog.i("[Performance2]PeakAppInterface", 1, "[onCreate...] + END, time cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        com.tencent.mobileqq.richmedia.g.b().e(BaseApplicationImpl.sApplication);
        PresendPicMgr g16 = PresendPicMgr.g(null);
        if (g16 != null) {
            g16.l();
        }
        WinkPublishHelper2.INSTANCE.unBindService();
        if (this.C) {
            this.app.unregisterReceiver(this.F);
            this.C = false;
        }
        ((IAsyncControl) QRoute.api(IAsyncControl.class)).destory();
        FaultTracker.n().x();
        if (QLog.isColorLevel()) {
            QLog.d("PeakAppInterface", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveAccountAction(String str, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) intent)).booleanValue();
        }
        ms.a.f("PeakAppInterface", "onReceiveAccountAction");
        return false;
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveLegalExitProcAction(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) intent)).booleanValue();
        }
        ms.a.c("PeakAppInterface", "onReceiveAccountAction");
        return f(BaseApplication.getContext(), intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onRunningBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        QLog.i("PeakAppInterface", 1, "onRunningBackground");
        super.onRunningBackground();
        FaultTracker.n().r();
        LpReportManager.getInstance().startReportImediately(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onRunningForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        super.onRunningForeground();
        FaultTracker.n().s();
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.app.PeakAppInterface.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PeakAppInterface.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    PeakAppInterface.this.setTalkbackSwitch();
                }
            }
        });
    }

    @Override // com.tencent.common.app.AppInterface
    public void receiveToService(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (!toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_EMOTION) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_TEXT_VALID) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_CAMERA_CONFIG) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_MATERIAL_RACE) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_COMPRESSED_MATERIAL_CATEGORY) && !toServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetPlayShowCatMatTree") && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_QQ_ONLINE_NUMBER) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_GET_FONT_DATA) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_FACE_DETECT) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_SMART_FILTER) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_TAB_AB_TEST) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AEEditorConstants.CMD_AUTO_TEMPLATE_RECOMMEND) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AEEditorConstants.CMD_EDITOR_MATERIAL_CATEGORY) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AEEditorConstants.CMD_SUBTITLE_SUBMIT) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AEEditorConstants.CMD_SUBTITLE_QUERY) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_WATERMARK_LOCATION) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_CAMERA_PROPERTY_AI) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(PhotoWallConstant.CMD_GET_PHOTO_WALL)) {
            this.f194894i.d(fromServiceMsg.isSuccess(), toServiceMsg, fromServiceMsg, null);
            return;
        }
        IPeakJceService iPeakJceService = this.f194895m;
        if (iPeakJceService != null) {
            iPeakJceService.handleResponse(fromServiceMsg.isSuccess(), toServiceMsg, fromServiceMsg);
        }
    }

    @Override // com.tencent.common.app.AppInterface
    public void sendToService(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (!toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_EMOTION) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_TEXT_VALID) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_CAMERA_CONFIG) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_MATERIAL_RACE) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_COMPRESSED_MATERIAL_CATEGORY) && !toServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetPlayShowCatMatTree") && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_QQ_ONLINE_NUMBER) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_GET_FONT_DATA) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_FACE_DETECT) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_SMART_FILTER) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_TAB_AB_TEST) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AEEditorConstants.CMD_AUTO_TEMPLATE_RECOMMEND) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AEEditorConstants.CMD_EDITOR_MATERIAL_CATEGORY) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AEEditorConstants.CMD_SUBTITLE_SUBMIT) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AEEditorConstants.CMD_SUBTITLE_QUERY) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_WATERMARK_LOCATION) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_CAMERA_PROPERTY_AI) && !toServiceMsg.getServiceCmd().equalsIgnoreCase(PhotoWallConstant.CMD_GET_PHOTO_WALL)) {
            this.f194894i.c(toServiceMsg, com.tencent.mobileqq.servlet.b.class);
        } else {
            this.f194895m.handleRequest(toServiceMsg);
        }
    }

    public void setTalkbackSwitch() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.app.getSystemService("accessibility");
            boolean isEnabled = accessibilityManager.isEnabled();
            boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
            if (isEnabled && isTouchExplorationEnabled) {
                z16 = true;
            } else {
                z16 = false;
            }
            AppSetting.f99565y = z16;
        } catch (Throwable unused) {
        }
    }
}
