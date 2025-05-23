package com.tencent.aelight.camera.aebase;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.download.AEResManager;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView;
import com.tencent.aelight.camera.ae.flashshow.WinkHomeActivity;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.util.AECacheMonitor;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.qipc.api.IAECameraGetInfoServer;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.photo.j;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qcircle.api.IQCircleQuicReqApi;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.FolderUtils;
import com.tencent.mobileqq.wink.WinkInitManager;
import com.tencent.mobileqq.wink.api.IClipService;
import com.tencent.mobileqq.wink.api.IClipServiceFactory;
import com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.api.IWinkMultiExportAPI;
import com.tencent.mobileqq.wink.export.model.WinkExportTask;
import com.tencent.mobileqq.wink.picker.qzone.n;
import com.tencent.mobileqq.wink.publish.OneClickPublishingHelper;
import com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck;
import com.tencent.mobileqq.wink.utils.at;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.util.BinderWarpper;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

/* loaded from: classes32.dex */
public class PeakService extends Service {

    /* renamed from: d, reason: collision with root package name */
    private volatile Looper f66004d;

    /* renamed from: e, reason: collision with root package name */
    private volatile a f66005e;

    /* renamed from: f, reason: collision with root package name */
    private final IClipService.a f66006f;

    /* loaded from: classes32.dex */
    private final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            PeakService.this.g((Intent) message.obj);
        }
    }

    public PeakService() {
        ms.a.f("PeakService", "[PeakService]");
        this.f66006f = ((IClipServiceFactory) QRoute.api(IClipServiceFactory.class)).getClipService();
    }

    private void b() {
        AECacheMonitor.g().n();
    }

    private void c(CompressInfo compressInfo, com.tencent.mobileqq.activity.aio.photo.j jVar) {
        ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
        if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "CompressPic, current pid=" + Process.myPid());
        }
        if (jVar != null) {
            if (compressInfo.f258516f) {
                jVar.o1(compressInfo);
            } else {
                jVar.P4(compressInfo);
            }
            jVar.k2(compressInfo);
        }
    }

    private void d() {
        ms.a.f("PeakService", "deleteOldBundleFile");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aebase.PeakService.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileUtils.deleteFilesInDirectory(g.a.c.f65268c);
                } catch (Exception e16) {
                    QLog.e("PeakService", 1, "DeleteFilesInDirectory Error!", e16);
                }
            }
        }, 64, null, false);
    }

    public static EIPCResult e(String str) {
        VideoMaterial videoMaterial;
        List<String> C;
        ms.a.a("PeakService", "pre: loadLightSDK");
        String z16 = AEResUtil.z();
        String J = AEResUtil.J(AEResInfo.LIGHT_RES_PAG.agentType);
        String J2 = AEResUtil.J(AEResInfo.LIGHT_RES_FILAMENT.agentType);
        try {
            if (f(J + AECameraConstants.LIB_PAG)) {
                if (f(J2 + AECameraConstants.FILAMENT_NAME)) {
                    f(z16 + AECameraConstants.LIB_LIGHT);
                }
            }
            videoMaterial = VideoMaterial.loadLightAsset(str);
        } catch (Throwable th5) {
            ms.a.d("PeakService", "pre: loadLib error", th5);
            videoMaterial = null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (videoMaterial != null && (C = AEResUtil.C(videoMaterial)) != null && C.size() > 0) {
            for (String str2 : C) {
                ms.a.a("PeakService", "pre: agentType" + str2);
                if (!AEResUtil.V(str2)) {
                    arrayList.add(str2);
                    AEResUtil.h(str2);
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("types", arrayList);
        return EIPCResult.createSuccessResult(bundle);
    }

    private static boolean f(String str) {
        try {
            System.load(str);
            return true;
        } catch (Throwable th5) {
            ms.a.d("PeakService", "predownload load error", th5);
            return false;
        }
    }

    private void h() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aebase.PeakService.6
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.aelight.camera.ae.flashshow.util.f.a();
                ms.a.f("PeakService", "perLoadCameraInfo finished.");
            }
        }, 16, null, true);
    }

    private void i() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aebase.PeakService.1
            @Override // java.lang.Runnable
            public void run() {
                BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), IAECameraGetInfoServer.NAME, "ACTION_DOWNLOAD_AVCODEC", new Bundle());
            }
        }, 16, null, false);
    }

    private void j() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aebase.PeakService.5
            @Override // java.lang.Runnable
            public void run() {
                os.a aVar = os.a.f423933a;
                String d16 = aVar.d(WinkDaTongReportConstant.ElementParamKey.XSJ_SDK_MD5, "");
                String d17 = aVar.d(WinkDaTongReportConstant.ElementParamKey.XSJ_PAG_MD5, "");
                String d18 = aVar.d(WinkDaTongReportConstant.ElementParamKey.XSJ_QUERY_MD5, "");
                ms.a.c("PeakService", "sdk exits " + AEResUtil.U(AEResInfo.LIGHT_RES_BASE_PACKAGE));
                ms.a.c("PeakService", "verify sdkMD5 : " + d16 + "pagMD5:  " + d17 + "queryMD5: " + d18);
            }
        }, 64, null, true);
    }

    private void k() {
        iq.d.f408183a.e();
    }

    private void l() {
        aq.d.f26717a.e();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        ms.a.f("PeakService", "[PeakService] onBind");
        return this.f66006f;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ms.a.f("PeakService", "[PeakService] onCreate");
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("PeakService");
        baseHandlerThread.start();
        this.f66004d = baseHandlerThread.getLooper();
        this.f66005e = new a(this.f66004d);
        b();
        l();
        k();
        d();
    }

    @Override // android.app.Service
    public void onDestroy() {
        ms.a.f("PeakService", "[onDestroy]");
        this.f66004d.quit();
        AEResManager.J().G0();
        com.tencent.aelight.camera.ae.d.y();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        ms.a.f("PeakService", "[PeakService] onStartCommand" + AppSetting.f99551k);
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchAllEssentialBundles();
        ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).fetchWinkNewAlbumRes(null);
        ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).fetchWinkNewAlbumTextRes(null);
        ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).preLoadWinkInferenceRes();
        i();
        j();
        AEResManager.J().o0();
        ((IQCircleQuicReqApi) QRoute.api(IQCircleQuicReqApi.class)).retryPingRequest();
        Message obtainMessage = this.f66005e.obtainMessage();
        obtainMessage.arg1 = i16;
        obtainMessage.obj = intent;
        this.f66005e.sendMessage(obtainMessage);
        ms.a.f("PeakService", "[onStartCommand] flags=" + i3 + ",startId:" + i16);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        ms.a.f("PeakService", "[PeakService] onUnbind");
        return super.onUnbind(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Intent intent) {
        int i3;
        if (intent == null) {
            if (QLog.isColorLevel()) {
                QLog.d("PeakService", 2, "onHandleIntent: intent is null");
                return;
            }
            return;
        }
        int intExtra = intent.getIntExtra(AECameraConstants.INTENT_KEY_ACTION, -1);
        ms.a.f("PeakService", "onHandleIntent, action = " + intExtra);
        switch (intExtra) {
            case 1:
                Parcelable parcelableExtra = intent.getParcelableExtra(AECameraConstants.INTENT_KEY_COMPRESS_INFO);
                BinderWarpper binderWarpper = (BinderWarpper) intent.getParcelableExtra(AECameraConstants.INTENT_KEY_COMPRESS_CALLBACK);
                int[] intArrayExtra = intent.getIntArrayExtra(AECameraConstants.INTENT_KEY_COMPRESS_CONFIG);
                if (intArrayExtra != null && intArrayExtra.length >= 9) {
                    com.tencent.mobileqq.pic.compress.a.f258671d = intArrayExtra[0];
                    com.tencent.mobileqq.pic.compress.a.f258672e = intArrayExtra[1];
                    com.tencent.mobileqq.pic.compress.a.f258673f = intArrayExtra[2];
                    com.tencent.mobileqq.pic.compress.a.f258674g = intArrayExtra[3];
                    com.tencent.mobileqq.pic.compress.a.f258675h = intArrayExtra[4];
                    com.tencent.mobileqq.pic.compress.a.f258676i = intArrayExtra[5];
                    com.tencent.mobileqq.pic.compress.a.f258668a = intArrayExtra[6];
                    com.tencent.mobileqq.pic.compress.a.f258669b = intArrayExtra[7];
                    com.tencent.mobileqq.pic.compress.a.f258670c = intArrayExtra[8];
                    if (QLog.isColorLevel()) {
                        QLog.d("PeakService", 2, "onHandleIntent, compressConfig = " + Arrays.toString(intArrayExtra));
                    }
                }
                if ((parcelableExtra instanceof CompressInfo) && binderWarpper != null) {
                    c((CompressInfo) parcelableExtra, j.a.j(binderWarpper.binder));
                }
                CommonImgThumbHelper.initAioThumbSizeByDpc();
                return;
            case 2:
                ar.f.g().p(intent.getBooleanExtra(AECameraConstants.INTENT_KEY_ALIVE, false));
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    StatisticCollector.getInstance(this);
                    if (QLog.isColorLevel()) {
                        QLog.d("PeakService", 2, "step : init StatisticCollector use = " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (QLog.isColorLevel()) {
                        QLog.d("PeakService", 2, "step : init Activity use = " + (System.currentTimeMillis() - currentTimeMillis2));
                    }
                    n.f325197a.i();
                    long currentTimeMillis3 = System.currentTimeMillis();
                    com.tencent.mobileqq.camera.a.d();
                    if (QLog.isColorLevel()) {
                        QLog.d("PeakService", 2, "step : init CameraHolder use = " + (System.currentTimeMillis() - currentTimeMillis3));
                    }
                    long currentTimeMillis4 = System.currentTimeMillis();
                    com.tencent.mobileqq.shortvideo.util.f.m();
                    if (QLog.isColorLevel()) {
                        QLog.d("PeakService", 1, "step : init SVFilter use = " + (System.currentTimeMillis() - currentTimeMillis4));
                    }
                    try {
                        try {
                            AECameraGLSurfaceView.initSdk();
                            boolean z16 = AEResUtil.U(AEResInfo.AE_RES_BASE_PACKAGE) && AEResUtil.U(AEResInfo.LIGHT_RES_BASE_PACKAGE) && AEResUtil.U(AEResInfo.LIGHT_RES_FILAMENT) && AEResUtil.U(AEResInfo.LIGHT_RES_PAG);
                            String N = AEResUtil.N(AEResInfo.LIGHT_RES_PAG);
                            String N2 = AEResUtil.N(AEResInfo.LIGHT_RES_FILAMENT);
                            String N3 = AEResUtil.N(AEResInfo.LIGHT_RES_BASE_PACKAGE);
                            String O = AEResManager.J().O();
                            ms.a.c("PeakService", "version fix pag version " + N + " filamentVersion " + N2 + " sdkVersion" + N3 + " jarFilamentVersion 3.145.5.4474 jarPagVersion " + O);
                            if (z16 && AEResManager.J().V("3.145.5.4474", N2) && AEResManager.J().V(O, N)) {
                                ms.a.c("PeakService", "version fix [loadBasicFeaturesInLight] start");
                                ms.a.c("PeakService", "version fix [loadBasicFeaturesInLight] end result=" + com.tencent.aelight.camera.ae.d.u());
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            i3 = 1;
                            QLog.e("PeakService", i3, "", th);
                            return;
                        }
                    } catch (Throwable th6) {
                        ms.a.c("PeakService", " error message " + th6.getMessage());
                    }
                    if (Build.VERSION.SDK_INT > 23) {
                        com.tencent.aelight.camera.aebase.a.a();
                    }
                    g.a(-1000, null, null);
                    AECameraPrefsUtil.f().j("fake_key", "", 4);
                    h();
                    boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qalbum_pre_init_switch_8968", false);
                    try {
                        QLog.i("PeakService", 1, "QAlbum preInitSwitch:" + isSwitchOn);
                        if (isSwitchOn && intent.getBooleanExtra(AECameraConstants.INTENT_KEY_PRE_INIT_RES, false)) {
                            try {
                                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aebase.PeakService.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        PhotoListSceneBase.q(BaseApplication.getContext());
                                    }
                                }, 16, null, true);
                                return;
                            } catch (Throwable th7) {
                                th = th7;
                                i3 = 1;
                                QLog.e("PeakService", i3, "", th);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th8) {
                        th = th8;
                        i3 = 1;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    i3 = 1;
                }
                break;
            case 3:
                long currentTimeMillis5 = System.currentTimeMillis();
                int a16 = gm2.a.a();
                com.tencent.aelight.camera.ae.util.j.h();
                com.tencent.aelight.camera.ae.d.j();
                boolean g16 = com.tencent.aelight.camera.ae.flashshow.util.g.g();
                if (QLog.isColorLevel()) {
                    QLog.d("PeakService", 2, "cameraCreate finish, cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis5), " soloaded:", Boolean.valueOf(g16), " selectCamera:", Integer.valueOf(a16));
                    return;
                }
                return;
            case 4:
                ms.a.f("PeakService", "[ACTION_START_EDITOR_MISSON] receive");
                String stringExtra = intent.getStringExtra(AEEditorConstants.GENERATE_MISSION);
                ar.f.g().i();
                ar.f.g().l(stringExtra);
                return;
            case 5:
                ar.f.g().p(intent.getBooleanExtra(AECameraConstants.INTENT_KEY_ALIVE, false));
                return;
            case 6:
                ms.a.f("PeakService", "[ACTION_PRELOAD_WINK] start");
                ar.f.g().p(intent.getBooleanExtra(AECameraConstants.INTENT_KEY_ALIVE, false));
                try {
                    WinkPublishHelper2.INSTANCE.bindService(1, null);
                    if (Build.VERSION.SDK_INT > 23) {
                        com.tencent.aelight.camera.aebase.a.a();
                    }
                    n.f325197a.i();
                    gm2.a.a();
                    h();
                    com.tencent.aelight.camera.ae.util.j.h();
                    AECameraPrefsUtil.f().j("fake_key", "", 4);
                    com.tencent.mobileqq.shortvideo.util.f.m();
                    LSCameraGLSurfaceView.X0();
                    com.tencent.aelight.camera.ae.d.v();
                    com.tencent.aelight.camera.ae.control.a.b(4);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.aelight.camera.aebase.PeakService.3
                        @Override // java.lang.Runnable
                        public void run() {
                            new WinkHomeActivity();
                        }
                    });
                    wp.a.a().c(BaseApplication.getContext());
                    WinkInitManager.Companion companion = WinkInitManager.INSTANCE;
                    companion.a().e(null);
                    companion.a().g();
                } catch (Throwable th10) {
                    QLog.e("PeakService", 1, "[ACTION_PRELOAD_WINK] error", th10);
                }
                ms.a.f("PeakService", "[ACTION_PRELOAD_WINK] finished");
                return;
            case 7:
                ms.a.f("PeakService", "[ACTION_RETRY_MISSON] receive, mission:" + intent.getStringExtra(AEEditorConstants.GENERATE_MISSION));
                return;
            case 8:
                ms.a.f("PeakService", "[ACTION_DOWNLOAD_MATERIAL_BUNDDLE] finished");
                String stringExtra2 = intent.getStringExtra("local_path");
                if (stringExtra2 == null || stringExtra2.isEmpty()) {
                    return;
                }
                e(stringExtra2);
                return;
            case 9:
                ms.a.f("PeakService", "[ACTION_FORCE_MISSON] receive, mission:" + intent.getStringExtra(AEEditorConstants.GENERATE_MISSION));
                return;
            case 10:
            default:
                MqqHandler fileThreadHandler = ThreadManager.getFileThreadHandler();
                if (fileThreadHandler != null) {
                    fileThreadHandler.removeCallbacks(FolderUtils.f306952b);
                    fileThreadHandler.postDelayed(FolderUtils.f306952b, 1000L);
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aebase.PeakService.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QLog.isColorLevel()) {
                            QLog.d("PeakService", 2, "peak service start MediaScanner.doScan()");
                        }
                        MediaScanner.getInstance(BaseApplication.getContext()).doScan();
                    }
                }, 64, null, true);
                return;
            case 11:
                OneClickPublishingHelper.f325628a.B(intent.getExtras());
                return;
            case 12:
                ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).addTask((WinkExportTask) intent.getParcelableExtra("wink_export_task"), null);
                return;
            case 13:
                at.f326687a.a((List) intent.getSerializableExtra(IWinkEditorResourceAPI.QZONE_A_KEY_LOCALMEDIAINFOS));
                return;
            case 14:
                ar.f.g().p(intent.getBooleanExtra(AECameraConstants.INTENT_KEY_ALIVE, false));
                WinkSchemaPreCheck.C(intent);
                return;
        }
    }
}
