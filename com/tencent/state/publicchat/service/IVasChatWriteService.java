package com.tencent.state.publicchat.service;

import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import kotlin.Metadata;
import zs4.b;
import zs4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/publicchat/service/IVasChatWriteService;", "", "Lzs4/b;", "req", "Lcom/tencent/rapier/a;", "Lzs4/c;", SmsPlugin.API_SEND_SMS, "Lzs4/a;", "sendAuditMsg", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasChatWriteService {
    @Route(method = "SendAuditMsg", service = "trpc.qmeta.public_chat_write_svr.ChatWrite")
    a<Object> sendAuditMsg(zs4.a req);

    @Route(method = "SendMsg", service = "trpc.qmeta.public_chat_write_svr.ChatWrite")
    a<c> sendMsg(b req);
}
