package com.tencent.mobileqq.wink.picker.core.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.wink.view.ag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes21.dex */
public class WinkQZoneVideoPreviewView extends WinkBasePreviewVideoView implements g93.a {
    private View C;
    private View.OnClickListener D;
    private ISuperPlayer E;
    private b F;
    private QCircleCommonLoadingDialog G;
    private final ag H;
    String I;

    /* renamed from: f, reason: collision with root package name */
    private final FrameLayout f324739f;

    /* renamed from: h, reason: collision with root package name */
    private final ImageView f324740h;

    /* renamed from: i, reason: collision with root package name */
    private final ImageView f324741i;

    /* renamed from: m, reason: collision with root package name */
    private final SeekBar f324742m;

    /* loaded from: classes21.dex */
    class a implements ag.a {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.view.ag.a
        public void onRetryClick() {
            WinkQZoneVideoPreviewView.this.c();
            WinkQZoneVideoPreviewView winkQZoneVideoPreviewView = WinkQZoneVideoPreviewView.this;
            winkQZoneVideoPreviewView.v(winkQZoneVideoPreviewView.getContext());
            WinkQZoneVideoPreviewView.this.F.onVideoLoadStart();
            WinkQZoneVideoPreviewView.this.H.dismiss();
        }
    }

    /* loaded from: classes21.dex */
    public interface b {
        void onVideoLoadStart();

        void onVideoPlayStart();
    }

    public WinkQZoneVideoPreviewView(Context context, com.tencent.mobileqq.wink.picker.core.view.c cVar) {
        super(context, cVar);
        View.inflate(context, R.layout.i8d, this);
        this.f324739f = (FrameLayout) findViewById(R.id.kt9);
        this.f324740h = (ImageView) findViewById(R.id.f1178972o);
        this.f324741i = (ImageView) findViewById(R.id.f1178772m);
        SeekBar seekBar = (SeekBar) findViewById(R.id.f1179172q);
        this.f324742m = seekBar;
        seekBar.setPadding(0, 0, 0, 0);
        s(1);
        this.H = new ag(context, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.G;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
            this.H.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        ImageView imageView = this.f324741i;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        this.G = new QCircleCommonLoadingDialog.c(getContext()).n(false).p(getContext().getString(R.string.f216335y1)).a();
        ag agVar = this.H;
        if (agVar != null) {
            agVar.dismiss();
        }
        this.G.show();
    }

    private void D() {
        g93.b.d().j(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        b bVar;
        if (this.f324741i != null && this.E != null && this.f324740h != null && (bVar = this.F) != null) {
            bVar.onVideoPlayStart();
            this.E.start();
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.view.WinkQZoneVideoPreviewView.2
                @Override // java.lang.Runnable
                public void run() {
                    WinkQZoneVideoPreviewView.this.f324740h.setVisibility(8);
                    WinkQZoneVideoPreviewView.this.f324741i.setVisibility(8);
                }
            });
        }
    }

