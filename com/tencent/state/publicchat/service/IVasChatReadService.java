package com.tencent.state.publicchat.service;

import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import kotlin.Metadata;
import xs4.b;
import xs4.c;
import xs4.d;
import xs4.e;
import xs4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\u0003\u001a\u00020\nH'\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/publicchat/service/IVasChatReadService;", "", "Lxs4/c;", "req", "Lcom/tencent/rapier/a;", "Lxs4/d;", "getPublicChatConfInfo", "Lxs4/e;", "Lxs4/f;", "listLatestMsgInfos", "Lxs4/a;", "Lxs4/b;", "batchGetMsgInfos", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasChatReadService {
    @Route(method = "BatchGetMsgInfos", service = "trpc.qmeta.public_chat_read_svr.ChatRead")
    a<b> batchGetMsgInfos(xs4.a req);

    @Route(method = "GetPublicChatConfInfo", service = "trpc.qmeta.public_chat_read_svr.ChatRead")
    a<d> getPublicChatConfInfo(c req);

    @Route(method = "ListLatestMsgInfos", service = "trpc.qmeta.public_chat_read_svr.ChatRead")
    a<f> listLatestMsgInfos(e req);
}
