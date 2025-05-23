package com.qzone.reborn.feedx.itemview.ad;

import android.content.Context;
import android.view.View;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.presenter.ad.reward.QZoneAdRewardFeedExposePresenter;
import com.qzone.reborn.feedx.presenter.ad.reward.QZoneAdRewardFeedHeadPresenter;
import com.qzone.reborn.feedx.presenter.ad.reward.QZoneAdRewardFeedPresenter;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vg.a;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0016\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006H\u0014J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/feedx/itemview/ad/QZoneAdRewardFeedItemView;", "Lcom/qzone/reborn/feedx/itemview/QZoneBaseFeedItemView;", "", "getLayoutId", "", "getLogTag", "", "Ljava/lang/Class;", "Lvg/a;", "s0", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "E", "Ljava/lang/String;", "TAG", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAdRewardFeedItemView extends QZoneBaseFeedItemView {

    /* renamed from: E, reason: from kotlin metadata */
    private final String TAG;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAdRewardFeedItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "QZoneAdRewardFeedItemView";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cf7;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag, reason: from getter */
    protected String getTAG() {
        return this.TAG;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends a>> s0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QZoneAdRewardFeedHeadPresenter.class);
        arrayList.add(QZoneAdRewardFeedPresenter.class);
        arrayList.add(QZoneAdRewardFeedExposePresenter.class);
        return arrayList;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView, android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
