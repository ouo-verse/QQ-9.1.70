package com.qzone.reborn.message.section;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import bl.CommonNoticeBean;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.personalize.model.CustomHighFiveData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellHighFiveInfo;
import com.qzone.proxy.feedcomponent.model.CellLocalInfo;
import com.qzone.widget.MultiAnimationLayout;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.zipanimate.OnAnimationListener;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001TB\u0007\u00a2\u0006\u0004\bR\u0010SJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\r*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0014J*\u0010#\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0014J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000bH\u0016R\u0014\u0010(\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u00107R\u0016\u0010:\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010<\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00107R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010AR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010ER\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010NR\u0016\u0010Q\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010P\u00a8\u0006U"}, d2 = {"Lcom/qzone/reborn/message/section/ah;", "Lcom/qzone/reborn/message/section/y;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "J", "K", "", "highFiveCount", "T", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "needPlusOne", "Lkotlin/Pair;", "", "M", "U", "N", BdhLogUtil.LogTag.Tag_Req, "", "L", "(Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;)[Ljava/lang/String;", ExifInterface.LATITUDE_SOUTH, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lbl/a;", "data", "", "position", "", "", "payload", "O", "attached", "onAttachedChanged", "i", "I", "HIGH_FIVE_ANIM_SIZE", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "HIGH_FIVE_COUNT_ANIM_TRANSLATION", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "highFiveRoot", "D", "highFiveButton", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "highFiveButtonImage", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "highFiveText", "G", "highFiveSecondText", "H", "highFiveBeforeText", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "itemContainer", "Lcom/qzone/widget/MultiAnimationLayout;", "Lcom/qzone/widget/MultiAnimationLayout;", "highFiveAnimView", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "containerBgDrawable", "highFiveIcon", "highFivePressedIcon", "Ldl/c;", "P", "Ldl/c;", "highFiveIoc", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "onHighFiveClicked", "Z", "isHighFiveCountAnimPlaying", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ah extends y {

    /* renamed from: C, reason: from kotlin metadata */
    private View highFiveRoot;

    /* renamed from: D, reason: from kotlin metadata */
    private View highFiveButton;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView highFiveButtonImage;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView highFiveText;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView highFiveSecondText;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView highFiveBeforeText;

    /* renamed from: I, reason: from kotlin metadata */
    private FrameLayout itemContainer;

    /* renamed from: J, reason: from kotlin metadata */
    private MultiAnimationLayout highFiveAnimView;

    /* renamed from: K, reason: from kotlin metadata */
    private BusinessFeedData feedData;

    /* renamed from: L, reason: from kotlin metadata */
    private Drawable containerBgDrawable;

    /* renamed from: M, reason: from kotlin metadata */
    private Drawable highFiveIcon;

    /* renamed from: N, reason: from kotlin metadata */
    private Drawable highFivePressedIcon;

    /* renamed from: P, reason: from kotlin metadata */
    private dl.c highFiveIoc;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isHighFiveCountAnimPlaying;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int HIGH_FIVE_ANIM_SIZE = ef.d.b(80);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final float HIGH_FIVE_COUNT_ANIM_TRANSLATION = ef.d.a(Float.valueOf(12.0f));

    /* renamed from: Q, reason: from kotlin metadata */
    private View.OnClickListener onHighFiveClicked = new View.OnClickListener() { // from class: com.qzone.reborn.message.section.ag
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ah.P(ah.this, view);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/message/section/ah$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f58388e;

        c(String str) {
            this.f58388e = str;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            ah.this.isHighFiveCountAnimPlaying = false;
            TextView textView = ah.this.highFiveText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveText");
                textView = null;
            }
            textView.setText(this.f58388e);
        }
    }

    private final void J(BusinessFeedData feedData) {
        com.qzone.reborn.message.data.f fVar = com.qzone.reborn.message.data.f.f58260a;
        ImageView imageView = null;
        if (fVar.u(feedData)) {
            View view = this.highFiveButton;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveButton");
                view = null;
            }
            view.setBackground(null);
            ImageView imageView2 = this.highFiveButtonImage;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveButtonImage");
            } else {
                imageView = imageView2;
            }
            imageView.setImageDrawable(this.highFivePressedIcon);
            return;
        }
        if (fVar.x(feedData)) {
            View view2 = this.highFiveButton;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveButton");
                view2 = null;
            }
            view2.setBackground(this.containerBgDrawable);
            ImageView imageView3 = this.highFiveButtonImage;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveButtonImage");
            } else {
                imageView = imageView3;
            }
            imageView.setImageDrawable(this.highFiveIcon);
        }
    }

    private final void K(BusinessFeedData feedData) {
        Pair<Long, String> M = M(feedData, com.qzone.reborn.message.data.f.f58260a.u(feedData) && !this.isHighFiveCountAnimPlaying);
        long longValue = M.component1().longValue();
        String component2 = M.component2();
        T(feedData, longValue);
        Q();
        TextView textView = this.highFiveText;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveText");
            textView = null;
        }
        textView.setText(component2);
        TextView textView3 = this.highFiveSecondText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveSecondText");
            textView3 = null;
        }
        textView3.setText(component2);
        TextView textView4 = this.highFiveBeforeText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveBeforeText");
        } else {
            textView2 = textView4;
        }
        textView2.setText(component2);
    }

    private final String[] L(BusinessFeedData feedData) {
        String str;
        CellHighFiveInfo cellHighFiveInfo = feedData.cellHighFiveInfo;
        CustomHighFiveData e16 = com.qzone.personalize.business.b.n().e(LoginData.getInstance().getUin());
        if (e16 != null && !TextUtils.isEmpty(e16.strHighFiveResUrl)) {
            str = e16.strHighFiveResUrl;
        } else {
            str = "https://qzonestyle.gtimg.cn/qzone/client/mqq/notification/putongr.zip";
        }
        cellHighFiveInfo.rightHighFiveResUrl = str;
        RFWLog.i("QZonePassiveMessageHighFiveSection", RFWLog.DEV, "[buildAnimZipUrl] rightResUrl = " + str + " leftResUrl = " + cellHighFiveInfo.leftHighFiveResUrl);
        if (TextUtils.isEmpty(cellHighFiveInfo.easterEggResUrl)) {
            return new String[]{cellHighFiveInfo.rightHighFiveResUrl, cellHighFiveInfo.leftHighFiveResUrl};
        }
        return new String[]{cellHighFiveInfo.rightHighFiveResUrl, cellHighFiveInfo.leftHighFiveResUrl, cellHighFiveInfo.easterEggResUrl};
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void N() {
        Object obj = ((CommonNoticeBean) this.mData).getNotice().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
        if (!(obj instanceof BusinessFeedData)) {
            obj = null;
        }
        BusinessFeedData businessFeedData = (BusinessFeedData) obj;
        if (businessFeedData != null && !com.qzone.reborn.message.data.f.f58260a.u(businessFeedData)) {
            if (this.highFiveIoc == null) {
                this.highFiveIoc = (dl.c) q(dl.c.class);
            }
            dl.c cVar = this.highFiveIoc;
            if (cVar != null) {
                cVar.p7(businessFeedData, this.mPosition);
            }
            this.isHighFiveCountAnimPlaying = true;
            R(businessFeedData);
            return;
        }
        RFWLog.e("QZonePassiveMessageHighFiveSection", RFWLog.USR, "[handleHighFiveClick] feed data cannot high five");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(ah this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Q() {
        TextView textView = this.highFiveText;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveText");
            textView = null;
        }
        textView.setTranslationY(0.0f);
        TextView textView3 = this.highFiveSecondText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveSecondText");
            textView3 = null;
        }
        textView3.setTranslationY(0.0f);
        TextView textView4 = this.highFiveText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveText");
            textView4 = null;
        }
        textView4.setAlpha(1.0f);
        TextView textView5 = this.highFiveSecondText;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveSecondText");
        } else {
            textView2 = textView5;
        }
        textView2.setAlpha(0.0f);
    }

    private final void R(BusinessFeedData feedData) {
        MultiAnimationLayout multiAnimationLayout = new MultiAnimationLayout(p());
        this.highFiveAnimView = multiAnimationLayout;
        FrameLayout frameLayout = this.itemContainer;
        if (frameLayout == null) {
            RFWLog.e("QZonePassiveMessageHighFiveSection", RFWLog.USR, "[startHighFiveAnimation] content layout = null, stop playing animation");
            return;
        }
        if (feedData.cellHighFiveInfo == null) {
            S(feedData);
            RFWLog.e("QZonePassiveMessageHighFiveSection", RFWLog.USR, "[startHighFiveAnimation] data = null, no zipUrl");
            return;
        }
        int i3 = this.HIGH_FIVE_ANIM_SIZE;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 8388611;
        int[] iArr = new int[2];
        View view = this.highFiveRoot;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveRoot");
            view = null;
        }
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        frameLayout.getLocationOnScreen(iArr2);
        int i16 = iArr[0] - iArr2[0];
        int i17 = iArr[1] - iArr2[1];
        int i18 = this.HIGH_FIVE_ANIM_SIZE;
        View view3 = this.highFiveRoot;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveRoot");
            view3 = null;
        }
        layoutParams.leftMargin = i16 - ((int) ((i18 - view3.getWidth()) / 2.0f));
        int i19 = this.HIGH_FIVE_ANIM_SIZE;
        View view4 = this.highFiveRoot;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveRoot");
        } else {
            view2 = view4;
        }
        layoutParams.topMargin = i17 - ((int) ((i19 - view2.getHeight()) / 2.0f));
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(multiAnimationLayout, layoutParams);
        String[] L = L(feedData);
        multiAnimationLayout.setZipAnimation(new MultiAnimationLayout.a((String[]) Arrays.copyOf(L, L.length)).g(30).h(false).i(false).j(new b(frameLayout, multiAnimationLayout, this, feedData)));
    }

    private final void T(BusinessFeedData feedData, long highFiveCount) {
        com.qzone.reborn.message.data.f fVar = com.qzone.reborn.message.data.f.f58260a;
        TextView textView = null;
        if (fVar.u(feedData)) {
            TextView textView2 = this.highFiveText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveText");
                textView2 = null;
            }
            textView2.setVisibility(highFiveCount != 0 ? 0 : 8);
            TextView textView3 = this.highFiveSecondText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveSecondText");
                textView3 = null;
            }
            textView3.setVisibility(0);
            TextView textView4 = this.highFiveBeforeText;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveBeforeText");
            } else {
                textView = textView4;
            }
            textView.setVisibility(8);
            return;
        }
        if (fVar.x(feedData) && highFiveCount >= 1) {
            TextView textView5 = this.highFiveText;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveText");
                textView5 = null;
            }
            textView5.setVisibility(8);
            TextView textView6 = this.highFiveSecondText;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveSecondText");
                textView6 = null;
            }
            textView6.setVisibility(8);
            TextView textView7 = this.highFiveBeforeText;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveBeforeText");
            } else {
                textView = textView7;
            }
            textView.setVisibility(0);
            return;
        }
        TextView textView8 = this.highFiveText;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveText");
            textView8 = null;
        }
        textView8.setVisibility(8);
        TextView textView9 = this.highFiveSecondText;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveSecondText");
            textView9 = null;
        }
        textView9.setVisibility(8);
        TextView textView10 = this.highFiveBeforeText;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveBeforeText");
        } else {
            textView = textView10;
        }
        textView.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        super.onAttachedChanged(attached);
        if (attached || !this.isHighFiveCountAnimPlaying) {
            return;
        }
        FrameLayout frameLayout = this.itemContainer;
        if (frameLayout != null) {
            frameLayout.removeView(this.highFiveAnimView);
        }
        MultiAnimationLayout multiAnimationLayout = this.highFiveAnimView;
        if (multiAnimationLayout != null) {
            multiAnimationLayout.d();
        }
        this.isHighFiveCountAnimPlaying = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n8h);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ne_notice_high_five_root)");
        this.highFiveRoot = findViewById;
        View findViewById2 = containerView.findViewById(R.id.n8e);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026one_notice_high_five_btn)");
        this.highFiveButton = findViewById2;
        View findViewById3 = containerView.findViewById(R.id.n8f);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026otice_high_five_btn_icon)");
        this.highFiveButtonImage = (ImageView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.n8j);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026ne_notice_high_five_text)");
        this.highFiveText = (TextView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.n8i);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026ce_high_five_second_text)");
        this.highFiveSecondText = (TextView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.n8d);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026ce_high_five_before_text)");
        this.highFiveBeforeText = (TextView) findViewById6;
        View rootView = getRootView();
        this.itemContainer = rootView != null ? (FrameLayout) rootView.findViewById(R.id.n8k) : null;
        this.containerBgDrawable = ResourcesCompat.getDrawable(p().getResources(), R.drawable.f16205q, null);
        int color = p().getResources().getColor(R.color.qui_common_icon_secondary, null);
        this.highFiveIcon = com.tencent.mobileqq.qzone.picload.c.a().l(ResourcesCompat.getDrawable(p().getResources(), R.drawable.qui_highfive_testing, null), color);
        this.highFivePressedIcon = com.tencent.mobileqq.qzone.picload.c.a().l(ResourcesCompat.getDrawable(p().getResources(), R.drawable.qui_highfive_pressed_testing, null), color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    private final Pair<Long, String> M(BusinessFeedData businessFeedData, boolean z16) {
        String str;
        CellHighFiveInfo cellHighFiveInfo;
        long j3 = (businessFeedData == null || (cellHighFiveInfo = businessFeedData.cellHighFiveInfo) == null) ? 0L : cellHighFiveInfo.highFiveCount;
        if (z16) {
            j3++;
        }
        if (j3 <= 99) {
            str = p().getResources().getString(R.string.w_v, Long.valueOf(j3));
        } else {
            str = "x99+";
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (highFiveCount <= HIG\u2026_THRESHOLD_TEXT\n        }");
        return new Pair<>(Long.valueOf(j3), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonNoticeBean data, int position, List<Object> payload) {
        if (data != null) {
            Object obj = data.getNotice().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
            View view = null;
            if (!(obj instanceof BusinessFeedData)) {
                obj = null;
            }
            BusinessFeedData businessFeedData = (BusinessFeedData) obj;
            this.feedData = businessFeedData;
            J(businessFeedData);
            K(this.feedData);
            U(this.feedData);
            View view2 = this.highFiveRoot;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveRoot");
            } else {
                view = view2;
            }
            w(view, "em_qz_clap");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(BusinessFeedData feedData) {
        TextView textView;
        if (!com.qzone.reborn.message.data.f.f58260a.B(feedData)) {
            if (!(feedData != null && feedData.isFakeHighFive)) {
                this.isHighFiveCountAnimPlaying = false;
                RFWLog.e("QZonePassiveMessageHighFiveSection", RFWLog.USR, "[startHighFiveCountAnimation] feedData cannot support multiple high five");
                return;
            }
        }
        Pair<Long, String> M = M(feedData, true);
        M.component1().longValue();
        String component2 = M.component2();
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] animatorArr = new Animator[2];
        TextView textView2 = this.highFiveText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveText");
            textView2 = null;
        }
        animatorArr[0] = ObjectAnimator.ofFloat(textView2, "translationY", 0.0f, -this.HIGH_FIVE_COUNT_ANIM_TRANSLATION);
        TextView textView3 = this.highFiveText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveText");
            textView3 = null;
        }
        animatorArr[1] = ObjectAnimator.ofFloat(textView3, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        animatorSet.playTogether(animatorArr);
        animatorSet.addListener(new c(component2));
        animatorSet.setDuration(480L);
        animatorSet.setStartDelay(100L);
        animatorSet.start();
        TextView textView4 = this.highFiveSecondText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveSecondText");
            textView4 = null;
        }
        textView4.setText(component2);
        AnimatorSet animatorSet2 = new AnimatorSet();
        Animator[] animatorArr2 = new Animator[2];
        TextView textView5 = this.highFiveSecondText;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveSecondText");
            textView5 = null;
        }
        animatorArr2[0] = ObjectAnimator.ofFloat(textView5, "translationY", 0.0f, -this.HIGH_FIVE_COUNT_ANIM_TRANSLATION);
        TextView textView6 = this.highFiveSecondText;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveSecondText");
            textView = null;
        } else {
            textView = textView6;
        }
        animatorArr2[1] = ObjectAnimator.ofFloat(textView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        animatorSet2.playTogether(animatorArr2);
        animatorSet2.setDuration(480L);
        animatorSet2.setStartDelay(100L);
        animatorSet2.start();
    }

    private final void U(BusinessFeedData feedData) {
        CellLocalInfo localInfoV2;
        View view = null;
        if (!((feedData == null || (localInfoV2 = feedData.getLocalInfoV2()) == null || !localInfoV2.isFake()) ? false : true)) {
            com.qzone.reborn.message.data.f fVar = com.qzone.reborn.message.data.f.f58260a;
            if (fVar.c(feedData) && !fVar.u(feedData)) {
                View view2 = this.highFiveRoot;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("highFiveRoot");
                } else {
                    view = view2;
                }
                view.setOnClickListener(this.onHighFiveClicked);
                return;
            }
        }
        RFWLog.e("QZonePassiveMessageHighFiveSection", RFWLog.USR, "[updateListener] feed data cannot high five");
        View view3 = this.highFiveRoot;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveRoot");
        } else {
            view = view3;
        }
        view.setClickable(false);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/message/section/ah$b", "Lcooperation/qzone/zipanimate/OnAnimationListener;", "", "onDrawableLoaded", "onAnimationFinished", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements OnAnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameLayout f58383d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MultiAnimationLayout f58384e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ah f58385f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f58386h;

        b(FrameLayout frameLayout, MultiAnimationLayout multiAnimationLayout, ah ahVar, BusinessFeedData businessFeedData) {
            this.f58383d = frameLayout;
            this.f58384e = multiAnimationLayout;
            this.f58385f = ahVar;
            this.f58386h = businessFeedData;
        }

        @Override // cooperation.qzone.zipanimate.OnAnimationListener
        public void onAnimationFinished() {
            RFWLog.i("QZonePassiveMessageHighFiveSection", RFWLog.CLR, "[OnAnimationListener.onAnimationFinished] MultiAnimationLayout anim finished.");
            this.f58383d.removeView(this.f58384e);
            this.f58384e.d();
            this.f58385f.S(this.f58386h);
        }

        @Override // cooperation.qzone.zipanimate.OnAnimationListener
        public void onDrawableLoaded() {
        }
    }
}
