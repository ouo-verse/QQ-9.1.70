package com.tencent.mobileqq.guild.discoveryv2.content.part;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.api.FeedListDelegateSectionFactory;
import com.tencent.mobileqq.guild.api.IGuildFeedLayoutApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u00a8\u0006\u0003"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RecyclerView.RecycledViewPool recycledViewPool) {
        FeedListDelegateSectionFactory.DefaultImpls.b(((IGuildFeedLayoutApi) QRoute.api(IGuildFeedLayoutApi.class)).getRecommendFeedFactory(), recycledViewPool, null, 2, null);
    }
}
