package com.tencent.mobileqq.wink.editor.filter;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.tavcut.core.render.thumb.IThumbProvider;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.Rect;
import org.light.lightAssetKit.components.Size;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/filter/i;", "", "Lcom/tencent/tavcut/core/render/thumb/IThumbProvider;", "a", "Landroid/graphics/Bitmap;", "tempBitmap", "d", "", "atTimeUs", "b", "", "c", "Lcom/tencent/mobileqq/wink/editor/filter/a;", "Lcom/tencent/mobileqq/wink/editor/filter/a;", "getClipSourceWithSize", "()Lcom/tencent/mobileqq/wink/editor/filter/a;", "clipSourceWithSize", "Lcom/tencent/tavcut/core/render/thumb/IThumbProvider;", "thumbProvider", "<init>", "(Lcom/tencent/mobileqq/wink/editor/filter/a;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a clipSourceWithSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IThumbProvider thumbProvider;

    public i(@NotNull a clipSourceWithSize) {
        Intrinsics.checkNotNullParameter(clipSourceWithSize, "clipSourceWithSize");
        this.clipSourceWithSize = clipSourceWithSize;
        this.thumbProvider = a();
    }

    private final IThumbProvider a() {
        try {
            Result.Companion companion = Result.INSTANCE;
            return rd4.c.f431135f.i(this.clipSourceWithSize.getClipSource(), new Size((int) this.clipSourceWithSize.getSize().width, (int) this.clipSourceWithSize.getSize().height));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
            ms.a.c("SmartFilterFrameExtractor", "generateThumbProvider() error");
            return rd4.c.f431135f.i(this.clipSourceWithSize.getClipSource(), new Size(200, 200));
        }
    }

    private final Bitmap d(Bitmap tempBitmap) {
        int coerceAtMost;
        int coerceAtMost2;
        Matrix matrix = new Matrix();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(200, tempBitmap.getWidth());
        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(200, tempBitmap.getHeight());
        matrix.postScale(coerceAtMost / tempBitmap.getWidth(), coerceAtMost2 / tempBitmap.getHeight());
        return Bitmap.createBitmap(tempBitmap, 0, 0, tempBitmap.getWidth(), tempBitmap.getHeight(), matrix, true);
    }

    @Nullable
    public final Bitmap b(long atTimeUs) {
        float coerceAtLeast;
        float coerceAtLeast2;
        int coerceAtMost;
        int coerceAtMost2;
        Bitmap thumbAtTime = this.thumbProvider.getThumbAtTime(atTimeUs);
        if (thumbAtTime == null) {
            return null;
        }
        Rect clipRect = this.clipSourceWithSize.getClipSource().getClipRect();
        if (clipRect != null) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(clipRect.left, 0.0f);
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(clipRect.top, 0.0f);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost((int) (clipRect.right - clipRect.left), thumbAtTime.getWidth());
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost((int) (clipRect.bottom - clipRect.top), thumbAtTime.getHeight());
            Bitmap tempBitmap = Bitmap.createBitmap(thumbAtTime, (int) coerceAtLeast, (int) coerceAtLeast2, coerceAtMost, coerceAtMost2);
            ms.a.f("SmartFilterFrameExtractor", "original bitmap.recycle() error");
            Intrinsics.checkNotNullExpressionValue(tempBitmap, "tempBitmap");
            return d(tempBitmap);
        }
        return d(thumbAtTime);
    }

    public final void c() {
        this.thumbProvider.release();
    }
}
