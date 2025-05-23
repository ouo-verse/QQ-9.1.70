package com.tencent.gamematrix.gmcg.webrtc;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class SummaryLog {
    private long deviceAllocBeginTimeStamp = -1;
    private long deviceAllocEndTimeStamp = -1;
    private final Set<String> reportDevices = new HashSet();
    private final Set<String> reportFlags = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class Holder {
        private static final SummaryLog INSTANCE = new SummaryLog();

        Holder() {
        }
    }

    private long calculateClientFrameTime() {
        if (this.deviceAllocEndTimeStamp < 0) {
            return 0L;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.deviceAllocEndTimeStamp;
        this.deviceAllocEndTimeStamp = -1L;
        return elapsedRealtime;
    }

    private long calculateClientLaunchTime() {
        if (this.deviceAllocBeginTimeStamp < 0) {
            return 0L;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.deviceAllocBeginTimeStamp;
        this.deviceAllocBeginTimeStamp = -1L;
        return elapsedRealtime;
    }

    private boolean checkDeviceReported(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            boolean contains = this.reportDevices.contains(str);
            if (contains) {
                CGLog.w("device " + str + " has reported summary log!");
            } else {
                this.reportDevices.add(str);
            }
            return contains;
        } catch (Exception e16) {
            CGLog.e("checkDeviceReported: " + e16.toString());
            return false;
        }
    }

    private boolean checkFlagReported(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            boolean contains = this.reportFlags.contains(str);
            if (contains) {
                CGLog.w("flag " + str + " has reported summary log!");
            } else {
                this.reportFlags.add(str);
            }
            return contains;
        } catch (Exception e16) {
            CGLog.e("checkFlagReported: " + e16);
            return false;
        }
    }

    private int convertClientDecCodec(CGSessionCtx cGSessionCtx) {
        VideoCodecType videoCodecType = cGSessionCtx.pCodecType;
        if (videoCodecType == VideoCodecType.H264) {
            if (cGSessionCtx.pHardwareDecode) {
                return 0;
            }
            return 2;
        }
        if (videoCodecType == VideoCodecType.H265) {
            return 1;
        }
        return -1;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    private int convertClientPxlwSupport() {
        ?? isHardwareSupport = GmCgPxlwManager.get().isHardwareSupport();
        if (isHardwareSupport <= 0) {
            return isHardwareSupport == true ? 1 : 0;
        }
        return (isHardwareSupport == true ? 1 : 0) + (GmCgPxlwManager.get().isServiceSupport() ? 1 : 0);
    }

    private int covertClientSRType(int i3) {
        if (i3 == 2) {
            return 1;
        }
        return 0;
    }

    public static SummaryLog get() {
        return Holder.INSTANCE;
    }

    private void putCommonData(CGSessionCtx cGSessionCtx, Map<String, Object> map) {
        map.put("client_launch_time", Long.valueOf(calculateClientLaunchTime()));
        map.put("client_game_id", cGSessionCtx.pCgGameId);
        map.put("client_sr_type", Integer.valueOf(covertClientSRType(cGSessionCtx.pSrType)));
        map.put("client_dec_codec", Integer.valueOf(convertClientDecCodec(cGSessionCtx)));
        map.put("client_res_fps", Integer.valueOf(cGSessionCtx.pDeviceFps));
        map.put("client_biz_id", cGSessionCtx.pBizId);
        map.put("client_os_type", 0);
        map.put("client_os_version", String.valueOf(Build.VERSION.SDK_INT));
        map.put("client_device_model", cGSessionCtx.pDeviceModel);
        map.put("client_device_brand", cGSessionCtx.pDeviceBrand);
        map.put("client_xf_benchmark", cGSessionCtx.pBenchmarkScore);
        map.put("client_platform", cGSessionCtx.pDeviceSource);
        map.put("client_sdk_version", "3.0.0.241111110.3.9-SNAPSHOT");
        map.put("client_pxlw_support", Integer.valueOf(convertClientPxlwSupport()));
        map.put("client_network_type", cGSessionCtx.getNetworkTypeSymbol());
    }

    public void cancelDeviceAllocBegin() {
        this.deviceAllocBeginTimeStamp = -1L;
    }

    public void markDeviceAllocBegin() {
        this.deviceAllocBeginTimeStamp = SystemClock.elapsedRealtime();
    }

    public void markDeviceAllocEnd() {
        this.deviceAllocEndTimeStamp = SystemClock.elapsedRealtime();
    }

    @Nullable
    public String onStreamingFail(CGSessionCtx cGSessionCtx) {
        String str;
        if (cGSessionCtx == null) {
            return null;
        }
        DeviceConfig deviceConfig = cGSessionCtx.pDeviceConfig;
        if (deviceConfig != null) {
            str = deviceConfig.getDeviceId();
        } else {
            str = "";
        }
        if (checkDeviceReported(str) || checkFlagReported(cGSessionCtx.pRequestId)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("client_frame_time", 0);
        putCommonData(cGSessionCtx, hashMap);
        return new JSONObject(hashMap).toString();
    }

    @Nullable
    public String onStreamingSuccess(CGSessionCtx cGSessionCtx) {
        String str;
        if (cGSessionCtx == null) {
            return null;
        }
        DeviceConfig deviceConfig = cGSessionCtx.pDeviceConfig;
        if (deviceConfig != null) {
            str = deviceConfig.getDeviceId();
        } else {
            str = "";
        }
        if (checkDeviceReported(str) || checkFlagReported(cGSessionCtx.pRequestId)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("client_frame_time", Long.valueOf(calculateClientFrameTime()));
        putCommonData(cGSessionCtx, hashMap);
        return new JSONObject(hashMap).toString();
    }
}
