package com.tencent.gamematrix.gmcg.webrtc;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGNetworkUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGSystemUtil;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGSessionCtx {
    private final Context mContext;
    public String pAppBizNo;
    public String pAppChannel;
    public String pBizId;
    public String pClientIsp;
    public String pClientSource;
    public String pCloudGameDeviceType;
    public int pDeviceFps;
    public int pGameClientType;
    public String pGamePackageName;
    public boolean pHardwareDecode;
    public String pLocalSessionNo;
    public String pOaid;
    public int pResolutionHeight;
    public int pResolutionWidth;
    public String pSceneId;
    public String pSceneInfo;
    public int pServerEnv;
    public String pServerIsp;
    public String pSoc;
    public int pSrType;
    public String pUserId;
    public String pXid;
    public boolean pEnableTdmReport = true;
    public String pCgGameId = "";
    public VideoCodecType pCodecType = VideoCodecType.UNKNOWN;
    public String pDeviceModel = "";
    public String pDeviceBrand = "";
    public String pDecoderType = "default";
    public String pSessionId = "";
    public String pRequestId = "";
    public String pResolutionType = "";
    public String pDeviceSource = "";
    public String pBenchmarkScore = "0";
    public DeviceConfig pDeviceConfig = new DeviceConfig();
    public WebRTCParameters pWebRTCParameters = new WebRTCParameters();

    CGSessionCtx(@NonNull Context context) {
        this.mContext = context;
    }

    public static CGSessionCtx create(Context context, String str) {
        CGSessionCtx cGSessionCtx = new CGSessionCtx(context);
        cGSessionCtx.pUserId = str;
        cGSessionCtx.pLocalSessionNo = generateLocalSessionNo(str);
        return cGSessionCtx;
    }

    private static String generateLocalSessionNo(String str) {
        return CGSystemUtil.encryptMd5(("android@" + str + "@" + System.currentTimeMillis() + "@" + ((int) (Math.random() * 10000.0d))).getBytes());
    }

    public String getNetworkTypeSymbol() {
        try {
            return CGNetworkUtil.getNetworkTypeSymbol(this.mContext);
        } catch (Exception e16) {
            CGLog.e("CGSessionCtx getNetworkTypeSymbol failed: " + e16);
            return "none";
        }
    }
}
