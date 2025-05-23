package com.tencent.mobileqq.popanim.view;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qui.quiblurview.QQBlurView;
import java.util.Random;
import w61.c;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Random f259159a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52357);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f259159a = new Random();
        }
    }

    public static com.tencent.mobileqq.activity.aio.stickerbubble.a a(int i3, String str, boolean z16) {
        int i16;
        Random random;
        com.tencent.mobileqq.activity.aio.stickerbubble.a b16 = new com.tencent.mobileqq.activity.aio.stickerbubble.a().e(new Point(i3 / 2, 0)).c(str).b(z16);
        int i17 = 2000;
        Random random2 = f259159a;
        if (z16) {
            i16 = (-random2.nextInt(2000)) + 1000;
        } else {
            i16 = (-random2.nextInt(8000)) + 4000;
        }
        double d16 = i16;
        if (z16) {
            random = f259159a;
            i17 = 500;
        } else {
            random = f259159a;
        }
        return b16.f(new c.b(d16, random.nextInt(i17))).a(new c.a(0.0d, 200.0d)).d(49);
    }

    public static com.tencent.mobileqq.activity.aio.stickerbubble.a b(@NonNull Point point, @NonNull String str, boolean z16) {
        int i3;
        int nextInt;
        com.tencent.mobileqq.activity.aio.stickerbubble.a b16 = new com.tencent.mobileqq.activity.aio.stickerbubble.a().e(point).c(str).b(z16);
        Random random = f259159a;
        if (z16) {
            i3 = (-random.nextInt(1500)) + 750;
        } else {
            i3 = (-random.nextInt(6000)) + 3000;
        }
        double d16 = i3;
        if (z16) {
            nextInt = (-1000) - f259159a.nextInt(500);
        } else {
            nextInt = (-2000) - f259159a.nextInt(1000);
        }
        return b16.f(new c.b(d16, nextInt)).a(new c.a(0.0d, 200.0d)).d(85);
    }

    public static void c(QQBlurView qQBlurView, View view, int i3) {
        qQBlurView.j(view);
        qQBlurView.m(qQBlurView);
        qQBlurView.k(0);
        qQBlurView.A(8.0f);
        qQBlurView.l(8);
        ColorDrawable colorDrawable = new ColorDrawable(Color.rgb(3, 8, 26));
        colorDrawable.setAlpha(128);
        qQBlurView.z(colorDrawable);
        qQBlurView.getLayoutParams().height = i3;
        qQBlurView.x();
    }

    public static void d(LottieHelper.d dVar) {
        LottieHelper.b(BaseApplication.getContext(), "emoc/pop_anim_finger.json", null, 160, 160, -1, dVar);
    }

    public static void e(LottieHelper.d dVar) {
        LottieHelper.b(BaseApplication.getContext(), "emoc/pop_anim_top_static.json", null, 60, 60, -1, dVar);
    }

    public static void f(String str, int i3, String str2) {
        ReportController.o(null, "dc00898", "", "", str, str, i3, 0, str2, "", "", "");
    }

    public static void g(String str, int i3, String str2, String str3) {
        ReportController.o(null, "dc00898", "", "", str, str, i3, 0, str2, str3, "", "");
    }

    public static void h(String str, EmoticonInfo emoticonInfo) {
        i(str, emoticonInfo, false);
    }

    public static void i(String str, EmoticonInfo emoticonInfo, boolean z16) {
        int convertToServer;
        if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
            SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
            if (z16) {
                convertToServer = QQEmojiUtil.getEmojiUnicode(systemAndEmojiEmoticonInfo.code);
            } else {
                convertToServer = QQSysFaceUtil.convertToServer(systemAndEmojiEmoticonInfo.code);
            }
            f(str, convertToServer, "");
        }
    }

    public static void j(int i3, View... viewArr) {
        Drawable drawable;
        if (viewArr != null) {
            for (View view : viewArr) {
                view.setVisibility(i3);
                if ((view instanceof LottieAnimationView) && (drawable = ((LottieAnimationView) view).getDrawable()) != null && (drawable instanceof LottieDrawable)) {
                    LottieDrawable lottieDrawable = (LottieDrawable) drawable;
                    if (i3 == 0) {
                        if (!lottieDrawable.isAnimating()) {
                            lottieDrawable.playAnimation();
                        }
                    } else if (lottieDrawable.isAnimating()) {
                        lottieDrawable.stop();
                    }
                }
            }
        }
    }
}
