package kotlin.script.experimental.dependencies;

import java.util.Map;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.script.dependencies.KotlinScriptExternalDependencies;
import kotlin.script.dependencies.ScriptContents;
import kotlin.script.dependencies.ScriptDependenciesResolver;
import kotlin.script.experimental.dependencies.DependenciesResolver;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\nH\u0016J3\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\nH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lkotlin/script/experimental/dependencies/AsyncDependenciesResolver;", "Lkotlin/script/experimental/dependencies/DependenciesResolver;", "resolve", "Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult;", "scriptContents", "Lkotlin/script/dependencies/ScriptContents;", "environment", "", "", "", "Lkotlin/script/dependencies/Environment;", "resolveAsync", "(Lkotlin/script/dependencies/ScriptContents;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-script-runtime"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes38.dex */
public interface AsyncDependenciesResolver extends DependenciesResolver {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static Future<KotlinScriptExternalDependencies> resolve(AsyncDependenciesResolver asyncDependenciesResolver, ScriptContents script, Map<String, ? extends Object> map, Function3<? super ScriptDependenciesResolver.ReportSeverity, ? super String, ? super ScriptContents.Position, Unit> report, KotlinScriptExternalDependencies kotlinScriptExternalDependencies) {
            Intrinsics.checkNotNullParameter(script, "script");
            Intrinsics.checkNotNullParameter(report, "report");
            return DependenciesResolver.DefaultImpls.resolve(asyncDependenciesResolver, script, map, report, kotlinScriptExternalDependencies);
        }

        public static DependenciesResolver.ResolveResult resolve(AsyncDependenciesResolver asyncDependenciesResolver, ScriptContents scriptContents, Map<String, ? extends Object> environment) {
            Intrinsics.checkNotNullParameter(scriptContents, "scriptContents");
            Intrinsics.checkNotNullParameter(environment, "environment");
            throw new NotImplementedError(null, 1, null);
        }
    }

    @Override // kotlin.script.experimental.dependencies.DependenciesResolver
    DependenciesResolver.ResolveResult resolve(ScriptContents scriptContents, Map<String, ? extends Object> environment);

    Object resolveAsync(ScriptContents scriptContents, Map<String, ? extends Object> map, Continuation<? super DependenciesResolver.ResolveResult> continuation);
}
