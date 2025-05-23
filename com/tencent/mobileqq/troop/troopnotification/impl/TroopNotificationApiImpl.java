package com.tencent.mobileqq.troop.troopnotification.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.troop.troopnotification.ITroopNotificationApi;
import com.tencent.mobileqq.troop.troopnotification.push.TroopNotification0x210PushHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import ot2.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/impl/TroopNotificationApiImpl;", "Lcom/tencent/mobileqq/troop/troopnotification/ITroopNotificationApi;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/parser/av;", "getTroopNotificationParserClass", "", "data", "", "handle0x210Push", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopNotificationApiImpl implements ITroopNotificationApi {
    @Override // com.tencent.mobileqq.troop.troopnotification.ITroopNotificationApi
    public Class<av> getTroopNotificationParserClass() {
        return b.class;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.ITroopNotificationApi
    public void handle0x210Push(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface != null) {
            TroopNotification0x210PushHandler.f300681a.e(qQAppInterface, data);
        }
    }
}
