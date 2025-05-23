package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.gs;
import com.xiaomi.push.hi;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static int f388081a;

    public static MiPushCommandMessage a(String str, List<String> list, long j3, String str2, String str3, List<String> list2) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j3);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        miPushCommandMessage.setAutoMarkPkgs(list2);
        return miPushCommandMessage;
    }

    public static MiPushMessage b(hi hiVar, gs gsVar, boolean z16) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.setMessageId(hiVar.m414a());
        if (!TextUtils.isEmpty(hiVar.d())) {
            miPushMessage.setMessageType(1);
            miPushMessage.setAlias(hiVar.d());
        } else if (!TextUtils.isEmpty(hiVar.c())) {
            miPushMessage.setMessageType(2);
            miPushMessage.setTopic(hiVar.c());
        } else if (!TextUtils.isEmpty(hiVar.f())) {
            miPushMessage.setMessageType(3);
            miPushMessage.setUserAccount(hiVar.f());
        } else {
            miPushMessage.setMessageType(0);
        }
        miPushMessage.setCategory(hiVar.e());
        if (hiVar.a() != null) {
            miPushMessage.setContent(hiVar.a().c());
        }
        if (gsVar != null) {
            if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(gsVar.m341a());
            }
            if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(gsVar.m346b());
            }
            miPushMessage.setDescription(gsVar.d());
            miPushMessage.setTitle(gsVar.m349c());
            miPushMessage.setNotifyType(gsVar.a());
            miPushMessage.setNotifyId(gsVar.c());
            miPushMessage.setPassThrough(gsVar.b());
            miPushMessage.setExtra(gsVar.m342a());
        }
        miPushMessage.setNotified(z16);
        return miPushMessage;
    }

    public static int c(Context context) {
        if (f388081a == 0) {
            if (e(context)) {
                g(1);
            } else {
                g(2);
            }
        }
        return f388081a;
    }

    private static boolean d(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean e(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return d(context, intent);
    }

    public static void f(Context context, MiPushCommandMessage miPushCommandMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra(RemoteMessageConst.MSGTYPE, 3);
        intent.putExtra("key_command", miPushCommandMessage);
        new PushServiceReceiver().onReceive(context, intent);
    }

    private static void g(int i3) {
        f388081a = i3;
    }
}
