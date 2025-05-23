package com.tencent.mobileqq.wink.newalbum.collector;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorUtils;
import com.tencent.mobileqq.wink.newalbum.collector.j;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.newalbum.director.datasource.WinkAlbumDataSource;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumContext;
import com.tencent.mobileqq.wink.newalbum.resmanager.albumconfig.WinkNewAlbumTextFeatureManager;
import com.tencent.mobileqq.wink.newalbum.resmanager.albumconfig.WinkNewAlbumTextFetchResult;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;
import s83.WinkNewAlbumConfigInfo;
import s83.WinkNewAlbumFeatureConfigInfo;

/* loaded from: classes21.dex */
public class WinkNewAlbumCollectorProcessor extends com.tencent.mobileqq.wink.newalbum.processor.b {
    public static List<WinkNewAlbumCollectorConfigInfo> S;
    public static HashMap<String, Float> T = new HashMap<>();
    private static final Handler U = RFWThreadManager.createNewThreadHandler("WinkNewAlbumCollectorProcessorThread", 0, new a());
    private boolean C;
    private AtomicBoolean D;
    private List<WinkNewAlbumContext> E;
    private Map<String, LocalMediaInfo> F;
    private WinkNewAlbumDatabaseImp G;
    private com.tencent.mobileqq.wink.newalbum.resmanager.albumconfig.a H;
    private int I;
    private boolean J;
    private AtomicInteger K;
    private final l L;
    private List<String> M;
    private HashSet<String> N;
    private List<WinkNewMemoryAlbumResult> P;
    private List<WinkNewMemoryAlbumResult> Q;
    private int R;

    /* renamed from: m, reason: collision with root package name */
    a93.b f324025m;

    /* loaded from: classes21.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            Object obj = message.obj;
            if (obj instanceof i) {
                ((i) obj).a(message.what);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class b implements t83.a {
        b() {
        }

        @Override // t83.a
        public void a(boolean z16) {
            String str;
            String b16 = WinkNewAlbumCollectorProcessor.this.b();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("create album database result: ");
            if (z16) {
                str = "SUCCESS";
            } else {
                str = Tracker.FAIL;
            }
            sb5.append(str);
            QLog.d(b16, 1, sb5.toString());
            WinkNewAlbumCollectorProcessor.this.d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class c implements t83.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f324030a;

        c(String str) {
            this.f324030a = str;
        }

        @Override // t83.d
        public void a(int i3, int i16, int i17, Exception exc) {
            WinkNewAlbumCollectorProcessor.this.h(j.INSTANCE.j(this.f324030a, i3, i16, i17));
            QLog.i(WinkNewAlbumCollectorProcessor.this.b(), 1, "collect finished, storyID:" + this.f324030a + " not exposed totalCount:" + i17 + " imageCount:" + i3 + " videoCount:" + i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class d implements Comparator<com.tencent.mobileqq.wink.newalbum.database.a> {
        d() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.wink.newalbum.database.a aVar, com.tencent.mobileqq.wink.newalbum.database.a aVar2) {
            return Float.compare(aVar2.getSimilarity(), aVar.getSimilarity());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class e implements Comparator<com.tencent.mobileqq.wink.newalbum.database.a> {
        e() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.wink.newalbum.database.a aVar, com.tencent.mobileqq.wink.newalbum.database.a aVar2) {
            try {
                return Float.compare(aVar2.getSimilarity(), aVar.getSimilarity());
            } catch (Exception e16) {
                QLog.e("WinkNewAlbumCollectorProcessor", 1, e16, new Object[0]);
                return 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class f implements Comparator<com.tencent.mobileqq.wink.newalbum.database.a> {
        f() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.wink.newalbum.database.a aVar, com.tencent.mobileqq.wink.newalbum.database.a aVar2) {
            try {
                m mVar = m.f324110a;
                return Float.compare(mVar.g().get(aVar2.getPhotoID()).floatValue(), mVar.g().get(aVar.getPhotoID()).floatValue());
            } catch (Exception e16) {
                QLog.e("WinkNewAlbumCollectorProcessor", 1, e16, new Object[0]);
                return 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class g implements Comparator<com.tencent.mobileqq.wink.newalbum.database.a> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map f324035d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map f324036e;

        g(Map map, Map map2) {
            this.f324035d = map;
            this.f324036e = map2;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.wink.newalbum.database.a aVar, com.tencent.mobileqq.wink.newalbum.database.a aVar2) {
            try {
                return Integer.compare(((Integer) this.f324035d.get(aVar.getPhotoID())).intValue() + ((Integer) this.f324036e.get(aVar.getPhotoID())).intValue(), ((Integer) this.f324035d.get(aVar2.getPhotoID())).intValue() + ((Integer) this.f324036e.get(aVar2.getPhotoID())).intValue());
            } catch (Exception e16) {
                QLog.e(WinkNewAlbumCollectorProcessor.this.b(), 1, e16, new Object[0]);
                return 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class h implements t83.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f324038a;

        h(long j3) {
            this.f324038a = j3;
        }

        @Override // t83.c
        public void a(List<WinkNewMemoryAlbumResult> list) {
            int size;
            long currentTimeMillis = System.currentTimeMillis() - this.f324038a;
            String b16 = WinkNewAlbumCollectorProcessor.this.b();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("loadCacheMemoryAlbum end, cost:");
            sb5.append(currentTimeMillis);
            sb5.append(" size:");
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            sb5.append(size);
            QLog.e(b16, 1, sb5.toString());
            if (list != null && list.size() > 0) {
                WinkAlbumDataSource.f324204a.C(list);
                WinkNewAlbumCollectorProcessor.this.y(list);
            }
            WinkNewAlbumCollectorProcessor.this.a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<WinkNewAlbumCollectorProcessor> f324040a;

        /* renamed from: b, reason: collision with root package name */
        private final Object f324041b;

        i(WinkNewAlbumCollectorProcessor winkNewAlbumCollectorProcessor, Object obj) {
            this.f324040a = new WeakReference<>(winkNewAlbumCollectorProcessor);
            this.f324041b = obj;
        }

