package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.home.views.ban.GuildHomeBanLayout;
import com.tencent.mobileqq.guild.homev2.views.GuildNavigateTitleContainer;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 K2\u00020\u0001:\u0001LB\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u001c\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R#\u0010\"\u001a\n \u001d*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&R\u001b\u0010*\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010&R\u001b\u0010-\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010&R\u001b\u00100\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010\u001f\u001a\u0004\b/\u0010&R\u001b\u00103\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010\u001f\u001a\u0004\b2\u0010&R\u001b\u00106\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010\u001f\u001a\u0004\b5\u0010&R\u001b\u00109\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010\u001f\u001a\u0004\b8\u0010&R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010\u001f\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010\u001f\u001a\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010\u001f\u001a\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/FeedTipPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "args", "", "S9", "R9", "", "errorCode", "Landroid/view/View;", "D9", "T9", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "withGuildInfo", "B9", NodeProps.VISIBLE, "W9", "Ltl1/g$q;", "V9", "Q9", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "C9", "U9", "", "E9", "action", "handleBroadcastMessage", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "F9", "()Landroid/view/ViewGroup;", "emptyTipRoot", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "e", "M9", "()Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "quiNetErrorState", "f", "J9", "quiFeedDeletedState", tl.h.F, "I9", "permissionIssueState", "i", "P9", "unknowIssueState", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "H9", "notApprovedState", BdhLogUtil.LogTag.Tag_Conn, "O9", "underReviewState", "D", "L9", "quiGuildNotExistState", "Lcom/tencent/mobileqq/guild/home/views/ban/GuildHomeBanLayout;", "E", "K9", "()Lcom/tencent/mobileqq/guild/home/views/ban/GuildHomeBanLayout;", "quiGuildForbidState", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", UserInfo.SEX_FEMALE, "G9", "()Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "loadingView", "Landroid/widget/LinearLayout;", "G", "N9", "()Landroid/widget/LinearLayout;", "reloadingView", "<init>", "()V", "H", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedTipPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy underReviewState;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy quiGuildNotExistState;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy quiGuildForbidState;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy reloadingView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy emptyTipRoot;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy quiNetErrorState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy quiFeedDeletedState;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy permissionIssueState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy unknowIssueState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy notApprovedState;

    public FeedTipPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ViewGroup>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.FeedTipPart$emptyTipRoot$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewGroup invoke() {
                return (ViewGroup) FeedTipPart.this.getPartRootView().findViewById(R.id.v2a);
            }
        });
        this.emptyTipRoot = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new FeedTipPart$quiNetErrorState$2(this));
        this.quiNetErrorState = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new FeedTipPart$quiFeedDeletedState$2(this));
        this.quiFeedDeletedState = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new FeedTipPart$permissionIssueState$2(this));
        this.permissionIssueState = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new FeedTipPart$unknowIssueState$2(this));
        this.unknowIssueState = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new FeedTipPart$notApprovedState$2(this));
        this.notApprovedState = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new FeedTipPart$underReviewState$2(this));
        this.underReviewState = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new FeedTipPart$quiGuildNotExistState$2(this));
        this.quiGuildNotExistState = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeBanLayout>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.FeedTipPart$quiGuildForbidState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeBanLayout invoke() {
                Context context = FeedTipPart.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                GuildHomeBanLayout guildHomeBanLayout = new GuildHomeBanLayout(context, null, 0, 6, null);
                FeedTipPart feedTipPart = FeedTipPart.this;
                guildHomeBanLayout.setVisibility(8);
                LifecycleCoroutineScope e16 = com.tencent.mobileqq.guild.feed.part.a.e(feedTipPart);
                if (e16 != null) {
                    BuildersKt__Builders_commonKt.launch$default(e16, null, null, new FeedTipPart$quiGuildForbidState$2$1$1(feedTipPart, guildHomeBanLayout, null), 3, null);
                }
                return guildHomeBanLayout;
            }
        });
        this.quiGuildForbidState = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<ScanningLightView>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.FeedTipPart$loadingView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ScanningLightView invoke() {
                Context context = FeedTipPart.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ScanningLightView scanningLightView = new ScanningLightView(context, null, 2, null);
                scanningLightView.v(false);
                scanningLightView.setBackgroundResource(R.drawable.guild_jump_loading_feed_detail_page);
                scanningLightView.setSkeletonColorRes(R.color.qui_common_fill_standard_primary);
                return scanningLightView;
            }
        });
        this.loadingView = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.FeedTipPart$reloadingView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                LinearLayout linearLayout = new LinearLayout(FeedTipPart.this.getContext());
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                View imageView = new ImageView(linearLayout.getContext());
                ol1.b bVar = ol1.b.f423088a;
                Context context = imageView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                imageView.setBackground(bVar.d(context));
                imageView.setId(R.id.ysu);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f));
                layoutParams.setMarginEnd(ViewUtils.dip2px(4.0f));
                imageView.setLayoutParams(layoutParams);
                linearLayout.addView(imageView);
                TextView textView = new TextView(linearLayout.getContext());
                textView.setText(textView.getContext().getString(R.string.zxu));
                textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_text_secondary));
                textView.setTextSize(14.0f);
                linearLayout.addView(textView);
                return linearLayout;
            }
        });
        this.reloadingView = lazy11;
    }

    private final void B9(ViewGroup parent, boolean withGuildInfo) {
        IGProGuildInfo L = ch.L(yl1.n.r(this));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GuildNavigateTitleContainer guildNavigateTitleContainer = new GuildNavigateTitleContainer(context, null, 0, 0, 14, null);
        if (withGuildInfo && !U9()) {
            guildNavigateTitleContainer.M0(L);
            guildNavigateTitleContainer.F0(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.FeedTipPart$addTitle$1$1$1
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
                    FeedTipPart.this.Q9();
                }
            });
        } else {
            guildNavigateTitleContainer.D0();
        }
        guildNavigateTitleContainer.E0(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.FeedTipPart$addTitle$1$1$2
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
                QLog.i("FeedTipPart", 2, "error view, back click");
                FeedTipPart.this.getPartHost().getHostActivity().onBackPressed();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        int c16 = (int) cw.c(4.0f);
        layoutParams.setMarginStart(0);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = c16;
        layoutParams.setMarginEnd(0);
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = 0;
        layoutParams.addRule(10);
        Unit unit = Unit.INSTANCE;
        parent.addView(guildNavigateTitleContainer, layoutParams);
    }

    private final JumpGuildParam C9() {
        String str;
        Activity hostActivity;
        Intent intent;
        Bundle extras;
        String str2 = "";
        JumpGuildParam jumpGuildParam = new JumpGuildParam(yl1.n.r(this), "");
        JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) GuildSplitViewUtils.f235370a.h(getPartHost()).getParcelable("join_info_param");
        if (joinInfoParam == null) {
            joinInfoParam = jumpGuildParam.getJoinInfoParam();
            Intrinsics.checkNotNullExpressionValue(joinInfoParam, "jumpGuildParam.joinInfoParam");
        }
        IPartHost partHost = getPartHost();
        if (partHost != null && (hostActivity = partHost.getHostActivity()) != null && (intent = hostActivity.getIntent()) != null && (extras = intent.getExtras()) != null) {
            str = extras.getString("trace_Id", "");
        } else {
            str = null;
        }
        if (str != null) {
            str2 = str;
        }
        jumpGuildParam.extras.putString(JumpGuildParam.EXTRA_KEY_TRACE_ID, str2);
        jumpGuildParam.setJoinInfoParam(joinInfoParam);
        return jumpGuildParam;
    }

    private final View D9(int errorCode) {
        if (!NetworkUtil.isNetworkAvailable()) {
            return M9();
        }
        if (errorCode != 10014) {
            if (errorCode != 10015) {
                if (errorCode != 10023) {
                    if (errorCode != 10046) {
                        if (errorCode != 20014) {
                            if (errorCode != 20031) {
                                if (errorCode != 20040 && errorCode != 20041) {
                                    switch (errorCode) {
                                        case 20033:
                                        case 20034:
                                        case 20035:
                                            return L9();
                                        case 20036:
                                        case 20037:
                                        case 20038:
                                            return K9();
                                        default:
                                            return M9();
                                    }
                                }
                                return I9();
                            }
                            return H9();
                        }
                        return O9();
                    }
                } else {
                    return P9();
                }
            } else {
                return H9();
            }
        }
        return J9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String E9() {
        if (!U9()) {
            return "\u53bb\u9891\u9053";
        }
        return "";
    }

    private final ViewGroup F9() {
        return (ViewGroup) this.emptyTipRoot.getValue();
    }

    private final ScanningLightView G9() {
        return (ScanningLightView) this.loadingView.getValue();
    }

    private final GuildQUIEmptyState H9() {
        return (GuildQUIEmptyState) this.notApprovedState.getValue();
    }

    private final GuildQUIEmptyState I9() {
        return (GuildQUIEmptyState) this.permissionIssueState.getValue();
    }

    private final GuildQUIEmptyState J9() {
        return (GuildQUIEmptyState) this.quiFeedDeletedState.getValue();
    }

    private final GuildHomeBanLayout K9() {
        return (GuildHomeBanLayout) this.quiGuildForbidState.getValue();
    }

    private final GuildQUIEmptyState L9() {
        return (GuildQUIEmptyState) this.quiGuildNotExistState.getValue();
    }

    private final GuildQUIEmptyState M9() {
        return (GuildQUIEmptyState) this.quiNetErrorState.getValue();
    }

    private final LinearLayout N9() {
        return (LinearLayout) this.reloadingView.getValue();
    }

    private final GuildQUIEmptyState O9() {
        return (GuildQUIEmptyState) this.underReviewState.getValue();
    }

    private final GuildQUIEmptyState P9() {
        return (GuildQUIEmptyState) this.unknowIssueState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9() {
        boolean isBlank;
        String r16 = yl1.n.r(this);
        isBlank = StringsKt__StringsJVMKt.isBlank(r16);
        if (!isBlank) {
            QLog.i("FeedTipPart", 1, "handleJumpToGuildHomePage finished activity and go guild home");
            Context context = getPartRootView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            GuildJumpUtil.n(context, C9());
            return;
        }
        QLog.e("FeedTipPart", 1, "handleJumpToGuildHomePage failed guild is invalid " + r16);
    }

    private final void R9(Object args) {
        g.OnLoadMainCompletedMessage onLoadMainCompletedMessage;
        if (args instanceof g.OnLoadMainCompletedMessage) {
            onLoadMainCompletedMessage = (g.OnLoadMainCompletedMessage) args;
        } else {
            onLoadMainCompletedMessage = null;
        }
        if (onLoadMainCompletedMessage == null) {
            return;
        }
        QLog.i("FeedTipPart", 1, "handleLoadMainDataCompleted isSuccess=" + onLoadMainCompletedMessage.getIsSuccess() + " errorCode=" + onLoadMainCompletedMessage.getErrorCode() + ", isDb=" + onLoadMainCompletedMessage.getIsDbCache());
        if (onLoadMainCompletedMessage.getIsDbCache()) {
            return;
        }
        if (!onLoadMainCompletedMessage.getIsSuccess()) {
            broadcastMessage("message_change_comment_list_visibility", new g.ChangeCommentListVisibilityMessage(false));
            View D9 = D9(onLoadMainCompletedMessage.getErrorCode());
            ViewGroup F9 = F9();
            F9.setVisibility(0);
            F9.removeAllViews();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            Unit unit = Unit.INSTANCE;
            F9.addView(D9, layoutParams);
            Intrinsics.checkNotNullExpressionValue(F9, "this");
            B9(F9, !Intrinsics.areEqual(D9, M9()));
            W9(false);
            return;
        }
        F9().setVisibility(8);
        W9(true);
        V9((g.OnLoadMainCompletedMessage) args);
    }

    private final void S9(Object args) {
        g.OnPreloadMainCompletedMessage onPreloadMainCompletedMessage;
        g.OnPreloadMainCompletedMessage onPreloadMainCompletedMessage2 = null;
        if (args instanceof g.OnPreloadMainCompletedMessage) {
            onPreloadMainCompletedMessage = (g.OnPreloadMainCompletedMessage) args;
        } else {
            onPreloadMainCompletedMessage = null;
        }
        if (onPreloadMainCompletedMessage != null) {
            if (!onPreloadMainCompletedMessage.getIsSuccess()) {
                onPreloadMainCompletedMessage2 = onPreloadMainCompletedMessage;
            }
            if (onPreloadMainCompletedMessage2 != null) {
                QLog.i("FeedTipPart", 1, "handleLoadingSkeleton");
                W9(false);
                ViewGroup F9 = F9();
                F9.setVisibility(0);
                F9.removeAllViews();
                ScanningLightView G9 = G9();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                Unit unit = Unit.INSTANCE;
                F9.addView(G9, layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9() {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(getContext(), R.string.f1498013_, 0).show();
            return;
        }
        ViewGroup container = F9();
        container.removeAllViews();
        Intrinsics.checkNotNullExpressionValue(container, "container");
        B9(container, false);
        View N9 = N9();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        Unit unit = Unit.INSTANCE;
        container.addView(N9, layoutParams);
        broadcastMessage("message_change_comment_list_visibility", new g.ChangeCommentListVisibilityMessage(true));
        broadcastMessage("message_reload", new g.ReloadMessage("FeedTipPart", 0, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
    
        if (r1.length() == 0) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean U9() {
        boolean z16 = false;
        try {
            String string = GuildSplitViewUtils.f235370a.h(getPartHost()).getString("FEED_TROOP_UIN");
            if (string != null) {
            }
            z16 = true;
            return !z16;
        } catch (Exception unused) {
            return false;
        }
    }

    private final void V9(g.OnLoadMainCompletedMessage args) {
        String str;
        Object obj;
        boolean z16;
        List<hl1.g> a16 = args.a();
        if (a16 != null) {
            Iterator<T> it = a16.iterator();
            while (true) {
                str = null;
                if (it.hasNext()) {
                    obj = it.next();
                    if (((hl1.g) obj) instanceof FeedDetailMainData) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            hl1.g gVar = (hl1.g) obj;
            if (gVar != null) {
                qj1.h feedDetail = ((FeedDetailMainData) gVar).getFeedDetail();
                IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
                if (iGPSService != null) {
                    str = iGPSService.getSelfTinyId();
                }
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "QQGuildUtil.runtimeServi\u2026ss.java)?.selfTinyId?: \"\"");
                }
                boolean areEqual = Intrinsics.areEqual(feedDetail.r(), str);
                if (feedDetail.s() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QLog.i("FeedTipPart", 1, "notifyIsFeedAllowComment feedDetail.getAllowFeedComment()=" + feedDetail.s() + "  feedDetail.getPosterId():" + feedDetail.r() + "  currentAccountTinyId:" + str);
                broadcastMessage("message_update_feed_allow_comment", new g.UpdateFeedAllowCommentMessage(z16, areEqual));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.view.View] */
    private final void W9(boolean visible) {
        QLog.i("FeedTipPart", 1, "updateContentVisible visible=" + visible);
        View findViewById = getPartRootView().findViewById(R.id.v1n);
        Boolean valueOf = Boolean.valueOf(visible);
        findViewById.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, findViewById)) == null) {
            findViewById.setVisibility(8);
        }
        View findViewById2 = getPartRootView().findViewById(R.id.v1r);
        Boolean valueOf2 = Boolean.valueOf(visible);
        findViewById2.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf2, findViewById2)) == null) {
            findViewById2.setVisibility(8);
        }
        ViewGroup viewGroup = (ViewGroup) getPartRootView().findViewById(R.id.v28);
        if (viewGroup != null) {
            Boolean valueOf3 = Boolean.valueOf(visible);
            viewGroup.setVisibility(0);
            ?? r56 = (View) com.tencent.guild.aio.util.ex.g.a(valueOf3, viewGroup);
            if (r56 == 0) {
                viewGroup.setVisibility(8);
            } else {
                viewGroup = r56;
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -616307613) {
                if (hashCode != 159204545) {
                    if (hashCode != 329916566 || !action.equals("message_on_load_main_completed")) {
                        return;
                    }
                } else if (!action.equals("message_on_main_reload_complete")) {
                    return;
                }
                R9(args);
                return;
            }
            if (action.equals("message_on_preload_main_completed")) {
                S9(args);
            }
        }
    }
}
