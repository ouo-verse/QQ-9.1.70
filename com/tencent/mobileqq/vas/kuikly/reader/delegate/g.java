package com.tencent.mobileqq.vas.kuikly.reader.delegate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u00062\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016R$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/g;", "Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/a;", "", "width", "height", "", "d", "", "c", "Landroid/graphics/Canvas;", "a", "b", PM.CANVAS, "draw", "recycle", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Canvas;", "getCanvas", "()Landroid/graphics/Canvas;", "setCanvas", "(Landroid/graphics/Canvas;)V", "getWidth", "()I", "getHeight", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class g extends a {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final d f309921e = new d(2);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap bitmap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Canvas canvas;

    private final boolean c(int width, int height) {
        Bitmap bitmap = this.bitmap;
        Intrinsics.checkNotNull(bitmap);
        if (bitmap.getAllocationByteCount() >= width * height * 4) {
            return true;
        }
        return false;
    }

    private final void d(int width, int height) {
        if (width > 0 && height > 0) {
            if (this.bitmap == null) {
                this.bitmap = c.f309915a.d(width, height);
            }
            Bitmap bitmap = this.bitmap;
            Intrinsics.checkNotNull(bitmap);
            if (bitmap.getWidth() == width) {
                Bitmap bitmap2 = this.bitmap;
                Intrinsics.checkNotNull(bitmap2);
                if (bitmap2.getHeight() == height) {
                    return;
                }
            }
            if (c(width, height)) {
                Bitmap bitmap3 = this.bitmap;
                Intrinsics.checkNotNull(bitmap3);
                bitmap3.reconfigure(width, height, Bitmap.Config.ARGB_8888);
            } else {
                c cVar = c.f309915a;
                Bitmap bitmap4 = this.bitmap;
                Intrinsics.checkNotNull(bitmap4);
                cVar.e(bitmap4);
                this.bitmap = cVar.d(width, height);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.e
    @NotNull
    public Canvas a(int width, int height) {
        d(width, height);
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
        Canvas a16 = f309921e.a();
        a16.setBitmap(this.bitmap);
        this.canvas = a16;
        Intrinsics.checkNotNull(a16);
        return a16;
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.a, com.tencent.mobileqq.vas.kuikly.reader.delegate.e
    public void b() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            bitmap.prepareToDraw();
        }
        super.b();
        d dVar = f309921e;
        Canvas canvas = this.canvas;
        Intrinsics.checkNotNull(canvas);
        dVar.b(canvas);
        this.canvas = null;
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.e
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Bitmap bitmap = this.bitmap;
        if (bitmap == null) {
            return;
        }
        Intrinsics.checkNotNull(bitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.e
    public int getHeight() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            return bitmap.getHeight();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.e
    public int getWidth() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            return bitmap.getWidth();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.a, com.tencent.mobileqq.vas.kuikly.reader.delegate.e
    public void recycle() {
        super.recycle();
        Bitmap bitmap = this.bitmap;
        if (bitmap == null) {
            return;
        }
        c.f309915a.e(bitmap);
        this.bitmap = null;
    }
}
