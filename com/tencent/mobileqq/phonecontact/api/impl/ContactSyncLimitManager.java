package com.tencent.mobileqq.phonecontact.api.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.FeatureSwitch;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ContactSyncLimitManager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static long f258345d;

    /* renamed from: e, reason: collision with root package name */
    private static int f258346e;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, b> f258347a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f258348b;

    /* renamed from: c, reason: collision with root package name */
    private AppInterface f258349c;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final ContactSyncLimitManager f258352a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24303);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f258352a = new ContactSyncLimitManager(null);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24308);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f258345d = 86400L;
            f258346e = 1;
        }
    }

    /* synthetic */ ContactSyncLimitManager(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) anonymousClass1);
    }

    public static ContactSyncLimitManager d() {
        return a.f258352a;
    }

    private void e() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.phonecontact.api.impl.ContactSyncLimitManager.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactSyncLimitManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Map<String, ?> all = ContactSyncLimitManager.this.f258349c.getApp().getSharedPreferences("com.tencent.mobileQQ.contact.sync_limit", 0).getAll();
                String currentAccountUin = ContactSyncLimitManager.this.f258349c.getCurrentAccountUin();
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    if (entry.getKey().equals(currentAccountUin)) {
                        ContactSyncLimitManager.this.f258347a.put(entry.getKey(), ContactSyncLimitManager.this.j((String) entry.getValue()));
                    }
                }
            }
        }, 16, null, true);
    }

    private void g() {
        boolean z16;
        long parseLong;
        int parseInt;
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) this.f258349c.getRuntimeService(IFeatureRuntimeService.class, "all");
        JSONObject jSONObject = iFeatureRuntimeService.getJSONObject("background_sync_contact_frequency_limit", "");
        FeatureSwitch featureSwitch = iFeatureRuntimeService.getFeatureSwitch("background_sync_contact_frequency_limit");
        if (featureSwitch != null && featureSwitch.mSwitchEnable) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && jSONObject != null) {
            if (TextUtils.isEmpty(jSONObject.optString("time"))) {
                parseLong = f258345d;
            } else {
                parseLong = Long.parseLong(jSONObject.optString("time"));
            }
            f258345d = parseLong;
            if (TextUtils.isEmpty(jSONObject.optString("count"))) {
                parseInt = f258346e;
            } else {
                parseInt = Integer.parseInt(jSONObject.optString("count"));
            }
            f258346e = parseInt;
            QLog.d("ContactSyncLimitManager", 1, "syncContactCountFreshTime: " + f258345d + "    maxTime: " + f258346e);
            return;
        }
        QLog.e("ContactSyncLimitManager", 1, "config null,using default,syncContactCountFreshTime: " + f258345d + "    maxTime: " + f258346e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b j(String str) {
        String[] split = str.split("#");
        if (split != null && split.length == 2) {
            return new b(Integer.parseInt(split[0]), Long.parseLong(split[1]));
        }
        return new b(1, -1L);
    }

    private void k(String str, b bVar) {
        ThreadManagerV2.excute(new Runnable(str, bVar) { // from class: com.tencent.mobileqq.phonecontact.api.impl.ContactSyncLimitManager.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f258350d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f258351e;

            {
                this.f258350d = str;
                this.f258351e = bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ContactSyncLimitManager.this, str, bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                SharedPreferences.Editor edit = ContactSyncLimitManager.this.f258349c.getApp().getSharedPreferences("com.tencent.mobileQQ.contact.sync_limit", 0).edit();
                edit.putString(this.f258350d, this.f258351e.toString());
                edit.apply();
            }
        }, 16, null, true);
    }

    public void f(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
            return;
        }
        this.f258349c = appInterface;
        g();
        e();
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f258348b;
    }

    public synchronized boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        String currentAccountUin = this.f258349c.getCurrentAccountUin();
        boolean z16 = false;
        if (this.f258347a.containsKey(currentAccountUin)) {
            b bVar = this.f258347a.get(currentAccountUin);
            if (bVar == null) {
                return false;
            }
            if (bVar.f258353a >= f258346e && currentTimeMillis - bVar.f258354b < f258345d) {
                z16 = true;
            }
        }
        if (!z16) {
            m();
        }
        return !z16;
    }

    public void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f258348b = z16;
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String currentAccountUin = this.f258349c.getCurrentAccountUin();
        if (this.f258347a.containsKey(currentAccountUin)) {
            b bVar = this.f258347a.get(currentAccountUin);
            if (bVar == null) {
                b bVar2 = new b(currentTimeMillis);
                this.f258347a.put(currentAccountUin, bVar2);
                k(currentAccountUin, bVar2);
                return;
            } else {
                if (currentTimeMillis - bVar.f258354b >= f258345d) {
                    bVar.f258353a = 0;
                    bVar.f258354b = currentTimeMillis;
                }
                b.c(bVar);
                k(currentAccountUin, bVar);
                return;
            }
        }
        b bVar3 = new b(currentTimeMillis);
        this.f258347a.put(currentAccountUin, bVar3);
        k(currentAccountUin, bVar3);
    }

    ContactSyncLimitManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f258347a = new ConcurrentHashMap<>();
            this.f258348b = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f258353a;

        /* renamed from: b, reason: collision with root package name */
        private long f258354b;

        public b(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, j3);
            } else {
                this.f258353a = 1;
                this.f258354b = j3;
            }
        }

        static /* synthetic */ int c(b bVar) {
            int i3 = bVar.f258353a;
            bVar.f258353a = i3 + 1;
            return i3;
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f258353a + "#" + this.f258354b;
        }

        public b(int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3));
            } else {
                this.f258353a = i3;
                this.f258354b = j3;
            }
        }
    }
}
