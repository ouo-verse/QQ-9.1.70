package me;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedpro.section.ad.basepresenter.a;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedDeleteManager;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lme/f;", "Lcom/qzone/reborn/feedpro/section/ad/basepresenter/a;", "", tl.h.F, "", UserInfo.SEX_FEMALE, "G", "Landroid/view/View;", "v", NodeProps.ON_CLICK, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "K", "Ljava/lang/String;", "TAG", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "L", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "mFeedBackListener", "Lyd/a;", "M", "Lyd/a;", "getMAdFeedData", "()Lyd/a;", "setMAdFeedData", "(Lyd/a;)V", "mAdFeedData", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends com.qzone.reborn.feedpro.section.ad.basepresenter.a {

    /* renamed from: K, reason: from kotlin metadata */
    private final String TAG = "QZoneAdGdtFeedHeadSection";

    /* renamed from: L, reason: from kotlin metadata */
    private AdFeedbackDialogFragment.Listener mFeedBackListener;

    /* renamed from: M, reason: from kotlin metadata */
    private yd.a mAdFeedData;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(f this$0, AdFeedbackDialogFragment.Result result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (result.action != 3) {
            return;
        }
        qe.a aVar = qe.a.f428878a;
        yd.a aVar2 = this$0.mAdFeedData;
        aVar.d(aVar2 != null ? aVar2.getGdtAd() : null, 4, this$0.getMPosition());
        CommonFeed mFeedData = this$0.getMFeedData();
        if (mFeedData != null) {
            new QzoneFeedDeleteManager().removeFeedFromList(mFeedData);
        }
    }

    @Override // com.qzone.reborn.feedpro.section.ad.basepresenter.a
    public void F() {
        CommonFeed mFeedData = getMFeedData();
        this.mAdFeedData = mFeedData != null ? xd.c.h(mFeedData) : null;
        a.C0455a mAdFeedHeadData = getMAdFeedHeadData();
        String vaildImageUrl = GdtUIUtils.getVaildImageUrl(yd.b.c(this.mAdFeedData));
        Intrinsics.checkNotNullExpressionValue(vaildImageUrl, "getVaildImageUrl(mAdFeedData.getAdIconUrl())");
        mAdFeedHeadData.e(vaildImageUrl);
        getMAdFeedHeadData().f(yd.b.d(this.mAdFeedData));
        getMAdFeedHeadData().d(yd.b.a(this.mAdFeedData));
    }

    @Override // com.qzone.reborn.feedpro.section.ad.basepresenter.a
    public void G() {
        super.G();
        this.mFeedBackListener = new AdFeedbackDialogFragment.Listener() { // from class: me.e
            @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
            public final void onResult(AdFeedbackDialogFragment.Result result) {
                f.I(f.this, result);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            switch (v3.getId()) {
                case R.id.mlq /* 1745224409 */:
                    g6.c.f401419a.g(getActivity(), v3, this.mAdFeedData, FeedElement.USER_AVATAR, 2, getMPosition(), null);
                    break;
                case R.id.mmb /* 1745224431 */:
                    g6.c.f401419a.g(getActivity(), v3, this.mAdFeedData, FeedElement.SUMMARY, 4, getMPosition(), null);
                    break;
                case R.id.mmc /* 1745224432 */:
                    g6.c.f401419a.g(getActivity(), v3, this.mAdFeedData, FeedElement.FEEDBACK, 2001, getMPosition(), this.mFeedBackListener);
                    break;
                case R.id.mmr /* 1745224447 */:
                    g6.c.f401419a.g(getActivity(), v3, this.mAdFeedData, FeedElement.USER_NICKNAME, 3, getMPosition(), null);
                    break;
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // ne.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        this.mFeedBackListener = null;
    }
}
