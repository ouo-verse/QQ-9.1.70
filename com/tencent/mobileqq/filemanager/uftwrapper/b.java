package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.filemanager.nt.NTFileManageBridger;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.h;
import com.tencent.mobileqq.uftransfer.api.i;
import com.tencent.mobileqq.uftransfer.api.k;
import com.tencent.mobileqq.uftransfer.api.l;
import com.tencent.mobileqq.uftransfer.api.m;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final QQAppInterface f209112a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<UUID, e> f209113b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC7583b f209114c = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements InterfaceC7583b {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.b.InterfaceC7583b
        public void a(UUID uuid) {
            b.this.e(uuid);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.uftwrapper.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    interface InterfaceC7583b {
        void a(UUID uuid);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
        void a(int i3, boolean z16, Bundle bundle);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static class d extends e {

        /* renamed from: f, reason: collision with root package name */
        boolean f209116f;

        /* renamed from: g, reason: collision with root package name */
        final TroopFileTransferManager.Item f209117g;

        /* renamed from: h, reason: collision with root package name */
        final Bundle f209118h;

        /* renamed from: i, reason: collision with root package name */
        long f209119i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes12.dex */
        public class a implements NTFileManageBridger.g {
            a() {
            }

            @Override // com.tencent.mobileqq.filemanager.nt.NTFileManageBridger.g
            public void a() {
                d dVar = d.this;
                dVar.f209124d.a(dVar.f209117g.Id);
            }

            @Override // com.tencent.mobileqq.filemanager.nt.NTFileManageBridger.g
            public void b(int i3, String str) {
                d dVar = d.this;
                dVar.f209124d.a(dVar.f209117g.Id);
            }
        }

        d(QQAppInterface qQAppInterface, long j3, TroopFileTransferManager.Item item, Bundle bundle, InterfaceC7583b interfaceC7583b) {
            super(qQAppInterface, j3, interfaceC7583b);
            this.f209116f = false;
            this.f209119i = 0L;
            this.f209117g = item;
            this.f209118h = bundle;
            this.f209116f = item.isFromAIO;
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.b.e
        long i() {
            return this.f209119i;
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.b.e
        void k(int i3) {
            QLog.e("QFileTroopTransferWrapper<FileAssistant>", 1, "Id[" + this.f209117g.idStr() + "] stop reason:" + i3);
            this.f209121a.getNTFileManageBridger().N(this.f209117g);
        }

        void l() {
            QLog.i("QFileTroopTransferWrapper<FileAssistant>", 1, "send local to troop file use nt, filePath:" + this.f209117g.FileName + "toUid:" + this.f209117g.troopuin + " id:" + this.f209117g.idStr());
            this.f209121a.getNTFileManageBridger().L0(this.f209123c, this.f209117g, this.f209118h, new a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static class f extends e {

        /* renamed from: f, reason: collision with root package name */
        final String f209126f;

        /* renamed from: g, reason: collision with root package name */
        final UUID f209127g;

        /* renamed from: h, reason: collision with root package name */
        final String f209128h;

        /* renamed from: i, reason: collision with root package name */
        int f209129i;

        /* renamed from: j, reason: collision with root package name */
        final c f209130j;

        /* renamed from: k, reason: collision with root package name */
        String f209131k;

        /* renamed from: l, reason: collision with root package name */
        String f209132l;

        /* renamed from: m, reason: collision with root package name */
        String f209133m;

        /* renamed from: n, reason: collision with root package name */
        long f209134n;

        /* renamed from: o, reason: collision with root package name */
        int f209135o;

        /* renamed from: p, reason: collision with root package name */
        int f209136p;

        /* renamed from: q, reason: collision with root package name */
        int f209137q;

        public f(QQAppInterface qQAppInterface, UUID uuid, long j3, String str, InterfaceC7583b interfaceC7583b, c cVar) {
            super(qQAppInterface, j3, interfaceC7583b);
            this.f209128h = "";
            this.f209129i = 102;
            this.f209126f = str;
            this.f209127g = uuid;
            this.f209130j = cVar;
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.b.e, com.tencent.mobileqq.uftransfer.api.b
        public void b(com.tencent.mobileqq.uftransfer.api.a aVar, h hVar) {
            this.f209131k = vb1.a.b(hVar.b());
            this.f209132l = vb1.a.b(hVar.c());
            this.f209135o = hVar.h();
            this.f209136p = hVar.g();
            this.f209137q = hVar.e();
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.b.e, com.tencent.mobileqq.uftransfer.api.b
        public void d(com.tencent.mobileqq.uftransfer.api.a aVar, i iVar) {
            if (!TextUtils.isEmpty(iVar.a())) {
                this.f209133m = iVar.a();
            }
            if (iVar instanceof l) {
                this.f209129i = ((l) iVar).k();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.b.e, com.tencent.mobileqq.uftransfer.api.b
        public void f(com.tencent.mobileqq.uftransfer.api.a aVar, int i3, com.tencent.mobileqq.uftransfer.api.c cVar) {
            if (this.f209122b) {
                return;
            }
            if (this.f209130j != null) {
                Bundle bundle = new Bundle();
                bundle.putLong("fileSize", this.f209134n);
                bundle.putString("strFileId", this.f209133m);
                bundle.putString("strMd5", this.f209131k);
                bundle.putString("strSha", this.f209132l);
                bundle.putInt("width", this.f209135o);
                bundle.putInt("height", this.f209136p);
                bundle.putInt("duration", this.f209137q);
                bundle.putInt("busiId", this.f209129i);
                this.f209130j.a(i3, true, bundle);
            }
            Object a16 = this.f209125e.a();
            if (a16 instanceof UUID) {
                this.f209124d.a((UUID) a16);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.uftwrapper.b.e
        long i() {
            if (this.f209134n == 0) {
                this.f209134n = FileManagerUtil.getFileSizes(this.f209126f);
            }
            return this.f209134n;
        }

        public void l() {
            this.f209122b = false;
            m mVar = new m();
            mVar.g(this.f209126f);
            mVar.i(false);
            mVar.h(true);
            mVar.k(String.valueOf(this.f209123c));
            mVar.j(1);
            mVar.l(this.f209127g);
            mVar.r(this.f209129i);
            mVar.t("");
            mVar.s(5);
            this.f209125e = ((IUFTTransferService) this.f209121a.getRuntimeService(IUFTTransferService.class, "")).uploadTroopFile(mVar, j(), this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static class g extends e {
    }

    public b(QQAppInterface qQAppInterface) {
        this.f209112a = qQAppInterface;
    }

    private void b(UUID uuid, e eVar) {
        synchronized (this) {
            this.f209113b.put(uuid, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e e(UUID uuid) {
        e remove;
        synchronized (this) {
            remove = this.f209113b.remove(uuid);
        }
        return remove;
    }

    public boolean c(UUID uuid) {
        e e16 = e(uuid);
        if (e16 == null) {
            return false;
        }
        e16.k(0);
        return true;
    }

    public void d() {
        HashMap hashMap = new HashMap();
        synchronized (this) {
            hashMap.putAll(this.f209113b);
            this.f209113b.clear();
        }
        Iterator it = hashMap.values().iterator();
        while (it.hasNext()) {
            ((e) it.next()).k(3);
        }
    }

    public int f(long j3, TroopFileTransferManager.Item item, Bundle bundle) {
        d dVar = new d(this.f209112a, j3, item, bundle, this.f209114c);
        b(item.Id, dVar);
        dVar.l();
        return 0;
    }

    public UUID g(long j3, String str, c cVar) {
        UUID randomUUID = UUID.randomUUID();
        f fVar = new f(this.f209112a, randomUUID, j3, str, this.f209114c, cVar);
        b(randomUUID, fVar);
        fVar.l();
        return randomUUID;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static abstract class e implements com.tencent.mobileqq.uftransfer.api.b {

        /* renamed from: a, reason: collision with root package name */
        final QQAppInterface f209121a;

        /* renamed from: b, reason: collision with root package name */
        boolean f209122b = true;

        /* renamed from: c, reason: collision with root package name */
        final long f209123c;

        /* renamed from: d, reason: collision with root package name */
        final InterfaceC7583b f209124d;

        /* renamed from: e, reason: collision with root package name */
        com.tencent.mobileqq.uftransfer.api.a f209125e;

        e(QQAppInterface qQAppInterface, long j3, InterfaceC7583b interfaceC7583b) {
            this.f209121a = qQAppInterface;
            this.f209123c = j3;
            this.f209124d = interfaceC7583b;
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public int a(com.tencent.mobileqq.uftransfer.api.a aVar, Bundle bundle, com.tencent.mobileqq.uftransfer.api.d dVar) {
            return -1;
        }

        abstract long i();

        k j() {
            ExcitingTransferUploadChnConfigInfo excitingTransferUploadChnConfigInfo;
            k kVar = new k(true);
            kVar.a().l(true);
            kVar.a().m(com.tencent.mobileqq.filemanager.core.d.c().isConfigEnableIPV6(this.f209121a, 3));
            if (i() > ((IExcitingTransferAdapter) this.f209121a.getRuntimeService(IExcitingTransferAdapter.class, "")).getGroupUploadLimitedSize()) {
                kVar.a().k(true);
                kVar.a().i(true);
            }
            IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.f209121a.getRuntimeService(IQFileConfigManager.class, "");
            if (iQFileConfigManager.getExcitingGroupUploadConfig() != null) {
                excitingTransferUploadChnConfigInfo = iQFileConfigManager.getExcitingGroupUploadConfig().c();
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

        void k(int i3) {
            this.f209122b = true;
            if (this.f209125e != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("REASON", i3);
                ((IUFTTransferService) this.f209121a.getRuntimeService(IUFTTransferService.class, "")).stop(this.f209125e, bundle);
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
