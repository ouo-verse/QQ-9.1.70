package com.epicgames.ue4.demonetwork;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class NetStateChangeReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private List<com.epicgames.ue4.demonetwork.a> f32590a = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final NetStateChangeReceiver f32591a = new NetStateChangeReceiver();
    }

    private void a(NetworkType networkType) {
        if (networkType == NetworkType.NETWORK_NO) {
            Iterator<com.epicgames.ue4.demonetwork.a> it = this.f32590a.iterator();
            while (it.hasNext()) {
                it.next().onNetDisconnected();
            }
        } else {
            Iterator<com.epicgames.ue4.demonetwork.a> it5 = this.f32590a.iterator();
            while (it5.hasNext()) {
                it5.next().onNetConnected(networkType);
            }
        }
    }

    public static void b(com.epicgames.ue4.demonetwork.a aVar) {
        if (aVar != null && !a.f32591a.f32590a.contains(aVar)) {
            a.f32591a.f32590a.add(aVar);
        }
    }

    public static void c(@NonNull Context context) {
        context.registerReceiver(a.f32591a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            a(b.b(context));
        }
    }
}
