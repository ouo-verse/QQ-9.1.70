package com.tencent.mm.ui.widget.edittext;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.animation.LinearInterpolator;
import android.widget.Magnifier;
import androidx.annotation.RequiresApi;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b)\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001dR\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001dR\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u001d\u00a8\u0006+"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/MagnifierMotionAnimator;", "", "", HippyTKDListViewAdapter.X, "y", "", "show", "dismiss", "Landroid/widget/Magnifier;", "a", "Landroid/widget/Magnifier;", "getMMagnifier", "()Landroid/widget/Magnifier;", "setMMagnifier", "(Landroid/widget/Magnifier;)V", "mMagnifier", "Landroid/animation/ValueAnimator;", "b", "Landroid/animation/ValueAnimator;", "mAnimator", "", "c", "Z", "getMMagnifierIsShowing", "()Z", "setMMagnifierIsShowing", "(Z)V", "mMagnifierIsShowing", "d", UserInfo.SEX_FEMALE, "mAnimationStartX", "e", "mAnimationStartY", "f", "mAnimationCurrentX", "g", "mAnimationCurrentY", tl.h.F, "mLastX", "i", "mLastY", "<init>", "Companion", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class MagnifierMotionAnimator {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Magnifier mMagnifier;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ValueAnimator mAnimator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean mMagnifierIsShowing;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public float mAnimationStartX;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public float mAnimationStartY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public float mAnimationCurrentX;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public float mAnimationCurrentY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public float mLastX;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public float mLastY;

    public MagnifierMotionAnimator(@NotNull Magnifier mMagnifier) {
        Intrinsics.checkNotNullParameter(mMagnifier, "mMagnifier");
        this.mMagnifier = mMagnifier;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(0f, 1f)");
        this.mAnimator = ofFloat;
        ofFloat.setDuration(100L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mm.ui.widget.edittext.MagnifierMotionAnimator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(@NotNull ValueAnimator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                MagnifierMotionAnimator magnifierMotionAnimator = MagnifierMotionAnimator.this;
                magnifierMotionAnimator.mAnimationCurrentX = magnifierMotionAnimator.mAnimationStartX + ((MagnifierMotionAnimator.this.mLastX - MagnifierMotionAnimator.this.mAnimationStartX) * animation.getAnimatedFraction());
                MagnifierMotionAnimator magnifierMotionAnimator2 = MagnifierMotionAnimator.this;
                magnifierMotionAnimator2.mAnimationCurrentY = magnifierMotionAnimator2.mAnimationStartY + ((MagnifierMotionAnimator.this.mLastY - MagnifierMotionAnimator.this.mAnimationStartY) * animation.getAnimatedFraction());
                if (Build.VERSION.SDK_INT >= 28) {
                    MagnifierMotionAnimator.this.getMMagnifier().show(MagnifierMotionAnimator.this.mAnimationCurrentX, MagnifierMotionAnimator.this.mAnimationCurrentY);
                }
            }
        });
    }

    @RequiresApi(api = 28)
    public final void dismiss() {
        this.mMagnifier.dismiss();
        this.mAnimator.cancel();
        this.mMagnifierIsShowing = false;
    }

    @NotNull
    public final Magnifier getMMagnifier() {
        return this.mMagnifier;
    }

    public final boolean getMMagnifierIsShowing() {
        return this.mMagnifierIsShowing;
    }

    public final void setMMagnifier(@NotNull Magnifier magnifier) {
        Intrinsics.checkNotNullParameter(magnifier, "<set-?>");
        this.mMagnifier = magnifier;
    }

    public final void setMMagnifierIsShowing(boolean z16) {
        this.mMagnifierIsShowing = z16;
    }

    @RequiresApi(api = 28)
    public final void show(float x16, float y16) {
        boolean z16;
        boolean z17 = false;
        if (this.mMagnifierIsShowing) {
            if (y16 == this.mLastY) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = true;
            }
        }
        if (z17) {
            if (this.mAnimator.isRunning()) {
                this.mAnimator.cancel();
                this.mAnimationStartX = this.mAnimationCurrentX;
                this.mAnimationStartY = this.mAnimationCurrentY;
            } else {
                this.mAnimationStartX = this.mLastX;
                this.mAnimationStartY = this.mLastY;
            }
            this.mAnimator.start();
        } else if (!this.mAnimator.isRunning()) {
            this.mMagnifier.show(x16, y16);
        }
        this.mLastX = x16;
        this.mLastY = y16;
        this.mMagnifierIsShowing = true;
    }
}
