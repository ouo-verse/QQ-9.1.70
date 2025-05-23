package jl1;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00102\u00020\u0001:\u0001\tB)\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0019\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017\u00a8\u0006%"}, d2 = {"Ljl1/h;", "Lhl1/g;", "", "getItemType", "", "getItemId", "newItem", "", "b", "a", "", "c", "", "toString", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "e", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "replyData", "I", "f", "()I", "setReplyListPosition", "(I)V", "replyListPosition", "Ljl1/a;", "Ljl1/a;", "d", "()Ljl1/a;", "setCommonInfo", "(Ljl1/a;)V", "commonInfo", "g", tl.h.F, "sendStatus", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;ILjl1/a;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h implements hl1.g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProStReply replyData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int replyListPosition;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CommentCommonInfo commonInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int sendStatus;

    public h(@NotNull GProStReply replyData, int i3, @NotNull CommentCommonInfo commonInfo, int i16) {
        Intrinsics.checkNotNullParameter(replyData, "replyData");
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        this.replyData = replyData;
        this.replyListPosition = i3;
        this.commonInfo = commonInfo;
        this.sendStatus = i16;
    }

    @Override // hl1.g
    public boolean a(@NotNull hl1.g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof h)) {
            return false;
        }
        h hVar = (h) newItem;
        if (!c.a(this.commonInfo, hVar.commonInfo) || !ll1.c.d(this, hVar) || !ll1.c.c(this, hVar) || !ll1.c.a(this, hVar) || !ll1.c.b(this, hVar)) {
            return false;
        }
        return true;
    }

    @Override // hl1.g
    public boolean b(@NotNull hl1.g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof h)) {
            return false;
        }
        return this.replyData.idd.equals(((h) newItem).replyData.idd);
    }

    @Override // hl1.g
    @Nullable
    public Object c(@NotNull hl1.g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Boolean.TRUE;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final CommentCommonInfo getCommonInfo() {
        return this.commonInfo;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final GProStReply getReplyData() {
        return this.replyData;
    }

    /* renamed from: f, reason: from getter */
    public final int getReplyListPosition() {
        return this.replyListPosition;
    }

    /* renamed from: g, reason: from getter */
    public final int getSendStatus() {
        return this.sendStatus;
    }

    @Override // hl1.g
    public long getItemId() {
        return this.replyData.hashCode();
    }

    @Override // hl1.g
    public int getItemType() {
        return 7;
    }

    public final void h(int i3) {
        this.sendStatus = i3;
    }

    @NotNull
    public String toString() {
        return "commonInfo = " + this.commonInfo + ", replyListPosition = " + this.replyListPosition;
    }
}
