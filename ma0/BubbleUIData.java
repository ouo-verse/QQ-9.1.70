package ma0;

import e40.QFSFeedBubbleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lma0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "show", "Le40/a;", "Le40/a;", "()Le40/a;", "bubbleInfo", "<init>", "(ZLe40/a;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ma0.a, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class BubbleUIData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean show;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final QFSFeedBubbleInfo bubbleInfo;

    public BubbleUIData(boolean z16, @NotNull QFSFeedBubbleInfo bubbleInfo) {
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        this.show = z16;
        this.bubbleInfo = bubbleInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final QFSFeedBubbleInfo getBubbleInfo() {
        return this.bubbleInfo;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getShow() {
        return this.show;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BubbleUIData)) {
            return false;
        }
        BubbleUIData bubbleUIData = (BubbleUIData) other;
        if (this.show == bubbleUIData.show && Intrinsics.areEqual(this.bubbleInfo, bubbleUIData.bubbleInfo)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.show;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + this.bubbleInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "BubbleUIData(show=" + this.show + ", bubbleInfo=" + this.bubbleInfo + ")";
    }

    public /* synthetic */ BubbleUIData(boolean z16, QFSFeedBubbleInfo qFSFeedBubbleInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? new QFSFeedBubbleInfo(false, null, null, null, null, null, null, null, 255, null) : qFSFeedBubbleInfo);
    }
}
