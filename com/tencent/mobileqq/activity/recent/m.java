package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class m implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static m f185673f;

    /* renamed from: d, reason: collision with root package name */
    private boolean f185674d;

    /* renamed from: e, reason: collision with root package name */
    private Set<String> f185675e;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f185674d = false;
        this.f185675e = new HashSet();
        h();
    }

    public static m a() {
        if (f185673f == null) {
            synchronized (m.class) {
                if (f185673f == null) {
                    f185673f = new m();
                }
            }
        }
        return f185673f;
    }

    private String b(String str) {
        return "RecentPubAccManager_has_migrate_key_" + str;
    }

    private String c(String str) {
        return "RecentPubAccManagerwhite_list_key" + str;
    }

    private boolean d(Context context, String str) {
        return QMMKV.from(context, "common_mmkv_configurations").decodeBool(b(str), false);
    }

    private void g(Context context, String str) {
        this.f185674d = ea.J(context, "RecentPubAccManager", str);
        this.f185675e = QMMKV.from(context, "common_mmkv_configurations").decodeStringSet(c(str), null);
        QLog.d("RecentPubAccManager", 1, "loadFromMMKV mWhiteUinList:" + this.f185675e + ",  Switch: " + this.f185674d);
    }

    private void h() {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface == null) {
            return;
        }
        BaseApplication app = qQAppInterface.getApp();
        String currentUin = qQAppInterface.getCurrentUin();
        if (d(app, currentUin)) {
            g(app, currentUin);
            return;
        }
        this.f185674d = ea.I(qQAppInterface.getApp(), qQAppInterface.getCurrentUin());
        this.f185675e = qQAppInterface.getApp().getSharedPreferences("RecentPubAccManager" + qQAppInterface.getCurrentAccountUin(), 0).getStringSet("white_list_key", null);
        QLog.d("RecentPubAccManager", 1, "loadFromSp   mBlackUinList:" + this.f185675e + ",  Switch: " + this.f185674d);
        i(app, currentUin);
    }

    private void i(Context context, String str) {
        ea.P3(context, "RecentPubAccManager", str, this.f185674d);
        QMMKV.from(context, "common_mmkv_configurations").encodeStringSet(c(str), this.f185675e);
        j(context, str);
        QLog.d("RecentPubAccManager", 1, "migrateToMMKV finished!");
    }

    private void j(Context context, String str) {
        QMMKV.from(context, "common_mmkv_configurations").encodeBool(b(str), true);
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f185674d;
    }

    public boolean f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        Set<String> set = this.f185675e;
        if (set != null && set.contains(str)) {
            return true;
        }
        return false;
    }

    public void k(QQAppInterface qQAppInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, Boolean.valueOf(z16));
            return;
        }
        if (qQAppInterface == null) {
            return;
        }
        QLog.d("RecentPubAccManager", 1, "setUnFollowPubAccSwitch: " + z16);
        this.f185674d = z16;
        ea.P3(qQAppInterface.getApp(), "RecentPubAccManager", qQAppInterface.getCurrentAccountUin(), z16);
    }

    public synchronized void l(QQAppInterface qQAppInterface, Set<String> set) {
        String obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface, (Object) set);
            return;
        }
        if (qQAppInterface == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setUnFollowPubAccWhiteList:");
        if (set == null) {
            obj = "null";
        } else {
            obj = set.toString();
        }
        sb5.append(obj);
        QLog.d("RecentPubAccManager", 1, sb5.toString());
        this.f185675e = set;
        QMMKV.from(qQAppInterface.getApp(), "common_mmkv_configurations").encodeStringSet(c(qQAppInterface.getCurrentUin()), set);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }
}
