package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class CapitalizeDecapitalizeKt {
    @NotNull
    public static final String capitalizeAsciiOnly(@NotNull String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean z17 = false;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && charAt < '{') {
            z17 = true;
        }
        if (z17) {
            char upperCase = Character.toUpperCase(charAt);
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return upperCase + substring;
        }
        return str;
    }

    @NotNull
    public static final String decapitalizeAsciiOnly(@NotNull String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean z17 = false;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('A' <= charAt && charAt < '[') {
            z17 = true;
        }
        if (z17) {
            char lowerCase = Character.toLowerCase(charAt);
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return lowerCase + substring;
        }
        return str;
    }

    @NotNull
    public static final String decapitalizeSmartForCompiler(@NotNull String str, boolean z16) {
        boolean z17;
        boolean z18;
        IntRange indices;
        Integer num;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17 && isUpperCaseCharAt(str, 0, z16)) {
            if (str.length() != 1 && isUpperCaseCharAt(str, 1, z16)) {
                indices = StringsKt__StringsKt.getIndices(str);
                Iterator<Integer> it = indices.iterator();
                while (true) {
                    if (it.hasNext()) {
                        num = it.next();
                        if (!isUpperCaseCharAt(str, num.intValue(), z16)) {
                            break;
                        }
                    } else {
                        num = null;
                        break;
                    }
                }
                Integer num2 = num;
                if (num2 != null) {
                    int intValue = num2.intValue() - 1;
                    StringBuilder sb5 = new StringBuilder();
                    String substring = str.substring(0, intValue);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    sb5.append(toLowerCase(substring, z16));
                    String substring2 = str.substring(intValue);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    sb5.append(substring2);
                    return sb5.toString();
                }
                return toLowerCase(str, z16);
            }
            if (z16) {
                return decapitalizeAsciiOnly(str);
            }
            if (str.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                char lowerCase = Character.toLowerCase(str.charAt(0));
                String substring3 = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                return lowerCase + substring3;
            }
            return str;
        }
        return str;
    }

    private static final boolean isUpperCaseCharAt(String str, int i3, boolean z16) {
        char charAt = str.charAt(i3);
        if (z16) {
            if ('A' > charAt || charAt >= '[') {
                return false;
            }
            return true;
        }
        return Character.isUpperCase(charAt);
    }

    private static final String toLowerCase(String str, boolean z16) {
        if (z16) {
            return toLowerCaseAsciiOnly(str);
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @NotNull
    public static final String toLowerCaseAsciiOnly(@NotNull String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb5 = new StringBuilder(str.length());
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if ('A' <= charAt && charAt < '[') {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                charAt = Character.toLowerCase(charAt);
            }
            sb5.append(charAt);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
        return sb6;
    }
}
