package com.qzone.reborn.feedx.presenter.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.qzone.common.event.EventCenter;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.presenter.ad.basepresenter.b;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/u;", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/b;", "", "k", "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", "", BdhLogUtil.LogTag.Tag_Conn, "M", "O", "v", NodeProps.ON_CLICK, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "N", "Ljava/lang/String;", "TAG", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "P", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "mFeedBackListener", "Landroid/widget/TextView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/TextView;", "getMAdTime", "()Landroid/widget/TextView;", "setMAdTime", "(Landroid/widget/TextView;)V", "mAdTime", "Lcom/tencent/gdtad/aditem/GdtAd;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/gdtad/aditem/GdtAd;", "getMAd", "()Lcom/tencent/gdtad/aditem/GdtAd;", "setMAd", "(Lcom/tencent/gdtad/aditem/GdtAd;)V", "mAd", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class u extends com.qzone.reborn.feedx.presenter.ad.basepresenter.b {

    /* renamed from: N, reason: from kotlin metadata */
    private final String TAG = "QZoneAdGdtFeedHeadPresenter";

    /* renamed from: P, reason: from kotlin metadata */
    private AdFeedbackDialogFragment.Listener mFeedBackListener;

    /* renamed from: Q, reason: from kotlin metadata */
    private TextView mAdTime;

    /* renamed from: R, reason: from kotlin metadata */
    private GdtAd mAd;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(u this$0, AdFeedbackDialogFragment.Result result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (result.action != 3) {
            return;
        }
        String feedsKey = this$0.f441565h.getFeedCommInfo().feedskey;
        Intrinsics.checkNotNullExpressionValue(feedsKey, "feedsKey");
        if (feedsKey.length() == 0) {
            return;
        }
        ih.f fVar = ih.f.f407629a;
        GdtAd gdtAd = this$0.mAd;
        String g16 = GdtFeedUtilForQZone.g(this$0.f441565h);
        if (g16 == null) {
            g16 = "0";
        }
        fVar.a(gdtAd, 4, Integer.parseInt(g16));
        if (this$0.f441565h.isGDTAdvFeed()) {
            BusinessFeedData businessFeedData = this$0.f441565h;
            if (businessFeedData.isSubFeed && !TextUtils.isEmpty(businessFeedData.parentFeedData.getFeedCommInfo().feedskey)) {
                feedsKey = this$0.f441565h.parentFeedData.getFeedCommInfo().feedskey;
            }
        }
        this$0.f441565h.cellNegativeFeedback = null;
        EventCenter eventCenter = EventCenter.getInstance();
        Intrinsics.checkNotNullExpressionValue(feedsKey, "feedsKey");
        eventCenter.post("WriteOperation", 38, feedsKey);
        if (Intrinsics.areEqual("1", GdtFeedUtilForQZone.g(this$0.f441565h))) {
            return;
        }
        try {
            com.qzone.reborn.feedx.viewmodel.q qVar = (com.qzone.reborn.feedx.viewmodel.q) this$0.r(com.qzone.reborn.feedx.viewmodel.q.class);
            if (qVar == null) {
                return;
            }
            QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
            BusinessFeedData businessFeedData2 = this$0.f441565h;
            UIStateData<List<BusinessFeedData>> value = qVar.T1().getValue();
            qZoneAdFeedUtils.d0(businessFeedData2, value != null ? value.getData() : null);
        } catch (Exception e16) {
            QLog.e(this$0.TAG, 1, "[updateAdHeadView] getViewModel error: " + e16);
        }
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.b, vg.a
    protected void C(View containerView) {
        super.C(containerView);
        this.mAdTime = containerView != null ? (TextView) containerView.findViewById(R.id.mms) : null;
        if (containerView != null) {
            int color = containerView.getResources().getColor(R.color.qui_common_text_secondary);
            TextView textView = this.mAdTime;
            if (textView != null) {
                textView.setTextColor(color);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.b
    public void M() {
        this.mAd = new GdtAd(GdtFeedUtilForQZone.f(this.f441565h));
        b.a mAdFeedHeadData = getMAdFeedHeadData();
        GdtAd gdtAd = this.mAd;
        String advertiser_corporate_logo = gdtAd != null ? gdtAd.getAdvertiser_corporate_logo() : null;
        if (advertiser_corporate_logo == null) {
            advertiser_corporate_logo = "";
        }
        mAdFeedHeadData.f(advertiser_corporate_logo);
        b.a mAdFeedHeadData2 = getMAdFeedHeadData();
        GdtAd gdtAd2 = this.mAd;
        String advertiser_corporate_image_name = gdtAd2 != null ? gdtAd2.getAdvertiser_corporate_image_name() : null;
        if (advertiser_corporate_image_name == null) {
            advertiser_corporate_image_name = "";
        }
        mAdFeedHeadData2.g(advertiser_corporate_image_name);
        b.a mAdFeedHeadData3 = getMAdFeedHeadData();
        String description = GdtAdFeedUtil.getDescription(this.f441565h);
        mAdFeedHeadData3.e(description != null ? description : "");
        getMAdFeedHeadData().h("\u4eca\u5929");
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.b
    public void O() {
        super.O();
        this.mFeedBackListener = new AdFeedbackDialogFragment.Listener() { // from class: com.qzone.reborn.feedx.presenter.ad.t
            @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
            public final void onResult(AdFeedbackDialogFragment.Result result) {
                u.Q(u.this, result);
            }
        };
        TextView textView = this.mAdTime;
        if (textView != null) {
            textView.setText(getMAdFeedHeadData().getAdTime());
        }
        TextView textView2 = this.mAdTime;
        if (textView2 == null) {
            return;
        }
        textView2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            int id5 = v3.getId();
            if (id5 == R.id.mlq) {
                QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
                Activity mActivity = this.C;
                Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
                BusinessFeedData mFeedData = this.f441565h;
                Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
                qZoneAdFeedUtils.H(mActivity, v3, mFeedData, FeedElement.USER_AVATAR, 2, this.f441567m, null);
            } else if (id5 != R.id.mmr) {
                switch (id5) {
                    case R.id.mmb /* 1745224431 */:
                        QZoneAdFeedUtils qZoneAdFeedUtils2 = QZoneAdFeedUtils.f55717a;
                        Activity mActivity2 = this.C;
                        Intrinsics.checkNotNullExpressionValue(mActivity2, "mActivity");
                        BusinessFeedData mFeedData2 = this.f441565h;
                        Intrinsics.checkNotNullExpressionValue(mFeedData2, "mFeedData");
                        qZoneAdFeedUtils2.H(mActivity2, v3, mFeedData2, FeedElement.SUMMARY, 4, this.f441567m, null);
                        break;
                    case R.id.mmc /* 1745224432 */:
                    case R.id.mmd /* 1745224433 */:
                        QZoneAdFeedUtils qZoneAdFeedUtils3 = QZoneAdFeedUtils.f55717a;
                        Activity mActivity3 = this.C;
                        Intrinsics.checkNotNullExpressionValue(mActivity3, "mActivity");
                        BusinessFeedData mFeedData3 = this.f441565h;
                        Intrinsics.checkNotNullExpressionValue(mFeedData3, "mFeedData");
                        qZoneAdFeedUtils3.H(mActivity3, v3, mFeedData3, FeedElement.FEEDBACK, 2001, this.f441567m, this.mFeedBackListener);
                        break;
                }
            } else {
                QZoneAdFeedUtils qZoneAdFeedUtils4 = QZoneAdFeedUtils.f55717a;
                Activity mActivity4 = this.C;
                Intrinsics.checkNotNullExpressionValue(mActivity4, "mActivity");
                BusinessFeedData mFeedData4 = this.f441565h;
                Intrinsics.checkNotNullExpressionValue(mFeedData4, "mFeedData");
                qZoneAdFeedUtils4.H(mActivity4, v3, mFeedData4, FeedElement.USER_NICKNAME, 3, this.f441567m, null);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        this.mFeedBackListener = null;
    }

    @Override // com.qzone.reborn.feedx.presenter.ad.basepresenter.b, vg.a
    protected boolean x() {
        return false;
    }
}
