package com.tencent.gamematrix.gmcg.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.api.GmCgApiService;
import com.tencent.gamematrix.gmcg.api.GmCgError;
import com.tencent.gamematrix.gmcg.api.GmCgLogger;
import com.tencent.gamematrix.gmcg.api.GmCgPlayAllocator;
import com.tencent.gamematrix.gmcg.api.GmCgPlayNetDetector;
import com.tencent.gamematrix.gmcg.api.GmCgSdkLoginListener;
import com.tencent.gamematrix.gmcg.api.model.GmCgAllocatorCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgNetDetectionInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgPlayQueueInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgSdkLoginCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgSessionCfg;
import com.tencent.gamematrix.gmcg.base.helper.CGBaseHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.network.CGHttpReqManager;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.env.CGClientEnvHelper;
import com.tencent.gamematrix.gmcg.sdk.impl.CGApiServiceImpl;
import com.tencent.gamematrix.gmcg.sdk.impl.CGNetworkChangeObserver;
import com.tencent.gamematrix.gmcg.sdk.impl.CGPlayAllocatorImpl;
import com.tencent.gamematrix.gmcg.sdk.impl.CGPlayDetectorImpl;
import com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl;
import com.tencent.gamematrix.gmcg.sdk.impl.CGTVPlaySessionImpl;
import com.tencent.gamematrix.gmcg.sdk.netdetect.CGNetDetectionManager;
import com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService;
import com.tencent.gamematrix.gmcg.sdk.service.CGInitAuthResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGServerProvider;
import com.tencent.gamematrix.gmcg.sdk.view.GmCgPlayTextureView;
import com.tencent.gamematrix.gmcg.sdk.view.GmCgPlayView;
import com.tencent.gamematrix.gmcg.webrtc.GmCgPxlwManager;
import com.tencent.gamematrix.gmcg.webrtc.VideoFilterController;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.TVInputManager;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.ITVInputManager;
import com.tencent.gamematrix.gmcg.webrtc.monitor.CGTdmDataReport;
import com.tencent.gamematrix.pxlw.PixelWorksImpl;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GmCgSdk {
    public static final int GMCG_BIZNO = 9;
    public static final String GMCG_VERSION = "3.0.0.241111110.3.9-SNAPSHOT";
    private static int sAppBizNo;

    private static void checkIfHasServerMapping(GmCgSdkLoginCfg gmCgSdkLoginCfg) {
        CGGlbConfig.setServerMapping(gmCgSdkLoginCfg.pServerMapping);
    }

    private static boolean checkSdkLoginCfgIfValid(GmCgSdkLoginCfg gmCgSdkLoginCfg, GmCgSdkLoginListener gmCgSdkLoginListener) {
        if (gmCgSdkLoginCfg != null && gmCgSdkLoginCfg.isValid()) {
            return true;
        }
        onSdkLoginFail(GmCgError.ErrorParamsWrong, gmCgSdkLoginListener);
        return false;
    }

    public static GmCgApiService createApiService() {
        return new CGApiServiceImpl();
    }

    public static GmCgPlayAllocator createPlayAllocator(@NonNull GmCgAllocatorCfg gmCgAllocatorCfg) {
        return CGPlayAllocatorImpl.create(gmCgAllocatorCfg);
    }

    public static GmCgPlayAllocator createPlayAllocatorFromQueue(@NonNull GmCgPlayQueueInfo gmCgPlayQueueInfo) {
        return CGPlayAllocatorImpl.createFromQueue(gmCgPlayQueueInfo);
    }

    public static GmCgPlayAllocator createPlayAllocatorFromShareCode(@NonNull String str) {
        return CGPlayAllocatorImpl.createFromShareCode(str);
    }

    public static GmCgPlayNetDetector createPlayNetDetector(@NonNull String str) {
        return CGPlayDetectorImpl.create(str);
    }

    public static GmCgPlaySession createPlaySession(@NonNull GmCgAllocatorCfg gmCgAllocatorCfg, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull GmCgPlayView gmCgPlayView) {
        return CGPlaySessionImpl.create(gmCgAllocatorCfg, gmCgSessionCfg, gmCgPlayView);
    }

    public static GmCgPlaySession createPlaySessionFromDevice(@NonNull GmCgDeviceInfo gmCgDeviceInfo, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull GmCgPlayView gmCgPlayView) {
        return CGPlaySessionImpl.createFromDevice(gmCgDeviceInfo, gmCgSessionCfg, gmCgPlayView);
    }

    public static GmCgPlaySession createPluginPlaySessionFromDevice(@NonNull Context context, @NonNull GmCgDeviceInfo gmCgDeviceInfo, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull FrameLayout frameLayout) {
        return CGPlaySessionImpl.createFromDeviceForPlugin(context, gmCgDeviceInfo, gmCgSessionCfg, frameLayout);
    }

    public static GmCgPlaySession createPreviewSessionFromDevice(@NonNull Context context, @NonNull GmCgDeviceInfo gmCgDeviceInfo, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull FrameLayout frameLayout) {
        return CGPlaySessionImpl.createPreviewFromDevice(context, gmCgDeviceInfo, gmCgSessionCfg, frameLayout);
    }

    public static ITVInputManager createTVInputManager(Context context) {
        return TVInputManager.createInstance(context);
    }

    public static GmCgPlaySession createTVPlaySession(@NonNull GmCgAllocatorCfg gmCgAllocatorCfg, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull GmCgPlayView gmCgPlayView) {
        return CGTVPlaySessionImpl.create(gmCgAllocatorCfg, gmCgSessionCfg, gmCgPlayView);
    }

    public static GmCgPlaySession createTVPlaySessionFromDevice(@NonNull GmCgDeviceInfo gmCgDeviceInfo, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull GmCgPlayView gmCgPlayView) {
        return CGTVPlaySessionImpl.createFromDevice(gmCgDeviceInfo, gmCgSessionCfg, gmCgPlayView);
    }

    public static void enableCgSSO(boolean z16) {
        CGGlbConfig.enableCgSSO(z16);
    }

    public static void enableDebug(boolean z16) {
        CGGlbConfig.sDebugEnabled = z16;
        CGLog.enable(z16);
    }

    public static void enableImeAntiFlash(boolean z16) {
        CGGlbConfig.enableImeAntiFlash(z16);
    }

    public static void enableStartPxlw(boolean z16) {
        GmCgPxlwManager.get().enablePxlw(z16);
    }

    public static void enableSuperResolution(boolean z16) {
        if (CGGlbConfig.sForceFsr) {
            return;
        }
        CGGlbConfig.sEnableSuperResolution = z16;
    }

    public static void enableTdmReport(boolean z16, boolean z17) {
        CGTdmDataReport.enableTdmReport(z16, z17);
    }

    public static void enableTdmReportPerfData(boolean z16) {
        CGTdmDataReport.enableReportPerfData(z16);
    }

    public static void enableTdmReportStatusData(boolean z16) {
        CGTdmDataReport.enableReportStatusData(z16);
    }

    public static void forceUseFsr(boolean z16) {
        CGGlbConfig.sForceFsr = z16;
        if (z16) {
            CGGlbConfig.sEnableSuperResolution = true;
        }
    }

    @Deprecated
    public static String getCodecConfig() {
        return "unknown";
    }

    public static List<GmCgNetDetectionInfo> getPlayDetDetectorResult() {
        return CGNetDetectionManager.get().getCachedNetDelayDetectList();
    }

    public static ITVInputManager getTVInputManager() {
        return TVInputManager.getInstance();
    }

    public static void init(@NonNull Context context, boolean z16, GmCgLogger gmCgLogger, int i3, @NonNull String str) {
        Context applicationContext = context.getApplicationContext();
        CGGlbConfig.setAppContext(applicationContext);
        CGBaseHelper.init(applicationContext);
        CGGlbConfig.setAppBizNo(String.valueOf(i3));
        CGGlbConfig.setAppChannel(str);
        sAppBizNo = i3;
        if (i3 != 9 && i3 != 8) {
            throw new IllegalArgumentException("illegal biz no: expected 9, actual " + sAppBizNo);
        }
        if (isTvBiz(i3)) {
            initWithTV(applicationContext, z16, gmCgLogger);
        } else {
            init(applicationContext, z16, gmCgLogger);
        }
        initPxlw(applicationContext.getPackageName());
    }

    private static void initPxlw(String str) {
        if (GmCgPxlwManager.get().isEnablePxlw()) {
            try {
                GmCgPxlwManager.get().init(new PixelWorksImpl(str));
            } catch (Throwable unused) {
            }
        }
    }

    private static void initWithTV(@NonNull Context context, boolean z16, GmCgLogger gmCgLogger) {
        CGGlbConfig.setForTV(true);
        TVInputManager.createInstance(context);
        init(context, z16, gmCgLogger);
    }

    private static void internalSdkLogin(GmCgSdkLoginCfg gmCgSdkLoginCfg, @Nullable String str, final GmCgSdkLoginListener gmCgSdkLoginListener) {
        checkIfHasServerMapping(gmCgSdkLoginCfg);
        CGClientEnvHelper.get().init(CGGlbConfig.getServerMapping());
        CGNetDetectionManager.get().init(CGGlbConfig.getAppContext(), CGGlbConfig.getUserId(), CGGlbConfig.getServerMapping());
        if (gmCgSdkLoginCfg.pUseFakeLogin) {
            CGGlbConfig.setGmCgToken("123456789ABCDEF");
            CGServerProvider.init(CGGlbConfig.getServerType(), true);
            if (gmCgSdkLoginListener != null) {
                gmCgSdkLoginListener.onGmCgSdkLoginResult(GmCgError.OK());
                return;
            }
            return;
        }
        if (4 == gmCgSdkLoginCfg.pServerType && CGStringUtil.notEmpty(gmCgSdkLoginCfg.pCustomServer)) {
            if (gmCgSdkLoginCfg.pCustomServerForDebug) {
                CGGlbConfig.sUseDebugAlloc = true;
                CGServerProvider.initWithCustomServer(gmCgSdkLoginCfg.pCustomServer, false);
                CGGlbConfig.setGmCgToken("ABCDEFG1234567");
                onSdkLoginSuccess(gmCgSdkLoginListener, "");
                return;
            }
            CGServerProvider.initWithCustomServer(gmCgSdkLoginCfg.pCustomServer, true);
        } else {
            CGServerProvider.init(CGGlbConfig.getServerType(), true);
        }
        if (TextUtils.isEmpty(str)) {
            CGLog.i("get token from server");
            new CGBizHttpService().requestInitAndAuth(new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.b
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    GmCgSdk.lambda$internalSdkLogin$0(GmCgSdkLoginListener.this, gmCgError, (CGInitAuthResp) obj);
                }
            }, "login");
        } else {
            CGLog.i("inject token directly");
            CGGlbConfig.setGmCgToken(str);
            onSdkLoginSuccess(gmCgSdkLoginListener, "");
        }
    }

    public static boolean isAllTvBiz() {
        return isTvBiz(sAppBizNo);
    }

    public static boolean isAppChannel() {
        if (sAppBizNo == 1) {
            return true;
        }
        return false;
    }

    public static boolean isDebugEnabled() {
        return CGGlbConfig.sDebugEnabled;
    }

    private static boolean isQtvBiz(int i3) {
        if (i3 == 4) {
            return true;
        }
        return false;
    }

    public static boolean isQtvBizChannel() {
        return isQtvBiz(sAppBizNo);
    }

    private static boolean isTvBiz(int i3) {
        if (i3 != 2 && i3 != 4 && i3 != 8) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$internalSdkLogin$0(GmCgSdkLoginListener gmCgSdkLoginListener, GmCgError gmCgError, CGInitAuthResp cGInitAuthResp) {
        if (GmCgError.isOK(gmCgError)) {
            CGGlbConfig.setGmCgToken(cGInitAuthResp.token);
            onSdkLoginSuccess(gmCgSdkLoginListener, cGInitAuthResp.context);
        } else {
            onSdkLoginFail(gmCgError, gmCgSdkLoginListener);
        }
    }

    public static void login(GmCgSdkLoginCfg gmCgSdkLoginCfg, GmCgSdkLoginListener gmCgSdkLoginListener) {
        if (!isQtvBiz(sAppBizNo)) {
            CGClientEnvHelper.get().refresh();
        }
        if (checkSdkLoginCfgIfValid(gmCgSdkLoginCfg, gmCgSdkLoginListener)) {
            CGGlbConfig.setLoginInfo(gmCgSdkLoginCfg.pBizId, gmCgSdkLoginCfg.pUserId, gmCgSdkLoginCfg.pUserKey, gmCgSdkLoginCfg.pServerType);
            if (CGStringUtil.notEmpty(gmCgSdkLoginCfg.pGameMatrixChannelId)) {
                CGGlbConfig.setAppChannel(gmCgSdkLoginCfg.pGameMatrixChannelId);
            }
            if (CGStringUtil.notEmpty(gmCgSdkLoginCfg.pCustomAppBizInfo)) {
                CGGlbConfig.setAppBizInfo(gmCgSdkLoginCfg.pCustomAppBizInfo);
            }
            internalSdkLogin(gmCgSdkLoginCfg, null, gmCgSdkLoginListener);
        }
    }

    public static void loginLite(GmCgSdkLoginCfg gmCgSdkLoginCfg, String str, @Nullable GmCgSdkLoginListener gmCgSdkLoginListener) {
        if (!isQtvBiz(sAppBizNo)) {
            CGClientEnvHelper.get().refresh();
        }
        CGGlbConfig.setLoginInfo(gmCgSdkLoginCfg.pBizId, gmCgSdkLoginCfg.pUserId, gmCgSdkLoginCfg.pUserKey, gmCgSdkLoginCfg.pServerType);
        if (CGStringUtil.notEmpty(gmCgSdkLoginCfg.pGameMatrixChannelId)) {
            CGGlbConfig.setAppChannel(gmCgSdkLoginCfg.pGameMatrixChannelId);
        }
        if (CGStringUtil.notEmpty(gmCgSdkLoginCfg.pCustomAppBizInfo)) {
            CGGlbConfig.setAppBizInfo(gmCgSdkLoginCfg.pCustomAppBizInfo);
        }
        internalSdkLogin(gmCgSdkLoginCfg, str, gmCgSdkLoginListener);
    }

    private static void onSdkLoginFail(GmCgError gmCgError, GmCgSdkLoginListener gmCgSdkLoginListener) {
        if (gmCgSdkLoginListener != null) {
            gmCgSdkLoginListener.onGmCgSdkLoginResult(gmCgError);
        }
    }

    private static void onSdkLoginSuccess(GmCgSdkLoginListener gmCgSdkLoginListener, String str) {
        if (gmCgSdkLoginListener != null) {
            gmCgSdkLoginListener.onGmCgSdkLoginResult(GmCgError.OK());
            gmCgSdkLoginListener.onGmCgSdkLoginMessage(str);
        }
    }

    public static void reportTdmData(int i3, String str, Map<String, String> map) {
        CGTdmDataReport.reportData(i3, str, map);
    }

    public static void setLogger(final GmCgLogger gmCgLogger) {
        if (gmCgLogger == null) {
            return;
        }
        CGLog.setLogger(new CGLog.Logger() { // from class: com.tencent.gamematrix.gmcg.sdk.GmCgSdk.1
            @Override // com.tencent.gamematrix.gmcg.base.log.CGLog.Logger
            public void d(String str, String str2) {
                GmCgLogger.this.d(str, str2);
            }

            @Override // com.tencent.gamematrix.gmcg.base.log.CGLog.Logger
            public void e(String str, String str2) {
                GmCgLogger.this.e(str, str2);
            }

            @Override // com.tencent.gamematrix.gmcg.base.log.CGLog.Logger
            public void i(String str, String str2) {
                GmCgLogger.this.i(str, str2);
            }

            @Override // com.tencent.gamematrix.gmcg.base.log.CGLog.Logger
            public void v(String str, String str2) {
                GmCgLogger.this.v(str, str2);
            }

            @Override // com.tencent.gamematrix.gmcg.base.log.CGLog.Logger
            public void w(String str, String str2) {
                GmCgLogger.this.w(str, str2);
            }
        });
    }

    public static void setPrivacyDeviceInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        CGGlbConfig.setPrivacyDeviceInfo(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }

    public static void setSGSRDeltaLimit(@FloatRange(from = 0.0d, to = 255.0d) float f16) {
        VideoFilterController.get().setSGSRDeltaLimit(f16);
    }

    public static void setSGSREdgeSharpness(float f16) {
        VideoFilterController.get().setSGSREdgeSharpness(f16);
    }

    public static void setSGSREdgeThreshold(@FloatRange(from = 0.0d, to = 255.0d) float f16) {
        VideoFilterController.get().setSGSREdgeThreshold(f16);
    }

    public static GmCgPlaySession createPlaySession(@NonNull Activity activity, @NonNull GmCgAllocatorCfg gmCgAllocatorCfg, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull FrameLayout frameLayout) {
        return CGPlaySessionImpl.create(activity, gmCgAllocatorCfg, gmCgSessionCfg, frameLayout);
    }

    public static GmCgPlaySession createPlaySessionFromDevice(@NonNull Activity activity, @NonNull GmCgDeviceInfo gmCgDeviceInfo, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull FrameLayout frameLayout) {
        return CGPlaySessionImpl.createFromDevice(activity, gmCgDeviceInfo, gmCgSessionCfg, frameLayout);
    }

    public static GmCgPlaySession createTVPlaySession(@NonNull GmCgAllocatorCfg gmCgAllocatorCfg, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull GmCgPlayTextureView gmCgPlayTextureView) {
        return CGTVPlaySessionImpl.create(gmCgAllocatorCfg, gmCgSessionCfg, gmCgPlayTextureView);
    }

    public static GmCgPlaySession createTVPlaySessionFromDevice(@NonNull GmCgDeviceInfo gmCgDeviceInfo, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull GmCgPlayTextureView gmCgPlayTextureView) {
        return CGTVPlaySessionImpl.createFromDevice(gmCgDeviceInfo, gmCgSessionCfg, gmCgPlayTextureView);
    }

    public static void enableImeAntiFlash(boolean z16, long j3) {
        CGGlbConfig.enableImeAntiFlash(z16, j3);
    }

    private static void init(@NonNull Context context, boolean z16, GmCgLogger gmCgLogger) {
        enableDebug(z16);
        setLogger(gmCgLogger);
        init(context);
    }

    public static void init(@NonNull Context context) {
        CGNetworkChangeObserver.get().create(context).register();
        CGHttpReqManager.get().init(context);
        CGTdmDataReport.init(context);
        if (isQtvBiz(sAppBizNo)) {
            CGTdmDataReport.enableTdmReport(true, false);
        } else {
            CGClientEnvHelper.get().refresh();
        }
    }
}
