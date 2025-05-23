package com.tencent.youtu.ytposedetect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes27.dex */
public @interface PoseDetectResultCode {
    public static final int FACE_QUALITY_DELETE_FAILED = -1025;
    public static final int FACE_QUALITY_EYE_CLOSE = -1031;
    public static final int FACE_QUALITY_KEEP = -1026;
    public static final int FACE_QUALITY_MOUTH_OPEN = -1032;
    public static final int FACE_QUALITY_SHAKING = -1033;
    public static final int FACE_QUALITY_STATUS_ANGLE_FAILED = -1030;
    public static final int FACE_QUALITY_STATUS_FAILED = -1029;
    public static final int POSE_RET_AUTH_FAILED = -1024;
    public static final int POSE_RET_HALF_FACE = -3;
    public static final int POSE_RET_LIGHT_NOT_RIGHT = -4;
    public static final int POSE_RET_NO_FACE = -2;
    public static final int POSE_RET_POSE_COMMIT = 1;
    public static final int POSE_RET_POSE_DETECTING = 0;
    public static final int POSE_RET_POSE_NOT_RIGHT = -1;
    public static final int POSE_RET_SHAKING = -5;
    public static final int POSE_SHAPE_ERROR = -6;
}
