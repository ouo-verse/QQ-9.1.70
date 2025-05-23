package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.nt.NTFileManageBridger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d extends TroopFileDownloadWorker {
    static IPatchRedirector $redirector_;

    /* renamed from: x, reason: collision with root package name */
    private QQAppInterface f295922x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements NTFileManageBridger.e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.nt.NTFileManageBridger.e
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            d.this.C(0);
            d dVar = d.this;
            TroopFileDownloadWorker.b bVar = dVar.f295878f;
            if (bVar != null) {
                bVar.a(dVar.f295874b.Id, false, 1, dVar);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.nt.NTFileManageBridger.e
        public void b(int i3, String str) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            if (i3 == 0) {
                d.this.C(3);
            } else {
                d.this.C(4);
            }
            com.tencent.mobileqq.filemanager.uftwrapper.a.b(d.this.f295874b, i3, str);
            d dVar = d.this;
            TroopFileDownloadWorker.b bVar = dVar.f295878f;
            if (bVar != null) {
                UUID uuid = dVar.f295874b.Id;
                if (i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.a(uuid, z16, i3, dVar);
            }
        }
    }

    protected d(QQAppInterface qQAppInterface, long j3, TroopFileTransferManager.Item item, Bundle bundle, TroopFileDownloadWorker.b bVar) {
        super(j3, item, bundle, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, Long.valueOf(j3), item, bundle, bVar);
        } else {
            this.f295922x = qQAppInterface;
        }
    }

    public static d G(QQAppInterface qQAppInterface, long j3, TroopFileTransferManager.Item item, Bundle bundle, TroopFileDownloadWorker.b bVar) {
        if (j3 == 0) {
            QLog.e("NTTroopFileDownloadWorker", 1, "getWoker. troopuin=0");
            return null;
        }
        if (item == null) {
            QLog.e("NTTroopFileDownloadWorker", 1, "getWoker. item=null");
            return null;
        }
        if (item.Id == null) {
            QLog.e("NTTroopFileDownloadWorker", 1, "getWoker. item.id=null");
            return null;
        }
        return new d(qQAppInterface, j3, item, bundle, bVar);
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            QLog.e("NTTroopFileDownloadWorker", 1, "func resetReportInfo is no support!!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    public void C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            super.C(i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    public boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        E();
        return true;
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (!this.f295876d) {
            return;
        }
        this.f295876d = false;
        QQAppInterface qQAppInterface = this.f295922x;
        if (qQAppInterface != null) {
            qQAppInterface.getNTFileManageBridger().R(this.f295874b, this.f295883k, new a());
        } else {
            this.f295876d = true;
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    public void F(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        if (i3 == 3) {
            i16 = 10;
        } else {
            i16 = 9;
        }
        com.tencent.mobileqq.troop.filemanager.b.e(this.f295873a, this.f295874b, i16);
        if (this.f295876d) {
            return;
        }
        this.f295876d = true;
        C(0);
        QQAppInterface qQAppInterface = this.f295922x;
        if (qQAppInterface != null) {
            qQAppInterface.getNTFileManageBridger().K(this.f295874b, this.f295883k, i3);
        } else {
            this.f295876d = false;
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker, com.tencent.mobileqq.troop.filemanager.download.c
    public void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else {
            QLog.e("NTTroopFileDownloadWorker", 1, "func onChangeUrl is no support!!");
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker, com.tencent.mobileqq.troop.filemanager.download.c
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            QLog.e("NTTroopFileDownloadWorker", 1, "func onRetryDownload is no support!!");
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker, com.tencent.mobileqq.troop.filemanager.download.c
    public void f(boolean z16, long j3, int i3, String str, String str2, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3), str, str2, bundle);
        } else {
            QLog.e("NTTroopFileDownloadWorker", 1, "func onErr is no support!!");
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected void g(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            QLog.e("NTTroopFileDownloadWorker", 1, "func doDel is no support!!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    public void h(boolean z16, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            QLog.e("NTTroopFileDownloadWorker", 1, "func doErr is no support!!");
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            QLog.e("NTTroopFileDownloadWorker", 1, "func doSuc is no support!!");
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected void k(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            QLog.e("NTTroopFileDownloadWorker", 1, "func fillHttpTransBaseReportInfo is no support!!");
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        QLog.e("NTTroopFileDownloadWorker", 1, "func genDir is no support!!");
        return false;
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected b o(QQAppInterface qQAppInterface, long j3, String str, String str2, boolean z16, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (b) iPatchRedirector.redirect((short) 12, this, qQAppInterface, Long.valueOf(j3), str, str2, Boolean.valueOf(z16), str3);
        }
        QLog.e("NTTroopFileDownloadWorker", 1, "func getCustomFileDownloader is no support!!");
        return null;
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker, com.tencent.mobileqq.troop.filemanager.download.c
    public void onDownloadProgress(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            QLog.e("NTTroopFileDownloadWorker", 1, "func onDownloadProgress is no support!!");
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker, com.tencent.mobileqq.troop.filemanager.download.c
    public void onDownloadSuccess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            QLog.e("NTTroopFileDownloadWorker", 1, "func onDownloadSuccess is no support!!");
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    public UUID p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (UUID) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return super.p();
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected int q(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) bundle)).intValue();
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected int r(int i3, int i16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), bundle)).intValue();
        }
        return 9;
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    public long s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return super.s();
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.u();
        TroopFileTransferManager.Item item = this.f295874b;
        if (item.Status != 8) {
            com.tencent.mobileqq.troop.filemanager.b.e(this.f295873a, item, 8);
        }
        com.tencent.mobileqq.troop.filemanager.b.h(this.f295873a, this.f295874b);
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            QLog.e("NTTroopFileDownloadWorker", 1, "func reportDownloadFailInfo is no support!!");
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            QLog.e("NTTroopFileDownloadWorker", 1, "func reportDownloadSucDetailInfo is no support!!");
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            QLog.e("NTTroopFileDownloadWorker", 1, "func reportDownloadSucInfo is no support!!");
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            QLog.e("NTTroopFileDownloadWorker", 1, "func reqDownload is no support!!");
        }
    }
}
