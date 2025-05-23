package com.tencent.tavcut.rendermodel.transform;

import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.tavcut.composition.model.component.Quat;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.Vec3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003\u001a*\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u0003\u001a\u001a\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003\u001a\u0012\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0003\u001a\u0012\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0003\u00a8\u0006\u0011"}, d2 = {"anchor", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "left", "", "right", "top", "bottom", "offset", CanvasView.ACTION_ROTATE, "degree", "scale", BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, "transitionY", "y", "transtionX", HippyTKDListViewAdapter.X, "lib_tavcut_model_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class ScreenTransFromExtKt {
    @NotNull
    public static final ScreenTransform anchor(@NotNull ScreenTransform anchor, float f16, float f17, float f18, float f19) {
        ScreenTransform copy;
        Intrinsics.checkParameterIsNotNull(anchor, "$this$anchor");
        copy = anchor.copy((r36 & 1) != 0 ? anchor.entityId : null, (r36 & 2) != 0 ? anchor.componentID : null, (r36 & 4) != 0 ? anchor.enabled : null, (r36 & 8) != 0 ? anchor.type : null, (r36 & 16) != 0 ? anchor.anchor : new Rect(f16, f18, f17, f19, null, 16, null), (r36 & 32) != 0 ? anchor.offset : null, (r36 & 64) != 0 ? anchor.pivot : null, (r36 & 128) != 0 ? anchor.ePinToEdge : null, (r36 & 256) != 0 ? anchor.eFixSize : null, (r36 & 512) != 0 ? anchor.eEditingMode : null, (r36 & 1024) != 0 ? anchor.eKeepRatio : null, (r36 & 2048) != 0 ? anchor.position : null, (r36 & 4096) != 0 ? anchor.rotation : null, (r36 & 8192) != 0 ? anchor.scale : null, (r36 & 16384) != 0 ? anchor.euler : null, (r36 & 32768) != 0 ? anchor.objectEnabled : null, (r36 & 65536) != 0 ? anchor.version : null, (r36 & 131072) != 0 ? anchor.unknownFields() : null);
        return copy;
    }

    @NotNull
    public static final ScreenTransform offset(@NotNull ScreenTransform offset, float f16, float f17, float f18, float f19) {
        ScreenTransform copy;
        Intrinsics.checkParameterIsNotNull(offset, "$this$offset");
        copy = offset.copy((r36 & 1) != 0 ? offset.entityId : null, (r36 & 2) != 0 ? offset.componentID : null, (r36 & 4) != 0 ? offset.enabled : null, (r36 & 8) != 0 ? offset.type : null, (r36 & 16) != 0 ? offset.anchor : null, (r36 & 32) != 0 ? offset.offset : new Rect(f16, f18, f17, f19, null, 16, null), (r36 & 64) != 0 ? offset.pivot : null, (r36 & 128) != 0 ? offset.ePinToEdge : null, (r36 & 256) != 0 ? offset.eFixSize : null, (r36 & 512) != 0 ? offset.eEditingMode : null, (r36 & 1024) != 0 ? offset.eKeepRatio : null, (r36 & 2048) != 0 ? offset.position : null, (r36 & 4096) != 0 ? offset.rotation : null, (r36 & 8192) != 0 ? offset.scale : null, (r36 & 16384) != 0 ? offset.euler : null, (r36 & 32768) != 0 ? offset.objectEnabled : null, (r36 & 65536) != 0 ? offset.version : null, (r36 & 131072) != 0 ? offset.unknownFields() : null);
        return copy;
    }

    @NotNull
    public static final ScreenTransform rotate(@NotNull ScreenTransform rotate, float f16) {
        ScreenTransform copy;
        Intrinsics.checkParameterIsNotNull(rotate, "$this$rotate");
        double radians = (float) Math.toRadians(f16 / 2);
        copy = rotate.copy((r36 & 1) != 0 ? rotate.entityId : null, (r36 & 2) != 0 ? rotate.componentID : null, (r36 & 4) != 0 ? rotate.enabled : null, (r36 & 8) != 0 ? rotate.type : null, (r36 & 16) != 0 ? rotate.anchor : null, (r36 & 32) != 0 ? rotate.offset : null, (r36 & 64) != 0 ? rotate.pivot : null, (r36 & 128) != 0 ? rotate.ePinToEdge : null, (r36 & 256) != 0 ? rotate.eFixSize : null, (r36 & 512) != 0 ? rotate.eEditingMode : null, (r36 & 1024) != 0 ? rotate.eKeepRatio : null, (r36 & 2048) != 0 ? rotate.position : null, (r36 & 4096) != 0 ? rotate.rotation : new Quat(0.0f, 0.0f, (float) Math.sin(radians), (float) Math.cos(radians), null, 16, null), (r36 & 8192) != 0 ? rotate.scale : null, (r36 & 16384) != 0 ? rotate.euler : null, (r36 & 32768) != 0 ? rotate.objectEnabled : null, (r36 & 65536) != 0 ? rotate.version : null, (r36 & 131072) != 0 ? rotate.unknownFields() : null);
        return copy;
    }

    @NotNull
    public static final ScreenTransform scale(@NotNull ScreenTransform scale, float f16) {
        ScreenTransform copy;
        Intrinsics.checkParameterIsNotNull(scale, "$this$scale");
        copy = scale.copy((r36 & 1) != 0 ? scale.entityId : null, (r36 & 2) != 0 ? scale.componentID : null, (r36 & 4) != 0 ? scale.enabled : null, (r36 & 8) != 0 ? scale.type : null, (r36 & 16) != 0 ? scale.anchor : null, (r36 & 32) != 0 ? scale.offset : null, (r36 & 64) != 0 ? scale.pivot : null, (r36 & 128) != 0 ? scale.ePinToEdge : null, (r36 & 256) != 0 ? scale.eFixSize : null, (r36 & 512) != 0 ? scale.eEditingMode : null, (r36 & 1024) != 0 ? scale.eKeepRatio : null, (r36 & 2048) != 0 ? scale.position : null, (r36 & 4096) != 0 ? scale.rotation : null, (r36 & 8192) != 0 ? scale.scale : new Vec3(f16, f16, 1.0f, null, 8, null), (r36 & 16384) != 0 ? scale.euler : null, (r36 & 32768) != 0 ? scale.objectEnabled : null, (r36 & 65536) != 0 ? scale.version : null, (r36 & 131072) != 0 ? scale.unknownFields() : null);
        return copy;
    }

    @NotNull
    public static final ScreenTransform transitionY(@NotNull ScreenTransform transitionY, float f16) {
        ScreenTransform copy;
        ScreenTransform copy2;
        Intrinsics.checkParameterIsNotNull(transitionY, "$this$transitionY");
        if (f16 < 0) {
            copy2 = transitionY.copy((r36 & 1) != 0 ? transitionY.entityId : null, (r36 & 2) != 0 ? transitionY.componentID : null, (r36 & 4) != 0 ? transitionY.enabled : null, (r36 & 8) != 0 ? transitionY.type : null, (r36 & 16) != 0 ? transitionY.anchor : new Rect(0.0f, 0.0f, 0.0f, f16, null, 16, null), (r36 & 32) != 0 ? transitionY.offset : null, (r36 & 64) != 0 ? transitionY.pivot : null, (r36 & 128) != 0 ? transitionY.ePinToEdge : null, (r36 & 256) != 0 ? transitionY.eFixSize : null, (r36 & 512) != 0 ? transitionY.eEditingMode : null, (r36 & 1024) != 0 ? transitionY.eKeepRatio : null, (r36 & 2048) != 0 ? transitionY.position : null, (r36 & 4096) != 0 ? transitionY.rotation : null, (r36 & 8192) != 0 ? transitionY.scale : null, (r36 & 16384) != 0 ? transitionY.euler : null, (r36 & 32768) != 0 ? transitionY.objectEnabled : null, (r36 & 65536) != 0 ? transitionY.version : null, (r36 & 131072) != 0 ? transitionY.unknownFields() : null);
            return copy2;
        }
        copy = transitionY.copy((r36 & 1) != 0 ? transitionY.entityId : null, (r36 & 2) != 0 ? transitionY.componentID : null, (r36 & 4) != 0 ? transitionY.enabled : null, (r36 & 8) != 0 ? transitionY.type : null, (r36 & 16) != 0 ? transitionY.anchor : new Rect(0.0f, f16, 0.0f, 0.0f, null, 16, null), (r36 & 32) != 0 ? transitionY.offset : null, (r36 & 64) != 0 ? transitionY.pivot : null, (r36 & 128) != 0 ? transitionY.ePinToEdge : null, (r36 & 256) != 0 ? transitionY.eFixSize : null, (r36 & 512) != 0 ? transitionY.eEditingMode : null, (r36 & 1024) != 0 ? transitionY.eKeepRatio : null, (r36 & 2048) != 0 ? transitionY.position : null, (r36 & 4096) != 0 ? transitionY.rotation : null, (r36 & 8192) != 0 ? transitionY.scale : null, (r36 & 16384) != 0 ? transitionY.euler : null, (r36 & 32768) != 0 ? transitionY.objectEnabled : null, (r36 & 65536) != 0 ? transitionY.version : null, (r36 & 131072) != 0 ? transitionY.unknownFields() : null);
        return copy;
    }

    @NotNull
    public static final ScreenTransform transtionX(@NotNull ScreenTransform transtionX, float f16) {
        ScreenTransform copy;
        ScreenTransform copy2;
        Intrinsics.checkParameterIsNotNull(transtionX, "$this$transtionX");
        if (f16 < 0) {
            copy2 = transtionX.copy((r36 & 1) != 0 ? transtionX.entityId : null, (r36 & 2) != 0 ? transtionX.componentID : null, (r36 & 4) != 0 ? transtionX.enabled : null, (r36 & 8) != 0 ? transtionX.type : null, (r36 & 16) != 0 ? transtionX.anchor : new Rect(f16, 0.0f, 0.0f, 0.0f, null, 16, null), (r36 & 32) != 0 ? transtionX.offset : null, (r36 & 64) != 0 ? transtionX.pivot : null, (r36 & 128) != 0 ? transtionX.ePinToEdge : null, (r36 & 256) != 0 ? transtionX.eFixSize : null, (r36 & 512) != 0 ? transtionX.eEditingMode : null, (r36 & 1024) != 0 ? transtionX.eKeepRatio : null, (r36 & 2048) != 0 ? transtionX.position : null, (r36 & 4096) != 0 ? transtionX.rotation : null, (r36 & 8192) != 0 ? transtionX.scale : null, (r36 & 16384) != 0 ? transtionX.euler : null, (r36 & 32768) != 0 ? transtionX.objectEnabled : null, (r36 & 65536) != 0 ? transtionX.version : null, (r36 & 131072) != 0 ? transtionX.unknownFields() : null);
            return copy2;
        }
        copy = transtionX.copy((r36 & 1) != 0 ? transtionX.entityId : null, (r36 & 2) != 0 ? transtionX.componentID : null, (r36 & 4) != 0 ? transtionX.enabled : null, (r36 & 8) != 0 ? transtionX.type : null, (r36 & 16) != 0 ? transtionX.anchor : new Rect(0.0f, 0.0f, f16, 0.0f, null, 16, null), (r36 & 32) != 0 ? transtionX.offset : null, (r36 & 64) != 0 ? transtionX.pivot : null, (r36 & 128) != 0 ? transtionX.ePinToEdge : null, (r36 & 256) != 0 ? transtionX.eFixSize : null, (r36 & 512) != 0 ? transtionX.eEditingMode : null, (r36 & 1024) != 0 ? transtionX.eKeepRatio : null, (r36 & 2048) != 0 ? transtionX.position : null, (r36 & 4096) != 0 ? transtionX.rotation : null, (r36 & 8192) != 0 ? transtionX.scale : null, (r36 & 16384) != 0 ? transtionX.euler : null, (r36 & 32768) != 0 ? transtionX.objectEnabled : null, (r36 & 65536) != 0 ? transtionX.version : null, (r36 & 131072) != 0 ? transtionX.unknownFields() : null);
        return copy;
    }

    @NotNull
    public static final ScreenTransform scale(@NotNull ScreenTransform scale, float f16, float f17) {
        ScreenTransform copy;
        Intrinsics.checkParameterIsNotNull(scale, "$this$scale");
        copy = scale.copy((r36 & 1) != 0 ? scale.entityId : null, (r36 & 2) != 0 ? scale.componentID : null, (r36 & 4) != 0 ? scale.enabled : null, (r36 & 8) != 0 ? scale.type : null, (r36 & 16) != 0 ? scale.anchor : null, (r36 & 32) != 0 ? scale.offset : null, (r36 & 64) != 0 ? scale.pivot : null, (r36 & 128) != 0 ? scale.ePinToEdge : null, (r36 & 256) != 0 ? scale.eFixSize : null, (r36 & 512) != 0 ? scale.eEditingMode : null, (r36 & 1024) != 0 ? scale.eKeepRatio : null, (r36 & 2048) != 0 ? scale.position : null, (r36 & 4096) != 0 ? scale.rotation : null, (r36 & 8192) != 0 ? scale.scale : new Vec3(f16, f17, 1.0f, null, 8, null), (r36 & 16384) != 0 ? scale.euler : null, (r36 & 32768) != 0 ? scale.objectEnabled : null, (r36 & 65536) != 0 ? scale.version : null, (r36 & 131072) != 0 ? scale.unknownFields() : null);
        return copy;
    }
}
