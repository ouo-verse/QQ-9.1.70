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
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \n2\u00020\u0001:\u0001NB\u0007\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\r*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0014J*\u0010\"\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0014J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000bH\u0016R\u0014\u0010'\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u0005R\u0016\u0010-\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u00108\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u00104R\u0018\u0010;\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010DR\u0016\u0010H\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010GR\u0016\u0010K\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006O"}, d2 = {"Lcom/qzone/reborn/message/section/n;", "Lcom/qzone/reborn/message/section/QZOldStylePassiveMsgBaseSection;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", UserInfo.SEX_FEMALE, "G", "", "highFiveCount", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "N", "", "needPlusOne", "Lkotlin/Pair;", "", "J", BdhLogUtil.LogTag.Tag_Req, "K", "O", "", "H", "(Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;)[Ljava/lang/String;", "P", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "L", "attached", "onAttachedChanged", tl.h.F, "I", "HIGH_FIVE_ANIM_SIZE", "", "i", "HIGH_FIVE_COUNT_ANIM_TRANSLATION", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "highFiveRoot", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "highFiveButtonImage", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "highFiveText", "E", "highFiveSecondText", "highFiveBeforeText", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "itemContainer", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "highFiveIcon", "highFivePressedIcon", "Lcom/qzone/widget/MultiAnimationLayout;", "Lcom/qzone/widget/MultiAnimationLayout;", "highFiveAnimView", "Ldl/c;", "Ldl/c;", "highFiveIoc", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "onHighFiveClicked", "M", "Z", "isHighFiveCountAnimPlaying", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class n extends QZOldStylePassiveMsgBaseSection {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView highFiveButtonImage;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView highFiveText;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView highFiveSecondText;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView highFiveBeforeText;

    /* renamed from: G, reason: from kotlin metadata */
    private FrameLayout itemContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private Drawable highFiveIcon;

    /* renamed from: I, reason: from kotlin metadata */
    private Drawable highFivePressedIcon;

    /* renamed from: J, reason: from kotlin metadata */
    private MultiAnimationLayout highFiveAnimView;

    /* renamed from: K, reason: from kotlin metadata */
    private dl.c highFiveIoc;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isHighFiveCountAnimPlaying;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View highFiveRoot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int HIGH_FIVE_ANIM_SIZE = ef.d.b(75);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final float HIGH_FIVE_COUNT_ANIM_TRANSLATION = ef.d.a(Float.valueOf(12.0f));

    /* renamed from: L, reason: from kotlin metadata */
    private View.OnClickListener onHighFiveClicked = new View.OnClickListener() { // from class: com.qzone.reborn.message.section.m
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            n.M(n.this, view);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/message/section/n$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f58436e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f58437f;

        c(long j3, String str) {
            this.f58436e = j3;
            this.f58437f = str;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            String str;
            n.this.isHighFiveCountAnimPlaying = false;
            TextView textView = n.this.highFiveText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveText");
                textView = null;
            }
            if (this.f58436e > 1) {
                str = this.f58437f;
            } else {
                str = "";
            }
            textView.setText(str);
        }
    }

    private final void F(BusinessFeedData feedData) {
        View view = this.highFiveRoot;
        ImageView imageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveRoot");
            view = null;
        }
        com.qzone.reborn.message.data.f fVar = com.qzone.reborn.message.data.f.f58260a;
        view.setVisibility(fVar.c(feedData) ? 0 : 8);
        if (fVar.u(feedData)) {
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
            ImageView imageView3 = this.highFiveButtonImage;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveButtonImage");
            } else {
                imageView = imageView3;
            }
            imageView.setImageDrawable(this.highFiveIcon);
        }
    }

    private final void G(BusinessFeedData feedData) {
        Pair<Long, String> J = J(feedData, com.qzone.reborn.message.data.f.f58260a.u(feedData) && !this.isHighFiveCountAnimPlaying);
        long longValue = J.component1().longValue();
        String component2 = J.component2();
        Q(feedData, longValue);
        N();
        if (longValue <= 1) {
            component2 = "";
        }
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

    private final String[] H(BusinessFeedData feedData) {
        String j3;
        CellHighFiveInfo cellHighFiveInfo = feedData.cellHighFiveInfo;
        CustomHighFiveData e16 = com.qzone.personalize.business.b.n().e(LoginData.getInstance().getUin());
        if (e16 != null && !TextUtils.isEmpty(e16.strHighFiveResUrl)) {
            j3 = e16.strHighFiveResUrl;
        } else {
            j3 = com.qzone.personalize.business.b.n().j();
        }
        cellHighFiveInfo.rightHighFiveResUrl = j3;
        RFWLog.i("QZOldStylePassiveMsgHighFiveSection", RFWLog.DEV, "[buildAnimZipUrl] rightResUrl = " + j3 + " leftResUrl = " + cellHighFiveInfo.leftHighFiveResUrl);
        if (TextUtils.isEmpty(cellHighFiveInfo.easterEggResUrl)) {
            return new String[]{cellHighFiveInfo.rightHighFiveResUrl, cellHighFiveInfo.leftHighFiveResUrl};
        }
        return new String[]{cellHighFiveInfo.rightHighFiveResUrl, cellHighFiveInfo.leftHighFiveResUrl, cellHighFiveInfo.easterEggResUrl};
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K() {
        BusinessFeedData businessFeedData = (BusinessFeedData) this.mData;
        if (businessFeedData != null && !com.qzone.reborn.message.data.f.f58260a.u(businessFeedData)) {
            if (this.highFiveIoc == null) {
                this.highFiveIoc = (dl.c) q(dl.c.class);
            }
            dl.c cVar = this.highFiveIoc;
            if (cVar != null) {
                cVar.p7(businessFeedData, this.mPosition);
            }
            this.isHighFiveCountAnimPlaying = true;
            O(businessFeedData);
            return;
        }
        RFWLog.e("QZOldStylePassiveMsgHighFiveSection", RFWLog.USR, "[handleHighFiveClick] feed data cannot high five");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(n this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void N() {
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

    private final void O(BusinessFeedData feedData) {
        int coerceAtLeast;
        MultiAnimationLayout multiAnimationLayout = new MultiAnimationLayout(p());
        this.highFiveAnimView = multiAnimationLayout;
        FrameLayout frameLayout = this.itemContainer;
        if (frameLayout == null) {
            RFWLog.e("QZOldStylePassiveMsgHighFiveSection", RFWLog.USR, "[startHighFiveAnimation] content layout = null, stop playing animation");
            return;
        }
        if (feedData.cellHighFiveInfo == null) {
            P(feedData);
            RFWLog.e("QZOldStylePassiveMsgHighFiveSection", RFWLog.USR, "[startHighFiveAnimation] data = null, no zipUrl");
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
        int height = i17 - ((int) ((i19 - view2.getHeight()) / 2.0f));
        layoutParams.topMargin = height;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(height, 0);
        layoutParams.topMargin = coerceAtLeast;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(multiAnimationLayout, layoutParams);
        String[] H = H(feedData);
        multiAnimationLayout.setZipAnimation(new MultiAnimationLayout.a((String[]) Arrays.copyOf(H, H.length)).g(30).h(false).i(false).j(new b(frameLayout, multiAnimationLayout, this, feedData)));
    }

    private final void Q(BusinessFeedData feedData, long highFiveCount) {
        com.qzone.reborn.message.data.f fVar = com.qzone.reborn.message.data.f.f58260a;
        TextView textView = null;
        if (fVar.u(feedData)) {
            TextView textView2 = this.highFiveText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveText");
                textView2 = null;
            }
            textView2.setVisibility(0);
            TextView textView3 = this.highFiveSecondText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveSecondText");
                textView3 = null;
            }
            textView3.setVisibility(0);
            TextView textView4 = this.highFiveBeforeText;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveBeforeText");
                textView4 = null;
            }
            textView4.setVisibility(8);
            int color = this.isHighFiveCountAnimPlaying ? ResourcesCompat.getColor(p().getResources(), R.color.qui_common_text_secondary, null) : -13056;
            TextView textView5 = this.highFiveText;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveText");
                textView5 = null;
            }
            textView5.setTextColor(color);
            TextView textView6 = this.highFiveSecondText;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveSecondText");
            } else {
                textView = textView6;
            }
            textView.setTextColor(-13056);
            return;
        }
        if (fVar.x(feedData) && highFiveCount > 1) {
            TextView textView7 = this.highFiveText;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveText");
                textView7 = null;
            }
            textView7.setVisibility(8);
            TextView textView8 = this.highFiveSecondText;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveSecondText");
                textView8 = null;
            }
            textView8.setVisibility(8);
            TextView textView9 = this.highFiveBeforeText;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("highFiveBeforeText");
            } else {
                textView = textView9;
            }
            textView.setVisibility(0);
            return;
        }
        TextView textView10 = this.highFiveText;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveText");
            textView10 = null;
        }
        textView10.setVisibility(8);
        TextView textView11 = this.highFiveSecondText;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveSecondText");
            textView11 = null;
        }
        textView11.setVisibility(8);
        TextView textView12 = this.highFiveBeforeText;
        if (textView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveBeforeText");
        } else {
            textView = textView12;
        }
        textView.setVisibility(8);
    }

    private final void R(BusinessFeedData feedData) {
        CellLocalInfo localInfoV2 = feedData.getLocalInfoV2();
        View view = null;
        if (!(localInfoV2 != null && localInfoV2.isFake())) {
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
        RFWLog.e("QZOldStylePassiveMsgHighFiveSection", RFWLog.USR, "[updateListener] feed data cannot high five");
        View view3 = this.highFiveRoot;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveRoot");
        } else {
            view = view3;
        }
        view.setClickable(false);
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
        View findViewById2 = containerView.findViewById(R.id.n8f);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026otice_high_five_btn_icon)");
        this.highFiveButtonImage = (ImageView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.n8j);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026ne_notice_high_five_text)");
        this.highFiveText = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.n8i);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026ce_high_five_second_text)");
        this.highFiveSecondText = (TextView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.n8d);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026ce_high_five_before_text)");
        this.highFiveBeforeText = (TextView) findViewById5;
        this.itemContainer = (FrameLayout) containerView.findViewById(R.id.n7c);
        this.highFiveIcon = ResourcesCompat.getDrawable(p().getResources(), R.drawable.qzone_skin_feed_high5_icon_normal, null);
        this.highFivePressedIcon = ResourcesCompat.getDrawable(p().getResources(), R.drawable.qzone_skin_feed_high5_icon_clicked, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nog};
    }

    private final Pair<Long, String> J(BusinessFeedData businessFeedData, boolean z16) {
        String str;
        CellHighFiveInfo cellHighFiveInfo;
        long j3 = (businessFeedData == null || (cellHighFiveInfo = businessFeedData.cellHighFiveInfo) == null) ? 0L : cellHighFiveInfo.highFiveCount;
        if (z16) {
            j3++;
        }
        if (j3 <= 999) {
            str = p().getResources().getString(R.string.w_v, Long.valueOf(j3));
        } else {
            str = "x999+";
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (highFiveCount <= HIG\u2026_THRESHOLD_TEXT\n        }");
        return new Pair<>(Long.valueOf(j3), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void onBindData(BusinessFeedData data, int position, List<Object> payload) {
        if (data != null) {
            F(data);
            G(data);
            R(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(BusinessFeedData feedData) {
        if (!com.qzone.reborn.message.data.f.f58260a.B(feedData) && !feedData.isFakeHighFive) {
            this.isHighFiveCountAnimPlaying = false;
            RFWLog.e("QZOldStylePassiveMsgHighFiveSection", RFWLog.USR, "[startHighFiveCountAnimation] feedData cannot support multiple high five");
            return;
        }
        Pair<Long, String> J = J(feedData, true);
        long longValue = J.component1().longValue();
        String component2 = J.component2();
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] animatorArr = new Animator[2];
        TextView textView = this.highFiveText;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveText");
            textView = null;
        }
        animatorArr[0] = ObjectAnimator.ofFloat(textView, "translationY", 0.0f, -this.HIGH_FIVE_COUNT_ANIM_TRANSLATION);
        TextView textView3 = this.highFiveText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveText");
            textView3 = null;
        }
        animatorArr[1] = ObjectAnimator.ofFloat(textView3, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        animatorSet.playTogether(animatorArr);
        animatorSet.addListener(new c(longValue, component2));
        animatorSet.setDuration(480L);
        animatorSet.setStartDelay(100L);
        animatorSet.start();
        TextView textView4 = this.highFiveSecondText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highFiveSecondText");
            textView4 = null;
        }
        if (longValue <= 1) {
            component2 = "";
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
        } else {
            textView2 = textView6;
        }
        animatorArr2[1] = ObjectAnimator.ofFloat(textView2, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        animatorSet2.playTogether(animatorArr2);
        animatorSet2.setDuration(480L);
        animatorSet2.setStartDelay(100L);
        animatorSet2.start();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/message/section/n$b", "Lcooperation/qzone/zipanimate/OnAnimationListener;", "", "onDrawableLoaded", "onAnimationFinished", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements OnAnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameLayout f58431d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MultiAnimationLayout f58432e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ n f58433f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f58434h;

        b(FrameLayout frameLayout, MultiAnimationLayout multiAnimationLayout, n nVar, BusinessFeedData businessFeedData) {
            this.f58431d = frameLayout;
            this.f58432e = multiAnimationLayout;
            this.f58433f = nVar;
            this.f58434h = businessFeedData;
        }

        @Override // cooperation.qzone.zipanimate.OnAnimationListener
        public void onAnimationFinished() {
            RFWLog.i("QZOldStylePassiveMsgHighFiveSection", RFWLog.CLR, "[OnAnimationListener.onAnimationFinished] MultiAnimationLayout anim finished.");
            this.f58431d.removeView(this.f58432e);
            this.f58432e.d();
            this.f58433f.P(this.f58434h);
        }

        @Override // cooperation.qzone.zipanimate.OnAnimationListener
        public void onDrawableLoaded() {
        }
    }
}
