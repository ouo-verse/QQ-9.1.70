package ll1;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStLike;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStLike;", "a", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {
    @NotNull
    public static final GProStLike a(@NotNull GProStLike gProStLike) {
        Intrinsics.checkNotNullParameter(gProStLike, "<this>");
        GProStLike gProStLike2 = new GProStLike();
        gProStLike2.idd = gProStLike.idd;
        gProStLike2.count = gProStLike.count;
        gProStLike2.status = gProStLike.status;
        gProStLike2.jumpUrl = gProStLike.jumpUrl;
        gProStLike2.busiData = gProStLike.busiData;
        gProStLike2.postUser = gProStLike.postUser;
        gProStLike2.vecUserList = gProStLike.vecUserList;
        gProStLike2.ownerStatus = gProStLike.ownerStatus;
        gProStLike2.hasLikedCount = gProStLike.hasLikedCount;
        return gProStLike2;
    }
}
