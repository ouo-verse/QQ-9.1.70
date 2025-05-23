package com.tencent.timi.game.smoba.impl.config;

import com.tencent.mobileqq.pb.MessageMicro;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.GameDataServerOuterClass$GetSmobaConfigReq;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends pl4.a {
    public static NewIntent d() {
        return a.C11028a.a(new MessageMicro<GameDataServerOuterClass$GetSmobaConfigReq>() { // from class: trpc.yes.common.GameDataServerOuterClass$GetSmobaConfigReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GameDataServerOuterClass$GetSmobaConfigReq.class);
        }, a.class);
    }

    @Override // pl4.a
    protected int b() {
        return 307;
    }
}
