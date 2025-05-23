package com.tencent.mobileqq.springhb;

import android.media.SoundPool;
import android.os.Build;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ac {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    private static final boolean[] f288951k;

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f288952l;

    /* renamed from: m, reason: collision with root package name */
    private static ac f288953m;

    /* renamed from: a, reason: collision with root package name */
    private volatile SoundPool f288954a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f288955b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f288956c;

    /* renamed from: d, reason: collision with root package name */
    private volatile int f288957d;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f288958e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f288959f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f288960g;

    /* renamed from: h, reason: collision with root package name */
    private FileInputStream f288961h;

    /* renamed from: i, reason: collision with root package name */
    private long f288962i;

    /* renamed from: j, reason: collision with root package name */
    private SoundPool.OnLoadCompleteListener f288963j;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements SoundPool.OnLoadCompleteListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ac.this);
            }
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i17 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, soundPool, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            QLog.d("SpringSoundManager", 1, "onLoadComplete, " + i3 + ", " + i16 + ", mPlayCountDownStreamId=" + ac.this.f288957d + ", mPlayCountDownState=" + ac.this.f288958e);
            while (i17 < 5 && ac.this.f288955b[i17] != i3) {
                i17++;
            }
            if (i17 != 5 && i16 == 0) {
                ac.f288951k[i17] = true;
                ac.this.p(i17, true);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75256);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f288951k = new boolean[]{false, false, false, false, false};
        f288952l = new int[]{R.raw.f169431eu, R.raw.f169433a1, R.raw.f169432ev, R.raw.f169430et, R.raw.f169434ew};
        f288953m = new ac();
    }

    ac() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f288955b = new int[]{0, 0, 0, 0, 0};
        this.f288956c = null;
        this.f288957d = 0;
        this.f288958e = 4;
        this.f288959f = true;
        this.f288960g = true;
        this.f288961h = null;
        this.f288962i = 0L;
        this.f288963j = new a();
    }

    public static ac h() {
        return f288953m;
    }

    private boolean l() {
        if (Build.VERSION.SDK_INT < 30) {
            return false;
        }
        if (!DeviceInfoMonitor.getModel().equalsIgnoreCase("M2004J7AC") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("M2006J10C") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("M2004J7BC")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(boolean z16, int i3) {
        int i16;
        int i17;
        SoundPool soundPool = this.f288954a;
        if (soundPool != null && (!z16 || this.f288957d == 0)) {
            if (z16) {
                i16 = 10;
            } else {
                i16 = 1;
            }
            if (z16) {
                i17 = -1;
            } else {
                i17 = 0;
            }
            float f16 = 1;
            int play = soundPool.play(i3, f16, f16, i16, i17, 1.0f);
            if (z16) {
                this.f288957d = play;
                if (this.f288958e == 4) {
                    try {
                        soundPool.pause(this.f288957d);
                        QLog.i("SpringSoundManager", 1, "playSoundBySpool stop the CountDown sound");
                    } catch (Throwable th5) {
                        QLog.e("SpringSoundManager", 1, "playSoundBySpool stop e:", th5);
                    }
                    this.f288957d = 0;
                }
            }
            QLog.i("SpringSoundManager", 1, "playSoundBySpool loadId:" + i3 + " streamId:" + play + " isPlayCountDownSound:" + z16);
            return;
        }
        QLog.i("SpringSoundManager", 1, "playSoundBySpool return, isPlayCountDownSound:" + z16 + " mPlayCountDownStreamId:" + this.f288957d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i3, boolean z16) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[Async log]playSound, ");
        sb5.append(i3);
        sb5.append(", ");
        sb5.append(this.f288955b[i3]);
        sb5.append(", ");
        boolean[] zArr = f288951k;
        sb5.append(zArr[i3]);
        sb5.append(", mPlayCountDownStreamId=");
        sb5.append(this.f288957d);
        sb5.append(", mPlayCountDownState=");
        sb5.append(this.f288958e);
        QLog.iAsync("SpringSoundManager", 1, sb5.toString());
        if (l()) {
            QLog.d("SpringSoundManager", 1, "playSound return for special phone");
            return;
        }
        if (this.f288956c == null) {
            this.f288956c = f288952l;
        }
        if (i3 == 2) {
            this.f288959f = false;
            this.f288960g = false;
        }
        if (i()) {
            QLog.iAsync("SpringSoundManager", 1, "[Async log]playSound return isMute");
            return;
        }
        try {
            if (this.f288954a == null) {
                this.f288954a = new SoundPool(10, 3, 0);
                this.f288954a.setOnLoadCompleteListener(this.f288963j);
            }
            if (i3 == 2) {
                if (this.f288958e != 4 || !z16) {
                    if (this.f288958e == 1 && !z16) {
                        return;
                    } else {
                        this.f288958e = 1;
                    }
                } else {
                    return;
                }
            }
            int i16 = this.f288955b[i3];
            if (i16 == 0) {
                if (i3 == 2 && this.f288961h != null && this.f288962i != 0) {
                    i16 = this.f288954a.load(this.f288961h.getFD(), 0L, this.f288962i, 1);
                }
                if (i16 == 0) {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime == null) {
                        return;
                    } else {
                        i16 = this.f288954a.load(peekAppRuntime.getApplicationContext(), this.f288956c[i3], 1);
                    }
                }
                this.f288955b[i3] = i16;
                return;
            }
            if (zArr[i3]) {
                if (i3 != 2) {
                    q(i16, false);
                } else if (this.f288957d == 0) {
                    q(i16, true);
                }
            }
            QLog.iAsync("SpringSoundManager", 1, "[Async log]playSound, " + i3 + ", " + this.f288955b[i3] + ", " + zArr[i3] + ", loadId:" + i16);
        } catch (Throwable th5) {
            QLog.e("SpringSoundManager", 1, "playSound, throwable=", th5);
        }
    }

    private void q(final int i3, final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.springhb.aa
            @Override // java.lang.Runnable
            public final void run() {
                ac.this.m(z16, i3);
            }
        }, 16, null, false);
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return ((SpringFestivalEntryManager) peekAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).N().isMuteSys;
        }
        return false;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f288959f;
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f288960g;
    }

    public void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else if (l()) {
            QLog.d("SpringSoundManager", 1, "playSound return for special phone");
        } else {
            p(i3, false);
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.i("SpringSoundManager", 1, "reset");
        if (this.f288954a != null) {
            final SoundPool soundPool = this.f288954a;
            this.f288954a = null;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.springhb.ab
                @Override // java.lang.Runnable
                public final void run() {
                    soundPool.release();
                }
            }, 16, null, false);
            Arrays.fill(this.f288955b, 0);
            Arrays.fill(f288951k, false);
            this.f288957d = 0;
            this.f288958e = 4;
        }
        this.f288956c = null;
        this.f288959f = true;
        FileInputStream fileInputStream = this.f288961h;
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e16) {
                QLog.e("SpringSoundManager", 1, e16, new Object[0]);
            }
            this.f288961h = null;
            this.f288962i = 0L;
        }
    }

    public void s(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) file);
            return;
        }
        if (file != null && file.exists()) {
            try {
                this.f288961h = new FileInputStream(file);
                this.f288962i = file.length();
            } catch (IOException e16) {
                QLog.e("SpringSoundManager", 1, e16, new Object[0]);
            }
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f288959f = true;
            this.f288960g = true;
        }
    }

    public void u(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            SpringFestivalEntryManager springFestivalEntryManager = (SpringFestivalEntryManager) peekAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
            springFestivalEntryManager.N().isMuteSys = z16;
            springFestivalEntryManager.g0();
        }
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.iAsync("SpringSoundManager", 1, "[Async log]stopCountDownSound, mPlayCountDownStreamId=" + this.f288957d + ", mPlayCountDownState=" + this.f288958e);
        if (this.f288958e == 4) {
            return;
        }
        if (this.f288957d != 0) {
            try {
                if (this.f288954a != null) {
                    this.f288954a.pause(this.f288957d);
                }
            } catch (Throwable th5) {
                QLog.e("SpringSoundManager", 1, "stopCountDownSound, throwable=", th5);
            }
        }
        this.f288957d = 0;
        this.f288958e = 4;
    }
}
