package js1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017\"\u0004\b\u0013\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Ljs1/a;", "", "", "maxDelayTimes", "", "a", "", "toString", "hashCode", "other", "equals", "Z", "isChannelListAnimRunning", "()Z", "setChannelListAnimRunning", "(Z)V", "b", "isDraggingBubble", "d", "c", "isLoading", "setLoading", "I", "()I", "(I)V", "delayRefreshTimes", "<init>", "(ZZZI)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isChannelListAnimRunning;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isDraggingBubble;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isLoading;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int delayRefreshTimes;

    public a() {
        this(false, false, false, 0, 15, null);
    }

    public final boolean a(int maxDelayTimes) {
        if ((!this.isChannelListAnimRunning && !this.isDraggingBubble && !this.isLoading) || this.delayRefreshTimes > maxDelayTimes) {
            return true;
        }
        return false;
    }

    /* renamed from: b, reason: from getter */
    public final int getDelayRefreshTimes() {
        return this.delayRefreshTimes;
    }

    public final void c(int i3) {
        this.delayRefreshTimes = i3;
    }

    public final void d(boolean z16) {
        this.isDraggingBubble = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.isChannelListAnimRunning == aVar.isChannelListAnimRunning && this.isDraggingBubble == aVar.isDraggingBubble && this.isLoading == aVar.isLoading && this.delayRefreshTimes == aVar.delayRefreshTimes) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.isChannelListAnimRunning;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.isDraggingBubble;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z17 = this.isLoading;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i18 + i3) * 31) + this.delayRefreshTimes;
    }

    @NotNull
    public String toString() {
        return this.isChannelListAnimRunning + "_" + this.isDraggingBubble + "_" + this.isLoading + "_" + this.delayRefreshTimes;
    }

    public a(boolean z16, boolean z17, boolean z18, int i3) {
        this.isChannelListAnimRunning = z16;
        this.isDraggingBubble = z17;
        this.isLoading = z18;
        this.delayRefreshTimes = i3;
    }

    public /* synthetic */ a(boolean z16, boolean z17, boolean z18, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? false : z17, (i16 & 4) != 0 ? false : z18, (i16 & 8) != 0 ? 0 : i3);
    }
}
