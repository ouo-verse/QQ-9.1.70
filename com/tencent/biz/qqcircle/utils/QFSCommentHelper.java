package com.tencent.biz.qqcircle.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleCommentPicLayerBean;
import com.tencent.biz.qqcircle.beans.QFSCommentInputWindowConfig;
import com.tencent.biz.qqcircle.beans.QFSCommentPicInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentPublishFeedAttrBean;
import com.tencent.biz.qqcircle.beans.QFSCommentPublishFeedDraftBean;
import com.tencent.biz.qqcircle.beans.QFSFakeCommentAvatarUpdateEvent;
import com.tencent.biz.qqcircle.beans.QFSFeedCommentInfo;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.comment.QFSBaseCommentPresenter;
import com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSCommentHintTextEvent;
import com.tencent.biz.qqcircle.events.QFSCommentSendEvent;
import com.tencent.biz.qqcircle.events.QFSFakeCommentSendEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.result.ImageResult;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$ExpressionInfo;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSCommentHelper implements SimpleEventReceiver {
    private static volatile QFSCommentHelper H = null;
    private static volatile boolean I = false;
    private static volatile boolean J = false;
    private static volatile boolean K = true;
    private static volatile boolean L;
    private static volatile boolean M;
    private ValueAnimator D;
    private Boolean E;
    private int F;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<com.tencent.biz.qqcircle.comment.u> f92564f;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<b> f92565h;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, an> f92562d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, List<String>> f92563e = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, QFSCommentPublishFeedDraftBean> f92566i = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private final Map<String, String> f92567m = new HashMap();
    private final List<String> C = new ArrayList();
    private boolean G = false;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f92570d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f92571e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f92572f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f92573h;

        a(View view, boolean z16, float f16, View view2) {
            this.f92570d = view;
            this.f92571e = z16;
            this.f92572f = f16;
            this.f92573h = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f92570d.getTag() instanceof Float) {
                float floatValue = ((Float) this.f92570d.getTag()).floatValue();
                this.f92573h.setTranslationX(floatValue);
                float f16 = floatValue / this.f92572f;
                boolean z16 = this.f92571e;
                if (z16) {
                    f16 += 1.0f;
                }
                View view = this.f92570d;
                if (!z16) {
                    f16 = 1.0f - f16;
                }
                view.setAlpha(f16);
            }
            QFSCommentHelper.this.D = null;
            this.f92570d.setTag(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSCommentHelper.this.D = null;
            this.f92570d.setTag(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            float f16;
            View view = this.f92570d;
            if (this.f92571e) {
                f16 = this.f92572f;
            } else {
                f16 = 0.0f;
            }
            view.setTag(Float.valueOf(f16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void a(int i3);

        void b(FeedCloudMeta$StReply feedCloudMeta$StReply, o20.d dVar);

        void c(FeedCloudMeta$StComment feedCloudMeta$StComment, o20.d dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class c extends ITaskListener.Stub {

        /* renamed from: d, reason: collision with root package name */
        private com.tencent.biz.qqcircle.comment.u f92575d;

        /* renamed from: e, reason: collision with root package name */
        private QFSCommentInputWindowConfig f92576e;

        public c(com.tencent.biz.qqcircle.comment.u uVar, QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
            this.f92575d = uVar;
            this.f92576e = qFSCommentInputWindowConfig;
        }

        private void v() {
            this.f92575d = null;
            this.f92576e = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(b bVar, boolean z16, FeedCloudMeta$StReply feedCloudMeta$StReply, FeedCloudMeta$StComment feedCloudMeta$StComment) {
            com.tencent.biz.qqcircle.comment.u uVar;
            if (bVar != null && (uVar = this.f92575d) != null) {
                if (z16) {
                    bVar.b(feedCloudMeta$StReply, uVar.d8());
                } else {
                    bVar.c(feedCloudMeta$StComment, uVar.d8());
                }
            }
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(TaskInfo taskInfo) throws RemoteException {
            QFSCommentInputWindowConfig qFSCommentInputWindowConfig;
            boolean z16;
            String str;
            FeedCloudMeta$StReply feedCloudMeta$StReply;
            if (taskInfo != null && this.f92575d != null && (qFSCommentInputWindowConfig = this.f92576e) != null && qFSCommentInputWindowConfig.activity != null && qFSCommentInputWindowConfig.commentInfo != null && !TextUtils.isEmpty(qFSCommentInputWindowConfig.commentPicPath)) {
                QFSCommentInputWindowConfig qFSCommentInputWindowConfig2 = this.f92576e;
                QFSFeedCommentInfo qFSFeedCommentInfo = qFSCommentInputWindowConfig2.commentInfo;
                final b bVar = qFSCommentInputWindowConfig2.inputListener;
                if (qFSFeedCommentInfo.mComment != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (qFSFeedCommentInfo.mFakeComment == null && qFSFeedCommentInfo.mFakeReply == null) {
                    QLog.d("CommentPicTag", 1, "[addFakeCommentOrReply] picPath: " + this.f92576e.commentPicPath);
                    ImageResult imageResult = new ImageResult();
                    QFSCommentInputWindowConfig qFSCommentInputWindowConfig3 = this.f92576e;
                    if (qFSCommentInputWindowConfig3.publishType == 2) {
                        str = qFSCommentInputWindowConfig3.emojiPicUrl;
                    } else {
                        str = qFSCommentInputWindowConfig3.commentPicPath;
                    }
                    imageResult.setOriginUrl(str);
                    imageResult.setOriginWidth(this.f92576e.commentPicWidth);
                    imageResult.setOriginHeight(this.f92576e.commentPicHeight);
                    FeedCloudMeta$StComment feedCloudMeta$StComment = null;
                    if (z16) {
                        feedCloudMeta$StReply = QFSCommentHelper.L().q(this.f92575d, qFSFeedCommentInfo, imageResult, this.f92576e.publishType);
                    } else {
                        feedCloudMeta$StReply = null;
                    }
                    if (!z16) {
                        feedCloudMeta$StComment = QFSCommentHelper.L().p(this.f92575d, imageResult, qFSFeedCommentInfo.mCommentText, this.f92576e.publishType);
                    }
                    final FeedCloudMeta$StComment feedCloudMeta$StComment2 = feedCloudMeta$StComment;
                    final boolean z17 = z16;
                    final FeedCloudMeta$StReply feedCloudMeta$StReply2 = feedCloudMeta$StReply;
                    RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.utils.aw
                        @Override // java.lang.Runnable
                        public final void run() {
                            QFSCommentHelper.c.this.x(bVar, z17, feedCloudMeta$StReply2, feedCloudMeta$StComment2);
                        }
                    });
                    qFSFeedCommentInfo.mFakeComment = feedCloudMeta$StComment2;
                    qFSFeedCommentInfo.mFakeReply = feedCloudMeta$StReply;
                }
                QFSCommentHelper.L().m(QFSCommentPublishFeedAttrBean.COMMENT_PIC_PUBLISH_TYPE, String.valueOf(taskInfo.getTaskId()));
                QLog.d("CommentPicTag", 1, "process:" + taskInfo.getUploadProgress());
                if (taskInfo.isFinish() && taskInfo.getMediaInfos() != null && (taskInfo.getMediaInfos().get(0).getUploadResult() instanceof ImageResult)) {
                    ImageResult imageResult2 = (ImageResult) taskInfo.getMediaInfos().get(0).getUploadResult();
                    QLog.d("CommentPicTag", 1, "originUrl:" + imageResult2.getOriginUrl() + ", w: " + imageResult2.getOriginWidth() + ", h: " + imageResult2.getOriginHeight());
                    com.tencent.biz.qqcircle.comment.h.G().X(this);
                    if (z16) {
                        QFSCommentHelper.L().v0(this.f92576e, this.f92575d, bVar, imageResult2, false);
                    } else {
                        QFSCommentHelper.L().u0(this.f92576e, this.f92575d, bVar, imageResult2, false);
                    }
                    v();
                    return;
                }
                if (taskInfo.isCancelled()) {
                    QLog.d("CommentPicTag", 1, "onTaskChange fakeResult code failed: " + taskInfo.getErrCode() + ", errMsg: " + taskInfo.getErrMsg());
                    com.tencent.biz.qqcircle.comment.h.G().X(this);
                    v();
                    return;
                }
                return;
            }
            com.tencent.biz.qqcircle.comment.h.G().X(this);
        }
    }

    QFSCommentHelper() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private String B(String str, String str2, String str3) {
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb5.append(str);
        } else {
            sb5.append("0");
        }
        if (!TextUtils.isEmpty(str2)) {
            sb5.append("&&");
            sb5.append(str2);
        } else {
            sb5.append("&&");
            sb5.append("0");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb5.append("&&");
            sb5.append(str3);
        } else {
            sb5.append("&&");
            sb5.append("0");
        }
        return sb5.toString();
    }

    private void D0(QFSCommentInputWindowConfig qFSCommentInputWindowConfig, com.tencent.biz.qqcircle.comment.u uVar) {
        if (qFSCommentInputWindowConfig != null && qFSCommentInputWindowConfig.commentInfo != null && uVar != null && !TextUtils.isEmpty(qFSCommentInputWindowConfig.goodsContent)) {
            QFSFeedCommentInfo qFSFeedCommentInfo = qFSCommentInputWindowConfig.commentInfo;
            an E = E(qFSFeedCommentInfo.mFeed, qFSFeedCommentInfo.mComment, qFSFeedCommentInfo.mReply);
            if (E == null) {
                B0(qFSCommentInputWindowConfig.commentInfo.mFeed, null, null, qFSCommentInputWindowConfig.goodsContent, qFSCommentInputWindowConfig.ecommerceBean, "", "", "");
                return;
            }
            String str = E.f() + qFSCommentInputWindowConfig.goodsContent;
            E.g(qFSCommentInputWindowConfig.ecommerceBean);
            E.k(str);
        }
    }

    private void E0(QFSFeedCommentInfo qFSFeedCommentInfo, String str, com.tencent.biz.qqcircle.comment.u uVar) {
        if (qFSFeedCommentInfo != null && uVar != null && !TextUtils.isEmpty(str)) {
            QLog.d("CommentPicTag", 1, "[showInputPopupWindow] path: " + str);
            an E = L().E(qFSFeedCommentInfo.mFeed, qFSFeedCommentInfo.mComment, qFSFeedCommentInfo.mReply);
            if (E == null) {
                uVar.R2(str);
            } else {
                E.a();
                E.j(str);
            }
        }
    }

    private com.tencent.biz.qqcircle.comment.h F() {
        return com.tencent.biz.qqcircle.comment.h.G();
    }

    private FeedCloudMeta$StComment F0(com.tencent.biz.qqcircle.comment.u uVar, @NonNull FeedCloudMeta$StComment feedCloudMeta$StComment, @Nullable ImageResult imageResult, int i3) {
        if (uVar != null && imageResult != null) {
            if (i3 != 2) {
                if (i3 == 3) {
                    feedCloudMeta$StComment.commentPic.setHasFlag(true);
                    feedCloudMeta$StComment.commentPic.picUrl.set(imageResult.getOriginUrl());
                    feedCloudMeta$StComment.commentPic.width.set(imageResult.getOriginWidth());
                    feedCloudMeta$StComment.commentPic.height.set(imageResult.getOriginHeight());
                }
            } else {
                FeedCloudMeta$ExpressionInfo feedCloudMeta$ExpressionInfo = new FeedCloudMeta$ExpressionInfo();
                feedCloudMeta$ExpressionInfo.expressionURL.set(imageResult.getOriginUrl());
                feedCloudMeta$ExpressionInfo.expression_src.set(uVar.B1());
                feedCloudMeta$ExpressionInfo.width.set(Math.max(imageResult.getOriginWidth(), 0));
                feedCloudMeta$ExpressionInfo.height.set(Math.max(imageResult.getOriginHeight(), 0));
                if (!TextUtils.isEmpty(uVar.z1())) {
                    feedCloudMeta$ExpressionInfo.expressionMD5.set(uVar.z1());
                }
                feedCloudMeta$StComment.expressionInfo.set(feedCloudMeta$ExpressionInfo);
            }
        }
        return feedCloudMeta$StComment;
    }

    private FeedCloudMeta$StReply G0(com.tencent.biz.qqcircle.comment.u uVar, @NonNull FeedCloudMeta$StReply feedCloudMeta$StReply, @Nullable ImageResult imageResult, int i3) {
        if (imageResult != null && uVar != null) {
            if (i3 != 2) {
                if (i3 == 3) {
                    feedCloudMeta$StReply.replyPic.setHasFlag(true);
                    feedCloudMeta$StReply.replyPic.picUrl.set(imageResult.getOriginUrl());
                    feedCloudMeta$StReply.replyPic.width.set(imageResult.getOriginWidth());
                    feedCloudMeta$StReply.replyPic.height.set(imageResult.getOriginHeight());
                }
            } else {
                FeedCloudMeta$ExpressionInfo feedCloudMeta$ExpressionInfo = new FeedCloudMeta$ExpressionInfo();
                feedCloudMeta$ExpressionInfo.expressionURL.set(imageResult.getOriginUrl());
                feedCloudMeta$ExpressionInfo.width.set(Math.max(imageResult.getOriginWidth(), 0));
                feedCloudMeta$ExpressionInfo.height.set(Math.max(imageResult.getOriginHeight(), 0));
                feedCloudMeta$ExpressionInfo.expression_src.set(uVar.B1());
                if (!TextUtils.isEmpty(uVar.z1())) {
                    feedCloudMeta$ExpressionInfo.expressionMD5.set(uVar.z1());
                }
                feedCloudMeta$StReply.expressionInfo.set(feedCloudMeta$ExpressionInfo);
            }
        }
        return feedCloudMeta$StReply;
    }

    public static String H() {
        return "fakeId_" + System.currentTimeMillis();
    }

    public static void H0(@NonNull TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(" \u00b7 " + str);
        textView.setVisibility(0);
    }

    public static QFSCommentHelper L() {
        if (H == null) {
            synchronized (QFSCommentHelper.class) {
                if (H == null) {
                    H = new QFSCommentHelper();
                }
            }
        }
        return H;
    }

    private QFSTransitionAnimBean R(ImageView imageView, String str) {
        if (imageView != null) {
            int[] iArr = new int[2];
            imageView.getLocationInWindow(iArr);
            int i3 = iArr[0];
            QFSTransitionAnimBean backTransition = new QFSTransitionAnimBean().setLayoutRect(new QFSTransitionAnimBean.SourceRect(i3, iArr[1], imageView.getWidth() + i3, iArr[1] + imageView.getHeight())).setImageUrl(str).setScaleType(ImageView.ScaleType.FIT_CENTER).setBackTransition(true);
            backTransition.setCoverDrawable(imageView.getDrawable());
            return backTransition;
        }
        return null;
    }

    private void S(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        String C = C(qCircleCommentUpdateEvent.feedId, qCircleCommentUpdateEvent.comment.f398447id.get());
        List<String> list = this.f92563e.get(C);
        if (list == null) {
            list = new ArrayList<>();
            this.f92563e.put(C, list);
        }
        list.add(qCircleCommentUpdateEvent.reply.f398460id.get());
    }

    private void U(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        List<String> list = this.f92563e.get(C(qCircleCommentUpdateEvent.feedId, qCircleCommentUpdateEvent.comment.f398447id.get()));
        if (RFSafeListUtils.isEmpty(list)) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next(), qCircleCommentUpdateEvent.reply.f398460id.get())) {
                it.remove();
                return;
            }
        }
    }

    public static boolean V(int i3, int i16) {
        if ((i3 & i16) != 0) {
            return true;
        }
        return false;
    }

    private void X(com.tencent.biz.qqcircle.comment.u uVar, FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser != null && feedCloudMeta$StUser.is_e_da_xia.get()) {
            uVar.k1();
            uVar.y0(h.a(R.string.f1899740u));
            QLog.d("QFSCommentHelper", 1, "initEDaxiaInputLabelAndHint");
        }
    }

    private void Y() {
        boolean z16;
        if (!I) {
            synchronized (QFSCommentHelper.class) {
                if (!I) {
                    J = TextUtils.equals(l.b("exp_likepocketboard"), "exp_likepocketboard_B");
                    K = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_host_push_tab_enable", true);
                    L = k.g("exp_xsj_ad_comment_label", "exp_xsj_ad_comment_label_C");
                    if (!k.g("exp_xsj_cmt_hot_and_fiery_bar_1", "exp_xsj_cmt_hot_and_fiery_bar_1_D") && !k.g("exp_xsj_cmt_hot_and_fiery_bar_1", "exp_xsj_cmt_hot_and_fiery_bar_1_E")) {
                        z16 = false;
                        M = z16;
                        I = true;
                        QLog.d("QFSCommentHelper", 1, "[initExpConfig] isHitLikeAndPushTabThanksExp:", Boolean.valueOf(J), ", enableHostPushTab: ", Boolean.valueOf(K), ", mEnableAdCommentLabelOptExp: ", Boolean.valueOf(L), ", mEnableHotAndFieryBarOptExp: ", Boolean.valueOf(M));
                    }
                    z16 = true;
                    M = z16;
                    I = true;
                    QLog.d("QFSCommentHelper", 1, "[initExpConfig] isHitLikeAndPushTabThanksExp:", Boolean.valueOf(J), ", enableHostPushTab: ", Boolean.valueOf(K), ", mEnableAdCommentLabelOptExp: ", Boolean.valueOf(L), ", mEnableHotAndFieryBarOptExp: ", Boolean.valueOf(M));
                }
            }
        }
    }

    private void Z(final com.tencent.biz.qqcircle.comment.u uVar, final QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        QFSFeedCommentInfo qFSFeedCommentInfo;
        if (uVar != null && qFSCommentInputWindowConfig != null && qFSCommentInputWindowConfig.activity != null && (qFSFeedCommentInfo = qFSCommentInputWindowConfig.commentInfo) != null) {
            final FeedCloudMeta$StFeed feedCloudMeta$StFeed = qFSFeedCommentInfo.mFeed;
            final FeedCloudMeta$StComment feedCloudMeta$StComment = qFSFeedCommentInfo.mComment;
            final FeedCloudMeta$StReply feedCloudMeta$StReply = qFSFeedCommentInfo.mReply;
            uVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.biz.qqcircle.utils.ap
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    QFSCommentHelper.i0(FeedCloudMeta$StFeed.this, feedCloudMeta$StComment, feedCloudMeta$StReply, uVar, dialogInterface);
                }
            });
            uVar.B0(new QFSBaseInputPopupWindow.c() { // from class: com.tencent.biz.qqcircle.utils.aq
                @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow.c
                public final void onDismiss() {
                    QFSCommentHelper.this.j0(uVar, feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply, qFSCommentInputWindowConfig);
                }
            });
        }
    }

    private void a0(@NonNull final com.tencent.biz.qqcircle.comment.u uVar, @NonNull final QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        if (qFSCommentInputWindowConfig.activity == null) {
            return;
        }
        uVar.z0(new QFSBaseInputPopupWindow.b() { // from class: com.tencent.biz.qqcircle.utils.ao
            @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow.b
            public final void a() {
                QFSCommentHelper.this.k0(qFSCommentInputWindowConfig, uVar);
            }

            @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow.b
            public /* synthetic */ void b() {
                com.tencent.biz.qqcircle.comment.c.a(this);
            }
        });
    }

    public static boolean c0(@NonNull String str) {
        return str.startsWith("fakeId_");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h0(View view, float f16, boolean z16, View view2, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        view.setTranslationX(floatValue);
        float f17 = floatValue / f16;
        if (z16) {
            f17 += 1.0f;
        }
        if (!z16) {
            f17 = 1.0f - f17;
        }
        view2.setAlpha(f17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, com.tencent.biz.qqcircle.comment.u uVar, DialogInterface dialogInterface) {
        an E = L().E(feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply);
        if (E != null) {
            uVar.C0(uVar.x0(E.f(), true));
            uVar.B2(E.b());
            uVar.P2(E.d(), E.c());
            uVar.R2(E.e());
        } else {
            uVar.C0("");
        }
        uVar.I = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(com.tencent.biz.qqcircle.comment.u uVar, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        String str = "";
        uVar.y0("");
        String j06 = uVar.j0();
        L().B0(feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply, j06, uVar.E1(), uVar.C1(), uVar.A1(), uVar.y1());
        uVar.y0(I(null, null, null, qFSCommentInputWindowConfig.commentInfo.mHintText));
        QFSCommentHintTextEvent qFSCommentHintTextEvent = new QFSCommentHintTextEvent();
        if (feedCloudMeta$StFeed != null) {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        qFSCommentHintTextEvent.setFeedId(str);
        qFSCommentHintTextEvent.setCommentText(j06);
        SimpleEventBus.getInstance().dispatchEvent(qFSCommentHintTextEvent);
        b bVar = qFSCommentInputWindowConfig.inputListener;
        if (bVar != null) {
            bVar.a(qFSCommentInputWindowConfig.relocationType);
        }
        this.f92564f = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(QFSCommentInputWindowConfig qFSCommentInputWindowConfig, com.tencent.biz.qqcircle.comment.u uVar) {
        QLog.d("QFSCommentHelper", 1, "onClickSend()");
        if (qFSCommentInputWindowConfig.activity.isFinishing()) {
            QLog.d("QFSCommentHelper", 1, "onCommentSend(): mCommentInputPopupWindow null");
            return;
        }
        String y16 = uVar.y1();
        String C1 = uVar.C1();
        String j06 = uVar.j0();
        boolean isEmpty = TextUtils.isEmpty(C1);
        boolean isEmpty2 = TextUtils.isEmpty(y16);
        if (TextUtils.isEmpty(j06.trim()) && isEmpty && isEmpty2) {
            QCircleToast.o(qFSCommentInputWindowConfig.activity.getString(R.string.f170929b52), 0);
            return;
        }
        if (!HostNetworkUtils.isNetworkAvailable()) {
            QCircleToast.l(QCircleToast.f91645e, qFSCommentInputWindowConfig.activity.getString(R.string.f195304e9), 0, true, false);
            return;
        }
        if (qFSCommentInputWindowConfig.commentInfo.mFeed == null) {
            QLog.e("QFSCommentHelper", 1, "feed is null");
            return;
        }
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_format_comment_multi_line_breaks", false)) {
            j06 = j06.replaceAll("\\n([\\p{Zs}\\t\\v\\f\\r]*\\n)+", "\n\n").replaceAll("(^[\\t\\n]+)|([\\t\\n]+$)", "");
        }
        qFSCommentInputWindowConfig.commentInfo.mCommentText = j06;
        if (!isEmpty2) {
            qFSCommentInputWindowConfig.commentPicPath = y16;
            qFSCommentInputWindowConfig.publishType = 3;
            com.tencent.biz.qqcircle.comment.h.G().p0(y16, new c(uVar, qFSCommentInputWindowConfig));
            o(uVar, qFSCommentInputWindowConfig.commentInfo);
            return;
        }
        if (!isEmpty) {
            QLog.d("QFSCommentHelper", 1, "publish emoji pic comment. ");
            qFSCommentInputWindowConfig.publishType = 2;
            ImageResult imageResult = new ImageResult();
            imageResult.setOriginUrl(C1);
            String A1 = uVar.A1();
            QLog.d("QFSCommentHelper", 1, "emojiPath=" + A1);
            if (!TextUtils.isEmpty(A1)) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(A1, options);
                QLog.d("QFSCommentHelper", 1, "emoji size=" + options.outWidth + HippyTKDListViewAdapter.X + options.outHeight);
                int max = Math.max(options.outWidth, 0);
                int max2 = Math.max(options.outHeight, 0);
                imageResult.setOriginWidth(max);
                imageResult.setOriginHeight(max2);
            }
            w(qFSCommentInputWindowConfig, uVar, imageResult);
            return;
        }
        qFSCommentInputWindowConfig.publishType = 1;
        w(qFSCommentInputWindowConfig, uVar, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l0(QFSCommentInputWindowConfig qFSCommentInputWindowConfig, com.tencent.biz.qqcircle.comment.u uVar, DialogInterface dialogInterface) {
        String str;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = qFSCommentInputWindowConfig.commentInfo.mFeed;
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(13, str, true));
        if (!TextUtils.isEmpty(qFSCommentInputWindowConfig.commentInfo.mCommentText)) {
            uVar.C0(qFSCommentInputWindowConfig.commentInfo.mCommentText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m0(QFSCommentInputWindowConfig qFSCommentInputWindowConfig, QFSBaseInputPopupWindow.b bVar, DialogInterface dialogInterface) {
        String str;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = qFSCommentInputWindowConfig.commentInfo.mFeed;
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(13, str, false));
        if (bVar != null) {
            bVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n0(QFSCommentInputWindowConfig qFSCommentInputWindowConfig, com.tencent.biz.qqcircle.comment.u uVar, DialogInterface dialogInterface) {
        String str;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = qFSCommentInputWindowConfig.commentInfo.mFeed;
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(33, str, true));
        if (!TextUtils.isEmpty(qFSCommentInputWindowConfig.commentInfo.mCommentText)) {
            uVar.C0(qFSCommentInputWindowConfig.commentInfo.mCommentText);
        }
    }

    private void o(com.tencent.biz.qqcircle.comment.u uVar, QFSFeedCommentInfo qFSFeedCommentInfo) {
        QFSCommentAtHelper.p0(uVar.i9());
        uVar.y0(null);
        uVar.r1();
        uVar.C0("");
        uVar.dismiss();
        SimpleEventBus.getInstance().dispatchEvent(new QFSCommentSendEvent(qFSFeedCommentInfo.mFeed));
        L().r0(qFSFeedCommentInfo.mFeed, qFSFeedCommentInfo.mComment, qFSFeedCommentInfo.mReply);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o0(QFSCommentInputWindowConfig qFSCommentInputWindowConfig, QFSBaseInputPopupWindow.b bVar, DialogInterface dialogInterface) {
        String str;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = qFSCommentInputWindowConfig.commentInfo.mFeed;
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(33, str, false));
        if (bVar != null) {
            bVar.b();
        }
    }

    @Deprecated
    public static void p0(Context context) {
        HostSelectMemberUtils.onAtClick(ASEngineUtils.getHostContext(context), true, 1, uq3.c.Z2(), 257);
    }

    private boolean r(Activity activity, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (QFSBaseCommentPresenter.o(activity, feedCloudMeta$StFeed) || QFSBaseCommentPresenter.m(feedCloudMeta$StFeed)) {
            return false;
        }
        return true;
    }

    private void t0() {
        I = false;
    }

    private com.tencent.biz.qqcircle.comment.u u(@NonNull QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        QFSFeedCommentInfo qFSFeedCommentInfo;
        String string;
        int i3;
        boolean z16;
        if (qFSCommentInputWindowConfig.activity != null && (qFSFeedCommentInfo = qFSCommentInputWindowConfig.commentInfo) != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = qFSFeedCommentInfo.mFeed;
            FeedCloudMeta$StComment feedCloudMeta$StComment = qFSFeedCommentInfo.mComment;
            FeedCloudMeta$StReply feedCloudMeta$StReply = qFSFeedCommentInfo.mReply;
            an E = L().E(feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply);
            boolean z17 = false;
            if (E != null) {
                if (!qFSCommentInputWindowConfig.isShowPostBtn && TextUtils.isEmpty(E.f()) && TextUtils.isEmpty(E.d()) && TextUtils.isEmpty(E.e())) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                qFSCommentInputWindowConfig.isShowPostBtn = z16;
            }
            qFSCommentInputWindowConfig.allowShowGoodsView = com.tencent.biz.qqcircle.helpers.l.e().c(feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply);
            com.tencent.biz.qqcircle.comment.u uVar = new com.tencent.biz.qqcircle.comment.u(qFSCommentInputWindowConfig);
            E0(qFSCommentInputWindowConfig.commentInfo, qFSCommentInputWindowConfig.commentPicPath, uVar);
            D0(qFSCommentInputWindowConfig, uVar);
            uVar.A0(qFSCommentInputWindowConfig.needShowAt);
            uVar.G2(feedCloudMeta$StComment, feedCloudMeta$StReply);
            uVar.B2(qFSCommentInputWindowConfig.ecommerceBean);
            FeedCloudMeta$StUser m3 = QCirclePluginGlobalInfo.m();
            if (m3.label.get() == 1) {
                z17 = true;
            }
            uVar.C2(z17);
            if (!z17) {
                string = I(feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply, qFSCommentInputWindowConfig.commentInfo.mHintText);
            } else {
                string = qFSCommentInputWindowConfig.activity.getResources().getString(R.string.f181863ex);
            }
            uVar.y0(string);
            X(uVar, m3);
            Window window = uVar.getWindow();
            if (!qFSCommentInputWindowConfig.isShowEmoji && !qFSCommentInputWindowConfig.isShowAiComment && !qFSCommentInputWindowConfig.isShowHalfScreenPicPanel) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            window.setSoftInputMode(i3);
            return uVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(QFSCommentInputWindowConfig qFSCommentInputWindowConfig, com.tencent.biz.qqcircle.comment.u uVar, b bVar, @Nullable ImageResult imageResult, boolean z16) {
        Activity activity;
        QFSFeedCommentInfo qFSFeedCommentInfo;
        FeedCloudMeta$StComment F0;
        if (qFSCommentInputWindowConfig != null && (activity = qFSCommentInputWindowConfig.activity) != null && (qFSFeedCommentInfo = qFSCommentInputWindowConfig.commentInfo) != null && uVar != null) {
            String str = qFSFeedCommentInfo.mCommentText;
            boolean z17 = qFSCommentInputWindowConfig.isFromContentPage;
            int i3 = qFSCommentInputWindowConfig.relocationType;
            FeedCloudMeta$StComment feedCloudMeta$StComment = qFSFeedCommentInfo.mFakeComment;
            if (feedCloudMeta$StComment == null) {
                F0 = p(uVar, imageResult, str, qFSCommentInputWindowConfig.publishType);
            } else {
                F0 = F0(uVar, feedCloudMeta$StComment, imageResult, qFSCommentInputWindowConfig.publishType);
            }
            if (bVar != null && z16) {
                QLog.d("QFSCommentHelper", 1, "addFakeComment commentInputListener callback success");
                bVar.c(F0, uVar.d8());
            } else {
                QLog.e("QFSCommentHelper", 1, "addFakeComment commentInputListener null, isAddFakeComment: " + z16);
            }
            if (i3 == 103) {
                F().o(activity.getIntent().getIntExtra("contextHashCode", 0), qFSFeedCommentInfo.mFeed, F0, z17, true, QCirclePluginUtil.getQCircleInitBean(activity));
            } else {
                F().o(activity.hashCode(), qFSFeedCommentInfo.mFeed, F0, z17, qFSFeedCommentInfo.showSuccessToast, QCirclePluginUtil.getQCircleInitBean(activity));
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSFakeCommentSendEvent(qFSFeedCommentInfo.mFeed, F0));
        }
    }

    public static void v(final String str, final View view, long j3) {
        if (view == null || !c0(str)) {
            return;
        }
        view.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.utils.QFSCommentHelper.2
            @Override // java.lang.Runnable
            public void run() {
                view.getLocationInWindow(r1);
                int[] iArr = {iArr[0] + (view.getWidth() / 2), iArr[1] + (view.getHeight() / 2)};
                SimpleEventBus.getInstance().dispatchEvent(new QFSFakeCommentAvatarUpdateEvent(str, iArr));
            }
        }, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(QFSCommentInputWindowConfig qFSCommentInputWindowConfig, com.tencent.biz.qqcircle.comment.u uVar, b bVar, @Nullable ImageResult imageResult, boolean z16) {
        Activity activity;
        QFSFeedCommentInfo qFSFeedCommentInfo;
        FeedCloudMeta$StReply G0;
        if (qFSCommentInputWindowConfig != null && (activity = qFSCommentInputWindowConfig.activity) != null && (qFSFeedCommentInfo = qFSCommentInputWindowConfig.commentInfo) != null && uVar != null) {
            boolean z17 = qFSCommentInputWindowConfig.isFromContentPage;
            FeedCloudMeta$StReply feedCloudMeta$StReply = qFSFeedCommentInfo.mFakeReply;
            if (feedCloudMeta$StReply == null) {
                G0 = q(uVar, qFSFeedCommentInfo, imageResult, qFSCommentInputWindowConfig.publishType);
            } else {
                G0 = G0(uVar, feedCloudMeta$StReply, imageResult, qFSCommentInputWindowConfig.publishType);
            }
            FeedCloudMeta$StReply feedCloudMeta$StReply2 = G0;
            if (bVar != null && z16) {
                QLog.d("QFSCommentHelper", 1, "addFakeReply commentInputListener callback success");
                bVar.b(feedCloudMeta$StReply2, uVar.d8());
            } else {
                QLog.e("QFSCommentHelper", 1, "addFakeReply commentInputListener null, isAddFakeReply: " + z16);
            }
            F().m(activity.hashCode(), qFSFeedCommentInfo.mFeed, qFSFeedCommentInfo.mComment, feedCloudMeta$StReply2, z17, QCirclePluginUtil.getQCircleInitBean(activity));
        }
    }

    private void w(QFSCommentInputWindowConfig qFSCommentInputWindowConfig, com.tencent.biz.qqcircle.comment.u uVar, @Nullable ImageResult imageResult) {
        b bVar;
        WeakReference<b> weakReference = this.f92565h;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        b bVar2 = bVar;
        boolean z16 = true;
        if (qFSCommentInputWindowConfig != null && uVar != null && bVar2 != null) {
            if (qFSCommentInputWindowConfig.commentInfo.mComment == null) {
                z16 = false;
            }
            if (z16) {
                v0(qFSCommentInputWindowConfig, uVar, bVar2, imageResult, true);
            } else {
                u0(qFSCommentInputWindowConfig, uVar, bVar2, imageResult, true);
            }
            o(uVar, qFSCommentInputWindowConfig.commentInfo);
            return;
        }
        QLog.d("QFSCommentHelper", 1, "[doSendCommentOrReply] invalid params");
    }

    public static void x0(@NonNull View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(view.getBackground());
        d.h(view, 0, arrayList, arrayList2, null);
    }

    public String A(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        String str;
        String str2;
        String str3 = "";
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        if (feedCloudMeta$StComment == null) {
            str2 = "";
        } else {
            str2 = feedCloudMeta$StComment.f398447id.get();
        }
        if (feedCloudMeta$StReply != null) {
            str3 = feedCloudMeta$StReply.f398460id.get();
        }
        return B(str, str2, str3);
    }

    public boolean A0(@NonNull final QFSCommentInputWindowConfig qFSCommentInputWindowConfig, final QFSBaseInputPopupWindow.b bVar) {
        if (qFSCommentInputWindowConfig.activity != null && qFSCommentInputWindowConfig.commentInfo != null) {
            if (!fb0.a.b(qFSCommentInputWindowConfig.activity.hashCode() + "QFSCommentHelper", 500L)) {
                final com.tencent.biz.qqcircle.comment.u u16 = u(qFSCommentInputWindowConfig);
                if (u16 == null) {
                    return false;
                }
                this.f92565h = new WeakReference<>(qFSCommentInputWindowConfig.inputListener);
                this.f92564f = new WeakReference<>(u16);
                u16.z0(bVar);
                u16.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.biz.qqcircle.utils.at
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        QFSCommentHelper.n0(QFSCommentInputWindowConfig.this, u16, dialogInterface);
                    }
                });
                u16.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.biz.qqcircle.utils.au
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        QFSCommentHelper.o0(QFSCommentInputWindowConfig.this, bVar, dialogInterface);
                    }
                });
                u16.H2(qFSCommentInputWindowConfig);
                return true;
            }
        }
        QLog.e("QFSCommentHelper", 1, "showShareMessageReplyInputWindow param error");
        return false;
    }

    public void B0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, String str, be beVar, String str2, String str3, String str4) {
        C0(A(feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply), str, beVar, str2, str3, str4);
    }

    public String C(String str, String str2) {
        return str + "|" + str2;
    }

    public void C0(String str, String str2, be beVar, String str3, String str4, String str5) {
        an anVar = new an();
        anVar.k(str2);
        anVar.g(beVar);
        anVar.i(str3);
        anVar.h(str4);
        anVar.j(str5);
        this.f92562d.put(str, anVar);
    }

    public List<String> D(String str) {
        return this.f92563e.get(str);
    }

    public an E(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        String A = A(feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply);
        if (this.f92562d.containsKey(A)) {
            return this.f92562d.get(A);
        }
        return null;
    }

    public String G(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        an E = E(feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply);
        if (E != null && E.f() != null) {
            return E.f();
        }
        return "";
    }

    public String I(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (feedCloudMeta$StReply != null && !TextUtils.isEmpty(feedCloudMeta$StReply.f398460id.get()) && feedCloudMeta$StReply.postUser != null) {
            return String.format(h.a(R.string.f170928b51), feedCloudMeta$StReply.postUser.nick.get());
        }
        if (feedCloudMeta$StComment != null && !TextUtils.isEmpty(feedCloudMeta$StComment.f398447id.get()) && feedCloudMeta$StComment.postUser != null) {
            return String.format(h.a(R.string.f170928b51), feedCloudMeta$StComment.postUser.nick.get());
        }
        if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(feedCloudMeta$StFeed.commentTextInfo.normalCommentBoxDesc.get())) {
            return feedCloudMeta$StFeed.commentTextInfo.normalCommentBoxDesc.get();
        }
        return uq3.c.b1("qqcircle", "qcircle_comment_input_place_holder", QCircleApplication.APP.getResources().getString(R.string.f181843ev));
    }

    public void I0(boolean z16, int i3) {
        this.E = Boolean.TRUE;
        this.F = i3;
        uq3.k.a().j("sp_key_is_reached_push_ran_count_limit", z16);
        uq3.k.a().n("sp_key_last_reached_push_ran_limit_time", System.currentTimeMillis());
        uq3.k.a().m("sp_key_push_ran_max_count", i3);
    }

    public int J() {
        com.tencent.biz.qqcircle.comment.u K2 = K();
        if (K2 != null) {
            return K2.c0();
        }
        return 0;
    }

    public com.tencent.biz.qqcircle.comment.u K() {
        WeakReference<com.tencent.biz.qqcircle.comment.u> weakReference = this.f92564f;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int M(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        if (feedCloudMeta$StFeed == null) {
            return 0;
        }
        if (feedCloudMeta$StComment == null) {
            return 1;
        }
        if (feedCloudMeta$StReply != null && !TextUtils.isEmpty(feedCloudMeta$StReply.postUser.f398463id.get())) {
            return 3;
        }
        return 2;
    }

    public QFSCommentPublishFeedDraftBean N(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f92566i.get(str);
    }

    public Iterator<QFSCommentPublishFeedDraftBean> O() {
        return this.f92566i.values().iterator();
    }

    public String P(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f92567m.get(str);
    }

    public int Q() {
        return this.F;
    }

    protected void T(SimpleBaseEvent simpleBaseEvent) {
        com.tencent.biz.qqcircle.comment.u K2 = K();
        if (K2 != null && simpleBaseEvent.mHashCode == K2.P()) {
            K2.N2((QCircleAtUpdateEvent) simpleBaseEvent);
        }
    }

    public boolean W(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.C.contains(str);
    }

    public boolean b0() {
        return uq3.o.e1();
    }

    public boolean d0() {
        Boolean bool = this.E;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(uq3.k.a().c("sp_key_is_reached_push_ran_count_limit", false));
        this.E = valueOf;
        if (!valueOf.booleanValue()) {
            QLog.d("QFSCommentHelper", 1, "[isReachedPushRanCountLimit] not reached push ran count limit");
            return false;
        }
        if (!uq3.n.c(uq3.k.a().f("sp_key_last_reached_push_ran_limit_time", 0L), System.currentTimeMillis())) {
            this.E = Boolean.FALSE;
            uq3.k.a().j("sp_key_is_reached_push_ran_count_limit", false);
            QLog.d("QFSCommentHelper", 1, "[isReachedPushRanCountLimit] reached push ran count limit, but not same day");
            return false;
        }
        this.E = Boolean.TRUE;
        this.F = uq3.k.a().e("sp_key_push_ran_max_count", 0);
        QLog.d("QFSCommentHelper", 1, "[isReachedPushRanCountLimit] reached push ran count limit, maxCount:" + this.F);
        return true;
    }

    public boolean e0(String str) {
        if (TextUtils.isEmpty(str) || !this.f92567m.containsValue(str)) {
            return false;
        }
        return true;
    }

    public void f0(Context context, String str, boolean z16, int i3, boolean z17, ImageView imageView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FeedCloudMeta$StImage feedCloudMeta$StImage = new FeedCloudMeta$StImage();
        feedCloudMeta$StImage.picUrl.set(str);
        QFSCommentPicInfo qFSCommentPicInfo = new QFSCommentPicInfo(feedCloudMeta$StImage);
        qFSCommentPicInfo.setEmojiPic(z16);
        qFSCommentPicInfo.setExpressionSrc(i3);
        QCircleCommentPicLayerBean qCircleCommentPicLayerBean = new QCircleCommentPicLayerBean();
        if (z16) {
            qCircleCommentPicLayerBean.setNeedSaveOperate(false);
            qCircleCommentPicLayerBean.setNeedAddImageOperate(z17);
        }
        qCircleCommentPicLayerBean.setTransitionAnimBean(R(imageView, str));
        qCircleCommentPicLayerBean.setCommentPicInfoList(Collections.singletonList(qFSCommentPicInfo));
        com.tencent.biz.qqcircle.launcher.c.t(context, qCircleCommentPicLayerBean);
    }

    public void g0(Context context, String str, boolean z16, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.G = true;
        f0(context, str, z16, i3, false, null);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleCommentUpdateEvent.class);
        arrayList.add(QCircleAtUpdateEvent.class);
        return arrayList;
    }

    public void l(@NonNull final View view, @NonNull final View view2, final boolean z16, final float f16) {
        float f17;
        float f18;
        float f19 = 0.0f;
        if (view2.getTag() instanceof Float) {
            float floatValue = ((Float) view2.getTag()).floatValue();
            if (z16) {
                f18 = f16;
            } else {
                f18 = 0.0f;
            }
            if (floatValue == f18) {
                QLog.d("QFSCommentHelper", 1, "[actionPostBtnWithAnim] is same anim.");
                return;
            }
        }
        ValueAnimator valueAnimator = this.D;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.D.cancel();
        }
        if (view2.getLocalVisibleRect(new Rect()) == z16) {
            return;
        }
        float[] fArr = new float[2];
        if (z16) {
            f17 = f16;
        } else {
            f17 = 0.0f;
        }
        fArr[0] = f17;
        if (!z16) {
            f19 = f16;
        }
        fArr[1] = f19;
        ValueAnimator duration = ValueAnimator.ofFloat(fArr).setDuration(200L);
        this.D = duration;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.utils.av
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                QFSCommentHelper.h0(view, f16, z16, view2, valueAnimator2);
            }
        });
        this.D.addListener(new a(view2, z16, f16, view));
        this.D.start();
    }

    public void m(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f92567m.put(str, str2);
    }

    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.C.add(str);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleCommentUpdateEvent) {
            QCircleCommentUpdateEvent qCircleCommentUpdateEvent = (QCircleCommentUpdateEvent) simpleBaseEvent;
            int i3 = qCircleCommentUpdateEvent.eventStatus;
            if (i3 == 6) {
                U(qCircleCommentUpdateEvent);
                return;
            } else {
                if (i3 == 5) {
                    S(qCircleCommentUpdateEvent);
                    return;
                }
                return;
            }
        }
        if (simpleBaseEvent instanceof QCircleAtUpdateEvent) {
            T(simpleBaseEvent);
        }
    }

    public FeedCloudMeta$StComment p(com.tencent.biz.qqcircle.comment.u uVar, @Nullable ImageResult imageResult, String str, int i3) {
        FeedCloudMeta$StComment feedCloudMeta$StComment = new FeedCloudMeta$StComment();
        if (uVar == null) {
            return feedCloudMeta$StComment;
        }
        feedCloudMeta$StComment.f398447id.set(H());
        feedCloudMeta$StComment.content.set(str);
        feedCloudMeta$StComment.createTime.set((int) (System.currentTimeMillis() / 1000));
        FeedCloudMeta$StUser m3 = QCirclePluginGlobalInfo.m();
        if (QCircleHostGlobalInfo.getStUserInfo() != null) {
            m3.iconDecorate.set(QCircleHostGlobalInfo.getStUserInfo().iconDecorate.get());
        }
        feedCloudMeta$StComment.postUser.set(m3);
        F0(uVar, feedCloudMeta$StComment, imageResult, i3);
        be E1 = uVar.E1();
        if (E1 != null) {
            feedCloudMeta$StComment.goodsInfo.setHasFlag(true);
            feedCloudMeta$StComment.goodsInfo.isGoodsCmt.set(1);
            feedCloudMeta$StComment.goodsInfo.goodsID.set(E1.c());
            feedCloudMeta$StComment.goodsInfo.goodsType.set(com.tencent.biz.qqcircle.helpers.l.e().m(E1.b()));
            feedCloudMeta$StComment.goodsInfo.original_url.set(E1.a());
        }
        return feedCloudMeta$StComment;
    }

    public FeedCloudMeta$StReply q(com.tencent.biz.qqcircle.comment.u uVar, QFSFeedCommentInfo qFSFeedCommentInfo, @Nullable ImageResult imageResult, int i3) {
        FeedCloudMeta$StReply feedCloudMeta$StReply = new FeedCloudMeta$StReply();
        feedCloudMeta$StReply.f398460id.set(H());
        feedCloudMeta$StReply.content.set(qFSFeedCommentInfo.mCommentText);
        feedCloudMeta$StReply.createTime.set((int) (System.currentTimeMillis() / 1000));
        feedCloudMeta$StReply.postUser.set(QCirclePluginGlobalInfo.m());
        G0(uVar, feedCloudMeta$StReply, imageResult, i3);
        FeedCloudMeta$StReply feedCloudMeta$StReply2 = qFSFeedCommentInfo.mReply;
        if (feedCloudMeta$StReply2 != null && !TextUtils.isEmpty(feedCloudMeta$StReply2.postUser.f398463id.get())) {
            feedCloudMeta$StReply.targetUser.set(qFSFeedCommentInfo.mReply.postUser.get());
            feedCloudMeta$StReply.targetReplyID.set(qFSFeedCommentInfo.mReply.f398460id.get());
        }
        return feedCloudMeta$StReply;
    }

    public void q0() {
        this.f92562d.clear();
        this.f92566i.clear();
        this.f92567m.clear();
        this.E = null;
        t0();
    }

    public void r0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        this.f92562d.remove(A(feedCloudMeta$StFeed, feedCloudMeta$StComment, feedCloudMeta$StReply));
        if (feedCloudMeta$StFeed != null) {
            this.f92562d.remove(feedCloudMeta$StFeed.f398449id.get());
        }
    }

    public void s() {
        this.f92563e.clear();
    }

    public void s0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f92567m.remove(str);
    }

    public void t() {
        this.f92566i.clear();
    }

    public boolean w0(@NonNull QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        com.tencent.biz.qqcircle.comment.u u16;
        if (qFSCommentInputWindowConfig.activity != null && qFSCommentInputWindowConfig.commentInfo != null) {
            if (!fb0.a.b(qFSCommentInputWindowConfig.activity.hashCode() + "QFSCommentHelper", 500L)) {
                if (!r(qFSCommentInputWindowConfig.activity, qFSCommentInputWindowConfig.commentInfo.mFeed) || com.tencent.biz.qqcircle.helpers.d.a(11, true) || (u16 = u(qFSCommentInputWindowConfig)) == null) {
                    return false;
                }
                this.f92565h = new WeakReference<>(qFSCommentInputWindowConfig.inputListener);
                this.f92564f = new WeakReference<>(u16);
                a0(u16, qFSCommentInputWindowConfig);
                Z(u16, qFSCommentInputWindowConfig);
                u16.H2(qFSCommentInputWindowConfig);
                return true;
            }
        }
        QLog.e("QFSCommentHelper", 1, "showInputPopupWindow param error");
        return false;
    }

    public boolean x() {
        Y();
        return L;
    }

    public boolean y() {
        Y();
        return M;
    }

    public boolean y0(Activity activity, QFSFeedCommentInfo qFSFeedCommentInfo, b bVar, boolean z16, QCircleReportBean qCircleReportBean) {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
        qFSCommentInputWindowConfig.activity = activity;
        qFSCommentInputWindowConfig.commentInfo = qFSFeedCommentInfo;
        qFSCommentInputWindowConfig.isFromContentPage = z16;
        qFSCommentInputWindowConfig.inputListener = bVar;
        qFSCommentInputWindowConfig.reportBean = qCircleReportBean;
        return w0(qFSCommentInputWindowConfig);
    }

    public boolean z() {
        Y();
        return K;
    }

    public boolean z0(@NonNull final QFSCommentInputWindowConfig qFSCommentInputWindowConfig, final QFSBaseInputPopupWindow.b bVar) {
        if (qFSCommentInputWindowConfig.activity != null && qFSCommentInputWindowConfig.commentInfo != null) {
            if (!fb0.a.b(qFSCommentInputWindowConfig.activity.hashCode() + "QFSCommentHelper", 500L)) {
                final com.tencent.biz.qqcircle.comment.u u16 = u(qFSCommentInputWindowConfig);
                if (u16 == null) {
                    return false;
                }
                this.f92565h = new WeakReference<>(qFSCommentInputWindowConfig.inputListener);
                this.f92564f = new WeakReference<>(u16);
                u16.z0(bVar);
                u16.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.biz.qqcircle.utils.ar
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        QFSCommentHelper.l0(QFSCommentInputWindowConfig.this, u16, dialogInterface);
                    }
                });
                u16.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.biz.qqcircle.utils.as
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        QFSCommentHelper.m0(QFSCommentInputWindowConfig.this, bVar, dialogInterface);
                    }
                });
                u16.H2(qFSCommentInputWindowConfig);
                return true;
            }
        }
        QLog.e("QFSCommentHelper", 1, "showSendMsgInputWindow param error");
        return false;
    }
}
