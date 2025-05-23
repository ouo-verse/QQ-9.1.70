package cooperation.qzone.networkedmodule;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneModuleConst {
    public static final String MINIGAME_MODULE_MINIGAME_LAMEMP3_SO = "libminigame_lamemp3.so";
    public static final String MINIGAME_MODULE_WEBAUDIO_SO = "libwebAudio.so";
    public static final String QZONE_DECODE_ANIMATED_WEBP_KEY = "animatedWebp";
    public static final String QZONE_DECODE_ANIMATED_WEBP_MD5 = "4c8590a921c2722051416111dfd57122";
    public static final String QZONE_DECODE_ANIMATED_WEBP_MD5_SECONDARY_KEY = "animatedWebpMD5";
    public static final String QZONE_DECODE_ANIMATED_WEBP_SO = "animatedWebp.so";
    public static final String QZONE_DECODE_ANIMATED_WEBP_SO_URL = "https://d3g.qq.com/sngapp/app/update/20190724163607_2917/libanimwebp_jni.so";
    public static final List<String> QZONE_MODULES_NEED_INSTALL;
    public static final List<String> QZONE_MODULES_PREDOWNLOAD;
    public static final List<String> QZONE_MODULES_QBOSS;
    public static final String QZONE_MODULE_ADDITIONAL_BLACK_LIST = "qzone_module_black_list";
    public static final String QZONE_MODULE_ANTISHAKE_SO = "pictureMarkerSo.zip";
    public static final String QZONE_MODULE_AR_TAR_ENGINE_JAR = "vip_tar_engine.jar";
    public static final String QZONE_MODULE_AR_TAR_ENGINE_JAR_DEFAULT_MD5 = "3c4cd9ff849e9b6576ffa6d8fe60bcaa";
    public static final String QZONE_MODULE_AR_TAR_ENGINE_JAR_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20191114160352_6351/vip_tar_engine.jar";
    public static final String QZONE_MODULE_AR_TAR_ENGINE_JAR_MD5 = "vip_tar_engine_md5";
    public static final String QZONE_MODULE_AR_TAR_ENGINE_JAR_VERSION = "version";
    public static final String QZONE_MODULE_AR_TAR_ENGINE_JAR_VERSION_DEFAULT = "3";
    public static final String QZONE_MODULE_AR_TAR_ENGINE_SO = "libTar.so";
    public static final String QZONE_MODULE_AR_TAR_ENGINE_SO_DEFAULT_MD5 = "3a0222c4b9d441a4cf4a3ac620f5dfbc";
    public static final String QZONE_MODULE_AR_TAR_ENGINE_SO_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20191106212848_5780/libTAR.so";
    public static final String QZONE_MODULE_AR_TAR_ENGINE_SO_MD5 = "lib_tar_so_md5";
    public static final String QZONE_MODULE_AR_TAR_ENGINE_SO_VERSION = "version";
    public static final String QZONE_MODULE_AR_TAR_ENGINE_SO_VERSION_DEFAULT = "1";
    public static final String QZONE_MODULE_CONFIG_LIVE_AUDIO_DEFAULT_MD5 = "73bf723be02a6b71b17a0d47888c4e04";
    public static final String QZONE_MODULE_CONFIG_LIVE_AUDIO_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20160803113848_6187/qzoneliveaudio.jar";
    public static final String QZONE_MODULE_CONFIG_LIVE_FILTERBUNDLE_DEFAULT_MD5 = "b11e343a1096d3b6331b32e2b1bada88";
    public static final String QZONE_MODULE_CONFIG_LIVE_FILTERBUNDLE_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20171105201346_3221/filterengine.bundle_qzone_7.6.jar";
    public static final String QZONE_MODULE_CONFIG_LIVE_PTU_DM_DEFAULT_MD5 = "1cdaf8508cc7343f796ef21b5e65c2b6";
    public static final String QZONE_MODULE_CONFIG_LIVE_PTU_DM_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20191226133414_2167/res1_yt_facedetect.so";
    public static final String QZONE_MODULE_CONFIG_LIVE_SEG_AND_HAND_DETECT_DEFAULT_MD5 = "586bcad62ef42fc352676e485dc38d96";
    public static final String QZONE_MODULE_CONFIG_LIVE_SEG_AND_HAND_DETECT_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20180110162244_5632/res1_yt_seg_and_hand.so";
    public static final String QZONE_MODULE_CONFIG_MODULE_CLASS_IDS = "module_class_ids";
    public static final String QZONE_MODULE_CONFIG_MODULE_FILE_LENGTH = "module_file_length";
    public static final String QZONE_MODULE_CONFIG_MODULE_ID = "module_id";
    public static final String QZONE_MODULE_CONFIG_MODULE_KEY_CLASS_IDS_COUNT = "module_class_ids_count";
    public static final String QZONE_MODULE_CONFIG_MODULE_KEY_CLASS_NAME = "module_key_class_name";
    public static final String QZONE_MODULE_CONFIG_MODULE_MAIN_VERSION = "module_main_version";
    public static final String QZONE_MODULE_CONFIG_MODULE_MD5 = "module_md5";
    public static final String QZONE_MODULE_CONFIG_MODULE_URL = "module_url";
    public static final String QZONE_MODULE_CONFIG_MODULE_VERSION = "module_version";
    public static final String QZONE_MODULE_CONFIG_NETWORKED_MODULE = "qzone_networked_modules";
    public static final String QZONE_MODULE_DISABLE = "qzone_module_disable";
    public static final String QZONE_MODULE_KNOWN_BLACK_LIST = "";
    public static final String QZONE_MODULE_LIVE_AUDIO = "qzlive_live_audio.jar";
    public static final String QZONE_MODULE_LIVE_FILTER_BUNDLE = "qzlive_filterbundle.jar";
    public static final String QZONE_MODULE_LIVE_PTU_DM = "qzlive_res1_yt_facedetect.jar";
    public static final String QZONE_MODULE_LIVE_SEG_AND_HAND_DETECT = "qzlive_res1_yt_seg_and_hand.jar";
    public static final String QZONE_MODULE_MAPSDK_LAST_CRASH_COUNT = "qzone_module_mapsdk_last_crash_count";
    public static final String QZONE_MODULE_MAP_SDK = "qzonemodule_mapsdk.jar";
    public static final int QZONE_MODULE_MAX_CRASH_COUNT = 2;
    private static final String QZONE_MODULE_OSKPLAYER_JAR_CRASH_KEY_WORDS_0 = "Exo2MediaPlayer";
    public static final String QZONE_MODULE_OSK_PLAYER = "osk_exoplayer2_bundle.jar";
    public static final String QZONE_MODULE_OSK_PLAYER_CONFIG_DEFAULT = "https://d3g.qq.com/sngapp/app/update/20170728155227_6686/osk_exoplayer2_bundle.jar|f9d35ec8e90af758354bb174abc12df4";
    public static final String QZONE_MODULE_OSK_PLAYER_CONFIG_SECONDARY_KEY = "libOskPlayerJarConfig";
    public static final String QZONE_MODULE_TAGCLASSIFY_DEFAULT_MD5 = "6b5338544a7c9baff2af16413d3d5119";
    public static final String QZONE_MODULE_TAGCLASSIFY_DEFAULT_MD5_SECONDARY_KEY = "photo_classify_file_md5";
    public static final String QZONE_MODULE_TAGCLASSIFY_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20180329102523_4877/pic_tag_sdk.jar";
    public static final String QZONE_MODULE_TAGCLASSIFY_DEFAULT_URL_SECONDARY_KEY = "photo_tag_classify_file";
    public static final String QZONE_MODULE_TAGCLASSIFY_SO = "tag_classify.jar";
    public static final String QZONE_MODULE_TEST_ID = "test_log.dex";
    public static final String QZONE_MODULE_UPLOAD_JAR = "upload.jar";
    private static final String QZONE_MODULE_UPLOAD_JAR_CRASH_KEY_WORDS_0 = "com.tencent.upload";
    public static final String QZONE_MODULE_UPLOAD_JAR_DEFAULT_MD5 = "f0cee072f5851282b04dc809a834dd0d";
    public static final String QZONE_MODULE_UPLOAD_JAR_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20200225165213_5410/upload.jar";
    public static final String QZONE_MODULE_UPLOAD_JAR_MD5_SECONDARY_KEY = "libUploadJarMD5";
    public static final String QZONE_MODULE_UPLOAD_JAR_URL_SECONDARY_KEY = "libUploadJarUrl";
    public static final String QZONE_MODULE_UPLOAD_SO = "upload.so";
    public static final String QZONE_MODULE_VIDEO_HEROPLAYER = "lib_heroplayer.jar";
    public static final String QZONE_MODULE_XMP_CORE_DEFAULT_MD5 = "a0c5ac44fc2d0e35187f0c1479db48b2";
    public static final String QZONE_MODULE_XMP_CORE_DEFAULT_MD5_SECONDARY_KEY = "XMPcoreJarMD5";
    public static final String QZONE_MODULE_XMP_CORE_DEFAULT_URL = "https://d3g.qq.com/sngapp/app/update/20171220130606_8640/xmpcore.jar";
    public static final String QZONE_MODULE_XMP_CORE_DEFAULT_URL_SECONDARY_KEY = "xmpcoreUrl";
    public static final String QZONE_MODULE_XMP_CORE_JAR = "xmpcore.jar";
    private static final String QZONE_MOMULE_CRASH_TAG = "QzoneModuleCrash";
    private static String QZONE_NETWORKED_MODULE_FILE_PATH = null;
    private static final String TAG = "QzoneModuleConst";
    private static List<String> sCrashKeyWords;
    private static Map<String, String> sKeyWords2IdMap;

    static {
        ArrayList arrayList = new ArrayList();
        QZONE_MODULES_QBOSS = Collections.unmodifiableList(arrayList);
        arrayList.add(QZONE_MODULE_UPLOAD_JAR);
        QZONE_MODULES_PREDOWNLOAD = Collections.unmodifiableList(new ArrayList());
        QZONE_MODULES_NEED_INSTALL = Collections.unmodifiableList(new ArrayList());
        QZONE_NETWORKED_MODULE_FILE_PATH = "qzone_networked_module";
        sCrashKeyWords = new ArrayList();
        sKeyWords2IdMap = new HashMap();
        sCrashKeyWords.add("com.tencent.upload");
        sCrashKeyWords.add(QZONE_MODULE_OSKPLAYER_JAR_CRASH_KEY_WORDS_0);
        sKeyWords2IdMap.put("com.tencent.upload", QZONE_MODULE_UPLOAD_JAR);
        sKeyWords2IdMap.put(QZONE_MODULE_OSKPLAYER_JAR_CRASH_KEY_WORDS_0, QZONE_MODULE_OSK_PLAYER);
    }

    public static void clearLastCrashCount(String str) {
        if (QZONE_MODULE_MAP_SDK.equals(str)) {
            LocalMultiProcConfig.putInt(LocalMultiProcConfig.PREFS_NAME_QZ_SETTING, getSpKeyById(str), 0);
            QLog.e(QZONE_MOMULE_CRASH_TAG, 1, "clear last crash count");
        }
    }

    public static String getModuleSavePath(Context context, QzoneModuleRecord qzoneModuleRecord) {
        return new File(context.getApplicationContext().getDir(QZONE_NETWORKED_MODULE_FILE_PATH, 0), qzoneModuleRecord.mMD5.toLowerCase() + "_" + qzoneModuleRecord.mModuleId).getAbsolutePath();
    }

    private static String getSpKeyById(String str) {
        return "qzone_module_" + str + "_last_crash_count";
    }

    public static synchronized boolean isLoadAccordingToCrashCount(String str) {
        synchronized (QzoneModuleConst.class) {
            int i3 = LocalMultiProcConfig.getInt(LocalMultiProcConfig.PREFS_NAME_QZ_SETTING, getSpKeyById(str), 0);
            QLog.i(TAG, 1, "qzone module(map sdk) crash count:" + i3);
            if (i3 != 2) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "crash count 1->2, disable module.");
            }
            return false;
        }
    }

    public static void updateCrashInfo(String str, boolean z16) {
        boolean z17;
        String str2;
        if (TextUtils.isEmpty(str)) {
            QLog.e(QZONE_MOMULE_CRASH_TAG, 1, "errMsg is empty");
            return;
        }
        if (z16 && str.contains("nativeResolvePatchClass")) {
            QLog.e(QZONE_MOMULE_CRASH_TAG, 1, "load2QQClassLoader crash, native crash caused by nativeResolvePatchClass");
            z17 = true;
        } else {
            z17 = false;
        }
        Iterator<String> it = sCrashKeyWords.iterator();
        while (true) {
            if (it.hasNext()) {
                String next = it.next();
                if (str.contains(next)) {
                    str2 = sKeyWords2IdMap.get(next);
                    QLog.e(QZONE_MOMULE_CRASH_TAG, 1, "loaded Module get a crash, module id:" + str2);
                    z17 = true;
                    break;
                }
            } else {
                str2 = null;
                break;
            }
        }
        if (z17 && !TextUtils.isEmpty(str2)) {
            int i3 = LocalMultiProcConfig.getInt(LocalMultiProcConfig.PREFS_NAME_QZ_SETTING, getSpKeyById(str2), 0);
            if (i3 >= 2) {
                QLog.e(QZONE_MOMULE_CRASH_TAG, 1, "qzone module have crashed " + (i3 + 1) + " times,so clear qzone module crash count.moduleId:" + str2);
                LocalMultiProcConfig.putInt(LocalMultiProcConfig.PREFS_NAME_QZ_SETTING, getSpKeyById(str2), 0);
                return;
            }
            LocalMultiProcConfig.putInt(LocalMultiProcConfig.PREFS_NAME_QZ_SETTING, getSpKeyById(str2), i3 + 1);
        }
    }
}
