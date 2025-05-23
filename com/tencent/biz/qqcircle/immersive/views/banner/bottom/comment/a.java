package com.tencent.biz.qqcircle.immersive.views.banner.bottom.comment;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.c;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.comment.QFSBottomCommentDisplayView;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e30.b;
import feedcloud.FeedCloudMeta$StComment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class a extends c implements QFSBottomCommentDisplayView.a, SimpleEventReceiver {
    private QFSBottomCommentDisplayView D;
    private LinearLayout E;
    private FeedCloudMeta$StComment F;

    public a(@NonNull com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
    }

    private void B(@NonNull QCircleCommentPraiseUpdateEvent qCircleCommentPraiseUpdateEvent) {
        FeedCloudMeta$StComment y16 = y();
        if (y16 == null) {
            QLog.e(m(), 1, "[handlePraiseUpdateEvent] currentHotComment = null or not exp");
            return;
        }
        if (this.D == null) {
            QLog.e(m(), 1, "[handlePraiseUpdateEvent] bottom comment display view should not be null.");
            return;
        }
        if (qCircleCommentPraiseUpdateEvent.mType == 1 && TextUtils.equals(qCircleCommentPraiseUpdateEvent.mCommentId, y16.f398447id.get())) {
            y16.likeInfo.status.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
            y16.likeInfo.count.set(qCircleCommentPraiseUpdateEvent.mPraisedNum);
            this.D.n(z(), A());
            this.D.l(y16);
        }
    }

    private void E() {
        View view = this.f90604h;
        if (view == null) {
            RFWLog.w(m(), RFWLog.USR, "[makeSureInflate] current root view should not be null.");
            return;
        }
        if (this.D != null) {
            RFWLog.w(m(), RFWLog.USR, "[makeSureInflate] current bottom comment display view not is null.");
            return;
        }
        try {
            this.E = (LinearLayout) view.findViewById(R.id.f34340yw);
            this.D = (QFSBottomCommentDisplayView) ((ViewStub) this.f90604h.findViewById(R.id.f34370yz)).inflate().findViewById(R.id.t_9);
        } catch (Throwable th5) {
            RFWLog.e(m(), RFWLog.USR, "[makeSureInflate] ex: ", th5);
        }
    }

    private void F(View view, FeedCloudMeta$StComment feedCloudMeta$StComment, String str, boolean z16, String str2, boolean z17) {
        if (o() == null) {
            return;
        }
        QFSCommentInfo u16 = u(feedCloudMeta$StComment, str, str2);
        u16.mActionBean.mNeedDoCommentPraise = z17;
        o().onHandlerMessage("event_open_comment", u16);
        if (z16) {
            o().onHandlerMessage("event_open_comment_input", u16);
        }
    }

    private void G(View view) {
        if (view != null && this.f90602e != null && this.F != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_feed_id", bj.g(this.f90602e));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.f90602e.poster.f398463id.get());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, this.F.f398447id.get());
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.reportEvent("dt_clck", view, hashMap);
        }
    }

    private void H(View view, String str, @Nullable Map<String, Object> map) {
        if (view != null && this.f90602e != null && this.F != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (map != null) {
                buildElementParams.putAll(map);
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, this.F.f398447id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_ID, this.F.f398447id.get());
            buildElementParams.put("xsj_feed_id", bj.g(this.f90602e));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.f90602e.poster.f398463id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SUB_ACTION_TYPE, "cmt");
            VideoReport.setElementId(view, x());
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.reportEvent(str, view, buildElementParams);
        }
    }

    private void I(View view, int i3) {
        if (view == null) {
            return;
        }
        view.setVisibility(i3);
    }

    private void J(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        int i3;
        QFSBottomCommentDisplayView qFSBottomCommentDisplayView = this.D;
        if (qFSBottomCommentDisplayView == null) {
            return;
        }
        qFSBottomCommentDisplayView.k(QCircleSkinHelper.getInstance().getDrawable(v()));
        this.D.n(z(), A());
        QFSBottomCommentDisplayView qFSBottomCommentDisplayView2 = this.D;
        if (D()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        qFSBottomCommentDisplayView2.p(i3);
        this.D.l(feedCloudMeta$StComment);
        this.D.setOnBottomCommentListener(this);
    }

    private void t(View view) {
        if (view != null && this.f90602e != null && this.F != null) {
            VideoReport.setElementId(view, x());
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_feed_id", bj.g(this.f90602e));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.f90602e.poster.f398463id.get());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, this.F.f398447id.get());
            VideoReport.setElementParams(view, hashMap);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementReuseIdentifier(view, x() + bj.f(this.f90602e));
        }
    }

    private QFSCommentInfo u(FeedCloudMeta$StComment feedCloudMeta$StComment, String str, String str2) {
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mFeedBlockData = this.f90601d;
        qFSCommentInfo.mFeed = this.f90602e;
        qFSCommentInfo.mReportBean = p();
        qFSCommentInfo.mRelocationScrollType = 100;
        QCircleExtraTypeInfo k3 = k();
        qFSCommentInfo.mExtraTypeInfo = k3;
        k3.mDataPosition = this.f90603f;
        qFSCommentInfo.mHintText = str;
        qFSCommentInfo.mCmtPanelSource = 3;
        if (!TextUtils.isEmpty(str2)) {
            qFSCommentInfo.mCommentId = feedCloudMeta$StComment.f398447id.get();
            qFSCommentInfo.mHotCommentId = str2;
            QFSCommentInfo.ActionBean actionBean = new QFSCommentInfo.ActionBean();
            qFSCommentInfo.mActionBean = actionBean;
            actionBean.mIsNeedShowTopAnim = true;
            actionBean.mCommentInitBeanActionBean = new QCircleInitBean.QCircleActionBean();
            qFSCommentInfo.mActionBean.mCommentInitBeanActionBean.mItemTopAnimationCommentId = str2;
        }
        return qFSCommentInfo;
    }

    protected int A() {
        return R.drawable.qui_like_secondary;
    }

    protected abstract boolean C();

    protected boolean D() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.comment.QFSBottomCommentDisplayView.a
    public void a(View view, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        boolean z16;
        if (this.D == null) {
            RFWLog.w(m(), RFWLog.USR, "[onClickPraise] bottom comment display view should not be null.");
            return;
        }
        if (feedCloudMeta$StComment.likeInfo.status.get() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        F(view, feedCloudMeta$StComment, null, false, feedCloudMeta$StComment.f398447id.get(), z16);
        if (z16) {
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_action_type", "like");
            H(this.D.d(), QCircleDaTongConstant.EventId.EV_XSJ_CMTREPLY_LIKE_ACTION, hashMap);
            return;
        }
        G(this.D.d());
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.comment.QFSBottomCommentDisplayView.a
    public void b(View view, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        F(view, feedCloudMeta$StComment, null, false, feedCloudMeta$StComment.f398447id.get(), false);
        QFSBottomCommentDisplayView qFSBottomCommentDisplayView = this.D;
        if (qFSBottomCommentDisplayView != null) {
            G(qFSBottomCommentDisplayView.d());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleCommentPraiseUpdateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(b bVar, int i3) {
        super.h(bVar, i3);
        FeedCloudMeta$StComment w3 = w(this.f90601d);
        this.F = w3;
        J(w3);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return C();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        RFWLog.d(m(), RFWLog.USR, "[onElementActivated] current element activated.this: " + hashCode());
        E();
        J(w(this.f90601d));
        I(this.D, 0);
        I(this.E, 0);
        SimpleEventBus.getInstance().registerReceiver(this);
        QFSBottomCommentDisplayView qFSBottomCommentDisplayView = this.D;
        if (qFSBottomCommentDisplayView != null) {
            t(qFSBottomCommentDisplayView.d());
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        RFWLog.d(m(), RFWLog.USR, "[onElementInactivated] current element inactivated.this:" + hashCode());
        I(this.D, 8);
        I(this.E, 8);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent) {
            B((QCircleCommentPraiseUpdateEvent) simpleBaseEvent);
        }
    }

    protected abstract int v();

    protected abstract FeedCloudMeta$StComment w(b bVar);

    protected abstract String x();

    protected FeedCloudMeta$StComment y() {
        return this.F;
    }

    protected abstract int z();

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
    }
}
