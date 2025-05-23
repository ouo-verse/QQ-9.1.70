package cooperation.qzone.networkedmodule;

import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneModuleRecordFactory {
    private static final String TAG = "QzoneModuleRecordFactory";
    private static volatile QzoneModuleRecordFactory sFactory;
    private HashMap<String, MethodHolder> mMethodMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class MethodHolder {
        Object instance;
        Method method;

        MethodHolder() {
        }
    }

    QzoneModuleRecordFactory() {
        HashMap<String, MethodHolder> hashMap = new HashMap<>();
        this.mMethodMap = hashMap;
        hashMap.putAll(loadMethods(this, QzoneModuleRecordFactory.class));
    }

    public static QzoneModuleRecordFactory getInstance() {
        if (sFactory == null) {
            synchronized (QzoneModuleRecordFactory.class) {
                if (sFactory == null) {
                    sFactory = new QzoneModuleRecordFactory();
                }
            }
        }
        return sFactory;
    }

    private HashMap<String, MethodHolder> loadMethods(Object obj, Class<?> cls) {
        HashMap<String, MethodHolder> hashMap = new HashMap<>();
        for (Method method : cls.getMethods()) {
            try {
                if (method.isAnnotationPresent(QzoneModuleId.class)) {
                    method.setAccessible(true);
                    String value = ((QzoneModuleId) method.getAnnotation(QzoneModuleId.class)).value();
                    MethodHolder methodHolder = new MethodHolder();
                    methodHolder.instance = obj;
                    methodHolder.method = method;
                    hashMap.put(value, methodHolder);
                }
            } catch (Throwable th5) {
                QLog.w(TAG, 1, "catch an exception:", th5);
            }
        }
        return hashMap;
    }

    @QzoneModuleId(QzoneModuleConst.QZONE_MODULE_UPLOAD_SO)
    public QzoneModuleRecord createQzoneUploadSo() {
        String config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_UPLOAD_SO, "https://d3g.qq.com/sngapp/app/update/20200113193058_6341/qzoneuploadso.zip");
        String config2 = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_UPLOAD_MD5, "0bdd196ce6962895dbe3634ab1d55d2a");
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        qzoneModuleRecordBuilder.setModuleId(QzoneModuleConst.QZONE_MODULE_UPLOAD_SO).setUrl(config).setMD5(config2);
        return qzoneModuleRecordBuilder.build();
    }

    public QzoneModuleRecord createRecord(String str) {
        MethodHolder methodHolder = this.mMethodMap.get(str);
        if (methodHolder != null) {
            try {
                return (QzoneModuleRecord) methodHolder.method.invoke(methodHolder.instance, new Object[0]);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "catch an exception:", e16);
            }
        }
        return null;
    }

    @QzoneModuleId(QzoneModuleConst.QZONE_MODULE_ANTISHAKE_SO)
    public QzoneModuleRecord createRecordForAntishakeDMSo() {
        String config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTO_QULATITY_SO_64, "https://d3g.qq.com/sngapp/app/update/20191105214335_3222/gifAntishake64.zip");
        String config2 = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTO_QULATITY_SO_MD5_64, "fff43d114068dc1ead91c92db27b9f22");
        long config3 = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTO_QULATITY_SO_LENGTH_64, 1680425);
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        qzoneModuleRecordBuilder.setModuleId(QzoneModuleConst.QZONE_MODULE_ANTISHAKE_SO).setUrl(config).setMD5(config2).setModuleFileLength(config3);
        return qzoneModuleRecordBuilder.build();
    }

    @QzoneModuleId(QzoneModuleConst.QZONE_MODULE_LIVE_AUDIO)
    public QzoneModuleRecord createRecordForLiveAudioSo() {
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_LIVE_VIDEO, QzoneConfig.SECONDARY_LIVE_PLUGIN_AUDIO_URL, QzoneModuleConst.QZONE_MODULE_CONFIG_LIVE_AUDIO_DEFAULT_URL);
        String config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_LIVE_VIDEO, QzoneConfig.SECONDARY_LIVE_PLUGIN_AUDIO_MD5, QzoneModuleConst.QZONE_MODULE_CONFIG_LIVE_AUDIO_DEFAULT_MD5);
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        qzoneModuleRecordBuilder.setModuleId(QzoneModuleConst.QZONE_MODULE_LIVE_AUDIO).setUrl(config).setMD5(config2);
        return qzoneModuleRecordBuilder.build();
    }

    @QzoneModuleId(QzoneModuleConst.QZONE_MODULE_LIVE_PTU_DM)
    public QzoneModuleRecord createRecordForLivePtuDMSo() {
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_LIVE_VIDEO, QzoneConfig.SECONDARY_LIVE_PLUGIN_PTU_DM_URL, QzoneModuleConst.QZONE_MODULE_CONFIG_LIVE_PTU_DM_DEFAULT_URL);
        String config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_LIVE_VIDEO, QzoneConfig.SECONDARY_LIVE_PLUGIN_PTU_DM_MD5, QzoneModuleConst.QZONE_MODULE_CONFIG_LIVE_PTU_DM_DEFAULT_MD5);
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        qzoneModuleRecordBuilder.setModuleId(QzoneModuleConst.QZONE_MODULE_LIVE_PTU_DM).setUrl(config).setMD5(config2);
        return qzoneModuleRecordBuilder.build();
    }

    @QzoneModuleId(QzoneModuleConst.QZONE_MODULE_LIVE_SEG_AND_HAND_DETECT)
    public QzoneModuleRecord createRecordForLivePtuSegAndHandDetect() {
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_LIVE_VIDEO, QzoneConfig.SECONDARY_LIVE_PLUGIN_PITU_SEG_AND_HAND_DETECT_URL, QzoneModuleConst.QZONE_MODULE_CONFIG_LIVE_SEG_AND_HAND_DETECT_DEFAULT_URL);
        String config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_LIVE_VIDEO, QzoneConfig.SECONDARY_LIVE_PLUGIN_PITU_SEG_AND_HAND_DETECT_MD5, QzoneModuleConst.QZONE_MODULE_CONFIG_LIVE_SEG_AND_HAND_DETECT_DEFAULT_MD5);
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        qzoneModuleRecordBuilder.setModuleId(QzoneModuleConst.QZONE_MODULE_LIVE_SEG_AND_HAND_DETECT).setUrl(config).setMD5(config2);
        return qzoneModuleRecordBuilder.build();
    }

    @QzoneModuleId(QzoneModuleConst.MINIGAME_MODULE_MINIGAME_LAMEMP3_SO)
    public QzoneModuleRecord createRecordForMiniGameLameMp3So() {
        String config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_MINIGAME_LAMEMP3_SO_INFO, QzoneConfig.DEFAULT_VALUE_MINIGAME_LAMEMP3_SO_INFO_64);
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        try {
            JSONObject jSONObject = new JSONObject(config);
            String string = jSONObject.getString("url");
            String string2 = jSONObject.getString("md5");
            qzoneModuleRecordBuilder.setModuleId(QzoneModuleConst.MINIGAME_MODULE_MINIGAME_LAMEMP3_SO).setUrl(string).setMD5(string2).setModuleFileLength(jSONObject.getLong("length"));
        } catch (JSONException e16) {
            QLog.w(TAG, 1, "createRecordForLameMp3So catch an exception:", e16);
        }
        return qzoneModuleRecordBuilder.build();
    }

    @QzoneModuleId(QzoneModuleConst.QZONE_MODULE_OSK_PLAYER)
    public QzoneModuleRecord createRecordForOskPlayer() {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_MODULE_OSK_PLAYER_CONFIG_SECONDARY_KEY, QzoneModuleConst.QZONE_MODULE_OSK_PLAYER_CONFIG_DEFAULT);
        String[] split = config.split("\\|");
        String str = "";
        String str2 = "";
        for (int i3 = 0; i3 < split.length; i3++) {
            if (i3 == 0) {
                str = split[i3];
            } else if (i3 == 1) {
                str2 = split[i3];
            }
        }
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        qzoneModuleRecordBuilder.setModuleId(QzoneModuleConst.QZONE_MODULE_OSK_PLAYER).setUrl(str).setMD5(str2).setKeyClassName("com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer").setVersion("1").setMainVersion(QUA.getQUA3());
        QLog.i(TAG, 1, "oskplayerconfig:" + config);
        return qzoneModuleRecordBuilder.build();
    }

    @QzoneModuleId(QzoneModuleConst.QZONE_MODULE_TAGCLASSIFY_SO)
    public QzoneModuleRecord createRecordForTagClassifySo() {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_MODULE_TAGCLASSIFY_DEFAULT_URL_SECONDARY_KEY, QzoneModuleConst.QZONE_MODULE_TAGCLASSIFY_DEFAULT_URL);
        String config2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_MODULE_TAGCLASSIFY_DEFAULT_MD5_SECONDARY_KEY, QzoneModuleConst.QZONE_MODULE_TAGCLASSIFY_DEFAULT_MD5);
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        qzoneModuleRecordBuilder.setModuleId(QzoneModuleConst.QZONE_MODULE_TAGCLASSIFY_SO).setUrl(config).setMD5(config2);
        return qzoneModuleRecordBuilder.build();
    }

    @QzoneModuleId(QzoneModuleConst.QZONE_MODULE_TEST_ID)
    public QzoneModuleRecord createRecordForTest() {
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        qzoneModuleRecordBuilder.setModuleId(QzoneModuleConst.QZONE_MODULE_TEST_ID).setUrl("https://d3g.qq.com/sngapp/app/update/20161212150740_4388/qzonemodule_mapsdk.jar").setMD5("158c17d81b2aa6c0f8347aaa64dd015b").setKeyClassName("com.tencent.tencentmap.mapsdk.map.Projection").setVersion("1").setMainVersion(QUA.getQUA3());
        return qzoneModuleRecordBuilder.build();
    }

    @QzoneModuleId(QzoneModuleConst.QZONE_MODULE_UPLOAD_JAR)
    public QzoneModuleRecord createRecordForUploadJar() {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_MODULE_UPLOAD_JAR_URL_SECONDARY_KEY, QzoneModuleConst.QZONE_MODULE_UPLOAD_JAR_DEFAULT_URL);
        String config2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_MODULE_UPLOAD_JAR_MD5_SECONDARY_KEY, QzoneModuleConst.QZONE_MODULE_UPLOAD_JAR_DEFAULT_MD5);
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        qzoneModuleRecordBuilder.setModuleId(QzoneModuleConst.QZONE_MODULE_UPLOAD_JAR).setUrl(config).setMD5(config2).setClassIds("3-31;3-32;3-33;3-34;3-35;3-36;3-37;3-38;3-39;3-40;3-41;3-42;3-43;3-44;3-45;3-46;3-47;3-48;3-49;3-50;3-51;3-52;3-53;3-54;3-55;3-56;3-57;3-58;3-59;3-60;3-61;3-62;3-63;3-64;3-65;3-66;3-67;3-68;3-69;3-70;3-71;3-72;3-73;3-74;3-75;3-76;3-77;3-78;3-79;3-80;3-81;3-125;3-126;3-127;3-128;3-197;3-198;3-199;3-5892;3-5788;3-5884;3-5889;3-5890;3-5800;3-5801;3-5802;3-5803;3-5804;3-5805;3-5811;3-5812;3-5814;3-5815;3-5816;3-5817;3-5841;3-5862;3-5863;3-5877;3-5878;3-5879;3-5880;3-5881;3-5882;3-5883;3-5885;3-5886;3-5887;3-5888;3-5891;3-5893;3-5894;3-5895;3-5896;3-5897;3-5898;3-5899;3-5900;3-5901;3-5902;3-5903;3-5904;3-5905;3-5906;3-5907;3-5908;3-5909;3-5910;3-5911;3-5912;3-5939;3-5913;3-5914;3-5915;3-5916;3-5917;3-5918;3-5919;3-5920;3-5921;3-5922;3-5923;3-5924;3-5925;3-5926;3-5927;3-5928;3-5929;3-5930;3-5931;3-5932;3-5933;3-5934;3-5935;3-5936;3-5937;3-5938;3-5940;3-5941;3-5942;3-5943;3-5944;3-5945;3-5946;3-5947;3-5948;3-5949;3-5950;3-5951;3-5952").setKeyClassName("com.tencent.upload.impl.UploadServiceProxy").setVersion("1").setClassIdsCount(150).setMainVersion(QUA.getQUA3());
        return qzoneModuleRecordBuilder.build();
    }

    @QzoneModuleId(QzoneModuleConst.MINIGAME_MODULE_WEBAUDIO_SO)
    public QzoneModuleRecord createRecordForWebAudioSo() {
        long j3;
        String config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_WEBAUDIO_SO_INFO, QzoneConfig.DEFAULT_VALUE_WEBAUDIO_SO_INFO);
        String str = "https://d3g.qq.com/sngapp/app/update/20200723130554_3898/libwebAudio.so";
        String str2 = "c387d4ac69717660762353321313c6c4";
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        try {
            JSONObject jSONObject = new JSONObject(config);
            str = jSONObject.getString("url");
            str2 = jSONObject.getString("md5");
            j3 = jSONObject.getLong("length");
        } catch (JSONException e16) {
            QLog.w(TAG, 1, "createRecordForWebAudioSo catch an exception:", e16);
            j3 = 13345220;
        }
        qzoneModuleRecordBuilder.setModuleId(QzoneModuleConst.MINIGAME_MODULE_WEBAUDIO_SO).setUrl(str).setMD5(str2).setModuleFileLength(j3);
        return qzoneModuleRecordBuilder.build();
    }

    @QzoneModuleId(QzoneModuleConst.QZONE_MODULE_AR_TAR_ENGINE_JAR)
    public QzoneModuleRecord createRecrodForARTarEngineJar() {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_MODULE_AR_TAR_ENGINE_JAR, QzoneModuleConst.QZONE_MODULE_AR_TAR_ENGINE_JAR_DEFAULT_URL);
        String config2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_MODULE_AR_TAR_ENGINE_JAR_MD5, QzoneModuleConst.QZONE_MODULE_AR_TAR_ENGINE_JAR_DEFAULT_MD5);
        String config3 = QzoneConfig.getInstance().getConfig("QZoneSetting", "version", "3");
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        qzoneModuleRecordBuilder.setModuleId(QzoneModuleConst.QZONE_MODULE_AR_TAR_ENGINE_JAR).setUrl(config).setMD5(config2).setVersion(config3).setMainVersion(QUA.getQUA3());
        return qzoneModuleRecordBuilder.build();
    }

    @QzoneModuleId(QzoneModuleConst.QZONE_MODULE_AR_TAR_ENGINE_SO)
    public QzoneModuleRecord createRecrodForARTarEngineSo() {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_MODULE_AR_TAR_ENGINE_SO, QzoneModuleConst.QZONE_MODULE_AR_TAR_ENGINE_SO_DEFAULT_URL);
        String config2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_MODULE_AR_TAR_ENGINE_SO_MD5, QzoneModuleConst.QZONE_MODULE_AR_TAR_ENGINE_SO_DEFAULT_MD5);
        String config3 = QzoneConfig.getInstance().getConfig("QZoneSetting", "version", "1");
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        qzoneModuleRecordBuilder.setModuleId(QzoneModuleConst.QZONE_MODULE_AR_TAR_ENGINE_SO).setUrl(config).setMD5(config2).setVersion(config3).setMainVersion(QUA.getQUA3());
        return qzoneModuleRecordBuilder.build();
    }

    @QzoneModuleId(QzoneModuleConst.QZONE_DECODE_ANIMATED_WEBP_SO)
    public QzoneModuleRecord createRecrodForAnimatedWebp() {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_DECODE_ANIMATED_WEBP_KEY, QzoneModuleConst.QZONE_DECODE_ANIMATED_WEBP_SO_URL);
        String config2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_DECODE_ANIMATED_WEBP_MD5_SECONDARY_KEY, QzoneModuleConst.QZONE_DECODE_ANIMATED_WEBP_MD5);
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        qzoneModuleRecordBuilder.setModuleId(QzoneModuleConst.QZONE_DECODE_ANIMATED_WEBP_SO).setUrl(config).setMD5(config2);
        return qzoneModuleRecordBuilder.build();
    }

    @QzoneModuleId(QzoneModuleConst.QZONE_MODULE_LIVE_FILTER_BUNDLE)
    public QzoneModuleRecord createRecrodForLiveFilterBundle() {
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_LIVE_VIDEO, QzoneConfig.SECONDARY_LIVE_PLUGIN_FILTER_BUNDLE_URL, QzoneModuleConst.QZONE_MODULE_CONFIG_LIVE_FILTERBUNDLE_DEFAULT_URL);
        String config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_LIVE_VIDEO, QzoneConfig.SECONDARY_LIVE_PLUGIN_FILTER_BUNDLE_MD5, QzoneModuleConst.QZONE_MODULE_CONFIG_LIVE_FILTERBUNDLE_DEFAULT_MD5);
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        qzoneModuleRecordBuilder.setModuleId(QzoneModuleConst.QZONE_MODULE_LIVE_FILTER_BUNDLE).setUrl(config).setMD5(config2);
        return qzoneModuleRecordBuilder.build();
    }

    @QzoneModuleId(QzoneModuleConst.QZONE_MODULE_XMP_CORE_JAR)
    public QzoneModuleRecord createRecrodForXMPCoreJar() {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_MODULE_XMP_CORE_DEFAULT_URL_SECONDARY_KEY, QzoneModuleConst.QZONE_MODULE_XMP_CORE_DEFAULT_URL);
        String config2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneModuleConst.QZONE_MODULE_XMP_CORE_DEFAULT_MD5_SECONDARY_KEY, QzoneModuleConst.QZONE_MODULE_XMP_CORE_DEFAULT_MD5);
        QzoneModuleRecordBuilder qzoneModuleRecordBuilder = new QzoneModuleRecordBuilder();
        qzoneModuleRecordBuilder.setModuleId(QzoneModuleConst.QZONE_MODULE_XMP_CORE_JAR).setUrl(config).setMD5(config2);
        return qzoneModuleRecordBuilder.build();
    }
}
