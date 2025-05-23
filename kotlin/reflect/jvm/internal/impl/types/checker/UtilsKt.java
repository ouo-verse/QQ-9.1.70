package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class UtilsKt {
    private static final KotlinType approximate(KotlinType kotlinType) {
        return CapturedTypeApproximationKt.approximateCapturedTypes(kotlinType).getUpper();
    }

    private static final String debugInfo(TypeConstructor typeConstructor) {
        StringBuilder sb5 = new StringBuilder();
        debugInfo$lambda$1$unaryPlus("type: " + typeConstructor, sb5);
        debugInfo$lambda$1$unaryPlus("hashCode: " + typeConstructor.hashCode(), sb5);
        debugInfo$lambda$1$unaryPlus("javaClass: " + typeConstructor.getClass().getCanonicalName(), sb5);
        for (DeclarationDescriptor mo1779getDeclarationDescriptor = typeConstructor.mo1779getDeclarationDescriptor(); mo1779getDeclarationDescriptor != null; mo1779getDeclarationDescriptor = mo1779getDeclarationDescriptor.getContainingDeclaration()) {
            debugInfo$lambda$1$unaryPlus("fqName: " + DescriptorRenderer.FQ_NAMES_IN_TYPES.render(mo1779getDeclarationDescriptor), sb5);
            debugInfo$lambda$1$unaryPlus("javaClass: " + mo1779getDeclarationDescriptor.getClass().getCanonicalName(), sb5);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    private static final StringBuilder debugInfo$lambda$1$unaryPlus(String str, StringBuilder sb5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        sb5.append(str);
        Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
        sb5.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        return sb5;
    }

    @Nullable
    public static final KotlinType findCorrespondingSupertype(@NotNull KotlinType subtype, @NotNull KotlinType supertype, @NotNull TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(subtype, "subtype");
        Intrinsics.checkNotNullParameter(supertype, "supertype");
        Intrinsics.checkNotNullParameter(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new SubtypePathNode(subtype, null));
        TypeConstructor constructor = supertype.getConstructor();
        while (!arrayDeque.isEmpty()) {
            SubtypePathNode subtypePathNode = (SubtypePathNode) arrayDeque.poll();
            KotlinType type = subtypePathNode.getType();
            TypeConstructor constructor2 = type.getConstructor();
            if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor2, constructor)) {
                boolean isMarkedNullable = type.isMarkedNullable();
                for (SubtypePathNode previous = subtypePathNode.getPrevious(); previous != null; previous = previous.getPrevious()) {
                    KotlinType type2 = previous.getType();
                    List<TypeProjection> arguments = type2.getArguments();
                    if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                        Iterator<T> it = arguments.iterator();
                        while (it.hasNext()) {
                            if (((TypeProjection) it.next()).getProjectionKind() != Variance.INVARIANT) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                z17 = true;
                                break;
                            }
                        }
                    }
                    z17 = false;
                    if (z17) {
                        KotlinType safeSubstitute = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(TypeConstructorSubstitution.Companion.create(type2), false, 1, null).buildSubstitutor().safeSubstitute(type, Variance.INVARIANT);
                        Intrinsics.checkNotNullExpressionValue(safeSubstitute, "TypeConstructorSubstitut\u2026uted, Variance.INVARIANT)");
                        type = approximate(safeSubstitute);
                    } else {
                        type = TypeConstructorSubstitution.Companion.create(type2).buildSubstitutor().safeSubstitute(type, Variance.INVARIANT);
                        Intrinsics.checkNotNullExpressionValue(type, "{\n                    Ty\u2026ARIANT)\n                }");
                    }
                    if (!isMarkedNullable && !type2.isMarkedNullable()) {
                        isMarkedNullable = false;
                    } else {
                        isMarkedNullable = true;
                    }
                }
                TypeConstructor constructor3 = type.getConstructor();
                if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor3, constructor)) {
                    return TypeUtils.makeNullableAsSpecified(type, isMarkedNullable);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + debugInfo(constructor3) + ", \n\nsupertype: " + debugInfo(constructor) + " \n" + typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor3, constructor));
            }
            for (KotlinType immediateSupertype : constructor2.mo1780getSupertypes()) {
                Intrinsics.checkNotNullExpressionValue(immediateSupertype, "immediateSupertype");
                arrayDeque.add(new SubtypePathNode(immediateSupertype, subtypePathNode));
            }
        }
        return null;
    }
}
