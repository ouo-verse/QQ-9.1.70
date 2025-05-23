package com.tencent.state.common.push;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/common/push/PullMsgResponse;", "", "offset", "", WidgetCacheConstellationData.INTERVAL, "", "serverTime", "", "messages", "", "Lcom/tencent/state/common/push/PushMessage;", "([BIJLjava/util/List;)V", "getInterval", "()I", "getMessages", "()Ljava/util/List;", "getOffset", "()[B", "getServerTime", "()J", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class PullMsgResponse {
    private final int interval;
    private final List<PushMessage> messages;
    private final byte[] offset;
    private final long serverTime;

    /* JADX WARN: Multi-variable type inference failed */
    public PullMsgResponse(byte[] offset, int i3, long j3, List<? extends PushMessage> messages) {
        Intrinsics.checkNotNullParameter(offset, "offset");
        Intrinsics.checkNotNullParameter(messages, "messages");
        this.offset = offset;
        this.interval = i3;
        this.serverTime = j3;
        this.messages = messages;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final List<PushMessage> getMessages() {
        return this.messages;
    }

    public final byte[] getOffset() {
        return this.offset;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public String toString() {
        return "PullMsgResponse(interval=" + this.interval + ", serverTime=" + this.serverTime + ", messages: " + this.messages.size() + ')';
    }
}
