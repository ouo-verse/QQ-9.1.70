package com.tencent.qqlive.tvkplayer.api.postprocess.effect.video;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKVRFx extends ITVKVideoFx {
    public static final String VR_CONFIG_KEY = "vr_config";
    public static final String VR_ROTATE_KEY = "vr_rotate";
    public static final String VR_ROTATE_X = "vr_rotate_x";
    public static final String VR_ROTATE_Y = "vr_rotate_y";
    public static final String VR_ROTATE_Z = "vr_rotate_z";
    public static final String VR_VIEW_PATTERN_KEY = "vr_view_pattern";

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface VRViewPattern {
        public static final int VISION_BINOCULAR = 2;
        public static final int VISION_MONOCULAR = 1;
    }

    void doRotate(float f16, float f17, float f18) throws IllegalStateException;

    void enableSensor(boolean z16) throws IllegalStateException;

    void setVRConfig(Map<String, String> map) throws IllegalStateException;

    void setVrViewPattern(int i3) throws IllegalStateException;
}
