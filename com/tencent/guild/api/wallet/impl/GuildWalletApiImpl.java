package com.tencent.guild.api.wallet.impl;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.wallet.GuildWalletHolder;
import com.tencent.guild.api.wallet.IGuildWalletApi;
import com.tencent.guild.api.wallet.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import d4.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vk2.QWalletMsgModel;
import vk2.QWalletSessionInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\bH\u0016J(\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J \u0010\u0017\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\bH\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/guild/api/wallet/impl/GuildWalletApiImpl;", "Lcom/tencent/guild/api/wallet/IGuildWalletApi;", "Landroid/view/View;", "root", "createWalletContentView", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "contentView", "", "inGuildLive", "Lcom/tencent/guild/api/wallet/a;", "createGuildWalletHolder", "play", "", "changeGuildWalletApngState", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "guildId", "peerUid", "createRedPacketPanel", "goToSendHbActivity", "panelView", "show", "onPanelVisibilityChanged", "<init>", "()V", "a", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildWalletApiImpl implements IGuildWalletApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/api/wallet/impl/GuildWalletApiImpl$a;", "Ld4/f;", "Landroid/widget/RelativeLayout;", "getLayout", "Landroid/widget/TextView;", "a", "getBackground", h.F, "Landroid/widget/LinearLayout;", "f", "c", "b", "g", "Landroid/widget/ImageView;", "e", "d", "Landroid/view/View;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements f {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View view;

        public a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        @Override // d4.f
        @Nullable
        public TextView a() {
            return (TextView) this.view.findViewById(R.id.h3w);
        }

        @Override // d4.f
        @NotNull
        public TextView b() {
            View findViewById = this.view.findViewById(R.id.f67273cw);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qwallet_hb_aio_title)");
            return (TextView) findViewById;
        }

        @Override // d4.f
        @NotNull
        public TextView c() {
            View findViewById = this.view.findViewById(R.id.f67263cv);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qwallet_hb_aio_subtitle)");
            return (TextView) findViewById;
        }

        @Override // d4.f
        @NotNull
        public TextView d() {
            View findViewById = this.view.findViewById(R.id.f67193co);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qwallet_hb_aio_hb_state)");
            return (TextView) findViewById;
        }

        @Override // d4.f
        @NotNull
        public ImageView e() {
            View findViewById = this.view.findViewById(R.id.f67243ct);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qwallet_hb_aio_open_icon)");
            return (ImageView) findViewById;
        }

        @Override // d4.f
        @NotNull
        public LinearLayout f() {
            View findViewById = this.view.findViewById(R.id.f67223cr);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qwallet_hb_aio_icon_layout)");
            return (LinearLayout) findViewById;
        }

        @Override // d4.f
        @NotNull
        public TextView g() {
            View findViewById = this.view.findViewById(R.id.f67283cx);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.q\u2026llet_hb_aio_title_bottom)");
            return (TextView) findViewById;
        }

        @Override // d4.f
        @Nullable
        public RelativeLayout getBackground() {
            return (RelativeLayout) this.view.findViewById(R.id.f67173cm);
        }

        @Override // d4.f
        @NotNull
        public RelativeLayout getLayout() {
            View findViewById = this.view.findViewById(R.id.f67233cs);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qwallet_hb_aio_layout)");
            return (RelativeLayout) findViewById;
        }

        @Override // d4.f
        @NotNull
        public RelativeLayout h() {
            View findViewById = this.view.findViewById(R.id.f67183cn);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qwallet_hb_aio_foreground)");
            return (RelativeLayout) findViewById;
        }
    }

    @Override // com.tencent.guild.api.wallet.IGuildWalletApi
    public void changeGuildWalletApngState(boolean play) {
        ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).changeGuildWalletApngState(play);
    }

    @Override // com.tencent.guild.api.wallet.IGuildWalletApi
    @NotNull
    public com.tencent.guild.api.wallet.a createGuildWalletHolder(@NotNull GuildMsgItem msgItem, @Nullable View contentView, boolean inGuildLive) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        QWalletMsgModel d16 = b.d(msgItem);
        String str = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.guildId");
        String str2 = msgItem.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.peerUid");
        QWalletSessionInfo qWalletSessionInfo = new QWalletSessionInfo(10014, str, str2, inGuildLive);
        if (contentView != null) {
            return new GuildWalletHolder(d16, new a(contentView), qWalletSessionInfo);
        }
        return new GuildWalletHolder(d16, null, qWalletSessionInfo);
    }

    @Override // com.tencent.guild.api.wallet.IGuildWalletApi
    @NotNull
    public View createRedPacketPanel(@NotNull Activity activity, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull String guildId, @NotNull String peerUid) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        View redPacketPanelForGuild = ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).getRedPacketPanelForGuild(activity, aioContext, guildId, peerUid);
        Intrinsics.checkNotNullExpressionValue(redPacketPanelForGuild, "api(IQWalletHbApi::class\u2026ontext, guildId, peerUid)");
        return redPacketPanelForGuild;
    }

    @Override // com.tencent.guild.api.wallet.IGuildWalletApi
    @NotNull
    public View createWalletContentView(@NotNull View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        View inflate = LayoutInflater.from(root.getContext()).inflate(R.layout.f168978hj2, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(root.context).infla\u2026uild_layout, null, false)");
        return inflate;
    }

    @Override // com.tencent.guild.api.wallet.IGuildWalletApi
    public void goToSendHbActivity(@NotNull Activity activity, @NotNull String guildId, @NotNull String peerUid) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).goToSendHbActivity(activity, guildId, peerUid);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.guild.api.wallet.IGuildWalletApi
    public void onPanelVisibilityChanged(@NotNull View panelView, boolean show) {
        com.tencent.mobileqq.qwallet.hb.b bVar;
        Intrinsics.checkNotNullParameter(panelView, "panelView");
        if (panelView instanceof com.tencent.mobileqq.qwallet.hb.b) {
            bVar = (com.tencent.mobileqq.qwallet.hb.b) panelView;
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return;
        }
        if (show) {
            bVar.onShow();
        } else {
            bVar.onHide();
        }
    }
}
