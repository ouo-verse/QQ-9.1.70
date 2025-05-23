package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.util.Consumer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFollowDialogUserItemView extends QCircleBaseWidgetView<QQCircleDitto$StItemInfo> implements View.OnClickListener {
    private QQCircleDitto$StItemInfo C;
    private List<FeedCloudCommon$Entry> D;
    private List<FeedCloudCommon$Entry> E;
    private int F;
    private Size G;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f90340d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleAvatarView f90341e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f90342f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f90343h;

    /* renamed from: i, reason: collision with root package name */
    private QFSFollowView f90344i;

    /* renamed from: m, reason: collision with root package name */
    private FeedCloudMeta$StFeed f90345m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!FastClickUtils.isFastDoubleClick("QFSFollowDialogUserItemView")) {
                QFSFollowDialogUserItemView.this.f90344i.onClick(view);
                QFSFollowDialogUserItemView.this.x0();
                QFSFollowDialogUserItemView.this.q0(2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
    }

    public QFSFollowDialogUserItemView(Context context) {
        super(context);
        u0(this);
    }

    private void A0() {
        if (this.C == null) {
            return;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        feedCloudMeta$StUser.f398463id.set(this.C.f429300id.get());
        feedCloudMeta$StUser.followState.set(this.C.buttonInfo.buttonValue.get());
        this.f90344i.setFollowedDismiss(false);
        this.f90344i.setUserData(feedCloudMeta$StUser);
        this.f90344i.setOnClickListener(new a());
    }

    static /* bridge */ /* synthetic */ b m0(QFSFollowDialogUserItemView qFSFollowDialogUserItemView) {
        qFSFollowDialogUserItemView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(int i3) {
        if (this.f90345m != null && this.C != null) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder();
            dataBuilder.setActionType(617).setSubActionType(i3).setToUin(this.C.f429300id.get()).setExt10(ba.d(this.f90345m)).setPosition(this.F + 1).setPageId(getPageId()).setActTime(System.currentTimeMillis()).setFirstFeedId(w20.a.j().h());
            if (this.C.busiReport.has()) {
                dataBuilder.setReportInfo(this.C.busiReport.get().toByteArray());
            }
            QCircleLpReportDc05507.report(dataBuilder);
        }
    }

    private void r0() {
        if (this.C == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_target_qq", this.C.f429300id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, this.C.datongJsonData.get());
        VideoReport.setElementReuseIdentifier(this.f90341e, String.valueOf(this.F));
        VideoReport.setElementParams(this.f90341e, buildElementParams);
        VideoReport.setElementExposePolicy(this.f90341e, ExposurePolicy.REPORT_ALL);
    }

    private void s0() {
        String str;
        if (this.C == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_target_qq", this.C.f429300id.get());
        if (QCirclePluginUtil.isFollow(this.C.buttonInfo.buttonValue.get())) {
            str = QCircleDaTongConstant.ElementParamValue.FOLLOWED;
        } else {
            str = "follow";
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, str);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, this.C.datongJsonData.get());
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        VideoReport.setElementReuseIdentifier(this.f90344i, String.valueOf(this.F));
        VideoReport.setElementParams(this.f90344i, buildElementParams);
        VideoReport.setLogicParent(this.f90344i, this.f90340d);
        VideoReport.setElementExposePolicy(this.f90344i, ExposurePolicy.REPORT_ALL);
    }

    private void u0(View view) {
        this.f90340d = (FrameLayout) view.findViewById(R.id.f42001il);
        this.f90341e = (QCircleAvatarView) view.findViewById(R.id.f41991ik);
        this.f90342f = (TextView) view.findViewById(R.id.f42021in);
        this.f90343h = (TextView) view.findViewById(R.id.f42031io);
        this.f90344i = (QFSFollowView) view.findViewById(R.id.f42011im);
        this.f90341e.setOnClickListener(this);
        this.f90342f.setOnClickListener(this);
        this.G = com.tencent.biz.qqcircle.immersive.utils.n.a(getContext(), R.dimen.f159404d25);
        VideoReport.setElementId(this.f90340d, QCircleDaTongConstant.ElementId.EM_XSJ_ZERO_FOLLOW_GUIDE_FOLLOW_POPUP);
        VideoReport.setElementId(this.f90341e, "em_xsj_author_avatar");
        VideoReport.setElementId(this.f90344i, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON);
    }

    private void v0() {
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.C;
        if (qQCircleDitto$StItemInfo != null && !TextUtils.isEmpty(qQCircleDitto$StItemInfo.f429300id.get())) {
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setUin(this.C.f429300id.get());
            qCircleInitBean.setFromReportBean(getReportBean().m466clone());
            com.tencent.biz.qqcircle.launcher.c.d0(getContext(), qCircleInitBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(Integer num) {
        this.f90341e.setIsAuth(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.QFSFollowDialogUserItemView.2
            @Override // java.lang.Runnable
            public void run() {
                QFSFollowDialogUserItemView.m0(QFSFollowDialogUserItemView.this);
            }
        }, 400L);
    }

    private void y0() {
        if (this.C == null) {
            return;
        }
        this.f90341e.setAvatar(QCirclePluginUtil.getValueFromListEntry(this.E, "user_avatar_url"), this.C.f429300id.get(), this.G);
        com.tencent.biz.qqcircle.immersive.utils.p.b(this.C, new Consumer() { // from class: com.tencent.biz.qqcircle.immersive.views.e
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                QFSFollowDialogUserItemView.this.w0((Integer) obj);
            }
        });
        QLog.d("QFSFollowDialogUserItemView", 2, "[setAvatar] uin = " + this.C.f429300id.get());
    }

    private void z0() {
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.C;
        if (qQCircleDitto$StItemInfo != null && qQCircleDitto$StItemInfo.des.get().size() != 0 && !TextUtils.isEmpty(this.C.des.get().get(0))) {
            this.f90343h.setText(this.C.des.get().get(0));
        } else {
            this.f90343h.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gcb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSFollowDialogUserItemView";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        q0(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f42021in) {
            v0();
            q0(11);
        } else if (id5 == R.id.f41991ik) {
            v0();
            q0(10);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void bindData(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        String dtPageId;
        if (qQCircleDitto$StItemInfo == null) {
            return;
        }
        this.C = qQCircleDitto$StItemInfo;
        this.F = i3;
        this.D = qQCircleDitto$StItemInfo.busiInfo.get();
        this.E = qQCircleDitto$StItemInfo.urlInfo.get();
        this.f90342f.setText(qQCircleDitto$StItemInfo.name.get());
        y0();
        z0();
        A0();
        FrameLayout frameLayout = this.f90340d;
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean == null) {
            dtPageId = QCircleDaTongConstant.PageId.BASE;
        } else {
            dtPageId = qCircleReportBean.getDtPageId();
        }
        VideoReport.setPageId(frameLayout, dtPageId);
        r0();
        s0();
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f90345m = feedCloudMeta$StFeed;
    }

    public void setListener(b bVar) {
    }
}
