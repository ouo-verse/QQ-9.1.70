package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public final class IndexedParametersSubstitution extends TypeSubstitution {
    private final boolean approximateContravariantCapturedTypes;

    @NotNull
    private final TypeProjection[] arguments;

    @NotNull
    private final TypeParameterDescriptor[] parameters;

    public /* synthetic */ IndexedParametersSubstitution(TypeParameterDescriptor[] typeParameterDescriptorArr, TypeProjection[] typeProjectionArr, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeParameterDescriptorArr, typeProjectionArr, (i3 & 4) != 0 ? false : z16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        return this.approximateContravariantCapturedTypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    @Nullable
    /* renamed from: get */
    public TypeProjection mo1784get(@NotNull KotlinType key) {
        TypeParameterDescriptor typeParameterDescriptor;
        Intrinsics.checkNotNullParameter(key, "key");
        ClassifierDescriptor mo1779getDeclarationDescriptor = key.getConstructor().mo1779getDeclarationDescriptor();
        if (mo1779getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            typeParameterDescriptor = (TypeParameterDescriptor) mo1779getDeclarationDescriptor;
        } else {
            typeParameterDescriptor = null;
        }
        if (typeParameterDescriptor == null) {
            return null;
        }
        int index = typeParameterDescriptor.getIndex();
        TypeParameterDescriptor[] typeParameterDescriptorArr = this.parameters;
        if (index >= typeParameterDescriptorArr.length || !Intrinsics.areEqual(typeParameterDescriptorArr[index].getTypeConstructor(), typeParameterDescriptor.getTypeConstructor())) {
            return null;
        }
        return this.arguments[index];
    }

    @NotNull
    public final TypeProjection[] getArguments() {
        return this.arguments;
    }

    @NotNull
    public final TypeParameterDescriptor[] getParameters() {
        return this.parameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        if (this.arguments.length == 0) {
            return true;
        }
        return false;
    }

    public IndexedParametersSubstitution(@NotNull TypeParameterDescriptor[] parameters, @NotNull TypeProjection[] arguments, boolean z16) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.parameters = parameters;
        this.arguments = arguments;
        this.approximateContravariantCapturedTypes = z16;
        int length = parameters.length;
        int length2 = arguments.length;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IndexedParametersSubstitution(@NotNull List<? extends TypeParameterDescriptor> parameters, @NotNull List<? extends TypeProjection> argumentsList) {
        this(r3, (TypeProjection[]) r9, false, 4, null);
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(argumentsList, "argumentsList");
        Object[] array = parameters.toArray(new TypeParameterDescriptor[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        TypeParameterDescriptor[] typeParameterDescriptorArr = (TypeParameterDescriptor[]) array;
        Object[] array2 = argumentsList.toArray(new TypeProjection[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
