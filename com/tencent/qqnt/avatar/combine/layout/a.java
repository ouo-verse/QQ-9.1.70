package com.tencent.qqnt.avatar.combine.layout;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import androidx.annotation.IntRange;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.avatar.business.bitmap.layout.b;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017JU\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\f\u0010\rJ;\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J?\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0004H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/avatar/combine/layout/a;", "Lcom/tencent/qqnt/avatar/business/bitmap/layout/b;", "", "size", "", "Lkotlin/Pair;", "", "subSize", "gap", "gapColor", "Landroid/graphics/Bitmap;", "bitmaps", "b", "(I[Lkotlin/Pair;II[Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "count", "a", "(III)[Lkotlin/Pair;", "bimaps", "c", "(III[Landroid/graphics/Bitmap;)[Landroid/graphics/Bitmap;", "Lcom/tencent/qqnt/avatar/business/bitmap/layout/b;", "delegateLayoutManager", "<init>", "()V", "avatar_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b delegateLayoutManager;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.delegateLayoutManager = new com.tencent.qqnt.avatar.business.bitmap.layout.a();
        }
    }

    @Override // com.tencent.qqnt.avatar.business.bitmap.layout.b
    @NotNull
    public Pair<Float, Float>[] a(@IntRange(from = 2, to = 4) int size, int gap, int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair[]) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(size), Integer.valueOf(gap), Integer.valueOf(count));
        }
        return this.delegateLayoutManager.a(size, gap, count);
    }

    @Override // com.tencent.qqnt.avatar.business.bitmap.layout.b
    @Nullable
    public Bitmap b(int size, @NotNull Pair<Float, Float>[] subSize, int gap, int gapColor, @Nullable Bitmap[] bitmaps) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(size), subSize, Integer.valueOf(gap), Integer.valueOf(gapColor), bitmaps);
        }
        Intrinsics.checkNotNullParameter(subSize, "subSize");
        Bitmap createBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap b16 = this.delegateLayoutManager.b(size, subSize, gap, gapColor, bitmaps);
        if (b16 != null) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(b16, tileMode, tileMode));
            float f16 = size / 2.0f;
            canvas.drawCircle(f16, f16, f16, paint);
        }
        return createBitmap;
    }

    @Override // com.tencent.qqnt.avatar.business.bitmap.layout.b
    @NotNull
    public Bitmap[] c(int size, int gap, int count, @NotNull Bitmap[] bimaps) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap[]) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(size), Integer.valueOf(gap), Integer.valueOf(count), bimaps);
        }
        Intrinsics.checkNotNullParameter(bimaps, "bimaps");
        return this.delegateLayoutManager.c(size, gap, count, bimaps);
    }
}
