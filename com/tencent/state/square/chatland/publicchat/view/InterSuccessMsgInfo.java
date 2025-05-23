package com.tencent.state.square.chatland.publicchat.view;

import com.tencent.state.publicchat.data.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/chatland/publicchat/view/InterSuccessMsgInfo;", "", "template", "", "sender", "Lcom/tencent/state/publicchat/data/UserInfo;", "receiver", "(Ljava/lang/String;Lcom/tencent/state/publicchat/data/UserInfo;Lcom/tencent/state/publicchat/data/UserInfo;)V", "getReceiver", "()Lcom/tencent/state/publicchat/data/UserInfo;", "getSender", "getTemplate", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InterSuccessMsgInfo {
    private final UserInfo receiver;
    private final UserInfo sender;
    private final String template;

    public InterSuccessMsgInfo(String template, UserInfo sender, UserInfo receiver) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        this.template = template;
        this.sender = sender;
        this.receiver = receiver;
    }

    /* renamed from: component1, reason: from getter */
    public final String getTemplate() {
        return this.template;
    }

    /* renamed from: component2, reason: from getter */
    public final UserInfo getSender() {
        return this.sender;
    }

    /* renamed from: component3, reason: from getter */
    public final UserInfo getReceiver() {
        return this.receiver;
    }

    public final InterSuccessMsgInfo copy(String template, UserInfo sender, UserInfo receiver) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        return new InterSuccessMsgInfo(template, sender, receiver);
    }

    public final UserInfo getReceiver() {
        return this.receiver;
    }

    public final UserInfo getSender() {
        return this.sender;
    }

    public final String getTemplate() {
        return this.template;
    }

    public int hashCode() {
        String str = this.template;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        UserInfo userInfo = this.sender;
        int hashCode2 = (hashCode + (userInfo != null ? userInfo.hashCode() : 0)) * 31;
        UserInfo userInfo2 = this.receiver;
        return hashCode2 + (userInfo2 != null ? userInfo2.hashCode() : 0);
    }

    public String toString() {
        return "InterSuccessMsgInfo(template=" + this.template + ", sender=" + this.sender + ", receiver=" + this.receiver + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InterSuccessMsgInfo)) {
            return false;
        }
        InterSuccessMsgInfo interSuccessMsgInfo = (InterSuccessMsgInfo) other;
        return Intrinsics.areEqual(this.template, interSuccessMsgInfo.template) && Intrinsics.areEqual(this.sender, interSuccessMsgInfo.sender) && Intrinsics.areEqual(this.receiver, interSuccessMsgInfo.receiver);
    }

    public static /* synthetic */ InterSuccessMsgInfo copy$default(InterSuccessMsgInfo interSuccessMsgInfo, String str, UserInfo userInfo, UserInfo userInfo2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = interSuccessMsgInfo.template;
        }
        if ((i3 & 2) != 0) {
            userInfo = interSuccessMsgInfo.sender;
        }
        if ((i3 & 4) != 0) {
            userInfo2 = interSuccessMsgInfo.receiver;
        }
        return interSuccessMsgInfo.copy(str, userInfo, userInfo2);
    }
}
