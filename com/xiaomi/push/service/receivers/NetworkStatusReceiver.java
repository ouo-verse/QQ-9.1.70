package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.ac;
import com.xiaomi.mipush.sdk.ag;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.h;
import com.xiaomi.mipush.sdk.i;
import com.xiaomi.mipush.sdk.s;
import com.xiaomi.mipush.sdk.v;
import com.xiaomi.push.au;
import com.xiaomi.push.fo;
import com.xiaomi.push.ie;
import com.xiaomi.push.service.a;
import jz4.c;

/* compiled from: P */
/* loaded from: classes28.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f389800a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f389801b = true;

    public NetworkStatusReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (this.f389801b) {
            return;
        }
        au.r();
        ie.e().post(new Runnable() { // from class: com.xiaomi.push.service.receivers.NetworkStatusReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                NetworkStatusReceiver.this.a(context);
            }
        });
    }

    public static boolean a() {
        return f389800a;
    }

    public NetworkStatusReceiver(Object obj) {
        f389800a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (!ag.h(context).J() && s.c(context).s() && !s.c(context).x()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                a.i(context).j(intent);
            } catch (Exception e16) {
                c.q(e16);
            }
        }
        fo.h(context);
        if (au.t(context) && ag.h(context).P()) {
            ag.h(context).R();
        }
        if (au.t(context)) {
            if ("syncing".equals(ac.b(context).c(v.DISABLE_PUSH))) {
                MiPushClient.t(context);
            }
            if ("syncing".equals(ac.b(context).c(v.ENABLE_PUSH))) {
                MiPushClient.u(context);
            }
            ac b16 = ac.b(context);
            v vVar = v.UPLOAD_HUAWEI_TOKEN;
            if ("syncing".equals(b16.c(vVar))) {
                ag.h(context).E(null, vVar, d.ASSEMBLE_PUSH_HUAWEI, "net");
            }
            if ("syncing".equals(ac.b(context).c(v.UPLOAD_FCM_TOKEN))) {
                ag.h(context).E(null, vVar, d.ASSEMBLE_PUSH_HUAWEI, "net");
            }
            ac b17 = ac.b(context);
            v vVar2 = v.UPLOAD_COS_TOKEN;
            if ("syncing".equals(b17.c(vVar2))) {
                ag.h(context).E(null, vVar2, d.ASSEMBLE_PUSH_COS, "net");
            }
            ac b18 = ac.b(context);
            v vVar3 = v.UPLOAD_FTOS_TOKEN;
            if ("syncing".equals(b18.c(vVar3))) {
                ag.h(context).E(null, vVar3, d.ASSEMBLE_PUSH_FTOS, "net");
            }
            if (i.a() && i.d(context)) {
                i.c(context);
                i.b(context);
            }
            b.a(context);
            h.b(context);
        }
    }
}
