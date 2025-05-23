package com.tencent.mobileqq.zplan.meme.api.impl;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0013\b\u0086\b\u0018\u0000 \u00072\u00020\u0001:\u0001\bB/\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b'\u0010(J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014R\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014R\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010!R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010$R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/api/impl/d;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "targetWidth", "targetHeight", "i", "a", "b", "", h.F, "", "toString", "hashCode", "other", "", "equals", "I", "f", "()I", "index", "", "[B", "g", "()[B", "pixels", "c", "d", "dataWidth", "dataHeight", "e", "frameTime", "Landroid/graphics/Bitmap;", "getTargetWidth", "k", "(I)V", "getTargetHeight", "j", "<init>", "(I[BIII)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.meme.api.impl.d, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class FrameData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int index;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final byte[] pixels;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int dataWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int dataHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int frameTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Bitmap bitmap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int targetWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int targetHeight;

    public FrameData(int i3, byte[] pixels, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        this.index = i3;
        this.pixels = pixels;
        this.dataWidth = i16;
        this.dataHeight = i17;
        this.frameTime = i18;
    }

    private final Bitmap i(Bitmap bitmap, int targetWidth, int targetHeight) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale((targetWidth * 1.0f) / width, (targetHeight * 1.0f) / height);
        Bitmap res = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        if (!Intrinsics.areEqual(bitmap, res) && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        Intrinsics.checkNotNullExpressionValue(res, "res");
        return res;
    }

    public final Bitmap a() {
        int i3;
        if (this.bitmap == null) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(this.dataWidth, this.dataHeight, Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNull(createBitmap);
                createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(this.pixels));
                int i16 = this.targetWidth;
                if (i16 > 0 && (i3 = this.targetHeight) > 0 && (this.dataWidth != i16 || this.dataHeight != i3)) {
                    createBitmap = i(createBitmap, i16, i3);
                }
                this.bitmap = createBitmap;
            } catch (Throwable th5) {
                QLog.e("FrameData", 1, "decodeBitmap error.", th5);
            }
        }
        return this.bitmap;
    }

    /* renamed from: b, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /* renamed from: c, reason: from getter */
    public final int getDataHeight() {
        return this.dataHeight;
    }

    /* renamed from: d, reason: from getter */
    public final int getDataWidth() {
        return this.dataWidth;
    }

    /* renamed from: e, reason: from getter */
    public final int getFrameTime() {
        return this.frameTime;
    }

    /* renamed from: f, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: g, reason: from getter */
    public final byte[] getPixels() {
        return this.pixels;
    }

    public final void h() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    public int hashCode() {
        return (((((((this.index * 31) + Arrays.hashCode(this.pixels)) * 31) + this.dataWidth) * 31) + this.dataHeight) * 31) + this.frameTime;
    }

    public final void j(int i3) {
        this.targetHeight = i3;
    }

    public final void k(int i3) {
        this.targetWidth = i3;
    }

    public String toString() {
        return "FrameData(index=" + this.index + ", pixels=" + Arrays.toString(this.pixels) + ", dataWidth=" + this.dataWidth + ", dataHeight=" + this.dataHeight + ", frameTime=" + this.frameTime + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FrameData)) {
            return false;
        }
        FrameData frameData = (FrameData) other;
        return this.index == frameData.index && Intrinsics.areEqual(this.pixels, frameData.pixels) && this.dataWidth == frameData.dataWidth && this.dataHeight == frameData.dataHeight && this.frameTime == frameData.frameTime;
    }
}
