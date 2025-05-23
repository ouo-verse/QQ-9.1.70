package com.tencent.mobileqq.activity.aio.intimate;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasToggle;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f178911a = VasToggle.VAS_AIO_LEFT_RED_POINT_CONFIG.isEnable(false);

    public static boolean a(String str, String str2) {
        if (f178911a) {
            String stringDataSet = VasToggle.VAS_AIO_LEFT_RED_POINT_CONFIG.getStringDataSet(str, "");
            long decodeLong = VasMMKV.getAIOLeftRedTime().decodeLong("vas_aio_left_key_prefix" + str + str2, 0L);
            long serverTime = NetConnInfoCenter.getServerTime();
            if (stringDataSet.equals("1") && serverTime - decodeLong > 86400) {
                VasMMKV.getAIOLeftRedTime().encodeLong("vas_aio_left_key_prefix" + str + str2, serverTime);
                return true;
            }
            return false;
        }
        return false;
    }
}
