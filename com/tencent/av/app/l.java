package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.tencent.av.utils.at;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private VideoAppInterface f73180a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Integer> f73181b = null;

    /* renamed from: c, reason: collision with root package name */
    private a f73182c = null;

    /* renamed from: d, reason: collision with root package name */
    private d f73183d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (l.this.a() != null && intent != null) {
                long a16 = at.a(intent);
                String stringExtra = intent.getStringExtra("camera_id");
                int intExtra = intent.getIntExtra("availability", 1);
                l.this.d(stringExtra, intExtra);
                if (QLog.isColorLevel()) {
                    QLog.w("GCameraAvailabilityMonitor", 1, "CameraAvailabilityReceiver, id[" + stringExtra + "], available[" + intExtra + "], seq[" + a16 + "]");
                }
            }
        }
    }

    public l(VideoAppInterface videoAppInterface) {
        this.f73180a = videoAppInterface;
    }

    public synchronized Map<String, Integer> a() {
        return this.f73181b;
    }

    public void b() {
        if (this.f73181b == null) {
            this.f73181b = new HashMap();
        }
        if (this.f73182c == null) {
            if (QLog.isColorLevel()) {
                QLog.d("GCameraAvailabilityMonitor", 2, "register camera availability change receiver");
            }
            this.f73182c = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.qav.camera.availability");
            this.f73180a.getApplication().registerReceiver(this.f73182c, intentFilter);
        }
        if (QLog.isColorLevel()) {
            QLog.d("GCameraAvailabilityMonitor", 2, "register camera availability change callback");
        }
        if (!Build.VERSION.RELEASE.equalsIgnoreCase("7.1.2") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo x9")) {
            this.f73183d = new d();
            this.f73183d.a(this.f73180a.getApplication().getApplicationContext(), this.f73180a.getApplication().getPackageName(), ThreadManagerV2.getUIHandlerV2());
        }
    }

    public void c() {
        if (this.f73182c != null) {
            if (QLog.isColorLevel()) {
                QLog.d("GCameraAvailabilityMonitor", 2, "UnRegister camera availability change receiver");
            }
            try {
                this.f73180a.getApplication().unregisterReceiver(this.f73182c);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("GCameraAvailabilityMonitor", 2, "regist e = " + e16);
                }
            }
            this.f73182c = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GCameraAvailabilityMonitor", 2, "UnRegister camera availability change callback");
        }
        d dVar = this.f73183d;
        if (dVar != null) {
            dVar.b();
        }
    }

    public synchronized void d(String str, int i3) {
        this.f73181b.put(str, Integer.valueOf(i3));
    }
}
