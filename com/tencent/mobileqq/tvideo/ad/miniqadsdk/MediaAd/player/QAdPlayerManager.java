package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.qqlive.playerinterface.IQAdPlayerView;
import com.tencent.qqlive.playerinterface.QAdUserInfo;
import com.tencent.qqlive.playerinterface.QAdVideoItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kt3.b;
import kt3.i;
import pw2.n;
import pw2.y;

/* loaded from: classes19.dex */
public class QAdPlayerManager implements com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.a {
    private static String S;
    protected List<QAdVideoItem> C;
    private long D;
    private volatile b.InterfaceC10678b E;
    private volatile b.a F;
    private final boolean I;
    protected volatile QAdUserInfo K;

    /* renamed from: d, reason: collision with root package name */
    protected Context f303655d;

    /* renamed from: e, reason: collision with root package name */
    protected volatile kt3.b f303656e;

    /* renamed from: f, reason: collision with root package name */
    protected volatile QAdBasePlayerLayout f303657f;

    /* renamed from: h, reason: collision with root package name */
    protected ViewGroup f303658h;

    /* renamed from: i, reason: collision with root package name */
    private volatile int f303659i = 0;

    /* renamed from: m, reason: collision with root package name */
    private volatile int f303660m = 0;
    private boolean G = false;
    private float H = 1.0f;
    private int J = -16777216;
    protected volatile boolean L = false;
    private int M = 0;
    private int N = 0;
    private boolean P = false;
    private boolean Q = true;
    private b.InterfaceC10678b R = new a();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface QAdPlayerDataStatus {
        public static final int DATA_RECEIVED = 1;
        public static final int INIT = 0;
        public static final int PREPARED = 3;
        public static final int PREPARING = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface QAdPlayerViewStatus {
        public static final int CREATE_AFTER_DESTORY = 4;
        public static final int DESTORY = 3;
        public static final int FIRST_CREATE = 2;
        public static final int INIT = 0;
        public static final int NONE_SURFACE = 1;
    }

    /* loaded from: classes19.dex */
    class a implements b.InterfaceC10678b {
        a() {
        }

        @Override // kt3.b.InterfaceC10678b
        public void onEvent(int i3, int i16, int i17, Object obj) {
            n.a(QAdPlayerManager.S, "onEvent: " + i3 + ", " + i16);
            QAdPlayerManager.this.v(i3, i16, i17, obj);
        }
    }

    public QAdPlayerManager(Context context, ViewGroup viewGroup, boolean z16) {
        String str = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.b.d(QAdPlayerManager.class.getSimpleName()) + hashCode();
        S = str;
        n.e(str, "create QAdPlayerManager");
        this.f303655d = context;
        this.I = z16;
        this.f303658h = viewGroup;
        l(viewGroup);
    }

    private void A() {
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player.QAdPlayerManager.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (QAdPlayerManager.this) {
                    n.e(QAdPlayerManager.S, "releaseView");
                    QAdPlayerManager.this.B();
                    QAdPlayerManager.this.f303658h = null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void B() {
        if (this.f303658h != null && this.f303657f != null) {
            n.e(S, "call-ad, real releaseView");
            this.f303657f.removeAllViews();
            this.f303658h.removeView(this.f303657f);
        }
        this.f303657f = null;
        if (this.f303658h == null) {
            n.e(S, "removePlayerView: mParentView is null");
            return;
        }
        for (int i3 = 0; i3 < this.f303658h.getChildCount(); i3++) {
            View childAt = this.f303658h.getChildAt(i3);
            if (childAt instanceof QAdBasePlayerLayout) {
                n.e(S, "removePlayerView showParentView's child:" + childAt + ", i=" + i3);
            }
        }
    }

    private void J() {
        IQAdPlayerView iQAdPlayerView;
        n.e(S, "call-ad startRender");
        if (this.f303656e != null) {
            kt3.b bVar = this.f303656e;
            if (this.f303657f != null) {
                iQAdPlayerView = this.f303657f.c();
            } else {
                iQAdPlayerView = null;
            }
            bVar.a(iQAdPlayerView);
            if (this.f303657f != null) {
                this.f303657f.b(this.I, this.J);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000a, code lost:
    
        if (q() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean f() {
        boolean z16;
        z16 = true;
        if (this.f303659i == 1) {
        }
        z16 = false;
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i(ViewGroup viewGroup) {
        if (viewGroup == null) {
            n.h(S, "call-ad, createAndAddPlayerView parentView is null");
            return;
        }
        n.e(S, "call-ad, createAndAddPlayerView video");
        this.f303657f = new QAdPlayerLayout(this.f303655d);
        this.f303657f.setPlayerCallback(this);
        if (this.N > 0 && this.M > 0) {
            this.f303657f.setVideoWidthAndHeight(this.M, this.N);
        }
        this.f303657f.setResizePlayerEnable(this.Q);
        this.f303657f.d(this.P);
        if (this.I) {
            n.e(S, "createAndAddPlayerView , setBackground to black");
            this.f303657f.setBackgroundColor(this.J);
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.b.a(viewGroup, this.f303657f);
    }

    private void j(final ViewGroup viewGroup) {
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player.QAdPlayerManager.1
            @Override // java.lang.Runnable
            public void run() {
                QAdPlayerManager.this.i(viewGroup);
            }
        });
    }

    private synchronized void k() {
        i iVar;
        if (f()) {
            n.e(S, "doOpenPlayer");
            kt3.b h16 = h();
            if (h16 == null) {
                n.b(S, "mediaPlayer is null");
                if (this.F != null) {
                    this.F.n(7);
                }
                return;
            }
            if (h16 instanceof i) {
                iVar = (i) h16;
            } else {
                iVar = new i(h16);
            }
            iVar.g(this.R);
            iVar.e(this.K);
            if (this.G) {
                iVar.setOutputMute(true);
            }
            float f16 = this.H;
            if (f16 != 1.0f) {
                iVar.setAudioGainRatio(f16);
            }
            if (this.F != null) {
                this.F.n(3);
            }
            iVar.d(this.C, this.D);
            this.f303656e = iVar;
            this.f303659i = 2;
        }
    }

    private boolean p() {
        if (this.f303660m != 4 && (this.f303659i == 2 || this.f303659i == 3)) {
            return true;
        }
        return false;
    }

    private synchronized boolean q() {
        boolean z16;
        if (this.f303660m != 0) {
            if (!r()) {
                z16 = false;
            }
        }
        z16 = true;
        return z16;
    }

    private boolean r() {
        if (this.f303660m == 2 || this.f303660m == 4 || this.f303660m == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        synchronized (this) {
            n.e(S, "releaseOnlyPlayerView");
            B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(boolean z16) {
        int i3;
        if (this.f303657f != null) {
            QAdBasePlayerLayout qAdBasePlayerLayout = this.f303657f;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            qAdBasePlayerLayout.setVisibility(i3);
            if (z16) {
                J();
            }
        }
    }

    private void z() {
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player.c
            @Override // java.lang.Runnable
            public final void run() {
                QAdPlayerManager.this.t();
            }
        });
    }

    public void C() {
        kt3.b bVar = this.f303656e;
        if (bVar != null) {
            n.e(S, "seekToNextVideo");
            bVar.b();
        }
    }

    public synchronized boolean D(boolean z16) {
        this.G = z16;
        if (this.f303656e != null) {
            return this.f303656e.setOutputMute(z16);
        }
        return true;
    }

    public void E(final boolean z16) {
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.player.b
            @Override // java.lang.Runnable
            public final void run() {
                QAdPlayerManager.this.u(z16);
            }
        });
    }

    public void F(b.a aVar) {
        this.F = aVar;
    }

    public void G(b.InterfaceC10678b interfaceC10678b) {
        this.E = interfaceC10678b;
    }

    protected void H(int i3, int i16) {
        n.e(S, "setVideoWidthAndHeight, width = " + i3 + ", height = " + i16);
        QAdBasePlayerLayout qAdBasePlayerLayout = this.f303657f;
        if (qAdBasePlayerLayout != null) {
            qAdBasePlayerLayout.setVideoWidthAndHeight(i3, i16);
            this.M = 0;
            this.N = 0;
        } else {
            n.h(S, "setVideoWidthAndHeight, but playerLayout is not ready");
            this.M = i3;
            this.N = i16;
        }
        if (this.F != null) {
            this.F.f(i3, i16);
        }
    }

    public synchronized boolean I() {
        n.e(S, "start, mPlayerDataStatus = " + this.f303659i + ", mPlayerViewStatus = " + this.f303660m);
        if (s()) {
            if (this.f303657f != null) {
                this.f303657f.b(true, this.J);
            }
            if (this.f303656e != null) {
                n.e(S, "start, success");
                this.f303656e.start();
                return true;
            }
        }
        return false;
    }

    public synchronized void K(ViewGroup viewGroup) {
        n.e(S, "updatePlayerView, parentView");
        if (viewGroup == null) {
            n.e(S, "doUpdatePlayerView, parentView is null");
            this.f303660m = 1;
        }
        A();
        l(viewGroup);
        if (this.f303656e != null && viewGroup == null) {
            this.f303656e.a(null);
        }
    }

    public synchronized void L(QAdUserInfo qAdUserInfo) {
        this.K = qAdUserInfo;
    }

    public synchronized void g() {
        n.e(S, "close");
        if (this.f303656e != null) {
            if (this.f303656e.isPlaying()) {
                this.f303656e.pause();
            }
            this.f303656e.stop();
            this.f303656e.release();
            this.f303656e.a(null);
            this.f303656e = null;
        }
    }

    public synchronized kt3.b h() {
        IQAdPlayerView iQAdPlayerView;
        if (this.f303656e != null) {
            n.e(S, "createAdPlayer, mQAdMediaPlayer has ready");
            return this.f303656e;
        }
        if (this.f303657f != null) {
            iQAdPlayerView = this.f303657f.c();
        } else {
            iQAdPlayerView = null;
        }
        n.e(S, "createAdPlayer, video");
        this.f303656e = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.b.b(this.f303655d, iQAdPlayerView);
        return this.f303656e;
    }

    public synchronized void l(ViewGroup viewGroup) {
        if (viewGroup != null) {
            n.e(S, "doUpdatePlayerView, parentView is not null");
            this.f303658h = viewGroup;
            j(viewGroup);
        }
    }

    public long m() {
        kt3.b bVar = this.f303656e;
        if (bVar != null) {
            return bVar.getCurrentPositionMs();
        }
        return 0L;
    }

    public ViewGroup n() {
        return this.f303657f;
    }

    protected synchronized boolean o() {
        if (q()) {
            n.e(S, "handleMediaPlayerPrepared 1, ad media player prepared");
            this.f303659i = 3;
            return true;
        }
        n.e(S, "handleMediaPlayerPrepared 2, player view is not ok");
        return false;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.a
    public synchronized void onViewCreated(Object obj, int i3, int i16) {
        n.e(S, "call-ad onViewCreated");
        if (this.f303660m == 1) {
            n.e(S, "onViewCreated after NONE_SURFACE, width = " + i3 + ",height = " + i16);
            this.f303660m = 2;
            J();
        } else {
            if (this.f303660m == 0) {
                n.e(S, "onViewCreated first, width = " + i3 + ",height = " + i16);
                this.f303660m = 2;
            } else if (this.f303660m == 3) {
                n.e(S, "onViewCreated, create after destory, width = " + i3 + ",height = " + i16);
                this.f303660m = 4;
            }
            if (p()) {
                J();
                if (this.F != null) {
                    this.F.m();
                }
            } else {
                n.e(S, "call-ad, viewCreated, start open");
                k();
            }
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.a
    public synchronized void onViewDestroyed(Object obj) {
        n.e(S, "onViewDestroyed");
        if (this.f303660m == 1) {
            n.e(S, "onViewDestroyed, mPlayerViewStatus is NONE_SURFACE, return");
            return;
        }
        this.f303660m = 3;
        if (this.f303659i == 2 || this.f303659i == 3) {
            n.e(S, "onViewDestroyed, mPlayerDataStatus change to DATA_RECEIVED");
            this.f303659i = 1;
            if (this.F != null) {
                n.e(S, "onMediaPlayerStatusCallback pause");
                this.F.n(6);
            }
        }
        if (this.f303656e != null) {
            this.D = this.f303656e.getCurrentPositionMs();
            if (this.f303656e.isPlaying()) {
                this.f303656e.pause();
            }
            this.f303656e.a(null);
            this.f303656e.stop();
            this.f303656e.release();
            this.f303656e = null;
        }
    }

    public synchronized boolean s() {
        boolean z16;
        if (this.f303659i == 3) {
            if (q()) {
                z16 = true;
            }
        }
        z16 = false;
        return z16;
    }

    protected void v(int i3, int i16, int i17, Object obj) {
        boolean z16 = true;
        if (i3 != 1) {
            if (i3 == 5) {
                H(i16, i17);
            }
        } else {
            z16 = o();
        }
        b.InterfaceC10678b interfaceC10678b = this.E;
        if (interfaceC10678b != null && z16) {
            interfaceC10678b.onEvent(i3, i16, i17, obj);
        }
    }

    public synchronized void w(List<QAdVideoItem> list) {
        if (!y.h(list)) {
            ArrayList arrayList = new ArrayList(list);
            this.C = arrayList;
            this.f303659i = 1;
            this.L = ((QAdVideoItem) arrayList.get(0)).f();
            n.e(S, "call-ad, call open");
            if (this.L) {
                n.e(S, "open: is image, need release video player and create image player");
                z();
                i(this.f303658h);
            }
            k();
        } else {
            throw new RuntimeException("adVideoItemList size can not be zero");
        }
    }

    public synchronized boolean x() {
        n.e(S, "pause, mPlayerDataStatus = " + this.f303659i + ", mPlayerViewStatus = " + this.f303660m);
        if (s() && this.f303656e != null) {
            n.e(S, "pause, success");
            this.f303656e.pause();
            return true;
        }
        return false;
    }

    public synchronized void y() {
        n.e(S, "release");
        if (this.f303656e != null) {
            this.f303656e.g(null);
            this.f303656e.stop();
            this.f303656e.release();
            this.f303656e = null;
        }
        this.f303659i = 0;
        this.f303660m = 0;
        A();
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.a
    public void onViewChanged(Object obj, int i3, int i16) {
    }
}
