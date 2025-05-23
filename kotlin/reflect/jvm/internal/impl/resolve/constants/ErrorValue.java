package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class ErrorValue extends ConstantValue<Unit> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ErrorValue create(@NotNull String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new ErrorValueWithMessage(message);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class ErrorValueWithMessage extends ErrorValue {

        @NotNull
        private final String message;

        public ErrorValueWithMessage(@NotNull String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
        @NotNull
        public String toString() {
            return this.message;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
        @NotNull
        public ErrorType getType(@NotNull ModuleDescriptor module) {
            Intrinsics.checkNotNullParameter(module, "module");
            return ErrorUtils.createErrorType(ErrorTypeKind.ERROR_CONSTANT_VALUE, this.message);
        }
    }

    public ErrorValue() {
        super(Unit.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    @NotNull
    public Unit getValue() {
        throw new UnsupportedOperationException();
    }
}
