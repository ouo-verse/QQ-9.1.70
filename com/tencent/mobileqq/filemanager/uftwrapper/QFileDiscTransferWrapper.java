package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.s;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.h;
import com.tencent.mobileqq.uftransfer.api.i;
import com.tencent.mobileqq.uftransfer.api.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QFileDiscTransferWrapper {

    /* renamed from: a, reason: collision with root package name */
    private final QQAppInterface f209078a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Long, c> f209079b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private g f209080c = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements g {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.g
        public void a(long j3) {
            QFileDiscTransferWrapper.this.k(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements s {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f209089a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f209090b;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements QFileAppStorePromoteManager.f {
            a() {
            }

            @Override // com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.f
            public void a(boolean z16, AppDetail appDetail) {
                FileManagerEntity fileManagerEntity = b.this.f209089a;
                fileManagerEntity.yybApkPackageName = appDetail.packageName;
                fileManagerEntity.yybApkName = appDetail.appName;
                fileManagerEntity.yybApkIconUrl = appDetail.iconUrl;
            }

            @Override // com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.f
            public void b() {
                QLog.i("QFileC2CTransferWrapper<FileAssistant>", 1, "waterTest, onGetAppDetailTimeLimit. apkName[" + b.this.f209089a.yybApkName + "]");
                ah.b.a().execute(b.this.f209090b);
            }
        }

        b(FileManagerEntity fileManagerEntity, Runnable runnable) {
            this.f209089a = fileManagerEntity;
            this.f209090b = runnable;
        }

        @Override // com.tencent.mobileqq.filemanager.util.s
        public void a(String str, String str2) {
            FileManagerEntity fileManagerEntity = this.f209089a;
            fileManagerEntity.fileName = str;
            fileManagerEntity.strApkPackageName = str2;
            QFileDiscTransferWrapper.this.f209078a.getFileManagerEngine().J().g(str2, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class d extends c {

        /* renamed from: e, reason: collision with root package name */
        String f209097e;

        /* renamed from: f, reason: collision with root package name */
        String f209098f;

        /* renamed from: g, reason: collision with root package name */
        final long f209099g;

        /* renamed from: h, reason: collision with root package name */
        final f f209100h;

        /* renamed from: i, reason: collision with root package name */
        String f209101i;

        /* renamed from: j, reason: collision with root package name */
        String f209102j;

        /* renamed from: k, reason: collision with root package name */
        String f209103k;

        /* renamed from: l, reason: collision with root package name */
        int f209104l;

        /* renamed from: m, reason: collision with root package name */
        int f209105m;

        /* renamed from: n, reason: collision with root package name */
        int f209106n;

        d(QQAppInterface qQAppInterface, long j3, String str, String str2, g gVar, f fVar) {
            super(qQAppInterface, gVar);
            this.f209097e = str;
            this.f209098f = str2;
            this.f209099g = j3;
            this.f209100h = fVar;
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.c, com.tencent.mobileqq.uftransfer.api.b
        public void b(com.tencent.mobileqq.uftransfer.api.a aVar, h hVar) {
            this.f209102j = vb1.a.b(hVar.a());
            this.f209103k = vb1.a.b(hVar.c());
            this.f209104l = hVar.h();
            this.f209105m = hVar.g();
            this.f209106n = hVar.e();
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.c, com.tencent.mobileqq.uftransfer.api.b
        public void d(com.tencent.mobileqq.uftransfer.api.a aVar, i iVar) {
            if (!TextUtils.isEmpty(iVar.a())) {
                this.f209101i = iVar.a();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.c, com.tencent.mobileqq.uftransfer.api.b
        public void f(com.tencent.mobileqq.uftransfer.api.a aVar, int i3, com.tencent.mobileqq.uftransfer.api.c cVar) {
            if (this.f209094b) {
                return;
            }
            if (this.f209100h != null) {
                Bundle bundle = new Bundle();
                bundle.putString("strFileId", this.f209101i);
                bundle.putString("str10MMd5", this.f209102j);
                bundle.putString("strSha", this.f209103k);
                bundle.putInt("width", this.f209104l);
                bundle.putInt("height", this.f209105m);
                bundle.putInt("duration", this.f209106n);
                this.f209100h.a(i3, true, bundle);
            }
            Object a16 = this.f209096d.a();
            if (a16 instanceof Long) {
                this.f209095c.a(((Long) a16).longValue());
            }
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.c
        void j() {
            this.f209094b = false;
            com.tencent.mobileqq.uftransfer.api.g gVar = new com.tencent.mobileqq.uftransfer.api.g();
            gVar.g(this.f209097e);
            gVar.i(false);
            gVar.h(true);
            gVar.k(this.f209098f);
            gVar.j(3000);
            gVar.l(Long.valueOf(this.f209099g));
            this.f209096d = ((IUFTTransferService) this.f209093a.getRuntimeService(IUFTTransferService.class, "")).uploadDiscFile(gVar, i(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class e extends c {

        /* renamed from: e, reason: collision with root package name */
        final FileManagerEntity f209107e;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a extends com.tencent.mobileqq.filemanager.app.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.uftransfer.api.d f209108a;

            a(com.tencent.mobileqq.uftransfer.api.d dVar) {
                this.f209108a = dVar;
            }

            @Override // com.tencent.mobileqq.filemanager.app.d
            protected void g(boolean z16, Long l3) {
                com.tencent.mobileqq.uftransfer.api.d dVar = this.f209108a;
                if (dVar != null) {
                    dVar.a(z16, l3.longValue(), new Bundle());
                }
            }
        }

        e(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity, g gVar) {
            super(qQAppInterface, gVar);
            this.f209107e = fileManagerEntity;
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.c, com.tencent.mobileqq.uftransfer.api.b
        public int a(com.tencent.mobileqq.uftransfer.api.a aVar, Bundle bundle, com.tencent.mobileqq.uftransfer.api.d dVar) {
            FileManagerEntity fileManagerEntity = this.f209107e;
            String str = fileManagerEntity.fileName;
            if (fileManagerEntity.nFileType == 5 && !TextUtils.isEmpty(fileManagerEntity.strApkPackageName) && str.indexOf(".apk") < 0) {
                str = str + ".apk";
            }
            FileTransferHandler fileTransferHandler = this.f209093a.getFileTransferHandler();
            FileManagerEntity fileManagerEntity2 = this.f209107e;
            long j3 = fileManagerEntity2.nSessionId;
            String str2 = fileManagerEntity2.peerUin;
            String currentAccountUin = this.f209093a.getCurrentAccountUin();
            FileManagerEntity fileManagerEntity3 = this.f209107e;
            fileTransferHandler.k1(j3, str2, currentAccountUin, str, fileManagerEntity3.fileSize, fileManagerEntity3.Uuid, fileManagerEntity3.uniseq, fileManagerEntity3.msgUid, new a(dVar));
            return 0;
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.c, com.tencent.mobileqq.uftransfer.api.b
        public void b(com.tencent.mobileqq.uftransfer.api.a aVar, h hVar) {
            if (this.f209094b) {
                return;
            }
            if (hVar.a() != null) {
                this.f209107e.strFileMd5 = vb1.a.b(hVar.a());
                this.f209107e.str10Md5 = HexUtil.bytes2HexStr(hVar.a());
            }
            if (hVar.c() != null) {
                this.f209107e.strFileSHA = vb1.a.b(hVar.c());
            }
            if (hVar.g() != 0) {
                this.f209107e.imgHeight = hVar.g();
            }
            if (hVar.h() != 0) {
                this.f209107e.imgWidth = hVar.h();
            }
            this.f209093a.getFileManagerDataCenter().f0(this.f209107e);
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.c, com.tencent.mobileqq.uftransfer.api.b
        public void d(com.tencent.mobileqq.uftransfer.api.a aVar, i iVar) {
            if (this.f209094b) {
                return;
            }
            if (!TextUtils.isEmpty(iVar.a())) {
                this.f209107e.Uuid = iVar.a();
            }
            if (!TextUtils.isEmpty(iVar.c())) {
                this.f209107e.strServerPath = iVar.c();
            }
            this.f209107e.svrPathIpType = iVar.d();
            this.f209093a.getFileManagerDataCenter().f0(this.f209107e);
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.c, com.tencent.mobileqq.uftransfer.api.b
        public void f(com.tencent.mobileqq.uftransfer.api.a aVar, int i3, com.tencent.mobileqq.uftransfer.api.c cVar) {
            if (this.f209094b) {
                return;
            }
            this.f209094b = true;
            if (i3 != 0) {
                this.f209107e.status = 0;
                this.f209093a.getFileManagerDataCenter().f0(this.f209107e);
                FileManagerNotifyCenter fileManagerNotifyCenter = this.f209093a.getFileManagerNotifyCenter();
                FileManagerEntity fileManagerEntity = this.f209107e;
                fileManagerNotifyCenter.c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 15, null, i3, cVar.getErrMsg());
            } else {
                if (cVar.a()) {
                    FileManagerUtil.addCloseButtonSessionId(this.f209107e.nSessionId);
                    this.f209093a.getFileManagerNotifyCenter().a(this.f209107e, 5, "");
                } else {
                    this.f209107e.fProgress = 1.0f;
                }
                this.f209107e.status = 1;
                this.f209093a.getFileManagerDataCenter().f0(this.f209107e);
                FileManagerNotifyCenter fileManagerNotifyCenter2 = this.f209093a.getFileManagerNotifyCenter();
                FileManagerEntity fileManagerEntity2 = this.f209107e;
                fileManagerNotifyCenter2.c(fileManagerEntity2.uniseq, fileManagerEntity2.nSessionId, fileManagerEntity2.peerUin, fileManagerEntity2.peerType, 14, new Object[]{fileManagerEntity2.getFilePath(), Long.valueOf(this.f209107e.fileSize), Boolean.TRUE, cVar.getUrl()}, 0, null);
            }
            Object a16 = this.f209096d.a();
            if (a16 instanceof Long) {
                this.f209095c.a(((Long) a16).longValue());
            }
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.c, com.tencent.mobileqq.uftransfer.api.b
        public void g(com.tencent.mobileqq.uftransfer.api.a aVar) {
            if (this.f209094b) {
                return;
            }
            FileManagerEntity fileManagerEntity = this.f209107e;
            fileManagerEntity.fProgress = 0.0f;
            if (fileManagerEntity.status != 2) {
                fileManagerEntity.status = 2;
                this.f209093a.getFileManagerDataCenter().f0(this.f209107e);
            }
            FileManagerNotifyCenter fileManagerNotifyCenter = this.f209093a.getFileManagerNotifyCenter();
            FileManagerEntity fileManagerEntity2 = this.f209107e;
            fileManagerNotifyCenter.c(fileManagerEntity2.uniseq, fileManagerEntity2.nSessionId, fileManagerEntity2.peerUin, fileManagerEntity2.peerType, 16, null, 0, null);
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.c, com.tencent.mobileqq.uftransfer.api.b
        public void h(com.tencent.mobileqq.uftransfer.api.a aVar, long j3, long j16, long j17) {
            if (this.f209094b) {
                return;
            }
            FileManagerEntity fileManagerEntity = this.f209107e;
            fileManagerEntity.fProgress = ((float) j16) / ((float) j3);
            if (fileManagerEntity.status != 2) {
                fileManagerEntity.status = 2;
                this.f209093a.getFileManagerDataCenter().f0(this.f209107e);
            }
            FileManagerNotifyCenter fileManagerNotifyCenter = this.f209093a.getFileManagerNotifyCenter();
            FileManagerEntity fileManagerEntity2 = this.f209107e;
            fileManagerNotifyCenter.c(fileManagerEntity2.uniseq, fileManagerEntity2.nSessionId, fileManagerEntity2.peerUin, fileManagerEntity2.peerType, 16, null, 0, null);
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.c
        public void j() {
            this.f209094b = false;
            com.tencent.mobileqq.uftransfer.api.g gVar = new com.tencent.mobileqq.uftransfer.api.g();
            gVar.g(this.f209107e.strFilePath);
            gVar.i(true);
            gVar.k(this.f209107e.peerUin);
            gVar.j(this.f209107e.peerType);
            gVar.l(Long.valueOf(this.f209107e.nSessionId));
            this.f209096d = ((IUFTTransferService) this.f209093a.getRuntimeService(IUFTTransferService.class, "")).uploadDiscFile(gVar, i(), this);
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.c
        void k(int i3) {
            super.k(i3);
            this.f209107e.status = 3;
            this.f209093a.getFileManagerDataCenter().f0(this.f209107e);
            this.f209093a.getFileManagerNotifyCenter().b(true, 3, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface f {
        void a(int i3, boolean z16, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface g {
        void a(long j3);
    }

    public QFileDiscTransferWrapper(QQAppInterface qQAppInterface) {
        this.f209078a = qQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(long j3, c cVar) {
        synchronized (this) {
            this.f209079b.put(Long.valueOf(j3), cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c j(long j3) {
        c cVar;
        synchronized (this) {
            cVar = this.f209079b.get(Long.valueOf(j3));
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c k(long j3) {
        c remove;
        synchronized (this) {
            remove = this.f209079b.remove(Long.valueOf(j3));
        }
        return remove;
    }

    public boolean g(long j3) {
        c k3 = k(j3);
        if (k3 == null) {
            return false;
        }
        k3.k(0);
        return true;
    }

    public void h() {
        HashMap hashMap = new HashMap();
        synchronized (this) {
            hashMap.putAll(this.f209079b);
            this.f209079b.clear();
        }
        Iterator it = hashMap.values().iterator();
        while (it.hasNext()) {
            ((c) it.next()).k(4);
        }
    }

    public void i() {
        HashMap hashMap = new HashMap();
        synchronized (this) {
            hashMap.putAll(this.f209079b);
            this.f209079b.clear();
        }
        Iterator it = hashMap.values().iterator();
        while (it.hasNext()) {
            ((c) it.next()).k(3);
        }
    }

    public void l(final FileManagerEntity fileManagerEntity) {
        if (g(fileManagerEntity.nSessionId)) {
            ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.4
                @Override // java.lang.Runnable
                public void run() {
                    e eVar = new e(QFileDiscTransferWrapper.this.f209078a, fileManagerEntity, QFileDiscTransferWrapper.this.f209080c);
                    QFileDiscTransferWrapper.this.f(fileManagerEntity.nSessionId, eVar);
                    eVar.j();
                }
            });
            return;
        }
        e eVar = new e(this.f209078a, fileManagerEntity, this.f209080c);
        f(fileManagerEntity.nSessionId, eVar);
        eVar.j();
    }

    public FileManagerEntity m(final String str, final String str2, final Bundle bundle) {
        final long j3 = q.d(-1000).uniseq;
        final FileManagerEntity i3 = this.f209078a.getFileManagerDataCenter().i(j3, str2, 3000);
        if (i3 == null) {
            QLog.e("QFileC2CTransferWrapper<FileAssistant>", 1, "entry is null");
            return null;
        }
        i3.status = 2;
        int i16 = 0;
        i3.nOpType = 0;
        i3.setCloudType(3);
        i3.fileSize = FileManagerUtil.getFileSizes(str);
        i3.isReaded = true;
        i3.peerUin = str2;
        i3.peerNick = FileManagerUtil.getPeerNick(this.f209078a, str2, null, 3000);
        i3.setFilePath(str);
        i3.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        i3.fileName = FileManagerUtil.getFileName(str);
        i3.nFileType = FileManagerUtil.getFileType(str);
        i3.setCloudType(3);
        i3.bSend = true;
        i3.msgSeq = FileManagerUtil.genMsgSeq();
        i3.msgUid = FileManagerUtil.genMsgUid();
        i3.strThumbPath = FileManagerUtil.createMediaThumbnail(str, 150, 150, null);
        i3.tmpSessionType = -1L;
        if (bundle != null) {
            i16 = bundle.getInt("_m_ForwardFromScene");
        }
        i3.fromScene = i16;
        this.f209078a.getFileManagerDataCenter().t(i3);
        final String account = this.f209078a.getAccount();
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                FileManagerUtil.createMediThumbnail(i3);
                String makeTransFileProtocolData = TransfileUtile.makeTransFileProtocolData(str, 0L, 0, true);
                FileManagerDataCenter fileManagerDataCenter = QFileDiscTransferWrapper.this.f209078a.getFileManagerDataCenter();
                String str3 = str2;
                String str4 = account;
                String str5 = str;
                FileManagerEntity fileManagerEntity = i3;
                fileManagerDataCenter.q(str3, str4, true, str5, 0L, true, 3000, makeTransFileProtocolData, fileManagerEntity.msgSeq, j3, fileManagerEntity.msgUid, -1L, com.tencent.mobileqq.service.message.e.K0(), -1, bundle);
                QLog.i("QFileC2CTransferWrapper<FileAssistant>", 1, "=_=k Id[" + i3.nSessionId + "] SendLocalfile[" + i3.fileName + "], peerType[" + i3.peerType + "]");
                c j16 = QFileDiscTransferWrapper.this.j(i3.nSessionId);
                if (j16 != null) {
                    j16.j();
                    return;
                }
                QLog.w("QFileC2CTransferWrapper<FileAssistant>", 1, "=_=k Id[" + i3.nSessionId + "] SendLocalfile fail. may stoped");
            }
        };
        if (i3.nFileType == 5) {
            if (!((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).getApkPackageInfo(i3.getFilePath(), new b(i3, runnable))) {
                ah.b.a().execute(runnable);
            }
        } else {
            ah.b.a().execute(runnable);
        }
        f(i3.nSessionId, new e(this.f209078a, i3, this.f209080c));
        return i3;
    }

    public long n(String str, String str2, f fVar) {
        long longValue = FileManagerUtil.genSessionId().longValue();
        d dVar = new d(this.f209078a, longValue, str, str2, this.f209080c, fVar);
        f(longValue, dVar);
        dVar.j();
        return longValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static abstract class c implements com.tencent.mobileqq.uftransfer.api.b {

        /* renamed from: a, reason: collision with root package name */
        final QQAppInterface f209093a;

        /* renamed from: b, reason: collision with root package name */
        boolean f209094b = true;

        /* renamed from: c, reason: collision with root package name */
        final g f209095c;

        /* renamed from: d, reason: collision with root package name */
        com.tencent.mobileqq.uftransfer.api.a f209096d;

        c(QQAppInterface qQAppInterface, g gVar) {
            this.f209093a = qQAppInterface;
            this.f209095c = gVar;
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public int a(com.tencent.mobileqq.uftransfer.api.a aVar, Bundle bundle, com.tencent.mobileqq.uftransfer.api.d dVar) {
            return -1;
        }

        k i() {
            k kVar = new k(true);
            kVar.a().l(true);
            kVar.a().m(com.tencent.mobileqq.filemanager.core.d.c().isConfigEnableIPV6(this.f209093a, 5));
            return kVar;
        }

        abstract void j();

        void k(int i3) {
            this.f209094b = true;
            if (this.f209096d != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("REASON", i3);
                ((IUFTTransferService) this.f209093a.getRuntimeService(IUFTTransferService.class, "")).stop(this.f209096d, bundle);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void g(com.tencent.mobileqq.uftransfer.api.a aVar) {
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void b(com.tencent.mobileqq.uftransfer.api.a aVar, h hVar) {
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void d(com.tencent.mobileqq.uftransfer.api.a aVar, i iVar) {
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

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void h(com.tencent.mobileqq.uftransfer.api.a aVar, long j3, long j16, long j17) {
        }
    }
}
