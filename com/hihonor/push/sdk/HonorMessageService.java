package com.hihonor.push.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.push.sdk.common.data.DownMsgType;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class HonorMessageService extends Service {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f36342c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final a f36343a;

    /* renamed from: b, reason: collision with root package name */
    public final Messenger f36344b;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.i("HonorMessageService", "handle message for broadcast.");
            Bundle data = message.getData();
            if (data != null) {
                Intent intent = new Intent();
                intent.putExtras(data);
                HonorMessageService honorMessageService = HonorMessageService.this;
                int i3 = HonorMessageService.f36342c;
                honorMessageService.a(intent);
            }
        }
    }

    public HonorMessageService() {
        a aVar = new a(Looper.getMainLooper());
        this.f36343a = aVar;
        this.f36344b = new Messenger(aVar);
    }

    public final void a(Intent intent) {
        try {
            if (TextUtils.equals(intent.getStringExtra(CGNonAgeReport.EVENT_TYPE), DownMsgType.RECEIVE_TOKEN)) {
                String stringExtra = intent.getStringExtra("push_token");
                Context a16 = l.f36402e.a();
                d dVar = d.f36363b;
                if (!TextUtils.equals(stringExtra, dVar.b(a16))) {
                    dVar.a(a16, stringExtra);
                }
                Log.i("HonorMessageService", "onNewToken");
                onNewToken(stringExtra);
            } else {
                Log.i("HonorMessageService", "parse remote data start.");
                a1 a17 = b.a(new q0(intent));
                com.hihonor.push.sdk.a aVar = new com.hihonor.push.sdk.a(this);
                a17.getClass();
                a17.a(new t0(o0.f36415c.f36416a, aVar));
            }
            Log.i("HonorMessageService", "dispatch message end.");
        } catch (Exception e16) {
            e16.getMessage();
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f36344b.getBinder();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i16) {
        super.onStartCommand(intent, i3, i16);
        Log.i("HonorMessageService", "handle message for service.");
        a(intent);
        return 2;
    }

    public void onMessageReceived(HonorPushDataMsg honorPushDataMsg) {
    }

    public void onNewToken(String str) {
    }
}
