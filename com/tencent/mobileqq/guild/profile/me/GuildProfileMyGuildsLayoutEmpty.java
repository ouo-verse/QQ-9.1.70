package com.tencent.mobileqq.guild.profile.me;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreatedGuildInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0014J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\r8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\r8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010$\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001f\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/GuildProfileMyGuildsLayoutEmpty;", "Lcom/tencent/mobileqq/guild/profile/me/GuildProfileMyGuildsLayout;", "Landroid/view/View$OnClickListener;", "", "K0", "F0", "onThemeChanged", NodeProps.ON_ATTACHED_TO_WINDOW, "", "C0", "Landroid/view/View;", "p0", NodeProps.ON_CLICK, "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getCREATE_GUILD_LEFT_DARK", "()Ljava/lang/String;", "CREATE_GUILD_LEFT_DARK", "D", "getCREATE_GUILD_LEFT_WHITE", "CREATE_GUILD_LEFT_WHITE", "E", "getCREATE_GUILD_RIGHT", "CREATE_GUILD_RIGHT", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "getMGuildProfileBannerIcon", "()Landroid/widget/ImageView;", "setMGuildProfileBannerIcon", "(Landroid/widget/ImageView;)V", "mGuildProfileBannerIcon", "G", "getMRightBg", "setMRightBg", "mRightBg", "Landroid/content/Context;", "context", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCreatedGuildInfo;", "guildList", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileMyGuildsLayoutEmpty extends GuildProfileMyGuildsLayout implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String CREATE_GUILD_LEFT_DARK;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String CREATE_GUILD_LEFT_WHITE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String CREATE_GUILD_RIGHT;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ImageView mGuildProfileBannerIcon;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView mRightBg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileMyGuildsLayoutEmpty(@NotNull Context context, @NotNull List<? extends IGProCreatedGuildInfo> guildList) {
        super(context, guildList);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildList, "guildList");
        this.CREATE_GUILD_LEFT_DARK = "https://downv6.qq.com/innovate/guild/cover_info/create_guild_left_dark.png";
        this.CREATE_GUILD_LEFT_WHITE = "https://downv6.qq.com/innovate/guild/cover_info/create_guild_left_white.png";
        this.CREATE_GUILD_RIGHT = "https://downv6.qq.com/innovate/guild/cover_info/create_guild_right.png";
        J0();
        setClickable(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setFocusable(true);
        }
        setOnClickListener(this);
    }

    private final void K0() {
        if (GuildThemeManager.f235286a.b()) {
            ImageView imageView = this.mRightBg;
            Intrinsics.checkNotNull(imageView);
            imageView.setAlpha(0.08f);
            String str = this.CREATE_GUILD_LEFT_DARK;
            ImageView imageView2 = this.mGuildProfileBannerIcon;
            Intrinsics.checkNotNull(imageView2);
            com.tencent.mobileqq.guild.util.v.i(str, imageView2);
        } else {
            ImageView imageView3 = this.mRightBg;
            Intrinsics.checkNotNull(imageView3);
            imageView3.setAlpha(1.0f);
            String str2 = this.CREATE_GUILD_LEFT_WHITE;
            ImageView imageView4 = this.mGuildProfileBannerIcon;
            Intrinsics.checkNotNull(imageView4);
            com.tencent.mobileqq.guild.util.v.i(str2, imageView4);
        }
        String str3 = this.CREATE_GUILD_RIGHT;
        ImageView imageView5 = this.mRightBg;
        Intrinsics.checkNotNull(imageView5);
        com.tencent.mobileqq.guild.util.v.i(str3, imageView5);
    }

    @Override // com.tencent.mobileqq.guild.profile.me.GuildProfileMyGuildsLayout
    public int C0() {
        return R.layout.f2g;
    }

    @Override // com.tencent.mobileqq.guild.profile.me.GuildProfileMyGuildsLayout
    public void F0() {
        super.F0();
        this.mGuildProfileBannerIcon = (ImageView) findViewById(R.id.f165592wu2);
        this.mRightBg = (ImageView) findViewById(R.id.wir);
        K0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        postInvalidate();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View p06) {
        EventCollector.getInstance().onViewClickedBefore(p06);
        if (p06 != null) {
            A0(p06);
        }
        EventCollector.getInstance().onViewClicked(p06);
    }

    @Override // com.tencent.mobileqq.guild.profile.me.GuildProfileMyGuildsLayout
    public void onThemeChanged() {
        super.onThemeChanged();
        K0();
    }

    public final void setMGuildProfileBannerIcon(@Nullable ImageView imageView) {
        this.mGuildProfileBannerIcon = imageView;
    }

    public final void setMRightBg(@Nullable ImageView imageView) {
        this.mRightBg = imageView;
    }
}
