package com.tencent.mobileqq.guild.file;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes33.dex */
public class QFileGuildTransferWrapper {

    /* renamed from: a, reason: collision with root package name */
    private final QQAppInterface f224351a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Long, b> f224352b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private c f224353c = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class GuildUploadWrapper extends b {

        /* renamed from: e, reason: collision with root package name */
        private final FileManagerEntity f224358e;

        /* renamed from: f, reason: collision with root package name */
        private int f224359f;

        GuildUploadWrapper(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity, c cVar) {
            super(qQAppInterface, cVar);
            this.f224359f = 0;
            this.f224358e = fileManagerEntity;
        }

        private void m(final int i3, final int i16) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.file.QFileGuildTransferWrapper.GuildUploadWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
                    GuildUploadWrapper guildUploadWrapper = GuildUploadWrapper.this;
                    iGuildMessageUtilsApi.updateMsgSendStatus(guildUploadWrapper.f224364b, guildUploadWrapper.f224358e.channelId, GuildUploadWrapper.this.f224358e.uniseq, i3, i16);
                }
            }, 32, null, true);
        }

        @Override // com.tencent.mobileqq.guild.file.QFileGuildTransferWrapper.b, com.tencent.mobileqq.uftransfer.api.b
        public int a(com.tencent.mobileqq.uftransfer.api.a aVar, Bundle bundle, com.tencent.mobileqq.uftransfer.api.d dVar) {
            return 0;
        }

        @Override // com.tencent.mobileqq.guild.file.QFileGuildTransferWrapper.b, com.tencent.mobileqq.uftransfer.api.b
        public void b(com.tencent.mobileqq.uftransfer.api.a aVar, com.tencent.mobileqq.uftransfer.api.h hVar) {
            if (this.f224363a) {
                return;
            }
            if (hVar.a() != null) {
                this.f224358e.strFileMd5 = vb1.a.b(hVar.a());
                this.f224358e.str10Md5 = HexUtil.bytes2HexStr(hVar.a());
            }
            if (hVar.d() != null) {
                this.f224358e.strFileSha3 = HexUtil.bytes2HexStr(hVar.d());
            }
            if (hVar.c() != null) {
                this.f224358e.strFileSHA = vb1.a.b(hVar.c());
            }
            if (hVar.g() != 0) {
                this.f224358e.imgHeight = hVar.g();
            }
            if (hVar.h() != 0) {
                this.f224358e.imgWidth = hVar.h();
            }
            this.f224364b.getFileManagerDataCenter().f0(this.f224358e);
        }

        @Override // com.tencent.mobileqq.guild.file.QFileGuildTransferWrapper.b, com.tencent.mobileqq.uftransfer.api.b
        public void c(com.tencent.mobileqq.uftransfer.api.a aVar, int i3, Bundle bundle) {
            this.f224359f = i3;
        }

        @Override // com.tencent.mobileqq.guild.file.QFileGuildTransferWrapper.b, com.tencent.mobileqq.uftransfer.api.b
        public void d(com.tencent.mobileqq.uftransfer.api.a aVar, com.tencent.mobileqq.uftransfer.api.i iVar) {
            if (this.f224363a) {
                return;
            }
            if (!TextUtils.isEmpty(iVar.a())) {
                this.f224358e.Uuid = iVar.a();
            }
            this.f224358e.bUseMediaPlatform = iVar.e();
            if (!TextUtils.isEmpty(iVar.c())) {
                this.f224358e.strServerPath = iVar.c();
            }
            if (!TextUtils.isEmpty(iVar.b())) {
                this.f224358e.fileIdCrc = iVar.b();
            }
            this.f224358e.svrPathIpType = iVar.d();
            this.f224364b.getFileManagerDataCenter().f0(this.f224358e);
        }

        @Override // com.tencent.mobileqq.guild.file.QFileGuildTransferWrapper.b, com.tencent.mobileqq.uftransfer.api.b
        public void f(com.tencent.mobileqq.uftransfer.api.a aVar, int i3, com.tencent.mobileqq.uftransfer.api.c cVar) {
            if (this.f224363a) {
                return;
            }
            this.f224363a = true;
            if (i3 != 0) {
                this.f224358e.status = 0;
                m(32768, i3);
                this.f224364b.getFileManagerDataCenter().f0(this.f224358e);
                FileManagerNotifyCenter fileManagerNotifyCenter = this.f224364b.getFileManagerNotifyCenter();
                FileManagerEntity fileManagerEntity = this.f224358e;
                fileManagerNotifyCenter.c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 15, null, i3, cVar.getErrMsg());
            } else {
                FileManagerReporter.a aVar2 = new FileManagerReporter.a();
                aVar2.f209157b = "send_file_suc";
                aVar2.f209158c = 1;
                FileManagerReporter.addData(this.f224364b.getCurrentAccountUin(), aVar2);
                if (cVar.a()) {
                    FileManagerUtil.addCloseButtonSessionId(this.f224358e.nSessionId);
                    this.f224364b.getFileManagerNotifyCenter().a(this.f224358e, 11, "");
                } else {
                    this.f224358e.fProgress = 1.0f;
                }
                this.f224358e.status = 1;
                this.f224364b.getFileManagerDataCenter().f0(this.f224358e);
                FileManagerNotifyCenter fileManagerNotifyCenter2 = this.f224364b.getFileManagerNotifyCenter();
                FileManagerEntity fileManagerEntity2 = this.f224358e;
                fileManagerNotifyCenter2.c(fileManagerEntity2.uniseq, fileManagerEntity2.nSessionId, fileManagerEntity2.peerUin, fileManagerEntity2.peerType, 14, new Object[]{fileManagerEntity2.getFilePath(), Long.valueOf(this.f224358e.fileSize), Boolean.TRUE, cVar.getUrl()}, 0, null);
            }
            Object a16 = this.f224365c.a();
            if (a16 instanceof Long) {
                this.f224366d.a(((Long) a16).longValue());
            }
        }

        @Override // com.tencent.mobileqq.guild.file.QFileGuildTransferWrapper.b, com.tencent.mobileqq.uftransfer.api.b
        public void g(com.tencent.mobileqq.uftransfer.api.a aVar) {
            if (this.f224363a) {
                return;
            }
            FileManagerEntity fileManagerEntity = this.f224358e;
            fileManagerEntity.fProgress = 0.0f;
            if (fileManagerEntity.status != 2) {
                fileManagerEntity.status = 2;
                this.f224364b.getFileManagerDataCenter().f0(this.f224358e);
            }
            m(32772, 0);
            FileManagerNotifyCenter fileManagerNotifyCenter = this.f224364b.getFileManagerNotifyCenter();
            FileManagerEntity fileManagerEntity2 = this.f224358e;
            fileManagerNotifyCenter.c(fileManagerEntity2.uniseq, fileManagerEntity2.nSessionId, fileManagerEntity2.peerUin, fileManagerEntity2.peerType, 16, null, 0, null);
        }

        @Override // com.tencent.mobileqq.guild.file.QFileGuildTransferWrapper.b
        boolean j(int i3) {
            super.j(i3);
            this.f224358e.status = 3;
            m(32768, i3);
            this.f224364b.getFileManagerDataCenter().f0(this.f224358e);
            this.f224364b.getFileManagerNotifyCenter().b(true, 3, null);
            return true;
        }

        public void l() {
            this.f224363a = false;
            com.tencent.mobileqq.uftransfer.guild.e eVar = new com.tencent.mobileqq.uftransfer.guild.e();
            eVar.g(this.f224358e.strFilePath);
            eVar.r(this.f224358e.fileName);
            eVar.i(false);
            eVar.s(this.f224358e.guildId);
            eVar.q(this.f224358e.channelId);
            eVar.t(this.f224358e.msgUid);
            eVar.l(Long.valueOf(this.f224358e.nSessionId));
            eVar.k(this.f224358e.guildId);
            eVar.j(10014);
            this.f224365c = ((IUFTTransferService) this.f224364b.getRuntimeService(IUFTTransferService.class, "")).uploadGuildFile(eVar, i(), this);
        }

        @Override // com.tencent.mobileqq.guild.file.QFileGuildTransferWrapper.b, com.tencent.mobileqq.uftransfer.api.b
        public void h(com.tencent.mobileqq.uftransfer.api.a aVar, long j3, long j16, long j17) {
            String str;
            if (this.f224363a) {
                return;
            }
            if (j17 > 1048576) {
                str = "\u52a0\u901f\u4e0a\u4f20 " + new DecimalFormat("0.00").format(((float) j17) / 1048576.0f) + "MB/s";
            } else if (j17 > 1024) {
                str = "\u52a0\u901f\u4e0a\u4f20 " + new DecimalFormat("0.00").format(((float) j17) / 1024.0f) + "KB/s";
            } else {
                str = "\u52a0\u901f\u4e0a\u4f20 " + j17 + "KB/s";
            }
            if (j17 != 0) {
                this.f224358e.mExcitingSpeed = str;
            }
            this.f224358e.fProgress = ((float) j16) / ((float) j3);
            this.f224364b.getFileManagerDataCenter().f0(this.f224358e);
            FileManagerNotifyCenter fileManagerNotifyCenter = this.f224364b.getFileManagerNotifyCenter();
            FileManagerEntity fileManagerEntity = this.f224358e;
            fileManagerNotifyCenter.c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 16, null, 0, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements c {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.file.QFileGuildTransferWrapper.c
        public void a(long j3) {
            QFileGuildTransferWrapper.this.l(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static abstract class b implements com.tencent.mobileqq.uftransfer.api.b {

        /* renamed from: a, reason: collision with root package name */
        boolean f224363a = true;

        /* renamed from: b, reason: collision with root package name */
        final QQAppInterface f224364b;

        /* renamed from: c, reason: collision with root package name */
        com.tencent.mobileqq.uftransfer.api.a f224365c;

        /* renamed from: d, reason: collision with root package name */
        final c f224366d;

        public b(QQAppInterface qQAppInterface, c cVar) {
            this.f224364b = qQAppInterface;
            this.f224366d = cVar;
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public int a(com.tencent.mobileqq.uftransfer.api.a aVar, Bundle bundle, com.tencent.mobileqq.uftransfer.api.d dVar) {
            return -1;
        }

        protected com.tencent.mobileqq.uftransfer.api.k i() {
            ExcitingTransferUploadChnConfigInfo excitingTransferUploadChnConfigInfo;
            com.tencent.mobileqq.uftransfer.api.k kVar = new com.tencent.mobileqq.uftransfer.api.k(true);
            IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.f224364b.getRuntimeService(IQFileConfigManager.class, "");
            kVar.a().l(true);
            kVar.a().m(com.tencent.mobileqq.filemanager.core.d.c().isConfigEnableIPV6(this.f224364b, 1));
            kVar.a().n(true);
            kVar.a().k(true);
            kVar.a().i(true);
            kVar.a().j(false);
            if (iQFileConfigManager.getExcitingC2CUploadConfig() != null) {
                excitingTransferUploadChnConfigInfo = iQFileConfigManager.getExcitingC2CUploadConfig().c();
            } else {
                excitingTransferUploadChnConfigInfo = new ExcitingTransferUploadChnConfigInfo();
            }
            k.c cVar = new k.c();
            cVar.j(excitingTransferUploadChnConfigInfo.nConnectTimeout);
            cVar.k(excitingTransferUploadChnConfigInfo.nDataTimeout);
            cVar.l(excitingTransferUploadChnConfigInfo.uMaxChannelNum);
            cVar.m(excitingTransferUploadChnConfigInfo.nMaxEachHostErrorCount);
            cVar.n(excitingTransferUploadChnConfigInfo.nMaxEachHostParallelUseCount);
            cVar.o(excitingTransferUploadChnConfigInfo.nMaxEachHostTotalUseCount);
            cVar.p(excitingTransferUploadChnConfigInfo.uMuliFileSizeLimit);
            cVar.q(excitingTransferUploadChnConfigInfo.uPieceSize);
            cVar.r(excitingTransferUploadChnConfigInfo.nTotoalDataTimeout);
            kVar.a().h(cVar);
            return kVar;
        }

        boolean j(int i3) {
            this.f224363a = true;
            if (this.f224365c != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("REASON", i3);
                ((IUFTTransferService) this.f224364b.getRuntimeService(IUFTTransferService.class, "")).stop(this.f224365c, bundle);
            }
            return this.f224363a;
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void g(com.tencent.mobileqq.uftransfer.api.a aVar) {
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void b(com.tencent.mobileqq.uftransfer.api.a aVar, com.tencent.mobileqq.uftransfer.api.h hVar) {
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void d(com.tencent.mobileqq.uftransfer.api.a aVar, com.tencent.mobileqq.uftransfer.api.i iVar) {
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void h(com.tencent.mobileqq.uftransfer.api.a aVar, long j3, long j16, long j17) {
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void c(com.tencent.mobileqq.uftransfer.api.a aVar, int i3, Bundle bundle) {
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void e(com.tencent.mobileqq.uftransfer.api.a aVar, long j3, long j16) {
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void f(com.tencent.mobileqq.uftransfer.api.a aVar, int i3, com.tencent.mobileqq.uftransfer.api.c cVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface c {
        void a(long j3);
    }

    public QFileGuildTransferWrapper(QQAppInterface qQAppInterface) {
        this.f224351a = qQAppInterface;
    }

    private void f(long j3, b bVar) {
        synchronized (this) {
            this.f224352b.put(Long.valueOf(j3), bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Contact h(String str, String str2) {
        return new Contact(4, str2, str);
    }

    private ArrayList<MsgElement> i(Set<FileInfo> set) {
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        for (FileInfo fileInfo : set) {
            int fileType = FileManagerUtil.getFileType(fileInfo.k());
            MsgElement createFileElement = ((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createFileElement(fileInfo.k(), fileType);
            if (fileType == 5) {
                createFileElement.getFileElement().setFileName(new VFSFile(fileInfo.k()).getName());
            } else {
                createFileElement.getFileElement().setFileName(fileInfo.j());
            }
            QLog.d("QFileGuildTransferWrapper", 1, "createMsgElementLi element=" + createFileElement.getFileElement().toString());
            arrayList.add(createFileElement);
        }
        return arrayList;
    }

    private void j(final String str, final String str2, Set<FileInfo> set) {
        final ArrayList<MsgElement> i3 = i(set);
        ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.guild.file.QFileGuildTransferWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = i3.iterator();
                while (it.hasNext()) {
                    MsgElement msgElement = (MsgElement) it.next();
                    QFileGuildTransferWrapper qFileGuildTransferWrapper = QFileGuildTransferWrapper.this;
                    qFileGuildTransferWrapper.n(qFileGuildTransferWrapper.h(str, str2), msgElement);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(int i3, String str) {
        QLog.i("QFileGuildTransferWrapper", 4, "send MessageForFile result=" + i3 + " errMsg=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b l(long j3) {
        b remove;
        synchronized (this) {
            remove = this.f224352b.remove(Long.valueOf(j3));
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Contact contact, MsgElement msgElement) {
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        arrayList.add(msgElement);
        ((IMsgService) QRoute.api(IMsgService.class)).sendMsg(contact, arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.guild.file.n
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                QFileGuildTransferWrapper.k(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(FileManagerEntity fileManagerEntity) {
        GuildUploadWrapper guildUploadWrapper = new GuildUploadWrapper(this.f224351a, fileManagerEntity, this.f224353c);
        f(fileManagerEntity.nSessionId, guildUploadWrapper);
        guildUploadWrapper.l();
    }

    public boolean g(long j3) {
        QLog.i("QFileGuildTransferWrapper", 1, "cancelSend Id[" + j3 + "]");
        b l3 = l(j3);
        if (l3 != null) {
            return l3.j(0);
        }
        return false;
    }

    public void m(final FileManagerEntity fileManagerEntity) {
        QLog.i("QFileGuildTransferWrapper", 1, "resendFile Id[" + fileManagerEntity.nSessionId + "] fileName = " + fileManagerEntity.fileName + " fileSize = " + fileManagerEntity.fileSize);
        if (!g(fileManagerEntity.nSessionId)) {
            o(fileManagerEntity);
        } else {
            ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.guild.file.QFileGuildTransferWrapper.3
                @Override // java.lang.Runnable
                public void run() {
                    QFileGuildTransferWrapper.this.o(fileManagerEntity);
                }
            });
        }
    }

    public void p(String str, String str2, Set<FileInfo> set) {
        j(str, str2, set);
    }
}
