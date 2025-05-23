package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
@SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public final class HtmlCompat {
    public static final int FROM_HTML_MODE_COMPACT = 63;
    public static final int FROM_HTML_MODE_LEGACY = 0;
    public static final int FROM_HTML_OPTION_USE_CSS_COLORS = 256;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_BLOCKQUOTE = 32;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_DIV = 16;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_HEADING = 2;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST = 8;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST_ITEM = 4;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH = 1;
    public static final int TO_HTML_PARAGRAPH_LINES_CONSECUTIVE = 0;
    public static final int TO_HTML_PARAGRAPH_LINES_INDIVIDUAL = 1;

    HtmlCompat() {
    }

    @NonNull
    public static Spanned fromHtml(@NonNull String str, int i3) {
        Spanned fromHtml;
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(str, i3);
            return fromHtml;
        }
        return Html.fromHtml(str);
    }

    @NonNull
    public static String toHtml(@NonNull Spanned spanned, int i3) {
        String html;
        if (Build.VERSION.SDK_INT >= 24) {
            html = Html.toHtml(spanned, i3);
            return html;
        }
        return Html.toHtml(spanned);
    }

    @NonNull
    public static Spanned fromHtml(@NonNull String str, int i3, @Nullable Html.ImageGetter imageGetter, @Nullable Html.TagHandler tagHandler) {
        Spanned fromHtml;
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(str, i3, imageGetter, tagHandler);
            return fromHtml;
        }
        return Html.fromHtml(str, imageGetter, tagHandler);
    }
}
