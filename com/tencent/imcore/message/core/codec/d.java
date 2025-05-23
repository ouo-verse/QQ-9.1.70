package com.tencent.imcore.message.core.codec;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import msf.msgsvc.msg_svc$RoutingHead;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface d<T extends AppInterface> {
    int a();

    boolean b();

    boolean c(msg_svc$RoutingHead msg_svc_routinghead, MessageRecord messageRecord, T t16);

    int getUinType();
}
