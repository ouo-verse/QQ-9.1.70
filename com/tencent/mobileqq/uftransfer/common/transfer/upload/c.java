package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadBizInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadFileEntry;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferSendListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.uftransfer.api.j;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends UFTFileUploaderCbWrapper implements com.tencent.mobileqq.uftransfer.common.transfer.a, IExcitingTransferSendListener {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name */
    private static long f305068o;

    /* renamed from: p, reason: collision with root package name */
    private static long f305069p;

    /* renamed from: d, reason: collision with root package name */
    protected final AppRuntime f305070d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.mobileqq.uftransfer.common.transfer.d f305071e;

    /* renamed from: f, reason: collision with root package name */
    protected final long f305072f;

    /* renamed from: g, reason: collision with root package name */
    protected final long f305073g;

    /* renamed from: h, reason: collision with root package name */
    protected final int f305074h;

    /* renamed from: i, reason: collision with root package name */
    protected final String f305075i;

    /* renamed from: j, reason: collision with root package name */
    protected byte[] f305076j;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f305077k;

    /* renamed from: l, reason: collision with root package name */
    protected long f305078l;

    /* renamed from: m, reason: collision with root package name */
    protected long f305079m;

    /* renamed from: n, reason: collision with root package name */
    protected ExcitingTransferUploadResultRp f305080n;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21644);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            f305068o = 0L;
            f305069p = 0L;
        }
    }

    c(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.common.transfer.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) dVar);
            return;
        }
        this.f305077k = true;
        this.f305078l = 0L;
        this.f305079m = 0L;
        this.f305070d = appRuntime;
        this.f305071e = dVar;
        this.f305072f = dVar.k();
        this.f305071e = dVar;
        this.f305073g = dVar.j();
        this.f305074h = dVar.i();
        this.f305075i = appRuntime.getCurrentUin();
        this.f305077k = true;
        F();
    }

    private ExcitingTransferUploadBizInfo A() {
        ExcitingTransferUploadBizInfo excitingTransferUploadBizInfo = new ExcitingTransferUploadBizInfo();
        excitingTransferUploadBizInfo.commandId = this.f305071e.b();
        excitingTransferUploadBizInfo.chateType = this.f305071e.d();
        excitingTransferUploadBizInfo.businessType = this.f305071e.c();
        excitingTransferUploadBizInfo.bufSig = this.f305076j;
        excitingTransferUploadBizInfo.senderUin = Long.valueOf(this.f305075i).longValue();
        excitingTransferUploadBizInfo.receiverUin = this.f305073g;
        excitingTransferUploadBizInfo.clientType = 2;
        excitingTransferUploadBizInfo.clientVer = com.tencent.mobileqq.uftransfer.depend.a.w();
        excitingTransferUploadBizInfo.terminalType = 2;
        excitingTransferUploadBizInfo.terminalVer = com.tencent.mobileqq.uftransfer.depend.a.x();
        List<j> e16 = this.f305071e.l().e();
        int i3 = 0;
        if (e16 != null && e16.size() > 0) {
            excitingTransferUploadBizInfo.vecFtnLanIpV4AndPorts = new ExcitingTransferHostInfo[e16.size()];
            int i16 = 0;
            for (j jVar : e16) {
                excitingTransferUploadBizInfo.vecFtnLanIpV4AndPorts[i16] = new ExcitingTransferHostInfo(jVar.b(), jVar.a());
                i16++;
            }
        }
        List<j> f16 = this.f305071e.l().f();
        if (f16 != null && f16.size() > 0) {
            excitingTransferUploadBizInfo.vecFtnLanIpV6AndPorts = new ExcitingTransferHostInfo[f16.size()];
            for (j jVar2 : f16) {
                excitingTransferUploadBizInfo.vecFtnLanIpV6AndPorts[i3] = new ExcitingTransferHostInfo(jVar2.b(), jVar2.a());
                i3++;
            }
        }
        excitingTransferUploadBizInfo.bufBusinessExt = this.f305071e.l().c();
        excitingTransferUploadBizInfo.bufUuid = this.f305071e.f().g();
        excitingTransferUploadBizInfo.bufUploadKey = this.f305071e.f().f();
        excitingTransferUploadBizInfo.bUseMediaPlatform = this.f305071e.m();
        excitingTransferUploadBizInfo.groupCode = this.f305071e.g();
        return excitingTransferUploadBizInfo;
    }

    private ExcitingTransferUploadChnConfigInfo B() {
        ExcitingTransferUploadChnConfigInfo excitingTransferUploadChnConfigInfo = new ExcitingTransferUploadChnConfigInfo();
        if (this.f305071e.e() != null) {
            excitingTransferUploadChnConfigInfo.uMuliFileSizeLimit = this.f305071e.e().g();
            excitingTransferUploadChnConfigInfo.uMaxChannelNum = this.f305071e.e().c();
            excitingTransferUploadChnConfigInfo.uPieceSize = this.f305071e.e().h();
            excitingTransferUploadChnConfigInfo.nMaxEachHostTotalUseCount = this.f305071e.e().f();
            excitingTransferUploadChnConfigInfo.nMaxEachHostErrorCount = this.f305071e.e().d();
            excitingTransferUploadChnConfigInfo.nMaxEachHostParallelUseCount = this.f305071e.e().e();
            excitingTransferUploadChnConfigInfo.nConnectTimeout = this.f305071e.e().a();
            excitingTransferUploadChnConfigInfo.nDataTimeout = this.f305071e.e().b();
            excitingTransferUploadChnConfigInfo.nTotoalDataTimeout = this.f305071e.e().i();
        }
        return excitingTransferUploadChnConfigInfo;
    }

    private ExcitingTransferUploadFileEntry C() {
        ExcitingTransferUploadFileEntry excitingTransferUploadFileEntry = new ExcitingTransferUploadFileEntry();
        excitingTransferUploadFileEntry.strLocalFilePath = this.f305071e.f().i();
        excitingTransferUploadFileEntry.strFileName = this.f305071e.f().h();
        excitingTransferUploadFileEntry.uFileSize = this.f305071e.f().j();
        excitingTransferUploadFileEntry.buf10MMd5 = this.f305071e.f().b();
        excitingTransferUploadFileEntry.bufMd5 = this.f305071e.f().c();
        excitingTransferUploadFileEntry.bufSha = this.f305071e.f().d();
        excitingTransferUploadFileEntry.bufSha3 = this.f305071e.f().e();
        return excitingTransferUploadFileEntry;
    }

    private ExcitingTransferEngine.ExcitingSendInfo D() {
        ExcitingTransferEngine.ExcitingSendInfo excitingSendInfo = new ExcitingTransferEngine.ExcitingSendInfo();
        excitingSendInfo.mFileEntry = C();
        excitingSendInfo.mBusInfo = A();
        excitingSendInfo.mReqInfo = E();
        excitingSendInfo.mConfig = B();
        return excitingSendInfo;
    }

    private ExcitingTransferUploadReqInfo E() {
        ExcitingTransferUploadReqInfo excitingTransferUploadReqInfo = new ExcitingTransferUploadReqInfo();
        List<j> b16 = this.f305071e.l().b();
        if (b16 != null) {
            int i3 = 4;
            if (b16.size() <= 4) {
                i3 = b16.size();
            }
            excitingTransferUploadReqInfo.vecSrvIpAndPorts = new ExcitingTransferHostInfo[i3];
            for (int i16 = 0; i16 < i3; i16++) {
                j jVar = b16.get(i16);
                excitingTransferUploadReqInfo.vecSrvIpAndPorts[i16] = new ExcitingTransferHostInfo(jVar.b(), jVar.a());
            }
        }
        excitingTransferUploadReqInfo.bSupportHttps = this.f305071e.l().h();
        excitingTransferUploadReqInfo.strSSLCName = this.f305071e.l().g();
        return excitingTransferUploadReqInfo;
    }

    private void F() {
        byte[] e16 = com.tencent.mobileqq.uftransfer.depend.a.e(this.f305075i);
        this.f305076j = e16;
        if (e16 == null || e16.length == 0) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTExtfFileUploader", 1, "!!!!!Id[" + this.f305072f + "] UFTExtfFileUploader ERR: BigDataSig is null.!!!!!");
        }
    }

    private boolean G() {
        byte[] bArr = this.f305076j;
        if (bArr != null && bArr.length > 0) {
            return true;
        }
        return false;
    }

    public static c x(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.common.transfer.d dVar) {
        if (appRuntime != null && dVar != null) {
            if (!dVar.a()) {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTExtfFileUploader", 1, "prop invaild:" + dVar.h());
            }
            return new c(appRuntime, dVar);
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTExtfFileUploader", 1, "app|prop is null");
        return null;
    }

    private static void z(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = f305069p;
        if (j3 < 100 && currentTimeMillis - f305068o > 6000) {
            f305068o = currentTimeMillis;
            f305069p = j3 + 1;
            com.tencent.mobileqq.uftransfer.depend.c.e("[UFTTransfer] UFTExtfFileUploader", 1, "!!!getBigDataSigFromHwSvr. count:" + f305069p + " lastTime:" + f305068o);
            com.tencent.mobileqq.uftransfer.depend.a.D(appRuntime);
        }
    }

    public boolean H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (this.f305080n == null || this.f305071e.f() == null || this.f305080n.mu64StartSize != this.f305071e.f().j()) {
            return false;
        }
        return true;
    }

    protected void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.f305079m = 0L;
        this.f305078l = 0L;
        this.f305080n = null;
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.a
    public void cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f305077k) {
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTExtfFileUploader", 1, "Id[" + this.f305072f + "] cancel^^^^");
        this.f305077k = true;
        if (this.f305078l != 0) {
            ExcitingTransferEngine.getInstance().cancelSendFile(this.f305078l);
            this.f305078l = 0L;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.a
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.a
    public boolean g(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, j3)).booleanValue();
        }
        I();
        if (!G()) {
            F();
            if (!G()) {
                z(this.f305070d);
            }
        }
        ExcitingTransferEngine.ExcitingSendInfo D = D();
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTExtfFileUploader", 1, "Id[" + this.f305072f + "] uploadFile >>>>");
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTExtfFileUploader", 1, "Id[" + this.f305072f + "] ReqInfo   = {" + D.mReqInfo.toString() + "}");
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTExtfFileUploader", 1, "Id[" + this.f305072f + "] FileEntry = {" + D.mFileEntry.toString() + "}");
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTExtfFileUploader", 1, "Id[" + this.f305072f + "] BusInfo   = {" + D.mBusInfo.toString() + "}");
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTExtfFileUploader", 1, "Id[" + this.f305072f + "] Config    = {" + D.mConfig.toString() + "}");
        long sendFile = ExcitingTransferEngine.getInstance().sendFile(D, this);
        if (sendFile == 0) {
            this.f305077k = true;
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTExtfFileUploader", 1, "Id[" + this.f305072f + "] uploadFile fail");
            return false;
        }
        this.f305077k = false;
        this.f305078l = sendFile;
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTExtfFileUploader", 1, "Id[" + this.f305072f + "] uploadFile excitingId:" + this.f305078l);
        return true;
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.a
    public int getRetryCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        ExcitingTransferUploadResultRp excitingTransferUploadResultRp = this.f305080n;
        if (excitingTransferUploadResultRp != null) {
            return (int) excitingTransferUploadResultRp.muRetryCount;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.a
    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        ExcitingTransferUploadResultRp excitingTransferUploadResultRp = this.f305080n;
        if (excitingTransferUploadResultRp != null) {
            return excitingTransferUploadResultRp.mstrFileUrl;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.a
    public long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.f305079m;
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferSendListener
    public void onExcitingSendProgress(long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        } else {
            if (this.f305077k) {
                return;
            }
            this.f305079m = j3;
            m(j3, j16, j17);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferSendListener
    public void onExcitingSendResult(boolean z16, int i3, ExcitingTransferUploadResultRp excitingTransferUploadResultRp) {
        String str;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), Integer.valueOf(i3), excitingTransferUploadResultRp);
            return;
        }
        if (this.f305077k) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Id[");
        sb5.append(this.f305072f);
        sb5.append("] onExcitingSendResult suc:");
        sb5.append(z16);
        sb5.append(" errcode:");
        sb5.append(i3);
        sb5.append(" RP:");
        if (excitingTransferUploadResultRp != null) {
            str = excitingTransferUploadResultRp.toString();
        } else {
            str = "";
        }
        sb5.append(str);
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTExtfFileUploader", 1, sb5.toString());
        this.f305080n = excitingTransferUploadResultRp;
        if (z16) {
            this.f305079m = this.f305071e.f().j();
        }
        this.f305078l = 0L;
        if (excitingTransferUploadResultRp != null) {
            if (z16) {
                if (this.f305071e.f().j() - excitingTransferUploadResultRp.mu64StartSize > 0) {
                    j3 = this.f305071e.f().j() - excitingTransferUploadResultRp.mu64StartSize;
                } else {
                    j3 = 0;
                }
                excitingTransferUploadResultRp.mu64TransferSize = j3;
            } else {
                long j16 = this.f305079m;
                long j17 = excitingTransferUploadResultRp.mu64StartSize;
                if (j16 - j17 > 0) {
                    j3 = j16 - j17;
                } else {
                    j3 = 0;
                }
                excitingTransferUploadResultRp.mu64TransferSize = j3;
            }
            if (j3 > 0) {
                if (excitingTransferUploadResultRp.mu64HttpTime > 0) {
                    excitingTransferUploadResultRp.mu64TransferSpeed = ((float) j3) / (((float) r13) / 1000.0f);
                    com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTExtfFileUploader", 1, "Id[" + this.f305072f + "] sendResultRP:" + excitingTransferUploadResultRp.toString());
                }
            }
            excitingTransferUploadResultRp.mu64TransferSpeed = 0L;
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTExtfFileUploader", 1, "Id[" + this.f305072f + "] sendResultRP:" + excitingTransferUploadResultRp.toString());
        }
        if (z16) {
            j(H(), excitingTransferUploadResultRp);
            return;
        }
        if (!com.tencent.mobileqq.uftransfer.depend.a.A()) {
            if (excitingTransferUploadResultRp != null) {
                excitingTransferUploadResultRp.mnResult = 2;
            }
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTExtfFileUploader", 1, "Id[" + this.f305072f + "] onExcitingSendResult. is no network");
        } else {
            i16 = i3;
        }
        y(i16, excitingTransferUploadResultRp);
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferSendListener
    public void onExcitingSendStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.f305077k) {
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTExtfFileUploader", 1, "Id[" + this.f305072f + "] onExcitingSendStart.");
        m(this.f305079m, 0L, 0L);
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferSendListener
    public void onExcitingSubSenderResult(int i3, ExcitingTransferUploaderRp excitingTransferUploaderRp) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3, (Object) excitingTransferUploaderRp);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Id[");
        sb5.append(this.f305072f);
        sb5.append("] ^_^ onExcitingSubSenderResult:");
        sb5.append(i3);
        sb5.append(" RP:");
        if (excitingTransferUploaderRp != null) {
            str = excitingTransferUploaderRp.toString();
        } else {
            str = "";
        }
        sb5.append(str);
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTExtfFileUploader", 1, sb5.toString());
        if (i3 == 0) {
            f(excitingTransferUploaderRp);
        } else {
            k(false, i3, this.f305079m, "", "", excitingTransferUploaderRp);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.a
    public long p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        ExcitingTransferUploadResultRp excitingTransferUploadResultRp = this.f305080n;
        if (excitingTransferUploadResultRp != null) {
            return excitingTransferUploadResultRp.mu64StartSize;
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.a
    public void q(com.tencent.mobileqq.uftransfer.common.transfer.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.f305034a = bVar;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFileUploaderCbWrapper
    public boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.f305077k;
    }

    protected void y(int i3, ExcitingTransferUploadResultRp excitingTransferUploadResultRp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3, (Object) excitingTransferUploadResultRp);
            return;
        }
        if (this.f305077k) {
            return;
        }
        if (this.f305078l != 0) {
            ExcitingTransferEngine.getInstance().cancelSendFile(this.f305078l);
            this.f305078l = 0L;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTExtfFileUploader", 1, "Id[" + this.f305072f + "] *_* *_* onFailure errcode:" + i3);
        k(true, i3, this.f305079m, "", "", excitingTransferUploadResultRp);
    }
}
