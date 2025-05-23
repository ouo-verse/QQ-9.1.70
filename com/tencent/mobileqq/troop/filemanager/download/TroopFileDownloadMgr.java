package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileDownloadMgr extends Observable implements TroopFileDownloadWorker.b, INetInfoHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static TroopFileDownloadMgr f295851i;

    /* renamed from: d, reason: collision with root package name */
    private Map<UUID, TroopFileDownloadWorker> f295852d;

    /* renamed from: e, reason: collision with root package name */
    private LinkedList<UUID> f295853e;

    /* renamed from: f, reason: collision with root package name */
    private LinkedList<TroopFileDownloadWorker> f295854f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f295855h;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr$5, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass5 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f295857d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TroopFileTransferManager.Item f295858e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bundle f295859f;
        final /* synthetic */ TroopFileDownloadMgr this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.this$0.p(this.f295857d, this.f295858e, this.f295859f);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class FileDownloadMgrObserver implements Observer {
        static IPatchRedirector $redirector_;

        public FileDownloadMgrObserver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(Object obj) {
            Object[] objArr = (Object[]) obj;
            int intValue = ((Integer) objArr[0]).intValue();
            Object[] objArr2 = (Object[]) objArr[1];
            if (intValue == 1) {
                c((Set) objArr2[0]);
            }
        }

        protected void c(Set<Long> set) {
            throw null;
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) observable, obj);
                return;
            }
            if (obj == null) {
                return;
            }
            Looper mainLooper = Looper.getMainLooper();
            if (Thread.currentThread() != mainLooper.getThread()) {
                new Handler(mainLooper).post(new Runnable(obj) { // from class: com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.FileDownloadMgrObserver.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Object f295872d;

                    {
                        this.f295872d = obj;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FileDownloadMgrObserver.this, obj);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            FileDownloadMgrObserver.this.b(this.f295872d);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
            } else {
                b(obj);
            }
        }
    }

    TroopFileDownloadMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f295852d = new HashMap();
        this.f295853e = new LinkedList<>();
        this.f295854f = new LinkedList<>();
        this.f295855h = false;
    }

    public static synchronized TroopFileDownloadMgr g() {
        TroopFileDownloadMgr troopFileDownloadMgr;
        synchronized (TroopFileDownloadMgr.class) {
            if (f295851i == null) {
                f295851i = new TroopFileDownloadMgr();
            }
            troopFileDownloadMgr = f295851i;
        }
        return troopFileDownloadMgr;
    }

    private String i() {
        return " WS:" + this.f295852d.size() + " QS:" + this.f295853e.size() + " RS:" + this.f295854f.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(int i3, Object[] objArr) {
        setChanged();
        notifyObservers(new Object[]{Integer.valueOf(i3), objArr});
    }

    private void n() {
        if (this.f295854f.size() >= 2) {
            return;
        }
        while (this.f295853e.size() > 0) {
            TroopFileDownloadWorker remove = this.f295852d.remove(this.f295853e.remove(0));
            if (remove != null) {
                this.f295854f.add(remove);
                if (!remove.D()) {
                    this.f295854f.remove(remove);
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p(long j3, TroopFileTransferManager.Item item, Bundle bundle) {
        if (v(item.Id)) {
            e.b.c("TroopFileDownloadMgr", e.b.f295938b, "[" + item.Id.toString() + "] startDownload worker exsited. ");
            return -4;
        }
        d G = d.G(com.tencent.mobileqq.troop.filemanager.e.b(), j3, item, bundle, this);
        if (G == null) {
            return -3;
        }
        this.f295852d.put(item.Id, G);
        this.f295853e.add(item.Id);
        G.u();
        n();
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int r(long j3, TroopFileTransferManager.Item item, Bundle bundle) {
        if (v(item.Id)) {
            e.b.c("TroopFileDownloadMgr", e.b.f295938b, "[" + item.Id.toString() + "] startDownloadZipInnerFile worker exsited. ");
            return -4;
        }
        f G = f.G(j3, item, bundle, this);
        if (G == null) {
            return -3;
        }
        this.f295852d.put(item.Id, G);
        this.f295853e.add(item.Id);
        G.u();
        e.b.c("TroopFileDownloadMgr", e.b.f295938b, "[" + item.Id.toString() + "] startDownloadZipInnerFile filePath. " + item.FilePath + i());
        n();
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u(UUID uuid, Bundle bundle) {
        boolean z16;
        Iterator<TroopFileDownloadWorker> it = this.f295854f.iterator();
        while (true) {
            if (it.hasNext()) {
                TroopFileDownloadWorker next = it.next();
                if (uuid.equals(next.p())) {
                    next.F(0);
                    it.remove();
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            TroopFileDownloadWorker remove = this.f295852d.remove(uuid);
            if (remove != null) {
                remove.F(0);
                z16 |= true;
            }
            z16 |= this.f295853e.remove(uuid);
        }
        if (z16) {
            e.b.c("TroopFileDownloadMgr", e.b.f295938b, "[" + uuid.toString() + "] stopDownload." + i());
        }
        n();
        return 0;
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker.b
    public void a(UUID uuid, boolean z16, int i3, TroopFileDownloadWorker troopFileDownloadWorker) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, uuid, Boolean.valueOf(z16), Integer.valueOf(i3), troopFileDownloadWorker);
        } else {
            TroopFileTransferMgr.N0(new Runnable(uuid, z16, i3, troopFileDownloadWorker) { // from class: com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ UUID f295868d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f295869e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f295870f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ TroopFileDownloadWorker f295871h;

                {
                    this.f295868d = uuid;
                    this.f295869e = z16;
                    this.f295870f = i3;
                    this.f295871h = troopFileDownloadWorker;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopFileDownloadMgr.this, uuid, Boolean.valueOf(z16), Integer.valueOf(i3), troopFileDownloadWorker);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TroopFileDownloadMgr.this.l(this.f295868d, this.f295869e, this.f295870f, this.f295871h);
                    }
                }
            }, true);
        }
    }

    protected void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        e.b.e("TroopFileDownloadMgr", e.b.f295938b, "failAll. reason:" + i3);
        TroopFileTransferMgr.N0(new Runnable(i3) { // from class: com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.10
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f295856d;

            {
                this.f295856d = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileDownloadMgr.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    TroopFileDownloadMgr.this.s(this.f295856d, null);
                }
            }
        }, false);
    }

    public int h(long j3, TroopFileTransferManager.Item item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), item)).intValue();
        }
        if (j3 != 0 && item != null) {
            if (item.Id == null) {
                return -2;
            }
            e c16 = e.c(j3, item);
            if (c16 == null) {
                return -3;
            }
            if (c16.b()) {
                return 0;
            }
            return -5;
        }
        return -1;
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            e.b.c("TroopFileDownloadMgr", e.b.f295938b, "init");
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileDownloadMgr.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (TroopFileDownloadMgr.this.f295855h) {
                        return;
                    }
                    QQAppInterface b16 = com.tencent.mobileqq.troop.filemanager.e.b();
                    if (b16 != null) {
                        AppNetConnInfo.registerConnectionChangeReceiver(b16.getApplication(), TroopFileDownloadMgr.this);
                        TroopFileDownloadMgr.this.f295855h = true;
                    } else {
                        e.b.b("TroopFileDownloadMgr", e.b.f295938b, "init registerConnectionChangeReceiver fail");
                    }
                }
            });
        }
    }

    protected void l(UUID uuid, boolean z16, int i3, TroopFileDownloadWorker troopFileDownloadWorker) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, uuid, Boolean.valueOf(z16), Integer.valueOf(i3), troopFileDownloadWorker);
            return;
        }
        this.f295854f.remove(troopFileDownloadWorker);
        e.b.c("TroopFileDownloadMgr", e.b.f295938b, "[" + uuid.toString() + "] onWorkDoneInter. bSuc:" + z16 + " errCode:" + i3 + i());
        n();
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        e.b.c("TroopFileDownloadMgr", e.b.f295938b, "release");
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileDownloadMgr.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TroopFileDownloadMgr troopFileDownloadMgr = TroopFileDownloadMgr.this;
                if (!troopFileDownloadMgr.f295855h) {
                    return;
                }
                AppNetConnInfo.unregisterNetInfoHandler(troopFileDownloadMgr);
                TroopFileDownloadMgr.this.f295855h = false;
            }
        });
        TroopFileTransferMgr.N0(new Runnable() { // from class: com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileDownloadMgr.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    TroopFileDownloadMgr.this.s(2, null);
                }
            }
        }, true);
    }

    public int o(long j3, TroopFileTransferManager.Item item, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), item, bundle)).intValue();
        }
        if (j3 != 0 && item != null) {
            if (item.Id == null) {
                e.b.b("TroopFileDownloadMgr", e.b.f295938b, "startDownload item.id null.");
                return -2;
            }
            TroopFileTransferMgr.N0(new Runnable(j3, item, bundle) { // from class: com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f295860d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TroopFileTransferManager.Item f295861e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bundle f295862f;

                {
                    this.f295860d = j3;
                    this.f295861e = item;
                    this.f295862f = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopFileDownloadMgr.this, Long.valueOf(j3), item, bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TroopFileDownloadMgr.this.p(this.f295860d, this.f295861e, this.f295862f);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, false);
            return 0;
        }
        e.b.b("TroopFileDownloadMgr", e.b.f295938b, "startDownload key param invaild.");
        return -1;
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            e.b.c("TroopFileDownloadMgr", e.b.f295938b, "onNetMobile2None");
            f(3);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else {
            e.b.c("TroopFileDownloadMgr", e.b.f295938b, "onNetMobile2Wifi");
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            e.b.c("TroopFileDownloadMgr", e.b.f295938b, "onNetNone2Mobile");
            TroopFileTransferMgr.N0(new Runnable() { // from class: com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.11
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileDownloadMgr.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    HashSet hashSet = new HashSet();
                    TroopFileDownloadMgr.this.s(1, hashSet);
                    TroopFileDownloadMgr.this.k(1, new Object[]{hashSet});
                }
            }, false);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            e.b.c("TroopFileDownloadMgr", e.b.f295938b, "onNetNone2Wifi");
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            TroopFileTransferMgr.N0(new Runnable() { // from class: com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.12
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileDownloadMgr.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    HashSet hashSet = new HashSet();
                    TroopFileDownloadMgr.this.s(1, hashSet);
                    TroopFileDownloadMgr.this.k(1, new Object[]{hashSet});
                }
            }, false);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            e.b.c("TroopFileDownloadMgr", e.b.f295938b, "onNetWifi2None");
            f(3);
        }
    }

    public int q(long j3, TroopFileTransferManager.Item item, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), item, bundle)).intValue();
        }
        if (j3 != 0 && item != null) {
            if (item.Id == null) {
                e.b.b("TroopFileDownloadMgr", e.b.f295938b, "startDownloadZipInnerFile item.id null.");
                return -2;
            }
            TroopFileTransferMgr.N0(new Runnable(j3, item, bundle) { // from class: com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f295863d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TroopFileTransferManager.Item f295864e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bundle f295865f;

                {
                    this.f295863d = j3;
                    this.f295864e = item;
                    this.f295865f = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopFileDownloadMgr.this, Long.valueOf(j3), item, bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TroopFileDownloadMgr.this.r(this.f295863d, this.f295864e, this.f295865f);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, false);
            return 0;
        }
        e.b.b("TroopFileDownloadMgr", e.b.f295938b, "startDownloadZipInnerFile key param invaild.");
        return -1;
    }

    protected void s(int i3, Set<Long> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) set);
            return;
        }
        Iterator<TroopFileDownloadWorker> it = this.f295854f.iterator();
        while (it.hasNext()) {
            TroopFileDownloadWorker next = it.next();
            next.F(i3);
            if (set != null) {
                set.add(Long.valueOf(next.s()));
            }
        }
        this.f295854f.clear();
        for (TroopFileDownloadWorker troopFileDownloadWorker : this.f295852d.values()) {
            troopFileDownloadWorker.F(i3);
            if (set != null) {
                set.add(Long.valueOf(troopFileDownloadWorker.s()));
            }
        }
        this.f295852d.clear();
        this.f295853e.clear();
        e.b.c("TroopFileDownloadMgr", e.b.f295938b, "stopAllInter");
    }

    public int t(UUID uuid, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) uuid, (Object) bundle)).intValue();
        }
        if (uuid == null) {
            e.b.b("TroopFileDownloadMgr", e.b.f295938b, "stopUpload item.id null.");
            return -2;
        }
        TroopFileTransferMgr.N0(new Runnable(uuid, bundle) { // from class: com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.8
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ UUID f295866d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f295867e;

            {
                this.f295866d = uuid;
                this.f295867e = bundle;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopFileDownloadMgr.this, uuid, bundle);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    TroopFileDownloadMgr.this.u(this.f295866d, this.f295867e);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, false);
        return 0;
    }

    protected boolean v(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) uuid)).booleanValue();
        }
        Iterator<TroopFileDownloadWorker> it = this.f295854f.iterator();
        while (it.hasNext()) {
            if (uuid.equals(it.next().p())) {
                return true;
            }
        }
        if (this.f295852d.containsKey(uuid)) {
            return true;
        }
        return false;
    }
}
