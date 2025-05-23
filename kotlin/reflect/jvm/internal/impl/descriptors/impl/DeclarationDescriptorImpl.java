package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class DeclarationDescriptorImpl extends AnnotatedImpl implements DeclarationDescriptor {

    @NotNull
    private final Name name;

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 2 && i3 != 3 && i3 != 5 && i3 != 6) {
            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i3 != 2 && i3 != 3 && i3 != 5 && i3 != 6) {
            i16 = 3;
        } else {
            i16 = 2;
        }
        Object[] objArr = new Object[i16];
        switch (i3) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 5 && i3 != 6) {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                } else {
                    objArr[1] = "toString";
                }
            } else {
                objArr[1] = "getOriginal";
            }
        } else {
            objArr[1] = "getName";
        }
        if (i3 != 2 && i3 != 3) {
            if (i3 != 4) {
                if (i3 != 5 && i3 != 6) {
                    objArr[2] = "<init>";
                }
            } else {
                objArr[2] = "toString";
            }
        }
        String format = String.format(str, objArr);
        if (i3 == 2 || i3 == 3 || i3 == 5 || i3 == 6) {
            throw new IllegalStateException(format);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeclarationDescriptorImpl(@NotNull Annotations annotations, @NotNull Name name) {
        super(annotations);
        if (annotations == null) {
            $$$reportNull$$$0(0);
        }
        if (name == null) {
            $$$reportNull$$$0(1);
        }
        this.name = name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    @NotNull
    public Name getName() {
        Name name = this.name;
        if (name == null) {
            $$$reportNull$$$0(2);
        }
        return name;
    }

    public String toString() {
        return toString(this);
    }

    @NotNull
    public static String toString(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(4);
        }
        try {
            String str = DescriptorRenderer.DEBUG_TEXT.render(declarationDescriptor) + "[" + declarationDescriptor.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(declarationDescriptor)) + "]";
            if (str == null) {
                $$$reportNull$$$0(5);
            }
            return str;
        } catch (Throwable unused) {
            String str2 = declarationDescriptor.getClass().getSimpleName() + " " + declarationDescriptor.getName();
            if (str2 == null) {
                $$$reportNull$$$0(6);
            }
            return str2;
        }
    }

    @NotNull
    public DeclarationDescriptor getOriginal() {
        return this;
    }
}
