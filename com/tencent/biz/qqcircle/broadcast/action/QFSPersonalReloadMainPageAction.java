package com.tencent.biz.qqcircle.broadcast.action;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqcircle.immersive.events.QFSPersonalDetailRefreshEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

/* loaded from: classes4.dex */
public class QFSPersonalReloadMainPageAction extends QCircleBaseBroadcastAction {
    @Override // com.tencent.biz.qqcircle.broadcast.action.QCircleBaseBroadcastAction
    public String a() {
        return "action_reload_get_main_page";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.hasExtra("uin")) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSPersonalDetailRefreshEvent(intent.getStringExtra("uin")));
        }
    }
}
