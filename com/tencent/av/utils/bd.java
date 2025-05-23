package com.tencent.av.utils;

import android.content.Context;
import android.net.wifi.WifiManager;

/* compiled from: P */
/* loaded from: classes3.dex */
public class bd {

    /* renamed from: a, reason: collision with root package name */
    Context f77077a;

    /* renamed from: b, reason: collision with root package name */
    int f77078b;

    /* renamed from: c, reason: collision with root package name */
    String f77079c;

    /* renamed from: d, reason: collision with root package name */
    WifiManager.WifiLock f77080d = null;

    public bd(Context context, int i3, String str) {
        this.f77077a = context;
        this.f77078b = i3;
        this.f77079c = str;
    }

    public boolean a() {
        WifiManager.WifiLock wifiLock = this.f77080d;
        if (wifiLock != null && wifiLock.isHeld()) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f77080d == null) {
            this.f77080d = ((WifiManager) this.f77077a.getSystemService("wifi")).createWifiLock(this.f77078b, this.f77079c);
        }
        WifiManager.WifiLock wifiLock = this.f77080d;
        if (wifiLock != null) {
            if (!wifiLock.isHeld()) {
                this.f77080d.acquire();
            }
            return true;
        }
        return false;
    }

    public void c() {
        if (a()) {
            this.f77080d.release();
            this.f77080d = null;
        }
    }
}
