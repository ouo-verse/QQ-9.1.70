package com.tencent.mobileqq.proavatar.mask;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.proavatar.c;
import com.tencent.mobileqq.proavatar.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.avatar.layer.d;
import com.tencent.qqnt.avatar.meta.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017JX\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/proavatar/mask/a;", "Lcom/tencent/mobileqq/proavatar/c;", "Lcom/tencent/qqnt/avatar/layer/d;", "", "curLayer", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Rect;", "bounds", "Landroid/graphics/Paint;", "paint", "Lcom/tencent/mobileqq/proavatar/k;", "viewConfig", "Lkotlin/Function0;", "", "drawSelf", "drawableInvalidateSelf", "", "a", "Landroid/graphics/Path;", "Landroid/graphics/Path;", "clipPath", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path clipPath;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.clipPath = new Path();
        }
    }

    @Override // com.tencent.mobileqq.proavatar.c
    public boolean a(@NotNull d<? extends Object> curLayer, @NotNull Canvas canvas, @NotNull Rect bounds, @Nullable Paint paint, @Nullable k viewConfig, @NotNull Function0<Unit> drawSelf, @NotNull Function0<Unit> drawableInvalidateSelf) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, curLayer, canvas, bounds, paint, viewConfig, drawSelf, drawableInvalidateSelf)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(curLayer, "curLayer");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(drawSelf, "drawSelf");
        Intrinsics.checkNotNullParameter(drawableInvalidateSelf, "drawableInvalidateSelf");
        float width = bounds.width();
        float height = bounds.height();
        if (width > 0.0f && height > 0.0f) {
            if ((curLayer.b() instanceof com.tencent.mobileqq.proavatar.a) && (curLayer.d() instanceof URLDrawable)) {
                canvas.save();
                this.clipPath.reset();
                this.clipPath.addArc(0.0f, 0.0f, width, height, 0.0f, 360.0f);
                canvas.clipPath(this.clipPath);
                drawSelf.invoke();
                canvas.restore();
                return true;
            }
            if ((curLayer.b() instanceof b) && (curLayer.d() instanceof Bitmap)) {
                Object d16 = curLayer.d();
                Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type android.graphics.Bitmap");
                Bitmap bitmap = (Bitmap) d16;
                if (bitmap.getWidth() <= 10 || bitmap.getHeight() <= 10) {
                    canvas.save();
                    this.clipPath.reset();
                    this.clipPath.addArc(0.0f, 0.0f, width, height, 0.0f, 360.0f);
                    canvas.clipPath(this.clipPath);
                    drawSelf.invoke();
                    canvas.restore();
                    return true;
                }
            }
        }
        return false;
    }
}
