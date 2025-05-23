package com.tencent.mobileqq.intervideo.groupvideo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.intervideo.yiqikan.c f238176a = new C7942a();

    /* renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f238177b = new b();

    /* renamed from: c, reason: collision with root package name */
    private List<com.tencent.mobileqq.intervideo.yiqikan.b> f238178c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private List<com.tencent.mobileqq.intervideo.yiqikan.b> f238179d = new ArrayList();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.intervideo.groupvideo.a$a, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    class C7942a implements com.tencent.mobileqq.intervideo.yiqikan.c {
        C7942a() {
        }

        @Override // com.tencent.mobileqq.intervideo.yiqikan.c
        public void a(NewTogetherRoomMessageData newTogetherRoomMessageData) {
            QLog.i("GroupVideoManager|Communicate", 2, "receive closeWatchTogether: " + newTogetherRoomMessageData.toString());
            a.this.m(newTogetherRoomMessageData, 2);
        }

        @Override // com.tencent.mobileqq.intervideo.yiqikan.c
        public void b(NewTogetherRoomMessageData newTogetherRoomMessageData) {
            QLog.i("GroupVideoManager|Communicate", 2, "receive switchWatchTogether: " + newTogetherRoomMessageData.toString());
            a.this.m(newTogetherRoomMessageData, 3);
        }

        @Override // com.tencent.mobileqq.intervideo.yiqikan.c
        public void c(NewTogetherRoomMessageData newTogetherRoomMessageData) {
            QLog.i("GroupVideoManager|Communicate", 2, "receive startWatchTogether: " + newTogetherRoomMessageData.toString());
            a.this.m(newTogetherRoomMessageData, 1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("command_type", 0);
            QLog.i("GroupVideoManager|Communicate", 2, "get message from plugin: " + intent.getExtras());
            if (intExtra == 1) {
                a aVar = a.this;
                aVar.k(intent, aVar.f238178c);
            } else if (intExtra == 2) {
                a aVar2 = a.this;
                aVar2.k(intent, aVar2.f238179d);
            } else {
                if (intExtra != 3) {
                    return;
                }
                a.this.l(intent);
            }
        }
    }

    private QQAppInterface f() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    private Intent g() {
        Intent intent = new Intent();
        intent.setAction("com.tencent.gvideo.message.communicate.qq2gvideo");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Intent intent, List<com.tencent.mobileqq.intervideo.yiqikan.b> list) {
        String str;
        if (list.isEmpty()) {
            return;
        }
        int intExtra = intent.getIntExtra("callback_return_code", 0);
        String stringExtra = intent.getStringExtra("callback_return_message");
        Iterator<com.tencent.mobileqq.intervideo.yiqikan.b> it = this.f238178c.iterator();
        while (it.hasNext()) {
            it.next().callback(intExtra, stringExtra);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("receive ");
        if (list == this.f238178c) {
            str = "close";
        } else {
            str = "open";
        }
        sb5.append(str);
        sb5.append(" room message ");
        sb5.append(intExtra);
        sb5.append(" ");
        sb5.append(stringExtra);
        QLog.i("GroupVideoManager|Communicate", 2, sb5.toString());
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Intent intent) {
        QQAppInterface f16 = f();
        if (f16 == null) {
            return;
        }
        com.tencent.mobileqq.intervideo.yiqikan.h hVar = (com.tencent.mobileqq.intervideo.yiqikan.h) f16.getManager(QQManagerFactory.WATCH_LIVE_TOGETHER);
        NewTogetherRoomMessageData newTogetherRoomMessageData = new NewTogetherRoomMessageData();
        newTogetherRoomMessageData.f238445e = intent.getStringExtra("closeRoomGroupOwnerUin");
        newTogetherRoomMessageData.f238444d = intent.getStringExtra("closeRoomGroupUin");
        hVar.o(intent.getStringExtra("closeRoomFrom"), newTogetherRoomMessageData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(NewTogetherRoomMessageData newTogetherRoomMessageData, int i3) {
        Intent g16 = g();
        g16.putExtra("command_type", i3);
        g16.putExtra("togetherRoomMessageData", newTogetherRoomMessageData);
        n(g16);
    }

    private void n(Intent intent) {
        QQAppInterface f16 = f();
        if (f16 == null) {
            return;
        }
        f16.getApp().sendBroadcast(intent);
    }

    public com.tencent.mobileqq.intervideo.yiqikan.c h() {
        return this.f238176a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(QQAppInterface qQAppInterface) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.gvideo.message.communicate.gvideo2qq");
        qQAppInterface.getApp().registerReceiver(this.f238177b, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Bundle bundle, com.tencent.mobileqq.intervideo.yiqikan.b bVar) {
        Intent g16 = g();
        g16.putExtra("command_type", 4);
        g16.putExtra("closeRoomBundle", bundle);
        n(g16);
        this.f238178c.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        QQAppInterface f16 = f();
        if (f16 == null) {
            return;
        }
        try {
            f16.getApp().unregisterReceiver(this.f238177b);
        } catch (Exception e16) {
            QLog.d("GroupVideoManager|Communicate", 1, "unInit exception " + e16.getMessage());
        }
        this.f238179d.clear();
        this.f238178c.clear();
    }
}
