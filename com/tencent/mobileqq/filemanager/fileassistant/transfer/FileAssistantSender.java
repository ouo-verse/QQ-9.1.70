package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import android.os.Bundle;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.k;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.e;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Random;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4$WlanRecvNotify;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileAssistantSender {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f208022a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<yb1.a> f208023b;

    /* renamed from: c, reason: collision with root package name */
    private k f208024c;

    /* renamed from: d, reason: collision with root package name */
    private FMObserver f208025d;

    /* renamed from: e, reason: collision with root package name */
    private String f208026e;

    /* renamed from: f, reason: collision with root package name */
    private FileManagerEntity f208027f;

    /* renamed from: g, reason: collision with root package name */
    private WLANSender f208028g;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f208029h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f208030i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f208031j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f208032k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f208033l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends FMObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void S(boolean z16, long j3, long j16, String str, int i3, int i16, String str2) {
            if (FileAssistantSender.this.f208027f.nSessionId != j16) {
                return;
            }
            QLog.i("FileAssistantSender<FileAssistant>", 1, "onFileTransferEnd :" + j16 + ", isSuccess:" + z16);
            boolean z17 = false;
            FileAssistantSender.this.f208032k = false;
            if (!z16) {
                if (FileAssistantSender.this.f208028g == null && FileAssistantSender.this.C(i16)) {
                    QLog.w("FileAssistantSender<FileAssistant>", 1, "offline failed errCode :" + i16);
                    FileAssistantSender.this.f208030i = true;
                    FileAssistantSender.this.x(true);
                    z17 = true;
                }
                if (!z17 && !FileAssistantSender.this.f208033l) {
                    QLog.e("FileAssistantSender<FileAssistant>", 1, "wlan and offline all failed : " + FileAssistantSender.this.f208027f.nSessionId);
                } else {
                    QLog.e("FileAssistantSender<FileAssistant>", 1, "wlan workind[" + FileAssistantSender.this.f208033l + "], isNeedStartLan[" + z17 + "] : " + FileAssistantSender.this.f208027f.nSessionId);
                    FileAssistantSender.this.f208027f.status = 2;
                    FileAssistantSender.this.f208022a.getFileManagerNotifyCenter().c(FileAssistantSender.this.f208027f.uniseq, FileAssistantSender.this.f208027f.nSessionId, FileAssistantSender.this.f208027f.peerUin, FileAssistantSender.this.f208027f.peerType, 16, null, 0, null);
                    return;
                }
            }
            yb1.a aVar = (yb1.a) FileAssistantSender.this.f208023b.get();
            if (aVar != null) {
                aVar.b(FileAssistantSender.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends k {
        b() {
        }

        @Override // com.tencent.mobileqq.app.k
        protected void n(Session session, boolean z16) {
            if (session.isFileAssist && session.uSessionID == FileAssistantSender.this.f208027f.nSessionId) {
                FileAssistantSender.this.f208033l = false;
                QLog.i("FileAssistantSender<FileAssistant>", 1, "onServiceSessionComplete:" + FileAssistantSender.this.f208027f.nSessionId + ", isSucc:" + z16);
                if (FileAssistantSender.this.f208032k) {
                    if (!z16) {
                        QLog.i("FileAssistantSender<FileAssistant>", 1, "onServiceSessionComplete:" + FileAssistantSender.this.f208027f.nSessionId + ", wanLan faild, offline is working continue!");
                        return;
                    }
                    if (FileAssistantSender.this.f208022a.getFileManagerEngine().T().d(FileAssistantSender.this.f208027f.nSessionId)) {
                        FileAssistantSender.this.f208032k = false;
                    }
                }
                if (FileAssistantSender.this.f208027f.status != 1) {
                    FileAssistantSender.this.f208027f.status = z16 ? 1 : 0;
                }
                FileAssistantSender.this.f208022a.getFileManagerDataCenter().f0(FileAssistantSender.this.f208027f);
                FileAssistantSender.this.f208022a.getFileManagerNotifyCenter().c(FileAssistantSender.this.f208027f.uniseq, FileAssistantSender.this.f208027f.nSessionId, FileAssistantSender.this.f208027f.peerUin, FileAssistantSender.this.f208027f.peerType, 14, new Object[]{FileAssistantSender.this.f208026e, Long.valueOf(FileAssistantSender.this.f208027f.fileSize), Boolean.TRUE, ""}, 0, null);
                ((DataLineHandler) FileAssistantSender.this.f208022a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).N3(2, z16, new Object[]{0L, Long.valueOf(session.uSessionID), FileAssistantSender.this.f208027f.getFilePath()});
                if (z16) {
                    FileAssistantSender.this.D();
                }
                yb1.a aVar = (yb1.a) FileAssistantSender.this.f208023b.get();
                if (aVar != null) {
                    aVar.b(FileAssistantSender.this);
                }
            }
        }

        @Override // com.tencent.mobileqq.app.k
        protected void p(Session session, float f16) {
            if (!FileAssistantSender.this.f208028g.a(session.uSessionID)) {
                return;
            }
            QLog.i("FileAssistantSender<FileAssistant>", 1, "onServiceSessionProgress:" + FileAssistantSender.this.f208027f.nSessionId + ", fProgress:" + f16);
            FileAssistantSender.this.f208027f.fProgress = f16;
            FileAssistantSender.this.f208022a.getFileManagerNotifyCenter().c(FileAssistantSender.this.f208027f.uniseq, FileAssistantSender.this.f208027f.nSessionId, FileAssistantSender.this.f208027f.peerUin, FileAssistantSender.this.f208027f.peerType, 16, null, 0, null);
        }

        @Override // com.tencent.mobileqq.app.k
        protected void s(long j3, int i3, int i16) {
            if (FileAssistantSender.this.f208028g.a(j3)) {
                FileAssistantSender.this.D();
                QLog.i("FileAssistantSender<FileAssistant>", 1, "onWlanConnect:" + FileAssistantSender.this.f208027f.nSessionId + ", channelType:" + i3 + ", connStep:" + i16);
                if (!FileAssistantSender.this.f208022a.getFileManagerEngine().T().h(FileAssistantSender.this.f208027f.nSessionId)) {
                    ThreadManager.getUIHandler().removeCallbacks(FileAssistantSender.this.f208029h);
                    QLog.i("FileAssistantSender<FileAssistant>", 1, "onWlanConnect cancel timer:" + FileAssistantSender.this.f208027f.nSessionId + "]");
                    return;
                }
                QLog.i("FileAssistantSender<FileAssistant>", 1, "onWlanConnect[" + FileAssistantSender.this.f208027f.nSessionId + "] timer is started,tryCancel");
                if (FileAssistantSender.this.f208022a.getFileManagerEngine().T().d(FileAssistantSender.this.f208027f.nSessionId)) {
                    FileAssistantSender.this.f208032k = false;
                }
            }
        }

        @Override // com.tencent.mobileqq.app.k
        protected void t(long j3) {
            if (FileAssistantSender.this.f208028g.a(j3)) {
                FileAssistantSender.this.f208033l = true;
                if (FileAssistantSender.this.f208030i) {
                    QLog.i("FileAssistantSender<FileAssistant>", 1, "onWlanStartRun:" + FileAssistantSender.this.f208027f.nSessionId + ",config isNotEnoughtSpace[" + FileAssistantSender.this.f208030i + "] stop start offline!");
                    return;
                }
                if (((IQFileConfigManager) FileAssistantSender.this.f208022a.getRuntimeService(IQFileConfigManager.class, "")).isWlanOnly()) {
                    QLog.i("FileAssistantSender<FileAssistant>", 1, FileAssistantSender.this.f208027f.nSessionId + ":run only wlan mode, waiting for connect!");
                    return;
                }
                QLog.i("FileAssistantSender<FileAssistant>", 1, "onWlanStartRun:" + FileAssistantSender.this.f208027f.nSessionId + ", start offline timer, wait 3s!");
                synchronized (FileAssistantSender.this) {
                    FileAssistantSender fileAssistantSender = FileAssistantSender.this;
                    fileAssistantSender.f208029h = fileAssistantSender.s();
                    ThreadManager.getUIHandler().postDelayed(FileAssistantSender.this.f208029h, h.h(FileAssistantSender.this.f208022a));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileAssistantSender(QQAppInterface qQAppInterface, yb1.a aVar, String str) {
        this.f208024c = null;
        this.f208025d = null;
        this.f208026e = null;
        this.f208027f = null;
        this.f208028g = null;
        this.f208029h = null;
        this.f208030i = false;
        this.f208031j = false;
        this.f208032k = false;
        this.f208033l = false;
        this.f208022a = qQAppInterface;
        this.f208023b = new WeakReference<>(aVar);
        this.f208026e = str;
    }

    private void A() {
        if (this.f208024c != null) {
            return;
        }
        b bVar = new b();
        this.f208024c = bVar;
        this.f208022a.addDefaultObservers(bVar);
    }

    private void B() {
        if (this.f208025d != null) {
            return;
        }
        this.f208025d = new a();
        this.f208022a.getFileManagerNotifyCenter().addObserver(this.f208025d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C(int i3) {
        if (i3 != -10112 && i3 != -25087 && i3 != -98090) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (this.f208031j) {
            QLog.i("FileAssistantSender<FileAssistant>", 1, "sendWlanNotify failed, isSendWlanNotify:true");
            return;
        }
        this.f208031j = true;
        SubMsgType0x4$WlanRecvNotify subMsgType0x4$WlanRecvNotify = new SubMsgType0x4$WlanRecvNotify();
        subMsgType0x4$WlanRecvNotify.uint32_time.set((int) e.K0());
        subMsgType0x4$WlanRecvNotify.uint64_file_size.set(this.f208027f.fileSize);
        subMsgType0x4$WlanRecvNotify.str_file_name.set(this.f208027f.fileName);
        subMsgType0x4$WlanRecvNotify.uint32_send_client_type.set(h.d());
        subMsgType0x4$WlanRecvNotify.uint32_target_client_type.set(h.e());
        subMsgType0x4$WlanRecvNotify.uint64_session_id.set(this.f208027f.nSessionId);
        subMsgType0x4$WlanRecvNotify.uint32_random.set(Math.abs(new Random().nextInt()));
        this.f208022a.getFileTransferHandler().t1(subMsgType0x4$WlanRecvNotify);
        QLog.i("FileAssistantSender<FileAssistant>", 1, "sendWlanNotify : " + this.f208027f.nSessionId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable s() {
        return new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantSender.1
            @Override // java.lang.Runnable
            public void run() {
                FileAssistantSender.this.v();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        QLog.i("FileAssistantSender<FileAssistant>", 1, "doOfflineSend[" + this.f208027f.nSessionId + "] use extf upload. filename:" + this.f208027f.fileName);
        B();
        this.f208032k = true;
        this.f208022a.getFileManagerEngine().T().l(this.f208027f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z16) {
        A();
        WLANSender wLANSender = new WLANSender();
        this.f208028g = wLANSender;
        wLANSender.c(this.f208022a, this.f208027f, z16);
        this.f208027f.isStartWlan = true;
        QLog.i("FileAssistantSender<FileAssistant>", 1, "doWlanSend[" + this.f208027f.nSessionId + "],filePath:" + this.f208027f.getFilePath() + ",filename:" + this.f208027f.fileName);
    }

    public void E() {
        WLANSender wLANSender = this.f208028g;
        if (wLANSender != null) {
            wLANSender.b();
        }
        this.f208022a.getFileManagerEngine().T().d(this.f208027f.nSessionId);
        this.f208032k = false;
        this.f208033l = false;
        yb1.a aVar = this.f208023b.get();
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void F() {
        if (this.f208029h != null) {
            QLog.i("FileAssistantSender<FileAssistant>", 1, "remove offlineSenderStartTimer");
            ThreadManager.getUIHandler().removeCallbacks(this.f208029h);
        }
        if (this.f208028g != null) {
            QLog.i("FileAssistantSender<FileAssistant>", 1, "cancel mWlanSender");
            this.f208028g.d();
        }
        if (this.f208022a.getFileManagerEngine().T().d(this.f208027f.nSessionId)) {
            QLog.i("FileAssistantSender<FileAssistant>", 1, "cancel offlineSender");
        }
        FileManagerEntity fileManagerEntity = this.f208027f;
        if (fileManagerEntity.status != 1) {
            fileManagerEntity.status = 3;
            this.f208022a.getFileManagerDataCenter().f0(this.f208027f);
        }
        this.f208032k = false;
        this.f208033l = false;
        this.f208022a.getFileManagerNotifyCenter().b(true, 3, null);
        yb1.a aVar = this.f208023b.get();
        if (aVar != null) {
            QLog.i("FileAssistantSender<FileAssistant>", 1, "call onSendComplete");
            aVar.b(this);
        }
    }

    public void t() {
        k kVar = this.f208024c;
        if (kVar != null) {
            this.f208022a.removeObserver(kVar);
        }
        if (this.f208025d != null) {
            this.f208022a.getFileManagerNotifyCenter().deleteObserver(this.f208025d);
        }
        this.f208032k = false;
        this.f208033l = false;
        QLog.i("FileAssistantSender<FileAssistant>", 1, "destory Sender:" + this.f208027f.nSessionId);
    }

    public FileManagerEntity u(Bundle bundle) {
        final FileInfo b16 = FileInfo.b(this.f208026e);
        if (b16 == null) {
            QLog.e("FileAssistantSender<FileAssistant>", 1, "filePath maybe not exsited:" + this.f208026e);
            return null;
        }
        this.f208027f = FileManagerUtil.newEntityByLocalFileInfo(b16);
        final String debugDatalineSettingUin = ((IQFileConfigManager) this.f208022a.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
        this.f208027f.nSessionId = ((DataLineHandler) this.f208022a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).v3();
        this.f208027f.uniseq = FileManagerUtil.genSessionId().longValue();
        this.f208027f.msgSeq = FileManagerUtil.genMsgSeq();
        FileManagerEntity fileManagerEntity = this.f208027f;
        fileManagerEntity.peerUin = debugDatalineSettingUin;
        fileManagerEntity.cloudType = 3;
        fileManagerEntity.status = 2;
        fileManagerEntity.bDelInFM = true;
        fileManagerEntity.bSend = true;
        fileManagerEntity.nOpType = 51;
        if (bundle != null) {
            com.tencent.mobileqq.activity.aio.forward.b.d().e(this.f208027f.uniseq, bundle.getLong("forward_origin_uni_seq", -1L), bundle.getInt("forward_id", -1));
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantSender.4
            @Override // java.lang.Runnable
            public void run() {
                String currentUin = FileAssistantSender.this.f208022a.getCurrentUin();
                FileManagerUtil.createMediThumbnail(FileAssistantSender.this.f208027f);
                FileAssistantSender.this.f208022a.getFileManagerDataCenter().t(FileAssistantSender.this.f208027f);
                FileAssistantSender.this.f208022a.getFileManagerDataCenter().p(debugDatalineSettingUin, currentUin, true, b16.k(), b16.l(), true, 0, "", FileAssistantSender.this.f208027f.msgSeq, FileAssistantSender.this.f208027f.uniseq, FileAssistantSender.this.f208027f.msgUid, -1L, e.K0());
            }
        });
        return this.f208027f;
    }

    public void w(boolean z16) {
        if (!((IQFileConfigManager) this.f208022a.getRuntimeService(IQFileConfigManager.class, "")).isWlanOnly() && h.A(this.f208022a, this.f208027f.fileSize)) {
            this.f208032k = true;
            v();
        } else {
            x(z16);
        }
        FileManagerNotifyCenter fileManagerNotifyCenter = this.f208022a.getFileManagerNotifyCenter();
        FileManagerEntity fileManagerEntity = this.f208027f;
        fileManagerNotifyCenter.c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 16, null, 0, null);
    }

    public boolean y(long j3) {
        QLog.i("FileAssistantSender<FileAssistant>", 1, "equal id[" + j3 + "," + this.f208027f.nSessionId + "]");
        if (this.f208027f.nSessionId == j3) {
            return true;
        }
        return false;
    }

    public long z() {
        FileManagerEntity fileManagerEntity = this.f208027f;
        if (fileManagerEntity != null) {
            return fileManagerEntity.nSessionId;
        }
        return 0L;
    }

    public FileAssistantSender(QQAppInterface qQAppInterface, yb1.a aVar, FileManagerEntity fileManagerEntity) {
        this.f208024c = null;
        this.f208025d = null;
        this.f208026e = null;
        this.f208027f = null;
        this.f208028g = null;
        this.f208029h = null;
        this.f208030i = false;
        this.f208031j = false;
        this.f208032k = false;
        this.f208033l = false;
        this.f208022a = qQAppInterface;
        this.f208023b = new WeakReference<>(aVar);
        this.f208027f = fileManagerEntity;
        fileManagerEntity.status = 2;
    }
}
