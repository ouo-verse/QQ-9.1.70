package androidx.core.view.inputmethod;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Preconditions;

/* compiled from: P */
/* loaded from: classes.dex */
public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;

    @VisibleForTesting
    static final int MAX_INITIAL_SELECTION_LENGTH = 1024;

    @VisibleForTesting
    static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class Impl30 {
        Impl30() {
        }

        static CharSequence getInitialSelectedText(@NonNull EditorInfo editorInfo, int i3) {
            CharSequence initialSelectedText;
            initialSelectedText = editorInfo.getInitialSelectedText(i3);
            return initialSelectedText;
        }

        static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo editorInfo, int i3, int i16) {
            CharSequence initialTextAfterCursor;
            initialTextAfterCursor = editorInfo.getInitialTextAfterCursor(i3, i16);
            return initialTextAfterCursor;
        }

        static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo editorInfo, int i3, int i16) {
            CharSequence initialTextBeforeCursor;
            initialTextBeforeCursor = editorInfo.getInitialTextBeforeCursor(i3, i16);
            return initialTextBeforeCursor;
        }

        static void setInitialSurroundingSubText(@NonNull EditorInfo editorInfo, CharSequence charSequence, int i3) {
            editorInfo.setInitialSurroundingSubText(charSequence, i3);
        }
    }

    @Deprecated
    public EditorInfoCompat() {
    }

    @NonNull
    public static String[] getContentMimeTypes(EditorInfo editorInfo) {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 25) {
            strArr = editorInfo.contentMimeTypes;
            if (strArr == null) {
                return EMPTY_STRING_ARRAY;
            }
            return strArr;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return EMPTY_STRING_ARRAY;
        }
        String[] stringArray = bundle.getStringArray(CONTENT_MIME_TYPES_KEY);
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
        }
        if (stringArray == null) {
            return EMPTY_STRING_ARRAY;
        }
        return stringArray;
    }

    @Nullable
    public static CharSequence getInitialSelectedText(@NonNull EditorInfo editorInfo, int i3) {
        int i16;
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Impl30.getInitialSelectedText(editorInfo, i3);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return null;
        }
        int i17 = editorInfo.initialSelStart;
        int i18 = editorInfo.initialSelEnd;
        if (i17 > i18) {
            i16 = i18;
        } else {
            i16 = i17;
        }
        if (i17 <= i18) {
            i17 = i18;
        }
        int i19 = bundle.getInt(CONTENT_SELECTION_HEAD_KEY);
        int i26 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int i27 = i17 - i16;
        if (editorInfo.initialSelStart < 0 || editorInfo.initialSelEnd < 0 || i26 - i19 != i27 || (charSequence = editorInfo.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        if ((i3 & 1) != 0) {
            return charSequence.subSequence(i19, i26);
        }
        return TextUtils.substring(charSequence, i19, i26);
    }

    @Nullable
    public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo editorInfo, int i3, int i16) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Impl30.getInitialTextAfterCursor(editorInfo, i3, i16);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i17 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
        int min = Math.min(i3, charSequence.length() - i17);
        if ((i16 & 1) != 0) {
            return charSequence.subSequence(i17, min + i17);
        }
        return TextUtils.substring(charSequence, i17, min + i17);
    }

    @Nullable
    public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo editorInfo, int i3, int i16) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Impl30.getInitialTextBeforeCursor(editorInfo, i3, i16);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
            return null;
        }
        int i17 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
        int min = Math.min(i3, i17);
        if ((i16 & 1) != 0) {
            return charSequence.subSequence(i17 - min, i17);
        }
        return TextUtils.substring(charSequence, i17 - min, i17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getProtocol(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            return 1;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return 0;
        }
        boolean containsKey = bundle.containsKey(CONTENT_MIME_TYPES_KEY);
        boolean containsKey2 = editorInfo.extras.containsKey(CONTENT_MIME_TYPES_INTEROP_KEY);
        if (containsKey && containsKey2) {
            return 4;
        }
        if (containsKey) {
            return 3;
        }
        if (!containsKey2) {
            return 0;
        }
        return 2;
    }

    private static boolean isCutOnSurrogate(CharSequence charSequence, int i3, int i16) {
        if (i16 != 0) {
            if (i16 != 1) {
                return false;
            }
            return Character.isHighSurrogate(charSequence.charAt(i3));
        }
        return Character.isLowSurrogate(charSequence.charAt(i3));
    }

    private static boolean isPasswordInputType(int i3) {
        int i16 = i3 & 4095;
        if (i16 != 129 && i16 != 225 && i16 != 18) {
            return false;
        }
        return true;
    }

    public static void setContentMimeTypes(@NonNull EditorInfo editorInfo, @Nullable String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_KEY, strArr);
        editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_INTEROP_KEY, strArr);
    }

    public static void setInitialSurroundingSubText(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence, int i3) {
        int i16;
        int i17;
        Preconditions.checkNotNull(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.setInitialSurroundingSubText(editorInfo, charSequence, i3);
            return;
        }
        int i18 = editorInfo.initialSelStart;
        int i19 = editorInfo.initialSelEnd;
        if (i18 > i19) {
            i16 = i19 - i3;
        } else {
            i16 = i18 - i3;
        }
        if (i18 > i19) {
            i17 = i18 - i3;
        } else {
            i17 = i19 - i3;
        }
        int length = charSequence.length();
        if (i3 >= 0 && i16 >= 0 && i17 <= length) {
            if (isPasswordInputType(editorInfo.inputType)) {
                setSurroundingText(editorInfo, null, 0, 0);
                return;
            } else if (length <= 2048) {
                setSurroundingText(editorInfo, charSequence, i16, i17);
                return;
            } else {
                trimLongSurroundingText(editorInfo, charSequence, i16, i17);
                return;
            }
        }
        setSurroundingText(editorInfo, null, 0, 0);
    }

    public static void setInitialSurroundingText(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.setInitialSurroundingSubText(editorInfo, charSequence, 0);
        } else {
            setInitialSurroundingSubText(editorInfo, charSequence, 0);
        }
    }

    private static void setSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i3, int i16) {
        SpannableStringBuilder spannableStringBuilder;
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        if (charSequence != null) {
            spannableStringBuilder = new SpannableStringBuilder(charSequence);
        } else {
            spannableStringBuilder = null;
        }
        editorInfo.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, spannableStringBuilder);
        editorInfo.extras.putInt(CONTENT_SELECTION_HEAD_KEY, i3);
        editorInfo.extras.putInt(CONTENT_SELECTION_END_KEY, i16);
    }

    private static void trimLongSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i3, int i16) {
        int i17;
        CharSequence subSequence;
        int i18 = i16 - i3;
        if (i18 > 1024) {
            i17 = 0;
        } else {
            i17 = i18;
        }
        int i19 = 2048 - i17;
        int min = Math.min(charSequence.length() - i16, i19 - Math.min(i3, (int) (i19 * 0.8d)));
        int min2 = Math.min(i3, i19 - min);
        int i26 = i3 - min2;
        if (isCutOnSurrogate(charSequence, i26, 0)) {
            i26++;
            min2--;
        }
        if (isCutOnSurrogate(charSequence, (i16 + min) - 1, 1)) {
            min--;
        }
        int i27 = min2 + i17 + min;
        if (i17 != i18) {
            subSequence = TextUtils.concat(charSequence.subSequence(i26, i26 + min2), charSequence.subSequence(i16, min + i16));
        } else {
            subSequence = charSequence.subSequence(i26, i27 + i26);
        }
        int i28 = min2 + 0;
        setSurroundingText(editorInfo, subSequence, i28, i17 + i28);
    }
}
