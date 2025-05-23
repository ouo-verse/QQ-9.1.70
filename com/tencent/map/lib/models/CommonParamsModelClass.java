package com.tencent.map.lib.models;

import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngListDeserializer;
import cooperation.qzone.report.QZonePushReporter;
import java.util.List;

/* loaded from: classes9.dex */
public class CommonParamsModelClass {

    /* loaded from: classes9.dex */
    public static class AmbientLightParams extends JsonComposer {

        @Json(name = "color")
        public MonoColorParams color;

        @Json(name = "intensity")
        public float intensity;
    }

    /* loaded from: classes9.dex */
    public static class AnimationInfo extends JsonComposer {

        @Json(name = "duration")
        float duration;

        @Json(name = "index")
        int index;

        @Json(name = "name")
        String name;

        public AnimationInfo(int i3, String str, float f16) {
            this.index = i3;
            this.name = str;
            this.duration = f16;
        }
    }

    /* loaded from: classes9.dex */
    public static class DirectionalParams extends JsonComposer {

        /* renamed from: x, reason: collision with root package name */
        @Json(name = HippyTKDListViewAdapter.X)
        public float f147582x;

        /* renamed from: y, reason: collision with root package name */
        @Json(name = "y")
        public float f147583y;

        /* renamed from: z, reason: collision with root package name */
        @Json(name = QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW)
        public float f147584z;
    }

    /* loaded from: classes9.dex */
    public static class EnableClickParams extends JsonComposer {

        @Json(name = NodeProps.ENABLED)
        public boolean enabled;
    }

    /* loaded from: classes9.dex */
    public static class EnableUnlitParams extends JsonComposer {

        @Json(name = NodeProps.ENABLED)
        public boolean enabled;
    }

    /* loaded from: classes9.dex */
    public static class ExposureParams extends JsonComposer {

        @Json(name = QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE)
        public float exposure;
    }

    /* loaded from: classes9.dex */
    public static class MaterialVariantIndexParams extends JsonComposer {

        @Json(name = "index")
        public int variantIndex;
    }

    /* loaded from: classes9.dex */
    public static class MaterialVariantInfo extends JsonComposer {

        @Json(name = "name")
        public String variantName;
    }

    /* loaded from: classes9.dex */
    public static class MaterialVariantsInfoParams extends JsonComposer {

        @Json(name = "materialVariantsInfo")
        public List<MaterialVariantInfo> materialVariantInfoList;
    }

    /* loaded from: classes9.dex */
    public static class MonoColorParams extends JsonComposer {

        /* renamed from: b, reason: collision with root package name */
        @Json(name = "b")
        public float f147585b;

        /* renamed from: g, reason: collision with root package name */
        @Json(name = "g")
        public float f147586g;

        /* renamed from: r, reason: collision with root package name */
        @Json(name = "r")
        public float f147587r;
    }

    /* loaded from: classes9.dex */
    public static class PixelBoundParams extends JsonComposer {

        @Json(name = "height")
        public int height;

        @Json(name = "width")
        public int width;
    }

    /* loaded from: classes9.dex */
    public static class PlaySkeletonAnimationParams extends JsonComposer {

        @Json(name = "index")
        public int index;

        @Json(name = "repeat")
        public boolean repeat;

        @Json(name = "speed")
        public float speed;
    }

    /* loaded from: classes9.dex */
    public static class PositionParams extends JsonComposer {

        @Json(name = "altitude")
        public double altitude;

        @Json(name = QCircleSchemeAttr.Polymerize.LAT)
        public double lat;

        @Json(name = "lng")
        public double lng;
    }

    /* loaded from: classes9.dex */
    public static class RotationParams extends JsonComposer {

        @Json(name = BasicAnimation.KeyPath.ROTATION_X)
        public float rotationX;

        @Json(name = BasicAnimation.KeyPath.ROTATION_Y)
        public float rotationY;

        @Json(name = "rotationZ")
        public float rotationZ;
    }

    /* loaded from: classes9.dex */
    public static class ScaleParams extends JsonComposer {

        @Json(name = "scale")
        public float scale;
    }

    /* loaded from: classes9.dex */
    public static class SkeletonAnimationParams extends JsonComposer {

        @Json(name = "animationInfo")
        List<AnimationInfo> animationInfoList;
    }

    /* loaded from: classes9.dex */
    public static class SpotOrDirectionalLightParams extends JsonComposer {

        @Json(name = "color")
        public MonoColorParams color;

        @Json(name = "direction")
        public DirectionalParams direction;

        @Json(name = "intensity")
        public float intensity;

        @Json(name = "type")
        public int type;
    }

    /* loaded from: classes9.dex */
    public static class StartTranslateAnimationParams extends JsonComposer {

        @Json(name = "duration")
        public float duration;

        @Json(name = "initRotation")
        public float initRotation;

        @Json(name = "needRotate")
        public boolean needRotate;

        @Json(deserializer = LatLngListDeserializer.class, name = "positions")
        public List<LatLng> positions;
    }

    /* loaded from: classes9.dex */
    public static class VisibleParams extends JsonComposer {

        @Json(name = "isVisible")
        public boolean isVisible;
    }

    /* loaded from: classes9.dex */
    public static class ZoomLevelRangeParams extends JsonComposer {

        @Json(name = "maxLevel")
        public int maxLevel;

        @Json(name = "minLevel")
        public int minLevel;
    }
}
