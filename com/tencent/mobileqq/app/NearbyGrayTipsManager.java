package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class NearbyGrayTipsManager implements Manager {
    static IPatchRedirector $redirector_;
    private int C;
    private Random D;
    private List<GreetWording> E;
    private List<FaceScoreWording> F;
    private List<Object> G;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f194875d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<GrayTipsConfig> f194876e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f194877f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f194878h;

    /* renamed from: i, reason: collision with root package name */
    private int f194879i;

    /* renamed from: m, reason: collision with root package name */
    private int f194880m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class GrayTipsConfig implements Serializable {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;
        public ArrayList<Integer> aioTypes;
        public long createTime;
        public ArrayList<Wording> favoriteGrayTipWordings1;
        public ArrayList<Wording> favoriteGrayTipWordings2;
        public int globalMaxTipsCountPerDay;
        public ArrayList<Wording> grayTipWordings;
        public boolean grayTipsEnable;

        /* renamed from: id, reason: collision with root package name */
        public int f194883id;
        public int maxTipsCount;
        public int messageCount;
        public int priority;
        public ArrayList<String> randomWordings;
        public SceneFive sceneFive;
        public SceneFour sceneFour;
        public int sceneId;
        public SceneOne sceneOne;
        public SceneThree sceneThree;
        public SceneTwo sceneTwo;
        public ArrayList<Integer> sexTypes;
        public boolean showKeyboard;
        public int singleTaskMaxTipsCount;
        public int singleTaskMaxTipsCountPerDay;
        public ArrayList<TimeRangeInOneDay> timeRange;
        public boolean timeRangeControl;
        public String url;

        public GrayTipsConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public Wording getFavoriteGrayTipWording1(Random random) {
            int i3;
            Wording wording;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Wording) iPatchRedirector.redirect((short) 3, (Object) this, (Object) random);
            }
            ArrayList<Wording> arrayList = this.favoriteGrayTipWordings1;
            int i16 = 0;
            if (arrayList != null) {
                i3 = arrayList.size();
            } else {
                i3 = 0;
            }
            if (i3 > 1 && random != null) {
                int nextInt = random.nextInt(i3);
                int i17 = nextInt;
                while (true) {
                    if (i17 < i3) {
                        wording = this.favoriteGrayTipWordings1.get(i17);
                        if (wording != null && !TextUtils.isEmpty(wording.text)) {
                            break;
                        }
                        i17++;
                    } else {
                        wording = null;
                        break;
                    }
                }
                if (wording == null) {
                    while (i16 < nextInt) {
                        Wording wording2 = this.favoriteGrayTipWordings1.get(i16);
                        if (wording2 != null && !TextUtils.isEmpty(wording2.text)) {
                            return wording2;
                        }
                        i16++;
                        wording = null;
                    }
                }
                return wording;
            }
            if (i3 != 1) {
                return null;
            }
            return this.favoriteGrayTipWordings1.get(0);
        }

        public Wording getFavoriteGrayTipWording2(Random random) {
            int i3;
            Wording wording;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Wording) iPatchRedirector.redirect((short) 4, (Object) this, (Object) random);
            }
            ArrayList<Wording> arrayList = this.favoriteGrayTipWordings2;
            int i16 = 0;
            if (arrayList != null) {
                i3 = arrayList.size();
            } else {
                i3 = 0;
            }
            if (i3 > 1 && random != null) {
                int nextInt = random.nextInt(i3);
                int i17 = nextInt;
                while (true) {
                    if (i17 < i3) {
                        wording = this.favoriteGrayTipWordings2.get(i17);
                        if (wording != null && !TextUtils.isEmpty(wording.text)) {
                            break;
                        }
                        i17++;
                    } else {
                        wording = null;
                        break;
                    }
                }
                if (wording == null) {
                    while (i16 < nextInt) {
                        Wording wording2 = this.favoriteGrayTipWordings2.get(i16);
                        if (wording2 != null && !TextUtils.isEmpty(wording2.text)) {
                            return wording2;
                        }
                        i16++;
                        wording = null;
                    }
                }
                return wording;
            }
            if (i3 != 1) {
                return null;
            }
            return this.favoriteGrayTipWordings2.get(0);
        }

        public Wording getGrayTipWording(Random random) {
            int i3;
            Wording wording;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Wording) iPatchRedirector.redirect((short) 2, (Object) this, (Object) random);
            }
            ArrayList<Wording> arrayList = this.grayTipWordings;
            int i16 = 0;
            if (arrayList != null) {
                i3 = arrayList.size();
            } else {
                i3 = 0;
            }
            if (i3 > 1 && random != null) {
                int nextInt = random.nextInt(i3);
                int i17 = nextInt;
                while (true) {
                    if (i17 < i3) {
                        wording = this.grayTipWordings.get(i17);
                        if (wording != null && !TextUtils.isEmpty(wording.text)) {
                            break;
                        }
                        i17++;
                    } else {
                        wording = null;
                        break;
                    }
                }
                if (wording == null) {
                    while (i16 < nextInt) {
                        Wording wording2 = this.grayTipWordings.get(i16);
                        if (wording2 != null && !TextUtils.isEmpty(wording2.text)) {
                            return wording2;
                        }
                        i16++;
                        wording = null;
                    }
                }
                return wording;
            }
            if (i3 != 1) {
                return null;
            }
            return this.grayTipWordings.get(0);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
        
            r2 = true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean isInValidRangeDaily(long j3) {
            ArrayList<TimeRangeInOneDay> arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, j3)).booleanValue();
            }
            if (!this.timeRangeControl || (arrayList = this.timeRange) == null || arrayList.size() == 0) {
                return true;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j3);
            int i3 = calendar.get(11);
            Iterator<TimeRangeInOneDay> it = this.timeRange.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                TimeRangeInOneDay next = it.next();
                if (next != null) {
                    z16 = (r2 = next.beginTime) <= (r3 = next.endTime) ? false : false;
                    if (z16) {
                        break;
                    }
                }
            }
            return z16;
        }

        public boolean isValid(QQAppInterface qQAppInterface, int i3, int i16, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, this, qQAppInterface, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3))).booleanValue();
            }
            ArrayList<Integer> arrayList = this.aioTypes;
            if (arrayList != null && !arrayList.contains(Integer.valueOf(i3))) {
                return false;
            }
            if ((this.sexTypes == null || this.sexTypes.contains(Integer.valueOf(((com.tencent.mobileqq.nearby.b) qQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).e(i16)))) && isInValidRangeDaily(j3)) {
                return true;
            }
            return false;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "GrayTipsConfig{id=" + this.f194883id + ", createTime=" + this.createTime + ", grayTipsEnable=" + this.grayTipsEnable + ", global_MaxTipsCountPerDay=" + this.globalMaxTipsCountPerDay + ", maxTipsCount=" + this.maxTipsCount + ", messageCount=" + this.messageCount + ", priority=" + this.priority + ", singleTask_MaxTipsCountPerDay=" + this.singleTaskMaxTipsCountPerDay + ", singleTask_maxTipsCount=" + this.singleTaskMaxTipsCount + ", aioTypes=" + this.aioTypes + ", sexTypes=" + this.sexTypes + ", timeRangeControl=" + this.timeRangeControl + ", timeRange=" + this.timeRange + ", showKeyboard=" + this.showKeyboard + ", url='" + this.url + "', grayTipWordings=" + this.grayTipWordings + ", favoriteGrayTipWordings1=" + this.favoriteGrayTipWordings1 + ", favoriteGrayTipWordings2=" + this.favoriteGrayTipWordings2 + ", sceneId=" + this.sceneId + ", randomWordings=" + this.randomWordings + ", sceneOne=" + this.sceneOne + ", sceneTwo=" + this.sceneTwo + ", sceneThree=" + this.sceneThree + ", sceneFour=" + this.sceneFour + ", sceneFive=" + this.sceneFive + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class SceneFive implements Serializable {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;
        public boolean faceScoreTrigger;
        public ArrayList<String> randomWordingForFeMale;
        public ArrayList<String> randomWordingForMale;

        public SceneFive() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class SceneFour implements Serializable {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;
        public boolean enterAIOTrigger;

        public SceneFour() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class SceneOne implements Serializable {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;
        public boolean sayHiTrigger;

        public SceneOne() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class SceneThree implements Serializable {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;
        public boolean keywordTrigger;
        public ArrayList<String> keywords;
        public ArrayList<Integer> whichSide;

        public SceneThree() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class SceneTwo implements Serializable {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;
        public boolean sayHiFrequencyControl;
        public int sayHiPeopleCount;
        public int timeRange;

        public SceneTwo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class TimeRangeInOneDay implements Serializable {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;
        public int beginTime;
        public int endTime;

        public TimeRangeInOneDay() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class Wording implements Serializable {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;
        public String highlightText;
        public String text;

        public Wording() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "Wording{text='" + this.text + "', highlightText='" + this.highlightText + "'}";
        }
    }

    public NearbyGrayTipsManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194876e = new ArrayList<>();
        this.E = null;
        this.F = null;
        this.G = null;
        this.f194875d = qQAppInterface;
        this.E = new ArrayList(2);
        this.F = new ArrayList(2);
        this.G = new ArrayList(2);
        Random random = new Random();
        this.D = random;
        random.setSeed(System.currentTimeMillis());
    }

    public static String b() {
        File file = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/nearby_gray_tips_configs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + "/";
    }

    private FaceScoreWording c(int i3) {
        FaceScoreWording faceScoreWording;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_FACE_SCORE, 2, "getFaceScoreWordingById id= " + i3);
        }
        synchronized (this.F) {
            int size = this.F.size();
            faceScoreWording = null;
            for (int i16 = 0; i16 < size; i16++) {
                faceScoreWording = this.F.get(i16);
                if (faceScoreWording != null) {
                    if (faceScoreWording.f194881id == i3) {
                        break;
                    }
                    faceScoreWording = null;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_FACE_SCORE, 2, "getFaceScoreWordingById return faceScoreWording= " + faceScoreWording);
        }
        return faceScoreWording;
    }

    private GreetWording d(int i3) {
        GreetWording greetWording;
        synchronized (this.E) {
            int size = this.E.size();
            greetWording = null;
            for (int i16 = 0; i16 < size; i16++) {
                greetWording = this.E.get(i16);
                if (greetWording != null) {
                    if (greetWording.f194884id == i3) {
                        break;
                    }
                    greetWording = null;
                }
            }
        }
        return greetWording;
    }

    private static void f(GrayTipsConfig grayTipsConfig, JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("CreationDate")) {
            grayTipsConfig.createTime = jSONObject.getLong("CreationDate") * 1000;
        }
        if (!jSONObject.isNull("TipEnable")) {
            grayTipsConfig.grayTipsEnable = jSONObject.getBoolean("TipEnable");
        }
        if (!jSONObject.isNull("GlobalTipsCountPerDay")) {
            grayTipsConfig.globalMaxTipsCountPerDay = jSONObject.getInt("GlobalTipsCountPerDay");
        }
        if (!jSONObject.isNull("Frequency")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("Frequency");
            if (!jSONObject2.isNull("TipsCount")) {
                grayTipsConfig.maxTipsCount = jSONObject2.getInt("TipsCount");
            }
            if (!jSONObject2.isNull("MessageCount")) {
                grayTipsConfig.messageCount = jSONObject2.getInt("MessageCount");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x008e -> B:18:0x0091). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static GrayTipsConfig g(File file) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        ?? r26 = 0;
        r26 = 0;
        GrayTipsConfig grayTipsConfig = null;
        if (file == null || !file.exists()) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        try {
            try {
                try {
                    fileReader = new FileReader(file);
                } catch (FileNotFoundException e16) {
                    e = e16;
                    bufferedReader = null;
                    fileReader = null;
                } catch (IOException e17) {
                    e = e17;
                    bufferedReader = null;
                    fileReader = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileReader = null;
                }
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                sb5.append(readLine);
                            } else {
                                try {
                                    break;
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                            }
                        } catch (FileNotFoundException e19) {
                            e = e19;
                            if (QLog.isColorLevel()) {
                                QLog.d(LogTag.NEARBY_AIO_OPERATION_GRAY_TIPS, 2, "parseJSONFromFile()--->FileNotFoundException");
                            }
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e26) {
                                    e26.printStackTrace();
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            if (sb5.length() <= 0) {
                            }
                        } catch (IOException e27) {
                            e = e27;
                            if (QLog.isColorLevel()) {
                                QLog.d(LogTag.NEARBY_AIO_OPERATION_GRAY_TIPS, 2, "parseJSONFromFile()--->IOException");
                            }
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e28) {
                                    e28.printStackTrace();
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            if (sb5.length() <= 0) {
                            }
                        }
                    }
                    bufferedReader.close();
                    fileReader.close();
                } catch (FileNotFoundException e29) {
                    e = e29;
                    bufferedReader = null;
                } catch (IOException e36) {
                    e = e36;
                    bufferedReader = null;
                } catch (Throwable th6) {
                    th = th6;
                    if (r26 != 0) {
                        try {
                            r26.close();
                        } catch (IOException e37) {
                            e37.printStackTrace();
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                            throw th;
                        } catch (IOException e38) {
                            e38.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (IOException e39) {
                e39.printStackTrace();
            }
            if (sb5.length() <= 0) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(sb5.toString());
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.NEARBY_AIO_OPERATION_GRAY_TIPS, 2, "json = " + jSONObject);
                }
                GrayTipsConfig grayTipsConfig2 = new GrayTipsConfig();
                try {
                    f(grayTipsConfig2, jSONObject);
                    if (!jSONObject.isNull("SingleTaskConfig")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("SingleTaskConfig");
                        o(grayTipsConfig2, jSONObject2);
                        q(grayTipsConfig2, jSONObject2);
                        m(grayTipsConfig2, jSONObject2);
                        j(grayTipsConfig2, jSONObject2);
                        s(grayTipsConfig2, jSONObject2);
                        u(grayTipsConfig2, jSONObject2);
                        t(grayTipsConfig2, jSONObject2);
                        p(grayTipsConfig2, jSONObject2);
                        k(grayTipsConfig2, jSONObject2);
                        l(grayTipsConfig2, jSONObject2);
                        r(grayTipsConfig2, jSONObject2);
                    }
                    return grayTipsConfig2;
                } catch (JSONException e46) {
                    e = e46;
                    grayTipsConfig = grayTipsConfig2;
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.NEARBY_AIO_OPERATION_GRAY_TIPS, 2, "parseJSONFromFile()--->JSONException. json string=" + sb5.toString());
                    }
                    e.printStackTrace();
                    return grayTipsConfig;
                }
            } catch (JSONException e47) {
                e = e47;
            }
        } catch (Throwable th7) {
            th = th7;
            r26 = file;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00cc A[Catch: IOException -> 0x00c8, TryCatch #11 {IOException -> 0x00c8, blocks: (B:68:0x00c4, B:59:0x00cc, B:61:0x00d1), top: B:67:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d1 A[Catch: IOException -> 0x00c8, TRY_LEAVE, TryCatch #11 {IOException -> 0x00c8, blocks: (B:68:0x00c4, B:59:0x00cc, B:61:0x00d1), top: B:67:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v5, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object h(String str) {
        ObjectInputStream objectInputStream;
        FileInputStream fileInputStream;
        String obj;
        Object obj2 = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    str = new BufferedInputStream(fileInputStream);
                } catch (FileNotFoundException e17) {
                    e = e17;
                    str = 0;
                    objectInputStream = null;
                } catch (IOException e18) {
                    e = e18;
                    str = 0;
                    objectInputStream = null;
                } catch (Exception e19) {
                    e = e19;
                    str = 0;
                    objectInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    objectInputStream = null;
                    th = th;
                    str = objectInputStream;
                    if (objectInputStream != null) {
                    }
                    if (str != 0) {
                    }
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
                try {
                    objectInputStream = new ObjectInputStream(str);
                } catch (FileNotFoundException e26) {
                    e = e26;
                    objectInputStream = null;
                } catch (IOException e27) {
                    e = e27;
                    objectInputStream = null;
                } catch (Exception e28) {
                    e = e28;
                    objectInputStream = null;
                } catch (Throwable th6) {
                    objectInputStream = null;
                    th = th6;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e29) {
                            e29.printStackTrace();
                            throw th;
                        }
                    }
                    if (str != 0) {
                        str.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e36) {
                e = e36;
                str = 0;
                fileInputStream = null;
                objectInputStream = null;
            } catch (IOException e37) {
                e = e37;
                str = 0;
                fileInputStream = null;
                objectInputStream = null;
            } catch (Exception e38) {
                e = e38;
                str = 0;
                fileInputStream = null;
                objectInputStream = null;
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = null;
                objectInputStream = null;
            }
            try {
                obj2 = objectInputStream.readObject();
                objectInputStream.close();
                str.close();
                fileInputStream.close();
            } catch (FileNotFoundException e39) {
                e = e39;
                e.printStackTrace();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (str != 0) {
                    str.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                str = QLog.isColorLevel();
                if (str != 0) {
                }
                return obj2;
            } catch (IOException e46) {
                e = e46;
                e.printStackTrace();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (str != 0) {
                    str.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                str = QLog.isColorLevel();
                if (str != 0) {
                }
                return obj2;
            } catch (Exception e47) {
                e = e47;
                e.printStackTrace();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (str != 0) {
                    str.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                str = QLog.isColorLevel();
                if (str != 0) {
                }
                return obj2;
            }
            str = QLog.isColorLevel();
            if (str != 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("restore, obj = ");
                if (obj2 == null) {
                    obj = "null";
                } else {
                    obj = obj2.toString();
                }
                sb5.append(obj);
                QLog.i(LogTag.NEARBY_AIO_OPERATION_GRAY_TIPS, 2, sb5.toString());
            }
            return obj2;
        } catch (Throwable th8) {
            th = th8;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0114 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d4 A[Catch: IOException -> 0x00d8, TRY_ENTER, TRY_LEAVE, TryCatch #16 {IOException -> 0x00d8, blocks: (B:82:0x0090, B:66:0x00b2, B:47:0x00d4), top: B:11:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b2 A[Catch: IOException -> 0x00d8, TRY_ENTER, TRY_LEAVE, TryCatch #16 {IOException -> 0x00d8, blocks: (B:82:0x0090, B:66:0x00b2, B:47:0x00d4), top: B:11:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0090 A[Catch: IOException -> 0x00d8, TRY_ENTER, TRY_LEAVE, TryCatch #16 {IOException -> 0x00d8, blocks: (B:82:0x0090, B:66:0x00b2, B:47:0x00d4), top: B:11:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v22, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v30, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(Object obj, String str) {
        ObjectOutputStream objectOutputStream;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream2;
        Exception e16;
        IOException e17;
        FileNotFoundException e18;
        boolean z16;
        if (obj == null) {
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.NEARBY_AIO_OPERATION_GRAY_TIPS, 2, "save, obj is null");
                return;
            }
            return;
        }
        OutputStream outputStream = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream((String) str);
                } catch (FileNotFoundException e19) {
                    e = e19;
                    fileOutputStream = null;
                    objectOutputStream2 = null;
                } catch (IOException e26) {
                    e = e26;
                    fileOutputStream = null;
                    objectOutputStream2 = null;
                } catch (Exception e27) {
                    e = e27;
                    fileOutputStream = null;
                    objectOutputStream2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                    objectOutputStream = null;
                }
                try {
                    str = new BufferedOutputStream(fileOutputStream);
                    try {
                        objectOutputStream2 = new ObjectOutputStream(str);
                    } catch (FileNotFoundException e28) {
                        objectOutputStream2 = null;
                        e18 = e28;
                    } catch (IOException e29) {
                        objectOutputStream2 = null;
                        e17 = e29;
                    } catch (Exception e36) {
                        objectOutputStream2 = null;
                        e16 = e36;
                    } catch (Throwable th6) {
                        th = th6;
                        objectOutputStream = null;
                        outputStream = str;
                        if (outputStream != null) {
                        }
                        if (objectOutputStream != null) {
                        }
                        if (fileOutputStream == null) {
                        }
                    }
                } catch (FileNotFoundException e37) {
                    e = e37;
                    objectOutputStream2 = null;
                    e18 = e;
                    str = objectOutputStream2;
                    e18.printStackTrace();
                    if (str != 0) {
                    }
                    if (objectOutputStream2 != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    z16 = false;
                    if (!QLog.isColorLevel()) {
                    }
                } catch (IOException e38) {
                    e = e38;
                    objectOutputStream2 = null;
                    e17 = e;
                    str = objectOutputStream2;
                    e17.printStackTrace();
                    if (str != 0) {
                    }
                    if (objectOutputStream2 != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    z16 = false;
                    if (!QLog.isColorLevel()) {
                    }
                } catch (Exception e39) {
                    e = e39;
                    objectOutputStream2 = null;
                    e16 = e;
                    str = objectOutputStream2;
                    e16.printStackTrace();
                    if (str != 0) {
                    }
                    if (objectOutputStream2 != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    z16 = false;
                    if (!QLog.isColorLevel()) {
                    }
                } catch (Throwable th7) {
                    th = th7;
                    objectOutputStream = null;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e46) {
                            e46.printStackTrace();
                        }
                    }
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e47) {
                            e47.printStackTrace();
                        }
                    }
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (IOException e48) {
                            e48.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
                try {
                    objectOutputStream2.writeObject(obj);
                    str.flush();
                    try {
                        str.close();
                    } catch (IOException e49) {
                        e49.printStackTrace();
                    }
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e56) {
                        e56.printStackTrace();
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e57) {
                        e57.printStackTrace();
                    }
                    z16 = true;
                } catch (FileNotFoundException e58) {
                    e18 = e58;
                    e18.printStackTrace();
                    if (str != 0) {
                        try {
                            str.close();
                        } catch (IOException e59) {
                            e59.printStackTrace();
                        }
                    }
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e65) {
                            e65.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    z16 = false;
                    if (!QLog.isColorLevel()) {
                    }
                } catch (IOException e66) {
                    e17 = e66;
                    e17.printStackTrace();
                    if (str != 0) {
                        try {
                            str.close();
                        } catch (IOException e67) {
                            e67.printStackTrace();
                        }
                    }
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e68) {
                            e68.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    z16 = false;
                    if (!QLog.isColorLevel()) {
                    }
                } catch (Exception e69) {
                    e16 = e69;
                    e16.printStackTrace();
                    if (str != 0) {
                        try {
                            str.close();
                        } catch (IOException e75) {
                            e75.printStackTrace();
                        }
                    }
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e76) {
                            e76.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    z16 = false;
                    if (!QLog.isColorLevel()) {
                    }
                }
            } catch (IOException e77) {
                e77.printStackTrace();
                z16 = false;
                if (!QLog.isColorLevel()) {
                }
            }
            if (!QLog.isColorLevel()) {
                QLog.i(LogTag.NEARBY_AIO_OPERATION_GRAY_TIPS, 2, "save, " + z16 + "," + obj.toString());
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    private static void j(GrayTipsConfig grayTipsConfig, JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("AIOType")) {
            JSONArray jSONArray = jSONObject.getJSONArray("AIOType");
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(Integer.valueOf(jSONArray.getInt(i3)));
            }
            grayTipsConfig.aioTypes = arrayList;
        }
    }

    private static void k(GrayTipsConfig grayTipsConfig, JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull(AECameraConstants.REQ_FIELD_FONT_CONTENT)) {
            JSONArray jSONArray = jSONObject.getJSONArray(AECameraConstants.REQ_FIELD_FONT_CONTENT);
            ArrayList<Wording> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                if (!jSONObject2.isNull("Title")) {
                    Wording wording = new Wording();
                    wording.text = jSONObject2.getString("Title");
                    if (!jSONObject2.isNull("HighlightTitle")) {
                        wording.highlightText = jSONObject2.getString("HighlightTitle");
                    }
                    arrayList.add(wording);
                }
            }
            grayTipsConfig.grayTipWordings = arrayList;
        }
    }

    private static void l(GrayTipsConfig grayTipsConfig, JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("FavoriteContent1")) {
            JSONArray jSONArray = jSONObject.getJSONArray("FavoriteContent1");
            ArrayList<Wording> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                if (!jSONObject2.isNull("Title")) {
                    Wording wording = new Wording();
                    wording.text = jSONObject2.getString("Title");
                    if (!jSONObject2.isNull("HighlightTitle")) {
                        wording.highlightText = jSONObject2.getString("HighlightTitle");
                    }
                    arrayList.add(wording);
                }
            }
            grayTipsConfig.favoriteGrayTipWordings1 = arrayList;
        }
        if (!jSONObject.isNull("FavoriteContent2")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("FavoriteContent2");
            ArrayList<Wording> arrayList2 = new ArrayList<>();
            for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i16);
                if (!jSONObject3.isNull("Title")) {
                    Wording wording2 = new Wording();
                    wording2.text = jSONObject3.getString("Title");
                    if (!jSONObject3.isNull("HighlightTitle")) {
                        wording2.highlightText = jSONObject3.getString("HighlightTitle");
                    }
                    arrayList2.add(wording2);
                }
            }
            grayTipsConfig.favoriteGrayTipWordings2 = arrayList2;
        }
    }

    private static void m(GrayTipsConfig grayTipsConfig, JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("Frequency")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("Frequency");
            if (!jSONObject2.isNull("SingleTaskTipsCountPerDay")) {
                grayTipsConfig.singleTaskMaxTipsCountPerDay = jSONObject2.getInt("SingleTaskTipsCountPerDay");
            }
            if (!jSONObject2.isNull("SingleTaskTotalTipsCount")) {
                grayTipsConfig.singleTaskMaxTipsCount = jSONObject2.getInt("SingleTaskTotalTipsCount");
            }
        }
    }

    private static void o(GrayTipsConfig grayTipsConfig, JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("ID")) {
            grayTipsConfig.f194883id = jSONObject.getInt("ID");
        }
    }

    private static void p(GrayTipsConfig grayTipsConfig, JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("Link")) {
            grayTipsConfig.url = jSONObject.getString("Link");
        }
    }

    private static void q(GrayTipsConfig grayTipsConfig, JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("Priority")) {
            grayTipsConfig.priority = jSONObject.getInt("Priority");
        }
    }

    private static void r(GrayTipsConfig grayTipsConfig, JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("SceneType")) {
            grayTipsConfig.sceneId = jSONObject.getInt("SceneType");
        }
        if (!jSONObject.isNull("RandomWording")) {
            JSONArray jSONArray = jSONObject.getJSONArray("RandomWording");
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.getString(i3));
            }
            grayTipsConfig.randomWordings = arrayList;
        }
        if (!jSONObject.isNull("SceneFirst")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("SceneFirst");
            SceneOne sceneOne = new SceneOne();
            if (!jSONObject2.isNull("SayHiTrigger")) {
                sceneOne.sayHiTrigger = jSONObject2.getBoolean("SayHiTrigger");
            }
            grayTipsConfig.sceneOne = sceneOne;
        }
        if (!jSONObject.isNull("SceneSecond")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("SceneSecond");
            SceneTwo sceneTwo = new SceneTwo();
            if (!jSONObject3.isNull("SayHiFrequencyControl")) {
                sceneTwo.sayHiFrequencyControl = jSONObject3.getBoolean("SayHiFrequencyControl");
                if (!jSONObject3.isNull("TimeRange")) {
                    sceneTwo.timeRange = jSONObject3.getInt("TimeRange");
                }
                if (!jSONObject3.isNull("UsersCount")) {
                    sceneTwo.sayHiPeopleCount = jSONObject3.getInt("UsersCount");
                }
            }
            grayTipsConfig.sceneTwo = sceneTwo;
        }
        if (!jSONObject.isNull("SceneThird")) {
            JSONObject jSONObject4 = jSONObject.getJSONObject("SceneThird");
            if (!jSONObject4.isNull("KeywordTrigger")) {
                SceneThree sceneThree = new SceneThree();
                sceneThree.keywordTrigger = jSONObject4.getBoolean("KeywordTrigger");
                if (!jSONObject4.isNull("MessageSide")) {
                    JSONArray jSONArray2 = jSONObject4.getJSONArray("MessageSide");
                    ArrayList<Integer> arrayList2 = new ArrayList<>();
                    for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                        arrayList2.add(Integer.valueOf(jSONArray2.getInt(i16)));
                    }
                    sceneThree.whichSide = arrayList2;
                }
                if (!jSONObject4.isNull("KeywordList")) {
                    JSONArray jSONArray3 = jSONObject4.getJSONArray("KeywordList");
                    ArrayList<String> arrayList3 = new ArrayList<>();
                    for (int i17 = 0; i17 < jSONArray3.length(); i17++) {
                        arrayList3.add(jSONArray3.getString(i17));
                    }
                    sceneThree.keywords = arrayList3;
                }
                grayTipsConfig.sceneThree = sceneThree;
            }
        }
        if (!jSONObject.isNull("SceneForth")) {
            JSONObject jSONObject5 = jSONObject.getJSONObject("SceneForth");
            SceneFour sceneFour = new SceneFour();
            sceneFour.enterAIOTrigger = jSONObject5.getBoolean("AIOTrigger");
            grayTipsConfig.sceneFour = sceneFour;
        }
        if (!jSONObject.isNull("SceneFifth")) {
            JSONObject jSONObject6 = jSONObject.getJSONObject("SceneFifth");
            SceneFive sceneFive = new SceneFive();
            sceneFive.faceScoreTrigger = jSONObject6.getBoolean("FaceScoreTrigger");
            JSONArray jSONArray4 = jSONObject6.getJSONArray("RandomWordingForMale");
            ArrayList<String> arrayList4 = new ArrayList<>();
            for (int i18 = 0; i18 < jSONArray4.length(); i18++) {
                arrayList4.add(jSONArray4.getString(i18));
            }
            sceneFive.randomWordingForMale = arrayList4;
            JSONArray jSONArray5 = jSONObject6.getJSONArray("RandomWordingForFemale");
            ArrayList<String> arrayList5 = new ArrayList<>();
            for (int i19 = 0; i19 < jSONArray5.length(); i19++) {
                arrayList5.add(jSONArray5.getString(i19));
            }
            sceneFive.randomWordingForFeMale = arrayList5;
            grayTipsConfig.sceneFive = sceneFive;
        }
    }

    private static void s(GrayTipsConfig grayTipsConfig, JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("SexType")) {
            JSONArray jSONArray = jSONObject.getJSONArray("SexType");
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(Integer.valueOf(jSONArray.getInt(i3)));
            }
            grayTipsConfig.sexTypes = arrayList;
        }
    }

    private static void t(GrayTipsConfig grayTipsConfig, JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("ShowKeyboardSupport")) {
            grayTipsConfig.showKeyboard = jSONObject.getBoolean("ShowKeyboardSupport");
        }
    }

    private static void u(GrayTipsConfig grayTipsConfig, JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("TimeDailyControl")) {
            grayTipsConfig.timeRangeControl = jSONObject.getBoolean("TimeDailyControl");
        }
        if (!jSONObject.isNull("TimeRangeDaily")) {
            JSONArray jSONArray = jSONObject.getJSONArray("TimeRangeDaily");
            ArrayList<TimeRangeInOneDay> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                if (!jSONObject2.isNull("BeginTime") && !jSONObject2.isNull("EndTime")) {
                    TimeRangeInOneDay timeRangeInOneDay = new TimeRangeInOneDay();
                    timeRangeInOneDay.beginTime = jSONObject2.getInt("BeginTime");
                    timeRangeInOneDay.endTime = jSONObject2.getInt("EndTime");
                    arrayList.add(timeRangeInOneDay);
                }
            }
            grayTipsConfig.timeRange = arrayList;
        }
    }

    public static boolean v(GrayTipsConfig grayTipsConfig) {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        boolean z16 = false;
        if (grayTipsConfig == null) {
            return false;
        }
        ObjectOutputStream objectOutputStream = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                fileOutputStream = new FileOutputStream(b() + grayTipsConfig.f194883id + ".conf");
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    try {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(bufferedOutputStream);
                        try {
                            objectOutputStream2.writeObject(grayTipsConfig);
                            bufferedOutputStream.flush();
                            try {
                                objectOutputStream2.close();
                                bufferedOutputStream.close();
                                fileOutputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                            z16 = true;
                        } catch (FileNotFoundException e18) {
                            e = e18;
                            objectOutputStream = objectOutputStream2;
                            e.printStackTrace();
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return z16;
                        } catch (IOException e19) {
                            e = e19;
                            objectOutputStream = objectOutputStream2;
                            e.printStackTrace();
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return z16;
                        } catch (Throwable th5) {
                            th = th5;
                            objectOutputStream = objectOutputStream2;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (IOException e26) {
                                    e26.printStackTrace();
                                    throw th;
                                }
                            }
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e27) {
                        e = e27;
                    } catch (IOException e28) {
                        e = e28;
                    }
                } catch (FileNotFoundException e29) {
                    e = e29;
                    bufferedOutputStream = null;
                } catch (IOException e36) {
                    e = e36;
                    bufferedOutputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream = null;
                }
            } catch (FileNotFoundException e37) {
                e = e37;
                fileOutputStream = null;
                bufferedOutputStream = null;
            } catch (IOException e38) {
                e = e38;
                fileOutputStream = null;
                bufferedOutputStream = null;
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream = null;
                bufferedOutputStream = null;
            }
            return z16;
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public void a() {
        File[] listFiles;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        File file = new File(b());
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
        ArrayList<GrayTipsConfig> arrayList = this.f194876e;
        if (arrayList != null && arrayList.size() > 0) {
            synchronized (this.f194876e) {
                this.f194876e.clear();
            }
        }
        this.f194878h = false;
    }

    public String e(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        GreetWording d16 = d(i3);
        if (d16 == null && z16) {
            Object h16 = h(GreetWording.getPath(i3));
            if (h16 instanceof GreetWording) {
                d16 = (GreetWording) h16;
            }
        }
        if (d16 == null) {
            return "";
        }
        return d16.getWording(this.D);
    }

    public void n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            this.f194877f = z16;
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public void w(GrayTipsConfig grayTipsConfig, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, grayTipsConfig, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_FACE_SCORE, 2, "updateFaceScoreWording config= " + grayTipsConfig + "  needSaveToFile=" + z16);
        }
        if (grayTipsConfig != null && grayTipsConfig.sceneId == 5 && grayTipsConfig.sceneFive != null) {
            FaceScoreWording c16 = c(grayTipsConfig.f194883id);
            if (c16 == null) {
                c16 = new FaceScoreWording(grayTipsConfig.f194883id);
                synchronized (this.F) {
                    if (z16) {
                        this.F.add(0, c16);
                    } else {
                        this.F.add(c16);
                    }
                }
            }
            long j3 = grayTipsConfig.createTime;
            SceneFive sceneFive = grayTipsConfig.sceneFive;
            c16.saveWording(j3, sceneFive.randomWordingForMale, sceneFive.randomWordingForFeMale, z16);
        }
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ArrayList<GrayTipsConfig> arrayList = this.f194876e;
        if (arrayList != null && arrayList.size() > 0) {
            synchronized (this.f194876e) {
                if (this.f194876e.size() > 0) {
                    GrayTipsConfig grayTipsConfig = this.f194876e.get(0);
                    Iterator<GrayTipsConfig> it = this.f194876e.iterator();
                    while (it.hasNext()) {
                        GrayTipsConfig next = it.next();
                        if (next.createTime > grayTipsConfig.createTime) {
                            grayTipsConfig = next;
                        }
                    }
                    this.f194878h = grayTipsConfig.grayTipsEnable;
                    this.f194879i = grayTipsConfig.globalMaxTipsCountPerDay;
                    this.f194880m = grayTipsConfig.maxTipsCount;
                    this.C = grayTipsConfig.messageCount;
                }
            }
        }
    }

    public void y(GrayTipsConfig grayTipsConfig, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, grayTipsConfig, Boolean.valueOf(z16));
            return;
        }
        if (grayTipsConfig != null && grayTipsConfig.sceneId == 4) {
            GreetWording d16 = d(grayTipsConfig.f194883id);
            if (d16 == null) {
                d16 = new GreetWording(grayTipsConfig.f194883id);
                synchronized (this.E) {
                    if (z16) {
                        this.E.add(0, d16);
                    } else {
                        this.E.add(d16);
                    }
                }
            }
            d16.saveWording(grayTipsConfig.createTime, grayTipsConfig.randomWordings, z16);
        }
    }

    public void z(GrayTipsConfig grayTipsConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) grayTipsConfig);
            return;
        }
        if (grayTipsConfig != null) {
            synchronized (this.f194876e) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.f194876e.size()) {
                        break;
                    }
                    GrayTipsConfig grayTipsConfig2 = this.f194876e.get(i3);
                    if (grayTipsConfig2.f194883id == grayTipsConfig.f194883id) {
                        if (grayTipsConfig.createTime > grayTipsConfig2.createTime) {
                            this.f194876e.set(i3, grayTipsConfig);
                        }
                    } else {
                        i3++;
                    }
                }
                if (i3 == this.f194876e.size()) {
                    this.f194876e.add(grayTipsConfig);
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i(LogTag.NEARBY_AIO_OPERATION_GRAY_TIPS, 4, "updateOrAddAConfig,[" + i3 + ",config_id =" + grayTipsConfig.f194883id + ",config_scene_id =" + grayTipsConfig.sceneId + ",]");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class GreetWording implements Serializable {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;
        public long createTime;

        /* renamed from: id, reason: collision with root package name */
        public int f194884id;
        public int lastIndex;
        public List<String> list;

        public GreetWording() {
            this(0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else if (QLog.isDevelopLevel()) {
                QLog.i(LogTag.NEARBY_AIO_OPERATION_GRAY_TIPS, 4, "GreetWording");
            }
        }

        public static String getPath(int i3) {
            return NearbyGrayTipsManager.b() + GreetWording.class.getSimpleName() + "_" + i3;
        }

        public String getWording(Random random) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) random);
            }
            String str = "";
            synchronized (this.list) {
                int size = this.list.size();
                if (size > 0) {
                    int nextInt = random.nextInt(size);
                    int i3 = this.lastIndex;
                    if (nextInt == i3) {
                        nextInt = (i3 + 1) % size;
                    }
                    this.lastIndex = nextInt;
                    str = this.list.get(nextInt);
                }
            }
            return str;
        }

        public void saveWording(long j3, List<String> list, boolean z16) {
            GreetWording greetWording;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), list, Boolean.valueOf(z16));
                return;
            }
            if (list != null && list.size() != 0) {
                synchronized (this.list) {
                    if (this.list.size() == 0 || this.createTime < j3) {
                        this.createTime = j3;
                        this.list.clear();
                        this.list.addAll(list);
                        if (z16) {
                            greetWording = new GreetWording(this.f194884id);
                            greetWording.createTime = this.createTime;
                            greetWording.lastIndex = this.lastIndex;
                            greetWording.list.addAll(list);
                        }
                    }
                    greetWording = null;
                }
                if (z16 && greetWording != null) {
                    ThreadManager.getFileThreadHandler().post(new Runnable(greetWording) { // from class: com.tencent.mobileqq.app.NearbyGrayTipsManager.GreetWording.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ GreetWording f194885d;

                        {
                            this.f194885d = greetWording;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GreetWording.this, (Object) greetWording);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                NearbyGrayTipsManager.i(this.f194885d, GreetWording.getPath(this.f194885d.f194884id));
                            }
                        }
                    });
                }
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('[');
            stringBuffer.append(this.f194884id);
            stringBuffer.append(',');
            stringBuffer.append(this.createTime);
            stringBuffer.append(',');
            stringBuffer.append(this.lastIndex);
            stringBuffer.append(',');
            if (this.list.size() == 0) {
                stringBuffer.append("size is 0");
            } else {
                stringBuffer.append("size = ");
                stringBuffer.append(this.list.size());
                stringBuffer.append('(');
                Iterator<String> it = this.list.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                    stringBuffer.append(',');
                }
                stringBuffer.append(')');
            }
            stringBuffer.append(']');
            return stringBuffer.toString();
        }

        public GreetWording(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            this.f194884id = i3;
            this.createTime = 0L;
            this.list = new ArrayList(20);
            this.lastIndex = -1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class FaceScoreWording implements Serializable {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;
        public long createTime;
        public List<String> femaleWordingList;

        /* renamed from: id, reason: collision with root package name */
        public int f194881id;
        public int lastIndex;
        public Object lock;
        public List<String> maleWordingList;

        public FaceScoreWording(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
                return;
            }
            this.lock = new Object();
            this.f194881id = i3;
            this.maleWordingList = new ArrayList(5);
            this.femaleWordingList = new ArrayList(5);
        }

        public static String getPath(int i3) {
            return NearbyGrayTipsManager.b() + FaceScoreWording.class.getSimpleName() + "_" + i3;
        }

        public String getWording(Random random, int i3) {
            List<String> list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) random, i3);
            }
            String str = "";
            synchronized (this.lock) {
                if (i3 == 1) {
                    list = this.femaleWordingList;
                } else {
                    list = this.maleWordingList;
                }
                int size = list.size();
                if (size > 0) {
                    int nextInt = random.nextInt(size);
                    int i16 = this.lastIndex;
                    if (nextInt == i16) {
                        nextInt = (i16 + 1) % size;
                    }
                    this.lastIndex = nextInt;
                    str = list.get(nextInt);
                }
            }
            return str;
        }

        public void saveWording(long j3, List<String> list, List<String> list2, boolean z16) {
            FaceScoreWording faceScoreWording;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), list, list2, Boolean.valueOf(z16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_FACE_SCORE, 2, "saveWording time= " + j3 + "  maleWordingList=" + list + "  femaleWordingList=" + list2 + "  needSaveToFile=" + z16);
            }
            if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
                synchronized (this.lock) {
                    if (this.maleWordingList.size() == 0 || this.createTime < j3) {
                        this.createTime = j3;
                        this.maleWordingList.clear();
                        this.maleWordingList.addAll(list);
                    }
                    if (this.femaleWordingList.size() == 0 || this.createTime < j3) {
                        this.createTime = j3;
                        this.femaleWordingList.clear();
                        this.femaleWordingList.addAll(list2);
                    }
                    if (z16) {
                        faceScoreWording = new FaceScoreWording(this.f194881id);
                        faceScoreWording.createTime = this.createTime;
                        faceScoreWording.lastIndex = this.lastIndex;
                        faceScoreWording.maleWordingList.addAll(list);
                        faceScoreWording.femaleWordingList.addAll(list2);
                    } else {
                        faceScoreWording = null;
                    }
                }
                if (z16 && faceScoreWording != null) {
                    ThreadManager.getFileThreadHandler().post(new Runnable(faceScoreWording) { // from class: com.tencent.mobileqq.app.NearbyGrayTipsManager.FaceScoreWording.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ FaceScoreWording f194882d;

                        {
                            this.f194882d = faceScoreWording;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FaceScoreWording.this, (Object) faceScoreWording);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                NearbyGrayTipsManager.i(this.f194882d, FaceScoreWording.getPath(this.f194882d.f194881id));
                            }
                        }
                    });
                }
            }
        }

        public FaceScoreWording(int i3, long j3, List<String> list, List<String> list2, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), list, list2, Integer.valueOf(i16));
                return;
            }
            this.lock = new Object();
            this.f194881id = i3;
            this.createTime = j3;
            this.maleWordingList = list;
            this.femaleWordingList = list2;
            this.lastIndex = i16;
        }
    }
}
