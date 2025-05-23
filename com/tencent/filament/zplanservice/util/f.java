package com.tencent.filament.zplanservice.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.io.Closeable;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u001b\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ \u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J/\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0002\b\u000fJ\u0012\u0010\u0014\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0015\u001a\u00020\u000eH\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00028\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/filament/zplanservice/util/f;", "Landroid/view/View;", "V", "Ljava/io/Closeable;", "", "width", "height", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "b", "newWidth", "newHeight", h.F, "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "a", "Ljava/nio/ByteBuffer;", "inputBuffer", "c", "close", "d", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "e", "Landroid/view/View;", "view", "g", "()I", "<init>", "(Landroid/view/View;)V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class f<V extends View> implements Closeable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Bitmap bitmap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private V view;

    public f(@NotNull V view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    private final Bitmap b(int width, int height) {
        return Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
    }

    public static /* synthetic */ ByteBuffer d(f fVar, ByteBuffer byteBuffer, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            byteBuffer = null;
        }
        return fVar.c(byteBuffer);
    }

    private final Bitmap h(int newWidth, int newHeight) {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null && bitmap.getWidth() == newWidth && bitmap.getHeight() == newHeight) {
            return bitmap;
        }
        if (bitmap == null) {
            Bitmap newBitmap = b(newWidth, newHeight);
            this.bitmap = newBitmap;
            Intrinsics.checkNotNullExpressionValue(newBitmap, "newBitmap");
            return newBitmap;
        }
        try {
            bitmap.reconfigure(newWidth, newHeight, Bitmap.Config.ARGB_8888);
            return bitmap;
        } catch (IllegalArgumentException unused) {
            bitmap.recycle();
            Bitmap newBitmap2 = b(newWidth, newHeight);
            this.bitmap = newBitmap2;
            Intrinsics.checkNotNullExpressionValue(newBitmap2, "newBitmap");
            return newBitmap2;
        }
    }

    public final void a(int newWidth, int newHeight, @NotNull Function1<? super V, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (newWidth > 0 && newHeight > 0) {
            h(newWidth, newHeight);
        }
        V v3 = this.view;
        if (newWidth <= 0) {
            newWidth = -2;
        }
        if (newHeight <= 0) {
            newHeight = -2;
        }
        v3.setLayoutParams(new ViewGroup.LayoutParams(newWidth, newHeight));
        block.invoke(this.view);
    }

    @NotNull
    public final ByteBuffer c(@Nullable ByteBuffer inputBuffer) {
        int g16;
        int e16;
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (layoutParams != null) {
            g16 = layoutParams.width;
        } else {
            g16 = g();
        }
        ViewGroup.LayoutParams layoutParams2 = this.view.getLayoutParams();
        if (layoutParams2 != null) {
            e16 = layoutParams2.height;
        } else {
            e16 = e();
        }
        this.view.measure(g16, e16);
        if (g16 <= 0) {
            g16 = Math.max(this.view.getMeasuredWidth() + 2, 3);
        }
        if (e16 <= 0) {
            e16 = Math.max(this.view.getMeasuredHeight() + 2, 3);
        }
        this.view.layout(0, 0, g16, e16);
        Bitmap h16 = h(g16, e16);
        h16.eraseColor(0);
        Canvas canvas = new Canvas(h16);
        canvas.translate(1.0f, 1.0f);
        canvas.clipRect(0, 0, g16 - 2, e16 - 2);
        this.view.draw(canvas);
        if (inputBuffer == null || h16.getByteCount() > inputBuffer.remaining()) {
            inputBuffer = ByteBuffer.allocate(h16.getByteCount());
        }
        h16.copyPixelsToBuffer(inputBuffer);
        Intrinsics.checkNotNullExpressionValue(inputBuffer, "buffer");
        return inputBuffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    public final int e() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            return bitmap.getHeight();
        }
        return 0;
    }

    public final int g() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            return bitmap.getWidth();
        }
        return 0;
    }
}
