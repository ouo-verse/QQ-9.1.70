package com.tencent.mobileqq.tvideo.floatingwindow;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowPlayEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowStatusEvent;
import com.tencent.mobileqq.tvideo.player.TVideoQFSVideoView;
import java.lang.ref.SoftReference;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private SoftReference<Activity> f304441a;

    /* renamed from: b, reason: collision with root package name */
    private IVideoOuterStatusListener f304442b;

    /* renamed from: c, reason: collision with root package name */
    private IVideoInnerStatusListener f304443c;

    /* renamed from: d, reason: collision with root package name */
    private IFullScreenEnterListener f304444d;

    /* renamed from: e, reason: collision with root package name */
    private AudioManager f304445e;

    /* renamed from: f, reason: collision with root package name */
    private AudioManager.OnAudioFocusChangeListener f304446f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f304447g = false;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f304448h = false;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f304449i = false;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final h f304451a = new h();
    }

    h() {
    }

    private void e() {
        SoftReference<Activity> softReference = this.f304441a;
        if (softReference != null && softReference.get() != null) {
            j.i(this.f304441a.get().getApplicationContext());
        }
    }

    private void i() {
        this.f304446f = new AudioManager.OnAudioFocusChangeListener() { // from class: com.tencent.mobileqq.tvideo.floatingwindow.f
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i3) {
                h.this.s(i3);
            }
        };
    }

    private void j() {
        this.f304444d = new IFullScreenEnterListener() { // from class: com.tencent.mobileqq.tvideo.floatingwindow.g
            @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener
            public final void onEnter(int i3, int i16) {
                h.this.t(i3, i16);
            }
        };
    }

    private void k() {
        this.f304443c = new a();
    }

    public static h l() {
        return b.f304451a;
    }

    private void m() {
        SoftReference<Activity> softReference;
        if (this.f304447g && this.f304448h && (softReference = this.f304441a) != null && softReference.get() != null) {
            this.f304448h = false;
            j.e(this.f304441a.get()).U(true);
            IVideoInnerStatusListener iVideoInnerStatusListener = this.f304443c;
            if (iVideoInnerStatusListener != null) {
                iVideoInnerStatusListener.notifyVideoStart();
            }
            IVideoOuterStatusListener iVideoOuterStatusListener = this.f304442b;
            if (iVideoOuterStatusListener != null) {
                iVideoOuterStatusListener.onVideoStart(0);
            }
        }
    }

    private void n() {
        if (this.f304447g) {
            j.j();
        }
    }

    private void o() {
        SoftReference<Activity> softReference;
        if (this.f304447g && (softReference = this.f304441a) != null && softReference.get() != null) {
            this.f304448h = true;
            j.e(this.f304441a.get()).U(false);
            IVideoInnerStatusListener iVideoInnerStatusListener = this.f304443c;
            if (iVideoInnerStatusListener != null) {
                iVideoInnerStatusListener.notifyVideoStop();
            }
        }
    }

    private void p() {
        if (this.f304443c == null) {
            k();
        }
        if (this.f304444d == null) {
            j();
        }
        this.f304442b = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(this.f304443c);
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setFullScreenListener(this.f304444d);
    }

    private void q(TVideoQFSVideoView tVideoQFSVideoView) {
        if (tVideoQFSVideoView.getSuperPlayer().isPlaying()) {
            this.f304442b.onVideoStart((int) tVideoQFSVideoView.getSuperPlayer().getDurationMs());
        } else {
            this.f304442b.onVideoStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(int i3) {
        if (!GuardManager.sInstance.isApplicationForeground()) {
            return;
        }
        if (i3 != -3 && i3 != -2) {
            if (i3 != -1) {
                if (i3 == 1) {
                    m();
                    return;
                }
                return;
            }
            n();
            return;
        }
        if (this.f304447g) {
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(int i3, int i16) {
        this.f304449i = true;
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoFloatingWindowStatusEvent(1));
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoFloatingWindowEvent(false));
        j.j();
        e();
    }

    private void v() {
        SoftReference<Activity> softReference = this.f304441a;
        if (softReference != null && softReference.get() != null) {
            if (this.f304445e == null) {
                this.f304445e = (AudioManager) this.f304441a.get().getSystemService("audio");
            }
            if (this.f304446f == null) {
                i();
            }
            this.f304445e.requestAudioFocus(this.f304446f, 3, 1);
        }
    }

    public boolean f(@NonNull Context context) {
        return j.c(context);
    }

    public boolean g(Activity activity, TVideoQFSVideoView tVideoQFSVideoView) {
        if (activity == null || tVideoQFSVideoView == null || tVideoQFSVideoView.getSuperPlayer() == null || !f(activity)) {
            return false;
        }
        this.f304441a = new SoftReference<>(activity);
        j.k(activity.getApplicationContext(), true);
        j.d(activity.getApplicationContext(), tVideoQFSVideoView);
        p();
        q(tVideoQFSVideoView);
        this.f304447g = true;
        v();
        return true;
    }

    public void h() {
        SoftReference<Activity> softReference = this.f304441a;
        if (softReference != null && softReference.get() != null && !this.f304441a.get().isFinishing() && !this.f304441a.get().isDestroyed()) {
            this.f304441a.get().finish();
            this.f304441a.clear();
            this.f304441a = null;
        }
    }

    public boolean r() {
        return this.f304447g;
    }

    public void u() {
        this.f304445e.abandonAudioFocus(null);
        this.f304449i = false;
        this.f304447g = false;
        this.f304448h = false;
        this.f304443c = null;
        this.f304442b = null;
        this.f304444d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements IVideoInnerStatusListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoClose(int i3) {
            h.this.f304447g = false;
            if (!h.this.f304449i) {
                h.this.h();
            }
            h.this.u();
            if (i3 == 1) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoFloatingWindowStatusEvent(3));
            }
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoStart() {
            SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoFloatingWindowPlayEvent(true));
            SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoFloatingWindowStatusEvent(2));
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoStop() {
            SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoFloatingWindowPlayEvent(false));
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoSeek(int i3) {
        }
    }
}
