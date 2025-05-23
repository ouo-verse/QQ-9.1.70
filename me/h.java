package me;

import android.app.Activity;
import android.view.View;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lme/h;", "Lcom/qzone/reborn/feedpro/section/ad/basepresenter/b;", "", tl.h.F, "", "G", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h extends com.qzone.reborn.feedpro.section.ad.basepresenter.b {
    @Override // com.qzone.reborn.feedpro.section.ad.basepresenter.b
    public void G() {
        getMAdFeedPicData().b(yd.b.e(getMAdFeedData()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.section.ad.basepresenter.b, ne.a
    public String h() {
        return "PSLink-QZoneAdGdtFeedPicPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Activity activity;
        yd.a mAdFeedData;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null && v3.getId() == R.id.mvo && (activity = getActivity()) != null && (mAdFeedData = getMAdFeedData()) != null) {
            g6.c.f401419a.g(activity, v3, mAdFeedData, FeedElement.PHOTO, 5, getMPosition(), null);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
