package kotlin.script.templates;

import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message = "temporary workaround for missing functionality, will be replaced by the new API soon")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nj\u0004\u0018\u0001`\u000bH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lkotlin/script/templates/ScriptTemplateAdditionalCompilerArgumentsProvider;", "", "arguments", "", "", "(Ljava/lang/Iterable;)V", "getArguments", "()Ljava/lang/Iterable;", "getAdditionalCompilerArguments", "environment", "", "Lkotlin/script/dependencies/Environment;", "kotlin-script-runtime"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes38.dex */
public class ScriptTemplateAdditionalCompilerArgumentsProvider {
    private final Iterable<String> arguments;

    public ScriptTemplateAdditionalCompilerArgumentsProvider() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public Iterable<String> getAdditionalCompilerArguments(Map<String, ? extends Object> environment) {
        return this.arguments;
    }

    public final Iterable<String> getArguments() {
        return this.arguments;
    }

    public ScriptTemplateAdditionalCompilerArgumentsProvider(Iterable<String> arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.arguments = arguments;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ScriptTemplateAdditionalCompilerArgumentsProvider(Iterable iterable, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(iterable);
        List emptyList;
        if ((i3 & 1) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            iterable = emptyList;
        }
    }
}
