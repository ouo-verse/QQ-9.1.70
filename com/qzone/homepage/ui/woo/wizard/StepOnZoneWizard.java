package com.qzone.homepage.ui.woo.wizard;

import android.text.TextUtils;
import com.qzone.homepage.business.model.FunnySpaceModel;
import com.qzone.homepage.ui.woo.StepOnZoneDirector;
import com.qzone.util.ad;
import com.qzone.util.f;
import com.tencent.open.base.MD5Utils;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class StepOnZoneWizard implements ad.a {

    /* renamed from: c, reason: collision with root package name */
    private static StepOnZoneWizard f47865c;

    /* renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, b> f47866d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap<String, b> f47867e = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Set<String>> f47868a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, a> f47869b = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class NotifyTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final String f47870d;

        /* renamed from: e, reason: collision with root package name */
        private final List<e7.a> f47871e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f47872f;

        /* renamed from: h, reason: collision with root package name */
        private final c f47873h;

        NotifyTask(a aVar, boolean z16, boolean z17) {
            this.f47870d = aVar.f47874a;
            this.f47871e = z16 ? StepOnZoneWizard.m(aVar.f47875b) : null;
            this.f47872f = z17;
            this.f47873h = (c) aVar.f47876c.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = this.f47873h;
            if (cVar == null) {
                return;
            }
            cVar.Q0(this.f47870d, this.f47871e, this.f47872f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f47874a;

        /* renamed from: b, reason: collision with root package name */
        private final List<b> f47875b;

        /* renamed from: c, reason: collision with root package name */
        private final WeakReference<c> f47876c;

        /* renamed from: d, reason: collision with root package name */
        private final Set<String> f47877d = new HashSet();

        a(String str, List<b> list, c cVar) {
            this.f47874a = str;
            this.f47875b = Collections.unmodifiableList(list);
            this.f47876c = new WeakReference<>(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class b implements Comparable<b> {
        private FunnySpaceModel C;
        private FunnySpaceModel D;
        private String E;
        private String F;
        private String G;
        private String H;
        private String I;
        private String J;
        private String K;
        private String L;
        private String M;
        private int N = 0;
        private int P = -1;
        private ArrayList<Integer> Q;

        /* renamed from: d, reason: collision with root package name */
        private String f47878d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f47879e;

        /* renamed from: f, reason: collision with root package name */
        private int f47880f;

        /* renamed from: h, reason: collision with root package name */
        private int f47881h;

        /* renamed from: i, reason: collision with root package name */
        private int f47882i;

        /* renamed from: m, reason: collision with root package name */
        private int[] f47883m;

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String H() {
            FunnySpaceModel funnySpaceModel = this.D;
            if (funnySpaceModel != null && !TextUtils.isEmpty(funnySpaceModel.likeKey)) {
                return this.D.likeKey;
            }
            FunnySpaceModel funnySpaceModel2 = this.C;
            if (funnySpaceModel2 == null) {
                return "";
            }
            return funnySpaceModel2.likeKey;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String I() {
            FunnySpaceModel funnySpaceModel = this.C;
            if (funnySpaceModel != null && !TextUtils.isEmpty(funnySpaceModel.likeKey)) {
                return this.C.likeKey;
            }
            FunnySpaceModel funnySpaceModel2 = this.D;
            if (funnySpaceModel2 == null) {
                return "";
            }
            return funnySpaceModel2.likeKey;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J() {
            ad adVar = ad.f59766a;
            this.E = adVar.c(this.I);
            this.F = adVar.c(this.J);
            this.G = adVar.c(this.K);
            this.H = adVar.c(this.L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void K() {
            if (M(this.D) || M(this.C)) {
                return;
            }
            this.f47879e = false;
            this.f47880f = 0;
            this.f47881h = Integer.MAX_VALUE;
            this.f47882i = Integer.MAX_VALUE;
            this.f47883m = new int[0];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L() {
            FunnySpaceModel funnySpaceModel = this.C;
            this.I = funnySpaceModel == null ? null : funnySpaceModel.url;
            FunnySpaceModel funnySpaceModel2 = this.D;
            this.J = funnySpaceModel2 == null ? null : funnySpaceModel2.url;
            if (funnySpaceModel != null && !TextUtils.isEmpty(funnySpaceModel.iconUrl)) {
                this.K = this.C.iconUrl;
            } else {
                FunnySpaceModel funnySpaceModel3 = this.D;
                this.K = funnySpaceModel3 == null ? null : funnySpaceModel3.iconUrl;
            }
            if (this.f47879e) {
                FunnySpaceModel funnySpaceModel4 = this.D;
                if (funnySpaceModel4 != null && !TextUtils.isEmpty(funnySpaceModel4.firstFrameUrl)) {
                    this.L = this.D.firstFrameUrl;
                } else {
                    FunnySpaceModel funnySpaceModel5 = this.C;
                    this.L = funnySpaceModel5 != null ? funnySpaceModel5.firstFrameUrl : null;
                }
            } else {
                this.L = null;
            }
            J();
        }

        private boolean M(FunnySpaceModel funnySpaceModel) {
            JSONObject jSONObject;
            int i3;
            if (funnySpaceModel == null) {
                return false;
            }
            boolean z16 = true;
            if (funnySpaceModel.dataSource == 1) {
                this.f47879e = funnySpaceModel.spy_type;
                this.f47880f = funnySpaceModel.cycleStart;
                this.f47881h = funnySpaceModel.cycleEnd;
                this.f47882i = funnySpaceModel.rank;
                this.f47883m = funnySpaceModel.vibration;
                this.N = 1;
                this.P = funnySpaceModel.itemId;
                this.M = funnySpaceModel.feeds_image;
                return true;
            }
            if (TextUtils.isEmpty(funnySpaceModel.metaJson)) {
                return false;
            }
            try {
                jSONObject = new JSONObject(funnySpaceModel.metaJson);
            } catch (JSONException e16) {
                QZLog.w("StepOnZoneWizard", "readMetaJson: failed to read json: " + funnySpaceModel.metaJson, e16);
                jSONObject = null;
            }
            if (jSONObject == null) {
                return false;
            }
            if (!this.f47879e) {
                this.f47879e = "1".equals(jSONObject.optString(FunnySpaceModel.META_KEY_SPE_TYPE));
            }
            if (!this.f47879e && (this.f47880f == 0 || (i3 = this.f47881h) == 0 || i3 == Integer.MAX_VALUE)) {
                JSONObject optJSONObject = jSONObject.optJSONObject(FunnySpaceModel.META_KEY_CYCLE);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("start");
                    if (optString.length() == 0) {
                        this.f47880f = 0;
                    } else {
                        try {
                            this.f47880f = Integer.parseInt(optString);
                        } catch (NumberFormatException e17) {
                            QZLog.w("StepOnZoneWizard", "readMetaJson: wrong cycleStart ", e17);
                            this.f47880f = 0;
                            z16 = false;
                        }
                    }
                    String optString2 = optJSONObject.optString("end");
                    if (optString2.length() == 0) {
                        this.f47881h = Integer.MAX_VALUE;
                    } else {
                        try {
                            this.f47881h = Integer.parseInt(optString2);
                        } catch (NumberFormatException e18) {
                            QZLog.w("StepOnZoneWizard", "readMetaJson: wrong cycleEnd ", e18);
                            this.f47881h = Integer.MAX_VALUE;
                        }
                    }
                }
                z16 = false;
            }
            int i16 = this.f47882i;
            if (i16 == 0 || i16 == Integer.MAX_VALUE) {
                try {
                    this.f47882i = Integer.parseInt(jSONObject.optString("rank"));
                } catch (NumberFormatException e19) {
                    QZLog.w("StepOnZoneWizard", "readMetaJson: wrong rank ", e19);
                    this.f47882i = Integer.MAX_VALUE;
                    z16 = false;
                }
            }
            int[] iArr = this.f47883m;
            if (iArr == null || iArr.length == 0) {
                JSONArray optJSONArray = jSONObject.optJSONArray("vibration");
                if (optJSONArray == null) {
                    return false;
                }
                this.f47883m = new int[optJSONArray.length()];
                for (int i17 = 0; i17 < optJSONArray.length(); i17++) {
                    try {
                        this.f47883m[i17] = Integer.parseInt(optJSONArray.optString(i17));
                    } catch (NumberFormatException e26) {
                        QZLog.w("StepOnZoneWizard", "readMetaJson: wrong vibrate ", e26);
                        this.f47883m[i17] = -2;
                    }
                }
            }
            return z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getName() {
            FunnySpaceModel funnySpaceModel = this.C;
            if (funnySpaceModel != null && !TextUtils.isEmpty(funnySpaceModel.name)) {
                return this.C.name;
            }
            FunnySpaceModel funnySpaceModel2 = this.D;
            if (funnySpaceModel2 == null) {
                return "";
            }
            return funnySpaceModel2.name;
        }

        @Override // java.lang.Comparable
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            return this.f47882i - bVar.f47882i;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface c {
        void Q0(String str, List<e7.a> list, boolean z16);
    }

    private void d(a aVar, String str) {
        QZLog.i("StepOnZoneWizard", "asyncDownFile: " + aVar.f47874a + " " + str);
        aVar.f47877d.add(str);
        if (this.f47868a.containsKey(str)) {
            this.f47868a.get(str).add(aVar.f47874a);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(aVar.f47874a);
        this.f47868a.put(str, hashSet);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        ad.f59766a.d(arrayList, this);
    }

    private void e(String str) {
        boolean z16;
        a aVar = this.f47869b.get(str);
        if (aVar == null) {
            QZLog.w("StepOnZoneWizard", "asyncLoadFile: empty request " + str);
            return;
        }
        aVar.f47877d.clear();
        loop0: while (true) {
            for (b bVar : aVar.f47875b) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(bVar.I);
                arrayList.add(bVar.J);
                arrayList.add(bVar.K);
                arrayList.add(bVar.L);
                z16 = !l(arrayList, aVar).booleanValue() && z16;
            }
        }
        if (z16) {
            this.f47869b.remove(str);
            RFWThreadManager.getUIHandler().post(new NotifyTask(aVar, true, true));
        }
    }

    private void f(String str) {
        Set<String> set = this.f47868a.get(str);
        if (set == null) {
            return;
        }
        for (String str2 : set) {
            a aVar = this.f47869b.get(str2);
            if (aVar != null) {
                QZLog.i("StepOnZoneWizard", "asyncOnDownFailed: " + aVar.f47874a + " " + str);
                this.f47869b.remove(str2);
                RFWThreadManager.getUIHandler().post(new NotifyTask(aVar, false, false));
            }
        }
        this.f47868a.remove(str);
    }

    private void g(String str) {
        Set<String> set = this.f47868a.get(str);
        if (set == null) {
            return;
        }
        for (String str2 : set) {
            a aVar = this.f47869b.get(str2);
            if (aVar != null) {
                aVar.f47877d.remove(str);
                QZLog.i("StepOnZoneWizard", "asyncOnDownOk: " + aVar.f47874a + " " + str + " " + aVar.f47877d.size());
                if (aVar.f47877d.isEmpty()) {
                    this.f47869b.remove(str2);
                    Iterator it = aVar.f47875b.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).J();
                    }
                    RFWThreadManager.getUIHandler().post(new NotifyTask(aVar, true, false));
                }
            }
        }
        this.f47868a.remove(str);
    }

    public static synchronized StepOnZoneWizard h() {
        StepOnZoneWizard stepOnZoneWizard;
        synchronized (StepOnZoneWizard.class) {
            if (f47865c == null) {
                f47865c = new StepOnZoneWizard();
            }
            stepOnZoneWizard = f47865c;
        }
        return stepOnZoneWizard;
    }

    private static boolean i(String str) {
        String c16 = ad.f59766a.c(str);
        if (TextUtils.isEmpty(c16)) {
            return false;
        }
        File file = new File(c16);
        return file.exists() && file.isFile() && file.length() > 0;
    }

    private Boolean l(List<String> list, a aVar) {
        boolean z16 = false;
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && !i(str)) {
                d(aVar, str);
                z16 = true;
            }
        }
        return Boolean.valueOf(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<e7.a> m(List<b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (b bVar : list) {
            List<String> p16 = p(bVar.E);
            List<String> p17 = p(bVar.F);
            HashSet hashSet = new HashSet();
            for (int i3 : bVar.f47883m) {
                hashSet.add(Integer.valueOf(i3));
            }
            e7.a aVar = new e7.a(bVar.f47878d, p16, p17, bVar.G, bVar.H, bVar.f47880f, bVar.f47881h, hashSet, bVar.f47882i, bVar.I(), bVar.H(), bVar.getName(), bVar.f47879e, bVar.N, bVar.M, bVar.Q);
            if (aVar.f395797b.isEmpty()) {
                QZLog.w("StepOnZoneWizard", "parseAnimModel: empty tap res list " + bVar.f47878d);
            } else {
                arrayList.add(aVar);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private boolean n(String str, List<b> list, c cVar) {
        Collections.sort(list);
        a aVar = new a(str, list, cVar);
        if (this.f47869b.putIfAbsent(aVar.f47874a, aVar) != null) {
            QZLog.w("StepOnZoneWizard", "loadAnimFiles: this key is already in request " + aVar.f47874a);
            return false;
        }
        e(aVar.f47874a);
        return true;
    }

    private static File[] o(File file) {
        File[] listFiles = file.listFiles();
        return listFiles == null ? new File[0] : listFiles;
    }

    @Override // com.qzone.util.ad.a
    public void a(String str, String str2) {
        QZLog.i("StepOnZoneWizard", "onLoadSucceed url:" + str);
        g(str);
    }

    @Override // com.qzone.util.ad.a
    public void b(String str) {
        QZLog.i("StepOnZoneWizard", "onDownloadFailed url:" + str);
        f(str);
    }

    public boolean j(String str, Collection<FunnySpaceModel> collection, c cVar, int i3) {
        int i16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("loadAnimFiles: ");
        sb5.append(collection == null ? 0 : collection.size());
        sb5.append(" ");
        sb5.append(StepOnZoneDirector.j0());
        QZLog.i("StepOnZoneWizard", sb5.toString());
        if (collection == null || collection.isEmpty() || StepOnZoneDirector.j0()) {
            return false;
        }
        HashMap hashMap = new HashMap();
        for (FunnySpaceModel funnySpaceModel : collection) {
            if (!TextUtils.isEmpty(funnySpaceModel.f47486id) && (i16 = funnySpaceModel.type) >= 0 && i16 <= 1 && !TextUtils.isEmpty(funnySpaceModel.url)) {
                b bVar = (b) hashMap.get(funnySpaceModel.f47486id);
                if (bVar == null) {
                    bVar = new b();
                    bVar.f47878d = funnySpaceModel.f47486id;
                    hashMap.put(bVar.f47878d, bVar);
                }
                if (funnySpaceModel.type == 0) {
                    if (bVar.C == null) {
                        bVar.C = funnySpaceModel;
                    }
                } else if (bVar.D == null) {
                    bVar.D = funnySpaceModel;
                    ArrayList<Integer> arrayList = funnySpaceModel.comboIndexList;
                    if (arrayList != null) {
                        bVar.Q = arrayList;
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(hashMap.size());
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            b bVar2 = (b) ((Map.Entry) it.next()).getValue();
            bVar2.K();
            bVar2.L();
            if (TextUtils.isEmpty(bVar2.I)) {
                QZLog.w("StepOnZoneWizard", "loadAnimFiles: this holder has no tap url " + bVar2.f47878d);
            } else {
                arrayList2.add(bVar2);
            }
        }
        for (b bVar3 : arrayList2) {
            if (i3 == 1) {
                f47867e.put(bVar3.P + "_" + bVar3.f47878d, bVar3);
            } else {
                f47866d.put(bVar3.f47878d, bVar3);
            }
        }
        return n(str, arrayList2, cVar);
    }

    public boolean k(String str, Set<String> set, c cVar, int i3) {
        QZLog.i("StepOnZoneWizard", "loadAnimFiles: in cache " + f.c(set) + " " + StepOnZoneDirector.j0());
        if (set == null || set.isEmpty() || StepOnZoneDirector.j0()) {
            return false;
        }
        ArrayList arrayList = new ArrayList(set.size());
        if (i3 == -1) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                b bVar = f47866d.get(it.next());
                if (bVar != null) {
                    arrayList.add(bVar);
                }
            }
        } else {
            for (String str2 : set) {
                b bVar2 = f47867e.get(i3 + "_" + str2);
                if (bVar2 != null) {
                    arrayList.add(bVar2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            QZLog.i("StepOnZoneWizard", "loadAnimFiles: in cache empty itemid =" + i3);
            return false;
        }
        return n(str, arrayList, cVar);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:8|(1:10)|11|(2:15|(6:17|18|(1:20)|21|22|23))|24|25|26|(1:28)(7:29|(1:31)|18|(0)|21|22|23)) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
    
        cooperation.qzone.util.QZLog.w("StepOnZoneWizard", "unzipResFile: failed to unzip");
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007f A[LOOP:0: B:19:0x007d->B:20:0x007f, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<String> p(String str) {
        File[] o16;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf >= 0) {
            name = name.substring(0, lastIndexOf);
        }
        String str2 = name + "_unzip_" + MD5Utils.toMD5(str);
        File y16 = p6.b.y(str2, str);
        if (y16.exists() && y16.isDirectory()) {
            o16 = o(y16);
            if (o16.length > 0) {
                QZLog.i("StepOnZoneWizard", "unzipResFile: no need unzip again");
                ArrayList arrayList = new ArrayList(o16.length);
                for (File file2 : o16) {
                    arrayList.add(file2.getAbsolutePath());
                }
                Collections.sort(arrayList);
                return arrayList;
            }
        }
        p6.b.G(str2, str);
        if (!y16.exists()) {
            return null;
        }
        o16 = o(y16);
        if (o16.length == 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(o16.length);
        while (r3 < r0) {
        }
        Collections.sort(arrayList2);
        return arrayList2;
    }
}
