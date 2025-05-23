package com.tencent.mobileqq.proavatar.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.avatar.layer.c;
import com.tencent.qqnt.avatar.meta.transform.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ5\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0014\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/proavatar/transform/CircleAvatarTransform;", "Lcom/tencent/qqnt/avatar/meta/transform/b;", "Landroid/graphics/Bitmap;", "source", "d", "e", "Lcom/tencent/qqnt/avatar/meta/b;", "avatarBean", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "avatarInfoArr", "", "a", "(Lcom/tencent/qqnt/avatar/meta/b;[Lcom/tencent/qqnt/avatar/meta/info/a;)Z", "bitmapArr", "b", "(Lcom/tencent/qqnt/avatar/meta/b;[Lcom/tencent/qqnt/avatar/meta/info/a;[Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "Lkotlin/Lazy;", "f", "()Z", "fixSwitch", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class CircleAvatarTransform implements com.tencent.qqnt.avatar.meta.transform.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy fixSwitch;

    public CircleAvatarTransform() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(CircleAvatarTransform$fixSwitch$2.INSTANCE);
            this.fixSwitch = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Bitmap d(Bitmap source) {
        int coerceAtMost;
        if (!f()) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(source.getWidth(), source.getHeight());
            Bitmap circle = Bitmap.createBitmap(coerceAtMost, coerceAtMost, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(circle);
            Paint paint = new Paint();
            RectF rectF = new RectF(0.0f, 0.0f, source.getWidth(), source.getHeight());
            Path path = new Path();
            path.addArc(rectF, 0.0f, 360.0f);
            canvas.clipPath(path);
            canvas.drawBitmap(source, (Rect) null, rectF, paint);
            Intrinsics.checkNotNullExpressionValue(circle, "circle");
            return circle;
        }
        return e(source);
    }

    private final Bitmap e(Bitmap source) {
        int coerceAtMost;
        Rect rect;
        Rect rect2;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(source.getWidth(), source.getHeight());
        Bitmap circle = Bitmap.createBitmap(coerceAtMost, coerceAtMost, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(circle);
        Paint paint = new Paint();
        float f16 = coerceAtMost;
        RectF rectF = new RectF(0.0f, 0.0f, f16, f16);
        Path path = new Path();
        path.addArc(rectF, 0.0f, 360.0f);
        canvas.clipPath(path);
        if (source.getHeight() == source.getWidth()) {
            rect2 = new Rect(0, 0, source.getWidth(), source.getWidth());
        } else {
            if (source.getHeight() > source.getWidth()) {
                int height = (source.getHeight() - source.getWidth()) / 2;
                rect = new Rect(0, height, source.getWidth(), source.getWidth() + height);
            } else {
                int width = (source.getWidth() - source.getHeight()) / 2;
                rect = new Rect(width, 0, source.getHeight() + width, source.getHeight());
            }
            rect2 = rect;
        }
        canvas.drawBitmap(source, rect2, rectF, paint);
        Intrinsics.checkNotNullExpressionValue(circle, "circle");
        return circle;
    }

    private final boolean f() {
        return ((Boolean) this.fixSwitch.getValue()).booleanValue();
    }

    @Override // com.tencent.qqnt.avatar.meta.transform.b
    public boolean a(@NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @NotNull com.tencent.qqnt.avatar.meta.info.a[] avatarInfoArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) avatarBean, (Object) avatarInfoArr)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Intrinsics.checkNotNullParameter(avatarInfoArr, "avatarInfoArr");
        return avatarBean.n();
    }

    @Override // com.tencent.qqnt.avatar.meta.transform.b
    @Nullable
    public Bitmap b(@NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @NotNull com.tencent.qqnt.avatar.meta.info.a[] avatarInfoArr, @NotNull Bitmap[] bitmapArr) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, avatarBean, avatarInfoArr, bitmapArr);
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Intrinsics.checkNotNullParameter(avatarInfoArr, "avatarInfoArr");
        Intrinsics.checkNotNullParameter(bitmapArr, "bitmapArr");
        if (bitmapArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        return d(bitmapArr[0]);
    }

    @Override // com.tencent.qqnt.avatar.meta.transform.b
    @Nullable
    public c c(@NotNull com.tencent.qqnt.avatar.meta.b bVar, @NotNull com.tencent.qqnt.avatar.meta.info.a[] aVarArr, @NotNull Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, this, bVar, aVarArr, bitmap);
        }
        return b.a.a(this, bVar, aVarArr, bitmap);
    }
}
