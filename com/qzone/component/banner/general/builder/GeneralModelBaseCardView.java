package com.qzone.component.banner.general.builder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import gf.r;
import i6.a;
import i6.e;
import k6.b;
import k6.d;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class GeneralModelBaseCardView extends FrameLayout implements e, r {

    /* renamed from: d, reason: collision with root package name */
    private d f46573d;

    /* renamed from: e, reason: collision with root package name */
    protected a f46574e;

    /* renamed from: f, reason: collision with root package name */
    protected i6.d f46575f;

    public GeneralModelBaseCardView(Context context) {
        super(context);
    }

    @Override // gf.r
    public void a() {
        QLog.d(h(), 1, "onVideoReleasePlayer");
        d dVar = this.f46573d;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void c(a aVar) {
        this.f46574e = aVar;
        j(aVar);
    }

    @Override // gf.r
    public QZoneVideoItemWidgetView d() {
        return null;
    }

    public void e(a aVar) {
        d a16 = b.a(aVar);
        this.f46573d = a16;
        if (a16 != null) {
            a16.n(aVar, this);
        }
    }

    public i6.d f() {
        return this.f46575f;
    }

    protected abstract int g();

    protected abstract String h();

    public void i(a aVar) {
        LayoutInflater.from(getContext()).inflate(g(), (ViewGroup) this, true);
        k();
        if (aVar != null) {
            c(aVar);
        }
    }

    protected abstract void j(a aVar);

    protected abstract void k();

    @Override // i6.e
    public void onClose() {
        QLog.d(h(), 1, "onClose");
        d dVar = this.f46573d;
        if (dVar != null) {
            dVar.onClose();
        }
    }

    @Override // i6.e
    public void onDestroy() {
        QLog.d(h(), 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        d dVar = this.f46573d;
        if (dVar != null) {
            dVar.onDestroy();
        }
    }

    @Override // i6.e
    public void onInit() {
        QLog.d(h(), 1, "onInit");
        d dVar = this.f46573d;
        if (dVar != null) {
            dVar.onInit();
        }
    }

    @Override // i6.e
    public void onPause() {
        QLog.d(h(), 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        d dVar = this.f46573d;
        if (dVar != null) {
            dVar.onPause();
        }
    }

    @Override // i6.e
    public void onResume() {
        QLog.d(h(), 1, "onResume");
        d dVar = this.f46573d;
        if (dVar != null) {
            dVar.onResume();
        }
    }

    @Override // gf.r
    public void pause() {
        QLog.d(h(), 1, "onVideoPause");
        d dVar = this.f46573d;
        if (dVar != null) {
            dVar.pause();
        }
    }

    @Override // gf.r
    public void play() {
        QLog.d(h(), 1, "onVideoPlay");
        d dVar = this.f46573d;
        if (dVar != null) {
            dVar.play();
        }
    }

    public void setActionCallback(i6.d dVar) {
        this.f46575f = dVar;
    }

    public abstract void setDividerLineVisible(boolean z16);
}
