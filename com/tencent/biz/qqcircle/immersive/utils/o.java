package com.tencent.biz.qqcircle.immersive.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f90229a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f90230b = false;

    /* renamed from: c, reason: collision with root package name */
    private static String f90231c;

    public static String a() {
        String str = f90231c;
        if (str != null) {
            return str;
        }
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_barrage_exp", true)) {
            QLog.d("QFSBarrageEntranceExpUtils", 1, "[getCurrentExpName] close by config");
            f90231c = "";
            return "";
        }
        String a16 = com.tencent.biz.qqcircle.utils.k.a("exp_bullet2");
        TextUtils.isEmpty(a16);
        f90231c = a16;
        QLog.d("QFSBarrageEntranceExpUtils", 1, "[getCurrentExpName]:" + a16);
        return a16;
    }

    private static boolean b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return com.tencent.biz.qqcircle.manager.d.b().e(feedCloudMeta$StFeed);
    }

    public static boolean c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return false;
    }

    private static boolean d() {
        boolean d16 = com.tencent.biz.qqcircle.manager.d.b().d();
        QLog.d("QFSBarrageEntranceExpUtils", 1, "[isOpenSwitch] isBarrageOpen: " + d16);
        return d16;
    }

    public static boolean e(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return true;
    }

    public static boolean f(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean z16;
        String a16 = a();
        boolean d16 = d();
        boolean b16 = b(feedCloudMeta$StFeed);
        if (TextUtils.equals(a16, "exp_bullet2_B") && d16 && b16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 != f90230b) {
            f90230b = z16;
            i("isFullScreenVideoShow", a16, d16, b16, false);
        }
        return z16;
    }

    public static boolean g(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean z16;
        String a16 = a();
        boolean z17 = true;
        if (!TextUtils.isEmpty(a16) && !TextUtils.equals(a16, "exp_bullet2_A")) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean d16 = d();
        boolean b16 = b(feedCloudMeta$StFeed);
        if (!z16 || !d16 || !b16) {
            z17 = false;
        }
        if (z17 != f90229a) {
            f90229a = z17;
            i("isVideoRightShow", a16, d16, b16, false);
        }
        return z17;
    }

    public static void h() {
        QLog.d("QFSBarrageEntranceExpUtils", 1, "[onAccountChange]");
        f90231c = null;
    }

    private static void i(String str, String str2, boolean z16, boolean z17, boolean z18) {
        QLog.d("QFSBarrageEntranceExpUtils", 1, "[" + str + "] expName: " + str2 + " | isOpenSwitch: " + z16 + " | isFeedNeedShowBarrage: " + z17 + " | isVideoLandScape: " + z18);
    }

    public static boolean j() {
        return TextUtils.equals(a(), "exp_bullet2_B");
    }
}
