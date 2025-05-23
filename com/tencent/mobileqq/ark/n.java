package com.tencent.mobileqq.ark;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.ark.aio.BaseArkAppContainer;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.utils.cl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class n {

    /* renamed from: d, reason: collision with root package name */
    private static volatile n f199582d;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<QQAppInterface> f199583a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f199584b = false;

    /* renamed from: c, reason: collision with root package name */
    private a f199585c = null;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public BaseArkAppContainer f199586a;

        /* renamed from: b, reason: collision with root package name */
        public long f199587b;

        /* renamed from: c, reason: collision with root package name */
        public String f199588c;

        /* renamed from: d, reason: collision with root package name */
        public String f199589d;

        /* renamed from: e, reason: collision with root package name */
        public int f199590e;

        /* renamed from: f, reason: collision with root package name */
        public String f199591f;

        /* renamed from: g, reason: collision with root package name */
        public String f199592g;

        /* renamed from: h, reason: collision with root package name */
        public String f199593h;

        /* renamed from: i, reason: collision with root package name */
        public WeakReference<ArkTipsBar> f199594i = null;

        public a(BaseArkAppContainer baseArkAppContainer, long j3, String str, String str2, int i3, String str3, String str4, String str5) {
            b(baseArkAppContainer, j3, str, str2, i3, str3, str4, str5);
        }

        boolean a(BaseArkAppContainer baseArkAppContainer, long j3) {
            if (this.f199586a == baseArkAppContainer && this.f199587b == j3) {
                return false;
            }
            return true;
        }

        public void b(BaseArkAppContainer baseArkAppContainer, long j3, String str, String str2, int i3, String str3, String str4, String str5) {
            this.f199586a = baseArkAppContainer;
            this.f199587b = j3;
            this.f199588c = str;
            this.f199589d = str2;
            this.f199590e = i3;
            this.f199591f = str3;
            this.f199592g = str4;
            this.f199593h = str5;
        }
    }

    protected n() {
    }

    private void a(BaseArkAppContainer baseArkAppContainer) {
        if (baseArkAppContainer == null) {
            return;
        }
        baseArkAppContainer.attachFromStatusBar();
    }

    private void b(BaseArkAppContainer baseArkAppContainer, boolean z16) {
        if (baseArkAppContainer == null) {
            return;
        }
        baseArkAppContainer.detachFromStatusBar();
        if (z16) {
            baseArkAppContainer.doOnEvent(2);
        }
    }

    public static n c() {
        if (f199582d == null) {
            synchronized (n.class) {
                if (f199582d == null) {
                    f199582d = new n();
                }
            }
        }
        return f199582d;
    }

    private void i(com.tencent.aio.api.runtime.a aVar, long j3) {
        if (aVar == null) {
            QLog.e("ArkTipsManagerNew", 1, "aioContext is null");
        } else {
            aVar.e().h(new ArkTipsShowEvent(this.f199585c.f199591f, j3));
        }
    }

    public void d(com.tencent.aio.api.runtime.a aVar) {
        if (aVar == null) {
            QLog.e("ArkTipsManagerNew", 1, "aioContext is null");
            return;
        }
        aVar.e().h(new ArkTipsHideEvent());
        this.f199584b = false;
        this.f199583a = null;
    }

    public void g(com.tencent.aio.api.runtime.a aVar) {
        d(aVar);
    }

    public void h(AppInterface appInterface, String str, String str2) {
        if (appInterface != null && !cl.a(appInterface.getApp())) {
            QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(appInterface.getApp());
            Intent intent = new Intent();
            intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, 239);
            builder.setSmallIcon(R.drawable.b8f).setWhen(System.currentTimeMillis()).setContentTitle(str).setContentText(str2).setContentIntent(PendingIntent.getActivity(appInterface.getApp(), 0, intent, 167772160));
            Notification build = builder.build();
            build.flags = 16;
            qQNotificationManager.notify("ArkTipsManagerNew", 239, build);
        }
    }

    public void j(BaseArkAppContainer baseArkAppContainer, MsgRecord msgRecord, String str, QQAppInterface qQAppInterface) {
        Object obj;
        boolean z16;
        com.tencent.qqnt.msg.data.a parseArkMsgModelFromMsgRecord = ArkMsgUtils.parseArkMsgModelFromMsgRecord(msgRecord);
        if (parseArkMsgModelFromMsgRecord == null) {
            return;
        }
        long msgId = msgRecord.getMsgId();
        String peerUid = msgRecord.getPeerUid();
        if (TextUtils.isEmpty(peerUid)) {
            return;
        }
        Object myContext = baseArkAppContainer.getMyContext();
        if (!(myContext instanceof com.tencent.aio.api.runtime.a)) {
            return;
        }
        this.f199583a = new WeakReference<>(qQAppInterface);
        String peerName = msgRecord.getPeerName();
        int chatType = msgRecord.getChatType();
        String d16 = parseArkMsgModelFromMsgRecord.d();
        String e16 = parseArkMsgModelFromMsgRecord.e();
        a aVar = this.f199585c;
        if (aVar == null) {
            obj = myContext;
            z16 = true;
            this.f199585c = new a(baseArkAppContainer, msgId, peerUid, peerName, chatType, str, d16, e16);
        } else {
            obj = myContext;
            z16 = true;
            if (aVar.a(baseArkAppContainer, msgId)) {
                BaseArkAppContainer baseArkAppContainer2 = this.f199585c.f199586a;
                if (baseArkAppContainer2 != baseArkAppContainer && baseArkAppContainer2 != null) {
                    b(baseArkAppContainer2, !TextUtils.equals(r1.f199588c, peerUid));
                }
                this.f199585c.b(baseArkAppContainer, msgId, peerUid, peerName, chatType, str, d16, e16);
            }
        }
        a(baseArkAppContainer);
        this.f199585c.f199591f = str;
        i((com.tencent.aio.api.runtime.a) obj, msgId);
        g.b(qQAppInterface, d16, "AIOStatusBarShow", 0, 0, 0L, 0L, 0L, "", "");
        this.f199584b = z16;
    }

    public void f() {
    }

    public void e(com.tencent.aio.api.runtime.a aVar) {
    }
}
