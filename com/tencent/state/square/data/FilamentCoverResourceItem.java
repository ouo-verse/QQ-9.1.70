package com.tencent.state.square.data;

import androidx.fragment.app.a;
import cooperation.qzone.QZoneRequestEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/data/FilamentCoverResourceItem;", "", "uin", "", "motionId", "", "cover", "Lcom/tencent/state/square/data/FilamentCoverResource;", "(JILcom/tencent/state/square/data/FilamentCoverResource;)V", QZoneRequestEncoder.KEY_COVER_REQ, "()Lcom/tencent/state/square/data/FilamentCoverResource;", "getMotionId", "()I", "getUin", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class FilamentCoverResourceItem {

    @NotNull
    private final FilamentCoverResource cover;
    private final int motionId;
    private final long uin;

    public FilamentCoverResourceItem(long j3, int i3, @NotNull FilamentCoverResource cover) {
        Intrinsics.checkNotNullParameter(cover, "cover");
        this.uin = j3;
        this.motionId = i3;
        this.cover = cover;
    }

    public static /* synthetic */ FilamentCoverResourceItem copy$default(FilamentCoverResourceItem filamentCoverResourceItem, long j3, int i3, FilamentCoverResource filamentCoverResource, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            j3 = filamentCoverResourceItem.uin;
        }
        if ((i16 & 2) != 0) {
            i3 = filamentCoverResourceItem.motionId;
        }
        if ((i16 & 4) != 0) {
            filamentCoverResource = filamentCoverResourceItem.cover;
        }
        return filamentCoverResourceItem.copy(j3, i3, filamentCoverResource);
    }

    /* renamed from: component1, reason: from getter */
    public final long getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMotionId() {
        return this.motionId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final FilamentCoverResource getCover() {
        return this.cover;
    }

    @NotNull
    public final FilamentCoverResourceItem copy(long uin, int motionId, @NotNull FilamentCoverResource cover) {
        Intrinsics.checkNotNullParameter(cover, "cover");
        return new FilamentCoverResourceItem(uin, motionId, cover);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FilamentCoverResourceItem) {
                FilamentCoverResourceItem filamentCoverResourceItem = (FilamentCoverResourceItem) other;
                if (this.uin != filamentCoverResourceItem.uin || this.motionId != filamentCoverResourceItem.motionId || !Intrinsics.areEqual(this.cover, filamentCoverResourceItem.cover)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final FilamentCoverResource getCover() {
        return this.cover;
    }

    public final int getMotionId() {
        return this.motionId;
    }

    public final long getUin() {
        return this.uin;
    }

    public int hashCode() {
        int i3;
        int a16 = ((a.a(this.uin) * 31) + this.motionId) * 31;
        FilamentCoverResource filamentCoverResource = this.cover;
        if (filamentCoverResource != null) {
            i3 = filamentCoverResource.hashCode();
        } else {
            i3 = 0;
        }
        return a16 + i3;
    }

    @NotNull
    public String toString() {
        return "FilamentCoverResourceItem(uin=" + this.uin + ", motionId=" + this.motionId + ", cover=" + this.cover + ')';
    }
}
