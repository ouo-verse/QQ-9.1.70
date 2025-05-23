package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.editor.util.h;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.ttpic.openapi.initializer.Feature;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEDashboardUtil {

    /* renamed from: a, reason: collision with root package name */
    private static int f62608a = js.a.f410904d.b();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f62609b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f62610c = false;

    /* renamed from: d, reason: collision with root package name */
    public static final e f62611d = new e();

    /* renamed from: e, reason: collision with root package name */
    private static final List<Feature> f62612e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    private static final List<Pair<String, Integer>> f62613f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    private static final List<d> f62614g = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    private static final MutableLiveData<d> f62615h = new MutableLiveData<>();

    /* renamed from: i, reason: collision with root package name */
    private static final MutableLiveData<Float> f62616i = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            if (cVar.f62625b) {
                return 1;
            }
            return cVar2.f62625b ? -1 : 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f62622a;

        /* renamed from: b, reason: collision with root package name */
        public String f62623b = "null";

        public String toString() {
            return this.f62622a + ", value=" + this.f62623b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f62624a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f62625b;

        /* renamed from: c, reason: collision with root package name */
        public String f62626c = "null";

        /* renamed from: d, reason: collision with root package name */
        public String f62627d = "null";

        public String toString() {
            return this.f62624a + ", ready=" + this.f62625b + ", extraInfo=" + this.f62627d + ", error=" + this.f62626c;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public int f62631a;

        /* renamed from: b, reason: collision with root package name */
        public int f62632b;

        /* renamed from: c, reason: collision with root package name */
        public int f62633c;

        /* renamed from: d, reason: collision with root package name */
        public int f62634d;

        /* renamed from: e, reason: collision with root package name */
        public int f62635e;

        /* renamed from: f, reason: collision with root package name */
        public int f62636f;

        /* renamed from: g, reason: collision with root package name */
        public int f62637g;

        /* renamed from: h, reason: collision with root package name */
        public int f62638h;

        /* renamed from: i, reason: collision with root package name */
        public int f62639i;

        /* renamed from: j, reason: collision with root package name */
        public int f62640j;

        /* renamed from: k, reason: collision with root package name */
        public int f62641k;

        /* renamed from: l, reason: collision with root package name */
        public int f62642l;

        /* renamed from: m, reason: collision with root package name */
        public int f62643m;

        /* renamed from: n, reason: collision with root package name */
        public int f62644n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f62645o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f62646p;

        private void a() {
            int i3 = this.f62636f;
            int i16 = this.f62635e;
            double d16 = (i3 * 1.0d) / i16;
            double d17 = (this.f62632b * 1.0d) / this.f62631a;
            double d18 = i16;
            double d19 = i3;
            if (d16 > d17) {
                d19 = d17 * d18;
            } else if (d16 < d17) {
                d18 = (1.0d / d17) * d19;
            }
            this.f62641k = (int) d18;
            this.f62642l = (int) d19;
        }

        private String g() {
            if (this.f62640j != 0 && this.f62639i != 0) {
                return this.f62640j + "*" + this.f62639i;
            }
            return "none";
        }

        private String i() {
            if (this.f62645o) {
                return g();
            }
            return h();
        }

        public String b() {
            a();
            if (this.f62642l != 0 && this.f62641k != 0) {
                return this.f62642l + "*" + this.f62641k;
            }
            return "none";
        }

        public String c() {
            if (this.f62636f != 0 && this.f62635e != 0) {
                return this.f62636f + "*" + this.f62635e;
            }
            return "none";
        }

        public String d() {
            if (this.f62634d != 0 && this.f62633c != 0) {
                return this.f62634d + "*" + this.f62633c;
            }
            return "none";
        }

        public String e() {
            if (this.f62646p) {
                return i();
            }
            return b();
        }

        public String f() {
            if (this.f62632b != 0 && this.f62631a != 0) {
                return this.f62632b + "*" + this.f62631a;
            }
            return "none";
        }

        public String h() {
            if (this.f62638h != 0 && this.f62637g != 0) {
                return this.f62638h + "*" + this.f62637g;
            }
            return "none";
        }

        public String j() {
            if (this.f62644n != 0 && this.f62643m != 0) {
                return this.f62644n + "*" + this.f62643m;
            }
            return "none";
        }

        public List<String> k() {
            a();
            return Arrays.asList("\u53d6\u666f\u6846\u5927\u5c0f: " + this.f62632b + "*" + this.f62631a, "\u8bbe\u7f6e\u7684\u9884\u89c8\u5206\u8fa8\u7387: " + this.f62634d + "*" + this.f62633c, "\u8bbe\u7f6e\u7684\u7167\u7247\u5206\u8fa8\u7387: " + this.f62636f + "*" + this.f62635e, "\u666e\u901a\u6e32\u67d3 & \u622a\u5e27\u5206\u8fa8\u7387: " + this.f62638h + "*" + this.f62637g, "\u9ad8\u6e05\u6e32\u67d3 & \u622a\u5e27\u5206\u8fa8\u7387: " + this.f62640j + "*" + this.f62639i, "\u5927\u56fe\u62cd\u7167\u5206\u8fa8\u7387: " + this.f62642l + "*" + this.f62641k, "\u89c6\u9891\u5206\u8fa8\u7387: " + this.f62644n + "*" + this.f62643m, "\u9884\u89c8\u5e27\u7387: TODO");
        }

        public String toString() {
            List<String> k3 = k();
            int size = k3.size();
            int i3 = size - 1;
            StringBuilder sb5 = new StringBuilder();
            for (int i16 = 0; i16 < size; i16++) {
                sb5.append(k3.get(i16));
                if (i16 < i3) {
                    sb5.append("\n");
                }
            }
            return sb5.toString();
        }
    }

    static {
        if (x()) {
            n();
            m();
            o();
        }
    }

    static /* bridge */ /* synthetic */ List b() {
        return f();
    }

    static /* bridge */ /* synthetic */ List c() {
        return g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(final AEVideoStoryDashboardPart.r rVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil.2
            @Override // java.lang.Runnable
            public void run() {
                AEDashboardUtil.s(AEVideoStoryDashboardPart.r.this, AEDashboardUtil.c(), AEDashboardUtil.b());
            }
        }, 64, null, true);
    }

    private static List<b> f() {
        LinkedList linkedList = new LinkedList();
        for (Pair<String, Integer> pair : f62613f) {
            b bVar = new b();
            bVar.f62622a = (String) pair.first;
            bVar.f62623b = AECameraPrefsUtil.f().j((String) pair.first, "null", ((Integer) pair.second).intValue());
            linkedList.add(bVar);
        }
        return linkedList;
    }

    private static List<c> g() {
        LinkedList linkedList = new LinkedList();
        for (Feature feature : f62612e) {
            c cVar = new c();
            try {
                try {
                    cVar.f62624a = feature.getName();
                    cVar.f62625b = feature.isFunctionReady();
                } catch (Exception e16) {
                    cVar.f62625b = false;
                    cVar.f62626c = e16.getMessage();
                }
            } finally {
                linkedList.add(cVar);
            }
        }
        Collections.sort(linkedList, new a());
        return linkedList;
    }

    public static void h(final AEVideoStoryDashboardPart.r rVar, long j3) {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil.1
            @Override // java.lang.Runnable
            public void run() {
                AEDashboardUtil.e(AEVideoStoryDashboardPart.r.this);
            }
        }, j3);
    }

    public static List<d> i(d dVar) {
        LinkedList<d> linkedList = new LinkedList(f62614g);
        if (dVar != null && !TextUtils.isEmpty(dVar.f62628a)) {
            for (d dVar2 : linkedList) {
                if (dVar2 != null && !TextUtils.isEmpty(dVar2.f62628a) && dVar2.f62628a.equals(dVar.f62628a)) {
                    dVar2.f62629b = dVar.f62629b;
                    dVar2.f62630c = dVar.f62630c;
                }
            }
        }
        return linkedList;
    }

    public static boolean j() {
        return ar.f326685a.c("com.tencent.aelight.camera.beautyv7.1", false);
    }

    public static MutableLiveData<d> k() {
        return f62615h;
    }

    public static MutableLiveData<Float> l() {
        return f62616i;
    }

    private static void m() {
        List<Pair<String, Integer>> list = f62613f;
        list.add(new Pair<>(AECameraConstants.RES_MAP_ENTRANCE_QZONE_KEY, 4));
        list.add(new Pair<>(AECameraConstants.RES_MAP_PLAY_SHOW_KEY, 4));
    }

    private static void o() {
        List<d> list = f62614g;
        list.add(new d(AECameraConstants.CMD_CAMERA_CONFIG));
        list.add(new d("ShadowBackendSvc.GetCategoryMaterial.MqStoryCamera"));
        list.add(new d("ShadowBackendSvc.GetCategoryMaterial.MqCameraMakeup"));
        list.add(new d("ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera"));
        list.add(new d("ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark"));
        list.add(new d("ShadowBackendSvc.GetCategoryMaterial.MqKuaishanCamera"));
        list.add(new d("ShadowBackendSvc.GetPlayShowCatMatTree"));
    }

    public static boolean p(Context context) {
        return ar.f326685a.c("com.tencent.aelight.camera.beautyv7.1", false) || (gq.a.N(context) && h.f322638a.b());
    }

    public static boolean q() {
        return true;
    }

    public static boolean r() {
        return com.tencent.aelight.camera.aebase.a.a().getApp().getSharedPreferences("com.tencent.aelight.camera.video_story_dashboard", 4).getBoolean("com.tencent.aelight.camera.cosmetic_filter_data_source_asset", false);
    }

    public static void u(boolean z16) {
        ar.f326685a.m("com.tencent.aelight.camera.beautyv7.1", z16);
    }

    public static void v(boolean z16) {
        com.tencent.aelight.camera.aebase.a.a().getApp().getSharedPreferences("com.tencent.aelight.camera.video_story_dashboard", 4).edit().putBoolean("com.tencent.aelight.camera.dy_style", z16).apply();
    }

    public static void w(boolean z16) {
        com.tencent.aelight.camera.aebase.a.a().getApp().getSharedPreferences("com.tencent.aelight.camera.video_story_dashboard", 4).edit().putBoolean("com.tencent.aelight.camera.cosmetic_filter_data_source_asset", z16).apply();
    }

    public static boolean x() {
        return false;
    }

    public static void t(Intent intent) {
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        int i3 = intent.getExtras().getInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
        f62608a = i3;
        f62609b = i3 == js.a.f410908h.b() || f62608a == js.a.Q.b() || f62608a == js.a.f410910j.b() || f62608a == js.a.f410906f.b() || f62608a == js.a.f410920t.b();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f62628a;

        /* renamed from: b, reason: collision with root package name */
        public String f62629b;

        /* renamed from: c, reason: collision with root package name */
        public String f62630c;

        public d(String str) {
            this.f62629b = "null";
            this.f62630c = "null";
            this.f62628a = str;
        }

        public String toString() {
            return "cmd=" + this.f62628a + ", state=" + this.f62629b + ", result=" + this.f62630c;
        }

        public d(String str, String str2, String str3) {
            this.f62628a = str;
            this.f62629b = str2;
            this.f62630c = str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(final AEVideoStoryDashboardPart.r rVar, final List<c> list, final List<b> list2) {
        if (rVar == null) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil.3
            @Override // java.lang.Runnable
            public void run() {
                AEVideoStoryDashboardPart.r.this.b(list, list2);
            }
        });
    }

    private static void n() {
    }
}
