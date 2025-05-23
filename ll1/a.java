package ll1;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStLike;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0007\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0000*\u00020\u0000\u00a8\u0006\t"}, d2 = {"Ljl1/b;", "newItemData", "", "c", "b", "d", "a", "e", "f", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    public static final boolean a(@NotNull jl1.b bVar, @NotNull jl1.b newItemData) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        if (bVar.getCommentData().createTime == newItemData.getCommentData().createTime && bVar.getCommentData().needFold == newItemData.getCommentData().needFold && bVar.getCommentData().sequence == newItemData.getCommentData().sequence) {
            return true;
        }
        return false;
    }

    public static final boolean b(@NotNull jl1.b bVar, @NotNull jl1.b newItemData) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        ArrayList<GProStRichTextContent> arrayList = bVar.getCommentData().richContents.contents;
        ArrayList<GProStRichTextContent> arrayList2 = newItemData.getCommentData().richContents.contents;
        return true;
    }

    public static final boolean c(@NotNull jl1.b bVar, @NotNull jl1.b newItemData) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        GProStUser gProStUser = bVar.getCommentData().postUser;
        GProStUser gProStUser2 = newItemData.getCommentData().postUser;
        if (gProStUser.nick.equals(gProStUser2.nick) && gProStUser.icon.iconUrl.equals(gProStUser2.icon.iconUrl) && gProStUser.nickFlag == gProStUser2.nickFlag) {
            return true;
        }
        return false;
    }

    public static final boolean d(@NotNull jl1.b bVar, @NotNull jl1.b newItemData) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        GProStLike gProStLike = bVar.getCommentData().likeInfo;
        GProStLike gProStLike2 = newItemData.getCommentData().likeInfo;
        if (gProStLike.count == gProStLike2.count && gProStLike.hasLikedCount == gProStLike2.hasLikedCount && gProStLike.status == gProStLike2.status) {
            return true;
        }
        return false;
    }

    public static final boolean e(@NotNull jl1.b bVar, @NotNull jl1.b newItemData) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        ArrayList<GProStReply> arrayList = bVar.getCommentData().vecReplyList;
        ArrayList<GProStReply> arrayList2 = newItemData.getCommentData().vecReplyList;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "newItemData.commentData.vecReplyList");
        if (arrayList.containsAll(arrayList2)) {
            ArrayList<GProStReply> arrayList3 = newItemData.getCommentData().vecReplyList;
            ArrayList<GProStReply> arrayList4 = bVar.getCommentData().vecReplyList;
            Intrinsics.checkNotNullExpressionValue(arrayList4, "commentData.vecReplyList");
            if (arrayList3.containsAll(arrayList4)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final jl1.b f(@NotNull jl1.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        return new jl1.b(bVar.getCommentData(), bVar.getSendStatus(), bVar.getCommonInfo(), bVar.f(), 0L, 16, null);
    }
}
