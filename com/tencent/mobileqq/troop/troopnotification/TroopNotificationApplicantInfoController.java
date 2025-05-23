package com.tencent.mobileqq.troop.troopnotification;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.handler.TroopNotificationHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopNotificationApplicantInfoController extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    protected Map<Long, d> f300633c;

    /* renamed from: d, reason: collision with root package name */
    protected Map<String, ConcurrentHashMap<Long, Integer>> f300634d;

    public TroopNotificationApplicantInfoController(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else {
            this.f300633c = new HashMap();
            this.f300634d = new ConcurrentHashMap();
        }
    }

    private void f(String str, List<Long> list) {
        if (!TextUtils.isEmpty(str) && list != null) {
            ConcurrentHashMap<Long, Integer> concurrentHashMap = this.f300634d.get(str);
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap<>();
                this.f300634d.put(str, concurrentHashMap);
            }
            for (Long l3 : list) {
                if (l3 != null) {
                    concurrentHashMap.put(l3, 0);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.a();
        this.f300634d.clear();
        this.f300633c.clear();
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.a
    @Nullable
    protected String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "TroopNotificationApplicantInfoController";
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.a
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            a();
        }
    }

    public void e(Long l3, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, l3, Integer.valueOf(i3), str);
            return;
        }
        if (l3 != null && !TextUtils.isEmpty(str)) {
            ConcurrentHashMap<Long, Integer> concurrentHashMap = this.f300634d.get(str);
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap<>();
                this.f300634d.put(str, concurrentHashMap);
            }
            if (!concurrentHashMap.contains(l3)) {
                concurrentHashMap.put(l3, Integer.valueOf(i3));
            }
        }
    }

    protected void g(String str, List<Long> list) {
        ConcurrentHashMap<Long, Integer> concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) list);
            return;
        }
        if (TextUtils.isEmpty(str) || list == null || (concurrentHashMap = this.f300634d.get(str)) == null) {
            return;
        }
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            concurrentHashMap.remove(it.next());
        }
    }

    public d h(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (d) iPatchRedirector.redirect((short) 8, (Object) this, (Object) l3);
        }
        d dVar = this.f300633c.get(l3);
        if (dVar != null) {
            return dVar.clone();
        }
        return dVar;
    }

    public List<Long> i(String str) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        ConcurrentHashMap<Long, Integer> concurrentHashMap = this.f300634d.get(str);
        if (concurrentHashMap == null) {
            return arrayList;
        }
        for (Long l3 : concurrentHashMap.keySet()) {
            if (l3 != null && (num = concurrentHashMap.get(l3)) != null && num.intValue() == 0) {
                arrayList.add(l3);
                concurrentHashMap.put(l3, 1);
            }
        }
        return arrayList;
    }

    public void j(List<Long> list, String str) {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list, (Object) str);
            return;
        }
        if (list != null && !list.isEmpty()) {
            AppRuntime appRuntime = this.f300638a;
            if (appRuntime == null) {
                QLog.i("TroopNotificationApplic", 1, "[getNotifyCationApplicantInfo] app is null");
                f(str, list);
                return;
            }
            TroopNotificationHandler troopNotificationHandler = (TroopNotificationHandler) ((AppInterface) appRuntime).getBusinessHandler(TroopNotificationHandler.class.getName());
            if (troopNotificationHandler == null) {
                QLog.i("TroopNotificationApplic", 1, "[getNotifyCationApplicantInfo] troopNotificationHandler is empty");
                f(str, list);
                return;
            }
            int size = list.size();
            QLog.i("TroopNotificationApplic", 1, "[getNotifyCationApplicantInfo] size:" + size);
            if (size > 70) {
                while (size > 0) {
                    if (size > 70) {
                        arrayList = new ArrayList(list.subList(size - 70, size));
                        size -= 70;
                    } else {
                        arrayList = new ArrayList(list.subList(0, size));
                        size = 0;
                    }
                    troopNotificationHandler.G2(arrayList, str);
                }
                return;
            }
            troopNotificationHandler.G2(list, str);
            return;
        }
        QLog.i("TroopNotificationApplic", 1, "[getNotifyCationApplicantInfo] uin is null or empty");
    }

    public void k(String str, List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) list);
        } else if (list != null && !list.isEmpty()) {
            ThreadManagerV2.postImmediately(new Runnable(str, list) { // from class: com.tencent.mobileqq.troop.troopnotification.TroopNotificationApplicantInfoController.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f300635d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ List f300636e;

                {
                    this.f300635d = str;
                    this.f300636e = list;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopNotificationApplicantInfoController.this, str, list);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TroopNotificationApplicantInfoController.this.g(this.f300635d, this.f300636e);
                    }
                }
            }, null, false);
        }
    }

    public void l(List<d> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (d dVar : list) {
                if (dVar != null) {
                    this.f300633c.put(Long.valueOf(dVar.h()), dVar);
                    arrayList.add(Long.valueOf(dVar.h()));
                }
            }
            k("OidbSvc.0x5eb_troopnotifycation", arrayList);
        }
    }

    public void m(Map<Long, Integer> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) map);
            return;
        }
        if (map != null && !map.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Long l3 : map.keySet()) {
                if (l3 != null) {
                    arrayList.add(l3);
                    int intValue = map.get(l3).intValue();
                    d dVar = this.f300633c.get(l3);
                    if (dVar != null) {
                        dVar.o(intValue);
                        dVar.s(true);
                    } else {
                        this.f300633c.put(l3, new d(l3.longValue(), intValue, true));
                    }
                }
            }
            k("OidbSvc.0x668", arrayList);
        }
    }
}
