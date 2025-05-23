package com.tencent.now.od.logic.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: P */
/* loaded from: classes22.dex */
public class NetworkManager {

    /* renamed from: h, reason: collision with root package name */
    private static NetworkManager f338507h = new NetworkManager();

    /* renamed from: a, reason: collision with root package name */
    private Logger f338508a = LoggerFactory.getLogger((Class<?>) NetworkManager.class);

    /* renamed from: b, reason: collision with root package name */
    private volatile int f338509b = 0;

    /* renamed from: c, reason: collision with root package name */
    private volatile String f338510c = "null";

    /* renamed from: d, reason: collision with root package name */
    private List<b> f338511d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    private Handler f338512e = new Handler(Looper.getMainLooper());

    /* renamed from: f, reason: collision with root package name */
    private BroadcastReceiver f338513f = new a();

    /* renamed from: g, reason: collision with root package name */
    private Context f338514g;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkManager.this.h();
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface b {
        void a(int i3);
    }

    NetworkManager() {
        BaseApplication context = BaseApplication.getContext();
        this.f338514g = context;
        context.registerReceiver(this.f338513f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public static NetworkManager d() {
        return f338507h;
    }

    private int e(String[] strArr) {
        NetworkInfo activeNetworkInfo;
        strArr[0] = "null";
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f338514g.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        strArr[0] = NetworkMonitor.getTypeName(activeNetworkInfo);
        int type = NetworkMonitor.getType(activeNetworkInfo);
        if (type != 0) {
            if (type == 1) {
                return 1;
            }
            if (type != 9) {
                return 6;
            }
            return 5;
        }
        switch (NetworkMonitor.getSubtype(activeNetworkInfo)) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 3;
            case 13:
                return 4;
            case 16:
            default:
                return 6;
        }
    }

    private void f(final int i3) {
        this.f338512e.post(new Runnable() { // from class: com.tencent.now.od.logic.core.NetworkManager.2
            @Override // java.lang.Runnable
            public void run() {
                for (int size = NetworkManager.this.f338511d.size() - 1; size >= 0; size--) {
                    b bVar = (b) NetworkManager.this.f338511d.get(size);
                    if (bVar != null) {
                        bVar.a(i3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        String[] strArr = new String[1];
        int e16 = e(strArr);
        this.f338510c = strArr[0];
        if (this.f338509b != e16) {
            this.f338509b = e16;
            this.f338508a.info("network changed to : " + e16);
            f(e16);
        }
    }

    public void c(b bVar) {
        if (bVar != null && !this.f338511d.contains(bVar)) {
            this.f338511d.add(bVar);
            h();
        }
    }

    public void g(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f338511d.remove(bVar);
    }
}
