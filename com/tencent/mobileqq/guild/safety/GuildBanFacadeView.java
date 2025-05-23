package com.tencent.mobileqq.guild.safety;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.safety.GuildBanFacadeView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableView;
import com.tencent.widget.immersive.ImmersiveUtils;
import er1.DrawableType;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00027\u0004B'\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00103\u001a\u000202\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010\u0010\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/safety/GuildBanFacadeView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/theme/SkinnableView;", "", "b", "d", "Lcom/tencent/mobileqq/guild/mainframe/a;", "provider", "Lcom/tencent/mobileqq/guild/safety/GuildBanFacadeView$b;", "callback", "setGuildMainViewContext", "onThemeChanged", "Lcom/tencent/mobileqq/guild/mainframe/a;", "mGuildMainViewContext", "Landroid/view/View;", "e", "Landroid/view/View;", "mRootView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mGuildBanTitle", tl.h.F, "mGuildBanContentTitle", "Landroid/view/ViewGroup;", "i", "Landroid/view/ViewGroup;", "mGuildBanTitleLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mGuildBanContent", "Landroid/widget/Button;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/Button;", "mGuildBanMainBtn", "D", "mGuildBanSubBtn", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "mGuildBanIcon", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "G", "mCoverBack", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildBanFacadeView extends RelativeLayout implements SkinnableView {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Button mGuildBanMainBtn;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Button mGuildBanSubBtn;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ImageView mGuildBanIcon;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private IGProGuildInfo mGuildInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final View mCoverBack;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.guild.mainframe.a mGuildMainViewContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mGuildBanTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mGuildBanContentTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup mGuildBanTitleLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mGuildBanContent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/safety/GuildBanFacadeView$b;", "", "", "onFinish", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void onFinish();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildBanFacadeView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b() {
        IGProGuildInfo iGProGuildInfo = this.mGuildInfo;
        boolean z16 = false;
        if (iGProGuildInfo != null && iGProGuildInfo.getUserType() == 2) {
            z16 = true;
        }
        if (z16) {
            new DrawableType(R.drawable.guild_ban_red_tip, Integer.valueOf(R.color.qui_common_feedback_error)).b(this.mGuildBanIcon);
        } else {
            new DrawableType(R.drawable.guild_ban_blue_tip, Integer.valueOf(R.color.qui_common_feedback_normal)).b(this.mGuildBanIcon);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(b callback, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.onFinish();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void d() {
        b();
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        d();
    }

    public final void setGuildMainViewContext(@NotNull com.tencent.mobileqq.guild.mainframe.a provider, @NotNull final b callback) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mGuildMainViewContext = provider;
        if (provider instanceof com.tencent.mobileqq.guild.mainframe.e) {
            if (((com.tencent.mobileqq.guild.mainframe.e) provider).getF227292a().a().isPreviewStyle()) {
                ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
                this.mRootView.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
            }
        } else {
            this.mGuildBanTitleLayout.setVisibility(8);
        }
        if (provider.a().isTabStyle()) {
            this.mCoverBack.setVisibility(8);
            ViewGroup.LayoutParams layoutParams2 = this.mGuildBanTitle.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = QQGuildUIUtil.f(12.0f);
            Logger.f235387a.d().d("GuildBanFacadeView", 1, "setGuildMainViewContext guildTab");
            return;
        }
        if (provider.a() == GuildFacadeType.ChatList) {
            this.mCoverBack.setVisibility(0);
            ViewGroup.LayoutParams layoutParams3 = this.mGuildBanTitle.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = QQGuildUIUtil.f(7.0f);
            this.mCoverBack.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.safety.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildBanFacadeView.c(GuildBanFacadeView.b.this, view);
                }
            });
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
            ViewGroup.LayoutParams layoutParams4 = this.mGuildBanTitleLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = statusBarHeight;
            ViewGroup.LayoutParams layoutParams5 = this.mRootView.findViewById(R.id.t38).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = 0;
            Logger.f235387a.d().d("GuildBanFacadeView", 1, "setGuildMainViewContext chatList statusBarHeight:" + statusBarHeight);
            return;
        }
        Logger.f235387a.d().w("GuildBanFacadeView", 1, "setGuildMainViewContext unexpectedFacadeType:" + provider.a());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildBanFacadeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildBanFacadeView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildBanFacadeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.eml, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026ld_facade_ban_view, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.f120607_0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.warn_icon)");
        this.mGuildBanIcon = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f165583ws3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.guild_name_tv)");
        this.mGuildBanTitle = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.title)");
        this.mGuildBanTitleLayout = (ViewGroup) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.w0f);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R\u2026.guild_ban_content_title)");
        this.mGuildBanContentTitle = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.t37);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.ban_content_tv)");
        this.mGuildBanContent = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.w0d);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R\u2026ild_ban_content_main_btn)");
        this.mGuildBanMainBtn = (Button) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.w0e);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R\u2026uild_ban_content_sub_btn)");
        this.mGuildBanSubBtn = (Button) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.u_q);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mRootView.findViewById(R.id.cover_back)");
        this.mCoverBack = findViewById8;
    }
}
