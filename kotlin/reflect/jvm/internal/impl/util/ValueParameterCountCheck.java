package kotlin.reflect.jvm.internal.impl.util;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public abstract class ValueParameterCountCheck implements Check {

    @NotNull
    private final String description;

    /* loaded from: classes28.dex */
    public static final class AtLeast extends ValueParameterCountCheck {

        /* renamed from: n, reason: collision with root package name */
        private final int f412767n;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AtLeast(int i3) {
            super(r0.toString(), null);
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("must have at least ");
            sb5.append(i3);
            sb5.append(" value parameter");
            if (i3 > 1) {
                str = ReportConstant.COSTREPORT_PREFIX;
            } else {
                str = "";
            }
            sb5.append(str);
            this.f412767n = i3;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            if (functionDescriptor.getValueParameters().size() >= this.f412767n) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes28.dex */
    public static final class Equals extends ValueParameterCountCheck {

        /* renamed from: n, reason: collision with root package name */
        private final int f412768n;

        public Equals(int i3) {
            super("must have exactly " + i3 + " value parameters", null);
            this.f412768n = i3;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            if (functionDescriptor.getValueParameters().size() == this.f412768n) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes28.dex */
    public static final class NoValueParameters extends ValueParameterCountCheck {

        @NotNull
        public static final NoValueParameters INSTANCE = new NoValueParameters();

        NoValueParameters() {
            super("must have no value parameters", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().isEmpty();
        }
    }

    /* loaded from: classes28.dex */
    public static final class SingleValueParameter extends ValueParameterCountCheck {

        @NotNull
        public static final SingleValueParameter INSTANCE = new SingleValueParameter();

        SingleValueParameter() {
            super("must have a single value parameter", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            if (functionDescriptor.getValueParameters().size() == 1) {
                return true;
            }
            return false;
        }
    }

    public /* synthetic */ ValueParameterCountCheck(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
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

    ValueParameterCountCheck(String str) {
        this.description = str;
    }
}
