package le4;

import android.util.Log;
import com.gyailib.library.GYTrackStickerInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.tavcut.composition.model.component.Quat;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.Vec3;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a(\u0010\f\u001a\u0004\u0018\u00010\u00002\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0007j\b\u0012\u0004\u0012\u00020\u0000`\b2\u0006\u0010\u000b\u001a\u00020\n\u001a\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\r\u001a(\u0010\u0016\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\n\u00a8\u0006\u0017"}, d2 = {"Lcom/gyailib/library/GYTrackStickerInfo;", "stickerInfo", "Lcom/tencent/tavcut/composition/model/component/Rect;", "a", "offsetRect", "Lcom/tencent/tavcut/composition/model/component/Vec3;", "b", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "stickerTrackerResult", "", "targetTime", "d", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "entity", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "e", "stickerTransform", "", "imageWidth", "imageHeight", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "c", "lib_tavcut_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class e {
    @NotNull
    public static final Rect a(@NotNull GYTrackStickerInfo stickerInfo) {
        Intrinsics.checkParameterIsNotNull(stickerInfo, "stickerInfo");
        float f16 = stickerInfo.f35991w;
        if (f16 == 0.0f) {
            return new Rect(-2.0f, 2.0f, -2.0f, 2.0f, null, 16, null);
        }
        float f17 = stickerInfo.f35992x + (f16 / 2.0f);
        float f18 = stickerInfo.imageW;
        float f19 = stickerInfo.imageH;
        float f26 = (f17 - (f18 / 2.0f)) / (f18 / 2.0f);
        float f27 = (((f19 / 2.0f) - stickerInfo.f35993y) - (stickerInfo.f35990h / 2.0f)) / (f19 / 2.0f);
        return new Rect(f26, f27, f26, f27, null, 16, null);
    }

    @NotNull
    public static final Vec3 b(@NotNull Rect offsetRect, @NotNull GYTrackStickerInfo stickerInfo) {
        Intrinsics.checkParameterIsNotNull(offsetRect, "offsetRect");
        Intrinsics.checkParameterIsNotNull(stickerInfo, "stickerInfo");
        float f16 = 2;
        return new Vec3(stickerInfo.f35991w / ((-offsetRect.left) * f16), stickerInfo.f35990h / (offsetRect.top * f16), 1.0f, null, 8, null);
    }

    @Nullable
    public static final GYTrackStickerInfo c(@NotNull ScreenTransform stickerTransform, int i3, int i16, long j3) {
        Float f16;
        Float f17;
        Intrinsics.checkParameterIsNotNull(stickerTransform, "stickerTransform");
        GYTrackStickerInfo gYTrackStickerInfo = new GYTrackStickerInfo();
        Rect rect = stickerTransform.offset;
        Rect rect2 = stickerTransform.anchor;
        Vec3 vec3 = stickerTransform.scale;
        if (vec3 != null) {
            f16 = Float.valueOf(vec3.x);
        } else {
            f16 = null;
        }
        if (f16 == null) {
            Intrinsics.throwNpe();
        }
        float floatValue = f16.floatValue();
        Vec3 vec32 = stickerTransform.scale;
        if (vec32 != null) {
            f17 = Float.valueOf(vec32.y);
        } else {
            f17 = null;
        }
        if (f17 == null) {
            Intrinsics.throwNpe();
        }
        float floatValue2 = f17.floatValue();
        if (rect != null && rect2 != null) {
            ee4.b.e("TavAssetCreator", "convertStickerTransform2StickerInfo anchor " + rect2 + " offsetRect " + rect + " scaleX " + floatValue);
            float f18 = (float) i3;
            float f19 = (rect2.left * f18) / 2.0f;
            float f26 = (float) i16;
            float f27 = (rect2.top * f26) / 2.0f;
            float f28 = (float) 2;
            float f29 = (-rect.left) * f28 * floatValue;
            float f36 = rect.top * f28 * floatValue2;
            gYTrackStickerInfo.f35991w = f29;
            gYTrackStickerInfo.f35990h = f36;
            gYTrackStickerInfo.f35992x = ((f18 / 2.0f) + f19) - (f29 / 2.0f);
            gYTrackStickerInfo.f35993y = ((f26 / 2.0f) - f27) - (f36 / 2.0f);
            Quat quat = stickerTransform.rotation;
            if (quat == null) {
                gYTrackStickerInfo.radian = 0.0f;
            } else {
                gYTrackStickerInfo.radian = d.b(quat).z * 57.29578f;
            }
            gYTrackStickerInfo.imageW = f18;
            gYTrackStickerInfo.imageH = f26;
            gYTrackStickerInfo.timestamp = j3;
            return gYTrackStickerInfo;
        }
        Log.e("TavAssetCreator", "convertStickerTransform2StickerInfo legal data: offset null");
        return null;
    }

    @Nullable
    public static final GYTrackStickerInfo d(@NotNull ArrayList<GYTrackStickerInfo> stickerTrackerResult, long j3) {
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
    public static final ScreenTransform e(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        for (IdentifyComponent identifyComponent : entity.getComponents()) {
            if (identifyComponent.getData() instanceof ScreenTransform) {
                Object data = identifyComponent.getData();
                if (data != null) {
                    return (ScreenTransform) data;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.ScreenTransform");
            }
        }
        return null;
    }
}
