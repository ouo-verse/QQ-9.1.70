package com.tencent.mobileqq.activity.aio.audiopanel.impl;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEnumTableID;

/* loaded from: classes10.dex */
public class AudioPanelUtilsImpl implements IAudioPanelUtils {
    private static final String CONFIG_KEY = "aio_audio_panel_time_interval_str_8990_116733951";
    private static final int LEVEL_OFFSET;
    private static final int[] VOLUME_LEVELS;

    static {
        int[] iArr = {1038, 1948, 2857, 3766, 4675, 5584, 6493, 7402, 8311, 10000};
        VOLUME_LEVELS = iArr;
        LEVEL_OFFSET = iArr[1] - iArr[0];
    }

    public int getFirstTimeInterval() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(CONFIG_KEY, true)) {
            return 500;
        }
        return 1000;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelUtils
    public String getTimeStrByMillis(double d16) {
        int i3;
        if (d16 < getFirstTimeInterval()) {
            i3 = 0;
        } else {
            i3 = (int) ((d16 / 1000.0d) + 0.5d);
        }
        int i16 = i3 / 60;
        int i17 = i3 % 60;
        if (i17 < 10) {
            return i16 + ":0" + i17;
        }
        return i16 + ":" + i17;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelUtils
    public int getTitleBarHeight(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelUtils
    public int getVolumeLevel(int i3) {
        int i16;
        if (i3 < 5000) {
            i16 = 4000;
        } else {
            int i17 = 8000;
            if (i3 >= 8000) {
                i17 = 10000;
                if (i3 >= 10000) {
                    if (i3 < 14000) {
                        i16 = GProEnumTableID.ENUMTABLEIDQGROUPFEEDACTOPT;
                    } else if (i3 < 18000) {
                        i16 = 16000;
                    } else if (i3 < 23000) {
                        i16 = 19000;
                    } else if (i3 < 27000) {
                        i16 = IWeiyunResponseHandler.ERROR_DISK_SERVER_CODE_FLOW_LIMIT_VIP;
                    } else {
                        i17 = 32000;
                        if (i3 < 32000) {
                            i16 = 25000;
                        } else if (i3 < 35000) {
                            i16 = 28000;
                        } else if (i3 >= 40000) {
                            i16 = 40000;
                        }
                    }
                }
            }
            i16 = i17;
        }
        int i18 = (int) ((i16 * 0.3f) / LEVEL_OFFSET);
        return VOLUME_LEVELS[Math.min(i18, r0.length - 1)];
    }
}
