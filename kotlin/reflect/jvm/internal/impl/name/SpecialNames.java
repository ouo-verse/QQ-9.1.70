package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class SpecialNames {

    @JvmField
    @NotNull
    public static final Name ANONYMOUS;

    @JvmField
    @NotNull
    public static final Name ARRAY;

    @JvmField
    @NotNull
    public static final Name DEFAULT_NAME_FOR_COMPANION_OBJECT;

    @JvmField
    @NotNull
    public static final Name DESTRUCT;

    @JvmField
    @NotNull
    public static final Name IMPLICIT_SET_PARAMETER;

    @JvmField
    @NotNull
    public static final Name INIT;

    @NotNull
    public static final SpecialNames INSTANCE = new SpecialNames();

    @JvmField
    @NotNull
    public static final Name ITERATOR;

    @JvmField
    @NotNull
    public static final Name LOCAL;

    @JvmField
    @NotNull
    public static final Name NO_NAME_PROVIDED;

    @JvmField
    @NotNull
    public static final Name RECEIVER;

    @JvmField
    @NotNull
    public static final Name ROOT_PACKAGE;

    @JvmField
    @NotNull
    public static final Name SAFE_IDENTIFIER_FOR_NO_NAME;

    @JvmField
    @NotNull
    public static final Name THIS;

    @JvmField
    @NotNull
    public static final Name UNARY;

    @JvmField
    @NotNull
    public static final Name UNARY_RESULT;

    @JvmField
    @NotNull
    public static final Name UNDERSCORE_FOR_UNUSED_VAR;

    static {
        Name special = Name.special("<no name provided>");
        Intrinsics.checkNotNullExpressionValue(special, "special(\"<no name provided>\")");
        NO_NAME_PROVIDED = special;
        Name special2 = Name.special("<root package>");
        Intrinsics.checkNotNullExpressionValue(special2, "special(\"<root package>\")");
        ROOT_PACKAGE = special2;
        Name identifier = Name.identifier("Companion");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"Companion\")");
        DEFAULT_NAME_FOR_COMPANION_OBJECT = identifier;
        Name identifier2 = Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"no_name_in_P\u2026_4cd0_b7f5_b46aa3cd5d40\")");
        SAFE_IDENTIFIER_FOR_NO_NAME = identifier2;
        Name special3 = Name.special("<anonymous>");
        Intrinsics.checkNotNullExpressionValue(special3, "special(ANONYMOUS_STRING)");
        ANONYMOUS = special3;
        Name special4 = Name.special("<unary>");
        Intrinsics.checkNotNullExpressionValue(special4, "special(\"<unary>\")");
        UNARY = special4;
        Name special5 = Name.special("<unary-result>");
        Intrinsics.checkNotNullExpressionValue(special5, "special(\"<unary-result>\")");
        UNARY_RESULT = special5;
        Name special6 = Name.special("<this>");
        Intrinsics.checkNotNullExpressionValue(special6, "special(\"<this>\")");
        THIS = special6;
        Name special7 = Name.special("<init>");
        Intrinsics.checkNotNullExpressionValue(special7, "special(\"<init>\")");
        INIT = special7;
        Name special8 = Name.special("<iterator>");
        Intrinsics.checkNotNullExpressionValue(special8, "special(\"<iterator>\")");
        ITERATOR = special8;
        Name special9 = Name.special("<destruct>");
        Intrinsics.checkNotNullExpressionValue(special9, "special(\"<destruct>\")");
        DESTRUCT = special9;
        Name special10 = Name.special("<local>");
        Intrinsics.checkNotNullExpressionValue(special10, "special(\"<local>\")");
        LOCAL = special10;
        Name special11 = Name.special("<unused var>");
        Intrinsics.checkNotNullExpressionValue(special11, "special(\"<unused var>\")");
        UNDERSCORE_FOR_UNUSED_VAR = special11;
        Name special12 = Name.special("<set-?>");
        Intrinsics.checkNotNullExpressionValue(special12, "special(\"<set-?>\")");
        IMPLICIT_SET_PARAMETER = special12;
        Name special13 = Name.special("<array>");
        Intrinsics.checkNotNullExpressionValue(special13, "special(\"<array>\")");
        ARRAY = special13;
        Name special14 = Name.special("<receiver>");
        Intrinsics.checkNotNullExpressionValue(special14, "special(\"<receiver>\")");
        RECEIVER = special14;
    }

    SpecialNames() {
    }

    @JvmStatic
    @NotNull
    public static final Name safeIdentifier(@Nullable Name name) {
        if (name == null || name.isSpecial()) {
            return SAFE_IDENTIFIER_FOR_NO_NAME;
        }
        return name;
    }

    public final boolean isSafeIdentifier(@NotNull Name name) {
        boolean z16;
        Intrinsics.checkNotNullParameter(name, "name");
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        if (asString.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !name.isSpecial()) {
            return true;
        }
        return false;
    }
}
