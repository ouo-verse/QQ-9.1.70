package com.tencent.biz.qqcircle.immersive.redpacket.viewmodel;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import feedcloud.FeedCloudDatacard$RedPocketCoverInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dB/\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\n\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/MakeRedPacketResult;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/MakeRedPacketResult$State;", "a", "Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/MakeRedPacketResult$State;", "d", "()Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/MakeRedPacketResult$State;", "state", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "message", "Lfeedcloud/FeedCloudDatacard$RedPocketCoverInfo;", "c", "Lfeedcloud/FeedCloudDatacard$RedPocketCoverInfo;", "()Lfeedcloud/FeedCloudDatacard$RedPocketCoverInfo;", "redPacketInfo", "I", "()I", IProfileCardConst.KEY_FROM_TYPE, "<init>", "(Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/MakeRedPacketResult$State;Ljava/lang/String;Lfeedcloud/FeedCloudDatacard$RedPocketCoverInfo;I)V", "State", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final /* data */ class MakeRedPacketResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final State state;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String message;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final FeedCloudDatacard$RedPocketCoverInfo redPacketInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int fromType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/MakeRedPacketResult$State;", "", "(Ljava/lang/String;I)V", "LOADING", "FAILED", "SUCCEED", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public enum State {
        LOADING,
        FAILED,
        SUCCEED
    }

    public MakeRedPacketResult(@NotNull State state, @NotNull String message, @Nullable FeedCloudDatacard$RedPocketCoverInfo feedCloudDatacard$RedPocketCoverInfo, int i3) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(message, "message");
        this.state = state;
        this.message = message;
        this.redPacketInfo = feedCloudDatacard$RedPocketCoverInfo;
        this.fromType = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getFromType() {
        return this.fromType;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final FeedCloudDatacard$RedPocketCoverInfo getRedPacketInfo() {
        return this.redPacketInfo;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final State getState() {
        return this.state;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MakeRedPacketResult)) {
            return false;
        }
        MakeRedPacketResult makeRedPacketResult = (MakeRedPacketResult) other;
        if (this.state == makeRedPacketResult.state && Intrinsics.areEqual(this.message, makeRedPacketResult.message) && Intrinsics.areEqual(this.redPacketInfo, makeRedPacketResult.redPacketInfo) && this.fromType == makeRedPacketResult.fromType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.state.hashCode() * 31) + this.message.hashCode()) * 31;
        FeedCloudDatacard$RedPocketCoverInfo feedCloudDatacard$RedPocketCoverInfo = this.redPacketInfo;
        if (feedCloudDatacard$RedPocketCoverInfo == null) {
            hashCode = 0;
        } else {
            hashCode = feedCloudDatacard$RedPocketCoverInfo.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + this.fromType;
    }

    @NotNull
    public String toString() {
        return "MakeRedPacketResult(state=" + this.state + ", message=" + this.message + ", redPacketInfo=" + this.redPacketInfo + ", fromType=" + this.fromType + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ MakeRedPacketResult(State state, String str, FeedCloudDatacard$RedPocketCoverInfo feedCloudDatacard$RedPocketCoverInfo, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(state, str, (i16 & 4) != 0 ? null : feedCloudDatacard$RedPocketCoverInfo, (i16 & 8) != 0 ? 0 : i3);
        if ((i16 & 2) != 0) {
            str = com.tencent.biz.qqcircle.utils.h.a(R.string.f194724co);
            Intrinsics.checkNotNullExpressionValue(str, "qqStr(R.string.qfs_red_packet_preview_make_failed)");
        }
    }
}
