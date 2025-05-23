package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.a;
import com.xiaomi.push.service.r;
import jz4.c;

/* loaded from: classes28.dex */
public class PingReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        c.z(intent.getPackage() + " is the package name");
        if (XMPushService.m448e()) {
            return;
        }
        if (r.f389788o.equals(intent.getAction())) {
            if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                c.z("Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    a.i(context).j(intent2);
                    return;
                } catch (Exception e16) {
                    c.q(e16);
                    return;
                }
            }
            return;
        }
        c.m("cancel the old ping timer");
        Cdo.a();
    }
}
