package com.tencent.mobileqq.leba.more;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.leba.business.LebaPluginProxy;
import com.tencent.mobileqq.leba.business.g;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.f;
import com.tencent.mobileqq.leba.entity.i;
import com.tencent.mobileqq.leba.entity.k;
import com.tencent.mobileqq.leba.entity.l;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.leba.more.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LebaMoreDataLogic {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final List<i> f240664a;

    /* renamed from: b, reason: collision with root package name */
    public final List<i> f240665b;

    /* renamed from: c, reason: collision with root package name */
    public final List<i> f240666c;

    /* renamed from: d, reason: collision with root package name */
    public final List<i> f240667d;

    /* renamed from: e, reason: collision with root package name */
    public final List<List<i>> f240668e;

    /* renamed from: f, reason: collision with root package name */
    public int f240669f;

    /* renamed from: g, reason: collision with root package name */
    public int f240670g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f240671h;

    /* renamed from: i, reason: collision with root package name */
    protected AppRuntime f240672i;

    /* renamed from: j, reason: collision with root package name */
    protected g f240673j;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f240674k;

    /* renamed from: l, reason: collision with root package name */
    protected LebaPluginProxy f240675l;

    /* renamed from: m, reason: collision with root package name */
    public long f240676m;

    public LebaMoreDataLogic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f240671h = false;
        this.f240674k = false;
        this.f240675l = new LebaPluginProxy();
        this.f240676m = 0L;
        ArrayList arrayList = new ArrayList();
        this.f240664a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f240665b = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.f240666c = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        this.f240667d = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        this.f240668e = arrayList5;
        arrayList5.add(arrayList);
        arrayList5.add(arrayList2);
        arrayList5.add(arrayList3);
        arrayList5.add(arrayList4);
    }

    private void a(List<n> list, boolean z16) {
        List<i> list2;
        if (z16) {
            list2 = this.f240665b;
        } else {
            list2 = this.f240667d;
        }
        if (!list.isEmpty()) {
            for (n nVar : list) {
                if (nVar.f240507d == 1) {
                    list2.add(b(nVar, z16));
                }
            }
        }
    }

    private void l(List<i> list, boolean z16) {
        List<i> list2;
        if (z16) {
            list2 = this.f240664a;
        } else {
            list2 = this.f240666c;
        }
        if (!list.isEmpty()) {
            list2.add(c(z16));
        }
    }

    private void s() {
        n nVar;
        if (this.f240670g <= 0) {
            return;
        }
        int size = this.f240665b.size() - this.f240670g;
        while (true) {
            int i3 = size - 1;
            if (size > 0) {
                List<i> list = this.f240665b;
                i iVar = list.get(list.size() - 1);
                if (iVar == null || (nVar = iVar.f240488c) == null || iVar.f240486a != 2 || !nVar.c()) {
                    break;
                }
                iVar.f240489d = false;
                this.f240667d.add(d(iVar), iVar);
                this.f240665b.remove(iVar);
                size = i3;
            } else {
                return;
            }
        }
        QLog.i("LebaMoreDataLogic", 1, "removeToMoreIfFull  closeItem error ");
    }

    public i b(n nVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (i) iPatchRedirector.redirect((short) 10, this, nVar, Boolean.valueOf(z16));
        }
        i iVar = new i();
        iVar.f240486a = 2;
        iVar.f240489d = z16;
        iVar.f240488c = nVar;
        return iVar;
    }

    public i c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (i) iPatchRedirector.redirect((short) 9, (Object) this, z16);
        }
        i iVar = new i();
        iVar.f240486a = 1;
        if (z16) {
            iVar.f240487b = HardCodeUtil.qqStr(R.string.f162091zh);
        } else {
            iVar.f240487b = HardCodeUtil.qqStr(R.string.f162111zj);
        }
        return iVar;
    }

    public int d(i iVar) {
        n nVar;
        LebaPluginInfo lebaPluginInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) iVar)).intValue();
        }
        int i3 = 0;
        for (int i16 = 0; i16 < this.f240667d.size(); i16++) {
            i iVar2 = this.f240667d.get(i16);
            if (iVar2 != null && (nVar = iVar2.f240488c) != null && (lebaPluginInfo = nVar.f240505b) != null) {
                if (iVar.f240490e) {
                    if (!iVar2.f240490e) {
                        break;
                    }
                    if (iVar.f240491f <= iVar2.f240491f) {
                        break;
                    }
                    i3 = i16 + 1;
                } else {
                    if (!iVar2.f240490e && iVar.f240488c.f240505b.sPriority <= lebaPluginInfo.sPriority) {
                        break;
                    }
                    i3 = i16 + 1;
                }
            }
        }
        return i3;
    }

    public int e(i iVar) {
        n nVar;
        LebaPluginInfo lebaPluginInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) iVar)).intValue();
        }
        int i3 = 0;
        for (int i16 = 0; i16 < this.f240665b.size(); i16++) {
            i iVar2 = this.f240665b.get(i16);
            if (iVar2 != null && (nVar = iVar2.f240488c) != null && (lebaPluginInfo = nVar.f240505b) != null) {
                if (iVar.f240490e) {
                    if (!iVar2.f240490e) {
                        break;
                    }
                    if (iVar.f240491f <= iVar2.f240491f) {
                        break;
                    }
                    i3 = i16 + 1;
                } else {
                    if (!iVar2.f240490e && iVar.f240488c.f240505b.sPriority <= lebaPluginInfo.sPriority) {
                        break;
                    }
                    i3 = i16 + 1;
                }
            }
        }
        return i3;
    }

    public i f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (i) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        if (i3 < 0) {
            QLog.i("LebaMoreDataLogic", 1, "getItem" + i3);
            return null;
        }
        int i16 = 0;
        for (List<i> list : this.f240668e) {
            if (i3 < list.size() + i16) {
                return list.get(i3 - i16);
            }
            i16 += list.size();
        }
        return null;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        Iterator<List<i>> it = this.f240668e.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().size();
        }
        return i3;
    }

    public int h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        i f16 = f(i3);
        if (f16 == null) {
            return 1;
        }
        return f16.f240486a;
    }

    public int i(List<i> list) {
        List<i> next;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) list)).intValue();
        }
        Iterator<List<i>> it = this.f240668e.iterator();
        int i3 = 0;
        while (it.hasNext() && (next = it.next()) != list) {
            i3 += next.size();
        }
        return i3;
    }

    public void j(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        } else {
            this.f240672i = appRuntime;
        }
    }

    public void k(List<n> list, List<n> list2, int i3, a aVar, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, list, list2, Integer.valueOf(i3), aVar, Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        this.f240670g = i16;
        this.f240669f = i3;
        this.f240671h = z16;
        this.f240665b.clear();
        this.f240664a.clear();
        this.f240667d.clear();
        this.f240666c.clear();
        if ((list != null && !list.isEmpty()) || (list2 != null && !list2.isEmpty())) {
            if (list != null) {
                a(list, true);
            }
            if (list2 != null) {
                a(list2, false);
            }
            s();
            l(this.f240665b, true);
            l(this.f240667d, false);
            QLog.i("LebaMoreDataLogic", 1, "initShowMgrData model=" + this.f240669f + ",maxSize=" + this.f240670g);
            aVar.notifyDataSetChanged();
            return;
        }
        QLog.i("LebaMoreDataLogic", 1, "initShowMgrData srcList isEmpty " + this.f240669f);
        aVar.notifyDataSetChanged();
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        if (this.f240665b.isEmpty() && this.f240667d.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (Math.abs(this.f240676m - System.currentTimeMillis()) < 400) {
            return true;
        }
        this.f240676m = System.currentTimeMillis();
        return false;
    }

    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.f240674k;
    }

    public void p(a aVar, i iVar, a.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, aVar, iVar, fVar);
            return;
        }
        if (n()) {
            QLog.i("LebaMoreDataLogic", 1, "closePlugin isFastClick");
            return;
        }
        if (iVar != null && iVar.f240488c != null && iVar.f240486a == 2 && this.f240665b.contains(iVar)) {
            t(true);
            int i3 = i(this.f240665b) + this.f240665b.indexOf(iVar);
            iVar.f240489d = false;
            aVar.u(fVar, iVar);
            int d16 = d(iVar);
            this.f240667d.add(d16, iVar);
            this.f240665b.remove(iVar);
            aVar.notifyItemMoved(i3, i(this.f240667d) + d16);
            if (this.f240666c.isEmpty()) {
                this.f240666c.add(c(false));
                aVar.notifyItemInserted(i(this.f240666c));
                return;
            }
            return;
        }
        QLog.i("LebaMoreDataLogic", 1, "closePlugin error ");
    }

    public void q(a aVar, i iVar, a.f fVar) {
        boolean z16;
        i iVar2;
        n nVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, aVar, iVar, fVar);
            return;
        }
        if (n()) {
            QLog.i("LebaMoreDataLogic", 1, "openPlugin isFastClick");
            return;
        }
        if (iVar != null && iVar.f240488c != null && iVar.f240486a == 2 && this.f240667d.contains(iVar)) {
            if (this.f240670g != 0 && this.f240665b.size() >= this.f240670g) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QQToastUtil.showQQToast(0, R.string.f162181zq, Integer.valueOf(this.f240670g));
                return;
            }
            t(true);
            if (z16) {
                List<i> list = this.f240665b;
                iVar2 = list.get(list.size() - 1);
                if (iVar2 == null || (nVar = iVar2.f240488c) == null || iVar2.f240486a != 2 || !nVar.c()) {
                    QLog.i("LebaMoreDataLogic", 1, "moveToShowPlugin  closeItem error ");
                    return;
                }
            } else {
                iVar2 = null;
            }
            int i3 = i(this.f240667d) + this.f240667d.indexOf(iVar);
            iVar.f240489d = true;
            aVar.u(fVar, iVar);
            int e16 = e(iVar);
            this.f240665b.add(e16, iVar);
            this.f240667d.remove(iVar);
            aVar.notifyItemMoved(i3, i(this.f240665b) + e16);
            if (z16) {
                iVar2.f240489d = false;
                int i16 = i(this.f240665b) + this.f240665b.indexOf(iVar2);
                int d16 = d(iVar2);
                this.f240667d.add(d16, iVar2);
                this.f240665b.remove(iVar2);
                aVar.notifyItemMoved(i16, i(this.f240667d) + d16);
                aVar.notifyItemRangeChanged(i(this.f240665b), this.f240665b.size() + this.f240667d.size() + this.f240666c.size());
            }
            if (this.f240667d.isEmpty()) {
                this.f240666c.clear();
                aVar.notifyItemRemoved(i(this.f240666c));
                return;
            }
            return;
        }
        QLog.i("LebaMoreDataLogic", 1, "moveToShowPlugin error ");
    }

    public void r(View view, n nVar, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, view, nVar, fVar);
        } else {
            this.f240675l.q(view, nVar, fVar);
        }
    }

    public void t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            this.f240674k = z16;
        }
    }

    public void u(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
        } else {
            this.f240673j = gVar;
        }
    }

    public void v(AppRuntime appRuntime) {
        k g16;
        boolean z16;
        n nVar;
        n nVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) appRuntime);
            return;
        }
        int i3 = this.f240669f;
        if (i3 != 0 && i3 != 2) {
            g16 = new k();
            g16.h();
            z16 = true;
        } else {
            g16 = LebaPluginLogic.g(appRuntime, i3);
            if (g16.f() <= 0) {
                QLog.e("LebaMoreDataLogic", 1, "setNormalPluginSettingNet getPluginSettingLocal itemsSize is 0");
            }
            g16.h();
            if (QLog.isDevelopLevel()) {
                g16.i("setNormalPluginSettingNet read local");
            }
            z16 = false;
        }
        QLog.d("LebaMoreDataLogic", 4, "setNormalPluginSettingNet showPlugin: " + this.f240665b.size());
        for (i iVar : this.f240665b) {
            if (iVar != null && (nVar2 = iVar.f240488c) != null && !iVar.f240490e) {
                l lVar = new l(nVar2.f240504a, 1, nVar2.f240505b.cShowVer);
                if (z16) {
                    g16.a(lVar);
                } else {
                    n nVar3 = iVar.f240488c;
                    g16.j(new l(nVar3.f240504a, 2, nVar3.f240505b.cShowVer));
                    g16.a(lVar);
                    QLog.d("LebaMoreDataLogic", 4, "setNormalPluginSettingNet add item (show): " + lVar.f240499a + "|" + lVar.f240500b + "|" + lVar.f240501c);
                }
            }
        }
        QLog.d("LebaMoreDataLogic", 4, "setNormalPluginSettingNet morePlugin: " + this.f240667d.size());
        for (i iVar2 : this.f240667d) {
            if (iVar2 != null && (nVar = iVar2.f240488c) != null && !iVar2.f240490e) {
                l lVar2 = new l(nVar.f240504a, 2, nVar.f240505b.cShowVer);
                if (z16) {
                    g16.a(lVar2);
                } else {
                    n nVar4 = iVar2.f240488c;
                    g16.j(new l(nVar4.f240504a, 1, nVar4.f240505b.cShowVer));
                    g16.a(lVar2);
                    QLog.d("LebaMoreDataLogic", 4, "setNormalPluginSettingNet add item (more): " + lVar2.f240499a + "|" + lVar2.f240500b + "|" + lVar2.f240501c);
                }
            }
        }
        ThreadManagerV2.excute(new Runnable(g16, appRuntime) { // from class: com.tencent.mobileqq.leba.more.LebaMoreDataLogic.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ k f240677d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ AppRuntime f240678e;

            {
                this.f240677d = g16;
                this.f240678e = appRuntime;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, LebaMoreDataLogic.this, g16, appRuntime);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isDevelopLevel()) {
                    this.f240677d.i("setNormalPluginSettingNet");
                }
                LebaPluginLogic.z(this.f240678e, LebaMoreDataLogic.this.f240669f, this.f240677d);
            }
        }, 160, null, true);
    }

    public void w(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) appRuntime);
            return;
        }
        for (i iVar : this.f240665b) {
            if (iVar != null) {
                g gVar = this.f240673j;
                if (gVar != null) {
                    gVar.d(appRuntime, iVar.f240489d, iVar);
                }
                LebaPluginProxy lebaPluginProxy = this.f240675l;
                n nVar = iVar.f240488c;
                lebaPluginProxy.v(nVar.f240504a, iVar.f240489d, nVar);
            }
        }
        for (i iVar2 : this.f240667d) {
            if (iVar2 != null) {
                g gVar2 = this.f240673j;
                if (gVar2 != null) {
                    gVar2.d(appRuntime, iVar2.f240489d, iVar2);
                }
                LebaPluginProxy lebaPluginProxy2 = this.f240675l;
                n nVar2 = iVar2.f240488c;
                lebaPluginProxy2.v(nVar2.f240504a, iVar2.f240489d, nVar2);
            }
        }
    }
}
