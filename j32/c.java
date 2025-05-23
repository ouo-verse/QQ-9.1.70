package j32;

import com.tencent.ark.ark;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.icgame.framework.pagefacotry.ComponentNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\"\u001a\u0010\r\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u000e"}, d2 = {"", "key", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;", "componentNode", "", "c", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "b", "", "a", "Z", "()Z", "IS_LOG", "ic-game-base-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f409199a = false;

    public static final boolean a() {
        return f409199a;
    }

    private static final void b(JSONObject jSONObject, ComponentNode componentNode) {
        jSONObject.put("self", componentNode.getComponentKey());
        JSONArray jSONArray = new JSONArray();
        for (ComponentNode it : componentNode.e()) {
            JSONObject jSONObject2 = new JSONObject();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            b(jSONObject2, it);
            jSONArray.mo162put(jSONObject2);
        }
        jSONObject.put("child", jSONArray);
    }

    public static final void c(@NotNull String key, @NotNull ComponentNode componentNode) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(componentNode, "componentNode");
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, componentNode);
        b.f409197a.i("ICGamePageSdk_TAG", key + MsgSummary.STR_COLON + jSONObject);
    }
}
