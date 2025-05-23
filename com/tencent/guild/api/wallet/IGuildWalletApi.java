package com.tencent.guild.api.wallet;

import android.app.Activity;
import android.view.View;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\bH&J(\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H&J \u0010\u0017\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H&J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\bH&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/guild/api/wallet/IGuildWalletApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/view/View;", "root", "createWalletContentView", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "contentView", "", "inGuildLive", "Lcom/tencent/guild/api/wallet/a;", "createGuildWalletHolder", "play", "", "changeGuildWalletApngState", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "guildId", "peerUid", "createRedPacketPanel", "goToSendHbActivity", "panelView", "show", "onPanelVisibilityChanged", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes6.dex */
public interface IGuildWalletApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ com.tencent.guild.api.wallet.a a(IGuildWalletApi iGuildWalletApi, GuildMsgItem guildMsgItem, View view, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                return iGuildWalletApi.createGuildWalletHolder(guildMsgItem, view, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createGuildWalletHolder");
        }
    }

    void changeGuildWalletApngState(boolean play);

    @NotNull
    com.tencent.guild.api.wallet.a createGuildWalletHolder(@NotNull GuildMsgItem msgItem, @Nullable View contentView, boolean inGuildLive);

    @NotNull
    View createRedPacketPanel(@NotNull Activity activity, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull String guildId, @NotNull String peerUid);

    @NotNull
    View createWalletContentView(@NotNull View root);

    void goToSendHbActivity(@NotNull Activity activity, @NotNull String guildId, @NotNull String peerUid);

    void onPanelVisibilityChanged(@NotNull View panelView, boolean show);
}
