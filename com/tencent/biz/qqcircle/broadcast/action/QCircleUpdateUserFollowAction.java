package com.tencent.biz.qqcircle.broadcast.action;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.utils.z;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.relation.QCircleRelationGroupManager;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleUpdateUserFollowAction extends QCircleBaseBroadcastAction {
    @Override // com.tencent.biz.qqcircle.broadcast.action.QCircleBaseBroadcastAction
    public String a() {
        return "action_update_native_user_follow_state";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("uin");
        int intExtra = intent.getIntExtra("type", -1);
        if (!TextUtils.isEmpty(stringExtra) && intExtra != -1) {
            boolean z16 = true;
            QLog.d("QCircleUpdateUserFollowAction", 1, "updateFollowManager uin:" + stringExtra + " type:" + intExtra);
            if (intExtra != 1) {
                z16 = false;
            }
            QCircleFollowManager.getInstance().setUinFollowed(stringExtra, intExtra);
            SimpleEventBus.getInstance().dispatchEvent(new QCircleFollowUpdateEvent(intExtra, stringExtra));
            QCircleRelationGroupManager.instance().updateFollowFriendListToDB(stringExtra, intent.getStringExtra("nick"), z16);
            z.d(stringExtra, intExtra);
        }
    }
}
