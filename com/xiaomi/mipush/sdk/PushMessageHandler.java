package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.df;
import com.xiaomi.push.ed;
import com.xiaomi.push.fv;
import com.xiaomi.push.gj;
import com.xiaomi.push.ii;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes28.dex */
public class PushMessageHandler extends BaseService {

    /* renamed from: a, reason: collision with root package name */
    private static List<MiPushClient.b> f388007a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static List<MiPushClient.c> f388008b = new ArrayList();

    /* renamed from: a, reason: collision with other field name */
    private static ThreadPoolExecutor f24704a = new BaseThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public interface a extends Serializable {
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (Exception e16) {
            jz4.c.n("PushMessageHandler", e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b() {
        synchronized (f388007a) {
            f388007a.clear();
        }
    }

    private static void c(final Context context, final Intent intent) {
        String str;
        if (intent != null && !f24704a.isShutdown()) {
            f24704a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.PushMessageHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    PushMessageHandler.b(context, intent);
                }
            });
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("-->scheduleJob() fail, case");
        if (intent == null) {
            str = "0";
        } else {
            str = "1";
        }
        sb5.append(str);
        jz4.c.C("PushMessageHandler", sb5.toString());
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i3) {
        super.onStart(intent, i3);
        c(getApplicationContext(), intent);
    }

    protected static void b(Context context, Intent intent) {
        boolean z16;
        ResolveInfo resolveInfo;
        try {
            z16 = intent.getBooleanExtra("is_clicked_activity_call", false);
        } catch (Throwable th5) {
            jz4.c.n("PushMessageHandler", "intent unparcel error:" + th5);
            z16 = false;
        }
        try {
            jz4.c.p("PushMessageHandler", "-->onHandleIntent(): action=", intent.getAction());
            if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                gj gjVar = new gj();
                fv.d(gjVar, intent.getByteArrayExtra("mipush_payload"));
                jz4.c.x("PushMessageHandler", "PushMessageHandler.onHandleIntent " + gjVar.d());
                MiTinyDataClient.a(context, gjVar);
            } else if (1 == p.c(context)) {
                if (m297b()) {
                    jz4.c.A("PushMessageHandler", "receive a message before application calling initialize");
                    if (z16) {
                        b(context);
                        return;
                    }
                    return;
                }
                a b16 = af.e(context).b(intent);
                if (b16 != null) {
                    a(context, b16);
                }
            } else if (!"com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(context.getPackageName());
                intent2.putExtras(intent);
                try {
                    List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                    if (queryBroadcastReceivers != null) {
                        Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                        while (it.hasNext()) {
                            resolveInfo = it.next();
                            ActivityInfo activityInfo = resolveInfo.activityInfo;
                            if (activityInfo != null && activityInfo.packageName.equals(context.getPackageName()) && PushMessageReceiver.class.isAssignableFrom(ii.c(context, resolveInfo.activityInfo.name))) {
                                break;
                            }
                        }
                    }
                    resolveInfo = null;
                    if (resolveInfo != null) {
                        a(context, intent2, resolveInfo, z16);
                    } else {
                        jz4.c.A("PushMessageHandler", "cannot find the receiver to handler this message, check your manifest");
                        df.a(context).d(context.getPackageName(), intent, "11");
                    }
                } catch (Exception e16) {
                    jz4.c.o("PushMessageHandler", e16);
                    df.a(context).d(context.getPackageName(), intent, "9");
                }
            }
            if (!z16) {
            }
        } catch (Throwable th6) {
            try {
                jz4.c.o("PushMessageHandler", th6);
                df.a(context).d(context.getPackageName(), intent, "10");
            } finally {
                if (z16) {
                    b(context);
                }
            }
        }
    }

