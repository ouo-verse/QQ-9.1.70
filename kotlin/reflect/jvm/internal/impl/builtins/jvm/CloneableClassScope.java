package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class CloneableClassScope extends GivenFunctionsMemberScope {

    @NotNull
    private static final Name CLONE_NAME;

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Name getCLONE_NAME() {
            return CloneableClassScope.CLONE_NAME;
        }

        Companion() {
        }
    }

    static {
        Name identifier = Name.identifier("clone");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"clone\")");
        CLONE_NAME = identifier;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloneableClassScope(@NotNull StorageManager storageManager, @NotNull ClassDescriptor containingClass) {
        super(storageManager, containingClass);
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(containingClass, "containingClass");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
    @NotNull
    protected List<FunctionDescriptor> computeDeclaredFunctions() {
        List<ReceiverParameterDescriptor> emptyList;
        List<? extends TypeParameterDescriptor> emptyList2;
        List<ValueParameterDescriptor> emptyList3;
        List<FunctionDescriptor> listOf;
        SimpleFunctionDescriptorImpl create = SimpleFunctionDescriptorImpl.create(getContainingClass(), Annotations.Companion.getEMPTY(), CLONE_NAME, CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE);
        ReceiverParameterDescriptor thisAsReceiverParameter = getContainingClass().getThisAsReceiverParameter();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
        create.initialize((ReceiverParameterDescriptor) null, thisAsReceiverParameter, emptyList, emptyList2, emptyList3, (KotlinType) DescriptorUtilsKt.getBuiltIns(getContainingClass()).getAnyType(), Modality.OPEN, DescriptorVisibilities.PROTECTED);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(create);
        return listOf;
    }
}
