package jl1;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \"2\u00020\u0001:\u0001\tBE\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0017\u0012\u0018\b\u0002\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` \u0012\b\b\u0002\u0010*\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0001H\u0016R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR'\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010#R\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Ljl1/b;", "Lhl1/g;", "", "getItemType", "", "getItemId", "newItem", "", "b", "a", "", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "d", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "commentData", "I", "g", "()I", "i", "(I)V", "sendStatus", "Ljl1/a;", "Ljl1/a;", "e", "()Ljl1/a;", tl.h.F, "(Ljl1/a;)V", "commonInfo", "Ljava/util/ArrayList;", "Ljl1/h;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "f", "()Ljava/util/ArrayList;", "replyItemList", "J", "getSeq", "()J", "setSeq", "(J)V", "seq", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;ILjl1/a;Ljava/util/ArrayList;J)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements hl1.g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProStComment commentData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int sendStatus;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CommentCommonInfo commonInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<h> replyItemList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long seq;

    public b(@NotNull GProStComment commentData, int i3, @NotNull CommentCommonInfo commonInfo, @NotNull ArrayList<h> replyItemList, long j3) {
        Intrinsics.checkNotNullParameter(commentData, "commentData");
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(replyItemList, "replyItemList");
        this.commentData = commentData;
        this.sendStatus = i3;
        this.commonInfo = commonInfo;
        this.replyItemList = replyItemList;
        this.seq = j3;
    }

    @Override // hl1.g
    public boolean a(@NotNull hl1.g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof b)) {
            return false;
        }
        b bVar = (b) newItem;
        if (!c.a(this.commonInfo, bVar.commonInfo) || this.sendStatus != bVar.sendStatus || this.seq != bVar.seq || !ll1.a.c(this, bVar) || !ll1.a.d(this, bVar) || !ll1.a.a(this, bVar) || !ll1.a.e(this, bVar) || !ll1.a.b(this, bVar)) {
            return false;
        }
        return true;
    }

    @Override // hl1.g
    public boolean b(@NotNull hl1.g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof b)) {
            return false;
        }
        return this.commentData.idd.equals(((b) newItem).commentData.idd);
    }

    @Override // hl1.g
    @Nullable
    public Object c(@NotNull hl1.g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Boolean.TRUE;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final GProStComment getCommentData() {
        return this.commentData;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final CommentCommonInfo getCommonInfo() {
        return this.commonInfo;
    }

    @NotNull
    public final ArrayList<h> f() {
        return this.replyItemList;
    }

    /* renamed from: g, reason: from getter */
    public final int getSendStatus() {
        return this.sendStatus;
    }

    @Override // hl1.g
    public long getItemId() {
        return this.commentData.hashCode();
    }

    @Override // hl1.g
    public int getItemType() {
        return 6;
    }

    public final void h(@NotNull CommentCommonInfo commentCommonInfo) {
        Intrinsics.checkNotNullParameter(commentCommonInfo, "<set-?>");
        this.commonInfo = commentCommonInfo;
    }

    public final void i(int i3) {
        this.sendStatus = i3;
    }

    public /* synthetic */ b(GProStComment gProStComment, int i3, CommentCommonInfo commentCommonInfo, ArrayList arrayList, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(gProStComment, (i16 & 2) != 0 ? 0 : i3, commentCommonInfo, (i16 & 8) != 0 ? new ArrayList() : arrayList, (i16 & 16) != 0 ? 0L : j3);
    }
}
