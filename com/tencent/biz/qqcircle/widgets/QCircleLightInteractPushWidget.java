package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLightInteractInfo;
import feedcloud.FeedCloudMeta$StUser;
import java.util.Map;

/* loaded from: classes5.dex */
public class QCircleLightInteractPushWidget extends QCircleBaseLightInteractWidget {
    private ImageView C;
    private TextView D;
    private QFSFollowView E;
    private com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> F;
    private TextView G;
    private QCircleSlidBottomView H;
    private Size I;

    /* renamed from: i, reason: collision with root package name */
    private QCircleAvatarView f93026i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f93027m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StUser f93028d;

        a(FeedCloudMeta$StUser feedCloudMeta$StUser) {
            this.f93028d = feedCloudMeta$StUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed;
            int i3;
            String str;
            int i16;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
            EventCollector.getInstance().onViewClickedBefore(view);
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setUser(this.f93028d);
            if (QCircleLightInteractPushWidget.this.getReportBean() != null) {
                qCircleInitBean.setFromReportBean(QCircleLightInteractPushWidget.this.getReportBean().m466clone());
            }
            com.tencent.biz.qqcircle.launcher.c.d0(view.getContext(), qCircleInitBean);
            QCircleExtraTypeInfo qCircleExtraTypeInfo = QCircleLightInteractPushWidget.this.f92935h;
            if (qCircleExtraTypeInfo != null) {
                feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed;
            } else {
                feedCloudMeta$StFeed = null;
            }
            QCircleLpReportDc05501.DataBuilder actionType = ua0.c.a(feedCloudMeta$StFeed).setActionType(87);
            if (view == QCircleLightInteractPushWidget.this.f93026i) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            QCircleLpReportDc05501.DataBuilder subActionType = actionType.setSubActionType(i3);
            QCircleExtraTypeInfo qCircleExtraTypeInfo2 = QCircleLightInteractPushWidget.this.f92935h;
            if (qCircleExtraTypeInfo2 != null && (feedCloudMeta$StFeed2 = qCircleExtraTypeInfo2.mFeed) != null) {
                str = feedCloudMeta$StFeed2.poster.f398463id.get();
            } else {
                str = "";
            }
            QCircleLpReportDc05501.DataBuilder toUin = subActionType.setToUin(str);
            QCircleExtraTypeInfo qCircleExtraTypeInfo3 = QCircleLightInteractPushWidget.this.f92935h;
            if (qCircleExtraTypeInfo3 != null) {
                i16 = qCircleExtraTypeInfo3.mDataPosition;
            } else {
                i16 = -1;
            }
            QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setIndex(i16).setPageId(QCircleLightInteractPushWidget.this.getPageId())));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements QFSFollowView.c {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.c
        public void O(boolean z16, FeedCloudMeta$StUser feedCloudMeta$StUser) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed;
            int i3;
            String str;
            int i16;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
            QCircleExtraTypeInfo qCircleExtraTypeInfo = QCircleLightInteractPushWidget.this.f92935h;
            if (qCircleExtraTypeInfo != null) {
                feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed;
            } else {
                feedCloudMeta$StFeed = null;
            }
            QCircleLpReportDc05501.DataBuilder actionType = ua0.c.a(feedCloudMeta$StFeed).setActionType(87);
            if (z16) {
                i3 = 4;
            } else {
                i3 = 5;
            }
            QCircleLpReportDc05501.DataBuilder subActionType = actionType.setSubActionType(i3);
            QCircleExtraTypeInfo qCircleExtraTypeInfo2 = QCircleLightInteractPushWidget.this.f92935h;
            if (qCircleExtraTypeInfo2 != null && (feedCloudMeta$StFeed2 = qCircleExtraTypeInfo2.mFeed) != null) {
                str = feedCloudMeta$StFeed2.poster.f398463id.get();
            } else {
                str = "";
            }
            QCircleLpReportDc05501.DataBuilder toUin = subActionType.setToUin(str);
            QCircleExtraTypeInfo qCircleExtraTypeInfo3 = QCircleLightInteractPushWidget.this.f92935h;
            if (qCircleExtraTypeInfo3 != null) {
                i16 = qCircleExtraTypeInfo3.mDataPosition;
            } else {
                i16 = -1;
            }
            QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setIndex(i16).setPageId(QCircleLightInteractPushWidget.this.getPageId())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QCirclePushInfoManager.e().m(QCircleLightInteractPushWidget.this.f92932d, null, 1);
            if (QCircleLightInteractPushWidget.this.H != null) {
                QCircleLightInteractPushWidget.this.H.g();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QCircleLightInteractPushWidget(@NonNull Context context, int i3) {
        super(context, i3);
        o0(this);
        this.I = com.tencent.biz.qqcircle.immersive.utils.n.a(context, R.dimen.d4f);
    }

    private void n0() {
        VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_USER_ROW);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, QCircleDaTongConstant.ElementId.EM_XSJ_ROCKETS_LIST);
        VideoReport.setElementParams(this, buildElementParams);
    }

    private void o0(View view) {
        this.f93026i = (QCircleAvatarView) view.findViewById(R.id.f32170t1);
        this.f93027m = (TextView) view.findViewById(R.id.f32240t8);
        this.C = (ImageView) view.findViewById(R.id.f32100su);
        this.D = (TextView) view.findViewById(R.id.f32110sv);
        this.E = (QFSFollowView) view.findViewById(R.id.f32180t2);
        this.G = (TextView) view.findViewById(R.id.f32190t3);
        n0();
    }

    private void p0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (this.G == null) {
            return;
        }
        if (!QCirclePluginUtil.isOwner(feedCloudMeta$StUser)) {
            this.G.setVisibility(8);
        } else {
            this.G.setVisibility(0);
            this.G.setOnClickListener(new c());
        }
    }

    private void q0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.E.setFollowedDismiss(false);
        this.E.setUserData(feedCloudMeta$StUser);
        this.E.setFollowStateChangeListener(new b());
    }

    private void r0(FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo) {
        int i3 = feedCloudMeta$StLightInteractInfo.count.get();
        this.D.setText(HippyTKDListViewAdapter.X + i3);
        s0(i3);
    }

    private void s0(int i3) {
        if (i3 >= 10) {
            ImageView imageView = this.C;
            imageView.setImageDrawable(imageView.getResources().getDrawable(R.drawable.qvideo_skin_rocketpanel_icon_rocket));
            this.D.setTextColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_feedback_error));
        } else {
            ImageView imageView2 = this.C;
            imageView2.setImageDrawable(imageView2.getResources().getDrawable(R.drawable.qvideo_skin_rocketpanel_icon_rocket));
            this.D.setTextColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_primary));
        }
    }

    private void u0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.f93026i.setUser(feedCloudMeta$StUser, this.I);
        this.f93027m.setText(feedCloudMeta$StUser.nick.get());
        a aVar = new a(feedCloudMeta$StUser);
        this.f93026i.setOnClickListener(aVar);
        this.f93027m.setOnClickListener(aVar);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        if (obj instanceof FeedCloudMeta$StLightInteractInfo) {
            if (i3 == 0) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.setMargins(0, cx.a(-1.5f), 0, 0);
                    setLayoutParams(layoutParams);
                } else {
                    RecyclerView.LayoutParams layoutParams2 = new RecyclerView.LayoutParams(-2, -2);
                    layoutParams2.setMargins(0, cx.a(-1.5f), 0, 0);
                    setLayoutParams(layoutParams2);
                }
            }
            FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo = (FeedCloudMeta$StLightInteractInfo) obj;
            this.f92933e = feedCloudMeta$StLightInteractInfo;
            u0(feedCloudMeta$StLightInteractInfo.user);
            r0(this.f92933e);
            q0(this.f92933e.user);
            p0(this.f92933e.user);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g5f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleLightInteractPushWidget";
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseLightInteractWidget
    public void k0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, QCircleExtraTypeInfo qCircleExtraTypeInfo, int i3) {
        this.f92932d = feedCloudMeta$StFeed;
        this.f92935h = qCircleExtraTypeInfo;
        this.f92934f = i3;
    }

    public void setReportBeanAgent(com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar) {
        this.F = aVar;
    }

    public void setSlideBottomViewContainer(QCircleSlidBottomView qCircleSlidBottomView) {
        this.H = qCircleSlidBottomView;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            return QCircleReportBean.getReportBean("QCircleLightInteractPushWidget", qCircleReportBean);
        }
        com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar = this.F;
        if (aVar != null) {
            return QCircleReportBean.getReportBean("QCircleLightInteractPushWidget", aVar.getReportBean());
        }
        return null;
    }
}
