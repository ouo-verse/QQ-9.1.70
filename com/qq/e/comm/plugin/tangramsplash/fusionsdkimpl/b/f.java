package com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b;

import com.qq.e.comm.constants.LoadAdParams;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f implements nt.e {

    /* renamed from: a, reason: collision with root package name */
    private boolean f40039a;

    /* renamed from: b, reason: collision with root package name */
    private String f40040b;

    /* renamed from: c, reason: collision with root package name */
    private String f40041c;

    /* renamed from: d, reason: collision with root package name */
    private LoadAdParams f40042d;

    @Override // nt.e
    public boolean a() {
        return this.f40039a;
    }

    @Override // nt.e
    public String b() {
        return this.f40040b;
    }

    @Override // nt.e
    public String c() {
        return this.f40041c;
    }

    @Override // nt.e
    public long d() {
        return TTL.MAX_VALUE;
    }

    @Override // nt.e
    public Object e() {
        return this.f40042d;
    }

    @Override // nt.e
    public boolean f() {
        LoadAdParams loadAdParams = this.f40042d;
        if (loadAdParams != null && loadAdParams.isRefreshAdRequest()) {
            return true;
        }
        return false;
    }

    public void a(boolean z16) {
        this.f40039a = z16;
    }

    public void b(String str) {
        this.f40041c = str;
    }

    public void a(String str) {
        this.f40040b = str;
    }

    public void a(LoadAdParams loadAdParams) {
        this.f40042d = loadAdParams;
    }
}
