package com.tencent.biz.qqcircle.immersive.feed;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.download.api.IAEDownloadMaterial;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.aspectj.QCircleForbidInteractProcessor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.comment.QFSCommentReportHelper;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedPermissionChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFollowTabLiveListEvent;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleMaxHeightScrollView;
import com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QFSVipNickNameAndIconView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.qqvideo.event.QCircleFeedJSPermissionChangeEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.span.BoldClickableSpan;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e40.p;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLiteBanner;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import qqcircle.QQCircleBase$StUserBusiData;

/* loaded from: classes4.dex */
public class QFSFeedChildBottomInfoPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {

    /* renamed from: g0, reason: collision with root package name */
    private static final float f85053g0 = QCircleApplication.getAPP().getResources().getDimension(R.dimen.f159408d33);
    private View J;
    private QFSVipNickNameAndIconView K;
    private LinearLayout L;
    private ImageView M;
    private LinearLayout N;
    private TextView P;
    private TextView Q;
    private QFSExpandableAsyncTextView S;
    private QCircleMaxHeightScrollView T;
    private ImageView U;
    private Drawable W;
    private RelativeLayout X;
    private ImageView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private ImageView f85054a0;

    /* renamed from: c0, reason: collision with root package name */
    private int f85056c0;

    /* renamed from: d0, reason: collision with root package name */
    private BoldClickableSpan.OnClickBoldTextListener f85057d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f85058e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f85059f0;
    private final Rect I = new Rect(0, -4, com.tencent.biz.qqcircle.utils.cx.a(32.0f), com.tencent.biz.qqcircle.utils.cx.a(18.0f));
    private int R = 0;
    private boolean V = false;

    /* renamed from: b0, reason: collision with root package name */
    private final int[] f85055b0 = new int[2];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class ReportHashTagRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QFSFeedChildBottomInfoPresenter> f85064d;

