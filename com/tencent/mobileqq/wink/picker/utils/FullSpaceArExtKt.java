package com.tencent.mobileqq.wink.picker.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a.\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00010\u0000H\u0000\u001a\"\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0000\u001a,\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001*\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0000\u00a8\u0006\f"}, d2 = {"", "", "", "", "Lkotlin/Pair;", "Lorg/json/JSONArray;", "b", "Lcom/tencent/mobileqq/wink/edit/bean/a;", "jsonPath", "a", "originalScriptParams", "c", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class FullSpaceArExtKt {
    @Nullable
    public static final Map<String, Object> a(@NotNull com.tencent.mobileqq.wink.edit.bean.a aVar, @NotNull String jsonPath) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(jsonPath, "jsonPath");
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(aVar.processedExtra);
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = jSONObject.getJSONArray("mediaInfosDescription");
            ArrayList<String> b16 = aVar.b();
            int min = Math.min(jSONArray.length(), b16.size());
            for (int i3 = 0; i3 < min; i3++) {
                Object obj = jSONArray.get(i3);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                jSONObject2.put((String) obj, b16.get(i3));
            }
            hashMap.put("fullSpaceARMask", jSONObject2);
            File file = new File(jsonPath);
            if (file.exists()) {
                file.delete();
            } else {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
            }
            String string = jSONObject.getString("json_info");
            Intrinsics.checkNotNullExpressionValue(string, "extraJson.getString(KEY_JSON_INFO)");
            FilesKt__FileReadWriteKt.writeText$default(file, string, null, 2, null);
            hashMap.put("pointsJson", file.getAbsolutePath());
            hashMap.put("pagIndex", Integer.valueOf(aVar.originalMediaIndex));
            w53.b.f("TemplateLibMediaProcessedBean", "generateFullSpaceARJson: " + hashMap);
            return hashMap;
        } catch (Exception e16) {
            w53.b.d("TemplateLibMediaProcessedBean", "generateFullSpaceARJson fail", e16);
            return null;
        }
    }

    @Nullable
    public static final Pair<String, JSONArray> b(@NotNull List<? extends Map<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            if (map != null) {
                jSONArray.mo162put(new JSONObject(map));
            }
        }
        return TuplesKt.to("fullSpaceARData", jSONArray);
    }

    @Nullable
    public static final Map<String, Object> c(@NotNull com.tencent.mobileqq.wink.edit.bean.a aVar, @Nullable String str, @NotNull String jsonPath) {
        boolean z16;
        Sequence asSequence;
        Sequence map;
        Map<String, Object> map2;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(jsonPath, "jsonPath");
        Map<String, Object> a16 = a(aVar, jsonPath);
        int i3 = 0;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16 && a16 != null) {
                    try {
                        final JSONObject jSONObject = new JSONObject(str);
                        JSONArray jSONArray = jSONObject.getJSONArray("fullSpaceARData");
                        int length = jSONArray.length();
                        while (true) {
                            if (i3 >= length) {
                                break;
                            }
                            Object obj = jSONArray.get(i3);
                            if ((obj instanceof JSONObject) && Intrinsics.areEqual(((JSONObject) obj).get("pagIndex"), Integer.valueOf(aVar.originalMediaIndex))) {
                                jSONArray.remove(i3);
                                break;
                            }
                            i3++;
                        }
                        jSONArray.mo162put(new JSONObject(a16));
                        Iterator keys = jSONObject.keys();
                        Intrinsics.checkNotNullExpressionValue(keys, "originalJson.keys()");
                        asSequence = SequencesKt__SequencesKt.asSequence(keys);
                        map = SequencesKt___SequencesKt.map(asSequence, new Function1<String, Pair<? extends String, ? extends Object>>() { // from class: com.tencent.mobileqq.wink.picker.utils.FullSpaceArExtKt$mergeFullSpaceArJson$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final Pair<String, Object> invoke(String str2) {
                                return TuplesKt.to(str2, JSONObject.this.get(str2));
                            }
                        });
                        map2 = MapsKt__MapsKt.toMap(map);
                        return map2;
                    } catch (Throwable th5) {
                        w53.b.d("TemplateLibMediaProcessedBean", "mergeFullSpaceArJson fail", th5);
                        return null;
                    }
                }
                return a16;
            }
        }
        z16 = true;
        if (z16) {
        }
        return a16;
    }
}
