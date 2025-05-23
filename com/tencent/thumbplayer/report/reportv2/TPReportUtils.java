package com.tencent.thumbplayer.report.reportv2;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.capability.TPDrmCapAttribute;
import com.tencent.thumbplayer.api.capability.TPDrmCapability;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.manager.TPMgrConfig;
import com.tencent.thumbplayer.common.TPNetworkUtil;
import com.tencent.thumbplayer.common.TPVersion;
import com.tencent.thumbplayer.common.config.TPConfig;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import com.tencent.thumbplayer.report.reportv2.data.TPCommonParams;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPReportUtils {
    private static final int DEVICE_TYPE = 0;
    private static final int INIT_SEQ = 0;
    private static final String OS_VERSION = String.format("android %s", TPSystemInfo.getOsVersion());
    private static final int PLATFORM_TYPE = 0;
    private static final Map<Integer, Integer> REPORT_DRM_TYPE;
    private static final Map<Integer, Integer> REPORT_PLAYER_TYPE;
    public static final String REPORT_PROTOCOL_VERSION = "1.0.0";
    private static final String TAG = "TPReportUtils";
    private Context mContext;

    static {
        HashMap hashMap = new HashMap();
        REPORT_PLAYER_TYPE = hashMap;
        hashMap.put(0, -1);
        hashMap.put(1, 0);
        hashMap.put(2, 3);
        HashMap hashMap2 = new HashMap();
        REPORT_DRM_TYPE = hashMap2;
        hashMap2.put(-1, -1);
        hashMap2.put(0, 32);
        hashMap2.put(2, 4);
        hashMap2.put(3, 64);
    }

    public TPReportUtils(@NonNull Context context) {
        this.mContext = context;
    }

    public static int convertTPDRMTypeToReportDrmType(TPDrmCapAttribute tPDrmCapAttribute) {
        Integer num = REPORT_DRM_TYPE.get(Integer.valueOf(tPDrmCapAttribute.getDrmType()));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public static int convertTPPlayerTypeToReportPlayerEnum(int i3) {
        Integer num = REPORT_PLAYER_TYPE.get(Integer.valueOf(i3));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    private int getDrmAbility() {
        TPDrmCapAttribute[] tPDrmCapAttributeArr = new TPDrmCapAttribute[0];
        try {
            tPDrmCapAttributeArr = TPDrmCapability.getDrmCapAttributes();
        } catch (TPLoadLibraryException e16) {
            e16.printStackTrace();
        }
        int i3 = 0;
        for (TPDrmCapAttribute tPDrmCapAttribute : tPDrmCapAttributeArr) {
            i3 |= convertTPDRMTypeToReportDrmType(tPDrmCapAttribute);
        }
        return i3;
    }

    public void initDeviceParams(TPCommonParams tPCommonParams) {
        tPCommonParams.setGuid((String) TPConfig.getConfigValue(TPMgrConfig.TP_MGR_CONFIG_KEY_BEFORE_STRING_GUID, ""));
        tPCommonParams.setPlatformType(0);
        tPCommonParams.setDeviceType(0);
        tPCommonParams.setNetworkType(TPNetworkUtil.getNetworkType(this.mContext));
        tPCommonParams.setDeviceName(TPSystemInfo.getDeviceName());
        tPCommonParams.setOsVersion(OS_VERSION);
        tPCommonParams.setAppName(this.mContext.getPackageName());
        tPCommonParams.setAppVer(TPSystemInfo.getAppVersionName(this.mContext));
        tPCommonParams.setReportProtocolVer("1.0.0");
        tPCommonParams.setPlayerVer(TPVersion.getVersion());
        tPCommonParams.setPlatform(((Integer) TPConfig.getConfigValue(TPMgrConfig.TP_MGR_CONFIG_KEY_BEFORE_INT_PLATFORM, 0)).intValue());
        tPCommonParams.setSeq(0);
        tPCommonParams.setDrmAbility(getDrmAbility());
    }

    public void updateCommonParams(TPCommonParams tPCommonParams) {
        tPCommonParams.setNetworkType(TPNetworkUtil.getNetworkType(this.mContext));
    }
}
