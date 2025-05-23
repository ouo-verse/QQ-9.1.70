package com.tencent.qqguild.directmessage.aio;

import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/DirectMessageNodeUpdateEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "", "isSticky", "", "toString", "", "hashCode", "", "other", "equals", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", "d", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", "b", "()Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", "node", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "nickName", "f", "getSource", "source", "<init>", "(Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final /* data */ class DirectMessageNodeUpdateEvent implements MsgIntent {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final DirectMessageNode node;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nickName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String source;

    public DirectMessageNodeUpdateEvent(@NotNull DirectMessageNode node, @NotNull String nickName, @NotNull String source) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(source, "source");
        this.node = node;
        this.nickName = nickName;
        this.source = source;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final DirectMessageNode getNode() {
        return this.node;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectMessageNodeUpdateEvent)) {
            return false;
        }
        DirectMessageNodeUpdateEvent directMessageNodeUpdateEvent = (DirectMessageNodeUpdateEvent) other;
        if (Intrinsics.areEqual(this.node, directMessageNodeUpdateEvent.node) && Intrinsics.areEqual(this.nickName, directMessageNodeUpdateEvent.nickName) && Intrinsics.areEqual(this.source, directMessageNodeUpdateEvent.source)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    public int hashCode() {
        return (((this.node.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.source.hashCode();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return true;
    }

    @NotNull
    public String toString() {
        return "DirectMessageNodeUpdateEvent(node=" + this.node + ", nickName=" + this.nickName + ", source=" + this.source + ")";
    }
}
