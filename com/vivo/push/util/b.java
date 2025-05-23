package com.vivo.push.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.security.PublicKey;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected String f387887a;

    /* renamed from: b, reason: collision with root package name */
    protected long f387888b;

    /* renamed from: c, reason: collision with root package name */
    protected Context f387889c;

    /* renamed from: d, reason: collision with root package name */
    protected NotifyArriveCallbackByUser f387890d;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Intent intent, Context context) {
        try {
            intent.putExtra("security_avoid_pull", a.a(context).a("com.vivo.pushservice"));
            String a16 = com.vivo.push.e.b.a().a(context).a("com.vivo.pushservice");
            PublicKey a17 = com.vivo.push.e.b.a().a(context).a();
            if (TextUtils.isEmpty(a16)) {
                a16 = "com.vivo.pushservice";
            }
            intent.putExtra("security_avoid_pull_rsa", a16);
            intent.putExtra("security_avoid_rsa_public_key", a17 == null ? "com.vivo.pushservice" : ab.a(a17));
        } catch (Exception e16) {
            u.a("BaseNotifyClickIntentParam", "pushNotificationBySystem encrypt \uff1a" + e16.getMessage());
            intent.putExtra("security_avoid_pull_rsa", "com.vivo.pushservice");
            intent.putExtra("security_avoid_rsa_public_key", "com.vivo.pushservice");
        }
    }

    protected abstract int a();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract PendingIntent a(Context context, Intent intent);

    protected abstract Intent a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser);

    public final long b() {
        return this.f387888b;
    }

    public final Intent a(Context context, String str, long j3, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        this.f387888b = j3;
        this.f387887a = str;
        this.f387889c = context;
        this.f387890d = notifyArriveCallbackByUser;
        Intent a16 = a(context, insideNotificationItem, notifyArriveCallbackByUser);
        int a17 = a();
        if (a17 <= 0) {
            return a16;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(com.heytap.mcssdk.a.a.f36093c, String.valueOf(this.f387888b));
        String a18 = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(a18)) {
            hashMap.put("remoteAppId", a18);
        }
        hashMap.put("ap", this.f387887a);
        hashMap.put("clientsdkver", String.valueOf(ag.c(this.f387889c, this.f387887a)));
        f.a(a17, (HashMap<String, String>) hashMap);
        return null;
    }

    public static Intent a(Context context, String str, long j3, Intent intent, InsideNotificationItem insideNotificationItem) {
        Intent intent2 = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent2.setPackage(context.getPackageName());
        intent2.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        intent2.putExtra("command_type", "reflect_receiver");
        intent2.putExtras(intent.getExtras());
        a(intent2, context);
        com.vivo.push.b.p pVar = new com.vivo.push.b.p(str, j3, insideNotificationItem);
        pVar.b(intent.getAction());
        if (intent.getComponent() != null) {
            pVar.c(intent.getComponent().getPackageName());
            pVar.d(intent.getComponent().getClassName());
        }
        if (intent.getData() != null) {
            pVar.a(intent.getData());
        }
        pVar.b(intent2);
        return intent2;
    }
}
