package com.tencent.mobileqq.icgame.widget.chat.message;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w42.f;
import w42.i;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/message/LiveLocalMsg;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lw42/f;", "Lw42/i;", "getHeader", "", "roomId", "J", "getRoomId", "()J", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "sender", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "getSender", "()Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "msgHeader", "Lw42/i;", "", "isSendMsgAlienation", "Z", "()Z", "setSendMsgAlienation", "(Z)V", "<init>", "(JLjava/lang/String;Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;)V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LiveLocalMsg extends SimpleBaseEvent implements f {
    private boolean isSendMsgAlienation;

    @NotNull
    private final i msgHeader;
    private final long roomId;

    @NotNull
    private final LiveUserInfo sender;

    @NotNull
    private final String text;

    public LiveLocalMsg(long j3, @NotNull String text, @NotNull LiveUserInfo sender) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(sender, "sender");
        this.roomId = j3;
        this.text = text;
        this.sender = sender;
        this.msgHeader = new i();
    }

    @Nullable
    /* renamed from: getHeader, reason: from getter */
    public i getMsgHeader() {
        return this.msgHeader;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    @NotNull
    public final LiveUserInfo getSender() {
        return this.sender;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    /* renamed from: isSendMsgAlienation, reason: from getter */
    public final boolean getIsSendMsgAlienation() {
        return this.isSendMsgAlienation;
    }

    public final void setSendMsgAlienation(boolean z16) {
        this.isSendMsgAlienation = z16;
    }
}
