package jl1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Ljl1/a;", "newInfo", "", "a", "Ljl1/b;", "b", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {
    public static final boolean a(@NotNull CommentCommonInfo commentCommonInfo, @NotNull CommentCommonInfo newInfo) {
        Intrinsics.checkNotNullParameter(commentCommonInfo, "<this>");
        Intrinsics.checkNotNullParameter(newInfo, "newInfo");
        if (commentCommonInfo.getTotalReplyCount() == newInfo.getTotalReplyCount() && commentCommonInfo.getLocalReplyListCount() == newInfo.getLocalReplyListCount() && commentCommonInfo.getExpandReplyListCount() == newInfo.getExpandReplyListCount() && commentCommonInfo.getItemGroupPosition() == newInfo.getItemGroupPosition() && commentCommonInfo.getNextPageReply() == newInfo.getNextPageReply()) {
            return true;
        }
        return false;
    }

    public static final boolean b(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        return bVar.getCommentData().isTop;
    }
}
