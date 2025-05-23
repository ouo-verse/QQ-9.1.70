package com.tencent.aelight.camera.ae.flashshow.dashboard;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.ttpic.openapi.initializer.Feature;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class LSDashboardUtil {

    /* renamed from: a, reason: collision with root package name */
    private static int f64211a = js.a.f410904d.b();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f64212b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f64213c = false;

    /* renamed from: d, reason: collision with root package name */
    public static final e f64214d = new e();

    /* renamed from: e, reason: collision with root package name */
    private static final List<Feature> f64215e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    private static final List<Pair<String, Integer>> f64216f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    private static final List<d> f64217g = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    private static final MutableLiveData<d> f64218h = new MutableLiveData<>();

    /* renamed from: i, reason: collision with root package name */
    private static final MutableLiveData<Float> f64219i = new MutableLiveData<>();

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.dashboard.LSDashboardUtil$1, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LSDashboardPart.s f64220d;

        @Override // java.lang.Runnable
        public void run() {
            LSDashboardUtil.e(this.f64220d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            if (cVar.f64228b) {
                return 1;
            }
            return cVar2.f64228b ? -1 : 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f64225a;

        /* renamed from: b, reason: collision with root package name */
        public String f64226b = "null";

        public String toString() {
            return this.f64225a + ", value=" + this.f64226b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f64227a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f64228b;

        /* renamed from: c, reason: collision with root package name */
        public String f64229c = "null";

        /* renamed from: d, reason: collision with root package name */
        public String f64230d = "null";

        public String toString() {
            return this.f64227a + ", ready=" + this.f64228b + ", extraInfo=" + this.f64230d + ", error=" + this.f64229c;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f64231a;

        /* renamed from: b, reason: collision with root package name */
        public String f64232b = "null";

        /* renamed from: c, reason: collision with root package name */
        public String f64233c = "null";

        public d(String str) {
            this.f64231a = str;
        }

        public String toString() {
            return "cmd=" + this.f64231a + ", state=" + this.f64232b + ", result=" + this.f64233c;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public int f64234a;

        /* renamed from: b, reason: collision with root package name */
        public int f64235b;

        /* renamed from: c, reason: collision with root package name */
        public int f64236c;

        /* renamed from: d, reason: collision with root package name */
        public int f64237d;

        /* renamed from: e, reason: collision with root package name */
        public int f64238e;

        /* renamed from: f, reason: collision with root package name */
        public int f64239f;

        /* renamed from: g, reason: collision with root package name */
        public int f64240g;

        /* renamed from: h, reason: collision with root package name */
        public int f64241h;

        /* renamed from: i, reason: collision with root package name */
        public int f64242i;

        /* renamed from: j, reason: collision with root package name */
        public int f64243j;

        /* renamed from: k, reason: collision with root package name */
        public int f64244k;

        /* renamed from: l, reason: collision with root package name */
        public int f64245l;

        /* renamed from: m, reason: collision with root package name */
        public int f64246m;

        /* renamed from: n, reason: collision with root package name */
        public int f64247n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f64248o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f64249p;

        private void a() {
            int i3 = this.f64239f;
            int i16 = this.f64238e;
            double d16 = (i3 * 1.0d) / i16;
            double d17 = (this.f64235b * 1.0d) / this.f64234a;
            double d18 = i16;
            double d19 = i3;
            if (d16 > d17) {
                d19 = d17 * d18;
            } else if (d16 < d17) {
                d18 = (1.0d / d17) * d19;
            }
            this.f64244k = (int) d18;
            this.f64245l = (int) d19;
        }

        public List<String> b() {
            a();
            return Arrays.asList("\u53d6\u666f\u6846\u5927\u5c0f: " + this.f64235b + "*" + this.f64234a, "\u8bbe\u7f6e\u7684\u9884\u89c8\u5206\u8fa8\u7387: " + this.f64237d + "*" + this.f64236c, "\u8bbe\u7f6e\u7684\u7167\u7247\u5206\u8fa8\u7387: " + this.f64239f + "*" + this.f64238e, "\u666e\u901a\u6e32\u67d3 & \u622a\u5e27\u5206\u8fa8\u7387: " + this.f64241h + "*" + this.f64240g, "\u9ad8\u6e05\u6e32\u67d3 & \u622a\u5e27\u5206\u8fa8\u7387: " + this.f64243j + "*" + this.f64242i, "\u5927\u56fe\u62cd\u7167\u5206\u8fa8\u7387: " + this.f64245l + "*" + this.f64244k, "\u89c6\u9891\u5206\u8fa8\u7387: " + this.f64247n + "*" + this.f64246m, "\u9884\u89c8\u5e27\u7387: TODO");
        }

        public String toString() {
            List<String> b16 = b();
            int size = b16.size();
            int i3 = size - 1;
            StringBuilder sb5 = new StringBuilder();
            for (int i16 = 0; i16 < size; i16++) {
                sb5.append(b16.get(i16));
                if (i16 < i3) {
                    sb5.append("\n");
                }
            }
            return sb5.toString();
        }
    }

    static {
        if (p()) {
            k();
            l();
        }
    }

    static /* bridge */ /* synthetic */ List b() {
        return f();
    }

    static /* bridge */ /* synthetic */ List c() {
        return g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(final LSDashboardPart.s sVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.dashboard.LSDashboardUtil.2
            @Override // java.lang.Runnable
            public void run() {
                LSDashboardUtil.n(LSDashboardPart.s.this, LSDashboardUtil.c(), LSDashboardUtil.b());
            }
        }, 64, null, true);
    }

    private static List<b> f() {
        LinkedList linkedList = new LinkedList();
        for (Pair<String, Integer> pair : f64216f) {
            b bVar = new b();
            bVar.f64225a = (String) pair.first;
            bVar.f64226b = AECameraPrefsUtil.f().j((String) pair.first, "null", ((Integer) pair.second).intValue());
            linkedList.add(bVar);
        }
        return linkedList;
    }

    private static List<c> g() {
        LinkedList linkedList = new LinkedList();
        for (Feature feature : f64215e) {
            c cVar = new c();
            try {
                try {
                    cVar.f64227a = feature.getName();
                    cVar.f64228b = feature.isFunctionReady();
                } catch (Exception e16) {
                    cVar.f64228b = false;
                    cVar.f64229c = e16.getMessage();
                }
            } finally {
                linkedList.add(cVar);
            }
        }
        Collections.sort(linkedList, new a());
        return linkedList;
    }

    public static List<d> h(d dVar) {
        LinkedList<d> linkedList = new LinkedList(f64217g);
        if (dVar != null && !TextUtils.isEmpty(dVar.f64231a)) {
            for (d dVar2 : linkedList) {
                if (dVar2 != null && !TextUtils.isEmpty(dVar2.f64231a) && dVar2.f64231a.equals(dVar.f64231a)) {
                    dVar2.f64232b = dVar.f64232b;
                    dVar2.f64233c = dVar.f64233c;
                }
            }
        }
        return linkedList;
    }

    public static MutableLiveData<d> i() {
        return f64218h;
    }

    public static MutableLiveData<Float> j() {
        return f64219i;
    }

    private static void k() {
        List<Pair<String, Integer>> list = f64216f;
        list.add(new Pair<>(AECameraConstants.RES_MAP_ENTRANCE_QZONE_KEY, 4));
        list.add(new Pair<>(AECameraConstants.RES_MAP_PLAY_SHOW_KEY, 4));
    }

    private static void l() {
        List<d> list = f64217g;
        list.add(new d(AECameraConstants.CMD_CAMERA_CONFIG));
        list.add(new d("ShadowBackendSvc.GetCategoryMaterial.MqStoryCamera"));
        list.add(new d("ShadowBackendSvc.GetCategoryMaterial.MqCameraMakeup"));
        list.add(new d("ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera"));
        list.add(new d("ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark"));
        list.add(new d("ShadowBackendSvc.GetCategoryMaterial.MqKuaishanCamera"));
        list.add(new d("ShadowBackendSvc.GetPlayShowCatMatTree"));
    }

    public static boolean m() {
        return true;
    }

    public static boolean p() {
        return false;
    }

    public static void o(Intent intent) {
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        int i3 = intent.getExtras().getInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
        f64211a = i3;
        f64212b = i3 == js.a.f410908h.b() || f64211a == js.a.Q.b() || f64211a == js.a.f410910j.b() || f64211a == js.a.f410906f.b() || f64211a == js.a.f410920t.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(final LSDashboardPart.s sVar, final List<c> list, final List<b> list2) {
        if (sVar == null) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.dashboard.LSDashboardUtil.3
            @Override // java.lang.Runnable
            public void run() {
                LSDashboardPart.s.this.b(list, list2);
            }
        });
    }
}
