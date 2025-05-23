package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data;

import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import hl1.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "", "b", "Lhl1/g;", "a", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    public static final boolean a(@NotNull g gVar) {
        boolean z16;
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        if (!(gVar instanceof FeedDetailMainData)) {
            return true;
        }
        if (((FeedDetailMainData) gVar).getFeedDetail().getFeedId().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (gVar.getItemType() == 12 && !((FeedDetailMainData) gVar).getFeedDetail().k()) {
            return true;
        }
        return false;
    }

    public static final boolean b(@NotNull GProStFeed gProStFeed) {
        Intrinsics.checkNotNullParameter(gProStFeed, "<this>");
        String str = gProStFeed.idd;
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }
}
