package nq0;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u0003\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lnq0/b;", "", "", "a", "J", "b", "()J", "msgSeq", "", "I", "c", "()I", "topMsgType", "", "Ljava/lang/String;", "()Ljava/lang/String;", "channelId", "<init>", "(JILjava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long msgSeq;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int topMsgType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    public b(long j3, int i3, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.msgSeq = j3;
        this.topMsgType = i3;
        this.channelId = channelId;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* renamed from: b, reason: from getter */
    public final long getMsgSeq() {
        return this.msgSeq;
    }

    /* renamed from: c, reason: from getter */
    public final int getTopMsgType() {
        return this.topMsgType;
    }
}
