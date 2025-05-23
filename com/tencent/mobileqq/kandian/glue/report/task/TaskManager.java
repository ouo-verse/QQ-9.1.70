package com.tencent.mobileqq.kandian.glue.report.task;

import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.glue.report.task.JSContext;
import com.tencent.mobileqq.kandian.glue.report.task.TaskOfflineUtils;
import com.tencent.mobileqq.kandian.glue.report.task.a;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.measure.utils.MeasureConst;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class TaskManager {

    /* renamed from: d, reason: collision with root package name */
    private static String f239884d = null;

    /* renamed from: e, reason: collision with root package name */
    private static String f239885e = null;

    /* renamed from: f, reason: collision with root package name */
    private static String f239886f = null;

    /* renamed from: g, reason: collision with root package name */
    private static String f239887g = null;

    /* renamed from: h, reason: collision with root package name */
    private static String f239888h = null;

    /* renamed from: i, reason: collision with root package name */
    private static String f239889i = null;

    /* renamed from: j, reason: collision with root package name */
    public static int f239890j = -1;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f239891k = false;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f239892l = false;

    /* renamed from: m, reason: collision with root package name */
    private static long f239893m = 0;

    /* renamed from: n, reason: collision with root package name */
    private static long f239894n = 3600000;

    /* renamed from: o, reason: collision with root package name */
    private static TaskManager f239895o = new TaskManager();

    /* renamed from: p, reason: collision with root package name */
    private static List<String> f239896p;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.kandian.glue.report.task.a> f239897a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private boolean f239898b = false;

    /* renamed from: c, reason: collision with root package name */
    private INetInfoHandler f239899c = new k();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.kandian.glue.report.task.TaskManager$7, reason: invalid class name */
    /* loaded from: classes33.dex */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ TaskManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            QLog.d("kandianreport.taskmanager", 1, "reset");
            this.this$0.d0();
            FileUtils.deleteDirectory(TaskManager.f239884d);
            FileUtils.deleteDirectory(KandianReportSoLoader.m());
            com.tencent.mobileqq.kandian.base.utils.c.e("kandianreport_ON", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements JSContext.a {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements JSContext.a {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class c implements JSContext.a {
        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d implements JSContext.a {
        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class e implements JSContext.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.kandian.glue.report.task.a f239916a;

        e(com.tencent.mobileqq.kandian.glue.report.task.a aVar) {
            this.f239916a = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class f implements JSContext.a {
        f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class g implements JSContext.a {
        g() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class h implements JSContext.a {
        h() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class i implements JSContext.a {
        i() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class j implements JSContext.a {
        j() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class k implements INetInfoHandler {
        k() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            TaskManager.this.j(TaskManager.E("NONE"));
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            TaskManager.this.j(TaskManager.E(Global.TRACKING_WIFI));
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            TaskManager.this.j(TaskManager.E("WWAN"));
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            TaskManager.this.j(TaskManager.E(Global.TRACKING_WIFI));
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            TaskManager.this.j(TaskManager.E("WWAN"));
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            TaskManager.this.j(TaskManager.E("NONE"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class l implements JSContext.a {
        l() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class m implements JSContext.a {
        m() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class n implements JSContext.a {
        n() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class o implements JSContext.a {
        o() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class p implements JSContext.a {
        p() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class q implements JSContext.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.kandian.glue.report.task.a f239929a;

        q(com.tencent.mobileqq.kandian.glue.report.task.a aVar) {
            this.f239929a = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class r implements JSContext.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.kandian.glue.report.task.a f239931a;

        r(com.tencent.mobileqq.kandian.glue.report.task.a aVar) {
            this.f239931a = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class s implements JSContext.a {
        s() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class t implements JSContext.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.kandian.glue.report.task.a f239934a;

        t(com.tencent.mobileqq.kandian.glue.report.task.a aVar) {
            this.f239934a = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class u implements JSContext.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.kandian.glue.report.task.a f239936a;

        u(com.tencent.mobileqq.kandian.glue.report.task.a aVar) {
            this.f239936a = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class v implements TaskOfflineUtils.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f239938a;

        v(boolean z16) {
            this.f239938a = z16;
        }

        @Override // com.tencent.mobileqq.kandian.glue.report.task.TaskOfflineUtils.b
        public void onStateChange(int i3, int i16) {
            if (i3 == 0) {
                TaskManager.f239890j = i16;
                QLog.d("kandianreport.taskmanager", 1, "download scripts success: a new version: " + TaskManager.f239890j);
                if (this.f239938a) {
                    QLog.d("kandianreport.taskmanager", 1, "startAfterDownload");
                    TaskManager.x().U();
                    return;
                }
                return;
            }
            QLog.d("kandianreport.taskmanager", 1, "download scripts fail or not update" + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class w implements JSContext.a {
        w() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class x implements JSContext.a {
        x() {
        }
    }

    static {
        try {
            f239892l = w();
            f239884d = com.tencent.biz.common.offline.c.c("3412") + "3412";
            f239885e = f239884d + "/extraction";
            f239886f = f239884d + "/process";
            f239887g = f239884d + "/distribution";
            f239888h = f239884d + "/check";
            f239889i = f239884d + "/task_config";
        } catch (Throwable th5) {
            QLog.e("kandianreport.taskmanager", 2, th5.getLocalizedMessage());
        }
    }

    TaskManager() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.report.task.TaskManager.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    boolean w3 = TaskManager.w();
                    TaskManager.f239892l = w3;
                    if (w3) {
                        QLog.d("kandianreport.taskmanager", 1, "configure is on");
                        KandianReportSoLoader.k();
                        TaskManager.this.q(false);
                    }
                } catch (Throwable th5) {
                    QLog.e("kandianreport.taskmanager", 2, th5, new Object[0]);
                }
            }
        });
    }

    private JSContext.a A(com.tencent.mobileqq.kandian.glue.report.task.a aVar) {
        return new r(aVar);
    }

    private JSContext.a B() {
        return new x();
    }

    private JSContext.a D() {
        return new j();
    }

    public static String E(String str) {
        return new JSONObject().toString();
    }

    private JSContext.a F(com.tencent.mobileqq.kandian.glue.report.task.a aVar) {
        return new e(aVar);
    }

    private void G(com.tencent.mobileqq.kandian.glue.report.task.a aVar, ArrayList<a.C7960a> arrayList, int i3) throws Exception {
        String str;
        JSContext jSContext = aVar.f239964a;
        if (i3 == com.tencent.mobileqq.kandian.glue.report.task.a.f239960p) {
            str = f239885e;
        } else if (i3 == com.tencent.mobileqq.kandian.glue.report.task.a.f239961q) {
            str = f239886f;
        } else if (i3 == com.tencent.mobileqq.kandian.glue.report.task.a.f239962r) {
            str = f239887g;
        } else if (i3 == com.tencent.mobileqq.kandian.glue.report.task.a.f239963s) {
            str = f239888h;
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<a.C7960a> it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = str + "/" + it.next().f239974b + PTSFileUtil.JS_FORMAT;
            File file = new File(str2);
            if (file.exists()) {
                StringBuffer stringBuffer = new StringBuffer();
                String readFileToString = FileUtils.readFileToString(file);
                if (jSContext != null) {
                    jSContext.a(readFileToString, stringBuffer);
                    if (!TextUtils.isEmpty(stringBuffer)) {
                        QLog.d("kandianreport.taskmanager", 1, "evaluate js exception: " + ((Object) stringBuffer));
                        com.tencent.mobileqq.kandian.glue.report.task.c.b(aVar.f239965b, "evaluate js exception: " + ((Object) stringBuffer));
                    }
                }
            } else {
                QLog.d("kandianreport.taskmanager", 2, "import js not exist: " + str2);
            }
        }
    }

    private void H(com.tencent.mobileqq.kandian.glue.report.task.a aVar) {
        JSContext jSContext = new JSContext();
        aVar.f239964a = jSContext;
        jSContext.f239871c = aVar;
        jSContext.b();
        aVar.f239964a.c("doNext", p(aVar));
        aVar.f239964a.c("setTimeout", W(aVar));
        aVar.f239964a.c("QLog", M());
        aVar.f239964a.c("getTaskId", A(aVar));
        aVar.f239964a.c("setInterval", V(aVar));
        aVar.f239964a.c("reportToServer", T());
        aVar.f239964a.c("clearInterval", m());
        aVar.f239964a.c("getPlatformInfo", z());
        aVar.f239964a.c("createRIJStorage", n());
        aVar.f239964a.c("setValueForKey", X());
        aVar.f239964a.c("getValueForKey", D());
        aVar.f239964a.c("removeKey", Q());
        aVar.f239964a.c("invalidate", I());
        aVar.f239964a.c("reportCustomEvent", R());
        aVar.f239964a.c("generateCustomData", t(aVar));
        aVar.f239964a.c("httpRequest", F(aVar));
        aVar.f239964a.c("alert", l());
        aVar.f239964a.c("getAladdinConfig", u());
        aVar.f239964a.c("decodeBase64", o());
        aVar.f239964a.c("encodeBase64", r());
        aVar.f239964a.c("getUserUin", B());
        aVar.f239964a.c("isPublicVersion", J());
        aVar.f239966c = com.tencent.mobileqq.kandian.glue.report.task.a.f239955k;
    }

    private JSContext.a I() {
        return new h();
    }

    private JSContext.a J() {
        return new w();
    }

    private boolean K(com.tencent.mobileqq.kandian.glue.report.task.a aVar) {
        int intValue = ((Integer) com.tencent.mobileqq.kandian.base.utils.c.c("kandianreport.taskmanager" + aVar.f239965b, 0)).intValue();
        return (intValue == com.tencent.mobileqq.kandian.glue.report.task.a.f239959o || intValue == com.tencent.mobileqq.kandian.glue.report.task.a.f239958n) ? false : true;
    }

    private JSContext.a M() {
        return new s();
    }

    private com.tencent.mobileqq.kandian.glue.report.task.a N(File file) throws Exception {
        return O(FileUtils.readFileContent(file));
    }

    private com.tencent.mobileqq.kandian.glue.report.task.a O(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        JSONArray optJSONArray = jSONObject.optJSONArray("filter");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("extraction");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("process");
        JSONArray optJSONArray4 = jSONObject.optJSONArray(MeasureConst.SLI_TYPE_DISTRIBUTION);
        JSONArray optJSONArray5 = jSONObject.optJSONArray("check");
        com.tencent.mobileqq.kandian.glue.report.task.a aVar = new com.tencent.mobileqq.kandian.glue.report.task.a();
        aVar.f239967d = jSONObject;
        aVar.f239965b = jSONObject.optString("id");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                k(aVar.f239968e, (JSONObject) optJSONArray.opt(i3));
            }
        }
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                k(aVar.f239969f, (JSONObject) optJSONArray2.opt(i16));
            }
        }
        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
            for (int i17 = 0; i17 < optJSONArray3.length(); i17++) {
                k(aVar.f239970g, (JSONObject) optJSONArray3.opt(i17));
            }
        }
        if (optJSONArray4 != null && optJSONArray4.length() > 0) {
            for (int i18 = 0; i18 < optJSONArray4.length(); i18++) {
                k(aVar.f239971h, (JSONObject) optJSONArray4.opt(i18));
            }
        }
        if (optJSONArray5 != null && optJSONArray5.length() > 0) {
            for (int i19 = 0; i19 < optJSONArray5.length(); i19++) {
                k(aVar.f239972i, (JSONObject) optJSONArray5.opt(i19));
            }
        }
        return aVar;
    }

    private void P() throws Exception {
        QLog.d("kandianreport.taskmanager", 1, "readTasksFromConfigFile...");
        if (FileUtils.fileExists(f239889i)) {
            File[] listFiles = new File(f239889i).listFiles();
            this.f239897a.clear();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    try {
                        com.tencent.mobileqq.kandian.glue.report.task.a N = N(file);
                        List<String> list = f239896p;
                        if (list != null && list.size() > 0 && ("*".equals(f239896p.get(0)) || f239896p.contains(N.f239965b))) {
                            this.f239897a.add(N);
                        }
                    } catch (Exception e16) {
                        QLog.d("kandianreport.taskmanager", 2, e16.getMessage());
                        com.tencent.mobileqq.kandian.glue.report.task.c.a(e16.getMessage());
                    }
                }
            }
            if (this.f239897a.size() > 0) {
                Iterator<com.tencent.mobileqq.kandian.glue.report.task.a> it = this.f239897a.iterator();
                while (it.hasNext()) {
                    QLog.d("kandianreport.taskmanager", 1, it.next().toString());
                }
                return;
            }
            QLog.d("kandianreport.taskmanager", 1, "tasklist empty");
        }
    }

    private JSContext.a Q() {
        return new i();
    }

    private JSContext.a R() {
        return new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(StringBuffer stringBuffer, com.tencent.mobileqq.kandian.glue.report.task.a aVar, String str) {
        if (TextUtils.isEmpty(stringBuffer)) {
            return;
        }
        L(aVar);
        QLog.d("kandianreport.taskmanager", 1, "evaluate js exception: " + str + " " + ((Object) stringBuffer));
        com.tencent.mobileqq.kandian.glue.report.task.c.b(aVar.f239965b, "evaluate js exception: " + str + " " + ((Object) stringBuffer));
    }

    private JSContext.a T() {
        return new p();
    }

    private JSContext.a V(com.tencent.mobileqq.kandian.glue.report.task.a aVar) {
        return new q(aVar);
    }

    private JSContext.a W(com.tencent.mobileqq.kandian.glue.report.task.a aVar) {
        return new t(aVar);
    }

    private JSContext.a X() {
        return new l();
    }

    private void Z(com.tencent.mobileqq.kandian.glue.report.task.a aVar) throws Exception {
        G(aVar, aVar.f239969f, com.tencent.mobileqq.kandian.glue.report.task.a.f239960p);
        G(aVar, aVar.f239970g, com.tencent.mobileqq.kandian.glue.report.task.a.f239961q);
        G(aVar, aVar.f239971h, com.tencent.mobileqq.kandian.glue.report.task.a.f239962r);
        G(aVar, aVar.f239972i, com.tencent.mobileqq.kandian.glue.report.task.a.f239963s);
        aVar.f239966c = com.tencent.mobileqq.kandian.glue.report.task.a.f239956l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.report.task.TaskManager.5
            @Override // java.lang.Runnable
            public void run() {
                TaskManager.this.b0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        try {
            if (f239891k) {
                return;
            }
            if (!FileUtils.fileExists(f239884d)) {
                QLog.d("kandianreport.taskmanager", 1, "startTasksIfExist: offline root dir is null");
            } else {
                try {
                    if (!com.tencent.biz.common.util.h.k(f239884d, "3412")) {
                        KandianReportSoLoader.r("startTasksIfExist: verification failed");
                        return;
                    }
                } catch (Throwable th5) {
                    QLog.e("kandianreport.taskmanager", 1, th5.getMessage());
                    return;
                }
            }
            P();
            c0();
            KandianReportSoLoader.r("startTasksIfExist tasks size are: " + this.f239897a.size());
        } catch (Error e16) {
            QLog.d("kandianreport.taskmanager", 2, "startAllTasks unexpected error: " + e16.getMessage());
            com.tencent.mobileqq.kandian.glue.report.task.c.a("startAllTasks unexpected error: " + e16.getMessage());
        } catch (Exception e17) {
            QLog.d("kandianreport.taskmanager", 2, "startAllTasks unexpected exception: " + e17.getMessage());
            com.tencent.mobileqq.kandian.glue.report.task.c.a("startAllTasks unexpected exception: " + e17.getMessage());
        }
    }

    private void c0() {
        QLog.d("kandianreport.taskmanager", 1, "startTasksInList...");
        Iterator<com.tencent.mobileqq.kandian.glue.report.task.a> it = this.f239897a.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.kandian.glue.report.task.a next = it.next();
            try {
                if (K(next)) {
                    H(next);
                    Z(next);
                } else {
                    QLog.d("kandianreport.taskmanager", 1, next.f239965b + " available status is " + next.f239966c);
                }
            } catch (Error e16) {
                L(next);
                QLog.d("kandianreport.taskmanager", 1, "startTasksInList unexpected error: " + e16.getMessage());
                com.tencent.mobileqq.kandian.glue.report.task.c.b(next.f239965b, "startTasksInList unexpected error: " + e16.getMessage());
            } catch (Exception e17) {
                L(next);
                QLog.d("kandianreport.taskmanager", 1, "startTasksInList unexpected exception: " + e17.getMessage());
                com.tencent.mobileqq.kandian.glue.report.task.c.b(next.f239965b, "startTasksInList unexpected exception: " + e17.getMessage());
            }
        }
        f239891k = true;
    }

    private void k(ArrayList<a.C7960a> arrayList, JSONObject jSONObject) {
        String optString = jSONObject.optString("id");
        String optString2 = jSONObject.optString("value");
        JSONArray optJSONArray = jSONObject.optJSONArray("output");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("check");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("args");
        a.C7960a c7960a = new a.C7960a();
        c7960a.f239973a = optString;
        c7960a.f239974b = optString2;
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                c7960a.f239975c.add((String) optJSONArray.opt(i3));
            }
        }
        if (optJSONArray2 != null) {
            for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                c7960a.f239976d.add((String) optJSONArray2.opt(i16));
            }
        }
        if (optJSONArray3 != null) {
            for (int i17 = 0; i17 < optJSONArray3.length(); i17++) {
                c7960a.f239977e.add((String) optJSONArray3.opt(i17));
            }
        }
        arrayList.add(c7960a);
    }

    private JSContext.a l() {
        return new d();
    }

    private JSContext.a m() {
        return new o();
    }

    private JSContext.a n() {
        return new m();
    }

    private JSContext.a o() {
        return new b();
    }

    private JSContext.a p(com.tencent.mobileqq.kandian.glue.report.task.a aVar) {
        return new u(aVar);
    }

    private JSContext.a r() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String s(ArrayList<String> arrayList) {
        String str = "[";
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (i3 != 0) {
                    str = str + ',';
                }
                str = str + "'" + arrayList.get(i3) + "'";
            }
        }
        return str + "]";
    }

    private JSContext.a t(com.tencent.mobileqq.kandian.glue.report.task.a aVar) {
        return new f();
    }

    private JSContext.a u() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> v(ArrayList<a.C7960a> arrayList, String str) {
        Iterator<a.C7960a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C7960a next = it.next();
            if (next.f239974b.equals(str)) {
                return next.f239977e;
            }
        }
        return null;
    }

    public static TaskManager x() {
        return f239895o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> y(ArrayList<a.C7960a> arrayList, String str) {
        Iterator<a.C7960a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C7960a next = it.next();
            if (next.f239974b.equals(str)) {
                return next.f239975c;
            }
        }
        return null;
    }

    private JSContext.a z() {
        return new n();
    }

    public void L(com.tencent.mobileqq.kandian.glue.report.task.a aVar) {
        QLog.d("kandianreport.taskmanager", 2, "mark task fail " + aVar.f239965b);
        aVar.f239966c = com.tencent.mobileqq.kandian.glue.report.task.a.f239959o;
        com.tencent.mobileqq.kandian.base.utils.c.e("kandianreport.taskmanager" + aVar.f239965b, Integer.valueOf(com.tencent.mobileqq.kandian.glue.report.task.a.f239959o));
    }

    public synchronized void Y() {
        try {
            boolean w3 = w();
            f239892l = w3;
            if (w3 && !f239891k) {
                KandianReportSoLoader.r("startAllTasks");
                if (!this.f239898b) {
                    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.f239899c);
                    this.f239898b = true;
                }
                f239890j = TaskOfflineUtils.b("3412", 1).f239952b;
                if (KandianReportSoLoader.p()) {
                    QLog.d("kandianreport.taskmanager", 1, "so loaded, now startTasks");
                    a0();
                } else {
                    QLog.d("kandianreport.taskmanager", 1, "so not loaded, load first");
                    if (!KandianReportSoLoader.o()) {
                        KandianReportSoLoader.l(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.report.task.TaskManager.3
                            @Override // java.lang.Runnable
                            public void run() {
                                KandianReportSoLoader.q(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.report.task.TaskManager.3.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        TaskManager.this.a0();
                                    }
                                });
                            }
                        });
                    } else {
                        KandianReportSoLoader.q(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.report.task.TaskManager.4
                            @Override // java.lang.Runnable
                            public void run() {
                                TaskManager.this.a0();
                            }
                        });
                    }
                }
            } else {
                QLog.d("kandianreport.taskmanager", 2, "startAllTasks fail isConfigureOn: " + f239892l + " isStarted: " + f239891k);
            }
        } catch (Throwable th5) {
            QLog.e("kandianreport.taskmanager", 2, "startAllTasks " + th5);
        }
    }

    public synchronized void d0() {
        if (f239891k) {
            QLog.d("kandianreport.taskmanager", 1, "stopAllTasks");
            f239891k = false;
            Iterator<com.tencent.mobileqq.kandian.glue.report.task.a> it = this.f239897a.iterator();
            while (it.hasNext()) {
                e0(it.next().f239965b);
            }
            this.f239898b = false;
        }
    }

    public void e0(String str) {
        Iterator<com.tencent.mobileqq.kandian.glue.report.task.a> it = this.f239897a.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.kandian.glue.report.task.a next = it.next();
            if (next.f239965b == str) {
                next.f239966c = com.tencent.mobileqq.kandian.glue.report.task.a.f239957m;
            }
        }
    }

    public void j(final String str) {
        if (f239892l && f239891k && !TextUtils.isEmpty(str)) {
            if (!KandianReportSoLoader.p()) {
                QLog.d("kandianreport.taskmanager", 2, "accept so not load");
            } else {
                ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.report.task.TaskManager.6
                    @Override // java.lang.Runnable
                    public void run() {
                        String[] C;
                        synchronized (TaskManager.this) {
                            if (TaskManager.this.f239897a.size() == 0) {
                                return;
                            }
                            Iterator it = TaskManager.this.f239897a.iterator();
                            while (it.hasNext()) {
                                com.tencent.mobileqq.kandian.glue.report.task.a aVar = (com.tencent.mobileqq.kandian.glue.report.task.a) it.next();
                                if (aVar.f239966c == com.tencent.mobileqq.kandian.glue.report.task.a.f239956l) {
                                    Iterator<a.C7960a> it5 = aVar.f239968e.iterator();
                                    while (it5.hasNext()) {
                                        a.C7960a next = it5.next();
                                        if (!TextUtils.isEmpty(next.f239974b) && !TextUtils.isEmpty(str) && str.contains(next.f239974b)) {
                                            try {
                                                ArrayList y16 = TaskManager.this.y(aVar.f239968e, next.f239974b);
                                                if (y16 != null && y16.size() > 0 && (C = TaskManager.this.C(aVar.f239969f, y16)) != null && C.length > 0) {
                                                    for (String str2 : C) {
                                                        String str3 = str2 + "('" + str + "'," + TaskManager.this.s(TaskManager.this.v(aVar.f239969f, str2)) + ")";
                                                        if (aVar.f239964a != null) {
                                                            StringBuffer stringBuffer = new StringBuffer();
                                                            String replaceAll = str3.replaceAll("\"", "\\\\\"");
                                                            aVar.f239964a.a(replaceAll, stringBuffer);
                                                            if (!TextUtils.isEmpty(stringBuffer)) {
                                                                TaskManager.this.L(aVar);
                                                                QLog.d("kandianreport.taskmanager", 1, "evaluate js exception: " + replaceAll + " " + ((Object) stringBuffer));
                                                                com.tencent.mobileqq.kandian.glue.report.task.c.b(aVar.f239965b, "evaluate js exception: " + replaceAll + " " + ((Object) stringBuffer));
                                                                return;
                                                            }
                                                        }
                                                    }
                                                }
                                            } catch (Error e16) {
                                                TaskManager.this.L(aVar);
                                                QLog.d("kandianreport.taskmanager", 1, "accept unexpected error: " + e16.getMessage());
                                                com.tencent.mobileqq.kandian.glue.report.task.c.b(aVar.f239965b, "accept unexpected error: " + e16.getMessage());
                                            } catch (Exception e17) {
                                                TaskManager.this.L(aVar);
                                                QLog.d("kandianreport.taskmanager", 1, "accept unexpected exception: " + e17.getMessage());
                                                com.tencent.mobileqq.kandian.glue.report.task.c.b(aVar.f239965b, "accept unexpected exception: " + e17.getMessage());
                                            }
                                        }
                                    }
                                } else {
                                    QLog.d("kandianreport.taskmanager", 2, aVar.f239965b + " not accept status is " + aVar.f239966c);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void q(boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f239893m >= f239894n) {
            TaskOfflineUtils.c("3412", 1, new v(z16));
        }
        f239893m = currentTimeMillis;
    }

    public static boolean w() {
        return ((Integer) com.tencent.mobileqq.kandian.base.utils.c.c("kandianreport_ON", 0)).intValue() == 1;
    }

    public void U() {
        QLog.d("kandianreport.taskmanager", 2, "restartAllTasks");
        d0();
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] C(ArrayList<a.C7960a> arrayList, ArrayList<String> arrayList2) {
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return null;
        }
        String[] strArr = new String[arrayList2.size()];
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            Iterator<a.C7960a> it = arrayList.iterator();
            while (it.hasNext()) {
                a.C7960a next = it.next();
                if (next.f239973a.equals(arrayList2.get(i3))) {
                    strArr[i3] = next.f239974b;
                }
            }
        }
        return strArr;
    }
}
