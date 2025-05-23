package com.tencent.ecommerce.base.list;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B9\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0018\u001a\u0004\u0018\u00018\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\n\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/base/list/h;", "BEAN", "EXTRA", "", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "dataList", "Lcom/tencent/ecommerce/base/list/a;", "b", "Lcom/tencent/ecommerce/base/list/a;", "dataCacheLevel", "", "c", "Z", "hasMore", "Lcom/tencent/ecommerce/base/list/c;", "d", "Lcom/tencent/ecommerce/base/list/c;", "listUiState", "e", "Ljava/lang/Object;", "()Ljava/lang/Object;", "extra", "<init>", "(Ljava/util/List;Lcom/tencent/ecommerce/base/list/a;ZLcom/tencent/ecommerce/base/list/c;Ljava/lang/Object;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class h<BEAN, EXTRA> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<BEAN> dataList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final a dataCacheLevel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final boolean hasMore;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final c listUiState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final EXTRA extra;

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends BEAN> list, a aVar, boolean z16, c cVar, EXTRA extra) {
        this.dataList = list;
        this.dataCacheLevel = aVar;
        this.hasMore = z16;
        this.listUiState = cVar;
        this.extra = extra;
    }

    public final List<BEAN> a() {
        return this.dataList;
    }

    public final EXTRA b() {
        return this.extra;
    }

    public /* synthetic */ h(List list, a aVar, boolean z16, c cVar, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, aVar, z16, cVar, (i3 & 16) != 0 ? null : obj);
    }
}
