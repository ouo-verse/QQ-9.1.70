package kotlin.script.templates.standard;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u00a2\u0006\u0002\u0010\u0005R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lkotlin/script/templates/standard/ScriptTemplateWithBindings;", "", "bindings", "", "", "(Ljava/util/Map;)V", "getBindings", "()Ljava/util/Map;", "kotlin-script-runtime"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes38.dex */
public abstract class ScriptTemplateWithBindings {
    private final Map<String, Object> bindings;

    public ScriptTemplateWithBindings(Map<String, ? extends Object> bindings) {
        Intrinsics.checkNotNullParameter(bindings, "bindings");
        this.bindings = bindings;
    }

    public final Map<String, Object> getBindings() {
        return this.bindings;
    }
}
