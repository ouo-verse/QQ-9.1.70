package com.tencent.kuikly.core.render.android.expand.component;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00104\u001a\u00020\u0001\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\u0006\u001a\u00020\u0003J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J(\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010.\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010-R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u00100R\u0014\u00104\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/HRRotateDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Animatable;", "", "g", tl.h.F, "j", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "start", "stop", "", "isRunning", "", "i", "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "Landroid/graphics/Rect;", "bounds", "setBounds", "left", "top", "right", "bottom", "", "d", "J", "getFrameDuration", "()J", "setFrameDuration", "(J)V", "frameDuration", "", "e", UserInfo.SEX_FEMALE, "f", "()F", "setFrameRotateDeg", "(F)V", "frameRotateDeg", "mCurrentDeg", "Z", "mRunning", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mNextFrame", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/drawable/Drawable;", "imageDrawable", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class HRRotateDrawable extends Drawable implements Animatable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long frameDuration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float frameRotateDeg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mCurrentDeg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mRunning;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Runnable mNextFrame;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Drawable imageDrawable;

    public HRRotateDrawable(@NotNull Drawable imageDrawable) {
        Intrinsics.checkNotNullParameter(imageDrawable, "imageDrawable");
        this.imageDrawable = imageDrawable;
        this.frameDuration = 70L;
        this.frameRotateDeg = 30.0f;
        this.mNextFrame = new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.component.HRRotateDrawable$mNextFrame$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z16;
                float f16;
                float f17;
                z16 = HRRotateDrawable.this.mRunning;
                if (z16) {
                    HRRotateDrawable hRRotateDrawable = HRRotateDrawable.this;
                    f16 = hRRotateDrawable.mCurrentDeg;
                    hRRotateDrawable.mCurrentDeg = f16 + HRRotateDrawable.this.getFrameRotateDeg();
                    f17 = HRRotateDrawable.this.mCurrentDeg;
                    if (f17 > 360.0f - HRRotateDrawable.this.getFrameRotateDeg()) {
                        HRRotateDrawable.this.mCurrentDeg = 0.0f;
                    }
                    HRRotateDrawable.this.invalidateSelf();
                    HRRotateDrawable.this.g();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        scheduleSelf(this.mNextFrame, SystemClock.uptimeMillis() + this.frameDuration);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable drawable = this.imageDrawable;
        Rect bounds = drawable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "drawable.bounds");
        int save = canvas.save();
        canvas.rotate(this.mCurrentDeg, ((bounds.right - bounds.left) * 0.5f) + bounds.left, ((bounds.bottom - bounds.top) * 0.5f) + bounds.top);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    /* renamed from: f, reason: from getter */
    public final float getFrameRotateDeg() {
        return this.frameRotateDeg;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    public final void h() {
        if (!this.mRunning) {
            this.mRunning = true;
            g();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mRunning;
    }

    public final void j() {
        this.mRunning = false;
        unscheduleSelf(this.mNextFrame);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@NotNull Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.setBounds(bounds);
        this.imageDrawable.setBounds(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        this.imageDrawable.setBounds(left, top, right, bottom);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