        public void a(int i3) {
            WinkNewAlbumCollectorProcessor winkNewAlbumCollectorProcessor = this.f324040a.get();
            if (winkNewAlbumCollectorProcessor == null) {
                QLog.e("WinkNewAlbumCollectorProcessor", 1, "cannot do collector task, get processor is null");
                return;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        winkNewAlbumCollectorProcessor.C = true;
                        winkNewAlbumCollectorProcessor.X();
                        return;
                    }
                    if (i3 == 3) {
                        winkNewAlbumCollectorProcessor.z();
                        return;
                    }
                    if (i3 == 4) {
                        winkNewAlbumCollectorProcessor.D();
                        return;
                    }
                    QLog.e(winkNewAlbumCollectorProcessor.b(), 1, "get invalid message as what: " + i3);
                    return;
                }
                Object obj = this.f324041b;
                if (obj == null) {
                    QLog.e(winkNewAlbumCollectorProcessor.b(), 1, "obj is null in what: 1");
                    return;
                }
                if (!(obj instanceof List)) {
                    QLog.e(winkNewAlbumCollectorProcessor.b(), 1, "list is not instance List in what: 1");
                    return;
                }
                List list = (List) obj;
                if (!list.isEmpty() && !(list.get(0) instanceof WinkNewAlbumCollectorConfigInfo)) {
                    QLog.e(winkNewAlbumCollectorProcessor.b(), 1, "list get 0 is not instance WinkNewAlbumCollectorConfigInfo in what: 1");
                    return;
                }
                WinkNewAlbumCollectorProcessor.S = (List) this.f324041b;
                ArrayList arrayList = new ArrayList();
                for (WinkNewAlbumCollectorConfigInfo winkNewAlbumCollectorConfigInfo : WinkNewAlbumCollectorProcessor.S) {
                    WinkNewAlbumCollectorDebugInstance.f324014a.t(winkNewAlbumCollectorConfigInfo);
                    arrayList.add(winkNewAlbumCollectorConfigInfo.getAlbumConfigInfo());
                }
                winkNewAlbumCollectorProcessor.M(arrayList);
                return;
            }
            Object obj2 = this.f324041b;
            if (obj2 == null) {
                QLog.e(winkNewAlbumCollectorProcessor.b(), 1, "obj is null in what: 0");
            } else if (obj2 instanceof WinkNewAlbumContext) {
                winkNewAlbumCollectorProcessor.U((WinkNewAlbumContext) obj2);
            } else {
                QLog.e(winkNewAlbumCollectorProcessor.b(), 1, "obj is not instanceof WinkNewAlbumContext in what: 0");
            }
        }
    }

    public WinkNewAlbumCollectorProcessor(com.tencent.mobileqq.wink.newalbum.processor.a aVar, String str, a93.b bVar) {
        super(aVar, str);
        this.C = false;
        this.D = new AtomicBoolean(false);
        this.E = new ArrayList();
        this.F = new HashMap();
        this.G = new WinkNewAlbumDatabaseImp();
        this.I = 0;
        this.J = false;
        this.K = new AtomicInteger(0);
        this.L = new l();
        this.M = new ArrayList();
        this.N = new HashSet<>();
        this.P = new ArrayList();
        this.Q = new ArrayList();
        this.R = 0;
        this.f324025m = bVar;
        T();
        S = new ArrayList();
        WinkNewAlbumCollectorDebugInstance.f324014a.h();
    }

    private void A(WinkNewAlbumConfigInfo winkNewAlbumConfigInfo) {
        this.G.n(winkNewAlbumConfigInfo);
    }

    private void B(List<WinkNewAlbumContext> list, WinkNewAlbumCollectorUtils.QueryTime queryTime) {
        WinkNewAlbumCollectorDebugInstance.f324014a.k();
        j.Companion companion = j.INSTANCE;
        WinkPublishQualityReportData h16 = companion.h(list);
        WinkPublishQualityReportData k3 = companion.k(list);
        h(h16);
        h(k3);
        Iterator<WinkNewAlbumCollectorConfigInfo> it = S.iterator();
        while (it.hasNext()) {
            C(it.next(), list, Boolean.valueOf(this.J), queryTime);
        }
        if (w83.b.f445025a.M()) {
            for (WinkNewAlbumContext winkNewAlbumContext : list) {
                if (!winkNewAlbumContext.getIsLast()) {
                    WinkNewAlbumDatabaseImp.l(winkNewAlbumContext.getMetaData().getId());
                }
            }
        }
    }

    private void C(WinkNewAlbumCollectorConfigInfo winkNewAlbumCollectorConfigInfo, List<WinkNewAlbumContext> list, Boolean bool, WinkNewAlbumCollectorUtils.QueryTime queryTime) {
        float[] fArr;
        long currentTimeMillis = System.currentTimeMillis();
        float[] textFeature = winkNewAlbumCollectorConfigInfo.getFeatureConfigInfo().getTextFeature();
        ArrayList<WinkNewAlbumContext> arrayList = new ArrayList<>();
        ArrayList<Float> arrayList2 = new ArrayList<>();
        long currentTimeMillis2 = System.currentTimeMillis();
        int i3 = 0;
        int i16 = 0;
        for (WinkNewAlbumContext winkNewAlbumContext : list) {
            if (winkNewAlbumContext == null) {
                QLog.i(b(), 1, "can not calculate similarity, albumContext is null");
            } else {
                w83.b bVar = w83.b.f445025a;
                if (!bVar.M() && WinkNewAlbumDatabaseImp.L(winkNewAlbumCollectorConfigInfo.getStoryID(), winkNewAlbumContext.getMetaData().getId())) {
                    WinkNewAlbumCollectorDebugInstance.f324014a.u("can not shown in story: " + winkNewAlbumCollectorConfigInfo.getStoryID() + ", storyName is " + winkNewAlbumCollectorConfigInfo.getAlbumConfigInfo().getStoryName() + ", album id: " + winkNewAlbumContext.getMetaData().getId());
                } else {
                    float f16 = m.f(textFeature, winkNewAlbumContext.getForwardResult().getPhotoFeature(), winkNewAlbumContext.getMetaData().getPath(), winkNewAlbumCollectorConfigInfo.getAlbumConfigInfo().d());
                    if (QLog.isDevelopLevel()) {
                        fArr = textFeature;
                        QLog.d("WinkNewAlbumCollectorProcessor", 4, "path:" + winkNewAlbumContext.getMetaData().getPath() + " storyid:" + winkNewAlbumCollectorConfigInfo.getStoryID() + " textSimilarity:" + f16);
                    } else {
                        fArr = textFeature;
                    }
                    if (f16 < winkNewAlbumCollectorConfigInfo.getAlbumConfigInfo().getThreshold()) {
                        WinkNewAlbumCollectorDebugInstance.f324014a.c(winkNewAlbumContext, winkNewAlbumCollectorConfigInfo.getStoryID(), f16);
                    } else if (winkNewAlbumContext.getAestheticScore() < winkNewAlbumCollectorConfigInfo.getAlbumConfigInfo().getAestheticThreshold() && bVar.M() && com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_WINK_NEWALBUM_BEAUTY, 1)) {
                        WinkNewAlbumCollectorDebugInstance.f324014a.c(winkNewAlbumContext, winkNewAlbumCollectorConfigInfo.getStoryID(), f16);
                    } else if (f16 < this.L.getMaxTextSimilarityThreshould() && f16 >= this.L.getMinTextSimilarityThreshould()) {
                        WinkNewAlbumCollectorDebugInstance.f324014a.e(winkNewAlbumContext, winkNewAlbumCollectorConfigInfo.getStoryID(), f16);
                        arrayList2.add(Float.valueOf(f16));
                        arrayList.add(winkNewAlbumContext);
                    } else {
                        if (winkNewAlbumContext.getMetaData().D()) {
                            i16++;
                        } else {
                            i3++;
                        }
                        QLog.e(b(), 1, "text similarity: " + f16 + ", is out of threshould in story: " + winkNewAlbumCollectorConfigInfo.getStoryID() + ", invalid video count: " + i16 + ", invalid image count: " + i3);
                    }
                    textFeature = fArr;
                }
            }
            fArr = textFeature;
            textFeature = fArr;
        }
        QLog.i(b(), 1, "collectMemoryAlbum end, cost:" + (System.currentTimeMillis() - currentTimeMillis2));
        WinkNewAlbumCollectorDebugInstance winkNewAlbumCollectorDebugInstance = WinkNewAlbumCollectorDebugInstance.f324014a;
        winkNewAlbumCollectorDebugInstance.u("currentLoop" + winkNewAlbumCollectorDebugInstance.m() + ", storyID: " + winkNewAlbumCollectorConfigInfo.getStoryID() + ", name: " + winkNewAlbumCollectorConfigInfo.getAlbumConfigInfo().getStoryName() + ", total count: " + list.size() + ", got count: " + arrayList.size());
        if (i3 > 0 || i16 > 0) {
            h(j.INSTANCE.i(winkNewAlbumCollectorConfigInfo.getStoryID(), 0, 0, i3, i16));
        }
        j0(winkNewAlbumCollectorConfigInfo, arrayList, arrayList2, bool, currentTimeMillis, list.size(), queryTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.H = new com.tencent.mobileqq.wink.newalbum.resmanager.albumconfig.a() { // from class: com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorProcessor.2
            @Override // com.tencent.mobileqq.wink.newalbum.resmanager.albumconfig.a
            public void a(@NonNull final WinkNewAlbumTextFetchResult winkNewAlbumTextFetchResult) {
                RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorProcessor.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String clipMemoryInfoJSONPath = winkNewAlbumTextFetchResult.getClipMemoryInfoJSONPath();
                        String clipTextFeatureJSONPath = winkNewAlbumTextFetchResult.getClipTextFeatureJSONPath();
                        if (FileUtils.fileExists(clipMemoryInfoJSONPath) && FileUtils.fileExists(clipTextFeatureJSONPath)) {
                            try {
                                List<WinkNewAlbumConfigInfo> m3 = WinkNewAlbumConfigInfo.m(FileUtils.readFileToString(new File(clipMemoryInfoJSONPath)));
                                List<WinkNewAlbumFeatureConfigInfo> c16 = WinkNewAlbumFeatureConfigInfo.c(FileUtils.readFileToString(new File(clipTextFeatureJSONPath)));
                                List G = WinkNewAlbumCollectorProcessor.this.G(m3, c16);
                                m.i(c16);
                                WinkNewAlbumCollectorProcessor.this.c0(G);
                                QLog.d(WinkNewAlbumCollectorProcessor.this.b(), 1, "config init complet!");
                                return;
                            } catch (Exception e16) {
                                QLog.d(WinkNewAlbumCollectorProcessor.this.b(), 1, e16, new Object[0]);
                                return;
                            }
                        }
                        QLog.d(WinkNewAlbumCollectorProcessor.this.b(), 1, "file doesn't exist!");
                    }
                });
            }
        };
        QLog.d(b(), 1, "downloadConfigInfo, downloadCallback: " + this.H);
        WinkNewAlbumTextFeatureManager winkNewAlbumTextFeatureManager = WinkNewAlbumTextFeatureManager.f324317d;
        winkNewAlbumTextFeatureManager.g();
        winkNewAlbumTextFeatureManager.c(this.H);
    }

    private void E(WinkNewAlbumConfigInfo winkNewAlbumConfigInfo, List<com.tencent.mobileqq.wink.newalbum.database.a> list, List<com.tencent.mobileqq.wink.newalbum.database.a> list2) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.addAll(list2);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.wink.newalbum.database.a) it.next()).g(1);
        }
        this.G.G(list, winkNewAlbumConfigInfo, true, new t83.b() { // from class: com.tencent.mobileqq.wink.newalbum.collector.f
            @Override // t83.b
            public final void a(boolean z16) {
                WinkNewAlbumCollectorProcessor.this.Q(z16);
            }
        });
    }

    private List<z83.a> F(List<z83.a> list) {
        for (z83.a aVar : list) {
            LocalMediaInfo localMediaInfo = this.F.get(aVar.getId());
            if (localMediaInfo != null) {
                aVar.O(localMediaInfo);
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WinkNewAlbumCollectorConfigInfo> G(List<WinkNewAlbumConfigInfo> list, List<WinkNewAlbumFeatureConfigInfo> list2) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (WinkNewAlbumConfigInfo winkNewAlbumConfigInfo : list) {
            hashMap.put(winkNewAlbumConfigInfo.getStoryID(), winkNewAlbumConfigInfo);
        }
        for (WinkNewAlbumFeatureConfigInfo winkNewAlbumFeatureConfigInfo : list2) {
            hashMap2.put(winkNewAlbumFeatureConfigInfo.getStoryID(), winkNewAlbumFeatureConfigInfo);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : hashMap.keySet()) {
            if (!hashMap2.containsKey(str)) {
                QLog.i(b(), 1, "feature config not contain key: " + str);
            } else {
                WinkNewAlbumConfigInfo winkNewAlbumConfigInfo2 = (WinkNewAlbumConfigInfo) hashMap.get(str);
                WinkNewAlbumFeatureConfigInfo winkNewAlbumFeatureConfigInfo2 = (WinkNewAlbumFeatureConfigInfo) hashMap2.get(str);
                if (winkNewAlbumConfigInfo2 != null && winkNewAlbumFeatureConfigInfo2 != null) {
                    arrayList.add(new WinkNewAlbumCollectorConfigInfo(str, winkNewAlbumConfigInfo2.getPriorityIndex(), winkNewAlbumConfigInfo2, winkNewAlbumFeatureConfigInfo2));
                } else {
                    QLog.i(b(), 1, "albumConfigInfo or featureConfigInfo is nil ");
                }
            }
        }
        Collections.sort(arrayList, new com.tencent.mobileqq.wink.newalbum.collector.a());
        return arrayList;
    }

    private List<com.tencent.mobileqq.wink.newalbum.database.a> H(List<com.tencent.mobileqq.wink.newalbum.database.a> list, WinkNewAlbumConfigInfo winkNewAlbumConfigInfo) {
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= list.size()) {
                break;
            }
            com.tencent.mobileqq.wink.newalbum.database.a aVar = list.get(i3);
            if (!this.N.contains(aVar.getPhotoID())) {
                list.remove(i3);
                list.add(0, aVar);
                z16 = true;
                break;
            }
            QLog.i(b(), 1, "hasExposuredCoverIDSet has " + aVar.getPhotoID());
            i3++;
        }
        if (!z16) {
            QLog.i(b(), 1, "can not search no repeat cover in story: " + winkNewAlbumConfigInfo.getStoryID() + ", storyName: " + winkNewAlbumConfigInfo.getStoryName() + ", exposured Cover count: " + this.N.size() + ", noRepeatList count: " + list.size());
        }
        return list;
    }

    private Map<String, List<com.tencent.mobileqq.wink.newalbum.database.a>> I(List<com.tencent.mobileqq.wink.newalbum.database.a> list, WinkNewAlbumConfigInfo winkNewAlbumConfigInfo) {
        boolean z16;
        if (list.isEmpty()) {
            return new HashMap();
        }
        try {
            if (w83.b.f445025a.M() && com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_WINK_NEWALBUM_BEAUTY, 1)) {
                try {
                    h0(list);
                } catch (Exception e16) {
                    QLog.e("WinkNewAlbumCollectorProcessor", 1, e16, new Object[0]);
                }
            } else {
                Collections.sort(list, new d());
            }
        } catch (Exception e17) {
            QLog.e("WinkNewAlbumCollectorProcessor", 1, e17, new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.tencent.mobileqq.wink.newalbum.database.a aVar : list) {
            float[] M = WinkNewAlbumDatabaseImp.M(aVar.getPhotoID());
            if (M == null) {
                QLog.e(b(), 1, "cannot put it in output, because can not searched img feature. photo ID: " + aVar.getPhotoID() + ", similarity: " + aVar.getSimilarity() + ", storyName: " + winkNewAlbumConfigInfo.getStoryName() + ", storyID: " + winkNewAlbumConfigInfo.getStoryID());
                arrayList2.add(aVar);
            } else {
                Iterator<com.tencent.mobileqq.wink.newalbum.database.a> it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (m.h(M, WinkNewAlbumDatabaseImp.M(it.next().getPhotoID()))) {
                            z16 = false;
                            break;
                        }
                    } else {
                        z16 = true;
                        break;
                    }
                }
                if (z16) {
                    arrayList.add(aVar);
                } else {
                    arrayList2.add(aVar);
                }
                if (arrayList.size() >= winkNewAlbumConfigInfo.getMaxShowCount()) {
                    break;
                }
            }
        }
        List<com.tencent.mobileqq.wink.newalbum.database.a> H = H(arrayList, winkNewAlbumConfigInfo);
        HashMap hashMap = new HashMap();
        hashMap.put("SearchedOutputListKey", H);
        hashMap.put("SearchedSomeRepeatListKey", arrayList2);
        return hashMap;
    }

    private String J(WinkNewAlbumConfigInfo winkNewAlbumConfigInfo) {
        if (winkNewAlbumConfigInfo.f() == null) {
            QLog.e(b(), 1, "can not random select story name, random name list is null");
            return winkNewAlbumConfigInfo.getStoryName();
        }
        if (winkNewAlbumConfigInfo.f().isEmpty()) {
            QLog.e(b(), 1, "can not random select story name, story name list size is 0");
            return winkNewAlbumConfigInfo.getStoryName();
        }
        int nextInt = new Random().nextInt(winkNewAlbumConfigInfo.f().size());
        if (nextInt >= winkNewAlbumConfigInfo.f().size()) {
            QLog.e(b(), 1, "name Index is out of bound, index is " + nextInt + ", list size is " + winkNewAlbumConfigInfo.f().size());
            return winkNewAlbumConfigInfo.getStoryName();
        }
        QLog.i(b(), 1, "get random story name: " + winkNewAlbumConfigInfo.f().get(nextInt) + ", from index: " + nextInt);
        return winkNewAlbumConfigInfo.f().get(nextInt);
    }

    public static List<String> K(String str) {
        List<WinkNewAlbumCollectorConfigInfo> list = S;
        if (list == null) {
            return null;
        }
        for (WinkNewAlbumCollectorConfigInfo winkNewAlbumCollectorConfigInfo : list) {
            if (winkNewAlbumCollectorConfigInfo.getStoryID().equals(str)) {
                return winkNewAlbumCollectorConfigInfo.getAlbumConfigInfo().k();
            }
        }
        return null;
    }

    private boolean L() {
        if (this.E.isEmpty()) {
            QLog.i(b(), 1, "cannot, aggregation, candidateAlbumContexts is empty");
            return false;
        }
        if (S.isEmpty()) {
            QLog.i(b(), 1, "cannot, aggregation, configInfo is empty");
            return false;
        }
        if (this.C) {
            return true;
        }
        QLog.i(b(), 1, "cannot, aggregation, dbbase is not ready");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(List<WinkNewAlbumConfigInfo> list) {
        N(list);
        this.G.F(list, !w83.b.f445025a.M(), true, new b());
    }

    private void N(List<WinkNewAlbumConfigInfo> list) {
        if (w83.b.f445025a.M()) {
            return;
        }
        if (list == null) {
            QLog.e(b(), 1, "cannot dropout dispalyed photo, albumConfigInfos is null");
            return;
        }
        for (WinkNewAlbumConfigInfo winkNewAlbumConfigInfo : list) {
            List<String> K = WinkNewAlbumDatabaseImp.K(winkNewAlbumConfigInfo.getStoryID());
            if (!K.isEmpty()) {
                Random random = new Random();
                int size = (int) (K.size() * this.L.getDropoutDisplayedPhotoRate());
                Collections.shuffle(K, random);
                QLog.i(b(), 1, "get displayed list count is " + K.size() + ", from story: " + winkNewAlbumConfigInfo.getStoryID() + " - " + winkNewAlbumConfigInfo.getStoryName() + ", dropout count is " + size + ", rate is " + this.L.getDropoutDisplayedPhotoRate());
                WinkNewAlbumDatabaseImp.s(winkNewAlbumConfigInfo.getStoryID(), K.subList(0, size));
            }
        }
    }

    private boolean O(WinkNewAlbumContext winkNewAlbumContext, WinkNewAlbumContext winkNewAlbumContext2) {
        z83.a metaData = winkNewAlbumContext.getMetaData();
        z83.a metaData2 = winkNewAlbumContext2.getMetaData();
        if (metaData.getYear() == metaData2.getYear() && metaData.getMonth() == metaData2.getMonth() && metaData.getDayOfMonth() == metaData2.getDayOfMonth()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(boolean z16) {
        String str;
        String b16 = b();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("clear album Album Database ");
        if (z16) {
            str = "SUCCESS";
        } else {
            str = Tracker.FAIL;
        }
        sb5.append(str);
        QLog.i(b16, 1, sb5.toString());
        this.G.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(boolean z16) {
        String str;
        String b16 = b();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("exposure SQL ");
        if (z16) {
            str = "SUCCESS";
        } else {
            str = Tracker.FAIL;
        }
        sb5.append(str);
        QLog.i(b16, 1, sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(WinkNewAlbumConfigInfo winkNewAlbumConfigInfo, Boolean bool, long j3, List list, Boolean bool2) {
        W(list, winkNewAlbumConfigInfo, bool.booleanValue(), j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(WinkNewAlbumConfigInfo winkNewAlbumConfigInfo, Boolean bool, long j3, WinkNewAlbumCollectorUtils.QueryTime queryTime, boolean z16) {
        if (!z16) {
            QLog.e(b(), 1, "can not search SQL, insert SQL failed");
        }
        Z(winkNewAlbumConfigInfo, bool, j3, queryTime);
    }

    private void T() {
        ar arVar = ar.f326685a;
        if (arVar.e("mmkv_n_m_cache_version", 0) != 1) {
            this.G.p();
            arVar.o("mmkv_n_m_cache_version", 1);
            a0();
        } else if (w83.b.f445025a.M()) {
            long currentTimeMillis = System.currentTimeMillis();
            QLog.e(b(), 1, "loadCacheMemoryAlbum start");
            this.G.O(new h(currentTimeMillis));
        } else {
            a0();
            QLog.e(b(), 1, "not loadCacheMemoryAlbum");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(@NonNull WinkNewAlbumContext winkNewAlbumContext) {
        QLog.d("WinkNewAlbumCollectorProcessor", 4, "prepareCollect");
        this.J = winkNewAlbumContext.getIsLast();
        Y(winkNewAlbumContext);
        if (this.E.isEmpty()) {
            QLog.d(b(), 1, "candidateAlbumContexts is empty ");
            this.E.add(winkNewAlbumContext);
            if (!this.J) {
                return;
            }
        }
        if (!g0(winkNewAlbumContext)) {
            QLog.d(b(), 4, "no need aggregation, candidate count is " + this.E.size());
            if (O(this.E.get(this.I), winkNewAlbumContext)) {
                QLog.d(b(), 1, "should reset currentDayIndex" + this.I + ", candidate count is " + this.E.size() + ", newAlbum year is " + winkNewAlbumContext.getMetaData().getYear() + ", newAlbum month is " + winkNewAlbumContext.getMetaData().getMonth() + ", newAlbum day is " + winkNewAlbumContext.getMetaData().getDayOfMonth());
                this.I = this.E.size();
            }
            this.E.add(winkNewAlbumContext);
            return;
        }
        WinkNewAlbumCollectorUtils.QueryTime c16 = WinkNewAlbumCollectorUtils.f324042a.c(this.E, winkNewAlbumContext);
        ArrayList arrayList = new ArrayList();
        arrayList.add(winkNewAlbumContext);
        this.I = 0;
        m.a(this.E);
        i0(this.E);
        B(this.E, c16);
        Iterator<WinkNewAlbumContext> it = this.E.iterator();
        while (it.hasNext()) {
            i(it.next());
        }
        this.E = arrayList;
    }

    private void V(List<WinkNewMemoryAlbumResult> list, boolean z16) {
        boolean z17;
        boolean z18;
        if (!z16 && w83.b.f445025a.M()) {
            try {
                if (WinkNewMemoryAlbumResult.t(list.get(0), this.Q)) {
                    QLog.e("WinkNewAlbumCollectorProcessor", 1, "pushCollectedAlbumResult error, this result is similar");
                    return;
                }
                this.Q.add(list.get(0));
            } catch (Exception e16) {
                QLog.e("WinkNewAlbumCollectorProcessor", 1, e16, new Object[0]);
            }
        }
        this.P.addAll(list);
        if (getNext() == null) {
            QLog.e(b(), 1, "push result error, get next is null");
            return;
        }
        if (z16) {
            QLog.i(b(), 1, "force push result count: " + this.P.size());
            for (WinkNewMemoryAlbumResult winkNewMemoryAlbumResult : this.P) {
                QLog.i(b(), 1, "force push storyID: " + winkNewMemoryAlbumResult.getStoryID() + ", count is: " + winkNewMemoryAlbumResult.j().size() + ", story Name is: " + winkNewMemoryAlbumResult.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String());
                this.M.add(winkNewMemoryAlbumResult.getStoryID());
                this.f324025m.f(winkNewMemoryAlbumResult);
            }
            h(new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_UNSHOW_QUEUE").traceId(getTraceId()).ext1(String.valueOf(this.R)).ext2(String.valueOf(this.P.size())).attachInfo("Peak").getReportData());
            this.P.size();
            return;
        }
        for (boolean z19 = true; z19 && !this.P.isEmpty(); z19 = z17) {
            ArrayList arrayList = new ArrayList();
            z17 = false;
            for (WinkNewMemoryAlbumResult winkNewMemoryAlbumResult2 : this.P) {
                int max = Math.max(this.M.size() - this.L.getStoryIntervalNums(), 0);
                while (true) {
                    if (max < this.M.size()) {
                        if (winkNewMemoryAlbumResult2.getStoryID().equals(this.M.get(max))) {
                            z18 = false;
                            break;
                        }
                        max++;
                    } else {
                        z18 = true;
                        break;
                    }
                }
                if (z18) {
                    this.M.add(winkNewMemoryAlbumResult2.getStoryID());
                    this.f324025m.f(winkNewMemoryAlbumResult2);
                    QLog.i(b(), 1, "should exposure storyID: " + winkNewMemoryAlbumResult2.getStoryID() + ", ouputList is " + winkNewMemoryAlbumResult2.j().size());
                    z17 = true;
                } else {
                    arrayList.add(winkNewMemoryAlbumResult2);
                }
            }
            this.P = arrayList;
        }
        this.R = Math.max(this.R, this.P.size());
    }

    private void W(List<WinkNewMemoryAlbumResult> list, WinkNewAlbumConfigInfo winkNewAlbumConfigInfo, boolean z16, long j3) {
        int size;
        if (this.D.get()) {
            QLog.e(b(), 1, "can not push searched Result, process has stoped");
            return;
        }
        if (list.size() != 1) {
            QLog.e(b(), 1, "can not notify result, invalid size " + list.size());
            h(j.INSTANCE.e(-30001, "can not notify result, invalid size " + list.size()));
            e0(Boolean.valueOf(z16));
            return;
        }
        WinkNewMemoryAlbumResult winkNewMemoryAlbumResult = list.get(0);
        WinkNewAlbumCollectorDebugInstance winkNewAlbumCollectorDebugInstance = WinkNewAlbumCollectorDebugInstance.f324014a;
        winkNewAlbumCollectorDebugInstance.x(winkNewMemoryAlbumResult);
        QLog.i(b(), 4, "has searched story: " + winkNewMemoryAlbumResult.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String() + ", collect size: " + winkNewMemoryAlbumResult.j().size() + ", album id: " + winkNewMemoryAlbumResult.getAlbumID());
        WinkNewMemoryAlbumResult o16 = winkNewAlbumCollectorDebugInstance.o(winkNewMemoryAlbumResult);
        if (o16.j().size() != o16.i().size()) {
            h(j.INSTANCE.e(MessageRecord.MSG_TYPE_C2C_MIXED, "lists' size are not equal, get album collect result list count: " + o16.j().size() + "collect photo list count: " + o16.i().size()));
            e0(Boolean.valueOf(z16));
            return;
        }
        Map<String, List<com.tencent.mobileqq.wink.newalbum.database.a>> I = I(o16.j(), winkNewAlbumConfigInfo);
        List<com.tencent.mobileqq.wink.newalbum.database.a> list2 = I.get("SearchedOutputListKey");
        List<com.tencent.mobileqq.wink.newalbum.database.a> list3 = I.get("SearchedSomeRepeatListKey");
        if (list2 != null && list2.size() >= winkNewAlbumConfigInfo.getMinShowCount()) {
            float[] fArr = new float[list2.size()];
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < list2.size(); i17++) {
                com.tencent.mobileqq.wink.newalbum.database.a aVar = list2.get(i17);
                fArr[i17] = aVar.getSimilarity();
                Iterator<z83.a> it = o16.i().iterator();
                while (true) {
                    if (it.hasNext()) {
                        z83.a next = it.next();
                        if (next.getId().equals(aVar.getPhotoID())) {
                            arrayList.add(next);
                            if (next.D()) {
                                i16++;
                            } else {
                                i3++;
                            }
                        }
                    }
                }
            }
            if (list2.size() != arrayList.size()) {
                h(j.INSTANCE.e(MessageRecord.MSG_TYPE_TROOP_MIXED, "outputDBModelList size: " + list2.size() + " is not equal to outputMemoryPhotoList size: " + arrayList.size()));
                e0(Boolean.valueOf(z16));
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - j3;
            WinkNewAlbumCollectorResultReportInfo winkNewAlbumCollectorResultReportInfo = new WinkNewAlbumCollectorResultReportInfo();
            winkNewAlbumCollectorResultReportInfo.o(winkNewAlbumConfigInfo.getStoryID());
            winkNewAlbumCollectorResultReportInfo.m(list2.get(list2.size() - 1).getSimilarity());
            winkNewAlbumCollectorResultReportInfo.l(list2.get(0).getSimilarity());
            winkNewAlbumCollectorResultReportInfo.q(o16.j().size());
            if (list3 == null) {
                size = 0;
            } else {
                size = list3.size();
            }
            winkNewAlbumCollectorResultReportInfo.n(size);
            winkNewAlbumCollectorResultReportInfo.k(i3);
            winkNewAlbumCollectorResultReportInfo.s(i16);
            winkNewAlbumCollectorResultReportInfo.p(fArr);
            winkNewAlbumCollectorResultReportInfo.r(getTraceId());
            h(j.INSTANCE.f(winkNewAlbumCollectorResultReportInfo, currentTimeMillis));
            o16.G(winkNewAlbumCollectorResultReportInfo);
            o16.B(list2);
            o16.A(F(arrayList));
            o16.w(J(winkNewAlbumConfigInfo));
            o16.I(new ArrayList(Collections.singletonList(o16.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String())));
            WinkNewAlbumCollectorDebugInstance.f324014a.w(o16);
            String photoID = o16.j().get(0).getPhotoID();
            this.N.add(photoID);
            QLog.i(b(), 1, "hasExposuredCoverIDSet add " + photoID);
            V(new ArrayList(Collections.singletonList(o16)), false);
            e0(Boolean.valueOf(z16));
            if (this.L.getShouldClearStoryDBTableAfterCollector()) {
                A(winkNewAlbumConfigInfo);
                return;
            } else {
                E(winkNewAlbumConfigInfo, list2, list3);
                return;
            }
        }
        QLog.i(b(), 4, "list size less than min count, get album collect result list count: " + o16.j().size() + ", config min count: " + winkNewAlbumConfigInfo.getMinShowCount());
        e0(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        if (!L()) {
            return;
        }
        List<WinkNewAlbumContext> list = this.E;
        this.I = 0;
        this.E = new ArrayList();
        Iterator<WinkNewAlbumContext> it = list.iterator();
        while (it.hasNext()) {
            U(it.next());
        }
    }

    private void Y(WinkNewAlbumContext winkNewAlbumContext) {
        z83.a metaData = winkNewAlbumContext.getMetaData();
        if (!metaData.getId().isEmpty() && metaData.getOriginPhoto() != null) {
            this.F.put(metaData.getId(), metaData.getOriginPhoto());
        }
    }

    private void Z(final WinkNewAlbumConfigInfo winkNewAlbumConfigInfo, final Boolean bool, final long j3, WinkNewAlbumCollectorUtils.QueryTime queryTime) {
        this.G.w(winkNewAlbumConfigInfo, WinkNewAlbumCollectorUtils.f324042a.b(winkNewAlbumConfigInfo, queryTime, bool.booleanValue()), bool, new t83.e() { // from class: com.tencent.mobileqq.wink.newalbum.collector.i
            @Override // t83.e
            public final void a(List list, Boolean bool2) {
                WinkNewAlbumCollectorProcessor.this.R(winkNewAlbumConfigInfo, bool, j3, list, bool2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        Handler handler = U;
        handler.removeCallbacksAndMessages(null);
        i iVar = new i(this, null);
        Message message = new Message();
        message.obj = iVar;
        message.what = 4;
        handler.sendMessage(message);
    }

    private void b0() {
        Handler handler = U;
        handler.removeCallbacksAndMessages(null);
        i iVar = new i(this, null);
        Message message = new Message();
        message.obj = iVar;
        message.what = 3;
        handler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(@NonNull List<WinkNewAlbumCollectorConfigInfo> list) {
        i iVar = new i(this, list);
        Message message = new Message();
        message.obj = iVar;
        message.what = 1;
        U.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        i iVar = new i(this, null);
        Message message = new Message();
        message.obj = iVar;
        message.what = 2;
        U.sendMessage(message);
    }

    private void e0(Boolean bool) {
        String str;
        if (!bool.booleanValue()) {
            return;
        }
        if (this.K.incrementAndGet() == S.size() && getNext() != null) {
            WinkNewAlbumCollectorDebugInstance winkNewAlbumCollectorDebugInstance = WinkNewAlbumCollectorDebugInstance.f324014a;
            winkNewAlbumCollectorDebugInstance.u("send last result, total count: " + winkNewAlbumCollectorDebugInstance.q());
            QLog.i(b(), 1, "send last result, total count: " + winkNewAlbumCollectorDebugInstance.q() + ", timeCost:" + (System.currentTimeMillis() - getStartTime()));
            winkNewAlbumCollectorDebugInstance.z(System.currentTimeMillis() - getStartTime());
            V(new ArrayList(), true);
            this.P = new ArrayList();
            WinkNewMemoryAlbumResult winkNewMemoryAlbumResult = new WinkNewMemoryAlbumResult();
            winkNewAlbumCollectorDebugInstance.l();
            winkNewMemoryAlbumResult.F(true);
            this.f324025m.f(winkNewMemoryAlbumResult);
            Iterator<WinkNewAlbumCollectorConfigInfo> it = S.iterator();
            while (it.hasNext()) {
                String storyID = it.next().getStoryID();
                this.G.S(storyID, new c(storyID));
            }
            if (w83.b.f445025a.M()) {
                h(j.INSTANCE.a());
                return;
            }
            return;
        }
        String b16 = b();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("cannot send last result, count is ");
        sb5.append(this.K.get());
        sb5.append(", get next is ");
        if (getNext() == null) {
            str = "null";
        } else {
            str = "no null";
        }
        sb5.append(str);
        QLog.i(b16, 1, sb5.toString());
    }

    private void f0(@NonNull WinkNewAlbumContext winkNewAlbumContext) {
        i iVar = new i(this, winkNewAlbumContext);
        Message message = new Message();
        message.obj = iVar;
        message.what = 0;
        U.sendMessage(message);
    }

    private boolean g0(WinkNewAlbumContext winkNewAlbumContext) {
        if (!L()) {
            QLog.i(b(), 1, "prepare not ready");
            return false;
        }
        if (winkNewAlbumContext.getIsLast()) {
            QLog.i(b(), 1, "success get last context");
            WinkNewAlbumCollectorDebugInstance.f324014a.u("should aggregation, get last context");
            h(j.INSTANCE.g(3, this.E.size()));
            return true;
        }
        if (w83.b.f445025a.I()) {
            return WinkNewAlbumCollectorUtils.f324042a.d(this.E, winkNewAlbumContext);
        }
        if (O(this.E.get(this.I), winkNewAlbumContext)) {
            String str = "candidate size is " + this.E.size() + ", new album year is " + winkNewAlbumContext.getMetaData().getYear() + ", new album month is " + winkNewAlbumContext.getMetaData().getMonth() + ", new album day is " + winkNewAlbumContext.getMetaData().getDayOfMonth();
            if (this.E.size() - this.I >= this.L.getSameDayCount()) {
                WinkNewAlbumCollectorDebugInstance.f324014a.u("should aggregation, diff same day is : " + (this.E.size() - this.I) + ", new album info : " + str);
                QLog.i(b(), 1, "should aggregation, diff same day is : " + (this.E.size() - this.I) + ", new album info : " + str);
                h(j.INSTANCE.g(2, this.E.size()));
                return true;
            }
            if (this.E.size() >= this.L.getEachCount()) {
                WinkNewAlbumCollectorDebugInstance.f324014a.u("should aggregation, candidate more than " + this.L.getEachCount() + ", new album info : " + str);
                QLog.i(b(), 1, "should aggregation, candidate more than " + this.L.getEachCount() + ", new album info : " + str);
                h(j.INSTANCE.g(1, this.E.size()));
                return true;
            }
        }
        return false;
    }

    private void h0(List<com.tencent.mobileqq.wink.newalbum.database.a> list) {
        if (list != null && list.size() != 1) {
            Collections.sort(list, new e());
            HashMap hashMap = new HashMap();
            for (int i3 = 0; i3 < list.size(); i3++) {
                hashMap.put(list.get(i3).getPhotoID(), Integer.valueOf(i3));
            }
            if (m.f324110a.g().size() == 0) {
                return;
            }
            Collections.sort(list, new f());
            HashMap hashMap2 = new HashMap();
            for (int i16 = 0; i16 < list.size(); i16++) {
                hashMap2.put(list.get(i16).getPhotoID(), Integer.valueOf(i16));
            }
            Collections.sort(list, new g(hashMap, hashMap2));
        }
    }

    private void i0(List<WinkNewAlbumContext> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<WinkNewAlbumContext> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getMetaData());
        }
        this.G.V(arrayList, null);
    }

    private void j0(WinkNewAlbumCollectorConfigInfo winkNewAlbumCollectorConfigInfo, ArrayList<WinkNewAlbumContext> arrayList, ArrayList<Float> arrayList2, final Boolean bool, final long j3, int i3, final WinkNewAlbumCollectorUtils.QueryTime queryTime) {
        if (arrayList2.size() == 0 && !bool.booleanValue()) {
            return;
        }
        QLog.i(b(), 1, "currentLoop" + WinkNewAlbumCollectorDebugInstance.f324014a.m() + ", storyID: " + winkNewAlbumCollectorConfigInfo.getStoryID() + ", name: " + winkNewAlbumCollectorConfigInfo.getAlbumConfigInfo().getStoryName() + ", total count: " + i3 + ", got count: " + arrayList.size());
        String b16 = b();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("write to sql, configInfo name: ");
        sb5.append(winkNewAlbumCollectorConfigInfo.getAlbumConfigInfo().getStoryName());
        sb5.append(", storyAlbumContextList count: ");
        sb5.append(arrayList.size());
        sb5.append(", similarity count: ");
        sb5.append(arrayList2.size());
        QLog.d(b16, 4, sb5.toString());
        if (arrayList2.size() != arrayList.size()) {
            QLog.e(b(), 1, "similaritys size: " + arrayList2.size() + " is not equal to story albums" + arrayList.size());
            return;
        }
        final WinkNewAlbumConfigInfo albumConfigInfo = winkNewAlbumCollectorConfigInfo.getAlbumConfigInfo();
        ArrayList arrayList3 = new ArrayList();
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            WinkNewAlbumContext winkNewAlbumContext = arrayList.get(i16);
            com.tencent.mobileqq.wink.newalbum.database.a aVar = new com.tencent.mobileqq.wink.newalbum.database.a();
            aVar.g(0);
            aVar.i(arrayList2.get(i16).floatValue());
            aVar.h(winkNewAlbumContext.getMetaData().getId());
            aVar.f(winkNewAlbumContext.getAestheticScore());
            arrayList3.add(aVar);
        }
        this.G.G(arrayList3, albumConfigInfo, true, new t83.b() { // from class: com.tencent.mobileqq.wink.newalbum.collector.h
            @Override // t83.b
            public final void a(boolean z16) {
                WinkNewAlbumCollectorProcessor.this.S(albumConfigInfo, bool, j3, queryTime, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(List<WinkNewMemoryAlbumResult> list) {
        if (list == null) {
            return;
        }
        for (WinkNewMemoryAlbumResult winkNewMemoryAlbumResult : list) {
            if (winkNewMemoryAlbumResult != null) {
                this.N.add(winkNewMemoryAlbumResult.getAlbumCoverPhotoId());
                QLog.i("WinkNewAlbumCollectorProcessor", 1, "addCacheAlbumCoverId:" + winkNewMemoryAlbumResult.getAlbumCoverPhotoId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (w83.b.f445025a.M()) {
            QLog.i(b(), 1, "stop");
            this.G.t();
            return;
        }
        QLog.i(b(), 1, "should clear all list and database");
        ArrayList arrayList = new ArrayList();
        Iterator<WinkNewAlbumCollectorConfigInfo> it = S.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAlbumConfigInfo());
        }
        this.G.F(arrayList, true, true, new t83.a() { // from class: com.tencent.mobileqq.wink.newalbum.collector.g
            @Override // t83.a
            public final void a(boolean z16) {
                WinkNewAlbumCollectorProcessor.this.P(z16);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b, com.tencent.mobileqq.wink.newalbum.processor.a
    public void a(@NonNull WinkNewAlbumContext winkNewAlbumContext) {
        if (winkNewAlbumContext == null) {
            QLog.e(b(), 1, "cannot add to candidateList, context is null");
            return;
        }
        if (!winkNewAlbumContext.getIsLast() && WinkNewAlbumDatabaseImp.J(winkNewAlbumContext.getMetaData().getId()) && w83.b.f445025a.M()) {
            QLog.d(b(), 4, "cannot add to candidateList, context is used");
            return;
        }
        super.a(winkNewAlbumContext);
        j.INSTANCE.n(getTraceId());
        WinkNewAlbumCollectorDebugInstance.f324014a.y();
        f0(winkNewAlbumContext);
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    @NonNull
    public String b() {
        return super.b() + "WinkNewAlbumCollectorProcessor";
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void onStop() {
        U.removeCallbacksAndMessages(null);
        this.D.set(true);
        b0();
        WinkNewAlbumCollectorDebugInstance.f324014a.j();
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void g() {
    }
}
