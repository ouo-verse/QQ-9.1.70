package com.tencent.mobileqq.qqlive.player;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.config.d;
import com.tencent.mobileqq.qqlive.config.e;
import com.tencent.mobileqq.qqlive.config.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.thumbplayer.api.player.ITPPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f271389a;

    /* renamed from: b, reason: collision with root package name */
    private static final List<ITPPlayer> f271390b;

    /* renamed from: c, reason: collision with root package name */
    private static final List<ISuperPlayer> f271391c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61256);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f271390b = new ArrayList();
            f271391c = new ArrayList();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a() {
        int i3;
        boolean z16;
        d a16 = e.a();
        if (a16.f271189k != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QQLivePlayerPool", 4, "playerConfig:" + a16.f271189k);
            }
            f fVar = a16.f271189k;
            z16 = fVar.f271192b;
            i3 = fVar.f271191a;
        } else {
            i3 = 3;
            z16 = false;
        }
        int size = f271390b.size() + f271391c.size();
        if (!z16 || size >= i3) {
            return false;
        }
        return true;
    }

    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (f271389a == null) {
                f271389a = new a();
            }
            aVar = f271389a;
        }
        return aVar;
    }

    private void f(ISuperPlayer iSuperPlayer) {
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnVideoPreparedListener(null);
            iSuperPlayer.setOnInfoListener(null);
            iSuperPlayer.setOnErrorListener(null);
            iSuperPlayer.setOnCompletionListener(null);
            iSuperPlayer.setOnVideoSizeChangedListener(null);
            iSuperPlayer.reset();
        }
    }

    public ISuperPlayer b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ISuperPlayer) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        List<ISuperPlayer> list = f271391c;
        synchronized (list) {
            QLog.i("QQLivePlayerPool", 1, "getISuperPlayer current size is " + list.size());
            if (list.isEmpty()) {
                return null;
            }
            return list.remove(0);
        }
    }

    public void d(ISuperPlayer iSuperPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iSuperPlayer);
            return;
        }
        if (a()) {
            QLog.d("QQLivePlayerPool", 1, "recycle player:" + iSuperPlayer);
            f(iSuperPlayer);
            List<ISuperPlayer> list = f271391c;
            synchronized (list) {
                list.add(iSuperPlayer);
            }
            return;
        }
        QLog.d("QQLivePlayerPool", 1, "release player:" + iSuperPlayer);
        iSuperPlayer.release();
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        List<ITPPlayer> list = f271390b;
        synchronized (list) {
            Iterator<ITPPlayer> it = list.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            f271390b.clear();
        }
        List<ISuperPlayer> list2 = f271391c;
        synchronized (list2) {
            Iterator<ISuperPlayer> it5 = list2.iterator();
            while (it5.hasNext()) {
                it5.next().release();
            }
            f271391c.clear();
        }
    }
}
