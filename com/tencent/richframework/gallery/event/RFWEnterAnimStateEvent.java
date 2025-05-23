package com.tencent.richframework.gallery.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/richframework/gallery/event/RFWEnterAnimStateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "isStart", "", "picId", "", "(ZLjava/lang/String;)V", "()Z", "getPicId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final /* data */ class RFWEnterAnimStateEvent extends SimpleBaseEvent {
    private final boolean isStart;

    @NotNull
    private final String picId;

    public RFWEnterAnimStateEvent(boolean z16, @NotNull String picId) {
        Intrinsics.checkNotNullParameter(picId, "picId");
        this.isStart = z16;
        this.picId = picId;
    }

    public static /* synthetic */ RFWEnterAnimStateEvent copy$default(RFWEnterAnimStateEvent rFWEnterAnimStateEvent, boolean z16, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = rFWEnterAnimStateEvent.isStart;
        }
        if ((i3 & 2) != 0) {
            str = rFWEnterAnimStateEvent.picId;
        }
        return rFWEnterAnimStateEvent.copy(z16, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsStart() {
        return this.isStart;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getPicId() {
        return this.picId;
    }

    @NotNull
    public final RFWEnterAnimStateEvent copy(boolean isStart, @NotNull String picId) {
        Intrinsics.checkNotNullParameter(picId, "picId");
        return new RFWEnterAnimStateEvent(isStart, picId);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof RFWEnterAnimStateEvent) {
                RFWEnterAnimStateEvent rFWEnterAnimStateEvent = (RFWEnterAnimStateEvent) other;
                if (this.isStart != rFWEnterAnimStateEvent.isStart || !Intrinsics.areEqual(this.picId, rFWEnterAnimStateEvent.picId)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getPicId() {
        return this.picId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        int i3;
        boolean z16 = this.isStart;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        String str = this.picId;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    public final boolean isStart() {
        return this.isStart;
    }

    @NotNull
    public String toString() {
        return "RFWEnterAnimStateEvent(isStart=" + this.isStart + ", picId=" + this.picId + ")";
    }
}
