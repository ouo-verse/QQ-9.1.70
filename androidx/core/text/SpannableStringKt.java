package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a%\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\u001d\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\r\u0010\u000b\u001a\u00020\u0002*\u00020\fH\u0086\b\u00a8\u0006\r"}, d2 = {"clearSpans", "", "Landroid/text/Spannable;", "set", "start", "", "end", TtmlNode.TAG_SPAN, "", DownloaderConstant.KEY_RANGE, "Lkotlin/ranges/IntRange;", "toSpannable", "", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class SpannableStringKt {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(@NotNull Spannable clearSpans) {
        Intrinsics.checkNotNullParameter(clearSpans, "$this$clearSpans");
        Object[] spans = clearSpans.getSpans(0, clearSpans.length(), Object.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            clearSpans.removeSpan(obj);
        }
    }

    public static final void set(@NotNull Spannable set, int i3, int i16, @NotNull Object span) {
        Intrinsics.checkNotNullParameter(set, "$this$set");
        Intrinsics.checkNotNullParameter(span, "span");
        set.setSpan(span, i3, i16, 17);
    }

    @NotNull
    public static final Spannable toSpannable(@NotNull CharSequence toSpannable) {
        Intrinsics.checkNotNullParameter(toSpannable, "$this$toSpannable");
        SpannableString valueOf = SpannableString.valueOf(toSpannable);
        Intrinsics.checkNotNullExpressionValue(valueOf, "SpannableString.valueOf(this)");
        return valueOf;
    }

    public static final void set(@NotNull Spannable set, @NotNull IntRange range, @NotNull Object span) {
        Intrinsics.checkNotNullParameter(set, "$this$set");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(span, "span");
        set.setSpan(span, range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
    }
}
