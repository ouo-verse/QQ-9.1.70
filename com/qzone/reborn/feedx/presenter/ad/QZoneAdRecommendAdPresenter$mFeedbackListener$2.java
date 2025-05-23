package com.qzone.reborn.feedx.presenter.ad;

import android.text.TextUtils;
import com.qzone.common.event.EventCenter;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
final class QZoneAdRecommendAdPresenter$mFeedbackListener$2 extends Lambda implements Function0<AdFeedbackDialogFragment.Listener> {
    final /* synthetic */ QZoneAdRecommendAdPresenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAdRecommendAdPresenter$mFeedbackListener$2(QZoneAdRecommendAdPresenter qZoneAdRecommendAdPresenter) {
        super(0);
        this.this$0 = qZoneAdRecommendAdPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QZoneAdRecommendAdPresenter this$0, AdFeedbackDialogFragment.Result result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (result.action != 3) {
            return;
        }
        String feedsKey = ((vg.a) this$0).f441565h.getFeedCommInfo().feedskey;
        Intrinsics.checkNotNullExpressionValue(feedsKey, "feedsKey");
        if (feedsKey.length() == 0) {
            return;
        }
        if (((vg.a) this$0).f441565h.isGDTAdvFeed() && ((vg.a) this$0).f441565h.isSubFeed && !TextUtils.isEmpty(((vg.a) this$0).f441565h.parentFeedData.getFeedCommInfo().feedskey)) {
            feedsKey = ((vg.a) this$0).f441565h.parentFeedData.getFeedCommInfo().feedskey;
        }
        ((vg.a) this$0).f441565h.cellNegativeFeedback = null;
        EventCenter eventCenter = EventCenter.getInstance();
        Intrinsics.checkNotNullExpressionValue(feedsKey, "feedsKey");
        eventCenter.post("WriteOperation", 38, feedsKey);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AdFeedbackDialogFragment.Listener invoke() {
        final QZoneAdRecommendAdPresenter qZoneAdRecommendAdPresenter = this.this$0;
        return new AdFeedbackDialogFragment.Listener() { // from class: com.qzone.reborn.feedx.presenter.ad.z
            @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
            public final void onResult(AdFeedbackDialogFragment.Result result) {
                QZoneAdRecommendAdPresenter$mFeedbackListener$2.b(QZoneAdRecommendAdPresenter.this, result);
            }
        };
    }
}
