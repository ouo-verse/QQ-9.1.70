package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public final class ReflectJavaPackage extends ReflectJavaElement implements JavaPackage {

    @NotNull
    private final FqName fqName;

    public ReflectJavaPackage(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = fqName;
    }

    public boolean equals(@Nullable Object obj) {
        if ((obj instanceof ReflectJavaPackage) && Intrinsics.areEqual(getFqName(), ((ReflectJavaPackage) obj).getFqName())) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @Nullable
    public JavaAnnotation findAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    @NotNull
    public Collection<JavaClass> getClasses(@NotNull Function1<? super Name, Boolean> nameFilter) {
        List emptyList;
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    @NotNull
    public FqName getFqName() {
        return this.fqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    @NotNull
    public Collection<JavaPackage> getSubPackages() {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    public int hashCode() {
        return getFqName().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @NotNull
    public String toString() {
        return ReflectJavaPackage.class.getName() + MsgSummary.STR_COLON + getFqName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    public List<JavaAnnotation> getAnnotations() {
        List<JavaAnnotation> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }
}