    private void s(int i3) {
        if (this.f324742m == null) {
            return;
        }
        int dpToPx = ImmersiveUtils.dpToPx(20.0f) * 2;
        this.f324742m.setPadding(0, dpToPx, 0, 0);
        this.f324742m.getLayoutParams().height = dpToPx + ImmersiveUtils.dpToPx(i3);
        this.f324742m.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.view.j
            @Override // java.lang.Runnable
            public final void run() {
                WinkQZoneVideoPreviewView.this.w();
            }
        });
    }

    private View.OnClickListener u() {
        if (this.D == null) {
            this.D = new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.view.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkQZoneVideoPreviewView.this.x(view);
                }
            };
        }
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void v(Context context) {
        if (context != null && this.C == null) {
            c cVar = new c();
            ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(context);
            createPlayerVideoView.addViewCallBack(cVar);
            View view = (View) createPlayerVideoView;
            this.C = view;
            view.setBackgroundColor(-16777216);
            this.f324739f.addView(this.C, 0);
            SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(this.I, 1, (String) null);
            ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(context, 160, (ISPlayerVideoView) this.C);
            this.E = createMediaPlayer;
            createMediaPlayer.setOnVideoPreparedListener(cVar);
            this.E.setOnErrorListener(cVar);
            this.E.setOnInfoListener(cVar);
            this.E.setOnCompletionListener(cVar);
            this.E.setLoopback(false);
            this.E.openMediaPlayer(context, createVideoInfoForUrl, 0L);
            this.E.setOutputMute(false);
            if (QLog.isColorLevel()) {
                w53.b.f("WinkQZoneVideoPreviewView", "openMediaPlayerByUrl: time=" + System.currentTimeMillis());
            }
            this.C.setOnClickListener(u());
            b bVar = this.F;
            if (bVar != null) {
                bVar.onVideoLoadStart();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        ag agVar = this.H;
        if (agVar != null) {
            agVar.dismiss();
        }
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.G;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ISuperPlayer iSuperPlayer = this.E;
        if (iSuperPlayer != null && this.f324740h != null) {
            if (iSuperPlayer.isPlaying()) {
                this.E.pause();
                this.f324740h.setVisibility(0);
            } else {
                G();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y() {
        v(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(boolean z16) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.view.g
            @Override // java.lang.Runnable
            public final void run() {
                WinkQZoneVideoPreviewView.this.y();
            }
        });
    }

    public void C() {
        D();
        g93.b.d().i(this);
    }

    public void E() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.view.h
            @Override // java.lang.Runnable
            public final void run() {
                WinkQZoneVideoPreviewView.this.A();
            }
        });
    }

    public void F() {
        w53.b.f("WinkQZoneVideoPreviewView", "show timeout loading");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.view.f
            @Override // java.lang.Runnable
            public final void run() {
                WinkQZoneVideoPreviewView.this.B();
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.picker.core.view.WinkBasePreviewVideoView
    public void b(boolean z16) {
        if (z16) {
            ISuperPlayer iSuperPlayer = this.E;
            if (iSuperPlayer != null && iSuperPlayer.isPlaying()) {
                this.E.pause();
                this.f324740h.setVisibility(0);
                return;
            }
            return;
        }
        v(getContext());
    }

    @Override // com.tencent.mobileqq.wink.picker.core.view.WinkBasePreviewVideoView
    public boolean c() {
        if (this.E != null && this.f324739f != null) {
            D();
            this.E.stop();
            this.E.release();
            this.f324739f.removeView(this.C);
            this.C = null;
            this.E = null;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!QQVideoPlaySDKManager.isSoLoadSucess()) {
            QQVideoPlaySDKManager.initSDKAsync(getContext(), new SDKInitListener() { // from class: com.tencent.mobileqq.wink.picker.core.view.e
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public final void onSDKInited(boolean z16) {
                    WinkQZoneVideoPreviewView.this.z(z16);
                }
            });
        } else {
            v(getContext());
        }
        b bVar = this.F;
        if (bVar != null) {
            bVar.onVideoLoadStart();
            C();
        }
        com.tencent.mobileqq.wink.picker.core.view.c cVar = a().get();
        if (cVar != null) {
            cVar.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.E != null) {
            c();
        }
    }

    @Override // g93.a
    public void onTimerCallback() {
        ISuperPlayer iSuperPlayer;
        if (this.f324742m != null && (iSuperPlayer = this.E) != null) {
            double currentPositionMs = iSuperPlayer.getCurrentPositionMs();
            float durationMs = (float) this.E.getDurationMs();
            if (durationMs == 0.0f) {
                this.f324742m.setProgress(0);
            } else {
                this.f324742m.setProgress((int) (this.f324742m.getMax() * (currentPositionMs / durationMs)));
            }
        }
    }

    public void r(LocalMediaInfo localMediaInfo) {
        if (this.f324741i != null) {
            String w3 = e93.i.w(localMediaInfo);
            w53.b.f("WinkQZoneVideoPreviewView", "[bindVideoInfo] url=" + w3);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mUseSharpPImage = true;
            this.f324741i.setImageDrawable(URLDrawable.getDrawable(w3, obtain));
            this.f324741i.setVisibility(8);
        }
        this.I = e93.i.j(localMediaInfo);
    }

    public void setCallback(b bVar) {
        this.F = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class c implements ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISPlayerVideoView.IVideoViewCallBack, ISuperPlayer.OnInfoListener {
        c() {
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            if (WinkQZoneVideoPreviewView.this.E != null) {
                WinkQZoneVideoPreviewView.this.E.seekTo(0);
                WinkQZoneVideoPreviewView.this.G();
            }
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
        public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
            w53.b.f("WinkQZoneVideoPreviewView", "super player play error=" + i17);
            WinkQZoneVideoPreviewView.this.E();
            return false;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
        public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
            if (WinkQZoneVideoPreviewView.this.F == null) {
                return false;
            }
            if (i3 == 112) {
                WinkQZoneVideoPreviewView.this.F.onVideoLoadStart();
            } else if (i3 == 113 || i3 == 105) {
                WinkQZoneVideoPreviewView.this.t();
                WinkQZoneVideoPreviewView.this.F.onVideoPlayStart();
            }
            return false;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
            WinkQZoneVideoPreviewView.this.G();
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceChanged(Object obj) {
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceCreated(Object obj) {
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceDestroy(Object obj) {
        }
    }
}
