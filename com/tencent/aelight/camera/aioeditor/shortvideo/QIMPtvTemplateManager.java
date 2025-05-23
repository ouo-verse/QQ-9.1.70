package com.tencent.aelight.camera.aioeditor.shortvideo;

import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager;
import com.tencent.aelight.camera.aioeditor.capture.data.l;
import com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.common.util.k;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.richmedia.g;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qs.f;

/* loaded from: classes32.dex */
public class QIMPtvTemplateManager extends QIMAsyncManager {
    public static final Long J = 2000L;
    private static final String K;
    public static String L;
    public static String M;
    public static String N;
    private static File P;
    public static File Q;
    public static int R;
    public static AtomicBoolean S;
    private yq2.b C;
    private l D;
    private l E;
    private String H;

    /* renamed from: h, reason: collision with root package name */
    String f67576h;

    /* renamed from: i, reason: collision with root package name */
    String f67577i;

    /* renamed from: f, reason: collision with root package name */
    protected final Object f67575f = new Object();

    /* renamed from: m, reason: collision with root package name */
    protected Object f67578m = new Object();
    public String F = "recent_template_setting";
    public String G = "recent_template_list";
    HashMap<Integer, Object> I = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    protected List<l> f67574e = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f67585d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PtvTemplateManager.a f67586e;

        a(f fVar, PtvTemplateManager.a aVar) {
            this.f67585d = fVar;
            this.f67586e = aVar;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            if (QLog.isColorLevel()) {
                QLog.i("QIMPtvTemplateManager", 2, "onResp url: " + this.f67585d.f429435c + " resultcode: " + netResp.mHttpCode);
            }
            f fVar = this.f67585d;
            fVar.f429439g = QIMPtvTemplateManager.this.x(fVar);
            synchronized (QIMPtvTemplateManager.this.f67575f) {
                Iterator<l> it = QIMPtvTemplateManager.this.f67574e.iterator();
                while (it.hasNext()) {
                    List<f> list = it.next().f66745d;
                    if (list != null) {
                        for (f fVar2 : list) {
                            if (fVar2.f429437e.equals(this.f67585d.f429437e)) {
                                fVar2.f429439g = QIMPtvTemplateManager.this.x(fVar2);
                            }
                        }
                    }
                }
            }
            PtvTemplateManager.a aVar = this.f67586e;
            if (aVar != null) {
                f fVar3 = this.f67585d;
                aVar.a(fVar3, fVar3.f429439g);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            f fVar = this.f67585d;
            fVar.W = j16;
            PtvTemplateManager.a aVar = this.f67586e;
            if (aVar != null) {
                aVar.b(fVar, (int) ((j3 * 100) / j16));
            }
        }
    }

    static List<l> B(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < length; i3++) {
            try {
                l lVar = new l();
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject.has("content")) {
                    lVar.f66745d = PtvTemplateManager.b.a(jSONObject.getJSONArray("content"));
                }
                if (jSONObject.has("categoryName")) {
                    lVar.f66747f = jSONObject.getString("categoryName");
                }
                if (jSONObject.has("TipsVer") && jSONObject.has("Tips")) {
                    lVar.f66750m = jSONObject.getInt("TipsVer");
                    lVar.f66749i = jSONObject.getString("Tips");
                }
                lVar.C = "1".equals(jSONObject.optString("random_position"));
                if (jSONObject.has("categoryId")) {
                    lVar.f66746e = jSONObject.getInt("categoryId");
                    List<f> list = lVar.f66745d;
                    if (list != null && !list.isEmpty()) {
                        Iterator<f> it = lVar.f66745d.iterator();
                        while (it.hasNext()) {
                            it.next().f429444l = lVar.f66746e;
                        }
                    }
                }
                arrayList.add(lVar);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    e16.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    static List<l> C(QIMPtvTemplateManager qIMPtvTemplateManager, String str) {
        String str2;
        String str3;
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (qIMPtvTemplateManager != null) {
                if (jSONObject2.has("guide_video_url")) {
                    qIMPtvTemplateManager.f67576h = jSONObject2.getString("guide_video_url");
                }
                if (jSONObject2.has("guide_video_md5")) {
                    qIMPtvTemplateManager.f67577i = jSONObject2.getString("guide_video_md5");
                }
            }
            String str4 = "";
            if (!jSONObject2.has("bigheadCommonRes") || (jSONObject = jSONObject2.getJSONObject("bigheadCommonRes")) == null) {
                str2 = "";
                str3 = str2;
            } else {
                String optString = jSONObject.optString("bighead_model_name", "");
                str3 = jSONObject.optString("bighead_model_resurl", "");
                str2 = jSONObject.optString("bighead_model_resmd5", "");
                str4 = optString;
            }
            if (jSONObject2.has("category")) {
                List<l> B = B(jSONObject2.getJSONArray("category"));
                E(B, str4, str3, str2);
                return B;
            }
        } catch (Error e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
        } catch (JSONException e17) {
            if (QLog.isColorLevel()) {
                e17.printStackTrace();
            }
        }
        return null;
    }

