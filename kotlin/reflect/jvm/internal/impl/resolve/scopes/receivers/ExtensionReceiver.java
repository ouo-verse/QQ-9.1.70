package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ExtensionReceiver extends AbstractReceiverValue implements ImplicitReceiver {
    private final CallableDescriptor descriptor;

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 2) {
            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i3 != 2) {
            i16 = 3;
        } else {
            i16 = 2;
        }
        Object[] objArr = new Object[i16];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    objArr[0] = "callableDescriptor";
                } else {
                    objArr[0] = "newType";
                }
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
            }
        } else {
            objArr[0] = "receiverType";
        }
        if (i3 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else {
            objArr[1] = "getDeclarationDescriptor";
        }
        if (i3 != 2) {
            if (i3 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "replaceType";
            }
        }
        String format = String.format(str, objArr);
        if (i3 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtensionReceiver(@NotNull CallableDescriptor callableDescriptor, @NotNull KotlinType kotlinType, @Nullable ReceiverValue receiverValue) {
        super(kotlinType, receiverValue);
        if (callableDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(1);
        }
        this.descriptor = callableDescriptor;
    }

    public String toString() {
        return getType() + ": Ext {" + this.descriptor + "}";
    }
}
