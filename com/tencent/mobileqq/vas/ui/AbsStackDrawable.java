package com.tencent.mobileqq.vas.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 *2\u00020\u0001:\u0001*B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0014J(\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H&J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J(\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0016J\u0012\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010!\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/AbsStackDrawable;", "Landroid/graphics/drawable/Drawable;", "drawableStack", "", "(Ljava/util/List;)V", "callbackProxy", "Landroid/graphics/drawable/Drawable$Callback;", "getCallbackProxy", "()Landroid/graphics/drawable/Drawable$Callback;", "draw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "getIntrinsicHeight", "", "getIntrinsicWidth", "getOpacity", "getPadding", "", "padding", "Landroid/graphics/Rect;", "onBoundsChange", "bounds", "onDraw", "setAlpha", com.tencent.luggage.wxa.c8.c.f123400v, "setBounds", "left", "top", "right", "bottom", "setColorFilter", CustomAnimation.KeyPath.COLOR_FILTER, "Landroid/graphics/ColorFilter;", "color", "mode", "Landroid/graphics/PorterDuff$Mode;", "setVisible", NodeProps.VISIBLE, "restart", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public abstract class AbsStackDrawable extends Drawable {

    @NotNull
    public static final String TAG = "AbsAsyncDrawable";

    @NotNull
    private final Drawable.Callback callbackProxy;

    @NotNull
    private final List<Drawable> drawableStack;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/ui/AbsStackDrawable$a", "Landroid/graphics/drawable/Drawable$Callback;", "Landroid/graphics/drawable/Drawable;", "who", "Ljava/lang/Runnable;", "what", "", "unscheduleDrawable", "d", "invalidateDrawable", "", "time", "scheduleDrawable", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NotNull Drawable d16) {
            Intrinsics.checkNotNullParameter(d16, "d");
            Drawable.Callback callback = AbsStackDrawable.this.getCallback();
            if (callback != null) {
                callback.invalidateDrawable(AbsStackDrawable.this);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NotNull Drawable who, @NotNull Runnable what, long time) {
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
            Drawable.Callback callback = AbsStackDrawable.this.getCallback();
            if (callback != null) {
                callback.scheduleDrawable(AbsStackDrawable.this, what, time);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NotNull Drawable who, @NotNull Runnable what) {
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
            Drawable.Callback callback = AbsStackDrawable.this.getCallback();
            if (callback != null) {
                callback.unscheduleDrawable(AbsStackDrawable.this, what);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbsStackDrawable(@NotNull List<? extends Drawable> drawableStack) {
        Intrinsics.checkNotNullParameter(drawableStack, "drawableStack");
        this.drawableStack = drawableStack;
        this.callbackProxy = new a();
        Iterator it = drawableStack.iterator();
        while (it.hasNext()) {
            ((Drawable) it.next()).setCallback(this.callbackProxy);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        onDraw(canvas, this.drawableStack, getBounds());
    }

    @NotNull
    protected final Drawable.Callback getCallbackProxy() {
        return this.callbackProxy;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.drawableStack.get(0).getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.drawableStack.get(0).getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.drawableStack.get(0).getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.drawableStack.get(0).getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NotNull Rect padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        return this.drawableStack.get(0).getPadding(padding);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@Nullable Rect bounds) {
        if (bounds != null) {
            Iterator<T> it = this.drawableStack.iterator();
            while (it.hasNext()) {
                ((Drawable) it.next()).setBounds(bounds);
            }
        }
        super.onBoundsChange(bounds);
    }

    public abstract void onDraw(@NotNull Canvas canvas, @NotNull List<? extends Drawable> drawableStack, @Nullable Rect bounds);

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        Iterator<T> it = this.drawableStack.iterator();
        while (it.hasNext()) {
            ((Drawable) it.next()).setAlpha(alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int left, int top, int right, int bottom) {
        Iterator<T> it = this.drawableStack.iterator();
        while (it.hasNext()) {
            ((Drawable) it.next()).setBounds(left, top, right, bottom);
        }
        super.setBounds(left, top, right, bottom);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Iterator<T> it = this.drawableStack.iterator();
        while (it.hasNext()) {
            ((Drawable) it.next()).setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        Iterator<T> it = this.drawableStack.iterator();
        while (it.hasNext()) {
            ((Drawable) it.next()).setVisible(visible, restart);
        }
        return super.setVisible(visible, restart);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int color, @NotNull PorterDuff.Mode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Iterator<T> it = this.drawableStack.iterator();
        while (it.hasNext()) {
            ((Drawable) it.next()).setColorFilter(color, mode);
        }
    }
}
