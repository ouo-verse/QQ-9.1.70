package com.tencent.biz.qqcircle.comment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.activity.QCircleFolderActivity;
import com.tencent.biz.qqcircle.beans.QFSCommentExtendInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLike;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$CommDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleBase$StUserBusiData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class af {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f83325a;

    /* renamed from: b, reason: collision with root package name */
    private static String f83326b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f83327c;

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<String, Boolean> f83328d = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements OnPromiseRejected {
        a() {
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
        public void onFail(String str) {
            RFWLog.e("QFSCommentUtils", RFWLog.USR, new RuntimeException("IReplyIoc  error = " + str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements OnPromiseResolved<com.tencent.biz.qqcircle.comment.animation.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPromiseResolved f83329a;

        b(OnPromiseResolved onPromiseResolved) {
            this.f83329a = onPromiseResolved;
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onDone(com.tencent.biz.qqcircle.comment.animation.a aVar) {
            this.f83329a.onDone(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A(DialogInterface dialogInterface, int i3) {
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        f83327c = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(FeedCloudRead$CommDialog feedCloudRead$CommDialog, String str, DialogInterface dialogInterface, int i3) {
        l(feedCloudRead$CommDialog.cancel_btn_text.get(), str);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(View view, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = intValue;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D(View view, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = intValue;
        view.setLayoutParams(layoutParams);
    }

    public static boolean E(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StComment == null || QFSCommentHelper.c0(feedCloudMeta$StComment.f398447id.get())) {
            return false;
        }
        if (!QCirclePluginUtil.isOwner(feedCloudMeta$StFeed.poster.f398463id.get()) && !QCirclePluginUtil.isOwner(feedCloudMeta$StComment.postUser.get())) {
            return false;
        }
        return true;
    }

    public static boolean F(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StReply == null || QFSCommentHelper.c0(feedCloudMeta$StReply.f398460id.get())) {
            return false;
        }
        if (!QCirclePluginUtil.isOwner(feedCloudMeta$StFeed.poster.f398463id.get()) && !QCirclePluginUtil.isOwner(feedCloudMeta$StReply.postUser.get())) {
            return false;
        }
        return true;
    }

    public static boolean G(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment == null || QFSCommentHelper.c0(feedCloudMeta$StComment.f398447id.get())) {
            return false;
        }
        return !QCirclePluginUtil.isOwner(feedCloudMeta$StComment.postUser.f398463id.get());
    }

    public static boolean H(FeedCloudMeta$StReply feedCloudMeta$StReply) {
        if (feedCloudMeta$StReply == null || QFSCommentHelper.c0(feedCloudMeta$StReply.f398460id.get())) {
            return false;
        }
        return !QCirclePluginUtil.isOwner(feedCloudMeta$StReply.postUser.f398463id.get());
    }

    public static void I(boolean z16) {
        f83325a = z16;
    }

    public static void J(String str) {
        QLog.d("QFSCommentUtils", 4, "showingFastReplyCommentId: " + str);
        f83326b = str;
    }

    public static void K(Context context, final DialogInterface.OnClickListener onClickListener, final String str) {
        final FeedCloudRead$CommDialog y16 = h.G().y();
        if (y16 != null && !TextUtils.isEmpty(y16.title.get())) {
            if (bz.r() && bz.t() && (context instanceof QCircleFolderActivity)) {
                context = QBaseActivity.sTopActivity;
            }
            Context context2 = context;
            DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.aa
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    af.z(onClickListener, y16, str, dialogInterface, i3);
                }
            };
            SpannableString k3 = k(context2, y16);
            QQCustomDialog createDialogWithCheckBox = DialogUtil.createDialogWithCheckBox(context2, 230, y16.title.get(), k3.toString(), y16.check_box_text.get(), false, y16.cancel_btn_text.get(), y16.ok_btn_text.get(), new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.ab
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    af.A(dialogInterface, i3);
                }
            }, onClickListener2, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.ac
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    af.B(FeedCloudRead$CommDialog.this, str, dialogInterface, i3);
                }
            });
            TextView textView = (TextView) createDialogWithCheckBox.findViewById(R.id.dialogText);
            textView.setText(k3);
            textView.setHighlightColor(0);
            textView.setMovementMethod(RichTextHelper.getMovementMethodInstance());
            createDialogWithCheckBox.getWindow().setFlags(131072, 131072);
            createDialogWithCheckBox.show();
            return;
        }
        QLog.d("QFSCommentUtils", 1, "dialogConfig is empty.");
        QCircleToast.h(R.string.f188893xx, 0);
    }

    public static AnimatorSet L(final View view, View view2, View view3, int i3) {
        if (view == null || view2 == null || view3 == null || i3 <= 0) {
            return null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, i3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.comment.ad
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                af.C(view, valueAnimator);
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view3, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofInt, ofFloat, ofFloat2, ofFloat3);
        animatorSet.setDuration(200L);
        animatorSet.addListener(new d(view, view2, view3));
        animatorSet.start();
        return animatorSet;
    }

    public static AnimatorSet M(final View view, View view2, View view3, int i3) {
        if (view != null && view2 != null && view3 != null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(i3, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.comment.ae
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    af.D(view, valueAnimator);
                }
            });
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view3, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofInt, ofFloat, ofFloat2, ofFloat3);
            animatorSet.setDuration(200L);
            animatorSet.addListener(new c(view, view2, view3, i3));
            animatorSet.start();
            return animatorSet;
        }
        return null;
    }

    public static void N() {
        int i3;
        uq3.k.b().n("sp_key_fast_reply_panel_last_time", System.currentTimeMillis());
        int e16 = uq3.k.b().e("sp_key_fast_reply_panel_count", 0);
        int e17 = uq3.k.b().e("sp_key_fast_reply_panel_total_count", 0);
        uq3.k b16 = uq3.k.b();
        int i16 = 1;
        if (e16 >= uq3.c.Q1()) {
            i3 = 1;
        } else {
            i3 = e16 + 1;
        }
        b16.m("sp_key_fast_reply_panel_count", i3);
        uq3.k b17 = uq3.k.b();
        if (e16 < uq3.c.P1()) {
            i16 = 1 + e17;
        }
        b17.m("sp_key_fast_reply_panel_total_count", i16);
    }

    public static void O() {
        if (uq3.k.b().c("sp_key_fast_reply_state", false)) {
            return;
        }
        uq3.k.b().j("sp_key_fast_reply_state", true);
    }

    public static void f(PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField, QFSCommentExtendInfo qFSCommentExtendInfo) {
        if (pBRepeatMessageField != null && qFSCommentExtendInfo != null) {
            if (!TextUtils.isEmpty(qFSCommentExtendInfo.mFeedId)) {
                FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
                feedCloudCommon$Entry.key.set("feed_id");
                feedCloudCommon$Entry.value.set(qFSCommentExtendInfo.mFeedId);
                pBRepeatMessageField.add(feedCloudCommon$Entry);
            }
            if (qFSCommentExtendInfo.mCreateTime != 0) {
                try {
                    FeedCloudCommon$Entry feedCloudCommon$Entry2 = new FeedCloudCommon$Entry();
                    feedCloudCommon$Entry2.key.set(AlbumCacheData.CREATE_TIME);
                    feedCloudCommon$Entry2.value.set(String.valueOf(qFSCommentExtendInfo.mCreateTime));
                    pBRepeatMessageField.add(feedCloudCommon$Entry2);
                } catch (Exception e16) {
                    QLog.e("QFSCommentUtils", 1, "[addCommentInfoToExt] createTime parse error, e:" + e16.toString());
                }
            }
            if (!TextUtils.isEmpty(qFSCommentExtendInfo.mPostUin)) {
                FeedCloudCommon$Entry feedCloudCommon$Entry3 = new FeedCloudCommon$Entry();
                feedCloudCommon$Entry3.key.set("user_id");
                feedCloudCommon$Entry3.value.set(qFSCommentExtendInfo.mPostUin);
                pBRepeatMessageField.add(feedCloudCommon$Entry3);
            }
            if (!TextUtils.isEmpty(qFSCommentExtendInfo.mCommentId)) {
                FeedCloudCommon$Entry feedCloudCommon$Entry4 = new FeedCloudCommon$Entry();
                feedCloudCommon$Entry4.key.set("comment_id");
                feedCloudCommon$Entry4.value.set(qFSCommentExtendInfo.mCommentId);
                pBRepeatMessageField.add(feedCloudCommon$Entry4);
            }
            if (!TextUtils.isEmpty(qFSCommentExtendInfo.mReplyId)) {
                FeedCloudCommon$Entry feedCloudCommon$Entry5 = new FeedCloudCommon$Entry();
                feedCloudCommon$Entry5.key.set("reply_id");
                feedCloudCommon$Entry5.value.set(qFSCommentExtendInfo.mReplyId);
                pBRepeatMessageField.add(feedCloudCommon$Entry5);
            }
        }
    }

    public static int g(@NonNull View view) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_full_comment_panel_container_height", true)) {
            QLog.d("QFSCommentUtils", 1, "[calculateContainerHeight] use measuredHeight. ");
            return view.getMeasuredHeight();
        }
        Context context = view.getContext();
        if (context == null) {
            QLog.d("QFSCommentUtils", 1, "[calculateContainerHeight] context is null, use  getScreenHeight");
            return DisplayUtil.getScreenHeight();
        }
        int screenHeight = DisplayUtil.getScreenHeight();
        if (screenHeight == DisplayUtil.getInstantScreenHeight(context)) {
            return screenHeight - cx.h();
        }
        return screenHeight;
    }

    public static boolean h() {
        return !uq3.k.b().c("sp_key_fast_reply_state", false);
    }

    public static void i() {
        f83328d.clear();
    }

    public static Drawable j(@ColorRes int i3, @ColorRes int i16) {
        Application application = RFWApplication.getApplication();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(DisplayUtil.dip2px(application, 100.0f));
        int d16 = QFSQUIUtilsKt.d(application, i3);
        int a16 = QFSQUIUtilsKt.a(QFSQUIUtilsKt.d(application, i16), 0.3f);
        gradientDrawable.setColor(d16);
        gradientDrawable.setStroke(DisplayUtil.dip2px(application, 1.0f) / 2, a16);
        return gradientDrawable;
    }

    private static SpannableString k(Context context, FeedCloudRead$CommDialog feedCloudRead$CommDialog) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < feedCloudRead$CommDialog.jump_infos.size(); i3++) {
            arrayList.add(new RichTextHelper.RichTextData(feedCloudRead$CommDialog.jump_infos.get(i3).key_word.get(), feedCloudRead$CommDialog.jump_infos.get(i3).jump_url.get()));
        }
        return RichTextHelper.buildSpannable(feedCloudRead$CommDialog.text.get(), context, false, arrayList);
    }

    private static void l(String str, String str2) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("eid", QCircleDaTongConstant.ElementId.EM_XSJ_AI_CMT_POP_OPERATION);
        buildElementParams.put("xsj_item_name", str);
        buildElementParams.put("xsj_custom_pgid", str2);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    public static void m(String str, boolean z16, boolean z17, String str2) {
        String str3;
        String str4;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TARGET_FEED_ID, str);
        if (z16) {
            str3 = "success";
        } else {
            str3 = QCircleDaTongConstant.ElementParamValue.XSJ_STATUS_CMT_FAIL;
        }
        buildElementParams.put("xsj_status", str3);
        if (z17) {
            str4 = "cmt";
        } else {
            str4 = "reply";
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, str4);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, str2);
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMT_VIDEO_STATUS_TOAST);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    public static boolean n(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        String b16 = com.tencent.biz.qqcircle.utils.l.b("exp_comment2");
        if (TextUtils.equals(b16, "exp_comment2_C")) {
            return true;
        }
        if (!TextUtils.equals(b16, "exp_comment2_B")) {
            return false;
        }
        QQCircleBase$StUserBusiData userExtraData = QCircleHostUtil.getUserExtraData(feedCloudMeta$StUser);
        if (userExtraData != null && userExtraData.feedNum.get() == 0) {
            return true;
        }
        return false;
    }

    public static boolean o() {
        return TextUtils.equals(com.tencent.biz.qqcircle.utils.l.b("exp_comment2"), "exp_comment2_C");
    }

    public static boolean p(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean z16;
        boolean z17 = false;
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        String str = feedCloudMeta$StFeed.f398449id.get();
        if (!str.isEmpty()) {
            HashMap<String, Boolean> hashMap = f83328d;
            if (hashMap.containsKey(str)) {
                return Boolean.TRUE.equals(hashMap.get(str));
            }
        }
        boolean contains = feedCloudMeta$StFeed.opMask2.get().contains(48);
        boolean o16 = uq3.c.o();
        boolean p16 = uq3.c.p();
        if (!o16 && !p16) {
            z16 = false;
        } else {
            z16 = true;
        }
        QLog.d("QFSCommentUtils", 1, "enableCommentPublishFeed feedId = " + str + " isAllowCommentVideoInOpMask = " + contains + ", enableCommentPublishFeed = " + o16 + ", enableCommentPublishPic = " + p16);
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && contains && z16) {
            z17 = true;
        }
        f83328d.put(str, Boolean.valueOf(z17));
        return z17;
    }

    public static boolean q() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_feed_comment_expose_again", true);
    }

    public static boolean r(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        FeedCloudMeta$StLike feedCloudMeta$StLike;
        if (feedCloudMeta$StComment == null || !feedCloudMeta$StComment.show_submit_ran_comment_btn.get() || (feedCloudMeta$StLike = feedCloudMeta$StComment.likeInfo) == null || feedCloudMeta$StLike.negativeLikeStatus.get() == 1) {
            return false;
        }
        return true;
    }

    public static LinearLayout s(Context context) {
        if (context == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, cx.a(20.0f)));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setVisibility(8);
        ImageView imageView = new ImageView(context);
        int a16 = cx.a(16.0f);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(a16, a16));
        imageView.setImageResource(R.drawable.qui_caution_circle_icon_secondary);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f189003y8));
        textView.setTextColor(ie0.a.f().g(context, R.color.qui_common_text_secondary, 1000));
        textView.setTextSize(12.0f);
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
        return linearLayout;
    }

    public static int t(EditText editText) {
        return editText.getText().toString().lastIndexOf("@", editText.getSelectionStart() - 1);
    }

    public static void u(View view, OnPromiseResolved<com.tencent.biz.qqcircle.comment.animation.a> onPromiseResolved) {
        RFWIocAbilityProvider.g().getIoc(com.tencent.biz.qqcircle.comment.animation.a.class).originView(view).done(new b(onPromiseResolved)).fail(new a()).run();
    }

    public static String v() {
        boolean o16 = uq3.c.o();
        boolean p16 = uq3.c.p();
        if (o16 && p16) {
            return "all";
        }
        if (o16) {
            return "video";
        }
        if (p16) {
            return "image";
        }
        return "";
    }

    public static int w(List<QFSCommentItemInfo> list, String str) {
        if (RFSafeListUtils.isEmpty(list) || TextUtils.isEmpty(str)) {
            return -1;
        }
        int i3 = -1;
        for (int i16 = 0; i16 < list.size(); i16++) {
            i3++;
            QFSCommentItemInfo qFSCommentItemInfo = list.get(i16);
            if (TextUtils.equals(str, qFSCommentItemInfo.comment.f398447id.get())) {
                return i3;
            }
            if (!RFSafeListUtils.isEmpty(qFSCommentItemInfo.replyItemList)) {
                i3 += qFSCommentItemInfo.replyItemList.size();
            }
        }
        return -1;
    }

    public static boolean x() {
        return f83325a;
    }

    public static boolean y(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment != null && TextUtils.equals(f83326b, feedCloudMeta$StComment.f398447id.get())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(DialogInterface.OnClickListener onClickListener, FeedCloudRead$CommDialog feedCloudRead$CommDialog, String str, DialogInterface dialogInterface, int i3) {
        if (f83327c && onClickListener != null) {
            l(feedCloudRead$CommDialog.ok_btn_text.get(), str);
            onClickListener.onClick(dialogInterface, i3);
        } else {
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f188073vp), 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class c implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f83330d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f83331e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f83332f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f83333h;

        c(View view, View view2, View view3, int i3) {
            this.f83330d = view;
            this.f83331e = view2;
            this.f83332f = view3;
            this.f83333h = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f83330d.setVisibility(8);
            this.f83330d.setAlpha(1.0f);
            ViewGroup.LayoutParams layoutParams = this.f83330d.getLayoutParams();
            layoutParams.height = this.f83333h;
            this.f83330d.setLayoutParams(layoutParams);
            this.f83331e.setVisibility(8);
            this.f83331e.setAlpha(1.0f);
            this.f83332f.setAlpha(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f83330d.setVisibility(0);
            this.f83331e.setVisibility(0);
            this.f83332f.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class d implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f83334d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f83335e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f83336f;

        d(View view, View view2, View view3) {
            this.f83334d = view;
            this.f83335e = view2;
            this.f83336f = view3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f83334d.setAlpha(1.0f);
            if (this.f83334d.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) this.f83334d.getLayoutParams()).height = -2;
            }
            this.f83335e.setAlpha(1.0f);
            this.f83336f.setVisibility(8);
            this.f83336f.setAlpha(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f83334d.setVisibility(0);
            this.f83335e.setVisibility(0);
            this.f83336f.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
