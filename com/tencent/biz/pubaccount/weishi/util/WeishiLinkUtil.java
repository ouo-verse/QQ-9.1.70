package com.tencent.biz.pubaccount.weishi.util;

import UserGrowth.stLinkStragegyArgs;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.DateUtils;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WeishiLinkUtil {
    static /* bridge */ /* synthetic */ String a() {
        return e();
    }

    private static String b() {
        return "key_click_recommend_card_count_" + l();
    }

    private static String c() {
        return "key_click_recommend_card_time_" + l();
    }

    private static String d() {
        return "key_last_link_time_" + l();
    }

    private static String e() {
        return "key_last_link_type_" + l();
    }

    private static String f() {
        return "key_open_recommend_page_count_" + l();
    }

    private static String g() {
        return "key_open_recommend_page_time_" + l();
    }

    private static int h() {
        if (m(e(), d(), -1)) {
            return ai.c(e(), -1);
        }
        return -1;
    }

    public static stLinkStragegyArgs i() {
        stLinkStragegyArgs stlinkstragegyargs = new stLinkStragegyArgs();
        stlinkstragegyargs.hasInstalledWeish = com.tencent.biz.qqstory.utils.l.c(BaseApplicationImpl.getApplication().getApplicationContext());
        stlinkstragegyargs.todayClickCount = j();
        stlinkstragegyargs.todayEnterCount = k();
        stlinkstragegyargs.todayLastLinkId = h();
        return stlinkstragegyargs;
    }

    private static int j() {
        if (m(b(), c(), 0)) {
            return ai.c(b(), 0);
        }
        return 0;
    }

    private static int k() {
        if (m(f(), g(), 0)) {
            return ai.c(f(), 0);
        }
        return 0;
    }

    private static String l() {
        String str;
        String o16 = p.o(BaseApplication.getContext());
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && !TextUtils.isEmpty(runtime.getAccount())) {
            str = com.tencent.open.base.g.d(runtime.getAccount());
        } else {
            str = "";
        }
        return str + "_" + o16;
    }

    public static void n(final int i3) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.util.WeishiLinkUtil.1
            @Override // java.lang.Runnable
            public void run() {
                ai.l(WeishiLinkUtil.a(), i3);
            }
        });
    }

    private static void o(final String str, final String str2) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.util.WeishiLinkUtil.2
            @Override // java.lang.Runnable
            public void run() {
                ai.l(str, ai.c(str, 0) + 1);
                ai.n(str2, System.currentTimeMillis());
            }
        });
    }

    public static void p() {
        o(b(), c());
    }

    public static void q() {
        o(f(), g());
    }

    private static boolean m(final String str, final String str2, final int i3) {
        boolean isSameDay = DateUtils.isSameDay(System.currentTimeMillis(), ai.f(str2, 0L));
        if (!isSameDay) {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.util.WeishiLinkUtil.3
                @Override // java.lang.Runnable
                public void run() {
                    ai.l(str, i3);
                    ai.n(str2, System.currentTimeMillis());
                }
            });
        }
        return isSameDay;
    }
}
