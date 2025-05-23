package com.qzone.detail.business.service;

import android.os.Handler;
import android.os.Message;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.proxy.feedcomponent.util.j;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends QZoneDetailService {
    @Override // com.qzone.detail.business.service.QZoneDetailService, com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        Handler handler;
        j.e("QZoneCommentDetailService", 1, "--onTaskResponse");
        if (qZoneTask == null || (handler = qZoneTask.getHandler()) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage(qZoneTask.mType);
        obtainMessage.obj = qZoneTask;
        handler.sendMessage(obtainMessage);
    }
}
