package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class ReturnsCheck implements Check {

    @NotNull
    private final String description;

    @NotNull
    private final String name;

    @NotNull
    private final Function1<KotlinBuiltIns, KotlinType> type;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class ReturnsBoolean extends ReturnsCheck {

        @NotNull
        public static final ReturnsBoolean INSTANCE = new ReturnsBoolean();

        ReturnsBoolean() {
            super("Boolean", new Function1<KotlinBuiltIns, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsBoolean.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final KotlinType invoke(@NotNull KotlinBuiltIns kotlinBuiltIns) {
                    Intrinsics.checkNotNullParameter(kotlinBuiltIns, "$this$null");
                    SimpleType booleanType = kotlinBuiltIns.getBooleanType();
                    Intrinsics.checkNotNullExpressionValue(booleanType, "booleanType");
                    return booleanType;
                }
            }, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class ReturnsInt extends ReturnsCheck {

        @NotNull
        public static final ReturnsInt INSTANCE = new ReturnsInt();

        ReturnsInt() {
            super("Int", new Function1<KotlinBuiltIns, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsInt.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final KotlinType invoke(@NotNull KotlinBuiltIns kotlinBuiltIns) {
                    Intrinsics.checkNotNullParameter(kotlinBuiltIns, "$this$null");
                    SimpleType intType = kotlinBuiltIns.getIntType();
                    Intrinsics.checkNotNullExpressionValue(intType, "intType");
                    return intType;
                }
            }, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class ReturnsUnit extends ReturnsCheck {

        @NotNull
        public static final ReturnsUnit INSTANCE = new ReturnsUnit();

        ReturnsUnit() {
            super("Unit", new Function1<KotlinBuiltIns, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsUnit.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final KotlinType invoke(@NotNull KotlinBuiltIns kotlinBuiltIns) {
                    Intrinsics.checkNotNullParameter(kotlinBuiltIns, "$this$null");
                    SimpleType unitType = kotlinBuiltIns.getUnitType();
                    Intrinsics.checkNotNullExpressionValue(unitType, "unitType");
                    return unitType;
                }
            }, null);
        }
    }

    public /* synthetic */ ReturnsCheck(String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        return Intrinsics.areEqual(functionDescriptor.getReturnType(), this.type.invoke(DescriptorUtilsKt.getBuiltIns(functionDescriptor)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @NotNull
    public String getDescription() {
        return this.description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    ReturnsCheck(String str, Function1<? super KotlinBuiltIns, ? extends KotlinType> function1) {
        this.name = str;
        this.type = function1;
        this.description = "must return " + str;
    }
}
