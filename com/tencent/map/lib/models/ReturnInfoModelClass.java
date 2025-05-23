package com.tencent.map.lib.models;

import com.tencent.map.lib.models.CommonParamsModelClass;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ReturnInfoModelClass {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class BaseBooleanReturnInfo extends ReturnStatus {
        public boolean value;

        public BaseBooleanReturnInfo(boolean z16) {
            this.status = "success";
            this.value = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class BaseFloatReturnInfo extends ReturnStatus {
        public float value;

        public BaseFloatReturnInfo(float f16) {
            this.status = "success";
            this.value = f16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class BaseIntReturnInfo extends ReturnStatus {
        public int value;

        public BaseIntReturnInfo(int i3) {
            this.status = "success";
            this.value = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class BaseStringReturnInfo extends ReturnStatus {
        public String value;

        public BaseStringReturnInfo(String str) {
            this.status = "success";
            this.value = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class ErrorReturnInfo extends ReturnStatus {
        public int errorCode;
        public String errorMsg;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public enum ErrorMsg {
            success(0, "none"),
            jsonparse(1, "json parse error"),
            unsupported(2, "unsupported function"),
            internal(3, VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_INTERNAL_ERROR),
            invalidparam(4, "invalid param error");

            private int errorCode;
            private String errorMsg;

            ErrorMsg(int i3, String str) {
                this.errorCode = i3;
                this.errorMsg = str;
            }

            public final ErrorMsg bindErrorMsg(String str) {
                this.errorMsg += APLogFileUtil.SEPARATOR_LOG + str;
                return this;
            }

            public final int getErrorCode() {
                return this.errorCode;
            }

            public final String getErrorMsg() {
                return this.errorMsg;
            }
        }

        public ErrorReturnInfo(ErrorMsg errorMsg) {
            this.status = "failed";
            this.errorCode = errorMsg.getErrorCode();
            this.errorMsg = errorMsg.getErrorMsg();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class MaterialVariantsReturnInfo extends ReturnStatus {
        public CommonParamsModelClass.MaterialVariantsInfoParams value;

        public MaterialVariantsReturnInfo(List<CommonParamsModelClass.MaterialVariantInfo> list) {
            CommonParamsModelClass.MaterialVariantsInfoParams materialVariantsInfoParams = new CommonParamsModelClass.MaterialVariantsInfoParams();
            this.value = materialVariantsInfoParams;
            materialVariantsInfoParams.materialVariantInfoList = list;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class PositionReturnInfo extends ReturnStatus {
        public CommonParamsModelClass.PositionParams value;

        public PositionReturnInfo(LatLng latLng) {
            CommonParamsModelClass.PositionParams positionParams = new CommonParamsModelClass.PositionParams();
            this.value = positionParams;
            positionParams.lat = latLng.latitude;
            positionParams.lng = latLng.longitude;
            positionParams.altitude = latLng.altitude;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class ReturnStatus extends JsonComposer {
        public String status = "success";
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class RotationReturnInfo extends ReturnStatus {
        public CommonParamsModelClass.RotationParams value;

        public RotationReturnInfo(float f16, float f17, float f18) {
            CommonParamsModelClass.RotationParams rotationParams = new CommonParamsModelClass.RotationParams();
            this.value = rotationParams;
            rotationParams.rotationX = f16;
            rotationParams.rotationY = f17;
            rotationParams.rotationZ = f18;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SkeletonAnimationReturnInfo extends ReturnStatus {
        public CommonParamsModelClass.SkeletonAnimationParams value;

        public SkeletonAnimationReturnInfo(List<CommonParamsModelClass.AnimationInfo> list) {
            CommonParamsModelClass.SkeletonAnimationParams skeletonAnimationParams = new CommonParamsModelClass.SkeletonAnimationParams();
            this.value = skeletonAnimationParams;
            skeletonAnimationParams.animationInfoList = list == null ? new ArrayList<>() : list;
        }
    }
}
