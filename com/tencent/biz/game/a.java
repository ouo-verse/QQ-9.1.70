package com.tencent.biz.game;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a extends MSFServlet {

    /* renamed from: d, reason: collision with root package name */
    private String[] f78553d = {"OnlinePush.ReqPush.GameStatusPush"};

    @Override // mqq.app.MSFServlet
    public String[] getPreferSSOCommands() {
        return this.f78553d;
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        b msfToWebViewConnector = SensorAPIJavaScript.getMsfToWebViewConnector();
        if (msfToWebViewConnector != null) {
            msfToWebViewConnector.e(intent, fromServiceMsg);
        } else if (QLog.isColorLevel()) {
            QLog.d("GamePushServlet", 2, "WebView not connect to msf");
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
    }
}
