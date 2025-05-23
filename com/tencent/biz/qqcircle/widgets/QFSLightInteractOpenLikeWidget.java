package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLightInteractInfo;
import feedcloud.FeedCloudMeta$StUser;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001>B\u0017\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010:\u001a\u00020\t\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u001a\u0010\u0016\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\tH\u0014J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010 R*\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00107\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106\u00a8\u0006?"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QFSLightInteractOpenLikeWidget;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseLightInteractWidget;", "Landroid/view/View$OnClickListener;", "", "initView", "Lfeedcloud/FeedCloudMeta$StUser;", QCircleAlphaUserReporter.KEY_USER, "q0", "o0", "", "state", "m0", "Lfeedcloud/FeedCloudMeta$StLightInteractInfo;", "interactInfo", "p0", "n0", "getLayoutId", "Lcooperation/qqcircle/report/QCircleReportBean;", "getReportBean", "", "objData", com.tencent.luggage.wxa.c8.c.G, "bindData", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "i", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "avatarView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "nickName", "Lcom/tencent/biz/qqcircle/widgets/QFSFollowView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/widgets/QFSFollowView;", "followView", "D", "labelTv", "Lcom/tencent/biz/qqcircle/richframework/part/a;", "E", "Lcom/tencent/biz/qqcircle/richframework/part/a;", "getReportBeanAgent", "()Lcom/tencent/biz/qqcircle/richframework/part/a;", "setReportBeanAgent", "(Lcom/tencent/biz/qqcircle/richframework/part/a;)V", "reportBeanAgent", "Lcom/tencent/biz/qqcircle/beans/QCircleExtraTypeInfo;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/beans/QCircleExtraTypeInfo;", "getExtraTypeInfo", "()Lcom/tencent/biz/qqcircle/beans/QCircleExtraTypeInfo;", "setExtraTypeInfo", "(Lcom/tencent/biz/qqcircle/beans/QCircleExtraTypeInfo;)V", "extraTypeInfo", "Landroid/content/Context;", "context", "viewType", "<init>", "(Landroid/content/Context;I)V", "G", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSLightInteractOpenLikeWidget extends QCircleBaseLightInteractWidget implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QFSFollowView followView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView labelTv;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> reportBeanAgent;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QCircleExtraTypeInfo extraTypeInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleAvatarView avatarView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView nickName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSLightInteractOpenLikeWidget(@NotNull Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    private final void initView() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 17));
        this.avatarView = (QCircleAvatarView) getRootView().findViewById(R.id.f56892lu);
        this.nickName = (TextView) getRootView().findViewById(R.id.f56962m1);
        QCircleAvatarView qCircleAvatarView = this.avatarView;
        if (qCircleAvatarView != null) {
            qCircleAvatarView.setOnClickListener(this);
        }
        TextView textView = this.nickName;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        this.followView = (QFSFollowView) getRootView().findViewById(R.id.f42091iu);
        this.labelTv = (TextView) getRootView().findViewById(R.id.f56302k9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(int state) {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        PBStringField pBStringField2;
        QFSFollowView qFSFollowView = this.followView;
        if (qFSFollowView == null) {
            return;
        }
        VideoReport.setElementId(qFSFollowView, QCircleDaTongConstant.ElementId.EM_XSJ_LIKES_LIST_FOLLOW_BUTTON);
        VideoReport.setElementExposePolicy(this.followView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.followView, ClickPolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(this.followView, EndExposurePolicy.REPORT_NONE);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, com.tencent.biz.qqcircle.immersive.utils.r.F(state));
        QCircleExtraTypeInfo qCircleExtraTypeInfo = this.extraTypeInfo;
        String str2 = null;
        if (qCircleExtraTypeInfo != null && (feedCloudMeta$StFeed2 = qCircleExtraTypeInfo.mFeed) != null && (pBStringField2 = feedCloudMeta$StFeed2.f398449id) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        if (str != null) {
            params.put("xsj_feed_id", str);
        }
        QCircleExtraTypeInfo qCircleExtraTypeInfo2 = this.extraTypeInfo;
        if (qCircleExtraTypeInfo2 != null && (feedCloudMeta$StFeed = qCircleExtraTypeInfo2.mFeed) != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed.poster) != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null) {
            str2 = pBStringField.get();
        }
        if (str2 != null) {
            params.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str2);
        }
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, this.followView, params);
    }

    private final void n0() {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        FeedCloudMeta$StUser feedCloudMeta$StUser2;
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo = this.f92933e;
        if (feedCloudMeta$StLightInteractInfo != null && (feedCloudMeta$StUser2 = feedCloudMeta$StLightInteractInfo.user) != null) {
            feedCloudMeta$StUser = feedCloudMeta$StUser2.get();
        } else {
            feedCloudMeta$StUser = null;
        }
        qCircleInitBean.setUser(feedCloudMeta$StUser);
        qCircleInitBean.setFromReportBean(getReportBean().m466clone());
        com.tencent.biz.qqcircle.launcher.c.d0(getContext(), qCircleInitBean);
    }

    private final void o0(FeedCloudMeta$StUser user) {
        QFSFollowView qFSFollowView = this.followView;
        if (qFSFollowView != null) {
            qFSFollowView.setFollowedDismiss(false);
        }
        QFSFollowView qFSFollowView2 = this.followView;
        if (qFSFollowView2 != null) {
            qFSFollowView2.setUserData(user);
        }
        QFSFollowView qFSFollowView3 = this.followView;
        if (qFSFollowView3 != null) {
            qFSFollowView3.setItemReportListener(new b());
        }
    }

    private final void p0(FeedCloudMeta$StLightInteractInfo interactInfo) {
        int i3;
        boolean z16 = interactInfo.relation.isFriend.get();
        TextView textView = this.labelTv;
        if (textView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    private final void q0(FeedCloudMeta$StUser user) {
        Size a16 = com.tencent.biz.qqcircle.immersive.utils.n.a(getContext(), R.dimen.d4f);
        QCircleAvatarView qCircleAvatarView = this.avatarView;
        if (qCircleAvatarView != null) {
            qCircleAvatarView.setUser(user, a16);
        }
        TextView textView = this.nickName;
        if (textView != null) {
            textView.setText(user.nick.get());
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(@Nullable Object objData, int pos) {
        if (!(objData instanceof FeedCloudMeta$StLightInteractInfo)) {
            return;
        }
        FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo = (FeedCloudMeta$StLightInteractInfo) objData;
        this.f92933e = feedCloudMeta$StLightInteractInfo;
        FeedCloudMeta$StUser user = feedCloudMeta$StLightInteractInfo.user.get();
        Intrinsics.checkNotNullExpressionValue(user, "user");
        q0(user);
        FeedCloudMeta$StLightInteractInfo mInteractInfo = this.f92933e;
        Intrinsics.checkNotNullExpressionValue(mInteractInfo, "mInteractInfo");
        p0(mInteractInfo);
        o0(user);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g_b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        boolean z16 = true;
        if ((num == null || num.intValue() != R.id.f56892lu) && (num == null || num.intValue() != R.id.f56962m1)) {
            z16 = false;
        }
        if (z16) {
            n0();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void setExtraTypeInfo(@Nullable QCircleExtraTypeInfo qCircleExtraTypeInfo) {
        this.extraTypeInfo = qCircleExtraTypeInfo;
    }

    public final void setReportBeanAgent(@Nullable com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar) {
        this.reportBeanAgent = aVar;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView, com.tencent.biz.qqcircle.richframework.part.a
    @NotNull
    public QCircleReportBean getReportBean() {
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            QCircleReportBean reportBean = QCircleReportBean.getReportBean("QFSLightInteractOpenLikeWidget", qCircleReportBean);
            Intrinsics.checkNotNullExpressionValue(reportBean, "getReportBean(TAG, mReportBean)");
            return reportBean;
        }
        com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar = this.reportBeanAgent;
        if (aVar != null) {
            QCircleReportBean reportBean2 = QCircleReportBean.getReportBean("QFSLightInteractOpenLikeWidget", aVar != null ? aVar.getReportBean() : null);
            Intrinsics.checkNotNullExpressionValue(reportBean2, "{\n            QCircleRep\u2026nt?.reportBean)\n        }");
            return reportBean2;
        }
        return new QCircleReportBean();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/widgets/QFSLightInteractOpenLikeWidget$b", "Lcom/tencent/biz/qqcircle/widgets/QFSFollowView$d;", "", "state", "", "c", NodeProps.ON_CLICK, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b implements QFSFollowView.d {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public /* synthetic */ void b() {
            aa.a(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void onClick(int state) {
            QFSLightInteractOpenLikeWidget.this.m0(state);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void c(int state) {
        }
    }
}
