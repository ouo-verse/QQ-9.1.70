package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public class ReceiverParameterDescriptorImpl extends AbstractReceiverParameterDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final DeclarationDescriptor containingDeclaration;
    private ReceiverValue value;

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 3 && i3 != 4) {
            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i3 != 3 && i3 != 4) {
            i16 = 3;
        } else {
            i16 = 2;
        }
        Object[] objArr = new Object[i16];
        switch (i3) {
            case 1:
                objArr[0] = "value";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 5:
                objArr[0] = "newOwner";
                break;
            case 6:
                objArr[0] = "outType";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i3 != 3) {
            if (i3 != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
            } else {
                objArr[1] = "getContainingDeclaration";
            }
        } else {
            objArr[1] = HippyTextInputController.COMMAND_getValue;
        }
        if (i3 != 3 && i3 != 4) {
            if (i3 != 5) {
                if (i3 != 6) {
                    objArr[2] = "<init>";
                } else {
                    objArr[2] = "setOutType";
                }
            } else {
                objArr[2] = "copy";
            }
        }
        String format = String.format(str, objArr);
        if (i3 == 3 || i3 == 4) {
            throw new IllegalStateException(format);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReceiverParameterDescriptorImpl(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull ReceiverValue receiverValue, @NotNull Annotations annotations) {
        super(annotations);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (receiverValue == null) {
            $$$reportNull$$$0(1);
        }
        if (annotations == null) {
            $$$reportNull$$$0(2);
        }
        this.containingDeclaration = declarationDescriptor;
        this.value = receiverValue;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.containingDeclaration;
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(4);
        }
        return declarationDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor
    @NotNull
    public ReceiverValue getValue() {
        ReceiverValue receiverValue = this.value;
        if (receiverValue == null) {
            $$$reportNull$$$0(3);
        }
        return receiverValue;
    }
}
