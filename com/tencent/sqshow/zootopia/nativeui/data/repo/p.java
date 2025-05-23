package com.tencent.sqshow.zootopia.nativeui.data.repo;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.nativeui.data.repo.p;
import com.tencent.sqshow.zootopia.nativeui.data.sort.PanelSortData;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelCategoryData;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelSectionData;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelTypeData;
import com.tencent.sqshow.zootopia.nativeui.view.PortalStoreGroupPanelPageData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import uv4.ah;
import uv4.ak;
import uv4.ao;
import uv4.ap;
import uv4.ar;
import uv4.at;
import uv4.au;
import uv4.ay;
import uv4.bg;
import uv4.bj;
import uv4.v;
import uv4.w;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b=\u0010>J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019JE\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000f2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJU\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u000f2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\f2\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020'H\u0016Jv\u00106\u001a\u00020\b2\b\b\u0002\u0010*\u001a\u00020'2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010-2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020'2\b\b\u0002\u00100\u001a\u00020\u00132\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u00020\u00042\n\b\u0002\u00105\u001a\u0004\u0018\u0001042\b\b\u0002\u0010\u0007\u001a\u00020\u0004R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u000208078\u0006\u00a2\u0006\f\n\u0004\b)\u00109\u001a\u0004\b:\u0010;\u00a8\u0006@"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/repo/p;", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/h;", "Luv4/w;", "rsp", "", "clearDressHistory", "fromCache", "refreshCurrentDress", "", "f", "Lcom/tencent/sqshow/zootopia/nativeui/data/sort/b;", "d", "", "Luv4/ay;", "data", "", "Lcom/tencent/sqshow/zootopia/nativeui/view/PortalStoreGroupPanelPageData;", "o", "([Luv4/ay;)Ljava/util/List;", "", "parentIndex", "Luv4/bg;", "groupData", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelSectionData;", DomainData.DOMAIN_NAME, "(I[Luv4/bg;Luv4/ay;)Ljava/util/List;", "grandIndex", "Luv4/ao;", "storeSectionCfgV1", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelCategoryData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(II[Luv4/ao;Luv4/bg;Luv4/ay;)Ljava/util/List;", "greatGrandIndex", "Luv4/bj;", "categoryCfg", "sectionCfgV1", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelTypeData;", "l", "(III[Luv4/bj;Luv4/ao;Luv4/bg;Luv4/ay;)Ljava/util/List;", "", "param", "a", "brandId", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "gender", "Lcom/tencent/mobileqq/zootopia/api/e;", "cb", "sceneParams", "source", "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", TagName.ENGINE_TYPE, "useCacheRsp", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, tl.h.F, "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/m;", "Landroidx/lifecycle/MutableLiveData;", "e", "()Landroidx/lifecycle/MutableLiveData;", "mPanelAllData", "<init>", "()V", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class p implements h {

    /* renamed from: a, reason: from kotlin metadata */
    private final MutableLiveData<PortalStorePanelAllData> mPanelAllData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/data/repo/p$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/w;", "result", "", "b", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<w> {

        /* renamed from: d */
        final /* synthetic */ String f371147d;

        /* renamed from: e */
        final /* synthetic */ p f371148e;

        /* renamed from: f */
        final /* synthetic */ boolean f371149f;

        /* renamed from: h */
        final /* synthetic */ boolean f371150h;

        /* renamed from: i */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<w> f371151i;

        b(String str, p pVar, boolean z16, boolean z17, com.tencent.mobileqq.zootopia.api.e<w> eVar) {
            this.f371147d = str;
            this.f371148e = pVar;
            this.f371149f = z16;
            this.f371150h = z17;
            this.f371151i = eVar;
        }

        public static final void c(com.tencent.mobileqq.zootopia.api.e eVar, w result) {
            Intrinsics.checkNotNullParameter(result, "$result");
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: b */
        public void onResultSuccess(final w result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("PortalStorePanelGroupDataRepo", 1, "refreshPanelAllData onResultSuccess brandId:" + this.f371147d);
            r.f371154a.b(result);
            p.g(this.f371148e, result, this.f371149f, false, this.f371150h, 4, null);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final com.tencent.mobileqq.zootopia.api.e<w> eVar = this.f371151i;
            uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.q
                @Override // java.lang.Runnable
                public final void run() {
                    p.b.c(com.tencent.mobileqq.zootopia.api.e.this, result);
                }
            }, ZPlanQQMC.INSTANCE.enableNewPortalStore() ? 0L : 500L);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("PortalStorePanelGroupDataRepo", 1, "refreshPanelAllData onResultFailure brandId:" + this.f371147d + " error:" + error + ", message:" + message);
            com.tencent.mobileqq.zootopia.api.e<w> eVar = this.f371151i;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000f, code lost:
    
        r0 = kotlin.collections.ArraysKt___ArraysKt.toList(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0026, code lost:
    
        r8 = kotlin.collections.ArraysKt___ArraysKt.toList(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final PanelSortData d(w rsp) {
        List emptyList;
        List emptyList2;
        int collectionSizeOrDefault;
        PanelSortData panelSortData = new PanelSortData(null, null, null, 7, null);
        ar[] arVarArr = rsp.f440461b;
        if (arVarArr == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        panelSortData.d().addAll(emptyList);
        ap[] apVarArr = rsp.f440463d;
        if (apVarArr == null || emptyList2 == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        }
        panelSortData.b().addAll(emptyList2);
        ArrayList<ah> c16 = panelSortData.c();
        ArrayList<ap> b16 = panelSortData.b();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ap apVar : b16) {
            ah ahVar = new ah();
            ahVar.f440138a = apVar.f440199a;
            ahVar.f440139b = apVar.f440203e;
            arrayList.add(ahVar);
        }
        c16.addAll(arrayList);
        return panelSortData;
    }

    public static final void j(p this$0, final w wVar, boolean z16, final com.tencent.mobileqq.zootopia.api.e eVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f(wVar, z16, true, true);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.o
            @Override // java.lang.Runnable
            public final void run() {
                p.k(com.tencent.mobileqq.zootopia.api.e.this, wVar);
            }
        }, ZPlanQQMC.INSTANCE.enableNewPortalStore() ? 0L : 500L);
    }

    private final List<PortalStorePanelTypeData> l(int greatGrandIndex, int grandIndex, int parentIndex, bj[] data, ao categoryCfg, bg sectionCfgV1, ay groupData) {
        Iterable<IndexedValue> withIndex;
        ArrayList arrayList = new ArrayList();
        if (data == null) {
            return arrayList;
        }
        withIndex = ArraysKt___ArraysKt.withIndex(data);
        for (IndexedValue indexedValue : withIndex) {
            int index = indexedValue.getIndex();
            bj bjVar = (bj) indexedValue.component2();
            String str = bjVar.f440349a;
            Intrinsics.checkNotNullExpressionValue(str, "item.id");
            String str2 = bjVar.f440351c;
            Intrinsics.checkNotNullExpressionValue(str2, "item.name");
            arrayList.add(new PortalStorePanelTypeData(index, parentIndex, grandIndex, greatGrandIndex, str, str2, bjVar, categoryCfg, sectionCfgV1, groupData));
        }
        return arrayList;
    }

    private final List<PortalStorePanelCategoryData> m(int i3, int i16, ao[] aoVarArr, bg bgVar, ay ayVar) {
        Iterable<IndexedValue> withIndex;
        ArrayList arrayList = new ArrayList();
        if (aoVarArr == null) {
            return arrayList;
        }
        withIndex = ArraysKt___ArraysKt.withIndex(aoVarArr);
        for (IndexedValue indexedValue : withIndex) {
            int index = indexedValue.getIndex();
            ao aoVar = (ao) indexedValue.component2();
            String str = aoVar.f440183a;
            Intrinsics.checkNotNullExpressionValue(str, "item.id");
            String str2 = aoVar.f440185c;
            Intrinsics.checkNotNullExpressionValue(str2, "item.name");
            arrayList.add(new PortalStorePanelCategoryData(index, i16, i3, str, str2, l(i3, i16, index, aoVar.f440189g, aoVar, bgVar, ayVar), aoVar, bgVar, ayVar));
        }
        return arrayList;
    }

    private final List<PortalStorePanelSectionData> n(int i3, bg[] bgVarArr, ay ayVar) {
        Iterable<IndexedValue> withIndex;
        ArrayList arrayList = new ArrayList();
        if (bgVarArr == null) {
            return arrayList;
        }
        withIndex = ArraysKt___ArraysKt.withIndex(bgVarArr);
        for (IndexedValue indexedValue : withIndex) {
            int index = indexedValue.getIndex();
            bg bgVar = (bg) indexedValue.component2();
            String str = bgVar.f440331a;
            Intrinsics.checkNotNullExpressionValue(str, "item.id");
            PortalStorePanelSectionData portalStorePanelSectionData = new PortalStorePanelSectionData(index, i3, str, m(i3, index, bgVar.f440337g, bgVar, ayVar), bgVar);
            String str2 = bgVar.f440333c;
            Intrinsics.checkNotNullExpressionValue(str2, "item.name");
            portalStorePanelSectionData.setTitle(str2);
            arrayList.add(portalStorePanelSectionData);
        }
        return arrayList;
    }

    private final List<PortalStoreGroupPanelPageData> o(ay[] data) {
        Iterable<IndexedValue> withIndex;
        ArrayList arrayList = new ArrayList();
        if (data == null) {
            return arrayList;
        }
        withIndex = ArraysKt___ArraysKt.withIndex(data);
        for (IndexedValue indexedValue : withIndex) {
            int index = indexedValue.getIndex();
            ay ayVar = (ay) indexedValue.component2();
            arrayList.add(new PortalStoreGroupPanelPageData(index + "-" + ayVar.f440266b, n(index, ayVar.f440270f, ayVar), ayVar, 0, false, null, 56, null));
        }
        return arrayList;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.repo.h
    public void a(String param) {
        Intrinsics.checkNotNullParameter(param, "param");
        yb4.e.g(yb4.e.f450058a, param, 0, 2, null);
    }

    public final MutableLiveData<PortalStorePanelAllData> e() {
        return this.mPanelAllData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void i(p pVar, String str, UEAvatarGender uEAvatarGender, com.tencent.mobileqq.zootopia.api.e eVar, boolean z16, String str2, int i3, AvatarEngineType avatarEngineType, boolean z17, com.tencent.sqshow.zootopia.nativeui.data.j jVar, boolean z18, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = "";
        }
        if ((i16 & 2) != 0) {
            uEAvatarGender = null;
        }
        if ((i16 & 4) != 0) {
            eVar = null;
        }
        if ((i16 & 8) != 0) {
            z16 = true;
        }
        if ((i16 & 16) != 0) {
            str2 = "";
        }
        if ((i16 & 32) != 0) {
            i3 = 0;
        }
        if ((i16 & 64) != 0) {
            avatarEngineType = AvatarEngineType.UE;
        }
        if ((i16 & 128) != 0) {
            z17 = false;
        }
        if ((i16 & 256) != 0) {
            jVar = null;
        }
        if ((i16 & 512) != 0) {
            z18 = true;
        }
        pVar.h(str, uEAvatarGender, eVar, z16, str2, i3, avatarEngineType, z17, jVar, z18);
    }

    public static final void k(com.tencent.mobileqq.zootopia.api.e eVar, w wVar) {
        if (eVar != null) {
            eVar.onResultSuccess(wVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x003d, code lost:
    
        r3 = kotlin.collections.ArraysKt___ArraysJvmKt.asList(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void f(w rsp, boolean clearDressHistory, boolean fromCache, boolean refreshCurrentDress) {
        List emptyList;
        try {
            List<PortalStoreGroupPanelPageData> o16 = o(rsp.f440460a);
            j94.a.f409675a.d(rsp);
            com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
            ak akVar = rsp.f440462c;
            UEAvatarGender g16 = cVar.g(akVar != null ? Integer.valueOf(akVar.f440145a) : null);
            ak akVar2 = rsp.f440462c;
            Intrinsics.checkNotNullExpressionValue(akVar2, "rsp.avatar");
            PanelSortData d16 = d(rsp);
            at atVar = rsp.f440464e;
            au auVar = rsp.f440465f;
            Integer valueOf = Integer.valueOf(rsp.f440466g);
            int[] iArr = rsp.f440467h;
            if (iArr == null || emptyList == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            this.mPanelAllData.setValue(new PortalStorePanelAllData(o16, akVar2, d16, atVar, auVar, valueOf, emptyList, rsp.f440468i, clearDressHistory, g16, fromCache, refreshCurrentDress));
            com.tencent.sqshow.zootopia.nativeui.view.experience.m.f371882a.a().postValue(rsp.f440465f);
        } catch (Throwable th5) {
            QLog.e("PortalStorePanelGroupDataRepo", 1, "handleGetStoreCfgV1Rsp error", th5);
        }
    }

    public final void h(String brandId, UEAvatarGender uEAvatarGender, final com.tencent.mobileqq.zootopia.api.e<w> eVar, final boolean z16, String sceneParams, int i3, AvatarEngineType engineType, boolean z17, com.tencent.sqshow.zootopia.nativeui.data.j jVar, boolean z18) {
        Intrinsics.checkNotNullParameter(brandId, "brandId");
        Intrinsics.checkNotNullParameter(sceneParams, "sceneParams");
        Intrinsics.checkNotNullParameter(engineType, "engineType");
        v vVar = new v();
        xb4.b bVar = xb4.b.f447772a;
        vVar.f440454a = bVar.q(bVar.k(uEAvatarGender, sceneParams));
        if (uEAvatarGender != null) {
            vVar.f440455b = uEAvatarGender.getIndex();
        }
        vVar.f440456c = i3;
        int f16 = (int) com.tencent.sqshow.zootopia.utils.i.f(e84.a.f395879a.d().height());
        vVar.f440458e = f16;
        vVar.f440457d = engineType.getEngineId();
        vVar.f440459f = com.tencent.sqshow.zootopia.nativeui.data.q.f371046a.i(jVar);
        QLog.i("PortalStorePanelGroupDataRepo", 1, "refreshPanelAllData brandId:" + brandId + ", gender:" + uEAvatarGender + ", sceneParams:" + sceneParams + ", source:" + i3 + ", heightInDp:" + f16);
        final w a16 = r.f371154a.a();
        if (z17 && a16 != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.n
                @Override // java.lang.Runnable
                public final void run() {
                    p.j(p.this, a16, z16, eVar);
                }
            });
        } else {
            com.tencent.sqshow.zootopia.nativeui.data.p.b(com.tencent.sqshow.zootopia.nativeui.data.p.f371044a, vVar, new b(brandId, this, z16, z18, eVar), 0, 4, null);
        }
    }

    static /* synthetic */ void g(p pVar, w wVar, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        if ((i3 & 8) != 0) {
            z18 = true;
        }
        pVar.f(wVar, z16, z17, z18);
    }
}
