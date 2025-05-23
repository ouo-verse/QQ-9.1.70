package da2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lda2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "d", "(Z)V", "bTiming", "b", "I", "()I", "e", "(I)V", "delay", "Lda2/d;", "c", "Lda2/d;", "()Lda2/d;", "f", "(Lda2/d;)V", com.tencent.luggage.wxa.c8.c.G, "<init>", "(ZILda2/d;)V", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: da2.a, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class FetchMapDataTimingInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean bTiming;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int delay;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private d pos;

    public FetchMapDataTimingInfo() {
        this(false, 0, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getBTiming() {
        return this.bTiming;
    }

    /* renamed from: b, reason: from getter */
    public final int getDelay() {
        return this.delay;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final d getPos() {
        return this.pos;
    }

    public final void d(boolean z16) {
        this.bTiming = z16;
    }

    public final void e(int i3) {
        this.delay = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FetchMapDataTimingInfo)) {
            return false;
        }
        FetchMapDataTimingInfo fetchMapDataTimingInfo = (FetchMapDataTimingInfo) other;
        if (this.bTiming == fetchMapDataTimingInfo.bTiming && this.delay == fetchMapDataTimingInfo.delay && Intrinsics.areEqual(this.pos, fetchMapDataTimingInfo.pos)) {
            return true;
        }
        return false;
    }

    public final void f(@Nullable d dVar) {
        this.pos = dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.bTiming;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = ((r06 * 31) + this.delay) * 31;
        d dVar = this.pos;
        if (dVar == null) {
            hashCode = 0;
        } else {
            hashCode = dVar.hashCode();
        }
        return i3 + hashCode;
    }

    @NotNull
    public String toString() {
        return "FetchMapDataTimingInfo(bTiming=" + this.bTiming + ", delay=" + this.delay + ", pos=" + this.pos + ")";
    }

    public FetchMapDataTimingInfo(boolean z16, int i3, @Nullable d dVar) {
        this.bTiming = z16;
        this.delay = i3;
        this.pos = dVar;
    }

    public /* synthetic */ FetchMapDataTimingInfo(boolean z16, int i3, d dVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? null : dVar);
    }
}
