package com.tencent.timi.game.expand.hall.impl.view;

import ag4.i;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.be;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleInfo;
import trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;
import yn4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u00018B;\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u0012\b\b\u0002\u00103\u001a\u00020\u0014\u0012\b\b\u0002\u00104\u001a\u00020\u0014\u0012\b\b\u0002\u00105\u001a\u00020#\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002R\u001c\u0010\u001c\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u0019R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010-\u00a8\u00069"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallInfoView;", "Landroid/widget/FrameLayout;", "", "w", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/app/QBaseActivity;", "owner", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "defaultAccount", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "E", "r", "u", "Ltrpc/yes/wuji/WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;", "data", "v", "Landroid/view/View$OnClickListener;", "listener", "setSmobaAuthClickListener", "", "p", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "I", "getMState$annotations", "()V", "mState", "e", "Landroid/view/View$OnClickListener;", "mSmobaAuthClickListener", "f", "Ltrpc/yes/wuji/WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;", "mHallInfo", "Lgh4/d;", tl.h.F, "Lgh4/d;", "mReportHelper", "i", "mYesGameId", "Landroid/graphics/drawable/ColorDrawable;", "Landroid/graphics/drawable/ColorDrawable;", "colorDrawable", "Lnr2/be;", "Lnr2/be;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "yesGameId", "reporterHelper", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILgh4/d;)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ExpandHallInfoView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final be binding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener mSmobaAuthClickListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf mHallInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final gh4.d mReportHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int mYesGameId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ColorDrawable colorDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/expand/hall/impl/view/ExpandHallInfoView$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            ExpandHallInfoView.this.u();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandHallInfoView(@NotNull Context context) {
        this(context, null, 0, 0, null, 30, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A(final QBaseActivity owner, final YesGameInfoOuterClass$GetUserGameDefaultRoleRsp defaultAccount) {
        String str;
        YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo;
        PBStringField pBStringField;
        this.binding.f421013k.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandHallInfoView.B(ExpandHallInfoView.this, owner, defaultAccount, view);
            }
        });
        com.tencent.timi.game.utils.l.i("ExpandHallInfoView_", "refreshAccountUI defaultAccount:" + defaultAccount);
        if (defaultAccount != null && (yesGameInfoOuterClass$YesGameRoleInfo = defaultAccount.role_info) != null && (pBStringField = yesGameInfoOuterClass$YesGameRoleInfo.role_name) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        com.tencent.timi.game.utils.l.i("ExpandHallInfoView_", "refreshAccountUI defaultAccount name:" + str);
        this.binding.f421013k.setVisibility(0);
        GameAuthOuterClass$GetGameAuthRsp value = ((ag4.i) mm4.b.b(ag4.i.class)).G0(this.mYesGameId).getValue();
        if (defaultAccount != null && value != null && value.is_auth.get() && defaultAccount.role_info.has()) {
            this.binding.f421014l.setVisibility(0);
            this.binding.f421015m.setText(defaultAccount.role_info.role_name.get());
        } else {
            this.binding.f421014l.setVisibility(0);
            this.binding.f421015m.setText("\u53bb\u7ed1\u5b9a");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ExpandHallInfoView this$0, QBaseActivity owner, YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(owner, "$owner");
        if (!hg4.c.f404865a.d(this$0.mYesGameId, true)) {
            GameAuthOuterClass$GetGameAuthRsp value = ((ag4.i) mm4.b.b(ag4.i.class)).G0(this$0.mYesGameId).getValue();
            if (value == null) {
                QQToast.makeText(this$0.getContext(), R.string.f23153724, 0).show();
                ((ag4.i) mm4.b.b(ag4.i.class)).I1(this$0.mYesGameId, null);
            } else if (!value.is_auth.get()) {
                ((ag4.i) mm4.b.b(ag4.i.class)).o3(this$0.mYesGameId, owner, value.auth_desc.get(), Boolean.TRUE, null, null);
            } else if (value.is_auth.get()) {
                if (yesGameInfoOuterClass$GetUserGameDefaultRoleRsp != null && cg4.b.a(yesGameInfoOuterClass$GetUserGameDefaultRoleRsp)) {
                    ((ag4.i) mm4.b.b(ag4.i.class)).A1(this$0.mYesGameId, owner, new d());
                } else {
                    wf4.a.f445618a.c(this$0.getContext());
                    ((ag4.i) mm4.b.b(ag4.i.class)).J1(this$0.mYesGameId, owner, new c());
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void C() {
        com.tencent.timi.game.utils.l.i("ExpandHallInfoView_", "refreshUI mHallInfo=" + this.mHallInfo);
        WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf = this.mHallInfo;
        if (wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf != null) {
            URLDrawable.URLDrawableOptions options = URLDrawable.URLDrawableOptions.obtain();
            ColorDrawable colorDrawable = this.colorDrawable;
            options.mLoadingDrawable = colorDrawable;
            options.mFailedDrawable = colorDrawable;
            String str = wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf.room_detail_background_img.get();
            com.tencent.timi.game.utils.l.i("ExpandHallInfoView_", "refreshUI coverBgUrl=" + str);
            RoundCornerImageView roundCornerImageView = this.binding.f421012j;
            Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "binding.headBgIgv");
            Intrinsics.checkNotNullExpressionValue(options, "options");
            com.tencent.timi.game.utils.b.g(roundCornerImageView, str, options);
            String str2 = wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf.room_cover.get();
            com.tencent.timi.game.utils.l.i("ExpandHallInfoView_", "refreshUI hallIconUrl=" + str2);
            RoundCornerImageView roundCornerImageView2 = this.binding.f421011i;
            Intrinsics.checkNotNullExpressionValue(roundCornerImageView2, "binding.hallIconIgv");
            com.tencent.timi.game.utils.b.g(roundCornerImageView2, str2, options);
            this.binding.f421009g.setText(wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf.introduce.get());
            this.binding.f421010h.setText(wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf.notice.get());
        }
    }

    private final void E() {
        requestLayout();
        setVisibility(0);
        post(new Runnable() { // from class: com.tencent.timi.game.expand.hall.impl.view.s
            @Override // java.lang.Runnable
            public final void run() {
                ExpandHallInfoView.F(ExpandHallInfoView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(final ExpandHallInfoView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final int height = this$0.binding.f421006d.getHeight();
        this$0.binding.f421006d.setTranslationY(height);
        this$0.binding.f421006d.setVisibility(0);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.expand.hall.impl.view.v
            @Override // java.lang.Runnable
            public final void run() {
                ExpandHallInfoView.G(ExpandHallInfoView.this, height);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(ExpandHallInfoView this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0.binding.f421006d, "translationY", i3, 0.0f);
        ofFloat.setInterpolator(b.f.f450693a);
        ofFloat.setDuration(500L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this$0.binding.f421016n, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.x
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ExpandHallInfoView.H(valueAnimator);
            }
        });
        ofFloat2.setInterpolator(b.f.f450693a);
        ofFloat2.setDuration(500L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat2);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(ValueAnimator valueAnimator) {
        com.tencent.timi.game.utils.l.i("ExpandHallInfoView_", "#showAnim #addUpdateListener " + valueAnimator.getAnimatedValue());
    }

    private final void m(final QBaseActivity owner) {
        LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> B2 = ((ag4.i) mm4.b.b(ag4.i.class)).B2(this.mYesGameId);
        if (B2 != null) {
            B2.observe(owner, new Observer() { // from class: com.tencent.timi.game.expand.hall.impl.view.t
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ExpandHallInfoView.n(ExpandHallInfoView.this, owner, (YesGameInfoOuterClass$GetUserGameDefaultRoleRsp) obj);
                }
            });
        }
        ((ag4.i) mm4.b.b(ag4.i.class)).G0(this.mYesGameId).observe(owner, new Observer() { // from class: com.tencent.timi.game.expand.hall.impl.view.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExpandHallInfoView.o(ExpandHallInfoView.this, owner, (GameAuthOuterClass$GetGameAuthRsp) obj);
            }
        });
        YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp = null;
        ((ag4.i) mm4.b.b(ag4.i.class)).m2(this.mYesGameId, null);
        if (B2 != null) {
            yesGameInfoOuterClass$GetUserGameDefaultRoleRsp = B2.getValue();
        }
        A(owner, yesGameInfoOuterClass$GetUserGameDefaultRoleRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ExpandHallInfoView this$0, QBaseActivity owner, YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(owner, "$owner");
        this$0.A(owner, yesGameInfoOuterClass$GetUserGameDefaultRoleRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ExpandHallInfoView this$0, QBaseActivity owner, GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp) {
        YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(owner, "$owner");
        LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> B2 = ((ag4.i) mm4.b.b(ag4.i.class)).B2(this$0.mYesGameId);
        if (B2 != null) {
            yesGameInfoOuterClass$GetUserGameDefaultRoleRsp = B2.getValue();
        } else {
            yesGameInfoOuterClass$GetUserGameDefaultRoleRsp = null;
        }
        this$0.A(owner, yesGameInfoOuterClass$GetUserGameDefaultRoleRsp);
    }

    private final void r() {
        post(new Runnable() { // from class: com.tencent.timi.game.expand.hall.impl.view.r
            @Override // java.lang.Runnable
            public final void run() {
                ExpandHallInfoView.s(ExpandHallInfoView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(final ExpandHallInfoView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final int height = this$0.binding.f421006d.getHeight();
        this$0.binding.f421006d.setTranslationY(0.0f);
        this$0.binding.f421006d.setVisibility(0);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.expand.hall.impl.view.w
            @Override // java.lang.Runnable
            public final void run() {
                ExpandHallInfoView.t(ExpandHallInfoView.this, height);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ExpandHallInfoView this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0.binding.f421006d, "translationY", 0.0f, i3);
        ofFloat.setInterpolator(b.f.f450694b);
        ofFloat.setDuration(500L);
        ofFloat.addListener(new b());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this$0.binding.f421016n, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat2.setInterpolator(b.f.f450694b);
        ofFloat2.setDuration(500L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat2);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        setVisibility(8);
        this.mState = 2;
    }

    private final void w() {
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandHallInfoView.x(ExpandHallInfoView.this, view);
            }
        });
        this.binding.f421006d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandHallInfoView.y(view);
            }
        });
        gh4.d dVar = this.mReportHelper;
        LinearLayout linearLayout = this.binding.f421013k;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.roleNameLl");
        dVar.a(linearLayout, this.mReportHelper.e());
        gh4.d dVar2 = this.mReportHelper;
        LinearLayout linearLayout2 = this.binding.f421004b;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.authHintLl");
        dVar2.a(linearLayout2, this.mReportHelper.d());
        this.binding.f421004b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandHallInfoView.z(ExpandHallInfoView.this, view);
            }
        });
        RoundCornerImageView roundCornerImageView = this.binding.f421012j;
        Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "binding.headBgIgv");
        RoundCornerImageView.setRadius$default(roundCornerImageView, com.tencent.timi.game.utils.b.a(15), com.tencent.timi.game.utils.b.a(15), 0.0f, 0.0f, 12, null);
        this.binding.f421011i.setRadius(com.tencent.timi.game.utils.b.c(18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(ExpandHallInfoView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.timi.game.utils.l.i("ExpandHallInfoView_", "contentRoot clicked!");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ExpandHallInfoView this$0, View view) {
        View.OnClickListener onClickListener;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.utils.o.c("authHintLl") && (onClickListener = this$0.mSmobaAuthClickListener) != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void D() {
        if (this.mState == 1) {
            return;
        }
        this.mState = 1;
        E();
    }

    /* renamed from: p, reason: from getter */
    public final int getMState() {
        return this.mState;
    }

    public final void q() {
        if (this.mState == 2) {
            return;
        }
        this.mState = 2;
        r();
    }

    public final void setSmobaAuthClickListener(@Nullable View.OnClickListener listener) {
        this.mSmobaAuthClickListener = listener;
    }

    public final void v(@NotNull QBaseActivity owner, @Nullable WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf data) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.mHallInfo = data;
        m(owner);
        C();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandHallInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, null, 28, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandHallInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, null, 24, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ExpandHallInfoView(Context context, AttributeSet attributeSet, int i3, int i16, gh4.d dVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16, (i17 & 16) != 0 ? new gh4.d(new ExpandHallLaunchParam()) : dVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandHallInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16, @NotNull gh4.d reporterHelper) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporterHelper, "reporterHelper");
        this.mState = 2;
        this.mReportHelper = reporterHelper;
        this.mYesGameId = i16;
        this.colorDrawable = new ColorDrawable(16052712);
        be f16 = be.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        ((hn4.a) mm4.b.b(hn4.a.class)).H1(this);
        setBackgroundResource(R.color.ajr);
        w();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/timi/game/expand/hall/impl/view/ExpandHallInfoView$c", "Lag4/i$d;", "", "b", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "selectedDefaultAccount", "a", "", "errorCode", "", "errorMsg", "e", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements i.d {
        c() {
        }

        @Override // ag4.i.d
        public void a(@NotNull YesGameInfoOuterClass$GetUserGameDefaultRoleRsp selectedDefaultAccount) {
            Intrinsics.checkNotNullParameter(selectedDefaultAccount, "selectedDefaultAccount");
        }

        @Override // ag4.i.c
        public void c() {
            wf4.a.f445618a.a(ExpandHallInfoView.this.getContext());
        }

        @Override // ag4.i.d
        public void e(int errorCode, @Nullable String errorMsg) {
            wf4.a.f445618a.a(ExpandHallInfoView.this.getContext());
        }

        @Override // ag4.i.d
        public void b() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/timi/game/expand/hall/impl/view/ExpandHallInfoView$d", "Lag4/i$d;", "", "b", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "selectedDefaultAccount", "a", "", "errorCode", "", "errorMsg", "e", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements i.d {
        d() {
        }

        @Override // ag4.i.d
        public void a(@NotNull YesGameInfoOuterClass$GetUserGameDefaultRoleRsp selectedDefaultAccount) {
            Intrinsics.checkNotNullParameter(selectedDefaultAccount, "selectedDefaultAccount");
        }

        @Override // ag4.i.d
        public void b() {
        }

        @Override // ag4.i.c
        public void c() {
        }

        @Override // ag4.i.d
        public void e(int errorCode, @Nullable String errorMsg) {
        }
    }
}
