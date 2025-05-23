package com.tencent.mobileqq.troop.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UsingTimeReportManager extends BroadcastReceiver implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f302482d;

    /* renamed from: e, reason: collision with root package name */
    private List<a> f302483e;

    /* renamed from: f, reason: collision with root package name */
    private IntentFilter f302484f;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public UsingTimeReportManager(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f302483e = new ArrayList();
        this.f302482d = appInterface;
        IntentFilter intentFilter = new IntentFilter();
        this.f302484f = intentFilter;
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        this.f302484f.addAction(IECScreenReceiver.ACTION_QQ_BACKGROUND);
        this.f302484f.addAction(IECScreenReceiver.ACTION_QQ_FOREGROUND);
        this.f302484f.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        try {
            BaseApplication app = appInterface.getApp();
            if (app != null) {
                app.registerReceiver(this, this.f302484f);
            }
        } catch (Exception e16) {
            QLog.e("UsingTimeReportManager", 1, "init," + e16.toString(), e16);
        }
    }

    private synchronized void b() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f302483e);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
    }

    private synchronized void c() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f302483e);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b();
        }
    }

    public synchronized void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f302483e);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).c();
        }
    }

    public synchronized void d(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            if (!this.f302483e.contains(aVar)) {
                this.f302483e.add(aVar);
            }
        }
    }

    public synchronized void e(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            if (this.f302483e.contains(aVar)) {
                this.f302483e.remove(aVar);
            }
        }
    }

    @Override // mqq.manager.Manager
    public synchronized void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f302483e.clear();
        try {
            BaseApplication app = this.f302482d.getApp();
            if (app != null) {
                app.unregisterReceiver(this);
            }
        } catch (Exception e16) {
            QLog.e("UsingTimeReportManager", 1, "unInit" + e16.toString(), e16);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String action = intent.getAction();
        if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
            b();
            return;
        }
        if (IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
            c();
            return;
        }
        if (IECScreenReceiver.ACTION_QQ_BACKGROUND.equals(action)) {
            b();
        } else if (IECScreenReceiver.ACTION_QQ_FOREGROUND.equals(action)) {
            c();
        } else if (NewIntent.ACTION_ACCOUNT_KICKED.equals(action)) {
            a();
        }
    }
}
