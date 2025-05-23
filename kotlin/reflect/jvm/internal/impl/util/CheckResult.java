package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class CheckResult {
    private final boolean isSuccess;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class IllegalFunctionName extends CheckResult {

        @NotNull
        public static final IllegalFunctionName INSTANCE = new IllegalFunctionName();

        IllegalFunctionName() {
            super(false, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class IllegalSignature extends CheckResult {

        @NotNull
        private final String error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IllegalSignature(@NotNull String error) {
            super(false, null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class SuccessCheck extends CheckResult {

        @NotNull
        public static final SuccessCheck INSTANCE = new SuccessCheck();

        SuccessCheck() {
            super(true, null);
        }
    }

    public /* synthetic */ CheckResult(boolean z16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16);
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    CheckResult(boolean z16) {
        this.isSuccess = z16;
    }
}
