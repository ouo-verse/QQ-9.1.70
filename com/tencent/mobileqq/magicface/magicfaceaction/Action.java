package com.tencent.mobileqq.magicface.magicfaceaction;

import android.os.Vibrator;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder;
import com.tencent.mobileqq.magicface.model.e;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3EncodeThread;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes15.dex */
public class Action {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public ActionGlobalData f243330a;

    /* renamed from: b, reason: collision with root package name */
    public String f243331b;

    /* renamed from: c, reason: collision with root package name */
    public List<e> f243332c;

    /* renamed from: d, reason: collision with root package name */
    e f243333d;

    /* renamed from: e, reason: collision with root package name */
    public int f243334e;

    /* renamed from: f, reason: collision with root package name */
    public int f243335f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.mobileqq.magicface.service.b f243336g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f243337h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.mobileqq.magicface.magicfaceaction.a f243338i;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f243339j;

    /* renamed from: k, reason: collision with root package name */
    volatile boolean f243340k;

    /* renamed from: l, reason: collision with root package name */
    int f243341l;

    /* renamed from: m, reason: collision with root package name */
    Vibrator f243342m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f243343n;

    /* renamed from: o, reason: collision with root package name */
    CountDownLatch f243344o;

    /* renamed from: p, reason: collision with root package name */
    MagicfaceDecoder.a f243345p;

