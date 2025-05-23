package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StHotEventInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00014B\u000f\u0012\u0006\u00100\u001a\u00020/\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0014J\b\u0010\u0017\u001a\u00020\u0005H\u0014J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0014R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010 R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010+\u00a8\u00065"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/d;", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/c;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "u", "y", "", NodeProps.VISIBLE, "w", "Lfeedcloud/FeedCloudMeta$StFeed;", "data", "", "hotName", "v", "t", "isElementCanActivate", "onElementActivated", "onElementInactivated", "", "getPriority", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", NodeProps.ON_CLICK, "pageId", HippyTKDListViewAdapter.X, "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "bannerWrapper", "E", "Landroid/view/View;", "containerLayout", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "titleTv", "G", "subTitleTv", "H", "dividerLine", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "iconIv", "J", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;", "host", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;)V", "K", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d extends c implements View.OnClickListener {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private LinearLayout bannerWrapper;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View containerLayout;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView titleTv;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView subTitleTv;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View dividerLine;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ImageView iconIv;

    /* renamed from: J, reason: from kotlin metadata */
    private int pageId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull a host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
    }

    private final void t() {
        if (this.f90602e == null) {
            return;
        }
        VideoReport.setElementId(this.containerLayout, QCircleDaTongConstant.ElementId.EM_XSJ_TOPIC_CHALLENGE_BAR);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_topic_name", this.f90602e.hotEventInfo.eventName.get());
        params.put("xsj_feed_id", this.f90602e.f398449id.get());
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.f90602e.poster.f398463id.get());
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_HOT_NUM, Long.valueOf(this.f90602e.hotEventInfo.heat.get()));
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, "rank");
        VideoReport.setElementParams(this.containerLayout, params);
        VideoReport.setElementClickPolicy(this.containerLayout, ClickPolicy.REPORT_ALL);
        VideoReport.setElementReuseIdentifier(this.containerLayout, "QFSBottomHotEventView" + this.f90602e.f398449id.get());
    }

    private final void u(View rootView) {
        View view;
        if (this.containerLayout != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) rootView.findViewById(R.id.f43811nh);
        this.bannerWrapper = (LinearLayout) rootView.findViewById(R.id.f34340yw);
        if (viewStub != null) {
            view = viewStub.inflate();
        } else {
            view = null;
        }
        if (view == null) {
            return;
        }
        this.containerLayout = view.findViewById(R.id.f40461ef);
        this.titleTv = (TextView) view.findViewById(R.id.f40481eh);
        this.subTitleTv = (TextView) view.findViewById(R.id.f40471eg);
        this.dividerLine = view.findViewById(R.id.f40441ed);
        this.iconIv = (ImageView) view.findViewById(R.id.f40451ee);
        View view2 = this.containerLayout;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
    }

    private final void v(FeedCloudMeta$StFeed data, String hotName) {
        if (TextUtils.isEmpty(hotName)) {
            return;
        }
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(ua0.c.c(data)).setActionType(5105).setSubActionType(2).setfpageid(p().getFromPageId()).setExt3(hotName).setPageId(this.pageId).setRequestId(ba.d(data)));
    }

    private final void w(boolean visible) {
        int i3;
        View view = this.containerLayout;
        int i16 = 0;
        if (view != null) {
            if (visible) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
        LinearLayout linearLayout = this.bannerWrapper;
        if (linearLayout != null) {
            if (!visible) {
                i16 = 8;
            }
            linearLayout.setVisibility(i16);
        }
    }

    private final void y() {
        if (this.f90602e == null) {
            return;
        }
        String str = com.tencent.biz.qqcircle.utils.h.a(R.string.f1910343p) + "\uff1a" + this.f90602e.hotEventInfo.eventName.get();
        TextView textView = this.titleTv;
        if (textView != null) {
            textView.setText(str);
        }
        String f16 = com.tencent.biz.qqcircle.immersive.utils.r.f(this.f90602e.hotEventInfo.heat.get());
        if (TextUtils.equals(f16, "0")) {
            View view = this.dividerLine;
            if (view != null) {
                view.setVisibility(8);
            }
            TextView textView2 = this.subTitleTv;
            if (textView2 != null) {
                textView2.setText("");
            }
        } else {
            View view2 = this.dividerLine;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            TextView textView3 = this.subTitleTv;
            if (textView3 != null) {
                textView3.setText(f16);
            }
        }
        Option obtain = Option.obtain();
        obtain.setUrl(this.f90602e.hotEventInfo.bannerInfo.showIcon.get());
        obtain.setTargetView(this.iconIv);
        obtain.setSupportRecycler(true);
        obtain.setLoadingDrawableColor(0);
        QCircleFeedPicLoader.g().loadImage(obtain);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 112;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (this.f90602e == null) {
            return false;
        }
        return !TextUtils.isEmpty(r0.hotEventInfo.bannerInfo.showIcon.get());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        String str;
        FeedCloudMeta$StHotEventInfo feedCloudMeta$StHotEventInfo;
        PBStringField pBStringField;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (this.f90602e != null) {
            QFSSearchBean qFSSearchBean = new QFSSearchBean();
            qFSSearchBean.setSearchKeyword(this.f90602e.hotEventInfo.eventName.get());
            qFSSearchBean.setQuerySource(25);
            qFSSearchBean.setUserSource(8);
            qFSSearchBean.setPageInteract(true);
            com.tencent.biz.qqcircle.launcher.c.y0(j(), qFSSearchBean);
            FeedCloudMeta$StFeed mFeed = this.f90602e;
            Intrinsics.checkNotNullExpressionValue(mFeed, "mFeed");
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
            if (feedCloudMeta$StFeed != null && (feedCloudMeta$StHotEventInfo = feedCloudMeta$StFeed.hotEventInfo) != null && (pBStringField = feedCloudMeta$StHotEventInfo.eventName) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            v(mFeed, str);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        View mRootView = this.f90604h;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        u(mRootView);
        y();
        w(true);
        t();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        w(false);
    }

    public final void x(int pageId) {
        this.pageId = pageId;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
    }
}
