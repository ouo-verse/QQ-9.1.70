package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.AEModuleConfig;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;
import com.tencent.aelight.camera.aioeditor.capture.data.LockedCategory;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMRedDotConfig;
import com.tencent.aelight.camera.aioeditor.capture.data.TransitionCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMFileUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.api.IAEPhotoAIManager;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.av.video.effect.lowlight.LowLightTools;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class m {
    private static int A;
    private static int B;

    /* renamed from: m, reason: collision with root package name */
    public static final String f66480m;

    /* renamed from: n, reason: collision with root package name */
    private static final String f66481n;

    /* renamed from: o, reason: collision with root package name */
    private static m f66482o;

    /* renamed from: p, reason: collision with root package name */
    public static HashMap<String, FilterDesc> f66483p;

    /* renamed from: q, reason: collision with root package name */
    private static boolean f66484q;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f66485r;

    /* renamed from: s, reason: collision with root package name */
    public static QIMRedDotConfig f66486s;

    /* renamed from: t, reason: collision with root package name */
    public static Object f66487t;

    /* renamed from: u, reason: collision with root package name */
    private static boolean f66488u;

    /* renamed from: v, reason: collision with root package name */
    public static String f66489v;

    /* renamed from: w, reason: collision with root package name */
    public static String f66490w;

    /* renamed from: x, reason: collision with root package name */
    public static int f66491x;

    /* renamed from: y, reason: collision with root package name */
    private static int f66492y;

    /* renamed from: z, reason: collision with root package name */
    private static int f66493z;

    /* renamed from: a, reason: collision with root package name */
    public FilterDesc f66494a;

    /* renamed from: e, reason: collision with root package name */
    private EditVideoPartManager f66498e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f66499f;

    /* renamed from: j, reason: collision with root package name */
    private TransitionCategoryItem f66503j;

    /* renamed from: b, reason: collision with root package name */
    private int[] f66495b = {-1};

    /* renamed from: c, reason: collision with root package name */
    private int f66496c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f66497d = -1;

    /* renamed from: g, reason: collision with root package name */
    private boolean f66500g = true;

    /* renamed from: h, reason: collision with root package name */
    public QIMFilterCategoryItem[] f66501h = new QIMFilterCategoryItem[5];

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.aelight.camera.aioeditor.capture.data.h[] f66502i = new com.tencent.aelight.camera.aioeditor.capture.data.h[5];

    /* renamed from: k, reason: collision with root package name */
    public QIMFilterCategoryItem[] f66504k = new QIMFilterCategoryItem[5];

    /* renamed from: l, reason: collision with root package name */
    public QIMFilterCategoryItem[] f66505l = new QIMFilterCategoryItem[5];

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f66506a;

        /* renamed from: b, reason: collision with root package name */
        CopyOnWriteArrayList<FilterCategory> f66507b;

        /* renamed from: c, reason: collision with root package name */
        public HashMap<String, LockedCategory> f66508c = new HashMap<>();

        /* renamed from: d, reason: collision with root package name */
        public b f66509d;

        /* renamed from: e, reason: collision with root package name */
        public b f66510e;

        /* renamed from: f, reason: collision with root package name */
        public b f66511f;

        /* renamed from: g, reason: collision with root package name */
        public b f66512g;

        /* renamed from: h, reason: collision with root package name */
        public b f66513h;

        /* renamed from: i, reason: collision with root package name */
        public b f66514i;

        public a(String str) throws JSONException {
            this.f66509d = new b();
            this.f66510e = new b();
            this.f66511f = new b();
            this.f66512g = new b();
            this.f66513h = new b();
            this.f66514i = new b();
            this.f66506a = str;
            CopyOnWriteArrayList<FilterCategory> j3 = j(str);
            this.f66507b = j3;
            this.f66509d = m.b(j3, true, false, false);
            this.f66511f = m.b(this.f66507b, false, true, false);
            this.f66512g = m.b(this.f66507b, false, false, false);
            this.f66510e = m.b(this.f66507b, true, false, true);
            this.f66513h = m.b(this.f66507b, false, true, true);
            this.f66514i = m.b(this.f66507b, false, false, true);
            if (i(this.f66510e)) {
                return;
            }
            this.f66510e = h();
            this.f66513h = h();
            this.f66514i = h();
        }

        public static synchronized List<QIMFilterCategoryItem> b(List<QIMFilterCategoryItem> list) {
            ArrayList arrayList;
            synchronized (a.class) {
                int i3 = AEDashboardUtil.q() ? 104 : 103;
                arrayList = new ArrayList();
                if (list != null) {
                    for (QIMFilterCategoryItem qIMFilterCategoryItem : list) {
                        if (qIMFilterCategoryItem != null && qIMFilterCategoryItem.f66701i == i3) {
                            arrayList.add(qIMFilterCategoryItem);
                        }
                    }
                }
            }
            return arrayList;
        }

        private TransitionCategoryItem g(int i3, String str, int i16, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            TransitionCategoryItem transitionCategoryItem = new TransitionCategoryItem();
            transitionCategoryItem.f66697d = i3 + "";
            transitionCategoryItem.f66698e = str;
            transitionCategoryItem.f66700h = str4;
            transitionCategoryItem.P = str3;
            transitionCategoryItem.f66701i = i16;
            ArrayList<String> arrayList = new ArrayList<>(1);
            transitionCategoryItem.F = arrayList;
            arrayList.add(str2);
            transitionCategoryItem.Q = str5;
            transitionCategoryItem.R = str7;
            transitionCategoryItem.S = str8;
            transitionCategoryItem.T = str6;
            return transitionCategoryItem;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r5 != 4) goto L22;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b c(int i3) {
            b bVar = new b();
            b bVar2 = this.f66509d;
            boolean q16 = AEDashboardUtil.q();
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                        }
                    }
                    if (q16) {
                        bVar2 = this.f66514i;
                    } else {
                        bVar2 = this.f66512g;
                    }
                }
                if (q16) {
                    bVar2 = this.f66513h;
                } else {
                    bVar2 = this.f66511f;
                }
            } else if (q16) {
                bVar2 = this.f66510e;
            } else {
                bVar2 = this.f66509d;
            }
            a(bVar2, bVar);
            return bVar;
        }

        public TransitionCategoryItem d() {
            if (m.D()) {
                return g(5, HardCodeUtil.qqStr(R.string.v3s), 103, "tran_fade", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor_static.png", "fadecolor", "1", "9", "Basic");
            }
            return g(4, HardCodeUtil.qqStr(R.string.f172893v43), 103, "tran_default", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default_static.png", "LinearBlur", "1", "1", "Basic");
        }

        public ArrayList<QIMFilterCategoryItem> e() {
            ArrayList<QIMFilterCategoryItem> arrayList = new ArrayList<>(10);
            if (!m.D()) {
                arrayList.add(g(1, HardCodeUtil.qqStr(R.string.v3q), 103, "tran_move", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move_static.png", "speedWipe", "0", "3", "Basic"));
                arrayList.add(g(10, HardCodeUtil.qqStr(R.string.v46), 103, "tran_speedout", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut_static.png", "speedOut", "0", "4", "Basic"));
                arrayList.add(g(11, HardCodeUtil.qqStr(R.string.v4_), 103, "tran_filterCut", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut_static.png", "filterCut", "0", "5", "Basic"));
            }
            return arrayList;
        }

        public ArrayList<FilterCategory> f() {
            boolean D = m.D();
            ArrayList<FilterCategory> arrayList = new ArrayList<>(2);
            FilterCategory filterCategory = new FilterCategory(1001, HardCodeUtil.qqStr(R.string.v3p), false, false, 0, 0);
            ArrayList arrayList2 = new ArrayList(15);
            if (!D) {
                arrayList2.add(g(4, HardCodeUtil.qqStr(R.string.v48), 103, "tran_default", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default_static.png", "LinearBlur", "1", "1", "Basic"));
            }
            arrayList2.add(g(-1, HardCodeUtil.qqStr(R.string.f172894v44), 103, "tran_no", null, "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_no_static.png", "NoEffect", "1", "2", "Basic"));
            if (!D) {
                arrayList2.add(g(12, HardCodeUtil.qqStr(R.string.v47), 103, "tran_reverse", "https://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_turn.png", "https://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_turn_static.png", "Flipping", "1", "12", "Basic"));
                arrayList2.add(g(13, HardCodeUtil.qqStr(R.string.v3u), 103, "tran_recombine", "https://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_remix.png", "https://dl.url.cn/myapp/qq_desk/shortvideo/transition/trans_remix_static.png", "Recombination", "1", "13", "Basic"));
                arrayList2.add(g(1, HardCodeUtil.qqStr(R.string.f172891v40), 103, "tran_move", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move_static.png", "speedWipe", "1", "3", "Basic"));
                arrayList2.add(g(10, HardCodeUtil.qqStr(R.string.v4a), 103, "tran_speedout", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speedOut_static.png", "speedOut", "1", "4", "Basic"));
                arrayList2.add(g(11, HardCodeUtil.qqStr(R.string.v3y), 103, "tran_filterCut", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_filterCut_static.png", "filterCut", "1", "5", "Basic"));
                String model = DeviceInfoMonitor.getModel();
                if (model != null && !model.equals("MI NOTE LTE") && !model.equals("R7Plusm") && !model.equals("vivo X5M") && !model.equals("SLA-AL00") && !model.equals("vivo Y71A") && !model.equals("vivo Y66i A") && !model.equals("Redmi 4A") && !model.equals("vivo X6Plus A") && !model.equals("vivo Y31") && !model.equals("SCL-AL00") && !model.equals("2014813") && !model.equals("Redmi Note 5A") && !model.equals("A31")) {
                    arrayList2.add(g(3, HardCodeUtil.qqStr(R.string.v3t), 103, "tran_speed", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speed.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_speed_static.png", "speedLine", "1", "6", "Basic"));
                }
            }
            arrayList2.add(g(9, HardCodeUtil.qqStr(R.string.v3v), 103, "tran_slip", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_sideSlip.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_sideSlip_static.png", "sideSlip", "1", "7", "Basic"));
            arrayList2.add(g(8, HardCodeUtil.qqStr(R.string.v49), 103, "tran_light", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_flashOut.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_flashOut_static.png", "flashOut", "1", "8", "Basic"));
            arrayList2.add(g(5, HardCodeUtil.qqStr(R.string.v4b), 103, "tran_fade", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor_static.png", "fadecolor", "1", "9", "Basic"));
            arrayList2.add(g(6, HardCodeUtil.qqStr(R.string.f172895v45), 103, "tran_zoom", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_zoom.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_zoom_static.png", "simpleZoom", "1", "10", "Basic"));
            arrayList2.add(g(7, HardCodeUtil.qqStr(R.string.v3r), 103, "tran_wipe", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_wipe.png", "https://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_wipe_static.png", "directionalwipe", "1", "11", "Basic"));
            filterCategory.f66687f = arrayList2;
            arrayList.add(filterCategory);
            return arrayList;
        }

        public b h() {
            b bVar = new b();
            try {
                bVar = m.b(j(QIMFileUtils.c(IVideoFilterTools.FILTER_ASSET)), false, false, true);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("VideoFilterTools", 2, "v8 initFromAsset false", e16);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("VideoFilterTools", 2, "initFromAsset false size: " + bVar.f66517c.size());
            }
            return bVar;
        }

        public CopyOnWriteArrayList<FilterCategory> j(String str) throws JSONException {
            CopyOnWriteArrayList<FilterCategory> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<FilterDesc> it = FilterDesc.parse(jSONObject.getJSONArray("filters")).iterator();
            while (it.hasNext()) {
                FilterDesc next = it.next();
                m.f66483p.put(next.name, next);
            }
            JSONArray jSONArray = jSONObject.getJSONArray(IVideoFilterTools.CATEGORYS);
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(new FilterCategory(jSONArray.getJSONObject(i3), null));
            }
            copyOnWriteArrayList.clear();
            copyOnWriteArrayList.addAll(arrayList);
            ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).D(arrayList);
            JSONArray optJSONArray = jSONObject.optJSONArray(IVideoFilterTools.LOCK_CATEGORYS);
            if (optJSONArray != null) {
                for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i16);
                    if (optJSONObject != null) {
                        this.f66508c.put(optJSONObject.optString("comboId"), new LockedCategory(optJSONObject));
                    }
                }
            }
            return copyOnWriteArrayList;
        }

        public void k() {
            l(this.f66507b);
            this.f66509d = m.b(this.f66507b, true, false, false);
            this.f66511f = m.b(this.f66507b, false, true, false);
            this.f66512g = m.b(this.f66507b, false, false, false);
        }

        public void l(CopyOnWriteArrayList<FilterCategory> copyOnWriteArrayList) {
            com.tencent.aelight.camera.aioeditor.capture.data.g z16 = ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).z();
            Iterator<FilterCategory> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                FilterCategory next = it.next();
                if (next.f66689i) {
                    QIMFilterCategoryItem remove = next.f66687f.remove(0);
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    LinkedList linkedList3 = new LinkedList();
                    for (QIMFilterCategoryItem qIMFilterCategoryItem : next.f66687f) {
                        if (z16.c(qIMFilterCategoryItem.f66697d)) {
                            linkedList.add(qIMFilterCategoryItem);
                        } else {
                            m.n();
                            if (m.F(3, qIMFilterCategoryItem.f66701i, qIMFilterCategoryItem.f66697d)) {
                                linkedList2.add(qIMFilterCategoryItem);
                            } else {
                                linkedList3.add(qIMFilterCategoryItem);
                            }
                        }
                    }
                    Collections.shuffle(linkedList3);
                    Iterator it5 = linkedList2.iterator();
                    while (it5.hasNext()) {
                        linkedList3.add(0, (QIMFilterCategoryItem) it5.next());
                    }
                    Iterator it6 = linkedList.iterator();
                    while (it6.hasNext()) {
                        linkedList3.add(0, (QIMFilterCategoryItem) it6.next());
                    }
                    linkedList3.add(0, remove);
                    next.f66687f = linkedList3;
                }
            }
        }

        private void a(b bVar, b bVar2) {
            com.tencent.aelight.camera.aioeditor.d dVar = (com.tencent.aelight.camera.aioeditor.d) fr.f.c(13);
            ArrayList<FilterCategory> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < bVar.f66515a.size(); i3++) {
                if (!dVar.j(bVar.f66515a.get(i3).f66690m)) {
                    arrayList.add(bVar.f66515a.get(i3));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = (ArrayList) bVar.f66517c.clone();
            for (int i16 = 0; i16 < bVar.f66516b.size(); i16++) {
                if (!dVar.j(bVar.f66516b.get(i16).f66690m)) {
                    arrayList2.add(bVar.f66516b.get(i16));
                } else {
                    for (QIMFilterCategoryItem qIMFilterCategoryItem : bVar.f66516b.get(i16).f66687f) {
                        if (!qIMFilterCategoryItem.equals(bVar.f66520f)) {
                            arrayList3.remove(qIMFilterCategoryItem);
                        }
                    }
                }
            }
            ArrayList<FilterCategory> arrayList4 = (ArrayList) arrayList2.clone();
            ArrayList<QIMFilterCategoryItem> arrayList5 = (ArrayList) arrayList3.clone();
            int i17 = AEDashboardUtil.q() ? 2 : 1;
            if (dVar.k()) {
                Iterator<FilterCategory> it = arrayList4.iterator();
                while (it.hasNext()) {
                    FilterCategory next = it.next();
                    if (next != null && next.C != i17) {
                        it.remove();
                    }
                }
                Iterator<QIMFilterCategoryItem> it5 = arrayList5.iterator();
                while (it5.hasNext()) {
                    QIMFilterCategoryItem next2 = it5.next();
                    if (next2 != null && next2.C != i17) {
                        it5.remove();
                    }
                }
            }
            bVar2.f66515a = arrayList;
            bVar2.f66516b = arrayList4;
            bVar2.f66517c = arrayList5;
            bVar2.f66518d = bVar.f66518d;
            bVar2.f66519e = bVar.f66519e;
            bVar2.f66520f = bVar.f66520f;
        }

        private boolean i(b bVar) {
            if (bVar == null) {
                return false;
            }
            Iterator<FilterCategory> it = bVar.f66516b.iterator();
            while (it.hasNext()) {
                if (it.next().f66685d == 104) {
                    return true;
                }
            }
            ms.a.f("VideoFilterTools", "has no V8 config");
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<FilterCategory> f66515a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<FilterCategory> f66516b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<QIMFilterCategoryItem> f66517c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<QIMFilterCategoryItem> f66518d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        public QIMFilterCategoryItem f66519e = null;

        /* renamed from: f, reason: collision with root package name */
        public QIMFilterCategoryItem f66520f = null;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void C2(boolean z16);
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        String str = com.tencent.aelight.camera.aioeditor.richmedia.capture.data.a.f67458i;
        sb5.append(str);
        sb5.append("artfilter");
        String str2 = File.separator;
        sb5.append(str2);
        f66480m = sb5.toString();
        f66481n = com.tencent.mobileqq.activity.richmedia.g.f185856d + "dov_capture_qsvf" + str2;
        f66483p = new HashMap<>();
        f66484q = false;
        f66485r = false;
        f66487t = new Object();
        f66488u = false;
        f66489v = str + "lowlight";
        f66490w = f66489v + str2 + "LowLight.png";
        f66491x = 0;
        f66492y = 2;
        f66493z = 1;
        A = -1;
        B = 0;
    }

    m() {
        com.tencent.sveffects.a.b();
    }

    public static void A() {
        QIMRedDotConfig redDotConfigFromFile;
        if (f66486s != null || (redDotConfigFromFile = QIMRedDotConfig.getRedDotConfigFromFile(com.tencent.aelight.camera.aioeditor.richmedia.capture.data.a.f67458i)) == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "VideoFilterTools reddot config init");
        }
        synchronized (f66487t) {
            f66486s = redDotConfigFromFile;
        }
    }

    public static boolean B(Context context) {
        ArrayList<AEResInfo> arrayList = new ArrayList();
        arrayList.add(AEResInfo.AE_RES_BASE_PACKAGE);
        arrayList.add(AEResInfo.LIGHT_RES_BASE_PACKAGE);
        arrayList.add(AEResInfo.LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE);
        arrayList.add(AEResInfo.LIGHT_RES_BUNDLE_SCENE);
        boolean z16 = true;
        for (AEResInfo aEResInfo : arrayList) {
            if (((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(aEResInfo)) {
                ms.a.f("VideoFilterTools", "[handleDownloadAERes], resInfo=" + aEResInfo + " local file exists");
            } else {
                ms.a.f("VideoFilterTools", "[handleDownloadAERes], resInfo=" + aEResInfo + " start download");
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aEResInfo.agentType);
                z16 = false;
            }
        }
        if (!((IAEPhotoAIManager) QRoute.api(IAEPhotoAIManager.class)).isPhotoAIResExist()) {
            ((IAEPhotoAIManager) QRoute.api(IAEPhotoAIManager.class)).downloadPhotoAIRes();
            ms.a.f("VideoFilterTools", "photo ai res not exist.");
            z16 = false;
        }
        if (z16) {
            String soPathDir = SdkContext.getInstance().getResources().getPtuFilterResource().getSoPathDir();
            ms.a.a("VideoFilterTools", "initAEKit modelPath = " + soPathDir);
            AEModule.initialize(BaseApplication.getContext(), AEModuleConfig.newBuilder().setLoadSo(false).setModelDir(soPathDir).setSoDir(soPathDir).setAuthMode(1).setEnableDebug(false).setFramebufferFetchEnable(false).setEnableResourceCheck(false).setEnableProfiler(false).setEnableDefaultBasic3(false).build());
            if (!com.tencent.aelight.camera.ae.d.t()) {
                boolean s16 = com.tencent.aelight.camera.ae.d.s();
                ms.a.f("VideoFilterTools", "load in light process, status: " + s16);
                if (!s16) {
                    z16 = false;
                }
            } else {
                ms.a.c("VideoFilterTools", "init ready.");
            }
            if (!FeatureManager.Features.PAG.init() || !FeatureManager.Features.PTU_TOOLS.init() || !FeatureManager.Features.PTU_ALGO.init() || !FeatureManager.Features.IMAGE_ALGO.init()) {
                ms.a.c("VideoFilterTools", "init failed.");
                return false;
            }
        }
        return z16;
    }

    public static boolean C() {
        boolean hasQmcfEntrance = QmcfManager.getInstance().hasQmcfEntrance(1);
        if (!hasQmcfEntrance) {
            return hasQmcfEntrance;
        }
        int b16 = cr2.a.b();
        boolean z16 = b16 > 0;
        if (!z16) {
            QmcfManager.getInstance().setQmcfMobileNotSupport(cr2.a.f391695d);
            QLog.d("VideoFilterTools", 1, String.format("isArtFilterSupport supportFrameType[%d], gpuinfo[%s], model[%s]", Integer.valueOf(b16), cr2.a.f391695d, DeviceInfoMonitor.getModel()));
        }
        return z16;
    }

    public static boolean D() {
        if (f66485r) {
            return f66484q;
        }
        f66485r = true;
        f66484q = false;
        String model = DeviceInfoMonitor.getModel();
        if (model.equals("ZTE BA610C") || model.equals("ZTE BA610T") || model.equals("vivo Y51A") || model.equals("vivo Y51") || model.equals("vivo Y37") || model.equals("OPPO A37t") || model.equals("OPPO A37m") || model.equals("SLA-TL10") || model.equals("SM-A5000") || model.equals("SM-A8000") || model.equals("HUAWEI GRA-TL00") || model.equals("OPPO A33m") || model.equals("OPPO A33") || model.equals("vivo X6A") || model.equals("CUN-AL00") || model.equals("Redmi 3") || model.equals("CAM-TL00") || model.equals("vivo Y35A") || model.equals("KIW-AL10") || model.equals("vivo Y31A") || model.equals("OPPO A53m") || model.equals("OPPO A53") || model.equals("OPPO R7sm") || model.equals("M6 Note") || model.equals("HUAWEI TIT-AL00") || model.equals("CUN-TL00") || model.equals("HUAWEI TIT-TL00") || model.equals("m2")) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoFilterTools", 2, "in TransitionBlackModel:" + model);
            }
            f66484q = true;
        }
        return f66484q;
    }

    public static boolean F(int i3, int i16, String str) {
        synchronized (f66487t) {
            QIMRedDotConfig qIMRedDotConfig = f66486s;
            if (qIMRedDotConfig == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig_Filter", 2, "needShowRedDot|mQIMRedDotConfig is null");
                }
                return false;
            }
            boolean needShowRedDot = qIMRedDotConfig.needShowRedDot(i3, i16, str);
            if (needShowRedDot && QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("ShowRedDot==> type=");
                sb5.append(i3);
                if (i3 == 2) {
                    sb5.append(",categoryId=");
                    sb5.append(i16);
                } else if (i3 == 3) {
                    sb5.append(",id=");
                    sb5.append(str);
                } else if (i3 == 4) {
                    sb5.append(",defaultId=");
                    sb5.append(f66486s.defaultUseId);
                } else if (i3 == 5) {
                    sb5.append(",defaultCategoryId=");
                    sb5.append(f66486s.defaultCategoryId);
                } else if (i3 == 7) {
                    sb5.append(",comboDefaultCategoryId=");
                    sb5.append(f66486s.comboDefaultCategoryId);
                }
                QLog.d("QIMRedDotConfig_Filter", 2, sb5.toString());
            }
            return needShowRedDot;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static ArrayList<FilterDesc> G(String str) {
        ArrayList<FilterDesc> arrayList;
        if (!TextUtils.isEmpty(str)) {
            AVCoreLog.printColorLog("VideoFilterTools", "parseConfig|content is empty.");
            try {
                arrayList = FilterDesc.parse(new JSONObject(str).getJSONArray("filters"));
            } catch (JSONException e16) {
                e16.printStackTrace();
                AVCoreLog.i("VideoFilterTools", "parseConfig|parse failed.context = " + str);
            }
            return arrayList != null ? new ArrayList<>() : arrayList;
        }
        arrayList = null;
        if (arrayList != null) {
        }
    }

    private static void I(Context context) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_filter_config_sp", 4).edit();
        edit.putInt("dov_video_filter_first_change_path", 1);
        edit.commit();
    }

    public static void R(Context context, int i3) {
        AVCoreLog.d("VideoFilterTools", "setQQShortVideoFilterConfigVersion:" + i3);
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_filter_config_sp", 4).edit();
        edit.putInt("dov_video_filter_config_version_775", i3);
        edit.commit();
    }

    public static void W(Context context, String str) {
        if (str == null) {
            AVCoreLog.i("VideoFilterTools", "updateQQShortVideoFilterConfig error ");
            return;
        }
        ms.a.f("VideoFilterTools", "updateQQShortVideoFilterConfig");
        if (o(BaseApplication.getContext())) {
            I(BaseApplication.getContext());
            String str2 = f66481n;
            if (new File(str2).exists()) {
                FileUtils.deleteDirectory(str2);
            }
        }
        c(context, str, q(context));
        if (X(str)) {
            FileUtils.writeFile(com.tencent.aelight.camera.aioeditor.richmedia.capture.data.a.f67458i, IVideoFilterTools.BASE_CONFIG, str);
        }
    }

    static void c(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<FilterDesc> arrayList = null;
        ArrayList<FilterDesc> G = (str == null || str.equals("")) ? null : G(str);
        if (str2 != null && !str2.equals("")) {
            arrayList = G(str2);
        }
        if (G == null) {
            FileUtils.deleteDirectory(com.tencent.aelight.camera.aioeditor.richmedia.capture.data.a.f67459j);
        } else if (arrayList != null) {
            Iterator<FilterDesc> it = arrayList.iterator();
            while (it.hasNext()) {
                FilterDesc next = it.next();
                Iterator<FilterDesc> it5 = G.iterator();
                while (it5.hasNext()) {
                    FilterDesc next2 = it5.next();
                    String str3 = next2.name;
                    if (str3 != null && str3.equals(next.name)) {
                        AVCoreLog.d("VideoFilterTools", "compareContent res:" + next2.name + "|" + next2.resMD5 + "|" + next.resMD5);
                        if (!TextUtils.isEmpty(next2.resMD5) && !next2.resMD5.equals(next.resMD5)) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("compareContentDelete res:");
                            String str4 = com.tencent.aelight.camera.aioeditor.richmedia.capture.data.a.f67459j;
                            sb5.append(next.getResFold(str4));
                            AVCoreLog.d("VideoFilterTools", sb5.toString());
                            FileUtils.deleteDirectory(next.getResFold(str4));
                        }
                        AVCoreLog.d("VideoFilterTools", "compareContent iconMD5:" + next2.name + "|" + next2.iconMD5 + "|" + next.iconMD5);
                        if (!TextUtils.isEmpty(next2.iconMD5) && !next2.iconMD5.equals(next.iconMD5)) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("compareContentDelete iconMD5:");
                            String str5 = com.tencent.aelight.camera.aioeditor.richmedia.capture.data.a.f67459j;
                            sb6.append(next.getIconFile(str5));
                            AVCoreLog.d("VideoFilterTools", sb6.toString());
                            FileUtils.deleteFile(next.getIconFile(str5));
                        }
                    }
                }
            }
        }
        AVCoreLog.d("VideoFilterTools", "compareContent :" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static JSONArray d(List<FilterDesc> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (FilterDesc filterDesc : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(QCircleSchemeAttr.Polymerize.FILTER_ID, filterDesc.f281357id + "");
                jSONObject.put("type", filterDesc.type + "");
                jSONObject.put("name", filterDesc.name);
                jSONObject.put("respicname", filterDesc.respicname);
                jSONObject.put("version", filterDesc.version);
                jSONObject.put("md5", filterDesc.resMD5);
                jSONObject.put("resurl", filterDesc.resurl);
                jSONArray.mo162put(jSONObject);
            }
        } catch (Exception e16) {
            QLog.w("VideoFilterTools", 2, "convertFilterDesc" + e16.toString());
        }
        QLog.w("VideoFilterTools", 2, "convertFilterDesc json" + jSONArray.toString());
        return jSONArray;
    }

    public static void g(Context context, List<QIMFilterCategoryItem> list) {
        boolean z16 = context instanceof EditPicActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        File file = new File(f66490w);
        if (file.exists()) {
            file.delete();
        } else {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
        }
        Bitmap lowLightImage = LowLightTools.getLowLightImage(3.0f, 0.88f, 0.96f, 1.22f, false);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            lowLightImage.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e16) {
            QLog.w("VideoFilterTools", 2, "LowLightTools saveBitmap:" + e16);
        }
        if (!file.exists()) {
            f66491x = A;
        } else {
            f66491x = f66492y;
        }
    }

    public static ArrayList<FilterCategory> l(CopyOnWriteArrayList<FilterCategory> copyOnWriteArrayList, int i3, boolean z16) {
        boolean z17;
        boolean z18;
        ArrayList<FilterCategory> arrayList = new ArrayList<>();
        boolean z19 = C() && z16;
        Iterator<FilterCategory> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            FilterCategory next = it.next();
            if (i3 == 1 && next.f66688h) {
                FilterCategory filterCategory = new FilterCategory(next.f66685d, next.f66686e, next.f66688h, next.f66689i, next.f66690m, next.C);
                filterCategory.f66688h = true;
                for (QIMFilterCategoryItem qIMFilterCategoryItem : next.f66687f) {
                    if (z19 || !QIMFilterCategoryItem.f(qIMFilterCategoryItem)) {
                        if (!QIMFilterCategoryItem.m(qIMFilterCategoryItem)) {
                            filterCategory.f66687f.add(qIMFilterCategoryItem);
                        }
                    }
                }
                if (filterCategory.f66687f.size() > 0) {
                    Iterator<QIMFilterCategoryItem> it5 = filterCategory.f66687f.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            z18 = true;
                            break;
                        }
                        if (!it5.next().l()) {
                            z18 = false;
                            break;
                        }
                    }
                    if (!z18) {
                        arrayList.add(filterCategory);
                    }
                }
            } else if (i3 == 2 && !next.f66688h) {
                FilterCategory filterCategory2 = new FilterCategory(next.f66685d, next.f66686e, next.f66688h, next.f66689i, next.f66690m, next.C);
                filterCategory2.f66688h = false;
                for (QIMFilterCategoryItem qIMFilterCategoryItem2 : next.f66687f) {
                    if (z19 || !QIMFilterCategoryItem.f(qIMFilterCategoryItem2)) {
                        if (!QIMFilterCategoryItem.m(qIMFilterCategoryItem2)) {
                            filterCategory2.f66687f.add(qIMFilterCategoryItem2);
                        }
                    }
                }
                if (filterCategory2.f66687f.size() > 0) {
                    Iterator<QIMFilterCategoryItem> it6 = filterCategory2.f66687f.iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            z17 = true;
                            break;
                        }
                        if (!it6.next().l()) {
                            z17 = false;
                            break;
                        }
                    }
                    if (!z17) {
                        arrayList.add(filterCategory2);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(20);
            sb5.append("getFilterCategory categoryType:");
            sb5.append(i3);
            sb5.append(" filter:");
            sb5.append(arrayList.size());
            QLog.d("VideoFilterTools", 2, sb5.toString());
        }
        return arrayList;
    }

    public static m n() {
        if (f66482o == null) {
            f66482o = new m();
        }
        return f66482o;
    }

    private static boolean o(Context context) {
        int i3 = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_filter_config_sp", 4).getInt("dov_video_filter_first_change_path", 0);
        AVCoreLog.d("VideoFilterTools", "getIsfisrtChangePath:" + i3);
        return i3 == 0;
    }

    public static String q(Context context) {
        String str = null;
        try {
            StringBuilder sb5 = new StringBuilder();
            String str2 = com.tencent.aelight.camera.aioeditor.richmedia.capture.data.a.f67458i;
            sb5.append(str2);
            sb5.append(IVideoFilterTools.BASE_CONFIG);
            File file = new File(sb5.toString());
            AVCoreLog.d("VideoFilterTools", "getQQShortVideoFilterConfig:" + str2 + IVideoFilterTools.BASE_CONFIG + "|" + file.exists());
            if (file.exists()) {
                str = FileUtils.readFileToString(file);
            } else {
                R(context, 0);
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        } catch (Error e17) {
            e17.printStackTrace();
        }
        return str;
    }

    public static int r(Context context) {
        int i3 = 0;
        int i16 = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_filter_config_sp", 4).getInt("dov_video_filter_config_version_775", 0);
        if (i16 > 0) {
            if (!new File(com.tencent.aelight.camera.aioeditor.richmedia.capture.data.a.f67458i + IVideoFilterTools.BASE_CONFIG).exists()) {
                AVCoreLog.i("VideoFilterTools", "getQQShortVideoFilterConfigVersion config file don't exist!");
                AVCoreLog.d("VideoFilterTools", "getQQShortVideoFilterConfigVersion:" + i3);
                return i3;
            }
        }
        i3 = i16;
        AVCoreLog.d("VideoFilterTools", "getQQShortVideoFilterConfigVersion:" + i3);
        return i3;
    }

    public static void w(String str) {
        if (str == null) {
            AVCoreLog.i("VideoFilterTools", "handleQQSvCommonConfig empty content!");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("CommonConfig");
            if (jSONObject.getJSONObject("SvArtFilter") != null) {
                QmcfManager.getInstance().updateQmcfMainSwitch(jSONObject.getJSONObject("SvArtFilter"));
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("VideoFilterTools", 2, "handleQQSvCommonConfig error!", e16);
            }
        }
    }

    public boolean E() {
        return this.f66500g;
    }

    void H(CopyOnWriteArrayList<FilterCategory> copyOnWriteArrayList) {
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            AVCoreLog.d("VideoFilterTools", " preDownloadResource Categorylist size: " + copyOnWriteArrayList.size());
            com.tencent.aelight.camera.aioeditor.capture.data.d dVar = (com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5);
            Iterator<FilterCategory> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                FilterCategory next = it.next();
                if (!next.f66688h) {
                    Iterator<QIMFilterCategoryItem> it5 = next.f66687f.iterator();
                    while (it5.hasNext()) {
                        com.tencent.aelight.camera.aioeditor.capture.data.j s16 = dVar.s(it5.next());
                        if (s16.w() && s16.j() == 2) {
                            s16.h();
                        }
                    }
                }
            }
            return;
        }
        AVCoreLog.i("VideoFilterTools", "preDownloadResource list is empty!");
    }

    public void L(QIMFilterCategoryItem qIMFilterCategoryItem, int i3) {
        this.f66505l[i3] = qIMFilterCategoryItem;
    }

    public void N(FilterDesc filterDesc) {
        if (filterDesc != null) {
            AVCoreLog.printColorLog("VideoFilterTools", "setCurrentId id: " + filterDesc.f281357id);
        } else {
            AVCoreLog.printColorLog("VideoFilterTools", "setCurrentId null");
        }
        this.f66494a = filterDesc;
    }

    public void O(int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.d("QCombo", 2, "setFrontCaptureScene " + i3);
        }
        this.f66497d = i3;
    }

    public void P(boolean z16) {
        this.f66500g = z16;
    }

    public void Q(EditVideoPartManager editVideoPartManager) {
        this.f66498e = editVideoPartManager;
    }

    public void S(Bitmap bitmap) {
        Bitmap bitmap2 = this.f66499f;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f66499f = null;
            QLog.i("VideoFilterTools", 1, "setRawBitmap recycled!");
        }
        try {
            this.f66499f = bitmap.copy(bitmap.getConfig(), true);
        } catch (Throwable th5) {
            QLog.e("VideoFilterTools", 1, "setRawBitmap error!", th5);
        }
    }

    public void T(TransitionCategoryItem transitionCategoryItem) {
        this.f66503j = transitionCategoryItem;
    }

    public void V(QIMFilterCategoryItem qIMFilterCategoryItem, Activity activity, int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.d("QCombo", 2, "setSelectedFilter " + qIMFilterCategoryItem + " scene " + i3);
        }
        if (i3 == -1) {
            return;
        }
        QIMFilterCategoryItem[] qIMFilterCategoryItemArr = this.f66504k;
        QIMFilterCategoryItem qIMFilterCategoryItem2 = qIMFilterCategoryItemArr[i3];
        qIMFilterCategoryItemArr[i3] = qIMFilterCategoryItem;
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "setSelectedFilter last:" + qIMFilterCategoryItem2);
        }
        if (qIMFilterCategoryItem == null || qIMFilterCategoryItem.l()) {
            return;
        }
        Y(3, qIMFilterCategoryItem.f66701i, qIMFilterCategoryItem.f66697d);
    }

    public void Y(int i3, int i16, String str) {
        synchronized (f66487t) {
            QIMRedDotConfig qIMRedDotConfig = f66486s;
            if (qIMRedDotConfig == null) {
                return;
            }
            if (qIMRedDotConfig.updateRedDotInfo(i3, i16, str) && QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("updateRedDotInfo==> type=");
                sb5.append(i3);
                if (i3 == 2) {
                    sb5.append(",categoryId=");
                    sb5.append(i16);
                } else if (i3 == 3) {
                    sb5.append(",id=");
                    sb5.append(str);
                } else if (i3 == 4) {
                    sb5.append(",defaultId=");
                    sb5.append(f66486s.defaultUseId);
                } else if (i3 == 5) {
                    sb5.append(",defaultCategoryId=");
                    sb5.append(f66486s.defaultCategoryId);
                } else if (i3 == 7) {
                    sb5.append(",comboDefaultCategoryId=");
                    sb5.append(f66486s.comboDefaultCategoryId);
                }
                QLog.d("QIMRedDotConfig_Filter", 2, sb5.toString());
            }
        }
    }

    public QIMFilterCategoryItem i(int i3) {
        return this.f66505l[i3];
    }

    public int j() {
        synchronized (f66487t) {
            QIMRedDotConfig qIMRedDotConfig = f66486s;
            if (qIMRedDotConfig == null || qIMRedDotConfig.hasChoose) {
                return -1;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("QIMRedDotConfig_Filter", 2, "getDefaultCategoryId=" + f66486s.defaultCategoryId);
            }
            return f66486s.defaultCategoryId;
        }
    }

    public int k() {
        synchronized (f66487t) {
            QIMRedDotConfig qIMRedDotConfig = f66486s;
            if (qIMRedDotConfig == null || qIMRedDotConfig.comboHasChoose) {
                return -1;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig_Filter", 2, "getDefaultComboCategoryId=" + f66486s.comboDefaultCategoryId);
            }
            return f66486s.comboDefaultCategoryId;
        }
    }

    public FilterDesc m(String str) {
        return f66483p.get(str);
    }

    public EditVideoPartManager p() {
        return this.f66498e;
    }

    public Bitmap s() {
        Bitmap bitmap = this.f66499f;
        if (bitmap == null || bitmap.isRecycled()) {
            EditVideoPartManager editVideoPartManager = this.f66498e;
            Bitmap S = editVideoPartManager != null ? editVideoPartManager.S() : null;
            if (S != null) {
                Bitmap.Config config = S.getConfig();
                if (config != null) {
                    this.f66499f = S.copy(config, true);
                } else {
                    QLog.e("VideoFilterTools", 1, "the bitmap config is null!");
                    return null;
                }
            }
        }
        return this.f66499f;
    }

    public QIMFilterCategoryItem t(int i3) {
        return this.f66501h[i3];
    }

    public QIMFilterCategoryItem u(int i3) {
        return this.f66504k[i3];
    }

    public TransitionCategoryItem v() {
        return this.f66503j;
    }

    public void x(Context context, c cVar, boolean z16) {
        CopyOnWriteArrayList<FilterCategory> copyOnWriteArrayList;
        synchronized (this) {
            com.tencent.aelight.camera.aioeditor.capture.data.d dVar = (com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5);
            a aVar = dVar.I;
            if (aVar != null) {
                AVCoreLog.d("VideoFilterTools", "already inited");
            } else {
                AVCoreLog.i("VideoFilterTools", "initCaptureComboManager");
                if (!z(BaseApplicationImpl.sApplication)) {
                    y();
                }
                aVar = dVar.I;
            }
            if (aVar != null) {
                copyOnWriteArrayList = aVar.f66507b;
            } else {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (cVar != null) {
                cVar.C2(false);
            }
            if (z16) {
                H(copyOnWriteArrayList);
            }
        }
    }

    public boolean y() {
        A();
        boolean z16 = true;
        try {
            ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).L(new a(QIMFileUtils.c(IVideoFilterTools.FILTER_ASSET)));
        } catch (Exception e16) {
            QLog.i("VideoFilterTools", 1, "initFromAsset false", e16);
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoFilterTools", 2, "initFromAsset " + z16);
        }
        return z16;
    }

    public boolean z(Context context) {
        A();
        String q16 = q(context);
        boolean z16 = false;
        try {
            if (!TextUtils.isEmpty(q16)) {
                a aVar = new a(q16);
                ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).L(aVar);
                z16 = !aVar.f66507b.isEmpty();
            }
        } catch (Exception e16) {
            QLog.i("VideoFilterTools", 1, "initFromCache", e16);
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoFilterTools", 2, "initFromCache " + z16);
        }
        return z16;
    }

    public void K(PublishVideoEntry publishVideoEntry) {
        QQFilterRenderManager b16;
        List<FilterDesc> currentAVFilterIdList;
        QLog.w("VideoFilterTools", 2, "saveRenderManagerData begin");
        if (publishVideoEntry == null || (b16 = com.tencent.mobileqq.filter.f.b(com.tencent.mobileqq.filter.f.f209753c)) == null || (currentAVFilterIdList = b16.getBusinessOperation().getCurrentAVFilterIdList()) == null || currentAVFilterIdList.size() <= 0) {
            return;
        }
        publishVideoEntry.putExtra("hasAVFilter", Boolean.TRUE);
        publishVideoEntry.putExtra("jsonAVFilterData", d(currentAVFilterIdList));
        MusicItemInfo musicItemInfo = b16.getBusinessOperation().getMusicItemInfo();
        if (musicItemInfo != null) {
            publishVideoEntry.putExtra("jsonMusicData", musicItemInfo.convertToJSON());
        }
    }

    public void e() {
        this.f66498e = null;
        Bitmap bitmap = this.f66499f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f66499f = null;
        }
    }

    public static void J(boolean z16) {
        if (z16) {
            QIMRedDotConfig qIMRedDotConfig = f66486s;
            if (qIMRedDotConfig == null || !qIMRedDotConfig.update) {
                return;
            }
            qIMRedDotConfig.update = false;
            QIMRedDotConfig.saveRedDotConfig(qIMRedDotConfig, com.tencent.aelight.camera.aioeditor.richmedia.capture.data.a.f67458i);
            return;
        }
        QIMRedDotConfig.saveRedDotConfig(f66486s, com.tencent.aelight.camera.aioeditor.richmedia.capture.data.a.f67458i);
    }

    public static boolean X(String str) {
        try {
            synchronized (f66487t) {
                JSONObject jSONObject = new JSONObject(str);
                if (f66486s == null) {
                    f66486s = new QIMRedDotConfig(1);
                    if (QLog.isColorLevel()) {
                        QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer config is null");
                    }
                }
                int optInt = jSONObject.optInt("iconRedDotVersion");
                boolean optBoolean = jSONObject.optBoolean("needRedDot");
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + f66486s.iconVersion + ",ver=" + optInt + ",showRed " + optBoolean);
                }
                QIMRedDotConfig qIMRedDotConfig = f66486s;
                if (qIMRedDotConfig.iconVersion != optInt) {
                    qIMRedDotConfig.iconVersion = optInt;
                    qIMRedDotConfig.showRedDot = optBoolean;
                    qIMRedDotConfig.hasShow = false;
                    qIMRedDotConfig.firstShowTime = 0L;
                }
                int optInt2 = jSONObject.optInt(QIMRedDotConfig.COMB0_ICON_VERSION_ID);
                boolean optBoolean2 = jSONObject.optBoolean(QIMRedDotConfig.COMBO_SHOW_RED_DOT);
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer combo oldVer=" + f66486s.comboIconVersion + ",ver=" + optInt2 + ",showRed " + optBoolean2);
                }
                QIMRedDotConfig qIMRedDotConfig2 = f66486s;
                if (qIMRedDotConfig2.comboIconVersion != optInt2) {
                    qIMRedDotConfig2.comboIconVersion = optInt2;
                    qIMRedDotConfig2.comboShowRedDot = optBoolean2;
                    qIMRedDotConfig2.comboHasShow = false;
                    qIMRedDotConfig2.comboFirstShowTime = 0L;
                }
                int optInt3 = jSONObject.optInt(QIMRedDotConfig.COMBO_DEFAULT_CATEGORY_VERSION);
                int optInt4 = jSONObject.optInt(QIMRedDotConfig.COMBO_DEFAULT_CATEGORY_ID, -1);
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + f66486s.comboDefaultCategoryVer + ",ver=" + optInt3 + ",comboDefaultCategoryId " + optInt4);
                }
                QIMRedDotConfig qIMRedDotConfig3 = f66486s;
                if (qIMRedDotConfig3.comboDefaultCategoryVer != optInt3) {
                    qIMRedDotConfig3.comboDefaultCategoryVer = optInt3;
                    qIMRedDotConfig3.comboDefaultCategoryId = optInt4;
                    qIMRedDotConfig3.comboHasChoose = false;
                }
                int optInt5 = jSONObject.optInt("defaultCategoryVersion");
                int optInt6 = jSONObject.optInt("defaultCategoryId", -1);
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + f66486s.defaultCategoryVer + ",ver=" + optInt5 + ",defaultCategoryId " + optInt6);
                }
                QIMRedDotConfig qIMRedDotConfig4 = f66486s;
                if (qIMRedDotConfig4.defaultCategoryVer != optInt5) {
                    qIMRedDotConfig4.defaultCategoryVer = optInt5;
                    qIMRedDotConfig4.defaultCategoryId = optInt6;
                    qIMRedDotConfig4.hasChoose = false;
                }
                int optInt7 = jSONObject.optInt("defaultUseVersion");
                String optString = jSONObject.optString("defaultUseId");
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + f66486s.defaultUseVer + ",ver=" + optInt7 + ",defaultUseId " + optString);
                }
                QIMRedDotConfig qIMRedDotConfig5 = f66486s;
                if (qIMRedDotConfig5.defaultUseVer != optInt7) {
                    qIMRedDotConfig5.defaultUseVer = optInt7;
                    qIMRedDotConfig5.defaultUseId = optString;
                    qIMRedDotConfig5.hasUse = false;
                }
                int optInt8 = jSONObject.optInt("itemRedDotVersion");
                QIMRedDotConfig qIMRedDotConfig6 = f66486s;
                if (qIMRedDotConfig6.redDotVersion != optInt8) {
                    qIMRedDotConfig6.redDotVersion = optInt8;
                    qIMRedDotConfig6.redDotItems.clear();
                    if (jSONObject.has("itemNeedRedDot")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("itemNeedRedDot");
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("updateFromServer redDotList: ");
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            String optString2 = jSONArray.optString(i3);
                            if (!TextUtils.isEmpty(optString2)) {
                                QIMRedDotConfig.RedDotItemConfig redDotItemConfig = new QIMRedDotConfig.RedDotItemConfig();
                                redDotItemConfig.filterId = optString2;
                                sb5.append(optString2);
                                sb5.append(",");
                                f66486s.redDotItems.put(optString2, redDotItemConfig);
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("QIMRedDotConfig_Filter", 2, sb5.toString());
                        }
                    }
                }
                J(false);
                if (QLog.isDevelopLevel()) {
                    QLog.d("QCombo", 2, "updateComboConfig accept");
                }
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QIMRedDotConfig_Filter", 2, "updateRedDotConfigFromServer null", e16);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("QCombo", 2, "updateRedDotConfigFromServer fail");
            }
            return false;
        }
    }

    public static b b(CopyOnWriteArrayList<FilterCategory> copyOnWriteArrayList, boolean z16, boolean z17, boolean z18) {
        b bVar = new b();
        boolean C = C();
        ArrayList<FilterCategory> l3 = l(copyOnWriteArrayList, 1, C);
        ArrayList<FilterCategory> l16 = l(copyOnWriteArrayList, 2, C);
        ArrayList<QIMFilterCategoryItem> arrayList = new ArrayList<>();
        ArrayList<QIMFilterCategoryItem> arrayList2 = new ArrayList<>();
        ArrayList<FilterCategory> arrayList3 = new ArrayList<>();
        Iterator<FilterCategory> it = l3.iterator();
        QIMFilterCategoryItem qIMFilterCategoryItem = null;
        while (it.hasNext()) {
            FilterCategory next = it.next();
            FilterCategory filterCategory = new FilterCategory(next.f66685d, next.f66686e, next.f66688h, next.f66689i, next.f66690m, next.C);
            for (QIMFilterCategoryItem qIMFilterCategoryItem2 : next.f66687f) {
                if (qIMFilterCategoryItem2.l() && qIMFilterCategoryItem == null) {
                    qIMFilterCategoryItem = qIMFilterCategoryItem2;
                }
                QIMFilterCategoryItem clone = qIMFilterCategoryItem2.clone();
                if (!z17 || clone.a()) {
                    filterCategory.f66687f.add(clone);
                    arrayList.add(clone);
                }
            }
            arrayList3.add(filterCategory);
        }
        ArrayList<FilterCategory> arrayList4 = new ArrayList<>();
        Iterator<FilterCategory> it5 = l16.iterator();
        QIMFilterCategoryItem qIMFilterCategoryItem3 = null;
        while (it5.hasNext()) {
            FilterCategory next2 = it5.next();
            if (!z18 || next2.f66685d != 103) {
                if (z18 || next2.f66685d != 104) {
                    FilterCategory filterCategory2 = new FilterCategory(next2.f66685d, next2.f66686e, next2.f66688h, next2.f66689i, next2.f66690m, next2.C);
                    for (QIMFilterCategoryItem qIMFilterCategoryItem4 : next2.f66687f) {
                        if (qIMFilterCategoryItem4.l() && qIMFilterCategoryItem3 == null) {
                            qIMFilterCategoryItem3 = qIMFilterCategoryItem4;
                        }
                        QIMFilterCategoryItem clone2 = qIMFilterCategoryItem4.clone();
                        if (!z17 || clone2.a()) {
                            filterCategory2.f66687f.add(clone2);
                            arrayList.add(clone2);
                            arrayList2.add(clone2);
                        }
                    }
                    arrayList4.add(filterCategory2);
                }
            }
        }
        bVar.f66515a = arrayList3;
        bVar.f66516b = arrayList4;
        bVar.f66518d = arrayList;
        bVar.f66517c = arrayList2;
        bVar.f66519e = qIMFilterCategoryItem;
        bVar.f66520f = qIMFilterCategoryItem3;
        return bVar;
    }

    public static void f(List<QIMFilterCategoryItem> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<QIMFilterCategoryItem> it = list.iterator();
        while (it.hasNext()) {
            ArrayList<String> arrayList = it.next().F;
            if (arrayList != null) {
                Iterator<String> it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    FilterDesc m3 = n().m(it5.next());
                    if (m3 != null && QQAVImageFilterConstants.isMusicSpecialFilter(m3.f281357id)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void M(com.tencent.aelight.camera.aioeditor.capture.data.h hVar, Activity activity, int i3) {
        if (i3 == 0) {
            com.tencent.aelight.camera.aioeditor.capture.data.h[] hVarArr = this.f66502i;
            hVarArr[2] = hVar;
            hVarArr[1] = hVar;
        } else if (i3 == -1) {
            return;
        }
        this.f66502i[i3] = hVar;
    }

    public void U(QIMFilterCategoryItem qIMFilterCategoryItem, Activity activity, int i3) {
        if (i3 == 0) {
            QIMFilterCategoryItem[] qIMFilterCategoryItemArr = this.f66501h;
            qIMFilterCategoryItemArr[2] = qIMFilterCategoryItem;
            qIMFilterCategoryItemArr[1] = qIMFilterCategoryItem;
        } else if (i3 == -1) {
            return;
        }
        QIMFilterCategoryItem qIMFilterCategoryItem2 = this.f66501h[i3];
        if (qIMFilterCategoryItem2 != null && qIMFilterCategoryItem != null && TextUtils.equals(qIMFilterCategoryItem2.f66697d, qIMFilterCategoryItem.f66697d)) {
            qIMFilterCategoryItem = qIMFilterCategoryItem2;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "setSelectedCombo last:" + qIMFilterCategoryItem2 + " new:" + qIMFilterCategoryItem + ", " + i3);
        }
        this.f66501h[i3] = qIMFilterCategoryItem;
        if (qIMFilterCategoryItem == null || qIMFilterCategoryItem.l()) {
            return;
        }
        Y(3, qIMFilterCategoryItem.f66701i, qIMFilterCategoryItem.f66697d);
    }
}
