package m40;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.utils.bk;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lm40/k;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Lcom/tencent/biz/qqcircle/immersive/views/banner/QFSImageBanner$c;", "Landroid/view/View$OnClickListener;", "", "i1", "Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;", "h1", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "data", "", "position", "j1", "", "w0", "onItemClick", "v", NodeProps.ON_CLICK, "Q0", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedUnSelected", "Lcom/tencent/biz/qqcircle/widgets/QFSExpandableAsyncTextView;", "I", "Lcom/tencent/biz/qqcircle/widgets/QFSExpandableAsyncTextView;", "descTv", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", "coverView", "K", "picIcon", "Lcom/tencent/biz/qqcircle/immersive/views/banner/QFSImageBanner;", "L", "Lcom/tencent/biz/qqcircle/immersive/views/banner/QFSImageBanner;", "imageBannerView", "Lp80/e;", "M", "Lp80/e;", "adapter", "<init>", "()V", "N", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class k extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements QFSImageBanner.c, View.OnClickListener {

    /* renamed from: I, reason: from kotlin metadata */
    private QFSExpandableAsyncTextView descTv;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView coverView;

    /* renamed from: K, reason: from kotlin metadata */
    private ImageView picIcon;

    /* renamed from: L, reason: from kotlin metadata */
    private QFSImageBanner imageBannerView;

    /* renamed from: M, reason: from kotlin metadata */
    private p80.e adapter;

    /* JADX WARN: Multi-variable type inference failed */
    private final QCircleLayerBean h1() {
        QCircleInitBean qCircleInitBean;
        int i3;
        String str;
        Fragment hostFragment;
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setFeed((FeedCloudMeta$StFeed) this.f85017h);
        qCircleLayerBean.setUseLoadingPic(true);
        qCircleLayerBean.setSourceType(92);
        qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
        qCircleLayerBean.setFeedListBusiReqData(new QQCircleFeedBase$StFeedListBusiReqData());
        qCircleLayerBean.setFromReportBean(getReportBean().m466clone());
        t40.a s06 = s0();
        ImageView imageView = null;
        if (s06 != null) {
            qCircleInitBean = s06.getInitBean();
        } else {
            qCircleInitBean = null;
        }
        qCircleLayerBean.setTransInitBean(qCircleInitBean);
        t40.a s07 = s0();
        if (s07 != null && (hostFragment = s07.getHostFragment()) != null) {
            i3 = hostFragment.hashCode();
        } else {
            i3 = 0;
        }
        qCircleLayerBean.setPageCode(i3);
        qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
        t40.a s08 = s0();
        if (s08 != null) {
            str = s08.getViewModelKey();
        } else {
            str = null;
        }
        qCircleLayerBean.setGlobalViewModelKey(str);
        int[] iArr = new int[2];
        ImageView imageView2 = this.coverView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverView");
            imageView2 = null;
        }
        imageView2.getLocationInWindow(iArr);
        QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
        int i16 = iArr[0];
        int i17 = iArr[1];
        ImageView imageView3 = this.coverView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverView");
            imageView3 = null;
        }
        int width = imageView3.getWidth() + i16;
        int i18 = iArr[1];
        ImageView imageView4 = this.coverView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverView");
            imageView4 = null;
        }
        qCircleLayerBean.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i16, i17, width, i18 + imageView4.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(((FeedCloudMeta$StFeed) this.f85017h).cover.picUrl.get()));
        QFSTransitionAnimBean transitionAnimBean = qCircleLayerBean.getTransitionAnimBean();
        ImageView imageView5 = this.coverView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverView");
        } else {
            imageView = imageView5;
        }
        transitionAnimBean.setCoverDrawable(imageView.getDrawable());
        return qCircleLayerBean;
    }

    private final void i1() {
        com.tencent.biz.qqcircle.launcher.c.u(m0(), h1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(k this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSImageBanner qFSImageBanner = this$0.imageBannerView;
        if (qFSImageBanner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageBannerView");
            qFSImageBanner = null;
        }
        qFSImageBanner.setCurrentItem(0, false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        View findViewById = rootView.findViewById(R.id.f365814y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qfs_desc_text)");
        this.descTv = (QFSExpandableAsyncTextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f363914f);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qfs_cover_view)");
        this.coverView = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f4890219);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.qfs_pic_icon)");
        this.picIcon = (ImageView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f516728q);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026fs_recommend_card_banner)");
        this.imageBannerView = (QFSImageBanner) findViewById4;
        p80.e eVar = new p80.e();
        this.adapter = eVar;
        eVar.setEnableLoop(true);
        QFSImageBanner qFSImageBanner = this.imageBannerView;
        QFSImageBanner qFSImageBanner2 = null;
        if (qFSImageBanner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageBannerView");
            qFSImageBanner = null;
        }
        p80.e eVar2 = this.adapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            eVar2 = null;
        }
        qFSImageBanner.setAdapter(eVar2);
        QFSImageBanner qFSImageBanner3 = this.imageBannerView;
        if (qFSImageBanner3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageBannerView");
            qFSImageBanner3 = null;
        }
        qFSImageBanner3.setEnableOperate(false);
        QFSImageBanner qFSImageBanner4 = this.imageBannerView;
        if (qFSImageBanner4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageBannerView");
            qFSImageBanner4 = null;
        }
        qFSImageBanner4.setOnItemClickListener(this);
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView = this.descTv;
        if (qFSExpandableAsyncTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTv");
            qFSExpandableAsyncTextView = null;
        }
        qFSExpandableAsyncTextView.setOnClickListener(this);
        ImageView imageView = this.coverView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverView");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        QFSImageBanner qFSImageBanner5 = this.imageBannerView;
        if (qFSImageBanner5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageBannerView");
        } else {
            qFSImageBanner2 = qFSImageBanner5;
        }
        qFSImageBanner2.X().setOffscreenPageLimit(1);
        View findViewById5 = rootView.findViewById(R.id.f45831sy);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026ear_feed_media_container)");
        bk.d((RelativeLayout) findViewById5, 10);
        View findViewById6 = rootView.findViewById(R.id.f363514b);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.qfs_control_icon)");
        ((ImageView) findViewById6).setVisibility(8);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void Q0() {
        R0(1, 1, r(), "");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        super.L0(data, position);
        QFSImageBanner qFSImageBanner = this.imageBannerView;
        QFSImageBanner qFSImageBanner2 = null;
        if (qFSImageBanner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageBannerView");
            qFSImageBanner = null;
        }
        qFSImageBanner.setVisibility(0);
        ImageView imageView = this.picIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picIcon");
            imageView = null;
        }
        imageView.setVisibility(0);
        p80.e eVar = this.adapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            eVar = null;
        }
        Intrinsics.checkNotNull(data);
        eVar.v0(data.images.get());
        QFSImageBanner qFSImageBanner3 = this.imageBannerView;
        if (qFSImageBanner3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageBannerView");
        } else {
            qFSImageBanner2 = qFSImageBanner3;
        }
        qFSImageBanner2.post(new Runnable() { // from class: m40.j
            @Override // java.lang.Runnable
            public final void run() {
                k.k1(k.this);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        i1();
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedUnSelected(selectInfo);
        R0(1, 8, r(), "");
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.c
    public void onItemClick(int position) {
        i1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSLinearFeedPicPresenter";
    }
}
