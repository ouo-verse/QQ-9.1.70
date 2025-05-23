package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section;

import android.view.ViewParent;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.ShortFeedPicLineSection;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001c\u0010\u0005\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\n\u001a\u0004\u0018\u00010\u0007*\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lqj1/l;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/IMediaDisplayable;", "", "d", "(Lqj1/l;)Z", NodeProps.CUSTOM_PROP_ISGIF, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/ShortFeedPicLineSection$SquareImageView;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/ShortFeedPicLineSection$ImageItemView;", "c", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/ShortFeedPicLineSection$SquareImageView;)Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/ShortFeedPicLineSection$ImageItemView;", "parentItemView", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class w {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortFeedPicLineSection.ImageItemView c(ShortFeedPicLineSection.SquareImageView squareImageView) {
        ViewParent parent = squareImageView.getParent();
        if (parent instanceof ShortFeedPicLineSection.ImageItemView) {
            return (ShortFeedPicLineSection.ImageItemView) parent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(qj1.l lVar) {
        if (lVar.getType() == 3) {
            return true;
        }
        return false;
    }
}
