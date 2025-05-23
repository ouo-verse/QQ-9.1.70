package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
/* synthetic */ class GuildFeedSquareFeedItemView$isInScrollingContainer$2 extends FunctionReferenceImpl implements Function0<ViewParent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildFeedSquareFeedItemView$isInScrollingContainer$2(Object obj) {
        super(0, obj, GuildFeedSquareFeedItemView.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewParent invoke() {
        return ((GuildFeedSquareFeedItemView) this.receiver).getParent();
    }
}
