package lh0;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Llh0/b;", "Llh0/a;", "", "a", "I", "()I", "action", "Lorg/json/JSONObject;", "b", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "params", "<init>", "(ILorg/json/JSONObject;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class b extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int action;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JSONObject params;

    public b(int i3, @NotNull JSONObject jSONObject) {
        this.action = i3;
        this.params = jSONObject;
    }

    /* renamed from: a, reason: from getter */
    public final int getAction() {
        return this.action;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final JSONObject getParams() {
        return this.params;
    }
}
