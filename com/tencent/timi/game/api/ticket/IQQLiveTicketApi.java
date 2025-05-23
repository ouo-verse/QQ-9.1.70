package com.tencent.timi.game.api.ticket;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a2\u0006\u0002\u0010\tJ#\u0010\n\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a2\u0006\u0002\u0010\tJ!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/timi/game/api/ticket/IQQLiveTicketApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getPsKeysAsync", "", "domains", "", "", "callback", "Lcom/tencent/timi/game/api/ticket/PSKeyCallback;", "([Ljava/lang/String;Lcom/tencent/timi/game/api/ticket/PSKeyCallback;)V", "getPsKeysAsyncNoCache", "getPsKeysSync", "", "Lcom/tencent/timi/game/api/ticket/PSKey;", "([Ljava/lang/String;)Ljava/util/List;", "isPsKeyExpired", "", "domain", "timi-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes26.dex */
public interface IQQLiveTicketApi extends QRouteApi {
    void getPsKeysAsync(@NotNull String[] domains, @NotNull PSKeyCallback callback);

    void getPsKeysAsyncNoCache(@NotNull String[] domains, @NotNull PSKeyCallback callback);

    @NotNull
    List<PSKey> getPsKeysSync(@NotNull String[] domains);

    boolean isPsKeyExpired(@NotNull String domain);
}
