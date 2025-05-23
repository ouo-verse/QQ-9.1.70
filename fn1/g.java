package fn1;

import en1.a;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R0\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lfn1/g;", "Len1/a;", "Lorg/json/JSONObject;", "jsonObject", "Len1/a$a;", "result", "", "a", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mProcessorMap", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g implements en1.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, en1.a> mProcessorMap;

    public g() {
        HashMap<Integer, en1.a> hashMap = new HashMap<>();
        hashMap.put(1, new h());
        hashMap.put(4, new f());
        hashMap.put(2, new a());
        hashMap.put(5, new e());
        hashMap.put(3, new j());
        hashMap.put(8, new i());
        hashMap.put(9, new d());
        this.mProcessorMap = hashMap;
    }

    @Override // en1.a
    public void a(@NotNull JSONObject jsonObject, @NotNull a.C10251a result) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(result, "result");
        JSONArray jSONArray = jsonObject.getJSONObject("contents").getJSONArray("contents");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject contentJson = jSONArray.getJSONObject(i3);
            en1.a aVar = this.mProcessorMap.get(Integer.valueOf(contentJson.getInt("type")));
            if (aVar != null) {
                Intrinsics.checkNotNullExpressionValue(contentJson, "contentJson");
                aVar.a(contentJson, result);
            }
        }
    }
}
