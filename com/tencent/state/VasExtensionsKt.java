package com.tencent.state;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0006\u001a\u00020\u00072.\u0010\b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n0\t\"\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n\u00a2\u0006\u0002\u0010\r\u001a0\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00032\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0012\u001a*\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0001\"\u0004\b\u0000\u0010\u0010*\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u0002H\u00100\u0016\u001a,\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0001\"\u0004\b\u0000\u0010\u0010*\u00020\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0016\"\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0019"}, d2 = {"keys", "", "", "Landroid/util/SparseArray;", "getKeys", "(Landroid/util/SparseArray;)Ljava/util/List;", "bundleOf", "Landroid/os/Bundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/Bundle;", "forEach", "", "T", "block", "Lkotlin/Function2;", "map", "Lorg/json/JSONArray;", "transform", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "mapNotNull", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class VasExtensionsKt {
    public static final Bundle bundleOf(Pair<String, ? extends Object>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        Bundle bundle = new Bundle();
        for (Pair<String, ? extends Object> pair : pairs) {
            String first = pair.getFirst();
            Object second = pair.getSecond();
            if (second instanceof String) {
                bundle.putString(first, (String) second);
            } else if (second instanceof Boolean) {
                bundle.putBoolean(first, ((Boolean) second).booleanValue());
            } else if (second instanceof Integer) {
                bundle.putInt(first, ((Number) second).intValue());
            } else if (second instanceof Long) {
                bundle.putLong(first, ((Number) second).longValue());
            } else if (second instanceof Float) {
                bundle.putFloat(first, ((Number) second).floatValue());
            } else if (second instanceof Double) {
                bundle.putDouble(first, ((Number) second).doubleValue());
            } else if (second instanceof Parcelable) {
                bundle.putParcelable(first, (Parcelable) second);
            } else if (second instanceof Serializable) {
                bundle.putSerializable(first, (Serializable) second);
            }
        }
        return bundle;
    }

    public static final <T> void forEach(SparseArray<T> forEach, Function2<? super Integer, ? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(forEach, "$this$forEach");
        Intrinsics.checkNotNullParameter(block, "block");
        int size = forEach.size();
        for (int i3 = 0; i3 < size; i3++) {
            block.invoke(Integer.valueOf(forEach.keyAt(i3)), forEach.valueAt(i3));
        }
    }

    public static final List<Integer> getKeys(SparseArray<?> keys) {
        IntRange until;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(keys, "$this$keys");
        until = RangesKt___RangesKt.until(0, keys.size());
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(keys.keyAt(((IntIterator) it).nextInt())));
        }
        return arrayList;
    }

    public static final <T> List<T> map(JSONArray map, Function1<? super JSONObject, ? extends T> transform) {
        Intrinsics.checkNotNullParameter(map, "$this$map");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = map.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = map.optJSONObject(i3);
            Intrinsics.checkNotNullExpressionValue(optJSONObject, "this.optJSONObject(i)");
            arrayList.add(transform.invoke(optJSONObject));
        }
        return arrayList;
    }

    public static final <T> List<T> mapNotNull(JSONArray mapNotNull, Function1<? super JSONObject, ? extends T> transform) {
        Intrinsics.checkNotNullParameter(mapNotNull, "$this$mapNotNull");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = mapNotNull.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = mapNotNull.optJSONObject(i3);
            Intrinsics.checkNotNullExpressionValue(optJSONObject, "this.optJSONObject(i)");
            T invoke = transform.invoke(optJSONObject);
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }
}
