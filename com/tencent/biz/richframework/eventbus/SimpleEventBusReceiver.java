package com.tencent.biz.richframework.eventbus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SimpleEventBusReceiver extends BroadcastReceiver {
    public static final String BROADCAST_RECEIVER_ACTION = RFWApplication.getApplication().getPackageName() + "_SimpleEventBusReceiver_DISPATCH_SIMPLE_BUS_EVENT";
    public static final String INTENT_KEY_DISPATCH_EVENT = "intent_key_dispatch_event";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (BROADCAST_RECEIVER_ACTION.equals(intent.getAction())) {
            SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent) intent.getSerializableExtra(INTENT_KEY_DISPATCH_EVENT));
        }
    }
}
