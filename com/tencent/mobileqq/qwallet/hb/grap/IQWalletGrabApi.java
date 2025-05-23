package com.tencent.mobileqq.qwallet.hb.grap;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRemote;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H'JB\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH'J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H'JB\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH'J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH'J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH'\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/grap/IQWalletGrabApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getGuildAvatarUrl", "", "guildId", "tinyId", "getGuildAvatarUrls", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "requestCode", "", "tinyIds", "", "getGuildNick", "getGuildNicks", "initGuildObserver", "", "removeAllGuildCallback", "qqpay-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletGrabApi extends QRouteApi {
    @QRemote
    @Nullable
    String getGuildAvatarUrl(@NotNull String guildId, @NotNull String tinyId);

    @QRemote
    @NotNull
    HashMap<String, String> getGuildAvatarUrls(int requestCode, @NotNull String guildId, @NotNull List<String> tinyIds);

    @QRemote
    @NotNull
    String getGuildNick(@NotNull String guildId, @NotNull String tinyId);

    @QRemote
    @NotNull
    HashMap<String, String> getGuildNicks(int requestCode, @NotNull String guildId, @NotNull List<String> tinyIds);

    @QRemote
    void initGuildObserver(@NotNull String guildId, int requestCode);

    @QRemote
    void removeAllGuildCallback(int requestCode);
}
