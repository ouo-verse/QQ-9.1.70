package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class UtilKt {
    @NotNull
    public static final List<ValueParameterDescriptor> copyValueParameters(@NotNull Collection<? extends KotlinType> newValueParameterTypes, @NotNull Collection<? extends ValueParameterDescriptor> oldValueParameters, @NotNull CallableDescriptor newOwner) {
        List zip;
        int collectionSizeOrDefault;
        KotlinType kotlinType;
        Intrinsics.checkNotNullParameter(newValueParameterTypes, "newValueParameterTypes");
        Intrinsics.checkNotNullParameter(oldValueParameters, "oldValueParameters");
        Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        newValueParameterTypes.size();
        oldValueParameters.size();
        zip = CollectionsKt___CollectionsKt.zip(newValueParameterTypes, oldValueParameters);
        List list = zip;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Iterator it = list.iterator(); it.hasNext(); it = it) {
            Pair pair = (Pair) it.next();
            KotlinType kotlinType2 = (KotlinType) pair.component1();
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) pair.component2();
            int index = valueParameterDescriptor.getIndex();
            Annotations annotations = valueParameterDescriptor.getAnnotations();
            Name name = valueParameterDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name, "oldParameter.name");
            boolean declaresDefaultValue = valueParameterDescriptor.declaresDefaultValue();
            boolean isCrossinline = valueParameterDescriptor.isCrossinline();
            boolean isNoinline = valueParameterDescriptor.isNoinline();
            if (valueParameterDescriptor.getVarargElementType() != null) {
                kotlinType = DescriptorUtilsKt.getModule(newOwner).getBuiltIns().getArrayElementType(kotlinType2);
            } else {
                kotlinType = null;
            }
            SourceElement source = valueParameterDescriptor.getSource();
            Intrinsics.checkNotNullExpressionValue(source, "oldParameter.source");
            arrayList.add(new ValueParameterDescriptorImpl(newOwner, null, index, annotations, name, kotlinType2, declaresDefaultValue, isCrossinline, isNoinline, kotlinType, source));
        }
        return arrayList;
    }

    @Nullable
    public static final LazyJavaStaticClassScope getParentJavaStaticClassScope(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        ClassDescriptor superClassNotAny = DescriptorUtilsKt.getSuperClassNotAny(classDescriptor);
        LazyJavaStaticClassScope lazyJavaStaticClassScope = null;
        if (superClassNotAny == null) {
            return null;
        }
        MemberScope staticScope = superClassNotAny.getStaticScope();
        if (staticScope instanceof LazyJavaStaticClassScope) {
            lazyJavaStaticClassScope = (LazyJavaStaticClassScope) staticScope;
        }
        if (lazyJavaStaticClassScope == null) {
            return getParentJavaStaticClassScope(superClassNotAny);
        }
        return lazyJavaStaticClassScope;
    }
}
