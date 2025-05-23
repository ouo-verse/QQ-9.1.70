package com.qq.e.tg;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.TangramAlphaVideoPlayListener;
import com.qq.e.comm.pi.TangramAlphaVideoPlayer;
import com.qq.e.comm.pi.TangramWidget;
import com.qq.e.comm.pi.TangramWidgetInitListener;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TangramAlphaVideoView {

    /* renamed from: a, reason: collision with root package name */
    private TangramAlphaVideoPlayer f40438a;

    /* renamed from: b, reason: collision with root package name */
    private volatile TangramWidgetInitListener f40439b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f40440c;

    /* renamed from: d, reason: collision with root package name */
    private final TangramAlphaVideoPlayInfo f40441d;

    public TangramAlphaVideoView(Context context, TangramAlphaVideoPlayInfo tangramAlphaVideoPlayInfo) {
        this.f40440c = context;
        this.f40441d = tangramAlphaVideoPlayInfo;
    }

    public View getVideoView() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("TangramAlphaVideoView getVideoView ");
        if (this.f40438a != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        GDTLogger.d(sb5.toString());
        TangramAlphaVideoPlayer tangramAlphaVideoPlayer = this.f40438a;
        if (tangramAlphaVideoPlayer != null) {
            return tangramAlphaVideoPlayer.getVideoView();
        }
        return null;
    }

    public void setInitListener(TangramWidgetInitListener tangramWidgetInitListener) {
        if (tangramWidgetInitListener != null) {
            this.f40439b = tangramWidgetInitListener;
            if (this.f40440c == null || this.f40441d == null) {
                GDTLogger.e("build TangramAlphaVideoView error");
                a();
            }
            GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.TangramAlphaVideoView.1
                @Override // java.lang.Runnable
                public void run() {
                    String appId = TangramAlphaVideoView.this.f40441d.getAppId();
                    if (TextUtils.isEmpty(appId) && GDTADManager.getInstance().getAppStatus() != null) {
                        appId = GDTADManager.getInstance().getAppStatus().getAPPID();
                    }
                    if (GDTADManager.getInstance().initWith(TangramAlphaVideoView.this.f40440c, appId)) {
                        try {
                            POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory(PM.BASE);
                            if (pOFactory == null) {
                                TangramAlphaVideoView.this.a();
                                return;
                            }
                            TangramWidget tangramWidget = pOFactory.getTangramWidget(TangramAlphaVideoView.this.f40440c, TangramWidget.TANGRAM_ALPHA_VIDEO);
                            if (tangramWidget instanceof TangramAlphaVideoPlayer) {
                                TangramAlphaVideoView.this.f40438a = (TangramAlphaVideoPlayer) tangramWidget;
                            }
                            if (TangramAlphaVideoView.this.f40438a == null) {
                                TangramAlphaVideoView.this.a();
                                return;
                            }
                            TangramAlphaVideoView.this.f40438a.setPlayInfo(TangramAlphaVideoView.this.f40441d);
                            if (TangramAlphaVideoView.this.f40439b != null) {
                                TangramAlphaVideoView.this.f40439b.onInitialed(TangramAlphaVideoView.this.getVideoView());
                            }
                        } catch (com.qq.e.comm.managers.plugin.a e16) {
                            GDTLogger.e("getAlphaVideoPlayer error ", e16);
                            TangramAlphaVideoView.this.a();
                        }
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException("prepareListener can not be null!");
    }

    public void setPlayListener(TangramAlphaVideoPlayListener tangramAlphaVideoPlayListener) {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("TangramAlphaVideoView setPlayListener ");
        if (this.f40438a != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        GDTLogger.d(sb5.toString());
        TangramAlphaVideoPlayer tangramAlphaVideoPlayer = this.f40438a;
        if (tangramAlphaVideoPlayer != null) {
            tangramAlphaVideoPlayer.setPlayListener(tangramAlphaVideoPlayListener);
        }
    }

    public void start() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("TangramAlphaVideoView start ");
        if (this.f40438a != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        GDTLogger.d(sb5.toString());
        TangramAlphaVideoPlayer tangramAlphaVideoPlayer = this.f40438a;
        if (tangramAlphaVideoPlayer != null) {
            tangramAlphaVideoPlayer.start();
        }
    }

    public void stop() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder("TangramAlphaVideoView stop ");
        if (this.f40438a != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        GDTLogger.d(sb5.toString());
        TangramAlphaVideoPlayer tangramAlphaVideoPlayer = this.f40438a;
        if (tangramAlphaVideoPlayer != null) {
            tangramAlphaVideoPlayer.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f40439b != null) {
            this.f40439b.onError();
        }
    }
}
