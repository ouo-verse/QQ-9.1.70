package com.tencent.cache.api.collection;

import androidx.recyclerview.widget.BaseRecycledViewPool;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.cache.api.Business;
import com.tencent.cache.core.collection.collector.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmDefault;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001\"B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/cache/api/collection/b;", "Landroidx/recyclerview/widget/BaseRecycledViewPool;", "Lcom/tencent/cache/core/collection/base/b;", "", "viewType", "getMaxRecycledViews", "max", "", "setMaxRecycledViews", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getRecycledView", "scrap", "putRecycledView", "Lcom/tencent/cache/core/collection/base/c;", "getCollector", QCircleLpReportDc05507.KEY_CLEAR, "", "needRemoveSize", "trimMemory", "getCount", "", "getItemType", "Lcom/tencent/cache/core/collection/collector/d;", "collector", "Lcom/tencent/cache/core/collection/collector/d;", "Ljava/util/concurrent/ConcurrentHashMap;", "viewTypeToMaxScrap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/cache/api/Business;", "business", "subBusiness", "<init>", "(Lcom/tencent/cache/api/Business;Ljava/lang/String;)V", "Companion", "a", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public class b extends BaseRecycledViewPool implements com.tencent.cache.core.collection.base.b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int DEFAULT_MAX_SCRAP = 5;
    private static final String TAG = "QQRecycledViewPool";
    private d<RecyclerView.ViewHolder> collector;
    private ConcurrentHashMap<Integer, Integer> viewTypeToMaxScrap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/cache/api/collection/b$a;", "", "", "DEFAULT_MAX_SCRAP", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "Library_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.cache.api.collection.b$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12031);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull Business business, @NotNull String subBusiness) {
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(subBusiness, "subBusiness");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) business, (Object) subBusiness);
            return;
        }
        this.collector = new d<>(business.name(), subBusiness);
        this.viewTypeToMaxScrap = new ConcurrentHashMap<>();
        register(business, subBusiness);
        com.tencent.cache.core.util.b.f98833f.j(TAG, 1, "init");
    }

    private final int getMaxRecycledViews(int viewType) {
        Integer num = this.viewTypeToMaxScrap.get(Integer.valueOf(viewType));
        if (num != null) {
            return num.intValue();
        }
        return 5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool, com.tencent.cache.api.b, java.util.AbstractMap, java.util.Map
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.clear();
            com.tencent.cache.core.collection.base.c.d(this.collector, false, 1, null);
        }
    }

    @Override // com.tencent.cache.core.collection.base.b
    @JvmDefault
    @NotNull
    public com.tencent.cache.core.collection.base.d getCacheInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.cache.core.collection.base.d) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return getCollector().c();
    }

    @Override // com.tencent.cache.api.b
    @JvmDefault
    @Nullable
    public /* bridge */ /* synthetic */ com.tencent.cache.api.c getCacheListener() {
        return com.tencent.cache.core.collection.base.a.a(this);
    }

    @Override // com.tencent.cache.core.collection.base.b
    @NotNull
    public com.tencent.cache.core.collection.base.c getCollector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.cache.core.collection.base.c) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.collector;
    }

    @Override // com.tencent.cache.core.collection.base.b
    public int getCount() {
        int sumOfInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = this.viewTypeToMaxScrap;
        ArrayList arrayList = new ArrayList(concurrentHashMap.size());
        Iterator<Map.Entry<Integer, Integer>> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(getRecycledViewCount(it.next().getKey().intValue())));
        }
        sumOfInt = CollectionsKt___CollectionsKt.sumOfInt(arrayList);
        return sumOfInt;
    }

    @Override // com.tencent.cache.core.collection.base.b
    @Nullable
    public String getItemType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return Reflection.getOrCreateKotlinClass(RecyclerView.ViewHolder.class).getQualifiedName();
    }

    @Override // com.tencent.cache.api.b
    @JvmDefault
    public long getMemorySize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return getCacheInfo().f98708g;
    }

    @Override // com.tencent.cache.core.collection.base.b
    @JvmDefault
    @NotNull
    public /* bridge */ /* synthetic */ com.tencent.cache.core.manager.report.b getMonitorInfo() {
        return com.tencent.cache.core.collection.base.a.b(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    @Nullable
    public RecyclerView.ViewHolder getRecycledView(int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 4, (Object) this, viewType);
        }
        try {
            RecyclerView.ViewHolder recycledView = super.getRecycledView(viewType);
            if (recycledView != null) {
                d<RecyclerView.ViewHolder> dVar = this.collector;
                dVar.c().g();
                com.tencent.cache.core.collection.base.d dVar2 = dVar.f98718a;
                dVar2.f98704c++;
                com.tencent.cache.core.size.task.a.D.a(dVar2, false, recycledView);
                return recycledView;
            }
            return recycledView;
        } catch (IndexOutOfBoundsException e16) {
            com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
            StringBuilder a16 = c.a("getRecycledView fail, ");
            a16.append(e16.getMessage());
            bVar.j(TAG, 1, a16.toString());
            return null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void putRecycledView(@NotNull RecyclerView.ViewHolder scrap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) scrap);
            return;
        }
        Intrinsics.checkNotNullParameter(scrap, "scrap");
        int itemViewType = scrap.getItemViewType();
        if (!this.viewTypeToMaxScrap.contains(Integer.valueOf(itemViewType))) {
            this.viewTypeToMaxScrap.put(Integer.valueOf(itemViewType), 5);
        }
        if (getRecycledViewCount(itemViewType) < getMaxRecycledViews(itemViewType)) {
            d<RecyclerView.ViewHolder> dVar = this.collector;
            dVar.getClass();
            com.tencent.cache.core.size.task.a aVar = com.tencent.cache.core.size.task.a.D;
            com.tencent.cache.core.collection.base.d dVar2 = dVar.f98718a;
            Intrinsics.checkNotNull(scrap);
            aVar.a(dVar2, true, scrap);
            dVar.f98718a.g();
        }
        super.putRecycledView(scrap);
    }

    public /* synthetic */ void register(Business business, String str) {
        com.tencent.cache.api.a.a(this, business, str);
    }

    @JvmDefault
    public /* bridge */ /* synthetic */ void setCacheListener(@NotNull com.tencent.cache.api.c cVar) {
        com.tencent.cache.core.collection.base.a.c(this, cVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void setMaxRecycledViews(int viewType, int max) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(viewType), Integer.valueOf(max));
            return;
        }
        this.viewTypeToMaxScrap.put(Integer.valueOf(viewType), Integer.valueOf(max));
        int recycledViewCount = getRecycledViewCount(viewType);
        if (recycledViewCount > max) {
            int i3 = recycledViewCount - max;
            for (int i16 = 0; i16 < i3; i16++) {
                getRecycledView(viewType);
            }
        }
        super.setMaxRecycledViews(viewType, max);
    }

    @Override // com.tencent.cache.api.b
    public long trimMemory(long needRemoveSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this, needRemoveSize)).longValue();
        }
        return this.collector.b(this, Long.MAX_VALUE, true);
    }
}
