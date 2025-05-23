package hn3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u0005B9\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0005\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\r\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0015\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lhn3/d;", "", "", "toString", "", "a", "I", "b", "()I", "eventType", "d", "pkStatus", "Le55/c;", "c", "Le55/c;", "()Le55/c;", "anchorInfo", "", "J", "()J", "pkId", "e", "pkType", "<init>", "(IILe55/c;JI)V", "f", "qq-live-linkscreen-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: hn3.d, reason: from toString */
/* loaded from: classes22.dex */
public final class PKEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int eventType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int pkStatus;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final e55.c anchorInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long pkId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int pkType;

    public PKEvent(int i3, int i16, @Nullable e55.c cVar, long j3, int i17) {
        this.eventType = i3;
        this.pkStatus = i16;
        this.anchorInfo = cVar;
        this.pkId = j3;
        this.pkType = i17;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final e55.c getAnchorInfo() {
        return this.anchorInfo;
    }

    /* renamed from: b, reason: from getter */
    public final int getEventType() {
        return this.eventType;
    }

    /* renamed from: c, reason: from getter */
    public final long getPkId() {
        return this.pkId;
    }

    /* renamed from: d, reason: from getter */
    public final int getPkStatus() {
        return this.pkStatus;
    }

    /* renamed from: e, reason: from getter */
    public final int getPkType() {
        return this.pkType;
    }

    @NotNull
    public String toString() {
        return "PKEvent(eventType=" + this.eventType + ", pkStatus=" + this.pkStatus + ", pkId=" + this.pkId + ", pkType=" + this.pkType + ')';
    }

    public /* synthetic */ PKEvent(int i3, int i16, e55.c cVar, long j3, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i18 & 2) != 0 ? -1 : i16, (i18 & 4) != 0 ? null : cVar, (i18 & 8) != 0 ? 0L : j3, (i18 & 16) != 0 ? 2 : i17);
    }
}
