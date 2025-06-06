package com.huawei.hms.support.api.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.huawei.hms.push.c;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.i;
import com.huawei.hms.push.u;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HmsMsgService extends Service {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public Context f37562a;

        public a(Context context) {
            this.f37562a = context;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            if (Objects.equals(this.f37562a.getApplicationContext().getPackageManager().getNameForUid(message.sendingUid), HMSPackageManager.getInstance(this.f37562a).getHMSPackageName()) && data != null) {
                if (HMSPackageManager.getInstance(this.f37562a).getHMSPackageStates() != PackageManagerHelper.PackageStates.ENABLED) {
                    HMSLog.i("HmsMsgService", "service not start by hms");
                } else {
                    HMSLog.i("HmsMsgService", "chose push type");
                    if (Objects.equals(c.b(data, "push_action"), "com.huawei.push.msg.NOTIFY_MSG")) {
                        if (ResourceLoaderUtil.getmContext() == null) {
                            ResourceLoaderUtil.setmContext(this.f37562a.getApplicationContext());
                        }
                        HMSLog.i("HmsMsgService", "invokeSelfShow");
                        HmsMsgService.c(this.f37562a, data);
                    } else if (Objects.equals(c.b(data, "push_action"), "com.huawei.push.msg.PASSBY_MSG")) {
                        HMSLog.i("HmsMsgService", "sendBroadcastToHms");
                        HmsMsgService.d(this.f37562a, data);
                    }
                }
            }
            super.handleMessage(message);
        }
    }

    public static void c(Context context, Bundle bundle) {
        if (!u.a(context)) {
            HMSLog.i("HmsMsgService", context.getPackageName() + " disable display notification.");
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
        intent.putExtra("selfshow_info", c.a(bundle, "selfshow_info"));
        intent.putExtra("selfshow_token", c.a(bundle, "selfshow_token"));
        intent.setPackage(c.c(bundle, "push_package"));
        i.a(context, intent);
        HMSLog.i("HmsMsgService", "invokeSelfShow done");
    }

    public static void d(Context context, Bundle bundle) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.huawei.android.push.intent.RECEIVE");
            intent.putExtra("msg_data", c.a(bundle, "msg_data"));
            intent.putExtra(RemoteMessageConst.DEVICE_TOKEN, c.a(bundle, RemoteMessageConst.DEVICE_TOKEN));
            intent.putExtra("msgIdStr", c.c(bundle, "msgIdStr"));
            intent.setFlags(32);
            intent.setPackage(c.c(bundle, "push_package"));
            StringBuilder sb5 = new StringBuilder();
            sb5.append(context.getPackageName());
            sb5.append(".permission.PROCESS_PUSH_MSG");
            context.sendBroadcast(intent, sb5.toString());
            HMSLog.i("HmsMsgService", "send broadcast passby done");
        } catch (SecurityException unused) {
            HMSLog.i("HmsMsgService", "send broadcast SecurityException");
        } catch (Exception unused2) {
            HMSLog.i("HmsMsgService", "send broadcast Exception");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        HMSLog.i("HmsMsgService", "onBind");
        return new Messenger(new a(this)).getBinder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        HMSLog.i("HmsMsgService", "Enter onStartCommand.");
        return 2;
    }
}
