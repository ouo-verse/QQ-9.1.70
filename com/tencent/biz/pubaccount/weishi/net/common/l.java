package com.tencent.biz.pubaccount.weishi.net.common;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi.net.WeishiIntent;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes32.dex */
public class l extends MSFServlet {
    private String a(g gVar) {
        return gVar.getRequestCmd();
    }

    private void b(Packet packet, WeishiIntent weishiIntent, g gVar) {
        byte[] encode = gVar.encode();
        if (encode == null) {
            x.f("[WSService][Servlet]", "[MSFServlet.java][handlePacket] request encode result is null.cmd=" + gVar.getReqUniKey());
            encode = new byte[4];
        }
        long longExtra = weishiIntent.getLongExtra("timeout", 30000L);
        packet.setTimeout(longExtra);
        x.f("[WSService][Servlet]", "[MSFServlet.java][handlePacket]request = " + gVar.getCmdString() + "; timeout:" + longExtra);
        String a16 = a(gVar);
        packet.setSSOCommand(a16);
        x.i("[WSService][Servlet]", "[MSFServlet.java][handlePacket]sso cmd: " + a16);
        gVar.reqSize = (long) encode.length;
        packet.putSendData(encode);
        gVar.getTimeRecord().v();
        if (gVar.isNeedLaunchCalculator()) {
            f10.b.f397582a.k();
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        x.f("[WSService][Servlet]", "[MSFServlet.java][onReceive]");
        if (!(intent instanceof WeishiIntent)) {
            x.f("[WSService][Servlet]", "[MSFServlet.java][onReceive] intent is null");
            return;
        }
        BusinessObserver observer = ((WeishiIntent) intent).getObserver();
        if (observer != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("response", fromServiceMsg);
            observer.onReceive(0, true, bundle);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (intent == null) {
            x.f("[WSService][Servlet]", "[MSFServlet.java][onSend] request is null");
            return;
        }
        try {
            if (intent instanceof WeishiIntent) {
                WeishiIntent weishiIntent = (WeishiIntent) intent;
                b(packet, weishiIntent, ((d) weishiIntent.getObserver()).f());
            } else {
                x.f("[WSService][Servlet]", "[MSFServlet.java][onSend] request instanceod WeishiIntent is false");
            }
        } catch (Exception e16) {
            x.f("[WSService][Servlet]", "[MSFServlet.java][onSend] occur exception.Exception detail=" + Log.getStackTraceString(e16));
        }
    }
}
