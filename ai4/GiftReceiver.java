package ai4;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0013\u0010\u0017\"\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0019\u0010\r\u00a8\u0006\u001e"}, d2 = {"Lai4/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "f", "()J", "uid", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "c", "avatar", "d", "I", "()I", "seatType", "e", "setSeatNo", "(I)V", "seatNo", "startSeq", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ai4.a, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class GiftReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long uid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatar;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int seatType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int seatNo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final long startSeq;

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: c, reason: from getter */
    public final int getSeatNo() {
        return this.seatNo;
    }

    /* renamed from: d, reason: from getter */
    public final int getSeatType() {
        return this.seatType;
    }

    /* renamed from: e, reason: from getter */
    public final long getStartSeq() {
        return this.startSeq;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GiftReceiver)) {
            return false;
        }
        GiftReceiver giftReceiver = (GiftReceiver) other;
        if (this.uid == giftReceiver.uid && Intrinsics.areEqual(this.name, giftReceiver.name) && Intrinsics.areEqual(this.avatar, giftReceiver.avatar) && this.seatType == giftReceiver.seatType && this.seatNo == giftReceiver.seatNo && this.startSeq == giftReceiver.startSeq) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final long getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((((((androidx.fragment.app.a.a(this.uid) * 31) + this.name.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.seatType) * 31) + this.seatNo) * 31) + androidx.fragment.app.a.a(this.startSeq);
    }

    @NotNull
    public String toString() {
        return "GiftReceiver(uid=" + this.uid + ", name=" + this.name + ", avatar=" + this.avatar + ", seatType=" + this.seatType + ", seatNo=" + this.seatNo + ", startSeq=" + this.startSeq + ")";
    }
}
