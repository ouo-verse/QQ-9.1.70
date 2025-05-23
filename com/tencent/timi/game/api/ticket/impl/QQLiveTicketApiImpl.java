package com.tencent.timi.game.api.ticket.impl;

import com.tencent.timi.game.api.ticket.IQQLiveTicketApi;
import com.tencent.timi.game.api.ticket.PSKey;
import com.tencent.timi.game.api.ticket.PSKeyCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J#\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ#\u0010\r\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/api/ticket/impl/QQLiveTicketApiImpl;", "Lcom/tencent/timi/game/api/ticket/IQQLiveTicketApi;", "()V", "qqLiveTicketApiV2", "Lcom/tencent/timi/game/api/ticket/impl/QQLiveTicketApiV2Impl;", "getPsKeysAsync", "", "domains", "", "", "callback", "Lcom/tencent/timi/game/api/ticket/PSKeyCallback;", "([Ljava/lang/String;Lcom/tencent/timi/game/api/ticket/PSKeyCallback;)V", "getPsKeysAsyncNoCache", "getPsKeysSync", "", "Lcom/tencent/timi/game/api/ticket/PSKey;", "([Ljava/lang/String;)Ljava/util/List;", "isPsKeyExpired", "", "domain", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class QQLiveTicketApiImpl implements IQQLiveTicketApi {

    @NotNull
    private final QQLiveTicketApiV2Impl qqLiveTicketApiV2 = new QQLiveTicketApiV2Impl();

    @Override // com.tencent.timi.game.api.ticket.IQQLiveTicketApi
    public void getPsKeysAsync(@NotNull String[] domains, @NotNull PSKeyCallback callback) {
        Intrinsics.checkNotNullParameter(domains, "domains");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.qqLiveTicketApiV2.getPsKeysAsync(domains, callback);
    }

    @Override // com.tencent.timi.game.api.ticket.IQQLiveTicketApi
    public void getPsKeysAsyncNoCache(@NotNull String[] domains, @NotNull PSKeyCallback callback) {
        Intrinsics.checkNotNullParameter(domains, "domains");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.qqLiveTicketApiV2.getPsKeysAsyncNoCache(domains, callback);
    }

    @Override // com.tencent.timi.game.api.ticket.IQQLiveTicketApi
    @NotNull
    public List<PSKey> getPsKeysSync(@NotNull String[] domains) {
        Intrinsics.checkNotNullParameter(domains, "domains");
        return this.qqLiveTicketApiV2.getPsKeysSync(domains);
    }

    @Override // com.tencent.timi.game.api.ticket.IQQLiveTicketApi
    public boolean isPsKeyExpired(@NotNull String domain) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        return this.qqLiveTicketApiV2.isPsKeyExpired(domain);
    }
}
