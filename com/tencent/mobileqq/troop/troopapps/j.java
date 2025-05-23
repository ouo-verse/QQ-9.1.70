package com.tencent.mobileqq.troop.troopapps;

import com.tencent.luggage.wxa.xd.c0;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class j implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<Long, a> f299435d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f299436a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<TroopAppShortcutContainer.e> f299437b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<TroopAppShortcutContainer.e> f299438c;

        public a(long j3, ArrayList<TroopAppShortcutContainer.e> arrayList, ArrayList<TroopAppShortcutContainer.e> arrayList2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), arrayList, arrayList2);
                return;
            }
            this.f299436a = j3;
            this.f299437b = arrayList;
            this.f299438c = arrayList2;
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f299435d = new HashMap<>();
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f299435d.size() > 20) {
            ArrayList arrayList = new ArrayList();
            Iterator<a> it = this.f299435d.values().iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(it.next().f299436a));
            }
            Collections.sort(arrayList, Collections.reverseOrder());
            long longValue = ((Long) arrayList.get(19)).longValue();
            Iterator<Map.Entry<Long, a>> it5 = this.f299435d.entrySet().iterator();
            while (it5.hasNext()) {
                Map.Entry<Long, a> next = it5.next();
                if (next.getValue().f299436a < longValue) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopAppShortcutMgr", 2, "eliminateAppInfoCache troopUin:" + next.getKey());
                    }
                    it5.remove();
                }
            }
        }
    }

    public ArrayList<TroopAppShortcutContainer.e> b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, j3);
        }
        a aVar = this.f299435d.get(Long.valueOf(j3));
        if (aVar != null) {
            aVar.f299436a = System.currentTimeMillis();
            return aVar.f299437b;
        }
        return null;
    }

    public ArrayList<TroopAppShortcutContainer.e> c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }
        a aVar = this.f299435d.get(Long.valueOf(j3));
        if (aVar != null) {
            aVar.f299436a = System.currentTimeMillis();
            return aVar.f299438c;
        }
        return null;
    }

    public boolean d() {
        com.tencent.mobileqq.troop.shortcutbar.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() || (eVar = (com.tencent.mobileqq.troop.shortcutbar.e) am.s().x(c0.CTRL_INDEX)) == null) {
            return false;
        }
        return eVar.a();
    }

    public void e(long j3, ArrayList<TroopAppShortcutContainer.e> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), arrayList);
            return;
        }
        a aVar = this.f299435d.get(Long.valueOf(j3));
        if (aVar != null) {
            aVar.f299436a = System.currentTimeMillis();
            aVar.f299437b = arrayList;
        } else {
            this.f299435d.put(Long.valueOf(j3), new a(System.currentTimeMillis(), arrayList, null));
        }
    }

    public void f(long j3, ArrayList<TroopAppShortcutContainer.e> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), arrayList);
            return;
        }
        a aVar = this.f299435d.get(Long.valueOf(j3));
        if (aVar != null) {
            aVar.f299436a = System.currentTimeMillis();
            aVar.f299438c = arrayList;
        } else {
            this.f299435d.put(Long.valueOf(j3), new a(System.currentTimeMillis(), null, arrayList));
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f299435d.clear();
        }
    }
}