    public static void a(Context context, Intent intent) {
        jz4.c.x("PushMessageHandler", "addjob PushMessageHandler " + intent);
        if (intent != null) {
            c(context, intent);
            a(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(MiPushClient.c cVar) {
        synchronized (f388008b) {
            if (!f388008b.contains(cVar)) {
                f388008b.add(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(MiPushClient.b bVar) {
        synchronized (f388007a) {
            if (!f388007a.contains(bVar)) {
                f388007a.add(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a() {
        synchronized (f388008b) {
            f388008b.clear();
        }
    }

    private static void a(Context context, Intent intent, ResolveInfo resolveInfo, boolean z16) {
        try {
            MessageHandleService.a aVar = new MessageHandleService.a(intent, (PushMessageReceiver) ii.c(context, resolveInfo.activityInfo.name).newInstance());
            if (z16) {
                MessageHandleService.a(context.getApplicationContext(), aVar);
            } else {
                MessageHandleService.addJob(context.getApplicationContext(), aVar);
            }
            MessageHandleService.a(context, new Intent(context.getApplicationContext(), (Class<?>) MessageHandleService.class));
        } catch (Throwable th5) {
            jz4.c.q(th5);
        }
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a, reason: collision with other method in class */
    protected boolean mo298a() {
        ThreadPoolExecutor threadPoolExecutor = f24704a;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f24704a.getQueue().size() <= 0) ? false : true;
    }

    public static void a(Context context, a aVar) {
        if (aVar instanceof MiPushMessage) {
            a(context, (MiPushMessage) aVar);
            return;
        }
        if (aVar instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
            String command = miPushCommandMessage.getCommand();
            String str = null;
            if (ed.COMMAND_REGISTER.f24710a.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                return;
            }
            if (!ed.COMMAND_SET_ALIAS.f24710a.equals(command) && !ed.COMMAND_UNSET_ALIAS.f24710a.equals(command) && !ed.COMMAND_SET_ACCEPT_TIME.f24710a.equals(command)) {
                if (ed.COMMAND_SUBSCRIBE_TOPIC.f24710a.equals(command)) {
                    List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                    if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                        str = commandArguments2.get(0);
                    }
                    a(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                    return;
                }
                if (ed.COMMAND_UNSUBSCRIBE_TOPIC.f24710a.equals(command)) {
                    List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                    if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                        str = commandArguments3.get(0);
                    }
                    b(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                    return;
                }
                return;
            }
            a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
        }
    }

    private static void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("action_clicked_activity_finish");
            context.sendBroadcast(intent, t.a(context));
        } catch (Exception e16) {
            jz4.c.n("PushMessageHandler", "callback sync error" + e16);
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m297b() {
        return f388008b.isEmpty();
    }

    protected static void b(Context context, String str, long j3, String str2, String str3) {
        synchronized (f388008b) {
            for (MiPushClient.c cVar : f388008b) {
                if (a(str, cVar.a())) {
                    cVar.g(j3, str2, str3);
                }
            }
        }
    }

    public static void a(Context context, MiPushMessage miPushMessage) {
        synchronized (f388008b) {
            for (MiPushClient.c cVar : f388008b) {
                if (a(miPushMessage.getCategory(), cVar.a())) {
                    cVar.e(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    cVar.d(miPushMessage);
                }
            }
        }
    }

    public static void a(long j3, String str, String str2) {
        synchronized (f388008b) {
            Iterator<MiPushClient.c> it = f388008b.iterator();
            while (it.hasNext()) {
                it.next().c(j3, str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, String str, long j3, String str2, String str3) {
        synchronized (f388008b) {
            for (MiPushClient.c cVar : f388008b) {
                if (a(str, cVar.a())) {
                    cVar.f(j3, str2, str3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, String str, String str2, long j3, String str3, List<String> list) {
        synchronized (f388008b) {
            for (MiPushClient.c cVar : f388008b) {
                if (a(str, cVar.a())) {
                    cVar.b(str2, j3, str3, list);
                }
            }
        }
    }

    protected static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, MiPushCommandMessage miPushCommandMessage) {
        synchronized (f388007a) {
            for (MiPushClient.b bVar : f388007a) {
            }
        }
    }
}
