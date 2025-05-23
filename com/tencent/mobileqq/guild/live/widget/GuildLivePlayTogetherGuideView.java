package com.tencent.mobileqq.guild.live.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u00013B'\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\u0014\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fR\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010 \u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001a\u0010\u001fR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u0018\u0010\u001fR\u0016\u0010$\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/live/widget/GuildLivePlayTogetherGuideView;", "Landroid/widget/FrameLayout;", "", "j", "Landroid/view/View$OnClickListener;", "listener", "setClickPlayListener", "", "teamStatus", "actionDesc", "i", "Landroid/view/View;", "anchorView", tl.h.F, "g", "", "fullScreen", "setIsFullScreen", "hidden", "setPanelChanged", "", "d", "I", "offsetBottom", "e", "offsetRight", "f", "Landroid/view/View$OnClickListener;", "onClickPlayListener", "Landroid/widget/TextView;", "Lkotlin/Lazy;", "()Landroid/widget/TextView;", "teamStatusTv", "joinTeamTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "curIsShowing", BdhLogUtil.LogTag.Tag_Conn, "panelIsHide", "D", OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, "E", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLivePlayTogetherGuideView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean panelIsHide;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isFullScreen;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View anchorView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int offsetBottom;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int offsetRight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener onClickPlayListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy teamStatusTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy joinTeamTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean curIsShowing;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLivePlayTogetherGuideView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(GuildLivePlayTogetherGuideView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.onClickPlayListener;
        if (onClickListener != null) {
            onClickListener.onClick(this$0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(GuildLivePlayTogetherGuideView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final TextView e() {
        Object value = this.joinTeamTv.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-joinTeamTv>(...)");
        return (TextView) value;
    }

    private final TextView f() {
        Object value = this.teamStatusTv.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-teamStatusTv>(...)");
        return (TextView) value;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r0.isShown() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j() {
        boolean z16;
        View view = this.anchorView;
        int i3 = 0;
        if (view != null) {
            z16 = true;
        }
        z16 = false;
        if (!z16 || !this.panelIsHide || !this.curIsShowing || this.isFullScreen) {
            i3 = 8;
        }
        setVisibility(i3);
    }

    public final void g() {
        this.curIsShowing = false;
        j();
    }

    public final void h(@Nullable View anchorView) {
        this.anchorView = anchorView;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.rightMargin = this.offsetRight;
        layoutParams2.bottomMargin = this.offsetBottom;
        setLayoutParams(layoutParams2);
        this.curIsShowing = true;
        j();
    }

    public final void i(@NotNull String teamStatus, @NotNull String actionDesc) {
        Intrinsics.checkNotNullParameter(teamStatus, "teamStatus");
        Intrinsics.checkNotNullParameter(actionDesc, "actionDesc");
        f().setText(teamStatus);
        e().setText(actionDesc);
    }

    public final void setClickPlayListener(@Nullable View.OnClickListener listener) {
        this.onClickPlayListener = listener;
    }

    public final void setIsFullScreen(boolean fullScreen) {
        this.isFullScreen = fullScreen;
        j();
    }

    public final void setPanelChanged(boolean hidden) {
        this.panelIsHide = hidden;
        j();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLivePlayTogetherGuideView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildLivePlayTogetherGuideView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLivePlayTogetherGuideView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.offsetBottom = ViewUtils.dip2px(80.0f);
        this.offsetRight = ViewUtils.dip2px(74.666664f);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.live.widget.GuildLivePlayTogetherGuideView$teamStatusTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) GuildLivePlayTogetherGuideView.this.findViewById(R.id.f108456d6);
            }
        });
        this.teamStatusTv = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.live.widget.GuildLivePlayTogetherGuideView$joinTeamTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) GuildLivePlayTogetherGuideView.this.findViewById(R.id.f108446d5);
            }
        });
        this.joinTeamTv = lazy2;
        LayoutInflater.from(context).inflate(R.layout.f168119ex1, this);
        setBackgroundResource(R.drawable.guild_live_play_together_bg);
        setVisibility(8);
        e().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.widget.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildLivePlayTogetherGuideView.c(GuildLivePlayTogetherGuideView.this, view);
            }
        });
        findViewById(R.id.y3u).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.widget.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildLivePlayTogetherGuideView.d(GuildLivePlayTogetherGuideView.this, view);
            }
        });
        this.panelIsHide = true;
    }
}
