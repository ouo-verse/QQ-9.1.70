package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class MemberKindCheck implements Check {

    @NotNull
    private final String description;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Member extends MemberKindCheck {

        @NotNull
        public static final Member INSTANCE = new Member();

        Member() {
            super("must be a member function", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            if (functionDescriptor.getDispatchReceiverParameter() != null) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class MemberOrExtension extends MemberKindCheck {

        @NotNull
        public static final MemberOrExtension INSTANCE = new MemberOrExtension();

        MemberOrExtension() {
            super("must be a member or an extension function", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
            if (functionDescriptor.getDispatchReceiverParameter() == null && functionDescriptor.getExtensionReceiverParameter() == null) {
                return false;
            }
            return true;
        }
    }

    public /* synthetic */ MemberKindCheck(String str, DefaultConstructorMarker defaultConstructorMarker) {
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

    MemberKindCheck(String str) {
        this.description = str;
    }
}
