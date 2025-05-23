package com.tencent.map.lib.models;

import com.tencent.map.lib.models.CommonParamsModelClass;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

/* compiled from: P */
/* loaded from: classes9.dex */
public class CommandFunctionModelClass {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class BaseCommandFunction extends JsonComposer {

        @Json(name = "function")
        public String commandFunction;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class EnableClickCommand extends BaseCommandFunction {

        @Json(name = "params")
        public CommonParamsModelClass.EnableClickParams params;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class EnableUnlitCommand extends BaseCommandFunction {

        @Json(name = "params")
        public CommonParamsModelClass.EnableUnlitParams params;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class ErrorCommandFunction extends BaseCommandFunction {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class GetClickEnabledCommand extends BaseCommandFunction {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class GetCurrentMaterialVariantCommand extends BaseCommandFunction {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class GetExposureCommand extends BaseCommandFunction {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class GetMaterialVariantsCommand extends BaseCommandFunction {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class GetPositionCommand extends BaseCommandFunction {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class GetRotationCommand extends BaseCommandFunction {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class GetScaleCommand extends BaseCommandFunction {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class GetSkeletonAnimationInfoCommand extends BaseCommandFunction {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class GetTypeCommand extends BaseCommandFunction {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class GetUnlitEnabledCommand extends BaseCommandFunction {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class GetVisibleCommand extends BaseCommandFunction {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class PlaySkeletonAnimationCommand extends BaseCommandFunction {

        @Json(name = "params")
        public CommonParamsModelClass.PlaySkeletonAnimationParams params;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class ResetColorCommand extends BaseCommandFunction {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SetAmbientLightCommand extends BaseCommandFunction {

        @Json(name = "params")
        public CommonParamsModelClass.AmbientLightParams params;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SetExposureCommand extends BaseCommandFunction {

        @Json(name = "params")
        public CommonParamsModelClass.ExposureParams params;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SetMaterialVariantCommand extends BaseCommandFunction {

        @Json(name = "params")
        public CommonParamsModelClass.MaterialVariantIndexParams params;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SetMonoColorCommand extends BaseCommandFunction {

        @Json(name = "params")
        public CommonParamsModelClass.MonoColorParams params;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SetPixelBoundCommand extends BaseCommandFunction {

        @Json(name = "params")
        public CommonParamsModelClass.PixelBoundParams params;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SetPositionCommand extends BaseCommandFunction {

        @Json(name = "params")
        public CommonParamsModelClass.PositionParams params;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SetRotationCommand extends BaseCommandFunction {

        @Json(name = "params")
        public CommonParamsModelClass.RotationParams params;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SetScaleCommand extends BaseCommandFunction {

        @Json(name = "params")
        public CommonParamsModelClass.ScaleParams params;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SetSpotOrDirectionalLightCommand extends BaseCommandFunction {

        @Json(name = "params")
        public CommonParamsModelClass.SpotOrDirectionalLightParams params;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SetVisibleCommand extends BaseCommandFunction {

        @Json(name = "params")
        public CommonParamsModelClass.VisibleParams params;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SetZoomLevelRangeCommand extends BaseCommandFunction {

        @Json(name = "params")
        public CommonParamsModelClass.ZoomLevelRangeParams params;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class StartTranslateAnimationCommand extends BaseCommandFunction {

        @Json(name = "params")
        public CommonParamsModelClass.StartTranslateAnimationParams params;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class StopSkeletonAnimationCommand extends BaseCommandFunction {
    }
}
