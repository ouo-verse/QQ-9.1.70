package m40;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchLikeImageView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QFSLikeImageView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lm40/d;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/Observer;", "Le30/b;", "feed", "", "i1", "j1", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "data", "", "position", "g1", "v", NodeProps.ON_CLICK, "", "w0", "K0", "M0", "feedBlockData", "h1", "Lcom/tencent/biz/qqcircle/immersive/views/search/widget/QFSSearchLikeImageView;", "I", "Lcom/tencent/biz/qqcircle/immersive/views/search/widget/QFSSearchLikeImageView;", "likeView", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "likeNum", "", "K", "Z", "isLiked", "L", "Ljava/lang/String;", "contentType", "<init>", "()V", "M", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener, Observer<e30.b> {

    /* renamed from: I, reason: from kotlin metadata */
    private QFSSearchLikeImageView likeView;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView likeNum;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isLiked;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String contentType = "";

    private final void i1(FeedCloudMeta$StFeed feed) {
        QFSSearchLikeImageView qFSSearchLikeImageView = this.likeView;
        QFSSearchLikeImageView qFSSearchLikeImageView2 = null;
        if (qFSSearchLikeImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeView");
            qFSSearchLikeImageView = null;
        }
        qFSSearchLikeImageView.setData(feed);
        boolean z16 = true;
        if (feed.likeInfo.status.get() != 1) {
            z16 = false;
        }
        this.isLiked = z16;
        QFSSearchLikeImageView qFSSearchLikeImageView3 = this.likeView;
        if (qFSSearchLikeImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeView");
        } else {
            qFSSearchLikeImageView2 = qFSSearchLikeImageView3;
        }
        qFSSearchLikeImageView2.n(this.isLiked);
    }

    private final void j1(FeedCloudMeta$StFeed feed) {
        TextView textView = null;
        if (feed.likeInfo.count.get() <= 0) {
            TextView textView2 = this.likeNum;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("likeNum");
                textView2 = null;
            }
            textView2.setText(R.string.f193704_x);
            TextView textView3 = this.likeNum;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("likeNum");
            } else {
                textView = textView3;
            }
            textView.setContentDescription(com.tencent.biz.qqcircle.utils.h.a(R.string.f1909843k));
            return;
        }
        TextView textView4 = this.likeNum;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeNum");
            textView4 = null;
        }
        textView4.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(feed.likeInfo.count.get()));
        TextView textView5 = this.likeNum;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeNum");
            textView5 = null;
        }
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f187813v0);
        TextView textView6 = this.likeNum;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeNum");
        } else {
            textView = textView6;
        }
        textView5.setContentDescription(a16 + ((Object) textView.getText()));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        if (this.E != null) {
            w20.a.j().removeObserverGlobalState(this.E, this);
            w20.a.j().observerGlobalState(this.E, this);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        if (this.E != null) {
            w20.a.j().removeObserverGlobalState(this.E, this);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        View findViewById = rootView.findViewById(R.id.f45761sr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026near_feed_feed_like_icon)");
        this.likeView = (QFSSearchLikeImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f45771ss);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026near_feed_feed_like_text)");
        TextView textView = (TextView) findViewById2;
        this.likeNum = textView;
        QFSSearchLikeImageView qFSSearchLikeImageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeNum");
            textView = null;
        }
        textView.setOnClickListener(this);
        QFSSearchLikeImageView qFSSearchLikeImageView2 = this.likeView;
        if (qFSSearchLikeImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeView");
            qFSSearchLikeImageView2 = null;
        }
        qFSSearchLikeImageView2.setItemPreClickListener(new QFSLikeImageView.d() { // from class: m40.c
        });
        QFSSearchLikeImageView qFSSearchLikeImageView3 = this.likeView;
        if (qFSSearchLikeImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeView");
        } else {
            qFSSearchLikeImageView = qFSSearchLikeImageView3;
        }
        qFSSearchLikeImageView.setDrawablePadding(cx.a(4.0f));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull FeedCloudMeta$StFeed data, int position) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        super.L0(data, position);
        i1(data);
        j1(data);
        Object b16 = this.E.b("KEY_LINEAR_FEED_CONTENT_TYPE");
        QFSSearchLikeImageView qFSSearchLikeImageView = null;
        if (b16 instanceof String) {
            str = (String) b16;
        } else {
            str = null;
        }
        if (str != null) {
            this.contentType = str;
        }
        QFSSearchLikeImageView qFSSearchLikeImageView2 = this.likeView;
        if (qFSSearchLikeImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeView");
            qFSSearchLikeImageView2 = null;
        }
        VideoReport.setElementId(qFSSearchLikeImageView2, QCircleDaTongConstant.ElementId.EM_XSJ_LIKE_BUTTON);
        QFSSearchLikeImageView qFSSearchLikeImageView3 = this.likeView;
        if (qFSSearchLikeImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeView");
        } else {
            qFSSearchLikeImageView = qFSSearchLikeImageView3;
        }
        VideoReport.setElementClickPolicy(qFSSearchLikeImageView, ClickPolicy.REPORT_NONE);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable e30.b feedBlockData) {
        FeedCloudMeta$StFeed g16;
        if (feedBlockData != null && (g16 = feedBlockData.g()) != null) {
            i1(g16);
            j1(g16);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        QFSSearchLikeImageView qFSSearchLikeImageView = this.likeView;
        QFSSearchLikeImageView qFSSearchLikeImageView2 = null;
        if (qFSSearchLikeImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeView");
            qFSSearchLikeImageView = null;
        }
        QFSSearchLikeImageView qFSSearchLikeImageView3 = this.likeView;
        if (qFSSearchLikeImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeView");
        } else {
            qFSSearchLikeImageView2 = qFSSearchLikeImageView3;
        }
        qFSSearchLikeImageView.onClick(qFSSearchLikeImageView2);
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSLinearFeedLikePresenter";
    }
}
