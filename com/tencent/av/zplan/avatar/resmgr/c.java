package com.tencent.av.zplan.avatar.resmgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.av.zplan.avatar.resmgr.b;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f77332a;

    /* renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f77333b = null;

    /* renamed from: c, reason: collision with root package name */
    private BroadcastReceiver f77334c = null;

    /* renamed from: d, reason: collision with root package name */
    private b.d f77335d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.av.zplan.avatar.resmgr.b f77336e;

    /* renamed from: f, reason: collision with root package name */
    private b.d f77337f;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements b.d {
        a() {
        }

        @Override // com.tencent.av.zplan.avatar.resmgr.b.d
        public void a(AVAvatarResInfo aVAvatarResInfo, int i3, int i16) {
            if ((i16 & 2) > 0) {
                BaseApplicationImpl application = BaseApplicationImpl.getApplication();
                Intent intent = new Intent("ACTION_AV_AVATAR_RES_DOWNLOAD_RSP");
                intent.putExtra("ACTION_FIELD_RES_INFO", aVAvatarResInfo);
                intent.putExtra("ACTION_FIELD_RES_DOWNLOAD_PROGRESS", i3);
                application.sendBroadcast(intent);
            }
        }

        @Override // com.tencent.av.zplan.avatar.resmgr.b.d
        public void b(AVAvatarResInfo aVAvatarResInfo, int i3, int i16) {
            if (c.this.f77337f != null) {
                c.this.f77337f.b(aVAvatarResInfo, i3, 1);
            }
            if ((i16 & 2) > 0) {
                BaseApplicationImpl application = BaseApplicationImpl.getApplication();
                Intent intent = new Intent("ACTION_AV_AVATAR_RES_DOWNLOAD_RSP");
                intent.putExtra("ACTION_FIELD_RES_INFO", aVAvatarResInfo);
                intent.putExtra("ACTION_FIELD_RES_DOWNLOAD_STATE", i3);
                application.sendBroadcast(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !"ACTION_AV_AVATAR_RES_DOWNLOAD_REQ".equals(intent.getAction())) {
                return;
            }
            c.this.d((AVAvatarResInfo) intent.getSerializableExtra("ACTION_FIELD_RES_INFO"), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.av.zplan.avatar.resmgr.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0778c extends BroadcastReceiver {
        C0778c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !"ACTION_AV_AVATAR_RES_DOWNLOAD_RSP".equals(intent.getAction())) {
                return;
            }
            AVAvatarResInfo aVAvatarResInfo = (AVAvatarResInfo) intent.getSerializableExtra("ACTION_FIELD_RES_INFO");
            if (c.this.f77337f != null) {
                int intExtra = intent.getIntExtra("ACTION_FIELD_RES_DOWNLOAD_STATE", 0);
                if (intExtra != 0) {
                    c.this.f77337f.b(aVAvatarResInfo, intExtra, 2);
                }
                int intExtra2 = intent.getIntExtra("ACTION_FIELD_RES_DOWNLOAD_PROGRESS", -1);
                if (intExtra2 != -1) {
                    c.this.f77337f.a(aVAvatarResInfo, intExtra2, 2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.d dVar) {
        this.f77332a = true;
        this.f77335d = null;
        this.f77336e = null;
        this.f77337f = dVar;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        this.f77332a = BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface;
        QLog.i("AVAvatarResDownloaderOnMultiProcess", 1, "AVAvatarResDownloaderOnMultiProcess for " + application.getQQProcessName());
        if (this.f77332a) {
            a aVar = new a();
            this.f77335d = aVar;
            this.f77336e = new com.tencent.av.zplan.avatar.resmgr.b(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(AVAvatarResInfo aVAvatarResInfo, int i3) {
        return this.f77336e.e(aVAvatarResInfo, i3);
    }

    private void f() {
        this.f77333b = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_AV_AVATAR_RES_DOWNLOAD_REQ");
        BaseApplicationImpl.getApplication().registerReceiver(this.f77333b, intentFilter);
    }

    private void g() {
        this.f77334c = new C0778c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_AV_AVATAR_RES_DOWNLOAD_RSP");
        BaseApplicationImpl.getApplication().registerReceiver(this.f77334c, intentFilter);
    }

    private void i() {
        if (this.f77333b != null) {
            BaseApplicationImpl.getApplication().unregisterReceiver(this.f77333b);
            this.f77333b = null;
        }
    }

    private void j() {
        if (this.f77334c != null) {
            BaseApplicationImpl.getApplication().unregisterReceiver(this.f77334c);
            this.f77334c = null;
        }
    }

    public boolean c(AVAvatarResInfo aVAvatarResInfo) {
        if (this.f77332a) {
            return d(aVAvatarResInfo, 1);
        }
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        Intent intent = new Intent("ACTION_AV_AVATAR_RES_DOWNLOAD_REQ");
        intent.putExtra("ACTION_FIELD_RES_INFO", aVAvatarResInfo);
        application.sendBroadcast(intent);
        return true;
    }

    public void e() {
        if (this.f77332a) {
            f();
        } else {
            g();
        }
    }

    public void h() {
        if (this.f77332a) {
            i();
        } else {
            j();
        }
    }
}
