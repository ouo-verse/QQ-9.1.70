package com.tencent.mobileqq.shortvideo;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.av.utils.ba;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes18.dex */
public class PtvTemplateManager {
    private static boolean E;

    /* renamed from: t, reason: collision with root package name */
    public static String f287624t;

    /* renamed from: u, reason: collision with root package name */
    public static String f287625u;

    /* renamed from: v, reason: collision with root package name */
    public static String f287626v;

    /* renamed from: w, reason: collision with root package name */
    public static File f287627w;

    /* renamed from: x, reason: collision with root package name */
    public static File f287628x;

    /* renamed from: z, reason: collision with root package name */
    static PtvTemplateManager f287630z;

    /* renamed from: d, reason: collision with root package name */
    public PtvTemplateInfo f287634d;

    /* renamed from: i, reason: collision with root package name */
    String f287639i;

    /* renamed from: j, reason: collision with root package name */
    String f287640j;

    /* renamed from: k, reason: collision with root package name */
    String f287641k;

    /* renamed from: s, reason: collision with root package name */
    public static final Long f287623s = 60000L;

    /* renamed from: y, reason: collision with root package name */
    static Object f287629y = new Object();
    public static String A = "5";
    public static String B = "200";
    public static String C = "20";
    public static boolean D = false;

    /* renamed from: c, reason: collision with root package name */
    ArrayList<PtvTemplateInfo> f287633c = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<VideoMaterial> f287635e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    Object f287636f = new Object();

    /* renamed from: g, reason: collision with root package name */
    Object f287637g = new Object();

    /* renamed from: h, reason: collision with root package name */
    Object f287638h = new Object();

    /* renamed from: l, reason: collision with root package name */
    public boolean f287642l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f287643m = false;

    /* renamed from: n, reason: collision with root package name */
    public boolean f287644n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f287645o = false;

    /* renamed from: p, reason: collision with root package name */
    ArrayList<PtvTemplateInfo> f287646p = new ArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    public boolean f287647q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f287648r = false;

    /* renamed from: a, reason: collision with root package name */
    ArrayList<PtvTemplateInfo> f287631a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    ArrayList<PtvTemplateInfo> f287632b = new ArrayList<>();

