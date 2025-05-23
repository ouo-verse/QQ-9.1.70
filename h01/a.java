package h01;

import android.text.InputFilter;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.util.SparseArray;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.kuikly.core.render.android.expand.component.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import d01.m;
import d01.u;
import d01.y;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0005%\u0007&\u0010\u0013B5\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001a\u00a2\u0006\u0004\b\"\u0010#J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J>\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001d\u00a8\u0006'"}, d2 = {"Lh01/a;", "Landroid/text/InputFilter;", "", "text", "", "start", "charLimit", "b", "source", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "Lh01/a$d;", "d", "Lh01/a$d;", "calculateStrategy", "e", "I", "maxLength", "Lcom/tencent/kuikly/core/render/android/a;", "f", "Lcom/tencent/kuikly/core/render/android/a;", "kuiklyRenderContext", "Lkotlin/Function0;", "", h.F, "Lkotlin/jvm/functions/Function0;", "fontSizeGetter", "", "i", "textLengthBeyondLimitCallback", "<init>", "(ILcom/tencent/kuikly/core/render/android/a;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "c", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a implements InputFilter {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f403988m = Pattern.compile("[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]|[\\ud83e\\udc00-\\ud83e\\udfff]|[\\ud83f\\udc00-\\ud83f\\udfff]");

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CountCalculateStrategy calculateStrategy;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int maxLength;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.render.android.a kuiklyRenderContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Function0<Float> fontSizeGetter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> textLengthBeyondLimitCallback;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010#\u001a\u00020\u000b\u0012\b\b\u0002\u0010&\u001a\u00020\u000b\u0012\b\b\u0002\u0010)\u001a\u00020\u000b\u0012\b\b\u0002\u0010,\u001a\u00020\u000b\u0012\b\b\u0002\u00101\u001a\u00020\u0004\u0012\u0006\u00108\u001a\u000202\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0007J&\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0017J\t\u0010\u001a\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010#\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010&\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\"\u0010)\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\"\u0010,\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010-\u001a\u0004\b\r\u0010.\"\u0004\b/\u00100R\"\u00108\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006;"}, d2 = {"Lh01/a$a;", "", "", "character", "", "j", "d", "", "i", "", "str", "", ReportConstant.COSTREPORT_PREFIX, "e", "limit", "g", "", "a", "Lh01/a$e;", TtmlNode.TAG_SPAN, "b", "c", "f", "Lh01/a$b;", h.F, "", "toString", "hashCode", "other", "equals", "I", "getEmojiCount", "()I", "setEmojiCount", "(I)V", "emojiCount", "getReplacementCount", "setReplacementCount", "replacementCount", "getMAsciiCount", "setMAsciiCount", "mAsciiCount", "getMNonAsciiCount", "setMNonAsciiCount", "mNonAsciiCount", "Z", "()Z", "setLimit", "(Z)V", "isLimit", "Lh01/a$d;", "Lh01/a$d;", "getStrategy", "()Lh01/a$d;", "setStrategy", "(Lh01/a$d;)V", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "<init>", "(IIIIZLh01/a$d;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: h01.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes7.dex */
    public static final /* data */ class AsciiHalfCharacterCounter {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int emojiCount;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int replacementCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int mAsciiCount;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int mNonAsciiCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isLimit;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private CountCalculateStrategy strategy;

        public AsciiHalfCharacterCounter(int i3, int i16, int i17, int i18, boolean z16, @NotNull CountCalculateStrategy strategy) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            this.emojiCount = i3;
            this.replacementCount = i16;
            this.mAsciiCount = i17;
            this.mNonAsciiCount = i18;
            this.isLimit = z16;
            this.strategy = strategy;
        }

        private final boolean d(char character) {
            if (character >= '\u0080') {
                return true;
            }
            return false;
        }

        private final boolean j(char character) {
            if (d(character)) {
                this.isLimit = true;
                return false;
            }
            if (character < '\u0080') {
                this.mAsciiCount++;
            } else {
                this.mNonAsciiCount++;
            }
            return true;
        }

        public final void a(char character) {
            if (character < '\u0080') {
                this.mAsciiCount++;
            } else {
                this.mNonAsciiCount++;
            }
        }

        public final void b(@NotNull SpanPair span) {
            Intrinsics.checkNotNullParameter(span, "span");
            if (span.getType() == 1) {
                this.emojiCount++;
            } else {
                this.replacementCount++;
            }
        }

        public final void c(@NotNull CharSequence str, int s16, int e16) {
            Intrinsics.checkNotNullParameter(str, "str");
            while (s16 < e16) {
                a(str.charAt(s16));
                s16++;
            }
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsLimit() {
            return this.isLimit;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof AsciiHalfCharacterCounter) {
                    AsciiHalfCharacterCounter asciiHalfCharacterCounter = (AsciiHalfCharacterCounter) other;
                    if (this.emojiCount != asciiHalfCharacterCounter.emojiCount || this.replacementCount != asciiHalfCharacterCounter.replacementCount || this.mAsciiCount != asciiHalfCharacterCounter.mAsciiCount || this.mNonAsciiCount != asciiHalfCharacterCounter.mNonAsciiCount || this.isLimit != asciiHalfCharacterCounter.isLimit || !Intrinsics.areEqual(this.strategy, asciiHalfCharacterCounter.strategy)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public final int f(@NotNull SpanPair span, float limit) {
            Intrinsics.checkNotNullParameter(span, "span");
            if (limit < 1) {
                this.isLimit = true;
                return 0;
            }
            b(span);
            return span.getEnd() - span.getStart();
        }

        public final int g(@NotNull CharSequence str, int s16, int e16, float limit) {
            Intrinsics.checkNotNullParameter(str, "str");
            float i3 = i() + limit;
            int i16 = s16;
            while (true) {
                if (i16 >= e16 || limit <= 0) {
                    break;
                }
                if (limit >= 1) {
                    a(str.charAt(i16));
                    i16++;
                } else {
                    if (!j(str.charAt(i16))) {
                        this.isLimit = true;
                        break;
                    }
                    i16++;
                }
                limit = i3 - i();
            }
            if (limit <= 0) {
                this.isLimit = true;
            }
            return i16 - s16;
        }

        @NotNull
        public final CharacterCountInfo h() {
            return new CharacterCountInfo(this.emojiCount, this.replacementCount, this.mAsciiCount, this.mNonAsciiCount);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3;
            int i16 = ((((((this.emojiCount * 31) + this.replacementCount) * 31) + this.mAsciiCount) * 31) + this.mNonAsciiCount) * 31;
            boolean z16 = this.isLimit;
            int i17 = z16;
            if (z16 != 0) {
                i17 = 1;
            }
            int i18 = (i16 + i17) * 31;
            CountCalculateStrategy countCalculateStrategy = this.strategy;
            if (countCalculateStrategy != null) {
                i3 = countCalculateStrategy.hashCode();
            } else {
                i3 = 0;
            }
            return i18 + i3;
        }

        public final float i() {
            return (float) ((this.emojiCount * this.strategy.getEmojiCount()) + (this.replacementCount * this.strategy.getEmoticonCount()) + (this.mNonAsciiCount * this.strategy.getTextCount()) + (this.mAsciiCount * this.strategy.getAsciiCount()));
        }

        @NotNull
        public String toString() {
            return "AsciiHalfCharacterCounter(emojiCount=" + this.emojiCount + ", replacementCount=" + this.replacementCount + ", mAsciiCount=" + this.mAsciiCount + ", mNonAsciiCount=" + this.mNonAsciiCount + ", isLimit=" + this.isLimit + ", strategy=" + this.strategy + ")";
        }

        public /* synthetic */ AsciiHalfCharacterCounter(int i3, int i16, int i17, int i18, boolean z16, CountCalculateStrategy countCalculateStrategy, int i19, DefaultConstructorMarker defaultConstructorMarker) {
            this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? 0 : i16, (i19 & 4) != 0 ? 0 : i17, (i19 & 8) != 0 ? 0 : i18, (i19 & 16) != 0 ? false : z16, countCalculateStrategy);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010\u00a8\u0006 "}, d2 = {"Lh01/a$b;", "", "Lh01/a$d;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "", "a", "", "toString", "hashCode", "other", "", "equals", "I", "getEmojiCount", "()I", "setEmojiCount", "(I)V", "emojiCount", "b", "getEmoticonCount", "setEmoticonCount", "emoticonCount", "c", "getAsciiCount", "setAsciiCount", "asciiCount", "d", "getTextCount", "setTextCount", "textCount", "<init>", "(IIII)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: h01.a$b, reason: from toString */
    /* loaded from: classes7.dex */
    public static final /* data */ class CharacterCountInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int emojiCount;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int emoticonCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int asciiCount;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int textCount;

        public CharacterCountInfo() {
            this(0, 0, 0, 0, 15, null);
        }

        public final int a(@NotNull CountCalculateStrategy strategy) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            return (int) (Math.ceil(this.emojiCount * strategy.getEmojiCount()) + Math.ceil(this.emoticonCount * strategy.getEmoticonCount()) + Math.ceil(this.textCount * strategy.getTextCount()) + Math.ceil(this.asciiCount * strategy.getAsciiCount()));
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof CharacterCountInfo) {
                    CharacterCountInfo characterCountInfo = (CharacterCountInfo) other;
                    if (this.emojiCount != characterCountInfo.emojiCount || this.emoticonCount != characterCountInfo.emoticonCount || this.asciiCount != characterCountInfo.asciiCount || this.textCount != characterCountInfo.textCount) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((((this.emojiCount * 31) + this.emoticonCount) * 31) + this.asciiCount) * 31) + this.textCount;
        }

        @NotNull
        public String toString() {
            return "CharacterCountInfo(emojiCount=" + this.emojiCount + ", emoticonCount=" + this.emoticonCount + ", asciiCount=" + this.asciiCount + ", textCount=" + this.textCount + ")";
        }

        public CharacterCountInfo(int i3, int i16, int i17, int i18) {
            this.emojiCount = i3;
            this.emoticonCount = i16;
            this.asciiCount = i17;
            this.textCount = i18;
        }

        public /* synthetic */ CharacterCountInfo(int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
            this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? 0 : i16, (i19 & 4) != 0 ? 0 : i17, (i19 & 8) != 0 ? 0 : i18);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J)\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lh01/a$c;", "", "", "text", "Landroid/util/SparseArray;", "Lh01/a$e;", "d", TtmlNode.ATTR_TTS_ORIGIN, "Lcom/tencent/kuikly/core/render/android/a;", "kuiklyRenderContext", "", "fontSize", "c", "(Ljava/lang/CharSequence;Lcom/tencent/kuikly/core/render/android/a;F)Ljava/lang/CharSequence;", "Lh01/a$d;", "calculateStrategy", "Lh01/a$b;", "b", "(Ljava/lang/CharSequence;Lh01/a$d;)Lh01/a$b;", "", "e", "(Ljava/lang/CharSequence;)I", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "extraEmoji", "Ljava/util/regex/Pattern;", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: h01.a$c, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SparseArray<SpanPair> d(CharSequence text) {
            SparseArray<SpanPair> sparseArray = new SparseArray<>();
            if (text instanceof Spannable) {
                int i3 = 0;
                for (Object obj : ((Spannable) text).getSpans(0, text.length(), Object.class)) {
                    if (obj instanceof ReplacementSpan) {
                        SpanPair a16 = SpanPair.INSTANCE.a((Spannable) text, obj, 2);
                        sparseArray.append(a16.getStart(), a16);
                        i3 = Math.max(i3, a16.getEnd());
                    }
                }
            }
            Matcher matcher = a.f403988m.matcher(text);
            while (matcher.find()) {
                int start = matcher.start();
                if (sparseArray.indexOfKey(start) < 0) {
                    sparseArray.append(start, new SpanPair(start, matcher.end(), 1));
                }
            }
            return sparseArray;
        }

        @NotNull
        public final CharacterCountInfo b(@NotNull CharSequence text, @NotNull CountCalculateStrategy calculateStrategy) {
            int length;
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(calculateStrategy, "calculateStrategy");
            AsciiHalfCharacterCounter asciiHalfCharacterCounter = new AsciiHalfCharacterCounter(0, 0, 0, 0, false, calculateStrategy, 31, null);
            SparseArray<SpanPair> d16 = d(text);
            int i3 = 0;
            while (i3 < text.length()) {
                int indexOfKey = d16.indexOfKey(i3);
                if (indexOfKey >= 0) {
                    SpanPair valueAt = d16.valueAt(indexOfKey);
                    Intrinsics.checkNotNullExpressionValue(valueAt, "lookups.valueAt(spanIndex)");
                    SpanPair spanPair = valueAt;
                    i3 += spanPair.getEnd() - spanPair.getStart();
                    asciiHalfCharacterCounter.b(spanPair);
                } else {
                    int i16 = (-indexOfKey) - 1;
                    if (i16 < d16.size()) {
                        length = d16.valueAt(i16).getStart();
                    } else {
                        length = text.length();
                    }
                    asciiHalfCharacterCounter.c(text, i3, length);
                    i3 += length - i3;
                }
            }
            return asciiHalfCharacterCounter.h();
        }

        @NotNull
        public final CharSequence c(@NotNull CharSequence origin, @Nullable com.tencent.kuikly.core.render.android.a kuiklyRenderContext, float fontSize) {
            Intrinsics.checkNotNullParameter(origin, "origin");
            m j3 = u.f392615m.j();
            if (j3 != null) {
                d dVar = new d(kuiklyRenderContext);
                dVar.D("fontSize", Float.valueOf(fontSize));
                return j3.a(kuiklyRenderContext, new y("input", origin, dVar)).getText();
            }
            return origin;
        }

        public final int e(@NotNull CharSequence text) {
            Intrinsics.checkNotNullParameter(text, "text");
            CountCalculateStrategy countCalculateStrategy = new CountCalculateStrategy(0.0d, 0.0d, 0.0d, 0.0d, 15, null);
            return b(text, countCalculateStrategy).a(countCalculateStrategy);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0014\u0010\u000fR\"\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lh01/a$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "D", "b", "()D", "setEmojiCount", "(D)V", "emojiCount", "c", "setEmoticonCount", "emoticonCount", "setAsciiCount", "asciiCount", "d", "setTextCount", "textCount", "<init>", "(DDDD)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: h01.a$d, reason: from toString */
    /* loaded from: classes7.dex */
    public static final /* data */ class CountCalculateStrategy {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private double emojiCount;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private double emoticonCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private double asciiCount;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private double textCount;

        public CountCalculateStrategy() {
            this(0.0d, 0.0d, 0.0d, 0.0d, 15, null);
        }

        /* renamed from: a, reason: from getter */
        public final double getAsciiCount() {
            return this.asciiCount;
        }

        /* renamed from: b, reason: from getter */
        public final double getEmojiCount() {
            return this.emojiCount;
        }

        /* renamed from: c, reason: from getter */
        public final double getEmoticonCount() {
            return this.emoticonCount;
        }

        /* renamed from: d, reason: from getter */
        public final double getTextCount() {
            return this.textCount;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof CountCalculateStrategy) {
                    CountCalculateStrategy countCalculateStrategy = (CountCalculateStrategy) other;
                    if (Double.compare(this.emojiCount, countCalculateStrategy.emojiCount) != 0 || Double.compare(this.emoticonCount, countCalculateStrategy.emoticonCount) != 0 || Double.compare(this.asciiCount, countCalculateStrategy.asciiCount) != 0 || Double.compare(this.textCount, countCalculateStrategy.textCount) != 0) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long doubleToLongBits = Double.doubleToLongBits(this.emojiCount);
            long doubleToLongBits2 = Double.doubleToLongBits(this.emoticonCount);
            int i3 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31;
            long doubleToLongBits3 = Double.doubleToLongBits(this.asciiCount);
            int i16 = (i3 + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31;
            long doubleToLongBits4 = Double.doubleToLongBits(this.textCount);
            return i16 + ((int) ((doubleToLongBits4 >>> 32) ^ doubleToLongBits4));
        }

        @NotNull
        public String toString() {
            return "CountCalculateStrategy(emojiCount=" + this.emojiCount + ", emoticonCount=" + this.emoticonCount + ", asciiCount=" + this.asciiCount + ", textCount=" + this.textCount + ")";
        }

        public CountCalculateStrategy(double d16, double d17, double d18, double d19) {
            this.emojiCount = d16;
            this.emoticonCount = d17;
            this.asciiCount = d18;
            this.textCount = d19;
        }

        public /* synthetic */ CountCalculateStrategy(double d16, double d17, double d18, double d19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 1.0d : d16, (i3 & 2) != 0 ? 1.0d : d17, (i3 & 4) != 0 ? 1.0d : d18, (i3 & 8) == 0 ? d19 : 1.0d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u0000 \u00132\u00020\u0001:\u0001\tB\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lh01/a$e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "start", "end", "c", "type", "<init>", "(III)V", "d", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: h01.a$e, reason: from toString */
    /* loaded from: classes7.dex */
    public static final /* data */ class SpanPair {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int start;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int end;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lh01/a$e$a;", "", "Landroid/text/Spannable;", "spans", TtmlNode.TAG_SPAN, "", "type", "Lh01/a$e;", "a", "EMOJI_TYPE", "I", "REPLACEMENT_SPAN_TYPE", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: h01.a$e$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes7.dex */
        public static final class Companion {
            Companion() {
            }

            @NotNull
            public final SpanPair a(@NotNull Spannable spans, @NotNull Object span, int type) {
                Intrinsics.checkNotNullParameter(spans, "spans");
                Intrinsics.checkNotNullParameter(span, "span");
                return new SpanPair(spans.getSpanStart(span), spans.getSpanEnd(span), type);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public SpanPair(int i3, int i16, int i17) {
            this.start = i3;
            this.end = i16;
            this.type = i17;
        }

        /* renamed from: a, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        /* renamed from: b, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        /* renamed from: c, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof SpanPair) {
                    SpanPair spanPair = (SpanPair) other;
                    if (this.start != spanPair.start || this.end != spanPair.end || this.type != spanPair.type) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.start * 31) + this.end) * 31) + this.type;
        }

        @NotNull
        public String toString() {
            return "SpanPair(start=" + this.start + ", end=" + this.end + ", type=" + this.type + ")";
        }
    }

    public a(int i3, @Nullable com.tencent.kuikly.core.render.android.a aVar, @NotNull Function0<Float> fontSizeGetter, @NotNull Function0<Unit> textLengthBeyondLimitCallback) {
        Intrinsics.checkNotNullParameter(fontSizeGetter, "fontSizeGetter");
        Intrinsics.checkNotNullParameter(textLengthBeyondLimitCallback, "textLengthBeyondLimitCallback");
        this.maxLength = i3;
        this.kuiklyRenderContext = aVar;
        this.fontSizeGetter = fontSizeGetter;
        this.textLengthBeyondLimitCallback = textLengthBeyondLimitCallback;
        this.calculateStrategy = new CountCalculateStrategy(0.0d, 0.0d, 0.0d, 0.0d, 15, null);
    }

    private final int b(CharSequence text, int start, int charLimit) {
        int length;
        int g16;
        SparseArray d16 = INSTANCE.d(text);
        AsciiHalfCharacterCounter asciiHalfCharacterCounter = new AsciiHalfCharacterCounter(0, 0, 0, 0, false, this.calculateStrategy, 31, null);
        float f16 = charLimit;
        float i3 = f16 - asciiHalfCharacterCounter.i();
        while (start < text.length() && !asciiHalfCharacterCounter.getIsLimit()) {
            float f17 = 0;
            if (i3 <= f17) {
                break;
            }
            int indexOfKey = d16.indexOfKey(start);
            if (indexOfKey >= 0) {
                Object valueAt = d16.valueAt(indexOfKey);
                Intrinsics.checkNotNullExpressionValue(valueAt, "lookups.valueAt(spanIndex)");
                g16 = asciiHalfCharacterCounter.f((SpanPair) valueAt, i3);
            } else {
                int i16 = (-indexOfKey) - 1;
                if (i16 < d16.size()) {
                    length = ((SpanPair) d16.valueAt(i16)).getStart();
                } else {
                    length = text.length();
                }
                g16 = asciiHalfCharacterCounter.g(text, start, length, i3);
            }
            float i17 = f16 - asciiHalfCharacterCounter.i();
            if (i17 >= f17) {
                start += g16;
            }
            i3 = i17;
        }
        return start;
    }

    @Override // android.text.InputFilter
    @Nullable
    public CharSequence filter(@Nullable CharSequence source, int start, int end, @Nullable Spanned dest, int dstart, int dend) {
        int a16;
        Companion companion = INSTANCE;
        CharSequence charSequence = dest;
        if (dest == null) {
            charSequence = "";
        }
        CharSequence c16 = companion.c(charSequence, this.kuiklyRenderContext, this.fontSizeGetter.invoke().floatValue());
        if (dend == dstart) {
            a16 = 0;
        } else {
            a16 = companion.b(c16.subSequence(dstart, dend), this.calculateStrategy).a(this.calculateStrategy);
        }
        int a17 = this.maxLength - (companion.b(c16, this.calculateStrategy).a(this.calculateStrategy) - a16);
        if (a17 <= 0) {
            this.textLengthBeyondLimitCallback.invoke();
            return "";
        }
        if (source == null) {
            source = "";
        }
        CharSequence c17 = companion.c(source, this.kuiklyRenderContext, this.fontSizeGetter.invoke().floatValue());
        if (a17 >= companion.b(c17, this.calculateStrategy).a(this.calculateStrategy)) {
            return null;
        }
        int b16 = b(c17, start, a17);
        this.textLengthBeyondLimitCallback.invoke();
        return c17.subSequence(start, b16);
    }
}
