package ko0;

import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import com.tencent.guild.aio.input.at.utils.AtTroopMemberSpan;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {
    public static void a(Editable editable, int i3, SpannableString spannableString) {
        int e16 = e(editable, Math.max(0, i3 - spannableString.length()), i3);
        if (e16 < 0) {
            editable.insert(i3, spannableString);
        } else {
            editable.replace(e16, i3, spannableString);
        }
    }

    public static <T> boolean b(Spanned spanned, int i3, Class<T> cls) {
        Object[] spans;
        if (i3 >= 0 && i3 < spanned.length() && (spans = spanned.getSpans(i3, i3, cls)) != null && spans.length > 0) {
            for (Object obj : spans) {
                int spanStart = spanned.getSpanStart(obj);
                int spanEnd = spanned.getSpanEnd(obj);
                if (i3 >= spanStart && i3 < spanEnd) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(Collection collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public static int d(Editable editable, int i3) {
        return e(editable, 0, i3);
    }

    public static int e(Editable editable, int i3, int i16) {
        return g(editable, 42, 65290, i3, i16);
    }

    public static int f(Spanned spanned, int i3, int i16, int i17) {
        boolean z16;
        String substring = spanned.toString().substring(i16, i17);
        int length = substring.length();
        int i18 = i17 - i16;
        if (i18 > 0 && length > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i19 = -1;
        int i26 = -1;
        for (int i27 = 0; z16 && i27 < length; i27++) {
            i26 = substring.lastIndexOf(i3, i18 - 1);
            int i28 = i26 + i16;
            boolean b16 = b(spanned, i28, AtTroopMemberSpan.class);
            boolean b17 = b(spanned, i28, ReplacementSpan.class);
            if (i26 != -1 && !b16 && b17) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i18 = i26;
            } else if (b16) {
                break;
            }
        }
        i19 = i26;
        if (i19 >= 0) {
            return i19 + i16;
        }
        return i19;
    }

    public static int g(Spanned spanned, int i3, int i16, int i17, int i18) {
        boolean z16;
        String substring = spanned.toString().substring(i17, i18);
        int length = substring.length();
        int i19 = i18 - i17;
        if (i19 > 0 && length > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i26 = -1;
        int i27 = -1;
        for (int i28 = 0; z16 && i28 < length; i28++) {
            int i29 = i19 - 1;
            i27 = Math.max(substring.lastIndexOf(i3, i29), substring.lastIndexOf(i16, i29));
            int i36 = i27 + i17;
            boolean b16 = b(spanned, i36, AtTroopMemberSpan.class);
            boolean b17 = b(spanned, i36, ReplacementSpan.class);
            if (i27 != -1 && !b16 && b17) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i19 = i27;
            } else if (b16) {
                break;
            }
        }
        i26 = i27;
        if (i26 >= 0) {
            return i26 + i17;
        }
        return i26;
    }
}
