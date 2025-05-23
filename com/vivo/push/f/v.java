package com.vivo.push.f;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes13.dex */
public final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InsideNotificationItem f387697a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.q f387698b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ u f387699c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, InsideNotificationItem insideNotificationItem, com.vivo.push.b.q qVar) {
        this.f387699c = uVar;
        this.f387697a = insideNotificationItem;
        this.f387698b = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        char c16;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        u uVar = this.f387699c;
        PushMessageCallback pushMessageCallback = ((aa) uVar).f387661b;
        context = ((com.vivo.push.s) uVar).f387838a;
        NotifyArriveCallbackByUser onNotificationMessageArrived = pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.v.a(this.f387697a));
        int a16 = this.f387699c.a(onNotificationMessageArrived);
        if (a16 > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put(com.heytap.mcssdk.a.a.f36093c, String.valueOf(this.f387698b.f()));
            String a17 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a17)) {
                hashMap.put("remoteAppId", a17);
            }
            context9 = ((com.vivo.push.s) this.f387699c).f387838a;
            context10 = ((com.vivo.push.s) this.f387699c).f387838a;
            hashMap.put("clientsdkver", String.valueOf(com.vivo.push.util.ag.c(context9, context10.getPackageName())));
            com.vivo.push.util.f.a(a16, (HashMap<String, String>) hashMap);
            return;
        }
        int b16 = this.f387699c.b();
        if (b16 <= 0) {
            context2 = ((com.vivo.push.s) this.f387699c).f387838a;
            InsideNotificationItem insideNotificationItem = this.f387697a;
            long f16 = this.f387698b.f();
            u uVar2 = this.f387699c;
            PushMessageCallback pushMessageCallback2 = ((aa) uVar2).f387661b;
            context3 = ((com.vivo.push.s) uVar2).f387838a;
            com.vivo.push.util.p pVar = new com.vivo.push.util.p(context2, insideNotificationItem, f16, pushMessageCallback2.isAllowNet(context3), new w(this), onNotificationMessageArrived);
            boolean isShowBigPicOnMobileNet = this.f387697a.isShowBigPicOnMobileNet();
            String purePicUrl = this.f387697a.getPurePicUrl();
            if (TextUtils.isEmpty(purePicUrl)) {
                purePicUrl = this.f387697a.getCoverUrl();
            }
            if (!TextUtils.isEmpty(purePicUrl)) {
                com.vivo.push.util.u.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(isShowBigPicOnMobileNet)));
                if (!isShowBigPicOnMobileNet) {
                    context5 = ((com.vivo.push.s) this.f387699c).f387838a;
                    com.vivo.push.util.u.a(context5, "mobile net unshow");
                    context6 = ((com.vivo.push.s) this.f387699c).f387838a;
                    NetworkInfo a18 = com.vivo.push.util.x.a(context6);
                    if (a18 == null || a18.getState() != NetworkInfo.State.CONNECTED) {
                        c16 = 0;
                    } else {
                        int type = NetworkMonitor.getType(a18);
                        if (type == 1) {
                            c16 = 2;
                        } else if (type == 0) {
                            c16 = 1;
                        } else {
                            c16 = 3;
                        }
                    }
                    if (c16 == 1) {
                        this.f387697a.clearCoverUrl();
                        this.f387697a.clearPurePicUrl();
                        purePicUrl = null;
                    }
                } else {
                    context4 = ((com.vivo.push.s) this.f387699c).f387838a;
                    com.vivo.push.util.u.a(context4, "mobile net show");
                }
            }
            pVar.execute(this.f387697a.getIconUrl(), purePicUrl);
            return;
        }
        StringBuilder sb5 = new StringBuilder("pkg name : ");
        context7 = ((com.vivo.push.s) this.f387699c).f387838a;
        sb5.append(context7.getPackageName());
        sb5.append(" notify channel switch is ");
        sb5.append(b16);
        com.vivo.push.util.u.b("OnNotificationArrivedTask", sb5.toString());
        context8 = ((com.vivo.push.s) this.f387699c).f387838a;
        com.vivo.push.util.u.b(context8, "\u5141\u8bb8\u901a\u77e5\u5f00\u5173\u6216\u8005\u63a8\u9001\u901a\u77e5\u6e20\u9053\u5f00\u5173\u5173\u95ed\uff0c\u5bfc\u81f4\u901a\u77e5\u65e0\u6cd5\u5c55\u793a\uff0c\u8bf7\u5230\u8bbe\u7f6e\u9875\u6253\u5f00\u5e94\u7528\u901a\u77e5\u5f00\u5173 ".concat(String.valueOf(b16)));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(com.heytap.mcssdk.a.a.f36093c, String.valueOf(this.f387698b.f()));
        String a19 = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(a19)) {
            hashMap2.put("remoteAppId", a19);
        }
        com.vivo.push.util.f.a(b16, (HashMap<String, String>) hashMap2);
    }
}
