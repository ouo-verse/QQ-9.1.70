package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenTask;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileThumbnailGenMgr implements TroopFileThumbnailGenTask.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, TroopFileThumbnailGenTask> f295980a;

    /* renamed from: b, reason: collision with root package name */
    private LinkedList<String> f295981b;

    /* renamed from: c, reason: collision with root package name */
    private LinkedList<TroopFileThumbnailGenTask> f295982c;

    /* renamed from: d, reason: collision with root package name */
    private LinkedList<TroopFileThumbnailGenTask> f295983d;

    public TroopFileThumbnailGenMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f295980a = new HashMap();
        this.f295981b = new LinkedList<>();
        this.f295982c = new LinkedList<>();
        this.f295983d = new LinkedList<>();
    }

    public static String c(UUID uuid, int i3) {
        return uuid.toString() + "_" + i3;
    }

    private String d() {
        return " WS:" + this.f295980a.size() + " QS:" + this.f295981b.size() + " PRS:" + this.f295983d.size() + " RS:" + this.f295982c.size();
    }

    private boolean f(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<TroopFileThumbnailGenTask> it = this.f295982c.iterator();
        while (it.hasNext()) {
            TroopFileThumbnailGenTask next = it.next();
            if (i3 == next.k() && str.equalsIgnoreCase(next.l())) {
                return true;
            }
        }
        return false;
    }

    private void i() {
        if (this.f295982c.size() >= 4) {
            return;
        }
        while (this.f295981b.size() > 0) {
            TroopFileThumbnailGenTask remove = this.f295980a.remove(this.f295981b.remove(0));
            if (remove != null) {
                if (f(remove.l(), remove.k())) {
                    e.b.e("TroopFileThumbnailGenMgr", e.b.f295938b, "[" + remove.n() + "] has same task gening. add WD task");
                    this.f295983d.add(remove);
                    remove.q();
                } else {
                    this.f295982c.add(remove);
                    if (!remove.t()) {
                        e.b.b("TroopFileThumbnailGenMgr", e.b.f295938b, "[" + remove.n() + "] start failed!!");
                        this.f295982c.remove(remove);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private LinkedList<TroopFileThumbnailGenTask> l(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LinkedList<TroopFileThumbnailGenTask> linkedList = new LinkedList<>();
        Iterator<Map.Entry<String, TroopFileThumbnailGenTask>> it = this.f295980a.entrySet().iterator();
        while (it.hasNext()) {
            TroopFileThumbnailGenTask value = it.next().getValue();
            if (i3 == value.k() && str.equalsIgnoreCase(value.l())) {
                linkedList.add(value);
                it.remove();
            }
        }
        Iterator<TroopFileThumbnailGenTask> it5 = this.f295983d.iterator();
        while (it5.hasNext()) {
            TroopFileThumbnailGenTask next = it5.next();
            if (i3 == next.k() && str.equalsIgnoreCase(next.l())) {
                linkedList.add(next);
                it5.remove();
            }
        }
        return linkedList;
    }

    @Override // com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenTask.a
    public void a(String str, boolean z16, int i3, TroopFileThumbnailGenTask troopFileThumbnailGenTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), troopFileThumbnailGenTask);
            return;
        }
        TroopFileThumbnailMgr.a aVar = troopFileThumbnailGenTask.J;
        if (aVar != null) {
            aVar.a(z16);
        }
        TroopFileTransferMgr.N0(new Runnable(str, z16, i3, troopFileThumbnailGenTask) { // from class: com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenMgr.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f295984d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f295985e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f295986f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ TroopFileThumbnailGenTask f295987h;

            {
                this.f295984d = str;
                this.f295985e = z16;
                this.f295986f = i3;
                this.f295987h = troopFileThumbnailGenTask;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopFileThumbnailGenMgr.this, str, Boolean.valueOf(z16), Integer.valueOf(i3), troopFileThumbnailGenTask);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    TroopFileThumbnailGenMgr.this.g(this.f295984d, this.f295985e, this.f295986f, this.f295987h);
                }
            }
        }, false);
    }

    public int b(long j3, TroopFileTransferManager.Item item, int i3, String str, TroopFileThumbnailMgr.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), item, Integer.valueOf(i3), str, aVar)).intValue();
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
            if (m(c16)) {
                e.b.c("TroopFileThumbnailGenMgr", e.b.f295938b, "[" + c16 + "] genFileThumbnail task exsited. ");
                return -4;
            }
            TroopFileThumbnailGenTask m3 = TroopFileThumbnailGenTask.m(j3, item, i3, str, this, aVar);
            if (m3 == null) {
                return -3;
            }
            TroopFileThumbnailMgr.m(item, i3);
            this.f295980a.put(c16, m3);
            this.f295981b.add(c16);
            e.b.c("TroopFileThumbnailGenMgr", e.b.f295938b, "[" + c16 + "] genFileThumbnail filePath:" + item.LocalFile + d());
            i();
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

    protected void g(String str, boolean z16, int i3, TroopFileThumbnailGenTask troopFileThumbnailGenTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), troopFileThumbnailGenTask);
            return;
        }
        this.f295982c.remove(troopFileThumbnailGenTask);
        this.f295983d.remove(troopFileThumbnailGenTask);
        e.b.c("TroopFileThumbnailGenMgr", e.b.f295938b, "[" + str + "] onTaskDoneInter.  bSuc:" + z16 + " errCode:" + i3 + d());
        LinkedList<TroopFileThumbnailGenTask> l3 = l(troopFileThumbnailGenTask.l(), troopFileThumbnailGenTask.k());
        if (l3 != null && l3.size() > 0) {
            e.b.e("TroopFileThumbnailGenMgr", e.b.f295938b, "[" + str + "] onTaskDoneInter. " + l3.size() + " same task passive complete. " + d());
            Iterator<TroopFileThumbnailGenTask> it = l3.iterator();
            while (it.hasNext()) {
                it.next().p(z16, i3, troopFileThumbnailGenTask.o());
            }
        }
        i();
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            j();
        }
    }

    protected void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Iterator<TroopFileThumbnailGenTask> it = this.f295982c.iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
        this.f295982c.clear();
        this.f295980a.clear();
        this.f295981b.clear();
        this.f295983d.clear();
        e.b.c("TroopFileThumbnailGenMgr", e.b.f295938b, "stopAllInter");
    }

    public int k(UUID uuid, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) uuid, i3)).intValue();
        }
        if (uuid == null) {
            return -2;
        }
        String c16 = c(uuid, i3);
        Iterator<TroopFileThumbnailGenTask> it = this.f295982c.iterator();
        while (true) {
            if (it.hasNext()) {
                TroopFileThumbnailGenTask next = it.next();
                if (c16.equalsIgnoreCase(next.n())) {
                    next.stop();
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
            Iterator<TroopFileThumbnailGenTask> it5 = this.f295983d.iterator();
            while (it5.hasNext()) {
                TroopFileThumbnailGenTask next2 = it5.next();
                if (c16.equalsIgnoreCase(next2.n())) {
                    next2.stop();
                    it5.remove();
                    z16 = true;
                }
            }
            TroopFileThumbnailGenTask remove = this.f295980a.remove(uuid);
            if (remove != null) {
                remove.stop();
                z16 |= true;
            }
            z16 |= this.f295981b.remove(uuid);
        }
        if (z16) {
            e.b.c("TroopFileThumbnailGenMgr", e.b.f295938b, "[" + c16 + "] stopGen." + d());
        }
        i();
        return 0;
    }

    protected boolean m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        Iterator<TroopFileThumbnailGenTask> it = this.f295982c.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next().n())) {
                return true;
            }
        }
        Iterator<TroopFileThumbnailGenTask> it5 = this.f295983d.iterator();
        while (it5.hasNext()) {
            if (str.equalsIgnoreCase(it5.next().n())) {
                return true;
            }
        }
        if (this.f295980a.containsKey(str)) {
            return true;
        }
        return false;
    }
}
