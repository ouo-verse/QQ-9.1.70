package kotlin.reflect.jvm.internal.impl.name;

import com.tencent.ecommerce.base.report.api.IECDtReport;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class Name implements Comparable<Name> {

    @NotNull
    private final String name;
    private final boolean special;

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            i16 = 3;
        } else {
            i16 = 2;
        }
        Object[] objArr = new Object[i16];
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            objArr[0] = "name";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3 && i3 != 4) {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
                } else {
                    objArr[1] = "asStringStripSpecialMarkers";
                }
            } else {
                objArr[1] = "getIdentifier";
            }
        } else {
            objArr[1] = "asString";
        }
        switch (i3) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = IECDtReport.ACTION_IDENTIFIER;
                break;
            case 6:
                objArr[2] = "isValidIdentifier";
                break;
            case 7:
                objArr[2] = "special";
                break;
            case 8:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
            throw new IllegalStateException(format);
        }
    }

    Name(@NotNull String str, boolean z16) {
        if (str == null) {
            $$$reportNull$$$0(0);
        }
        this.name = str;
        this.special = z16;
    }

    @NotNull
    public static Name guessByFirstCharacter(@NotNull String str) {
        if (str == null) {
            $$$reportNull$$$0(8);
        }
        if (str.startsWith("<")) {
            return special(str);
        }
        return identifier(str);
    }

    @NotNull
    public static Name identifier(@NotNull String str) {
        if (str == null) {
            $$$reportNull$$$0(5);
        }
        return new Name(str, false);
    }

    public static boolean isValidIdentifier(@NotNull String str) {
        if (str == null) {
            $$$reportNull$$$0(6);
        }
        if (str.isEmpty() || str.startsWith("<")) {
            return false;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '.' || charAt == '/' || charAt == '\\') {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static Name special(@NotNull String str) {
        if (str == null) {
            $$$reportNull$$$0(7);
        }
        if (str.startsWith("<")) {
            return new Name(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    @NotNull
    public String asString() {
        String str = this.name;
        if (str == null) {
            $$$reportNull$$$0(1);
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        if (this.special == name.special && this.name.equals(name.name)) {
            return true;
        }
        return false;
    }

    @NotNull
    public String getIdentifier() {
        if (!this.special) {
            String asString = asString();
            if (asString == null) {
                $$$reportNull$$$0(2);
            }
            return asString;
        }
        throw new IllegalStateException("not identifier: " + this);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + (this.special ? 1 : 0);
    }

    public boolean isSpecial() {
        return this.special;
    }

    public String toString() {
        return this.name;
    }

    @Override // java.lang.Comparable
    public int compareTo(Name name) {
        return this.name.compareTo(name.name);
    }
}
