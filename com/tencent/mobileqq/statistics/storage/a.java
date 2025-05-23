package com.tencent.mobileqq.statistics.storage;

import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends RecyclablePool.Recyclable {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public String f290131h;

    /* renamed from: i, reason: collision with root package name */
    public String f290132i;

    /* renamed from: j, reason: collision with root package name */
    public long f290133j;

    /* renamed from: k, reason: collision with root package name */
    public long f290134k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f290135l;

    /* renamed from: m, reason: collision with root package name */
    public long f290136m;

    /* renamed from: n, reason: collision with root package name */
    public long f290137n;

    /* renamed from: o, reason: collision with root package name */
    public long f290138o;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.commonsdk.pool.RecyclablePool.Recyclable
    public void recycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.recycle();
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(64);
        sb5.append("StorageItem info[size=");
        sb5.append(this.f290133j);
        sb5.append(",accessTime=");
        sb5.append(this.f290134k);
        sb5.append(",isFile=");
        sb5.append(this.f290135l);
        sb5.append(",fileCount=");
        sb5.append(this.f290136m);
        sb5.append(",dirCount=");
        sb5.append(this.f290137n);
        sb5.append(",name=");
        sb5.append(this.f290131h);
        sb5.append(",path=");
        sb5.append(this.f290132i);
        sb5.append(",cost=");
        sb5.append(this.f290138o);
        sb5.append("]");
        return sb5.toString();
    }
}
