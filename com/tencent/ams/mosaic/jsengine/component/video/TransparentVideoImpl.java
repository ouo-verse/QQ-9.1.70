package com.tencent.ams.mosaic.jsengine.component.video;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer;
import com.tencent.ams.fusion.widget.alphaplayer.AlphaVideoView;
import com.tencent.ams.fusion.widget.alphaplayer.PlayInfo;
import com.tencent.ams.fusion.widget.alphaplayer.gl.FormatType;
import com.tencent.ams.fusion.widget.alphaplayer.gl.ScaleType;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.jsengine.component.BasicComponent;
import com.tencent.ams.mosaic.jsengine.component.video.VideoComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TransparentVideoImpl extends BasicComponent implements ITransparentVideo, AlphaPlayer.AlphaPlayerListener {
    static IPatchRedirector $redirector_;
    private JSFunction C;

    /* renamed from: d, reason: collision with root package name */
    private final AlphaVideoView f71356d;

    /* renamed from: e, reason: collision with root package name */
    private final PlayInfo f71357e;

    /* renamed from: f, reason: collision with root package name */
    private String f71358f;

    /* renamed from: h, reason: collision with root package name */
    private int f71359h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f71360i;

    /* renamed from: m, reason: collision with root package name */
    private int f71361m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements View.OnLayoutChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TransparentVideoImpl.this);
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
                return;
            }
            com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "onLayoutChange, left: " + i3 + ", top: " + i16 + ", right: " + i17 + ", bottom: " + i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements f.InterfaceC0685f.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TransparentVideoImpl.this);
            }
        }

        @Override // com.tencent.ams.mosaic.f.InterfaceC0685f.a
        public void onLoadFinish(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("TransparentVideoImpl", "load video finish: " + str);
            if (TextUtils.isEmpty(str) || "null".equals(str)) {
                TransparentVideoImpl.this.t(3);
            } else {
                TransparentVideoImpl.this.s(str);
            }
        }

        @Override // com.tencent.ams.mosaic.f.InterfaceC0685f.a
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.ams.mosaic.utils.f.a("TransparentVideoImpl", "load video start");
            }
        }
    }

    public TransparentVideoImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.f71360i = false;
        AlphaVideoView alphaVideoView = new AlphaVideoView(context);
        this.f71356d = alphaVideoView;
        alphaVideoView.addOnLayoutChangeListener(new a());
        alphaVideoView.setPlayerListener(this);
        this.f71357e = new PlayInfo();
        u(0);
    }

    private void q(int i3, int i16) {
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "notifyPlayStatusChanged, status: " + i3 + ", failReason: " + i16);
        JSFunction jSFunction = this.C;
        if (jSFunction != null) {
            getJSEngine().u(jSFunction, new Object[]{Integer.valueOf(i3), Integer.valueOf(i16)}, null);
        }
    }

    private void r() {
        com.tencent.ams.mosaic.utils.f.a("TransparentVideoImpl", "openVideo");
        if (this.f71358f != null) {
            u(5);
            getVideoLoader().loadVideo(this.f71358f, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "openVideo: " + str);
        try {
            this.f71357e.setVideoPath(str);
            this.f71356d.setPlayInfo(this.f71357e);
            this.f71356d.start();
        } catch (Exception e16) {
            com.tencent.ams.mosaic.utils.f.c("TransparentVideoImpl", "play failed", e16);
            t(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3) {
        v(3, i3);
    }

    private void u(int i3) {
        v(i3, 0);
    }

    private void v(int i3, int i16) {
        if (this.f71359h != i3) {
            this.f71359h = i3;
            q(i3, i16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public boolean executeTask(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) runnable)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.ITransparentVideo
    public int getCurrentPosition() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        try {
            i3 = (int) this.f71356d.getPosition();
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.c("TransparentVideoImpl", "getCurrentPosition error.", th5);
            i3 = 0;
        }
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "getCurrentPosition, position: " + i3);
        return i3;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.ITransparentVideo
    public int getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        int i3 = this.f71361m;
        if (i3 > 0) {
            return i3;
        }
        try {
            i3 = (int) this.f71356d.getDuration();
            this.f71361m = i3;
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.c("TransparentVideoImpl", "getDuration error.", th5);
        }
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "getDuration, duration: " + i3);
        return i3;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (View) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f71356d;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.ITransparentVideo
    public boolean isPlaying() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        try {
            z16 = this.f71356d.isPlaying();
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.c("TransparentVideoImpl", "isPlaying error.", th5);
            z16 = false;
        }
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "isPlaying, isPlaying: " + z16);
        return z16;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "onComplete");
            u(2);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onError(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "onError, reason: " + i3);
        t(i3);
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public boolean onInfo(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "onInfo, what: " + i3 + ", extra: " + i16);
        if (i3 == 3) {
            u(8);
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            u(4);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onPrepared(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "onPrepared, width: " + i3 + ", height: " + i16);
        u(6);
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onSeekComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "onSeekComplete");
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "onStart");
            u(1);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", DKHippyEvent.EVENT_STOP);
            u(7);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.ITransparentVideo
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "pause");
        try {
            this.f71356d.pause();
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.c("TransparentVideoImpl", "pause error.", th5);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.ITransparentVideo
    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "seekTo, position: " + i3);
        try {
            this.f71356d.seekTo(i3);
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.c("TransparentVideoImpl", "seekTo error.", th5);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.ITransparentVideo
    public void setFormatType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "setFormat, formatType: " + i3);
        if (i3 == 0) {
            this.f71357e.setFormatType(FormatType.ALIGNED);
        } else {
            this.f71357e.setFormatType(FormatType.COMPRESS);
        }
        this.f71356d.setPlayInfo(this.f71357e);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.ITransparentVideo
    public void setLoop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "setLoop, isLoop: " + z16);
        this.f71357e.setLoopPlay(z16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.ITransparentVideo
    public void setPlayListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) jSFunction);
        } else {
            this.C = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.ITransparentVideo
    public void setScaleType(String str) {
        char c16;
        ScaleType scaleType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "setScaleType, scaleType: " + str);
        try {
            switch (str.hashCode()) {
                case -518810571:
                    if (str.equals(VideoComponent.ScaleType.FIT_WIDTH)) {
                        c16 = 4;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 97441490:
                    if (str.equals("fitXY")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 520762310:
                    if (str.equals("fitCenter")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 663746712:
                    if (str.equals(VideoComponent.ScaleType.FIT_HEIGHT)) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1161480325:
                    if (str.equals("centerCrop")) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            if (c16 != 0) {
                if (c16 != 1) {
                    if (c16 != 2) {
                        if (c16 != 3) {
                            if (c16 != 4) {
                                scaleType = null;
                            } else {
                                scaleType = ScaleType.FIT_WIDTH;
                            }
                        } else {
                            scaleType = ScaleType.FIT_HEIGHT;
                        }
                    } else {
                        scaleType = ScaleType.CENTER_CROP;
                    }
                } else {
                    scaleType = ScaleType.FIT_CENTER;
                }
            } else {
                scaleType = ScaleType.FIT_XY;
            }
            if (scaleType != null) {
                this.f71357e.setScaleType(scaleType);
            }
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.c("TransparentVideoImpl", "setScaleType error.", th5);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.ITransparentVideo
    public void setVideoParams(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "setVideoParams, params: " + str);
        this.f71358f = str;
        if (this.f71360i) {
            r();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.ITransparentVideo
    public void setVolume(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "setVolume: " + i3);
        try {
            this.f71356d.setVolume(i3);
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.c("TransparentVideoImpl", "setVolume error.", th5);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.ITransparentVideo
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "start");
        this.f71360i = true;
        try {
            r();
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.c("TransparentVideoImpl", "start error.", th5);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.ITransparentVideo
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TransparentVideoImpl", "stop");
        try {
            this.f71356d.stop();
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.c("TransparentVideoImpl", "stop error.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "TransparentVideoImpl";
    }
}
