package com.tencent.state.template.data;

import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/template/data/OperationAd;", "", "startTs", "", "endTs", "video", "Lcom/tencent/state/template/data/OperationAdVideo;", "background", "Lcom/tencent/state/template/data/OperationAdBackground;", "(JJLcom/tencent/state/template/data/OperationAdVideo;Lcom/tencent/state/template/data/OperationAdBackground;)V", "getBackground", "()Lcom/tencent/state/template/data/OperationAdBackground;", "getEndTs", "()J", "getStartTs", "getVideo", "()Lcom/tencent/state/template/data/OperationAdVideo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class OperationAd {
    private final OperationAdBackground background;
    private final long endTs;
    private final long startTs;
    private final OperationAdVideo video;

    public OperationAd(long j3, long j16, OperationAdVideo video, OperationAdBackground background) {
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(background, "background");
        this.startTs = j3;
        this.endTs = j16;
        this.video = video;
        this.background = background;
    }

    /* renamed from: component1, reason: from getter */
    public final long getStartTs() {
        return this.startTs;
    }

    /* renamed from: component2, reason: from getter */
    public final long getEndTs() {
        return this.endTs;
    }

    /* renamed from: component3, reason: from getter */
    public final OperationAdVideo getVideo() {
        return this.video;
    }

    /* renamed from: component4, reason: from getter */
    public final OperationAdBackground getBackground() {
        return this.background;
    }

    public final OperationAd copy(long startTs, long endTs, OperationAdVideo video, OperationAdBackground background) {
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(background, "background");
        return new OperationAd(startTs, endTs, video, background);
    }

    public final OperationAdBackground getBackground() {
        return this.background;
    }

    public final long getEndTs() {
        return this.endTs;
    }

    public final long getStartTs() {
        return this.startTs;
    }

    public final OperationAdVideo getVideo() {
        return this.video;
    }

    public int hashCode() {
        int a16 = ((c.a(this.startTs) * 31) + c.a(this.endTs)) * 31;
        OperationAdVideo operationAdVideo = this.video;
        int hashCode = (a16 + (operationAdVideo != null ? operationAdVideo.hashCode() : 0)) * 31;
        OperationAdBackground operationAdBackground = this.background;
        return hashCode + (operationAdBackground != null ? operationAdBackground.hashCode() : 0);
    }

    public String toString() {
        return "OperationAd(startTs=" + this.startTs + ", endTs=" + this.endTs + ", video=" + this.video + ", background=" + this.background + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OperationAd)) {
            return false;
        }
        OperationAd operationAd = (OperationAd) other;
        return this.startTs == operationAd.startTs && this.endTs == operationAd.endTs && Intrinsics.areEqual(this.video, operationAd.video) && Intrinsics.areEqual(this.background, operationAd.background);
    }

    public static /* synthetic */ OperationAd copy$default(OperationAd operationAd, long j3, long j16, OperationAdVideo operationAdVideo, OperationAdBackground operationAdBackground, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = operationAd.startTs;
        }
        long j17 = j3;
        if ((i3 & 2) != 0) {
            j16 = operationAd.endTs;
        }
        long j18 = j16;
        if ((i3 & 4) != 0) {
            operationAdVideo = operationAd.video;
        }
        OperationAdVideo operationAdVideo2 = operationAdVideo;
        if ((i3 & 8) != 0) {
            operationAdBackground = operationAd.background;
        }
        return operationAd.copy(j17, j18, operationAdVideo2, operationAdBackground);
    }
}
