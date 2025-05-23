package com.tencent.mobileqq.troop.filemanager.thumbnail;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileThumbnailFetchMgr implements TroopFileThumbnailFetchWorker.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, TroopFileThumbnailFetchWorker> f295956a;

    /* renamed from: b, reason: collision with root package name */
    private LinkedList<String> f295957b;

    /* renamed from: c, reason: collision with root package name */
    private LinkedList<TroopFileThumbnailFetchWorker> f295958c;

    public TroopFileThumbnailFetchMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f295956a = new HashMap();
        this.f295957b = new LinkedList<>();
        this.f295958c = new LinkedList<>();
    }

    public static String c(UUID uuid, int i3) {
        return uuid.toString() + "_" + i3;
    }

    private String d() {
        return " WS:" + this.f295956a.size() + " QS:" + this.f295957b.size() + " RS:" + this.f295958c.size();
    }

    private void h() {
        if (this.f295958c.size() >= 10) {
            return;
        }
        while (this.f295957b.size() > 0) {
            TroopFileThumbnailFetchWorker remove = this.f295956a.remove(this.f295957b.remove(0));
            if (remove != null) {
                this.f295958c.add(remove);
                if (!remove.p()) {
                    this.f295958c.remove(remove);
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker.b
    public void a(String str, boolean z16, int i3, TroopFileThumbnailFetchWorker troopFileThumbnailFetchWorker) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), troopFileThumbnailFetchWorker);
        } else {
            TroopFileTransferMgr.N0(new Runnable(str, z16, i3, troopFileThumbnailFetchWorker) { // from class: com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchMgr.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f295959d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f295960e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f295961f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ TroopFileThumbnailFetchWorker f295962h;

                {
                    this.f295959d = str;
                    this.f295960e = z16;
                    this.f295961f = i3;
                    this.f295962h = troopFileThumbnailFetchWorker;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopFileThumbnailFetchMgr.this, str, Boolean.valueOf(z16), Integer.valueOf(i3), troopFileThumbnailFetchWorker);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TroopFileThumbnailFetchMgr.this.f(this.f295959d, this.f295960e, this.f295961f, this.f295962h);
                    }
                }
            }, false);
        }
    }

    public int b(long j3, TroopFileTransferManager.Item item, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), item, Integer.valueOf(i3))).intValue();
        }
        if (j3 != 0 && item != null) {
            UUID uuid = item.Id;
            if (uuid == null) {
                return -2;
            }
            if (i3 == 0) {
                return -5;
            }
            String c16 = c(uuid, i3);
            if (k(c16)) {
                e.b.c("TroopFileThumbnailFetchMgr", e.b.f295938b, "[" + c16 + "] fetchFileThumbnail worker exsited. ");
                return -4;
            }
            TroopFileThumbnailFetchWorker k3 = TroopFileThumbnailFetchWorker.k(j3, item, i3, this);
            if (k3 == null) {
                return -3;
            }
            TroopFileThumbnailMgr.m(item, i3);
            this.f295956a.put(c16, k3);
            this.f295957b.add(c16);
            e.b.c("TroopFileThumbnailFetchMgr", e.b.f295938b, "[" + c16 + "] fetchFileThumbnail fileName. " + item.FileName + d());
            h();
            return 0;
        }
        return -1;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    protected void f(String str, boolean z16, int i3, TroopFileThumbnailFetchWorker troopFileThumbnailFetchWorker) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), troopFileThumbnailFetchWorker);
            return;
        }
        this.f295958c.remove(troopFileThumbnailFetchWorker);
        e.b.c("TroopFileThumbnailFetchMgr", e.b.f295938b, "[" + str + "] onWorkDoneInter. bSuc:" + z16 + " errCode:" + i3 + d());
        h();
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            i();
        }
    }

    protected void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Iterator<TroopFileThumbnailFetchWorker> it = this.f295958c.iterator();
        while (it.hasNext()) {
            it.next().r();
        }
        this.f295958c.clear();
        Iterator<TroopFileThumbnailFetchWorker> it5 = this.f295956a.values().iterator();
        while (it5.hasNext()) {
            it5.next().r();
        }
        this.f295956a.clear();
        this.f295957b.clear();
        e.b.c("TroopFileThumbnailFetchMgr", e.b.f295938b, "stopAllInter");
    }

    public int j(UUID uuid, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) uuid, i3)).intValue();
        }
        if (uuid == null) {
            return -2;
        }
        String c16 = c(uuid, i3);
        Iterator<TroopFileThumbnailFetchWorker> it = this.f295958c.iterator();
        while (true) {
            if (it.hasNext()) {
                TroopFileThumbnailFetchWorker next = it.next();
                if (c16.equalsIgnoreCase(next.j())) {
                    next.r();
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
            TroopFileThumbnailFetchWorker remove = this.f295956a.remove(uuid);
            if (remove != null) {
                remove.r();
                z16 |= true;
            }
            z16 |= this.f295957b.remove(uuid);
        }
        if (z16) {
            e.b.c("TroopFileThumbnailFetchMgr", e.b.f295938b, "[" + c16 + "] stopFetch. " + d());
        }
        h();
        return 0;
    }

    protected boolean k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        Iterator<TroopFileThumbnailFetchWorker> it = this.f295958c.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next().j())) {
                return true;
            }
        }
        if (this.f295956a.containsKey(str)) {
            return true;
        }
        return false;
    }
}
