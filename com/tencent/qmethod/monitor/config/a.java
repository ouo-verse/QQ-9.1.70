package com.tencent.qmethod.monitor.config;

import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.qmethod.pandoraex.api.b;
import com.tencent.qmethod.pandoraex.api.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qmethod/monitor/config/a;", "", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/qmethod/pandoraex/api/v;", "c", TransferConfig.ExtendParamFloats.KEY_RULE, "d", "", "Lcom/tencent/qmethod/pandoraex/api/b;", "b", DownloadInfo.spKey_Config, "a", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f343552a = new a();

    a() {
    }

    private final v c(JSONObject jsonObject) {
        v.a aVar = new v.a();
        String scene = jsonObject.optString("scene");
        aVar.g(scene);
        aVar.i(jsonObject.optString(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY));
        aVar.b(jsonObject.optLong("cacheTime"));
        aVar.h(jsonObject.optLong("silenceTime"));
        Intrinsics.checkExpressionValueIsNotNull(scene, "scene");
        aVar.f(!"normal".contentEquals(scene) ? 1 : 0);
        JSONArray optJSONArray = jsonObject.optJSONArray("legalPage");
        if (optJSONArray != null) {
            HashSet hashSet = new HashSet();
            IntRange intRange = new IntRange(0, optJSONArray.length() - 1);
            int first = intRange.getFirst();
            int last = intRange.getLast();
            if (first <= last) {
                while (true) {
                    hashSet.add(optJSONArray.optString(first));
                    if (first == last) {
                        break;
                    }
                    first++;
                }
            }
            aVar.e(hashSet);
        }
        JSONArray optJSONArray2 = jsonObject.optJSONArray("illegalPage");
        if (optJSONArray2 != null) {
            HashSet hashSet2 = new HashSet();
            IntRange intRange2 = new IntRange(0, optJSONArray2.length() - 1);
            int first2 = intRange2.getFirst();
            int last2 = intRange2.getLast();
            if (first2 <= last2) {
                while (true) {
                    hashSet2.add(optJSONArray2.optString(first2));
                    if (first2 == last2) {
                        break;
                    }
                    first2++;
                }
            }
            aVar.d(hashSet2);
        }
        JSONObject optJSONObject = jsonObject.optJSONObject("highFreq");
        if (optJSONObject != null) {
            aVar.c(new com.tencent.qmethod.pandoraex.api.c(optJSONObject.optLong("duration"), optJSONObject.optInt("count")));
        }
        v a16 = aVar.a();
        Intrinsics.checkExpressionValueIsNotNull(a16, "Rule.Builder().apply {\n \u2026     }\n\n        }.build()");
        return a16;
    }

    private final JSONObject d(v rule) {
        JSONObject jSONObject = new JSONObject();
        String str = rule.f343990a;
        if (str != null) {
            jSONObject.put("scene", str);
        }
        String str2 = rule.f343991b;
        if (str2 != null) {
            jSONObject.put(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, str2);
        }
        com.tencent.qmethod.pandoraex.api.c cVar = rule.f343992c;
        if (cVar != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("count", cVar.f343897b);
            jSONObject2.put("duration", cVar.f343898c);
            jSONObject.put("highFreq", jSONObject2);
        }
        jSONObject.put("cacheTime", rule.f343993d);
        jSONObject.put("silenceTime", rule.f343994e);
        jSONObject.put("reportRate", rule.f343995f);
        JSONArray jSONArray = new JSONArray();
        Set<String> set = rule.f343996g;
        if (set != null) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put((String) it.next());
            }
        }
        jSONObject.put("legalPage", jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        Set<String> set2 = rule.f343997h;
        if (set2 != null) {
            Iterator<T> it5 = set2.iterator();
            while (it5.hasNext()) {
                jSONArray2.mo162put((String) it5.next());
            }
        }
        jSONObject.put("illegalPage", jSONArray2);
        return jSONObject;
    }

    @NotNull
    public final JSONObject a(@NotNull com.tencent.qmethod.pandoraex.api.b config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        JSONObject jSONObject = new JSONObject();
        String str = config.f343878a;
        if (str != null) {
            jSONObject.put("module", str);
        }
        String str2 = config.f343881d;
        if (str2 != null) {
            jSONObject.put("specialPage", str2);
        }
        String str3 = config.f343879b;
        if (str3 != null) {
            jSONObject.put("apis", str3);
        }
        JSONArray jSONArray = new JSONArray();
        Map<String, v> map = config.f343880c;
        Intrinsics.checkExpressionValueIsNotNull(map, "config.rules");
        for (Map.Entry<String, v> entry : map.entrySet()) {
            a aVar = f343552a;
            v value = entry.getValue();
            Intrinsics.checkExpressionValueIsNotNull(value, "it.value");
            jSONArray.mo162put(aVar.d(value));
        }
        jSONObject.put("rules", jSONArray);
        return jSONObject;
    }

    @NotNull
    public final List<com.tencent.qmethod.pandoraex.api.b> b(@NotNull JSONObject jsonObject) {
        IntRange intRange;
        int first;
        int last;
        Intrinsics.checkParameterIsNotNull(jsonObject, "jsonObject");
        b.a aVar = new b.a();
        aVar.f(jsonObject.optString("module"));
        JSONArray optJSONArray = jsonObject.optJSONArray("rules");
        if (optJSONArray != null && (first = (intRange = new IntRange(0, optJSONArray.length() - 1)).getFirst()) <= (last = intRange.getLast())) {
            while (true) {
                a aVar2 = f343552a;
                JSONObject optJSONObject = optJSONArray.optJSONObject(first);
                Intrinsics.checkExpressionValueIsNotNull(optJSONObject, "it.optJSONObject(i)");
                aVar.a(aVar2.c(optJSONObject));
                if (first == last) {
                    break;
                }
                first++;
            }
        }
        aVar.h(jsonObject.optString("specialPage"));
        aVar.g(1);
        aVar.e(true);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray2 = jsonObject.optJSONArray("apis");
        if (optJSONArray2 != null) {
            IntRange intRange2 = new IntRange(0, optJSONArray2.length() - 1);
            int first2 = intRange2.getFirst();
            int last2 = intRange2.getLast();
            if (first2 <= last2) {
                while (true) {
                    com.tencent.qmethod.pandoraex.api.b it = aVar.i(optJSONArray2.getString(first2)).b();
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    arrayList.add(it);
                    if (first2 == last2) {
                        break;
                    }
                    first2++;
                }
            }
            return arrayList;
        }
        com.tencent.qmethod.pandoraex.api.b b16 = aVar.i(jsonObject.optString("apis", "")).b();
        Intrinsics.checkExpressionValueIsNotNull(b16, "builder.systemApi(jsonOb\u2026ng(KEY_APIS, \"\")).build()");
        arrayList.add(b16);
        return arrayList;
    }
}
