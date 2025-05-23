package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class AbstractClassTypeConstructor extends AbstractTypeConstructor {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        String format;
        if (i3 != 1 && i3 != 3 && i3 != 4) {
            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i3 != 1 && i3 != 3 && i3 != 4) {
            i16 = 3;
        } else {
            i16 = 2;
        }
        Object[] objArr = new Object[i16];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3 && i3 != 4) {
                    objArr[0] = "storageManager";
                }
            } else {
                objArr[0] = "classifier";
            }
            if (i3 == 1) {
                if (i3 != 3 && i3 != 4) {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
                } else {
                    objArr[1] = "getAdditionalNeighboursInSupertypeGraph";
                }
            } else {
                objArr[1] = "getBuiltIns";
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3 && i3 != 4) {
                        objArr[2] = "<init>";
                    }
                } else {
                    objArr[2] = "isSameClassifier";
                }
            }
            format = String.format(str, objArr);
            if (i3 != 1 || i3 == 3 || i3 == 4) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }
        objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        if (i3 == 1) {
        }
        if (i3 != 1) {
        }
        format = String.format(str, objArr);
        if (i3 != 1) {
        }
        throw new IllegalStateException(format);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractClassTypeConstructor(@NotNull StorageManager storageManager) {
        super(storageManager);
        if (storageManager == null) {
            $$$reportNull$$$0(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    @Nullable
    public KotlinType defaultSupertypeIfEmpty() {
        if (KotlinBuiltIns.isSpecialClassWithNoSupertypes(mo1779getDeclarationDescriptor())) {
            return null;
        }
        return getBuiltIns().getAnyType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    @NotNull
    protected Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean z16) {
        DeclarationDescriptor containingDeclaration = mo1779getDeclarationDescriptor().getContainingDeclaration();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            List emptyList = Collections.emptyList();
            if (emptyList == null) {
                $$$reportNull$$$0(3);
            }
            return emptyList;
        }
        SmartList smartList = new SmartList();
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        smartList.add(classDescriptor.getDefaultType());
        ClassDescriptor mo1772getCompanionObjectDescriptor = classDescriptor.mo1772getCompanionObjectDescriptor();
        if (z16 && mo1772getCompanionObjectDescriptor != null) {
            smartList.add(mo1772getCompanionObjectDescriptor.getDefaultType());
        }
        return smartList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = DescriptorUtilsKt.getBuiltIns(mo1779getDeclarationDescriptor());
        if (builtIns == null) {
            $$$reportNull$$$0(1);
        }
        return builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    /* renamed from: getDeclarationDescriptor */
    public abstract ClassDescriptor mo1779getDeclarationDescriptor();

    @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor
    protected boolean isSameClassifier(@NotNull ClassifierDescriptor classifierDescriptor) {
        if (classifierDescriptor == null) {
            $$$reportNull$$$0(2);
        }
        if ((classifierDescriptor instanceof ClassDescriptor) && areFqNamesEqual(mo1779getDeclarationDescriptor(), classifierDescriptor)) {
            return true;
        }
        return false;
    }
}
