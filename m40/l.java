package m40;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.utils.au;
import com.tencent.biz.qqcircle.widgets.QFSPressEffectImageView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lm40/l;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Landroid/view/View$OnClickListener;", "feed", "", "j1", "Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "g1", "", "h1", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "data", "position", "i1", "v", NodeProps.ON_CLICK, "", "w0", "Landroid/widget/LinearLayout;", "I", "Landroid/widget/LinearLayout;", "shareLayout", "Lcom/tencent/biz/qqcircle/widgets/QFSPressEffectImageView;", "J", "Lcom/tencent/biz/qqcircle/widgets/QFSPressEffectImageView;", "shareView", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "shareNum", "L", "Ljava/lang/String;", "contentType", "<init>", "()V", "M", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class l extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {

    /* renamed from: I, reason: from kotlin metadata */
    private LinearLayout shareLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private QFSPressEffectImageView shareView;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView shareNum;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String contentType = "";

    /* JADX WARN: Multi-variable type inference failed */
    private final QCircleShareInfo g1() {
        QCircleShareInfo c16 = au.c((FeedCloudMeta$StFeed) this.f85017h);
        c16.isShowBarrageSwitch = false;
        c16.isShareBottomBarrageSwitch = com.tencent.biz.qqcircle.immersive.utils.o.e((FeedCloudMeta$StFeed) this.f85017h);
        c16.isShowPlayRate = false;
        c16.feedBlockData = this.E;
        c16.extraTypeInfo.mDataPosition = this.f85018i;
        c16.feed = (FeedCloudMeta$StFeed) this.f85017h;
        c16.mReportBean = getReportBean();
        c16.source = h1();
        Intrinsics.checkNotNullExpressionValue(c16, "createShareInfo(mData).a\u2026rePanelSource()\n        }");
        return c16;
    }

    private final int h1() {
        String str = this.contentType;
        if (Intrinsics.areEqual(str, "article")) {
            return 13;
        }
        if (Intrinsics.areEqual(str, "feed")) {
            return 14;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [com.tencent.biz.qqcircle.widgets.QFSPressEffectImageView] */
    private final void j1(FeedCloudMeta$StFeed feed) {
        TextView textView = null;
        if (feed.share.sharedCount.get() <= 0) {
            TextView textView2 = this.shareNum;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareNum");
                textView2 = null;
            }
            textView2.setText(R.string.f184893n4);
            ?? r75 = this.shareView;
            if (r75 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("shareView");
            } else {
                textView = r75;
            }
            textView.setContentDescription(com.tencent.biz.qqcircle.utils.h.a(R.string.f184893n4));
            return;
        }
        TextView textView3 = this.shareNum;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareNum");
            textView3 = null;
        }
        textView3.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(feed.share.sharedCount.get()));
        QFSPressEffectImageView qFSPressEffectImageView = this.shareView;
        if (qFSPressEffectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareView");
            qFSPressEffectImageView = null;
        }
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f187833v2);
        TextView textView4 = this.shareNum;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareNum");
        } else {
            textView = textView4;
        }
        qFSPressEffectImageView.setContentDescription(a16 + ((Object) textView.getText()));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        View findViewById = rootView.findViewById(R.id.f45841sz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026linear_feed_share_layout)");
        this.shareLayout = (LinearLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f45781st);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ear_feed_feed_share_icon)");
        this.shareView = (QFSPressEffectImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f45791su);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026ear_feed_feed_share_text)");
        this.shareNum = (TextView) findViewById3;
        LinearLayout linearLayout = this.shareLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull FeedCloudMeta$StFeed data, int position) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        super.L0(data, position);
        j1(data);
        Object b16 = this.E.b("KEY_LINEAR_FEED_CONTENT_TYPE");
        LinearLayout linearLayout = null;
        if (b16 instanceof String) {
            str = (String) b16;
        } else {
            str = null;
        }
        if (str != null) {
            this.contentType = str;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CONTENT_TYPE, this.contentType);
        LinearLayout linearLayout2 = this.shareLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
        } else {
            linearLayout = linearLayout2;
        }
        g0(linearLayout, "em_xsj_share_button", hashMap);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        t40.a s06 = s0();
        if (s06 != null) {
            s06.onHandlerMessage("event_open_share", g1());
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSLinearFeedSharePresenter";
    }
}
