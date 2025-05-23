package com.tencent.luggage.wxa.eh;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.mg.g;
import com.tencent.luggage.wxa.mg.k;
import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c extends b {
    public boolean W;

    /* renamed from: a0, reason: collision with root package name */
    public String f124851a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f124852b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f124853c0;

    /* renamed from: d0, reason: collision with root package name */
    public final Rect f124854d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f124855e0;

    public c(Context context) {
        super(context);
        this.f124853c0 = 0;
        this.f124854d0 = new Rect();
        this.f124855e0 = false;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void a(boolean z16, String str, int i3) {
        this.W = z16;
        this.f124851a0 = str;
        this.f124852b0 = i3;
    }

    public abstract d b(Context context);

    @Override // com.tencent.luggage.wxa.eh.d.b
    public void b(int i3, int i16) {
        b("MicroMsg.Video.BaseVideoView", "onInfo [%d %d]", Integer.valueOf(i3), Integer.valueOf(i16));
        if (i3 == 701) {
            x();
        } else if (i3 == 702) {
            n();
        }
    }

    @Override // com.tencent.luggage.wxa.eh.b, com.tencent.luggage.wxa.mg.g
    public void d() {
        boolean z16 = this.f124827b;
        super.d();
        d dVar = this.f124836k;
        if (dVar != null && (dVar instanceof a)) {
            if (this.D) {
                c();
                return;
            }
            boolean localVisibleRect = getLocalVisibleRect(this.f124854d0);
            b("MicroMsg.Video.BaseVideoView", "onUIResume, oldIsUIAvailable: %b, isShown: %b", Boolean.valueOf(z16), Boolean.valueOf(localVisibleRect));
            if (!z16 && localVisibleRect) {
                ((a) this.f124836k).b();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.eh.b, com.tencent.luggage.wxa.mg.g
    public void f() {
        super.f();
    }

    @Override // com.tencent.luggage.wxa.eh.b, com.tencent.luggage.wxa.mg.g
    public int getCacheTimeSec() {
        try {
            if (this.f124836k instanceof a) {
                return (int) (super.getVideoDurationSec() * ((((a) r1).getDownloadPercent() * 1.0f) / 100.0f));
            }
        } catch (Exception e16) {
            a("MicroMsg.Video.BaseVideoView", e16, "get cache time sec error", new Object[0]);
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.eh.b, com.tencent.luggage.wxa.mg.g
    public int getVideoDurationSec() {
        int i3 = this.f124852b0;
        if (i3 <= 0) {
            return super.getVideoDurationSec();
        }
        return i3;
    }

    @Override // com.tencent.luggage.wxa.eh.b
    public int getVideoSource() {
        return this.f124853c0;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean i() {
        int i3;
        boolean q16 = q();
        d dVar = this.f124836k;
        if (dVar != null) {
            i3 = dVar.getDuration();
        } else {
            i3 = 0;
        }
        if (!this.W && (!q16 || i3 > 0)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void j() {
        d dVar = this.f124836k;
        if (dVar != null) {
            b("MicroMsg.Video.BaseVideoView", "preloadVideo url:%s, path:%s", this.f124851a0, dVar.getVideoPath());
            if (w0.c(this.f124836k.getVideoPath())) {
                this.f124836k.setVideoPath(this.f124851a0);
                this.H = false;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.eh.b
    public void n() {
        super.n();
    }

    public void setLoop(boolean z16) {
        this.f124855e0 = z16;
    }

    @Override // com.tencent.luggage.wxa.eh.b, com.tencent.luggage.wxa.mg.g
    public void setScaleType(g.h hVar) {
        d dVar = this.f124836k;
        if (dVar instanceof a) {
            ((a) dVar).setScaleType(hVar);
        }
    }

    @Override // com.tencent.luggage.wxa.eh.b, com.tencent.luggage.wxa.mg.g
    public void setVideoContext(@NonNull k kVar) {
        super.setVideoContext(kVar);
        d dVar = this.f124836k;
        if (dVar instanceof a) {
            ((a) dVar).setVideoContext(kVar);
        }
    }

    @Override // com.tencent.luggage.wxa.eh.b, com.tencent.luggage.wxa.mg.g
    public void setVideoSource(int i3) {
        this.f124853c0 = i3;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void start() {
        d dVar = this.f124836k;
        if (dVar != null) {
            b("MicroMsg.Video.BaseVideoView", "start path [%s] [%s]", dVar.getVideoPath(), w0.b());
            if (w0.c(this.f124836k.getVideoPath())) {
                this.f124836k.setVideoPath(this.f124851a0);
                this.H = true;
                x();
            } else {
                this.H = true;
                c();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.eh.b
    public d a(Context context) {
        return b(context);
    }

    @Override // com.tencent.luggage.wxa.eh.b, com.tencent.luggage.wxa.eh.d.a
    public void b() {
        if (i()) {
            b("MicroMsg.Video.BaseVideoView", "it is live video, do not completion", new Object[0]);
            stop();
            start();
        } else {
            super.b();
            if (this.f124855e0) {
                a(0.0d, true);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean a(float f16) {
        b("MicroMsg.Video.BaseVideoView", "set play rate [%f]", Float.valueOf(f16));
        d dVar = this.f124836k;
        if (dVar instanceof a) {
            return ((a) dVar).a(f16);
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.eh.b, com.tencent.luggage.wxa.mg.g
    public boolean a(double d16, boolean z16) {
        if (i()) {
            d("MicroMsg.Video.BaseVideoView", "it is live, don't seek ", new Object[0]);
            return false;
        }
        return super.a(d16, z16);
    }

    @Override // com.tencent.luggage.wxa.eh.b, com.tencent.luggage.wxa.mg.g
    public View getView() {
        return this;
    }
}
