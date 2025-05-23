package com.tencent.mobileqq.matchfriend.reborn.mark.config;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR4\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0005\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/mark/config/a;", "Lcom/tencent/freesia/IConfigData;", "", "c", "", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "resBaseUrl", "", "", "", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/a;", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "(Ljava/util/Map;)V", "markConfigMap", "<init>", "()V", "f", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a implements IConfigData {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String resBaseUrl = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Map<Integer, List<com.tencent.mobileqq.matchfriend.reborn.couple.model.a>> markConfigMap = new HashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003R\u0014\u0010\r\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/mark/config/a$a;", "", "Lorg/json/JSONObject;", "", "parseKey", "", "", "", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/a;", "b", "content", "Lcom/tencent/mobileqq/matchfriend/reborn/mark/config/a;", "a", "CONFIG_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.mark.config.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map<Integer, List<com.tencent.mobileqq.matchfriend.reborn.couple.model.a>> b(JSONObject jSONObject, String str) {
            JSONArray optJSONArray;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray(str)) != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = optJSONArray.get(i3);
                    JSONObject jSONObject2 = obj instanceof JSONObject ? (JSONObject) obj : null;
                    if (jSONObject2 != null) {
                        Integer valueOf = Integer.valueOf(jSONObject2.optInt("markId"));
                        ArrayList arrayList = new ArrayList();
                        JSONArray optJSONArray2 = jSONObject2.optJSONArray("levelArray");
                        if (optJSONArray2 != null) {
                            Intrinsics.checkNotNullExpressionValue(optJSONArray2, "optJSONArray(\"levelArray\")");
                            int length2 = optJSONArray2.length();
                            for (int i16 = 0; i16 < length2; i16++) {
                                Object obj2 = optJSONArray2.get(i16);
                                JSONObject jSONObject3 = obj2 instanceof JSONObject ? (JSONObject) obj2 : null;
                                if (jSONObject3 != null) {
                                    int optInt = jSONObject3.optInt("targetCount");
                                    String optString = jSONObject3.optString("name");
                                    Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"name\")");
                                    String optString2 = jSONObject3.optString("targetDesc");
                                    Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(\"targetDesc\")");
                                    arrayList.add(new com.tencent.mobileqq.matchfriend.reborn.couple.model.a(optInt, optString, optString2));
                                }
                            }
                        }
                        linkedHashMap.put(valueOf, arrayList);
                    }
                }
            }
            return linkedHashMap;
        }

        public final a a(String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(content);
                String optString = jSONObject.optString("resBaseUrl");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"resBaseUrl\")");
                aVar.e(optString);
                aVar.d(b(jSONObject, "markConfigArray"));
            } catch (Exception e16) {
                QLog.e("QQStrangerMarkConfigBean", 1, "parse error.", e16);
            }
            return aVar;
        }

        Companion() {
        }
    }

    public final Map<Integer, List<com.tencent.mobileqq.matchfriend.reborn.couple.model.a>> a() {
        return this.markConfigMap;
    }

    /* renamed from: b, reason: from getter */
    public final String getResBaseUrl() {
        return this.resBaseUrl;
    }

    public final boolean c() {
        return (this.resBaseUrl.length() > 0) && (this.markConfigMap.isEmpty() ^ true);
    }

    public final void d(Map<Integer, List<com.tencent.mobileqq.matchfriend.reborn.couple.model.a>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.markConfigMap = map;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resBaseUrl = str;
    }
}
