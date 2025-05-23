package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.datacenter;

import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J*\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0011\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\tRD\u0010\u0004\u001a,\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b0\u00050\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/datacenter/ObserverWrapper;", "T", "", "()V", "observerMap", "", "Lkotlin/reflect/KClass;", "", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/datacenter/IDataObserver;", "getObserverMap", "()Ljava/util/Map;", "setObserverMap", "(Ljava/util/Map;)V", "addObserver", "", "clazz", "dataId", "observer", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class ObserverWrapper<T> {
    public static final int $stable = 8;
    private Map<KClass<T>, Map<String, List<IDataObserver<T>>>> observerMap = new LinkedHashMap();

    public final void addObserver(KClass<T> clazz, String dataId, IDataObserver<T> observer) {
        KLog.INSTANCE.d(QzoneDataCenter.TAG, "addObserver, clazz: " + clazz + ", dataId: " + dataId + ", observer, " + observer);
        Map<String, List<IDataObserver<T>>> map = this.observerMap.get(clazz);
        if (map == null) {
            map = new LinkedHashMap<>();
            this.observerMap.put(clazz, map);
        }
        List<IDataObserver<T>> list = map.get(dataId);
        if (list == null) {
            list = new ArrayList<>();
            map.put(dataId, list);
        }
        list.add(observer);
    }

    public final Map<KClass<T>, Map<String, List<IDataObserver<T>>>> getObserverMap() {
        return this.observerMap;
    }

    public final void setObserverMap(Map<KClass<T>, Map<String, List<IDataObserver<T>>>> map) {
        this.observerMap = map;
    }
}
