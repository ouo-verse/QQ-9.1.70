package com.tencent.ecommerce.biz.orders.buyerorders.orderlist;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "p2", "", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class ECOrderListFragment$ptsEventTypeToHandler$2 extends FunctionReferenceImpl implements Function2<JSONObject, Map<String, ? extends String>, Unit> {
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, Map<String, ? extends String> map) {
        invoke2(jSONObject, (Map<String, String>) map);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECOrderListFragment$ptsEventTypeToHandler$2(ECOrderListFragment eCOrderListFragment) {
        super(2, eCOrderListFragment, ECOrderListFragment.class, "enterShopPage", "enterShopPage(Lorg/json/JSONObject;Ljava/util/Map;)V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject jSONObject, Map<String, String> map) {
        ((ECOrderListFragment) this.receiver).bi(jSONObject, map);
    }
}
