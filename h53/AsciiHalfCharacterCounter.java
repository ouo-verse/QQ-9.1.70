package h53;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010#\u001a\u00020\u000b\u0012\b\b\u0002\u0010&\u001a\u00020\u000b\u0012\b\b\u0002\u0010)\u001a\u00020\u000b\u0012\b\b\u0002\u0010,\u001a\u00020\u000b\u0012\b\b\u0002\u00101\u001a\u00020\u0004\u0012\u0006\u00108\u001a\u000202\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0007J&\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0017J\t\u0010\u001a\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010#\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010&\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\"\u0010)\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\"\u0010,\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010-\u001a\u0004\b\r\u0010.\"\u0004\b/\u00100R\"\u00108\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006;"}, d2 = {"Lh53/a;", "", "", "character", "", "j", "d", "", "i", "", "str", "", ReportConstant.COSTREPORT_PREFIX, "e", "limit", "g", "", "a", "Lh53/v;", TtmlNode.TAG_SPAN, "b", "c", "f", "Lh53/d;", tl.h.F, "", "toString", "hashCode", "other", "equals", "I", "getMEmojiCount", "()I", "setMEmojiCount", "(I)V", "mEmojiCount", "getMEmoticonCount", "setMEmoticonCount", "mEmoticonCount", "getMAsciiCount", "setMAsciiCount", "mAsciiCount", "getMNonAsciiCount", "setMNonAsciiCount", "mNonAsciiCount", "Z", "()Z", "setLimit", "(Z)V", "isLimit", "Lh53/e;", "Lh53/e;", "getStrategy", "()Lh53/e;", "setStrategy", "(Lh53/e;)V", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "<init>", "(IIIIZLh53/e;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: h53.a, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class AsciiHalfCharacterCounter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int mEmojiCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int mEmoticonCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int mAsciiCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int mNonAsciiCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isLimit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private QUIInputCountCalculateStrategy strategy;

    public AsciiHalfCharacterCounter(int i3, int i16, int i17, int i18, boolean z16, @NotNull QUIInputCountCalculateStrategy strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.mEmojiCount = i3;
        this.mEmoticonCount = i16;
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
        if (span.getType() == 0) {
            this.mEmojiCount++;
        } else {
            this.mEmoticonCount++;
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
        if (this == other) {
            return true;
        }
        if (!(other instanceof AsciiHalfCharacterCounter)) {
            return false;
        }
        AsciiHalfCharacterCounter asciiHalfCharacterCounter = (AsciiHalfCharacterCounter) other;
        if (this.mEmojiCount == asciiHalfCharacterCounter.mEmojiCount && this.mEmoticonCount == asciiHalfCharacterCounter.mEmoticonCount && this.mAsciiCount == asciiHalfCharacterCounter.mAsciiCount && this.mNonAsciiCount == asciiHalfCharacterCounter.mNonAsciiCount && this.isLimit == asciiHalfCharacterCounter.isLimit && Intrinsics.areEqual(this.strategy, asciiHalfCharacterCounter.strategy)) {
            return true;
        }
        return false;
    }

    public final int f(@NotNull SpanPair span, float limit) {
        Intrinsics.checkNotNullParameter(span, "span");
        if (limit < 1.0f) {
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
            if (i16 >= e16 || limit <= 0.0f) {
                break;
            }
            if (limit >= 1.0f) {
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
        if (limit <= 0.0f) {
            this.isLimit = true;
        }
        return i16 - s16;
    }

    @NotNull
    public final CharacterCountInfo h() {
        return new CharacterCountInfo(this.mEmojiCount, this.mEmoticonCount, this.mAsciiCount, this.mNonAsciiCount);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = ((((((this.mEmojiCount * 31) + this.mEmoticonCount) * 31) + this.mAsciiCount) * 31) + this.mNonAsciiCount) * 31;
        boolean z16 = this.isLimit;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return ((i3 + i16) * 31) + this.strategy.hashCode();
    }

    public final float i() {
        return (float) ((this.mEmojiCount * this.strategy.getEmojiCount()) + (this.mEmoticonCount * this.strategy.getEmoticonCount()) + (this.mNonAsciiCount * this.strategy.getTextCount()) + (this.mAsciiCount * this.strategy.getAsciiCount()));
    }

    @NotNull
    public String toString() {
        return "AsciiHalfCharacterCounter(mEmojiCount=" + this.mEmojiCount + ", mEmoticonCount=" + this.mEmoticonCount + ", mAsciiCount=" + this.mAsciiCount + ", mNonAsciiCount=" + this.mNonAsciiCount + ", isLimit=" + this.isLimit + ", strategy=" + this.strategy + ')';
    }

    public /* synthetic */ AsciiHalfCharacterCounter(int i3, int i16, int i17, int i18, boolean z16, QUIInputCountCalculateStrategy qUIInputCountCalculateStrategy, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? 0 : i16, (i19 & 4) != 0 ? 0 : i17, (i19 & 8) != 0 ? 0 : i18, (i19 & 16) != 0 ? false : z16, qUIInputCountCalculateStrategy);
    }
}
