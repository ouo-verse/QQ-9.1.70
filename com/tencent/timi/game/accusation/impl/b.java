package com.tencent.timi.game.accusation.impl;

import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.SafeOuterClass$QQGetUserSafeSercetReq;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends pl4.a {
    public static NewIntent d(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        SafeOuterClass$QQGetUserSafeSercetReq safeOuterClass$QQGetUserSafeSercetReq = new SafeOuterClass$QQGetUserSafeSercetReq();
        safeOuterClass$QQGetUserSafeSercetReq.qq_user_id.set(commonOuterClass$QQUserId);
        return a.C11028a.a(safeOuterClass$QQGetUserSafeSercetReq, b.class);
    }

    @Override // pl4.a
    protected int b() {
        return 1002;
    }
}
