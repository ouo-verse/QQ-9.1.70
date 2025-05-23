package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.qqnt.aio.adapter.api.IGuildMsgApi;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import vh2.cz;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JZ\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2>\u0010\t\u001a:\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\u0004\u0018\u0001`\u000fH\u0016Jm\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2S\u0010\t\u001aO\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012j\u0004\u0018\u0001`\u0014H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/GuildMsgApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IGuildMsgApi;", "()V", "setGProGuildMsgRead", "", "guildId", "", "chatType", "", "cb", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "result", "errMsg", "Lcom/tencent/qqnt/aio/adapter/api/ISetGProGuildMsgReadCallback;", "setGuildUnNotifyFlag", "unNotifyType", "Lkotlin/Function3;", "needNotice", "Lcom/tencent/qqnt/aio/adapter/api/ISetGProGuildMessageNotifyCallback;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class GuildMsgApiImpl implements IGuildMsgApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IGuildMsgApi
    public void setGProGuildMsgRead(String guildId, int chatType, final Function2<? super Integer, ? super String, Unit> cb5) {
        GProContact gProContact = new GProContact(chatType, guildId, guildId);
        uh2.c gProGuildMsgService = ((IGProSession) bz.b(IGProSession.class)).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.clearGuildReadSceneV2(gProContact, 11, new IGuildOperateCallback() { // from class: com.tencent.qqnt.aio.adapter.api.impl.ap
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i3, String str) {
                    GuildMsgApiImpl.setGProGuildMsgRead$lambda$0(Function2.this, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildMsgApi
    public void setGuildUnNotifyFlag(String guildId, int unNotifyType, final Function3<? super Integer, ? super String, ? super Integer, Unit> cb5) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).setGuildUnNotifyFlag(guildId, unNotifyType, new cz() { // from class: com.tencent.qqnt.aio.adapter.api.impl.ao
            @Override // vh2.cz
            public final void a(int i3, String str, int i16) {
                GuildMsgApiImpl.setGuildUnNotifyFlag$lambda$1(Function3.this, i3, str, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setGProGuildMsgRead$lambda$0(Function2 function2, int i3, String errMsg) {
        if (function2 != null) {
            Integer valueOf = Integer.valueOf(i3);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            function2.invoke(valueOf, errMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setGuildUnNotifyFlag$lambda$1(Function3 function3, int i3, String errMsg, int i16) {
        if (function3 != null) {
            Integer valueOf = Integer.valueOf(i3);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            function3.invoke(valueOf, errMsg, Integer.valueOf(i16));
        }
    }
}
