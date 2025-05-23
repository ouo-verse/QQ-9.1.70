package o54;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import u54.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lo54/b;", "Lu54/c;", "", "c", "Z", "()Z", "isInDirectMsgRobotNode", "", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "guildId", "channelId", "", "chatType", "<init>", "(ZLjava/lang/String;Ljava/lang/String;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends c {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isInDirectMsgRobotNode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(boolean z16, @NotNull String guildId, @NotNull String channelId, int i3) {
        super(channelId, i3);
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.isInDirectMsgRobotNode = z16;
        this.guildId = guildId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsInDirectMsgRobotNode() {
        return this.isInDirectMsgRobotNode;
    }
}
