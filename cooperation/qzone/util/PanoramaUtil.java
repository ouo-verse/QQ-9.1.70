package cooperation.qzone.util;

import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import common.config.service.QzoneConfig;
import java.util.ArrayList;

/* loaded from: classes38.dex */
public class PanoramaUtil {
    public static final int CYLINDER_PIECE = 36;
    private static final int DEFAULT_PANORAMA_BLACKLIST_LEVEL_VALUE = 20;
    private static final int DEFAULT_PANORAMA_SWITCH_VALUE = 1;
    public static final String MTA_EVENT_KEY_ALBUM_DLNA = "qzone_panorama";
    public static final String MTA_SUB_KEY_COVER_PANORAMA = "qzone_cover_panorama";
    public static final String MTA_SUB_KEY_FEED_PANORAMA = "qzone_feed_panorama";
    public static final String MTA_SUB_KEY_GALLERY = "qzone_gallery";
    public static final String MTA_SUB_KEY_GALLERY_PANORAMA = "qzone_gallery_panorama";
    public static final String MTA_SUB_KEY_UPLOAD_ALL_COUNT = "upload_all_count";
    public static final String MTA_SUB_KEY_UPLOAD_PANORAMA_CYLINDER = "upload_panorama_cylinder";
    public static final String MTA_SUB_KEY_UPLOAD_PANORAMA_SPHERE = "upload_panorama_sphere";
    public static final String MTA_VALUE_PANORAMA_CLICK = "click";
    public static final String MTA_VALUE_PANORAMA_EXPOSE = "expose";
    public static final String SVR_PANORAMA_BALL = "2";
    public static final String SVR_PANORAMA_CYLINDER = "1";
    public static final String SVR_PANORAMA_NORMAL = "0";
    private static final String TAG = "PanoramaUtil";
    public static final int TYPE_PANORAMA_BALL = 2;
    public static final int TYPE_PANORAMA_CYLINDER = 1;
    public static final String TYPE_PANORAMA_NAME = "panorama_type";
    public static final int TYPE_PANORAMA_NORMAL = 3;
    private static PanoramaUtil instance;
    private ArrayList<float[]> sphereList;
    private static final String QZONE_CONFIG_SECONDARY_KEY_PANORAMA_SWITCH_VALUE = "panoramaSwitch";
    private static int mPanoramaSwitch = QzoneConfig.getInstance().getConfig("QZoneSetting", QZONE_CONFIG_SECONDARY_KEY_PANORAMA_SWITCH_VALUE, 1);
    private static final String QZONE_CONFIG_SECONDARY_KEY_PANORAMA_BLACKLIST_LEVEL_VALUE = "panoramaBlackListLevelValue";
    private static final int mPanoramaBlackLevel = QzoneConfig.getInstance().getConfig("QZoneSetting", QZONE_CONFIG_SECONDARY_KEY_PANORAMA_BLACKLIST_LEVEL_VALUE, 20);
    private static final String QZONE_CONFIG_SECONDARY_KEY_PANORAMA_BLACKLIST_VALUE = "panoramaBlackListValue";
    private static final String DEFAULT_PANORAMA_BLACKLIST_VALUE = "MI 3";
    private static final String mPanoramaBlackList = QzoneConfig.getInstance().getConfig("QZoneSetting", QZONE_CONFIG_SECONDARY_KEY_PANORAMA_BLACKLIST_VALUE, DEFAULT_PANORAMA_BLACKLIST_VALUE);
    private static final String QZONE_CONFIG_SECONDARY_KEY_PANORAMA__ROTATION_BLACKLIST_VALUE = "panoramaRotationBlackListValue";
    private static final String DEFAULT_PANORAMA_ROTATION_BLACKLIST_VALUE = "KNT-AL20";
    private static final String mPanoramaRotationBlackList = QzoneConfig.getInstance().getConfig("QZoneSetting", QZONE_CONFIG_SECONDARY_KEY_PANORAMA__ROTATION_BLACKLIST_VALUE, DEFAULT_PANORAMA_ROTATION_BLACKLIST_VALUE);
    private volatile String g_panoramaBlacklist = null;
    private volatile boolean g_isInPanoramaBlacklist = false;
    private volatile String g_panoramaRotationBlacklist = null;
    private volatile boolean g_isInPanoramaRotationBlacklist = false;

