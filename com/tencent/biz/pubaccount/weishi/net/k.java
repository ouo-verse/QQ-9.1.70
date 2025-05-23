package com.tencent.biz.pubaccount.weishi.net;

import android.content.Intent;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
@Deprecated
/* loaded from: classes32.dex */
public class k extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (intent == null) {
            Log.e("weishi", "onSend request is null");
            return;
        }
        try {
            if (intent instanceof WeishiIntent) {
                WeishiIntent weishiIntent = (WeishiIntent) intent;
                l lVar = weishiIntent.f80928d;
                j jVar = lVar.f80994g;
                byte[] encode = jVar.encode();
                if (encode == null) {
                    Log.e("weishi-Servlet", "onSend request encode result is null.cmd=" + lVar.f80994g.uniKey());
                    encode = new byte[4];
                }
                long longExtra = weishiIntent.getLongExtra("timeout", 30000L);
                packet.setTimeout(longExtra);
                x.f("weishi-Servlet", "request = " + lVar.f80994g.getCmdString() + "; timeout:" + longExtra);
                String a16 = a(jVar, jVar.getRequestCmd());
                packet.setSSOCommand(a16);
                Log.i("weishi-Servlet", "SSO\u547d\u4ee4\u5b57: " + a16);
                jVar.J = (long) encode.length;
                packet.putSendData(encode);
                Log.i("weishi-Servlet", "onSend request cmd=" + lVar.f80994g.uniKey() + " is correct");
            } else {
                Log.e("weishi-Servlet", "onSend request instanceod WeishiIntent is false");
            }
            ((WeishiIntent) intent).f80928d.f80994g.F = System.currentTimeMillis();
        } catch (Exception e16) {
            Log.e("weishi-Servlet", "onSend occur exception.Exception detail=" + Log.getStackTraceString(e16));
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        l lVar;
        if (intent == null) {
            Log.e("weishi", "***onReceive request is null");
        } else {
            if (!(intent instanceof WeishiIntent) || (lVar = ((WeishiIntent) intent).f80928d) == null) {
                return;
            }
            lVar.f80994g.onDataResponse(fromServiceMsg);
        }
    }

    private String a(j jVar, String str) {
        return str;
    }
}
