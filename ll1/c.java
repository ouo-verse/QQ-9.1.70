package ll1;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStLike;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import jl1.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0007"}, d2 = {"Ljl1/h;", "newItemData", "", "d", "b", "c", "a", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {
    public static final boolean a(@NotNull h hVar, @NotNull h newItemData) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        if (hVar.getReplyData().createTime == newItemData.getReplyData().createTime && hVar.getReplyData().needFold == newItemData.getReplyData().needFold) {
            return true;
        }
        return false;
    }

    public static final boolean b(@NotNull h hVar, @NotNull h newItemData) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        GProStUser gProStUser = hVar.getReplyData().postUser;
        GProStUser gProStUser2 = newItemData.getReplyData().postUser;
        if (gProStUser.nick.equals(gProStUser2.nick) && gProStUser.icon.iconUrl.equals(gProStUser2.icon.iconUrl) && gProStUser.nickFlag == gProStUser2.nickFlag) {
            return true;
        }
        return false;
    }

    public static final boolean c(@NotNull h hVar, @NotNull h newItemData) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        GProStLike gProStLike = hVar.getReplyData().likeInfo;
        GProStLike gProStLike2 = newItemData.getReplyData().likeInfo;
        if (gProStLike.count == gProStLike2.count && gProStLike.hasLikedCount == gProStLike2.hasLikedCount && gProStLike.status == gProStLike2.status) {
            return true;
        }
        return false;
    }

    public static final boolean d(@NotNull h hVar, @NotNull h newItemData) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        if (hVar.getReplyListPosition() == newItemData.getReplyListPosition() && hVar.getSendStatus() == newItemData.getSendStatus()) {
            return true;
        }
        return false;
    }
}
