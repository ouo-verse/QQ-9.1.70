package oo2;

import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import lo2.z;
import wo2.b;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private static final int Q = ViewUtils.dip2px(20.0f);
    private z I;
    private TextView J;
    private QCircleAvatarView K;
    private TextView L;
    private TextView M;
    private TextView N;
    private int P;

    /* JADX WARN: Multi-variable type inference failed */
    private void j1() {
        this.K.setVisibility(0);
        String str = ((FeedCloudMeta$StFeed) this.f85017h).poster.icon.iconUrl.get();
        if (!TextUtils.isEmpty(str)) {
            QCircleAvatarView qCircleAvatarView = this.K;
            int i3 = Q;
            qCircleAvatarView.setAvatarByUrl(str, new Size(i3, i3));
            return;
        }
        String str2 = ((FeedCloudMeta$StFeed) this.f85017h).poster.f398463id.get();
        if (!TextUtils.isEmpty(str2)) {
            QCircleAvatarView qCircleAvatarView2 = this.K;
            int i16 = Q;
            qCircleAvatarView2.setAvatarByUin(str2, new Size(i16, i16));
            return;
        }
        this.K.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void k1() {
        List<FeedCloudCommon$Entry> list = ((FeedCloudMeta$StFeed) this.f85017h).extInfo.get();
        if (list != null && !list.isEmpty()) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
                if (feedCloudCommon$Entry != null && "tag".equals(feedCloudCommon$Entry.key.get())) {
                    String str = feedCloudCommon$Entry.value.get();
                    if (!TextUtils.isEmpty(str)) {
                        this.M.setVisibility(0);
                        this.M.setText(str);
                        return;
                    }
                }
            }
        }
        this.M.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void l1() {
        String str = ((FeedCloudMeta$StFeed) this.f85017h).content.get();
        if (TextUtils.isEmpty(str)) {
            this.J.setVisibility(8);
            return;
        }
        this.J.setVisibility(0);
        this.J.setText(b.a(this.J, this.P, str, this.I.L));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.J = (TextView) view.findViewById(R.id.title);
        this.K = (QCircleAvatarView) view.findViewById(R.id.a2o);
        this.L = (TextView) view.findViewById(R.id.f5e);
        this.M = (TextView) view.findViewById(R.id.kbj);
        this.N = (TextView) view.findViewById(R.id.f25690bi);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.L.setText(feedCloudMeta$StFeed.poster.nick.get());
        this.N.setText(r.f(feedCloudMeta$StFeed.visitorInfo.viewCount.get()));
        l1();
        j1();
        k1();
    }

    public void h1(int i3) {
        this.P = i3;
    }

    public void i1(z zVar) {
        this.I = zVar;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QCircleSearchDoubleVideoWidgetPresenter";
    }
}
