package com.vivo.push.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.vivo.push.d;
import com.vivo.push.e.b;
import com.vivo.push.i;
import com.vivo.push.util.aa;
import com.vivo.push.util.ab;
import com.vivo.push.util.u;
import com.vivo.push.v;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    public static void a(Context context, String str, v vVar) {
        boolean c16 = vVar.c();
        i a16 = i.a(context, c16 ? "com.vivo.vms.upstageservice" : "com.vivo.vms.aidlservice");
        boolean a17 = a16.a();
        if (TextUtils.isEmpty(vVar.a())) {
            vVar.a(context.getPackageName());
        }
        if (a17 && !"com.vivo.pushservice".equals(context.getPackageName())) {
            d dVar = new d(vVar.a(), str, new Bundle());
            vVar.a(dVar);
            if (a16.a(dVar.b())) {
                return;
            }
            u.b("CommandBridge", "send command error by aidl");
            u.c(context, "send command error by aidl");
        }
        Intent intent = new Intent("com.vivo.pushservice.action.METHOD");
        intent.setPackage(str);
        intent.setClassName(str, c16 ? "com.vivo.push.sdk.service.UpstageService" : "com.vivo.push.sdk.service.PushService");
        vVar.a(intent);
        try {
            a(context, intent);
        } catch (Exception e16) {
            u.a("CommandBridge", "CommandBridge startService exception: ", e16);
        }
    }

    public static void a(Context context, Intent intent) throws Exception {
        if (context != null) {
            try {
                context.startService(intent);
                return;
            } catch (Exception e16) {
                u.a("CommandBridge", "start service error", e16);
                intent.setComponent(null);
                context.sendBroadcast(intent);
                return;
            }
        }
        u.d("CommandBridge", "enter startService context is null");
        throw new Exception("context is null");
    }

    public static void a(Context context, v vVar, String str) {
        try {
            boolean d16 = aa.d(context, str);
            String str2 = d16 ? "com.vivo.pushservice.action.RECEIVE" : "com.vivo.pushclient.action.RECEIVE";
            if (!TextUtils.isEmpty(str)) {
                if (d16 || a(context, str2, str)) {
                    if (TextUtils.isEmpty(vVar.a())) {
                        vVar.a(context.getPackageName());
                    }
                    Intent intent = new Intent();
                    intent.setFlags(1048576);
                    if (!TextUtils.isEmpty(str2)) {
                        intent.setAction(str2);
                    }
                    intent.setPackage(str);
                    intent.setClassName(str, d16 ? "com.vivo.push.sdk.service.CommandService" : "com.vivo.push.sdk.service.CommandClientService");
                    intent.putExtra("security_avoid_pull", com.vivo.push.util.a.a(context).a("com.vivo.pushservice"));
                    vVar.b(intent);
                    intent.putExtra("command_type", "reflect_receiver");
                    intent.putExtra("security_avoid_pull_rsa", b.a().a(context).a("com.vivo.pushservice"));
                    intent.putExtra("security_avoid_rsa_public_key", ab.a(b.a().a(context).a()));
                    a(context, intent);
                    return;
                }
                return;
            }
            u.c(context, "\u6d88\u606f\u63a5\u53d7\u8005\u5305\u540d\u4e3a\u7a7a\uff01");
            throw new Exception("\u6d88\u606f\u63a5\u53d7\u8005\u5305\u540d\u4e3a\u7a7a\uff01");
        } catch (Exception e16) {
            u.a("CommandBridge", "CommandBridge sendCommandToClient exception", e16);
        }
    }

    private static boolean a(Context context, String str, String str2) {
        Intent intent = new Intent(str);
        intent.setPackage(str2);
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT);
            if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                return true;
            }
            u.b("CommandBridge", "action check error\uff1aaction>>" + str + ";pkgname>>" + str2);
            return false;
        } catch (Exception unused) {
            u.b("CommandBridge", "queryBroadcastReceivers error");
            return false;
        }
    }
}
