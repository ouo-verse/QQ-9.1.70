package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26$MsgBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ah {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<p> f293966a;

    /* renamed from: b, reason: collision with root package name */
    private static ah f293967b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63868);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f293966a = new ArrayList<>();
        }
    }

    ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            b();
        }
    }

    public static ah a() {
        if (f293967b == null) {
            synchronized (ah.class) {
                if (f293967b == null) {
                    f293967b = new ah();
                }
            }
        }
        return f293967b;
    }

    private static void b() {
        ArrayList<Class<? extends p>> arrayList = com.tencent.mobileqq.troop.api.config.extension.a.f293982f;
        if (arrayList != null) {
            Iterator<Class<? extends p>> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    f293966a.add(it.next().newInstance());
                } catch (Throwable th5) {
                    QLog.i("TroopRedDotHandlerProcessorConfig", 1, "Init Fail", th5);
                }
            }
        }
    }

    public void c(@NonNull AppInterface appInterface, String str, String str2, @NonNull TroopInfo troopInfo, @NonNull ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appInterface, str, str2, troopInfo, arrayList);
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Iterator<p> it = f293966a.iterator();
            while (it.hasNext()) {
                it.next().a(appInterface, str, str2, troopInfo, arrayList);
            }
        }
    }

    public void d(@NonNull AppInterface appInterface, String str, String str2, TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, appInterface, str, str2, troopInfo);
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Iterator<p> it = f293966a.iterator();
            while (it.hasNext()) {
                it.next().b(appInterface, str, str2, troopInfo);
            }
        }
    }

    public void e(String str, List<String> list, List<String> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, list, list2);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Iterator<p> it = f293966a.iterator();
            while (it.hasNext()) {
                it.next().c(str, list, list2);
            }
        }
    }

    public void f(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) str);
            return;
        }
        Iterator<p> it = f293966a.iterator();
        while (it.hasNext()) {
            it.next().d(appInterface, str);
        }
    }

    public void g(@NonNull AppInterface appInterface, com.tencent.mobileqq.troop.unreadmsg.a aVar, submsgtype0x26$MsgBody.SubCmd0x1UpdateAppUnreadNum subCmd0x1UpdateAppUnreadNum, long[] jArr, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appInterface, aVar, subCmd0x1UpdateAppUnreadNum, jArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        Iterator<p> it = f293966a.iterator();
        while (it.hasNext()) {
            it.next().e(appInterface, aVar, subCmd0x1UpdateAppUnreadNum, jArr, i3, i16, i17);
        }
    }

    public void h(@NonNull AppInterface appInterface, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface, (Object) aVar);
            return;
        }
        Iterator<p> it = f293966a.iterator();
        while (it.hasNext()) {
            it.next().f(appInterface, aVar);
        }
    }

    public void i(@NonNull AppInterface appInterface, com.tencent.mobileqq.troop.entereffect.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) fVar);
            return;
        }
        Iterator<p> it = f293966a.iterator();
        while (it.hasNext()) {
            it.next().g(appInterface, fVar);
        }
    }
}
