package com.tencent.mobileqq.zootopia.space;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadTask;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchManager;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager;
import com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadRepository;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\"\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000bH\u0003J\u0016\u0010\u0013\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0003J\b\u0010\u0014\u001a\u00020\u0002H\u0003J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00152\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0015H\u0007J\"\u0010\u0019\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0007J\"\u0010\u001a\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0007J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0002R<\u0010$\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0!0 j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0!`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010#R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00170!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/zootopia/space/MapOccupiedSpaceManager;", "Lcom/tencent/mobileqq/zootopia/download/ah;", "", UserInfo.SEX_FEMALE, "", "", "mapIdList", "H", "mapId", "", "singleNotify", "Lcom/tencent/mobileqq/zootopia/space/k;", "G", "Lkotlin/Function0;", "callback", "v", "info", "M", "infoList", "N", "L", "Landroidx/lifecycle/LiveData;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/zootopia/space/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ReportConstant.COSTREPORT_PREFIX, "u", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "c", "B", "D", "Ljava/util/HashMap;", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "spaceInfoDataMap", "d", "Landroidx/lifecycle/MutableLiveData;", "allMapSpaceInfoLiveData", "Lcom/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadRepository;", "e", "Lcom/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadRepository;", "downloadRepo", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MapOccupiedSpaceManager extends ah {

    /* renamed from: b, reason: collision with root package name */
    public static final MapOccupiedSpaceManager f329259b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, MutableLiveData<MapSpaceInfo>> spaceInfoDataMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<AllMapSpaceInfo> allMapSpaceInfoLiveData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ZootopiaDownloadRepository downloadRepo;

    static {
        MapOccupiedSpaceManager mapOccupiedSpaceManager = new MapOccupiedSpaceManager();
        f329259b = mapOccupiedSpaceManager;
        spaceInfoDataMap = new HashMap<>();
        allMapSpaceInfoLiveData = new MutableLiveData<>();
        downloadRepo = new ZootopiaDownloadRepository();
        ZootopiaDownloadManager.f327992a.G(mapOccupiedSpaceManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(String mapId) {
        Intrinsics.checkNotNullParameter(mapId, "$mapId");
        I(f329259b, mapId, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E() {
        f329259b.F();
    }

    private final MapSpaceInfo G(String mapId, boolean singleNotify) {
        BaseApplication context = BaseApplication.getContext();
        j jVar = j.f329276a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        List<String> d16 = jVar.d(mapId, context);
        List<String> c16 = jVar.c(mapId, context);
        QLog.i("MapOccupiedSpaceManager", 1, "scanInner mapId:" + mapId + ", modMainPath:" + d16 + ", modCachePath:" + c16);
        long b16 = jVar.b(d16);
        long b17 = jVar.b(c16);
        QLog.i("MapOccupiedSpaceManager", 1, "scanInner mainSize:" + b16 + ", cacheSize:" + b17);
        final MapSpaceInfo mapSpaceInfo = new MapSpaceInfo(mapId, b16, b17);
        if (singleNotify) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.space.f
                @Override // java.lang.Runnable
                public final void run() {
                    MapOccupiedSpaceManager.K(MapSpaceInfo.this);
                }
            });
        }
        return mapSpaceInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(List<String> mapIdList) {
        final ArrayList arrayList = new ArrayList();
        Iterator<String> it = mapIdList.iterator();
        while (it.hasNext()) {
            arrayList.add(G(it.next(), false));
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.space.d
            @Override // java.lang.Runnable
            public final void run() {
                MapOccupiedSpaceManager.J(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(ArrayList scanResult) {
        Intrinsics.checkNotNullParameter(scanResult, "$scanResult");
        f329259b.N(scanResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(MapSpaceInfo info) {
        Intrinsics.checkNotNullParameter(info, "$info");
        f329259b.M(info);
    }

    private final void L() {
        QLog.i("MapOccupiedSpaceManager", 1, "updateAllMapSpaceInfo");
        Collection<MutableLiveData<MapSpaceInfo>> values = spaceInfoDataMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "spaceInfoDataMap.values");
        ArrayList arrayList = new ArrayList();
        Iterator<MutableLiveData<MapSpaceInfo>> it = values.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            MapSpaceInfo value = it.next().getValue();
            if (value != null) {
                arrayList.add(value);
                j3 += value.getMainOccupiedSize() + value.getCacheOccupiedSize();
                QLog.i("MapOccupiedSpaceManager", 1, "updateAllMapSpaceInfo info:" + value);
            }
        }
        QLog.i("MapOccupiedSpaceManager", 1, "updateAllMapSpaceInfo total:" + j3);
        allMapSpaceInfoLiveData.setValue(new AllMapSpaceInfo(j3, arrayList));
    }

    private final void M(MapSpaceInfo info) {
        List<MapSpaceInfo> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(info);
        N(listOf);
    }

    private final void N(List<MapSpaceInfo> infoList) {
        QLog.i("MapOccupiedSpaceManager", 1, "updateMapOccupiedSpace infoList:" + infoList);
        for (MapSpaceInfo mapSpaceInfo : infoList) {
            HashMap<String, MutableLiveData<MapSpaceInfo>> hashMap = spaceInfoDataMap;
            MutableLiveData<MapSpaceInfo> mutableLiveData = hashMap.get(mapSpaceInfo.getMapId());
            if (mutableLiveData == null) {
                mutableLiveData = new MutableLiveData<>();
                hashMap.put(mapSpaceInfo.getMapId(), mutableLiveData);
            }
            mutableLiveData.setValue(mapSpaceInfo);
        }
        L();
    }

    private final void v(final String mapId, final Function0<Unit> callback) {
        j jVar = j.f329276a;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        final List<String> c16 = jVar.c(mapId, context);
        QLog.i("MapOccupiedSpaceManager", 1, "deleteMapCacheFiles - " + mapId + " - " + c16);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.space.e
            @Override // java.lang.Runnable
            public final void run() {
                MapOccupiedSpaceManager.w(c16, mapId, callback);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(List cacheDirList, String mapId, final Function0 function0) {
        Intrinsics.checkNotNullParameter(cacheDirList, "$cacheDirList");
        Intrinsics.checkNotNullParameter(mapId, "$mapId");
        Iterator it = cacheDirList.iterator();
        while (it.hasNext()) {
            FileUtils.deleteDirectory((String) it.next());
        }
        ZPlanModHotPatchManager.f328077a.p(mapId, "deleteMapCacheFiles", true);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.zootopia.space.g
            @Override // java.lang.Runnable
            public final void run() {
                MapOccupiedSpaceManager.x(Ref.BooleanRef.this, function0);
            }
        };
        ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, 5000L);
        FileDownloadManager.f328148a.k(cacheDirList);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.space.h
            @Override // java.lang.Runnable
            public final void run() {
                MapOccupiedSpaceManager.y(Ref.BooleanRef.this, function0, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Ref.BooleanRef hasCallback, Function0 function0) {
        Intrinsics.checkNotNullParameter(hasCallback, "$hasCallback");
        QLog.i("MapOccupiedSpaceManager", 1, "deleteMapCacheFiles delayed, hasCallback= " + hasCallback.element);
        if (hasCallback.element) {
            return;
        }
        hasCallback.element = true;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Ref.BooleanRef hasCallback, Function0 function0, Runnable callbackRunnable) {
        Intrinsics.checkNotNullParameter(hasCallback, "$hasCallback");
        Intrinsics.checkNotNullParameter(callbackRunnable, "$callbackRunnable");
        QLog.i("MapOccupiedSpaceManager", 1, "deleteMapCacheFiles normalFinish, hasCallback= " + hasCallback.element);
        if (hasCallback.element) {
            return;
        }
        hasCallback.element = true;
        if (function0 != null) {
            function0.invoke();
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(callbackRunnable);
    }

    public final LiveData<MapSpaceInfo> A(String mapId) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        HashMap<String, MutableLiveData<MapSpaceInfo>> hashMap = spaceInfoDataMap;
        MutableLiveData<MapSpaceInfo> mutableLiveData = hashMap.get(mapId);
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        MutableLiveData<MapSpaceInfo> mutableLiveData2 = new MutableLiveData<>();
        hashMap.put(mapId, mutableLiveData2);
        return mutableLiveData2;
    }

    public final void B(final String mapId) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.space.c
            @Override // java.lang.Runnable
            public final void run() {
                MapOccupiedSpaceManager.C(mapId);
            }
        }, 64, null, false);
    }

    public final void D() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.space.b
            @Override // java.lang.Runnable
            public final void run() {
                MapOccupiedSpaceManager.E();
            }
        }, 32, null, false);
    }

    @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
    public void c(x task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task instanceof ZootopiaDownloadTask) {
            QLog.i("MapOccupiedSpaceManager", 1, "onComplete ZootopiaDownloadTask id:" + task.getId());
            B(task.getId());
        }
    }

    public final void s(String mapId, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        spaceInfoDataMap.remove(mapId);
        L();
        v(mapId, callback);
    }

    public final void u(String mapId, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        v(mapId, callback);
        MapSpaceInfo value = A(mapId).getValue();
        if (value != null) {
            value.e(0L);
            f329259b.M(value);
        }
    }

    public final LiveData<AllMapSpaceInfo> z() {
        return allMapSpaceInfoLiveData;
    }

    private final void F() {
        QLog.i("MapOccupiedSpaceManager", 1, "initAsync ");
        downloadRepo.j(MapOccupiedSpaceManager$scanAllDownloadedMapInner$1.INSTANCE);
    }

    MapOccupiedSpaceManager() {
        super(null, 1, null);
    }

    static /* synthetic */ MapSpaceInfo I(MapOccupiedSpaceManager mapOccupiedSpaceManager, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return mapOccupiedSpaceManager.G(str, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void t(MapOccupiedSpaceManager mapOccupiedSpaceManager, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = null;
        }
        mapOccupiedSpaceManager.s(str, function0);
    }
}
