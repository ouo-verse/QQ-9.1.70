package com.qzone.reborn.feedx.presenter.ad;

import android.app.Activity;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.presenter.ad.basepresenter.c;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/x;", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/c;", "", "k", "", "I", "J", "", "K", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class x extends com.qzone.reborn.feedx.presenter.ad.basepresenter.c {
    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.c
    public boolean I() {
        CellPictureInfo pictureInfo;
        ArrayList<PictureItem> arrayList;
        BusinessFeedData businessFeedData = this.f441565h;
        return (businessFeedData == null || (pictureInfo = businessFeedData.getPictureInfo()) == null || (arrayList = pictureInfo.pics) == null || !(arrayList.isEmpty() ^ true)) ? false : true;
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.c
    public boolean J() {
        Integer num;
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData != null) {
            num = Integer.valueOf(businessFeedData.isGDTAdvFeed() ? QZoneAdFeedDataExtKt.getGdtInnerAdShowType(businessFeedData) : Integer.MIN_VALUE);
        } else {
            num = null;
        }
        return num != null && num.intValue() == 2;
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.c
    public void K() {
        PictureUrl pictureUrl;
        c.a mAdFeedPicData = getMAdFeedPicData();
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData == null || (pictureUrl = QZoneAdFeedDataExtKt.getAdPicture(businessFeedData)) == null) {
            pictureUrl = new PictureUrl();
        }
        mAdFeedPicData.b(pictureUrl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "PSLink-QZoneAdGdtFeedPicPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null && v3.getId() == R.id.mvo) {
            QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
            Activity mActivity = this.C;
            Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
            BusinessFeedData mFeedData = this.f441565h;
            Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
            qZoneAdFeedUtils.H(mActivity, v3, mFeedData, FeedElement.PHOTO, 5, this.f441567m, null);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
