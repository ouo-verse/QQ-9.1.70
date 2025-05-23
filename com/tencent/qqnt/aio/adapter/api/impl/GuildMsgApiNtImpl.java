package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IGuildMsgApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JZ\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2>\u0010\t\u001a:\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\u0004\u0018\u0001`\u000fH\u0016Jm\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2S\u0010\t\u001aO\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012j\u0004\u0018\u0001`\u0014H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/GuildMsgApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IGuildMsgApi;", "()V", "setGProGuildMsgRead", "", "guildId", "", "chatType", "", "cb", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "result", "errMsg", "Lcom/tencent/qqnt/aio/adapter/api/ISetGProGuildMsgReadCallback;", "setGuildUnNotifyFlag", "unNotifyType", "Lkotlin/Function3;", "needNotice", "Lcom/tencent/qqnt/aio/adapter/api/ISetGProGuildMessageNotifyCallback;", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class GuildMsgApiNtImpl implements IGuildMsgApi {
    static IPatchRedirector $redirector_;

    public GuildMsgApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildMsgApi
    public void setGProGuildMsgRead(@Nullable String guildId, int chatType, @Nullable Function2<? super Integer, ? super String, Unit> cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, guildId, Integer.valueOf(chatType), cb5);
        } else if (cb5 != null) {
            cb5.invoke(0, "");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildMsgApi
    public void setGuildUnNotifyFlag(@NotNull String guildId, int unNotifyType, @Nullable Function3<? super Integer, ? super String, ? super Integer, Unit> cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, guildId, Integer.valueOf(unNotifyType), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (cb5 != null) {
            cb5.invoke(0, "", 0);
        }
    }
}
