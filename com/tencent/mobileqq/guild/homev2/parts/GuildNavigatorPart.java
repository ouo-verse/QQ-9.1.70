package com.tencent.mobileqq.guild.homev2.parts;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.channellist.GuildTextChannelListFragment;
import com.tencent.mobileqq.guild.config.QQGuildMCParser;
import com.tencent.mobileqq.guild.home.navigator.GuildNavigatorAdapter;
import com.tencent.mobileqq.guild.home.navigator.NavigatorData;
import com.tencent.mobileqq.guild.home.schedule.list.GuildHomeScheduleListFragment;
import com.tencent.mobileqq.guild.homev2.live.GuildAVListFragment;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bu;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0002R\u0016\u0010\"\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010.\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010!R\u0016\u00100\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010!R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010:R\u0014\u0010=\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010:\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/GuildNavigatorPart;", "Lcom/tencent/mobileqq/guild/homev2/parts/a;", "Lcom/tencent/mobileqq/guild/theme/d;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "onThemeChanged", "W9", "initData", "", "Lcom/tencent/mobileqq/guild/home/navigator/d;", "navigatorList", "ba", "Z9", "", "isExpand", "ca", "aa", "needExpand", "Q9", "Landroid/animation/ValueAnimator;", "R9", "T9", "data", "V9", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "Y9", "e", "Landroid/view/View;", "navigatorLayout", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "oneRowContainer", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", "foldRecyclerView", "i", "expandRecyclerView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "foldMaskView", BdhLogUtil.LogTag.Tag_Conn, "expandIcon", "", "D", UserInfo.SEX_FEMALE, "expandListHeight", "Lcom/tencent/mobileqq/guild/home/navigator/c;", "E", "Lcom/tencent/mobileqq/guild/home/navigator/c;", "eventHandler", "Lcom/tencent/mobileqq/guild/home/navigator/GuildNavigatorAdapter;", "Lcom/tencent/mobileqq/guild/home/navigator/GuildNavigatorAdapter;", "foldListAdapter", "G", "expandListAdapter", "<init>", "()V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildNavigatorPart extends a implements com.tencent.mobileqq.guild.theme.d {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int I = QQGuildUIUtil.f(8.0f);
    private static final int J = QQGuildUIUtil.f(12.0f);
    private static final int K = QQGuildUIUtil.f(22.0f);
    private static final float L = QQGuildUIUtil.f(32.0f);

    @NotNull
    private static final GuildDebugUtils.b<Integer> M = GuildDebugUtils.f235333a.g("Guild.NewHome.GuildNavigatorPart", "navigatorLayoutHeight");

    /* renamed from: C, reason: from kotlin metadata */
    private View expandIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private float expandListHeight;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.home.navigator.c eventHandler;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final GuildNavigatorAdapter foldListAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final GuildNavigatorAdapter expandListAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View navigatorLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout oneRowContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerView foldRecyclerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RecyclerView expandRecyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View foldMaskView;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/GuildNavigatorPart$a;", "", "", "c", "", "ITEM_SPACE", "I", "b", "()I", "", "FOLD_LIST_HEIGHT", UserInfo.SEX_FEMALE, "a", "()F", "CHECK_IN_NAVIGATOR_URL_PREFIX", "Ljava/lang/String;", "", "EXPAND_ANIMATOR_DURATION", "J", "EXPAND_ICON_ANIMATOR_DURATION", "NAVIGATOR_ONE_ROW_MAX_COUNT", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.homev2.parts.GuildNavigatorPart$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a() {
            return GuildNavigatorPart.L;
        }

        public final int b() {
            return GuildNavigatorPart.I;
        }

        @NotNull
        public final String c() {
            return QQGuildMCParser.INSTANCE.f("105813", "QQGProSignInWebUrl", "https://qun.qq.com/guild/h5/guild-member-sign/index.html#/ci");
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/homev2/parts/GuildNavigatorPart$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f225928e;

        b(boolean z16) {
            this.f225928e = z16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            GuildNavigatorPart.this.ca(this.f225928e);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/homev2/parts/GuildNavigatorPart$c", "Lcom/google/android/flexbox/FlexboxLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onLayoutCompleted", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends FlexboxLayoutManager {
        c(Context context) {
            super(context);
        }

        @Override // com.google.android.flexbox.FlexboxLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutCompleted(@Nullable RecyclerView.State state) {
            super.onLayoutCompleted(state);
            int size = M().size();
            GuildNavigatorPart.this.expandListHeight = (size * GuildNavigatorPart.INSTANCE.a()) + ((size - 1) * r2.b());
            Logger logger = Logger.f235387a;
            GuildNavigatorPart guildNavigatorPart = GuildNavigatorPart.this;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.GuildNavigatorPart", "onLayoutCompleted " + size + " " + guildNavigatorPart.expandListHeight);
            }
        }
    }

    public GuildNavigatorPart() {
        com.tencent.mobileqq.guild.home.navigator.c cVar = new com.tencent.mobileqq.guild.home.navigator.c(new GuildNavigatorPart$eventHandler$1(this), new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.homev2.parts.GuildNavigatorPart$eventHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildNavigatorPart.this.Q9(false);
            }
        });
        this.eventHandler = cVar;
        this.foldListAdapter = new GuildNavigatorAdapter(cVar);
        this.expandListAdapter = new GuildNavigatorAdapter(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(boolean needExpand) {
        RecyclerView recyclerView = this.foldRecyclerView;
        View view = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(0);
        RecyclerView recyclerView2 = this.expandRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandRecyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setVisibility(0);
        View view2 = this.foldMaskView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldMaskView");
            view2 = null;
        }
        view2.setVisibility(0);
        View view3 = this.expandIcon;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandIcon");
        } else {
            view = view3;
        }
        view.setVisibility(0);
        ValueAnimator R9 = R9(needExpand);
        ValueAnimator T9 = T9(needExpand);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(R9, T9);
        animatorSet.start();
    }

    private final ValueAnimator R9(final boolean needExpand) {
        ValueAnimator alphaChangeAnim = ValueAnimator.ofFloat(1.0f, 0.0f);
        alphaChangeAnim.setDuration(200L);
        alphaChangeAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.homev2.parts.l
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GuildNavigatorPart.S9(needExpand, this, valueAnimator);
            }
        });
        alphaChangeAnim.addListener(new b(needExpand));
        Intrinsics.checkNotNullExpressionValue(alphaChangeAnim, "alphaChangeAnim");
        return alphaChangeAnim;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(boolean z16, GuildNavigatorPart this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        RecyclerView recyclerView = null;
        if (z16) {
            RecyclerView recyclerView2 = this$0.foldRecyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("foldRecyclerView");
                recyclerView2 = null;
            }
            recyclerView2.setAlpha(floatValue);
            View view = this$0.expandIcon;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandIcon");
                view = null;
            }
            view.setAlpha(floatValue);
            View view2 = this$0.foldMaskView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("foldMaskView");
                view2 = null;
            }
            view2.setAlpha(floatValue);
            RecyclerView recyclerView3 = this$0.expandRecyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandRecyclerView");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.setAlpha(1 - floatValue);
            return;
        }
        RecyclerView recyclerView4 = this$0.foldRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldRecyclerView");
            recyclerView4 = null;
        }
        float f16 = 1 - floatValue;
        recyclerView4.setAlpha(f16);
        View view3 = this$0.expandIcon;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandIcon");
            view3 = null;
        }
        view3.setAlpha(f16);
        View view4 = this$0.foldMaskView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldMaskView");
            view4 = null;
        }
        view4.setAlpha(f16);
        RecyclerView recyclerView5 = this$0.expandRecyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandRecyclerView");
        } else {
            recyclerView = recyclerView5;
        }
        recyclerView.setAlpha(floatValue);
    }

    private final ValueAnimator T9(boolean needExpand) {
        ValueAnimator heightChangeAnim;
        if (needExpand) {
            heightChangeAnim = ValueAnimator.ofFloat(L, this.expandListHeight);
        } else {
            heightChangeAnim = ValueAnimator.ofFloat(this.expandListHeight, L);
        }
        heightChangeAnim.setDuration(200L);
        heightChangeAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.homev2.parts.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GuildNavigatorPart.U9(GuildNavigatorPart.this, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(heightChangeAnim, "heightChangeAnim");
        return heightChangeAnim;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(GuildNavigatorPart this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        View view = this$0.navigatorLayout;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigatorLayout");
            view = null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = ((int) floatValue) + K;
        View view3 = this$0.navigatorLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigatorLayout");
        } else {
            view2 = view3;
        }
        view2.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(NavigatorData data) {
        boolean isBlank;
        if (data.getCategoryType() == 11) {
            isBlank = StringsKt__StringsJVMKt.isBlank(data.getNavigationIconUrl());
            if (!isBlank) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ps1.a.a(context, data.getNavigationJumpType(), data.getNavigationJumpUrl());
                Logger.f235387a.d().d("Guild.NewHome.GuildNavigatorPart", 1, "handleNavigatorIconClick type:" + data.getNavigationJumpType() + " url:" + data.getNavigationJumpUrl());
                return;
            }
        }
        JumpGuildParam d16 = com.tencent.mobileqq.guild.base.extension.c.d(getHostFragment().getArguments());
        Logger.f235387a.d().d("Guild.NewHome.GuildNavigatorPart", 1, "handleNavigatorIconClick type:" + data.getCategoryType() + " " + d16);
        int categoryType = data.getCategoryType();
        if (categoryType != 2) {
            if (categoryType != 3) {
                if (categoryType != 7) {
                    if (categoryType != 9) {
                        if (categoryType == 10) {
                            Y9(d16);
                            return;
                        }
                        return;
                    }
                } else {
                    GuildHomeScheduleListFragment.Companion companion = GuildHomeScheduleListFragment.INSTANCE;
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    companion.a(context2, d16, String.valueOf(data.getCategoryId()));
                    return;
                }
            }
            GuildAVListFragment.Companion companion2 = GuildAVListFragment.INSTANCE;
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            companion2.a(context3, d16, String.valueOf(data.getCategoryId()), data.getCategoryType(), 0);
            return;
        }
        GuildTextChannelListFragment.Companion companion3 = GuildTextChannelListFragment.INSTANCE;
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        companion3.a(context4, d16);
    }

    private final void W9(View rootView) {
        View findViewById = rootView.findViewById(R.id.ws8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.guild_navigator_layout)");
        this.navigatorLayout = findViewById;
        GuildDebugUtils.b<Integer> bVar = M;
        RecyclerView recyclerView = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigatorLayout");
            findViewById = null;
        }
        bVar.e(Integer.valueOf(findViewById.getLayoutParams().height), "initView()");
        View findViewById2 = rootView.findViewById(R.id.zn7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.navigator_fold_mask)");
        this.foldMaskView = findViewById2;
        View findViewById3 = rootView.findViewById(R.id.zn9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026igator_one_row_container)");
        this.oneRowContainer = (LinearLayout) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f166385zn4);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.navigator_expand_icon)");
        this.expandIcon = findViewById4;
        View findViewById5 = rootView.findViewById(R.id.zn6);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.navigator_fold_list)");
        this.foldRecyclerView = (RecyclerView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.zn5);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.navigator_expand_list)");
        this.expandRecyclerView = (RecyclerView) findViewById6;
        RecyclerView recyclerView2 = this.foldRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldRecyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setAdapter(this.foldListAdapter);
        RecyclerView recyclerView3 = this.foldRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView recyclerView4 = this.expandRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandRecyclerView");
            recyclerView4 = null;
        }
        recyclerView4.setAdapter(this.expandListAdapter);
        RecyclerView recyclerView5 = this.expandRecyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandRecyclerView");
            recyclerView5 = null;
        }
        recyclerView5.setLayoutManager(new c(getContext()));
        int i3 = I;
        com.tencent.mobileqq.guild.widget.q qVar = new com.tencent.mobileqq.guild.widget.q(i3, 0);
        com.tencent.mobileqq.guild.widget.g gVar = new com.tencent.mobileqq.guild.widget.g(i3);
        RecyclerView recyclerView6 = this.foldRecyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldRecyclerView");
            recyclerView6 = null;
        }
        recyclerView6.addItemDecoration(qVar);
        RecyclerView recyclerView7 = this.expandRecyclerView;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandRecyclerView");
            recyclerView7 = null;
        }
        recyclerView7.addItemDecoration(gVar);
        View view = this.expandIcon;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandIcon");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.homev2.parts.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildNavigatorPart.X9(GuildNavigatorPart.this, view2);
            }
        });
        ca(false);
        RecyclerView recyclerView8 = this.foldRecyclerView;
        if (recyclerView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldRecyclerView");
        } else {
            recyclerView = recyclerView8;
        }
        bu.a(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(GuildNavigatorPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q9(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Y9(JumpGuildParam jumpGuildParam) {
        String n3 = ch.n(INSTANCE.c(), "guildId", jumpGuildParam.guildId);
        Intrinsics.checkNotNullExpressionValue(n3, "appendUri(checkInUrl, Jo\u2026, jumpGuildParam.guildId)");
        if (jumpGuildParam.getJoinInfoParam().isValid()) {
            String n16 = ch.n(n3, PreloadTRTCPlayerParams.KEY_SIG, jumpGuildParam.getJoinSignature());
            Intrinsics.checkNotNullExpressionValue(n16, "appendUri(\n             \u2026inSignature\n            )");
            String n17 = ch.n(n16, "mainSourceId", jumpGuildParam.getMainSource());
            Intrinsics.checkNotNullExpressionValue(n17, "appendUri(\n             \u2026.mainSource\n            )");
            n3 = ch.n(n17, "subSourceId", jumpGuildParam.getSubSource());
            Intrinsics.checkNotNullExpressionValue(n3, "appendUri(\n             \u2026m.subSource\n            )");
        }
        ch.i1(x9(), n3);
    }

    private final void Z9(List<NavigatorData> navigatorList) {
        RecyclerView recyclerView = this.foldRecyclerView;
        View view = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        RecyclerView recyclerView2 = this.expandRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandRecyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setVisibility(8);
        View view2 = this.expandIcon;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandIcon");
            view2 = null;
        }
        view2.setVisibility(8);
        View view3 = this.foldMaskView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldMaskView");
            view3 = null;
        }
        view3.setVisibility(8);
        LinearLayout linearLayout = this.oneRowContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oneRowContainer");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = this.oneRowContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oneRowContainer");
            linearLayout2 = null;
        }
        linearLayout2.removeAllViews();
        for (NavigatorData navigatorData : navigatorList) {
            LayoutInflater from = LayoutInflater.from(getContext());
            LinearLayout linearLayout3 = this.oneRowContainer;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("oneRowContainer");
                linearLayout3 = null;
            }
            View view4 = from.inflate(R.layout.etv, (ViewGroup) linearLayout3, false);
            Intrinsics.checkNotNullExpressionValue(view4, "view");
            GuildNavigatorAdapter.NavigatorViewHolder navigatorViewHolder = new GuildNavigatorAdapter.NavigatorViewHolder(view4, this.eventHandler);
            navigatorViewHolder.o(navigatorData);
            ViewGroup.LayoutParams layoutParams = navigatorViewHolder.itemView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.width = 0;
            layoutParams2.weight = 1.0f;
            layoutParams2.setMarginStart(I);
            View view5 = navigatorViewHolder.itemView;
            int i3 = J;
            view5.setPadding(i3, 0, i3, 0);
            LinearLayout linearLayout4 = this.oneRowContainer;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("oneRowContainer");
                linearLayout4 = null;
            }
            linearLayout4.addView(navigatorViewHolder.itemView);
        }
        View view6 = this.navigatorLayout;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigatorLayout");
        } else {
            view = view6;
        }
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        int i16 = (int) (L + K);
        M.e(Integer.valueOf(i16), "showOneRowState()");
        layoutParams3.height = i16;
    }

    private final void aa() {
        View view = this.expandIcon;
        RecyclerView recyclerView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandIcon");
            view = null;
        }
        view.setVisibility(8);
        View view2 = this.foldMaskView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldMaskView");
            view2 = null;
        }
        view2.setVisibility(8);
        RecyclerView recyclerView2 = this.foldRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldRecyclerView");
            recyclerView2 = null;
        }
        ViewGroup.LayoutParams layoutParams = recyclerView2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginEnd(0);
        RecyclerView recyclerView3 = this.foldRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldRecyclerView");
        } else {
            recyclerView = recyclerView3;
        }
        recyclerView.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba(List<NavigatorData> navigatorList) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.GuildNavigatorPart", 2, "Flow.collect size" + navigatorList.size());
        }
        View view = null;
        if (navigatorList.isEmpty()) {
            View view2 = this.navigatorLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigatorLayout");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        View view3 = this.navigatorLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigatorLayout");
            view3 = null;
        }
        view3.setVisibility(0);
        if (navigatorList.size() <= 3) {
            Z9(navigatorList);
            return;
        }
        LinearLayout linearLayout = this.oneRowContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oneRowContainer");
        } else {
            view = linearLayout;
        }
        view.setVisibility(8);
        this.foldListAdapter.setDataList(navigatorList);
        ArrayList arrayList = new ArrayList(navigatorList);
        arrayList.add(new NavigatorData(2, 0L, 0, null, null, 0, null, 126, null));
        this.expandListAdapter.setDataList(arrayList);
        ca(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca(boolean isExpand) {
        int i3;
        int i16;
        RecyclerView recyclerView = this.foldRecyclerView;
        View view = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldRecyclerView");
            recyclerView = null;
        }
        int i17 = 0;
        if (!isExpand) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        recyclerView.setVisibility(i3);
        View view2 = this.expandIcon;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandIcon");
            view2 = null;
        }
        if (!isExpand) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        view2.setVisibility(i16);
        View view3 = this.foldMaskView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldMaskView");
            view3 = null;
        }
        if (!(!isExpand)) {
            i17 = 8;
        }
        view3.setVisibility(i17);
        RecyclerView recyclerView2 = this.expandRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandRecyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setVisibility(8);
        if (isExpand) {
            RecyclerView recyclerView3 = this.expandRecyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandRecyclerView");
            } else {
                view = recyclerView3;
            }
            view.setAlpha(1.0f);
            return;
        }
        RecyclerView recyclerView4 = this.foldRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldRecyclerView");
            recyclerView4 = null;
        }
        recyclerView4.setAlpha(1.0f);
        View view4 = this.expandIcon;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandIcon");
            view4 = null;
        }
        view4.setAlpha(1.0f);
        View view5 = this.foldMaskView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldMaskView");
            view5 = null;
        }
        view5.setAlpha(1.0f);
        RecyclerView recyclerView5 = this.expandRecyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandRecyclerView");
            recyclerView5 = null;
        }
        recyclerView5.setAlpha(0.0f);
        aa();
        View view6 = this.navigatorLayout;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigatorLayout");
        } else {
            view = view6;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i18 = (int) (L + K);
        M.e(Integer.valueOf(i18), "updateViewState()");
        layoutParams.height = i18;
    }

    private final void initData() {
        com.tencent.mobileqq.guild.discoveryv2.content.part.d.b(this).launchWhenStarted(new GuildNavigatorPart$initData$1(this, FlowKt.distinctUntilChanged(C9().P1(), new Function2<GuildHomeViewModel.GuildHomeUiState, GuildHomeViewModel.GuildHomeUiState, Boolean>() { // from class: com.tencent.mobileqq.guild.homev2.parts.GuildNavigatorPart$initData$stateFlow$1
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Boolean invoke(@NotNull GuildHomeViewModel.GuildHomeUiState old, @NotNull GuildHomeViewModel.GuildHomeUiState guildHomeUiState) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(guildHomeUiState, "new");
                return Boolean.valueOf(old.getIsNormalGuild() == guildHomeUiState.getIsNormalGuild() && old.getIsVisitorVisibleGuild() == guildHomeUiState.getIsVisitorVisibleGuild());
            }
        }), null));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        GuildThemeManager.g(this);
        W9(rootView);
        initData();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.GuildNavigatorPart", 2, "onInitView");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        GuildThemeManager.j(this);
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        boolean z16;
        View view = this.navigatorLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigatorLayout");
            view = null;
        }
        if (view.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ba(C9().Z1().U1().getValue());
        }
    }
}
