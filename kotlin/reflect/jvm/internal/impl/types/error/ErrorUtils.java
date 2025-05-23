package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ErrorUtils {

    @NotNull
    private static final ErrorClassDescriptor errorClass;

    @NotNull
    private static final PropertyDescriptor errorProperty;

    @NotNull
    private static final Set<PropertyDescriptor> errorPropertyGroup;

    @NotNull
    private static final KotlinType errorPropertyType;

    @NotNull
    private static final KotlinType errorTypeForLoopInSupertypes;

    @NotNull
    public static final ErrorUtils INSTANCE = new ErrorUtils();

    @NotNull
    private static final ModuleDescriptor errorModule = ErrorModuleDescriptor.INSTANCE;

    static {
        Set<PropertyDescriptor> of5;
        String format = String.format(ErrorEntity.ERROR_CLASS.getDebugText(), Arrays.copyOf(new Object[]{"unknown class"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        Name special = Name.special(format);
        Intrinsics.checkNotNullExpressionValue(special, "special(ErrorEntity.ERRO\u2026.format(\"unknown class\"))");
        errorClass = new ErrorClassDescriptor(special);
        errorTypeForLoopInSupertypes = createErrorType(ErrorTypeKind.CYCLIC_SUPERTYPES, new String[0]);
        errorPropertyType = createErrorType(ErrorTypeKind.ERROR_PROPERTY_TYPE, new String[0]);
        ErrorPropertyDescriptor errorPropertyDescriptor = new ErrorPropertyDescriptor();
        errorProperty = errorPropertyDescriptor;
        of5 = SetsKt__SetsJVMKt.setOf(errorPropertyDescriptor);
        errorPropertyGroup = of5;
    }

    ErrorUtils() {
    }

    @JvmStatic
    @NotNull
    public static final ErrorScope createErrorScope(@NotNull ErrorScopeKind kind, @NotNull String... formatParams) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return createErrorScope(kind, false, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    @JvmStatic
    @NotNull
    public static final ErrorType createErrorType(@NotNull ErrorTypeKind kind, @NotNull String... formatParams) {
        List<? extends TypeProjection> emptyList;
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        ErrorUtils errorUtils = INSTANCE;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return errorUtils.createErrorTypeWithArguments(kind, emptyList, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    @JvmStatic
    public static final boolean isError(@Nullable DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            ErrorUtils errorUtils = INSTANCE;
            if (errorUtils.isErrorClass(declarationDescriptor) || errorUtils.isErrorClass(declarationDescriptor.getContainingDeclaration()) || declarationDescriptor == errorModule) {
                return true;
            }
        }
        return false;
    }

    private final boolean isErrorClass(DeclarationDescriptor declarationDescriptor) {
        return declarationDescriptor instanceof ErrorClassDescriptor;
    }

    @JvmStatic
    public static final boolean isUninferredTypeVariable(@Nullable KotlinType kotlinType) {
        if (kotlinType == null) {
            return false;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (!(constructor instanceof ErrorTypeConstructor) || ((ErrorTypeConstructor) constructor).getKind() != ErrorTypeKind.UNINFERRED_TYPE_VARIABLE) {
            return false;
        }
        return true;
    }

    @NotNull
    public final ErrorTypeConstructor createErrorTypeConstructor(@NotNull ErrorTypeKind kind, @NotNull String... formatParams) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return new ErrorTypeConstructor(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    @NotNull
    public final ErrorType createErrorTypeWithArguments(@NotNull ErrorTypeKind kind, @NotNull List<? extends TypeProjection> arguments, @NotNull String... formatParams) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return createErrorTypeWithArguments(kind, arguments, createErrorTypeConstructor(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length)), (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    @NotNull
    public final ErrorClassDescriptor getErrorClass() {
        return errorClass;
    }

    @NotNull
    public final ModuleDescriptor getErrorModule() {
        return errorModule;
    }

    @NotNull
    public final Set<PropertyDescriptor> getErrorPropertyGroup() {
        return errorPropertyGroup;
    }

    @NotNull
    public final KotlinType getErrorPropertyType() {
        return errorPropertyType;
    }

    @NotNull
    public final KotlinType getErrorTypeForLoopInSupertypes() {
        return errorTypeForLoopInSupertypes;
    }

    @JvmStatic
    @NotNull
    public static final ErrorScope createErrorScope(@NotNull ErrorScopeKind kind, boolean z16, @NotNull String... formatParams) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return z16 ? new ThrowingScope(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length)) : new ErrorScope(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    @NotNull
    public final ErrorType createErrorType(@NotNull ErrorTypeKind kind, @NotNull TypeConstructor typeConstructor, @NotNull String... formatParams) {
        List<? extends TypeProjection> emptyList;
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return createErrorTypeWithArguments(kind, emptyList, typeConstructor, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    @NotNull
    public final ErrorType createErrorTypeWithArguments(@NotNull ErrorTypeKind kind, @NotNull List<? extends TypeProjection> arguments, @NotNull TypeConstructor typeConstructor, @NotNull String... formatParams) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
        Intrinsics.checkNotNullParameter(formatParams, "formatParams");
        return new ErrorType(typeConstructor, createErrorScope(ErrorScopeKind.ERROR_TYPE_SCOPE, typeConstructor.toString()), kind, arguments, false, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }
}
