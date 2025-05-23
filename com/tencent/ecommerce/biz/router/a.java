package com.tencent.ecommerce.biz.router;

import com.tencent.ecommerce.base.provider.IECFilterProvider;
import com.tencent.ecommerce.base.router.api.IECRouterFilter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import wi0.b;
import wi0.c;
import wi0.d;
import wi0.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/router/a;", "Lcom/tencent/ecommerce/base/provider/IECFilterProvider;", "", "Lcom/tencent/ecommerce/base/router/api/IECRouterFilter;", "a", "", "Ljava/util/List;", "routerFilterList", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a implements IECFilterProvider<List<? extends IECRouterFilter>> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<IECRouterFilter> routerFilterList;

    public a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c());
        arrayList.add(new b());
        arrayList.add(new d());
        arrayList.add(new e());
        Unit unit = Unit.INSTANCE;
        this.routerFilterList = arrayList;
    }

    @Override // com.tencent.ecommerce.base.provider.IECFilterProvider
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<IECRouterFilter> get() {
        return this.routerFilterList;
    }
}
