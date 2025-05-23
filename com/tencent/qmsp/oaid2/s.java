package com.tencent.qmsp.oaid2;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class s implements ServiceConnection {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final ThreadPoolExecutor f344283c;

    /* renamed from: a, reason: collision with root package name */
    public boolean f344284a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f344285b;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final IBinder f344286a;

        public a(IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) s.this, (Object) iBinder);
            } else {
                this.f344286a = iBinder;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                try {
                    s.this.f344285b.offer(this.f344286a);
                } catch (Throwable unused) {
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(TVKEventId.PLAYER_STATE_SWITCH_AUDIO_TRACK_PLAYER_CORE_SWITCH_START);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f344283c = new BaseThreadPoolExecutor(0, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());
        }
    }

    public s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f344285b = new LinkedBlockingQueue<>(1);
            this.f344284a = false;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName, (Object) iBinder);
        } else {
            try {
                f344283c.execute(new a(iBinder));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) componentName);
        }
    }
}
