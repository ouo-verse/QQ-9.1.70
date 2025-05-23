package com.tencent.mobileqq.stickerbubble;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.NTPEItemData;
import com.tencent.mobileqq.poke.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import mqq.app.MobileQQ;
import w61.c;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Animation f290229a;

    /* renamed from: b, reason: collision with root package name */
    private static Random f290230b;

    /* renamed from: c, reason: collision with root package name */
    private static int[] f290231c;

    /* renamed from: d, reason: collision with root package name */
    private static Set<Object> f290232d;

    /* renamed from: e, reason: collision with root package name */
    private static int f290233e;

    /* renamed from: f, reason: collision with root package name */
    private static Drawable f290234f;

    /* renamed from: g, reason: collision with root package name */
    private static String f290235g;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.stickerbubble.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class AnimationAnimationListenerC8620a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        AnimationAnimationListenerC8620a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else if (QLog.isColorLevel()) {
                QLog.d("StickerBubbleHelper", 2, "onAllAnimationEnd " + animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else if (QLog.isColorLevel()) {
                QLog.d("StickerBubbleHelper", 2, "onAnimationStart " + animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52389);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f290230b = new Random();
            f290232d = new HashSet();
        }
    }

    public static void a(Object obj, View view) {
        Animation animation;
        f290232d.remove(obj);
        if (f290232d.isEmpty() && (animation = f290229a) != null && animation.hasStarted()) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerBubbleHelper", 2, "cancelShakeWindowAnim");
            }
            f290229a.cancel();
            f290229a.reset();
            view.clearAnimation();
        }
    }

    public static com.tencent.mobileqq.activity.aio.stickerbubble.a b(int i3, String str, int i16, int[] iArr) {
        int i17;
        Random random;
        boolean h16 = h(i16, iArr);
        com.tencent.mobileqq.activity.aio.stickerbubble.a b16 = new com.tencent.mobileqq.activity.aio.stickerbubble.a().e(new Point(i3 / 2, 0)).c(str).b(h16);
        int i18 = 2000;
        Random random2 = f290230b;
        if (h16) {
            i17 = (-random2.nextInt(2000)) + 1000;
        } else {
            i17 = (-random2.nextInt(8000)) + 4000;
        }
        double d16 = i17;
        if (h16) {
            random = f290230b;
            i18 = 500;
        } else {
            random = f290230b;
        }
        return b16.f(new c.b(d16, random.nextInt(i18))).a(new c.a(0.0d, 200.0d)).d(49);
    }

    public static com.tencent.mobileqq.activity.aio.stickerbubble.a c(@NonNull Point point, @NonNull String str, int i3) {
        int i16;
        int nextInt;
        boolean g16 = g(i3);
        com.tencent.mobileqq.activity.aio.stickerbubble.a b16 = new com.tencent.mobileqq.activity.aio.stickerbubble.a().e(point).c(str).b(g16);
        Random random = f290230b;
        if (g16) {
            i16 = (-random.nextInt(1500)) + 750;
        } else {
            i16 = (-random.nextInt(6000)) + 3000;
        }
        double d16 = i16;
        if (g16) {
            nextInt = (-1000) - f290230b.nextInt(500);
        } else {
            nextInt = (-2000) - f290230b.nextInt(1000);
        }
        return b16.f(new c.b(d16, nextInt)).a(new c.a(0.0d, 200.0d)).d(85);
    }

    private static Animation d(Context context) {
        TranslateAnimation translateAnimation = new TranslateAnimation(-r3, com.tencent.mobileqq.poke.utils.a.f259088a.a(8.0f, context.getResources()), 0.0f, 0.0f);
        translateAnimation.setDuration(100L);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(2);
        return translateAnimation;
    }

    public static int[] e(AppInterface appInterface) {
        String f16;
        if (f290231c == null && (f16 = f.f(appInterface, 7)) != null) {
            String[] split = f16.split(",");
            try {
                int length = split.length;
                int[] iArr = new int[length];
                for (int i3 = 0; i3 < length; i3++) {
                    iArr[i3] = Integer.parseInt(split[i3]);
                }
                f290231c = iArr;
            } catch (NumberFormatException e16) {
                QLog.e("StickerBubbleHelper", 1, "PE_SWITCH_TYPE_SURPRISE_INDEXS is illegal to parse, " + e16);
            }
        }
        int[] iArr2 = f290231c;
        if (iArr2 == null) {
            return new int[]{10, 20, 30};
        }
        return iArr2;
    }

    public static synchronized void f(@NonNull NTPEItemData nTPEItemData, @NonNull String str) {
        synchronized (a.class) {
            f290233e = nTPEItemData.getPokeEmoId();
            f290234f = com.tencent.mobileqq.poke.c.f258994a.b(f290233e);
            com.tencent.mobileqq.poke.utils.c.f259091a.b(nTPEItemData.getPokeEmoId(), str);
            f290235g = str;
        }
    }

    private static boolean g(int i3) {
        for (int i16 : e((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime())) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    private static boolean h(int i3, int[] iArr) {
        for (int i16 : iArr) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public static void i(Object obj, View view) {
        if (view == null) {
            return;
        }
        f290232d.add(obj);
        if (f290229a == null) {
            Animation d16 = d(view.getContext());
            f290229a = d16;
            d16.setAnimationListener(new AnimationAnimationListenerC8620a());
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerBubbleHelper", 2, "start to shake");
        }
        view.startAnimation(f290229a);
    }
}
