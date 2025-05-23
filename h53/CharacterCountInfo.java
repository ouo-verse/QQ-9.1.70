package h53;

import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Lh53/d;", "", "Lh53/e;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "", "c", "", "toString", "hashCode", "other", "", "equals", "a", "I", "()I", "setEmojiCount", "(I)V", "emojiCount", "b", "setEmoticonCount", "emoticonCount", "getAsciiCount", "setAsciiCount", "asciiCount", "d", "getTextCount", "setTextCount", "textCount", "<init>", "(IIII)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: h53.d, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class CharacterCountInfo {

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

    public static /* synthetic */ int d(CharacterCountInfo characterCountInfo, QUIInputCountCalculateStrategy qUIInputCountCalculateStrategy, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            qUIInputCountCalculateStrategy = new QUIInputCountCalculateStrategy(0.0d, 0.0d, 0.0d, 0.0d, 15, null);
        }
        return characterCountInfo.c(qUIInputCountCalculateStrategy);
    }

    /* renamed from: a, reason: from getter */
    public final int getEmojiCount() {
        return this.emojiCount;
    }

    /* renamed from: b, reason: from getter */
    public final int getEmoticonCount() {
        return this.emoticonCount;
    }

    public final int c(@NotNull QUIInputCountCalculateStrategy strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        return (int) (Math.ceil(this.emojiCount * strategy.getEmojiCount()) + Math.ceil(this.emoticonCount * strategy.getEmoticonCount()) + Math.ceil(this.textCount * strategy.getTextCount()) + Math.ceil(this.asciiCount * strategy.getAsciiCount()));
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CharacterCountInfo)) {
            return false;
        }
        CharacterCountInfo characterCountInfo = (CharacterCountInfo) other;
        if (this.emojiCount == characterCountInfo.emojiCount && this.emoticonCount == characterCountInfo.emoticonCount && this.asciiCount == characterCountInfo.asciiCount && this.textCount == characterCountInfo.textCount) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.emojiCount * 31) + this.emoticonCount) * 31) + this.asciiCount) * 31) + this.textCount;
    }

    @NotNull
    public String toString() {
        return "CharacterCountInfo(emojiCount=" + this.emojiCount + ", emoticonCount=" + this.emoticonCount + ", asciiCount=" + this.asciiCount + ", textCount=" + this.textCount + ')';
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
