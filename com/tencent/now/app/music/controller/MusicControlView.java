package com.tencent.now.app.music.controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.component.core.log.LogUtil;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mobileqq.R;
import com.tencent.now.app.music.model.data.MusicItem;
import com.tencent.now.app.music.model.manager.MusicPlayMgr;
import com.tencent.now.app.music.view.AccompanyTipsView;
import com.tencent.now.app.music.view.FloatLyricsView;
import com.tencent.now.app.music.view.MusicSettingView;
import com.tencent.now.app.music.widget.AudioVolumeSettingDialog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MusicControlView extends RelativeLayout implements b, FloatLyricsView.a, ThreadCenter.HandlerKeyable {
    private long C;
    private long D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private boolean I;
    com.tencent.now.app.music.controller.a J;
    private MusicItem K;

    /* renamed from: d, reason: collision with root package name */
    public int f337997d;

    /* renamed from: e, reason: collision with root package name */
    private MusicPlayMgr f337998e;

    /* renamed from: f, reason: collision with root package name */
    private MusicSettingView f337999f;

    /* renamed from: h, reason: collision with root package name */
    private FloatLyricsView f338000h;

    /* renamed from: i, reason: collision with root package name */
    private AccompanyTipsView f338001i;

    /* renamed from: m, reason: collision with root package name */
    private long f338002m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface AccompanyType {
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
    }

    public MusicControlView(Context context) {
        this(context, null);
    }

    private void B(int i3) {
        MusicPlayMgr musicPlayMgr = this.f337998e;
        if (musicPlayMgr == null) {
            return;
        }
        if (musicPlayMgr.t() == 1) {
            this.C += SystemClock.uptimeMillis() - this.f338002m;
        } else {
            this.D += SystemClock.uptimeMillis() - this.f338002m;
        }
        long j3 = this.C;
        if ((j3 != 0 || this.D != 0) && j3 <= 600000 && this.D <= 600000) {
            int i16 = this.E;
            if ((i16 > 0 || this.F != 0) && ((i16 > 1 || this.F != 1) && i16 == 0)) {
                int i17 = this.F;
            }
            this.C = 0L;
            this.D = 0L;
            this.E = 0;
            this.F = 0;
        }
    }

    private void C() {
        LogUtil.i("MusicControlView", "requestMusicSettingView", new Object[0]);
    }

    private void D(MusicItem musicItem) {
        com.tencent.now.app.music.controller.a aVar;
        if (!this.I || (aVar = this.J) == null) {
            return;
        }
        if (this.f338000h != null) {
            if (aVar.a() == 0) {
                this.f338000h.h();
            } else {
                this.f338000h.setNoLyricsMode();
            }
        }
        if (this.f337998e != null) {
            if (this.J.b() == 1) {
                this.f337998e.J();
            } else {
                this.f337998e.H();
            }
            int c16 = this.J.c();
            if (c16 == 1) {
                this.f337998e.I();
            } else if (c16 == 0) {
                this.f337998e.G();
            } else {
                this.f337998e.I();
            }
        }
    }

    private void t() {
        if (this.I) {
            LogUtil.w("music", "MusicControlView already init", new Object[0]);
            return;
        }
        this.I = true;
        View inflate = View.inflate(getContext(), R.layout.fmo, this);
        this.f338000h = (FloatLyricsView) inflate.findViewById(R.id.s7p);
        this.f338001i = (AccompanyTipsView) inflate.findViewById(R.id.s7q);
        C();
        LogUtil.w("music", "MusicControlView init", new Object[0]);
        this.f338000h.setMusicControl(this);
        this.f338000h.setParentUIControl(this);
        this.f338000h.setVisibility(8);
        MusicPlayMgr musicPlayMgr = this.f337998e;
        if (musicPlayMgr != null) {
            this.f338000h.setMusicPlayMgr(musicPlayMgr);
        }
    }

    private void v(MusicItem musicItem) {
        if (this.J == null) {
            this.J = new com.tencent.now.app.music.controller.a();
        }
        this.J.d(musicItem, this.f337997d);
        D(musicItem);
    }

    private void x(MusicItem musicItem, boolean z16) {
        if (this.I && musicItem != null && !musicItem.isEmpty()) {
            this.K = musicItem;
            if (z16) {
                v(musicItem);
                this.f338000h.setVisibility(0);
                this.f338000h.b().c();
                this.f338000h.b().i(musicItem);
                this.f338000h.setVisibility(0);
            }
            MusicSettingView musicSettingView = this.f337999f;
            if (musicSettingView != null) {
                musicSettingView.d();
            }
        }
    }

    public void A() {
        if (!this.I) {
            return;
        }
        this.f338000h.b().p();
        this.f338000h.b().i(null);
        if (this.f337998e != null) {
            LogUtil.i("MusicControlView", "playStop", new Object[0]);
            this.f337998e.P();
        }
        B(2);
    }

    @Override // com.tencent.now.app.music.controller.b
    public void a() {
        if (!this.I) {
            return;
        }
        this.E++;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.C += uptimeMillis - this.f338002m;
        this.f338002m = uptimeMillis;
        MusicPlayMgr musicPlayMgr = this.f337998e;
        if (musicPlayMgr != null) {
            musicPlayMgr.I();
        }
        this.f338001i.setNotify("\u539f\u5531\u6a21\u5f0f", false);
        k().g(1);
    }

    @Override // com.tencent.now.app.music.controller.b
    public int b() {
        return this.f337997d;
    }

    @Override // com.tencent.now.app.music.controller.b
    public void c() {
        if (!this.I) {
            return;
        }
        this.f338000h.h();
        this.f338001i.setNotify("\u6709\u8bcd\u6a21\u5f0f", false);
        k().e(0);
    }

    @Override // com.tencent.now.app.music.controller.b
    public void d(boolean z16) {
        if (!this.I) {
            return;
        }
        LogUtil.i("MusicControlView", "closeBanzou", new Object[0]);
        A();
        MusicSettingView musicSettingView = this.f337999f;
        if (musicSettingView != null) {
            this.K = null;
            musicSettingView.e();
        }
        setVisibility(8);
        int i3 = 1;
        if (z16) {
            int i16 = this.G;
            if (i16 != 0 && i16 != 1) {
            }
            i3 = 3;
        }
        B(i3);
        removeAllViews();
        this.I = false;
        this.f337998e = null;
        ThreadCenter.clear(this);
    }

    @Override // com.tencent.now.app.music.controller.b
    public void e(String str) {
        if (!this.I) {
            return;
        }
        MusicSettingView musicSettingView = this.f337999f;
        if (musicSettingView != null) {
            this.K = null;
            musicSettingView.e();
        }
        this.f338000h.b().o(str, false);
        ThreadCenter.postDelayedUITask(this, new Runnable() { // from class: com.tencent.now.app.music.controller.MusicControlView.1
            @Override // java.lang.Runnable
            public void run() {
                MusicControlView.this.d(false);
            }
        }, 3000L);
    }

    @Override // com.tencent.now.app.music.controller.b
    public void f(MusicItem musicItem) {
        w();
        u(musicItem, true);
    }

    @Override // com.tencent.now.app.music.controller.b
    public MusicItem g() {
        return this.K;
    }

    @Override // com.tencent.now.app.music.controller.b
    public void h() {
        if (!this.I) {
            return;
        }
        this.F++;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.D += uptimeMillis - this.f338002m;
        this.f338002m = uptimeMillis;
        MusicPlayMgr musicPlayMgr = this.f337998e;
        if (musicPlayMgr != null) {
            musicPlayMgr.G();
        }
        this.f338001i.setNotify("\u4f34\u594f\u6a21\u5f0f", false);
        k().g(0);
    }

    @Override // com.tencent.now.app.music.controller.b
    public void i(MusicItem musicItem) {
        x(musicItem, true);
    }

    @Override // com.tencent.now.app.music.controller.b
    public void j(boolean z16) {
        if (!this.I) {
            return;
        }
        MusicPlayMgr musicPlayMgr = this.f337998e;
        if (musicPlayMgr != null) {
            musicPlayMgr.J();
        }
        if (z16) {
            this.f338001i.setNotify("\u5355\u66f2\u6a21\u5f0f", false);
        }
        k().f(1);
    }

    @Override // com.tencent.now.app.music.controller.b
    public com.tencent.now.app.music.controller.a k() {
        if (this.J == null) {
            LogUtil.i("MusicControlView", "getAccompanySetting -> mAccompanySetting is null", new Object[0]);
            v(this.K);
        }
        return this.J;
    }

    @Override // com.tencent.now.app.music.controller.b
    public void l(boolean z16) {
        if (!this.I) {
            return;
        }
        MusicPlayMgr musicPlayMgr = this.f337998e;
        if (musicPlayMgr != null) {
            musicPlayMgr.H();
        }
        if (z16) {
            this.f338001i.setNotify("\u5faa\u73af\u6a21\u5f0f", false);
        }
        k().f(0);
    }

    @Override // com.tencent.now.app.music.controller.b
    public void m() {
        if (this.I && this.f337998e != null) {
            this.f338000h.b().g(this.f337998e.u());
        }
    }

    @Override // com.tencent.now.app.music.view.FloatLyricsView.a
    public RectF n() {
        RectF rectF = new RectF();
        rectF.left = getX();
        rectF.right = getX() + getWidth();
        rectF.top = getY();
        rectF.bottom = getY() + getHeight();
        return rectF;
    }

    @Override // com.tencent.now.app.music.controller.b
    public Activity o() {
        return (Activity) getContext();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtil.i("MusicControlView", "musicControlView:onDetachedFromWindow", new Object[0]);
        ThreadCenter.clear(this);
    }

    @Override // com.tencent.now.app.music.controller.b
    public void onProgressUpdate(int i3, int i16) {
        MusicSettingView musicSettingView;
        if (this.I && (musicSettingView = this.f337999f) != null) {
            musicSettingView.f(i3 / i16);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        FloatLyricsView floatLyricsView = this.f338000h;
        if (floatLyricsView != null) {
            floatLyricsView.f();
        }
    }

    @Override // com.tencent.now.app.music.controller.b
    public void p() {
        int i3;
        AudioVolumeSettingDialog audioVolumeSettingDialog = new AudioVolumeSettingDialog();
        audioVolumeSettingDialog.c(this.f337997d);
        audioVolumeSettingDialog.d(this.f337998e);
        Activity o16 = o();
        if (o16 != null) {
            audioVolumeSettingDialog.show(o16.getFragmentManager(), "start_volume_fragment");
        }
        dm3.a d16 = new dm3.a().e("add_music").d("click_sound_icon");
        if (this.f337997d != 1) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        d16.a("res2", i3).c();
    }

    @Override // com.tencent.now.app.music.controller.b
    public void q() {
        LogUtil.w("music", "MusicControlView showMusicControl", new Object[0]);
        t();
        setVisibility(0);
        this.f338002m = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0;
        this.F = 0;
    }

    @Override // com.tencent.now.app.music.controller.b
    public void r(int i3, String str) {
        if (!this.I) {
            return;
        }
        onProgressUpdate(1, 1);
        this.f338000h.b().j();
    }

    @Override // com.tencent.now.app.music.controller.b
    public void s() {
        if (!this.I) {
            return;
        }
        if (this.H) {
            this.f338000h.a(false);
        }
        this.G++;
        this.f338002m = SystemClock.uptimeMillis();
        this.f338000h.b().e();
    }

    public void setAccompanyType(int i3) {
        this.f337997d = i3;
    }

    @Override // com.tencent.now.app.music.controller.b
    public void setMusicPlayMgr(MusicPlayMgr musicPlayMgr) {
        this.f337998e = musicPlayMgr;
        if (!this.I) {
            return;
        }
        this.f338000h.setMusicPlayMgr(musicPlayMgr);
    }

    public void setMusicSettingView(MusicSettingView musicSettingView) {
        this.f337999f = musicSettingView;
        MusicItem musicItem = this.K;
        if (musicItem != null) {
            u(musicItem, false);
            x(this.K, false);
        }
    }

    @Override // com.tencent.now.app.music.controller.b
    public void setNoLyricsMode() {
        if (!this.I) {
            return;
        }
        this.f338000h.setNoLyricsMode();
        this.f338001i.setNotify("\u65e0\u8bcd\u6a21\u5f0f", false);
        k().e(1);
    }

    public void u(MusicItem musicItem, boolean z16) {
        if (!this.I) {
            return;
        }
        this.K = musicItem;
        if (this.f337999f != null) {
            if (z16) {
                v(musicItem);
            }
            this.f337999f.g(musicItem);
        }
    }

    public void y() {
        if (this.I && this.f337998e != null) {
            LogUtil.w("MusicControlView", "playPause", new Object[0]);
            this.f337998e.C();
            this.f338000h.b().p();
            if (this.f337997d != 1) {
                this.f338000h.b().g(this.f337998e.u());
            }
        }
    }

    public void z() {
        MusicPlayMgr musicPlayMgr;
        if (this.I && (musicPlayMgr = this.f337998e) != null) {
            musicPlayMgr.D();
            if (this.f337997d != 1) {
                this.f338000h.b().f(this.f337998e.u());
            }
        }
    }

    public MusicControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MusicControlView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f337997d = 0;
        this.f338002m = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.I = false;
        this.K = null;
    }

    private void w() {
    }

    public void setEnableFocus(boolean z16) {
    }

    public void setExternalCallback(Activity activity, a aVar) {
    }
}