    private static void E(List<l> list, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || list == null || list.size() <= 0) {
            return;
        }
        for (l lVar : list) {
            List<f> list2 = lVar.f66745d;
            if (list2 != null && list2.size() > 0) {
                for (f fVar : lVar.f66745d) {
                    if (fVar != null && fVar.f429447o == 20) {
                        fVar.R = str;
                        fVar.S = str2;
                        fVar.T = str3;
                    }
                }
            }
        }
    }

    static void H(final String str, final String str2) {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager.2
            @Override // java.lang.Runnable
            public void run() {
                FileUtils.writeFile(QIMPtvTemplateManager.P.getPath() + File.separator, str2, str);
                if (QLog.isColorLevel()) {
                    QLog.i("QIMPtvTemplateManager", 2, "save Config to file finish.");
                }
            }
        });
    }

    public static boolean v() {
        boolean exists = new File(P, "ptv_template_new.cfg").exists();
        if (QLog.isColorLevel()) {
            QLog.i("QIMPtvTemplateManager", 2, "QIMPtvTemplateManager isStickerConfigFileExist" + exists);
        }
        return exists;
    }

    private boolean w() {
        l lVar = this.D;
        return lVar != null && lVar.f66745d.size() >= 100;
    }

    private boolean y(String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(P, str);
        if (!file.exists()) {
            return false;
        }
        try {
            String calcMd5 = FileUtils.calcMd5(file.getPath());
            if (!TextUtils.isEmpty(calcMd5) && calcMd5.equalsIgnoreCase(str2)) {
                String str3 = L + str + File.separator;
                File file2 = new File(str3, IVideoFilterTools.CONFIG_FILE);
                File file3 = new File(str3, "params.dat");
                if (file2.exists() || (z16 && file3.exists())) {
                    return true;
                }
                try {
                    ZipUtils.unZipFile(new File(P, str), L);
                    return true;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QIMPtvTemplateManager", 2, "judgeTemplateUsable unZipFile exp:", e16);
                    }
                    return file2.exists() && (z16 || file3.exists());
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("QIMPtvTemplateManager", 2, "judgeTemplateUsable md5 exp, fileMd5:" + calcMd5 + ", tempMd5:" + str2 + ", name:" + str);
            }
            return false;
        } catch (UnsatisfiedLinkError e17) {
            if (QLog.isColorLevel()) {
                QLog.e("QIMPtvTemplateManager", 2, "judgeTemplateUsable calcMd5 error:", e17);
            }
            return false;
        }
    }

    public static String z(File file) {
        byte[] fileToBytes = FileUtils.fileToBytes(file);
        if (fileToBytes == null || fileToBytes.length <= 0) {
            return null;
        }
        try {
            return new String(fileToBytes, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            QLog.e("QIMPtvTemplateManager_PTV", 1, "loadFileContent error, ", e16);
            return null;
        } catch (Error e17) {
            QLog.e("QIMPtvTemplateManager_PTV", 1, "loadFileContent error, " + e17.getMessage());
            return null;
        }
    }

    public void A(int i3, Object obj) {
        yq2.b bVar = this.C;
        if (bVar != null) {
            bVar.c(i3, obj);
            if (QLog.isColorLevel()) {
                QLog.d("QIMPtvTemplateManager", 2, "notifyEventId eventId" + i3);
            }
        }
    }

    protected List<l> G(File file) {
        List<l> C;
        if (QLog.isColorLevel()) {
            QLog.i("QIMPtvTemplateManager", 2, String.format("rebuildTemplateInfos, cur_runnable[%s]", Integer.valueOf(hashCode())));
        }
        String z16 = z(file);
        if (TextUtils.isEmpty(z16) || (C = C(this, z16)) == null || C.isEmpty()) {
            return null;
        }
        for (l lVar : C) {
            List<f> list = lVar.f66745d;
            if (list != null && list.size() != 0) {
                for (f fVar : lVar.f66745d) {
                    if (fVar != null) {
                        fVar.f429439g = x(fVar);
                    }
                }
            }
        }
        k();
        return C;
    }

    public void I(f fVar, int i3) {
        synchronized (this.f67578m) {
            if (this.D == null) {
                l lVar = new l(HardCodeUtil.qqStr(R.string.qdz));
                this.D = lVar;
                lVar.f66745d = new ArrayList(100);
                p(this.D);
            }
            if (this.E == null) {
                this.E = this.D.clone();
            }
            int o16 = o(this.D.f66745d, fVar.f429433a);
            if (o16 == -1) {
                if (!w()) {
                    this.D.f66745d.add(0, fVar);
                    this.E.f66745d.add(0, fVar);
                    yq2.b bVar = this.C;
                    if (bVar != null) {
                        bVar.c(i3, this.E);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QIMPtvTemplateManager", 2, "setCurrentTemplateInfoToRecent not isRecentTemplateFull ");
                    }
                } else {
                    f remove = this.D.f66745d.remove(99);
                    this.D.f66745d.add(0, fVar);
                    this.E.f66745d.remove(remove);
                    this.E.f66745d.add(0, fVar);
                    yq2.b bVar2 = this.C;
                    if (bVar2 != null) {
                        bVar2.c(i3, this.E);
                    }
                }
            } else if (o16 != 0) {
                this.D.f66745d.remove(o16);
                this.D.f66745d.add(0, fVar);
            }
            if (QLog.isColorLevel()) {
                QLog.d("QIMPtvTemplateManager", 2, "setCurrentTemplateInfoToRecent index=" + o16);
            }
        }
    }

    public void J(String str, int i3, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("QIMPtvTemplateManager", 2, "QIMPtvTemplateManager setSelectedPtvTemplate id=" + str + " categoryId =" + i3 + " currentPath=" + str2);
        }
        A(113, null);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager
    public void i() {
        t();
    }

    protected void k() {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager.3
            @Override // java.lang.Runnable
            public void run() {
                boolean m3 = com.tencent.mobileqq.shortvideo.util.f.m();
                boolean isNetSupport = NetworkUtil.isNetSupport(BaseApplication.getContext());
                boolean z16 = MobileQQ.sProcessId != 1;
                if (m3 && isNetSupport && z16) {
                    QIMPtvTemplateManager qIMPtvTemplateManager = QIMPtvTemplateManager.this;
                    qIMPtvTemplateManager.D(qIMPtvTemplateManager.f67574e);
                }
            }
        }, J.longValue());
    }

    public f l(String str) {
        Iterator<l> it = q().iterator();
        while (it.hasNext()) {
            for (f fVar : it.next().f66745d) {
                if (fVar.f429433a.equals(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QIMPtvTemplateManager", 2, "QIMPtvTemplateManager existTemplateInfo id=" + str);
                    }
                    return fVar;
                }
            }
        }
        return null;
    }

    public String m() {
        return this.H;
    }

    public List<l> n() {
        ArrayList arrayList = new ArrayList();
        for (l lVar : this.f67574e) {
            if (lVar.f66748h) {
                arrayList.add(lVar);
            }
        }
        return arrayList;
    }

    public l p(l lVar) {
        String string = BaseApplicationImpl.getApplication().getSharedPreferences(this.F, 0).getString(this.G + BaseApplicationImpl.getApplication().getRuntime().getAccount(), null);
        if (QLog.isColorLevel()) {
            QLog.d("QIMPtvTemplateManager", 2, "getRecentTemplate list=" + string);
        }
        if (TextUtils.isEmpty(string)) {
            return lVar;
        }
        String[] split = string.split("\\$");
        synchronized (this.f67578m) {
            lVar.f66745d.clear();
            for (String str : split) {
                String[] split2 = str.split("\\|");
                if (split2 != null && split2.length == 2) {
                    Integer.valueOf(split2[1]).intValue();
                    f l3 = l(split2[0]);
                    if (l3 == null) {
                        continue;
                    } else {
                        if (lVar.f66745d.size() >= 100) {
                            return lVar;
                        }
                        lVar.f66745d.add(l3);
                    }
                }
            }
            return lVar;
        }
    }

    public ArrayList<l> q() {
        ArrayList<l> arrayList = new ArrayList<>(this.f67574e);
        List<l> n3 = n();
        if (n3 != null && !n3.isEmpty()) {
            arrayList.removeAll(n3);
        }
        return arrayList;
    }

    public Runnable s(final boolean z16) {
        return new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager.1
            /* JADX WARN: Code restructure failed: missing block: B:62:0x0031, code lost:
            
                if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L33;
             */
            /* JADX WARN: Code restructure failed: missing block: B:63:0x0033, code lost:
            
                r2.printStackTrace();
             */
            /* JADX WARN: Code restructure failed: missing block: B:75:0x0052, code lost:
            
                if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L33;
             */
            /* JADX WARN: Not initialized variable reg: 2, insn: 0x00f2: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:78:0x00f2 */
            /* JADX WARN: Removed duplicated region for block: B:81:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                InputStream inputStream;
                InputStream inputStream2;
                List<l> C;
                if (QIMPtvTemplateManager.this.f67574e.isEmpty() || z16) {
                    String str = "";
                    InputStream inputStream3 = null;
                    try {
                        try {
                            inputStream = BaseApplication.getContext().getAssets().open("ptv_template_new.cfg");
                        } catch (IOException e16) {
                            e = e16;
                            inputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            if (inputStream3 != null) {
                            }
                            throw th;
                        }
                        try {
                            str = k.h(inputStream);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e17) {
                                    e = e17;
                                }
                            }
                        } catch (IOException e18) {
                            e = e18;
                            if (QLog.isColorLevel()) {
                                e.printStackTrace();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e19) {
                                    e = e19;
                                }
                            }
                            C = QIMPtvTemplateManager.C(QIMPtvTemplateManager.this, str);
                            if (C != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                        C = QIMPtvTemplateManager.C(QIMPtvTemplateManager.this, str);
                        if (C != null || C.isEmpty()) {
                            return;
                        }
                        Iterator<l> it = C.iterator();
                        while (it.hasNext()) {
                            for (f fVar : it.next().f66745d) {
                                if (fVar != null) {
                                    boolean x16 = QIMPtvTemplateManager.this.x(fVar);
                                    fVar.f429439g = x16;
                                    if (!x16 && QLog.isColorLevel()) {
                                        QLog.i("QIMPtvTemplateManager", 2, "initAssetsFile template is not useable id=" + fVar.f429433a + " md5=" + fVar.f429436d);
                                    }
                                }
                            }
                        }
                        synchronized (QIMPtvTemplateManager.this.f67575f) {
                            if (QIMPtvTemplateManager.this.f67574e.isEmpty()) {
                                QIMPtvTemplateManager.this.f67574e.addAll(C);
                            }
                            if (QIMPtvTemplateManager.this.c() != null) {
                                QIMPtvTemplateManager.this.c().notifyObservers(com.tencent.aelight.camera.aioeditor.capture.music.b.class, 3, true, null);
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream3 = inputStream2;
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Exception e26) {
                                if (QLog.isColorLevel()) {
                                    e26.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                }
            }
        };
    }

    public void t() {
        Runnable u16;
        File file = new File(P, "ptv_template_new.cfg");
        if (!file.exists()) {
            u16 = s(false);
        } else {
            u16 = u(file);
        }
        u16.run();
        if (QLog.isDevelopLevel()) {
            QLog.d("QIMPtvTemplateManager", 4, "initTemplateConfig, cacheFile exists:", Boolean.valueOf(file.exists()), ", runnable:", Integer.valueOf(u16.hashCode()));
        }
    }

    public Runnable u(final File file) {
        return new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager.5
            @Override // java.lang.Runnable
            public void run() {
                List<l> G = QIMPtvTemplateManager.this.G(file);
                if (QLog.isColorLevel()) {
                    QLog.i("QIMPtvTemplateManager", 2, String.format("rebuildTemplateInfos, templateInfos[%s]", G));
                }
                if (G != null) {
                    synchronized (QIMPtvTemplateManager.this.f67575f) {
                        QIMPtvTemplateManager.this.f67574e.clear();
                        QIMPtvTemplateManager.this.f67574e.addAll(G);
                    }
                    if (QIMPtvTemplateManager.this.c() != null) {
                        QIMPtvTemplateManager.this.c().notifyObservers(com.tencent.aelight.camera.aioeditor.capture.music.b.class, 3, true, null);
                    }
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("QIMPtvTemplateManager", 4, String.format("rebuildTemplateInfos, [%s] finished", Integer.valueOf(hashCode())));
                }
            }
        };
    }

    public synchronized boolean x(f fVar) {
        if (fVar == null) {
            return false;
        }
        int i3 = fVar.f429447o;
        if (i3 == 5) {
            fVar.N = y(fVar.L, fVar.M, false);
            fVar.Q = y(fVar.O, fVar.P, false);
            boolean y16 = y(fVar.f429437e, fVar.f429436d, false);
            if (QLog.isColorLevel()) {
                QLog.d("QIMPtvTemplateManager", 2, String.format("isDGTemplateUsage stage[%s], model[%s], total[%s], id[%s]", Boolean.valueOf(fVar.N), Boolean.valueOf(fVar.Q), Boolean.valueOf(y16), fVar.f429433a));
            }
            if (fVar.N && fVar.Q) {
                return y16;
            }
            return false;
        }
        if (i3 == 6) {
            boolean y17 = y(fVar.L, fVar.M, false);
            fVar.N = y17;
            if (!y17) {
                return false;
            }
            return y(fVar.f429437e, fVar.f429436d, false);
        }
        return y(fVar.f429437e, fVar.f429436d, true);
    }

    @Override // fr.e
    public void d() {
        this.D = null;
        if (QLog.isColorLevel()) {
            QLog.d("QIMPtvTemplateManager", 2, "QIMPtvTemplateManager onDestroy");
        }
    }

    public void r(String str, int i3) {
        List<l> C = C(null, str);
        if (C != null && !C.isEmpty()) {
            H(str, "ptv_template_new.cfg");
            c().notifyObservers(com.tencent.aelight.camera.aioeditor.capture.music.b.class, 3, true, null);
        } else {
            QLog.d("QIMPtvTemplateManager", 1, "handleGetServerConfig no infos");
        }
    }

    static {
        L = "ptv_template_usable";
        M = "ptv_debug";
        N = "ptv_template_usable_doodle";
        File file = new File(g.f185856d);
        K = file.getPath();
        P = new File(file, "dov_ptv_template_dov");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(P.getPath());
        String str = File.separator;
        sb5.append(str);
        sb5.append(L);
        sb5.append(str);
        L = sb5.toString();
        M = P.getPath() + str + M;
        Q = new File(file, "doodle_template");
        N = Q.getPath() + str + N + str;
        S = new AtomicBoolean(false);
    }

    void D(List<l> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (l lVar : list) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(lVar.f66745d);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                final f fVar = (f) arrayList.get(i3);
                if (fVar != null && fVar.f429438f && !TextUtils.isEmpty(fVar.f429435c)) {
                    ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (QIMPtvTemplateManager.this.x(fVar)) {
                                fVar.f429439g = true;
                                return;
                            }
                            fVar.f429439g = false;
                            int availableInnernalMemorySize = (int) ((FileUtils.getAvailableInnernalMemorySize() / 1024.0f) / 1024.0f);
                            int i16 = (int) (fVar.U * 1024.0d);
                            if (QLog.isColorLevel()) {
                                QLog.d("QIMPtvTemplateManager", 2, "preDownloadTemplates getAvailableInnernalMemorySize: " + availableInnernalMemorySize + " mSizeFree: " + i16);
                            }
                            if (availableInnernalMemorySize < i16) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("QIMPtvTemplateManager", 2, "preDownloadTemplates return getAvailableInnernalMemorySize: " + availableInnernalMemorySize + " mSizeFree: " + i16);
                                    return;
                                }
                                return;
                            }
                            HttpNetReq httpNetReq = new HttpNetReq();
                            httpNetReq.mCallback = new a();
                            httpNetReq.mReqUrl = fVar.f429435c;
                            httpNetReq.mHttpMethod = 0;
                            httpNetReq.mOutPath = new File(QIMPtvTemplateManager.P, fVar.f429437e).getPath();
                            httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                            try {
                                AppInterface a16 = fr.b.a();
                                if (a16 != null) {
                                    ((IHttpEngineService) ((PeakAppInterface) a16).getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                                    if (QLog.isColorLevel()) {
                                        QLog.i("QIMPtvTemplateManager", 2, "startDownloadFilterConfigZip, url: " + fVar.f429435c);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }

                        /* renamed from: com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager$4$a */
                        /* loaded from: classes32.dex */
                        class a implements INetEngineListener {
                            a() {
                            }

                            @Override // com.tencent.mobileqq.transfile.INetEngineListener
                            public void onResp(NetResp netResp) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("QIMPtvTemplateManager", 2, "onResp url: " + fVar.f429435c + " resultcode: " + netResp.mHttpCode);
                                }
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                f fVar = fVar;
                                fVar.f429439g = QIMPtvTemplateManager.this.x(fVar);
                                if (fVar.f429439g) {
                                    try {
                                        ZipUtils.unZipFile(new File(QIMPtvTemplateManager.P, fVar.f429437e), QIMPtvTemplateManager.L);
                                    } catch (IOException e16) {
                                        if (QLog.isColorLevel()) {
                                            e16.printStackTrace();
                                        }
                                    }
                                }
                                if (QIMPtvTemplateManager.this.c() != null) {
                                    QIMPtvTemplateManager.this.c().notifyObservers(com.tencent.aelight.camera.aioeditor.capture.music.b.class, 3, true, null);
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

    public void K(AppInterface appInterface, f fVar, PtvTemplateManager.a aVar) {
        if (fVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QIMPtvTemplateManager", 2, "startDownloadTemplate is null");
                return;
            }
            return;
        }
        F(appInterface, fVar, aVar);
    }

    private int o(List<f> list, String str) {
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3).f429433a.equals(str)) {
                    return i3;
                }
            }
        }
        return -1;
    }

    public void F(AppInterface appInterface, f fVar, PtvTemplateManager.a aVar) {
        if (fVar == null || appInterface == null) {
            return;
        }
        fVar.V = System.currentTimeMillis();
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = new a(fVar, aVar);
        httpNetReq.mReqUrl = fVar.f429435c;
        httpNetReq.mHttpMethod = 0;
        if (fVar.f429437e == null) {
            QLog.i("QIMPtvTemplateManager", 1, "startDownloadTemplate fail, info.name is null, url:" + fVar.f429435c);
            return;
        }
        httpNetReq.mOutPath = new File(P, fVar.f429437e).getPath();
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mExcuteTimeLimit = 60000L;
        try {
            ((IHttpEngineService) appInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
        }
        httpNetReq.mCallback.onUpdateProgeress(httpNetReq, 1L, 100L);
        if (QLog.isColorLevel()) {
            QLog.i("QIMPtvTemplateManager", 2, "startDownloadTemplate url: " + fVar.f429435c);
        }
    }
}