        public ReportHashTagRunnable(QFSFeedChildBottomInfoPresenter qFSFeedChildBottomInfoPresenter) {
            this.f85064d = new WeakReference<>(qFSFeedChildBottomInfoPresenter);
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSExpandableAsyncTextView z16;
            CopyOnWriteArrayList<String> hashTagList;
            QFSFeedChildBottomInfoPresenter qFSFeedChildBottomInfoPresenter = this.f85064d.get();
            if (qFSFeedChildBottomInfoPresenter != null && (z16 = qFSFeedChildBottomInfoPresenter.z1()) != null && (hashTagList = z16.getHashTagList()) != null && !hashTagList.isEmpty()) {
                Iterator<String> it = hashTagList.iterator();
                while (it.hasNext()) {
                    qFSFeedChildBottomInfoPresenter.Q1(16, 1, qFSFeedChildBottomInfoPresenter.n0(), it.next());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements QFSExpandableAsyncTextView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f85065a;

        a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f85065a = feedCloudMeta$StFeed;
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView.b
        public void a(int i3) {
            if (i3 == 1) {
                QFSFeedChildBottomInfoPresenter.this.S1(-2);
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView.b
        public void b(boolean z16) {
            String str;
            if (QFSFeedChildBottomInfoPresenter.this.E0()) {
                QFSFeedChildBottomInfoPresenter qFSFeedChildBottomInfoPresenter = QFSFeedChildBottomInfoPresenter.this;
                QCircleExtraTypeInfo r16 = qFSFeedChildBottomInfoPresenter.r();
                if (QFSFeedChildBottomInfoPresenter.this.H1()) {
                    str = "1";
                } else {
                    str = "2";
                }
                qFSFeedChildBottomInfoPresenter.r1(82, 1, r16, str);
                if (!z16) {
                    QFSFeedChildBottomInfoPresenter.this.O1(this.f85065a, false);
                }
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView.b
        public boolean onClick(boolean z16) {
            int i3;
            String str;
            QFSFeedChildBottomInfoPresenter qFSFeedChildBottomInfoPresenter = QFSFeedChildBottomInfoPresenter.this;
            if (z16) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            QCircleExtraTypeInfo r16 = qFSFeedChildBottomInfoPresenter.r();
            if (QFSFeedChildBottomInfoPresenter.this.H1()) {
                str = "1";
            } else {
                str = "2";
            }
            qFSFeedChildBottomInfoPresenter.r1(82, i3, r16, str);
            QFSFeedChildBottomInfoPresenter.this.T0(new com.tencent.biz.qqcircle.immersive.feed.event.p(z16));
            if (!com.tencent.biz.qqcircle.manager.i.a("qfs_feed_comment_show") || z16) {
                return false;
            }
            QFSFeedChildBottomInfoPresenter qFSFeedChildBottomInfoPresenter2 = QFSFeedChildBottomInfoPresenter.this;
            qFSFeedChildBottomInfoPresenter2.v1(qFSFeedChildBottomInfoPresenter2.S, this.f85065a, 1);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    private class b implements View.OnClickListener {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSFeedChildBottomInfoPresenter qFSFeedChildBottomInfoPresenter = QFSFeedChildBottomInfoPresenter.this;
            T t16 = qFSFeedChildBottomInfoPresenter.f85017h;
            if (t16 != 0) {
                qFSFeedChildBottomInfoPresenter.t1(view, (FeedCloudMeta$StFeed) t16, 1);
            } else {
                QLog.e(qFSFeedChildBottomInfoPresenter.getTAG(), 1, "[txtSourceOnClick] mData is null");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private int A1() {
        QCircleReportBean reportBean = getReportBean();
        if (reportBean == null) {
            return 0;
        }
        return reportBean.getFromPageId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String B1() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return "null";
        }
        return ((FeedCloudMeta$StFeed) t16).f398449id.get();
    }

    @NonNull
    private SpannableStringBuilder C1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.S == null) {
            return spannableStringBuilder;
        }
        if (feedCloudMeta$StFeed.opMask2.get().contains(40)) {
            spannableStringBuilder.append((CharSequence) " ");
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
            Drawable drawable = this.S.getContext().getDrawable(R.drawable.nqj);
            drawable.setBounds(this.I);
            QCircleAsyncTextView.e(spannableStringBuilder2, 0, drawable);
            return spannableStringBuilder2;
        }
        return spannableStringBuilder;
    }

    private Map<String, Object> D1() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_MUSIC_TYPE, Integer.valueOf(this.E.g().musicInfo.scene.get()));
        hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        if (this.E.g().opMask2 != null && this.E.g().opMask2.get() != null) {
            if (this.E.g().opMask2.get().contains(40)) {
                str = "original";
            } else {
                str = WinkDaTongReportConstant.ElementParamValue.REPRINT;
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FEED_LABEL_NAME, str);
        }
        return hashMap;
    }

    private void E1(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.v_7);
        this.U = imageView;
        imageView.setOnClickListener(this);
    }

    private boolean F1() {
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null) {
            FeedCloudMeta$StFeed g16 = this.E.g();
            FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner = g16.liteBanner;
            if (feedCloudMeta$StLiteBanner == null || feedCloudMeta$StLiteBanner.style_type.get() != 4 || g16.liteBanner.business_type.get() != 4) {
                return false;
            }
            return true;
        }
        QLog.i("QFSFeedChildBottomInfoPresenter", 1, "[isEcommerceFeed] mFeedBlockData = " + this.E);
        return false;
    }

    private boolean G1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QLog.d("QFSFeedChildBottomInfoPresenter", 1, "is_daily:" + feedCloudMeta$StFeed.feedExtraInfo.daily.is_daily.get() + " tag:" + feedCloudMeta$StFeed.feedExtraInfo.daily.tag.get());
        if (feedCloudMeta$StFeed.feedExtraInfo.daily.is_daily.get() && !feedCloudMeta$StFeed.feedExtraInfo.daily.tag.get().isEmpty() && !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && (((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_publish_story_new_one", "exp_xsj_publish_story_new_one_D") || ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_publish_story_new_one", "exp_xsj_publish_story_new_one_E"))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean H1() {
        T t16 = this.f85017h;
        if (t16 != 0 && 2 == ((FeedCloudMeta$StFeed) t16).type.get()) {
            return true;
        }
        return false;
    }

    private boolean I1() {
        if (this.T.getHeight() >= this.S.getHeight()) {
            return true;
        }
        return false;
    }

    private boolean J1(View view, p.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        float a16 = aVar.a();
        float b16 = aVar.b();
        view.getLocationOnScreen(this.f85055b0);
        int[] iArr = this.f85055b0;
        int i3 = iArr[0];
        int i16 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i3;
        int measuredHeight = view.getMeasuredHeight() + i16;
        if (b16 < i16 || b16 > measuredHeight || a16 < i3 || a16 > measuredWidth) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        ce.c(this.C, feedCloudMeta$StFeed, y0(), this.f85018i);
    }

    private void N1() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str;
        String str2;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        QCircleExtraTypeInfo qCircleExtraTypeInfo = this.D;
        if (qCircleExtraTypeInfo != null) {
            feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed;
        } else {
            feedCloudMeta$StFeed = null;
        }
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed));
        QCircleLpReportDc05507.DataBuilder subActionType = dataBuilder.setActionType(81).setSubActionType(1);
        QCircleExtraTypeInfo qCircleExtraTypeInfo2 = this.D;
        if (qCircleExtraTypeInfo2 != null && (feedCloudMeta$StFeed2 = qCircleExtraTypeInfo2.mFeed) != null) {
            str = feedCloudMeta$StFeed2.poster.f398463id.get();
        } else {
            str = "";
        }
        QCircleLpReportDc05507.DataBuilder toUin = subActionType.setToUin(str);
        if (H1()) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        toUin.setExt1(str2).setPageId(y0()).setfpageid(A1());
        QCircleLpReportDc05507.report(dataBuilder);
        QCircleReporter.getInstance().getReportHandler().post(new ReportHashTagRunnable(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView = this.S;
        VideoReport.setElementId(qFSExpandableAsyncTextView, QCircleDaTongConstant.ElementId.EM_XSJ_PLAIN_CMT_EXPAND_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
        if (z16) {
            VideoReport.reportEvent("dt_clck", qFSExpandableAsyncTextView, buildElementParams);
        } else {
            VideoReport.setElementParams(qFSExpandableAsyncTextView, buildElementParams);
            VideoReport.setElementReuseIdentifier(qFSExpandableAsyncTextView, feedCloudMeta$StFeed.f398449id.get());
        }
    }

    private void P1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        String dtPageId;
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_PLAIN_CMT_COPY);
        buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
        if (getReportBean() == null) {
            dtPageId = "";
        } else {
            dtPageId = getReportBean().getDtPageId();
        }
        buildElementParams.put("xsj_custom_pgid", dtPageId);
        if (z16) {
            str = "ev_xsj_abnormal_clck";
        } else {
            str = "ev_xsj_abnormal_imp";
        }
        VideoReport.reportEvent(str, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R1(int i3, int i16, QCircleExtraTypeInfo qCircleExtraTypeInfo, String str, String str2, String str3) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (qCircleExtraTypeInfo != null && (feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed) != null) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed));
            dataBuilder.setActionType(i3).setSubActionType(i16).setToUin(qCircleExtraTypeInfo.mFeed.poster.f398463id.get()).setPosition(qCircleExtraTypeInfo.mDataPosition).setPlayScene(qCircleExtraTypeInfo.mPlayScene).setExt1(str).setExt4(str2).setExt5(str3).setPageId(y0()).setfpageid(A1()).setFirstFeedId(w20.a.j().h());
            QCircleLpReportDc05507.report(dataBuilder);
        } else {
            QLog.e("QCircleReportHelper_QFSFeedChildBottomInfoPresenter", 1, "extraTypeInfo is null or lost feed,actionType:" + i3 + ",subActionType:" + i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S1(int i3) {
        ViewGroup.LayoutParams layoutParams = this.S.getLayoutParams();
        if (layoutParams.width != i3) {
            layoutParams.width = i3;
            this.S.setLayoutParams(layoutParams);
        }
    }

    private void T1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (F1()) {
            this.S.setText(w1(feedCloudMeta$StFeed));
        } else {
            this.S.setText(x1(feedCloudMeta$StFeed));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void U1(int i3) {
        if (s0() == null) {
            QLog.d("QFSFeedChildBottomInfoPresenter", 1, "[openCommentPanel] feed ioc should not be null.");
            return;
        }
        if (this.f85017h == 0) {
            QLog.e(getTAG(), 1, "[openCommentPanel] mData == null");
            return;
        }
        QFSCommentInfo s16 = s1();
        s16.mCmtPanelSource = i3;
        s0().onHandlerMessage("event_open_comment", s16);
        R1(6, 2, r(), QFSCommentReportHelper.n((FeedCloudMeta$StFeed) this.f85017h), "", "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void V1() {
        float f16;
        if (this.M == null) {
            return;
        }
        QQCircleBase$StUserBusiData userBusiData = QCirclePluginUtil.getUserBusiData(this.E);
        if (userBusiData.certification.get() == 0) {
            this.M.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.M.getLayoutParams();
        Option targetView = Option.obtain().setUrl(com.tencent.biz.qqcircle.immersive.utils.p.d(userBusiData)).setRequestWidth(layoutParams.width).setRequestHeight(layoutParams.height).setTargetView(this.M);
        targetView.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(targetView);
        this.M.setVisibility(0);
        u1(this.M, QCircleDaTongConstant.ElementId.EM_XSJ_VERIFY_MARK, com.tencent.biz.qqcircle.immersive.utils.p.a((FeedCloudMeta$StFeed) this.f85017h, userBusiData));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
        if (this.f85058e0) {
            f16 = 4.0f;
        } else {
            f16 = 8.0f;
        }
        layoutParams2.leftMargin = com.tencent.biz.qqcircle.utils.cx.a(f16);
        this.M.setLayoutParams(layoutParams2);
    }

    private void W1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (QCirclePluginUtil.isFromMainProductOrMessage(m0())) {
            com.tencent.biz.qqcircle.immersive.utils.au.m(new QCircleShareInfo(), feedCloudMeta$StFeed);
        }
        X1(feedCloudMeta$StFeed);
    }

    private void X1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QFSVipNickNameAndIconView qFSVipNickNameAndIconView = this.K;
        if (qFSVipNickNameAndIconView == null) {
            QLog.d("QFSFeedChildBottomInfoPresenter", 1, "[updateAuthorNameView] author name view should not be null.");
            return;
        }
        qFSVipNickNameAndIconView.setUser(feedCloudMeta$StFeed.poster);
        this.K.setReportData(new QFSVipNickNameAndIconView.b().g(feedCloudMeta$StFeed).k(r0()).i(D1()));
        String str = feedCloudMeta$StFeed.poster.nick.get();
        if (!TextUtils.isEmpty(str)) {
            this.f85058e0 = this.K.w0("@" + str);
        }
    }

    private void Z1() {
        if (this.K != null && this.L != null) {
            int i3 = 0;
            for (int i16 = 0; i16 < this.L.getChildCount(); i16++) {
                try {
                    View childAt = this.L.getChildAt(i16);
                    childAt.measure(0, 0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.weight == 0.0f && childAt.getVisibility() == 0) {
                        QLog.d("QFSFeedChildBottomInfoPresenter", 4, "[updateAuthorRemainedView] ", "child.getMeasuredWidth() = ", Integer.valueOf(com.tencent.biz.qqcircle.utils.cx.j(childAt.getMeasuredWidth())), ", params.leftMargin = ", Integer.valueOf(com.tencent.biz.qqcircle.utils.cx.j(layoutParams.leftMargin)), ", params.rightMargin = ", Integer.valueOf(com.tencent.biz.qqcircle.utils.cx.j(layoutParams.rightMargin)), ", child = ", childAt, ", feed id = ", B1());
                        i3 += childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                    }
                } catch (Exception e16) {
                    QLog.e("QFSFeedChildBottomInfoPresenter", 1, "[updateAuthorRemainedView] exception: ", e16);
                    return;
                }
            }
            QLog.i("QFSFeedChildBottomInfoPresenter", 1, "[updateAuthorRemainedView] nonWeightedWidth =" + i3 + ", feed id = " + B1());
            int i17 = ((int) (((float) this.f85056c0) - f85053g0)) - i3;
            this.K.measure(0, 0);
            int measuredWidth = this.K.getMeasuredWidth();
            int min = Math.min(measuredWidth, i17);
            this.K.setMaxWidth(min);
            QLog.d("QFSFeedChildBottomInfoPresenter", 4, "[updateAuthorRemainedView] weightedViewWidth = ", Integer.valueOf(com.tencent.biz.qqcircle.utils.cx.j(i17)), ", needWidth = ", Integer.valueOf(com.tencent.biz.qqcircle.utils.cx.j(measuredWidth)), ", resultWidth = ", Integer.valueOf(com.tencent.biz.qqcircle.utils.cx.j(min)), ", nonWeightedWidth = ", Integer.valueOf(com.tencent.biz.qqcircle.utils.cx.j(i3)), ", mFeedInfoLLWidth = ", Integer.valueOf(this.f85056c0), ", feed id = ", B1());
            return;
        }
        QLog.e("QFSFeedChildBottomInfoPresenter", 1, "[updateAuthorRemainedView] mAuthorNameView == null");
    }

    @SuppressLint({"SetTextI18n"})
    private void a2(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        TextView textView = this.Q;
        if (textView == null) {
            QLog.d("QFSFeedChildBottomInfoPresenter", 1, "[updateCreateTimeView] mFeedCreateTimeView should not be null.");
            return;
        }
        textView.setVisibility(8);
        if (feedCloudMeta$StFeed.opMask2.get().contains(36) || QCirclePluginUtil.isFromMainProductOrMessage(m0())) {
            this.Q.setVisibility(0);
            String e16 = com.tencent.biz.qqcircle.widgets.comment.b.e(feedCloudMeta$StFeed.createTime.get() * 1000, true);
            this.Q.setText(" \u00b7 " + e16);
        }
    }

    private void c2(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.N == null) {
            return;
        }
        if (G1(feedCloudMeta$StFeed)) {
            this.P.setText(feedCloudMeta$StFeed.feedExtraInfo.daily.tag.get());
            this.N.setVisibility(0);
        } else {
            this.N.setVisibility(8);
        }
    }

    private void d2(boolean z16) {
        boolean z17;
        View view = this.J;
        if (view != null && view.getVisibility() != 8) {
            QCircleReportBean reportBean = getReportBean();
            int i3 = 4;
            if (reportBean != null && TextUtils.equals(reportBean.getDtPageId(), QCircleDaTongConstant.PageId.PG_XSJ_FOLLOWING_PAGE)) {
                Object messageFromPart = ((BasePartFragment) s0().getHostFragment()).getPartManager().getMessageFromPart("qfs_action_top_live_status", null);
                if ((messageFromPart instanceof Boolean) && ((Boolean) messageFromPart).booleanValue()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                View view2 = this.J;
                if (!z16 && !z17) {
                    i3 = 0;
                }
                view2.setVisibility(i3);
                QLog.d("QFSFeedChildBottomInfoPresenter", 1, "[setViewStatus] isShowView: " + z16 + " isShowLiveList: " + z17);
                return;
            }
            View view3 = this.J;
            if (!z16) {
                i3 = 0;
            }
            view3.setVisibility(i3);
            QLog.d("QFSFeedChildBottomInfoPresenter", 1, "[setViewStatus] isShowView: " + z16);
        }
    }

    private void e2(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.S == null) {
            QLog.d("QFSFeedChildBottomInfoPresenter", 1, "[updateFeedPostContentRichText] current feed post content view should be not null.");
            return;
        }
        RichTextPreloadParserInfo a16 = uc0.a.a(feedCloudMeta$StFeed);
        a16.setPreloadContent(new SpannableString(com.tencent.biz.qqcircle.utils.cu.e(a16.getPreloadContent().toString())));
        this.S.setPreloadParserInfo(a16);
        this.S.setExpanded(false);
        this.S.setExactWidth((int) (this.f85056c0 - f85053g0));
        T1(feedCloudMeta$StFeed);
        this.S.setVisibility(0);
        this.T.setVisibility(0);
        this.S.setCollapseCollapseListener(new a(feedCloudMeta$StFeed));
        if (TextUtils.isEmpty(feedCloudMeta$StFeed.content.get())) {
            this.S.setVisibility(8);
            this.T.setVisibility(8);
        }
        P1(feedCloudMeta$StFeed, false);
    }

    private void q1() {
        View view = this.J;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int i3 = (int) (com.tencent.biz.qqcircle.utils.bz.i(this.J.getContext()) * 0.72f);
            if (i3 == this.f85056c0) {
                return;
            }
            this.f85056c0 = i3;
            layoutParams.width = i3;
            QLog.d("QFSFeedChildBottomInfoPresenter", 1, "[adjustFeedInfoViewSize] params.width: " + layoutParams.width);
            this.J.setLayoutParams(layoutParams);
            this.J.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1(final int i3, final int i16, final QCircleExtraTypeInfo qCircleExtraTypeInfo, final String str) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBottomInfoPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                QFSFeedChildBottomInfoPresenter.this.R1(i3, i16, qCircleExtraTypeInfo, str, "", "");
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private QFSCommentInfo s1() {
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mFeedBlockData = this.E;
        qFSCommentInfo.mFeed = (FeedCloudMeta$StFeed) this.f85017h;
        qFSCommentInfo.mReportBean = getReportBean();
        QCircleExtraTypeInfo r16 = r();
        qFSCommentInfo.mExtraTypeInfo = r16;
        r16.mDataPosition = this.f85018i;
        qFSCommentInfo.mFrom = 1;
        QFSCommentInfo.ActionBean actionBean = new QFSCommentInfo.ActionBean();
        actionBean.mNeedShowTopFeedDesc = true;
        qFSCommentInfo.mActionBean = actionBean;
        qFSCommentInfo.mHadAdBanner = com.tencent.biz.qqcircle.immersive.utils.ad.a.h((ViewGroup) this.C.findViewById(R.id.f40181do));
        return qFSCommentInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(View view, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (QCircleForbidInteractProcessor.forbidInteractIfGuildFeed(feedCloudMeta$StFeed, i3)) {
            QLog.d(getTAG(), 1, "contentTextClick: guild feed forbid interact");
            return;
        }
        if (!com.tencent.biz.qqcircle.manager.i.a("qfs_feed_comment_show")) {
            QFSExpandableAsyncTextView qFSExpandableAsyncTextView = this.S;
            if (qFSExpandableAsyncTextView != null) {
                qFSExpandableAsyncTextView.B();
                return;
            }
            return;
        }
        U1(7);
        P1(feedCloudMeta$StFeed, true);
    }

    private void u1(View view, String str, Map<String, Object> map) {
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null && view != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementId(view, str);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (D1() != null && D1().size() > 0) {
                buildElementParams.putAll(D1());
            }
            if (map != null && map.size() > 0) {
                buildElementParams.putAll(map);
            }
            VideoReport.setElementReuseIdentifier(view, str + this.E.g().f398449id.get());
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1(View view, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (QCircleForbidInteractProcessor.forbidInteractIfGuildFeed(feedCloudMeta$StFeed, i3)) {
            QLog.d(getTAG(), 1, "expandTextClick: guild feed forbid interact");
        } else {
            if (!com.tencent.biz.qqcircle.manager.i.a("qfs_feed_comment_show")) {
                return;
            }
            U1(8);
            O1(feedCloudMeta$StFeed, true);
        }
    }

    private SpannableStringBuilder w1(final FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        SpannableStringBuilder x16 = x1(feedCloudMeta$StFeed);
        if (!this.V) {
            this.U.setVisibility(8);
            return x16;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(x16);
        QCircleAsyncTextView.e(spannableStringBuilder, spannableStringBuilder.length(), this.W);
        this.S.b(spannableStringBuilder, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.s
            @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
            public final void onClick() {
                QFSFeedChildBottomInfoPresenter.this.K1(feedCloudMeta$StFeed);
            }
        });
        this.S.setText(spannableStringBuilder);
        if ((this.S.s() > 2 && !this.S.u()) || TextUtils.isEmpty(feedCloudMeta$StFeed.content.get())) {
            this.U.setVisibility(0);
            return x16;
        }
        this.U.setVisibility(8);
        return spannableStringBuilder;
    }

    @NonNull
    private SpannableStringBuilder x1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        SpannableStringBuilder C1 = C1(feedCloudMeta$StFeed);
        C1.append((CharSequence) y1(feedCloudMeta$StFeed));
        this.f85057d0 = new BoldClickableSpan.OnClickBoldTextListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.r
            @Override // com.tencent.richframework.text.rich.span.BoldClickableSpan.OnClickBoldTextListener
            public final void onClick(Object obj) {
                QFSFeedChildBottomInfoPresenter.L1(obj);
            }
        };
        CharSequence[] O = com.tencent.biz.qqcircle.immersive.utils.r.O(feedCloudMeta$StFeed, com.tencent.biz.qqcircle.utils.cu.e(feedCloudMeta$StFeed.content.get()), this.f85057d0, false);
        C1.append(O[0]).append(O[1]);
        return C1;
    }

    private String y1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$FeedAlbumInfo feedCloudMeta$FeedAlbumInfo;
        PBUInt32Field pBUInt32Field;
        if (!c40.a.f(feedCloudMeta$StFeed) || (feedCloudMeta$FeedAlbumInfo = feedCloudMeta$StFeed.album_infos.get().get(0)) == null || (pBUInt32Field = feedCloudMeta$FeedAlbumInfo.feed_serial_number) == null || pBUInt32Field.get() == 0) {
            return "";
        }
        return this.C.getResources().getString(R.string.f195754fg, Integer.valueOf(feedCloudMeta$FeedAlbumInfo.feed_serial_number.get()), "");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean D0(e40.p pVar) {
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView = this.S;
        if (qFSExpandableAsyncTextView != null) {
            if (!qFSExpandableAsyncTextView.u() && !I1() && J1(this.T, pVar.b())) {
                return true;
            }
            return false;
        }
        return super.D0(pVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        com.tencent.biz.qqcircle.utils.l.i("exp_tagstrengthen_2");
        d2(this.f85059f0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: M1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.f85017h = feedCloudMeta$StFeed;
        if (feedCloudMeta$StFeed == 0) {
            QLog.d("QFSFeedChildBottomInfoPresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        c1(false);
        W1(feedCloudMeta$StFeed);
        a2(feedCloudMeta$StFeed);
        V1();
        e2(feedCloudMeta$StFeed);
        Z1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.J = view.findViewById(R.id.v_p);
        this.L = (LinearLayout) view.findViewById(R.id.v_h);
        this.K = (QFSVipNickNameAndIconView) view.findViewById(R.id.v_i);
        this.M = (ImageView) view.findViewById(R.id.f39221b3);
        this.N = (LinearLayout) view.findViewById(R.id.f40201dq);
        this.P = (TextView) view.findViewById(R.id.f40211dr);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.f40971ft);
        this.X = relativeLayout;
        relativeLayout.setVisibility(8);
        this.Y = (ImageView) view.findViewById(R.id.f40981fu);
        this.Z = (TextView) view.findViewById(R.id.f40961fs);
        this.f85054a0 = (ImageView) view.findViewById(R.id.f40991fv);
        this.X.setOnClickListener(this);
        this.K.setNickNameClickListener(new QFSVipNickNameAndIconView.a() { // from class: com.tencent.biz.qqcircle.immersive.feed.q
        });
        this.M.setOnClickListener(this);
        this.Q = (TextView) view.findViewById(R.id.f41011fx);
        QCircleMaxHeightScrollView qCircleMaxHeightScrollView = (QCircleMaxHeightScrollView) ((ViewStub) view.findViewById(R.id.f513427u)).inflate();
        this.T = qCircleMaxHeightScrollView;
        qCircleMaxHeightScrollView.setMaxHeight((int) (ImmersiveUtils.getScreenHeight() * 0.6f));
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView = (QFSExpandableAsyncTextView) view.findViewById(R.id.f165233va0);
        this.S = qFSExpandableAsyncTextView;
        qFSExpandableAsyncTextView.setOnClickListener(new b());
        this.S.setSpecialClickAreaColor(R.color.f158017al3);
        this.S.setNeedSpecialAreaBold(true);
        this.S.setExpandTextColor(R.color.cla);
        this.S.setCollapseTextColor(R.color.cla);
        q1();
        E1(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void Q0() {
        super.Q0();
        N1();
    }

    public void Q1(int i3, int i16, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(ua0.c.a(feedCloudMeta$StFeed).setActionType(i3).setSubActionType(i16).setExt1(str)).setPageId(y0()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void c1(boolean z16) {
        super.c1(z16);
        this.f85059f0 = z16;
        d2(z16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSFeedPermissionChangeEvent.class);
        eventClass.add(QCircleFeedJSPermissionChangeEvent.class);
        eventClass.add(QCircleConfigChangeEvent.class);
        eventClass.add(QFSFollowTabLiveListEvent.class);
        return eventClass;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        String str = ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.jumpUrl.get();
        QLog.d("QFSFeedChildBottomInfoPresenter", 1, "pre:onFeedSelected " + str);
        if (com.tencent.biz.qqcircle.utils.cy.n(str)) {
            String k3 = com.tencent.biz.qqcircle.utils.cy.k(str, "meterial");
            QLog.d("QFSFeedChildBottomInfoPresenter", 1, "pre: materialId " + str);
            ((IAEDownloadMaterial) QRoute.api(IAEDownloadMaterial.class)).preDownloadMaterial(k3);
        } else if (com.tencent.biz.qqcircle.utils.cy.m(str)) {
            String k16 = com.tencent.biz.qqcircle.utils.cy.k(str, QCircleSchemeAttr.UnifiedTagFlow.UNIFIED_ID);
            QLog.d("QFSFeedChildBottomInfoPresenter", 1, "pre: materialId " + k16);
            ((IAEDownloadMaterial) QRoute.api(IAEDownloadMaterial.class)).preDownloadMaterial(k16);
        }
        q1();
        c2(n0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildBottomInfoPresenter";
    }

    public QFSExpandableAsyncTextView z1() {
        return this.S;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L1(Object obj) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