    /* renamed from: q, reason: collision with root package name */
    TimerTask f243346q;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements MagicfaceDecoder.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Action.this);
            }
        }

        @Override // com.tencent.mobileqq.magicface.model.MagicfaceDecoder.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.qqmini.sdk.launcher.core.action.Action.TAG, 2, "fun startMagicPlay begins, sumPlayTimes:" + Action.this.f243341l + ",actionGlobalData.openSound:" + Action.this.f243330a.f243361n);
            }
            Action action = Action.this;
            if (action.f243341l == 0) {
                action.c();
                String str = Action.this.f243333d.f243460f;
                if (str != null && str.length() > 0) {
                    Action action2 = Action.this;
                    if (action2.f243330a.f243361n) {
                        e eVar = action2.f243333d;
                        int i3 = eVar.f243462h;
                        if (i3 > 0) {
                            eVar.f243462h = i3 - 1;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(com.tencent.qqmini.sdk.launcher.core.action.Action.TAG, 2, "fun startMagicPlay begins, start play Sound.");
                        }
                        Action action3 = Action.this;
                        com.tencent.mobileqq.magicface.service.b bVar = action3.f243336g;
                        e eVar2 = action3.f243333d;
                        bVar.e(eVar2.f243460f, eVar2.f243462h);
                    }
                }
                Action action4 = Action.this;
                if (action4.f243333d.f243465k) {
                    action4.f243342m = (Vibrator) BaseApplication.getContext().getSystemService("vibrator");
                    Action action5 = Action.this;
                    if (action5.f243333d.f243466l == -1) {
                        action5.f243342m.vibrate(new long[]{0, 1000}, 0);
                    } else {
                        action5.f243342m.vibrate(r3 * 1000);
                    }
                }
            }
            Action.this.f243341l++;
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.qqmini.sdk.launcher.core.action.Action.TAG, 2, "fun startMagicPlay ends, sumPlayTimes:" + Action.this.f243341l);
            }
        }

        @Override // com.tencent.mobileqq.magicface.model.MagicfaceDecoder.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.qqmini.sdk.launcher.core.action.Action.TAG, 2, "func endMagicPlay begins, isStop:" + Action.this.f243340k + ",timeout:" + Action.this.f243334e + ",playTimes:" + Action.this.f243335f + ",sumPlayTimes:" + Action.this.f243341l + ",isTimeout:" + Action.this.f243339j);
            }
            if (Action.this.f243340k) {
                Action.this.f243344o.countDown();
                return;
            }
            Action action = Action.this;
            if (action.f243334e == -1) {
                int i3 = action.f243335f;
                if (i3 == -1) {
                    action.f243336g.d(action.f243333d);
                    return;
                }
                int i16 = action.f243341l;
                if (i3 > i16) {
                    action.f243336g.d(action.f243333d);
                    return;
                } else if (i3 == i16) {
                    action.f243344o.countDown();
                    return;
                }
            }
            if (!action.f243339j) {
                Action action2 = Action.this;
                action2.f243336g.d(action2.f243333d);
            }
        }
    }

    public Action() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f243332c = new ArrayList();
        this.f243334e = -1;
        this.f243335f = 1;
        this.f243339j = false;
        this.f243340k = false;
        this.f243341l = 0;
        this.f243343n = false;
        this.f243344o = new CountDownLatch(1);
        this.f243345p = new a();
        this.f243346q = new TimerTask() { // from class: com.tencent.mobileqq.magicface.magicfaceaction.Action.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Action.this);
                }
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    Action.this.d();
                    Action.this.g();
                }
            }
        };
    }

    public void a(int i3, MagicfaceActionManager.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) fVar);
            return;
        }
        com.tencent.mobileqq.magicface.magicfaceaction.a aVar = this.f243338i;
        if (aVar == null) {
            return;
        }
        int i16 = aVar.f243377d;
        if (i16 > 0 && i16 < 40) {
            i16 *= 2;
        }
        if (QLog.isColorLevel()) {
            QLog.i(com.tencent.qqmini.sdk.launcher.core.action.Action.TAG, 2, "==stopValue=" + i16);
        }
        if ("end".equalsIgnoreCase(this.f243338i.f243376c)) {
            if (i3 >= i16) {
                g();
                return;
            }
            return;
        }
        if ("stop".equalsIgnoreCase(this.f243338i.f243374a) && i3 >= i16 && MiniGameLameMp3EncodeThread.AUDIO_SOURCE_MIC.equalsIgnoreCase(this.f243338i.f243375b)) {
            g();
            if (fVar != null) {
                fVar.stop();
                return;
            }
            return;
        }
        if (QQPermissionConstants.Permission.AUIDO_GROUP.equalsIgnoreCase(this.f243338i.f243374a)) {
            this.f243330a.f243356i += this.f243338i.a(i3);
            ActionGlobalData actionGlobalData = this.f243330a;
            c cVar = actionGlobalData.f243360m;
            if (cVar != null) {
                actionGlobalData.f243358k = cVar.a(actionGlobalData.f243356i, actionGlobalData.f243363p);
            }
        }
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        this.f243339j = false;
        f();
        e eVar = this.f243333d;
        this.f243335f = eVar.f243459e;
        this.f243336g.h(eVar.f243464j);
        this.f243336g.j(this.f243345p);
        this.f243336g.d(this.f243333d);
        try {
            this.f243344o.await();
        } catch (Exception unused) {
        }
        String str = this.f243333d.f243460f;
        if (str != null && str.length() > 0) {
            this.f243336g.m(this.f243333d.f243460f);
        }
        Vibrator vibrator = this.f243342m;
        if (vibrator != null && this.f243333d.f243465k) {
            vibrator.cancel();
        }
        if (this.f243339j && !this.f243337h) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i(com.tencent.qqmini.sdk.launcher.core.action.Action.TAG, 2, "===Magicaction is stop====");
            return true;
        }
        return true;
    }

    void c() {
        if (this.f243334e > 0) {
            ThreadManagerV2.getTimer().schedule(this.f243346q, this.f243334e * 1000);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f243339j = true;
        }
    }

    public void e(int i3, MagicfaceActionManager.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) fVar);
            return;
        }
        com.tencent.mobileqq.magicface.magicfaceaction.a aVar = this.f243338i;
        if (aVar == null) {
            return;
        }
        if ("end".equalsIgnoreCase(aVar.f243376c)) {
            if (fVar != null) {
                g();
            }
        } else if ("stop".equalsIgnoreCase(this.f243338i.f243374a) && WebRTCSDK.PRIVILEGE_TOUCH.equalsIgnoreCase(this.f243338i.f243375b) && this.f243338i.f243378e == i3) {
            g();
            if (fVar != null) {
                fVar.stop();
            }
        }
    }

    void f() {
        int size = this.f243332c.size();
        if (size == 1) {
            this.f243333d = this.f243332c.get(0);
            return;
        }
        if (size > 1 && this.f243330a.f243356i >= 0) {
            for (e eVar : this.f243332c) {
                int i3 = eVar.f243455a;
                int i16 = this.f243330a.f243356i;
                if (i3 <= i16 && eVar.f243456b > i16) {
                    this.f243333d = eVar;
                    return;
                }
            }
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f243340k = true;
        this.f243336g.l();
        this.f243346q.cancel();
    }
}
