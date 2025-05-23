package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInputWindowConfig;
import com.tencent.biz.qqcircle.beans.QFSCommentPublishFeedAttrBean;
import com.tencent.biz.qqcircle.beans.QFSCommentPublishFeedDraftBean;
import com.tencent.biz.qqcircle.beans.QFSFeedCommentInfo;
import com.tencent.biz.qqcircle.events.QFSCommentHintTextEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.api.WinkVideoCommentCompleteEvent;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cf extends u implements View.OnClickListener, SimpleEventReceiver {
    private View C;
    private QCircleAsyncTextView D;
    private FeedCloudMeta$StFeed E;
    private boolean F;
    private int G = 1;
    private View H;
    private TextView I;
    private ImageView J;
    private int K;
    private View L;
    private View M;

    /* renamed from: d, reason: collision with root package name */
    private QCircleInitBean f87810d;

    /* renamed from: e, reason: collision with root package name */
    private e30.b f87811e;

    /* renamed from: f, reason: collision with root package name */
    private View f87812f;

    /* renamed from: h, reason: collision with root package name */
    private View f87813h;

    /* renamed from: i, reason: collision with root package name */
    private View f87814i;

    /* renamed from: m, reason: collision with root package name */
    private View f87815m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            cf.this.U9();
        }
    }

    private boolean B9() {
        boolean z16;
        boolean z17;
        if (M9() || !K9()) {
            return false;
        }
        Object broadcastGetMessage = broadcastGetMessage("qfs_get_feed_by_pos", Integer.valueOf(this.K + 1));
        if (!(broadcastGetMessage instanceof e30.b)) {
            return false;
        }
        FeedCloudMeta$StFeed g16 = ((e30.b) broadcastGetMessage).g();
        if (g16 != null && g16.opMask2.get().contains(55)) {
            z16 = true;
        } else {
            z16 = false;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.E;
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.opMask2.get().contains(55)) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.d("QFSLayerPageBottomPart", 4, "[canShowBottomGuideView] mBottomGuideType: " + this.G + ", nextFeedIsFromFriend: " + z16 + ", curFeedIsFromFriend: " + z17 + ", mCurrentFeedPos: " + this.K);
        if (z16 && z17) {
            this.G = 1;
            return true;
        }
        if (z16 || !z17) {
            return false;
        }
        this.G = 2;
        return true;
    }

    private void C9() {
        View view = this.f87812f;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.L;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.M;
        if (view3 != null) {
            view3.getLayoutParams().height = ImmersiveUtils.dpToPx(56.0f);
        }
    }

    private void D9() {
        String str;
        String str2;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.E;
        String str3 = "";
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        buildElementParams.put("xsj_feed_id", str);
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMTBOX_VIDEO_ICON);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, "cmt");
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_UI_MODULE, com.tencent.biz.qqcircle.comment.af.v());
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.E;
        if (feedCloudMeta$StFeed2 == null || (feedCloudMeta$StUser = feedCloudMeta$StFeed2.poster) == null) {
            str2 = "";
        } else {
            str2 = feedCloudMeta$StUser.f398463id.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str2);
        if (getReportBean() != null) {
            str3 = getReportBean().getDtPageId();
        }
        buildElementParams.put("xsj_custom_pgid", str3);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    private String E9() {
        if (this.E == null) {
            return "";
        }
        String G = QFSCommentHelper.L().G(this.E, null, null);
        com.tencent.biz.qqcircle.utils.an E = QFSCommentHelper.L().E(this.E, null, null);
        if (E != null && !TextUtils.isEmpty(E.d())) {
            G = G + QCircleApplication.APP.getResources().getString(R.string.f182983hy);
        }
        if (E != null && !TextUtils.isEmpty(E.e())) {
            return G + QCircleApplication.APP.getResources().getString(R.string.image);
        }
        return G;
    }

    private void F9(WinkVideoCommentCompleteEvent winkVideoCommentCompleteEvent, QFSCommentPublishFeedDraftBean qFSCommentPublishFeedDraftBean) {
        if (winkVideoCommentCompleteEvent != null && winkVideoCommentCompleteEvent.params != null && qFSCommentPublishFeedDraftBean != null && getActivity() != null && qFSCommentPublishFeedDraftBean.getHostPartHashcode() == getActivity().hashCode()) {
            String str = winkVideoCommentCompleteEvent.params.get(QQWinkConstants.WINK_PUBLISH_PARAM_COVER_PATH);
            String str2 = winkVideoCommentCompleteEvent.params.get(QQWinkConstants.WINK_PUBLISH_PARAM_WIDTH);
            String str3 = winkVideoCommentCompleteEvent.params.get(QQWinkConstants.WINK_PUBLISH_PARAM_HEIGHT);
            QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
            qFSCommentInputWindowConfig.commentPicPath = str;
            if (str3 != null && str2 != null) {
                qFSCommentInputWindowConfig.commentPicWidth = Integer.parseInt(str2);
                qFSCommentInputWindowConfig.commentPicHeight = Integer.parseInt(str3);
            }
            qFSCommentInputWindowConfig.isShowPostBtn = !TextUtils.isEmpty(str);
            V9(qFSCommentInputWindowConfig);
            QLog.d("QFSLayerPageBottomPart", 1, "[handlePicCommentEvent] imagePath: " + str + ", width: " + str2 + ", height: " + str3);
        }
    }

    private void G9(WinkVideoCommentCompleteEvent winkVideoCommentCompleteEvent) {
        String str;
        if (!this.F) {
            return;
        }
        this.F = false;
        HashMap<String, String> hashMap = winkVideoCommentCompleteEvent.params;
        if (hashMap != null && !hashMap.isEmpty()) {
            if (QFSCommentHelper.L().K() != null) {
                QLog.d(getTAG(), 1, "[handleWinkEvent] has already show input window. ");
                return;
            }
            QFSCommentPublishFeedAttrBean attrBean = QFSCommentPublishFeedAttrBean.getAttrBean(hashMap);
            QLog.d(getTAG(), 1, "[handleWinkEvent] " + attrBean);
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.E;
            if (feedCloudMeta$StFeed == null) {
                str = "";
            } else {
                str = feedCloudMeta$StFeed.f398449id.get();
            }
            if (!TextUtils.isEmpty(attrBean.feedId) && TextUtils.equals(attrBean.feedId, str)) {
                QFSCommentPublishFeedDraftBean N = QFSCommentHelper.L().N(attrBean.draftId);
                if (N == null) {
                    QLog.e(getTAG(), 1, "[handleWinkEvent] draftBean == null");
                    return;
                }
                QFSFeedCommentInfo feedCommentInfo = N.getFeedCommentInfo();
                if (feedCommentInfo == null) {
                    QLog.e(getTAG(), 1, "[handleWinkEvent] feedCommentInfo == null");
                    return;
                }
                if (feedCommentInfo.mFeed == null) {
                    QLog.e(getTAG(), 1, "[handleWinkEvent] targetFeed == null");
                    return;
                }
                String str2 = hashMap.get("taskid");
                if (TextUtils.equals(str2, "comment") || TextUtils.equals(str2, "comment_reply")) {
                    QLog.d(getTAG(), 1, "[handleWinkEvent] isFrom commentPic");
                    F9(winkVideoCommentCompleteEvent, N);
                    return;
                }
                return;
            }
            QLog.e(getTAG(), 1, "[handleWinkEvent] curFeedId = " + str);
            return;
        }
        QLog.e(getTAG(), 1, "[handleWinkEvent] params == null or empty");
    }

    private void H9() {
        if (this.H == null) {
            View inflate = ((ViewStub) getPartRootView().findViewById(R.id.f44771q3)).inflate();
            this.H = inflate;
            this.I = (TextView) inflate.findViewById(R.id.f45301ri);
            this.J = (ImageView) this.H.findViewById(R.id.f45291rh);
        }
    }

    private boolean I9() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.E;
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.feedType.get() == 4) {
            return true;
        }
        return false;
    }

    private boolean J9() {
        if (!com.tencent.biz.qqcircle.immersive.feed.ad.u.f(this.E) && I9()) {
            return true;
        }
        return false;
    }

    private boolean K9() {
        QCircleInitBean qCircleInitBean = this.f87810d;
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null) {
            return QCircleDaTongConstant.PageId.PG_XSJ_AVATAR_APERTURE_PAGE.equals(this.f87810d.getSchemeAttrs().get("xsj_custom_pgid"));
        }
        return false;
    }

    private boolean L9() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.E;
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.type.get() == 4) {
            return true;
        }
        return false;
    }

    private boolean M9() {
        String a16 = com.tencent.biz.qqcircle.utils.k.a("exp_xsj_contacts_aperture_exp2");
        if (!TextUtils.equals(a16, "exp_xsj_contacts_aperture_exp2_B") && !TextUtils.equals(a16, "exp_xsj_contacts_aperture_exp2_C")) {
            return false;
        }
        return true;
    }

    private void N9() {
        com.tencent.biz.qqcircle.utils.z.b(getActivity(), 2, new a(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_SHARE_SAVE), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
        D9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f87815m.setVisibility(8);
        com.tencent.biz.qqcircle.comment.emoji.o.i(3);
        N9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f87814i.performClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    private boolean Q9() {
        if (!J9() && !L9() && !ba() && !B9()) {
            return true;
        }
        return false;
    }

    private void R9(@NonNull QFSCommentInfo qFSCommentInfo) {
        if (this.f87811e == null) {
            QLog.e("QFSLayerPageBottomPart", 1, "[openCommentInput] mFeedData == null");
            return;
        }
        if (J9()) {
            QCircleToast.h(R.string.f187873v6, 0);
            return;
        }
        e30.b bVar = this.f87811e;
        qFSCommentInfo.mFeedBlockData = bVar;
        qFSCommentInfo.mFeed = bVar.g();
        qFSCommentInfo.mReportBean = getReportBean();
        qFSCommentInfo.mIsShowAiComment = false;
        broadcastMessage("comment_input_window_show", qFSCommentInfo);
    }

    private void S9() {
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        QFSCommentInfo.ActionBean actionBean = new QFSCommentInfo.ActionBean();
        actionBean.mNeedShowAt = true;
        qFSCommentInfo.mActionBean = actionBean;
        R9(qFSCommentInfo);
    }

    private void T9() {
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mIsShowEmotion = true;
        R9(qFSCommentInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U9() {
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
        qFSCommentInputWindowConfig.isShowHalfScreenPicPanel = true;
        qFSCommentInfo.mInputWinConfig = qFSCommentInputWindowConfig;
        R9(qFSCommentInfo);
    }

    private void V9(QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mInputWinConfig = qFSCommentInputWindowConfig;
        R9(qFSCommentInfo);
    }

    private void W9() {
        View view = this.f87812f;
        int i3 = 0;
        if (view != null) {
            view.setVisibility(0);
        }
        da();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.E;
        if (feedCloudMeta$StFeed != null) {
            ud2.a aVar = ud2.a.f438849a;
            aVar.h(feedCloudMeta$StFeed.f398449id.get());
            boolean b16 = aVar.b();
            View view2 = this.C;
            if (view2 != null) {
                if (!b16) {
                    i3 = 8;
                }
                view2.setVisibility(i3);
            }
        }
    }

    private void X9(boolean z16) {
        ImageView imageView = this.J;
        if (imageView == null) {
            return;
        }
        imageView.setBackgroundResource(R.drawable.kji);
        AnimationDrawable animationDrawable = (AnimationDrawable) this.J.getBackground();
        if (animationDrawable == null) {
            return;
        }
        if (z16) {
            animationDrawable.start();
        } else {
            animationDrawable.stop();
        }
    }

    private void Y9(boolean z16) {
        int i3;
        if (this.H == null) {
            return;
        }
        int i16 = 0;
        if (z16) {
            TextView textView = this.I;
            if (this.G == 1) {
                i3 = R.string.f1913244h;
            } else {
                i3 = R.string.f1913444j;
            }
            textView.setText(i3);
            X9(true);
        } else {
            X9(false);
        }
        View view = this.H;
        if (!z16) {
            i16 = 8;
        }
        view.setVisibility(i16);
    }

    private void Z9() {
        if (this.D != null && this.f87812f != null) {
            String E9 = E9();
            if (TextUtils.isEmpty(E9)) {
                e30.b bVar = this.f87811e;
                if (bVar != null && bVar.g() != null && !TextUtils.isEmpty(this.f87811e.g().commentTextInfo.normalCommentBoxDesc.get())) {
                    E9 = this.f87811e.g().commentTextInfo.normalCommentBoxDesc.get();
                } else {
                    E9 = com.tencent.biz.qqcircle.utils.h.a(R.string.f13496006);
                }
            }
            this.D.setText(E9);
            return;
        }
        QLog.e("QFSLayerPageBottomPart", 1, "[setCommentInputHintText] mCommentWrapper == null");
    }

    private boolean ba() {
        if (o83.a.f422212a.d()) {
            if (getReportBean().getFromPageId() == 80000 || getReportBean().getFromPageId() == 80002) {
                return true;
            }
            return false;
        }
        if (getReportBean().getFromPageId() == 80000) {
            return true;
        }
        return false;
    }

    private void ca() {
        H9();
        Y9(true);
    }

    private void da() {
        int i3;
        if (this.f87813h != null && this.f87815m != null && this.f87814i != null) {
            boolean p16 = com.tencent.biz.qqcircle.comment.af.p(this.E);
            View view = this.f87813h;
            if (p16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
            if (com.tencent.biz.qqcircle.comment.emoji.o.c()) {
                this.f87815m.setVisibility(0);
                com.tencent.biz.qqcircle.comment.emoji.o.e();
            }
            this.f87814i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.cd
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    cf.this.O9(view2);
                }
            });
            this.f87813h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.ce
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    cf.this.P9(view2);
                }
            });
        }
    }

    private void ea() {
        if (Q9()) {
            W9();
            Y9(false);
        } else {
            C9();
        }
    }

    private void handleCommentHintTextEvent(QFSCommentHintTextEvent qFSCommentHintTextEvent) {
        e30.b bVar = this.f87811e;
        if (bVar != null && bVar.g() != null && TextUtils.equals(this.f87811e.g().f398449id.get(), qFSCommentHintTextEvent.getFeedId())) {
            Z9();
        }
    }

    public void aa(QCircleInitBean qCircleInitBean) {
        this.f87810d = qCircleInitBean;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSCommentHintTextEvent.class);
        arrayList.add(WinkVideoCommentCompleteEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerPageBottomPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("layer_notify_part_update_feed_index".equals(str)) {
            this.K = ((Integer) obj).intValue();
            if (B9()) {
                ca();
                C9();
            }
        }
        if ("layer_notify_part_update_feed".equals(str)) {
            if (!(obj instanceof e30.b)) {
                return;
            }
            e30.b bVar = (e30.b) obj;
            this.f87811e = bVar;
            this.E = bVar.g();
            Z9();
            ea();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.E;
            if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.f398449id.get() != null && this.E.f398449id.get().contains("share_fake_")) {
                C9();
                Y9(false);
            }
        }
        if ("layer_notify_visit_count_part_show".equals(str)) {
            C9();
            return;
        }
        View view = this.L;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.M;
        if (view2 != null) {
            view2.getLayoutParams().height = 0;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return com.tencent.biz.qqcircle.manager.i.a("qfs_feed_comment_show");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("externalCommentAt")) {
            if (view.getId() != R.id.v9m && view.getId() != R.id.v_m) {
                if (view.getId() == R.id.tfi) {
                    S9();
                } else if (view.getId() == R.id.ah5) {
                    ud2.a.f438849a.g();
                    T9();
                    View view2 = this.C;
                    if (view2 != null) {
                        view2.setVisibility(8);
                    }
                }
            } else {
                R9(new QFSCommentInfo());
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.L = view.findViewById(R.id.vh5);
        this.M = view.findViewById(R.id.f44761q2);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSCommentHintTextEvent) {
            handleCommentHintTextEvent((QFSCommentHintTextEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof WinkVideoCommentCompleteEvent) {
            G9((WinkVideoCommentCompleteEvent) simpleBaseEvent);
        }
    }
}
