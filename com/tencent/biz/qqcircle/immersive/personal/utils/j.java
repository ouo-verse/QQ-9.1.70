package com.tencent.biz.qqcircle.immersive.personal.utils;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.richframework.util.RFWStringBuilderUtils;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f89086a;

    /* renamed from: b, reason: collision with root package name */
    private static String f89087b;

    public static boolean a() {
        k();
        if (f89086a && com.tencent.biz.qqcircle.manager.i.a("qqcircle_enable_personal_collect_box")) {
            return true;
        }
        return false;
    }

    public static int b(int i3) {
        int i16 = 2;
        if (i3 != 2) {
            i16 = 3;
            if (i3 != 3) {
                return 1;
            }
        }
        return i16;
    }

    public static int c(int i3) {
        if (i3 == 2) {
            return 3;
        }
        if (i3 != 3) {
            if (i3 == 5) {
                return 2;
            }
            return 1;
        }
        return 4;
    }

    public static String d(List<FeedCloudFavoritessvr$FavoritesInfo> list) {
        StringBuilder obtain = RFWStringBuilderUtils.obtain();
        for (int i3 = 0; i3 < list.size(); i3++) {
            obtain.append(list.get(i3).f398434id.get());
            if (i3 < list.size() - 1) {
                obtain.append(",");
            }
        }
        return obtain.toString();
    }

    public static String e(List<FeedCloudMeta$StFeed> list) {
        StringBuilder obtain = RFWStringBuilderUtils.obtain();
        for (int i3 = 0; i3 < list.size(); i3++) {
            obtain.append(list.get(i3).f398449id.get());
            if (i3 < list.size() - 1) {
                obtain.append(",");
            }
        }
        return obtain.toString();
    }

    public static int f(int i3) {
        if (i3 != 1) {
            return 1;
        }
        return 2;
    }

    public static int g() {
        return 0 - j();
    }

    public static int h() {
        return 2 - j();
    }

    public static int i() {
        return 1 - j();
    }

    private static int j() {
        return !a() ? 1 : 0;
    }

    private static void k() {
        String q16 = r.q();
        if (!TextUtils.equals(f89087b, q16)) {
            f89086a = uq3.c.Q();
            f89087b = q16;
        }
    }
}
