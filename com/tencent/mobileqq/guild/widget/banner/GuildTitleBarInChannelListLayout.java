package com.tencent.mobileqq.guild.widget.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.config.GuildCoverInfo;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.header.business.onlinemember.GuildOnlineMemberController;
import com.tencent.mobileqq.guild.mainframe.view.GuildChannelNameTextView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.t;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0001VB)\u0012\u0006\u0010K\u001a\u00020J\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u0012\u0006\u0010N\u001a\u00020\u0007\u0012\u0006\u0010O\u001a\u00020\u0007\u00a2\u0006\u0004\bP\u0010QB\u0011\b\u0016\u0012\u0006\u0010K\u001a\u00020J\u00a2\u0006\u0004\bP\u0010RB\u001b\b\u0016\u0012\u0006\u0010K\u001a\u00020J\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u00a2\u0006\u0004\bP\u0010SB#\b\u0016\u0012\u0006\u0010K\u001a\u00020J\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u0012\u0006\u0010N\u001a\u00020\u0007\u00a2\u0006\u0004\bP\u0010TJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0014J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007J\b\u0010\r\u001a\u00020\u0005H\u0014J\b\u0010\u000e\u001a\u00020\u0005H\u0014J0\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0014J\u0012\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010.\u001a\u00020\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u001e\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"R\"\u00101\u001a\u00020$8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b,\u0010&\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010?\u001a\u00020:8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R?\u0010I\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010@8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/banner/GuildTitleBarInChannelListLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/util/t;", "Lks1/a;", "titleClickCallback", "", "setOnClickCallback", "", "visibility", "setVisibility", "drawableStateChanged", "alphaPosOffset", "setStartAlphaPosOffset", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "", "changed", "left", "top", "right", "bottom", "onLayout", "", "guildId", "j", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildChannelNameTextView;", "d", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildChannelNameTextView;", "titleView", "e", "Landroid/widget/FrameLayout;", tl.h.F, "()Landroid/widget/FrameLayout;", "setMoreBtnLayout", "(Landroid/widget/FrameLayout;)V", "moreBtnLayout", "Landroid/view/View;", "f", "Landroid/view/View;", "getMoreRedLayout", "()Landroid/view/View;", "setMoreRedLayout", "(Landroid/view/View;)V", "moreRedLayout", "i", "setShareLayout", "shareLayout", "g", "setGotoGuildLayout", "gotoGuildLayout", "Lcom/tencent/mobileqq/guild/widget/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/widget/b;", "bannerSizeHelper", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/header/business/onlinemember/GuildOnlineMemberController;", "D", "Lkotlin/Lazy;", "getOnlineMemberController", "()Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/header/business/onlinemember/GuildOnlineMemberController;", "onlineMemberController", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "E", "Lkotlin/jvm/functions/Function1;", "getOnVisibilityChanged", "()Lkotlin/jvm/functions/Function1;", "setOnVisibilityChanged", "(Lkotlin/jvm/functions/Function1;)V", "onVisibilityChanged", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildTitleBarInChannelListLayout extends FrameLayout implements t {
    private static final int G = ViewUtils.dip2px(18.0f);
    private static final int H = ViewUtils.dip2px(14.0f);
    private static final int I = ViewUtils.dip2px(12.0f);
    private static final int J = ViewUtils.dip2px(6.0f);
    private static final int K = ViewUtils.dip2px(16.0f);
    private static final int L = ViewUtils.dip2px(20.0f);
    private static final int M = ViewUtils.dip2px(23.0f);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private GuildFacadeType guildFacadeType;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy onlineMemberController;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function1<? super Integer, Unit> onVisibilityChanged;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildChannelNameTextView titleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public FrameLayout moreBtnLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public View moreRedLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public FrameLayout shareLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public View gotoGuildLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.widget.b bannerSizeHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTitleBarInChannelListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.bannerSizeHelper = new com.tencent.mobileqq.guild.widget.b(context, "Guild.MF.Rt.GuildCoverBelowList");
        this.guildFacadeType = GuildFacadeType.Tab;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildOnlineMemberController>() { // from class: com.tencent.mobileqq.guild.widget.banner.GuildTitleBarInChannelListLayout$onlineMemberController$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildOnlineMemberController invoke() {
                GuildFacadeType guildFacadeType;
                GuildOnlineMemberController.PositionType positionType = GuildOnlineMemberController.PositionType.GUILD_MF_COVER_ABOVE;
                guildFacadeType = GuildTitleBarInChannelListLayout.this.guildFacadeType;
                return new GuildOnlineMemberController(positionType, guildFacadeType);
            }
        });
        this.onlineMemberController = lazy;
    }

    private final boolean j(String guildId) {
        if (!ch.j0(guildId) && !this.guildFacadeType.isPreviewStyle()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(ks1.a titleClickCallback, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(titleClickCallback, "$titleClickCallback");
        titleClickCallback.c(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ks1.a titleClickCallback, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(titleClickCallback, "$titleClickCallback");
        titleClickCallback.c(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ks1.a titleClickCallback, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(titleClickCallback, "$titleClickCallback");
        titleClickCallback.a(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ks1.a titleClickCallback, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(titleClickCallback, "$titleClickCallback");
        titleClickCallback.b(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ks1.a titleClickCallback, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(titleClickCallback, "$titleClickCallback");
        titleClickCallback.c(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (isPressed() && !j(null)) {
            setBackgroundColor(GuildCoverInfo.E);
        } else {
            setBackgroundColor(0);
        }
    }

    @NotNull
    public final View g() {
        View view = this.gotoGuildLayout;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gotoGuildLayout");
        return null;
    }

    @NotNull
    public final FrameLayout h() {
        FrameLayout frameLayout = this.moreBtnLayout;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("moreBtnLayout");
        return null;
    }

    @NotNull
    public final FrameLayout i() {
        FrameLayout frameLayout = this.shareLayout;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logger.f235387a.d().d("GuildTitleBarInChannelListLayout", 1, "onAttachedToWindow, alpha=" + getAlpha());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Logger.f235387a.d().d("GuildTitleBarInChannelListLayout", 1, "onDetachedFromWindow, alpha=" + getAlpha());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Logger.f235387a.d().d("GuildTitleBarInChannelListLayout", 1, "onLayout(" + changed + ", " + left + ", " + top + ", " + right + ", " + bottom + "), alpha=" + getAlpha());
    }

    public final void setGotoGuildLayout(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.gotoGuildLayout = view;
    }

    public final void setMoreBtnLayout(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.moreBtnLayout = frameLayout;
    }

    public final void setMoreRedLayout(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.moreRedLayout = view;
    }

    public final void setOnClickCallback(@NotNull final ks1.a titleClickCallback) {
        Intrinsics.checkNotNullParameter(titleClickCallback, "titleClickCallback");
        if (this.guildFacadeType.isPreviewStyle()) {
            setEnabled(false);
            return;
        }
        GuildChannelNameTextView guildChannelNameTextView = this.titleView;
        if (guildChannelNameTextView != null) {
            if (guildChannelNameTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleView");
                guildChannelNameTextView = null;
            }
            guildChannelNameTextView.setOnClickListener(new View.OnClickListener(titleClickCallback) { // from class: com.tencent.mobileqq.guild.widget.banner.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildTitleBarInChannelListLayout.k(null, view);
                }
            });
        }
        if (this.moreBtnLayout != null) {
            h().setOnClickListener(new View.OnClickListener(titleClickCallback) { // from class: com.tencent.mobileqq.guild.widget.banner.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildTitleBarInChannelListLayout.l(null, view);
                }
            });
        }
        if (this.shareLayout != null) {
            i().setOnClickListener(new View.OnClickListener(titleClickCallback) { // from class: com.tencent.mobileqq.guild.widget.banner.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildTitleBarInChannelListLayout.m(null, view);
                }
            });
        }
        if (this.gotoGuildLayout != null) {
            g().setOnClickListener(new View.OnClickListener(titleClickCallback) { // from class: com.tencent.mobileqq.guild.widget.banner.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildTitleBarInChannelListLayout.n(null, view);
                }
            });
        }
        setOnClickListener(new View.OnClickListener(titleClickCallback) { // from class: com.tencent.mobileqq.guild.widget.banner.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildTitleBarInChannelListLayout.o(null, view);
            }
        });
    }

    public final void setOnVisibilityChanged(@Nullable Function1<? super Integer, Unit> function1) {
        this.onVisibilityChanged = function1;
    }

    public final void setShareLayout(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.shareLayout = frameLayout;
    }

    public final void setStartAlphaPosOffset(int alphaPosOffset) {
        this.bannerSizeHelper.i(alphaPosOffset);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        Function1<? super Integer, Unit> function1 = this.onVisibilityChanged;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(visibility));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildTitleBarInChannelListLayout(@NotNull Context context) {
        this(context, null, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildTitleBarInChannelListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildTitleBarInChannelListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
