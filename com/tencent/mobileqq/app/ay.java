package com.tencent.mobileqq.app;

import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ay implements Manager {
    static IPatchRedirector $redirector_;
    public static boolean E;
    static boolean F;
    static boolean G;
    SparseArray<String> C;
    com.tencent.mobileqq.hotchat.a D;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f195396d;

    /* renamed from: e, reason: collision with root package name */
    boolean f195397e;

    /* renamed from: f, reason: collision with root package name */
    int f195398f;

    /* renamed from: h, reason: collision with root package name */
    Boolean f195399h;

    /* renamed from: i, reason: collision with root package name */
    boolean f195400i;

    /* renamed from: m, reason: collision with root package name */
    final Map<String, HotChatInfo> f195401m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69764);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        E = true;
        F = false;
        G = false;
    }

    @Deprecated
    public ay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f195397e = false;
        this.f195398f = 0;
        this.f195399h = null;
        this.f195400i = false;
        this.f195401m = new ConcurrentHashMap();
        this.C = new SparseArray<>();
    }

    public static void b(AppInterface appInterface, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.HOTCHAT, 2, "update authFlag:" + z16 + " old:" + G);
        }
        if (G == z16) {
            return;
        }
        appInterface.getPreferences().edit().putBoolean("hotchat_auth_flag", z16).commit();
        G = z16;
    }

    public com.tencent.mobileqq.hotchat.a a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.hotchat.a) iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
        if (this.D == null && z16) {
            this.D = new com.tencent.mobileqq.hotchat.a(this.f195396d);
        }
        return this.D;
    }

    public void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("HotChatManager", 2, "setMyUinCharmLevel, charmLevel = " + i3);
        }
        this.f195398f = i3;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            F = false;
            G = false;
        }
    }

    public ay(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f195397e = false;
        this.f195398f = 0;
        this.f195399h = null;
        this.f195400i = false;
        this.f195401m = new ConcurrentHashMap();
        this.C = new SparseArray<>();
        this.f195396d = qQAppInterface;
    }
}
