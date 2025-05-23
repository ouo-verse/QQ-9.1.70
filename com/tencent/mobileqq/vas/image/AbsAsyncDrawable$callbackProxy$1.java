package com.tencent.mobileqq.vas.image;

import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016R\"\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\b\u0010\u0011R\"\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/vas/image/AbsAsyncDrawable$callbackProxy$1", "Landroid/graphics/drawable/Drawable$Callback;", "Landroid/graphics/drawable/Drawable;", "who", "Ljava/lang/Runnable;", "what", "", "unscheduleDrawable", "d", "invalidateDrawable", "", "time", "scheduleDrawable", "", "I", "b", "()I", "(I)V", "lastWidth", "e", "a", "c", "lastHeight", "vas_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class AbsAsyncDrawable$callbackProxy$1 implements Drawable.Callback {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int lastWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int lastHeight;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ AbsAsyncDrawable f309578f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsAsyncDrawable$callbackProxy$1(AbsAsyncDrawable absAsyncDrawable) {
        this.f309578f = absAsyncDrawable;
    }

    /* renamed from: a, reason: from getter */
    public final int getLastHeight() {
        return this.lastHeight;
    }

    /* renamed from: b, reason: from getter */
    public final int getLastWidth() {
        return this.lastWidth;
    }

    public final void c(int i3) {
        this.lastHeight = i3;
    }

    public final void d(int i3) {
        this.lastWidth = i3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NotNull final Drawable d16) {
        Intrinsics.checkNotNullParameter(d16, "d");
        final Drawable.Callback callback = this.f309578f.getCallback();
        if (callback != null) {
            final AbsAsyncDrawable absAsyncDrawable = this.f309578f;
            absAsyncDrawable.postUITask(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.image.AbsAsyncDrawable$callbackProxy$1$invalidateDrawable$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    callback.invalidateDrawable(absAsyncDrawable);
                    if (absAsyncDrawable.getRequestLayoutAfterDrawableChange()) {
                        Drawable.Callback callback2 = callback;
                        if (!(callback2 instanceof View) || ((View) callback2).getLayoutParams() == null) {
                            return;
                        }
                        if ((((View) callback).getLayoutParams().width != -2 && ((View) callback).getLayoutParams().height != -2) || this.getLastWidth() == d16.getIntrinsicWidth() || this.getLastHeight() == d16.getIntrinsicHeight()) {
                            return;
                        }
                        this.d(d16.getIntrinsicWidth());
                        this.c(d16.getIntrinsicHeight());
                        ((View) callback).requestLayout();
                    }
                }
            });
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NotNull Drawable who, @NotNull Runnable what, long time) {
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        Drawable.Callback callback = this.f309578f.getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this.f309578f, what, time);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NotNull Drawable who, @NotNull Runnable what) {
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        Drawable.Callback callback = this.f309578f.getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this.f309578f, what);
        }
    }
}
