package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.gamecenter.wadl.api.impl.QQGameReportServiceImpl;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.df;
import com.xiaomi.push.ed;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MessageHandleService extends BaseService {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentLinkedQueue<a> f387974a = new ConcurrentLinkedQueue<>();

    /* renamed from: a, reason: collision with other field name */
    private static ExecutorService f24702a = new BaseThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private PushMessageReceiver f387978a;

        /* renamed from: b, reason: collision with root package name */
        private Intent f387979b;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f387978a = pushMessageReceiver;
            this.f387979b = intent;
        }

        public Intent a() {
            return this.f387979b;
        }

        public PushMessageReceiver b() {
            return this.f387978a;
        }
    }

    public static void addJob(Context context, a aVar) {
        if (aVar != null) {
            f387974a.add(aVar);
            b(context);
            startService(context);
        }
    }

    private static void b(final Context context) {
        if (!f24702a.isShutdown()) {
            f24702a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.MessageHandleService.2
                @Override // java.lang.Runnable
                public void run() {
                    MessageHandleService.c(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        try {
            a(context, f387974a.poll());
        } catch (RuntimeException e16) {
            jz4.c.q(e16);
        }
    }

    public static void startService(final Context context) {
        final Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) MessageHandleService.class));
        com.xiaomi.push.ae.b(context).g(new Runnable() { // from class: com.xiaomi.mipush.sdk.MessageHandleService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    context.startService(intent);
                } catch (Exception e16) {
                    jz4.c.m(e16.getMessage());
                }
            }
        });
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i3) {
        super.onStart(intent, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        b(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, a aVar) {
        String[] stringArrayExtra;
        if (aVar == null) {
            return;
        }
        try {
            PushMessageReceiver b16 = aVar.b();
            Intent a16 = aVar.a();
            int intExtra = a16.getIntExtra(RemoteMessageConst.MSGTYPE, 1);
            if (intExtra != 1) {
                if (intExtra != 3) {
                    if (intExtra == 5 && "error_lack_of_permission".equals(a16.getStringExtra(QQGameReportServiceImpl.ATTA_KEY_ERROR_TYPE)) && (stringArrayExtra = a16.getStringArrayExtra("error_message")) != null) {
                        jz4.c.D("begin execute onRequirePermissions, lack of necessary permissions");
                        b16.onRequirePermissions(context, stringArrayExtra);
                        return;
                    }
                    return;
                }
                MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) a16.getSerializableExtra("key_command");
                jz4.c.D("(Local) begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                b16.onCommandResult(context, miPushCommandMessage);
                if (TextUtils.equals(miPushCommandMessage.getCommand(), ed.COMMAND_REGISTER.f24710a)) {
                    b16.onReceiveRegisterResult(context, miPushCommandMessage);
                    PushMessageHandler.a(context, miPushCommandMessage);
                    if (miPushCommandMessage.getResultCode() == 0) {
                        f.l(context);
                        return;
                    }
                    return;
                }
                return;
            }
            PushMessageHandler.a b17 = af.e(context).b(a16);
            int intExtra2 = a16.getIntExtra("eventMessageType", -1);
            if (b17 != null) {
                if (b17 instanceof MiPushMessage) {
                    MiPushMessage miPushMessage = (MiPushMessage) b17;
                    if (!miPushMessage.isArrivedMessage()) {
                        b16.onReceiveMessage(context, miPushMessage);
                    }
                    if (miPushMessage.getPassThrough() == 1) {
                        df.a(context.getApplicationContext()).c(context.getPackageName(), a16, 2004, null);
                        jz4.c.C("MessageHandleService", "begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                        b16.onReceivePassThroughMessage(context, miPushMessage);
                        return;
                    }
                    if (miPushMessage.isNotified()) {
                        if (intExtra2 == 1000) {
                            df.a(context.getApplicationContext()).c(context.getPackageName(), a16, 1007, null);
                        } else {
                            df.a(context.getApplicationContext()).c(context.getPackageName(), a16, 3007, null);
                        }
                        jz4.c.C("MessageHandleService", "begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                        b16.onNotificationMessageClicked(context, miPushMessage);
                        return;
                    }
                    jz4.c.C("MessageHandleService", "begin execute onNotificationMessageArrived from " + miPushMessage.getMessageId());
                    b16.onNotificationMessageArrived(context, miPushMessage);
                    return;
                }
                if (b17 instanceof MiPushCommandMessage) {
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) b17;
                    jz4.c.C("MessageHandleService", "begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                    b16.onCommandResult(context, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.getCommand(), ed.COMMAND_REGISTER.f24710a)) {
                        b16.onReceiveRegisterResult(context, miPushCommandMessage2);
                        PushMessageHandler.a(context, miPushCommandMessage2);
                        if (miPushCommandMessage2.getResultCode() == 0) {
                            f.l(context);
                            return;
                        }
                        return;
                    }
                    return;
                }
                jz4.c.C("MessageHandleService", "unknown raw message: " + b17);
                return;
            }
            jz4.c.C("MessageHandleService", "no message from raw for receiver");
        } catch (RuntimeException e16) {
            jz4.c.o("MessageHandleService", e16);
        }
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    protected boolean mo298a() {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = f387974a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }
}
