package com.tencent.biz.qqcircle.immersive.views.pymk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.util.Consumer;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.immersive.utils.p;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.pymk.QFSLayerFeedPYMKUserCardItemView;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.manager.j;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.utils.d;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.qqcircle.widgets.aa;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleDitto$StItemInfo;

/* loaded from: classes4.dex */
public class QFSLayerFeedPYMKUserCardItemView extends QCircleBaseWidgetView<QQCircleDitto$StItemInfo> implements View.OnClickListener, SimpleEventReceiver {
    protected FrameLayout C;
    private FeedCloudMeta$StFeed D;
    private QQCircleDitto$StItemInfo E;
    private List<FeedCloudCommon$Entry> F;
    private List<FeedCloudCommon$Entry> G;
    private String H;
    private String I;
    private int J;
    private Size K;

    /* renamed from: d, reason: collision with root package name */
    protected QCircleAvatarView f91006d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f91007e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f91008f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f91009h;

    /* renamed from: i, reason: collision with root package name */
    protected QFSFollowView f91010i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f91011m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSLayerFeedPYMKUserCardItemView.this.f91010i.onClick(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSLayerFeedPYMKUserCardItemView(Context context) {
        super(context);
        u0(this);
    }

    private void A0() {
        this.f91006d.setAvatar(QCirclePluginUtil.getValueFromListEntry(this.G, "user_avatar_url"), this.E.f429300id.get(), this.K);
    }

    private void B0() {
        QFSFollowView qFSFollowView = this.f91010i;
        if (qFSFollowView != null && this.E != null && this.f91011m != null) {
            qFSFollowView.setVisibility(0);
            this.f91011m.setVisibility(8);
            FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
            this.f91010i.setFollowedDismiss(false);
            feedCloudMeta$StUser.f398463id.set(this.E.f429300id.get());
            feedCloudMeta$StUser.followState.set(this.E.buttonInfo.buttonValue.get());
            this.f91010i.setUserData(feedCloudMeta$StUser);
            this.f91010i.setOnClickListener(new a());
            if (this.E.buttonInfo.animation.showScaleAnimation.get()) {
                d.k(this.f91010i, 2000L, -1, 1.0f, 1.1f, 1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(int i3) {
        if (this.D != null && this.E != null) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder();
            dataBuilder.setActionType(608).setSubActionType(i3).setToUin(this.E.f429300id.get()).setExt1(this.I).setExt2(this.H).setExt10(ba.d(this.D)).setPosition(this.J + 1).setPageId(getPageId()).setActTime(System.currentTimeMillis()).setFirstFeedId(w20.a.j().h());
            if (this.E.busiReport.has()) {
                dataBuilder.setReportInfo(this.E.busiReport.get().toByteArray());
            }
            QCircleLpReportDc05507.report(dataBuilder);
        }
    }

    private void p0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        this.f91010i.setItemReportListener(new b(qQCircleDitto$StItemInfo));
    }

    private String q0() {
        List<FeedCloudCommon$Entry> list = this.F;
        if (list == null) {
            return null;
        }
        this.H = QCirclePluginUtil.getValueFromListEntry(list, "fansnum");
        this.I = QCirclePluginUtil.getValueFromListEntry(this.F, "feedcount");
        try {
            return r.f(Long.parseLong(this.I)) + " " + h.a(R.string.f184183l7) + APLogFileUtil.SEPARATOR_LOG + r.f(Long.parseLong(this.H)) + " " + h.a(R.string.f183163if);
        } catch (NumberFormatException e16) {
            QLog.e("QFSLayerFeedPYMKUserCardItemView", 1, "parse fansNum or worksNum error ! " + e16.getMessage());
            return "";
        }
    }

    private void r0() {
        if (TextUtils.equals("1", bh.d(this.F, "is_user_private"))) {
            com.tencent.biz.qqcircle.utils.ba.f92679a.b(getContext());
        } else {
            QCircleHostLauncher.startAddFriend(getContext(), this.E.f429300id.get(), this.E.name.get(), false, false);
        }
    }

    private void s0(QCircleFollowUpdateEvent qCircleFollowUpdateEvent) {
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.E;
        if (qQCircleDitto$StItemInfo == null || !qQCircleDitto$StItemInfo.f429300id.get().equals(qCircleFollowUpdateEvent.mUserId)) {
            return;
        }
        y0(this.E, qCircleFollowUpdateEvent.mFollowStatus);
    }

    private void u0(View view) {
        this.C = (FrameLayout) view.findViewById(R.id.f45071qw);
        this.f91006d = (QCircleAvatarView) view.findViewById(R.id.f45061qv);
        this.f91007e = (TextView) view.findViewById(R.id.f45081qx);
        this.f91008f = (TextView) view.findViewById(R.id.f45091qy);
        this.f91009h = (TextView) view.findViewById(R.id.f45101qz);
        this.f91010i = (QFSFollowView) view.findViewById(R.id.f45051qu);
        this.f91011m = (TextView) view.findViewById(R.id.f45031qs);
        this.C.setOnClickListener(this);
        this.f91006d.setOnClickListener(this);
        this.f91007e.setOnClickListener(this);
        this.K = n.a(getContext(), R.dimen.d36);
    }

    private void v0() {
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.E;
        if (qQCircleDitto$StItemInfo != null && !TextUtils.isEmpty(qQCircleDitto$StItemInfo.f429300id.get())) {
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setUin(this.E.f429300id.get());
            qCircleInitBean.setFromReportBean(getReportBean().m466clone());
            c.d0(getContext(), qCircleInitBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(Integer num) {
        this.f91006d.setIsAuth(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        r0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void y0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        if (this.E == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.E.f429300id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYMK_INDEX, Integer.valueOf(this.J + 1));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_WORKS_NUM, this.I);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_FANS_NUM, this.H);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, r.F(i3));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleDitto$StItemInfo.datongJsonData.get());
        VideoReport.setElementId(this.C, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_ITEM);
        VideoReport.setElementReuseIdentifier(this.C, "em_xsj_pymk_item_" + qQCircleDitto$StItemInfo.hashCode());
        VideoReport.setElementParams(this.C, buildElementParams);
        VideoReport.setElementId(this.f91006d, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_AUTHOR_AVATAR);
        VideoReport.setElementParams(this.f91006d, buildElementParams);
        VideoReport.setElementId(this.f91007e, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_AUTHOR_NAME);
        VideoReport.setElementParams(this.f91007e, buildElementParams);
    }

    private void z0() {
        QFSFollowView qFSFollowView = this.f91010i;
        if (qFSFollowView != null && this.f91011m != null) {
            qFSFollowView.setVisibility(8);
            this.f91011m.setVisibility(0);
            this.f91011m.setOnClickListener(new View.OnClickListener() { // from class: c80.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSLayerFeedPYMKUserCardItemView.this.x0(view);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleFollowUpdateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gfa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSLayerFeedPYMKUserCardItemView";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        if (qQCircleDitto$StItemInfo == null) {
            return;
        }
        this.E = qQCircleDitto$StItemInfo;
        this.J = i3;
        this.F = qQCircleDitto$StItemInfo.busiInfo.get();
        this.G = this.E.urlInfo.get();
        A0();
        p.b(this.E, new Consumer() { // from class: c80.a
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                QFSLayerFeedPYMKUserCardItemView.this.w0((Integer) obj);
            }
        });
        this.f91007e.setText(this.E.name.get());
        if (j.e(this.E, getPageId())) {
            z0();
        } else {
            B0();
        }
        if (this.E.des.get().size() == 0) {
            this.f91008f.setVisibility(8);
            this.f91009h.setVisibility(8);
            return;
        }
        String q06 = q0();
        if (!TextUtils.isEmpty(q06)) {
            this.f91008f.setText(q06);
        } else {
            this.f91008f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.E.des.get().get(0))) {
            this.f91009h.setText(this.E.des.get().get(0));
        } else {
            this.f91009h.setVisibility(8);
        }
        y0(qQCircleDitto$StItemInfo, qQCircleDitto$StItemInfo.buttonInfo.buttonValue.get());
        p0(qQCircleDitto$StItemInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        o0(1);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f45081qx) {
            v0();
            o0(11);
        } else if (id5 == R.id.f45061qv) {
            v0();
            o0(10);
        } else if (id5 == R.id.f45071qw) {
            v0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleFollowUpdateEvent) {
            s0((QCircleFollowUpdateEvent) simpleBaseEvent);
        }
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.D = feedCloudMeta$StFeed;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements QFSFollowView.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQCircleDitto$StItemInfo f91013a;

        b(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
            this.f91013a = qQCircleDitto$StItemInfo;
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void a() {
            VideoReport.setElementId(QFSLayerFeedPYMKUserCardItemView.this.f91010i, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON);
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_action_type", "cancel");
            hashMap.put("xsj_target_qq", this.f91013a.f429300id.get());
            hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, QFSLayerFeedPYMKUserCardItemView.this.f91010i, hashMap);
            QFSLayerFeedPYMKUserCardItemView.this.o0(3);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public /* synthetic */ void b() {
            aa.a(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void onClick(int i3) {
            if (i3 == 0) {
                VideoReport.setElementId(QFSLayerFeedPYMKUserCardItemView.this.f91010i, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_ITEM);
                HashMap hashMap = new HashMap();
                hashMap.put("xsj_action_type", "follow");
                hashMap.put("xsj_target_qq", this.f91013a.f429300id.get());
                hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, QFSLayerFeedPYMKUserCardItemView.this.f91010i, hashMap);
                QFSLayerFeedPYMKUserCardItemView.this.o0(2);
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void c(int i3) {
        }
    }
}
