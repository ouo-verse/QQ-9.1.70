package com.tencent.mobileqq.uftransfer.guild;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.file.s;
import com.tencent.mobileqq.guild.file.u;
import com.tencent.mobileqq.uftransfer.api.k;
import java.io.File;
import java.util.List;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2$Addr;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g extends com.tencent.mobileqq.uftransfer.task.taskinfo.a {

    /* renamed from: j, reason: collision with root package name */
    private e f305232j;

    /* renamed from: k, reason: collision with root package name */
    private s f305233k;

    /* renamed from: l, reason: collision with root package name */
    private u f305234l;

    g(long j3, int i3, e eVar, k kVar) {
        super(j3, i3, kVar, true);
        this.f305232j = eVar;
        k(eVar.n());
        File file = new File(eVar.a());
        if (file.exists()) {
            l(file.length());
        }
    }

    public static g n(long j3, int i3, e eVar, k kVar) {
        if (eVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(eVar.o()) && !TextUtils.isEmpty(eVar.m())) {
            return new g(j3, i3, eVar, kVar);
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildUploadTaskInfo", 1, "TId[" + j3 + "] create task info fail.id is null");
        return null;
    }

    public boolean A() {
        return this.f305232j.f();
    }

    public void B(s sVar) {
        this.f305233k = sVar;
    }

    public void C(u uVar) {
        this.f305234l = uVar;
    }

    public byte[] o() {
        s sVar = this.f305233k;
        if (sVar != null) {
            return sVar.a();
        }
        return null;
    }

    public String p() {
        return this.f305232j.m();
    }

    public String q() {
        return this.f305232j.a();
    }

    public String r() {
        return this.f305232j.o();
    }

    public s s() {
        return this.f305233k;
    }

    public List<oidb_0xfc2$Addr> t() {
        s sVar = this.f305233k;
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    public List<oidb_0xfc2$Addr> u() {
        s sVar = this.f305233k;
        if (sVar != null) {
            return sVar.d();
        }
        return null;
    }

    public int v() {
        return this.f305232j.b();
    }

    public String w() {
        return this.f305232j.c();
    }

    public long x() {
        return this.f305232j.p();
    }

    public String y() {
        s sVar = this.f305233k;
        if (sVar != null && !TextUtils.isEmpty(sVar.f())) {
            return this.f305233k.f();
        }
        u uVar = this.f305234l;
        if (uVar != null && !TextUtils.isEmpty(uVar.c())) {
            return this.f305234l.c();
        }
        return "";
    }

    public boolean z() {
        s sVar = this.f305233k;
        if (sVar != null && sVar.g()) {
            return true;
        }
        return false;
    }
}
