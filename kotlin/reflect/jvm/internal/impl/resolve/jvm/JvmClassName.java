package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public class JvmClassName {
    private FqName fqName;
    private final String internalName;

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 3 && i3 != 6 && i3 != 7 && i3 != 8) {
            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i3 != 3 && i3 != 6 && i3 != 7 && i3 != 8) {
            i16 = 3;
        } else {
            i16 = 2;
        }
        Object[] objArr = new Object[i16];
        switch (i3) {
            case 1:
                objArr[0] = "classId";
                break;
            case 2:
            case 4:
                objArr[0] = "fqName";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            case 5:
            default:
                objArr[0] = "internalName";
                break;
        }
        if (i3 != 3) {
            if (i3 != 6) {
                if (i3 != 7) {
                    if (i3 != 8) {
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                    } else {
                        objArr[1] = "getInternalName";
                    }
                } else {
                    objArr[1] = "getPackageFqName";
                }
            } else {
                objArr[1] = "getFqNameForClassNameWithoutDollars";
            }
        } else {
            objArr[1] = "byFqNameWithoutInnerClasses";
        }
        switch (i3) {
            case 1:
                objArr[2] = "byClassId";
                break;
            case 2:
            case 4:
                objArr[2] = "byFqNameWithoutInnerClasses";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                break;
            case 5:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "byInternalName";
                break;
        }
        String format = String.format(str, objArr);
        if (i3 == 3 || i3 == 6 || i3 == 7 || i3 == 8) {
            throw new IllegalStateException(format);
        }
    }

    JvmClassName(@NotNull String str) {
        if (str == null) {
            $$$reportNull$$$0(5);
        }
        this.internalName = str;
    }

    @NotNull
    public static JvmClassName byClassId(@NotNull ClassId classId) {
        if (classId == null) {
            $$$reportNull$$$0(1);
        }
        FqName packageFqName = classId.getPackageFqName();
        String replace = classId.getRelativeClassName().asString().replace('.', '$');
        if (packageFqName.isRoot()) {
            return new JvmClassName(replace);
        }
        return new JvmClassName(packageFqName.asString().replace('.', '/') + "/" + replace);
    }

    @NotNull
    public static JvmClassName byFqNameWithoutInnerClasses(@NotNull FqName fqName) {
        if (fqName == null) {
            $$$reportNull$$$0(2);
        }
        JvmClassName jvmClassName = new JvmClassName(fqName.asString().replace('.', '/'));
        jvmClassName.fqName = fqName;
        return jvmClassName;
    }

    @NotNull
    public static JvmClassName byInternalName(@NotNull String str) {
        if (str == null) {
            $$$reportNull$$$0(0);
        }
        return new JvmClassName(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.internalName.equals(((JvmClassName) obj).internalName);
        }
        return false;
    }

    @NotNull
    public FqName getFqNameForTopLevelClassMaybeWithDollars() {
        return new FqName(this.internalName.replace('/', '.'));
    }

    @NotNull
    public String getInternalName() {
        String str = this.internalName;
        if (str == null) {
            $$$reportNull$$$0(8);
        }
        return str;
    }

    @NotNull
    public FqName getPackageFqName() {
        int lastIndexOf = this.internalName.lastIndexOf("/");
        if (lastIndexOf == -1) {
            FqName fqName = FqName.ROOT;
            if (fqName == null) {
                $$$reportNull$$$0(7);
            }
            return fqName;
        }
        return new FqName(this.internalName.substring(0, lastIndexOf).replace('/', '.'));
    }

    public int hashCode() {
        return this.internalName.hashCode();
    }

    public String toString() {
        return this.internalName;
    }
}
