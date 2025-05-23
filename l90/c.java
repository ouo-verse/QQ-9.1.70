package l90;

import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.widget.QFSSearchResultLabelLayout;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private QFSSearchResultLabelLayout I;
    private QCircleAsyncTextView J;
    private TextView K;
    private TextView L;

    private void h1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.J.setSpecialClickAreaColor(R.color.qui_common_text_allwhite_primary);
        this.J.setNeedSpecialAreaBold(false);
        this.J.setNeedSpecialHashTagAreaBackground(false);
        this.J.setTransformationMethod(SingleLineTransformationMethod.getInstance());
        this.J.setText(feedCloudMeta$StFeed.content.get());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = (QFSSearchResultLabelLayout) view.findViewById(R.id.f43851nl);
        this.J = (QCircleAsyncTextView) view.findViewById(R.id.f516828r);
        this.K = (TextView) view.findViewById(R.id.f517128u);
        this.L = (TextView) view.findViewById(R.id.f57202mo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        this.I.a(feedCloudMeta$StFeed);
        this.L.setText(r.f(feedCloudMeta$StFeed.likeInfo.count.get()));
        this.K.setText(feedCloudMeta$StFeed.publishTimeDesc.get());
        h1(feedCloudMeta$StFeed);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchMixUserWidgetPresenter";
    }
}
