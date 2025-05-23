package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StFeedButton;
import feedcloud.FeedCloudMeta$StLiteBanner;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0012\u001a\u00020\u0004H\u0014J\b\u0010\u0013\u001a\u00020\u0004H\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001c\u00a8\u0006&"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/j;", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/c;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "v", "y", "", NodeProps.VISIBLE, HippyTKDListViewAdapter.X, "u", "isElementCanActivate", "onElementActivated", "onElementInactivated", "", "getPriority", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Landroid/view/ViewGroup;", "D", "Landroid/view/ViewGroup;", "bannerWrapper", "E", ParseCommon.CONTAINER, "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "tvDesc", "G", "tvGo", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;", "host", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;)V", "H", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class j extends c {
    private static boolean I;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ViewGroup bannerWrapper;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ViewGroup container;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView tvDesc;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView tvGo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull a host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
    }

    private final void u() {
        ViewGroup viewGroup = this.container;
        if (viewGroup != null) {
            VideoReport.setElementId(viewGroup, QCircleDaTongConstant.ElementId.EM_XSJ_AWARD_CREATE_TASK_BAR);
            VideoReport.setElementParams(viewGroup, new QCircleDTParamBuilder().buildElementParams());
            VideoReport.setElementExposePolicy(viewGroup, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(viewGroup, ClickPolicy.REPORT_NONE);
        }
    }

    private final void v(View rootView) {
        ViewGroup viewGroup;
        View inflate;
        if (this.bannerWrapper != null) {
            return;
        }
        ViewStub viewStub = null;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f34340yw);
        } else {
            viewGroup = null;
        }
        this.bannerWrapper = viewGroup;
        if (rootView != null) {
            viewStub = (ViewStub) rootView.findViewById(R.id.f52262_b);
        }
        if (viewStub != null && (inflate = viewStub.inflate()) != null) {
            this.container = (ViewGroup) inflate.findViewById(R.id.f40041da);
            this.tvDesc = (TextView) inflate.findViewById(R.id.f40021d9);
            this.tvGo = (TextView) inflate.findViewById(R.id.f40031d_);
        }
        ViewGroup viewGroup2 = this.container;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.w(j.this, view);
                }
            });
        }
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(j this$0, View view) {
        String str;
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner;
        PBRepeatMessageField<FeedCloudMeta$StFeedButton> pBRepeatMessageField;
        List<FeedCloudMeta$StFeedButton> list;
        Object orNull;
        PBStringField pBStringField;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x(false);
        I = true;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this$0.f90602e;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StLiteBanner = feedCloudMeta$StFeed.liteBanner) != null && (pBRepeatMessageField = feedCloudMeta$StLiteBanner.button) != null && (list = pBRepeatMessageField.get()) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
            FeedCloudMeta$StFeedButton feedCloudMeta$StFeedButton = (FeedCloudMeta$StFeedButton) orNull;
            if (feedCloudMeta$StFeedButton != null && (pBStringField = feedCloudMeta$StFeedButton.jump_url) != null) {
                str = pBStringField.get();
                QLog.d(this$0.m(), 1, "jumpUrl=" + str);
                com.tencent.biz.qqcircle.launcher.c.g(view.getContext(), str);
                VideoReport.reportEvent("clck", this$0.container, new QCircleDTParamBuilder().buildElementParams());
                EventCollector.getInstance().onViewClicked(view);
            }
        }
        str = null;
        QLog.d(this$0.m(), 1, "jumpUrl=" + str);
        com.tencent.biz.qqcircle.launcher.c.g(view.getContext(), str);
        VideoReport.reportEvent("clck", this$0.container, new QCircleDTParamBuilder().buildElementParams());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void x(boolean visible) {
        if (visible) {
            ViewGroup viewGroup = this.bannerWrapper;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            ViewGroup viewGroup2 = this.container;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(0);
                return;
            }
            return;
        }
        ViewGroup viewGroup3 = this.bannerWrapper;
        if (viewGroup3 != null) {
            viewGroup3.setVisibility(8);
        }
        ViewGroup viewGroup4 = this.container;
        if (viewGroup4 != null) {
            viewGroup4.setVisibility(8);
        }
    }

    private final void y() {
        Object orNull;
        PBStringField pBStringField;
        String str;
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner;
        PBStringField pBStringField2;
        TextView textView = this.tvDesc;
        String str2 = null;
        if (textView != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
            if (feedCloudMeta$StFeed != null && (feedCloudMeta$StLiteBanner = feedCloudMeta$StFeed.liteBanner) != null && (pBStringField2 = feedCloudMeta$StLiteBanner.title) != null) {
                str = pBStringField2.get();
            } else {
                str = null;
            }
            textView.setText(str);
        }
        TextView textView2 = this.tvGo;
        if (textView2 != null) {
            List<FeedCloudMeta$StFeedButton> list = this.f90602e.liteBanner.button.get();
            Intrinsics.checkNotNullExpressionValue(list, "mFeed.liteBanner.button.get()");
            orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
            FeedCloudMeta$StFeedButton feedCloudMeta$StFeedButton = (FeedCloudMeta$StFeedButton) orNull;
            if (feedCloudMeta$StFeedButton != null && (pBStringField = feedCloudMeta$StFeedButton.text) != null) {
                str2 = pBStringField.get();
            }
            textView2.setText(str2);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 128;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        int i3 = feedCloudMeta$StFeed.liteBanner.style_type.get();
        int i16 = this.f90602e.liteBanner.business_type.get();
        if (QLog.isDebugVersion()) {
            QLog.d(m(), 1, "[isElementCanActivate] hasClicked=" + I + ", styleType=" + i3 + ", businessType=" + i16);
        }
        if (I || i3 != 9 || i16 != 18) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    @NotNull
    public String m() {
        return "QFSFeedBottomRewardPublishView";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        v(this.f90604h);
        y();
        if (I) {
            x(false);
        } else {
            x(true);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        x(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
    }
}
