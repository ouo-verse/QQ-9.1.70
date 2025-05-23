package com.tencent.sqshow.zootopia.mapstatus;

import bh3.DownloadTask;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pb3.a;
import pv4.y;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002Js\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013Jq\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u0017J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u0017J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u001bJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0006J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0002H\u0016R&\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170'0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010(R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010(R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/sqshow/zootopia/mapstatus/ZootopiaMapStatusManager;", "Lpb3/a;", "", "mapId", "", "f", "", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "", "progress", "version", "errorCode", "", "needRefreshUpdate", "realTimeSpeed", "averageSpeed", "isSilentDownload", "Lcom/tencent/sqshow/zootopia/mapstatus/c;", "i", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Z)Lcom/tencent/sqshow/zootopia/mapstatus/c;", "j", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Z)V", "c", "Lcom/tencent/sqshow/zootopia/mapstatus/a;", "callback", "g", h.F, "Lpv4/y;", "versionInfo", "e", "Lcom/tencent/sqshow/zootopia/mapstatus/b;", "d", "mapStatus", "l", "curCount", "onDownloadCountChanged", "id", "onTaskDelete", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/ConcurrentHashMap;", "mapToCallbacksMap", "mapStatusMap", "Ljava/util/concurrent/CopyOnWriteArraySet;", "callbackListeners", "Lbh3/c;", "Lbh3/c;", "listener", "Lcom/tencent/mobileqq/zplan/download/api/ICommonDownloadHelper;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zplan/download/api/ICommonDownloadHelper;", "downloadHelper", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaMapStatusManager implements pb3.a {

    /* renamed from: d, reason: collision with root package name */
    public static final ZootopiaMapStatusManager f370743d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, CopyOnWriteArraySet<com.tencent.sqshow.zootopia.mapstatus.a>> mapToCallbacksMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, c> mapStatusMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArraySet<com.tencent.sqshow.zootopia.mapstatus.a> callbackListeners;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final bh3.c listener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static final ICommonDownloadHelper downloadHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/sqshow/zootopia/mapstatus/ZootopiaMapStatusManager$a", "Lbh3/b;", "Lbh3/d;", "task", "", "c", "d", h.F, "a", "f", "b", "", "errorCode", "", "errorMessage", "g", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements bh3.b {
        a() {
        }

        @Override // bh3.a
        public void a(DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZootopiaMapStatusManager.k(ZootopiaMapStatusManager.f370743d, task.getTaskId(), Integer.valueOf(task.getState()), Float.valueOf(task.getProgress()), null, null, false, null, null, task.getIsSilentDownload(), 248, null);
        }

        @Override // bh3.a
        public void b(DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZootopiaMapStatusManager.k(ZootopiaMapStatusManager.f370743d, task.getTaskId(), Integer.valueOf(task.getState()), Float.valueOf(task.getProgress()), null, null, false, Integer.valueOf(task.getRealTimeSpeed()), Integer.valueOf(task.getAverageSpeed()), task.getIsSilentDownload(), 56, null);
        }

        @Override // bh3.a
        public void c(DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZootopiaMapStatusManager.k(ZootopiaMapStatusManager.f370743d, task.getTaskId(), Integer.valueOf(task.getState()), Float.valueOf(task.getProgress()), null, null, false, null, null, task.getIsSilentDownload(), 248, null);
        }

        @Override // bh3.a
        public void d(DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZootopiaMapStatusManager.k(ZootopiaMapStatusManager.f370743d, task.getTaskId(), Integer.valueOf(task.getState()), null, null, null, true, Integer.valueOf(task.getRealTimeSpeed()), Integer.valueOf(task.getAverageSpeed()), task.getIsSilentDownload(), 24, null);
        }

        @Override // bh3.a
        public void f(DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZootopiaMapStatusManager.k(ZootopiaMapStatusManager.f370743d, task.getTaskId(), Integer.valueOf(task.getState()), Float.valueOf(task.getProgress()), null, null, false, null, null, task.getIsSilentDownload(), 248, null);
        }

        @Override // bh3.a
        public void g(DownloadTask task, int errorCode, String errorMessage) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZootopiaMapStatusManager.k(ZootopiaMapStatusManager.f370743d, task.getTaskId(), Integer.valueOf(task.getState()), Float.valueOf(task.getProgress()), null, Integer.valueOf(errorCode), false, null, null, task.getIsSilentDownload(), 232, null);
        }

        @Override // bh3.a
        public void h(DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZootopiaMapStatusManager.k(ZootopiaMapStatusManager.f370743d, task.getTaskId(), Integer.valueOf(task.getState()), Float.valueOf(task.getProgress()), null, null, false, Integer.valueOf(task.getRealTimeSpeed()), Integer.valueOf(task.getAverageSpeed()), task.getIsSilentDownload(), 56, null);
        }
    }

    static {
        ZootopiaMapStatusManager zootopiaMapStatusManager = new ZootopiaMapStatusManager();
        f370743d = zootopiaMapStatusManager;
        mapToCallbacksMap = new ConcurrentHashMap<>();
        mapStatusMap = new ConcurrentHashMap<>();
        callbackListeners = new CopyOnWriteArraySet<>();
        bh3.c a16 = bh3.b.INSTANCE.a(new a());
        listener = a16;
        QRouteApi api = QRoute.api(ICommonDownloadHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ICommonDownloadHelper::class.java)");
        ICommonDownloadHelper iCommonDownloadHelper = (ICommonDownloadHelper) api;
        downloadHelper = iCommonDownloadHelper;
        iCommonDownloadHelper.addDownloadListener(a16);
        iCommonDownloadHelper.addManagerListener(zootopiaMapStatusManager);
    }

    ZootopiaMapStatusManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String mapId) {
        c cVar;
        ConcurrentHashMap<String, c> concurrentHashMap = mapStatusMap;
        synchronized (concurrentHashMap) {
            cVar = concurrentHashMap.get(mapId);
        }
        if (cVar == null) {
            QLog.e("ZootopiaMapStatusManager", 1, "callback mapId:" + mapId);
            return;
        }
        if (cVar.getIsSilentDownload() && (cVar.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() == 2 || cVar.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() == 4 || cVar.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() == 1 || cVar.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() == 8)) {
            QLog.i("ZootopiaMapStatusManager", 1, "callback mapId:" + mapId + ", silentDownload return fake status, real= " + cVar.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String());
            cVar.q(0);
        }
        b bVar = new b(cVar);
        CopyOnWriteArraySet<com.tencent.sqshow.zootopia.mapstatus.a> copyOnWriteArraySet = mapToCallbacksMap.get(mapId);
        if (copyOnWriteArraySet != null) {
            Iterator<T> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                ((com.tencent.sqshow.zootopia.mapstatus.a) it.next()).r1(bVar);
            }
        }
        Iterator<T> it5 = callbackListeners.iterator();
        while (it5.hasNext()) {
            ((com.tencent.sqshow.zootopia.mapstatus.a) it5.next()).r1(bVar);
        }
    }

    private final void f(final String mapId) {
        if (mapStatusMap.containsKey(mapId)) {
            c(mapId);
        } else {
            downloadHelper.getZootopiaResInfo(mapId, new Function1<ZootopiaResData, Unit>() { // from class: com.tencent.sqshow.zootopia.mapstatus.ZootopiaMapStatusManager$queryMapState$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ZootopiaResData zootopiaResData) {
                    invoke2(zootopiaResData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ZootopiaResData zootopiaResData) {
                    String str;
                    ZootopiaMapStatusManager zootopiaMapStatusManager = ZootopiaMapStatusManager.f370743d;
                    String str2 = mapId;
                    Integer valueOf = zootopiaResData != null ? Integer.valueOf(zootopiaResData.getDownloadStatus()) : null;
                    Float valueOf2 = zootopiaResData != null ? Float.valueOf(zootopiaResData.getProgress()) : null;
                    if (zootopiaResData == null || (str = zootopiaResData.getVersion()) == null) {
                        str = "";
                    }
                    ZootopiaMapStatusManager.k(zootopiaMapStatusManager, str2, valueOf, valueOf2, str, null, false, null, null, zootopiaResData != null ? zootopiaResData.isSilentDownload() : false, 240, null);
                }
            });
        }
    }

    private final void j(String mapId, Integer downloadStatus, Float progress, String version, Integer errorCode, boolean needRefreshUpdate, Integer realTimeSpeed, Integer averageSpeed, boolean isSilentDownload) {
        i(mapId, downloadStatus, progress, version, errorCode, needRefreshUpdate, realTimeSpeed, averageSpeed, isSilentDownload);
        if (!isSilentDownload || (downloadStatus != null && downloadStatus.intValue() == 5)) {
            c(mapId);
        }
    }

    public final b d(String mapId) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        c cVar = mapStatusMap.get(mapId);
        if (cVar == null) {
            return null;
        }
        return new b(cVar);
    }

    public final void e(final String mapId, final y versionInfo) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        Intrinsics.checkNotNullParameter(versionInfo, "versionInfo");
        QLog.i("ZootopiaMapStatusManager", 1, "onServerVersionUpdate mapId = " + mapId + " versionInfo = " + versionInfo);
        downloadHelper.getZootopiaResInfo(mapId, new Function1<ZootopiaResData, Unit>() { // from class: com.tencent.sqshow.zootopia.mapstatus.ZootopiaMapStatusManager$onServerVersionUpdate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaResData zootopiaResData) {
                invoke2(zootopiaResData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaResData zootopiaResData) {
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                ConcurrentHashMap concurrentHashMap3;
                ConcurrentHashMap concurrentHashMap4;
                concurrentHashMap = ZootopiaMapStatusManager.mapStatusMap;
                String str = mapId;
                y yVar = versionInfo;
                synchronized (concurrentHashMap) {
                    concurrentHashMap2 = ZootopiaMapStatusManager.mapStatusMap;
                    if (!concurrentHashMap2.containsKey(str)) {
                        concurrentHashMap4 = ZootopiaMapStatusManager.mapStatusMap;
                        concurrentHashMap4.put(str, new c(str));
                    }
                    concurrentHashMap3 = ZootopiaMapStatusManager.mapStatusMap;
                    c cVar = (c) concurrentHashMap3.get(str);
                    if (cVar != null) {
                        cVar.o(yVar, zootopiaResData);
                        Unit unit = Unit.INSTANCE;
                    }
                }
                ZootopiaMapStatusManager.f370743d.c(mapId);
            }
        });
    }

    public final void g(String mapId, com.tencent.sqshow.zootopia.mapstatus.a callback) {
        CopyOnWriteArraySet<com.tencent.sqshow.zootopia.mapstatus.a> copyOnWriteArraySet;
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ConcurrentHashMap<String, CopyOnWriteArraySet<com.tencent.sqshow.zootopia.mapstatus.a>> concurrentHashMap = mapToCallbacksMap;
        if (!concurrentHashMap.containsKey(mapId)) {
            concurrentHashMap.put(mapId, new CopyOnWriteArraySet<>());
        }
        CopyOnWriteArraySet<com.tencent.sqshow.zootopia.mapstatus.a> copyOnWriteArraySet2 = concurrentHashMap.get(mapId);
        boolean z16 = false;
        if (copyOnWriteArraySet2 != null && !copyOnWriteArraySet2.contains(callback)) {
            z16 = true;
        }
        if (z16 && (copyOnWriteArraySet = concurrentHashMap.get(mapId)) != null) {
            copyOnWriteArraySet.add(callback);
        }
        f(mapId);
    }

    public final void h(String mapId, com.tencent.sqshow.zootopia.mapstatus.a callback) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        CopyOnWriteArraySet<com.tencent.sqshow.zootopia.mapstatus.a> copyOnWriteArraySet = mapToCallbacksMap.get(mapId);
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.remove(callback);
        }
    }

    public final void l(String mapId, int mapStatus) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        ConcurrentHashMap<String, c> concurrentHashMap = mapStatusMap;
        synchronized (concurrentHashMap) {
            if (!concurrentHashMap.containsKey(mapId)) {
                concurrentHashMap.put(mapId, new c(mapId));
            }
            c cVar = concurrentHashMap.get(mapId);
            if (cVar != null) {
                cVar.s(mapStatus);
                Unit unit = Unit.INSTANCE;
            }
        }
        c(mapId);
    }

    @Override // pb3.a
    public void onDownloadingCountChanged(int i3) {
        a.C10996a.b(this, i3);
    }

    @Override // pb3.a
    public void onTaskDelete(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        k(this, id5, 0, Float.valueOf(0.0f), "", null, false, null, null, false, w.CTRL_INDEX, null);
    }

    private final c i(String mapId, Integer downloadStatus, Float progress, String version, Integer errorCode, boolean needRefreshUpdate, Integer realTimeSpeed, Integer averageSpeed, boolean isSilentDownload) {
        c cVar;
        ConcurrentHashMap<String, c> concurrentHashMap = mapStatusMap;
        synchronized (concurrentHashMap) {
            if (!concurrentHashMap.containsKey(mapId)) {
                concurrentHashMap.put(mapId, new c(mapId));
            }
            cVar = concurrentHashMap.get(mapId);
            if (cVar != null) {
                cVar.r(downloadStatus, progress, version, errorCode, realTimeSpeed, averageSpeed, Boolean.valueOf(isSilentDownload));
                if (needRefreshUpdate) {
                    cVar.p();
                }
            } else {
                cVar = null;
            }
        }
        return cVar;
    }

    @Override // pb3.a
    public void onDownloadCountChanged(int curCount) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(ZootopiaMapStatusManager zootopiaMapStatusManager, String str, Integer num, Float f16, String str2, Integer num2, boolean z16, Integer num3, Integer num4, boolean z17, int i3, Object obj) {
        zootopiaMapStatusManager.j(str, num, (i3 & 4) != 0 ? null : f16, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : num2, (i3 & 32) != 0 ? false : z16, (i3 & 64) != 0 ? null : num3, (i3 & 128) != 0 ? null : num4, (i3 & 256) != 0 ? false : z17);
    }
}
