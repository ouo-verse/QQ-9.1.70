package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.filemanager.nt.NTFileManageBridger;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.k;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QFileC2CTransferWrapper {

    /* renamed from: a, reason: collision with root package name */
    private final QQAppInterface f209039a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Long, c> f209040b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private h f209041c = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements h {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.h
        public void a(long j3) {
            QFileC2CTransferWrapper.this.i(j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements NTFileManageBridger.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f209044a;

        b(i iVar) {
            this.f209044a = iVar;
        }

        @Override // com.tencent.mobileqq.filemanager.nt.NTFileManageBridger.g
        public void a() {
            i iVar = this.f209044a;
            FileManagerEntity fileManagerEntity = iVar.f209068f;
            if (fileManagerEntity == null) {
                return;
            }
            iVar.f209048c.a(fileManagerEntity.nSessionId);
        }

        @Override // com.tencent.mobileqq.filemanager.nt.NTFileManageBridger.g
        public void b(int i3, String str) {
            i iVar = this.f209044a;
            FileManagerEntity fileManagerEntity = iVar.f209068f;
            if (fileManagerEntity == null) {
                return;
            }
            iVar.f209048c.a(fileManagerEntity.nSessionId);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f209051a;

        /* renamed from: b, reason: collision with root package name */
        public int f209052b;

        /* renamed from: c, reason: collision with root package name */
        public String f209053c;

        /* renamed from: d, reason: collision with root package name */
        public long f209054d;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f209055e;

        /* renamed from: f, reason: collision with root package name */
        public String f209056f;
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e extends c {

        /* renamed from: f, reason: collision with root package name */
        final g f209057f;

        /* renamed from: g, reason: collision with root package name */
        final d f209058g;

        /* renamed from: h, reason: collision with root package name */
        final long f209059h;

        /* renamed from: i, reason: collision with root package name */
        final long f209060i;

        /* renamed from: j, reason: collision with root package name */
        String f209061j;

        /* renamed from: k, reason: collision with root package name */
        String f209062k;

        /* renamed from: l, reason: collision with root package name */
        String f209063l;

        /* renamed from: m, reason: collision with root package name */
        int f209064m;

        /* renamed from: n, reason: collision with root package name */
        int f209065n;

        /* renamed from: o, reason: collision with root package name */
        int f209066o;

        public e(QQAppInterface qQAppInterface, long j3, d dVar, h hVar, g gVar) {
            super(qQAppInterface, hVar);
            this.f209057f = gVar;
            this.f209058g = dVar;
            this.f209059h = j3;
            this.f209060i = FileManagerUtil.getFileSizes(dVar.f209051a);
            this.f209050e = com.tencent.mobileqq.filemanager.fileassistant.util.h.k(dVar.f209053c);
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.c, com.tencent.mobileqq.uftransfer.api.b
        public void b(com.tencent.mobileqq.uftransfer.api.a aVar, com.tencent.mobileqq.uftransfer.api.h hVar) {
            this.f209062k = vb1.a.b(hVar.a());
            this.f209063l = vb1.a.b(hVar.c());
            this.f209064m = hVar.h();
            this.f209065n = hVar.g();
            this.f209066o = hVar.e();
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.c, com.tencent.mobileqq.uftransfer.api.b
        public void d(com.tencent.mobileqq.uftransfer.api.a aVar, com.tencent.mobileqq.uftransfer.api.i iVar) {
            if (!TextUtils.isEmpty(iVar.a())) {
                this.f209061j = iVar.a();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.c, com.tencent.mobileqq.uftransfer.api.b
        public void f(com.tencent.mobileqq.uftransfer.api.a aVar, int i3, com.tencent.mobileqq.uftransfer.api.c cVar) {
            if (this.f209047b) {
                return;
            }
            if (this.f209057f != null) {
                Bundle bundle = new Bundle();
                bundle.putString("strFileId", this.f209061j);
                bundle.putString("str10MMd5", this.f209062k);
                bundle.putString("strSha", this.f209063l);
                bundle.putInt("width", this.f209064m);
                bundle.putInt("height", this.f209065n);
                bundle.putInt("duration", this.f209066o);
                this.f209057f.a(i3, true, bundle);
            }
            Object a16 = this.f209049d.a();
            if (a16 instanceof Long) {
                this.f209048c.a(((Long) a16).longValue());
            }
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.c
        long i() {
            return this.f209060i;
        }

        void l() {
            this.f209047b = false;
            com.tencent.mobileqq.uftransfer.api.f fVar = new com.tencent.mobileqq.uftransfer.api.f();
            fVar.g(this.f209058g.f209051a);
            fVar.i(false);
            fVar.h(true);
            fVar.k(this.f209058g.f209053c);
            fVar.j(this.f209058g.f209052b);
            fVar.p(this.f209058g.f209054d);
            fVar.q(this.f209058g.f209055e);
            fVar.r(this.f209058g.f209056f);
            fVar.l(Long.valueOf(this.f209059h));
            this.f209049d = ((IUFTTransferService) this.f209046a.getRuntimeService(IUFTTransferService.class, "")).uploadC2CFile(fVar, j(), this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static class f extends c {
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface g {
        void a(int i3, boolean z16, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface h {
        void a(long j3);
    }

    public QFileC2CTransferWrapper(QQAppInterface qQAppInterface) {
        this.f209039a = qQAppInterface;
    }

    private void c(long j3, c cVar) {
        synchronized (this) {
            this.f209040b.put(Long.valueOf(j3), cVar);
        }
    }

    private c g(long j3) {
        c cVar;
        synchronized (this) {
            cVar = this.f209040b.get(Long.valueOf(j3));
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c i(long j3) {
        c remove;
        synchronized (this) {
            remove = this.f209040b.remove(Long.valueOf(j3));
        }
        return remove;
    }

    public void b(List<String> list, String str, String str2, String str3, int i3, long j3, int i16, Bundle bundle) {
        String str4;
        if (TextUtils.isEmpty(str3)) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2);
            QLog.w("QFileC2CTransferWrapper<FileAssistant>", 1, "send local file to c2c no peerUid, to get uid. toUin:" + str2);
            str4 = uidFromUin;
        } else {
            str4 = str3;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str5 = str4;
            String str6 = str4;
            ArrayList arrayList3 = arrayList2;
            i iVar = new i(this.f209039a, it.next(), str, str2, str5, i3, j3, i16, bundle, this.f209041c);
            arrayList.add(new b(iVar));
            arrayList3.add(iVar);
            arrayList2 = arrayList3;
            str4 = str6;
        }
        ArrayList arrayList4 = arrayList2;
        List<FileManagerEntity> F = this.f209039a.getNTFileManageBridger().F(list, str, str2, str3, i3, j3, i16, bundle, arrayList);
        if (F != null) {
            for (int i17 = 0; i17 < F.size(); i17++) {
                c(F.get(i17).nSessionId, (c) arrayList4.get(i17));
            }
        }
    }

    public boolean d(long j3) {
        c i3 = i(j3);
        if (i3 == null) {
            return false;
        }
        return i3.k(0);
    }

    public void e() {
        HashMap hashMap = new HashMap();
        synchronized (this) {
            hashMap.putAll(this.f209040b);
            this.f209040b.clear();
        }
        Iterator it = hashMap.values().iterator();
        while (it.hasNext()) {
            ((c) it.next()).k(4);
        }
    }

    public void f() {
        HashMap hashMap = new HashMap();
        synchronized (this) {
            hashMap.putAll(this.f209040b);
            this.f209040b.clear();
        }
        Iterator it = hashMap.values().iterator();
        while (it.hasNext()) {
            ((c) it.next()).k(3);
        }
    }

    public boolean h(long j3) {
        if (g(j3) != null) {
            return true;
        }
        return false;
    }

    public void j(final FileManagerEntity fileManagerEntity) {
        QLog.i("QFileC2CTransferWrapper<FileAssistant>", 1, "resendFile Id[" + fileManagerEntity.nSessionId + "]");
        if (!d(fileManagerEntity.nSessionId)) {
            l(fileManagerEntity);
        } else {
            ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.3
                @Override // java.lang.Runnable
                public void run() {
                    QFileC2CTransferWrapper.this.l(fileManagerEntity);
                }
            });
        }
    }

    public FileManagerEntity k(String str, String str2, String str3, String str4, int i3, long j3, int i16, Bundle bundle) {
        String str5;
        if (TextUtils.isEmpty(str4)) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str3);
            QLog.w("QFileC2CTransferWrapper<FileAssistant>", 1, "send local file to c2c no peerUid, to get uid. toUin:" + str3);
            str5 = uidFromUin;
        } else {
            str5 = str4;
        }
        i iVar = new i(this.f209039a, str, str2, str3, str5, i3, j3, i16, bundle, this.f209041c);
        iVar.m();
        FileManagerEntity l3 = iVar.l();
        if (l3 == null) {
            QQToast.makeText(BaseApplicationImpl.getApplication(), 1, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR, 1).show();
            return null;
        }
        c(l3.nSessionId, iVar);
        return l3;
    }

    public void l(FileManagerEntity fileManagerEntity) {
        i iVar = new i(this.f209039a, fileManagerEntity, this.f209041c);
        c(fileManagerEntity.nSessionId, iVar);
        iVar.m();
    }

    public long m(d dVar, g gVar) {
        long longValue = FileManagerUtil.genSessionId().longValue();
        QLog.i("QFileC2CTransferWrapper<FileAssistant>", 1, "sendFile4MultiFwd Id[" + longValue + "]");
        e eVar = new e(this.f209039a, longValue, dVar, this.f209041c, gVar);
        c(longValue, eVar);
        eVar.l();
        return longValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class i extends c {

        /* renamed from: f, reason: collision with root package name */
        FileManagerEntity f209068f;

        /* renamed from: g, reason: collision with root package name */
        String f209069g;

        /* renamed from: h, reason: collision with root package name */
        String f209070h;

        /* renamed from: i, reason: collision with root package name */
        String f209071i;

        /* renamed from: j, reason: collision with root package name */
        String f209072j;

        /* renamed from: k, reason: collision with root package name */
        int f209073k;

        /* renamed from: l, reason: collision with root package name */
        long f209074l;

        /* renamed from: m, reason: collision with root package name */
        int f209075m;

        /* renamed from: n, reason: collision with root package name */
        Bundle f209076n;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes12.dex */
        public class a implements NTFileManageBridger.g {
            a() {
            }

            @Override // com.tencent.mobileqq.filemanager.nt.NTFileManageBridger.g
            public void a() {
                i iVar = i.this;
                iVar.f209048c.a(iVar.f209068f.nSessionId);
            }

            @Override // com.tencent.mobileqq.filemanager.nt.NTFileManageBridger.g
            public void b(int i3, String str) {
                i iVar = i.this;
                FileManagerEntity fileManagerEntity = iVar.f209068f;
                if (fileManagerEntity == null) {
                    return;
                }
                iVar.f209048c.a(fileManagerEntity.nSessionId);
            }
        }

        public i(QQAppInterface qQAppInterface, String str, String str2, String str3, String str4, int i3, long j3, int i16, Bundle bundle, h hVar) {
            super(qQAppInterface, hVar);
            this.f209069g = str;
            this.f209070h = str2;
            this.f209071i = str3;
            this.f209072j = str4;
            this.f209073k = i3;
            this.f209074l = j3;
            this.f209075m = i16;
            this.f209076n = bundle;
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.c
        long i() {
            FileManagerEntity fileManagerEntity = this.f209068f;
            if (fileManagerEntity != null) {
                return fileManagerEntity.fileSize;
            }
            return 0L;
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.c
        boolean k(int i3) {
            if (this.f209068f != null) {
                QLog.e("QFileC2CTransferWrapper<FileAssistant>", 1, "Id[" + this.f209068f.nSessionId + "] stop reason:" + i3);
                this.f209046a.getNTFileManageBridger().M(this.f209068f);
                return true;
            }
            return false;
        }

        FileManagerEntity l() {
            return this.f209068f;
        }

        void m() {
            a aVar = new a();
            FileManagerEntity fileManagerEntity = this.f209068f;
            if (fileManagerEntity == null) {
                this.f209068f = this.f209046a.getNTFileManageBridger().I0(this.f209069g, this.f209070h, this.f209071i, this.f209072j, this.f209073k, this.f209074l, this.f209075m, this.f209076n, aVar);
                return;
            }
            if (fileManagerEntity.ntMsgId != 0) {
                QLog.i("QFileC2CTransferWrapper<FileAssistant>", 1, "Id[" + this.f209068f.nSessionId + "] resend local file to c2c use nt, filePath:" + this.f209069g);
                this.f209046a.getNTFileManageBridger().G0(this.f209068f, aVar);
                return;
            }
            QLog.e("QFileC2CTransferWrapper<FileAssistant>", 1, "=_= ! Id[" + this.f209068f.nSessionId + "] send error!");
        }

        public i(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity, h hVar) {
            super(qQAppInterface, hVar);
            this.f209068f = fileManagerEntity;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static abstract class c implements com.tencent.mobileqq.uftransfer.api.b {

        /* renamed from: a, reason: collision with root package name */
        final QQAppInterface f209046a;

        /* renamed from: c, reason: collision with root package name */
        final h f209048c;

        /* renamed from: d, reason: collision with root package name */
        com.tencent.mobileqq.uftransfer.api.a f209049d;

        /* renamed from: b, reason: collision with root package name */
        boolean f209047b = true;

        /* renamed from: e, reason: collision with root package name */
        boolean f209050e = false;

        public c(QQAppInterface qQAppInterface, h hVar) {
            this.f209046a = qQAppInterface;
            this.f209048c = hVar;
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public int a(com.tencent.mobileqq.uftransfer.api.a aVar, Bundle bundle, com.tencent.mobileqq.uftransfer.api.d dVar) {
            return -1;
        }

        abstract long i();

        protected k j() {
            ExcitingTransferUploadChnConfigInfo excitingTransferUploadChnConfigInfo;
            k kVar = new k(true);
            IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.f209046a.getRuntimeService(IQFileConfigManager.class, "");
            kVar.a().l(true);
            kVar.a().m(com.tencent.mobileqq.filemanager.core.d.c().isConfigEnableIPV6(this.f209046a, 1));
            kVar.a().n(true);
            if (i() > ((IExcitingTransferAdapter) this.f209046a.getRuntimeService(IExcitingTransferAdapter.class, "")).getC2CUploadLimitedSize()) {
                kVar.a().k(true);
                kVar.a().i(true);
            }
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
            if (this.f209050e) {
                kVar.a().k(true);
                kVar.a().i(false);
            }
            return kVar;
        }

        boolean k(int i3) {
            this.f209047b = true;
            if (this.f209049d != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("REASON", i3);
                ((IUFTTransferService) this.f209046a.getRuntimeService(IUFTTransferService.class, "")).stop(this.f209049d, bundle);
            }
            return true;
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
