package com.tencent.mobileqq.guild.message.directmessage.model.data;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.co;
import com.tencent.mobileqq.qqguildsdk.data.cq;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0017\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0006B7\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010'\u001a\u00020 \u0012\b\b\u0002\u0010,\u001a\u00020\n\u0012\b\b\u0002\u00103\u001a\u00020\u0004\u00a2\u0006\u0004\b5\u00106J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\t\u0010\u0010\u001a\u00020\nH\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u001a\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010,\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010(\u001a\u0004\b!\u0010)\"\u0004\b*\u0010+R\"\u00103\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u00104\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b-\u0010\u0017\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/model/data/b;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", "guildNotice", "", "j", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/cq;", "redPoint", "k", "", "b", "", "i", NodeProps.VISIBLE, "l", "toString", "", "hashCode", "other", "equals", "I", "g", "()I", "setType", "(I)V", "type", "Lcom/tencent/mobileqq/qqguildsdk/data/cq;", "f", "()Lcom/tencent/mobileqq/qqguildsdk/data/cq;", "setRedPoint", "(Lcom/tencent/mobileqq/qqguildsdk/data/cq;)V", "", "c", "J", "d", "()J", "setMessageTime", "(J)V", "messageTime", "Ljava/lang/String;", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "message", "e", "Z", h.F, "()Z", "setVisible", "(Z)V", "isVisible", "notifyType", "<init>", "(ILcom/tencent/mobileqq/qqguildsdk/data/cq;JLjava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.message.directmessage.model.data.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class InboxNoticeNode {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private cq redPoint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long messageTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String message;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isVisible;

    public InboxNoticeNode(int i3, @NotNull cq redPoint, long j3, @NotNull String message, boolean z16) {
        Intrinsics.checkNotNullParameter(redPoint, "redPoint");
        Intrinsics.checkNotNullParameter(message, "message");
        this.type = i3;
        this.redPoint = redPoint;
        this.messageTime = j3;
        this.message = message;
        this.isVisible = z16;
    }

    public final boolean a() {
        boolean z16;
        if (this.message.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        this.message = "";
        return true;
    }

    @NotNull
    public final String b() {
        return "type=" + this.type + " isVisible=" + this.isVisible + " notifyType=" + e() + " messageTime=" + this.messageTime + " message=" + this.message + " redPoint=" + this.redPoint;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: d, reason: from getter */
    public final long getMessageTime() {
        return this.messageTime;
    }

    public final int e() {
        if (this.redPoint.f265934d == 0) {
            return 1;
        }
        return 3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxNoticeNode)) {
            return false;
        }
        InboxNoticeNode inboxNoticeNode = (InboxNoticeNode) other;
        if (this.type == inboxNoticeNode.type && Intrinsics.areEqual(this.redPoint, inboxNoticeNode.redPoint) && this.messageTime == inboxNoticeNode.messageTime && Intrinsics.areEqual(this.message, inboxNoticeNode.message) && this.isVisible == inboxNoticeNode.isVisible) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final cq getRedPoint() {
        return this.redPoint;
    }

    /* renamed from: g, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.type * 31) + this.redPoint.hashCode()) * 31) + androidx.fragment.app.a.a(this.messageTime)) * 31) + this.message.hashCode()) * 31;
        boolean z16 = this.isVisible;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final void i() {
        this.redPoint = new cq();
        this.messageTime = 0L;
        this.message = "";
        this.isVisible = false;
    }

    public final boolean j(@NotNull co guildNotice) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildNotice, "guildNotice");
        String newMessage = yp1.a.a(guildNotice);
        long j3 = guildNotice.f265887c;
        if (Intrinsics.areEqual(this.message, newMessage) && this.messageTime == j3) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(newMessage, "newMessage");
            this.message = newMessage;
            this.messageTime = j3;
        }
        return z16;
    }

    public final boolean k(@NotNull cq redPoint) {
        Intrinsics.checkNotNullParameter(redPoint, "redPoint");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("InboxNoticeNode", 2, "updateRedPoint(" + redPoint + ") " + System.identityHashCode(redPoint));
        }
        boolean z16 = !Intrinsics.areEqual(this.redPoint, redPoint);
        cq cqVar = new cq();
        cqVar.f265931a = redPoint.f265931a;
        cqVar.f265932b = redPoint.f265932b;
        cqVar.f265933c = redPoint.f265933c;
        cqVar.f265934d = redPoint.f265934d;
        this.redPoint = cqVar;
        return z16;
    }

    public final boolean l(boolean visible) {
        if (this.isVisible != visible) {
            this.isVisible = visible;
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "InboxNoticeNode(type=" + this.type + ", redPoint=" + this.redPoint + ", messageTime=" + this.messageTime + ", message=" + this.message + ", isVisible=" + this.isVisible + ")";
    }

    public /* synthetic */ InboxNoticeNode(int i3, cq cqVar, long j3, String str, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? new cq() : cqVar, (i16 & 4) != 0 ? 0L : j3, (i16 & 8) != 0 ? "" : str, (i16 & 16) != 0 ? true : z16);
    }
}
