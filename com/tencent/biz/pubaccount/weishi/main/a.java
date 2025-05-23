package com.tencent.biz.pubaccount.weishi.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.l;
import com.tencent.biz.pubaccount.weishi.util.i;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.k;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.pad.LaunchMode;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f80924a = "WSLauncher.";

    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.main.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static class C0826a {
        public static void a(l lVar) {
            String str;
            int c16 = lVar.c();
            if (c16 < 0 || c16 > 1) {
                c16 = 1;
            }
            if (c16 == 0) {
                str = "follow_tab";
            } else {
                str = "waterfall_tab";
            }
            Bundle bundle = new Bundle();
            bundle.putString("key_home_to_index", str);
            bundle.putString("key_home_to_context_feed_id", lVar.b());
            bundle.putString("key_drama_id", lVar.e());
            bundle.putString("key_drama_jump_schema", lVar.f());
            bundle.putBoolean("key_context_feed_show_musk", lVar.h());
            bundle.putSerializable("key_open_home_then_video_params", lVar.d());
            bundle.putLong("key_click_open_time", SystemClock.uptimeMillis());
            Intent intent = new Intent(lVar.a(), (Class<?>) PublicFragmentActivity.class);
            intent.putExtra("key_home_bundle", bundle);
            intent.putExtra("key_from", "home");
            if (lVar.g()) {
                intent.setFlags(67108864);
            }
            b(lVar, intent);
        }

        private static void b(l lVar, Intent intent) {
            if (i.b()) {
                com.tencent.mobileqq.pad.i.e(lVar.a(), intent.getExtras(), WSMainContainerFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(true).h(LaunchMode.singleTop).b(R.anim.f154562ba, R.anim.f154568bf).a());
            } else {
                PublicFragmentActivity.b.a(lVar.a(), intent, PublicFragmentActivity.class, WSMainContainerFragment.class);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static String f80925a = a.f80924a + "VerticalPageLauncher";

        private static boolean a(String str) {
            return TextUtils.equals(str, "aio_enter_c_link") || TextUtils.equals(str, "open_home_then_video");
        }

        private static void b(Activity activity, k kVar) {
            activity.overridePendingTransition(kVar.n() != 2 ? R.anim.f154869su : R.anim.f154476ii, R.anim.f154868st);
        }

        public static void c(k kVar) {
            x.f(f80925a, "[WSVerticalMainFragment.java][start] params:" + kVar);
            f10.b.f397582a.d(kVar.l());
            Intent V = kVar.V();
            if (kVar.w()) {
                V.setFlags(67108864);
            }
            Context e16 = kVar.e();
            boolean p16 = com.tencent.biz.pubaccount.weishi.ui.videotransition.c.p(kVar, V, a(kVar.l()));
            if (!(e16 instanceof Activity) || p16) {
                return;
            }
            b((Activity) e16, kVar);
        }

        public static void d(k kVar) {
            x.f(f80925a, "[WSVerticalMainFragment.java][startForResult] params:" + kVar);
            f10.b.f397582a.d(kVar.l());
            Intent V = kVar.V();
            Context e16 = kVar.e();
            BaseFragment k3 = kVar.k();
            if (e16 instanceof Activity) {
                PublicFragmentActivity.b.f(k3, V, PublicFragmentActivity.class, WSMainContainerFragment.class, kVar.s());
                b((Activity) e16, kVar);
            }
        }

        public static void e(k kVar) {
            x.f(f80925a, "[WSVerticalMainFragment.java][start] params:" + kVar);
            f10.b.f397582a.d(kVar.l());
            Intent V = kVar.V();
            if (kVar.w()) {
                V.setFlags(67108864);
            }
            Context e16 = kVar.e();
            boolean n3 = com.tencent.biz.pubaccount.weishi.ui.videotransition.c.n(kVar, V, a(kVar.l()));
            if (!(e16 instanceof Activity) || n3) {
                return;
            }
            b((Activity) e16, kVar);
        }
    }
}
