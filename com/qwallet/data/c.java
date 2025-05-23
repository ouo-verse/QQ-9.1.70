package com.qwallet.data;

import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f41554a;

    /* renamed from: b, reason: collision with root package name */
    public String f41555b;

    /* renamed from: c, reason: collision with root package name */
    public String f41556c;

    /* renamed from: d, reason: collision with root package name */
    public long f41557d;

    c() {
    }

    public static c a(QWalletHomePage$AppInfo qWalletHomePage$AppInfo) {
        c cVar = new c();
        cVar.f41554a = qWalletHomePage$AppInfo.f41686id.get();
        cVar.f41555b = qWalletHomePage$AppInfo.name.get();
        cVar.f41556c = qWalletHomePage$AppInfo.icon.get();
        cVar.f41557d = qWalletHomePage$AppInfo.bit_flag.get();
        return cVar;
    }
}
