package com.tencent.ecommerce.biz.util;

import android.text.TextUtils;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004J\u0014\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/util/o;", "", "", "searchQuery", "", VideoTemplateParser.ITEM_LIST, "", "c", "searchHistoryItemList", "b", "jsonString", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f104877a = new o();

    o() {
    }

    public final List<String> a(String jsonString) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(jsonString);
            int length = jSONObject.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = jSONObject.optString(String.valueOf(i3), "");
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
        } catch (JSONException e16) {
            cg0.a.a("ECSearchUtil", "[decodeJsonToSearchItemList]", e16.toString());
        }
        return arrayList;
    }

    public final String b(List<String> searchHistoryItemList) {
        JSONObject jSONObject = new JSONObject();
        Iterator<T> it = searchHistoryItemList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            try {
                jSONObject.put(String.valueOf(i3), (String) it.next());
            } catch (JSONException e16) {
                cg0.a.a("ECSearchUtil", "[encodeSearchItemListToJson]", e16.toString());
            }
            i3++;
        }
        return jSONObject.toString();
    }

    public final int c(String searchQuery, List<String> itemList) {
        int size = itemList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (TextUtils.equals(searchQuery, itemList.get(i3))) {
                return i3;
            }
        }
        return -1;
    }
}
