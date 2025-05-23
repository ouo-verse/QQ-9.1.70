package com.tencent.ecommerce.biz.submitsucceed;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt__MapsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/submitsucceed/c;", "", "Lcom/tencent/ecommerce/biz/submitsucceed/SubmitSucceedFrom;", "scene", "Lorg/json/JSONObject;", "extraValues", "", "c", "b", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f104810a = new c();

    c() {
    }

    public final void a() {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_order_submit_success_ck_to_check", null, false, 4, null);
    }

    public final void b() {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_order_submit_success_ck_to_check", null, false, 4, null);
    }

    public final void c(SubmitSucceedFrom scene, JSONObject extraValues) {
        String str;
        Map map;
        int i3 = b.f104809a[scene.ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            str = "qstore_order_submit_success";
        } else if (i3 == 4) {
            str = "qstore_complete_order_rate_exp";
        } else if (i3 == 5) {
            str = "qstore_b_order_submit_success";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        String str2 = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator keys = extraValues.keys();
        while (keys.hasNext()) {
            String str3 = (String) keys.next();
            linkedHashMap.put(str3, extraValues.getString(str3));
        }
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        map = MapsKt__MapsKt.toMap(linkedHashMap);
        IECDataReport.a.a(bVar, str2, map, false, 4, null);
    }
}
