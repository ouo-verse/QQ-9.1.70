package com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text;

import android.text.TextUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/text/g;", "Lpm1/b;", "Lorg/json/JSONObject;", "jsonObject", "Lom1/b;", "restoreResult", "Lom1/a;", "restoreInfo", "", "a", "Ljava/util/HashMap;", "", "Lpm1/a;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mProcessorMap", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g implements pm1.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, pm1.a> mProcessorMap;

    public g() {
        HashMap<Integer, pm1.a> hashMap = new HashMap<>();
        hashMap.put(1, new h());
        hashMap.put(2, new b());
        hashMap.put(3, new a());
        hashMap.put(4, new d());
        hashMap.put(9, new e());
        hashMap.put(11, new f());
        hashMap.put(12, new UrlTextProcessor());
        hashMap.put(13, new TopicProcessor());
        hashMap.put(14, new c());
        this.mProcessorMap = hashMap;
    }

    @Override // pm1.b
    public void a(@NotNull JSONObject jsonObject, @NotNull om1.b restoreResult, @Nullable RestoreInfo restoreInfo) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
        if (restoreInfo == null) {
            return;
        }
        JSONArray jSONArray = jsonObject.getJSONObject("contents").getJSONArray("contents");
        String string = jsonObject.getString("patternInfo");
        if (jSONArray.length() != 0 && !TextUtils.isEmpty(string)) {
            JSONArray jSONArray2 = new JSONArray(string);
            int i3 = 0;
            jSONArray2.remove(0);
            int length = jSONArray2.length();
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (i16 < length) {
                JSONArray jSONArray3 = jSONArray2.getJSONObject(i17).getJSONArray("data");
                int length2 = jSONArray3.length();
                int i19 = i3;
                while (i19 < length2) {
                    if (i18 >= jSONArray.length()) {
                        return;
                    }
                    JSONObject contentJson = jSONArray.getJSONObject(i18);
                    JSONObject patternJson = jSONArray3.getJSONObject(i19);
                    int i26 = patternJson.getInt("type");
                    JSONArray jSONArray4 = jSONArray;
                    pm1.a aVar = this.mProcessorMap.get(Integer.valueOf(i26));
                    if (aVar != null) {
                        Intrinsics.checkNotNullExpressionValue(contentJson, "contentJson");
                        Intrinsics.checkNotNullExpressionValue(patternJson, "patternJson");
                        aVar.a(contentJson, patternJson, restoreResult, restoreInfo);
                    }
                    if (i26 != 11) {
                        i18++;
                    }
                    i19++;
                    jSONArray = jSONArray4;
                }
                i17++;
                i16++;
                i3 = 0;
            }
        }
    }
}
