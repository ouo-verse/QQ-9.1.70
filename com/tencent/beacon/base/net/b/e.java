package com.tencent.beacon.base.net.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.RequiresPermission;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class e extends BroadcastReceiver implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static final List<a> f77726a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f77727b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f77728c = true;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f77729d = false;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();
    }

    public static void a(Context context, a aVar) {
        if (context == null) {
            com.tencent.beacon.base.util.c.b("[net] context == null!", new Object[0]);
            return;
        }
        List<a> list = f77726a;
        synchronized (list) {
            if (!list.contains(aVar)) {
                list.add(aVar);
            }
        }
        if (f77727b) {
            return;
        }
        context.registerReceiver(new e(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        f77727b = true;
    }

    private void b() {
        List<a> list = f77726a;
        synchronized (list) {
            Iterator<a> it = list.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f77728c) {
            this.f77728c = false;
        } else if (!this.f77729d) {
            com.tencent.beacon.a.b.a.a().a(this);
        }
    }

    @Override // java.lang.Runnable
    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public void run() {
        this.f77729d = true;
        if (d.d()) {
            com.tencent.beacon.base.util.c.d("[net] current network available!", new Object[0]);
            a();
        } else {
            com.tencent.beacon.base.util.c.d("[net] current network unavailable!", new Object[0]);
            b();
        }
        this.f77729d = false;
    }

    private void a() {
        List<a> list = f77726a;
        synchronized (list) {
            Iterator<a> it = list.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }
}
