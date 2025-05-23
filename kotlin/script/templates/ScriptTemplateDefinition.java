package kotlin.script.templates;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.script.dependencies.ScriptDependenciesResolver;
import kotlin.script.experimental.dependencies.DependenciesResolver;

/* compiled from: P */
@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001c\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006R\u0017\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0007R\u000f\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\b\u00a8\u0006\t"}, d2 = {"Lkotlin/script/templates/ScriptTemplateDefinition;", "", "resolver", "Lkotlin/reflect/KClass;", "Lkotlin/script/dependencies/ScriptDependenciesResolver;", "scriptFilePattern", "", "()Ljava/lang/Class;", "()Ljava/lang/String;", "kotlin-script-runtime"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
/* loaded from: classes38.dex */
public @interface ScriptTemplateDefinition {
    Class<? extends ScriptDependenciesResolver> resolver() default DependenciesResolver.NoDependencies.class;

    String scriptFilePattern() default ".*\\.kts";
}
