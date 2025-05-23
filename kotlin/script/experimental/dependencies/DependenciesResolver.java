package kotlin.script.experimental.dependencies;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.script.dependencies.KotlinScriptExternalDependencies;
import kotlin.script.dependencies.ScriptContents;
import kotlin.script.dependencies.ScriptDependenciesResolver;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u000b\fJ*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\nH&\u00a8\u0006\r"}, d2 = {"Lkotlin/script/experimental/dependencies/DependenciesResolver;", "Lkotlin/script/dependencies/ScriptDependenciesResolver;", "resolve", "Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult;", "scriptContents", "Lkotlin/script/dependencies/ScriptContents;", "environment", "", "", "", "Lkotlin/script/dependencies/Environment;", "NoDependencies", "ResolveResult", "kotlin-script-runtime"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes38.dex */
public interface DependenciesResolver extends ScriptDependenciesResolver {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static Future<KotlinScriptExternalDependencies> resolve(DependenciesResolver dependenciesResolver, ScriptContents script, Map<String, ? extends Object> map, Function3<? super ScriptDependenciesResolver.ReportSeverity, ? super String, ? super ScriptContents.Position, Unit> report, KotlinScriptExternalDependencies kotlinScriptExternalDependencies) {
            Intrinsics.checkNotNullParameter(script, "script");
            Intrinsics.checkNotNullParameter(report, "report");
            return ScriptDependenciesResolver.DefaultImpls.resolve(dependenciesResolver, script, map, report, kotlinScriptExternalDependencies);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bj\u0002`\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lkotlin/script/experimental/dependencies/DependenciesResolver$NoDependencies;", "Lkotlin/script/experimental/dependencies/DependenciesResolver;", "()V", "resolve", "Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult$Success;", "scriptContents", "Lkotlin/script/dependencies/ScriptContents;", "environment", "", "", "", "Lkotlin/script/dependencies/Environment;", "kotlin-script-runtime"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes38.dex */
    public static final class NoDependencies implements DependenciesResolver {
        public static final NoDependencies INSTANCE = new NoDependencies();

        NoDependencies() {
        }

        @Override // kotlin.script.dependencies.ScriptDependenciesResolver
        public Future<KotlinScriptExternalDependencies> resolve(ScriptContents scriptContents, Map<String, ? extends Object> map, Function3<? super ScriptDependenciesResolver.ReportSeverity, ? super String, ? super ScriptContents.Position, Unit> function3, KotlinScriptExternalDependencies kotlinScriptExternalDependencies) {
            return DefaultImpls.resolve(this, scriptContents, map, function3, kotlinScriptExternalDependencies);
        }

        @Override // kotlin.script.experimental.dependencies.DependenciesResolver
        public /* bridge */ /* synthetic */ ResolveResult resolve(ScriptContents scriptContents, Map map) {
            return resolve(scriptContents, (Map<String, ? extends Object>) map);
        }

        @Override // kotlin.script.experimental.dependencies.DependenciesResolver
        public ResolveResult.Success resolve(ScriptContents scriptContents, Map<String, ? extends Object> environment) {
            Intrinsics.checkNotNullParameter(scriptContents, "scriptContents");
            Intrinsics.checkNotNullParameter(environment, "environment");
            return ResolversKt.asSuccess(ScriptDependencies.INSTANCE.getEmpty());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\f\rB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u000e\u000f\u00a8\u0006\u0010"}, d2 = {"Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult;", "", "()V", "dependencies", "Lkotlin/script/experimental/dependencies/ScriptDependencies;", "getDependencies", "()Lkotlin/script/experimental/dependencies/ScriptDependencies;", "reports", "", "Lkotlin/script/experimental/dependencies/ScriptReport;", "getReports", "()Ljava/util/List;", "Failure", "Success", "Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult$Failure;", "Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult$Success;", "kotlin-script-runtime"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes38.dex */
    public static abstract class ResolveResult {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u00c6\u0003J\u0019\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult$Failure;", "Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult;", "reports", "", "Lkotlin/script/experimental/dependencies/ScriptReport;", "([Lkotlin/script/experimental/dependencies/ScriptReport;)V", "", "(Ljava/util/List;)V", "dependencies", "Lkotlin/script/experimental/dependencies/ScriptDependencies;", "getDependencies", "()Lkotlin/script/experimental/dependencies/ScriptDependencies;", "getReports", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-script-runtime"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes38.dex */
        public static final /* data */ class Failure extends ResolveResult {
            private final List<ScriptReport> reports;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failure(List<ScriptReport> reports) {
                super(null);
                Intrinsics.checkNotNullParameter(reports, "reports");
                this.reports = reports;
            }

            public final List<ScriptReport> component1() {
                return getReports();
            }

            public final Failure copy(List<ScriptReport> reports) {
                Intrinsics.checkNotNullParameter(reports, "reports");
                return new Failure(reports);
            }

            @Override // kotlin.script.experimental.dependencies.DependenciesResolver.ResolveResult
            public ScriptDependencies getDependencies() {
                return null;
            }

            @Override // kotlin.script.experimental.dependencies.DependenciesResolver.ResolveResult
            public List<ScriptReport> getReports() {
                return this.reports;
            }

            public int hashCode() {
                return getReports().hashCode();
            }

            public String toString() {
                return "Failure(reports=" + getReports() + ')';
            }

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Failure(ScriptReport... reports) {
                this((List<ScriptReport>) r2);
                List asList;
                Intrinsics.checkNotNullParameter(reports, "reports");
                asList = ArraysKt___ArraysJvmKt.asList(reports);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Failure copy$default(Failure failure, List list, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    list = failure.getReports();
                }
                return failure.copy(list);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Failure) && Intrinsics.areEqual(getReports(), ((Failure) other).getReports());
            }
        }

        public /* synthetic */ ResolveResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract ScriptDependencies getDependencies();

        public abstract List<ScriptReport> getReports();

        /* compiled from: P */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult$Success;", "Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult;", "dependencies", "Lkotlin/script/experimental/dependencies/ScriptDependencies;", "reports", "", "Lkotlin/script/experimental/dependencies/ScriptReport;", "(Lkotlin/script/experimental/dependencies/ScriptDependencies;Ljava/util/List;)V", "getDependencies", "()Lkotlin/script/experimental/dependencies/ScriptDependencies;", "getReports", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-script-runtime"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes38.dex */
        public static final /* data */ class Success extends ResolveResult {
            private final ScriptDependencies dependencies;
            private final List<ScriptReport> reports;

            public /* synthetic */ Success(ScriptDependencies scriptDependencies, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(scriptDependencies, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
            }

            public final ScriptDependencies component1() {
                return getDependencies();
            }

            public final List<ScriptReport> component2() {
                return getReports();
            }

            public final Success copy(ScriptDependencies dependencies, List<ScriptReport> reports) {
                Intrinsics.checkNotNullParameter(dependencies, "dependencies");
                Intrinsics.checkNotNullParameter(reports, "reports");
                return new Success(dependencies, reports);
            }

            @Override // kotlin.script.experimental.dependencies.DependenciesResolver.ResolveResult
            public ScriptDependencies getDependencies() {
                return this.dependencies;
            }

            @Override // kotlin.script.experimental.dependencies.DependenciesResolver.ResolveResult
            public List<ScriptReport> getReports() {
                return this.reports;
            }

            public int hashCode() {
                return (getDependencies().hashCode() * 31) + getReports().hashCode();
            }

            public String toString() {
                return "Success(dependencies=" + getDependencies() + ", reports=" + getReports() + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(ScriptDependencies dependencies, List<ScriptReport> reports) {
                super(null);
                Intrinsics.checkNotNullParameter(dependencies, "dependencies");
                Intrinsics.checkNotNullParameter(reports, "reports");
                this.dependencies = dependencies;
                this.reports = reports;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Success copy$default(Success success, ScriptDependencies scriptDependencies, List list, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    scriptDependencies = success.getDependencies();
                }
                if ((i3 & 2) != 0) {
                    list = success.getReports();
                }
                return success.copy(scriptDependencies, list);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics.areEqual(getDependencies(), success.getDependencies()) && Intrinsics.areEqual(getReports(), success.getReports());
            }
        }

        ResolveResult() {
        }
    }

    ResolveResult resolve(ScriptContents scriptContents, Map<String, ? extends Object> environment);
}
