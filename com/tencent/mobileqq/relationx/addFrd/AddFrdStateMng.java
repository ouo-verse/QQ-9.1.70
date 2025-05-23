package com.tencent.mobileqq.relationx.addFrd;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AddFrdStateMng {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static final String f280682g;

    /* renamed from: a, reason: collision with root package name */
    final ConcurrentHashMap<String, Long> f280683a;

    /* renamed from: b, reason: collision with root package name */
    SharedPreferences f280684b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f280685c;

    /* renamed from: d, reason: collision with root package name */
    boolean f280686d;

    /* renamed from: e, reason: collision with root package name */
    volatile boolean f280687e;

    /* renamed from: f, reason: collision with root package name */
    WeakReference<QQAppInterface> f280688f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements Comparator<Map.Entry<String, Long>> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFrdStateMng.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) entry, (Object) entry2)).intValue();
            }
            return entry2.getValue().compareTo(entry.getValue());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74592);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f280682g = AddFrdStateMng.class.getSimpleName();
        }
    }

    public AddFrdStateMng() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f280684b = null;
        this.f280685c = false;
        this.f280686d = false;
        this.f280687e = false;
        this.f280683a = new ConcurrentHashMap<>(5);
    }

    private void b() {
        if (this.f280686d && !this.f280687e) {
            this.f280687e = true;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.relationx.addFrd.AddFrdStateMng.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFrdStateMng.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        AddFrdStateMng.this.h();
                        AddFrdStateMng.this.f280687e = false;
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 16, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.f280686d) {
            if (QLog.isColorLevel()) {
                QLog.i(f280682g, 2, "save cache no change");
                return;
            }
            return;
        }
        SharedPreferences d16 = d();
        if (d16 == null) {
            if (QLog.isColorLevel()) {
                QLog.i(f280682g, 2, "save cache pref is null");
                return;
            }
            return;
        }
        try {
            this.f280686d = false;
            ArrayList arrayList = new ArrayList(this.f280683a.size());
            for (Map.Entry<String, Long> entry : this.f280683a.entrySet()) {
                if (entry != null && entry.getValue() != null && entry.getValue().longValue() != 0) {
                    arrayList.add(entry);
                }
            }
            if (arrayList.size() > 100) {
                Collections.sort(arrayList, new a());
            }
            StringBuilder sb5 = new StringBuilder(200);
            Iterator it = arrayList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it.next();
                if (sb5.length() > 0) {
                    sb5.append(",");
                }
                sb5.append((String) entry2.getKey());
                sb5.append("|");
                sb5.append(entry2.getValue());
                i3++;
                if (i3 >= 100) {
                    break;
                }
            }
            d16.edit().putString("add_frd_state_list", sb5.toString()).apply();
            if (QLog.isColorLevel()) {
                QLog.i(f280682g, 2, String.format("saveCache %s", sb5.toString()));
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public int c(String str, QQAppInterface qQAppInterface) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) qQAppInterface)).intValue();
        }
        if (str == null || str.length() == 0) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            l3 = this.f280683a.get(str);
        } catch (Throwable th5) {
            th5.printStackTrace();
            l3 = null;
        }
        if (l3 == null) {
            l3 = 0L;
        }
        int i3 = 3;
        if (l3.longValue() != 0 && Math.abs(currentTimeMillis - l3.longValue()) >= 604800000) {
            if (QLog.isColorLevel()) {
                QLog.i(f280682g, 2, String.format("getAddFrdState long time ago [time:%s, cur: %s, du: %s]", l3, Long.valueOf(currentTimeMillis), Long.valueOf(Math.abs(currentTimeMillis - l3.longValue()))));
            }
            l3 = 0L;
            g(str);
        }
        if (l3.longValue() != 0) {
            i3 = 2;
        }
        if (qQAppInterface != null) {
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            if (currentAccountUin != null && currentAccountUin.equals(str)) {
                return 0;
            }
            if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), f280682g)) {
                g(str);
                return 1;
            }
        }
        return i3;
    }

    public SharedPreferences d() {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f280684b == null) {
            WeakReference<QQAppInterface> weakReference = this.f280688f;
            if (weakReference == null) {
                qQAppInterface = null;
            } else {
                qQAppInterface = weakReference.get();
            }
            if (qQAppInterface != null) {
                this.f280684b = qQAppInterface.getApplication().getSharedPreferences("add_frd_state_" + qQAppInterface.getCurrentAccountUin(), 0);
            } else if (QLog.isColorLevel()) {
                QLog.i(f280682g, 2, "getPref app is null");
            }
        }
        return this.f280684b;
    }

    public synchronized void e(QQAppInterface qQAppInterface) {
        String string;
        int indexOf;
        long j3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface);
            return;
        }
        if (!this.f280685c) {
            if (qQAppInterface != null) {
                try {
                    this.f280688f = new WeakReference<>(qQAppInterface);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            SharedPreferences d16 = d();
            if (d16 == null) {
                string = null;
            } else {
                string = d16.getString("add_frd_state_list", "");
            }
            if (string != null && string.length() > 0) {
                String[] split = string.split(",");
                if (split.length > 0) {
                    for (String str2 : split) {
                        if (str2 != null && str2.length() >= 3 && (indexOf = str2.indexOf("|")) > 0 && indexOf < str2.length() - 1) {
                            try {
                                str = str2.substring(0, indexOf);
                                j3 = Long.parseLong(str2.substring(indexOf + 1));
                            } catch (Throwable th6) {
                                th6.printStackTrace();
                                j3 = 0;
                                str = null;
                            }
                            if (str != null && str.length() > 0) {
                                this.f280683a.put(str, Long.valueOf(j3));
                            }
                        }
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i(f280682g, 2, String.format("init [%s, %s]", string, this.f280683a.toString()));
            }
            this.f280685c = true;
        }
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (str != null && str.length() != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.f280683a.put(str, Long.valueOf(currentTimeMillis));
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            this.f280686d = true;
            b();
            if (QLog.isColorLevel()) {
                QLog.i(f280682g, 2, String.format("markSendAddFrd uin:%s, time:%s", str, Long.valueOf(currentTimeMillis)));
            }
        }
    }

    public void g(String str) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (str != null && str.length() != 0) {
            try {
                l3 = this.f280683a.remove(str);
            } catch (Throwable th5) {
                th5.printStackTrace();
                l3 = null;
            }
            if (l3 != null) {
                this.f280686d = true;
            }
            b();
            if (QLog.isColorLevel()) {
                QLog.i(f280682g, 2, String.format("removeFromCache uin:%s, change: %s", str, Boolean.valueOf(this.f280686d)));
            }
        }
    }
}
