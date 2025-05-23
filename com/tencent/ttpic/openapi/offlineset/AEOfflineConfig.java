package com.tencent.ttpic.openapi.offlineset;

import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.offlineset.enumclass.ScaleMode;
import org.light.bean.PhoneType;
import org.light.device.OfflineConfig;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AEOfflineConfig {
    public static final int DEVICE_PERF_LEVERL_HIGH = 5;
    public static final int DEVICE_PERF_LEVERL_LOW = 2;
    public static final int DEVICE_PERF_LEVERL_MIDDLE = 3;
    public static final int DEVICE_PERF_LEVERL_MIDDLE_HIGH = 4;
    public static final int DEVICE_PERF_LEVERL_VERYLOW = 1;
    private static final String TAG = "OfflineConfig";
    protected static float sGauLowMaxSize = 360.0f;
    protected static float sGauMidMaxSize = 480.0f;
    protected static int sGauMidderPhoneYear = 2015;
    protected static float sGauSuperMaxSzie = 540.0f;
    protected static int sGauSuperPhoneYear = 2017;
    protected static int sGaussMaxSize = -1;
    protected static float sGaussScale = -1.0f;
    protected static boolean sIsGaussResize = true;
    private static boolean sIsHardDecodeEnable = false;
    private static boolean sIsHardEncodeEnable = false;
    protected static ScaleMode sGauScaleMode = ScaleMode.USE_MAX_SIZE;
    protected static boolean sUpdateGaussSetting = false;
    protected static int sLowDevYearPag = 2015;
    protected static int sPagNeedScaleStatus = 0;
    protected static float sPagScaleVaue = 0.5f;
    protected static boolean sNeedSoftDecoder = false;
    protected static boolean sNotSupportRealTimePag = false;
    protected static int sIsPagEncodeBgStaus = 0;
    public static int useCutoutVersion = OfflineConfig.CutOutVersion.NEW.value;

    public static int getGauMaxSize() {
        return OfflineConfig.getGauMaxSize();
    }

    public static PhoneType getGauPhoneType(int i3) {
        return OfflineConfig.getGauPhoneType(i3);
    }

    public static float getGauScaleFromPhoneYear(int i3) {
        return OfflineConfig.getGauScaleFromPhoneYear(i3);
    }

    public static ScaleMode getGauScaleMode() {
        return sGauScaleMode;
    }

    public static float getGauScaleValue() {
        return OfflineConfig.getGauScaleValue();
    }

    public static int getPagLowDeviceYear() {
        return OfflineConfig.getPagLowDeviceYear();
    }

    public static int getPagNeedScaleStatus() {
        return OfflineConfig.getPagNeedScaleStatus();
    }

    public static float getPagPlayScale() {
        return OfflineConfig.getPagPlayScale();
    }

    public static int getPhonePerfLevel() {
        return OfflineConfig.getPhonePerfLevel(AEModule.getContext());
    }

    public static int getPhoneType(int i3) {
        return OfflineConfig.getPhoneType(i3);
    }

    public static boolean isCouldHardDecode() {
        return sIsHardDecodeEnable;
    }

    public static boolean isCouldHardEncode() {
        return sIsHardEncodeEnable;
    }

    public static int isEncodeBackGround() {
        return OfflineConfig.isEncodeBackGround();
    }

    public static boolean isGausResize() {
        return sIsGaussResize;
    }

    public static boolean isGaussSettingUpdate() {
        return sUpdateGaussSetting;
    }

    public static boolean isNeedScale() {
        return OfflineConfig.isNeedScale();
    }

    public static boolean isNeedSkipRapidnet() {
        return OfflineConfig.isNeedSkipRapidnet(AEModule.getContext());
    }

    public static boolean isNeedSoftDecode() {
        return OfflineConfig.isNeedSoftDecode();
    }

    public static boolean isNotSuptPagRealTime() {
        return OfflineConfig.isNotSuptPagRealTime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void setHardDecodeEnable(boolean z16) {
        sIsHardDecodeEnable = z16;
        LogUtils.i(TAG, "setHardDecodeEnable:" + z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void setHardEncodeEnable(boolean z16) {
        sIsHardEncodeEnable = z16;
        LogUtils.i(TAG, "setHardEncodeEnable:" + z16);
    }
}
