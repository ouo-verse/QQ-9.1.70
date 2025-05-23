package com.tencent.mobileqq.mini.server.request;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.minigame.config_center.MiniGameVAHardwareConfig$GetConfigReq;
import com.tencent.util.AbiUtil;
import com.tencent.util.QQDeviceInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t74.c;
import t74.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0002R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/mini/server/request/MiniGameVAHardwareConfigRequest;", "Lcom/tencent/mobileqq/mini/server/BaseMiniAppSSORequest;", "appIds", "", "", "(Ljava/util/List;)V", "getAppIds", "()Ljava/util/List;", "getCmd", "getHardwareInfo", "getNetWorkTypeString", "getRequestData", "", "getSystemMaxRefreshRate", "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVAHardwareConfigRequest implements BaseMiniAppSSORequest {
    private static final String CMD = "miniapp.trpc.minigame.config_center.ConfigCenter.GetConfig";
    private static final String HARDWARE_INFO_BRAND = "brand";
    private static final String HARDWARE_INFO_CORE_NAME = "core_name";
    private static final String HARDWARE_INFO_CPU = "cpu";
    private static final String HARDWARE_INFO_CPU_NAME = "cpu_name";
    private static final String HARDWARE_INFO_DEVICE = "device";
    private static final String HARDWARE_INFO_FREQ = "freq";
    private static final String HARDWARE_INFO_FRESHRATE = "freshRate";
    private static final String HARDWARE_INFO_GLES = "gles";
    private static final String HARDWARE_INFO_GPU_NAME = "gpu_name";
    private static final String HARDWARE_INFO_INSTRUCTION_SET = "instruction_set";
    private static final String HARDWARE_INFO_IS_ALLOW_LANDSCAPE = "is_allow_landscape";
    private static final String HARDWARE_INFO_IS_ARM64 = "is_arm64";
    private static final String HARDWARE_INFO_IS_SUPPORT_H265 = "isSupportH265";
    private static final String HARDWARE_INFO_MANUFACTURER = "manufacturer";
    private static final String HARDWARE_INFO_MINI_BOX_VERSION = "mini_box_version";
    private static final String HARDWARE_INFO_MODEL = "model";
    private static final String HARDWARE_INFO_NETWORK = "network";
    private static final String HARDWARE_INFO_OS = "os";
    private static final String HARDWARE_INFO_OS_VERSION = "os_version";
    private static final String HARDWARE_INFO_RAM = "ram";
    private static final String HARDWARE_INFO_SECOND_INSTRUCTION_SET = "second_instruction_set";
    private static final String HARDWARE_INFO_UDID = "udid";
    private static final String HARDWARE_INFO_VA_META_DREAM_VERSION = "va_meta_dream_version";
    private static final String TAG = "MiniGameVAHardwareConfigRequest";
    private final List<String> appIds;

    public MiniGameVAHardwareConfigRequest(List<String> appIds) {
        Intrinsics.checkNotNullParameter(appIds, "appIds");
        this.appIds = appIds;
    }

    private final String getHardwareInfo() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            d dVar = d.f435534a;
            String b16 = dVar.b();
            String a16 = dVar.a();
            String model = DeviceInfoMonitor.getModel();
            long b17 = c.b();
            jSONObject.put(HARDWARE_INFO_GPU_NAME, b16);
            jSONObject.put(HARDWARE_INFO_RAM, String.valueOf(b17));
            jSONObject.put(HARDWARE_INFO_GLES, a16);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("device", Build.DEVICE);
            jSONObject.put("model", model);
            jSONObject.put(HARDWARE_INFO_INSTRUCTION_SET, Build.CPU_ABI);
            jSONObject.put(HARDWARE_INFO_SECOND_INSTRUCTION_SET, Build.CPU_ABI2);
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
            jSONObject.put(HARDWARE_INFO_CORE_NAME, Build.BOARD.toString());
            jSONObject.put("cpu_name", Build.HARDWARE.toString());
            jSONObject.put(HARDWARE_INFO_UDID, QQDeviceInfo.getQIMEI());
            jSONObject.put("os", c.a(BaseApplicationImpl.getApplication()));
            jSONObject.put(HARDWARE_INFO_IS_ARM64, String.valueOf(AbiUtil.isArm64Runtime(BaseApplicationImpl.getApplication())));
            jSONObject.put("network", getNetWorkTypeString());
            jSONObject.put(HARDWARE_INFO_IS_SUPPORT_H265, String.valueOf(AbiUtil.isArm64Runtime(BaseApplicationImpl.getApplication())));
            jSONObject.put(HARDWARE_INFO_CPU, String.valueOf(ah.n()));
            jSONObject.put(HARDWARE_INFO_FREQ, String.valueOf(ah.l()));
            jSONObject.put(HARDWARE_INFO_FRESHRATE, String.valueOf(getSystemMaxRefreshRate()));
            if (AppSetting.o(BaseApplication.getContext())) {
                str = "1";
            } else {
                str = "0";
            }
            jSONObject.put(HARDWARE_INFO_IS_ALLOW_LANDSCAPE, str);
            String dexVersion = MiniBoxSDK.getDexVersion(BaseApplication.getContext());
            if (!TextUtils.isEmpty(dexVersion)) {
                jSONObject.put(HARDWARE_INFO_MINI_BOX_VERSION, dexVersion);
            }
            QLog.i(TAG, 1, "local dexVersion:" + dexVersion);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getHardwareInfo exception: ", e16);
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "uploadInfo.toString()");
        return jSONObject2;
    }

    private final String getNetWorkTypeString() {
        int netWorkTypeContain5G = HttpUtil.getNetWorkTypeContain5G();
        switch (netWorkTypeContain5G) {
            case 0:
                return "NONE";
            case 1:
                return Global.TRACKING_WIFI;
            case 2:
                return "2G";
            case 3:
                return "3G";
            case 4:
                return "4G";
            case 5:
                return "CABLE";
            case 6:
                return "5G";
            default:
                return "UNKNOWN_" + netWorkTypeContain5G;
        }
    }

    private final int getSystemMaxRefreshRate() {
        try {
            return ScreenUtil.getMaxRefreshRate();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getSystemMaxRefreshRate exception:", e16);
            return 0;
        }
    }

    public final List<String> getAppIds() {
        return this.appIds;
    }

    @Override // com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest
    public String getCmd() {
        return CMD;
    }

    @Override // com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest
    public byte[] getRequestData() {
        MiniGameVAHardwareConfig$GetConfigReq miniGameVAHardwareConfig$GetConfigReq = new MiniGameVAHardwareConfig$GetConfigReq();
        miniGameVAHardwareConfig$GetConfigReq.config_type.set(1);
        miniGameVAHardwareConfig$GetConfigReq.appids.set(this.appIds);
        miniGameVAHardwareConfig$GetConfigReq.hardware_info.set(ByteStringMicro.copyFromUtf8(getHardwareInfo()));
        byte[] byteArray = miniGameVAHardwareConfig$GetConfigReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
