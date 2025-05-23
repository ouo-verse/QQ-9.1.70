package com.tencent.mobileqq.uftransfer.guild;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.guild.file.s;
import com.tencent.mobileqq.uftransfer.api.j;
import com.tencent.mobileqq.uftransfer.task.upload.a;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2$Addr;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d extends com.tencent.mobileqq.uftransfer.task.upload.a {

    /* renamed from: m, reason: collision with root package name */
    protected boolean f305225m;

    /* renamed from: n, reason: collision with root package name */
    protected ExcitingTransferUploadResultRp f305226n;

    public d(AppRuntime appRuntime, g gVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar, a.AbstractC8873a abstractC8873a) {
        super(appRuntime, gVar, aVar, abstractC8873a);
        this.f305225m = false;
        this.f305226n = null;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.a
    public boolean C() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.a
    public void D(a.b bVar) {
        if (bVar.n() != null && (bVar.n() instanceof ExcitingTransferUploadResultRp)) {
            this.f305226n = (ExcitingTransferUploadResultRp) bVar.n();
        }
        super.D(bVar);
    }

    protected int E(g gVar, s sVar) {
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, "TId[" + p() + "] start troop extf upload. useIPv6:" + this.f305225m);
        com.tencent.mobileqq.uftransfer.common.transfer.d dVar = new com.tencent.mobileqq.uftransfer.common.transfer.d();
        dVar.u(gVar.i());
        dVar.s(gVar.v());
        dVar.t(Long.parseLong(gVar.w()));
        dVar.n(86);
        dVar.o(102);
        dVar.p(1);
        dVar.r(Long.parseLong(gVar.w()));
        dVar.f().l(gVar.d().a());
        dVar.f().m(gVar.d().b());
        dVar.f().n(gVar.d().c());
        dVar.f().o(gVar.d().d());
        dVar.f().p(gVar.o());
        dVar.f().q(gVar.a());
        dVar.f().r(gVar.e());
        dVar.f().s(gVar.q());
        dVar.f().t(gVar.f());
        dVar.l().m(false);
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.uftransfer.depend.a.f(this.f305342a, this.f305225m, 3, arrayList);
        dVar.l().i(arrayList);
        ArrayList arrayList2 = new ArrayList();
        List<oidb_0xfc2$Addr> t16 = gVar.t();
        if (t16 != null && t16.size() > 0) {
            for (oidb_0xfc2$Addr oidb_0xfc2_addr : t16) {
                arrayList2.add(new j(oidb_0xfc2_addr.str_ip.get(), oidb_0xfc2_addr.uint32_https_port.get()));
            }
        }
        dVar.l().k(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        List<oidb_0xfc2$Addr> u16 = gVar.u();
        if (u16 != null && u16.size() > 0) {
            for (oidb_0xfc2$Addr oidb_0xfc2_addr2 : u16) {
                arrayList3.add(new j(oidb_0xfc2_addr2.str_ip.get(), oidb_0xfc2_addr2.uint32_https_port.get()));
            }
        }
        dVar.l().l(arrayList3);
        com.tencent.mobileqq.uftransfer.common.transfer.a a16 = com.tencent.mobileqq.uftransfer.common.transfer.c.a(this.f305342a, dVar);
        this.f305476j = a16;
        if (a16 == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, "TId[" + p() + "] upload error. cannot create extf uploader");
            t("file uploader cannt create");
            return 3;
        }
        a16.q(this);
        if (this.f305476j.g(0L)) {
            return 0;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, "TId[" + p() + "] upload error. extf uploader start fail");
        t("run upload file fail");
        return 4;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    protected int i() {
        this.f305226n = null;
        g gVar = (g) this.f305343b;
        this.f305225m = gVar.b().a().f();
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, "TId[" + p() + "] do start guild upload op");
        s s16 = gVar.s();
        if (s16 == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, "TId[" + p() + "] do start troop upload fail. guildUploadRsp info is null");
            t("upload file guildUploadRsp info is null");
            return 1;
        }
        return E(gVar, s16);
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.a
    public long w() {
        ExcitingTransferUploadResultRp excitingTransferUploadResultRp = this.f305226n;
        if (excitingTransferUploadResultRp != null) {
            return excitingTransferUploadResultRp.mu64HttpTime;
        }
        return super.w();
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.a
    public long y() {
        ExcitingTransferUploadResultRp excitingTransferUploadResultRp = this.f305226n;
        if (excitingTransferUploadResultRp != null) {
            return excitingTransferUploadResultRp.mu64TransferSpeed;
        }
        return super.y();
    }
}
