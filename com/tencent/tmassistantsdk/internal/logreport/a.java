package com.tencent.tmassistantsdk.internal.logreport;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.a.a;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class a implements c {

    /* renamed from: a, reason: collision with root package name */
    protected d f380551a = null;

    /* renamed from: b, reason: collision with root package name */
    protected int f380552b = 0;

    /* renamed from: c, reason: collision with root package name */
    protected final List<byte[]> f380553c = new ArrayList();

    public synchronized void a(JceStruct jceStruct) {
        if (jceStruct != null) {
            c().a(ProtocolPackage.jceStructToUTF8Byte(jceStruct));
        }
    }

    protected abstract boolean a();

    public void b() {
        this.f380551a = null;
        this.f380553c.clear();
    }

    protected abstract com.tencent.tmassistant.common.a.a c();

    protected abstract byte d();

    /* JADX WARN: Removed duplicated region for block: B:19:0x0050 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x000d, B:12:0x0013, B:14:0x0029, B:17:0x0032, B:19:0x0050), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void e() {
        boolean z16;
        if (!GlobalUtil.getInstance().canReportValue()) {
            return;
        }
        if (this.f380551a != null) {
            return;
        }
        d dVar = new d();
        this.f380551a = dVar;
        dVar.a(this);
        a.C9992a b16 = c().b(1000);
        if (b16 != null && b16.f380376b.size() > 0) {
            this.f380553c.addAll(b16.f380376b);
            z16 = this.f380551a.a(d(), b16);
            c().a(b16.f380375a);
            if (!z16) {
                this.f380551a = null;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    public void f() {
        this.f380552b = 0;
    }

    @Override // com.tencent.tmassistantsdk.internal.logreport.c
    public void a(d dVar, boolean z16) {
        List<byte[]> list;
        if (!z16 && (list = this.f380553c) != null && list.size() > 0) {
            c().b(this.f380553c);
        }
        this.f380551a = null;
        this.f380553c.clear();
        if (z16 && a() && this.f380552b < 5) {
            e();
            this.f380552b++;
        }
    }
}
