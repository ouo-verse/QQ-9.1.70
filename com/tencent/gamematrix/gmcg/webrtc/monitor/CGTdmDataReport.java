package com.tencent.gamematrix.gmcg.webrtc.monitor;

import android.content.Context;
import androidx.annotation.NonNull;
import com.heytap.mcssdk.a.a;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGAppUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGSystemUtil;
import com.tencent.gamematrix.gmcg.webrtc.CGSessionCtx;
import com.tencent.gamematrix.gmcg.webrtc.PerfValue;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGTdmDataReport {
    private static final long MIN_NECESSARY_STORAGE_SIZE = 31457280;
    private static final String TDM_ADDRESS = "https://hc.tdm.qq.com:8013/tdm/v1/route";
    private static final String TDM_ADDRESS_TEST = "https://htest.tdm.qq.com:8013/tdm/v1/route";
    private static final String TDM_SDK_APP_ID = "21";
    private static final String TDM_SDK_APP_KEY = "29daf8333787e6130d46177929336733";
    private static final int TDM_SDK_SRC_ID = 20010;
    private static final String TDM_TABLE_PERF = "client";
    private static final String TDM_TABLE_STATUS = "status";
    private static String mDeviceInfo = null;
    private static boolean mEnableReportPerfData = false;
    private static boolean mEnableReportStatusData = true;
    private static boolean mInitialized = false;

    CGTdmDataReport() {
    }

    public static void enableReportPerfData(boolean z16) {
        mEnableReportPerfData = z16;
    }

    public static void enableReportStatusData(boolean z16) {
        mEnableReportStatusData = z16;
    }

    public static String getQIMEI() {
        return "";
    }

    public static void reportData(int i3, String str, Map<String, String> map) {
    }

    public static void reportPerfData(Map<String, String> map) {
        if (mEnableReportPerfData) {
            reportData(TDM_TABLE_PERF, map);
        }
    }

    public static void reportStatusData(@NonNull CGSessionCtx cGSessionCtx, String str, int i3, String str2, boolean z16, long j3, long j16) {
        Object obj;
        if (!CGStringUtil.isEmpty(str) && mEnableReportStatusData) {
            CGLog.i("reportStatusData: " + str + " error: " + i3);
            HashMap hashMap = new HashMap();
            hashMap.put("bizId", cGSessionCtx.pBizId);
            hashMap.put("status", str);
            hashMap.put("package", cGSessionCtx.pGamePackageName);
            hashMap.put("userId", cGSessionCtx.pUserId);
            hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
            hashMap.put("deviceInfo", mDeviceInfo);
            hashMap.put("sdkVersion", "3.0.0.241111110.3.9-SNAPSHOT");
            hashMap.put("sdkType", "android");
            hashMap.put("localSessionNo", cGSessionCtx.pLocalSessionNo);
            hashMap.put(Constants.SP_DEVICE_ID, cGSessionCtx.pDeviceConfig.getDeviceId());
            hashMap.put("sessionId", cGSessionCtx.pDeviceConfig.getControlKey());
            hashMap.put("errorCode", String.valueOf(i3));
            hashMap.put("desc", str2);
            hashMap.put("sceneInfo", cGSessionCtx.pSceneInfo);
            String str3 = "1";
            if (CGSystemUtil.hasBluetoothConnected()) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put("btConnected", obj);
            hashMap.put(VirtualAppProxy.KEY_GAME_ID, cGSessionCtx.pCgGameId);
            hashMap.put("appChannel", cGSessionCtx.pAppChannel);
            hashMap.put("appBizNo", cGSessionCtx.pAppBizNo);
            hashMap.put(a.f36095e, CGAppUtil.getSelfPackageName());
            hashMap.put("gameClientType", String.valueOf(cGSessionCtx.pGameClientType));
            hashMap.put("source", cGSessionCtx.pClientSource);
            if (!z16) {
                str3 = "0";
            }
            hashMap.put("restart", str3);
            hashMap.put("totaltime", String.valueOf(j3));
            hashMap.put("costtime", String.valueOf(j16));
            hashMap.put("codecType", cGSessionCtx.pCodecType.mimeType());
            hashMap.put("deviceModel", cGSessionCtx.pDeviceModel);
            hashMap.put("decoderType", cGSessionCtx.pDecoderType);
            hashMap.put("aiSrEnabled", String.valueOf(cGSessionCtx.pSrType));
            reportData("status", hashMap);
        }
    }

    private static void reportData(String str, Map<String, String> map) {
        reportData(20010, str, map);
    }

    public static void reportPerfData(@NonNull CGSessionCtx cGSessionCtx, PerfValue perfValue, boolean z16) {
        if (perfValue == null || !mEnableReportPerfData) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("version", "3.0.0.241111110.3.9-SNAPSHOT");
        hashMap.put("framerate", String.valueOf(perfValue.decodeRate));
        hashMap.put("bitrate", String.valueOf(perfValue.bitrate));
        hashMap.put("vBitrate", String.valueOf(perfValue.videoBitrate));
        hashMap.put("decodeTime", String.valueOf(perfValue.decodeTimeMs));
        hashMap.put("rtt", String.valueOf(perfValue.averageRtt));
        hashMap.put("deviceInfo", mDeviceInfo);
        hashMap.put("firstFrameDelay", String.valueOf(perfValue.firstFrameRenderDelay));
        hashMap.put("byteReceived", String.valueOf(perfValue.bytesReceived));
        hashMap.put("resolution", perfValue.frameWidth + HippyTKDListViewAdapter.X + perfValue.frameHeight);
        hashMap.put("framesDropped", String.valueOf(perfValue.framesDropped));
        hashMap.put("packetsLost", String.valueOf(perfValue.packetsLost));
        hashMap.put(TPReportKeys.LiveExKeys.LIVE_EX_PLAY_TIME, String.valueOf(perfValue.playTime));
        hashMap.put("framesReceived", String.valueOf(perfValue.framesReceived));
        hashMap.put("hwDecode", cGSessionCtx.pWebRTCParameters.isHwDecode() ? "1" : "0");
        hashMap.put(Constants.SP_DEVICE_ID, cGSessionCtx.pDeviceConfig.getDeviceId());
        hashMap.put("freezeCount", String.valueOf(perfValue.freezeCount));
        hashMap.put("totalFreezesDuration", String.valueOf(perfValue.totalFreezesDuration));
        hashMap.put("app", "1");
        hashMap.put("timestamp", String.valueOf(perfValue.timestamp));
        hashMap.put("stop", z16 ? "1" : "0");
        hashMap.put("framesDecoded", String.valueOf(perfValue.framesDecoded));
        hashMap.put("webrtcNetworkBandwidth", String.valueOf(perfValue.webrtcNetworkBandwidth));
        hashMap.put("networkQuality", String.valueOf(perfValue.webrtcNetworkQuality));
        hashMap.put("localSessionNo", cGSessionCtx.pLocalSessionNo);
        hashMap.put("sceneInfo", cGSessionCtx.pSceneInfo);
        hashMap.put("bizId", cGSessionCtx.pBizId);
        hashMap.put("sdkVersion", "3.0.0.241111110.3.9-SNAPSHOT");
        hashMap.put("sdkType", "android");
        hashMap.put(VirtualAppProxy.KEY_GAME_ID, cGSessionCtx.pCgGameId);
        hashMap.put(WadlProxyConsts.SCENE_ID, cGSessionCtx.pSceneId);
        hashMap.put("codecType", cGSessionCtx.pCodecType.mimeType());
        hashMap.put("deviceModel", cGSessionCtx.pDeviceModel);
        hashMap.put("decoderType", cGSessionCtx.pDecoderType);
        hashMap.put("aiSrEnabled", String.valueOf(cGSessionCtx.pSrType));
        reportData(TDM_TABLE_PERF, hashMap);
    }

    public static void onDestroy() {
    }

    public static void onPause() {
    }

    public static void onResume() {
    }

    public static void onStart() {
    }

    public static void onStop() {
    }

    public static void init(Context context) {
    }

    public static void enableTdmReport(boolean z16, boolean z17) {
    }
}
