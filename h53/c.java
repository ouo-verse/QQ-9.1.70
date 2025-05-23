package h53;

import android.text.Spannable;
import android.text.style.ReplacementSpan;
import android.util.SparseArray;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.mobileqq.text.QQText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lh53/c;", "", "", "text", "Lh53/e;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "Lh53/d;", "a", "Landroid/text/Spannable;", "spannable", "Landroid/util/SparseArray;", "Lh53/v;", "c", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "b", "Ljava/util/regex/Pattern;", "extraEmoji", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f404346a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Pattern extraEmoji = Pattern.compile("[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]|[\\ud83e\\udc00-\\ud83e\\udfff]|[\\ud83f\\udc00-\\ud83f\\udfff]");

    c() {
    }

    @JvmStatic
    @NotNull
    public static final CharacterCountInfo a(@Nullable CharSequence text, @NotNull QUIInputCountCalculateStrategy strategy) {
        int length;
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        AsciiHalfCharacterCounter asciiHalfCharacterCounter = new AsciiHalfCharacterCounter(0, 0, 0, 0, false, strategy, 31, null);
        if (text != null) {
            SparseArray<SpanPair> c16 = f404346a.c(new QQText(text, 3), text);
            int i3 = 0;
            while (i3 < text.length()) {
                int indexOfKey = c16.indexOfKey(i3);
                if (indexOfKey >= 0) {
                    SpanPair valueAt = c16.valueAt(indexOfKey);
                    Intrinsics.checkNotNullExpressionValue(valueAt, "lookups.valueAt(spanIndex)");
                    SpanPair spanPair = valueAt;
                    i3 += spanPair.getEnd() - spanPair.getStart();
                    asciiHalfCharacterCounter.b(spanPair);
                } else {
                    int i16 = (-indexOfKey) - 1;
                    if (i16 < c16.size()) {
                        length = c16.valueAt(i16).getStart();
                    } else {
                        length = text.length();
                    }
                    asciiHalfCharacterCounter.c(text, i3, length);
                    i3 += length - i3;
                }
            }
        }
        return asciiHalfCharacterCounter.h();
    }

    public static /* synthetic */ CharacterCountInfo b(CharSequence charSequence, QUIInputCountCalculateStrategy qUIInputCountCalculateStrategy, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            qUIInputCountCalculateStrategy = new QUIInputCountCalculateStrategy(0.0d, 0.0d, 0.0d, 0.0d, 15, null);
        }
        return a(charSequence, qUIInputCountCalculateStrategy);
    }

    @NotNull
    public final SparseArray<SpanPair> c(@NotNull Spannable spannable, @NotNull CharSequence text) {
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        Intrinsics.checkNotNullParameter(text, "text");
        SparseArray<SpanPair> sparseArray = new SparseArray<>();
        Object[] allSpans = spannable.getSpans(0, spannable.length(), Object.class);
        Intrinsics.checkNotNullExpressionValue(allSpans, "allSpans");
        int i3 = 0;
        for (Object obj : allSpans) {
            if (obj instanceof ReplacementSpan) {
                SpanPair a16 = SpanPair.INSTANCE.a(spannable, obj);
                sparseArray.append(a16.getStart(), a16);
                if (a16.getStart() > i3) {
                    Matcher matcher = extraEmoji.matcher(text.subSequence(i3, a16.getStart()));
                    while (matcher.find()) {
                        int start = matcher.start() + i3;
                        if (sparseArray.indexOfKey(start) < 0) {
                            sparseArray.append(start, new SpanPair(start, matcher.end() + i3, 0));
                        }
                    }
                }
                i3 = Math.max(i3, a16.getEnd());
            }
        }
        if (text.length() > i3) {
            Matcher matcher2 = extraEmoji.matcher(text.subSequence(i3, text.length()));
            while (matcher2.find()) {
                int start2 = matcher2.start() + i3;
                if (sparseArray.indexOfKey(start2) < 0) {
                    sparseArray.append(start2, new SpanPair(start2, matcher2.end() + i3, 0));
                }
            }
        }
        return sparseArray;
    }
}
