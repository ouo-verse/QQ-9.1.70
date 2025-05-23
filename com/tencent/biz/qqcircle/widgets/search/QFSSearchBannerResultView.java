package com.tencent.biz.qqcircle.widgets.search;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.utils.az;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.search.QFSSearchBannerResultView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudRead$StSearchBanner;
import feedcloud.FeedCloudRead$StSearchBannerInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tianshu.QQCircleTianShu$AdItem;
import tianshu.QQCircleTianShu$AdPlacementInfo;
import tianshu.QQCircleTianShu$RspEntry;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSSearchBannerResultView extends QCircleBaseWidgetView<FeedCloudRead$StSearchBannerInfo> {

    /* renamed from: d, reason: collision with root package name */
    private RoundCorneredFrameLayout f93844d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f93845e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f93846f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f93841h = cx.a(16.0f);

    /* renamed from: i, reason: collision with root package name */
    public static final int f93842i = cx.a(10.0f);

    /* renamed from: m, reason: collision with root package name */
    public static final int f93843m = cx.a(8.0f);
    public static final int C = cx.a(8.0f);

    public QFSSearchBannerResultView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f93844d = (RoundCorneredFrameLayout) findViewById(R.id.f52462_v);
        this.f93845e = (ImageView) findViewById(R.id.f52452_u);
        float a16 = cx.a(8.0f);
        this.f93844d.setRadius(a16, a16, a16, a16);
    }

    private int l0() {
        int i3 = f93841h * 2;
        if (this.f93846f) {
            i3 = C * 2;
        }
        return DisplayUtil.getScreenWidth() - i3;
    }

    private void n0() {
        ImageView imageView = this.f93845e;
        if (imageView == null) {
            return;
        }
        VideoReport.setElementId(imageView, QCircleDaTongConstant.ElementId.EM_XSJ_TOP_BANNER);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRACE_ID, String.valueOf(QCirclePluginUtil.getCurrentAccountLongUin()));
        buildElementParams.put("xsj_item_index", 0);
        VideoReport.setElementParams(this.f93845e, buildElementParams);
        VideoReport.setElementExposePolicy(this.f93845e, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.f93845e, ClickPolicy.REPORT_ALL);
    }

    private void o0(FeedCloudRead$StSearchBannerInfo feedCloudRead$StSearchBannerInfo) {
        if (this.f93844d != null && this.f93845e != null) {
            if (feedCloudRead$StSearchBannerInfo.banners.size() >= 1 && feedCloudRead$StSearchBannerInfo.banners.get(0).image != null && !TextUtils.isEmpty(feedCloudRead$StSearchBannerInfo.banners.get(0).image.picUrl.get())) {
                int l06 = l0();
                final FeedCloudRead$StSearchBanner feedCloudRead$StSearchBanner = feedCloudRead$StSearchBannerInfo.banners.get(0);
                float f16 = l06;
                int i3 = (int) (f16 / 2.86f);
                if (feedCloudRead$StSearchBanner.image.width.get() != 0 && feedCloudRead$StSearchBanner.image.height.get() != 0) {
                    i3 = (int) ((feedCloudRead$StSearchBanner.image.height.get() * f16) / feedCloudRead$StSearchBanner.image.width.get());
                }
                q0();
                r0(i3);
                Option predecode = Option.obtain().setTargetView(this.f93845e).setUrl(feedCloudRead$StSearchBanner.image.picUrl.get()).setRequestWidth(l06).setRequestHeight(i3).setPredecode(true);
                predecode.setSupportRecycler(true);
                QCircleFeedPicLoader.g().loadImage(predecode);
                this.f93844d.setVisibility(0);
                n0();
                s0(feedCloudRead$StSearchBanner, 101);
                this.f93845e.setOnClickListener(new View.OnClickListener() { // from class: rc0.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QFSSearchBannerResultView.this.p0(feedCloudRead$StSearchBanner, view);
                    }
                });
                return;
            }
            this.f93844d.setVisibility(8);
            return;
        }
        QLog.w("QFSSearchBannerResultView", 1, "[initBanner] mRoundCorneredFrameLayout || mIvBanner is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(FeedCloudRead$StSearchBanner feedCloudRead$StSearchBanner, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        s0(feedCloudRead$StSearchBanner, 102);
        c.g(getContext(), feedCloudRead$StSearchBanner.imageJumpUrl.get());
        EventCollector.getInstance().onViewClicked(view);
    }

    private void q0() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f93844d.getLayoutParams();
        if (this.f93846f) {
            int i3 = C;
            marginLayoutParams.setMargins(i3, f93842i, i3, f93843m);
        } else {
            int i16 = f93841h;
            marginLayoutParams.setMargins(i16, f93842i, i16, 0);
        }
        this.f93844d.setLayoutParams(marginLayoutParams);
    }

    private void r0(int i3) {
        ViewGroup.LayoutParams layoutParams = this.f93845e.getLayoutParams();
        layoutParams.width = l0();
        layoutParams.height = i3;
        this.f93845e.setLayoutParams(layoutParams);
    }

    private void s0(FeedCloudRead$StSearchBanner feedCloudRead$StSearchBanner, int i3) {
        QQCircleTianShu$AdPlacementInfo qQCircleTianShu$AdPlacementInfo;
        if (feedCloudRead$StSearchBanner != null && feedCloudRead$StSearchBanner.tianshuEntry.has()) {
            List<QQCircleTianShu$AdItem> arrayList = new ArrayList<>();
            QQCircleTianShu$RspEntry qQCircleTianShu$RspEntry = feedCloudRead$StSearchBanner.tianshuEntry.get();
            if (qQCircleTianShu$RspEntry != null && qQCircleTianShu$RspEntry.key.get() == 1049 && (qQCircleTianShu$AdPlacementInfo = qQCircleTianShu$RspEntry.value) != null) {
                arrayList = qQCircleTianShu$AdPlacementInfo.lst.get();
            }
            az.a(arrayList, i3);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gql;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSSearchBannerResultView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudRead$StSearchBannerInfo feedCloudRead$StSearchBannerInfo, int i3) {
        if (feedCloudRead$StSearchBannerInfo == null) {
            return;
        }
        o0(feedCloudRead$StSearchBannerInfo);
    }

    public void setGameCollectionExist(boolean z16) {
        this.f93846f = z16;
    }
}
