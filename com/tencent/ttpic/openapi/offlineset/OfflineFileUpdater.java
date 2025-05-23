package com.tencent.ttpic.openapi.offlineset;

import android.os.AsyncTask;
import com.google.gson.reflect.TypeToken;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.offlineset.beans.FilterSettingJsonBean;
import com.tencent.ttpic.offlineset.beans.MediaSettingJsonBean;
import com.tencent.ttpic.offlineset.beans.PagCutoutSettingJsonBean;
import com.tencent.ttpic.offlineset.beans.PagSettingJsonBean;
import com.tencent.ttpic.offlineset.enumclass.ScaleMode;
import com.tencent.ttpic.offlineset.utils.OfflineSettingUtils;
import com.tencent.ttpic.openapi.offlineset.utils.FileOfflineUtil;
import com.tencent.ttpic.openapi.offlineset.utils.IHttpClient;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class OfflineFileUpdater {
    private static final String FILTER_SETTING_FILE = "filtersetting.json";
    private static final String MEDIA_SETTING_FILE = "mediasetting.json";
    private static final String PAG_CUTOUT_FILE = "pag_cutout_setting.json";
    private static final String PAG_SETTING_FILE = "pagsetting.json";
    private static final String PTU_SDK_3548 = "3548";
    private static final String TAG = "OfflineFileUpdater";
    private static final int UPDATE_GAP_MIN = 600000;
    private static final String VALUE_WILDCARD = "*";
    private static OfflineSettingUtils.IDownloadedListener sDownloadListener = new OfflineSettingUtils.IDownloadedListener() { // from class: com.tencent.ttpic.openapi.offlineset.OfflineFileUpdater.1
        @Override // com.tencent.ttpic.offlineset.utils.OfflineSettingUtils.IDownloadedListener
        public void downloadCompleted(String str) {
            OfflineFileUpdater.updateAllFile();
        }
    };
    private static long sLastUpdateTime;

    public static void checkOfflineFile() {
        LogUtils.i("OfflineConfig", "will updateAllFile.");
        if (Math.abs(System.currentTimeMillis() - sLastUpdateTime) < 600000) {
            LogUtils.e(TAG, "\u5341\u5206\u949f\u5185\u4e0d\u4f1a\u8fdb\u884c\u4e8c\u6b21\u79bb\u7ebf\u914d\u7f6e\u6570\u636e\u5bfc\u5165\u3002\u8bf7\u7a0d\u540e\u518d\u8fdb\u884c\u66f4\u65b0\u3002");
        } else {
            sLastUpdateTime = System.currentTimeMillis();
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.tencent.ttpic.openapi.offlineset.OfflineFileUpdater.2
                @Override // java.lang.Runnable
                public void run() {
                    OfflineSettingUtils.updateOfflinePage(OfflineFileUpdater.PTU_SDK_3548);
                }
            });
        }
    }

    private static String getStringFromFile(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(FileOfflineUtil.getOfflineDirPath());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(PTU_SDK_3548);
        sb5.append(str2);
        sb5.append(str);
        return FileOfflineUtil.readJsonStringFromFile(sb5.toString());
    }

    private static boolean isCurentPhone(String str, String str2) {
        if (DeviceInstance.PHONE_BRAND.equals(str) && (DeviceInstance.PHONE_MODEL.equals(str2) || "*".equals(str2))) {
            return true;
        }
        return false;
    }

    public static void setHttpClient(IHttpClient iHttpClient) {
        OfflineSettingUtils.setHttpClient(iHttpClient);
        OfflineSettingUtils.addDownloadLister(sDownloadListener);
    }

    protected static void updateAllFile() {
        LogUtils.i("OfflineConfig", "updateAllFile running.");
        updateMediaSetting();
        updateFilterSetting();
        updatePagSetting();
        updatePagCutoutSetting();
    }

    protected static void updateFilterSetting() {
        FilterSettingJsonBean filterSettingJsonBean;
        FilterSettingJsonBean.GaussSetting gaussSetting;
        ScaleMode scaleMode;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(FileOfflineUtil.getOfflineDirPath());
        String str = File.separator;
        sb5.append(str);
        sb5.append(PTU_SDK_3548);
        sb5.append(str);
        sb5.append(FILTER_SETTING_FILE);
        String readJsonStringFromFile = FileOfflineUtil.readJsonStringFromFile(sb5.toString());
        if (readJsonStringFromFile != null && (filterSettingJsonBean = (FilterSettingJsonBean) GsonUtils.json2Obj(readJsonStringFromFile, new TypeToken<FilterSettingJsonBean>() { // from class: com.tencent.ttpic.openapi.offlineset.OfflineFileUpdater.4
        }.getType())) != null && (gaussSetting = filterSettingJsonBean.gaussSetting) != null) {
            AEOfflineConfig.sGauSuperPhoneYear = gaussSetting.gaussSuperPhone;
            AEOfflineConfig.sGauMidderPhoneYear = gaussSetting.gaussMidderPhone;
            AEOfflineConfig.sGauSuperMaxSzie = gaussSetting.superMaxSize;
            AEOfflineConfig.sGauMidMaxSize = gaussSetting.midMaxSize;
            AEOfflineConfig.sGauLowMaxSize = gaussSetting.lowMaxSize;
            if (AEOfflineConfig.sGauSuperMaxSzie > 10.0f) {
                scaleMode = ScaleMode.USE_MAX_SIZE;
            } else {
                scaleMode = ScaleMode.USE_SCALE_VALE;
            }
            AEOfflineConfig.sGauScaleMode = scaleMode;
            AEOfflineConfig.sUpdateGaussSetting = true;
            List<FilterSettingJsonBean.GassResizeSet> list = gaussSetting.phoneGassSet;
            if (list != null) {
                for (FilterSettingJsonBean.GassResizeSet gassResizeSet : list) {
                    if (DeviceInstance.PHONE_BRAND.equals(gassResizeSet.brand)) {
                        if (DeviceInstance.PHONE_MODEL.equals(gassResizeSet.model)) {
                            updateGausSetting(gassResizeSet);
                            return;
                        } else if ("*".equals(gassResizeSet.model)) {
                            updateGausSetting(gassResizeSet);
                        }
                    }
                }
            }
        }
    }

    private static void updateGausSetting(FilterSettingJsonBean.GassResizeSet gassResizeSet) {
        AEOfflineConfig.sIsGaussResize = gassResizeSet.needResize;
        int i3 = gassResizeSet.maxSize;
        AEOfflineConfig.sGaussMaxSize = i3;
        float f16 = gassResizeSet.scale;
        AEOfflineConfig.sGaussScale = f16;
        if (i3 > 10) {
            AEOfflineConfig.sGauScaleMode = ScaleMode.USE_MAX_SIZE;
        }
        if (f16 > 0.0f && f16 < 1.0f) {
            AEOfflineConfig.sGauScaleMode = ScaleMode.USE_SCALE_VALE;
        }
    }

    protected static void updateMediaSetting() {
        MediaSettingJsonBean mediaSettingJsonBean;
        boolean z16;
        boolean z17;
        boolean z18;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(FileOfflineUtil.getOfflineDirPath());
        String str = File.separator;
        sb5.append(str);
        sb5.append(PTU_SDK_3548);
        sb5.append(str);
        sb5.append(MEDIA_SETTING_FILE);
        String readJsonStringFromFile = FileOfflineUtil.readJsonStringFromFile(sb5.toString());
        if (readJsonStringFromFile != null && (mediaSettingJsonBean = (MediaSettingJsonBean) GsonUtils.json2Obj(readJsonStringFromFile, new TypeToken<MediaSettingJsonBean>() { // from class: com.tencent.ttpic.openapi.offlineset.OfflineFileUpdater.3
        }.getType())) != null) {
            List<MediaSettingJsonBean.HardEncodeDevice> list = mediaSettingJsonBean.hardEncode;
            boolean z19 = true;
            if (list != null) {
                Iterator<MediaSettingJsonBean.HardEncodeDevice> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MediaSettingJsonBean.HardEncodeDevice next = it.next();
                    if (DeviceInstance.PHONE_BRAND.equals(next.brand)) {
                        if (DeviceInstance.PHONE_MODEL.equals(next.model)) {
                            if (next.encodetype == 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            AEOfflineConfig.setHardEncodeEnable(z17);
                        } else if ("*".equals(next.model)) {
                            if (next.encodetype == 0) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            AEOfflineConfig.setHardEncodeEnable(z18);
                        }
                    }
                }
            }
            List<MediaSettingJsonBean.HardDecodeDevice> list2 = mediaSettingJsonBean.hardDecode;
            if (list2 != null) {
                for (MediaSettingJsonBean.HardDecodeDevice hardDecodeDevice : list2) {
                    if (DeviceInstance.PHONE_BRAND.equals(hardDecodeDevice.brand)) {
                        if (DeviceInstance.PHONE_MODEL.equals(hardDecodeDevice.model)) {
                            if (hardDecodeDevice.decodetype != 0) {
                                z19 = false;
                            }
                            AEOfflineConfig.setHardDecodeEnable(z19);
                            return;
                        } else if ("*".equals(hardDecodeDevice.model)) {
                            if (hardDecodeDevice.decodetype == 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            AEOfflineConfig.setHardDecodeEnable(z16);
                        }
                    }
                }
            }
        }
    }

    private static void updatePagCutoutSetting() {
        PagCutoutSettingJsonBean pagCutoutSettingJsonBean;
        List<PagCutoutSettingJsonBean.PagCutoutSetting> list;
        String stringFromFile = getStringFromFile(PAG_CUTOUT_FILE);
        if (stringFromFile != null && (pagCutoutSettingJsonBean = (PagCutoutSettingJsonBean) GsonUtils.json2Obj(stringFromFile, new TypeToken<PagCutoutSettingJsonBean>() { // from class: com.tencent.ttpic.openapi.offlineset.OfflineFileUpdater.6
        }.getType())) != null && (list = pagCutoutSettingJsonBean.phoneSetting) != null) {
            for (PagCutoutSettingJsonBean.PagCutoutSetting pagCutoutSetting : list) {
                if (DeviceInstance.getInstance().getDeviceName().equals(pagCutoutSetting.deviceName)) {
                    AEOfflineConfig.useCutoutVersion = pagCutoutSetting.useVersion;
                }
            }
        }
    }

    private static void updatePagDeviceSetting(PagSettingJsonBean.PagDeviceSetting pagDeviceSetting) {
        AEOfflineConfig.sPagNeedScaleStatus = pagDeviceSetting.needLowScale;
        AEOfflineConfig.sPagScaleVaue = pagDeviceSetting.scale;
        AEOfflineConfig.sNotSupportRealTimePag = pagDeviceSetting.notRealTime;
        AEOfflineConfig.sIsPagEncodeBgStaus = pagDeviceSetting.encodeBackgroud;
        AEOfflineConfig.sNeedSoftDecoder = pagDeviceSetting.needSoftDecode;
    }

    protected static void updatePagSetting() {
        PagSettingJsonBean pagSettingJsonBean;
        String stringFromFile = getStringFromFile(PAG_SETTING_FILE);
        if (stringFromFile != null && (pagSettingJsonBean = (PagSettingJsonBean) GsonUtils.json2Obj(stringFromFile, new TypeToken<PagSettingJsonBean>() { // from class: com.tencent.ttpic.openapi.offlineset.OfflineFileUpdater.5
        }.getType())) != null) {
            AEOfflineConfig.sLowDevYearPag = pagSettingJsonBean.lowDeviceYear;
            AEOfflineConfig.sPagScaleVaue = pagSettingJsonBean.lowScale;
            List<PagSettingJsonBean.PagDeviceSetting> list = pagSettingJsonBean.phoneSetting;
            if (list != null) {
                for (PagSettingJsonBean.PagDeviceSetting pagDeviceSetting : list) {
                    if (DeviceInstance.PHONE_BRAND.equals(pagDeviceSetting.brand)) {
                        if (DeviceInstance.PHONE_MODEL.equals(pagDeviceSetting.model)) {
                            updatePagDeviceSetting(pagDeviceSetting);
                            return;
                        } else if ("*".equals(pagDeviceSetting.model)) {
                            updatePagDeviceSetting(pagDeviceSetting);
                        }
                    }
                }
            }
        }
    }
}