    /* renamed from: com.tencent.mobileqq.shortvideo.PtvTemplateManager$10, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ PtvTemplateManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.g();
        }
    }

    /* renamed from: com.tencent.mobileqq.shortvideo.PtvTemplateManager$11, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass11 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ File f287651d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f287652e;
        final /* synthetic */ PtvTemplateManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            PtvTemplateInfo u16;
            ArrayList<DoodleInfo> arrayList;
            String r16 = PtvTemplateManager.r(this.f287651d);
            if (!TextUtils.isEmpty(r16) && (u16 = PtvTemplateManager.u(r16)) != null && (arrayList = u16.doodleInfos) != null && !arrayList.isEmpty()) {
                this.this$0.f287635e.clear();
                synchronized (this.this$0.f287638h) {
                    this.this$0.f287634d = u16;
                }
                if (this.f287652e && com.tencent.mobileqq.shortvideo.util.f.m()) {
                    this.this$0.v();
                }
                this.this$0.s();
            }
        }
    }

    /* renamed from: com.tencent.mobileqq.shortvideo.PtvTemplateManager$15, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass15 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f287656d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f287657e;
        final /* synthetic */ PtvTemplateManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            List<PtvTemplateInfo> t16;
            boolean z16;
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[3];
                if (this.f287656d != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                objArr[0] = Boolean.valueOf(z16);
                objArr[1] = Boolean.valueOf(this.this$0.f287647q);
                objArr[2] = Integer.valueOf(hashCode());
                QLog.i("PtvTemplateManager", 2, String.format("initBlessSpecialPendantConfigInfo, app[%s], isUpdateedByServer[%s], cur_runnable[%s]", objArr));
            }
            if (this.this$0.f287647q) {
                return;
            }
            String r16 = PtvTemplateManager.r(this.f287657e);
            if (!TextUtils.isEmpty(r16) && (t16 = PtvTemplateManager.t(this.this$0, r16)) != null && !t16.isEmpty()) {
                for (PtvTemplateInfo ptvTemplateInfo : t16) {
                    if (ptvTemplateInfo != null) {
                        ptvTemplateInfo.usable = this.this$0.q(ptvTemplateInfo);
                        ptvTemplateInfo.businessID = 1;
                    }
                }
                synchronized (this.this$0.f287646p) {
                    PtvTemplateManager ptvTemplateManager = this.this$0;
                    if (ptvTemplateManager.f287647q) {
                        return;
                    }
                    ptvTemplateManager.f287646p.clear();
                    this.this$0.f287646p.addAll(t16);
                    PtvTemplateManager ptvTemplateManager2 = this.this$0;
                    ptvTemplateManager2.f287648r = true;
                    ptvTemplateManager2.s();
                }
            }
        }
    }

    /* renamed from: com.tencent.mobileqq.shortvideo.PtvTemplateManager$2, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f287659d;
        final /* synthetic */ PtvTemplateManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.e(this.f287659d);
        }
    }

    /* renamed from: com.tencent.mobileqq.shortvideo.PtvTemplateManager$6, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass6 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f287664d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f287665e;
        final /* synthetic */ PtvTemplateManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isDevelopLevel()) {
                QLog.d("PtvTemplateManager", 4, String.format("rebuildTemplateInfos, runnable[%s]", Integer.valueOf(hashCode())));
            }
            List<PtvTemplateInfo> x16 = this.this$0.x(this.f287664d, this.f287665e, null);
            if (x16 != null) {
                synchronized (this.this$0.f287636f) {
                    PtvTemplateManager ptvTemplateManager = this.this$0;
                    if (ptvTemplateManager.f287642l) {
                        return;
                    }
                    ptvTemplateManager.f287631a.clear();
                    this.this$0.f287631a.addAll(x16);
                    this.this$0.f287644n = true;
                    AppInterface appInterface = this.f287664d;
                    if (appInterface != null && (appInterface instanceof QQAppInterface) && com.tencent.mobileqq.shortvideo.util.f.m()) {
                        PtvTemplateManager ptvTemplateManager2 = this.this$0;
                        ptvTemplateManager2.w(ptvTemplateManager2.f287631a);
                    }
                    this.this$0.s();
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("PtvTemplateManager", 4, String.format("rebuildTemplateInfos, [%s] finished", Integer.valueOf(hashCode())));
            }
        }
    }

    /* renamed from: com.tencent.mobileqq.shortvideo.PtvTemplateManager$7, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass7 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f287666d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f287667e;
        final /* synthetic */ PtvTemplateManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isDevelopLevel()) {
                QLog.d("PtvTemplateManager", 4, String.format("rebuildWebTemplateInfos, runnable[%s]", Integer.valueOf(hashCode())));
            }
            List<PtvTemplateInfo> x16 = this.this$0.x(this.f287666d, this.f287667e, null);
            if (x16 != null) {
                synchronized (this.this$0.f287637g) {
                    PtvTemplateManager ptvTemplateManager = this.this$0;
                    if (ptvTemplateManager.f287643m) {
                        return;
                    }
                    ptvTemplateManager.f287632b.clear();
                    this.this$0.f287632b.addAll(x16);
                    this.this$0.f287644n = true;
                    AppInterface appInterface = this.f287666d;
                    if (appInterface != null && (appInterface instanceof QQAppInterface) && com.tencent.mobileqq.shortvideo.util.f.m()) {
                        PtvTemplateManager ptvTemplateManager2 = this.this$0;
                        ptvTemplateManager2.w(ptvTemplateManager2.f287632b);
                    }
                    this.this$0.s();
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("PtvTemplateManager", 4, String.format("rebuildWebTemplateInfos, [%s] finished", Integer.valueOf(hashCode())));
            }
        }
    }

    /* loaded from: classes18.dex */
    public static class DoodleInfo {
        public String doodleId;
        public String doodleMd5;
        public String doodleName;
        public String doodleUrl;
        public boolean doodleUsable;

        public String toString() {
            return "PtvTemplateInfo{id='" + this.doodleId + "', doodleName='" + this.doodleName + "', doodleUsable='" + this.doodleUsable + "'}";
        }
    }

    static {
        File filesDir;
        f287624t = "ptv_template_usable";
        f287625u = "ptv_debug";
        f287626v = "ptv_template_usable_doodle";
        boolean z16 = false;
        E = false;
        if (BaseApplication.getContext().getExternalFilesDir(null) != null && BaseApplication.getContext().getExternalCacheDir() != null) {
            z16 = true;
        }
        if (z16) {
            filesDir = BaseApplication.getContext().getExternalFilesDir(null);
        } else {
            filesDir = BaseApplication.getContext().getFilesDir();
        }
        f287627w = new File(filesDir, "ptv_template");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(f287627w.getPath());
        String str = File.separator;
        sb5.append(str);
        sb5.append(f287624t);
        sb5.append(str);
        f287624t = sb5.toString();
        f287625u = f287627w.getPath() + str + f287625u;
        f287628x = new File(filesDir, "doodle_template");
        f287626v = f287628x.getPath() + str + f287626v + str;
        E = ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProductFeatureRom(com.tencent.aelight.camera.constants.a.F);
    }

    PtvTemplateManager(AppInterface appInterface) {
    }

    public static void f() {
        synchronized (f287629y) {
            if (f287630z != null) {
                f287630z = null;
            }
        }
    }

    public static PtvTemplateManager h(AppInterface appInterface) {
        PtvTemplateManager ptvTemplateManager = f287630z;
        if (ptvTemplateManager != null) {
            return ptvTemplateManager;
        }
        synchronized (f287629y) {
            PtvTemplateManager ptvTemplateManager2 = f287630z;
            if (ptvTemplateManager2 != null) {
                return ptvTemplateManager2;
            }
            PtvTemplateManager ptvTemplateManager3 = new PtvTemplateManager(appInterface);
            f287630z = ptvTemplateManager3;
            return ptvTemplateManager3;
        }
    }

    public static boolean n() {
        return new File(f287627w, "ptv_template_bless.cfg").exists();
    }

    public static boolean o() {
        return new File(f287628x, "doodle_template_new.cfg").exists();
    }

    public static String r(File file) {
        byte[] fileToBytes = FileUtils.fileToBytes(file);
        if (fileToBytes == null || fileToBytes.length <= 0) {
            return null;
        }
        try {
            return new String(fileToBytes, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            if (!QLog.isDevelopLevel()) {
                return null;
            }
            e16.printStackTrace();
            return null;
        }
    }

    static List<PtvTemplateInfo> t(PtvTemplateManager ptvTemplateManager, String str) {
        JSONArray jSONArray;
        List<PtvTemplateInfo> convertFrom;
        if (QLog.isColorLevel()) {
            QLog.i("PtvTemplateManager", 2, "parse config: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("content")) {
                jSONArray = jSONObject.getJSONArray("content");
            } else {
                jSONArray = null;
            }
            if (ptvTemplateManager != null) {
                try {
                    if (jSONObject.has("guide_video_url")) {
                        ptvTemplateManager.f287639i = jSONObject.getString("guide_video_url");
                    }
                    if (jSONObject.has("guide_video_md5")) {
                        ptvTemplateManager.f287640j = jSONObject.getString("guide_video_md5");
                    }
                    if (jSONObject.has("version")) {
                        ptvTemplateManager.f287641k = jSONObject.getString("version");
                    }
                } catch (JSONException e16) {
                    e = e16;
                    if (QLog.isColorLevel()) {
                        e.printStackTrace();
                    }
                    if (jSONArray != null) {
                        return null;
                    }
                    return convertFrom;
                }
            }
            if (jSONObject.has("gestureGapFrame")) {
                A = jSONObject.getString("gestureGapFrame");
            }
            if (jSONObject.has("gestureGapTime")) {
                B = jSONObject.getString("gestureGapTime");
            }
            if (jSONObject.has("gesturethreadcoldtime")) {
                C = jSONObject.getString("gesturethreadcoldtime");
            }
            if (jSONObject.has("gestureShouldUpload")) {
                D = jSONObject.getBoolean("gestureShouldUpload");
            }
        } catch (JSONException e17) {
            e = e17;
            jSONArray = null;
        }
        if (jSONArray != null || (convertFrom = PtvTemplateInfo.convertFrom(jSONArray)) == null || convertFrom.isEmpty()) {
            return null;
        }
        return convertFrom;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d A[Catch: JSONException -> 0x007d, TryCatch #2 {JSONException -> 0x007d, blocks: (B:14:0x0036, B:17:0x003d, B:19:0x0047, B:21:0x0055), top: B:13:0x0036 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static PtvTemplateInfo u(String str) {
        PtvTemplateInfo ptvTemplateInfo;
        JSONArray jSONArray;
        int length;
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
            ptvTemplateInfo = (PtvTemplateInfo) JSONUtils.b(jSONObject, PtvTemplateInfo.class);
        } catch (JSONException e16) {
            e = e16;
            ptvTemplateInfo = null;
        }
        try {
        } catch (JSONException e17) {
            e = e17;
            if (QLog.isColorLevel()) {
                e.printStackTrace();
            }
            jSONArray = null;
            if (jSONArray != null) {
            }
            return null;
        }
        if (jSONObject.has("doodleinfo")) {
            jSONArray = jSONObject.getJSONArray("doodleinfo");
            if (jSONArray != null && ptvTemplateInfo != null) {
                try {
                    length = jSONArray.length();
                    if (length > 0) {
                        return null;
                    }
                    ptvTemplateInfo.doodleInfos = new ArrayList<>(length);
                    for (int i3 = 0; i3 < length; i3++) {
                        DoodleInfo doodleInfo = (DoodleInfo) JSONUtils.b(jSONArray.getJSONObject(i3), DoodleInfo.class);
                        if (doodleInfo != null) {
                            ptvTemplateInfo.doodleInfos.add(doodleInfo);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "parseDoodleConfig|templateInfo= " + ptvTemplateInfo);
                    }
                    return ptvTemplateInfo;
                } catch (JSONException e18) {
                    if (QLog.isDevelopLevel()) {
                        e18.printStackTrace();
                    }
                }
            }
            return null;
        }
        jSONArray = null;
        if (jSONArray != null) {
            length = jSONArray.length();
            if (length > 0) {
            }
        }
        return null;
    }

    static void y(final String str, final String str2) {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.PtvTemplateManager.1
            @Override // java.lang.Runnable
            public void run() {
                FileUtils.writeFile(PtvTemplateManager.f287627w.getPath() + File.separator, str2, str);
                if (QLog.isColorLevel()) {
                    QLog.i("PtvTemplateManager", 2, "save Config to file finish.");
                }
            }
        });
    }

    void c(QQAppInterface qQAppInterface, final ArrayList<PtvTemplateInfo> arrayList) {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.PtvTemplateManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.tencent.mobileqq.shortvideo.util.f.m()) {
                    PtvTemplateManager.this.w(arrayList);
                }
            }
        }, f287623s.longValue());
    }

    public void d() {
        synchronized (this.f287638h) {
            this.f287634d = null;
            this.f287635e.clear();
            File file = new File(f287628x, "doodle_template_new.cfg");
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public List<VideoMaterial> g() {
        return this.f287635e;
    }

    public QQAppInterface i() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    public ArrayList<PtvTemplateInfo> j() {
        return this.f287633c;
    }

    public void k(final String str, QQAppInterface qQAppInterface) {
        PtvTemplateInfo u16 = u(str);
        if (u16 == null) {
            return;
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.PtvTemplateManager.12
            @Override // java.lang.Runnable
            public void run() {
                FileUtils.writeFile(PtvTemplateManager.f287628x.getPath() + File.separator, "doodle_template_new.cfg", str);
                if (QLog.isColorLevel()) {
                    QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "save Config to file finish.");
                }
            }
        });
        synchronized (this.f287638h) {
            this.f287634d = u16;
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.PtvTemplateManager.13
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles;
                boolean z16;
                File file = PtvTemplateManager.f287628x;
                if (file != null && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        if (file2 != null && file2.isFile()) {
                            String name = file2.getName();
                            if (!TextUtils.isEmpty(name) && !name.contains(".")) {
                                Iterator<DoodleInfo> it = PtvTemplateManager.this.f287634d.doodleInfos.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        DoodleInfo next = it.next();
                                        if (next != null && !TextUtils.isEmpty(next.doodleName) && file2.getName().equalsIgnoreCase(next.doodleName)) {
                                            z16 = true;
                                            break;
                                        }
                                    } else {
                                        z16 = false;
                                        break;
                                    }
                                }
                                if (!z16) {
                                    file2.deleteOnExit();
                                    new File(PtvTemplateManager.f287626v + file2.getName()).deleteOnExit();
                                }
                            }
                        }
                    }
                }
            }
        });
        v();
    }

    public void l(String str, QQAppInterface qQAppInterface) {
        final List<PtvTemplateInfo> t16 = t(null, str);
        if (t16 != null && !t16.isEmpty()) {
            y(str, "ptv_template_bless.cfg");
            for (PtvTemplateInfo ptvTemplateInfo : t16) {
                if (ptvTemplateInfo != null) {
                    ptvTemplateInfo.usable = q(ptvTemplateInfo);
                    ptvTemplateInfo.businessID = 1;
                }
            }
            synchronized (this.f287646p) {
                this.f287646p.clear();
                this.f287646p.addAll(t16);
                this.f287647q = true;
            }
            if (this.f287648r) {
                return;
            }
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.PtvTemplateManager.16
                @Override // java.lang.Runnable
                public void run() {
                    PtvTemplateManager.this.e(t16);
                }
            });
            c(qQAppInterface, this.f287646p);
        }
    }

    public void m(final Runnable runnable) {
        boolean z16;
        Runnable runnable2 = new Runnable() { // from class: com.tencent.mobileqq.shortvideo.PtvTemplateManager.5
            @Override // java.lang.Runnable
            public void run() {
                List<PtvTemplateInfo> t16;
                boolean z17 = false;
                if (QLog.isColorLevel()) {
                    QLog.i("PtvTemplateManager", 2, String.format("\u53cc\u4eba\u6302\u4ef6\u52a0\u8f7d start, rebuildTemplateInfos, runnable[%s]", Integer.valueOf(hashCode())));
                }
                String str = QAVConfig.e(106).f448490b;
                if (!TextUtils.isEmpty(str) && (t16 = PtvTemplateManager.t(PtvTemplateManager.this, str)) != null && !t16.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    int qQVersion = ba.getQQVersion();
                    if (QLog.isColorLevel()) {
                        QLog.d("PtvTemplateManager", 2, "cur version:" + qQVersion);
                    }
                    for (PtvTemplateInfo ptvTemplateInfo : t16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PtvTemplateManager", 2, String.format("the pandent[%s], platform[%s]", ptvTemplateInfo.f287668id, Integer.valueOf(ptvTemplateInfo.platform)));
                        }
                        int i3 = ptvTemplateInfo.platform;
                        if (i3 != 0 && qQVersion < i3) {
                            if (QLog.isDevelopLevel()) {
                                QLog.d("PtvTemplateManager", 4, String.format("\u53cc\u4eba\u6302\u4ef6\u52a0\u8f7d, platform\u4e0d\u7b26\u5408, %s", ptvTemplateInfo));
                            }
                        } else {
                            ptvTemplateInfo.usable = PtvTemplateManager.this.q(ptvTemplateInfo);
                            arrayList.add(ptvTemplateInfo);
                        }
                    }
                    if (QLog.isDevelopLevel()) {
                        Object[] objArr = new Object[3];
                        objArr[0] = Integer.valueOf(arrayList.size());
                        if (runnable != null) {
                            z17 = true;
                        }
                        objArr[1] = Boolean.valueOf(z17);
                        objArr[2] = PtvTemplateManager.this.f287641k;
                        QLog.d("PtvTemplateManager", 2, String.format("\u53cc\u4eba\u6302\u4ef6\u52a0\u8f7d size[%s], onInitFinishSink[%s], mVersion[%s]", objArr));
                    }
                    synchronized (PtvTemplateManager.this.f287633c) {
                        QLog.w("PtvTemplateManager", 1, "initLocalTemplateConfigInfoWithExtra, isEmpty[" + PtvTemplateManager.this.f287633c.isEmpty() + "], size[" + arrayList.size() + "]");
                        PtvTemplateManager.this.f287633c.clear();
                        PtvTemplateManager.this.f287633c.addAll(arrayList);
                    }
                    Runnable runnable3 = runnable;
                    if (runnable3 != null) {
                        runnable3.run();
                    }
                }
            }
        };
        if (QLog.isDevelopLevel()) {
            Object[] objArr = new Object[2];
            if (runnable != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            objArr[1] = Integer.valueOf(runnable2.hashCode());
            QLog.d("PtvTemplateManager", 2, String.format("\u53cc\u4eba\u6302\u4ef6\u52a0\u8f7d, onInitFinishSink[%s], runnable[%s]", objArr));
        }
        ThreadManagerV2.postImmediately(runnable2, null, false);
    }

    public boolean p(DoodleInfo doodleInfo, boolean z16) {
        if (doodleInfo != null && !TextUtils.isEmpty(doodleInfo.doodleName)) {
            File file = new File(f287628x, doodleInfo.doodleName);
            if (!file.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "isDoodleTemplateUsable|file is not exist -> " + doodleInfo.doodleName);
                }
                return false;
            }
            try {
                String calcMd5 = FileUtils.calcMd5(file.getPath());
                if (TextUtils.isEmpty(calcMd5) || !calcMd5.equalsIgnoreCase(doodleInfo.doodleMd5)) {
                    return false;
                }
                if (z16) {
                    if (!new File(f287626v + doodleInfo.doodleName + File.separator, IVideoFilterTools.CONFIG_FILE).exists()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "isDoodleTemplateUsable|paramFile is not exist->>" + doodleInfo.doodleName);
                        }
                        try {
                            ZipUtils.unZipFile(new File(f287628x, doodleInfo.doodleName), f287626v);
                            if (QLog.isColorLevel()) {
                                QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "isDoodleTemplateUsable|unZipFile->>" + doodleInfo.doodleName);
                            }
                            return true;
                        } catch (IOException e16) {
                            if (QLog.isColorLevel()) {
                                e16.printStackTrace();
                            }
                            return false;
                        }
                    }
                }
                return true;
            } catch (UnsatisfiedLinkError e17) {
                if (QLog.isColorLevel()) {
                    e17.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean q(PtvTemplateInfo ptvTemplateInfo) {
        if (ptvTemplateInfo != null && !TextUtils.isEmpty(ptvTemplateInfo.name)) {
            File file = new File(f287627w, ptvTemplateInfo.name);
            if (!file.exists()) {
                return false;
            }
            try {
                String calcMd5 = FileUtils.calcMd5(file.getPath());
                if (TextUtils.isEmpty(calcMd5) || !calcMd5.equalsIgnoreCase(ptvTemplateInfo.md5)) {
                    return false;
                }
                String str = f287624t + ptvTemplateInfo.name + File.separator;
                File file2 = new File(str, IVideoFilterTools.CONFIG_FILE);
                File file3 = new File(str, "params.dat");
                if (file2.exists() || file3.exists()) {
                    return true;
                }
                try {
                    ZipUtils.unZipFile(new File(f287627w, ptvTemplateInfo.name), f287624t);
                    return true;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        e16.printStackTrace();
                    }
                    return false;
                }
            } catch (UnsatisfiedLinkError e17) {
                if (QLog.isColorLevel()) {
                    e17.printStackTrace();
                }
            }
        }
        return false;
    }

    void v() {
        QQAppInterface i3 = i();
        PtvTemplateInfo ptvTemplateInfo = this.f287634d;
        if (ptvTemplateInfo != null && !ptvTemplateInfo.doodleInfos.isEmpty() && i3 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "preDownloadDoodleTemplate!");
            }
            Iterator<DoodleInfo> it = this.f287634d.doodleInfos.iterator();
            while (it.hasNext()) {
                final DoodleInfo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.doodleUrl) && !next.doodleUsable) {
                    Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.shortvideo.PtvTemplateManager.14
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PtvTemplateManager.this.p(next, true)) {
                                next.doodleUsable = true;
                                return;
                            }
                            QQAppInterface i16 = PtvTemplateManager.this.i();
                            if (i16 == null) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "reqApp:" + i16);
                                    return;
                                }
                                return;
                            }
                            HttpNetReq httpNetReq = new HttpNetReq();
                            httpNetReq.mCallback = new a();
                            httpNetReq.mReqUrl = next.doodleUrl;
                            httpNetReq.mHttpMethod = 0;
                            httpNetReq.mOutPath = new File(PtvTemplateManager.f287628x, next.doodleName).getPath();
                            httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                            ((IHttpEngineService) i16.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                            if (QLog.isColorLevel()) {
                                QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "startDownloadTemplate, url: " + next.doodleUrl);
                            }
                        }

                        /* renamed from: com.tencent.mobileqq.shortvideo.PtvTemplateManager$14$a */
                        /* loaded from: classes18.dex */
                        class a implements INetEngineListener {
                            a() {
                            }

                            @Override // com.tencent.mobileqq.transfile.INetEngineListener
                            public void onResp(NetResp netResp) {
                                QQAppInterface i3;
                                if (QLog.isColorLevel()) {
                                    QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "onResp url: " + next.doodleUrl + " resultcode: " + netResp.mHttpCode);
                                }
                                AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                                DoodleInfo doodleInfo = next;
                                doodleInfo.doodleUsable = PtvTemplateManager.this.p(doodleInfo, false);
                                if (next.doodleUsable) {
                                    try {
                                        ZipUtils.unZipFile(new File(PtvTemplateManager.f287628x, next.doodleName), PtvTemplateManager.f287626v);
                                    } catch (IOException e16) {
                                        if (QLog.isColorLevel()) {
                                            e16.printStackTrace();
                                        }
                                    }
                                }
                                if (netResp.mResult == 0 && (i3 = PtvTemplateManager.this.i()) != null) {
                                    IPreDownloadController iPreDownloadController = (IPreDownloadController) i3.getRuntimeService(IPreDownloadController.class);
                                    if (iPreDownloadController.isEnable()) {
                                        iPreDownloadController.preDownloadSuccess(next.doodleUrl, netResp.mTotalFileLen);
                                    }
                                }
                            }

                            @Override // com.tencent.mobileqq.transfile.INetEngineListener
                            public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
                            }
                        }
                    };
                    IPreDownloadController iPreDownloadController = (IPreDownloadController) i3.getRuntimeService(IPreDownloadController.class);
                    if (iPreDownloadController.isEnable()) {
                        iPreDownloadController.requestPreDownload(10020, null, next.doodleName, 0, next.doodleUrl, new File(f287628x, next.doodleName).getPath(), 2, 0, true, new RunnableTask(i3, "qq_doodle_res", runnable, 4000L));
                    } else {
                        ThreadManagerV2.post(runnable, 8, null, true);
                    }
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "Exception!");
        }
    }

    void w(ArrayList<PtvTemplateInfo> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                final PtvTemplateInfo ptvTemplateInfo = arrayList.get(i3);
                if (ptvTemplateInfo != null && ptvTemplateInfo.predownload && !TextUtils.isEmpty(ptvTemplateInfo.resurl)) {
                    ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.PtvTemplateManager.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PtvTemplateManager.this.q(ptvTemplateInfo)) {
                                ptvTemplateInfo.usable = true;
                                return;
                            }
                            ptvTemplateInfo.usable = false;
                            QQAppInterface i16 = PtvTemplateManager.this.i();
                            if (i16 == null) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("PtvTemplateManager", 2, "preDownloadTemplates  null!");
                                    return;
                                }
                                return;
                            }
                            HttpNetReq httpNetReq = new HttpNetReq();
                            httpNetReq.mCallback = new a();
                            httpNetReq.mReqUrl = ptvTemplateInfo.resurl;
                            httpNetReq.mHttpMethod = 0;
                            httpNetReq.mOutPath = new File(PtvTemplateManager.f287627w, ptvTemplateInfo.name).getPath();
                            httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                            ((IHttpEngineService) i16.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                            if (QLog.isColorLevel()) {
                                QLog.i("PtvTemplateManager", 2, "startDownloadTemplate, url: " + ptvTemplateInfo.resurl);
                            }
                        }

                        /* renamed from: com.tencent.mobileqq.shortvideo.PtvTemplateManager$4$a */
                        /* loaded from: classes18.dex */
                        class a implements INetEngineListener {
                            a() {
                            }

                            @Override // com.tencent.mobileqq.transfile.INetEngineListener
                            public void onResp(NetResp netResp) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("PtvTemplateManager", 2, "onResp url: " + ptvTemplateInfo.resurl + " resultcode: " + netResp.mHttpCode);
                                }
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                PtvTemplateInfo ptvTemplateInfo = ptvTemplateInfo;
                                ptvTemplateInfo.usable = PtvTemplateManager.this.q(ptvTemplateInfo);
                                if (ptvTemplateInfo.usable) {
                                    try {
                                        ZipUtils.unZipFile(new File(PtvTemplateManager.f287627w, ptvTemplateInfo.name), PtvTemplateManager.f287624t);
                                    } catch (IOException e16) {
                                        if (QLog.isColorLevel()) {
                                            e16.printStackTrace();
                                        }
                                    }
                                }
                            }

                            @Override // com.tencent.mobileqq.transfile.INetEngineListener
                            public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
                            }
                        }
                    });
                }
            }
        }
    }

    List<PtvTemplateInfo> x(AppInterface appInterface, File file, HashMap<String, PtvTemplateInfo> hashMap) {
        List<PtvTemplateInfo> t16;
        boolean z16;
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[3];
            if (appInterface != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            objArr[1] = Boolean.valueOf(this.f287642l);
            objArr[2] = Integer.valueOf(hashCode());
            QLog.i("PtvTemplateManager", 2, String.format("rebuildTemplateInfos, app[%s], isUpdateedByServer[%s], cur_runnable[%s]", objArr));
        }
        if (this.f287642l) {
            return null;
        }
        String r16 = r(file);
        if (TextUtils.isEmpty(r16) || (t16 = t(this, r16)) == null || t16.isEmpty()) {
            return null;
        }
        for (PtvTemplateInfo ptvTemplateInfo : t16) {
            if (ptvTemplateInfo != null) {
                ptvTemplateInfo.usable = q(ptvTemplateInfo);
                if (hashMap != null) {
                    hashMap.put(ptvTemplateInfo.f287668id, ptvTemplateInfo);
                }
            }
        }
        return t16;
    }

    /* loaded from: classes18.dex */
    public static class PtvTemplateInfo {
        public static final int Category_BeautyMakeup = 3;
        public static final int Category_Face = 0;
        public static final int Category_FaceAndGesture = 2;
        public static final int Category_Gesture = 1;
        public static final int DOODLE = 1;
        public static int FUNC_REDBAG_GET = 1;
        public static final int LBS_MACDONALD = 1;
        public static final int LBS_NORMAL_FILTER = 0;
        public static final int NORMAL = 0;
        static final String SV_FILTER_DOWNLOAD_TIME = "sv_filter_download_time";
        public String advertiseIconUrl;
        public String advertiseStr;
        public String advertiseWebUrl;
        public boolean advertisement;
        public String androidopenurlheader;
        public String badgeurl;
        public boolean bigHeadModelUsable;
        public String buttonbgcolor;
        public int categoryId;
        public String categoryName;
        public int color;
        public String dgModelName;
        public String dgModelResmd5;
        public String dgModelResurl;
        public boolean dgModelUsable;
        public String dgStageName;
        public String dgStageResmd5;
        public String dgStageResurl;
        public boolean dgStageUsable;
        public ArrayList<DoodleInfo> doodleInfos;
        public boolean downloading;
        public String filtername;
        public String iconurl;

        /* renamed from: id, reason: collision with root package name */
        public String f287668id;
        public boolean isAdvertise;
        public String md5;
        public String name;
        public boolean needRedDot;
        public String openurl;
        public String popupbtn;
        public String popupbtn2;
        public String popupcontent;
        public String popupcontent2;
        public String popupimgurl;
        public boolean predownload;
        public String resurl;
        long startDownloadTime;
        public String storeurl;
        public long totalLen;
        public int type;
        public boolean usable;
        public int platform = 0;
        public int businessID = 0;
        public boolean renderfirst = true;
        public boolean isshow = true;
        public boolean isSelected = false;
        public int templateStyle = 0;
        public int kind = 0;
        public int activityType = 0;
        public int category = 0;
        public String gestureType = "";
        public String gestureWording = "";
        public int funcType = 0;
        public double sizeFree = 0.0d;
        public boolean popup = true;
        public String bigHeadName = "";
        public String bigHeadUrl = "";
        public String bigHeadMd5 = "";

        public static List<PtvTemplateInfo> convertFrom(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return convertFrom(new JSONArray(str));
            } catch (JSONException e16) {
                if (QLog.isDevelopLevel()) {
                    e16.printStackTrace();
                }
                return null;
            }
        }

        public static boolean isFace(int i3) {
            if (i3 != 2 && i3 != 0) {
                return false;
            }
            return true;
        }

        public static boolean isGesture(int i3) {
            if (i3 == 2 || i3 == 1) {
                return true;
            }
            return false;
        }

        public void doDownloadDataReport() {
            long currentTimeMillis = System.currentTimeMillis() - this.startDownloadTime;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("MANUFACTURER", Build.MANUFACTURER);
            hashMap.put("MODEL", DeviceInfoMonitor.getModel());
            hashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
            hashMap.put("timems", "" + currentTimeMillis);
            hashMap.put("totalsize", "" + this.totalLen);
            hashMap.put("success", "" + this.usable);
            StatisticCollector.getInstance(VideoEnvironment.getContext()).collectPerformance(null, SV_FILTER_DOWNLOAD_TIME, true, 0L, 0L, hashMap, "");
        }

        public String getLbsActivityType(int i3) {
            if (i3 != 1) {
                return "LBS_NORMAL_FILTER_" + i3;
            }
            return "LBS_MACDONALD_" + i3;
        }

        public boolean hasFace() {
            return isFace(this.category);
        }

        public boolean hasGesture() {
            return isGesture(this.category);
        }

        public String toString() {
            return "PtvTemplateInfo{id='" + this.f287668id + "', name='" + this.name + "', dooleInfos=" + this.doodleInfos + "',usable=" + this.usable + '}';
        }

        public static List<PtvTemplateInfo> convertFrom(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            try {
                int length = jSONArray.length();
                if (length <= 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(length);
                for (int i3 = 0; i3 < length; i3++) {
                    PtvTemplateInfo ptvTemplateInfo = (PtvTemplateInfo) JSONUtils.b(jSONArray.getJSONObject(i3), PtvTemplateInfo.class);
                    if (ptvTemplateInfo != null) {
                        try {
                            Long.parseLong(ptvTemplateInfo.f287668id);
                            int i16 = ptvTemplateInfo.kind;
                            if (i16 == 0) {
                                arrayList.add(ptvTemplateInfo);
                            } else if (i16 != 1) {
                                if (i16 == 2) {
                                    arrayList.add(ptvTemplateInfo);
                                } else if (i16 != 3 && i16 != 4) {
                                    arrayList.add(ptvTemplateInfo);
                                } else {
                                    arrayList.add(ptvTemplateInfo);
                                }
                            } else if (!PtvTemplateManager.E) {
                                arrayList.add(ptvTemplateInfo);
                            }
                        } catch (Exception unused) {
                            if (QLog.isColorLevel()) {
                                QLog.e("PtvTemplateManager", 1, "templateId must be a numeric string!");
                            }
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e16) {
                if (QLog.isDevelopLevel()) {
                    e16.printStackTrace();
                }
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
    }

    void e(List<PtvTemplateInfo> list) {
    }
}
