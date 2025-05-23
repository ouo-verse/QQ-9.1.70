package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.immersive.views.QFSHotCommentFlipper;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;

/* compiled from: P */
/* loaded from: classes4.dex */
public class q extends c {
    private QFSHotCommentFlipper D;
    private LinearLayout E;
    private final List<FeedCloudMeta$StComment> F;
    private boolean G;
    private List<FeedCloudMeta$StComment> H;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSHotCommentFlipper.b {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.QFSHotCommentFlipper.b
        public void a(View view, FeedCloudMeta$StComment feedCloudMeta$StComment) {
            boolean z16;
            q qVar = q.this;
            String str = feedCloudMeta$StComment.f398447id.get();
            if (feedCloudMeta$StComment.likeInfo.status.get() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            qVar.C(view, feedCloudMeta$StComment, null, false, str, z16);
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.QFSHotCommentFlipper.b
        public void b(View view, FeedCloudMeta$StComment feedCloudMeta$StComment) {
            q.this.C(view, feedCloudMeta$StComment, null, false, feedCloudMeta$StComment.f398447id.get(), false);
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.QFSHotCommentFlipper.b
        public void c(View view, FeedCloudMeta$StComment feedCloudMeta$StComment) {
            PBStringField pBStringField;
            if (feedCloudMeta$StComment != null && (pBStringField = feedCloudMeta$StComment.content) != null) {
                q.this.C(view, null, pBStringField.get(), true, feedCloudMeta$StComment.f398447id.get(), false);
            } else {
                QLog.d("QFSFeedHotCommentView", 1, "[onClickCommentGuide] comment == null || comment.content == null.");
            }
        }
    }

    public q(com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
        this.F = new ArrayList();
        this.G = false;
        this.H = new ArrayList();
    }

    private boolean A(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment == null || feedCloudMeta$StComment.sourceType.get() != 4) {
            return false;
        }
        return true;
    }

    private void B(@NotNull View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f43791nf);
        this.E = (LinearLayout) view.findViewById(R.id.f34340yw);
        if (viewStub == null) {
            return;
        }
        QFSHotCommentFlipper qFSHotCommentFlipper = (QFSHotCommentFlipper) viewStub.inflate().findViewById(R.id.xb7);
        this.D = qFSHotCommentFlipper;
        qFSHotCommentFlipper.setOnClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(View view, FeedCloudMeta$StComment feedCloudMeta$StComment, String str, boolean z16, String str2, boolean z17) {
        if (o() == null) {
            return;
        }
        QFSCommentInfo u16 = u(feedCloudMeta$StComment, str, str2);
        u16.mActionBean.mNeedDoCommentPraise = z17;
        o().onHandlerMessage("event_open_comment", u16);
        if (z16) {
            o().onHandlerMessage("event_open_comment_input", u16);
        }
        if (z17) {
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_action_type", "like");
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            v(view, QCircleDaTongConstant.EventId.EV_XSJ_CMTREPLY_LIKE_ACTION, hashMap);
            return;
        }
        v(view, "ev_xsj_abnormal_clck", null);
    }

    private void D() {
        String str;
        if (!z()) {
            return;
        }
        if (this.D.j()) {
            QLog.e("QFSFeedHotCommentView", 1, "[resetAutoHotPlay] current is play state, flow end.");
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed == null) {
            str = "null";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        QLog.d("QFSFeedHotCommentView", 1, "[resetAutoHotPlay] current reset auto hot play, feed id: " + str);
        this.D.o();
    }

    private void E() {
        List<FeedCloudMeta$StComment> list = this.F;
        if (list != null && !list.isEmpty()) {
            int size = this.F.size();
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (A(this.F.get(i3))) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            s(new com.tencent.biz.qqcircle.immersive.feed.event.i(129, z16));
        }
    }

    private void F(boolean z16) {
        int i3;
        QFSHotCommentFlipper qFSHotCommentFlipper = this.D;
        int i16 = 0;
        if (qFSHotCommentFlipper != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            qFSHotCommentFlipper.setVisibility(i3);
        }
        LinearLayout linearLayout = this.E;
        if (linearLayout != null) {
            if (!z16) {
                i16 = 8;
            }
            linearLayout.setVisibility(i16);
        }
    }

    private void G(List<FeedCloudMeta$StComment> list) {
        int size;
        String str;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed == null) {
            str = "null";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        if (size <= 1) {
            QLog.e("QFSFeedHotCommentView", 1, "[updateCommentGuide] current feed comments size: " + size + " \uff5c feed id: " + str);
            return;
        }
        List<FeedCloudMeta$StComment> list2 = this.H;
        if (list2 != null && list2.size() > 0) {
            if (this.G) {
                QLog.d("QFSFeedHotCommentView", 1, "[updateCommentGuide] current show bottom box guide, flow end.");
                return;
            }
            FeedCloudMeta$StComment feedCloudMeta$StComment = null;
            for (int i3 = 0; i3 < this.H.size(); i3++) {
                FeedCloudMeta$StComment feedCloudMeta$StComment2 = this.H.get(i3);
                if (A(feedCloudMeta$StComment2)) {
                    feedCloudMeta$StComment = feedCloudMeta$StComment2;
                }
            }
            if (feedCloudMeta$StComment != null) {
                QLog.d("QFSFeedHotCommentView", 1, "[updateCommentGuide] current size: " + size + " | add hot comment guide success. feedId: " + str);
                list.add(2, feedCloudMeta$StComment);
                return;
            }
            QLog.d("QFSFeedHotCommentView", 1, "[updateCommentGuide] current bottom hot comment guide content is null.");
            return;
        }
        QLog.e("QFSFeedHotCommentView", 1, "[updateCommentGuide] current feed comments is null.");
    }

    private void H() {
        String str;
        if (!this.F.isEmpty() && this.D != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
            if (feedCloudMeta$StFeed == null) {
                str = "null";
            } else {
                str = feedCloudMeta$StFeed.f398449id.get();
            }
            QLog.d("QFSFeedHotCommentView", 1, "[updateHotCommentData] feed id =" + str);
            this.D.setHotCommentList(this.F);
            F(true);
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
        if (feedCloudMeta$StComment != null && !TextUtils.isEmpty(str2)) {
            qFSCommentInfo.mCommentId = feedCloudMeta$StComment.f398447id.get();
            qFSCommentInfo.mHotCommentId = str2;
            QFSCommentInfo.ActionBean actionBean = new QFSCommentInfo.ActionBean();
            qFSCommentInfo.mActionBean = actionBean;
            actionBean.mIsNeedShowTopAnim = true;
            QCircleInitBean.QCircleActionBean qCircleActionBean = new QCircleInitBean.QCircleActionBean();
            qFSCommentInfo.mActionBean.mCommentInitBeanActionBean = qCircleActionBean;
            qCircleActionBean.mItemTopAnimationCommentId = str2;
        }
        return qFSCommentInfo;
    }

    private void v(View view, String str, @Nullable Map<String, Object> map) {
        if (view != null && this.f90602e != null) {
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_HOTCOMMENT_BAR);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.e(this.f90602e));
            if (map != null) {
                buildElementParams.putAll(map);
            }
            QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
            try {
                qQCircleFeedBase$StReportInfoForClient.mergeFrom(this.f90602e.reportInfoForClient.get().toByteArray());
                if (!TextUtils.isEmpty(qQCircleFeedBase$StReportInfoForClient.datongJsonData.get())) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleFeedBase$StReportInfoForClient.datongJsonData.get());
                }
            } catch (InvalidProtocolBufferMicroException unused) {
                QLog.w("QFSFeedHotCommentView", 1, "dtCustomClickPraiseView, transferInfo error");
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f90603f + 1));
            QFSHotCommentFlipper qFSHotCommentFlipper = this.D;
            if (qFSHotCommentFlipper != null) {
                FeedCloudMeta$StComment f16 = qFSHotCommentFlipper.f();
                if (f16 != null) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, f16.f398447id.get());
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_HOTCOMMENT_TYPE, Integer.valueOf(this.D.g()));
            }
            VideoReport.reportEvent(str, view, buildElementParams);
        }
    }

    private void w() {
        QFSHotCommentFlipper qFSHotCommentFlipper = this.D;
        if (qFSHotCommentFlipper != null && this.f90602e != null) {
            VideoReport.setElementId(qFSHotCommentFlipper, QCircleDaTongConstant.ElementId.EM_XSJ_HOTCOMMENT_BAR);
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_HOTCOMMENT_TYPE, Integer.valueOf(this.D.g()));
            FeedCloudMeta$StComment f16 = this.D.f();
            if (f16 != null) {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, f16.f398447id.get());
            }
            VideoReport.setElementParams(this.D, hashMap);
            VideoReport.setElementEndExposePolicy(this.D, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementReuseIdentifier(this.D, QCircleDaTongConstant.ElementId.EM_XSJ_HOTCOMMENT_BAR + this.f90602e.f398449id.get());
        }
    }

    private List<FeedCloudMeta$StComment> x(List<FeedCloudMeta$StComment> list) {
        QLog.d("QFSFeedHotCommentView", 1, "[getHotComments] trace id =" + ba.d(this.f90602e));
        this.F.clear();
        if (list != null && !list.isEmpty()) {
            for (FeedCloudMeta$StComment feedCloudMeta$StComment : list) {
                if (QFSCommentHelper.V(feedCloudMeta$StComment.typeFlag2.get(), 4) && !TextUtils.isEmpty(feedCloudMeta$StComment.content.get())) {
                    this.F.add(feedCloudMeta$StComment);
                }
            }
            return this.F;
        }
        return this.F;
    }

    private void y(@NonNull com.tencent.biz.qqcircle.immersive.feed.event.i iVar) {
        if (iVar.a() != 128) {
            return;
        }
        this.G = iVar.b();
        QLog.d("QFSFeedHotCommentView", 1, "[handleBottomCommentGuideEvent] isShowGuideCommentBox: " + this.G);
    }

    private boolean z() {
        QFSHotCommentFlipper qFSHotCommentFlipper = this.D;
        if (qFSHotCommentFlipper != null && qFSHotCommentFlipper.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void f(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.f(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.i) {
            y((com.tencent.biz.qqcircle.immersive.feed.event.i) hVar);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 108;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(e30.b bVar, int i3) {
        super.h(bVar, i3);
        List<FeedCloudMeta$StComment> list = this.f90602e.vecComment.get();
        this.H = list;
        G(x(list));
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return c40.c.b(this.f90602e);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        B(this.f90604h);
        H();
        D();
        E();
        w();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        F(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
        QFSHotCommentFlipper qFSHotCommentFlipper = this.D;
        if (qFSHotCommentFlipper != null) {
            qFSHotCommentFlipper.p();
            this.D.m();
        }
        this.G = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }
}
