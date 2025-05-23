package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.item.l;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static Animation f179869a;

    /* renamed from: c, reason: collision with root package name */
    private static int[] f179871c;

    /* renamed from: b, reason: collision with root package name */
    private static Random f179870b = new Random();

    /* renamed from: d, reason: collision with root package name */
    private static Set<Object> f179872d = new HashSet();

    public static void a(Object obj, View view) {
        Animation animation;
        f179872d.remove(obj);
        if (f179872d.isEmpty() && (animation = f179869a) != null && animation.hasStarted()) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerBubbleHelper", 2, "cancelShakeWindowAnim");
            }
            f179869a.cancel();
            f179869a.reset();
            view.clearAnimation();
        }
    }

    private static Animation b(Context context) {
        TranslateAnimation translateAnimation = new TranslateAnimation(-r3, BaseAIOUtils.f(8.0f, context.getResources()), 0.0f, 0.0f);
        translateAnimation.setDuration(100L);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(2);
        return translateAnimation;
    }

    public static int[] c(QQAppInterface qQAppInterface) {
        String g16;
        if (f179871c == null && (g16 = l.g(qQAppInterface, 7)) != null) {
            String[] split = g16.split(",");
            try {
                int length = split.length;
                int[] iArr = new int[length];
                for (int i3 = 0; i3 < length; i3++) {
                    iArr[i3] = Integer.parseInt(split[i3]);
                }
                f179871c = iArr;
            } catch (NumberFormatException e16) {
                QLog.e("StickerBubbleHelper", 1, "PE_SWITCH_TYPE_SURPRISE_INDEXS is illegal to parse, " + e16);
            }
        }
        int[] iArr2 = f179871c;
        if (iArr2 == null) {
            return new int[]{10, 20, 30};
        }
        return iArr2;
    }

    public static void d(Object obj, @NonNull View view) {
        f179872d.add(obj);
        if (f179869a == null) {
            Animation b16 = b(view.getContext());
            f179869a = b16;
            b16.setAnimationListener(new a());
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerBubbleHelper", 2, "start to shake");
        }
        view.startAnimation(f179869a);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerBubbleHelper", 2, "onAllAnimationEnd " + animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerBubbleHelper", 2, "onAnimationStart " + animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
