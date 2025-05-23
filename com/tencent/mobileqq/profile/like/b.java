package com.tencent.mobileqq.profile.like;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.tencent.biz.common.util.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends AnimateUtils.AnimationAdapter {
    static IPatchRedirector $redirector_;
    public com.tencent.mobileqq.hotchat.ui.c C;
    public SparseArray<Pair<Point, Integer>> D;

    /* renamed from: d, reason: collision with root package name */
    int f260216d;

    /* renamed from: e, reason: collision with root package name */
    int f260217e;

    /* renamed from: f, reason: collision with root package name */
    public View f260218f;

    /* renamed from: h, reason: collision with root package name */
    public Drawable[] f260219h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f260220i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f260221m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements Interpolator {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
            }
            if (f16 <= 0.33333334f) {
                return 0.0f;
            }
            return (f16 - 0.33333334f) * 1.5f;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f260216d = 0;
        this.f260217e = 0;
        this.f260221m = false;
        this.D = new SparseArray<>();
    }

    public static Animation b(Animation.AnimationListener animationListener, float f16, float f17) {
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f16, f17, f16, f17, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f16, f17);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setDuration(750L);
        alphaAnimation.setRepeatMode(2);
        alphaAnimation.setRepeatCount(-1);
        alphaAnimation.setDuration(750L);
        alphaAnimation.setAnimationListener(animationListener);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setInterpolator(new a());
        return animationSet;
    }

    public void a(QQAppInterface qQAppInterface, HeartLayout heartLayout, Bitmap bitmap, PraiseManager.a aVar, int i3, boolean z16, int i16, float f16, float f17) {
        Bitmap bitmap2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qQAppInterface, heartLayout, bitmap, aVar, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        if (SimpleUIUtil.getSimpleUISwitch()) {
            if (QLog.isColorLevel()) {
                QLog.i("PraiseManager", 2, "doZanAnim, SimpleUIMode is open now");
            }
            heartLayout.d(bitmap, f16, f17);
            return;
        }
        PraiseManager praiseManager = (PraiseManager) qQAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
        if (z16 && praiseManager.f260200f.e(Integer.valueOf(i3)) == null) {
            praiseManager.h(aVar);
            this.D.put(i3, new Pair<>(new Point((int) f16, (int) f17), Integer.valueOf(i16)));
        }
        d g16 = praiseManager.g(i3, z16, "from_nearby_people");
        if (g16 != null) {
            if (i16 == 2 && (bitmap2 = g16.f260242j) != null) {
                com.tencent.mobileqq.hotchat.ui.c cVar = this.C;
                if (cVar != null) {
                    heartLayout.h(g16, bitmap2, qQAppInterface, cVar.a(i16, heartLayout.f236900h), f16 - x.c(heartLayout.getContext(), 20.0f), f17 - x.c(heartLayout.getContext(), 120.0f), x.c(heartLayout.getContext(), 75.0f), x.c(heartLayout.getContext(), 65.0f));
                    return;
                } else {
                    heartLayout.e(g16, bitmap2, f16, f17);
                    return;
                }
            }
            heartLayout.e(g16, g16.f260240h, f16, f17);
            return;
        }
        if (!z16) {
            heartLayout.d(bitmap, f16, f17);
        }
    }

    public void c(boolean z16, boolean z17, Drawable drawable, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17), drawable, resources);
            return;
        }
        Drawable drawable2 = this.f260220i;
        if (z17) {
            drawable2 = e.d(drawable2, resources.getColor(R.color.f157192ku));
        } else if (z16) {
            drawable2 = e.d(drawable2, resources.getColor(R.color.f157195kx));
        }
        Drawable[] drawableArr = this.f260219h;
        if (drawableArr == null) {
            this.f260219h = new Drawable[]{drawable, drawable2};
        } else {
            drawableArr[0] = drawable;
            drawableArr[1] = drawable2;
        }
    }

    @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            return;
        }
        if (this.f260216d % 2 == 0) {
            int i3 = this.f260217e + 1;
            Drawable[] drawableArr = this.f260219h;
            int length = i3 % drawableArr.length;
            this.f260217e = length;
            View view = this.f260218f;
            if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(drawableArr[length]);
            } else {
                view.setBackgroundDrawable(drawableArr[length]);
            }
        }
        int i16 = this.f260216d + 1;
        this.f260216d = i16;
        if (i16 / 2 >= c.f260225d) {
            this.f260218f.clearAnimation();
            this.f260221m = false;
        }
    }
}
