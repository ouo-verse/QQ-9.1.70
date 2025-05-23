package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FunctionClassScope extends GivenFunctionsMemberScope {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FunctionClassKind.values().length];
            try {
                iArr[FunctionClassKind.Function.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FunctionClassKind.SuspendFunction.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionClassScope(@NotNull StorageManager storageManager, @NotNull FunctionClassDescriptor containingClass) {
        super(storageManager, containingClass);
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(containingClass, "containingClass");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
    @NotNull
    protected List<FunctionDescriptor> computeDeclaredFunctions() {
        List<FunctionDescriptor> listOf;
        List<FunctionDescriptor> listOf2;
        List<FunctionDescriptor> emptyList;
        ClassDescriptor containingClass = getContainingClass();
        Intrinsics.checkNotNull(containingClass, "null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
        int i3 = WhenMappings.$EnumSwitchMapping$0[((FunctionClassDescriptor) containingClass).getFunctionKind().ordinal()];
        if (i3 == 1) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(FunctionInvokeDescriptor.Factory.create((FunctionClassDescriptor) getContainingClass(), false));
            return listOf;
        }
        if (i3 != 2) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(FunctionInvokeDescriptor.Factory.create((FunctionClassDescriptor) getContainingClass(), true));
        return listOf2;
    }
}
