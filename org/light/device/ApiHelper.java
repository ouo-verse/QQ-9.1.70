package org.light.device;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.provider.MediaStore;
import android.view.View;
import org.light.device.LightDeviceProperty;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ApiHelper {
    public static final boolean CAN_START_PREVIEW_IN_JPEG_CALLBACK;
    public static final boolean CAN_TAKE_VIDEO;
    public static final boolean ENABLE_PHOTO_EDITOR;
    public static final boolean HAS_ACTION_BAR;
    public static final boolean HAS_AUTO_FOCUS_MOVE_CALLBACK;
    public static final boolean HAS_BITMAP_REGION_DECODER;
    public static final boolean HAS_CAMCORDERPROFILE_METHOD;
    public static final boolean HAS_CAMERAINFO;
    public static final boolean HAS_CAMERA_FOCUS_AREA;
    public static final boolean HAS_CAMERA_HDR;
    public static final boolean HAS_CAMERA_HDR_PLUS;
    public static final boolean HAS_CAMERA_METERING_AREA;
    public static final boolean HAS_DISPLAY_LISTENER;
    public static final boolean HAS_EDITOR_APPLY;
    public static final boolean HAS_EFFECTS_RECORDING = false;
    public static final boolean HAS_EFFECTS_RECORDING_CONTEXT_INPUT;
    public static final boolean HAS_FACE_DETECTION;
    public static final boolean HAS_FINE_RESOLUTION_QUALITY_LEVELS;
    public static final boolean HAS_GET_CAMERA_DISABLED;
    public static final boolean HAS_GET_SUPPORTED_VIDEO_SIZE;
    public static final boolean HAS_HARDWARE_ACCELERATION;
    public static final boolean HAS_INTENT_EXTRA_LOCAL_ONLY;
    public static final boolean HAS_MEDIA_ACTION_SOUND;
    public static final boolean HAS_MEDIA_COLUMNS_RESOLUTION = true;
    public static final boolean HAS_MEDIA_COLUMNS_WIDTH_AND_HEIGHT;
    public static final boolean HAS_MEDIA_PROVIDER_FILES_TABLE;
    public static final boolean HAS_MOTION_EVENT_TRANSFORM;
    public static final boolean HAS_MTP;
    public static final boolean HAS_MULTICORE_CHIPS;
    public static final boolean HAS_OLD_PANORAMA;
    public static final boolean HAS_OPTIONS_IN_MUTABLE;
    public static final boolean HAS_POST_ON_ANIMATION;
    public static final boolean HAS_RELEASE_SURFACE_TEXTURE;
    public static final boolean HAS_REMOTE_VIEWS_SERVICE;
    public static final boolean HAS_REUSING_BITMAP_IN_BITMAP_FACTORY;
    public static final boolean HAS_REUSING_BITMAP_IN_BITMAP_REGION_DECODER;
    public static final boolean HAS_SD_CARD;
    public static final boolean HAS_SET_BEAM_PUSH_URIS;
    public static final boolean HAS_SET_DEFALT_BUFFER_SIZE;
    public static final boolean HAS_SET_ICON_ATTRIBUTE;
    public static final boolean HAS_SET_SYSTEM_UI_VISIBILITY;
    public static boolean HAS_SURFACE_TEXTURE;
    public static final boolean HAS_SURFACE_TEXTURE_RECORDING;
    public static final boolean HAS_TIME_LAPSE_RECORDING;
    public static final boolean HAS_VIEW_PROPERTY_ANIMATOR;
    public static final boolean HAS_VIEW_SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    public static final boolean HAS_VIEW_SYSTEM_UI_FLAG_LAYOUT_STABLE;
    public static final boolean HAS_VIEW_TRANSFORM_PROPERTIES;
    public static final boolean HAS_ZOOM_WHEN_RECORDING;
    public static final boolean USE_888_PIXEL_FORMAT;
    public static final boolean USE_COOLPAD8013_PORTING;

    /* JADX WARN: Can't wrap try/catch for region: R(105:1|(1:3)(1:212)|4|(1:6)(1:211)|7|(1:9)(1:210)|10|(1:12)(1:209)|13|(1:15)(1:208)|16|(1:18)(1:207)|19|(1:21)(1:206)|22|(1:24)(1:205)|25|(1:27)(1:204)|28|(1:30)(1:203)|31|(1:33)(1:202)|34|(1:36)(1:201)|37|(1:39)(1:200)|40|(1:42)(1:199)|43|(1:45)(1:198)|46|(1:48)(1:197)|49|(1:51)(1:196)|52|(1:54)(1:195)|55|(1:57)(1:194)|58|(1:60)(1:193)|61|(1:63)(1:192)|64|(1:66)(1:191)|67|(1:69)(1:190)|70|(1:72)(1:189)|73|(1:75)(1:188)|76|(2:77|78)|(2:84|(51:86|87|88|89|90|91|(1:182)(1:95)|96|(1:98)(1:181)|99|(1:101)(1:180)|102|(1:104)(1:179)|105|(1:107)(1:178)|108|(1:110)(1:177)|111|(1:113)(1:176)|114|(1:116)(1:175)|117|(1:119)(1:174)|120|(1:122)(1:173)|123|(1:125)(1:172)|126|(1:128)(1:171)|129|(1:131)(1:170)|132|(1:134)(1:169)|135|(1:137)(1:168)|138|(1:140)(1:167)|141|(1:143)(1:166)|144|(1:146)(1:165)|147|(1:149)(1:164)|150|(1:152)(1:163)|153|(1:155)(1:162)|156|(1:158)|159|160))|186|87|88|89|90|91|(1:93)|182|96|(0)(0)|99|(0)(0)|102|(0)(0)|105|(0)(0)|108|(0)(0)|111|(0)(0)|114|(0)(0)|117|(0)(0)|120|(0)(0)|123|(0)(0)|126|(0)(0)|129|(0)(0)|132|(0)(0)|135|(0)(0)|138|(0)(0)|141|(0)(0)|144|(0)(0)|147|(0)(0)|150|(0)(0)|153|(0)(0)|156|(0)|159|160) */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0143, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0162  */
    static {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        boolean z37;
        boolean z38;
        boolean z39;
        boolean z46;
        boolean z47;
        boolean z48;
        boolean z49;
        boolean z55;
        boolean z56;
        boolean z57;
        boolean z58;
        boolean z59;
        boolean z65;
        boolean z66;
        boolean z67;
        boolean z68;
        boolean z69;
        int i3;
        boolean z75;
        boolean z76;
        boolean z77;
        boolean z78;
        boolean z79;
        boolean z85;
        boolean z86;
        boolean z87;
        boolean z88;
        boolean z89;
        boolean z95;
        boolean z96;
        boolean z97;
        boolean z98;
        boolean z99;
        boolean z100;
        boolean z101;
        boolean z102;
        boolean z103;
        boolean z104;
        boolean z105;
        int i16 = LightDeviceProperty.VERSION.SDK_INT;
        boolean z106 = true;
        if (i16 >= 16) {
            z16 = true;
        } else {
            z16 = false;
        }
        HAS_MEDIA_COLUMNS_WIDTH_AND_HEIGHT = z16;
        if (i16 >= 16) {
            z17 = true;
        } else {
            z17 = false;
        }
        HAS_AUTO_FOCUS_MOVE_CALLBACK = z17;
        if (i16 >= 14) {
            z18 = true;
        } else {
            z18 = false;
        }
        HAS_CAMERA_FOCUS_AREA = z18;
        if (i16 >= 14) {
            z19 = true;
        } else {
            z19 = false;
        }
        HAS_CAMERA_METERING_AREA = z19;
        if (i16 >= 17) {
            z26 = true;
        } else {
            z26 = false;
        }
        HAS_CAMERA_HDR = z26;
        if (i16 >= 19) {
            z27 = true;
        } else {
            z27 = false;
        }
        HAS_CAMERA_HDR_PLUS = z27;
        if (i16 >= 17) {
            z28 = true;
        } else {
            z28 = false;
        }
        HAS_DISPLAY_LISTENER = z28;
        if (i16 >= 14) {
            z29 = true;
        } else {
            z29 = false;
        }
        CAN_START_PREVIEW_IN_JPEG_CALLBACK = z29;
        if (i16 < 9) {
            z36 = true;
        } else {
            z36 = false;
        }
        USE_COOLPAD8013_PORTING = z36;
        if (i16 >= 16) {
            z37 = true;
        } else {
            z37 = false;
        }
        USE_888_PIXEL_FORMAT = z37;
        if (i16 >= 14) {
            z38 = true;
        } else {
            z38 = false;
        }
        ENABLE_PHOTO_EDITOR = z38;
        if (i16 >= 14) {
            z39 = true;
        } else {
            z39 = false;
        }
        HAS_HARDWARE_ACCELERATION = z39;
        if (i16 >= 16) {
            z46 = hasField(View.class, "SYSTEM_UI_FLAG_LAYOUT_STABLE");
        } else {
            z46 = false;
        }
        HAS_VIEW_SYSTEM_UI_FLAG_LAYOUT_STABLE = z46;
        if (i16 >= 14) {
            z47 = hasField(MediaStore.MediaColumns.class, "WIDTH");
        } else {
            z47 = false;
        }
        HAS_VIEW_SYSTEM_UI_FLAG_HIDE_NAVIGATION = z47;
        if (i16 >= 16) {
            z48 = true;
        } else {
            z48 = false;
        }
        HAS_REUSING_BITMAP_IN_BITMAP_REGION_DECODER = z48;
        if (i16 >= 11) {
            z49 = true;
        } else {
            z49 = false;
        }
        HAS_REUSING_BITMAP_IN_BITMAP_FACTORY = z49;
        if (i16 >= 16) {
            z55 = true;
        } else {
            z55 = false;
        }
        HAS_SET_BEAM_PUSH_URIS = z55;
        if (i16 >= 15) {
            Class cls = Integer.TYPE;
            z56 = hasMethod("android.graphics.SurfaceTexture", "setDefaultBufferSize", (Class<?>[]) new Class[]{cls, cls});
        } else {
            z56 = false;
        }
        HAS_SET_DEFALT_BUFFER_SIZE = z56;
        if (i16 >= 14) {
            z57 = hasMethod("android.graphics.SurfaceTexture", "release", (Class<?>[]) new Class[0]);
        } else {
            z57 = false;
        }
        HAS_RELEASE_SURFACE_TEXTURE = z57;
        if (i16 >= 14) {
            z58 = true;
        } else {
            z58 = false;
        }
        HAS_SURFACE_TEXTURE = z58;
        if (i16 >= 12) {
            z59 = true;
        } else {
            z59 = false;
        }
        HAS_MTP = z59;
        if (i16 >= 11) {
            z65 = true;
        } else {
            z65 = false;
        }
        HAS_REMOTE_VIEWS_SERVICE = z65;
        if (i16 >= 11) {
            z66 = true;
        } else {
            z66 = false;
        }
        HAS_INTENT_EXTRA_LOCAL_ONLY = z66;
        if (i16 >= 11) {
            z67 = hasMethod((Class<?>) View.class, "setSystemUiVisibility", (Class<?>[]) new Class[]{Integer.TYPE});
        } else {
            z67 = false;
        }
        HAS_SET_SYSTEM_UI_VISIBILITY = z67;
        if (i16 >= 9) {
            z68 = hasMethod((Class<?>) SharedPreferences.Editor.class, "apply", (Class<?>[]) null);
        } else {
            z68 = false;
        }
        HAS_EDITOR_APPLY = z68;
        if (hasMethod((Class<?>) Camera.class, "setFaceDetectionListener", (Class<?>[]) new Class[]{Camera.FaceDetectionListener.class}) && hasMethod((Class<?>) Camera.class, "startFaceDetection", (Class<?>[]) new Class[0]) && hasMethod((Class<?>) Camera.class, "stopFaceDetection", (Class<?>[]) new Class[0])) {
            if (hasMethod((Class<?>) Camera.Parameters.class, "getMaxNumDetectedFaces", (Class<?>[]) new Class[0])) {
                z69 = true;
                HAS_FACE_DETECTION = z69;
                Class.forName("android.graphics.BitmapRegionDecoder");
                boolean z107 = true;
                HAS_BITMAP_REGION_DECODER = z107;
                i3 = LightDeviceProperty.VERSION.SDK_INT;
                if (i3 < 14 && hasMethod((Class<?>) DevicePolicyManager.class, "getCameraDisabled", (Class<?>[]) new Class[]{ComponentName.class})) {
                    z75 = true;
                } else {
                    z75 = false;
                }
                HAS_GET_CAMERA_DISABLED = z75;
                if (i3 < 16) {
                    z76 = true;
                } else {
                    z76 = false;
                }
                HAS_MEDIA_ACTION_SOUND = z76;
                if (i3 < 14) {
                    z77 = true;
                } else {
                    z77 = false;
                }
                HAS_OLD_PANORAMA = z77;
                if (i3 < 11) {
                    z78 = true;
                } else {
                    z78 = false;
                }
                HAS_TIME_LAPSE_RECORDING = z78;
                if (i3 < 14) {
                    z79 = true;
                } else {
                    z79 = false;
                }
                HAS_ZOOM_WHEN_RECORDING = z79;
                if (i3 < 11) {
                    z85 = true;
                } else {
                    z85 = false;
                }
                HAS_FINE_RESOLUTION_QUALITY_LEVELS = z85;
                if (i3 < 11) {
                    z86 = true;
                } else {
                    z86 = false;
                }
                HAS_MOTION_EVENT_TRANSFORM = z86;
                if (i3 < 17) {
                    z87 = true;
                } else {
                    z87 = false;
                }
                HAS_EFFECTS_RECORDING_CONTEXT_INPUT = z87;
                if (i3 < 11) {
                    z88 = true;
                } else {
                    z88 = false;
                }
                HAS_GET_SUPPORTED_VIDEO_SIZE = z88;
                if (i3 < 11) {
                    z89 = true;
                } else {
                    z89 = false;
                }
                HAS_SET_ICON_ATTRIBUTE = z89;
                if (i3 < 11) {
                    z95 = true;
                } else {
                    z95 = false;
                }
                HAS_MEDIA_PROVIDER_FILES_TABLE = z95;
                if (i3 < 16) {
                    z96 = true;
                } else {
                    z96 = false;
                }
                HAS_SURFACE_TEXTURE_RECORDING = z96;
                if (i3 < 11) {
                    z97 = true;
                } else {
                    z97 = false;
                }
                HAS_ACTION_BAR = z97;
                if (i3 < 11) {
                    z98 = true;
                } else {
                    z98 = false;
                }
                HAS_VIEW_TRANSFORM_PROPERTIES = z98;
                if (i3 < 11) {
                    z99 = true;
                } else {
                    z99 = false;
                }
                HAS_OPTIONS_IN_MUTABLE = z99;
                if (i3 < 12) {
                    z100 = true;
                } else {
                    z100 = false;
                }
                HAS_VIEW_PROPERTY_ANIMATOR = z100;
                if (i3 < 16) {
                    z101 = true;
                } else {
                    z101 = false;
                }
                HAS_POST_ON_ANIMATION = z101;
                if (i3 < 9) {
                    z102 = true;
                } else {
                    z102 = false;
                }
                HAS_CAMERAINFO = z102;
                if (i3 < 12) {
                    z103 = true;
                } else {
                    z103 = false;
                }
                HAS_SD_CARD = z103;
                if (i3 < 9) {
                    z104 = true;
                } else {
                    z104 = false;
                }
                HAS_CAMCORDERPROFILE_METHOD = z104;
                if (Runtime.getRuntime().availableProcessors() <= 1) {
                    z105 = true;
                } else {
                    z105 = false;
                }
                HAS_MULTICORE_CHIPS = z105;
                if (i3 < 10) {
                    z106 = false;
                }
                CAN_TAKE_VIDEO = z106;
            }
        }
        z69 = false;
        HAS_FACE_DETECTION = z69;
        Class.forName("android.graphics.BitmapRegionDecoder");
        boolean z1072 = true;
        HAS_BITMAP_REGION_DECODER = z1072;
        i3 = LightDeviceProperty.VERSION.SDK_INT;
        if (i3 < 14) {
        }
        z75 = false;
        HAS_GET_CAMERA_DISABLED = z75;
        if (i3 < 16) {
        }
        HAS_MEDIA_ACTION_SOUND = z76;
        if (i3 < 14) {
        }
        HAS_OLD_PANORAMA = z77;
        if (i3 < 11) {
        }
        HAS_TIME_LAPSE_RECORDING = z78;
        if (i3 < 14) {
        }
        HAS_ZOOM_WHEN_RECORDING = z79;
        if (i3 < 11) {
        }
        HAS_FINE_RESOLUTION_QUALITY_LEVELS = z85;
        if (i3 < 11) {
        }
        HAS_MOTION_EVENT_TRANSFORM = z86;
        if (i3 < 17) {
        }
        HAS_EFFECTS_RECORDING_CONTEXT_INPUT = z87;
        if (i3 < 11) {
        }
        HAS_GET_SUPPORTED_VIDEO_SIZE = z88;
        if (i3 < 11) {
        }
        HAS_SET_ICON_ATTRIBUTE = z89;
        if (i3 < 11) {
        }
        HAS_MEDIA_PROVIDER_FILES_TABLE = z95;
        if (i3 < 16) {
        }
        HAS_SURFACE_TEXTURE_RECORDING = z96;
        if (i3 < 11) {
        }
        HAS_ACTION_BAR = z97;
        if (i3 < 11) {
        }
        HAS_VIEW_TRANSFORM_PROPERTIES = z98;
        if (i3 < 11) {
        }
        HAS_OPTIONS_IN_MUTABLE = z99;
        if (i3 < 12) {
        }
        HAS_VIEW_PROPERTY_ANIMATOR = z100;
        if (i3 < 16) {
        }
        HAS_POST_ON_ANIMATION = z101;
        if (i3 < 9) {
        }
        HAS_CAMERAINFO = z102;
        if (i3 < 12) {
        }
        HAS_SD_CARD = z103;
        if (i3 < 9) {
        }
        HAS_CAMCORDERPROFILE_METHOD = z104;
        if (Runtime.getRuntime().availableProcessors() <= 1) {
        }
        HAS_MULTICORE_CHIPS = z105;
        if (i3 < 10) {
        }
        CAN_TAKE_VIDEO = z106;
    }

    private static boolean hasField(Class<?> cls, String str) {
        try {
            cls.getDeclaredField(str);
            return true;
        } catch (NoSuchFieldException unused) {
            return false;
        }
    }

    public static boolean hasGingerbread() {
        if (LightDeviceProperty.VERSION.SDK_INT >= 9) {
            return true;
        }
        return false;
    }

    public static boolean hasHoneycomb() {
        if (LightDeviceProperty.VERSION.SDK_INT >= 11) {
            return true;
        }
        return false;
    }

    public static boolean hasHoneycombMR1() {
        if (LightDeviceProperty.VERSION.SDK_INT >= 12) {
            return true;
        }
        return false;
    }

    public static boolean hasIceCreamSandwich() {
        if (LightDeviceProperty.VERSION.SDK_INT >= 14) {
            return true;
        }
        return false;
    }

    public static boolean hasJellyBean() {
        if (LightDeviceProperty.VERSION.SDK_INT >= 16) {
            return true;
        }
        return false;
    }

    public static boolean hasJellyBeanMR1() {
        if (LightDeviceProperty.VERSION.SDK_INT >= 17) {
            return true;
        }
        return false;
    }

    public static boolean hasJellyBeanMR2() {
        if (LightDeviceProperty.VERSION.SDK_INT >= 18) {
            return true;
        }
        return false;
    }

    public static boolean hasKitkat() {
        if (LightDeviceProperty.VERSION.SDK_INT >= 19) {
            return true;
        }
        return false;
    }

    public static boolean hasLollipop() {
        if (LightDeviceProperty.VERSION.SDK_INT >= 21) {
            return true;
        }
        return false;
    }

    public static boolean hasLollipopMR1() {
        if (LightDeviceProperty.VERSION.SDK_INT >= 22) {
            return true;
        }
        return false;
    }

    public static boolean hasMarshmallow() {
        if (LightDeviceProperty.VERSION.SDK_INT >= 23) {
            return true;
        }
        return false;
    }

    private static boolean hasMethod(String str, String str2, Class<?>... clsArr) {
        try {
            Class.forName(str).getDeclaredMethod(str2, clsArr);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean hasNougat() {
        if (LightDeviceProperty.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    public static boolean isAndroid_8_1() {
        if (LightDeviceProperty.VERSION.SDK_INT == 27) {
            return true;
        }
        return false;
    }

    public static boolean isExactlyKitkat() {
        if (LightDeviceProperty.VERSION.SDK_INT == 19) {
            return true;
        }
        return false;
    }

    private static boolean hasMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            cls.getDeclaredMethod(str, clsArr);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }
}
