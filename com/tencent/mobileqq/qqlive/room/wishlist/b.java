package com.tencent.mobileqq.qqlive.room.wishlist;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.qqlive.common.api.IAegisLogApi;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f272152a;

    /* renamed from: b, reason: collision with root package name */
    private static final com.tencent.timi.game.liveroom.impl.room.livewebdialog.a f272153b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58486);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f272152a = false;
            f272153b = new com.tencent.timi.game.liveroom.impl.room.livewebdialog.a() { // from class: com.tencent.mobileqq.qqlive.room.wishlist.a
                @Override // com.tencent.timi.game.liveroom.impl.room.livewebdialog.a
                public final void onDismiss() {
                    b.f272152a = false;
                }
            };
        }
    }

    private static String b(String str, String str2) {
        return c(str, str2, 0);
    }

    @SuppressLint({"DefaultLocale"})
    private static String c(String str, String str2, int i3) {
        return String.format("https://qlive.qq.com/cos/live/h5/gift-wish/index.html?roomid=%s&anchor_uid=%s&type=main&is_hongniang=%d&_t=1647419808760&_load_type=0&_tde_id=6881&loading=light", str, str2, Integer.valueOf(i3));
    }

    @SuppressLint({"DefaultLocale"})
    public static void d(long j3, long j16) {
        if (f272152a) {
            return;
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) topActivity;
            String b16 = b(String.valueOf(j3), String.valueOf(j16));
            int h16 = x.h(fragmentActivity, x.f(fragmentActivity).f185861b);
            Bundle bundle = new Bundle();
            bundle.putString("url", b16);
            bundle.putInt("height_web_dialog", (int) (h16 * 0.85d));
            com.tencent.mobileqq.qqlive.base.webview.a.f(fragmentActivity, b16, "", bundle, null, null, false, f272153b);
            f272152a = true;
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("QQLIVEWishUrlHelper", 1, String.format("\u6253\u5f00\u5fc3\u613f\u5355 \u623f\u95f4ID:[%d], \u4e3b\u64adID:[%d], url[%s]", Long.valueOf(j3), Long.valueOf(j16), b16));
        }
    }
}
