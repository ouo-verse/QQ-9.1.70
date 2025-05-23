package com.tencent.ecommerce.biz.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/util/a;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "dstWidth", "dstHeight", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f104864a = new a();

    a() {
    }

    public final Bitmap a(Bitmap bitmap, int dstWidth, int dstHeight) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(dstWidth / width, dstHeight / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
