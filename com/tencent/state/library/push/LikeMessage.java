package com.tencent.state.library.push;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.state.common.push.PushBasic;
import com.tencent.state.common.push.PushMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/library/push/LikeMessage;", "Lcom/tencent/state/common/push/PushMessage;", "type", "", "info", "Lcom/tencent/state/common/push/PushBasic;", "fromUin", "", "toUin", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "(ILcom/tencent/state/common/push/PushBasic;JJI)V", "getFromUin", "()J", "getInfo", "()Lcom/tencent/state/common/push/PushBasic;", "getLikeCount", "()I", "getToUin", "getType", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LikeMessage extends PushMessage {
    private final long fromUin;
    private final PushBasic info;
    private final int likeCount;
    private final long toUin;
    private final int type;

    public LikeMessage(int i3, PushBasic info, long j3, long j16, int i16) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.type = i3;
        this.info = info;
        this.fromUin = j3;
        this.toUin = j16;
        this.likeCount = i16;
    }

    public final long getFromUin() {
        return this.fromUin;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public PushBasic getInfo() {
        return this.info;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final long getToUin() {
        return this.toUin;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public int getType() {
        return this.type;
    }

    public String toString() {
        return "LikeMessage(type=" + getType() + ", info=" + getInfo() + ", fromUin=" + this.fromUin + ", toUin=" + this.toUin + ", likeCount=" + this.likeCount + ')';
    }
}
