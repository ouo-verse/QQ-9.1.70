package kotlin.reflect.jvm.internal.impl.name;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ClassId {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean local;
    private final FqName packageFqName;
    private final FqName relativeClassName;

    /* JADX WARN: Removed duplicated region for block: B:14:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 5 && i3 != 6 && i3 != 7 && i3 != 9) {
            switch (i3) {
                case 13:
                case 14:
                case 15:
                case 16:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            if (i3 != 5 && i3 != 6 && i3 != 7 && i3 != 9) {
                switch (i3) {
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                        break;
                    default:
                        i16 = 3;
                        break;
                }
                Object[] objArr = new Object[i16];
                switch (i3) {
                    case 1:
                    case 3:
                        objArr[0] = "packageFqName";
                        break;
                    case 2:
                        objArr[0] = "relativeClassName";
                        break;
                    case 4:
                        objArr[0] = "topLevelName";
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 9:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                        break;
                    case 8:
                        objArr[0] = "name";
                        break;
                    case 10:
                        objArr[0] = "segment";
                        break;
                    case 11:
                    case 12:
                        objArr[0] = HippyControllerProps.STRING;
                        break;
                    default:
                        objArr[0] = "topLevelFqName";
                        break;
                }
                if (i3 == 5) {
                    if (i3 != 6) {
                        if (i3 != 7) {
                            if (i3 != 9) {
                                switch (i3) {
                                    case 13:
                                    case 14:
                                        objArr[1] = "asString";
                                        break;
                                    case 15:
                                    case 16:
                                        objArr[1] = "asFqNameString";
                                        break;
                                    default:
                                        objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                                        break;
                                }
                            } else {
                                objArr[1] = "asSingleFqName";
                            }
                        } else {
                            objArr[1] = "getShortClassName";
                        }
                    } else {
                        objArr[1] = "getRelativeClassName";
                    }
                } else {
                    objArr[1] = "getPackageFqName";
                }
                switch (i3) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        objArr[2] = "<init>";
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 9:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                        break;
                    case 8:
                        objArr[2] = "createNestedClassId";
                        break;
                    case 10:
                        objArr[2] = "startsWith";
                        break;
                    case 11:
                    case 12:
                        objArr[2] = "fromString";
                        break;
                    default:
                        objArr[2] = "topLevel";
                        break;
                }
                String format = String.format(str, objArr);
                if (i3 != 5 && i3 != 6 && i3 != 7 && i3 != 9) {
                    switch (i3) {
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                            break;
                        default:
                            throw new IllegalArgumentException(format);
                    }
                }
                throw new IllegalStateException(format);
            }
            i16 = 2;
            Object[] objArr2 = new Object[i16];
            switch (i3) {
            }
            if (i3 == 5) {
            }
            switch (i3) {
            }
            String format2 = String.format(str, objArr2);
            if (i3 != 5) {
                switch (i3) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i3 != 5) {
            switch (i3) {
            }
            Object[] objArr22 = new Object[i16];
            switch (i3) {
            }
            if (i3 == 5) {
            }
            switch (i3) {
            }
            String format22 = String.format(str, objArr22);
            if (i3 != 5) {
            }
            throw new IllegalStateException(format22);
        }
        i16 = 2;
        Object[] objArr222 = new Object[i16];
        switch (i3) {
        }
        if (i3 == 5) {
        }
        switch (i3) {
        }
        String format222 = String.format(str, objArr222);
        if (i3 != 5) {
        }
        throw new IllegalStateException(format222);
    }

    public ClassId(@NotNull FqName fqName, @NotNull FqName fqName2, boolean z16) {
        if (fqName == null) {
            $$$reportNull$$$0(1);
        }
        if (fqName2 == null) {
            $$$reportNull$$$0(2);
        }
        this.packageFqName = fqName;
        this.relativeClassName = fqName2;
        this.local = z16;
    }

    @NotNull
    public static ClassId fromString(@NotNull String str) {
        if (str == null) {
            $$$reportNull$$$0(11);
        }
        return fromString(str, false);
    }

    @NotNull
    public static ClassId topLevel(@NotNull FqName fqName) {
        if (fqName == null) {
            $$$reportNull$$$0(0);
        }
        return new ClassId(fqName.parent(), fqName.shortName());
    }

    @NotNull
    public FqName asSingleFqName() {
        if (this.packageFqName.isRoot()) {
            FqName fqName = this.relativeClassName;
            if (fqName == null) {
                $$$reportNull$$$0(9);
            }
            return fqName;
        }
        return new FqName(this.packageFqName.asString() + "." + this.relativeClassName.asString());
    }

    @NotNull
    public String asString() {
        if (this.packageFqName.isRoot()) {
            String asString = this.relativeClassName.asString();
            if (asString == null) {
                $$$reportNull$$$0(13);
            }
            return asString;
        }
        String str = this.packageFqName.asString().replace('.', '/') + "/" + this.relativeClassName.asString();
        if (str == null) {
            $$$reportNull$$$0(14);
        }
        return str;
    }

    @NotNull
    public ClassId createNestedClassId(@NotNull Name name) {
        if (name == null) {
            $$$reportNull$$$0(8);
        }
        return new ClassId(getPackageFqName(), this.relativeClassName.child(name), this.local);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ClassId.class != obj.getClass()) {
            return false;
        }
        ClassId classId = (ClassId) obj;
        if (this.packageFqName.equals(classId.packageFqName) && this.relativeClassName.equals(classId.relativeClassName) && this.local == classId.local) {
            return true;
        }
        return false;
    }

    @Nullable
    public ClassId getOuterClassId() {
        FqName parent = this.relativeClassName.parent();
        if (parent.isRoot()) {
            return null;
        }
        return new ClassId(getPackageFqName(), parent, this.local);
    }

    @NotNull
    public FqName getPackageFqName() {
        FqName fqName = this.packageFqName;
        if (fqName == null) {
            $$$reportNull$$$0(5);
        }
        return fqName;
    }

    @NotNull
    public FqName getRelativeClassName() {
        FqName fqName = this.relativeClassName;
        if (fqName == null) {
            $$$reportNull$$$0(6);
        }
        return fqName;
    }

    @NotNull
    public Name getShortClassName() {
        Name shortName = this.relativeClassName.shortName();
        if (shortName == null) {
            $$$reportNull$$$0(7);
        }
        return shortName;
    }

    public int hashCode() {
        return (((this.packageFqName.hashCode() * 31) + this.relativeClassName.hashCode()) * 31) + Boolean.valueOf(this.local).hashCode();
    }

    public boolean isLocal() {
        return this.local;
    }

    public boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    public String toString() {
        if (this.packageFqName.isRoot()) {
            return "/" + asString();
        }
        return asString();
    }

    @NotNull
    public static ClassId fromString(@NotNull String str, boolean z16) {
        String str2;
        if (str == null) {
            $$$reportNull$$$0(12);
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == -1) {
            str2 = "";
        } else {
            String replace = str.substring(0, lastIndexOf).replace('/', '.');
            str = str.substring(lastIndexOf + 1);
            str2 = replace;
        }
        return new ClassId(new FqName(str2), new FqName(str), z16);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClassId(@NotNull FqName fqName, @NotNull Name name) {
        this(fqName, FqName.topLevel(name), false);
        if (fqName == null) {
            $$$reportNull$$$0(3);
        }
        if (name == null) {
            $$$reportNull$$$0(4);
        }
    }
}
