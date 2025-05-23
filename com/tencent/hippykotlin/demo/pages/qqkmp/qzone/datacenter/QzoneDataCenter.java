package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.datacenter;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.kuikly.core.log.KLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J;\u0010\n\u001a\u00020\u000b\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086\bJD\u0010\u0013\u001a\u00020\u000b\"\b\b\u0000\u0010\f*\u00020\u00012\u0006\u0010\r\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\f0\u00072\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0001H\u0002J#\u0010\u0017\u001a\u00020\u000b\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u0010H\u0086\bJ\u001e\u0010\u0018\u001a\u00020\u000b\"\b\b\u0000\u0010\f*\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u0010J\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004J4\u0010\u001a\u001a\u00020\u000b\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u0002H\f2\b\b\u0002\u0010\u001b\u001a\u00020\u0004H\u0086\b\u00a2\u0006\u0002\u0010\u001cJ;\u0010\u001d\u001a\u00020\u000b\"\b\b\u0000\u0010\f*\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\f0\u00072\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u0002H\f2\u0006\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\u00060\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/datacenter/QzoneDataCenter;", "", "()V", "TAG", "", "cacheDataMap", "", "Lkotlin/reflect/KClass;", "observerMap", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/datacenter/ObserverWrapper;", "observeData", "", "T", "pageId", "dataId", "observer", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/datacenter/IDataObserver;", "applyCacheData", "", "observeDataInternal", "clazz", "printData", "data", "releaseObserver", "releaseObserverInternal", "releasePageObservers", "updateDataAndNotify", "action", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "updateDataAndNotifyInternal", "(Lkotlin/reflect/KClass;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneDataCenter {
    public static final String TAG = "QzoneDataCenter";
    public static final QzoneDataCenter INSTANCE = new QzoneDataCenter();
    private static Map<String, ObserverWrapper<?>> observerMap = new LinkedHashMap();
    private static Map<KClass<?>, Map<String, ?>> cacheDataMap = new LinkedHashMap();
    public static final int $stable = 8;

    QzoneDataCenter() {
    }

    private final String printData(Object data) {
        if (data instanceof List) {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("list, size: ");
            m3.append(((List) data).size());
            return m3.toString();
        }
        return data.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void observeDataInternal(String pageId, KClass<T> clazz, String dataId, IDataObserver<T> observer, boolean applyCacheData) {
        KLog kLog = KLog.INSTANCE;
        kLog.d(TAG, "observeDataInternal, pageId: " + pageId + ", clazz: " + clazz + ", dataId: " + dataId + ", applyCacheData, " + applyCacheData);
        ObserverWrapper<?> observerWrapper = observerMap.get(pageId);
        ObserverWrapper<?> observerWrapper2 = observerWrapper instanceof ObserverWrapper ? observerWrapper : null;
        if (observerWrapper2 == null) {
            observerWrapper2 = new ObserverWrapper<>();
            observerMap.put(pageId, observerWrapper2);
        }
        observerWrapper2.addObserver(clazz, dataId, observer);
        Map<String, ?> map = cacheDataMap.get(clazz);
        Map<String, ?> map2 = TypeIntrinsics.isMutableMap(map) ? map : null;
        Object obj = map2 != null ? map2.get(dataId) : null;
        if (!applyCacheData || obj == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onDataUpdateWhenObserve, clazz: ");
        sb5.append(clazz);
        sb5.append(", dataId: ");
        sb5.append(dataId);
        sb5.append(", action: MEMORY_CACHE, observer: ");
        sb5.append(observer);
        sb5.append(", data: ");
        NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(sb5, printData(obj), kLog, TAG);
        observer.onDataUpdate(obj, QzoneDataUpdateAction.MEMORY_CACHE);
    }

    /* renamed from: releaseObserverInternal, reason: merged with bridge method [inline-methods] */
    public final <T> void releaseObserver(IDataObserver<T> observer) {
        KLog.INSTANCE.d(TAG, "check releaseObserverInternal, observer: " + observer);
        Iterator<T> it = observerMap.values().iterator();
        while (it.hasNext()) {
            ObserverWrapper observerWrapper = (ObserverWrapper) it.next();
            if (!(observerWrapper instanceof ObserverWrapper)) {
                observerWrapper = null;
            }
            if (observerWrapper != null) {
                Iterator<T> it5 = observerWrapper.getObserverMap().values().iterator();
                while (it5.hasNext()) {
                    Iterator<T> it6 = ((Map) it5.next()).values().iterator();
                    while (it6.hasNext()) {
                        if (((List) it6.next()).remove(observer)) {
                            KLog.INSTANCE.d(TAG, "releaseObserverInternal success, observer: " + observer);
                        }
                    }
                }
            }
        }
    }

    public final void releasePageObservers(String pageId) {
        observerMap.remove(pageId);
    }

    public final <T> void updateDataAndNotifyInternal(KClass<T> clazz, String dataId, T data, String action) {
        KLog kLog = KLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("updateDataAndNotifyInternal, clazz: ");
        sb5.append(clazz);
        sb5.append(", dataId: ");
        sb5.append(dataId);
        sb5.append(", action: ");
        sb5.append(action);
        sb5.append(", data: ");
        NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(sb5, printData(data), kLog, TAG);
        Map<String, ?> map = cacheDataMap.get(clazz);
        Map<String, ?> map2 = TypeIntrinsics.isMutableMap(map) ? map : null;
        if (map2 == null) {
            map2 = new LinkedHashMap<>();
            cacheDataMap.put(clazz, map2);
        }
        map2.put(dataId, data);
        Iterator<T> it = observerMap.values().iterator();
        while (it.hasNext()) {
            ObserverWrapper observerWrapper = (ObserverWrapper) it.next();
            if (!(observerWrapper instanceof ObserverWrapper)) {
                observerWrapper = null;
            }
            if (observerWrapper != null) {
                Map<String, List<IDataObserver<T>>> map3 = observerWrapper.getObserverMap().get(clazz);
                List<IDataObserver<T>> list = map3 != null ? map3.get(dataId) : null;
                if (list != null) {
                    Iterator<T> it5 = list.iterator();
                    while (it5.hasNext()) {
                        IDataObserver iDataObserver = (IDataObserver) it5.next();
                        KLog kLog2 = KLog.INSTANCE;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("onDataUpdate, clazz: ");
                        sb6.append(clazz);
                        sb6.append(", dataId: ");
                        sb6.append(dataId);
                        sb6.append(", action: ");
                        sb6.append(action);
                        sb6.append(", observer: ");
                        sb6.append(iDataObserver);
                        sb6.append(", data: ");
                        NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(sb6, INSTANCE.printData(data), kLog2, TAG);
                        if (iDataObserver != null) {
                            iDataObserver.onDataUpdate(data, action);
                        }
                    }
                }
            }
        }
    }

    public final /* synthetic */ <T> void observeData(String pageId, String dataId, IDataObserver<T> observer, boolean applyCacheData) {
        Intrinsics.reifiedOperationMarker(4, "T");
        observeDataInternal(pageId, Reflection.getOrCreateKotlinClass(Object.class), dataId, observer, applyCacheData);
    }

    public final /* synthetic */ <T> void updateDataAndNotify(String dataId, T data, String action) {
        Intrinsics.reifiedOperationMarker(4, "T");
        updateDataAndNotifyInternal(Reflection.getOrCreateKotlinClass(Object.class), dataId, data, action);
    }

    public static /* synthetic */ void updateDataAndNotify$default(QzoneDataCenter qzoneDataCenter, String str, Object obj, String str2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            str2 = "REFRESH";
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        qzoneDataCenter.updateDataAndNotifyInternal(Reflection.getOrCreateKotlinClass(Object.class), str, obj, str2);
    }
}
