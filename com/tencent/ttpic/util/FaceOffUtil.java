package com.tencent.ttpic.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.luggage.wxa.ci.b;
import com.tencent.luggage.wxa.xd.m0;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FaceOffUtil {
    private static final String COORDS_FILE_CRAZY_FACE = "assets://camera/camera_video/faceOff/coords/crazyface.tsv";
    private static final String COORDS_FILE_FACE_COS3D_MASK = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
    private static final String COORDS_FILE_FACE_HEAD_CROP = "assets://camera/camera_video/faceOff/coords/faceheadcropgray.tsv";
    private static final String COORDS_FILE_FACE_SKIN = "assets://camera/camera_video/faceOff/coords/faceMask_skin.tsv";
    private static final String COORDS_FILE_HAS_EYE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
    private static final String COORDS_FILE_MASK = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
    private static final String COORDS_FILE_NO_EYE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
    public static final Float[] COSMETIC_MODEL_IMAGE_FACEPOINTS;
    public static final int COSMETIC_MODEL_IMAGE_HEIGHT = 1067;
    public static final int COSMETIC_MODEL_IMAGE_WIDTH = 800;
    private static String DEFAULT_BRUSH_POINT = "assets://camera/camera_video/defaultmask/default_brush_point.png";
    private static PointF EMPTY_POINT = new PointF();
    public static final int[] FaceMeshTriangles;
    public static final int[] FaceMeshTrianglesFaceAverage;
    public static final int[] FaceMeshTrianglesFaceAverageForTypeOne;
    public static final int[] FaceMeshTriangles_v2;
    public static String GRAY_CRAZY_SKIN_MERGE_MASK_NAME = "defaultMaskImage.jpg";
    private static String GRAY_FILE_CRAZY_FACE = "assets://camera/camera_video/faceOff/grayImages/crazyfacegray.png";
    private static String GRAY_FILE_CROP_HEAD_FACE = "assets://camera/camera_video/faceOff/grayImages/faceheadcropgray.png";
    private static String GRAY_FILE_FACE_COS3D_MASK = "assets://camera/camera_video/faceOff/grayImages/faceMaskCos3D.png";
    private static String GRAY_FILE_FACE_SKIN = "assets://camera/camera_video/faceOff/grayImages/faceMask_skin.png";
    private static String GRAY_FILE_HAS_EYE = "assets://camera/camera_video/faceOff/grayImages/noeyegray.png";
    private static String GRAY_FILE_LIPS_MASK = "assets://realtimeBeauty/lipsMask.png";
    private static String GRAY_FILE_MASK = "assets://camera/camera_video/faceOff/grayImages/faceoffmask.png";
    public static String GRAY_FILE_NOSE_MASK = "assets://camera/camera_video/faceOff/grayImages/faceoffnose.png";
    private static String GRAY_FILE_NO_EYE = "assets://camera/camera_video/faceOff/grayImages/nomouthgray.png";
    public static final int IRIS_TRIANGLE_COUNT = 8;
    public static final int[] IrisMeshTriangles;
    public static final int NO_HOLE_TRIANGLE_COUNT = 230;
    public static int NO_HOLE_TRIANGLE_COUNT_4_SMOOTH = 0;
    public static final int NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE = 184;
    public static final int NO_HOLE_TRIANGLE_COUNT_V2;
    public static final int NO_HOLE_VERTEX_COUNT_V2 = 135;
    public static int[] Select3DIndices = null;
    private static final String TAG = "FaceOffUtil";
    private static Bitmap crazySkinMergeBitmap;
    public static final int[] faceMesh4Smooth;
    public static final int[] faceMeshNoseLastTriangles;

    /* compiled from: P */
    /* renamed from: com.tencent.ttpic.util.FaceOffUtil$1, reason: invalid class name */
    /* loaded from: classes27.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$ttpic$util$FaceOffUtil$FeatureType;

        static {
            int[] iArr = new int[FeatureType.values().length];
            $SwitchMap$com$tencent$ttpic$util$FaceOffUtil$FeatureType = iArr;
            try {
                iArr[FeatureType.HAS_EYE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$util$FaceOffUtil$FeatureType[FeatureType.CRAZY_FACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$util$FaceOffUtil$FeatureType[FeatureType.FACE_HEAD_CROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$util$FaceOffUtil$FeatureType[FeatureType.FACE_SKIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$util$FaceOffUtil$FeatureType[FeatureType.MASK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$ttpic$util$FaceOffUtil$FeatureType[FeatureType.FACE_COS3D_MASK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum FeatureType {
        NO_EYE(0),
        HAS_EYE(1),
        CRAZY_FACE(2),
        FACE_HEAD_CROP(3),
        FACE_SKIN(4),
        FACE_COS3D_MASK(5),
        MASK(99),
        NOSE_MASK(100),
        LIPS_MASK(101);

        public int value;

        FeatureType(int i3) {
            this.value = i3;
        }
    }

    static {
        Float valueOf = Float.valueOf(528.1364f);
        Float valueOf2 = Float.valueOf(595.3715f);
        Float valueOf3 = Float.valueOf(649.9391f);
        Float valueOf4 = Float.valueOf(398.53836f);
        Float valueOf5 = Float.valueOf(445.3106f);
        Float valueOf6 = Float.valueOf(558.3435f);
        Float valueOf7 = Float.valueOf(239.70767f);
        Float valueOf8 = Float.valueOf(444.33618f);
        Float valueOf9 = Float.valueOf(458.95248f);
        Float valueOf10 = Float.valueOf(425.82217f);
        Float valueOf11 = Float.valueOf(460.90134f);
        Float valueOf12 = Float.valueOf(508.64798f);
        Float valueOf13 = Float.valueOf(512.54565f);
        Float valueOf14 = Float.valueOf(400.4872f);
        Float valueOf15 = Float.valueOf(713.2765f);
        COSMETIC_MODEL_IMAGE_FACEPOINTS = new Float[]{Float.valueOf(156.88185f), valueOf, Float.valueOf(169.54933f), valueOf2, Float.valueOf(181.24239f), valueOf3, Float.valueOf(191.96103f), Float.valueOf(695.7369f), Float.valueOf(214.37271f), Float.valueOf(738.61145f), Float.valueOf(238.73325f), Float.valueOf(776.6139f), Float.valueOf(277.7101f), Float.valueOf(811.69305f), Float.valueOf(311.81485f), Float.valueOf(843.84894f), Float.valueOf(351.76614f), Float.valueOf(868.2095f), valueOf4, Float.valueOf(876.9793f), valueOf5, Float.valueOf(866.2607f), Float.valueOf(491.1084f), Float.valueOf(841.90015f), valueOf, Float.valueOf(807.79535f), valueOf6, Float.valueOf(769.7929f), Float.valueOf(585.62726f), Float.valueOf(734.71375f), Float.valueOf(605.1157f), Float.valueOf(690.8648f), Float.valueOf(618.7576f), Float.valueOf(645.067f), Float.valueOf(630.4507f), Float.valueOf(592.44824f), Float.valueOf(633.37396f), Float.valueOf(524.2387f), Float.valueOf(199.7564f), Float.valueOf(446.285f), valueOf7, valueOf8, Float.valueOf(280.63336f), Float.valueOf(448.23386f), Float.valueOf(321.55908f), Float.valueOf(456.02924f), Float.valueOf(362.48477f), valueOf9, Float.valueOf(327.4056f), Float.valueOf(433.61755f), Float.valueOf(283.55664f), valueOf10, valueOf7, valueOf10, valueOf2, valueOf5, Float.valueOf(555.4202f), valueOf8, Float.valueOf(515.46893f), Float.valueOf(452.13156f), Float.valueOf(484.28745f), Float.valueOf(457.00366f), Float.valueOf(438.48965f), valueOf11, Float.valueOf(464.799f), Float.valueOf(435.56638f), valueOf12, Float.valueOf(422.8989f), Float.valueOf(559.31793f), Float.valueOf(422.8989f), Float.valueOf(241.65651f), Float.valueOf(506.69916f), Float.valueOf(260.17053f), Float.valueOf(518.3922f), Float.valueOf(285.5055f), Float.valueOf(522.2899f), Float.valueOf(309.86603f), Float.valueOf(520.34106f), Float.valueOf(336.17538f), Float.valueOf(511.57126f), Float.valueOf(317.66138f), Float.valueOf(493.05725f), Float.valueOf(287.4543f), Float.valueOf(483.31302f), Float.valueOf(263.09378f), Float.valueOf(489.15958f), Float.valueOf(291.35202f), Float.valueOf(504.7503f), Float.valueOf(291.35202f), Float.valueOf(502.80145f), valueOf6, Float.valueOf(501.82703f), Float.valueOf(537.8806f), Float.valueOf(516.44336f), Float.valueOf(511.57126f), Float.valueOf(523.2643f), Float.valueOf(487.21072f), Float.valueOf(521.3155f), valueOf11, valueOf13, Float.valueOf(481.3642f), Float.valueOf(492.08282f), valueOf12, Float.valueOf(484.28745f), Float.valueOf(534.9574f), Float.valueOf(488.18515f), valueOf12, Float.valueOf(502.80145f), valueOf12, Float.valueOf(500.85263f), Float.valueOf(370.28015f), valueOf13, Float.valueOf(366.38245f), Float.valueOf(600.2436f), Float.valueOf(340.0731f), valueOf3, Float.valueOf(370.28015f), Float.valueOf(668.4531f), valueOf14, Float.valueOf(672.35077f), Float.valueOf(428.74542f), Float.valueOf(666.5043f), valueOf9, Float.valueOf(647.0158f), Float.valueOf(432.64313f), Float.valueOf(601.218f), Float.valueOf(430.69427f), Float.valueOf(513.5201f), valueOf14, Float.valueOf(636.2972f), Float.valueOf(312.78928f), Float.valueOf(719.12305f), Float.valueOf(489.15958f), Float.valueOf(717.1742f), Float.valueOf(335.201f), Float.valueOf(743.4836f), Float.valueOf(364.43362f), Float.valueOf(759.0743f), Float.valueOf(399.5128f), Float.valueOf(766.8697f), Float.valueOf(434.59195f), Float.valueOf(758.09985f), Float.valueOf(464.799f), Float.valueOf(741.5347f), Float.valueOf(442.38733f), Float.valueOf(736.6626f), Float.valueOf(401.46164f), Float.valueOf(741.5347f), Float.valueOf(352.74057f), Float.valueOf(736.6626f), Float.valueOf(346.89404f), valueOf15, Float.valueOf(379.04993f), Float.valueOf(710.3532f), Float.valueOf(401.46164f), Float.valueOf(714.2509f), Float.valueOf(421.92447f), valueOf15, Float.valueOf(454.08038f), valueOf15, Float.valueOf(442.38733f), Float.valueOf(729.8417f), valueOf14, Float.valueOf(731.7905f), Float.valueOf(354.6894f), Float.valueOf(727.8928f), valueOf14, valueOf13, Float.valueOf(404.3849f), valueOf11, valueOf14, Float.valueOf(692.81366f), Float.valueOf(205.60292f), Float.valueOf(205.60292f), valueOf4, Float.valueOf(275.76126f), Float.valueOf(598.29474f), Float.valueOf(197.80756f), valueOf14, Float.valueOf(356.63824f)};
        FaceMeshTrianglesFaceAverage = new int[]{0, 1, 35, 1, 35, 36, 35, 36, 42, 20, 35, 42, 19, 20, 35, 19, 20, 26, 19, 26, 96, 19, 90, 96, 26, 95, 96, 25, 26, 95, 21, 25, 26, 20, 21, 26, 20, 21, 42, 21, 41, 42, 41, 42, 43, 36, 42, 43, 36, 37, 43, 36, 37, 57, 2, 36, 57, 2, 3, 57, 3, 4, 65, 4, 5, 65, 5, 65, 67, 5, 6, 67, 6, 7, 67, 7, 67, 68, 7, 8, 68, 8, 68, 69, 68, 69, 73, 68, 73, 74, 67, 68, 74, 65, 67, 74, 65, 75, 82, 57, 58, 75, 58, 75, 76, 75, 76, 82, 65, 74, 82, 74, 81, 82, 73, 74, 81, 70, 72, 73, 69, 70, 73, 10, 69, 70, 9, 10, 69, 8, 9, 69, 10, 11, 70, 12, 13, 71, 13, 66, 71, 13, 14, 66, 14, 15, 66, 60, 61, 79, 59, 60, 64, 59, 60, 78, 59, 77, 78, 76, 77, 81, 59, 76, 77, 58, 59, 76, 58, 59, 64, 56, 58, 64, 56, 57, 58, 37, 38, 43, 38, 40, 43, 38, 39, 40, 38, 39, 56, 39, 55, 56, 23, 39, 55, 56, 62, 64, 47, 61, 62, 46, 47, 61, 15, 16, 61, 17, 45, 46, 17, 18, 45, 27, 28, 45, 28, 45, 52, 28, 29, 52, 29, 51, 52, 29, 50, 51, 50, 51, 53, 48, 50, 53, 48, 49, 50, 31, 49, 63, 47, 48, 62, 47, 48, 53, 45, 46, 52, 51, 52, 53, 30, 31, 32, 31, 32, 94, 32, 92, 94, 32, 33, 92, 29, 30, 50, 27, 28, 34, 27, 34, 93, 27, 91, 93, 34, 92, 93, 33, 34, 92, 23, 31, 94, 23, 24, 94, 22, 23, 24, 21, 22, 24, 40, 41, 43, 22, 39, 40, 22, 23, 39, 21, 24, 25, 24, 25, 95, 24, 94, 95, 76, 81, 82, 78, 79, 80, 66, 72, 80, 66, 79, 80, 66, 71, 72, 70, 71, 72, 60, 78, 79, 1, 2, 36, 95, 96, 99, 92, 93, 105, 91, 104, 105, 14, 103, 104, 11, 102, 103, 7, 101, 102, 4, 100, 101, 90, 99, 100, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 92, 105, 106, 92, 94, 106, 94, 95, 106, 95, 99, 106, 90, 96, 99, 0, 90, 100, 21, 40, 41, 21, 22, 40, 23, 31, 83, 23, 55, 83, 31, 63, 83, 55, 56, 83, 56, 62, 83, 62, 63, 83, 49, 62, 63, 48, 49, 62, 30, 31, 49, 30, 49, 50, 29, 30, 32, 29, 32, 33, 29, 33, 34, 28, 29, 34, 46, 52, 53, 46, 47, 53, 37, 38, 56, 37, 56, 57, 60, 62, 64, 60, 61, 62, 16, 46, 61, 16, 17, 46, 77, 78, 81, 78, 80, 81, 72, 80, 81, 72, 73, 81, 11, 70, 71, 11, 12, 71, 0, 19, 90, 0, 19, 35, 18, 27, 91, 18, 27, 45, 3, 57, 65, 57, 65, 75, 61, 66, 79, 15, 61, 66};
        FaceMeshTrianglesFaceAverageForTypeOne = new int[]{0, 35, 1, 1, 35, 36, 35, 42, 36, 20, 42, 35, 19, 20, 35, 19, 26, 20, 19, 96, 26, 19, 90, 96, 26, 96, 95, 25, 26, 95, 21, 26, 25, 20, 26, 21, 20, 21, 42, 21, 41, 42, 41, 43, 42, 36, 42, 43, 36, 43, 37, 36, 37, 57, 2, 36, 57, 2, 57, 3, 3, 65, 4, 4, 65, 5, 5, 65, 67, 5, 67, 6, 6, 67, 7, 7, 67, 68, 7, 68, 8, 8, 68, 69, 68, 73, 69, 68, 74, 73, 67, 74, 68, 65, 74, 67, 65, 75, 82, 57, 58, 75, 58, 76, 75, 75, 76, 82, 65, 82, 74, 74, 82, 81, 73, 74, 81, 70, 73, 72, 69, 73, 70, 10, 69, 70, 9, 69, 10, 8, 69, 9, 10, 70, 11, 12, 71, 13, 13, 71, 66, 13, 66, 14, 14, 66, 15, 60, 61, 79, 59, 64, 60, 59, 60, 78, 59, 78, 77, 76, 77, 81, 59, 77, 76, 58, 59, 76, 58, 64, 59, 56, 64, 58, 56, 58, 57, 37, 43, 38, 38, 43, 40, 38, 40, 39, 38, 39, 56, 39, 55, 56, 23, 55, 39, 56, 62, 64, 47, 61, 62, 46, 61, 47, 15, 61, 16, 17, 46, 45, 17, 45, 18, 27, 45, 28, 28, 45, 52, 28, 52, 29, 29, 52, 51, 30, 51, 50, 50, 51, 53, 48, 50, 53, 48, 49, 50, 31, 49, 63, 47, 62, 48, 47, 48, 53, 45, 46, 52, 51, 52, 53, 30, 31, 32, 31, 94, 32, 32, 94, 92, 32, 92, 33, 29, 51, 30, 27, 28, 34, 27, 34, 93, 27, 93, 91, 34, 92, 93, 33, 92, 34, 23, 94, 31, 23, 24, 94, 22, 24, 23, 21, 24, 22, 40, 43, 41, 22, 40, 41, 22, 23, 40, 21, 25, 24, 24, 25, 95, 24, 95, 94, 76, 81, 82, 78, 79, 80, 66, 72, 80, 66, 80, 79, 66, 71, 72, 70, 72, 71, 60, 79, 78, 1, 36, 2, 95, 96, 99, 92, 105, 93, 91, 105, 104, 14, 104, 103, 11, 103, 102, 7, 102, 101, 4, 101, 100, 90, 100, 99, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 92, 106, 105, 92, 94, 106, 94, 95, 106, 95, 99, 106, 90, 99, 96, 0, 100, 90, 23, 39, 40, 21, 22, 41, 23, 31, 83, 23, 83, 55, 31, 63, 83, 55, 83, 56, 56, 83, 62, 62, 83, 63, 49, 62, 63, 48, 62, 49, 30, 50, 31, 31, 50, 49, 29, 30, 32, 29, 32, 33, 29, 33, 34, 28, 29, 34, 46, 53, 52, 46, 47, 53, 37, 38, 56, 37, 56, 57, 60, 64, 62, 60, 62, 61, 16, 61, 46, 16, 46, 17, 77, 78, 81, 78, 80, 81, 72, 81, 80, 72, 73, 81, 11, 70, 71, 11, 71, 12, 0, 90, 19, 0, 19, 35, 18, 27, 91, 18, 45, 27, 3, 57, 65, 57, 75, 65, 61, 66, 79, 15, 66, 61};
        FaceMeshTriangles = new int[]{19, 118, 111, 118, 19, 20, 7, 67, 68, 67, 7, 6, 1, 0, 111, 56, 109, 114, 109, 56, 57, 2, 1, 109, 69, 8, 68, 8, 69, 9, 3, 2, 107, 58, 76, 75, 76, 58, 59, 4, 3, 107, 65, 75, 82, 65, 67, 74, 65, 82, 74, 5, 4, 107, 67, 6, 5, 109, 107, 2, 107, 109, 57, 114, 55, 56, 55, 114, 115, 8, 7, 68, 114, 113, 38, 113, 114, 109, 10, 9, 69, 11, 10, 70, 12, 11, 71, 36, 113, 112, 113, 36, 37, 13, 12, 66, 41, 119, 40, 119, 41, 117, 14, 13, 108, 37, 41, 38, 41, 37, 42, 15, 14, 108, 42, 118, 120, 118, 42, 35, 16, 15, 108, 1, 111, 112, 17, 16, 110, 109, 112, 113, 112, 109, 1, 18, 17, 121, 25, 20, 26, 20, 25, 21, 96, 26, 19, 26, 96, 95, 107, 57, 65, 19, 111, 90, 20, 19, 26, 21, 25, 22, 58, 64, 59, 64, 58, 57, 20, 21, 120, 33, 29, 30, 29, 33, 28, 51, 129, 127, 129, 51, 50, 21, 22, 117, 22, 24, 23, 24, 22, 25, 121, 17, 122, 22, 23, 116, 52, 128, 45, 128, 52, 130, 121, 128, 27, 128, 121, 45, 23, 24, 84, 92, 33, 32, 33, 92, 34, 24, 25, 95, 24, 95, 94, 25, 26, 95, 121, 91, 18, 91, 121, 27, 84, 94, 32, 94, 84, 24, 27, 93, 91, 93, 27, 34, 27, 28, 34, 28, 27, 128, 32, 30, 31, 30, 32, 33, 28, 33, 34, 29, 28, 130, 110, 122, 17, 122, 110, 123, 32, 31, 84, 30, 29, 127, 47, 52, 46, 52, 47, 51, 31, 30, 129, 84, 31, 126, 92, 32, 94, 93, 34, 92, 42, 36, 35, 36, 42, 37, 35, 112, 111, 112, 35, 36, 120, 117, 41, 117, 120, 21, 38, 41, 40, 114, 38, 39, 22, 116, 119, 61, 64, 62, 64, 61, 60, 37, 38, 113, 116, 39, 40, 39, 116, 115, 61, 108, 66, 108, 61, 110, 39, 38, 40, 63, 84, 126, 84, 63, 83, 119, 117, 22, 120, 41, 42, 120, 118, 20, 45, 122, 46, 122, 45, 121, 46, 52, 45, 127, 130, 51, 130, 127, 29, 123, 46, 122, 46, 123, 47, 48, 51, 47, 51, 48, 50, 124, 48, 123, 48, 124, 49, 64, 60, 59, 48, 47, 123, 71, 11, 70, 31, 129, 126, 48, 49, 50, 84, 116, 23, 116, 84, 55, 49, 126, 50, 126, 49, 125, 127, 129, 30, 51, 130, 52, 128, 130, 28, 115, 114, 39, 83, 56, 55, 56, 83, 62, 64, 57, 56, 65, 57, 75, 5, 107, 65, 10, 69, 70, 57, 58, 75, 60, 79, 78, 79, 60, 61, 61, 66, 79, 108, 13, 66, 16, 108, 110, 59, 60, 78, 124, 123, 110, 110, 62, 124, 62, 110, 61, 124, 63, 125, 63, 124, 62, 56, 62, 64, 124, 125, 49, 63, 62, 83, 83, 55, 84, 5, 65, 67, 66, 12, 71, 74, 68, 67, 68, 74, 73, 68, 73, 69, 73, 70, 69, 70, 73, 72, 66, 71, 72, 66, 79, 80, 66, 80, 72, 71, 70, 72, 59, 78, 77, 72, 73, 80, 81, 80, 73, 80, 81, 78, 73, 74, 81, 82, 81, 74, 81, 82, 76, 75, 76, 82, 76, 59, 77, 77, 81, 76, 81, 77, 78, 78, 79, 80, 19, 90, 96, 0, 90, 111, 35, 111, 118, 55, 115, 116, 116, 40, 119, 125, 63, 126, 50, 126, 129, 99, 106, 96, 106, 105, 93, 105, 104, 91, 104, 103, 14, 103, 102, 11, 102, 101, 7, 101, 100, 4, 100, 99, 90, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 93, 92, 106, 92, 94, 106, 94, 95, 106, 95, 96, 106, 96, 90, 99, 90, 0, 100};
        int[] iArr = {131, 19, 26, 131, 26, 25, 131, 25, 133, 99, 131, 134, 106, 131, 133, 106, 131, 99, 19, 134, 131, 132, 105, 135, 106, 132, 105, 106, 132, 133, 132, 33, 133, 132, 34, 33, 132, 27, 34, 132, 27, 135, 133, 25, 24, 133, 24, 84, 133, 32, 84, 133, 33, 32, 0, 19, 134, 99, 134, 100, 100, 134, 0, 104, 18, 135, 105, 104, 135, 18, 27, 135, 19, 118, 111, 118, 19, 20, 7, 67, 68, 67, 7, 6, 1, 0, 111, 56, 109, 114, 109, 56, 57, 2, 1, 109, 69, 8, 68, 8, 69, 9, 3, 2, 107, 58, 76, 75, 76, 58, 59, 4, 3, 107, 65, 75, 82, 65, 67, 74, 65, 82, 74, 5, 4, 107, 67, 6, 5, 109, 107, 2, 107, 109, 57, 114, 55, 56, 55, 114, 115, 8, 7, 68, 114, 113, 38, 113, 114, 109, 10, 9, 69, 11, 10, 70, 12, 11, 71, 36, 113, 112, 113, 36, 37, 13, 12, 66, 41, 119, 40, 119, 41, 117, 14, 13, 108, 37, 41, 38, 41, 37, 42, 15, 14, 108, 42, 118, 120, 118, 42, 35, 16, 15, 108, 1, 111, 112, 17, 16, 110, 109, 112, 113, 112, 109, 1, 18, 17, 121, 25, 20, 26, 20, 25, 21, 107, 57, 65, 20, 19, 26, 21, 25, 22, 20, 21, 120, 33, 29, 30, 29, 33, 28, 51, 129, 127, 129, 51, 50, 21, 22, 117, 22, 24, 23, 24, 22, 25, 121, 17, 122, 22, 23, 116, 52, 128, 45, 128, 52, 130, 121, 128, 27, 128, 121, 45, 23, 24, 84, 27, 28, 34, 28, 27, 128, 32, 30, 31, 30, 32, 33, 28, 33, 34, 29, 28, 130, 110, 122, 17, 122, 110, 123, 32, 31, 84, 30, 29, 127, 47, 52, 46, 52, 47, 51, 31, 30, 129, 84, 31, 126, 42, 36, 35, 36, 42, 37, 35, 112, 111, 112, 35, 36, 120, 117, 41, 117, 120, 21, 38, 41, 40, 114, 38, 39, 22, 116, 119, 37, 38, 113, 116, 39, 40, 39, 116, 115, 61, 108, 66, 108, 61, 110, 39, 38, 40, 63, 84, 126, 119, 117, 22, 120, 41, 42, 120, 118, 20, 45, 122, 46, 122, 45, 121, 46, 52, 45, 127, 130, 51, 130, 127, 29, 123, 46, 122, 46, 123, 47, 48, 51, 47, 51, 48, 50, 124, 48, 123, 48, 124, 49, 48, 47, 123, 71, 11, 70, 31, 129, 126, 48, 49, 50, 84, 116, 23, 116, 84, 55, 49, 126, 50, 126, 49, 125, 127, 129, 30, 51, 130, 52, 128, 130, 28, 115, 114, 39, 65, 57, 75, 5, 107, 65, 10, 69, 70, 57, 58, 75, 60, 79, 78, 79, 60, 61, 61, 66, 79, 108, 13, 66, 16, 108, 110, 59, 60, 78, 124, 123, 110, 110, 62, 124, 62, 110, 61, 124, 63, 125, 63, 124, 62, 124, 125, 49, 5, 65, 67, 66, 12, 71, 74, 68, 67, 68, 74, 73, 68, 73, 69, 73, 70, 69, 70, 73, 72, 66, 71, 72, 66, 79, 80, 66, 80, 72, 71, 70, 72, 59, 78, 77, 72, 73, 80, 81, 80, 73, 80, 81, 78, 73, 74, 81, 82, 81, 74, 81, 82, 76, 75, 76, 82, 76, 59, 77, 77, 81, 76, 81, 77, 78, 78, 79, 80, 35, 111, 118, 55, 115, 116, 116, 40, 119, 125, 63, 126, 50, 126, 129, 84, 63, 83, 83, 56, 55, 56, 83, 62, 63, 62, 83, 83, 55, 84, 58, 64, 59, 64, 58, 57, 61, 64, 62, 64, 61, 60, 64, 60, 59, 64, 57, 56, 56, 62, 64, 0, 111, 19, 18, 121, 27, 100, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 101, 4, 101, 4, 5, 101, 5, 6, 101, 6, 7, 101, 102, 7, 102, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 103, 11, 103, 11, 12, 103, 12, 13, 103, 13, 14, 103, 104, 14, 104, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18};
        faceMesh4Smooth = iArr;
        NO_HOLE_TRIANGLE_COUNT_4_SMOOTH = iArr.length / 3;
        faceMeshNoseLastTriangles = new int[]{19, 118, 111, 118, 19, 20, 7, 67, 68, 67, 7, 6, 1, 0, 111, 56, 109, 114, 109, 56, 57, 2, 1, 109, 69, 8, 68, 8, 69, 9, 3, 2, 107, 58, 76, 75, 76, 58, 59, 4, 3, 107, 65, 75, 82, 65, 67, 74, 65, 82, 74, 5, 4, 107, 67, 6, 5, 109, 107, 2, 107, 109, 57, 114, 55, 56, 55, 114, 115, 8, 7, 68, 114, 113, 38, 113, 114, 109, 10, 9, 69, 11, 10, 70, 12, 11, 71, 36, 113, 112, 113, 36, 37, 13, 12, 66, 41, 119, 40, 119, 41, 117, 14, 13, 108, 37, 41, 38, 41, 37, 42, 15, 14, 108, 42, 118, 120, 118, 42, 35, 16, 15, 108, 1, 111, 112, 17, 16, 110, 109, 112, 113, 112, 109, 1, 18, 17, 121, 25, 20, 26, 20, 25, 21, 96, 26, 19, 26, 96, 95, 107, 57, 65, 19, 111, 90, 20, 19, 26, 21, 25, 22, 20, 21, 120, 33, 29, 30, 29, 33, 28, 51, 129, 127, 129, 51, 50, 21, 22, 117, 22, 24, 23, 24, 22, 25, 121, 17, 122, 22, 23, 116, 52, 128, 45, 128, 52, 130, 121, 128, 27, 128, 121, 45, 23, 24, 84, 92, 33, 32, 33, 92, 34, 24, 25, 95, 24, 95, 94, 25, 26, 95, 121, 91, 18, 91, 121, 27, 84, 94, 32, 94, 84, 24, 27, 93, 91, 93, 27, 34, 27, 28, 34, 28, 27, 128, 32, 30, 31, 30, 32, 33, 28, 33, 34, 29, 28, 130, 110, 122, 17, 122, 110, 123, 32, 31, 84, 30, 29, 127, 47, 52, 46, 52, 47, 51, 31, 30, 129, 84, 31, 126, 92, 32, 94, 93, 34, 92, 42, 36, 35, 36, 42, 37, 35, 112, 111, 112, 35, 36, 120, 117, 41, 117, 120, 21, 38, 41, 40, 114, 38, 39, 22, 116, 119, 37, 38, 113, 116, 39, 40, 39, 116, 115, 61, 108, 66, 108, 61, 110, 39, 38, 40, 63, 84, 126, 119, 117, 22, 120, 41, 42, 120, 118, 20, 45, 122, 46, 122, 45, 121, 46, 52, 45, 127, 130, 51, 130, 127, 29, 123, 46, 122, 46, 123, 47, 48, 51, 47, 51, 48, 50, 124, 48, 123, 48, 124, 49, 48, 47, 123, 71, 11, 70, 31, 129, 126, 48, 49, 50, 84, 116, 23, 116, 84, 55, 49, 126, 50, 126, 49, 125, 127, 129, 30, 51, 130, 52, 128, 130, 28, 115, 114, 39, 65, 57, 75, 5, 107, 65, 10, 69, 70, 57, 58, 75, 60, 79, 78, 79, 60, 61, 61, 66, 79, 108, 13, 66, 16, 108, 110, 59, 60, 78, 124, 123, 110, 110, 62, 124, 62, 110, 61, 124, 63, 125, 63, 124, 62, 124, 125, 49, 5, 65, 67, 66, 12, 71, 74, 68, 67, 68, 74, 73, 68, 73, 69, 73, 70, 69, 70, 73, 72, 66, 71, 72, 66, 79, 80, 66, 80, 72, 71, 70, 72, 59, 78, 77, 72, 73, 80, 81, 80, 73, 80, 81, 78, 73, 74, 81, 82, 81, 74, 81, 82, 76, 75, 76, 82, 76, 59, 77, 77, 81, 76, 81, 77, 78, 78, 79, 80, 19, 90, 96, 0, 90, 111, 35, 111, 118, 55, 115, 116, 116, 40, 119, 125, 63, 126, 50, 126, 129, 99, 106, 96, 106, 105, 93, 105, 104, 91, 104, 103, 14, 103, 102, 11, 102, 101, 7, 101, 100, 4, 100, 99, 90, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 93, 92, 106, 92, 94, 106, 94, 95, 106, 95, 96, 106, 96, 90, 99, 90, 0, 100, 84, 63, 83, 83, 56, 55, 56, 83, 62, 63, 62, 83, 83, 55, 84, 58, 64, 59, 64, 58, 57, 61, 64, 62, 64, 61, 60, 64, 60, 59, 64, 57, 56, 56, 62, 64};
        int[] iArr2 = {108, 14, 13, 108, 13, 12, 108, 12, 11, 134, 11, 66, 134, 11, 108, 71, 11, 66, 71, 11, 70, 107, 4, 5, 107, 5, 6, 107, 6, 7, 133, 7, 65, 133, 7, 107, 67, 7, 65, 67, 7, 68, 19, 118, 111, 118, 19, 20, 69, 8, 68, 8, 69, 9, 58, 76, 75, 76, 58, 59, 65, 75, 82, 65, 67, 74, 65, 82, 74, 114, 55, 56, 55, 114, 115, 8, 7, 68, 114, 113, 38, 10, 9, 69, 11, 10, 70, 36, 113, 112, 113, 36, 37, 41, 119, 40, 119, 41, 117, 37, 41, 38, 41, 37, 42, 42, 118, 120, 118, 42, 35, 25, 20, 26, 20, 25, 21, 96, 26, 19, 26, 96, 95, 19, 111, 90, 20, 19, 26, 21, 25, 22, 20, 21, 120, 33, 29, 30, 29, 33, 28, 51, 129, 127, 129, 51, 50, 21, 22, 117, 22, 24, 23, 24, 22, 25, 22, 23, 116, 52, 128, 45, 128, 52, 130, 121, 128, 27, 128, 121, 45, 23, 24, 84, 92, 33, 32, 33, 92, 34, 24, 25, 95, 24, 95, 94, 25, 26, 95, 121, 91, 18, 91, 121, 27, 84, 94, 32, 94, 84, 24, 27, 93, 91, 93, 27, 34, 27, 28, 34, 28, 27, 128, 32, 30, 31, 30, 32, 33, 28, 33, 34, 29, 28, 130, 32, 31, 84, 30, 29, 127, 47, 52, 46, 52, 47, 51, 31, 30, 129, 84, 31, 126, 92, 32, 94, 93, 34, 92, 42, 36, 35, 36, 42, 37, 35, 112, 111, 112, 35, 36, 120, 117, 41, 117, 120, 21, 38, 41, 40, 114, 38, 39, 22, 116, 119, 37, 38, 113, 116, 39, 40, 39, 116, 115, 39, 38, 40, 63, 84, 126, 119, 117, 22, 120, 41, 42, 120, 118, 20, 45, 122, 46, 122, 45, 121, 46, 52, 45, 127, 130, 51, 130, 127, 29, 123, 46, 122, 46, 123, 47, 48, 51, 47, 51, 48, 50, 124, 48, 123, 48, 124, 49, 48, 47, 123, 31, 129, 126, 48, 49, 50, 84, 116, 23, 116, 84, 55, 49, 126, 50, 126, 49, 125, 127, 129, 30, 51, 130, 52, 128, 130, 28, 115, 114, 39, 65, 57, 75, 10, 69, 70, 57, 58, 75, 60, 79, 78, 79, 60, 61, 61, 66, 79, 59, 60, 78, 124, 63, 125, 63, 124, 62, 124, 125, 49, 74, 68, 67, 68, 74, 73, 68, 73, 69, 73, 70, 69, 70, 73, 72, 66, 71, 72, 66, 79, 80, 66, 80, 72, 71, 70, 72, 59, 78, 77, 72, 73, 80, 81, 80, 73, 80, 81, 78, 73, 74, 81, 82, 81, 74, 81, 82, 76, 75, 76, 82, 76, 59, 77, 77, 81, 76, 81, 77, 78, 78, 79, 80, 19, 90, 96, 0, 90, 111, 35, 111, 118, 55, 115, 116, 116, 40, 119, 125, 63, 126, 50, 126, 129, 99, 106, 96, 106, 105, 93, 105, 104, 91, 104, 103, 14, 103, 102, 11, 102, 101, 7, 101, 100, 4, 100, 99, 90, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 93, 92, 106, 92, 94, 106, 94, 95, 106, 95, 96, 106, 96, 90, 99, 90, 0, 100, 0, 109, 111, 109, 112, 111, 131, 109, 112, 131, 112, 113, 131, 113, 114, 131, 114, 56, 0, 1, 109, 1, 2, 109, 2, 109, 107, 2, 107, 3, 3, 107, 4, 131, 56, 57, 133, 57, 65, 131, 57, 107, 131, 107, 109, 57, 107, 133, 18, 110, 121, 110, 122, 121, 132, 110, 122, 132, 122, 123, 132, 123, 124, 132, 124, 62, 18, 17, 110, 17, 16, 110, 16, 110, 108, 16, 108, 15, 15, 108, 14, 132, 62, 61, 134, 61, 66, 132, 61, 108, 132, 108, 110, 61, 108, 134, 84, 63, 83, 83, 56, 55, 56, 83, 62, 63, 62, 83, 83, 55, 84, 58, 64, 59, 64, 58, 57, 61, 64, 62, 64, 61, 60, 64, 60, 59, 64, 57, 56, 56, 62, 64};
        FaceMeshTriangles_v2 = iArr2;
        NO_HOLE_TRIANGLE_COUNT_V2 = iArr2.length / 3;
        IrisMeshTriangles = new int[]{0, 1, 2, 0, 2, 3, 0, 3, 4, 0, 4, 1, 5, 6, 7, 5, 7, 8, 5, 8, 9, 5, 9, 6};
        Select3DIndices = new int[]{359, 365, 364, 388, 2082, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_EXTERNAL_COMMENT_TYPE, 11, 21, 2161, 33, m0.CTRL_INDEX, 464, 1771, 874, 2085, 802, 2081, 782, 2591, 1203, 231, 2667, 2086, 162, 1071, 1059, 167, 1204, LpReportInfoConfig.ACTION_VIDEO_EDITOR, 2669, 2091, 595, 1072, 1060, 600, 200, 214, 213, 253, 181, 191, 1454, LaunchScene.LAUNCH_SCENE_GAME_CENTER_QA, 3023, 397, 633, 647, 646, 685, 614, 624, 1455, LaunchScene.LAUNCH_SCENE_GAME_CENTER_FROM_GUILD, 3027, 811, 2649, 2894, 3144, 93, 3038, 530, 3147, 2895, 2652, 3432, 1586, 3309, 3059, 264, 411, 693, 3060, 1427, 3375, 1426, 314, 3176, 3208, 3178, b.CTRL_INDEX, 3173, 1600, 1450, 211, 2361, 185, 182, 198, 2584, 2778, 1041, 2780, 194, 644, 2365, 618, 615, 631, 2587, 2783, 1042, 2785, 627};
    }

    private static float[] calcFullProbability_v2(List<PointF> list, float[] fArr, float f16) {
        float cos;
        float f17;
        float cos2;
        float f18;
        list.get(64);
        list.get(65);
        list.get(66);
        PointF pointF = list.get(54);
        PointF pointF2 = list.get(44);
        PointF pointF3 = new PointF(pointF.x - pointF2.x, pointF.y - pointF2.y);
        PointF pointF4 = new PointF(-pointF3.y, pointF3.x);
        float f19 = pointF4.y;
        if (f19 < 0.0f) {
            pointF4.x = -pointF4.x;
            pointF4.y = -f19;
        }
        float distance = AlgoUtils.getDistance(pointF3, new PointF(0.0f, 0.0f));
        float distance2 = AlgoUtils.getDistance(pointF4, new PointF(0.0f, 0.0f));
        pointF3.x /= distance;
        pointF3.y /= distance;
        pointF4.x /= distance2;
        pointF4.y /= distance2;
        PointF pointF5 = list.get(56);
        PointF pointF6 = list.get(62);
        PointF pointF7 = list.get(17);
        PointF pointF8 = list.get(1);
        list.get(9);
        list.get(87);
        Math.abs((pointF3.x * (pointF7.x - pointF5.x)) + (pointF3.y * (pointF7.y - pointF5.y)));
        Math.abs((pointF3.x * (pointF8.x - pointF6.x)) + (pointF3.y * (pointF8.y - pointF6.y)));
        float[] fArr2 = new float[135];
        for (int i3 = 0; i3 < 90; i3++) {
            fArr2[i3] = fArr[i3];
        }
        fArr2[90] = fArr2[1];
        fArr2[91] = fArr2[17];
        fArr2[92] = 1.0f;
        fArr2[93] = 1.0f;
        fArr2[94] = 1.0f;
        fArr2[95] = 1.0f;
        fArr2[96] = 1.0f;
        fArr2[97] = 0.0f;
        fArr2[98] = 0.0f;
        fArr2[99] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[100] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[101] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[102] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[103] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[104] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[105] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[106] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        float f26 = fArr2[35];
        fArr2[107] = f26;
        float f27 = fArr2[45];
        fArr2[108] = f27;
        fArr2[109] = f26;
        fArr2[110] = f27;
        fArr2[111] = f26;
        fArr2[112] = fArr2[36];
        fArr2[113] = fArr2[37];
        fArr2[114] = fArr2[38];
        fArr2[115] = fArr2[39];
        float f28 = fArr2[40];
        fArr2[116] = f28;
        float f29 = fArr2[41];
        fArr2[117] = f29;
        float f36 = fArr2[42];
        fArr2[118] = f36;
        fArr2[119] = (f28 + f29) / 2.0f;
        fArr2[120] = (f29 + f36) / 2.0f;
        fArr2[121] = f27;
        fArr2[122] = fArr2[46];
        fArr2[123] = fArr2[47];
        fArr2[124] = fArr2[48];
        fArr2[125] = fArr2[49];
        float f37 = fArr2[50];
        fArr2[126] = f37;
        float f38 = fArr2[51];
        fArr2[127] = f38;
        float f39 = fArr2[52];
        fArr2[128] = f39;
        fArr2[129] = (f37 + f38) / 2.0f;
        fArr2[130] = (f38 + f39) / 2.0f;
        if (f16 < 0.0f) {
            double d16 = f16;
            f17 = 0.7f - ((float) (Math.cos(d16) * 0.2d));
            cos = ((float) (Math.cos(d16) * 2.0d)) - 1.5f;
        } else {
            double d17 = f16;
            float cos3 = ((float) (Math.cos(d17) * 2.0d)) - 1.5f;
            cos = 0.7f - ((float) (Math.cos(d17) * 0.2d));
            f17 = cos3;
        }
        Math.max(Math.min(f17, 1.0f), 0.0f);
        Math.max(Math.min(cos, 1.0f), 0.0f);
        fArr2[131] = fArr2[36];
        fArr2[132] = fArr2[46];
        if (f16 < 0.0f) {
            double d18 = f16;
            f18 = 0.7f - ((float) (Math.cos(d18) * 0.2d));
            cos2 = ((float) (Math.cos(d18) * 2.0d)) - 1.5f;
        } else {
            double d19 = f16;
            float cos4 = ((float) (Math.cos(d19) * 2.0d)) - 1.5f;
            cos2 = 0.7f - ((float) (Math.cos(d19) * 0.2d));
            f18 = cos4;
        }
        Math.max(Math.min(f18, 1.0f), 0.0f);
        Math.max(Math.min(cos2, 1.0f), 0.0f);
        fArr2[133] = fArr2[36];
        fArr2[134] = fArr2[46];
        return fArr2;
    }

    public static List<PointF> genPoints(List<Float> list) {
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isEmpty(list)) {
            return arrayList;
        }
        for (int i3 = 0; i3 < list.size() / 2; i3++) {
            int i16 = i3 * 2;
            arrayList.add(new PointF(list.get(i16).floatValue(), list.get(i16 + 1).floatValue()));
        }
        return arrayList;
    }

    public static List<PointF> genPointsDouble(List<Double> list) {
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isEmpty(list)) {
            return arrayList;
        }
        for (int i3 = 0; i3 < list.size() / 2; i3++) {
            int i16 = i3 * 2;
            arrayList.add(new PointF(list.get(i16).floatValue(), list.get(i16 + 1).floatValue()));
        }
        return arrayList;
    }

    public static Bitmap getCrazySkinMergeMask(String str) {
        if (!BitmapUtils.isLegal(crazySkinMergeBitmap)) {
            crazySkinMergeBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), str + File.separator + GRAY_CRAZY_SKIN_MERGE_MASK_NAME, 1);
        }
        return crazySkinMergeBitmap;
    }

    public static void getCropNormalFaceFeature(List<PointF> list) {
        float distance = AlgoUtils.getDistance(list.get(99), list.get(105));
        float distance2 = AlgoUtils.getDistance(list.get(99), list.get(101));
        float f16 = 1.0f / distance;
        float f17 = 1.0f / distance2;
        for (int i3 = 0; i3 < list.size(); i3++) {
            list.get(i3).set(AlgoUtils.distanceOfPoint2Line(list.get(99), list.get(101), distance2, list.get(i3)) * f16, AlgoUtils.distanceOfPoint2Line(list.get(99), list.get(105), distance, list.get(i3)) * f17);
        }
    }

    public static Bitmap getFaceBitmap(String str) {
        return getFaceBitmap(str, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public static List<PointF> getFacePoints4Smooth(List<PointF> list) {
        List<PointF> fullCoordsForNoseAndOutline = getFullCoordsForNoseAndOutline(list);
        PointF pointF = new PointF(list.get(35).x + ((list.get(83).x - list.get(59).x) * 1.5f), list.get(35).y + ((list.get(83).y - list.get(59).y) * 1.5f));
        PointF pointF2 = new PointF(list.get(45).x + ((list.get(83).x - list.get(59).x) * 1.5f), list.get(45).y + ((list.get(83).y - list.get(59).y) * 1.5f));
        PointF pointF3 = fullCoordsForNoseAndOutline.get(0);
        PointF pointF4 = fullCoordsForNoseAndOutline.get(18);
        fullCoordsForNoseAndOutline.add(pointF);
        fullCoordsForNoseAndOutline.add(pointF2);
        PointF middlePoint = AlgoUtils.middlePoint(pointF, pointF2);
        float distance = (AlgoUtils.getDistance(fullCoordsForNoseAndOutline.get(83), pointF) * 0.5f) + (AlgoUtils.getDistance(fullCoordsForNoseAndOutline.get(83), pointF2) * 0.5f);
        float distance2 = AlgoUtils.getDistance(fullCoordsForNoseAndOutline.get(83), middlePoint) + 1.0E-4f;
        fullCoordsForNoseAndOutline.add(new PointF(list.get(83).x + (((middlePoint.x - list.get(83).x) * distance) / distance2), list.get(83).y + (((middlePoint.y - list.get(83).y) * distance) / distance2)));
        PointF middlePoint2 = AlgoUtils.middlePoint(pointF, pointF3);
        float distance3 = (AlgoUtils.getDistance(fullCoordsForNoseAndOutline.get(83), pointF) * 0.5f) + (AlgoUtils.getDistance(fullCoordsForNoseAndOutline.get(83), pointF3) * 0.5f);
        float distance4 = AlgoUtils.getDistance(fullCoordsForNoseAndOutline.get(83), middlePoint2) + 1.0E-4f;
        fullCoordsForNoseAndOutline.add(new PointF(list.get(83).x + (((middlePoint2.x - list.get(83).x) * distance3) / distance4), list.get(83).y + (((middlePoint2.y - list.get(83).y) * distance3) / distance4)));
        PointF middlePoint3 = AlgoUtils.middlePoint(pointF4, pointF2);
        float distance5 = (AlgoUtils.getDistance(fullCoordsForNoseAndOutline.get(83), pointF4) * 0.5f) + (AlgoUtils.getDistance(fullCoordsForNoseAndOutline.get(83), pointF2) * 0.5f);
        float distance6 = AlgoUtils.getDistance(fullCoordsForNoseAndOutline.get(83), middlePoint3) + 1.0E-4f;
        fullCoordsForNoseAndOutline.add(new PointF(list.get(83).x + (((middlePoint3.x - list.get(83).x) * distance5) / distance6), list.get(83).y + (((middlePoint3.y - list.get(83).y) * distance5) / distance6)));
        return fullCoordsForNoseAndOutline;
    }

    public static FeatureType getFeatureType(int i3) {
        for (FeatureType featureType : FeatureType.values()) {
            if (featureType.value == i3) {
                return featureType;
            }
        }
        return FeatureType.NO_EYE;
    }

    public static List<PointF> getFullCoords(List<PointF> list) {
        double d16;
        PointF pointF;
        char c16;
        if (!CollectionUtils.isEmpty(list) && list.size() >= 90) {
            PointF pointF2 = list.get(83);
            double atan = Math.atan((list.get(9).x - list.get(83).x) / ((-list.get(9).y) + list.get(83).y));
            double distance = AlgoUtils.getDistance(list.get(0), list.get(1)) * 2.0f;
            PointF pointF3 = new PointF((float) (list.get(1).x + (Math.sin(atan) * distance)), (float) (list.get(1).y - (distance * Math.cos(atan))));
            list.add(pointF3);
            double distance2 = AlgoUtils.getDistance(list.get(17), list.get(18)) * 2.0f;
            PointF pointF4 = new PointF((float) (list.get(17).x + (Math.sin(atan) * distance2)), (float) (list.get(17).y - (distance2 * Math.cos(atan))));
            list.add(pointF4);
            double distance3 = ((float) (AlgoUtils.getDistance(list.get(59), pointF2) * 1.2d)) * 2.0f;
            PointF pointF5 = new PointF((float) (list.get(59).x + (Math.sin(atan) * distance3)), (float) (list.get(59).y - (distance3 * Math.cos(atan))));
            for (int i3 = 2; i3 >= 1; i3--) {
                double radians = Math.toRadians(i3 * 30.0f);
                PointF pointF6 = new PointF();
                pointF6.x = (float) (pointF5.x - ((r10 - pointF4.x) * Math.cos(radians)));
                pointF6.y = (float) (pointF4.y - ((r10 - pointF5.y) * Math.sin(radians)));
                list.add(pointF6);
            }
            for (int i16 = 3; i16 >= 1; i16--) {
                double radians2 = Math.toRadians(i16 * 30.0f);
                PointF pointF7 = new PointF();
                pointF7.x = (float) (pointF5.x - ((r12 - pointF3.x) * Math.cos(radians2)));
                pointF7.y = (float) (pointF3.y - ((r1 - pointF5.y) * Math.sin(radians2)));
                list.add(pointF7);
            }
            list.add(EMPTY_POINT);
            list.add(EMPTY_POINT);
            PointF pointF8 = list.get(64);
            PointF pointF9 = list.get(54);
            PointF pointF10 = list.get(44);
            PointF pointF11 = new PointF(pointF9.x - pointF10.x, pointF9.y - pointF10.y);
            float f16 = pointF11.x;
            float f17 = pointF11.y;
            PointF pointF12 = new PointF(f16 + f16, f17 + f17);
            PointF pointF13 = new PointF(-pointF12.y, pointF12.x);
            list.add(new PointF((pointF8.x - pointF12.x) - pointF13.x, (pointF8.y - pointF12.y) - pointF13.y));
            list.add(new PointF(pointF8.x - pointF12.x, pointF8.y - pointF12.y));
            list.add(new PointF((pointF8.x - pointF12.x) + pointF13.x, (pointF8.y - pointF12.y) + pointF13.y));
            list.add(new PointF(pointF8.x + pointF13.x, pointF8.y + pointF13.y));
            list.add(new PointF(pointF8.x + pointF12.x + pointF13.x, pointF8.y + pointF12.y + pointF13.y));
            list.add(new PointF(pointF8.x + pointF12.x, pointF8.y + pointF12.y));
            list.add(new PointF((pointF8.x + pointF12.x) - pointF13.x, (pointF8.y + pointF12.y) - pointF13.y));
            list.add(new PointF(pointF8.x - pointF13.x, pointF8.y - pointF13.y));
            list.get(3);
            list.get(15);
            list.get(65);
            list.get(66);
            PointF middlePoint = AlgoUtils.middlePoint(list.get(3), list.get(65));
            list.add(new PointF(middlePoint.x, middlePoint.y));
            PointF middlePoint2 = AlgoUtils.middlePoint(list.get(15), list.get(66));
            list.add(new PointF(middlePoint2.x, middlePoint2.y));
            list.get(2);
            list.get(16);
            list.get(39);
            list.get(49);
            list.get(57);
            list.get(61);
            char c17 = '#';
            list.get(35);
            list.get(45);
            PointF middlePoint3 = AlgoUtils.middlePoint(list.get(35), list.get(57));
            list.add(new PointF(middlePoint3.x, middlePoint3.y));
            PointF middlePoint4 = AlgoUtils.middlePoint(list.get(45), list.get(61));
            list.add(new PointF(middlePoint4.x, middlePoint4.y));
            list.get(37);
            PointF pointF14 = list.get(44);
            int i17 = 35;
            while (true) {
                d16 = 1.0d;
                if (i17 >= 39) {
                    break;
                }
                PointF pointF15 = list.get(i17);
                if (Math.abs(pointF15.x - pointF14.x) < 1.0d) {
                    list.add(new PointF(pointF15.x, (float) (pointF15.y + ((r12 - pointF14.y) * 0.7d))));
                    c16 = c17;
                    pointF = pointF14;
                } else {
                    float f18 = pointF15.y;
                    float f19 = pointF14.y;
                    float f26 = pointF15.x;
                    float f27 = pointF14.x;
                    pointF = pointF14;
                    float f28 = (float) (f26 + ((f26 - f27) * 0.7d));
                    float f29 = (((f18 - f19) / (f26 - f27)) * (f28 - f27)) + f19;
                    c16 = '#';
                    if (i17 == 35 && f28 < list.get(0).x) {
                        f28 = list.get(0).x;
                    }
                    list.add(new PointF(f28, f29));
                }
                i17++;
                c17 = c16;
                pointF14 = pointF;
            }
            PointF pointF16 = pointF14;
            PointF middlePoint5 = AlgoUtils.middlePoint(list.get(39), list.get(55));
            list.add(new PointF(middlePoint5.x, middlePoint5.y));
            int size = list.size();
            int i18 = 40;
            while (i18 < 43) {
                PointF pointF17 = list.get(i18);
                PointF pointF18 = pointF16;
                if (Math.abs(pointF17.x - pointF18.x) < d16) {
                    list.add(new PointF(pointF17.x, (float) (pointF17.y + ((r3 - pointF18.y) * 1.2d))));
                } else {
                    float f36 = pointF17.y;
                    float f37 = pointF18.y;
                    float f38 = pointF17.x;
                    float f39 = pointF18.x;
                    float f46 = (f36 - f37) / (f38 - f39);
                    float f47 = (float) (f38 + ((f38 - f39) * 1.2d));
                    list.add(new PointF(f47, (f46 * (f47 - f39)) + f37));
                }
                i18++;
                pointF16 = pointF18;
                d16 = 1.0d;
            }
            PointF pointF19 = list.get(size);
            PointF pointF20 = list.get(size + 1);
            PointF pointF21 = list.get(size + 2);
            PointF middlePoint6 = AlgoUtils.middlePoint(pointF19, pointF20);
            PointF middlePoint7 = AlgoUtils.middlePoint(pointF21, pointF20);
            list.add(new PointF(middlePoint6.x, middlePoint6.y));
            list.add(new PointF(middlePoint7.x, middlePoint7.y));
            PointF pointF22 = list.get(54);
            for (int i19 = 45; i19 < 49; i19++) {
                PointF pointF23 = list.get(i19);
                if (Math.abs(pointF23.x - pointF22.x) < 1.0d) {
                    list.add(new PointF(pointF23.x, (float) (pointF23.y + ((r3 - pointF22.y) * 0.7d))));
                } else {
                    float f48 = pointF23.y;
                    float f49 = pointF22.y;
                    float f56 = pointF23.x;
                    float f57 = pointF22.x;
                    float f58 = (f48 - f49) / (f56 - f57);
                    float f59 = (float) (f56 + ((f56 - f57) * 0.7d));
                    float f65 = (f58 * (f59 - f57)) + f49;
                    if (i19 == 45 && f59 > list.get(18).x) {
                        f59 = list.get(18).x;
                    }
                    list.add(new PointF(f59, f65));
                }
            }
            PointF middlePoint8 = AlgoUtils.middlePoint(list.get(49), list.get(63));
            list.add(new PointF(middlePoint8.x, middlePoint8.y));
            int size2 = list.size();
            for (int i26 = 50; i26 < 53; i26++) {
                PointF pointF24 = list.get(i26);
                if (Math.abs(pointF24.x - pointF22.x) < 1.0d) {
                    list.add(new PointF(pointF24.x, (float) (pointF24.y + ((r4 - pointF22.y) * 1.2d))));
                } else {
                    float f66 = pointF24.y;
                    float f67 = pointF22.y;
                    float f68 = pointF24.x;
                    float f69 = pointF22.x;
                    float f75 = (f66 - f67) / (f68 - f69);
                    float f76 = (float) (f68 + ((f68 - f69) * 1.2d));
                    list.add(new PointF(f76, (f75 * (f76 - f69)) + f67));
                }
            }
            PointF pointF25 = list.get(size2);
            PointF pointF26 = list.get(size2 + 1);
            PointF pointF27 = list.get(size2 + 2);
            PointF middlePoint9 = AlgoUtils.middlePoint(pointF25, pointF26);
            PointF middlePoint10 = AlgoUtils.middlePoint(pointF27, pointF26);
            list.add(new PointF(middlePoint9.x, middlePoint9.y));
            list.add(new PointF(middlePoint10.x, middlePoint10.y));
            return list;
        }
        return new ArrayList();
    }

    public static List<PointF> getFullCoords4BeautyFaceList(List<PointF> list, float f16) {
        float f17;
        float cos;
        float f18;
        int i3;
        PointF pointF;
        float cos2;
        float f19;
        if (!CollectionUtils.isEmpty(list) && list.size() >= 90) {
            List<PointF> subList = list.size() > 90 ? list.subList(0, 90) : list;
            PointF pointF2 = subList.get(0);
            int i16 = 1;
            PointF pointF3 = subList.get(1);
            PointF pointF4 = subList.get(9);
            PointF pointF5 = subList.get(83);
            float f26 = pointF5.x - pointF4.x;
            float f27 = pointF5.y - pointF4.y;
            float sqrt = (float) Math.sqrt((f26 * f26) + (f27 * f27));
            float f28 = (-f27) / sqrt;
            float f29 = f26 / sqrt;
            float atan2 = (float) (Math.atan2(f26, f27) + 3.141592653589793d);
            PointF pointF6 = new PointF();
            float distance = AlgoUtils.getDistance(pointF2, pointF3) * 2.0f;
            pointF6.x = pointF3.x + (distance * f29);
            pointF6.y = pointF3.y - (distance * f28);
            subList.add(pointF6);
            PointF pointF7 = new PointF();
            PointF pointF8 = subList.get(17);
            PointF pointF9 = subList.get(18);
            float distance2 = AlgoUtils.getDistance(pointF8, pointF9) * 2.0f;
            pointF7.x = pointF8.x + (distance2 * f29);
            pointF7.y = pointF8.y - (distance2 * f28);
            subList.add(pointF7);
            PointF pointF10 = new PointF();
            PointF pointF11 = subList.get(59);
            PointF pointF12 = new PointF(pointF5.x, pointF5.y);
            float distance3 = AlgoUtils.getDistance(pointF11, pointF12) * 1.2f * 2.0f;
            pointF10.x = pointF11.x + (f29 * distance3);
            pointF10.y = pointF11.y - (distance3 * f28);
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.postTranslate(-pointF12.x, -pointF12.y);
            matrix.postRotate((float) Math.toDegrees(-atan2));
            matrix.postTranslate(pointF12.x, pointF12.y);
            int i17 = 2;
            while (true) {
                f17 = 30.0f;
                if (i17 < i16) {
                    break;
                }
                float radians = (float) Math.toRadians(i17 * 30.0f);
                PointF pointF13 = new PointF();
                float distance4 = AlgoUtils.getDistance(pointF10, pointF5);
                float f36 = atan2;
                double d16 = radians;
                pointF13.x = (float) (pointF5.x + (AlgoUtils.getDistance(pointF7, pointF5) * Math.cos(d16)));
                pointF13.y = (float) (pointF5.y - (distance4 * Math.sin(d16)));
                PointF mapPoint = AlgoUtils.mapPoint(pointF13, matrix);
                subList.add(new PointF(mapPoint.x, mapPoint.y));
                i17--;
                atan2 = f36;
                pointF7 = pointF7;
                pointF9 = pointF9;
                pointF6 = pointF6;
                i16 = 1;
            }
            float f37 = atan2;
            PointF pointF14 = pointF6;
            PointF pointF15 = pointF9;
            subList.add(pointF10);
            int i18 = 2;
            int i19 = 1;
            while (i18 >= i19) {
                float radians2 = (float) Math.toRadians(i18 * f17);
                PointF pointF16 = new PointF();
                float distance5 = AlgoUtils.getDistance(pointF10, pointF5);
                Matrix matrix2 = matrix;
                double d17 = radians2;
                pointF16.x = (float) (pointF5.x - (AlgoUtils.getDistance(pointF14, pointF5) * Math.cos(d17)));
                pointF16.y = (float) (pointF5.y - (distance5 * Math.sin(d17)));
                PointF mapPoint2 = AlgoUtils.mapPoint(pointF16, matrix2);
                subList.add(new PointF(mapPoint2.x, mapPoint2.y));
                i18--;
                matrix = matrix2;
                pointF10 = pointF10;
                i19 = 1;
                f17 = 30.0f;
            }
            subList.add(new PointF(0.0f, 0.0f));
            subList.add(new PointF(0.0f, 0.0f));
            PointF pointF17 = subList.get(64);
            PointF pointF18 = subList.get(54);
            PointF pointF19 = subList.get(44);
            PointF pointF20 = new PointF(pointF18.x - pointF19.x, pointF18.y - pointF19.y);
            PointF pointF21 = new PointF(pointF20.x * f16, pointF20.y * f16);
            PointF pointF22 = new PointF(-pointF21.y, pointF21.x);
            subList.add(new PointF((pointF17.x - pointF21.x) - pointF22.x, (pointF17.y - pointF21.y) - pointF22.y));
            subList.add(new PointF(pointF17.x - pointF21.x, pointF17.y - pointF21.y));
            subList.add(new PointF((pointF17.x - pointF21.x) + pointF22.x, (pointF17.y - pointF21.y) + pointF22.y));
            subList.add(new PointF(pointF17.x + pointF22.x, pointF17.y + pointF22.y));
            subList.add(new PointF(pointF17.x + pointF21.x + pointF22.x, pointF17.y + pointF21.y + pointF22.y));
            subList.add(new PointF(pointF17.x + pointF21.x, pointF17.y + pointF21.y));
            subList.add(new PointF((pointF17.x + pointF21.x) - pointF22.x, (pointF17.y + pointF21.y) - pointF22.y));
            subList.add(new PointF(pointF17.x - pointF22.x, pointF17.y - pointF22.y));
            PointF pointF23 = subList.get(3);
            PointF pointF24 = subList.get(15);
            PointF pointF25 = subList.get(65);
            PointF pointF26 = subList.get(66);
            PointF middlePoint = AlgoUtils.middlePoint(pointF23, pointF25);
            subList.add(new PointF(middlePoint.x, middlePoint.y));
            PointF middlePoint2 = AlgoUtils.middlePoint(pointF24, pointF26);
            subList.add(new PointF(middlePoint2.x, middlePoint2.y));
            int i26 = 39;
            PointF pointF27 = subList.get(39);
            PointF pointF28 = subList.get(49);
            PointF pointF29 = subList.get(57);
            PointF pointF30 = subList.get(61);
            int i27 = 35;
            PointF pointF31 = subList.get(35);
            PointF middlePoint3 = AlgoUtils.middlePoint(pointF31, pointF29);
            subList.add(new PointF(middlePoint3.x, middlePoint3.y));
            PointF pointF32 = subList.get(45);
            PointF middlePoint4 = AlgoUtils.middlePoint(pointF32, pointF30);
            subList.add(new PointF(middlePoint4.x, middlePoint4.y));
            PointF pointF33 = subList.get(43);
            PointF pointF34 = subList.get(55);
            PointF pointF35 = subList.get(41);
            PointF pointF36 = subList.get(37);
            float distance6 = AlgoUtils.getDistance(pointF31, pointF27);
            AlgoUtils.getDistance(pointF35, pointF36);
            float f38 = distance6 / 50.0f;
            int i28 = 35;
            while (i28 < i26) {
                PointF pointF37 = subList.get(i28);
                int i29 = i28 - 37;
                float f39 = f37;
                float sin = (float) (Math.sin(((2.0f - Math.abs(i29)) * 3.141592653589793d) / 4.0d) * 0.3d);
                if (i28 == i27) {
                    float f46 = pointF37.y;
                    float f47 = pointF33.y;
                    float f48 = pointF37.x;
                    float f49 = pointF33.x;
                    float f56 = (f46 - f47) / (f48 - f49);
                    i3 = i28;
                    f19 = (float) (f48 + ((f48 - f49) * 0.9d));
                    cos2 = (f56 * (f19 - f49)) + f47;
                    pointF = pointF28;
                } else {
                    i3 = i28;
                    double d18 = (sin + 1.0f) * 10.0f * f38;
                    pointF = pointF28;
                    double radians3 = f39 + ((float) Math.toRadians(i29 * 60.0f));
                    float sin2 = (float) (pointF37.x + (Math.sin(radians3) * d18));
                    cos2 = (float) (pointF37.y + (d18 * Math.cos(radians3)));
                    f19 = sin2;
                }
                int i36 = i3;
                if (i36 == 35) {
                    float f57 = pointF2.x;
                    if (f19 < f57) {
                        f19 = f57;
                    }
                }
                subList.add(new PointF(f19, cos2));
                i28 = i36 + 1;
                pointF28 = pointF;
                f37 = f39;
                i26 = 39;
                i27 = 35;
            }
            PointF pointF38 = pointF28;
            float f58 = f37;
            PointF middlePoint5 = AlgoUtils.middlePoint(pointF27, pointF34);
            subList.add(new PointF(middlePoint5.x, middlePoint5.y));
            int size = subList.size();
            for (int i37 = 40; i37 < 43; i37++) {
                PointF pointF39 = subList.get(i37);
                int i38 = i37 - 41;
                float radians4 = (float) Math.toRadians(i38 * 60.0f);
                double sin3 = 16.0f * f38 * (((float) (Math.sin(((3.0f - Math.abs(i38)) * 3.141592653589793d) / 2.0d) * 0.3d)) + 1.0f);
                double d19 = f58 + radians4;
                subList.add(new PointF((float) (pointF39.x - (Math.sin(d19) * sin3)), (float) (pointF39.y - (sin3 * Math.cos(d19)))));
            }
            PointF pointF40 = subList.get(size);
            PointF pointF41 = subList.get(size + 1);
            PointF pointF42 = subList.get(size + 2);
            subList.add(AlgoUtils.middlePoint(pointF40, pointF41));
            subList.add(AlgoUtils.middlePoint(pointF42, pointF41));
            subList.get(51);
            subList.get(47);
            PointF pointF43 = subList.get(53);
            PointF pointF44 = subList.get(63);
            float distance7 = AlgoUtils.getDistance(pointF32, pointF38) / 50.0f;
            int i39 = 45;
            while (i39 < 49) {
                PointF pointF45 = subList.get(i39);
                int i46 = i39 - 47;
                float sin4 = (float) (Math.sin(((2.0f - Math.abs(i46)) * 3.141592653589793d) / 4.0d) * 0.3d);
                if (i39 == 45) {
                    float f59 = pointF45.y;
                    float f65 = pointF43.y;
                    float f66 = pointF45.x;
                    float f67 = pointF43.x;
                    float f68 = (f59 - f65) / (f66 - f67);
                    f18 = (float) (f66 + ((f66 - f67) * 0.9d));
                    cos = (f68 * (f18 - f67)) + f65;
                } else {
                    double d26 = distance7 * 10.0f * (sin4 + 1.0f);
                    double radians5 = f58 - ((float) Math.toRadians(i46 * 60.0f));
                    float sin5 = (float) (pointF45.x + (Math.sin(radians5) * d26));
                    cos = (float) (pointF45.y + (d26 * Math.cos(radians5)));
                    f18 = sin5;
                }
                PointF pointF46 = pointF15;
                if (i39 == 45) {
                    float f69 = pointF46.x;
                    if (f18 > f69) {
                        f18 = f69;
                    }
                }
                subList.add(new PointF(f18, cos));
                i39++;
                pointF15 = pointF46;
            }
            PointF middlePoint6 = AlgoUtils.middlePoint(pointF38, pointF44);
            subList.add(new PointF(middlePoint6.x, middlePoint6.y));
            int size2 = subList.size();
            for (int i47 = 50; i47 < 53; i47++) {
                PointF pointF47 = subList.get(i47);
                int i48 = i47 - 51;
                float radians6 = (float) Math.toRadians(i48 * 60.0f);
                double sin6 = 16.0f * distance7 * (((float) (Math.sin(((3.0f - Math.abs(i48)) * 3.141592653589793d) / 2.0d) * 0.3d)) + 1.0f);
                double d27 = f58 - radians6;
                subList.add(new PointF((float) (pointF47.x - (Math.sin(d27) * sin6)), (float) (pointF47.y - (sin6 * Math.cos(d27)))));
            }
            PointF pointF48 = subList.get(size2);
            PointF pointF49 = subList.get(size2 + 1);
            PointF pointF50 = subList.get(size2 + 2);
            subList.add(AlgoUtils.middlePoint(pointF48, pointF49));
            subList.add(AlgoUtils.middlePoint(pointF50, pointF49));
            return subList;
        }
        return new ArrayList();
    }

    public static List<PointF> getFullCoordsForFaceOffFilter(List<PointF> list, float f16) {
        float f17;
        float f18;
        float f19;
        double d16;
        float cos;
        float f26;
        float sin;
        float cos2;
        if (!CollectionUtils.isEmpty(list) && list.size() >= 90) {
            PointF pointF = new PointF((list.get(41).x + list.get(51).x) / 2.0f, (list.get(41).y + list.get(51).y) / 2.0f);
            double atan2 = Math.atan2(list.get(9).x - list.get(84).x, (-list.get(9).y) + list.get(84).y) + 3.141592653589793d;
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.postTranslate(-pointF.x, -pointF.y);
            matrix.postRotate((float) Math.toDegrees(-atan2));
            matrix.postTranslate(pointF.x, pointF.y);
            List<PointF> mapPoints = AlgoUtils.mapPoints(list, matrix);
            int i3 = 1;
            double distance = AlgoUtils.getDistance(mapPoints.get(0), mapPoints.get(1)) * 2.0f;
            PointF pointF2 = new PointF((float) (mapPoints.get(1).x + (Math.sin(0.0d) * distance)), (float) (mapPoints.get(1).y - (distance * Math.cos(0.0d))));
            mapPoints.add(pointF2);
            double distance2 = AlgoUtils.getDistance(mapPoints.get(17), mapPoints.get(18)) * 2.0f;
            PointF pointF3 = new PointF((float) (mapPoints.get(17).x + (Math.sin(0.0d) * distance2)), (float) (mapPoints.get(17).y - (distance2 * Math.cos(0.0d))));
            mapPoints.add(pointF3);
            double distance3 = AlgoUtils.getDistance(mapPoints.get(59), pointF) * 2.0f;
            PointF pointF4 = new PointF((float) (mapPoints.get(59).x + (Math.sin(0.0d) * distance3)), (float) (mapPoints.get(59).y - (distance3 * Math.cos(0.0d))));
            int i16 = 2;
            while (true) {
                f17 = 30.0f;
                if (i16 < i3) {
                    break;
                }
                double radians = Math.toRadians(i16 * 30.0f);
                PointF pointF5 = new PointF();
                pointF5.x = (float) (pointF4.x - ((r15 - pointF3.x) * Math.cos(radians)));
                pointF5.y = (float) (pointF3.y - ((r9 - pointF4.y) * Math.sin(radians)));
                mapPoints.add(pointF5);
                i16--;
                pointF2 = pointF2;
                i3 = 1;
            }
            PointF pointF6 = pointF2;
            int i17 = 3;
            while (i17 >= 1) {
                double radians2 = Math.toRadians(i17 * f17);
                PointF pointF7 = new PointF();
                pointF7.x = (float) (pointF4.x - ((r12 - pointF6.x) * Math.cos(radians2)));
                pointF7.y = (float) (pointF6.y - ((r5 - pointF4.y) * Math.sin(radians2)));
                mapPoints.add(pointF7);
                i17--;
                atan2 = atan2;
                f17 = 30.0f;
            }
            double d17 = atan2;
            mapPoints.add(EMPTY_POINT);
            mapPoints.add(EMPTY_POINT);
            PointF pointF8 = mapPoints.get(64);
            PointF pointF9 = mapPoints.get(54);
            PointF pointF10 = mapPoints.get(44);
            PointF pointF11 = new PointF(pointF9.x - pointF10.x, pointF9.y - pointF10.y);
            PointF pointF12 = new PointF(pointF11.x * f16, pointF11.y * f16);
            PointF pointF13 = new PointF(-pointF12.y, pointF12.x);
            mapPoints.add(new PointF((pointF8.x - pointF12.x) - pointF13.x, (pointF8.y - pointF12.y) - pointF13.y));
            mapPoints.add(new PointF(pointF8.x - pointF12.x, pointF8.y - pointF12.y));
            mapPoints.add(new PointF((pointF8.x - pointF12.x) + pointF13.x, (pointF8.y - pointF12.y) + pointF13.y));
            mapPoints.add(new PointF(pointF8.x + pointF13.x, pointF8.y + pointF13.y));
            mapPoints.add(new PointF(pointF8.x + pointF12.x + pointF13.x, pointF8.y + pointF12.y + pointF13.y));
            mapPoints.add(new PointF(pointF8.x + pointF12.x, pointF8.y + pointF12.y));
            mapPoints.add(new PointF((pointF8.x + pointF12.x) - pointF13.x, (pointF8.y + pointF12.y) - pointF13.y));
            mapPoints.add(new PointF(pointF8.x - pointF13.x, pointF8.y - pointF13.y));
            mapPoints.get(3);
            mapPoints.get(15);
            mapPoints.get(65);
            mapPoints.get(66);
            PointF middlePoint = AlgoUtils.middlePoint(mapPoints.get(3), mapPoints.get(65));
            mapPoints.add(new PointF(middlePoint.x, middlePoint.y));
            PointF middlePoint2 = AlgoUtils.middlePoint(mapPoints.get(15), mapPoints.get(66));
            mapPoints.add(new PointF(middlePoint2.x, middlePoint2.y));
            mapPoints.get(2);
            mapPoints.get(16);
            int i18 = 39;
            PointF pointF14 = mapPoints.get(39);
            mapPoints.get(57);
            mapPoints.get(61);
            PointF pointF15 = mapPoints.get(35);
            PointF middlePoint3 = AlgoUtils.middlePoint(mapPoints.get(35), mapPoints.get(57));
            mapPoints.add(new PointF(middlePoint3.x, middlePoint3.y));
            PointF middlePoint4 = AlgoUtils.middlePoint(mapPoints.get(45), mapPoints.get(61));
            mapPoints.add(new PointF(middlePoint4.x, middlePoint4.y));
            PointF pointF16 = mapPoints.get(43);
            mapPoints.get(55);
            PointF pointF17 = mapPoints.get(41);
            PointF pointF18 = mapPoints.get(37);
            float distance4 = AlgoUtils.getDistance(pointF15, pointF14);
            AlgoUtils.getDistance(pointF17, pointF18);
            float f27 = distance4 / 50.0f;
            int i19 = 35;
            while (true) {
                f18 = 1.0f;
                f19 = 60.0f;
                d16 = 0.3d;
                if (i19 >= i18) {
                    break;
                }
                PointF pointF19 = mapPoints.get(i19);
                int i26 = i19 - 37;
                float f28 = f27;
                float sin2 = (float) (Math.sin(((2.0f - Math.abs(i26)) * 3.141592653589793d) / 4.0d) * 0.3d);
                if (i19 == 35) {
                    float f29 = pointF19.y;
                    float f36 = pointF16.y;
                    float f37 = pointF19.x;
                    float f38 = pointF16.x;
                    float f39 = (f29 - f36) / (f37 - f38);
                    sin = f37 + ((f37 - f38) * 0.9f);
                    cos2 = (f39 * (sin - f38)) + f36;
                } else {
                    float radians3 = (float) Math.toRadians(i26 * 60.0f);
                    double d18 = 10.0f * f28 * (sin2 + 1.0f);
                    double d19 = 0.0d + radians3;
                    sin = (float) (pointF19.x + (Math.sin(d19) * d18));
                    cos2 = (float) (pointF19.y + (d18 * Math.cos(d19)));
                }
                if (i19 == 35 && sin < mapPoints.get(0).x) {
                    sin = mapPoints.get(0).x;
                }
                mapPoints.add(new PointF(sin, cos2));
                i19++;
                f27 = f28;
                i18 = 39;
            }
            float f46 = f27;
            PointF middlePoint5 = AlgoUtils.middlePoint(mapPoints.get(i18), mapPoints.get(55));
            mapPoints.add(new PointF(middlePoint5.x, middlePoint5.y));
            int size = mapPoints.size();
            int i27 = 40;
            while (i27 < 43) {
                PointF pointF20 = mapPoints.get(i27);
                int i28 = i27 - 41;
                float radians4 = (float) Math.toRadians(i28 * f19);
                double sin3 = 16.0f * f46 * (((float) (Math.sin(((3.0f - Math.abs(i28)) * 3.141592653589793d) / 2.0d) * d16)) + f18);
                double d26 = 0.0d + radians4;
                mapPoints.add(new PointF((float) (pointF20.x - (Math.sin(d26) * sin3)), (float) (pointF20.y - (sin3 * Math.cos(d26)))));
                i27++;
                f18 = 1.0f;
                f19 = 60.0f;
                d16 = 0.3d;
            }
            PointF pointF21 = mapPoints.get(size);
            PointF pointF22 = mapPoints.get(size + 1);
            PointF pointF23 = mapPoints.get(size + 2);
            PointF middlePoint6 = AlgoUtils.middlePoint(pointF21, pointF22);
            PointF middlePoint7 = AlgoUtils.middlePoint(pointF23, pointF22);
            mapPoints.add(new PointF(middlePoint6.x, middlePoint6.y));
            mapPoints.add(new PointF(middlePoint7.x, middlePoint7.y));
            PointF pointF24 = mapPoints.get(51);
            PointF pointF25 = mapPoints.get(47);
            PointF pointF26 = mapPoints.get(54);
            mapPoints.get(63);
            float distance5 = AlgoUtils.getDistance(mapPoints.get(45), mapPoints.get(49));
            AlgoUtils.getDistance(pointF24, pointF25);
            float f47 = distance5 / 50.0f;
            for (int i29 = 45; i29 < 49; i29++) {
                PointF pointF27 = mapPoints.get(i29);
                int i36 = i29 - 47;
                float sin4 = (float) (Math.sin(((2.0f - Math.abs(i36)) * 3.141592653589793d) / 4.0d) * 0.3d);
                if (i29 == 45) {
                    float f48 = pointF27.y;
                    float f49 = pointF26.y;
                    float f56 = pointF27.x;
                    float f57 = pointF26.x;
                    float f58 = (f48 - f49) / (f56 - f57);
                    f26 = f56 + ((f56 - f57) * 0.9f);
                    cos = (f58 * (f26 - f57)) + f49;
                } else {
                    double d27 = 10.0f * f47 * (sin4 + 1.0f);
                    double radians5 = 0.0d - ((float) Math.toRadians(i36 * 60.0f));
                    float sin5 = (float) (pointF27.x + (Math.sin(radians5) * d27));
                    cos = (float) (pointF27.y + (d27 * Math.cos(radians5)));
                    f26 = sin5;
                }
                if (i29 == 45 && f26 > mapPoints.get(18).x) {
                    f26 = mapPoints.get(18).x;
                }
                mapPoints.add(new PointF(f26, cos));
            }
            PointF middlePoint8 = AlgoUtils.middlePoint(mapPoints.get(49), mapPoints.get(63));
            mapPoints.add(new PointF(middlePoint8.x, middlePoint8.y));
            int size2 = mapPoints.size();
            for (int i37 = 50; i37 < 53; i37++) {
                PointF pointF28 = mapPoints.get(i37);
                int i38 = i37 - 51;
                float radians6 = (float) Math.toRadians(i38 * 60.0f);
                double sin6 = 16.0f * f47 * (((float) (Math.sin(((3.0f - Math.abs(i38)) * 3.141592653589793d) / 2.0d) * 0.3d)) + 1.0f);
                double d28 = 0.0d - radians6;
                mapPoints.add(new PointF((float) (pointF28.x - (Math.sin(d28) * sin6)), (float) (pointF28.y - (sin6 * Math.cos(d28)))));
            }
            PointF pointF29 = mapPoints.get(size2);
            PointF pointF30 = mapPoints.get(size2 + 1);
            PointF pointF31 = mapPoints.get(size2 + 2);
            PointF middlePoint9 = AlgoUtils.middlePoint(pointF29, pointF30);
            PointF middlePoint10 = AlgoUtils.middlePoint(pointF31, pointF30);
            mapPoints.add(new PointF(middlePoint9.x, middlePoint9.y));
            mapPoints.add(new PointF(middlePoint10.x, middlePoint10.y));
            matrix.reset();
            matrix.postTranslate(-pointF.x, -pointF.y);
            matrix.postRotate((float) Math.toDegrees(d17));
            matrix.postTranslate(pointF.x, pointF.y);
            return AlgoUtils.mapPoints(mapPoints, matrix);
        }
        return new ArrayList();
    }

    public static List<PointF> getFullCoordsForNoseAndOutline(List<PointF> list) {
        double d16;
        Matrix matrix;
        float f16;
        float f17;
        double d17;
        float cos;
        float f18;
        int i3;
        float sin;
        float cos2;
        if (!CollectionUtils.isEmpty(list) && list.size() >= 90) {
            if (list.size() > 97) {
                list.subList(97, list.size()).clear();
            }
            if (list.size() != 90 && list.size() != 97) {
                return list;
            }
            PointF pointF = new PointF((list.get(41).x + list.get(51).x) / 2.0f, (list.get(41).y + list.get(51).y) / 2.0f);
            double atan2 = Math.atan2(list.get(9).x - list.get(84).x, (-list.get(9).y) + list.get(84).y) + 3.141592653589793d;
            Matrix matrix2 = new Matrix();
            matrix2.reset();
            matrix2.postTranslate(-pointF.x, -pointF.y);
            matrix2.postRotate((float) Math.toDegrees(-atan2));
            matrix2.postTranslate(pointF.x, pointF.y);
            List<PointF> mapPoints = AlgoUtils.mapPoints(list, matrix2);
            int i16 = 1;
            if (mapPoints.size() == 90) {
                double distance = AlgoUtils.getDistance(mapPoints.get(0), mapPoints.get(1)) * 2.0f;
                PointF pointF2 = new PointF((float) (mapPoints.get(1).x + (Math.sin(0.0d) * distance)), (float) (mapPoints.get(1).y - (distance * Math.cos(0.0d))));
                mapPoints.add(pointF2);
                double distance2 = AlgoUtils.getDistance(mapPoints.get(17), mapPoints.get(18)) * 2.0f;
                PointF pointF3 = new PointF((float) (mapPoints.get(17).x + (Math.sin(0.0d) * distance2)), (float) (mapPoints.get(17).y - (distance2 * Math.cos(0.0d))));
                mapPoints.add(pointF3);
                d16 = atan2;
                double distance3 = AlgoUtils.getDistance(mapPoints.get(59), pointF) * 2.0f;
                PointF pointF4 = new PointF((float) (mapPoints.get(59).x + (Math.sin(0.0d) * distance3)), (float) (mapPoints.get(59).y - (distance3 * Math.cos(0.0d))));
                int i17 = 2;
                while (i17 >= i16) {
                    double radians = Math.toRadians(i17 * 30.0f);
                    PointF pointF5 = new PointF();
                    pointF5.x = (float) (pointF4.x - ((r9 - pointF3.x) * Math.cos(radians)));
                    pointF5.y = (float) (pointF3.y - ((r9 - pointF4.y) * Math.sin(radians)));
                    mapPoints.add(pointF5);
                    i17--;
                    matrix2 = matrix2;
                    i16 = 1;
                }
                matrix = matrix2;
                int i18 = 3;
                for (int i19 = i16; i18 >= i19; i19 = 1) {
                    double radians2 = Math.toRadians(i18 * 30.0f);
                    PointF pointF6 = new PointF();
                    pointF6.x = (float) (pointF4.x - ((r9 - pointF2.x) * Math.cos(radians2)));
                    pointF6.y = (float) (pointF2.y - ((r9 - pointF4.y) * Math.sin(radians2)));
                    mapPoints.add(pointF6);
                    i18--;
                }
            } else {
                d16 = atan2;
                matrix = matrix2;
            }
            mapPoints.add(EMPTY_POINT);
            mapPoints.add(EMPTY_POINT);
            PointF pointF7 = mapPoints.get(54);
            PointF pointF8 = mapPoints.get(44);
            PointF pointF9 = new PointF(pointF7.x - pointF8.x, pointF7.y - pointF8.y);
            PointF pointF10 = new PointF(pointF9.x, pointF9.y);
            PointF pointF11 = new PointF(-pointF10.y, pointF10.x);
            float distance4 = AlgoUtils.getDistance(pointF10, new PointF(0.0f, 0.0f));
            float distance5 = AlgoUtils.getDistance(pointF11, new PointF(0.0f, 0.0f));
            pointF10.x /= distance4;
            pointF10.y /= distance4;
            pointF11.x /= distance5;
            pointF11.y /= distance5;
            PointF pointF12 = mapPoints.get(64);
            float abs = Math.abs((pointF10.x * (mapPoints.get(17).x - mapPoints.get(56).x)) + (pointF10.y * (mapPoints.get(17).y - mapPoints.get(56).y))) * 2.0f;
            float abs2 = Math.abs((pointF10.x * (mapPoints.get(1).x - mapPoints.get(62).x)) + (pointF10.y * (mapPoints.get(1).y - mapPoints.get(62).y))) * 2.0f;
            float abs3 = Math.abs((pointF11.x * (mapPoints.get(9).x - pointF12.x)) + (pointF11.y * (mapPoints.get(9).y - pointF12.y))) * 2.0f;
            float abs4 = Math.abs((pointF11.x * (mapPoints.get(87).x - pointF12.x)) + (pointF11.y * (mapPoints.get(87).y - pointF12.y))) * 2.0f;
            mapPoints.add(new PointF((pointF12.x - (pointF10.x * abs2)) - (pointF11.x * abs4), (pointF12.y - (pointF10.y * abs2)) - (pointF11.y * abs4)));
            mapPoints.add(new PointF(pointF12.x - (pointF10.x * abs2), pointF12.y - (pointF10.y * abs2)));
            mapPoints.add(new PointF((pointF12.x - (pointF10.x * abs2)) + (pointF11.x * abs3), (pointF12.y - (pointF10.y * abs2)) + (pointF11.y * abs3)));
            mapPoints.add(new PointF(pointF12.x + (pointF11.x * abs3), pointF12.y + (pointF11.y * abs3)));
            mapPoints.add(new PointF(pointF12.x + (pointF10.x * abs) + (pointF11.x * abs3), pointF12.y + (pointF10.y * abs) + (pointF11.y * abs3)));
            mapPoints.add(new PointF(pointF12.x + (pointF10.x * abs), pointF12.y + (pointF10.y * abs)));
            mapPoints.add(new PointF((pointF12.x + (pointF10.x * abs)) - (pointF11.x * abs4), (pointF12.y + (pointF10.y * abs)) - (pointF11.y * abs4)));
            mapPoints.add(new PointF(pointF12.x - (pointF11.x * abs4), pointF12.y - (pointF11.y * abs4)));
            mapPoints.get(3);
            mapPoints.get(15);
            mapPoints.get(65);
            mapPoints.get(66);
            PointF middlePoint = AlgoUtils.middlePoint(mapPoints.get(3), mapPoints.get(65));
            mapPoints.add(new PointF(middlePoint.x, middlePoint.y));
            PointF middlePoint2 = AlgoUtils.middlePoint(mapPoints.get(15), mapPoints.get(66));
            mapPoints.add(new PointF(middlePoint2.x, middlePoint2.y));
            mapPoints.get(2);
            mapPoints.get(16);
            int i26 = 39;
            PointF pointF13 = mapPoints.get(39);
            mapPoints.get(57);
            mapPoints.get(61);
            PointF pointF14 = mapPoints.get(35);
            PointF middlePoint3 = AlgoUtils.middlePoint(mapPoints.get(35), mapPoints.get(57));
            mapPoints.add(new PointF(middlePoint3.x, middlePoint3.y));
            int i27 = 45;
            PointF middlePoint4 = AlgoUtils.middlePoint(mapPoints.get(45), mapPoints.get(61));
            mapPoints.add(new PointF(middlePoint4.x, middlePoint4.y));
            PointF pointF15 = mapPoints.get(43);
            mapPoints.get(55);
            PointF pointF16 = mapPoints.get(41);
            PointF pointF17 = mapPoints.get(37);
            float distance6 = AlgoUtils.getDistance(pointF14, pointF13);
            AlgoUtils.getDistance(pointF16, pointF17);
            float f19 = distance6 / 50.0f;
            int i28 = 35;
            while (true) {
                f16 = 1.0f;
                f17 = 60.0f;
                d17 = 0.3d;
                if (i28 >= i26) {
                    break;
                }
                PointF pointF18 = mapPoints.get(i28);
                int i29 = i28 - 37;
                float f26 = f19;
                float sin2 = (float) (Math.sin(((2.0f - Math.abs(i29)) * 3.141592653589793d) / 4.0d) * 0.3d);
                if (i28 == 35) {
                    float f27 = pointF18.y;
                    float f28 = pointF15.y;
                    float f29 = pointF18.x;
                    float f36 = pointF15.x;
                    float f37 = (f27 - f28) / (f29 - f36);
                    sin = f29 + ((f29 - f36) * 0.9f);
                    cos2 = (f37 * (sin - f36)) + f28;
                } else {
                    double d18 = 10.0f * f26 * (sin2 + 1.0f);
                    double radians3 = 0.0d + ((float) Math.toRadians(i29 * 60.0f));
                    sin = (float) (pointF18.x + (Math.sin(radians3) * d18));
                    cos2 = (float) (pointF18.y + (d18 * Math.cos(radians3)));
                }
                if (i28 == 35 && sin < mapPoints.get(0).x) {
                    sin = mapPoints.get(0).x;
                }
                mapPoints.add(new PointF(sin, cos2));
                i28++;
                f19 = f26;
                i26 = 39;
            }
            float f38 = f19;
            PointF middlePoint5 = AlgoUtils.middlePoint(mapPoints.get(i26), mapPoints.get(55));
            mapPoints.add(new PointF(middlePoint5.x, middlePoint5.y));
            int size = mapPoints.size();
            int i36 = 40;
            while (i36 < 43) {
                PointF pointF19 = mapPoints.get(i36);
                int i37 = i36 - 41;
                float radians4 = (float) Math.toRadians(i37 * f17);
                double sin3 = 16.0f * f38 * (((float) (Math.sin(((3.0f - Math.abs(i37)) * 3.141592653589793d) / 2.0d) * d17)) + f16);
                double d19 = 0.0d + radians4;
                mapPoints.add(new PointF((float) (pointF19.x - (Math.sin(d19) * sin3)), (float) (pointF19.y - (sin3 * Math.cos(d19)))));
                i36++;
                f16 = 1.0f;
                f17 = 60.0f;
                d17 = 0.3d;
            }
            PointF pointF20 = mapPoints.get(size);
            PointF pointF21 = mapPoints.get(size + 1);
            PointF pointF22 = mapPoints.get(size + 2);
            PointF middlePoint6 = AlgoUtils.middlePoint(pointF20, pointF21);
            PointF middlePoint7 = AlgoUtils.middlePoint(pointF22, pointF21);
            mapPoints.add(new PointF(middlePoint6.x, middlePoint6.y));
            mapPoints.add(new PointF(middlePoint7.x, middlePoint7.y));
            PointF pointF23 = mapPoints.get(51);
            PointF pointF24 = mapPoints.get(47);
            PointF pointF25 = mapPoints.get(54);
            mapPoints.get(63);
            float distance7 = AlgoUtils.getDistance(mapPoints.get(45), mapPoints.get(49));
            AlgoUtils.getDistance(pointF23, pointF24);
            float f39 = distance7 / 50.0f;
            int i38 = 45;
            while (i38 < 49) {
                PointF pointF26 = mapPoints.get(i38);
                int i39 = i38 - 47;
                float sin4 = (float) (Math.sin(((2.0f - Math.abs(i39)) * 3.141592653589793d) / 4.0d) * 0.3d);
                if (i38 == i27) {
                    float f46 = pointF26.y;
                    float f47 = pointF25.y;
                    float f48 = pointF26.x;
                    float f49 = pointF25.x;
                    float f56 = (f46 - f47) / (f48 - f49);
                    f18 = f48 + ((f48 - f49) * 0.9f);
                    cos = (f56 * (f18 - f49)) + f47;
                    i3 = i27;
                } else {
                    double d26 = 10.0f * f39 * (sin4 + 1.0f);
                    double radians5 = 0.0d - ((float) Math.toRadians(i39 * 60.0f));
                    float sin5 = (float) (pointF26.x + (Math.sin(radians5) * d26));
                    cos = (float) (pointF26.y + (d26 * Math.cos(radians5)));
                    f18 = sin5;
                    i3 = 45;
                }
                if (i38 == i3 && f18 > mapPoints.get(18).x) {
                    f18 = mapPoints.get(18).x;
                }
                mapPoints.add(new PointF(f18, cos));
                i38++;
                i27 = i3;
            }
            PointF middlePoint8 = AlgoUtils.middlePoint(mapPoints.get(49), mapPoints.get(63));
            mapPoints.add(new PointF(middlePoint8.x, middlePoint8.y));
            int size2 = mapPoints.size();
            for (int i46 = 50; i46 < 53; i46++) {
                PointF pointF27 = mapPoints.get(i46);
                int i47 = i46 - 51;
                float radians6 = (float) Math.toRadians(i47 * 60.0f);
                double sin6 = (((float) (Math.sin(((3.0f - Math.abs(i47)) * 3.141592653589793d) / 2.0d) * 0.3d)) + 1.0f) * 16.0f * f39;
                double d27 = 0.0d - radians6;
                mapPoints.add(new PointF((float) (pointF27.x - (Math.sin(d27) * sin6)), (float) (pointF27.y - (sin6 * Math.cos(d27)))));
            }
            PointF pointF28 = mapPoints.get(size2);
            PointF pointF29 = mapPoints.get(size2 + 1);
            PointF pointF30 = mapPoints.get(size2 + 2);
            PointF middlePoint9 = AlgoUtils.middlePoint(pointF28, pointF29);
            PointF middlePoint10 = AlgoUtils.middlePoint(pointF30, pointF29);
            mapPoints.add(new PointF(middlePoint9.x, middlePoint9.y));
            mapPoints.add(new PointF(middlePoint10.x, middlePoint10.y));
            matrix.reset();
            matrix.postTranslate(-pointF.x, -pointF.y);
            matrix.postRotate((float) Math.toDegrees(d16));
            matrix.postTranslate(pointF.x, pointF.y);
            return AlgoUtils.mapPoints(mapPoints, matrix);
        }
        return new ArrayList();
    }

    public static List<PointF> getFullCoords_v2(List<PointF> list, float f16, float f17, boolean z16) {
        double d16;
        boolean z17;
        boolean z18;
        PointF pointF;
        boolean z19;
        PointF pointF2;
        float min;
        int i3;
        PointF pointF3;
        Matrix matrix;
        PointF pointF4;
        float cos;
        float f18;
        PointF pointF5;
        PointF pointF6;
        PointF pointF7;
        float cos2;
        float f19;
        float min2;
        int i16;
        boolean z26;
        boolean z27;
        PointF pointF8;
        if (!CollectionUtils.isEmpty(list) && list.size() >= 90) {
            if (list.size() > 97) {
                list.subList(97, list.size()).clear();
            }
            if (list.size() != 90 && list.size() != 97) {
                return list;
            }
            PointF pointF9 = new PointF((list.get(41).x + list.get(51).x) / 2.0f, (list.get(41).y + list.get(51).y) / 2.0f);
            double atan2 = Math.atan2(list.get(9).x - list.get(84).x, (-list.get(9).y) + list.get(84).y) + 3.141592653589793d;
            Matrix matrix2 = new Matrix();
            matrix2.reset();
            matrix2.postTranslate(-pointF9.x, -pointF9.y);
            matrix2.postRotate((float) Math.toDegrees(-atan2));
            matrix2.postTranslate(pointF9.x, pointF9.y);
            List<PointF> mapPoints = AlgoUtils.mapPoints(list, matrix2);
            if (mapPoints.size() == 90) {
                d16 = atan2;
                double distance = AlgoUtils.getDistance(mapPoints.get(0), mapPoints.get(1)) * 2.0f;
                PointF pointF10 = new PointF((float) (mapPoints.get(1).x + (Math.sin(0.0d) * distance)), (float) (mapPoints.get(1).y - (distance * Math.cos(0.0d))));
                mapPoints.add(pointF10);
                double distance2 = AlgoUtils.getDistance(mapPoints.get(17), mapPoints.get(18)) * 2.0f;
                PointF pointF11 = new PointF((float) (mapPoints.get(17).x + (Math.sin(0.0d) * distance2)), (float) (mapPoints.get(17).y - (distance2 * Math.cos(0.0d))));
                mapPoints.add(pointF11);
                double distance3 = AlgoUtils.getDistance(mapPoints.get(59), pointF9) * 2.0f;
                PointF pointF12 = new PointF((float) (mapPoints.get(59).x + (Math.sin(0.0d) * distance3)), (float) (mapPoints.get(59).y - (distance3 * Math.cos(0.0d))));
                for (int i17 = 2; i17 >= 1; i17--) {
                    double radians = Math.toRadians(i17 * 30.0f);
                    PointF pointF13 = new PointF();
                    pointF13.x = (float) (pointF12.x - ((r9 - pointF11.x) * Math.cos(radians)));
                    pointF13.y = (float) (pointF11.y - ((r9 - pointF12.y) * Math.sin(radians)));
                    mapPoints.add(pointF13);
                }
                for (int i18 = 3; i18 >= 1; i18--) {
                    double radians2 = Math.toRadians(i18 * 30.0f);
                    PointF pointF14 = new PointF();
                    pointF14.x = (float) (pointF12.x - ((r9 - pointF10.x) * Math.cos(radians2)));
                    pointF14.y = (float) (pointF10.y - ((r9 - pointF12.y) * Math.sin(radians2)));
                    mapPoints.add(pointF14);
                }
            } else {
                d16 = atan2;
            }
            mapPoints.add(EMPTY_POINT);
            mapPoints.add(EMPTY_POINT);
            mapPoints.get(54);
            mapPoints.get(44);
            PointF pointF15 = new PointF(mapPoints.get(18).x - mapPoints.get(0).x, mapPoints.get(18).y - mapPoints.get(0).y);
            PointF pointF16 = new PointF(-pointF15.y, pointF15.x);
            float f26 = pointF16.y;
            if (f26 < 0.0f) {
                pointF16.x = -pointF16.x;
                pointF16.y = -f26;
            }
            float distance4 = AlgoUtils.getDistance(pointF15, new PointF(0.0f, 0.0f));
            float distance5 = AlgoUtils.getDistance(pointF16, new PointF(0.0f, 0.0f));
            pointF15.x /= distance4;
            pointF15.y /= distance4;
            pointF16.x /= distance5;
            pointF16.y /= distance5;
            PointF pointF17 = mapPoints.get(56);
            PointF pointF18 = mapPoints.get(62);
            PointF pointF19 = mapPoints.get(17);
            PointF pointF20 = mapPoints.get(1);
            PointF pointF21 = mapPoints.get(9);
            PointF pointF22 = mapPoints.get(87);
            PointF pointF23 = mapPoints.get(64);
            float abs = Math.abs((pointF15.x * (pointF19.x - pointF17.x)) + (pointF15.y * (pointF19.y - pointF17.y)));
            float f27 = -Math.abs((pointF15.x * (pointF20.x - pointF18.x)) + (pointF15.y * (pointF20.y - pointF18.y)));
            float abs2 = Math.abs((pointF16.x * (pointF21.x - pointF23.x)) + (pointF16.y * (pointF21.y - pointF23.y)));
            float f28 = -Math.abs((pointF16.x * (pointF22.x - pointF23.x)) + (pointF16.y * (pointF22.y - pointF23.y)));
            mapPoints.add(new PointF(pointF23.x + (pointF15.x * f27 * f16) + (pointF16.x * f28 * f16), pointF23.y + (pointF15.y * f27 * f16) + (pointF16.y * f28 * f16)));
            mapPoints.add(new PointF(pointF23.x + (pointF15.x * f27 * f16), pointF23.y + (pointF15.y * f27 * f16)));
            mapPoints.add(new PointF(pointF23.x + (pointF15.x * f27 * f16) + (pointF16.x * abs2 * f16), pointF23.y + (pointF15.y * f27 * f16) + (pointF16.y * abs2 * f16)));
            mapPoints.add(new PointF(pointF23.x + (pointF16.x * abs2 * f16), pointF23.y + (pointF16.y * abs2 * f16)));
            mapPoints.add(new PointF(pointF23.x + (pointF15.x * abs * f16) + (pointF16.x * abs2 * f16), pointF23.y + (pointF15.y * abs * f16) + (pointF16.y * abs2 * f16)));
            mapPoints.add(new PointF(pointF23.x + (pointF15.x * abs * f16), pointF23.y + (pointF15.y * abs * f16)));
            mapPoints.add(new PointF(pointF23.x + (pointF15.x * abs * f16) + (pointF16.x * f28 * f16), pointF23.y + (pointF15.y * abs * f16) + (pointF16.y * f28 * f16)));
            mapPoints.add(new PointF(pointF23.x + (pointF16.x * f28 * f16), pointF23.y + (pointF16.y * f28 * f16)));
            mapPoints.get(3);
            mapPoints.get(15);
            PointF pointF24 = mapPoints.get(65);
            PointF pointF25 = mapPoints.get(66);
            if (f17 < 0.0f) {
                PointF pointF26 = new PointF(pointF24.x + (pointF15.x * f27 * 10.0f), pointF24.y + (pointF15.y * f27 * 10.0f));
                int i19 = 1;
                while (true) {
                    if (i19 >= 9) {
                        z27 = false;
                        pointF8 = null;
                        break;
                    }
                    PointF pointF27 = mapPoints.get(i19);
                    i19++;
                    PointF crossPoint = AlgoUtils.getCrossPoint(pointF24, pointF26, pointF27, mapPoints.get(i19));
                    if (crossPoint != null) {
                        float min3 = z16 ? 0.0f : Math.min(1.8f - ((float) (Math.cos(f17) * 1.8d)), 0.5f);
                        PointF betweenPoint = AlgoUtils.getBetweenPoint(crossPoint, mapPoints.get(65), min3);
                        pointF8 = AlgoUtils.getBetweenPoint(crossPoint, mapPoints.get(65), Math.min(min3, 0.4f));
                        mapPoints.add(new PointF(betweenPoint.x, betweenPoint.y));
                        z27 = true;
                    }
                }
                if (!z27) {
                    PointF pointF28 = mapPoints.get(1);
                    float min4 = z16 ? 0.0f : Math.min(1.8f - ((float) (Math.cos(f17) * 1.8d)), 0.5f);
                    PointF betweenPoint2 = AlgoUtils.getBetweenPoint(pointF28, mapPoints.get(65), min4);
                    PointF betweenPoint3 = AlgoUtils.getBetweenPoint(pointF28, mapPoints.get(65), Math.min(min4, 0.4f));
                    mapPoints.add(new PointF(betweenPoint2.x, betweenPoint2.y));
                    pointF8 = betweenPoint3;
                }
                pointF = pointF8;
                z18 = true;
            } else {
                PointF pointF29 = new PointF(pointF24.x + (pointF15.x * f27 * 10.0f), pointF24.y + (pointF15.y * f27 * 10.0f));
                int i26 = 1;
                while (true) {
                    if (i26 >= 9) {
                        z17 = false;
                        break;
                    }
                    PointF pointF30 = mapPoints.get(i26);
                    i26++;
                    PointF crossPoint2 = AlgoUtils.getCrossPoint(pointF24, pointF29, pointF30, mapPoints.get(i26));
                    if (crossPoint2 != null) {
                        PointF betweenPoint4 = AlgoUtils.getBetweenPoint(crossPoint2, mapPoints.get(65), (float) ((Math.cos(f17) * 4.0d) - 4.0d));
                        mapPoints.add(new PointF(betweenPoint4.x, betweenPoint4.y));
                        z17 = true;
                        break;
                    }
                }
                if (z17) {
                    z18 = true;
                } else {
                    z18 = true;
                    PointF betweenPoint5 = AlgoUtils.getBetweenPoint(mapPoints.get(1), mapPoints.get(65), (float) ((Math.cos(f17) * 4.0d) - 4.0d));
                    mapPoints.add(new PointF(betweenPoint5.x, betweenPoint5.y));
                }
                pointF = null;
            }
            PointF pointF31 = null;
            if (f17 < 0.0f) {
                PointF pointF32 = new PointF(pointF25.x + (pointF15.x * abs * 10.0f), pointF25.y + (pointF15.y * abs * 10.0f));
                int i27 = 9;
                while (true) {
                    if (i27 >= 17) {
                        z26 = false;
                        break;
                    }
                    PointF pointF33 = mapPoints.get(i27);
                    i27++;
                    PointF crossPoint3 = AlgoUtils.getCrossPoint(pointF25, pointF32, pointF33, mapPoints.get(i27));
                    if (crossPoint3 != null) {
                        PointF betweenPoint6 = AlgoUtils.getBetweenPoint(crossPoint3, mapPoints.get(66), (float) ((Math.cos(f17) * 4.0d) - 4.0d));
                        mapPoints.add(new PointF(betweenPoint6.x, betweenPoint6.y));
                        z26 = z18;
                        break;
                    }
                }
                if (!z26) {
                    PointF betweenPoint7 = AlgoUtils.getBetweenPoint(mapPoints.get(17), mapPoints.get(66), (float) ((Math.cos(f17) * 4.0d) - 4.0d));
                    mapPoints.add(new PointF(betweenPoint7.x, betweenPoint7.y));
                }
            } else {
                PointF pointF34 = new PointF(pointF25.x + (pointF15.x * abs * 10.0f), pointF25.y + (pointF15.y * abs * 10.0f));
                int i28 = 9;
                while (true) {
                    if (i28 >= 17) {
                        z19 = false;
                        break;
                    }
                    PointF pointF35 = mapPoints.get(i28);
                    i28++;
                    PointF crossPoint4 = AlgoUtils.getCrossPoint(pointF25, pointF34, pointF35, mapPoints.get(i28));
                    if (crossPoint4 != null) {
                        float min5 = z16 ? 0.0f : Math.min(1.8f - ((float) (Math.cos(f17) * 1.8d)), 0.5f);
                        PointF betweenPoint8 = AlgoUtils.getBetweenPoint(crossPoint4, mapPoints.get(66), min5);
                        pointF31 = AlgoUtils.getBetweenPoint(crossPoint4, mapPoints.get(66), Math.min(min5, 0.4f));
                        mapPoints.add(new PointF(betweenPoint8.x, betweenPoint8.y));
                        z19 = z18;
                    }
                }
                if (!z19) {
                    PointF pointF36 = mapPoints.get(17);
                    float min6 = z16 ? 0.0f : Math.min(1.8f - ((float) (Math.cos(f17) * 1.8d)), 0.5f);
                    PointF betweenPoint9 = AlgoUtils.getBetweenPoint(pointF36, mapPoints.get(66), min6);
                    PointF betweenPoint10 = AlgoUtils.getBetweenPoint(pointF36, mapPoints.get(66), Math.min(min6, 0.4f));
                    mapPoints.add(new PointF(betweenPoint9.x, betweenPoint9.y));
                    pointF31 = betweenPoint10;
                }
            }
            mapPoints.get(2);
            mapPoints.get(16);
            PointF pointF37 = mapPoints.get(39);
            mapPoints.get(57);
            mapPoints.get(61);
            PointF pointF38 = mapPoints.get(35);
            if (f17 < 0.0f) {
                if (z16) {
                    i16 = 0;
                    min2 = 0.0f;
                } else {
                    min2 = Math.min(1.2f - ((float) (Math.cos(f17) * 1.2d)), 0.5f);
                    i16 = 0;
                }
                PointF betweenPoint11 = AlgoUtils.getBetweenPoint(mapPoints.get(i16), mapPoints.get(56), min2);
                PointF betweenPoint12 = AlgoUtils.getBetweenPoint(mapPoints.get(i16), mapPoints.get(56), 0.1f);
                mapPoints.add(new PointF(betweenPoint11.x, betweenPoint12.y));
                pointF2 = new PointF(AlgoUtils.getBetweenPoint(mapPoints.get(i16), mapPoints.get(56), Math.min(min2, 0.3f)).x, betweenPoint12.y);
            } else {
                PointF betweenPoint13 = AlgoUtils.getBetweenPoint(mapPoints.get(0), mapPoints.get(56), (float) ((Math.cos(f17) * 3.0d) - 3.0d));
                PointF betweenPoint14 = AlgoUtils.getBetweenPoint(mapPoints.get(0), mapPoints.get(56), 0.1f);
                if ((mapPoints.get(18).x - mapPoints.get(0).x) * (mapPoints.get(56).x - mapPoints.get(0).x) <= 0.0f) {
                    mapPoints.add(new PointF(mapPoints.get(0).x, mapPoints.get(0).y));
                } else {
                    mapPoints.add(new PointF(betweenPoint13.x, betweenPoint14.y));
                }
                pointF2 = null;
            }
            PointF pointF39 = pointF2;
            if (f17 < 0.0f) {
                PointF betweenPoint15 = AlgoUtils.getBetweenPoint(mapPoints.get(18), mapPoints.get(62), (float) ((Math.cos(f17) * 3.0d) - 3.0d));
                PointF betweenPoint16 = AlgoUtils.getBetweenPoint(mapPoints.get(18), mapPoints.get(62), 0.1f);
                if ((mapPoints.get(18).x - mapPoints.get(0).x) * (mapPoints.get(18).x - mapPoints.get(62).x) <= 0.0f) {
                    mapPoints.add(new PointF(mapPoints.get(18).x, mapPoints.get(18).y));
                } else {
                    mapPoints.add(new PointF(betweenPoint15.x, betweenPoint16.y));
                }
                pointF3 = null;
            } else {
                if (z16) {
                    i3 = 18;
                    min = 0.0f;
                } else {
                    min = Math.min(1.2f - ((float) (Math.cos(f17) * 1.2d)), 0.5f);
                    i3 = 18;
                }
                PointF betweenPoint17 = AlgoUtils.getBetweenPoint(mapPoints.get(i3), mapPoints.get(62), min);
                PointF betweenPoint18 = AlgoUtils.getBetweenPoint(mapPoints.get(i3), mapPoints.get(62), 0.1f);
                mapPoints.add(new PointF(betweenPoint17.x, betweenPoint18.y));
                pointF3 = new PointF(AlgoUtils.getBetweenPoint(mapPoints.get(i3), mapPoints.get(62), Math.min(min, 0.3f)).x, betweenPoint18.y);
            }
            PointF pointF40 = mapPoints.get(43);
            mapPoints.get(55);
            PointF pointF41 = mapPoints.get(41);
            PointF pointF42 = mapPoints.get(37);
            float distance6 = AlgoUtils.getDistance(pointF38, pointF37);
            AlgoUtils.getDistance(pointF41, pointF42);
            float f29 = distance6 / 50.0f;
            int i29 = 35;
            while (i29 < 39) {
                PointF pointF43 = mapPoints.get(i29);
                int i36 = i29 - 37;
                PointF pointF44 = pointF39;
                float sin = (float) (Math.sin(((2.0f - Math.abs(i36)) * 3.141592653589793d) / 4.0d) * 0.3d);
                if (i29 == 35) {
                    float f36 = pointF43.y;
                    float f37 = pointF40.y;
                    float f38 = pointF43.x;
                    float f39 = pointF40.x;
                    float f46 = (f36 - f37) / (f38 - f39);
                    f19 = f38 + ((f38 - f39) * 0.9f);
                    cos2 = (f46 * (f19 - f39)) + f37;
                    pointF5 = pointF9;
                    pointF6 = pointF3;
                    pointF7 = pointF40;
                } else {
                    pointF5 = pointF9;
                    double d17 = (sin + 1.0f) * f29 * 10.0f;
                    pointF6 = pointF3;
                    pointF7 = pointF40;
                    double radians3 = 0.0d + ((float) Math.toRadians(i36 * 60.0f));
                    float sin2 = (float) (pointF43.x + (Math.sin(radians3) * d17));
                    cos2 = (float) (pointF43.y + (d17 * Math.cos(radians3)));
                    f19 = sin2;
                }
                if (i29 == 35 && f19 < mapPoints.get(0).x) {
                    f19 = mapPoints.get(0).x;
                }
                mapPoints.add(new PointF(f19, cos2));
                i29++;
                pointF39 = pointF44;
                pointF9 = pointF5;
                pointF3 = pointF6;
                pointF40 = pointF7;
            }
            PointF pointF45 = pointF9;
            PointF pointF46 = pointF39;
            PointF pointF47 = pointF3;
            PointF middlePoint = AlgoUtils.middlePoint(mapPoints.get(39), mapPoints.get(55));
            mapPoints.add(new PointF(middlePoint.x, middlePoint.y));
            int size = mapPoints.size();
            int i37 = 40;
            while (i37 < 43) {
                PointF pointF48 = mapPoints.get(i37);
                int i38 = i37 - 41;
                float radians4 = (float) Math.toRadians(i38 * 60.0f);
                double sin3 = 16.0f * f29 * (((float) (Math.sin(((3.0f - Math.abs(i38)) * 3.141592653589793d) / 2.0d) * 0.3d)) + 1.0f);
                double d18 = 0.0d + radians4;
                mapPoints.add(new PointF((float) (pointF48.x - (Math.sin(d18) * sin3)), (float) (pointF48.y - (sin3 * Math.cos(d18)))));
                i37++;
                matrix2 = matrix2;
                f29 = f29;
            }
            Matrix matrix3 = matrix2;
            PointF pointF49 = mapPoints.get(size);
            PointF pointF50 = mapPoints.get(size + 1);
            PointF pointF51 = mapPoints.get(size + 2);
            PointF middlePoint2 = AlgoUtils.middlePoint(pointF49, pointF50);
            PointF middlePoint3 = AlgoUtils.middlePoint(pointF51, pointF50);
            mapPoints.add(new PointF(middlePoint2.x, middlePoint2.y));
            mapPoints.add(new PointF(middlePoint3.x, middlePoint3.y));
            PointF pointF52 = mapPoints.get(51);
            PointF pointF53 = mapPoints.get(47);
            PointF pointF54 = mapPoints.get(54);
            mapPoints.get(63);
            int i39 = 45;
            float distance7 = AlgoUtils.getDistance(mapPoints.get(45), mapPoints.get(49));
            AlgoUtils.getDistance(pointF52, pointF53);
            float f47 = distance7 / 50.0f;
            int i46 = 45;
            while (i46 < 49) {
                PointF pointF55 = mapPoints.get(i46);
                int i47 = i46 - 47;
                float sin4 = (float) (Math.sin(((2.0f - Math.abs(i47)) * 3.141592653589793d) / 4.0d) * 0.3d);
                if (i46 == i39) {
                    float f48 = pointF55.y;
                    float f49 = pointF54.y;
                    float f56 = pointF55.x;
                    float f57 = pointF54.x;
                    float f58 = (f48 - f49) / (f56 - f57);
                    f18 = f56 + ((f56 - f57) * 0.9f);
                    cos = (f58 * (f18 - f57)) + f49;
                    pointF4 = pointF;
                    matrix = matrix3;
                } else {
                    matrix = matrix3;
                    double d19 = (sin4 + 1.0f) * f47 * 10.0f;
                    double radians5 = 0.0d - ((float) Math.toRadians(i47 * 60.0f));
                    float sin5 = (float) (pointF55.x + (Math.sin(radians5) * d19));
                    pointF4 = pointF;
                    cos = (float) (pointF55.y + (d19 * Math.cos(radians5)));
                    f18 = sin5;
                    i39 = 45;
                }
                if (i46 == i39 && f18 > mapPoints.get(18).x) {
                    f18 = mapPoints.get(18).x;
                }
                mapPoints.add(new PointF(f18, cos));
                i46++;
                matrix3 = matrix;
                pointF = pointF4;
                i39 = 45;
            }
            PointF pointF56 = pointF;
            Matrix matrix4 = matrix3;
            PointF middlePoint4 = AlgoUtils.middlePoint(mapPoints.get(49), mapPoints.get(63));
            mapPoints.add(new PointF(middlePoint4.x, middlePoint4.y));
            int size2 = mapPoints.size();
            int i48 = 50;
            while (i48 < 53) {
                PointF pointF57 = mapPoints.get(i48);
                int i49 = i48 - 51;
                float radians6 = (float) Math.toRadians(i49 * 60.0f);
                double sin6 = 16.0f * f47 * (((float) (Math.sin(((3.0f - Math.abs(i49)) * 3.141592653589793d) / 2.0d) * 0.3d)) + 1.0f);
                double d26 = 0.0d - radians6;
                mapPoints.add(new PointF((float) (pointF57.x - (Math.sin(d26) * sin6)), (float) (pointF57.y - (sin6 * Math.cos(d26)))));
                i48++;
                pointF31 = pointF31;
                f47 = f47;
            }
            PointF pointF58 = pointF31;
            PointF pointF59 = mapPoints.get(size2);
            PointF pointF60 = mapPoints.get(size2 + 1);
            PointF pointF61 = mapPoints.get(size2 + 2);
            PointF middlePoint5 = AlgoUtils.middlePoint(pointF59, pointF60);
            PointF middlePoint6 = AlgoUtils.middlePoint(pointF61, pointF60);
            mapPoints.add(new PointF(middlePoint5.x, middlePoint5.y));
            mapPoints.add(new PointF(middlePoint6.x, middlePoint6.y));
            PointF pointF62 = mapPoints.get(109);
            PointF pointF63 = mapPoints.get(110);
            PointF betweenPoint19 = AlgoUtils.getBetweenPoint(pointF62, AlgoUtils.middlePoint(mapPoints.get(56), mapPoints.get(62)), 0.5f);
            PointF betweenPoint20 = AlgoUtils.getBetweenPoint(pointF63, AlgoUtils.middlePoint(mapPoints.get(56), mapPoints.get(62)), 0.5f);
            PointF pointF64 = new PointF(betweenPoint19.x, betweenPoint19.y);
            PointF pointF65 = new PointF(betweenPoint20.x, betweenPoint20.y);
            if (f17 < 0.0f) {
                betweenPoint20 = AlgoUtils.getBetweenPoint(AlgoUtils.middlePoint(mapPoints.get(45), mapPoints.get(61)), betweenPoint20, Math.max((((float) Math.cos(f17)) * 15.0f) - 14.0f, 0.0f));
            } else {
                betweenPoint19 = AlgoUtils.getBetweenPoint(AlgoUtils.middlePoint(mapPoints.get(35), mapPoints.get(57)), betweenPoint19, Math.max((((float) Math.cos(-f17)) * 15.0f) - 14.0f, 0.0f));
            }
            mapPoints.add(new PointF(betweenPoint19.x, betweenPoint19.y));
            mapPoints.add(new PointF(betweenPoint20.x, betweenPoint20.y));
            PointF pointF66 = mapPoints.get(107);
            PointF pointF67 = mapPoints.get(108);
            PointF betweenPoint21 = AlgoUtils.getBetweenPoint(pointF66, mapPoints.get(65), 0.5f);
            PointF betweenPoint22 = AlgoUtils.getBetweenPoint(pointF67, mapPoints.get(66), 0.5f);
            if (f17 < 0.0f) {
                double d27 = f17;
                betweenPoint22 = AlgoUtils.getBetweenPoint(AlgoUtils.middlePoint(mapPoints.get(14), mapPoints.get(66)), betweenPoint22, Math.max((((float) Math.cos(d27)) * 12.0f) - 11.0f, 0.0f));
                PointF pointF68 = new PointF(mapPoints.get(110).x - pointF65.x, mapPoints.get(110).y - pointF65.y);
                mapPoints.set(108, AlgoUtils.getBetweenPoint(new PointF(betweenPoint22.x + (pointF68.x * 0.8f), betweenPoint22.y + (pointF68.y * 0.8f)), pointF67, Math.max((((float) Math.cos(d27)) * 8.0f) - 7.0f, 0.0f)));
            } else {
                double d28 = -f17;
                betweenPoint21 = AlgoUtils.getBetweenPoint(AlgoUtils.middlePoint(mapPoints.get(4), mapPoints.get(65)), betweenPoint21, Math.max((((float) Math.cos(d28)) * 12.0f) - 11.0f, 0.0f));
                PointF pointF69 = new PointF(mapPoints.get(109).x - pointF64.x, mapPoints.get(109).y - pointF64.y);
                mapPoints.set(107, AlgoUtils.getBetweenPoint(new PointF(betweenPoint21.x + (pointF69.x * 0.8f), betweenPoint21.y + (pointF69.y * 0.8f)), pointF66, Math.max((((float) Math.cos(d28)) * 8.0f) - 7.0f, 0.0f)));
            }
            mapPoints.add(new PointF(betweenPoint21.x, betweenPoint21.y));
            mapPoints.add(new PointF(betweenPoint22.x, betweenPoint22.y));
            if (pointF56 != null) {
                mapPoints.set(107, pointF56);
            }
            if (pointF58 != null) {
                mapPoints.set(108, pointF58);
            }
            if (pointF46 != null) {
                mapPoints.set(109, pointF46);
            }
            if (pointF47 != null) {
                mapPoints.set(110, pointF47);
            }
            if (z16) {
                mapPoints.set(107, AlgoUtils.middlePoint(mapPoints.get(3), mapPoints.get(65)));
                mapPoints.set(108, AlgoUtils.middlePoint(mapPoints.get(15), mapPoints.get(66)));
                mapPoints.set(109, AlgoUtils.middlePoint(mapPoints.get(35), mapPoints.get(57)));
                mapPoints.set(110, AlgoUtils.middlePoint(mapPoints.get(45), mapPoints.get(61)));
                mapPoints.set(131, AlgoUtils.middlePoint(mapPoints.get(35), mapPoints.get(57)));
                mapPoints.set(132, AlgoUtils.middlePoint(mapPoints.get(45), mapPoints.get(61)));
                mapPoints.set(133, AlgoUtils.middlePoint(mapPoints.get(3), mapPoints.get(65)));
                mapPoints.set(134, AlgoUtils.middlePoint(mapPoints.get(15), mapPoints.get(66)));
            }
            matrix4.reset();
            matrix4.postTranslate(-pointF45.x, -pointF45.y);
            matrix4.postRotate((float) Math.toDegrees(d16));
            matrix4.postTranslate(pointF45.x, pointF45.y);
            return AlgoUtils.mapPoints(mapPoints, matrix4);
        }
        return new ArrayList();
    }

    public static float[] getFullOpacityForFaceOffFilter_v2(List<PointF> list, float f16) {
        float[] fArr = new float[135];
        Arrays.fill(fArr, 1.0f);
        if (f16 < 0.0f) {
            double d16 = f16;
            if (d16 < -0.6108652381980153d) {
                float f17 = (float) ((d16 * 180.0d) / 3.141592653589793d);
                float f18 = ((35.0f + f17) * 0.2f) + 1.0f;
                fArr[27] = fArr[27] * Math.max(0.0f, Math.min(1.0f, f18));
                fArr[45] = fArr[45] * Math.max(0.0f, Math.min(1.0f, f18));
                float f19 = ((40.0f + f17) * 0.2f) + 1.0f;
                fArr[28] = fArr[28] * Math.max(0.0f, Math.min(1.0f, f19));
                fArr[34] = fArr[34] * Math.max(0.0f, Math.min(1.0f, f19));
                fArr[46] = fArr[46] * Math.max(0.0f, Math.min(1.0f, f19));
                fArr[52] = fArr[52] * Math.max(0.0f, Math.min(1.0f, f19));
                fArr[18] = fArr[18] * Math.max(0.0f, Math.min(1.0f, f19));
                fArr[17] = fArr[17] * Math.max(0.0f, Math.min(1.0f, f19));
                fArr[16] = fArr[16] * Math.max(0.0f, Math.min(1.0f, f19));
                fArr[15] = fArr[15] * Math.max(0.0f, Math.min(1.0f, f19));
                fArr[14] = fArr[14] * Math.max(0.0f, Math.min(1.0f, f19));
                fArr[13] = fArr[13] * Math.max(0.0f, Math.min(1.0f, f19));
                fArr[12] = fArr[12] * Math.max(0.0f, Math.min(1.0f, f19));
                fArr[11] = fArr[11] * Math.max(0.0f, Math.min(1.0f, f19));
                fArr[10] = fArr[10] * Math.max(0.0f, Math.min(1.0f, f19));
                fArr[88] = fArr[88] * Math.max(0.0f, Math.min(1.0f, f19));
                float f26 = 45.0f + f17;
                float f27 = (f26 * 0.1f) + 1.0f;
                fArr[29] = fArr[29] * Math.max(0.0f, Math.min(1.0f, f27));
                fArr[33] = fArr[33] * Math.max(0.0f, Math.min(1.0f, f27));
                fArr[47] = fArr[47] * Math.max(0.0f, Math.min(1.0f, f27));
                fArr[51] = fArr[51] * Math.max(0.0f, Math.min(1.0f, f27));
                float f28 = ((50.0f + f17) * 0.2f) + 1.0f;
                fArr[30] = fArr[30] * Math.max(0.0f, Math.min(1.0f, f28));
                fArr[31] = fArr[31] * Math.max(0.0f, Math.min(1.0f, f28));
                fArr[32] = fArr[32] * Math.max(0.0f, Math.min(1.0f, f28));
                fArr[48] = fArr[48] * Math.max(0.0f, Math.min(1.0f, f28));
                fArr[49] = fArr[49] * Math.max(0.0f, Math.min(1.0f, f28));
                fArr[50] = fArr[50] * Math.max(0.0f, Math.min(1.0f, f28));
                float f29 = (0.2f * f26) + 1.0f;
                fArr[60] = fArr[60] * Math.max(0.0f, Math.min(1.0f, f29));
                float f36 = (0.5f * f26) + 1.0f;
                fArr[61] = fArr[61] * Math.max(0.0f, Math.min(1.0f, f36));
                float f37 = ((f17 + 55.0f) * 0.1f) + 1.0f;
                fArr[62] = fArr[62] * Math.max(0.0f, Math.min(1.0f, f37));
                fArr[63] = fArr[63] * Math.max(0.0f, Math.min(1.0f, f37));
                fArr[66] = fArr[66] * Math.max(0.0f, Math.min(1.0f, f36));
                float f38 = (f26 * 0.3f) + 1.0f;
                fArr[71] = fArr[71] * Math.max(0.0f, Math.min(1.0f, f38));
                fArr[70] = fArr[70] * Math.max(0.0f, Math.min(1.0f, f29));
                fArr[78] = fArr[78] * Math.max(0.0f, Math.min(1.0f, f29));
                fArr[79] = fArr[79] * Math.max(0.0f, Math.min(1.0f, f38));
                fArr[72] = fArr[72] * Math.max(0.0f, Math.min(1.0f, f38));
                fArr[80] = fArr[80] * Math.max(0.0f, Math.min(1.0f, f38));
            }
        } else {
            double d17 = f16;
            if (d17 > 0.6108652381980153d) {
                float f39 = (float) ((d17 * 180.0d) / 3.141592653589793d);
                float f46 = 1.0f - ((f39 - 35.0f) * 0.2f);
                fArr[19] = fArr[19] * Math.max(0.0f, Math.min(1.0f, f46));
                fArr[35] = fArr[35] * Math.max(0.0f, Math.min(1.0f, f46));
                float f47 = 1.0f - ((f39 - 40.0f) * 0.2f);
                fArr[20] = fArr[20] * Math.max(0.0f, Math.min(1.0f, f47));
                fArr[26] = fArr[26] * Math.max(0.0f, Math.min(1.0f, f47));
                fArr[36] = fArr[36] * Math.max(0.0f, Math.min(1.0f, f47));
                fArr[42] = fArr[42] * Math.max(0.0f, Math.min(1.0f, f47));
                fArr[0] = fArr[0] * Math.max(0.0f, Math.min(1.0f, f47));
                fArr[1] = fArr[1] * Math.max(0.0f, Math.min(1.0f, f47));
                fArr[2] = fArr[2] * Math.max(0.0f, Math.min(1.0f, f47));
                fArr[3] = fArr[3] * Math.max(0.0f, Math.min(1.0f, f47));
                fArr[4] = fArr[4] * Math.max(0.0f, Math.min(1.0f, f47));
                fArr[5] = fArr[5] * Math.max(0.0f, Math.min(1.0f, f47));
                fArr[6] = fArr[6] * Math.max(0.0f, Math.min(1.0f, f47));
                fArr[7] = fArr[7] * Math.max(0.0f, Math.min(1.0f, f47));
                fArr[8] = fArr[8] * Math.max(0.0f, Math.min(1.0f, f47));
                fArr[86] = fArr[86] * Math.max(0.0f, Math.min(1.0f, f47));
                float f48 = 1.0f - ((f39 - 45.0f) * 0.1f);
                fArr[21] = fArr[21] * Math.max(0.0f, Math.min(1.0f, f48));
                fArr[25] = fArr[25] * Math.max(0.0f, Math.min(1.0f, f48));
                fArr[37] = fArr[37] * Math.max(0.0f, Math.min(1.0f, f48));
                fArr[41] = fArr[41] * Math.max(0.0f, Math.min(1.0f, f48));
                float f49 = 1.0f - ((f39 - 50.0f) * 0.2f);
                fArr[22] = fArr[22] * Math.max(0.0f, Math.min(1.0f, f49));
                fArr[23] = fArr[23] * Math.max(0.0f, Math.min(1.0f, f49));
                fArr[24] = fArr[24] * Math.max(0.0f, Math.min(1.0f, f49));
                fArr[38] = fArr[38] * Math.max(0.0f, Math.min(1.0f, f49));
                fArr[39] = fArr[39] * Math.max(0.0f, Math.min(1.0f, f49));
                fArr[40] = fArr[40] * Math.max(0.0f, Math.min(1.0f, f49));
                float f56 = 1.0f - ((f39 - 55.0f) * 0.1f);
                fArr[55] = fArr[55] * Math.max(0.0f, Math.min(1.0f, f56));
                fArr[56] = fArr[56] * Math.max(0.0f, Math.min(1.0f, f56));
                float f57 = f39 - 42.0f;
                float f58 = 1.0f - (0.5f * f57);
                fArr[57] = fArr[57] * Math.max(0.0f, Math.min(1.0f, f58));
                float f59 = 1.0f - (0.2f * f57);
                fArr[58] = fArr[58] * Math.max(0.0f, Math.min(1.0f, f59));
                fArr[65] = fArr[65] * Math.max(0.0f, Math.min(1.0f, f58));
                float f65 = 1.0f - (f57 * 0.3f);
                fArr[67] = fArr[67] * Math.max(0.0f, Math.min(1.0f, f65));
                fArr[68] = fArr[68] * Math.max(0.0f, Math.min(1.0f, f59));
                fArr[75] = fArr[75] * Math.max(0.0f, Math.min(1.0f, f65));
                fArr[76] = fArr[76] * Math.max(0.0f, Math.min(1.0f, f59));
                fArr[74] = fArr[74] * Math.max(0.0f, Math.min(1.0f, f65));
                fArr[82] = fArr[82] * Math.max(0.0f, Math.min(1.0f, f65));
            }
        }
        return calcFullProbability_v2(list, fArr, f16);
    }

    public static float[] getFullPointsOpacityForFaceOffFilter(float[] fArr) {
        float[] fArr2 = new float[131];
        for (int i3 = 0; i3 < 90; i3++) {
            fArr2[i3] = fArr[i3];
        }
        fArr2[90] = fArr2[1];
        fArr2[91] = fArr2[17];
        fArr2[92] = 1.0f;
        fArr2[93] = 1.0f;
        fArr2[94] = 1.0f;
        fArr2[95] = 1.0f;
        fArr2[96] = 1.0f;
        fArr2[97] = 0.0f;
        fArr2[98] = 0.0f;
        fArr2[99] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[100] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[101] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[102] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[103] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[104] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[105] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[106] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        float f16 = fArr2[36];
        fArr2[107] = f16;
        float f17 = fArr2[46];
        fArr2[108] = f17;
        fArr2[109] = f16;
        fArr2[110] = f17;
        fArr2[111] = fArr2[35];
        fArr2[112] = f16;
        fArr2[113] = fArr2[37];
        fArr2[114] = fArr2[38];
        fArr2[115] = fArr2[39];
        float f18 = fArr2[40];
        fArr2[116] = f18;
        float f19 = fArr2[41];
        fArr2[117] = f19;
        float f26 = fArr2[42];
        fArr2[118] = f26;
        fArr2[119] = (f18 + f19) / 2.0f;
        fArr2[120] = (f19 + f26) / 2.0f;
        fArr2[121] = fArr2[45];
        fArr2[122] = f17;
        fArr2[123] = fArr2[47];
        fArr2[124] = fArr2[48];
        fArr2[125] = fArr2[49];
        float f27 = fArr2[50];
        fArr2[126] = f27;
        float f28 = fArr2[51];
        fArr2[127] = f28;
        float f29 = fArr2[52];
        fArr2[128] = f29;
        fArr2[129] = (f27 + f28) / 2.0f;
        fArr2[130] = (f28 + f29) / 2.0f;
        return fArr2;
    }

    public static float[] getFullPointsVisForFaceOffFilter(float[] fArr) {
        float[] fArr2 = new float[131];
        for (int i3 = 0; i3 < 90; i3++) {
            fArr2[i3] = fArr[i3];
        }
        fArr2[90] = fArr2[1];
        fArr2[91] = fArr2[17];
        fArr2[92] = 1.0f;
        fArr2[93] = 1.0f;
        fArr2[94] = 1.0f;
        fArr2[95] = 1.0f;
        fArr2[96] = 1.0f;
        fArr2[97] = 0.0f;
        fArr2[98] = 0.0f;
        fArr2[99] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[100] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[101] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[102] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[103] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[104] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[105] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[106] = Math.min(Math.min(fArr2[44], fArr2[54]), fArr2[64]);
        fArr2[107] = (fArr2[3] + fArr2[65]) / 2.0f;
        fArr2[108] = (fArr2[15] + fArr2[66]) / 2.0f;
        float f16 = fArr2[35];
        fArr2[109] = (fArr2[57] + f16) / 2.0f;
        float f17 = fArr2[45];
        fArr2[110] = (fArr2[61] + f17) / 2.0f;
        fArr2[111] = f16;
        fArr2[112] = fArr2[36];
        fArr2[113] = fArr2[37];
        fArr2[114] = fArr2[38];
        fArr2[115] = fArr2[39];
        float f18 = fArr2[40];
        fArr2[116] = f18;
        float f19 = fArr2[41];
        fArr2[117] = f19;
        float f26 = fArr2[42];
        fArr2[118] = f26;
        fArr2[119] = (f18 + f19) / 2.0f;
        fArr2[120] = (f19 + f26) / 2.0f;
        fArr2[121] = f17;
        fArr2[122] = fArr2[46];
        fArr2[123] = fArr2[47];
        fArr2[124] = fArr2[48];
        fArr2[125] = fArr2[49];
        float f27 = fArr2[50];
        fArr2[126] = f27;
        float f28 = fArr2[51];
        fArr2[127] = f28;
        float f29 = fArr2[52];
        fArr2[128] = f29;
        fArr2[129] = (f27 + f28) / 2.0f;
        fArr2[130] = (f28 + f29) / 2.0f;
        return fArr2;
    }

    public static float[] getFullPointsVisForFaceOffFilter_v2(List<PointF> list, float[] fArr, float f16) {
        return calcFullProbability_v2(list, fArr, f16);
    }

    public static Bitmap getGrayBitmap(FeatureType featureType) {
        if (featureType.equals(FeatureType.NO_EYE)) {
            return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_NO_EYE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        if (featureType.equals(FeatureType.HAS_EYE)) {
            return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_HAS_EYE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        if (featureType.equals(FeatureType.CRAZY_FACE)) {
            return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_CRAZY_FACE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        if (featureType.equals(FeatureType.FACE_HEAD_CROP)) {
            return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_CROP_HEAD_FACE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        if (featureType.equals(FeatureType.FACE_SKIN)) {
            return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_FACE_SKIN, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        if (featureType.equals(FeatureType.MASK)) {
            return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_MASK, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        if (featureType.equals(FeatureType.FACE_COS3D_MASK)) {
            return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_FACE_COS3D_MASK, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        if (featureType.equals(FeatureType.NOSE_MASK)) {
            return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_NOSE_MASK, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        if (featureType.equals(FeatureType.LIPS_MASK)) {
            return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_LIPS_MASK, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        return null;
    }

    public static List<PointF> getGrayCoords(FeatureType featureType) {
        String str = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
        switch (AnonymousClass1.$SwitchMap$com$tencent$ttpic$util$FaceOffUtil$FeatureType[featureType.ordinal()]) {
            case 2:
                str = COORDS_FILE_CRAZY_FACE;
                break;
            case 3:
                str = COORDS_FILE_FACE_HEAD_CROP;
                break;
            case 4:
                str = COORDS_FILE_FACE_SKIN;
                break;
        }
        return loadTexCoords(str);
    }

    public static String getMaskBrushPointPath() {
        return DEFAULT_BRUSH_POINT;
    }

    public static List<PointF> getMaskCoords(List<Double> list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size() - 1; i3 += 2) {
            arrayList.add(new PointF((float) list.get(i3).doubleValue(), (float) list.get(i3 + 1).doubleValue()));
        }
        return arrayList;
    }

    public static float[] initFaceLinePositions(List<PointF> list, int i3, int i16, float[] fArr) {
        char c16 = 0;
        if (!CollectionUtils.isEmpty(list) && i3 > 0 && i16 > 0) {
            PointF[] pointFArr = new PointF[3];
            int i17 = 0;
            int i18 = 0;
            while (i17 < 690) {
                int[] iArr = FaceMeshTriangles;
                pointFArr[c16] = list.get(iArr[i17]);
                pointFArr[1] = list.get(iArr[i17 + 1]);
                PointF pointF = list.get(iArr[i17 + 2]);
                pointFArr[2] = pointF;
                PointF pointF2 = pointFArr[c16];
                float f16 = pointF2.x;
                float f17 = i3;
                fArr[i18] = ((f16 / f17) * 2.0f) - 1.0f;
                float f18 = pointF2.y;
                float f19 = i16;
                fArr[i18 + 1] = ((f18 / f19) * 2.0f) - 1.0f;
                PointF pointF3 = pointFArr[1];
                float f26 = pointF3.x;
                fArr[i18 + 2] = ((f26 / f17) * 2.0f) - 1.0f;
                float f27 = pointF3.y;
                fArr[i18 + 3] = ((f27 / f19) * 2.0f) - 1.0f;
                fArr[i18 + 4] = ((f26 / f17) * 2.0f) - 1.0f;
                fArr[i18 + 5] = ((f27 / f19) * 2.0f) - 1.0f;
                float f28 = pointF.x;
                fArr[i18 + 6] = ((f28 / f17) * 2.0f) - 1.0f;
                float f29 = pointF.y;
                fArr[i18 + 7] = ((f29 / f19) * 2.0f) - 1.0f;
                fArr[i18 + 8] = ((f28 / f17) * 2.0f) - 1.0f;
                fArr[i18 + 9] = ((f29 / f19) * 2.0f) - 1.0f;
                fArr[i18 + 10] = ((f16 / f17) * 2.0f) - 1.0f;
                fArr[i18 + 11] = ((f18 / f19) * 2.0f) - 1.0f;
                i18 += 12;
                i17 += 3;
                c16 = 0;
            }
            return fArr;
        }
        return new float[0];
    }

    public static float[] initFaceLinePositions_4_Smooth(List<PointF> list, int i3, int i16, float[] fArr) {
        char c16 = 0;
        if (!CollectionUtils.isEmpty(list) && i3 > 0 && i16 > 0) {
            int i17 = 3;
            PointF[] pointFArr = new PointF[3];
            int i18 = 0;
            int i19 = 0;
            while (i18 < NO_HOLE_TRIANGLE_COUNT_4_SMOOTH * i17) {
                int[] iArr = faceMesh4Smooth;
                pointFArr[c16] = list.get(iArr[i18]);
                pointFArr[1] = list.get(iArr[i18 + 1]);
                PointF pointF = list.get(iArr[i18 + 2]);
                pointFArr[2] = pointF;
                PointF pointF2 = pointFArr[c16];
                float f16 = pointF2.x;
                float f17 = i3;
                fArr[i19] = ((f16 / f17) * 2.0f) - 1.0f;
                float f18 = pointF2.y;
                float f19 = i16;
                fArr[i19 + 1] = ((f18 / f19) * 2.0f) - 1.0f;
                PointF pointF3 = pointFArr[1];
                float f26 = pointF3.x;
                fArr[i19 + 2] = ((f26 / f17) * 2.0f) - 1.0f;
                float f27 = pointF3.y;
                fArr[i19 + 3] = ((f27 / f19) * 2.0f) - 1.0f;
                fArr[i19 + 4] = ((f26 / f17) * 2.0f) - 1.0f;
                fArr[i19 + 5] = ((f27 / f19) * 2.0f) - 1.0f;
                float f28 = pointF.x;
                fArr[i19 + 6] = ((f28 / f17) * 2.0f) - 1.0f;
                float f29 = pointF.y;
                fArr[i19 + 7] = ((f29 / f19) * 2.0f) - 1.0f;
                fArr[i19 + 8] = ((f28 / f17) * 2.0f) - 1.0f;
                fArr[i19 + 9] = ((f29 / f19) * 2.0f) - 1.0f;
                fArr[i19 + 10] = ((f16 / f17) * 2.0f) - 1.0f;
                fArr[i19 + 11] = ((f18 / f19) * 2.0f) - 1.0f;
                i19 += 12;
                i18 += 3;
                i17 = 3;
                c16 = 0;
            }
            return fArr;
        }
        return new float[0];
    }

    public static float[] initFaceLinePositions_v2(List<PointF> list, int i3, int i16, float[] fArr) {
        char c16 = 0;
        if (!CollectionUtils.isEmpty(list) && i3 > 0 && i16 > 0) {
            int i17 = 3;
            PointF[] pointFArr = new PointF[3];
            int i18 = 0;
            int i19 = 0;
            while (i18 < NO_HOLE_TRIANGLE_COUNT_V2 * i17) {
                int[] iArr = FaceMeshTriangles_v2;
                pointFArr[c16] = list.get(iArr[i18]);
                pointFArr[1] = list.get(iArr[i18 + 1]);
                PointF pointF = list.get(iArr[i18 + 2]);
                pointFArr[2] = pointF;
                PointF pointF2 = pointFArr[c16];
                float f16 = pointF2.x;
                float f17 = i3;
                fArr[i19] = ((f16 / f17) * 2.0f) - 1.0f;
                float f18 = pointF2.y;
                float f19 = i16;
                fArr[i19 + 1] = ((f18 / f19) * 2.0f) - 1.0f;
                PointF pointF3 = pointFArr[1];
                float f26 = pointF3.x;
                fArr[i19 + 2] = ((f26 / f17) * 2.0f) - 1.0f;
                float f27 = pointF3.y;
                fArr[i19 + 3] = ((f27 / f19) * 2.0f) - 1.0f;
                fArr[i19 + 4] = ((f26 / f17) * 2.0f) - 1.0f;
                fArr[i19 + 5] = ((f27 / f19) * 2.0f) - 1.0f;
                float f28 = pointF.x;
                fArr[i19 + 6] = ((f28 / f17) * 2.0f) - 1.0f;
                float f29 = pointF.y;
                fArr[i19 + 7] = ((f29 / f19) * 2.0f) - 1.0f;
                fArr[i19 + 8] = ((f28 / f17) * 2.0f) - 1.0f;
                fArr[i19 + 9] = ((f29 / f19) * 2.0f) - 1.0f;
                fArr[i19 + 10] = ((f16 / f17) * 2.0f) - 1.0f;
                fArr[i19 + 11] = ((f18 / f19) * 2.0f) - 1.0f;
                i19 += 12;
                i18 += 3;
                i17 = 3;
                c16 = 0;
            }
            return fArr;
        }
        return new float[0];
    }

    public static float[] initFaceNoseLastPositions(List<PointF> list, int i3, int i16, float[] fArr) {
        if (!CollectionUtils.isEmpty(list) && fArr != null && i3 > 0 && i16 > 0 && fArr.length == 1380) {
            PointF[] pointFArr = new PointF[3];
            int i17 = 0;
            for (int i18 = 0; i18 < 690; i18 += 3) {
                int[] iArr = faceMeshNoseLastTriangles;
                pointFArr[0] = list.get(iArr[i18]);
                pointFArr[1] = list.get(iArr[i18 + 1]);
                pointFArr[2] = list.get(iArr[i18 + 2]);
                for (int i19 = 0; i19 < 3; i19++) {
                    int i26 = (i19 * 2) + i17;
                    PointF pointF = pointFArr[i19];
                    fArr[i26] = ((pointF.x / i3) * 2.0f) - 1.0f;
                    fArr[i26 + 1] = ((pointF.y / i16) * 2.0f) - 1.0f;
                }
                i17 += 6;
            }
            return fArr;
        }
        return new float[0];
    }

    public static float[] initFacePositions(List<PointF> list, int i3, int i16, float[] fArr) {
        return initFacePositions(list, i3, i16, fArr, null);
    }

    public static float[] initFacePositions4Smooth(List<PointF> list, int i3, int i16, float[] fArr, int i17) {
        if (!CollectionUtils.isEmpty(list) && fArr != null && i3 > 0 && i16 > 0) {
            PointF[] pointFArr = new PointF[3];
            for (int i18 = 0; i18 < NO_HOLE_TRIANGLE_COUNT_4_SMOOTH * 3; i18 += 3) {
                int[] iArr = faceMesh4Smooth;
                pointFArr[0] = list.get(iArr[i18]);
                pointFArr[1] = list.get(iArr[i18 + 1]);
                pointFArr[2] = list.get(iArr[i18 + 2]);
                for (int i19 = 0; i19 < 3; i19++) {
                    int i26 = (i19 * 2) + i17;
                    PointF pointF = pointFArr[i19];
                    fArr[i26] = ((pointF.x / i3) * 2.0f) - 1.0f;
                    fArr[i26 + 1] = ((pointF.y / i16) * 2.0f) - 1.0f;
                }
                i17 += 6;
            }
            return fArr;
        }
        return new float[0];
    }

    public static float[] initFacePositionsBaseOnFaceRect(List<PointF> list, float f16, float f17, float[] fArr) {
        if (!CollectionUtils.isEmpty(list) && fArr != null && f16 > 0.0f && f17 > 0.0f && fArr.length == 1380) {
            int size = list.size();
            float f18 = list.get(64).x;
            float f19 = list.get(64).y;
            for (int i3 = 0; i3 < size; i3++) {
                list.get(i3).x -= f18;
                list.get(i3).y -= f19;
            }
            PointF[] pointFArr = new PointF[3];
            int i16 = 0;
            for (int i17 = 0; i17 < 690; i17 += 3) {
                int[] iArr = FaceMeshTriangles;
                pointFArr[0] = list.get(iArr[i17]);
                pointFArr[1] = list.get(iArr[i17 + 1]);
                pointFArr[2] = list.get(iArr[i17 + 2]);
                for (int i18 = 0; i18 < 3; i18++) {
                    int i19 = (i18 * 2) + i16;
                    PointF pointF = pointFArr[i18];
                    fArr[i19] = (pointF.x / f16) * 2.0f;
                    fArr[i19 + 1] = (pointF.y / f17) * 2.0f;
                }
                i16 += 6;
            }
            return fArr;
        }
        return new float[0];
    }

    public static float[] initFacePositionsFaceAverage(List<PointF> list, int i3, int i16, float[] fArr, int i17) {
        if (!CollectionUtils.isEmpty(list) && fArr != null && i3 > 0 && i16 > 0 && fArr.length == 1104) {
            PointF[] pointFArr = new PointF[3];
            int i18 = 0;
            for (int i19 = 0; i19 < 552; i19 += 3) {
                if (i17 != 0) {
                    if (i17 == 1) {
                        int[] iArr = FaceMeshTrianglesFaceAverageForTypeOne;
                        pointFArr[0] = list.get(iArr[i19]);
                        pointFArr[1] = list.get(iArr[i19 + 1]);
                        pointFArr[2] = list.get(iArr[i19 + 2]);
                    }
                } else {
                    int[] iArr2 = FaceMeshTrianglesFaceAverage;
                    pointFArr[0] = list.get(iArr2[i19]);
                    pointFArr[1] = list.get(iArr2[i19 + 1]);
                    pointFArr[2] = list.get(iArr2[i19 + 2]);
                }
                for (int i26 = 0; i26 < 3; i26++) {
                    int i27 = (i26 * 2) + i18;
                    PointF pointF = pointFArr[i26];
                    fArr[i27] = ((pointF.x / i3) * 2.0f) - 1.0f;
                    fArr[i27 + 1] = ((pointF.y / i16) * 2.0f) - 1.0f;
                }
                i18 += 6;
            }
            return fArr;
        }
        return new float[0];
    }

    public static float[] initFacePositions_v2(List<PointF> list, int i3, int i16, float[] fArr) {
        return initFacePositions_v2(list, i3, i16, fArr, null);
    }

    public static float[] initFaceTexCoords4Smooth(List<PointF> list, int i3, int i16, float[] fArr) {
        if (!CollectionUtils.isEmpty(list) && fArr != null && i3 > 0 && i16 > 0) {
            PointF[] pointFArr = new PointF[3];
            int i17 = 0;
            for (int i18 = 0; i18 < NO_HOLE_TRIANGLE_COUNT_4_SMOOTH * 3; i18 += 3) {
                int[] iArr = faceMesh4Smooth;
                pointFArr[0] = list.get(iArr[i18]);
                pointFArr[1] = list.get(iArr[i18 + 1]);
                pointFArr[2] = list.get(iArr[i18 + 2]);
                for (int i19 = 0; i19 < 3; i19++) {
                    int i26 = (i19 * 2) + i17;
                    PointF pointF = pointFArr[i19];
                    fArr[i26] = pointF.x / i3;
                    fArr[i26 + 1] = pointF.y / i16;
                }
                i17 += 6;
            }
            return fArr;
        }
        return new float[0];
    }

    public static float[] initIrisLinePositions(List<PointF> list, int i3, int i16, float[] fArr) {
        char c16 = 0;
        if (!CollectionUtils.isEmpty(list) && i3 > 0 && i16 > 0) {
            PointF[] pointFArr = new PointF[3];
            int i17 = 0;
            int i18 = 0;
            while (i17 < 24) {
                int[] iArr = IrisMeshTriangles;
                pointFArr[c16] = list.get(iArr[i17]);
                pointFArr[1] = list.get(iArr[i17 + 1]);
                PointF pointF = list.get(iArr[i17 + 2]);
                pointFArr[2] = pointF;
                PointF pointF2 = pointFArr[c16];
                float f16 = pointF2.x;
                float f17 = i3;
                fArr[i18] = ((f16 / f17) * 2.0f) - 1.0f;
                float f18 = pointF2.y;
                float f19 = i16;
                fArr[i18 + 1] = ((f18 / f19) * 2.0f) - 1.0f;
                PointF pointF3 = pointFArr[1];
                float f26 = pointF3.x;
                fArr[i18 + 2] = ((f26 / f17) * 2.0f) - 1.0f;
                float f27 = pointF3.y;
                fArr[i18 + 3] = ((f27 / f19) * 2.0f) - 1.0f;
                fArr[i18 + 4] = ((f26 / f17) * 2.0f) - 1.0f;
                fArr[i18 + 5] = ((f27 / f19) * 2.0f) - 1.0f;
                float f28 = pointF.x;
                fArr[i18 + 6] = ((f28 / f17) * 2.0f) - 1.0f;
                float f29 = pointF.y;
                fArr[i18 + 7] = ((f29 / f19) * 2.0f) - 1.0f;
                fArr[i18 + 8] = ((f28 / f17) * 2.0f) - 1.0f;
                fArr[i18 + 9] = ((f29 / f19) * 2.0f) - 1.0f;
                fArr[i18 + 10] = ((f16 / f17) * 2.0f) - 1.0f;
                fArr[i18 + 11] = ((f18 / f19) * 2.0f) - 1.0f;
                i18 += 12;
                i17 += 3;
                c16 = 0;
            }
            return fArr;
        }
        return new float[0];
    }

    public static float[] initMaterialFaceNoseLastTexCoords(List<PointF> list, int i3, int i16, float[] fArr) {
        if (!CollectionUtils.isEmpty(list) && fArr != null && i3 > 0 && i16 > 0 && fArr.length == 1380) {
            PointF[] pointFArr = new PointF[3];
            int i17 = 0;
            for (int i18 = 0; i18 < 690; i18 += 3) {
                int[] iArr = faceMeshNoseLastTriangles;
                pointFArr[0] = list.get(iArr[i18]);
                pointFArr[1] = list.get(iArr[i18 + 1]);
                pointFArr[2] = list.get(iArr[i18 + 2]);
                for (int i19 = 0; i19 < 3; i19++) {
                    int i26 = (i19 * 2) + i17;
                    PointF pointF = pointFArr[i19];
                    fArr[i26] = pointF.x / i3;
                    fArr[i26 + 1] = pointF.y / i16;
                }
                i17 += 6;
            }
            return fArr;
        }
        return new float[0];
    }

    public static float[] initMaterialFaceTexCoords(List<PointF> list, int i3, int i16, float[] fArr) {
        if (!CollectionUtils.isEmpty(list) && fArr != null && i3 > 0 && i16 > 0 && fArr.length == 1380) {
            PointF[] pointFArr = new PointF[3];
            int i17 = 0;
            for (int i18 = 0; i18 < 690; i18 += 3) {
                int[] iArr = FaceMeshTriangles;
                pointFArr[0] = list.get(iArr[i18]);
                pointFArr[1] = list.get(iArr[i18 + 1]);
                pointFArr[2] = list.get(iArr[i18 + 2]);
                for (int i19 = 0; i19 < 3; i19++) {
                    int i26 = (i19 * 2) + i17;
                    PointF pointF = pointFArr[i19];
                    fArr[i26] = pointF.x / i3;
                    fArr[i26 + 1] = pointF.y / i16;
                }
                i17 += 6;
            }
            return fArr;
        }
        return new float[0];
    }

    public static float[] initMaterialFaceTexCoordsFaceAverage(List<PointF> list, int i3, int i16, float[] fArr, int i17) {
        if (!CollectionUtils.isEmpty(list) && fArr != null && i3 > 0 && i16 > 0 && fArr.length == 1104) {
            PointF[] pointFArr = new PointF[3];
            int i18 = 0;
            for (int i19 = 0; i19 < 552; i19 += 3) {
                if (i17 != 0) {
                    if (i17 == 1) {
                        int[] iArr = FaceMeshTrianglesFaceAverageForTypeOne;
                        pointFArr[0] = list.get(iArr[i19]);
                        pointFArr[1] = list.get(iArr[i19 + 1]);
                        pointFArr[2] = list.get(iArr[i19 + 2]);
                    }
                } else {
                    int[] iArr2 = FaceMeshTrianglesFaceAverage;
                    pointFArr[0] = list.get(iArr2[i19]);
                    pointFArr[1] = list.get(iArr2[i19 + 1]);
                    pointFArr[2] = list.get(iArr2[i19 + 2]);
                }
                for (int i26 = 0; i26 < 3; i26++) {
                    int i27 = (i26 * 2) + i18;
                    PointF pointF = pointFArr[i26];
                    fArr[i27] = pointF.x / i3;
                    fArr[i27 + 1] = pointF.y / i16;
                }
                i18 += 6;
            }
            return fArr;
        }
        return new float[0];
    }

    public static float[] initMaterialFaceTexCoords_v2(List<PointF> list, int i3, int i16, float[] fArr) {
        if (!CollectionUtils.isEmpty(list) && fArr != null && i3 > 0 && i16 > 0 && fArr.length == NO_HOLE_TRIANGLE_COUNT_V2 * 3 * 2) {
            PointF[] pointFArr = new PointF[3];
            int i17 = 0;
            for (int i18 = 0; i18 < NO_HOLE_TRIANGLE_COUNT_V2 * 3; i18 += 3) {
                int[] iArr = FaceMeshTriangles_v2;
                pointFArr[0] = list.get(iArr[i18]);
                pointFArr[1] = list.get(iArr[i18 + 1]);
                pointFArr[2] = list.get(iArr[i18 + 2]);
                for (int i19 = 0; i19 < 3; i19++) {
                    int i26 = (i19 * 2) + i17;
                    PointF pointF = pointFArr[i19];
                    fArr[i26] = pointF.x / i3;
                    fArr[i26 + 1] = pointF.y / i16;
                }
                i17 += 6;
            }
            return fArr;
        }
        return new float[0];
    }

    public static float[] initPointVis(float[] fArr, float[] fArr2) {
        if (fArr != null && fArr2.length == 1380) {
            float[] fArr3 = new float[3];
            int i3 = 0;
            for (int i16 = 0; i16 < 690; i16 += 3) {
                int[] iArr = FaceMeshTriangles;
                fArr3[0] = fArr[iArr[i16]];
                fArr3[1] = fArr[iArr[i16 + 1]];
                fArr3[2] = fArr[iArr[i16 + 2]];
                for (int i17 = 0; i17 < 3; i17++) {
                    int i18 = (i17 * 2) + i3;
                    fArr2[i18] = fArr3[i17];
                    fArr2[i18 + 1] = fArr3[i17];
                }
                i3 += 6;
            }
            return fArr2;
        }
        return new float[0];
    }

    public static float[] initPointVis_v2(float[] fArr, float[] fArr2) {
        if (fArr != null && fArr2.length == NO_HOLE_TRIANGLE_COUNT_V2 * 3 * 2) {
            float[] fArr3 = new float[3];
            int i3 = 0;
            for (int i16 = 0; i16 < NO_HOLE_TRIANGLE_COUNT_V2 * 3; i16 += 3) {
                int[] iArr = FaceMeshTriangles_v2;
                fArr3[0] = fArr[iArr[i16]];
                fArr3[1] = fArr[iArr[i16 + 1]];
                fArr3[2] = fArr[iArr[i16 + 2]];
                for (int i17 = 0; i17 < 3; i17++) {
                    int i18 = (i17 * 2) + i3;
                    fArr2[i18] = fArr3[i17];
                    fArr2[i18 + 1] = fArr3[i17];
                }
                i3 += 6;
            }
            return fArr2;
        }
        return new float[0];
    }

    public static List<PointF> loadTexCoords(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        String str2 = File.separator;
        return loadTexCoords(str.substring(0, str.lastIndexOf(str2)), str.substring(str.lastIndexOf(str2) + 1));
    }

    public static native void nativeGetFullCoords(Object obj, int i3, float f16, Object obj2);

    public static void recycleCrazySkinMergeBitmap() {
        BitmapUtils.recycle(crazySkinMergeBitmap);
    }

    public static void scalePoints(List<PointF> list, double d16) {
        if (list == null) {
            return;
        }
        for (PointF pointF : list) {
            pointF.x = (float) (pointF.x * d16);
            pointF.y = (float) (pointF.y * d16);
        }
    }

    public static void setCrazyFacePath(String str) {
        GRAY_FILE_CRAZY_FACE = str;
    }

    public static void setCrazyLipsMaskPath(String str) {
        GRAY_FILE_LIPS_MASK = str;
    }

    public static void setCrazyMaskCos3DPath(String str) {
        GRAY_FILE_FACE_COS3D_MASK = str;
    }

    public static void setCrazyMaskPath(String str) {
        GRAY_FILE_MASK = str;
    }

    public static void setCropHeadFacePath(String str) {
        GRAY_FILE_CROP_HEAD_FACE = str;
    }

    public static void setFaceMaskSkinPath(String str) {
        GRAY_FILE_FACE_SKIN = str;
    }

    public static void setGrayFileNoseMask(String str) {
        GRAY_FILE_NOSE_MASK = str;
    }

    public static void setMaskBrushPointPath(String str) {
        DEFAULT_BRUSH_POINT = str;
    }

    public static void setNoEyeGrayImagePath(String str) {
        GRAY_FILE_HAS_EYE = str;
    }

    public static void setNoMouthGrayImagePath(String str) {
        GRAY_FILE_NO_EYE = str;
    }

    public static Bitmap getFaceBitmap(String str, int i3, int i16) {
        Bitmap decodeSampledBitmapFromAssets;
        if (str == null) {
            return null;
        }
        if (str.startsWith("/")) {
            decodeSampledBitmapFromAssets = BitmapUtils.decodeSampledBitmapFromFileCheckExif(str, i3, i16);
        } else {
            decodeSampledBitmapFromAssets = BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(str), i3, i16);
        }
        if (BitmapUtils.isLegal(decodeSampledBitmapFromAssets)) {
            return decodeSampledBitmapFromAssets;
        }
        return null;
    }

    public static float[] initFacePositions(List<PointF> list, int i3, int i16, float[] fArr, float[] fArr2) {
        int i17 = 0;
        if (CollectionUtils.isEmpty(list) || fArr == null || i3 <= 0 || i16 <= 0 || fArr.length != 1380) {
            return new float[0];
        }
        int i18 = 3;
        PointF[] pointFArr = new PointF[3];
        float f16 = 0.0f;
        int i19 = 0;
        int i26 = 0;
        float f17 = 0.0f;
        while (i19 < 690) {
            int[] iArr = FaceMeshTriangles;
            pointFArr[i17] = list.get(iArr[i19]);
            pointFArr[1] = list.get(iArr[i19 + 1]);
            pointFArr[2] = list.get(iArr[i19 + 2]);
            int i27 = i17;
            while (i27 < i18) {
                int i28 = (i27 * 2) + i26;
                PointF pointF = pointFArr[i27];
                float f18 = ((pointF.x / i3) * 2.0f) - 1.0f;
                fArr[i28] = f18;
                f16 += f18;
                float f19 = ((pointF.y / i16) * 2.0f) - 1.0f;
                fArr[i28 + 1] = f19;
                f17 += f19;
                i27++;
                i18 = 3;
            }
            i26 += 6;
            i19 += 3;
            i18 = 3;
            i17 = 0;
        }
        if (fArr2 != null && fArr2.length >= 2) {
            fArr2[0] = f16;
            fArr2[1] = f17;
        }
        return fArr;
    }

    public static float[] initFacePositions_v2(List<PointF> list, int i3, int i16, float[] fArr, float[] fArr2) {
        int i17 = 0;
        if (!CollectionUtils.isEmpty(list) && fArr != null && i3 > 0 && i16 > 0) {
            int i18 = 3;
            char c16 = 2;
            if (fArr.length == NO_HOLE_TRIANGLE_COUNT_V2 * 3 * 2) {
                PointF[] pointFArr = new PointF[3];
                float f16 = 0.0f;
                int i19 = 0;
                int i26 = 0;
                float f17 = 0.0f;
                while (i19 < NO_HOLE_TRIANGLE_COUNT_V2 * i18) {
                    int[] iArr = FaceMeshTriangles_v2;
                    pointFArr[i17] = list.get(iArr[i19]);
                    pointFArr[1] = list.get(iArr[i19 + 1]);
                    pointFArr[c16] = list.get(iArr[i19 + 2]);
                    int i27 = i17;
                    while (i27 < i18) {
                        int i28 = (i27 * 2) + i26;
                        PointF pointF = pointFArr[i27];
                        float f18 = ((pointF.x / i3) * 2.0f) - 1.0f;
                        fArr[i28] = f18;
                        f16 += f18;
                        float f19 = ((pointF.y / i16) * 2.0f) - 1.0f;
                        fArr[i28 + 1] = f19;
                        f17 += f19;
                        i27++;
                        i18 = 3;
                    }
                    i26 += 6;
                    i19 += 3;
                    i17 = 0;
                    i18 = 3;
                    c16 = 2;
                }
                if (fArr2 != null && fArr2.length >= 2) {
                    fArr2[0] = f16;
                    fArr2[1] = f17;
                }
                return fArr;
            }
        }
        return new float[0];
    }

    private static List<PointF> loadTexCoords(String str, String str2) {
        String load;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (load = FileUtils.load(AEModule.getContext(), str, str2)) == null) {
            return arrayList;
        }
        String[] split = load.trim().split("\\s+");
        for (int i3 = 0; i3 < split.length / 2; i3++) {
            try {
                int i16 = i3 * 2;
                arrayList.add(new PointF(Float.parseFloat(split[i16]), Float.parseFloat(split[i16 + 1])));
            } catch (NumberFormatException e16) {
                LogUtils.e(TAG, e16.toString());
                return new ArrayList();
            }
        }
        return arrayList;
    }

    public static List<PointF> getFullCoords(List<PointF> list, float f16) {
        double d16;
        double d17;
        if (!CollectionUtils.isEmpty(list) && list.size() >= 90) {
            if (list.size() > 97) {
                list.subList(97, list.size()).clear();
            }
            if (list.size() != 90 && list.size() != 97) {
                return list;
            }
            PointF pointF = new PointF((list.get(41).x + list.get(51).x) / 2.0f, (list.get(41).y + list.get(51).y) / 2.0f);
            double atan2 = Math.atan2(list.get(9).x - list.get(84).x, (-list.get(9).y) + list.get(84).y) + 3.141592653589793d;
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.postTranslate(-pointF.x, -pointF.y);
            matrix.postRotate((float) Math.toDegrees(-atan2));
            matrix.postTranslate(pointF.x, pointF.y);
            List<PointF> mapPoints = AlgoUtils.mapPoints(list, matrix);
            if (mapPoints.size() == 90) {
                int i3 = 1;
                double distance = AlgoUtils.getDistance(mapPoints.get(0), mapPoints.get(1)) * 2.0f;
                PointF pointF2 = new PointF((float) (mapPoints.get(1).x + (Math.sin(0.0d) * distance)), (float) (mapPoints.get(1).y - (distance * Math.cos(0.0d))));
                mapPoints.add(pointF2);
                double distance2 = AlgoUtils.getDistance(mapPoints.get(17), mapPoints.get(18)) * 2.0f;
                PointF pointF3 = new PointF((float) (mapPoints.get(17).x + (Math.sin(0.0d) * distance2)), (float) (mapPoints.get(17).y - (distance2 * Math.cos(0.0d))));
                mapPoints.add(pointF3);
                double distance3 = AlgoUtils.getDistance(mapPoints.get(59), pointF) * 2.0f;
                PointF pointF4 = new PointF((float) (mapPoints.get(59).x + (Math.sin(0.0d) * distance3)), (float) (mapPoints.get(59).y - (distance3 * Math.cos(0.0d))));
                int i16 = 2;
                while (i16 >= i3) {
                    double radians = Math.toRadians(i16 * 30.0f);
                    PointF pointF5 = new PointF();
                    double d18 = atan2;
                    pointF5.x = (float) (pointF4.x - ((r8 - pointF3.x) * Math.cos(radians)));
                    pointF5.y = (float) (pointF3.y - ((r3 - pointF4.y) * Math.sin(radians)));
                    mapPoints.add(pointF5);
                    i16--;
                    atan2 = d18;
                    i3 = 1;
                }
                d16 = atan2;
                int i17 = i3;
                for (int i18 = 3; i18 >= i17; i18--) {
                    double radians2 = Math.toRadians(i18 * 30.0f);
                    PointF pointF6 = new PointF();
                    pointF6.x = (float) (pointF4.x - ((r10 - pointF2.x) * Math.cos(radians2)));
                    pointF6.y = (float) (pointF2.y - ((r10 - pointF4.y) * Math.sin(radians2)));
                    mapPoints.add(pointF6);
                }
            } else {
                d16 = atan2;
            }
            mapPoints.add(EMPTY_POINT);
            mapPoints.add(EMPTY_POINT);
            PointF pointF7 = mapPoints.get(64);
            PointF pointF8 = mapPoints.get(54);
            PointF pointF9 = mapPoints.get(44);
            PointF pointF10 = new PointF(pointF8.x - pointF9.x, pointF8.y - pointF9.y);
            PointF pointF11 = new PointF(pointF10.x * f16, pointF10.y * f16);
            PointF pointF12 = new PointF(-pointF11.y, pointF11.x);
            mapPoints.add(new PointF((pointF7.x - pointF11.x) - pointF12.x, (pointF7.y - pointF11.y) - pointF12.y));
            mapPoints.add(new PointF(pointF7.x - pointF11.x, pointF7.y - pointF11.y));
            mapPoints.add(new PointF((pointF7.x - pointF11.x) + pointF12.x, (pointF7.y - pointF11.y) + pointF12.y));
            mapPoints.add(new PointF(pointF7.x + pointF12.x, pointF7.y + pointF12.y));
            mapPoints.add(new PointF(pointF7.x + pointF11.x + pointF12.x, pointF7.y + pointF11.y + pointF12.y));
            mapPoints.add(new PointF(pointF7.x + pointF11.x, pointF7.y + pointF11.y));
            mapPoints.add(new PointF((pointF7.x + pointF11.x) - pointF12.x, (pointF7.y + pointF11.y) - pointF12.y));
            mapPoints.add(new PointF(pointF7.x - pointF12.x, pointF7.y - pointF12.y));
            mapPoints.get(3);
            mapPoints.get(15);
            mapPoints.get(65);
            mapPoints.get(66);
            PointF middlePoint = AlgoUtils.middlePoint(mapPoints.get(3), mapPoints.get(65));
            mapPoints.add(new PointF(middlePoint.x, middlePoint.y));
            PointF middlePoint2 = AlgoUtils.middlePoint(mapPoints.get(15), mapPoints.get(66));
            mapPoints.add(new PointF(middlePoint2.x, middlePoint2.y));
            mapPoints.get(2);
            mapPoints.get(16);
            int i19 = 39;
            mapPoints.get(39);
            mapPoints.get(49);
            mapPoints.get(57);
            mapPoints.get(61);
            mapPoints.get(35);
            mapPoints.get(45);
            PointF middlePoint3 = AlgoUtils.middlePoint(mapPoints.get(35), mapPoints.get(57));
            mapPoints.add(new PointF(middlePoint3.x, middlePoint3.y));
            PointF middlePoint4 = AlgoUtils.middlePoint(mapPoints.get(45), mapPoints.get(61));
            mapPoints.add(new PointF(middlePoint4.x, middlePoint4.y));
            mapPoints.get(37);
            PointF pointF13 = mapPoints.get(44);
            int i26 = 35;
            while (true) {
                d17 = 1.0d;
                if (i26 >= i19) {
                    break;
                }
                PointF pointF14 = mapPoints.get(i26);
                Matrix matrix2 = matrix;
                if (Math.abs(pointF14.x - pointF13.x) < 1.0d) {
                    mapPoints.add(new PointF(pointF14.x, (float) (pointF14.y + ((r7 - pointF13.y) * 0.7d))));
                } else {
                    float f17 = pointF14.y;
                    float f18 = pointF13.y;
                    float f19 = pointF14.x;
                    float f26 = pointF13.x;
                    float f27 = (float) (f19 + ((f19 - f26) * 0.7d));
                    float f28 = (((f17 - f18) / (f19 - f26)) * (f27 - f26)) + f18;
                    if (i26 == 35 && f27 < mapPoints.get(0).x) {
                        f27 = mapPoints.get(0).x;
                    }
                    mapPoints.add(new PointF(f27, f28));
                }
                i26++;
                matrix = matrix2;
                i19 = 39;
            }
            Matrix matrix3 = matrix;
            PointF middlePoint5 = AlgoUtils.middlePoint(mapPoints.get(i19), mapPoints.get(55));
            mapPoints.add(new PointF(middlePoint5.x, middlePoint5.y));
            int size = mapPoints.size();
            int i27 = 40;
            while (i27 < 43) {
                PointF pointF15 = mapPoints.get(i27);
                if (Math.abs(pointF15.x - pointF13.x) < d17) {
                    mapPoints.add(new PointF(pointF15.x, (float) (pointF15.y + ((r4 - pointF13.y) * 1.2d))));
                } else {
                    float f29 = pointF15.y;
                    float f36 = pointF13.y;
                    float f37 = pointF15.x;
                    float f38 = pointF13.x;
                    float f39 = (f29 - f36) / (f37 - f38);
                    float f46 = (float) (f37 + ((f37 - f38) * 1.2d));
                    mapPoints.add(new PointF(f46, (f39 * (f46 - f38)) + f36));
                }
                i27++;
                d17 = 1.0d;
            }
            PointF pointF16 = mapPoints.get(size);
            PointF pointF17 = mapPoints.get(size + 1);
            PointF pointF18 = mapPoints.get(size + 2);
            PointF middlePoint6 = AlgoUtils.middlePoint(pointF16, pointF17);
            PointF middlePoint7 = AlgoUtils.middlePoint(pointF18, pointF17);
            mapPoints.add(new PointF(middlePoint6.x, middlePoint6.y));
            mapPoints.add(new PointF(middlePoint7.x, middlePoint7.y));
            PointF pointF19 = mapPoints.get(54);
            for (int i28 = 45; i28 < 49; i28++) {
                PointF pointF20 = mapPoints.get(i28);
                if (Math.abs(pointF20.x - pointF19.x) < 1.0d) {
                    mapPoints.add(new PointF(pointF20.x, (float) (pointF20.y + ((r4 - pointF19.y) * 0.7d))));
                } else {
                    float f47 = pointF20.y;
                    float f48 = pointF19.y;
                    float f49 = pointF20.x;
                    float f56 = pointF19.x;
                    float f57 = (f47 - f48) / (f49 - f56);
                    float f58 = (float) (f49 + ((f49 - f56) * 0.7d));
                    float f59 = (f57 * (f58 - f56)) + f48;
                    if (i28 == 45 && f58 > mapPoints.get(18).x) {
                        f58 = mapPoints.get(18).x;
                    }
                    mapPoints.add(new PointF(f58, f59));
                }
            }
            PointF middlePoint8 = AlgoUtils.middlePoint(mapPoints.get(49), mapPoints.get(63));
            mapPoints.add(new PointF(middlePoint8.x, middlePoint8.y));
            int size2 = mapPoints.size();
            for (int i29 = 50; i29 < 53; i29++) {
                PointF pointF21 = mapPoints.get(i29);
                if (Math.abs(pointF21.x - pointF19.x) < 1.0d) {
                    mapPoints.add(new PointF(pointF21.x, (float) (pointF21.y + ((r7 - pointF19.y) * 1.2d))));
                } else {
                    float f65 = pointF21.y;
                    float f66 = pointF19.y;
                    float f67 = pointF21.x;
                    float f68 = pointF19.x;
                    float f69 = (f65 - f66) / (f67 - f68);
                    float f75 = (float) (f67 + ((f67 - f68) * 1.2d));
                    mapPoints.add(new PointF(f75, (f69 * (f75 - f68)) + f66));
                }
            }
            PointF pointF22 = mapPoints.get(size2);
            PointF pointF23 = mapPoints.get(size2 + 1);
            PointF pointF24 = mapPoints.get(size2 + 2);
            PointF middlePoint9 = AlgoUtils.middlePoint(pointF22, pointF23);
            PointF middlePoint10 = AlgoUtils.middlePoint(pointF24, pointF23);
            mapPoints.add(new PointF(middlePoint9.x, middlePoint9.y));
            mapPoints.add(new PointF(middlePoint10.x, middlePoint10.y));
            matrix3.reset();
            matrix3.postTranslate(-pointF.x, -pointF.y);
            matrix3.postRotate((float) Math.toDegrees(d16));
            matrix3.postTranslate(pointF.x, pointF.y);
            return AlgoUtils.mapPoints(mapPoints, matrix3);
        }
        return new ArrayList();
    }

    public static void getFullCoords(Object obj, int i3, float f16, Object obj2) {
        nativeGetFullCoords(obj, i3, f16, obj2);
    }
}
