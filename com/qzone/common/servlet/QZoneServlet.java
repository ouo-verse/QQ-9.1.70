package com.qzone.common.servlet;

import android.content.Intent;
import android.util.Log;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;
import xe.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneServlet extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (intent == null) {
            QZLog.e("QZoneServlet", "onSend request is null");
            return;
        }
        try {
            if (intent instanceof QZoneIntent) {
                QZoneTask qZoneTask = ((QZoneIntent) intent).f46120d;
                QZoneRequest qZoneRequest = qZoneTask.mRequest;
                byte[] encode = qZoneRequest.encode();
                if (encode == null) {
                    QZLog.e("QZoneServlet", "onSend request encode result is null.cmd=" + qZoneTask.mRequest.uniKey());
                    encode = new byte[4];
                }
                packet.setTimeout(30000L);
                packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + qZoneTask.mRequest.uniKey());
                qZoneRequest.reqSize = (long) encode.length;
                packet.putSendData(encode);
                QZLog.i("QZoneServlet", 1, "onSend request cmd=" + qZoneTask.mRequest.uniKey() + " is correct | appRuntime = " + MobileQQ.sMobileQQ.peekAppRuntime() + " | this = " + this);
            } else {
                QZLog.e("QZoneServlet", "onSend request instanceod QZoneIntent is false");
            }
            ((QZoneIntent) intent).f46120d.mRequest.startTime = System.currentTimeMillis();
        } catch (Exception e16) {
            QZLog.e("QZoneServlet", "onSend occur exception.Exception detail=" + Log.getStackTraceString(e16));
            b.f447841a.d(e16);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        QZoneTask qZoneTask;
        if (intent == null) {
            QZLog.e("QZoneServlet", "***onReceive request is null  | response = " + fromServiceMsg + " | appRuntime = " + MobileQQ.sMobileQQ.peekAppRuntime() + " | this = " + this);
            return;
        }
        if (!(intent instanceof QZoneIntent) || (qZoneTask = ((QZoneIntent) intent).f46120d) == null) {
            return;
        }
        qZoneTask.mRequest.onDataResponse(fromServiceMsg);
    }
}
