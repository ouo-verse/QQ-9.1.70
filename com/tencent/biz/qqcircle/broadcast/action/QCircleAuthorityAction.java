package com.tencent.biz.qqcircle.broadcast.action;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleAuthorityAction extends QCircleBaseBroadcastAction {
    @Override // com.tencent.biz.qqcircle.broadcast.action.QCircleBaseBroadcastAction
    public String a() {
        return QCircleHostConstants._InvitationWebViewPlugin.AUTHORITY_ACTION();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        QCircleBindPhoneNumberHelper.c(true);
    }
}
