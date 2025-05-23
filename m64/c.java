package m64;

import com.tencent.util.LRULinkedHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u000bB\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\u001aB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b!\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0006\u0010\f\u001a\u00020\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\rJ\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001dR \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001d\u00a8\u0006%"}, d2 = {"Lm64/c;", "", "", "jsonString", "", "g", "Lorg/json/JSONArray;", "jsonArray", h.F, "f", "b", "a", "j", "", "e", "Lm64/a;", "d", "robotId", "functionName", "", "functionType", "k", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "mChatUid", "Lcom/tencent/util/LRULinkedHashMap;", "Lcom/tencent/util/LRULinkedHashMap;", "mRecentUseRobotIdList", "mRecentUseFunctionList", "chatUid", "<init>", "", "isRecover", "(Ljava/lang/String;Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public String mChatUid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LRULinkedHashMap<String, String> mRecentUseRobotIdList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LRULinkedHashMap<String, a> mRecentUseFunctionList;

    public c(@NotNull String chatUid) {
        Intrinsics.checkNotNullParameter(chatUid, "chatUid");
        this.mRecentUseRobotIdList = new LRULinkedHashMap<>(3);
        this.mRecentUseFunctionList = new LRULinkedHashMap<>(3);
        i(chatUid);
    }

    private final JSONArray a() {
        JSONArray jSONArray = new JSONArray();
        Iterator<Map.Entry<String, a>> it = this.mRecentUseFunctionList.entrySet().iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next().getValue().i());
        }
        return jSONArray;
    }

    private final JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        Iterator<Map.Entry<String, String>> it = this.mRecentUseRobotIdList.entrySet().iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next().getValue());
        }
        return jSONArray;
    }

    private final void f(JSONArray jsonArray) {
        this.mRecentUseFunctionList.clear();
        int length = jsonArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            String optString = jsonArray.optString(i3);
            Intrinsics.checkNotNullExpressionValue(optString, "jsonArray.optString(index)");
            a aVar = new a(optString);
            this.mRecentUseFunctionList.put(aVar.a(), aVar);
        }
    }

    private final void g(String jsonString) {
        JSONObject jSONObject = new JSONObject(jsonString);
        String optString = jSONObject.optString("CHAT_UID");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(CHAT_UID)");
        i(optString);
        JSONArray optJSONArray = jSONObject.optJSONArray("ROBOT_ID_LIST");
        Intrinsics.checkNotNullExpressionValue(optJSONArray, "jsonObject.optJSONArray(ROBOT_ID_LIST)");
        h(optJSONArray);
        JSONArray optJSONArray2 = jSONObject.optJSONArray("FUNCTION_LIST");
        Intrinsics.checkNotNullExpressionValue(optJSONArray2, "jsonObject.optJSONArray(FUNCTION_LIST)");
        f(optJSONArray2);
    }

    private final void h(JSONArray jsonArray) {
        this.mRecentUseRobotIdList.clear();
        int length = jsonArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            String optString = jsonArray.optString(i3, "");
            this.mRecentUseRobotIdList.put(optString, optString);
        }
    }

    @NotNull
    public final String c() {
        String str = this.mChatUid;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mChatUid");
        return null;
    }

    @NotNull
    public final List<a> d() {
        LRULinkedHashMap<String, a> lRULinkedHashMap = this.mRecentUseFunctionList;
        ArrayList arrayList = new ArrayList(lRULinkedHashMap.size());
        Iterator<Map.Entry<String, a>> it = lRULinkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    @NotNull
    public final List<String> e() {
        LRULinkedHashMap<String, String> lRULinkedHashMap = this.mRecentUseRobotIdList;
        ArrayList arrayList = new ArrayList(lRULinkedHashMap.size());
        Iterator<Map.Entry<String, String>> it = lRULinkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        return arrayList;
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mChatUid = str;
    }

    @NotNull
    public final String j() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("CHAT_UID", c());
        jSONObject.put("ROBOT_ID_LIST", b());
        jSONObject.put("FUNCTION_LIST", a());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ay())\n       }.toString()");
        return jSONObject2;
    }

    public final void k(@NotNull String robotId, @NotNull String functionName, int functionType) {
        Intrinsics.checkNotNullParameter(robotId, "robotId");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        this.mRecentUseRobotIdList.put(robotId, robotId);
        a aVar = new a(robotId, functionName, functionType);
        this.mRecentUseFunctionList.put(aVar.a(), aVar);
    }

    public c(@NotNull String jsonString, boolean z16) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        this.mRecentUseRobotIdList = new LRULinkedHashMap<>(3);
        this.mRecentUseFunctionList = new LRULinkedHashMap<>(3);
        g(jsonString);
    }
}
