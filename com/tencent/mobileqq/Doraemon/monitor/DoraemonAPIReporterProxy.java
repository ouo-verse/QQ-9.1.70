package com.tencent.mobileqq.Doraemon.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.Doraemon.g;
import com.tencent.mobileqq.Doraemon.monitor.a;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.HashMap;

/* loaded from: classes9.dex */
public class DoraemonAPIReporterProxy implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    a.InterfaceC7087a f154252a;

    /* renamed from: b, reason: collision with root package name */
    BroadcastReceiver f154253b;

    public DoraemonAPIReporterProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d() {
        if (this.f154253b == null) {
            synchronized (this) {
                if (this.f154253b == null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("com.tencent.mobileqq.Doraemon.monitor.update");
                    intentFilter.addAction("com.tencent.mobileqq.Doraemon.monitor.update_batch");
                    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterProxy.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DoraemonAPIReporterProxy.this);
                            }
                        }

                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                                return;
                            }
                            a.InterfaceC7087a interfaceC7087a = DoraemonAPIReporterProxy.this.f154252a;
                            if (interfaceC7087a == null) {
                                return;
                            }
                            String action = intent.getAction();
                            if ("com.tencent.mobileqq.Doraemon.monitor.update".equals(action)) {
                                String stringExtra = intent.getStringExtra("key");
                                int intExtra = intent.getIntExtra("type", 0);
                                String stringExtra2 = intent.getStringExtra("appid");
                                String stringExtra3 = intent.getStringExtra(DTConstants.TAG.API);
                                long longExtra = intent.getLongExtra("remain", 0L);
                                long longExtra2 = intent.getLongExtra("time", 0L);
                                if (QLog.isColorLevel()) {
                                    QLog.d("DoraemonOpenAPI.report", 2, "receive update key=" + stringExtra + ", api=" + stringExtra3 + ", remain=" + longExtra + ", exp=" + longExtra2);
                                }
                                ThreadManager.getUIHandler().post(new Runnable(interfaceC7087a, stringExtra, intExtra, stringExtra2, stringExtra3, longExtra, longExtra2) { // from class: com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterProxy.1.1
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ long C;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ a.InterfaceC7087a f154255d;

                                    /* renamed from: e, reason: collision with root package name */
                                    final /* synthetic */ String f154256e;

                                    /* renamed from: f, reason: collision with root package name */
                                    final /* synthetic */ int f154257f;

                                    /* renamed from: h, reason: collision with root package name */
                                    final /* synthetic */ String f154258h;

                                    /* renamed from: i, reason: collision with root package name */
                                    final /* synthetic */ String f154259i;

                                    /* renamed from: m, reason: collision with root package name */
                                    final /* synthetic */ long f154260m;

                                    {
                                        this.f154255d = interfaceC7087a;
                                        this.f154256e = stringExtra;
                                        this.f154257f = intExtra;
                                        this.f154258h = stringExtra2;
                                        this.f154259i = stringExtra3;
                                        this.f154260m = longExtra;
                                        this.C = longExtra2;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass1.this, interfaceC7087a, stringExtra, Integer.valueOf(intExtra), stringExtra2, stringExtra3, Long.valueOf(longExtra), Long.valueOf(longExtra2));
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                        } else {
                                            this.f154255d.a(this.f154256e, this.f154257f, this.f154258h, this.f154259i, this.f154260m, this.C);
                                        }
                                    }
                                });
                                return;
                            }
                            if ("com.tencent.mobileqq.Doraemon.monitor.update_batch".equals(action)) {
                                String stringExtra4 = intent.getStringExtra("key");
                                intent.getIntExtra("type", 0);
                                intent.getStringExtra("appid");
                                try {
                                    HashMap hashMap = (HashMap) intent.getSerializableExtra("map");
                                    if (QLog.isColorLevel()) {
                                        QLog.d("DoraemonOpenAPI.report", 2, "receive update all key=" + stringExtra4);
                                    }
                                    ThreadManager.getUIHandler().post(new Runnable(interfaceC7087a, stringExtra4, hashMap) { // from class: com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterProxy.1.2
                                        static IPatchRedirector $redirector_;

                                        /* renamed from: d, reason: collision with root package name */
                                        final /* synthetic */ a.InterfaceC7087a f154261d;

                                        /* renamed from: e, reason: collision with root package name */
                                        final /* synthetic */ String f154262e;

                                        /* renamed from: f, reason: collision with root package name */
                                        final /* synthetic */ HashMap f154263f;

                                        {
                                            this.f154261d = interfaceC7087a;
                                            this.f154262e = stringExtra4;
                                            this.f154263f = hashMap;
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass1.this, interfaceC7087a, stringExtra4, hashMap);
                                            }
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                            } else {
                                                this.f154261d.b(this.f154262e, this.f154263f);
                                            }
                                        }
                                    });
                                } catch (ClassCastException unused) {
                                    QLog.e("DoraemonOpenAPI.report", 1, "illegal data");
                                }
                            }
                        }
                    };
                    BaseApplication.getContext().registerReceiver(broadcastReceiver, intentFilter, "com.tencent.msg.permission.pushnotify", null);
                    this.f154253b = broadcastReceiver;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.monitor.a
    public void a(a.InterfaceC7087a interfaceC7087a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) interfaceC7087a);
        } else {
            this.f154252a = interfaceC7087a;
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.monitor.a
    public void b(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2);
            return;
        }
        d();
        Bundle bundle = new Bundle();
        bundle.putString("key", str);
        bundle.putInt("type", i3);
        bundle.putString("appid", str2);
        g.b(2, bundle, null);
    }

    @Override // com.tencent.mobileqq.Doraemon.monitor.a
    public void c(String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2, str3);
            return;
        }
        d();
        Bundle bundle = new Bundle();
        bundle.putString("key", str);
        bundle.putInt("type", i3);
        bundle.putString("appid", str2);
        bundle.putString(DTConstants.TAG.API, str3);
        g.b(3, bundle, null);
    }
}
