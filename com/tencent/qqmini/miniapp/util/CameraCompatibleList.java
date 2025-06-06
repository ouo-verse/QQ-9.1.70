package com.tencent.qqmini.miniapp.util;

import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CameraCompatibleList {
    static String BLACK_3D_RENDER_ES20_NEED_SYNC = "samsung;SM-A7100;22;LMY47X|OPPO;OPPO A37m;22;LMY47I|HUAWEI;CHE-TL00H;21;HonorCHE-TL00H|samsung;SM-G9208;23;MMB29K|HUAWEI;HUAWEI NXT-AL10;23;HUAWEINXT-AL10|OPPO;OPPO R7;19;KTU84P|lephone;lephone W9;22;LMY47D";
    static String BLACK_EGL_MAKECURRENT_ERR_3009 = "";
    static String BLACK_NOT_SUPPORT_3D_TK = "HUAWEI;CHE-TL00H;21;HonorCHE-TL00H|HUAWEI;H30-T00;17;HuaweiH30-T00|BBK;vivo X5L;19;KOT49H";
    static String BLACK_NOT_SUPPORT_FILTER_PHONE = "samsung;GT-I8558|samsung;SM-G3818|Lenovo;Lenovo A828t|XiaoMi;HM 2A|OPPO;OPPO R823T|OPPO;R823T|Meizu;M355|samsung;SM-G3812|Meizu;m1 note|OPPO;U707T|OPPO;OPPO U707T|samsung;GT-I9502|HUAWEI;HUAWEI P6-T00|Meizu;M351|nubia;NX513J|meizu;M356|samsung;GT-I9500|OPPO;R815T|YuLong;Coolpad8750|BBK;vivo X3t|Xiaomi;2013022|Xiaomi;2013023|OPPO;N1T";
    static String BLACK_OPENGL_ES20_NEED_FLUSH = "samsung;17;JDQ39";
    static String CAMERA_OPEN_BLOCK_CHOOSE_PERMITTED_MODEL = "Meizu;MX4 Pro;21";
    static String CONST_HEIGHT_MAP_CLIP_WIDTH_POSITIVE_OFFSET_OF_FRONT_CAMERA = "samsung;SM-G5108Q;19;KTU84P";
    static String DISABLE_BACK_CAMERA_MODE = "samsung;SM-N9009;18;JSS15J|OPPO;X907;15;IML74K";
    static String DISABLE_FLASH = "HTC D820u";
    static String DO_NOT_DESTORY_GLSURFACE_VIEW = "Xiaomi;MI 3|samsung;GT-I9500|OPPO;X907";
    static String DUAL_DIFF_SCREEN_LIST = "VIVO;V1821A|VIVO;V1821T";
    static String ENCODE_ERROR_NOT_SUPPORT_PTV = "GiONEE;E3T;17";
    static String GL_CHOOSER_CONFIG_MODEL = "Coolpad 8675|Coolpad 8675-HD|SM-G900|H30-U10|MB855|HUAWEI G730-T00|lPHONE 6";
    static String HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL = "BBK;vivo X5L;19|HTC;HTC ONE X;15";
    static String HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL_NOSDK = "LGE;Nexus 5";
    static String HARDWARE_PRIVILEGE_ERROR_MODEL = "Xiaomi;MI 2A;16|meizu;M356;18|meizu;MX4;19|Meizu;m1 note;19";
    static String HW_HARDENCODE_NOT_SUPPORT_MODEL = "asus;ASUS_T00F;21";
    static String HW_PRE_SEND_NOT_SUPPORT_MODEL = "Xiaomi;MI 2S|nubia;NX513J|OPPO;1107|OPPO;OPPO R7sm|vivo;vivo Y27|HUAWEI;HUAWEI RIO-AL00|Xiaomi;Redmi Note 3|Xiaomi;MI 3|Meizu;m1 metal|Meizu;M3s|Xiaomi;MI 4LTE|Xiaomi;MI 5|Xiaomi;MI NOTE LTE";
    static String IO_RW_VERY_SLOW_MODLE = "Xiaomi;MI 2S";
    public static String KEY_BLACK_3D_RENDER_ES20_NEED_SYNC = "BLACK_3D_RENDER_ES20_NEED_SYNC";
    public static String KEY_BLACK_EGL_MAKECURRENT_ERR_3009 = "BLACK_EGL_MAKECURRENT_ERR_3009";
    public static String KEY_BLACK_NOT_SUPPORT_3D_TK = "BLACK_NOT_SUPPORT_3D_TK";
    public static String KEY_BLACK_NOT_SUPPORT_FILTER_PHONE = "BLACK_NOT_SUPPORT_FILTER_PHONE";
    public static String KEY_BLACK_OPENGL_ES20_NEED_FLUSH = "BLACK_OPENGL_ES20_NEED_FLUSH";
    private static final String KEY_CAMERA_COMPATIBLE_LIST = "camera_compatible_list";
    public static String KEY_CAMERA_OPEN_BLOCK_CHOOSE_PERMITTED_MODEL = "CAMERA_OPEN_BLOCK_CHOOSE_PERMITTED_MODEL";
    public static String KEY_CAN_NOT_CHANGE_PREVIEW_SIZE = "DOT_NOT_CHANGE_PREVIEW_SIZE";
    public static String KEY_CONST_HEIGHT_MAP_CLIP_WIDTH_POSITIVE_OFFSET_OF_FRONT_CAMERA = "CONST_HEIGHT_MAP_CLIP_WIDTH_POSITIVE_OFFSET_OF_FRONT_CAMERA";
    public static String KEY_DISABLE_CHANGE_BACK_CAMERA = "DISABLE_BACK_CAMERA_MODE";
    public static String KEY_DISABLE_FLASH = "DISABLE_FLASH";
    public static String KEY_DO_NOT_DESTORY_GLSURFACE_VIEW = "DO_NOT_DESTORY_GLSURFACE_VIEW";
    public static String KEY_DUAL_DIFF_SCREEN_PHONE = "DUAL_DIFF_SCREEN_PHONE";
    public static String KEY_ENCODE_ERROR_NOT_SUPPORT_PTV = "ENCODE_ERROR_NOT_SUPPORT_PTV";
    public static String KEY_GL_CHOOSER_CONFIG_MODEL = "GL_CHOOSER_CONFIG_MODEL";
    public static String KEY_HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL = "HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL";
    public static String KEY_HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL_NOSDK = "HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL_NOSDK";
    public static String KEY_HARDWARE_PRIVILEGE_ERROR_MODEL = "HARDWARE_PRIVILEGE_ERROR_MODEL";
    public static String KEY_HW_HARDENCODE_NOT_SUPPORT_MODEL = "HW_HARDENCODE_NOT_SUPPORT_MODEL";
    public static String KEY_HW_PRE_SEND_NOT_SUPPORT_MODEL = "HW_PRE_SEND_NOT_SUPPORT_MODEL";
    public static String KEY_IO_RW_VERY_SLOW_MODLE = "IO_RW_VERY_SLOW_MODLE";
    public static String KEY_NEED_ROTATION_INFO_90_MODEL = "NEED_ROTATION_INFO_90_MODEL";
    public static String KEY_NEED_ROTATION_INFO_MODEL = "NEED_ROTATION_INFO_MODEL";
    public static String KEY_NOT_CALLBACK_WHEN_SCREENOFF_MODEL = "NOT_CALLBACK_WHEN_SCREENOFF_MODEL";
    public static String KEY_NOT_FOCUS_MODEL = "NOT_FOCUS_MODEL";
    public static String KEY_NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL = "NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL";
    public static String KEY_NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL_2 = "NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL_2";
    public static String KEY_NOT_SUPPORT_MUTIL_TOUCH = "NOT_SUPPORT_MUTIL_TOUCH";
    public static String KEY_NOT_TAKE_PICTURE_MODEL = "NOT_TAKE_PICTURE_MODEL";
    public static String KEY_NO_QUALCOMM_CPU_IS_VERY_SLOW_PHONE = "NO_QUALCOMM_CPU_IS_VERY_SLOW_PHONE";
    public static String KEY_PREVIEW_DATA_LENGTH_ERR_MODEL = "PREVIEW_DATA_LENGTH_ERR_MODEL";
    public static String KEY_PREVIEW_DATA_LENGTH_MIN_1024X768_HUAWEI_MODLE = "PREVIEW_DATA_LENGTH_MIN_1024X768_HUAWEI_MODLE";
    public static String KEY_PREVIEW_DATA_LENGTH_MIN_640X480_MODLE = "PREVIEW_DATA_LENGTH_MIN_640X480_MODLE";
    public static String KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL = "PREVIEW_ORIENTATION_270_OF_BACK_MODEL";
    public static String KEY_PREVIEW_ORIENTATION_270_OF_FRONT_MODEL = "PREVIEW_ORIENTATION_270_OF_FRONT_MODEL";
    public static String KEY_PREVIEW_ORIENTATION_270_OF_FRONT_MODEL_2 = "PREVIEW_ORIENTATION_270_OF_FRONT_MODEL_2";
    public static String KEY_WHITE_LIST_FILTER_HIGH_FPS_PHONE = "WHITE_LIST_FILTER_HIGH_FPS_PHONE";
    static String NEED_DRAW_ON_SINGLE_THREAD = "OPPO;OPPO R9 Plustm A;22";
    static String NEED_ROTATION_INFO_90_MODEL = "M040|MX4 Pro";
    static String NEED_ROTATION_INFO_MODEL = "Mi-4c|MI NOTE Pro";
    static String NOT_CALLBACK_WHEN_SCREENOFF_MODEL = "M040|GT-N7102|GT-N7108|HTC_7060|OPPO_R1S|SM-G9250|HUAWEI NXT-TL00|DOOV L5|Lenovo A5860|Nexus 6P|R827T|VIE-AL10|OPPO A59m|OPPO A37m|OPPO R9m|OPPO R9tm|MI 4LTE|HUAWEI GRA-CL00|vivo X6A|SM-N9100|MX4 Pro|HUAWEI TAG-TL00|H60-L12|SM-G9200|vivo X6Plus D|vivo X6D|OPPO R7|vivo X5Pro D";
    static String NOT_FOCUS_MODEL = "GT-I8262D|SCH-I879|SCH-I829";
    static String NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL = "M351";
    static String NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL_2 = "Meizu;M351;17";
    static String NOT_SUPPORT_ARPARTICLE = "Xiaomi;MI 6;25|samsung;SM-G5500;22|samsung;SM-J3110;22|samsung;SM-G6000;22|ZTE;BV0701;23|GiONEE;GN8001;22";
    static String NOT_SUPPORT_CAMERA_FRONT_SYSTEM_PHOTO = "VIVO;V1732T|VIVO;V1732A";
    static String NOT_SUPPORT_CHANGE_PREVIEW_SIZE = "";
    static String NOT_SUPPORT_FILTER_BASED_SDK = "Xiaomi;MI 3;19";
    static String NOT_SUPPORT_MUTIL_TOUCH = "vivo;vivo X7Plus;22|OPPO;N1T;17|samsung;SM-A7000;19";
    static String NOT_TAKE_PICTURE_MODEL = "HTC T329t";
    static String NO_QUALCOMM_CPU_IS_VERY_SLOW_PHONE = "HUAWEI;HUAWEI GRA-CL10";
    static String PREVIEW_DATA_LENGTH_ERR_MODEL = "ZTE-T U880|Coolpad 5219|K-Touch S2";
    static String PREVIEW_DATA_LENGTH_MIN_1024X768_HUAWEI_MODLE = "htc;HTC T329t;16|htc;HTC T528t;15";
    static String PREVIEW_DATA_LENGTH_MIN_640X480_MODLE = "OPPO;R7c;19|OPPO;A51kc;22|OPPO;OPPO A51kc;22|OPPO;3007;19|OPPO;OPPO 3007;19|OPPO;A31;19|OPPO;OPPO A31;19|OPPO;R7Plusm;22|OPPO;OPPO R7Plusm;22|OPPO;A51;22|OPPO;OPPO A51;22|OPPO;R7sm;22|OPPO;OPPO R7sm;22|OPPO;A53;22|OPPO;OPPO A53;22|OPPO;A53m;22|OPPO;OPPO A53m;22|OPPO;A33;22|OPPO;OPPO A33;22|OPPO;R7sPlus;22|OPPO;OPPO R7sPlus;22|OPPO;A35;22|OPPO;OPPO A35;22|OPPO;A11;19|OPPO;OPPO A11;19|OPPO;R7;19|OPPO;OPPO R7;19|OPPO;R8107;19|OPPO;OPPO R8107;19|OPPO;1107;19|OPPO;OPPO 1107;19|OPPO;R8007;18|OPPO;OPPO R8007;18|OPPO;R8207;19|OPPO;OPPO R8207;19|OPPO;R7007;18|OPPO;OPPO R7007;18|OPPO;N5110;18|OPPO;OPPO N5110;18|OPPO;A33m;22|OPPO;OPPO A33m;22|OPPO;A33t;22|OPPO;OPPO A33t;22|OPPO;N5117;18|OPPO;OPPO N5117;18|ONEPLUS;A0001;22|OnePlus;ONE E1001;22|OnePlus;ONE E1003;22";
    static String PREVIEW_ORIENTATION_270_OF_BACK_MODEL = "Nexus 5X";
    static String PREVIEW_ORIENTATION_270_OF_FRONT_MODEL = "Nexus 6|Lenovo K860|Nexus 6P|Lenovo A3000-H|M823";
    static String PREVIEW_ORIENTATION_270_OF_FRONT_MODEL_2 = "ZTE;U9180;18;JLS36C|motorola;Moto X Pro;21;LXG22.67-7.1|redbird;redbird H1;23;MMB29M";
    private static final String SF_RESOLUTION_ERROR_COOLPAD = "YuLong;Coolpad Y75;19|YuLong;Coolpad Y76;19|YuLong;Coolpad K1-NT;19|YuLong;Coolpad SK1-01;19|YuLong;ivvi SK1-02;19|YuLong;Coolpad 5956;19|YuLong;Coolpad Y80D;19|YuLong;Coolpad 8297-C00;19";
    private static final String TAG = "CameraCompatibleList";
    static String WHITE_LIST_FILTER_HIGH_FPS_PHONE = "LGE;Nexus 5";
    private static Hashtable<String, String> mCompatibleListMap;
    private static AtomicBoolean mIsConfigInited = new AtomicBoolean(false);

    static {
        mCompatibleListMap = null;
        mCompatibleListMap = new Hashtable<>();
        mCompatibleListMap.put(KEY_NOT_FOCUS_MODEL, NOT_FOCUS_MODEL);
        mCompatibleListMap.put(KEY_NOT_CALLBACK_WHEN_SCREENOFF_MODEL, NOT_CALLBACK_WHEN_SCREENOFF_MODEL);
        mCompatibleListMap.put(KEY_NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL, NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL);
        mCompatibleListMap.put(KEY_NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL_2, NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL_2);
        mCompatibleListMap.put(KEY_PREVIEW_ORIENTATION_270_OF_FRONT_MODEL, PREVIEW_ORIENTATION_270_OF_FRONT_MODEL);
        mCompatibleListMap.put(KEY_PREVIEW_ORIENTATION_270_OF_FRONT_MODEL_2, PREVIEW_ORIENTATION_270_OF_FRONT_MODEL_2);
        mCompatibleListMap.put(KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL, PREVIEW_ORIENTATION_270_OF_BACK_MODEL);
        mCompatibleListMap.put(KEY_NOT_TAKE_PICTURE_MODEL, NOT_TAKE_PICTURE_MODEL);
        mCompatibleListMap.put(KEY_PREVIEW_DATA_LENGTH_ERR_MODEL, PREVIEW_DATA_LENGTH_ERR_MODEL);
        mCompatibleListMap.put(KEY_NEED_ROTATION_INFO_90_MODEL, NEED_ROTATION_INFO_90_MODEL);
        mCompatibleListMap.put(KEY_NEED_ROTATION_INFO_MODEL, NEED_ROTATION_INFO_MODEL);
        mCompatibleListMap.put(KEY_PREVIEW_DATA_LENGTH_MIN_640X480_MODLE, PREVIEW_DATA_LENGTH_MIN_640X480_MODLE);
        mCompatibleListMap.put(KEY_GL_CHOOSER_CONFIG_MODEL, GL_CHOOSER_CONFIG_MODEL);
        mCompatibleListMap.put(KEY_ENCODE_ERROR_NOT_SUPPORT_PTV, ENCODE_ERROR_NOT_SUPPORT_PTV);
        mCompatibleListMap.put(KEY_HW_PRE_SEND_NOT_SUPPORT_MODEL, HW_PRE_SEND_NOT_SUPPORT_MODEL);
        mCompatibleListMap.put(KEY_HARDWARE_PRIVILEGE_ERROR_MODEL, HARDWARE_PRIVILEGE_ERROR_MODEL);
        mCompatibleListMap.put(KEY_HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL, HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL);
        mCompatibleListMap.put(KEY_HW_HARDENCODE_NOT_SUPPORT_MODEL, HW_HARDENCODE_NOT_SUPPORT_MODEL);
        mCompatibleListMap.put(KEY_CAMERA_OPEN_BLOCK_CHOOSE_PERMITTED_MODEL, CAMERA_OPEN_BLOCK_CHOOSE_PERMITTED_MODEL);
        mCompatibleListMap.put(KEY_PREVIEW_DATA_LENGTH_MIN_1024X768_HUAWEI_MODLE, PREVIEW_DATA_LENGTH_MIN_1024X768_HUAWEI_MODLE);
        mCompatibleListMap.put(KEY_IO_RW_VERY_SLOW_MODLE, IO_RW_VERY_SLOW_MODLE);
        mCompatibleListMap.put(KEY_NO_QUALCOMM_CPU_IS_VERY_SLOW_PHONE, NO_QUALCOMM_CPU_IS_VERY_SLOW_PHONE);
        mCompatibleListMap.put(KEY_BLACK_EGL_MAKECURRENT_ERR_3009, BLACK_EGL_MAKECURRENT_ERR_3009);
        mCompatibleListMap.put(KEY_BLACK_NOT_SUPPORT_FILTER_PHONE, BLACK_NOT_SUPPORT_FILTER_PHONE);
        mCompatibleListMap.put(KEY_CONST_HEIGHT_MAP_CLIP_WIDTH_POSITIVE_OFFSET_OF_FRONT_CAMERA, CONST_HEIGHT_MAP_CLIP_WIDTH_POSITIVE_OFFSET_OF_FRONT_CAMERA);
        mCompatibleListMap.put(KEY_BLACK_OPENGL_ES20_NEED_FLUSH, BLACK_OPENGL_ES20_NEED_FLUSH);
        mCompatibleListMap.put(KEY_HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL_NOSDK, HARDWARE_PRIVILEGE_ERROR_CAMERA_NO_CALLBACK_MODEL_NOSDK);
        mCompatibleListMap.put(KEY_WHITE_LIST_FILTER_HIGH_FPS_PHONE, WHITE_LIST_FILTER_HIGH_FPS_PHONE);
        mCompatibleListMap.put(KEY_DO_NOT_DESTORY_GLSURFACE_VIEW, DO_NOT_DESTORY_GLSURFACE_VIEW);
        mCompatibleListMap.put(KEY_BLACK_3D_RENDER_ES20_NEED_SYNC, BLACK_3D_RENDER_ES20_NEED_SYNC);
        mCompatibleListMap.put(KEY_BLACK_NOT_SUPPORT_3D_TK, BLACK_NOT_SUPPORT_3D_TK);
        mCompatibleListMap.put(KEY_DISABLE_FLASH, DISABLE_FLASH);
        mCompatibleListMap.put(KEY_DISABLE_CHANGE_BACK_CAMERA, DISABLE_BACK_CAMERA_MODE);
        mCompatibleListMap.put(KEY_NOT_SUPPORT_MUTIL_TOUCH, NOT_SUPPORT_MUTIL_TOUCH);
        mCompatibleListMap.put(KEY_DUAL_DIFF_SCREEN_PHONE, DUAL_DIFF_SCREEN_LIST);
        mCompatibleListMap.put(KEY_CAN_NOT_CHANGE_PREVIEW_SIZE, NOT_SUPPORT_CHANGE_PREVIEW_SIZE);
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "local config has been inited");
        }
    }

    public static boolean canChangePreviewSize() {
        if (!mIsConfigInited.get()) {
            initCompatibleList();
        }
        String str = mCompatibleListMap.get(KEY_CAN_NOT_CHANGE_PREVIEW_SIZE);
        return !isFoundProduct(Build.MANUFACTURER + ";" + DeviceInfoUtil.getPhoneModel(), str);
    }

    private static void initCompatibleList() {
        if (mIsConfigInited.get()) {
            return;
        }
        String string = PreferenceManager.getDefaultSharedPreferences(AppLoaderFactory.g().getContext()).getString(KEY_CAMERA_COMPATIBLE_LIST, "");
        if (!TextUtils.isEmpty(string)) {
            updateCompatibleList(string, false);
        }
        mIsConfigInited.set(true);
    }

    public static boolean isDualScreenPhone() {
        return isDualScreenPhone(KEY_DUAL_DIFF_SCREEN_PHONE);
    }

    public static boolean isFoundCoolPad() {
        return isFoundProduct(Build.MANUFACTURER + ";" + DeviceInfoUtil.getPhoneModel() + ";" + Build.VERSION.SDK_INT, SF_RESOLUTION_ERROR_COOLPAD);
    }

    private static boolean isFoundProduct(String str, String str2) {
        String[] split;
        boolean z16 = false;
        if (str2 == null || (split = str2.split("\\|")) == null) {
            return false;
        }
        int length = split.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (split[i3].equalsIgnoreCase(str)) {
                z16 = true;
                break;
            }
            i3++;
        }
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "isFoundProduct buildType:" + str + ", result:" + z16);
        }
        return z16;
    }

    public static boolean isFoundProductByRomID(String str) {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "isFoundProductFeatureRom key=" + str);
        }
        if (!mIsConfigInited.get()) {
            initCompatibleList();
        }
        if (mCompatibleListMap == null) {
            return false;
        }
        return isFoundProduct(Build.MANUFACTURER + ";" + Build.VERSION.SDK_INT + ";" + Build.ID, mCompatibleListMap.get(str));
    }

    public static boolean isFoundProductFeature(String str) {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "isFoundProductFeature key=" + str);
        }
        if (!mIsConfigInited.get()) {
            initCompatibleList();
        }
        if (mCompatibleListMap == null) {
            return false;
        }
        return isFoundProduct(Build.MANUFACTURER + ";" + DeviceInfoUtil.getPhoneModel() + ";" + Build.VERSION.SDK_INT, mCompatibleListMap.get(str));
    }

    public static boolean isFoundProductFeatureRom(String str) {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "isFoundProductFeatureRom key=" + str);
        }
        if (!mIsConfigInited.get()) {
            initCompatibleList();
        }
        if (mCompatibleListMap == null) {
            return false;
        }
        return isFoundProduct(Build.MANUFACTURER + ";" + DeviceInfoUtil.getPhoneModel() + ";" + Build.VERSION.SDK_INT + ";" + Build.ID, mCompatibleListMap.get(str));
    }

    public static boolean isFoundProductManufacturer(String str) {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "isFoundProduct key=" + str);
        }
        if (!mIsConfigInited.get()) {
            initCompatibleList();
        }
        if (mCompatibleListMap == null) {
            return false;
        }
        String str2 = Build.MANUFACTURER + ";" + DeviceInfoUtil.getPhoneModel();
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "isFoundProductManufacturer =" + str2);
        }
        return isFoundProduct(str2, mCompatibleListMap.get(str));
    }

    public static boolean isInARParticleBackList() {
        return isFoundProduct(Build.MANUFACTURER + ";" + DeviceInfoUtil.getPhoneModel() + ";" + Build.VERSION.SDK_INT, NOT_SUPPORT_ARPARTICLE);
    }

    public static boolean isNeedDrawOnOpenGLSingleThread() {
        return isFoundProduct(Build.MANUFACTURER + ";" + DeviceInfoUtil.getPhoneModel() + ";" + Build.VERSION.SDK_INT, NEED_DRAW_ON_SINGLE_THREAD);
    }

    public static boolean isNotSupportFilterBasedSdk() {
        return isFoundProduct(Build.MANUFACTURER + ";" + DeviceInfoUtil.getPhoneModel() + ";" + Build.VERSION.SDK_INT, NOT_SUPPORT_FILTER_BASED_SDK);
    }

    public static boolean notSupportCameraFrontSysPhoto() {
        return isFoundProduct(Build.MANUFACTURER.toUpperCase() + ";" + DeviceInfoUtil.getPhoneModel().toUpperCase(), NOT_SUPPORT_CAMERA_FRONT_SYSTEM_PHOTO);
    }

    public static void updateCompatibleList(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (mCompatibleListMap == null) {
            mCompatibleListMap = new Hashtable<>();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                String str3 = (String) jSONObject.get(str2);
                String str4 = mCompatibleListMap.get(str2);
                if (mCompatibleListMap.containsKey(str2) && str4 != null) {
                    mCompatibleListMap.put(str2, str4 + "|" + str3);
                } else {
                    mCompatibleListMap.put(str2, str3);
                }
            }
            if (z16) {
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(AppLoaderFactory.g().getContext()).edit();
                edit.putString(KEY_CAMERA_COMPATIBLE_LIST, str);
                edit.commit();
            }
            mIsConfigInited.set(true);
        } catch (Exception e16) {
            if (QMLog.isColorLevel()) {
                QMLog.d(TAG, "updateCompatibleList json ERROR, msg=" + e16.getMessage());
            }
        }
    }

    private static boolean isDualScreenPhone(String str) {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "isDualScreenPhone key=" + str);
        }
        return isFoundProduct(Build.MANUFACTURER.toUpperCase() + ";" + DeviceInfoUtil.getPhoneModel().toUpperCase(), mCompatibleListMap.get(str));
    }

    public static boolean isFoundProduct(String str) {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "isFoundProduct key=" + str);
        }
        if (!mIsConfigInited.get()) {
            initCompatibleList();
        }
        Hashtable<String, String> hashtable = mCompatibleListMap;
        if (hashtable == null) {
            return false;
        }
        return isFoundProduct(DeviceInfoUtil.getPhoneModel(), hashtable.get(str));
    }
}
