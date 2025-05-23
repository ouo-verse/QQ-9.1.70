package com.tencent.sqshow.zootopia.usercenter.account;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/account/ZplanEventLogout;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "acountChangeMsg", "", "(Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZplanEventLogout extends SimpleBaseEvent {
    public ZplanEventLogout(String acountChangeMsg) {
        Intrinsics.checkNotNullParameter(acountChangeMsg, "acountChangeMsg");
    }
}
