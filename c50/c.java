package c50;

import android.view.View;
import android.view.ViewStub;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkpublish.model.params.FeedParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StVideo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lc50/c;", "Lcom/tencent/biz/richframework/part/Part;", "", "A9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;", "d", "Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;", "initBean", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;)V", "e", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleLayerBean initBean;

    public c(@NotNull QCircleLayerBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
    }

    private final void A9() {
        String b16 = uq3.c.b1("qqcircle", "qfs_hot_comment_collection_video_tag", "#\u71c3\u8bc4\u96c6\u9526 \u6211\u7684\u71c3\u8bc4\u9ad8\u5149\u65f6\u523b");
        Intrinsics.checkNotNullExpressionValue(b16, "getConfigValue(\n        \u2026LECTION_TAG, DEFAULT_TAG)");
        String str = this.initBean.getFeedVideo().videoComposeSourceInfo.get();
        Intrinsics.checkNotNullExpressionValue(str, "initBean.feedVideo.videoComposeSourceInfo.get()");
        FeedParams feedParams = new FeedParams(null, b16, false, false, false, null, null, str, false, null, null, null, null, null, null, null, 0, null, null, null, false, null, null, null, null, null, null, 134217597, null);
        ja0.a aVar = ja0.a.f409680a;
        FeedCloudMeta$StVideo feedVideo = this.initBean.getFeedVideo();
        Intrinsics.checkNotNullExpressionValue(feedVideo, "initBean.feedVideo");
        FeedCloudMeta$StImage feedCover = this.initBean.getFeedCover();
        Intrinsics.checkNotNullExpressionValue(feedCover, "initBean.feedCover");
        aVar.e(feedVideo, feedCover, feedParams, null);
        FragmentActivity activity = getHostFragment().getActivity();
        if (activity != null) {
            aVar.d(activity);
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z9(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A9();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerHotCommentCollectionBottomPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewStub viewStub;
        View inflate;
        super.onInitView(rootView);
        View view = null;
        if (rootView != null) {
            viewStub = (ViewStub) rootView.findViewById(R.id.f45321rk);
        } else {
            viewStub = null;
        }
        if (viewStub != null && (inflate = viewStub.inflate()) != null) {
            view = inflate.findViewById(R.id.f29000kg);
        }
        if (view != null) {
            VideoReport.setPageId(view, QCircleDaTongConstant.PageId.PG_XSJ_HOT_COMMENT_COLLECTION_PAGE);
            VideoReport.setElementId(view, "em_xsj_publish_button");
            VideoReport.setElementParams(view, new QCircleDTParamBuilder().buildElementParams());
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            view.setOnClickListener(new View.OnClickListener() { // from class: c50.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.z9(c.this, view2);
                }
            });
        }
    }
}
