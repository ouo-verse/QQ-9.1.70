package com.tencent.ecommerce.biz.util;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/util/g;", "", "Lorg/json/JSONArray;", "jsonArray", "", "", "a", "list", "", "maxCount", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f104867a = new g();

    g() {
    }

    public final List<String> a(JSONArray jsonArray) {
        ArrayList arrayList = new ArrayList();
        if (jsonArray == null) {
            return arrayList;
        }
        int length = jsonArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(jsonArray.optString(i3, ""));
        }
        return arrayList;
    }

    public final List<String> b(List<String> list, int maxCount) {
        return list.size() <= maxCount ? list : list.subList(0, maxCount);
    }
}
