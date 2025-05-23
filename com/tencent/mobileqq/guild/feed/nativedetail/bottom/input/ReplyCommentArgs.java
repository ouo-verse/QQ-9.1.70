package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\tB5\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u0014\u0010\u001aR\"\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u000f\u0010\u001e\"\u0004\b\u001f\u0010 R\u0019\u0010$\u001a\n \"*\u0004\u0018\u00010\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "f", "()I", "replyType", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "comment", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "d", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "reply", "Ljava/lang/Object;", "()Ljava/lang/Object;", "payload", "e", "Z", "()Z", "g", "(Z)V", "needSyncToGroup", "kotlin.jvm.PlatformType", "()Ljava/lang/String;", "replyTargetId", "<init>", "(ILcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;Ljava/lang/Object;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.h, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class ReplyCommentArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int replyType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GProStComment comment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final GProStReply reply;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Object payload;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean needSyncToGroup;

    public ReplyCommentArgs(int i3, @NotNull GProStComment comment, @Nullable GProStReply gProStReply, @Nullable Object obj, boolean z16) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        this.replyType = i3;
        this.comment = comment;
        this.reply = gProStReply;
        this.payload = obj;
        this.needSyncToGroup = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final GProStComment getComment() {
        return this.comment;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getNeedSyncToGroup() {
        return this.needSyncToGroup;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Object getPayload() {
        return this.payload;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final GProStReply getReply() {
        return this.reply;
    }

    public final String e() {
        if (this.replyType == 1) {
            return this.comment.idd;
        }
        GProStReply gProStReply = this.reply;
        Intrinsics.checkNotNull(gProStReply);
        return gProStReply.idd;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReplyCommentArgs)) {
            return false;
        }
        ReplyCommentArgs replyCommentArgs = (ReplyCommentArgs) other;
        if (this.replyType == replyCommentArgs.replyType && Intrinsics.areEqual(this.comment, replyCommentArgs.comment) && Intrinsics.areEqual(this.reply, replyCommentArgs.reply) && Intrinsics.areEqual(this.payload, replyCommentArgs.payload) && this.needSyncToGroup == replyCommentArgs.needSyncToGroup) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getReplyType() {
        return this.replyType;
    }

    public final void g(boolean z16) {
        this.needSyncToGroup = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.replyType * 31) + this.comment.hashCode()) * 31;
        GProStReply gProStReply = this.reply;
        int i3 = 0;
        if (gProStReply == null) {
            hashCode = 0;
        } else {
            hashCode = gProStReply.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        Object obj = this.payload;
        if (obj != null) {
            i3 = obj.hashCode();
        }
        int i17 = (i16 + i3) * 31;
        boolean z16 = this.needSyncToGroup;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        return i17 + i18;
    }

    @NotNull
    public String toString() {
        return "ReplyCommentArgs(replyType=" + this.replyType + ", comment=" + this.comment + ", reply=" + this.reply + ", payload=" + this.payload + ", needSyncToGroup=" + this.needSyncToGroup + ")";
    }

    public /* synthetic */ ReplyCommentArgs(int i3, GProStComment gProStComment, GProStReply gProStReply, Object obj, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, gProStComment, gProStReply, obj, (i16 & 16) != 0 ? false : z16);
    }
}
