package com.tencent.mobileqq.qrscan.ipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrscan.g;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a implements g, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Context f276650d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f276651e;

    /* renamed from: f, reason: collision with root package name */
    private g.a f276652f;

    /* renamed from: h, reason: collision with root package name */
    private BroadcastReceiver f276653h;

    /* renamed from: i, reason: collision with root package name */
    private String f276654i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qrscan.ipc.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C8443a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        C8443a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            if (QLog.isColorLevel()) {
                QLog.d("PreCallUpToolProc", 2, String.format("onReceive action=%s", action));
            }
            if ("com.tencent.mobileqq.armap.ACTION_START_THREAD_COMPLETED".equals(action) && TextUtils.equals(intent.getStringExtra("from"), a.this.f276654i)) {
                if (a.this.f276651e != null) {
                    a.this.f276651e.removeMessages(108);
                }
                if (a.this.f276652f != null) {
                    a.this.f276652f.a();
                }
            }
        }
    }

    public a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f276650d = context;
        this.f276651e = new Handler(this);
        e();
    }

    private void e() {
        if (this.f276653h == null) {
            this.f276653h = new C8443a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.armap.ACTION_START_THREAD_COMPLETED");
            this.f276650d.registerReceiver(this.f276653h, intentFilter);
        }
    }

    private void g() {
        BroadcastReceiver broadcastReceiver = this.f276653h;
        if (broadcastReceiver != null) {
            this.f276650d.unregisterReceiver(broadcastReceiver);
            this.f276653h = null;
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        g();
        Handler handler = this.f276651e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f276651e = null;
        }
        this.f276650d = null;
        this.f276652f = null;
    }

    public void f(String str, long j3, g.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PreCallUpToolProc", 2, String.format("callUpToolProc from=%s", str));
        }
        this.f276652f = aVar;
        this.f276654i = str;
        Intent intent = new Intent(this.f276650d, (Class<?>) ARMapThreadStubReceiver.class);
        intent.setAction("com.tencent.mobileqq.armap.ACTION_START_THREAD");
        intent.putExtra("from", str);
        this.f276650d.sendBroadcast(intent);
        Handler handler = this.f276651e;
        if (handler != null) {
            handler.removeMessages(108);
            this.f276651e.sendEmptyMessageDelayed(108, j3);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        g.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 108 && (aVar = this.f276652f) != null) {
            aVar.a();
            return true;
        }
        return true;
    }
}
