package h53;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0014\u0010\u000fR\"\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lh53/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "D", "b", "()D", "setEmojiCount", "(D)V", "emojiCount", "c", "setEmoticonCount", "emoticonCount", "setAsciiCount", "asciiCount", "d", "setTextCount", "textCount", "<init>", "(DDDD)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: h53.e, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class QUIInputCountCalculateStrategy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private double emojiCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private double emoticonCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private double asciiCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private double textCount;

    public QUIInputCountCalculateStrategy() {
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
        if (this == other) {
            return true;
        }
        if (!(other instanceof QUIInputCountCalculateStrategy)) {
            return false;
        }
        QUIInputCountCalculateStrategy qUIInputCountCalculateStrategy = (QUIInputCountCalculateStrategy) other;
        if (Double.compare(this.emojiCount, qUIInputCountCalculateStrategy.emojiCount) == 0 && Double.compare(this.emoticonCount, qUIInputCountCalculateStrategy.emoticonCount) == 0 && Double.compare(this.asciiCount, qUIInputCountCalculateStrategy.asciiCount) == 0 && Double.compare(this.textCount, qUIInputCountCalculateStrategy.textCount) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((com.tencent.biz.qqcircle.comment.recpic.a.a(this.emojiCount) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.emoticonCount)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.asciiCount)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.textCount);
    }

    @NotNull
    public String toString() {
        return "QUIInputCountCalculateStrategy(emojiCount=" + this.emojiCount + ", emoticonCount=" + this.emoticonCount + ", asciiCount=" + this.asciiCount + ", textCount=" + this.textCount + ')';
    }

    public QUIInputCountCalculateStrategy(double d16, double d17, double d18, double d19) {
        this.emojiCount = d16;
        this.emoticonCount = d17;
        this.asciiCount = d18;
        this.textCount = d19;
    }

    public /* synthetic */ QUIInputCountCalculateStrategy(double d16, double d17, double d18, double d19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1.0d : d16, (i3 & 2) != 0 ? 1.0d : d17, (i3 & 4) != 0 ? 0.5d : d18, (i3 & 8) == 0 ? d19 : 1.0d);
    }
}
