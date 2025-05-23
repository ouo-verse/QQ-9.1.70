package com.tencent.rdelivery.reshub.loader;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.reshub.api.b;
import com.tencent.rdelivery.reshub.api.g;
import com.tencent.rdelivery.reshub.api.n;
import com.tencent.rdelivery.reshub.core.ResLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jz3.d;
import jz3.e;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lz3.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B+\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0006R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/rdelivery/reshub/loader/a;", "", "", "errCode", "", "msg", "", "d", "c", "Lcom/tencent/rdelivery/RDelivery;", "a", "Lcom/tencent/rdelivery/RDelivery;", "rDelivery", "", "b", "J", WadlProxyConsts.SCENE_ID, "Lcom/tencent/rdelivery/reshub/api/b;", "Lcom/tencent/rdelivery/reshub/api/b;", "batchCallback", "Lcom/tencent/rdelivery/reshub/core/ResLoader;", "Lcom/tencent/rdelivery/reshub/core/ResLoader;", "loader", "<init>", "(Lcom/tencent/rdelivery/RDelivery;JLcom/tencent/rdelivery/reshub/api/b;Lcom/tencent/rdelivery/reshub/core/ResLoader;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final RDelivery rDelivery;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long sceneId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final b batchCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ResLoader loader;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/rdelivery/reshub/loader/a$a", "Liz3/b;", "", "reason", "", "onFail", "", "Lcom/tencent/rdelivery/data/RDeliveryData;", "datas", "onSuccess", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rdelivery.reshub.loader.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C9730a implements iz3.b {
        C9730a() {
        }

        @Override // iz3.m
        public /* synthetic */ void a(List list, List list2, List list3) {
            iz3.a.a(this, list, list2, list3);
        }

        @Override // iz3.m
        public void onFail(@NotNull String reason) {
            Intrinsics.checkParameterIsNotNull(reason, "reason");
            d.c("SceneResLoader", "fetchConfig onFail, " + reason);
            a.this.d(1003, "Scene Res Fetch Error: " + reason);
        }

        @Override // iz3.b
        public void onSuccess(@Nullable List<RDeliveryData> datas) {
            Collection<e> emptyList;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (datas == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                emptyList = new ArrayList();
                Iterator<T> it = datas.iterator();
                while (it.hasNext()) {
                    e b16 = h.b((RDeliveryData) it.next());
                    if (b16 != null) {
                        emptyList.add(b16);
                    }
                }
            }
            for (e eVar : emptyList) {
                String str = eVar.f411260a;
                Intrinsics.checkExpressionValueIsNotNull(str, "res.id");
                linkedHashMap.put(str, eVar);
            }
            d.e("SceneResLoader", "fetchConfig onSuccess, resMap.size = " + linkedHashMap.size());
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            b bVar = a.this.batchCallback;
            if (bVar != null) {
                bVar.a(true, linkedHashMap, linkedHashMap2);
            }
        }
    }

    public a(@Nullable RDelivery rDelivery, long j3, @Nullable b bVar, @NotNull ResLoader loader) {
        Intrinsics.checkParameterIsNotNull(loader, "loader");
        this.rDelivery = rDelivery;
        this.sceneId = j3;
        this.batchCallback = bVar;
        this.loader = loader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(int errCode, String msg2) {
        Map<String, ? extends n> mapOf;
        Map<String, ? extends g> emptyMap;
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        aVar.e(errCode);
        aVar.g(msg2);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("[SceneLoadErr]", com.tencent.rdelivery.reshub.report.b.b(aVar)));
        b bVar = this.batchCallback;
        if (bVar != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            bVar.a(false, emptyMap, mapOf);
        }
    }

    public final void c() {
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery == null) {
            d(10004, "RDelivery Init Error.");
        } else {
            rDelivery.F(this.sceneId, new C9730a());
        }
    }
}
