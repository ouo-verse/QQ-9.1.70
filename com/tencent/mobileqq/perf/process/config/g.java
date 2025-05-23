package com.tencent.mobileqq.perf.process.config;

import android.os.Build;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003j\b\u0012\u0004\u0012\u00020\u0001`\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0000\u001a*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\tj\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001`\n2\u0006\u0010\b\u001a\u00020\u0000\u00a8\u0006\f"}, d2 = {"Lorg/json/JSONObject;", "", "key", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "configObj", "b", "jsonObj", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "QQPerf-kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class g {
    @NotNull
    public static final ArrayList<String> a(@NotNull JSONObject jSONObject, @NotNull String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!jSONObject.has(key)) {
            return new ArrayList<>();
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(key);
            int length = jSONArray.length();
            ArrayList<String> arrayList = new ArrayList<>(length);
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(jSONArray.getString(i3));
            }
            return arrayList;
        } catch (Exception e16) {
            QLog.e("JSONObject", 1, e16, new Object[0]);
            return new ArrayList<>();
        }
    }

    @Nullable
    public static final JSONObject b(@NotNull JSONObject configObj) {
        Intrinsics.checkNotNullParameter(configObj, "configObj");
        if (configObj.has("vendorStrategies")) {
            JSONObject jSONObject = configObj.getJSONObject("vendorStrategies");
            String BRAND = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String lowerCase = BRAND.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (jSONObject.has(lowerCase)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(lowerCase);
                String MODEL = DeviceInfoMonitor.getModel();
                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                String lowerCase2 = MODEL.toLowerCase(ENGLISH);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                if (jSONObject2.has(lowerCase2)) {
                    return jSONObject2.getJSONObject(lowerCase2);
                }
                if (jSONObject2.has("default")) {
                    return jSONObject2.getJSONObject("default");
                }
            } else if (jSONObject.has("default")) {
                return jSONObject.getJSONObject("default");
            }
        }
        return null;
    }

    @NotNull
    public static final HashMap<String, String> c(@NotNull JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator keys = jsonObj.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "jsonObj.keys()");
        while (keys.hasNext()) {
            Object next = keys.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
            String str = (String) next;
            Object obj = jsonObj.get(str);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            hashMap.put(str, (String) obj);
        }
        return hashMap;
    }
}
