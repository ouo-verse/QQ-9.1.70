package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.zplan.web.impl.JsbL2NEvent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/ZootopiaLuaToH5ManagerImpl;", "Lcom/tencent/mobileqq/zootopia/ipc/y;", "", AdMetricTag.EVENT_NAME, "params", "Lcom/tencent/mobileqq/zootopia/ipc/ah;", "callback", "", "sendLuaEventToH5", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaLuaToH5ManagerImpl implements y {
    public static final String TAG = "ZootopiaLuaToH5ManagerImpl";

    @Override // com.tencent.mobileqq.zootopia.ipc.y
    public void sendLuaEventToH5(String eventName, String params, ah callback) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i(TAG, 1, "sendLuaEventToH5 :: eventName == " + eventName + " , params == " + params);
        SimpleEventBus.getInstance().dispatchEvent(new JsbL2NEvent(eventName, params));
    }
}