    public static PanoramaUtil getInstance() {
        if (instance == null) {
            synchronized (PanoramaUtil.class) {
                if (instance == null) {
                    instance = new PanoramaUtil();
                }
            }
        }
        return instance;
    }

    private boolean isBuildModelInList(String str) {
        try {
            String model = DeviceInfoMonitor.getModel();
            if (model != null && model.length() != 0) {
                if (QZLog.isColorLevel()) {
                    QZLog.d(TAG, 2, "buildModel is '" + model + "'");
                }
                if (str != null && str.length() != 0) {
                    if (("," + str + ",").contains("," + model + ",")) {
                        QZLog.i(TAG, 1, "\u547d\u4e2d\u7981\u6b62\u5168\u666f\u9ed1\u540d\u5355\u7b56\u7565");
                        return true;
                    }
                }
                return false;
            }
            QZLog.i(TAG, 1, "buildModel is empty,not show panorama items.\u547d\u4e2d\u7981\u6b62\u5168\u666f\u7b56\u7565");
            return true;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public static boolean isPanoramaPhoto(int i3) {
        if (!getInstance().isNeedShowPanorama()) {
            QZLog.i(TAG, "isPanoramaPhoto NoNeedShowPanorama");
            return false;
        }
        if (i3 == 1 || i3 == 2) {
            QZLog.i(TAG, "isPanoramaPhoto ReallyPanorama");
            return true;
        }
        if (i3 == 3) {
            QZLog.i(TAG, "isPanoramaPhoto IsNormal");
            return false;
        }
        QZLog.i(TAG, "isPanoramaPhoto Return");
        return false;
    }

    public static void setPanoramaType(LocalMediaInfo localMediaInfo) {
        int i3;
        if (localMediaInfo.panoramaPhotoType == 0 && getInstance().isNeedShowPanorama()) {
            int i16 = localMediaInfo.mediaWidth;
            if (i16 == 0 || (i3 = localMediaInfo.mediaHeight) == 0) {
                QZLog.i(TAG, "setPanoramaType LocalMediaInfoFalse");
                return;
            }
            if (i3 < 1000 || i16 / i3 != 2.0f) {
                if (i3 >= 512 && i16 / i3 >= 4.0f) {
                    localMediaInfo.panoramaPhotoType = 1;
                    QZLog.i(TAG, "setPanoramaType IsPanoramaCylinder");
                    return;
                } else {
                    QZLog.i(TAG, "setPanoramaType NormalType");
                    localMediaInfo.panoramaPhotoType = 3;
                    return;
                }
            }
            boolean isPanorama = XMPCoreUtil.getInstance().isPanorama(localMediaInfo.path);
            QZLog.i(TAG, "setPanoramaType GetIsPanorama");
            if (isPanorama) {
                localMediaInfo.panoramaPhotoType = 2;
                QZLog.i(TAG, "setPanoramaType IsPanorama");
                return;
            } else {
                localMediaInfo.panoramaPhotoType = 3;
                QZLog.i(TAG, "setPanoramaType IsNotPanorama");
                return;
            }
        }
        QZLog.i(TAG, "setPanoramaType NoPanoramaPhoto");
    }

    public ArrayList<float[]> getCylinderCoordinate(float f16, boolean z16) {
        return setCylinderList(new ArrayList<>(), f16, z16);
    }

    public boolean isClosePanoramaRotation() {
        String str = mPanoramaRotationBlackList;
        if (str == null || Build.VERSION.SDK_INT < 24) {
            return false;
        }
        if (!str.equals(this.g_panoramaRotationBlacklist)) {
            this.g_isInPanoramaRotationBlacklist = isBuildModelInList(str);
            this.g_panoramaRotationBlacklist = str;
        }
        return this.g_isInPanoramaRotationBlacklist;
    }

    public boolean isHighDevice() {
        return ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).getCurrentMemLevel() == 3;
    }

    public boolean isNeedShowPanorama() {
        if (mPanoramaSwitch == 0 || Build.VERSION.SDK_INT <= mPanoramaBlackLevel) {
            return false;
        }
        String str = mPanoramaBlackList;
        if (str == null) {
            return true;
        }
        if (!str.equals(this.g_panoramaBlacklist)) {
            this.g_isInPanoramaBlacklist = isBuildModelInList(str);
            this.g_panoramaBlacklist = str;
        }
        return !this.g_isInPanoramaBlacklist;
    }

    public int computeSampleSize(ImageLoader.Options options, int i3, int i16) {
        int i17 = 1;
        QZLog.i(TAG, 4, "computeSampleSize width = ", Integer.valueOf(i3), " height = ", Integer.valueOf(i16));
        if (i3 / i16 == 2) {
            if (i3 > 4096) {
                options.imageConfig = Bitmap.Config.RGB_565;
            }
            while (((((i3 / i17) * (i16 / i17)) * (options.imageConfig == Bitmap.Config.RGB_565 ? 2 : 4)) / 1024) / 1024 > 32) {
                i17 <<= 1;
            }
            return i17;
        }
        if (i3 >= i16) {
            i3 = i16;
        }
        while (i3 / i17 > 320) {
            i17 <<= 1;
        }
        return i17;
    }

    public ArrayList<float[]> getSphereCoordinate() {
        if (this.sphereList == null) {
            this.sphereList = new ArrayList<>();
        }
        int i3 = 0;
        Object[] objArr = {"sphereList size = ", Integer.valueOf(this.sphereList.size())};
        String str = TAG;
        int i16 = 4;
        QZLog.i(TAG, 4, objArr);
        if (this.sphereList.size() == 2 && this.sphereList.get(0) != null && this.sphereList.get(0).length > 0 && this.sphereList.get(1) != null && this.sphereList.get(1).length > 0) {
            return this.sphereList;
        }
        this.sphereList.clear();
        int i17 = 72;
        float f16 = 72;
        double d16 = 6.283185307179586d / f16;
        double d17 = 1.0f / f16;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        int i18 = 0;
        while (i18 < i17) {
            int i19 = i3;
            while (i19 < i17) {
                float f17 = i16;
                double d18 = d17;
                double d19 = i18;
                double d26 = (d19 * d16) / 2.0d;
                double d27 = i19;
                double d28 = d27 * d16;
                ArrayList arrayList3 = arrayList;
                float sin = ((float) (Math.sin(d26) * Math.cos(d28))) * f17;
                int i26 = i19;
                float sin2 = ((float) (Math.sin(d26) * Math.sin(d28))) * f17;
                double d29 = d16;
                float cos = ((float) Math.cos(d26)) * f17;
                double d36 = i18 + 1;
                double d37 = (d36 * d29) / 2.0d;
                float sin3 = ((float) (Math.sin(d37) * Math.cos(d28))) * f17;
                float sin4 = ((float) (Math.sin(d37) * Math.sin(d28))) * f17;
                long j3 = currentTimeMillis;
                float cos2 = ((float) Math.cos(d37)) * f17;
                String str2 = str;
                int i27 = i26 + 1;
                double d38 = i27;
                double d39 = d38 * d29;
                float sin5 = ((float) (Math.sin(d37) * Math.cos(d39))) * f17;
                int i28 = i18;
                float sin6 = ((float) (Math.sin(d37) * Math.sin(d39))) * f17;
                float cos3 = ((float) Math.cos(d37)) * f17;
                ArrayList arrayList4 = arrayList2;
                float sin7 = ((float) (Math.sin(d26) * Math.cos(d39))) * f17;
                float sin8 = f17 * ((float) (Math.sin(d26) * Math.sin(d39)));
                float cos4 = ((float) Math.cos(d26)) * f17;
                arrayList3.add(Float.valueOf(sin));
                arrayList3.add(Float.valueOf(cos));
                arrayList3.add(Float.valueOf(sin2));
                arrayList3.add(Float.valueOf(sin3));
                arrayList3.add(Float.valueOf(cos2));
                arrayList3.add(Float.valueOf(sin4));
                arrayList3.add(Float.valueOf(sin5));
                arrayList3.add(Float.valueOf(cos3));
                arrayList3.add(Float.valueOf(sin6));
                arrayList3.add(Float.valueOf(sin5));
                arrayList3.add(Float.valueOf(cos3));
                arrayList3.add(Float.valueOf(sin6));
                arrayList3.add(Float.valueOf(sin7));
                arrayList3.add(Float.valueOf(cos4));
                arrayList3.add(Float.valueOf(sin8));
                arrayList3.add(Float.valueOf(sin));
                arrayList3.add(Float.valueOf(cos));
                arrayList3.add(Float.valueOf(sin2));
                float f18 = (float) (d19 * d18);
                float f19 = (float) (d27 * d18);
                float f26 = (float) (d36 * d18);
                float f27 = (float) (d38 * d18);
                arrayList4.add(Float.valueOf(f19));
                arrayList4.add(Float.valueOf(f18));
                arrayList4.add(Float.valueOf(f19));
                arrayList4.add(Float.valueOf(f26));
                arrayList4.add(Float.valueOf(f27));
                arrayList4.add(Float.valueOf(f26));
                arrayList4.add(Float.valueOf(f27));
                arrayList4.add(Float.valueOf(f26));
                arrayList4.add(Float.valueOf(f27));
                arrayList4.add(Float.valueOf(f18));
                arrayList4.add(Float.valueOf(f19));
                arrayList4.add(Float.valueOf(f18));
                i17 = 72;
                i19 = i27;
                arrayList = arrayList3;
                d17 = d18;
                currentTimeMillis = j3;
                d16 = d29;
                str = str2;
                i18 = i28;
                arrayList2 = arrayList4;
                i16 = 4;
            }
            i18++;
            i17 = 72;
            i3 = 0;
            arrayList2 = arrayList2;
            i16 = 4;
        }
        String str3 = str;
        ArrayList arrayList5 = arrayList2;
        long j16 = currentTimeMillis;
        ArrayList arrayList6 = arrayList;
        int size = arrayList6.size() / 3;
        int i29 = size * 3;
        float[] fArr = new float[i29];
        for (int i36 = 0; i36 < i29; i36++) {
            fArr[i36] = ((Float) arrayList6.get(i36)).floatValue();
        }
        this.sphereList.add(fArr);
        int i37 = size * 2;
        float[] fArr2 = new float[i37];
        for (int i38 = 0; i38 < i37; i38++) {
            fArr2[i38] = ((Float) arrayList5.get(i38)).floatValue();
        }
        this.sphereList.add(fArr2);
        QZLog.i(str3, 4, "currentTime getSphereCoordinate = ", Long.valueOf(System.currentTimeMillis() - j16));
        return this.sphereList;
    }

    private ArrayList<float[]> setCylinderList(ArrayList<float[]> arrayList, float f16, boolean z16) {
        float f17 = f16;
        ArrayList<float[]> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
        QZLog.i(TAG, 4, "cylinderList size = ", Integer.valueOf(arrayList2.size()));
        if (arrayList2.size() == 2 && arrayList2.get(0) != null && arrayList2.get(0).length > 0 && arrayList2.get(1) != null && arrayList2.get(1).length > 0) {
            return arrayList2;
        }
        arrayList2.clear();
        float f18 = 360.0f / 36;
        float f19 = f17 / 10.0f;
        int i3 = ((int) f19) * 6;
        float[] fArr = new float[i3 * 3];
        float[] fArr2 = new float[i3 * 2];
        if (!z16) {
            f19 = 1.0f;
        }
        float f26 = 360.0f / f17;
        float f27 = 0.0f;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            double d16 = f27;
            if (Math.ceil(d16) < f17) {
                double radians = Math.toRadians(d16);
                f27 += f18;
                double radians2 = Math.toRadians(f27);
                double d17 = f26;
                double d18 = radians * d17;
                double d19 = d17 * radians2;
                int i18 = i16 + 1;
                float f28 = f18;
                double d26 = -100.0f;
                ArrayList<float[]> arrayList3 = arrayList2;
                fArr[i16] = (float) (d26 * Math.sin(radians));
                int i19 = i18 + 1;
                float f29 = 55;
                fArr[i18] = f29;
                int i26 = i19 + 1;
                fArr[i19] = (float) (d26 * Math.cos(radians));
                int i27 = i17 + 1;
                float f36 = (-((float) (d18 / 6.283185307179586d))) * f19;
                fArr2[i17] = f36;
                int i28 = i27 + 1;
                float f37 = 0;
                fArr2[i27] = f37;
                int i29 = i26 + 1;
                fArr[i26] = (float) (d26 * Math.sin(radians2));
                int i36 = i29 + 1;
                float f38 = -55;
                fArr[i29] = f38;
                int i37 = i36 + 1;
                fArr[i36] = (float) (d26 * Math.cos(radians2));
                int i38 = i28 + 1;
                float f39 = (-((float) (d19 / 6.283185307179586d))) * f19;
                fArr2[i28] = f39;
                int i39 = i38 + 1;
                float f46 = 1;
                fArr2[i38] = f46;
                int i46 = i37 + 1;
                fArr[i37] = (float) (d26 * Math.sin(radians));
                int i47 = i46 + 1;
                fArr[i46] = f38;
                int i48 = i47 + 1;
                fArr[i47] = (float) (Math.cos(radians) * d26);
                int i49 = i39 + 1;
                fArr2[i39] = f36;
                int i56 = i49 + 1;
                fArr2[i49] = f46;
                int i57 = i48 + 1;
                fArr[i48] = (float) (Math.sin(radians) * d26);
                int i58 = i57 + 1;
                fArr[i57] = f29;
                int i59 = i58 + 1;
                fArr[i58] = (float) (Math.cos(radians) * d26);
                int i65 = i56 + 1;
                fArr2[i56] = f36;
                int i66 = i65 + 1;
                fArr2[i65] = f37;
                int i67 = i59 + 1;
                fArr[i59] = (float) (Math.sin(radians2) * d26);
                int i68 = i67 + 1;
                fArr[i67] = f29;
                int i69 = i68 + 1;
                fArr[i68] = (float) (Math.cos(radians2) * d26);
                int i75 = i66 + 1;
                fArr2[i66] = f39;
                int i76 = i75 + 1;
                fArr2[i75] = f37;
                int i77 = i69 + 1;
                fArr[i69] = (float) (Math.sin(radians2) * d26);
                int i78 = i77 + 1;
                fArr[i77] = f38;
                int i79 = i78 + 1;
                fArr[i78] = (float) (d26 * Math.cos(radians2));
                int i85 = i76 + 1;
                fArr2[i76] = f39;
                i17 = i85 + 1;
                fArr2[i85] = f46;
                f26 = f26;
                i16 = i79;
                f18 = f28;
                arrayList2 = arrayList3;
                f17 = f16;
            } else {
                arrayList2.add(fArr);
                arrayList2.add(fArr2);
                return arrayList2;
            }
        }
    }

    public void reportMta(String str, String str2, int i3) {
    }
}
