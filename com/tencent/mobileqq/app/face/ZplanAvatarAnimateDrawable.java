package com.tencent.mobileqq.app.face;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0002)*B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0018J\b\u0010\u001d\u001a\u00020\bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\rJ\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0014J\u000e\u0010$\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u000bJ\b\u0010'\u001a\u00020\u0018H\u0016J\b\u0010(\u001a\u00020\u0018H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/app/face/ZplanAvatarAnimateDrawable;", "Landroid/graphics/drawable/BitmapDrawable;", "Landroid/graphics/drawable/Animatable;", "res", "Landroid/content/res/Resources;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "isHideAvatar", "", "(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Z)V", "animateDuration", "", "avatarAnimatorListener", "Lcom/tencent/mobileqq/app/face/ZplanAvatarAnimateDrawable$AvatarAnimatorListener;", "avatarDismissValueAnimator", "Landroid/animation/ValueAnimator;", "currentBounds", "Landroid/graphics/Rect;", "parentCallback", "Lmqq/util/WeakReference;", "Landroid/graphics/drawable/Drawable;", "scale", "", "draw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "hideAvatar", "invalidateParentDrawable", "isRunning", "onBoundsChange", "bounds", "setAvatarAnimatorListener", "listener", "setParentCallback", "drawable", "setScale", "showAvatar", "inputAnimateDuration", "start", "stop", "AvatarAnimatorListener", "Companion", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class ZplanAvatarAnimateDrawable extends BitmapDrawable implements Animatable {
    static IPatchRedirector $redirector_ = null;
    public static final int ALPHA_MAX = 255;
    public static final long ANIMATION_DURATION_DEFAULT = 250;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int SCALE_MAX = 100;

    @NotNull
    public static final String TAG = "ZplanAvatarAnimateDrawable";
    private long animateDuration;

    @Nullable
    private AvatarAnimatorListener avatarAnimatorListener;

    @Nullable
    private ValueAnimator avatarDismissValueAnimator;

    @NotNull
    private Rect currentBounds;
    private boolean isHideAvatar;

    @Nullable
    private WeakReference<Drawable> parentCallback;
    private int scale;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/app/face/ZplanAvatarAnimateDrawable$AvatarAnimatorListener;", "", "onShowComplete", "", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public interface AvatarAnimatorListener {
        void onShowComplete();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/app/face/ZplanAvatarAnimateDrawable$Companion;", "", "()V", "ALPHA_MAX", "", "ANIMATION_DURATION_DEFAULT", "", "SCALE_MAX", "TAG", "", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/app/face/ZplanAvatarAnimateDrawable$a", "Landroid/animation/Animator$AnimatorListener;", "", "a", "Landroid/animation/Animator;", "animation", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ZplanAvatarAnimateDrawable.this);
            }
        }

        private final void a() {
            if (ZplanAvatarAnimateDrawable.this.scale != 100 || ZplanAvatarAnimateDrawable.this.getAlpha() != 255) {
                ZplanAvatarAnimateDrawable.this.scale = 100;
                ZplanAvatarAnimateDrawable.this.setAlpha(255);
                ZplanAvatarAnimateDrawable.this.invalidateParentDrawable();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            a();
            AvatarAnimatorListener avatarAnimatorListener = ZplanAvatarAnimateDrawable.this.avatarAnimatorListener;
            if (avatarAnimatorListener != null) {
                avatarAnimatorListener.onShowComplete();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            a();
            AvatarAnimatorListener avatarAnimatorListener = ZplanAvatarAnimateDrawable.this.avatarAnimatorListener;
            if (avatarAnimatorListener != null) {
                avatarAnimatorListener.onShowComplete();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29817);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ ZplanAvatarAnimateDrawable(Resources resources, Bitmap bitmap, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(resources, bitmap, (i3 & 4) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, resources, bitmap, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$1$lambda$0(ZplanAvatarAnimateDrawable this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.invalidateParentDrawable();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.isHideAvatar) {
            return;
        }
        int i3 = this.scale;
        boolean z16 = false;
        if (i3 >= 0 && i3 < 100) {
            z16 = true;
        }
        if (z16) {
            float f16 = i3 / 100.0f;
            canvas.save();
            canvas.scale(f16, f16, getBounds().width() * 0.5f, getBounds().height());
            super.draw(canvas);
            canvas.restore();
            return;
        }
        super.draw(canvas);
    }

    public final void hideAvatar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "hideAvatar, drawable hash: " + hashCode() + ", isHideAvatar: " + this.isHideAvatar);
        if (this.isHideAvatar) {
            return;
        }
        this.isHideAvatar = true;
        invalidateParentDrawable();
    }

    public final void invalidateParentDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        WeakReference<Drawable> weakReference = this.parentCallback;
        if (weakReference != null) {
            Intrinsics.checkNotNull(weakReference);
            Drawable drawable = weakReference.get();
            if (drawable != null) {
                drawable.invalidateSelf();
                return;
            } else {
                QLog.e(TAG, 1, "onUpdate get is null ");
                return;
            }
        }
        QLog.e(TAG, 1, "onUpdate parentCallback is null ");
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        ValueAnimator valueAnimator = this.avatarDismissValueAnimator;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(@Nullable Rect bounds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bounds);
            return;
        }
        if (bounds != null && !Intrinsics.areEqual(this.currentBounds, bounds)) {
            this.currentBounds.set(bounds);
            if (isRunning()) {
                QLog.e(TAG, 1, "onBoundsChange stop");
                stop();
            }
        }
    }

    public final void setAvatarAnimatorListener(@Nullable AvatarAnimatorListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) listener);
        } else {
            this.avatarAnimatorListener = listener;
        }
    }

    public final void setParentCallback(@NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
        } else {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            this.parentCallback = new WeakReference<>(drawable);
        }
    }

    public final void setScale(int scale) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, scale);
        } else {
            this.scale = scale;
        }
    }

    public final void showAvatar(long inputAnimateDuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, inputAnimateDuration);
            return;
        }
        QLog.i(TAG, 1, "showAvatar, drawable hash: " + hashCode() + ", isHideAvatar: " + this.isHideAvatar);
        if (!this.isHideAvatar) {
            return;
        }
        this.isHideAvatar = false;
        if (inputAnimateDuration > 0) {
            this.animateDuration = inputAnimateDuration;
            start();
        } else {
            invalidateParentDrawable();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        long j3 = this.animateDuration;
        if (j3 > 0) {
            ValueAnimator valueAnimator = this.avatarDismissValueAnimator;
            if (valueAnimator != null) {
                valueAnimator.setDuration(j3);
            }
            ValueAnimator valueAnimator2 = this.avatarDismissValueAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.start();
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ValueAnimator valueAnimator = this.avatarDismissValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
    }

    public ZplanAvatarAnimateDrawable(@Nullable Resources resources, @Nullable Bitmap bitmap, boolean z16) {
        super(resources, bitmap);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, resources, bitmap, Boolean.valueOf(z16));
            return;
        }
        this.isHideAvatar = z16;
        this.scale = 100;
        this.currentBounds = new Rect();
        this.animateDuration = 250L;
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("scale", 0, 100);
        Intrinsics.checkNotNullExpressionValue(ofInt, "ofInt(\"scale\", 0, SCALE_MAX)");
        PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt(com.tencent.luggage.wxa.c8.c.f123400v, 0, 255);
        Intrinsics.checkNotNullExpressionValue(ofInt2, "ofInt(\"alpha\", 0, ALPHA_MAX)");
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, ofInt, ofInt2);
        this.avatarDismissValueAnimator = ofPropertyValuesHolder;
        if (ofPropertyValuesHolder != null) {
            ofPropertyValuesHolder.setStartDelay(0L);
            long j3 = this.animateDuration;
            ofPropertyValuesHolder.setDuration(j3 > 0 ? j3 : 250L);
            ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.app.face.m
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ZplanAvatarAnimateDrawable.lambda$1$lambda$0(ZplanAvatarAnimateDrawable.this, valueAnimator);
                }
            });
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(0);
            ofPropertyValuesHolder.setInterpolator(new AccelerateDecelerateInterpolator());
            ofPropertyValuesHolder.addListener(new a());
        }
    }
}
