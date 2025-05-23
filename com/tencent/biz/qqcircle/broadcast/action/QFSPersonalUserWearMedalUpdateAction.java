package com.tencent.biz.qqcircle.broadcast.action;

import android.content.Context;
import android.content.Intent;
import com.tencent.ark.ark;
import com.tencent.biz.qqcircle.immersive.events.QFSPersonalUserMedalRefreshEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

/* loaded from: classes4.dex */
public class QFSPersonalUserWearMedalUpdateAction extends QCircleBaseBroadcastAction {
    @Override // com.tencent.biz.qqcircle.broadcast.action.QCircleBaseBroadcastAction
    public String a() {
        return "action_user_wearing_medal_update";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.hasExtra(ark.ARKMETADATA_JSON)) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSPersonalUserMedalRefreshEvent(intent.getStringExtra(ark.ARKMETADATA_JSON)));
        }
    }
}
