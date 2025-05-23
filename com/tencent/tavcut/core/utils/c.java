package com.tencent.tavcut.core.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.util.Log;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.gyailib.library.GYTrackStickerInfo;
import com.tencent.filter.GLSLRender;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.tavcut.core.render.log.TavLogger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.bean.Texture;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.Quat;
import org.light.lightAssetKit.components.Rect;
import org.light.lightAssetKit.components.ScreenTransform;
import org.light.lightAssetKit.components.TimeOffset;
import org.light.lightAssetKit.components.Vec3;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a(\u0010\n\u001a\u0004\u0018\u00010\u00002\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0005j\b\u0012\u0004\u0012\u00020\u0000`\u00062\u0006\u0010\t\u001a\u00020\b\u001a\u0010\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000b\u001a\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b\u001a(\u0010\u0016\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\b\u001a\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017\u001a\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/gyailib/library/GYTrackStickerInfo;", "stickerInfo", "Lorg/light/lightAssetKit/components/Rect;", "b", "a", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "stickerTrackerResult", "", "targetTime", "e", "Lorg/light/lightAssetKit/Entity;", "entity", "Lorg/light/lightAssetKit/components/ScreenTransform;", "g", "Lorg/light/lightAssetKit/components/TimeOffset;", "f", "stickerTransform", "", "imageWidth", "imageHeight", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "c", "Lorg/light/bean/Texture;", "input", "Landroid/graphics/Bitmap;", h.F, "d", "lib_tavcut_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class c {
    @NotNull
    public static final Rect a(@NotNull GYTrackStickerInfo stickerInfo) {
        Intrinsics.checkParameterIsNotNull(stickerInfo, "stickerInfo");
        float f16 = stickerInfo.f35991w / 2.0f;
        float f17 = stickerInfo.f35990h / 2.0f;
        return new Rect(-f17, -f16, f16, f17);
    }

    @NotNull
    public static final Rect b(@NotNull GYTrackStickerInfo stickerInfo) {
        Intrinsics.checkParameterIsNotNull(stickerInfo, "stickerInfo");
        float f16 = stickerInfo.f35991w;
        if (f16 == 0.0f) {
            return new Rect(2.0f, -2.0f, -2.0f, 2.0f);
        }
        float f17 = stickerInfo.f35992x + (f16 / 2.0f);
        float f18 = stickerInfo.imageW;
        float f19 = stickerInfo.imageH;
        float f26 = (f17 - (f18 / 2.0f)) / (f18 / 2.0f);
        float f27 = (((f19 / 2.0f) - stickerInfo.f35993y) - (stickerInfo.f35990h / 2.0f)) / (f19 / 2.0f);
        return new Rect(f27, f26, f26, f27);
    }

    @Nullable
    public static final GYTrackStickerInfo c(@NotNull ScreenTransform stickerTransform, int i3, int i16, long j3) {
        Float f16;
        Float f17;
        Intrinsics.checkParameterIsNotNull(stickerTransform, "stickerTransform");
        GYTrackStickerInfo gYTrackStickerInfo = new GYTrackStickerInfo();
        Rect offset = stickerTransform.getOffset();
        Rect anchor = stickerTransform.getAnchor();
        Vec3 scale = stickerTransform.getScale();
        if (scale != null) {
            f16 = Float.valueOf(scale.f423832x);
        } else {
            f16 = null;
        }
        if (f16 == null) {
            Intrinsics.throwNpe();
        }
        float floatValue = f16.floatValue();
        Vec3 scale2 = stickerTransform.getScale();
        if (scale2 != null) {
            f17 = Float.valueOf(scale2.f423833y);
        } else {
            f17 = null;
        }
        if (f17 == null) {
            Intrinsics.throwNpe();
        }
        float floatValue2 = f17.floatValue();
        if (offset != null && anchor != null) {
            TavLogger.i("TavAssetCreator", "convertStickerTransform2StickerInfo anchor " + anchor + " offsetRect " + offset + " scaleX " + floatValue);
            float f18 = (float) i3;
            float f19 = (anchor.left * f18) / 2.0f;
            float f26 = (float) i16;
            float f27 = (anchor.top * f26) / 2.0f;
            float f28 = (float) 2;
            float f29 = (-offset.left) * f28 * floatValue;
            float f36 = offset.top * f28 * floatValue2;
            gYTrackStickerInfo.f35991w = f29;
            gYTrackStickerInfo.f35990h = f36;
            gYTrackStickerInfo.f35992x = ((f18 / 2.0f) + f19) - (f29 / 2.0f);
            gYTrackStickerInfo.f35993y = ((f26 / 2.0f) - f27) - (f36 / 2.0f);
            Quat rotation = stickerTransform.getRotation();
            if (rotation == null) {
                gYTrackStickerInfo.radian = 0.0f;
            } else {
                gYTrackStickerInfo.radian = b.f374339a.c(rotation).f423834z * 57.29578f;
            }
            gYTrackStickerInfo.imageW = f18;
            gYTrackStickerInfo.imageH = f26;
            gYTrackStickerInfo.timestamp = j3;
            return gYTrackStickerInfo;
        }
        Log.e("TavAssetCreator", "convertStickerTransform2StickerInfo legal data: offset null");
        return null;
    }

    @NotNull
    public static final Bitmap d(@NotNull Bitmap input) {
        Intrinsics.checkParameterIsNotNull(input, "input");
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, -1.0f);
        Bitmap flipBitmap = Bitmap.createBitmap(input, 0, 0, input.getWidth(), input.getHeight(), matrix, true);
        Intrinsics.checkExpressionValueIsNotNull(flipBitmap, "flipBitmap");
        return flipBitmap;
    }

    @Nullable
    public static final GYTrackStickerInfo e(@NotNull ArrayList<GYTrackStickerInfo> stickerTrackerResult, long j3) {
        Intrinsics.checkParameterIsNotNull(stickerTrackerResult, "stickerTrackerResult");
        if (stickerTrackerResult.isEmpty()) {
            return null;
        }
        int size = stickerTrackerResult.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (stickerTrackerResult.get(i3).timestamp >= j3) {
                int i16 = i3 - 1;
                if (i16 < 0) {
                    return stickerTrackerResult.get(i3);
                }
                if (Math.abs(stickerTrackerResult.get(i3).timestamp - j3) < Math.abs(stickerTrackerResult.get(i16).timestamp - j3)) {
                    return stickerTrackerResult.get(i3);
                }
                return stickerTrackerResult.get(i16);
            }
        }
        return null;
    }

    @Nullable
    public static final TimeOffset f(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        Collection<Component> components = entity.getComponents();
        Intrinsics.checkExpressionValueIsNotNull(components, "components");
        for (Component component : components) {
            if (component instanceof TimeOffset) {
                return (TimeOffset) component;
            }
        }
        return null;
    }

    @Nullable
    public static final ScreenTransform g(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        Collection<Component> components = entity.getComponents();
        Intrinsics.checkExpressionValueIsNotNull(components, "components");
        for (Component component : components) {
            if (component instanceof ScreenTransform) {
                return (ScreenTransform) component;
            }
        }
        return null;
    }

    @NotNull
    public static final Bitmap h(@NotNull Texture input) {
        Intrinsics.checkParameterIsNotNull(input, "input");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(input.width * input.height * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        allocateDirect.rewind();
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, input.f423804id, 0);
        GLES20.glReadPixels(0, 0, input.width, input.height, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        Bitmap bitmap = Bitmap.createBitmap(input.width, input.height, Bitmap.Config.ARGB_8888);
        allocateDirect.rewind();
        bitmap.copyPixelsFromBuffer(allocateDirect);
        Intrinsics.checkExpressionValueIsNotNull(bitmap, "bitmap");
        return bitmap;
    }
}
