package com.tencent.mobileqq.guild.feed.gallery.part;

import com.tencent.mobileqq.R;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/part/d;", "Lcom/tencent/mobileqq/guild/feed/gallery/part/GuildFeedCommentContainerPart;", "", "onBackEvent", "", "F9", "businessType", "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends GuildFeedCommentContainerPart {
    public d(int i3) {
        super(i3);
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedCommentContainerPart
    public int F9() {
        return R.id.w2t;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (!E9()) {
            return super.onBackEvent();
        }
        return true;
    }
}
