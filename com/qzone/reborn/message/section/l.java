package com.qzone.reborn.message.section;

import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedSignature;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.UserMedal;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.feedx.widget.countdown.QZoneTimeCountDownView;
import com.qzone.reborn.message.section.l;
import com.qzone.widget.QzoneZipAnimateUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vip.api.IVipIconUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.qzone.zipanimate.AnimationDrawableLoadedListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J*\u0010\u001c\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0014J\b\u0010\u001d\u001a\u00020\u0002H\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010$R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010$R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u00107R\u0018\u0010;\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010DR\u0014\u0010H\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010GR\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010J\u00a8\u0006N"}, d2 = {"Lcom/qzone/reborn/message/section/l;", "Lcom/qzone/reborn/message/section/QZOldStylePassiveMsgBaseSection;", "", "G", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "L", "Lcom/qzone/proxy/feedcomponent/model/User;", QCircleAlphaUserReporter.KEY_USER, "H", "P", "N", "M", QZoneJsConstants.ACTION_START_ANIMATION, "businessFeedData", "K", "J", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", tl.h.F, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "mAvatar", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "mAuthIcon", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "mNickname", BdhLogUtil.LogTag.Tag_Conn, "mVipSignature", "", "D", "Z", "isEnableCacheDrawable", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k;", "E", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k;", "optionCache", UserInfo.SEX_FEMALE, "mDescIcon", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mDescLayout", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "mDescArea", "Landroid/view/ViewGroup;", "I", "Landroid/view/ViewGroup;", "mTimeRoot", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mTimeArea", "Landroid/graphics/drawable/AnimationDrawable;", "Landroid/graphics/drawable/AnimationDrawable;", "mSignatureAnimationDrawable", "Lcooperation/qzone/zipanimate/AnimationDrawableLoadedListener;", "Lcooperation/qzone/zipanimate/AnimationDrawableLoadedListener;", "animationDrawableLoadedListener", "Landroid/graphics/drawable/Drawable$Callback;", "Landroid/graphics/drawable/Drawable$Callback;", "mSignatureCallback", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class l extends QZOldStylePassiveMsgBaseSection {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mVipSignature;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k optionCache;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView mDescIcon;

    /* renamed from: G, reason: from kotlin metadata */
    private LinearLayout mDescLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private QZoneRichTextView mDescArea;

    /* renamed from: I, reason: from kotlin metadata */
    private ViewGroup mTimeRoot;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView mTimeArea;

    /* renamed from: K, reason: from kotlin metadata */
    private AnimationDrawable mSignatureAnimationDrawable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView mAvatar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mAuthIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneNickNameView mNickname;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean isEnableCacheDrawable = VasNormalToggle.VAS_QZONE_SIGNATURE_CHANGE_CACHE_DRAWABLE.isEnable(true);

    /* renamed from: L, reason: from kotlin metadata */
    private final AnimationDrawableLoadedListener animationDrawableLoadedListener = new a();

    /* renamed from: M, reason: from kotlin metadata */
    private final Drawable.Callback mSignatureCallback = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/message/section/l$a", "Lcooperation/qzone/zipanimate/AnimationDrawableLoadedListener;", "Landroid/graphics/drawable/AnimationDrawable;", "animationDrawable", "", "onLoadedSuccess", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends AnimationDrawableLoadedListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(l this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.startAnimation();
        }

        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onLoadedSuccess(AnimationDrawable animationDrawable) {
            Intrinsics.checkNotNullParameter(animationDrawable, "animationDrawable");
            l.this.mSignatureAnimationDrawable = animationDrawable;
            ImageView imageView = l.this.mVipSignature;
            if (imageView != null) {
                final l lVar = l.this;
                imageView.post(new Runnable() { // from class: com.qzone.reborn.message.section.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.a.b(l.this);
                    }
                });
            }
            super.onLoadedSuccess(animationDrawable);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/message/section/l$b", "Lcom/qzone/proxy/feedcomponent/text/TextCellLayout$OnCellClickListener;", "Lcom/qzone/proxy/feedcomponent/text/TextCell;", "textCell", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "Lcom/qzone/proxy/feedcomponent/text/CellTextView$OnTextOperater;", JsonRuleKey.OPERATOR, "", NodeProps.ON_LONG_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements TextCellLayout.OnCellClickListener {
        b() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public void onClick(TextCell textCell, View view) {
            Intrinsics.checkNotNullParameter(textCell, "textCell");
            Intrinsics.checkNotNullParameter(view, "view");
            if (TextUtils.isEmpty(textCell.getUrl())) {
                return;
            }
            yo.d.d(textCell.getUrl(), view.getContext(), null);
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public boolean onLongClick(View view, CellTextView.OnTextOperater operator) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(operator, "operator");
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/message/section/l$c", "Landroid/graphics/drawable/Drawable$Callback;", "Landroid/graphics/drawable/Drawable;", "who", "", "invalidateDrawable", "Ljava/lang/Runnable;", "what", "", RemoteMessageConst.Notification.WHEN, "scheduleDrawable", "unscheduleDrawable", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements Drawable.Callback {
        c() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable who) {
            Intrinsics.checkNotNullParameter(who, "who");
            ImageView imageView = l.this.mVipSignature;
            if (imageView != null) {
                imageView.invalidate();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable who, Runnable what, long when) {
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
            ImageView imageView = l.this.mVipSignature;
            if (imageView != null) {
                imageView.scheduleDrawable(who, what, when);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable who, Runnable what) {
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
            ImageView imageView = l.this.mVipSignature;
            if (imageView != null) {
                imageView.unscheduleDrawable(who, what);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G() {
        BusinessFeedData businessFeedData = (BusinessFeedData) this.mData;
        if (businessFeedData != null) {
            ho.h.b(p(), businessFeedData.getUser().uin);
        }
    }

    private final void H(User user) {
        if (user.isCanShowFamousIcon()) {
            UserMedal userMedal = user.famousSpaceMedal;
            String str = userMedal != null ? userMedal.picUrl : null;
            if (!(str == null || str.length() == 0)) {
                ImageView imageView = this.mAuthIcon;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(user.famousSpaceMedal.picUrl).setTargetView(this.mAuthIcon).setNeedShowLoadingDrawable(false).setFailDrawable(com.qzone.adapter.feedcomponent.i.H().a0()));
                return;
            }
        }
        ImageView imageView2 = this.mAuthIcon;
        if (imageView2 == null) {
            return;
        }
        imageView2.setVisibility(8);
    }

    private final void J(User user) {
        QZoneUserAvatarView qZoneUserAvatarView = this.mAvatar;
        if (qZoneUserAvatarView == null) {
            return;
        }
        if (qZoneUserAvatarView != null) {
            qZoneUserAvatarView.setVisibility(0);
        }
        QZoneUserAvatarView qZoneUserAvatarView2 = this.mAvatar;
        if (qZoneUserAvatarView2 != null) {
            qZoneUserAvatarView2.setUser(user);
        }
        AccessibilityUtil.s(this.mAvatar, user.nickName + com.qzone.util.l.a(R.string.gqz));
    }

    private final void K(BusinessFeedData businessFeedData) {
        Paint paint;
        QZoneNickNameView qZoneNickNameView = this.mNickname;
        if (qZoneNickNameView != null && (paint = qZoneNickNameView.getPaint()) != null) {
            paint.setShader(null);
        }
        int color = ResourcesCompat.getColor(p().getResources(), R.color.qui_common_text_primary, null);
        QZoneNickNameView qZoneNickNameView2 = this.mNickname;
        if (qZoneNickNameView2 != null) {
            qZoneNickNameView2.setData(businessFeedData, color);
        }
    }

    private final void L(BusinessFeedData feedData) {
        ImageView imageView = this.mVipSignature;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        QZoneRichTextView qZoneRichTextView = this.mDescArea;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setVisibility(8);
        }
        ImageView imageView2 = this.mDescIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        CellFeedSignature cellFeedSignature = feedData.cellFeedSignature;
        String str = cellFeedSignature != null ? cellFeedSignature.strUrl : null;
        if (!(str == null || str.length() == 0)) {
            N(feedData);
            return;
        }
        User user = feedData.getUser();
        String str2 = user != null ? user.qzoneDesc : null;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        M(feedData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(BusinessFeedData feedData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(feedData, "$feedData");
        yo.d.c(feedData.cellFeedSignature.strJumpUrl, view.getContext());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void P(BusinessFeedData feedData) {
        TextView textView = this.mTimeArea;
        if (textView != null) {
            textView.setVisibility(8);
        }
        if (feedData.isDeleteOnTimeFeed() && LoginData.getInstance().getUin() == feedData.getUser().uin) {
            LinearLayout linearLayout = this.mDescLayout;
            if (linearLayout != null) {
                linearLayout.setPadding(0, ViewUtils.dpToPx(1.0f), 0, 0);
            }
            TextView textView2 = this.mTimeArea;
            if (textView2 == null) {
                return;
            }
            textView2.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = this.mDescLayout;
        if (linearLayout2 != null) {
            linearLayout2.setPadding(0, 0, 0, 0);
        }
        String g16 = com.qzone.reborn.feedx.util.n.g(feedData);
        if (!TextUtils.isEmpty(g16)) {
            TextView textView3 = this.mTimeArea;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            TextView textView4 = this.mTimeArea;
            if (textView4 != null) {
                textView4.setText(g16);
            }
            TextView textView5 = this.mTimeArea;
            if (textView5 != null) {
                textView5.setContentDescription(g16);
                return;
            }
            return;
        }
        TextView textView6 = this.mTimeArea;
        if (textView6 == null) {
            return;
        }
        textView6.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(l this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startAnimation() {
        try {
            ImageView imageView = this.mVipSignature;
            if (imageView != null) {
                imageView.setImageDrawable(this.mSignatureAnimationDrawable);
            }
            AnimationDrawable animationDrawable = this.mSignatureAnimationDrawable;
            if (animationDrawable != null) {
                animationDrawable.setOneShot(false);
            }
            AnimationDrawable animationDrawable2 = this.mSignatureAnimationDrawable;
            if (animationDrawable2 != null) {
                animationDrawable2.setCallback(this.mSignatureCallback);
            }
            AnimationDrawable animationDrawable3 = this.mSignatureAnimationDrawable;
            if (animationDrawable3 != null) {
                animationDrawable3.start();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        QZoneNickNameView qZoneNickNameView = this.mNickname;
        if (qZoneNickNameView != null) {
            qZoneNickNameView.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.mAvatar = (QZoneUserAvatarView) containerView.findViewById(R.id.nby);
        this.mAuthIcon = (ImageView) containerView.findViewById(R.id.nbx);
        QZoneNickNameView qZoneNickNameView = (QZoneNickNameView) containerView.findViewById(R.id.n87);
        this.mNickname = qZoneNickNameView;
        if (qZoneNickNameView != null) {
            qZoneNickNameView.setMaxWidth(QZoneFeedxViewUtils.g(p(), false));
        }
        QZoneNickNameView qZoneNickNameView2 = this.mNickname;
        if (qZoneNickNameView2 != null) {
            qZoneNickNameView2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.message.section.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.R(l.this, view);
                }
            });
        }
        this.mTimeRoot = (ViewGroup) containerView.findViewById(R.id.nbj);
        this.mTimeArea = (TextView) containerView.findViewById(R.id.nbi);
        QZoneTimeCountDownView qZoneTimeCountDownView = (QZoneTimeCountDownView) containerView.findViewById(R.id.nbh);
        if (qZoneTimeCountDownView != null) {
            qZoneTimeCountDownView.setVisibility(8);
        }
        this.mDescLayout = (LinearLayout) containerView.findViewById(R.id.f162923nc3);
        this.mDescArea = (QZoneRichTextView) containerView.findViewById(R.id.f162929nd4);
        this.mDescIcon = (ImageView) containerView.findViewById(R.id.mtz);
        int color = ResourcesCompat.getColor(containerView.getResources(), R.color.qui_common_text_secondary, null);
        QZoneRichTextView qZoneRichTextView = this.mDescArea;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setTextColor(color);
        }
        QZoneRichTextView qZoneRichTextView2 = this.mDescArea;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setTextColorLink(color);
        }
        this.mVipSignature = (ImageView) containerView.findViewById(R.id.nd6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nog};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void onBindData(BusinessFeedData data, int position, List<Object> payload) {
        if (data != null) {
            User user = data.getUser();
            Intrinsics.checkNotNullExpressionValue(user, "it.getUser()");
            J(user);
            H(user);
            L(data);
            P(data);
            K(data);
        }
    }

    private final void M(BusinessFeedData feedData) {
        cooperation.vip.c.b(140, 1);
        QZoneRichTextView qZoneRichTextView = this.mDescArea;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setVisibility(0);
        }
        ImageView imageView = this.mDescIcon;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        com.tencent.mobileqq.qzone.picload.c.a().j(this.mDescIcon, new c.C8489c().h(feedData.getUser().descToken).f("").e(R.color.qui_common_text_secondary));
        QZoneRichTextView qZoneRichTextView2 = this.mDescArea;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setRichText(feedData.getUser().qzoneDesc);
        }
        QZoneRichTextView qZoneRichTextView3 = this.mDescArea;
        if (qZoneRichTextView3 != null) {
            qZoneRichTextView3.setContentDescription(feedData.getUser().qzoneDesc);
        }
        QZoneRichTextView qZoneRichTextView4 = this.mDescArea;
        if (qZoneRichTextView4 != null) {
            qZoneRichTextView4.setOnCellClickListener(new b());
        }
    }

    private final void N(final BusinessFeedData feedData) {
        cooperation.vip.c.b(141, 1);
        ImageView imageView = this.mVipSignature;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.mVipSignature;
        ViewGroup.LayoutParams layoutParams = imageView2 != null ? imageView2.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = ViewUtils.dpToPx(feedData.cellFeedSignature.iWidth);
        }
        if (layoutParams != null) {
            layoutParams.height = ViewUtils.dpToPx(feedData.cellFeedSignature.iHeight);
        }
        ImageView imageView3 = this.mVipSignature;
        if (imageView3 != null) {
            imageView3.setLayoutParams(layoutParams);
        }
        ImageView imageView4 = this.mVipSignature;
        if (imageView4 != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.message.section.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.O(BusinessFeedData.this, view);
                }
            });
        }
        String descUrl = feedData.cellFeedSignature.strUrl;
        if (this.isEnableCacheDrawable) {
            if (this.optionCache == null) {
                com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar = new com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k();
                kVar.B(100);
                kVar.C(20);
                this.optionCache = kVar;
            }
            com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar2 = this.optionCache;
            if (kVar2 != null) {
                IVipIconUtils iVipIconUtils = (IVipIconUtils) QRoute.api(IVipIconUtils.class);
                Intrinsics.checkNotNullExpressionValue(descUrl, "descUrl");
                com.tencent.mobileqq.vas.ui.c qzoneFrameDrawable = iVipIconUtils.getQzoneFrameDrawable(descUrl, "", kVar2, 0);
                ImageView imageView5 = this.mVipSignature;
                if (imageView5 != null) {
                    imageView5.setImageDrawable(qzoneFrameDrawable.getDrawable());
                    return;
                }
                return;
            }
            return;
        }
        int hashCode = descUrl.hashCode();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(hashCode);
        QzoneZipAnimateUtil.j(descUrl, "vip_signature", sb5.toString(), -1, -1, 100, this.animationDrawableLoadedListener);
    }
}
