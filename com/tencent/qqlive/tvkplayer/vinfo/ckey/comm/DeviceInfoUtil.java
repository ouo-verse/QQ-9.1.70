package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DeviceInfoUtil {
    private static String mQimei16;
    private static String mQimei36;

    public static String getQimei16() {
        return mQimei16;
    }

    private static String getQimei16Syn(Context context, String str) {
        if (context == null) {
            return "";
        }
        String beacon42Qimei16 = BeaconAdapter.getBeacon42Qimei16(context, str);
        mQimei16 = beacon42Qimei16;
        if (!beacon42Qimei16.isEmpty()) {
            return mQimei16;
        }
        String beacon41Qimei16 = BeaconAdapter.getBeacon41Qimei16(context);
        mQimei16 = beacon41Qimei16;
        if (!beacon41Qimei16.isEmpty()) {
            return mQimei16;
        }
        return BeaconAdapter.getBeacon3Qimei16(context);
    }

    public static String getQimei36() {
        return mQimei36;
    }

    private static String getQimei36Syn(Context context, String str) {
        String beacon42Qimei36 = BeaconAdapter.getBeacon42Qimei36(context, str);
        mQimei36 = beacon42Qimei36;
        if (!beacon42Qimei36.isEmpty()) {
            return mQimei36;
        }
        String beacon41Qimei36 = BeaconAdapter.getBeacon41Qimei36(context);
        mQimei36 = beacon41Qimei36;
        return beacon41Qimei36;
    }

    public static void updateQimei(Context context, String str) {
        getQimei36Syn(context, str);
    }
}
