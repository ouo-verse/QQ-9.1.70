package h53;

import android.text.Spannable;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\tB!\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lh53/v;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "start", "end", "c", "type", "<init>", "(III)V", "d", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: h53.v, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class SpanPair {

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
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\t\u00a8\u0006\r"}, d2 = {"Lh53/v$a;", "", "Landroid/text/Spannable;", "spans", TtmlNode.TAG_SPAN, "Lh53/v;", "a", "", "EMOJI_TYPE", "I", "OTHER_TYPE", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: h53.v$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SpanPair a(@NotNull Spannable spans, @NotNull Object span) {
            Intrinsics.checkNotNullParameter(spans, "spans");
            Intrinsics.checkNotNullParameter(span, "span");
            return new SpanPair(spans.getSpanStart(span), spans.getSpanEnd(span), 1);
        }

        Companion() {
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
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpanPair)) {
            return false;
        }
        SpanPair spanPair = (SpanPair) other;
        if (this.start == spanPair.start && this.end == spanPair.end && this.type == spanPair.type) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.start * 31) + this.end) * 31) + this.type;
    }

    @NotNull
    public String toString() {
        return "SpanPair(start=" + this.start + ", end=" + this.end + ", type=" + this.type + ')';
    }
}
