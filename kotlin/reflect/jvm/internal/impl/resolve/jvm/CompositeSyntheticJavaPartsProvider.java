package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public final class CompositeSyntheticJavaPartsProvider implements SyntheticJavaPartsProvider {

    @NotNull
    private final List<SyntheticJavaPartsProvider> inner;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeSyntheticJavaPartsProvider(@NotNull List<? extends SyntheticJavaPartsProvider> inner) {
        Intrinsics.checkNotNullParameter(inner, "inner");
        this.inner = inner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateConstructors(@NotNull ClassDescriptor thisDescriptor, @NotNull List<ClassConstructorDescriptor> result) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(result, "result");
        Iterator<T> it = this.inner.iterator();
        while (it.hasNext()) {
            ((SyntheticJavaPartsProvider) it.next()).generateConstructors(thisDescriptor, result);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateMethods(@NotNull ClassDescriptor thisDescriptor, @NotNull Name name, @NotNull Collection<SimpleFunctionDescriptor> result) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(result, "result");
        Iterator<T> it = this.inner.iterator();
        while (it.hasNext()) {
            ((SyntheticJavaPartsProvider) it.next()).generateMethods(thisDescriptor, name, result);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateStaticFunctions(@NotNull ClassDescriptor thisDescriptor, @NotNull Name name, @NotNull Collection<SimpleFunctionDescriptor> result) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(result, "result");
        Iterator<T> it = this.inner.iterator();
        while (it.hasNext()) {
            ((SyntheticJavaPartsProvider) it.next()).generateStaticFunctions(thisDescriptor, name, result);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    @NotNull
    public List<Name> getMethodNames(@NotNull ClassDescriptor thisDescriptor) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        List<SyntheticJavaPartsProvider> list = this.inner;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((SyntheticJavaPartsProvider) it.next()).getMethodNames(thisDescriptor));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    @NotNull
    public List<Name> getStaticFunctionNames(@NotNull ClassDescriptor thisDescriptor) {
        Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        List<SyntheticJavaPartsProvider> list = this.inner;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((SyntheticJavaPartsProvider) it.next()).getStaticFunctionNames(thisDescriptor));
        }
        return arrayList;
    }
}
