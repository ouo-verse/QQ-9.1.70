package com.tencent.mobileqq.profilecard.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J6\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/profilecard/utils/CoverBlurUtil;", "", "()V", "TAG", "", "blur", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "inputBitmap", "radius", "", "scale", "", Element.ELEMENT_NAME_TIMES, "drawableToBitmap", "drawable", "Landroid/graphics/drawable/Drawable;", "reSizeBitmap", MimeHelper.IMAGE_SUBTYPE_BITMAP, "targetWidth", "targetHeight", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class CoverBlurUtil {
    public static final CoverBlurUtil INSTANCE = new CoverBlurUtil();
    private static final String TAG = "CoverFeedBlurUtil";

    CoverBlurUtil() {
    }

    public static /* synthetic */ Bitmap blur$default(CoverBlurUtil coverBlurUtil, Context context, Bitmap bitmap, float f16, int i3, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            f16 = 25.0f;
        }
        return coverBlurUtil.blur(context, bitmap, f16, (i17 & 8) != 0 ? 1 : i3, (i17 & 16) != 0 ? 1 : i16);
    }

    public final Bitmap blur(Context context, Bitmap inputBitmap, float radius, int scale, int times) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inputBitmap, "inputBitmap");
        try {
            QLog.d(TAG, 1, "blur, start times: " + times);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(inputBitmap, inputBitmap.getWidth() / scale, inputBitmap.getHeight() / scale, false);
            RenderScript create = RenderScript.create(context);
            for (int i3 = 0; i3 < times; i3++) {
                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, android.renderscript.Element.U8_4(create));
                create2.setRadius(radius);
                create2.setInput(createFromBitmap);
                create2.forEach(createTyped);
                createTyped.copyTo(createScaledBitmap);
                createFromBitmap.destroy();
                createTyped.destroy();
                create2.destroy();
            }
            create.destroy();
            QLog.d(TAG, 1, "blur, end ");
            return Bitmap.createScaledBitmap(createScaledBitmap, createScaledBitmap.getWidth() * scale, createScaledBitmap.getHeight() * scale, true);
        } catch (Error e16) {
            QLog.w(TAG, 1, "blur, error", e16);
            return null;
        }
    }

    public final Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap.Config config;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    public final Bitmap reSizeBitmap(Bitmap bitmap, float targetWidth, float targetHeight) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(targetWidth / width, targetHeight / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
