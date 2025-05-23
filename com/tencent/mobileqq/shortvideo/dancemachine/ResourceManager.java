package com.tencent.mobileqq.shortvideo.dancemachine;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.facedancegame.ExpressionTemplateConfig;
import com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceTemplateConfig;
import com.tencent.sveffects.SLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ResourceManager {
    private static volatile ResourceManager INSTANCE = null;
    private static final String TAG = "DanceResMgrLog";
    public List<DancePosture> dancePostures;
    public GameNumberResource mGameNumberResource;
    public GamingResource mGamingResource;
    public GeneralResource mGeneralResource;
    public LBGeneralResource mLBGeneraResource;
    private String mLittleBoyFilterRoot;
    public List<LyricItem> mLyricsList;
    public ReadyResource mReadyResource;
    public ScanResource mScanResource;
    public ShareResource mShareResource;
    public StartResource mStartResource;
    private String postureRecognizePath;
    private Map<String, Posture> postures;
    public static String sRootDanceStageQQPath = Environment.getExternalStorageDirectory() + "/tencent/mobileqq/capture_ptv_template/ptv_template_usable/postureRecognizeStage/";
    public static String sRootDanceStageTestPath = Environment.getExternalStorageDirectory() + "/postureRecognizeStage/";
    public static String sLittleBoyFilterPath = Environment.getExternalStorageDirectory() + "/tencent/mobileqq/capture_ptv_template/ptv_template_usable/video_niania_iOS/";
    public static String sTestLittleBoyFilterPath = Environment.getExternalStorageDirectory() + "/video_niania_iOS/";
    public static String sTestFaceLittleBoyFilterPath = Environment.getExternalStorageDirectory() + "/face_dance/";
    public static String sTestGestureDetectLibSoPath = "/sdcard/725_so/";
    public static String sTestGestureDetectLibSoLocPath = null;
    public int durationTime = 0;
    public float compressRatio = 1.0f;
    public boolean isCompressed = false;
    private int mPostureType = 0;
    private Comparator<LyricItem> mLyricsOrderCompare = new Comparator<LyricItem>() { // from class: com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.1
        @Override // java.util.Comparator
        public int compare(LyricItem lyricItem, LyricItem lyricItem2) {
            int i3 = lyricItem.startTime;
            int i16 = lyricItem2.startTime;
            if (i3 < i16) {
                return -1;
            }
            return i3 > i16 ? 1 : 0;
        }
    };

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class DancePosture {
        public static final int DANCE_POSTURE = 0;
        public static final int HAND_GESTURE = 1;
        public int appearCol;
        public double appearTime;
        boolean haveCreated = false;

        /* renamed from: id, reason: collision with root package name */
        public String f287854id;
        public int postureType;
        public double speed;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class GameNumberResource {
        public List<String> gameNums = new ArrayList();
        private String prefix;
        public String scoreSound;

        public GameNumberResource() {
            this.prefix = ResourceManager.this.postureRecognizePath + "number/";
            this.scoreSound = this.prefix + "score.mp3";
            for (int i3 = 0; i3 < 10; i3++) {
                this.gameNums.add(this.prefix + "gamenum_" + i3 + ".png");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class GamingResource {
        public String good;
        public String goodSound;
        public String good_background;
        public String good_mongolian;
        public String great;
        public String greatSound;
        public String great_background;
        public String great_mongolian;
        public String miss;
        public String missSound;
        public String miss_background;
        public String miss_mongolian;
        public String perfect;
        public String perfectSound;
        public String perfect_background;
        public String perfect_mongolian;
        private String prefix;
        public String timeBackground;
        public String volumSoundPic;
        public String volumSoundPicSingle;
        private String timeFront = "timeFront";
        public List<String> timeFronts = new ArrayList();
        private String recogRect = "recogrect";
        public List<String> recogRects = new ArrayList();

        public GamingResource() {
            this.prefix = ResourceManager.this.postureRecognizePath + "gaming/";
            this.miss_mongolian = this.prefix + "miss_mongolian.png";
            this.good_mongolian = this.prefix + "good_mongolian.png";
            this.great_mongolian = this.prefix + "great_mongolian.png";
            this.perfect_mongolian = this.prefix + "perfect_mongolian.png";
            this.miss_background = this.prefix + "miss_background.png";
            this.good_background = this.prefix + "good_background.png";
            this.great_background = this.prefix + "great_background.png";
            this.perfect_background = this.prefix + "perfect_background.png";
            this.miss = this.prefix + "miss.png";
            this.good = this.prefix + "good.png";
            this.great = this.prefix + "great.png";
            this.perfect = this.prefix + "perfect.png";
            this.timeBackground = this.prefix + "timeBackGround.png";
            this.volumSoundPic = this.prefix + "volume/sound.png";
            this.volumSoundPicSingle = this.prefix + "volume/sound_single.png";
            this.goodSound = this.prefix + "good.mp3";
            this.greatSound = this.prefix + "great.mp3";
            this.missSound = this.prefix + "miss.mp3";
            this.perfectSound = this.prefix + "perfect.mp3";
            int i3 = 0;
            int i16 = 0;
            while (i16 < 4) {
                List<String> list = this.recogRects;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.prefix);
                sb5.append(this.recogRect);
                i16++;
                sb5.append(i16);
                sb5.append(".png");
                list.add(sb5.toString());
            }
            this.timeFronts.add(this.prefix + this.timeFront + ".png");
            while (i3 < 3) {
                List<String> list2 = this.timeFronts;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(this.prefix);
                sb6.append(this.timeFront);
                i3++;
                sb6.append(i3);
                sb6.append(".png");
                list2.add(sb6.toString());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class GeneralResource {
        public String bgPic;
        private String prefix_bgm;

        public GeneralResource() {
            this.prefix_bgm = ResourceManager.this.postureRecognizePath;
            this.bgPic = this.prefix_bgm + "bg.png";
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class LBGeneralResource {
        public String bgmV;
        private String prefix_bgm;

        public LBGeneralResource() {
            this.prefix_bgm = ResourceManager.this.mLittleBoyFilterRoot;
            this.bgmV = this.prefix_bgm + "background-music-aac.mp3";
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class LyricItem {
        public static final int STATUS_INIT = 0;
        public static final int STATUS_INVALID = 2;
        public static final int STATUS_WORK = 1;
        public int endTime;
        public int startTime;
        public int status;
        public String text;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class Posture {
        public String blastPicture;
        public List<String> danceCartoon;
        public FaceDanceTemplateConfig faceDanceConfig;
        public List<MatchTemplateConfig> gestureConfigs;

        /* renamed from: id, reason: collision with root package name */
        public String f287855id;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class ReadyResource {
        public String oneSound;
        private String prefix;
        public String ready;
        public List<String> readyNums = new ArrayList();
        public String readySound;
        public String threeSound;
        public String twoSound;

        public ReadyResource() {
            this.prefix = ResourceManager.this.postureRecognizePath + "ready/";
            this.ready = this.prefix + "ready.png";
            this.readySound = this.prefix + "ready.mp3";
            this.oneSound = this.prefix + "one.mp3";
            this.twoSound = this.prefix + "two.mp3";
            this.threeSound = this.prefix + "three.mp3";
            for (int i3 = 1; i3 <= 3; i3++) {
                this.readyNums.add(this.prefix + "ready" + i3 + ".png");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class ScanResource {
        public String bottomText;
        public String facebottomText;
        public String facemaskPic;
        private String faceprefix_scan;
        public String facerecognizePic;
        public String facetopText;
        public String maskPic;
        private String prefix_scan;
        public String recognizePic;
        public String scanBg;
        public String scanContent;
        public String scanPic;
        public String topText;

        public ScanResource() {
            this.prefix_scan = ResourceManager.this.postureRecognizePath + "bodyScan/";
            this.faceprefix_scan = ResourceManager.this.postureRecognizePath + "faceScan/";
            this.recognizePic = this.prefix_scan + "recognize.png";
            this.scanPic = this.prefix_scan + "scan.png";
            this.maskPic = this.prefix_scan + "mask.png";
            this.facerecognizePic = this.faceprefix_scan + "facerecognize.png";
            this.facemaskPic = this.faceprefix_scan + "facemask.png";
            this.scanBg = this.prefix_scan + "scan_bg.png";
            this.scanContent = this.prefix_scan + "scan_content.png";
            this.bottomText = this.prefix_scan + "bottom_text.png";
            this.topText = this.prefix_scan + "top_text.png";
            this.facebottomText = this.faceprefix_scan + "face_bottom_text.png";
            this.facetopText = this.faceprefix_scan + "face_top_text.png";
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class ShareResource {
        public String button;
        public String levelA;
        public String levelB;
        public String levelC;
        public String levelS;
        private String prefix;
        public String shareBg;
        public String shareScoreBg;

        public ShareResource() {
            this.prefix = ResourceManager.this.postureRecognizePath + "share/";
            this.button = this.prefix + "button.png";
            this.levelA = this.prefix + "levelA.png";
            this.levelB = this.prefix + "levelB.png";
            this.levelC = this.prefix + "levelC.png";
            this.levelS = this.prefix + "levelS.png";
            this.shareBg = this.prefix + "shareBg.png";
            this.shareScoreBg = this.prefix + "shareScoreBg.png";
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class StartResource {
        private String prefix;
        public String startPic;
        public String startSound;

        public StartResource() {
            this.prefix = ResourceManager.this.postureRecognizePath + "start/";
            this.startPic = this.prefix + "start.png";
            this.startSound = this.prefix + "start.mp3";
        }
    }

    ResourceManager() {
    }

    private boolean checkResExist() {
        return new File(this.postureRecognizePath).exists();
    }

    private void createDanceStageResource() {
        this.mGeneralResource = new GeneralResource();
        this.mScanResource = new ScanResource();
        this.mReadyResource = new ReadyResource();
        this.mStartResource = new StartResource();
        this.mGamingResource = new GamingResource();
        this.mGameNumberResource = new GameNumberResource();
        this.mShareResource = new ShareResource();
    }

    public static ResourceManager getInstance() {
        if (INSTANCE == null) {
            synchronized (ResourceManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ResourceManager();
                }
            }
        }
        return INSTANCE;
    }

    private void parseCompressConfig() {
        this.compressRatio = 1.0f;
        this.isCompressed = false;
        try {
            JSONObject jSONObject = new JSONObject(readFileContent(this.mLittleBoyFilterRoot + "compress.json") + "");
            boolean optBoolean = jSONObject.optBoolean("isCompressed", false);
            this.isCompressed = optBoolean;
            if (optBoolean) {
                float optDouble = (float) jSONObject.optDouble("compressRatio", 1.0d);
                this.compressRatio = optDouble;
                if (optDouble > 1.0f) {
                    this.compressRatio = 1.0f;
                }
                if (this.compressRatio < 0.2f) {
                    this.compressRatio = 0.2f;
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x031c A[Catch: JSONException -> 0x0357, TryCatch #0 {JSONException -> 0x0357, blocks: (B:9:0x004a, B:12:0x006b, B:17:0x0076, B:19:0x007c, B:23:0x0154, B:24:0x0088, B:27:0x009d, B:28:0x00ad, B:30:0x00b3, B:32:0x00c1, B:34:0x00cb, B:38:0x00d0, B:42:0x00da, B:44:0x0113, B:47:0x011a, B:48:0x011f, B:50:0x0122, B:52:0x012a, B:54:0x013a, B:58:0x013f, B:60:0x0147, B:62:0x014b, B:64:0x0151, B:67:0x015c, B:70:0x0163, B:72:0x0169, B:76:0x01c5, B:77:0x0172, B:80:0x0184, B:82:0x0197, B:83:0x0199, B:87:0x01a6, B:88:0x01a8, B:92:0x01c0, B:94:0x01bc, B:98:0x0311, B:100:0x031c, B:101:0x0322, B:103:0x032a, B:105:0x033a, B:106:0x033e, B:108:0x0344, B:116:0x01d3, B:117:0x01e1, B:119:0x01e7, B:121:0x01f1, B:123:0x01f4, B:126:0x01f7, B:127:0x01fe, B:129:0x0204, B:131:0x020e, B:134:0x021f, B:136:0x025e, B:141:0x0265, B:142:0x026a, B:144:0x026d, B:146:0x0275, B:148:0x0285, B:152:0x028a, B:156:0x0293, B:140:0x029d, B:162:0x02a3, B:163:0x02a8, B:165:0x02ae, B:169:0x030c, B:170:0x02cc, B:172:0x02de, B:173:0x02e0, B:176:0x02ec, B:177:0x02ee, B:182:0x0305, B:183:0x0307), top: B:8:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseLittleBoyConfig() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str;
        double d16;
        JSONArray jSONArray;
        File[] fileArr;
        String str2;
        JSONObject jSONObject3;
        JSONArray jSONArray2;
        String str3;
        File[] fileArr2;
        JSONArray jSONArray3;
        Map<String, Posture> map = this.postures;
        if (map == null) {
            this.postures = new HashMap();
        } else {
            map.clear();
        }
        List<DancePosture> list = this.dancePostures;
        if (list == null) {
            this.dancePostures = new ArrayList();
        } else {
            list.clear();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(readFileContent(this.mLittleBoyFilterRoot + "tConfig.json"));
        String str4 = "";
        sb5.append("");
        try {
            JSONObject jSONObject4 = new JSONObject(sb5.toString());
            int i3 = this.mPostureType;
            String str5 = "appearTime";
            String str6 = "matchTemplate";
            if (i3 == 0) {
                JSONArray jSONArray4 = jSONObject4.getJSONArray("allGestures");
                if (jSONArray4 == null) {
                    return;
                }
                int i16 = 0;
                while (i16 < jSONArray4.length()) {
                    JSONObject optJSONObject = jSONArray4.optJSONObject(i16);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("id", "");
                        Posture posture = new Posture();
                        posture.f287855id = optString;
                        if (!TextUtils.isEmpty(optString)) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray(str6);
                            jSONArray2 = jSONArray4;
                            posture.gestureConfigs = new ArrayList();
                            str3 = str6;
                            int i17 = 0;
                            while (i17 < optJSONArray.length()) {
                                MatchTemplateConfig parseConfig = MatchTemplateConfig.parseConfig(optJSONArray.get(i17).toString());
                                if (parseConfig != null) {
                                    jSONArray3 = optJSONArray;
                                    posture.gestureConfigs.add(parseConfig);
                                } else {
                                    jSONArray3 = optJSONArray;
                                }
                                i17++;
                                optJSONArray = jSONArray3;
                            }
                            if (posture.gestureConfigs.size() != 0) {
                                posture.blastPicture = this.mLittleBoyFilterRoot + "others/dismiss.png";
                                posture.danceCartoon = new ArrayList();
                                File file = new File(this.mLittleBoyFilterRoot + "gestures/" + optString);
                                if (file.exists() && file.isDirectory()) {
                                    File[] listFiles = file.listFiles();
                                    int i18 = 0;
                                    while (i18 < listFiles.length) {
                                        if (listFiles[i18].isFile()) {
                                            fileArr2 = listFiles;
                                            posture.danceCartoon.add(listFiles[i18].getAbsolutePath());
                                        } else {
                                            fileArr2 = listFiles;
                                        }
                                        i18++;
                                        listFiles = fileArr2;
                                    }
                                    if (posture.danceCartoon.size() == 0) {
                                        resourceCheck(optString);
                                    } else {
                                        this.postures.put(optString, posture);
                                    }
                                }
                                resourceCheck(optString);
                            }
                            i16++;
                            jSONArray4 = jSONArray2;
                            str6 = str3;
                        }
                    }
                    jSONArray2 = jSONArray4;
                    str3 = str6;
                    i16++;
                    jSONArray4 = jSONArray2;
                    str6 = str3;
                }
                JSONArray optJSONArray2 = jSONObject4.optJSONArray("dances");
                if (optJSONArray2 != null) {
                    int i19 = 0;
                    while (i19 < optJSONArray2.length()) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i19);
                        if (optJSONObject2 != null) {
                            DancePosture dancePosture = new DancePosture();
                            String optString2 = optJSONObject2.optString("gestureId", str4);
                            if (this.postures.containsKey(optString2)) {
                                dancePosture.f287854id = optString2;
                                dancePosture.postureType = 0;
                                str2 = str4;
                                jSONObject3 = jSONObject4;
                                double optDouble = optJSONObject2.optDouble("appearTime", 0.0d);
                                dancePosture.appearTime = optDouble;
                                if (optDouble < 0.0d) {
                                    dancePosture.appearTime = 0.0d;
                                }
                                int optInt = optJSONObject2.optInt("appearCol", 0);
                                dancePosture.appearCol = optInt;
                                if (optInt != 1 && optInt != 2) {
                                    dancePosture.appearCol = 1;
                                }
                                double optDouble2 = optJSONObject2.optDouble("speed", 0.25d);
                                dancePosture.speed = optDouble2;
                                if (optDouble2 <= 0.0d || optDouble2 > 1.0d) {
                                    dancePosture.speed = 0.25d;
                                }
                                this.dancePostures.add(dancePosture);
                                i19++;
                                str4 = str2;
                                jSONObject4 = jSONObject3;
                            }
                        }
                        str2 = str4;
                        jSONObject3 = jSONObject4;
                        i19++;
                        str4 = str2;
                        jSONObject4 = jSONObject3;
                    }
                }
                jSONObject = jSONObject4;
            } else {
                jSONObject = jSONObject4;
                if (i3 == 1) {
                    jSONObject2 = jSONObject;
                    JSONArray jSONArray5 = jSONObject2.getJSONArray("expressionList");
                    ArrayList arrayList = new ArrayList();
                    for (int i26 = 0; i26 < jSONArray5.length(); i26++) {
                        ExpressionTemplateConfig parseConfig2 = ExpressionTemplateConfig.parseConfig(jSONArray5.getString(i26));
                        if (parseConfig2 != null) {
                            arrayList.add(parseConfig2);
                        }
                    }
                    JSONArray jSONArray6 = jSONObject2.getJSONArray("matchTemplate");
                    int i27 = 0;
                    while (i27 < jSONArray6.length()) {
                        FaceDanceTemplateConfig parseConfig3 = FaceDanceTemplateConfig.parseConfig(jSONArray6.getString(i27), arrayList);
                        if (parseConfig3 != null) {
                            Posture posture2 = new Posture();
                            String str7 = parseConfig3.mTemplateID;
                            posture2.f287855id = str7;
                            if (!TextUtils.isEmpty(str7)) {
                                posture2.blastPicture = this.mLittleBoyFilterRoot + "others/dismiss.png";
                                posture2.faceDanceConfig = parseConfig3;
                                posture2.danceCartoon = new ArrayList();
                                StringBuilder sb6 = new StringBuilder();
                                jSONArray = jSONArray6;
                                sb6.append(this.mLittleBoyFilterRoot);
                                sb6.append("gestures/");
                                sb6.append(parseConfig3.mTemplateID);
                                File file2 = new File(sb6.toString());
                                if (file2.exists() && file2.isDirectory()) {
                                    File[] listFiles2 = file2.listFiles();
                                    int i28 = 0;
                                    while (i28 < listFiles2.length) {
                                        if (listFiles2[i28].isFile()) {
                                            fileArr = listFiles2;
                                            posture2.danceCartoon.add(listFiles2[i28].getAbsolutePath());
                                        } else {
                                            fileArr = listFiles2;
                                        }
                                        i28++;
                                        listFiles2 = fileArr;
                                    }
                                    if (posture2.danceCartoon.size() != 0) {
                                        this.postures.put(parseConfig3.mTemplateID, posture2);
                                    }
                                }
                                i27++;
                                jSONArray6 = jSONArray;
                            }
                        }
                        jSONArray = jSONArray6;
                        i27++;
                        jSONArray6 = jSONArray;
                    }
                    JSONArray jSONArray7 = jSONObject2.getJSONArray("dances");
                    int i29 = 0;
                    while (i29 < jSONArray7.length()) {
                        JSONObject jSONObject5 = jSONArray7.getJSONObject(i29);
                        DancePosture dancePosture2 = new DancePosture();
                        String string = jSONObject5.getString("gestureId");
                        if (!this.postures.containsKey(string)) {
                            str = str5;
                        } else {
                            dancePosture2.f287854id = string;
                            dancePosture2.postureType = 1;
                            double d17 = jSONObject5.getDouble(str5);
                            dancePosture2.appearTime = d17;
                            str = str5;
                            if (d17 < 0.0d) {
                                dancePosture2.appearTime = 0.0d;
                            }
                            int i36 = jSONObject5.getInt("appearCol");
                            dancePosture2.appearCol = i36;
                            if (i36 != 1 && i36 != 2) {
                                dancePosture2.appearCol = 1;
                            }
                            double d18 = jSONObject5.getDouble("speed");
                            dancePosture2.speed = d18;
                            if (d18 > 0.0d) {
                                d16 = 0.25d;
                                if (d18 > 1.0d) {
                                }
                                this.dancePostures.add(dancePosture2);
                            } else {
                                d16 = 0.25d;
                            }
                            dancePosture2.speed = d16;
                            this.dancePostures.add(dancePosture2);
                        }
                        i29++;
                        str5 = str;
                    }
                    if (jSONObject2.optInt("randomDance", 0) != 1) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i37 = 0; i37 < this.dancePostures.size(); i37++) {
                            arrayList2.add(this.dancePostures.get(i37).f287854id);
                        }
                        Collections.shuffle(arrayList2);
                        for (int i38 = 0; i38 < arrayList2.size(); i38++) {
                            this.dancePostures.get(i38).f287854id = (String) arrayList2.get(i38);
                        }
                        return;
                    }
                    return;
                }
            }
            jSONObject2 = jSONObject;
            if (jSONObject2.optInt("randomDance", 0) != 1) {
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void parseLyricsConfig() {
        if (!QmcfManager.isQQRun && this.mPostureType == 0) {
            List<LyricItem> list = this.mLyricsList;
            if (list == null) {
                this.mLyricsList = new ArrayList();
            } else {
                list.clear();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(readFileContent(this.mLittleBoyFilterRoot + "lyrics.json"));
            sb5.append("");
            String sb6 = sb5.toString();
            if (!TextUtils.isEmpty(sb6) && !"null".equals(sb6)) {
                try {
                    JSONObject jSONObject = new JSONObject(sb6);
                    if (jSONObject.has("lyricsList")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("lyricsList");
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                            int optInt = jSONObject2.optInt("startTime", 0);
                            int optInt2 = jSONObject2.optInt("endTime", 0);
                            if (optInt <= optInt2) {
                                LyricItem lyricItem = new LyricItem();
                                lyricItem.text = jSONObject2.optString("text", "");
                                lyricItem.startTime = optInt;
                                lyricItem.endTime = optInt2;
                                lyricItem.status = 0;
                                this.mLyricsList.add(lyricItem);
                            }
                        }
                        Collections.sort(this.mLyricsList, this.mLyricsOrderCompare);
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    private void parseParamConfig() {
        this.durationTime = 30000;
        try {
            int optDouble = (int) (new JSONObject(readFileContent(this.mLittleBoyFilterRoot + IVideoFilterTools.CONFIG_FILE) + "").getJSONObject("postureParam").optDouble("gameDuration", 30.0d) * 1000.0d);
            this.durationTime = optDouble;
            if (optDouble > 60000) {
                this.durationTime = 60000;
            }
            if (this.durationTime <= 0) {
                this.durationTime = 30000;
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readFileContent(String str) {
        BufferedReader bufferedReader;
        File file = new File(str);
        StringBuilder sb5 = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb5.append(readLine);
                        } else {
                            try {
                                break;
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return null;
                }
            }
            bufferedReader.close();
            return sb5.toString();
        } catch (Exception e17) {
            e = e17;
            bufferedReader = null;
        } catch (Throwable th6) {
            th = th6;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }

    private void resourceCheck(String str) {
        if (BdhLogUtil.LogTag.Tag_Conn.equals(str) && !TextUtils.isEmpty(this.mLittleBoyFilterRoot)) {
            File file = new File(this.mLittleBoyFilterRoot + IVideoFilterTools.CONFIG_FILE);
            if (file.exists()) {
                file.delete();
                if (SLog.isEnable()) {
                    SLog.e(TAG, "ResourceCheck fail, delete params file!");
                }
            }
        }
    }

    public Map<String, Posture> getAllBoyPosture() {
        return this.postures;
    }

    public List<String> getAllSound() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mGameNumberResource.scoreSound);
        arrayList.add(this.mReadyResource.oneSound);
        arrayList.add(this.mReadyResource.twoSound);
        arrayList.add(this.mReadyResource.threeSound);
        arrayList.add(this.mReadyResource.readySound);
        arrayList.add(this.mStartResource.startSound);
        arrayList.add(this.mGamingResource.goodSound);
        arrayList.add(this.mGamingResource.greatSound);
        arrayList.add(this.mGamingResource.missSound);
        arrayList.add(this.mGamingResource.perfectSound);
        return arrayList;
    }

    public List<DancePosture> getDancePostures() {
        return this.dancePostures;
    }

    public String getLittleBoyFilterRootPath() {
        return this.mLittleBoyFilterRoot;
    }

    public List<LyricItem> getLyricsList() {
        if (this.mPostureType != 0) {
            return null;
        }
        return this.mLyricsList;
    }

    public Posture getPostureById(String str) {
        if (this.postures.containsKey(str)) {
            return this.postures.get(str);
        }
        return null;
    }

    public int getPostureType() {
        return this.mPostureType;
    }

    public void setLittleBoyFilterRootPath(String str) {
        this.mLittleBoyFilterRoot = str;
        if (str == null || "".equals(str)) {
            this.mLittleBoyFilterRoot = sLittleBoyFilterPath;
        }
        parseLittleBoyConfig();
        parseParamConfig();
        parseLyricsConfig();
        parseCompressConfig();
        this.mLBGeneraResource = new LBGeneralResource();
    }

    public void setPostureType(int i3) {
        this.mPostureType = i3;
    }

    public void setRootDanceStagePath(String str) {
        this.postureRecognizePath = str;
        if (str == null || "".equals(str)) {
            this.postureRecognizePath = sRootDanceStageQQPath;
        }
        createDanceStageResource();
    }
}
