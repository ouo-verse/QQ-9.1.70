package com.tencent.sqshow.zootopia.nativeui.data.cart;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tencent.sqshow.zootopia.nativeui.data.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014JF\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0005J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/cart/c;", "", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/cart/a;", "goodsDataList", "", "itemIds", "zplanFaceId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "", "d", "", "gender", "b", "Lcom/tencent/sqshow/zootopia/nativeui/data/l;", "pool", "c", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f370946a = new c();

    c() {
    }

    private final HashMap<String, String> a(List<CartGoodsData> goodsDataList, String itemIds, String zplanFaceId) {
        HashMap<String, String> hashMapOf;
        JsonArray jsonArray = new JsonArray();
        if (goodsDataList != null) {
            Iterator<T> it = goodsDataList.iterator();
            while (it.hasNext()) {
                JsonObject J = r94.b.J(((CartGoodsData) it.next()).getItemData());
                J.addProperty("zplan_face_id", zplanFaceId);
                jsonArray.add(J);
            }
        }
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("zplan_item_id", itemIds);
        if (zplanFaceId == null) {
            zplanFaceId = "";
        }
        pairArr[1] = TuplesKt.to("zplan_face_id", zplanFaceId);
        pairArr[2] = TuplesKt.to("zplan_ext_info", jsonArray.toString());
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        return hashMapOf;
    }

    public final Map<String, Object> b(int gender, String zplanFaceId) {
        ArrayList arrayList;
        int collectionSizeOrDefault;
        List<CartGoodsData> value = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.h().getValue();
        if (value != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : value) {
                if (b.c(((CartGoodsData) obj).getItemData(), gender)) {
                    arrayList2.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(r94.b.K(((CartGoodsData) it.next()).getItemData()));
            }
        } else {
            arrayList = null;
        }
        return a(value, String.valueOf(arrayList), zplanFaceId);
    }

    public final Map<String, Object> c(l pool) {
        int collectionSizeOrDefault;
        HashMap hashMapOf;
        HashSet<az> t16 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.t(pool);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(t16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = t16.iterator();
        while (it.hasNext()) {
            arrayList.add(r94.b.K((az) it.next()));
        }
        JsonArray jsonArray = new JsonArray();
        Iterator<T> it5 = t16.iterator();
        while (it5.hasNext()) {
            jsonArray.add(r94.b.J((az) it5.next()));
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("zplan_item_id", arrayList.toString()), TuplesKt.to("zplan_ext_info", jsonArray.toString()));
        return hashMapOf;
    }

    public final Map<String, Object> d(String zplanFaceId) {
        ArrayList arrayList;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(zplanFaceId, "zplanFaceId");
        List<CartGoodsData> value = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.h().getValue();
        if (value != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : value) {
                if (((CartGoodsData) obj).getIsSelected()) {
                    arrayList2.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(r94.b.K(((CartGoodsData) it.next()).getItemData()));
            }
        } else {
            arrayList = null;
        }
        return a(value, String.valueOf(arrayList), zplanFaceId);
    }
}
