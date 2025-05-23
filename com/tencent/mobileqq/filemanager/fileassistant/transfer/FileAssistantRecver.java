package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import android.text.TextUtils;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.k;
import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import vb1.b;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileAssistantRecver {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f208010a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<yb1.a> f208011b;

    /* renamed from: e, reason: collision with root package name */
    private FileManagerEntity f208014e;

    /* renamed from: c, reason: collision with root package name */
    private k f208012c = null;

    /* renamed from: d, reason: collision with root package name */
    private FMObserver f208013d = null;

    /* renamed from: f, reason: collision with root package name */
    b f208015f = null;

    /* renamed from: g, reason: collision with root package name */
    com.tencent.mobileqq.filemanager.fileassistant.transfer.a f208016g = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f208017h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f208018i = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends k {
        a() {
        }

        @Override // com.tencent.mobileqq.app.k
        protected void n(Session session, boolean z16) {
            if (!session.isFileAssist || session.uSessionID != FileAssistantRecver.this.f208014e.nSessionId) {
                return;
            }
            QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "onServiceSessionComplete:" + FileAssistantRecver.this.f208014e.nSessionId + ", isSucc:" + z16);
            b bVar = FileAssistantRecver.this.f208015f;
            if (bVar != null) {
                bVar.e();
            }
            if (z16) {
                FileAssistantRecver.this.f208014e.status = 1;
                FileAssistantRecver.this.f208014e.cloudType = 3;
                if (!FileAssistantRecver.this.f208010a.getFileManagerDataCenter().y(FileAssistantRecver.this.f208014e.nSessionId)) {
                    FileAssistantRecver.this.f208010a.getFileManagerDataCenter().d(FileAssistantRecver.this.f208014e.nSessionId);
                    String debugDatalineSettingUin = ((IQFileConfigManager) FileAssistantRecver.this.f208010a.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
                    int intValue = ((Integer) FileAssistantRecver.this.f208014e.mContext).intValue();
                    FileAssistantRecver.this.f208014e.mContext = null;
                    FileAssistantRecver.this.f208010a.getFileManagerDataCenter().r(debugDatalineSettingUin, debugDatalineSettingUin, false, intValue, FileAssistantRecver.this.f208014e);
                }
            } else {
                FileAssistantRecver.this.f208014e.status = 0;
            }
            ((DataLineHandler) FileAssistantRecver.this.f208010a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).N3(3, z16, new Object[]{0L, Long.valueOf(FileAssistantRecver.this.f208014e.nSessionId), FileAssistantRecver.this.f208014e.getFilePath()});
            FileAssistantRecver.this.f208010a.getFileManagerDataCenter().f0(FileAssistantRecver.this.f208014e);
            FileAssistantRecver.this.f208010a.getFileManagerNotifyCenter().c(FileAssistantRecver.this.f208014e.uniseq, FileAssistantRecver.this.f208014e.nSessionId, FileAssistantRecver.this.f208014e.peerUin, FileAssistantRecver.this.f208014e.peerType, 14, new Object[]{FileAssistantRecver.this.f208014e.strFilePath, Long.valueOf(FileAssistantRecver.this.f208014e.fileSize), Boolean.TRUE, ""}, 0, null);
            yb1.a aVar = (yb1.a) FileAssistantRecver.this.f208011b.get();
            if (aVar != null) {
                aVar.a(FileAssistantRecver.this);
            }
        }

        @Override // com.tencent.mobileqq.app.k
        protected void p(Session session, float f16) {
            if (FileAssistantRecver.this.f208014e.nSessionId != session.uSessionID) {
                return;
            }
            QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "onServiceSessionProgress:" + FileAssistantRecver.this.f208014e.nSessionId + ", fProgress:" + f16);
            FileAssistantRecver.this.f208014e.fProgress = f16;
            FileAssistantRecver.this.f208010a.getFileManagerNotifyCenter().c(FileAssistantRecver.this.f208014e.uniseq, FileAssistantRecver.this.f208014e.nSessionId, FileAssistantRecver.this.f208014e.peerUin, FileAssistantRecver.this.f208014e.peerType, 16, null, 0, null);
        }

        @Override // com.tencent.mobileqq.app.k
        protected void q(Session session) {
            if (FileAssistantRecver.this.f208014e.nSessionId != session.uSessionID) {
                return;
            }
            b bVar = FileAssistantRecver.this.f208015f;
            if (bVar != null) {
                bVar.e();
                FileAssistantRecver.this.f208017h = false;
            }
            FileAssistantRecver.this.f208014e.status = 2;
            FileAssistantRecver.this.f208018i = true;
            QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "onServiceSessionStart:" + session.uSessionID);
            FileAssistantRecver.this.f208014e.strFilePath = session.strFilePathSrc;
            FileAssistantRecver.this.f208014e.strMiddleThumPath = session.strFilePathThumb;
            FileAssistantRecver.this.f208014e.fileName = session.strFileNameSrc;
            if (TextUtils.isEmpty(FileAssistantRecver.this.f208014e.strFileMd5)) {
                FileAssistantRecver.this.f208014e.strFileMd5 = HexUtil.bytes2HexStr(session.vFileMD5Src);
            }
            FileAssistantRecver.this.f208014e.fileSize = session.uFileSizeSrc;
            FileAssistantRecver.this.f208010a.getFileManagerDataCenter().f0(FileAssistantRecver.this.f208014e);
        }

        @Override // com.tencent.mobileqq.app.k
        protected void s(long j3, int i3, int i16) {
            if (FileAssistantRecver.this.f208014e.nSessionId != j3) {
                return;
            }
            QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "onWlanConnect:" + j3 + ", try cancel offline download!");
            b bVar = FileAssistantRecver.this.f208015f;
            if (bVar != null) {
                bVar.e();
            }
            FileAssistantRecver.this.f208014e.status = 2;
            FileAssistantRecver.this.f208014e.isStartWlan = true;
            if (!FileAssistantRecver.this.f208010a.getFileManagerDataCenter().y(FileAssistantRecver.this.f208014e.nSessionId)) {
                FileAssistantRecver.this.f208010a.getFileManagerDataCenter().d(FileAssistantRecver.this.f208014e.nSessionId);
                QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "MsgRecord is not exsited, addAIOMsg");
                String debugDatalineSettingUin = ((IQFileConfigManager) FileAssistantRecver.this.f208010a.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
                int intValue = ((Integer) FileAssistantRecver.this.f208014e.mContext).intValue();
                FileAssistantRecver.this.f208014e.mContext = null;
                FileAssistantRecver.this.f208010a.getFileManagerDataCenter().r(debugDatalineSettingUin, debugDatalineSettingUin, false, intValue, FileAssistantRecver.this.f208014e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileAssistantRecver(QQAppInterface qQAppInterface, yb1.a aVar, FileManagerEntity fileManagerEntity) {
        this.f208010a = qQAppInterface;
        this.f208011b = new WeakReference<>(aVar);
        this.f208014e = fileManagerEntity;
    }

    private void h() {
        QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doOfflineRecv:" + this.f208014e.nSessionId);
        p();
        this.f208017h = true;
        this.f208015f.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doWlanRecv:" + this.f208014e.nSessionId);
        n();
        this.f208016g = new com.tencent.mobileqq.filemanager.fileassistant.transfer.a(this.f208010a, this.f208014e);
    }

    private void n() {
        if (this.f208012c != null) {
            QLog.w("FileAssistantRecver<FileAssistant>.NFRV", 1, "why initObserver call two times?");
            return;
        }
        a aVar = new a();
        this.f208012c = aVar;
        this.f208010a.addObserver(aVar);
    }

    private void o() {
        if (this.f208013d != null) {
            return;
        }
        this.f208013d = new FMObserver() { // from class: com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantRecver.1
            @Override // com.tencent.mobileqq.filemanager.app.FMObserver
            protected void S(boolean z16, long j3, long j16, String str, int i3, int i16, String str2) {
                if (FileAssistantRecver.this.f208014e.nSessionId != j16) {
                    return;
                }
                if (FileAssistantRecver.this.f208014e.status != 16 && !z16 && !FileAssistantRecver.this.f208014e.isStartWlan && FileAssistantRecver.this.f208016g != null) {
                    QLog.w("FileAssistantRecver<FileAssistant>.NFRV", 1, "offline failed errCode :" + i16);
                    FileAssistantRecver.this.k();
                    FileAssistantRecver.this.f208014e.status = 2;
                    return;
                }
                if (z16) {
                    com.tencent.mobileqq.filemanager.fileassistant.transfer.a aVar = FileAssistantRecver.this.f208016g;
                    if (aVar != null) {
                        aVar.b();
                    }
                    ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantRecver.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FileAssistantRecver.this.f208014e.status = 1;
                            FileManagerUtil.createMediThumbnail(FileAssistantRecver.this.f208014e);
                            FileAssistantRecver.this.f208010a.getFileManagerDataCenter().f0(FileAssistantRecver.this.f208014e);
                            FileAssistantRecver.this.f208010a.getFileManagerNotifyCenter().b(true, 0, null);
                        }
                    });
                }
                QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "onFileTransferEnd :" + j16);
            }
        };
        this.f208010a.getFileManagerNotifyCenter().addObserver(this.f208013d);
    }

    private void p() {
        if (((IExcitingTransferAdapter) this.f208010a.getRuntimeService(IExcitingTransferAdapter.class, "")).isEnableC2CDownload()) {
            this.f208015f = new xb1.b(this.f208010a, this.f208014e);
        } else {
            this.f208015f = new FileManagerRSWorker(this.f208010a, this.f208014e);
        }
        o();
    }

    private boolean q() {
        if (TextUtils.isEmpty(this.f208014e.Uuid)) {
            return false;
        }
        return true;
    }

    private boolean r() {
        byte[] bArr;
        byte[] bArr2;
        FileManagerEntity fileManagerEntity = this.f208014e;
        if (fileManagerEntity.nfcServerIP == 0 || fileManagerEntity.nfcServerPort < 0 || (bArr = fileManagerEntity.nfcUrlNotify) == null || bArr.length == 0 || (bArr2 = fileManagerEntity.nfcTokenKey) == null || bArr2.length == 0) {
            return false;
        }
        return true;
    }

    private void t() {
        QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "setFileInvalid:" + this.f208014e.nSessionId);
        this.f208014e.status = 16;
        this.f208010a.getFileManagerDataCenter().f0(this.f208014e);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantRecver.3
            @Override // java.lang.Runnable
            public void run() {
                FileAssistantRecver.this.f208010a.getFileManagerNotifyCenter().c(FileAssistantRecver.this.f208014e.uniseq, FileAssistantRecver.this.f208014e.nSessionId, FileAssistantRecver.this.f208014e.peerUin, FileAssistantRecver.this.f208014e.peerType, 12, null, 6, "");
            }
        });
        yb1.a aVar = this.f208011b.get();
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void g() {
        QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "destory:" + this.f208014e.nSessionId);
        this.f208017h = false;
        this.f208018i = false;
        k kVar = this.f208012c;
        if (kVar != null) {
            this.f208010a.removeObserver(kVar);
            this.f208012c = null;
        }
        if (this.f208013d != null) {
            this.f208010a.getFileManagerNotifyCenter().deleteObserver(this.f208013d);
            this.f208013d = null;
        }
    }

    public void i() {
        if (this.f208014e == null) {
            QLog.e("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRecv entiry is null!");
            yb1.a aVar = this.f208011b.get();
            if (aVar != null) {
                aVar.a(this);
                return;
            }
            return;
        }
        QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRecv, wlanInfo is full");
        if (this.f208016g == null) {
            k();
        }
        if (q()) {
            QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRecv, offlineInfo is full");
            if (!this.f208014e.isStartWlan) {
                h();
                return;
            }
        }
        QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRecv, unknow download type");
    }

    public void j() {
        boolean z16;
        boolean z17 = false;
        if (r()) {
            QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRetryRecv NFC:" + this.f208014e.nSessionId);
            n();
            ((DataLineHandler) this.f208010a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).b4(this.f208014e);
            z16 = false;
        } else {
            z16 = true;
        }
        if (q()) {
            QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRetryRecv Offline:" + this.f208014e.nSessionId);
            h();
        } else {
            z17 = z16;
        }
        if (z17) {
            QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRetryRecv but info is null");
            t();
        }
    }

    public boolean l(long j3) {
        QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "equal id[" + j3 + "," + this.f208014e.nSessionId + "]");
        if (this.f208014e.nSessionId == j3) {
            return true;
        }
        return false;
    }

    public long m() {
        FileManagerEntity fileManagerEntity = this.f208014e;
        if (fileManagerEntity != null) {
            return fileManagerEntity.nSessionId;
        }
        return 0L;
    }

    public void s() {
        QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "setFailed:" + this.f208014e.nSessionId);
        com.tencent.mobileqq.filemanager.fileassistant.transfer.a aVar = this.f208016g;
        if (aVar != null) {
            aVar.a();
        }
        b bVar = this.f208015f;
        if (bVar != null) {
            bVar.f();
        }
        this.f208017h = false;
        this.f208018i = false;
        yb1.a aVar2 = this.f208011b.get();
        if (aVar2 != null) {
            aVar2.a(this);
        }
    }

    public void u() {
        QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "userCancel:" + this.f208014e.nSessionId);
        if (this.f208016g != null) {
            QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "wlanRecver cancel");
            this.f208016g.b();
        }
        if (this.f208015f != null) {
            QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "offlineDownloader cancel");
            this.f208015f.e();
        }
        this.f208017h = false;
        this.f208018i = false;
        this.f208014e.status = 3;
        this.f208010a.getFileManagerDataCenter().f0(this.f208014e);
        yb1.a aVar = this.f208011b.get();
        if (aVar != null) {
            QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "call onRecvComplete");
            aVar.a(this);
        }
    }
}
