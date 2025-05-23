package com.tencent.aelight.camera.ae.gif.preview;

import android.content.Context;
import android.media.MediaPlayer;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.tencent.aelight.camera.ae.gif.preview.a;

/* loaded from: classes32.dex */
public class VideoPlayView extends GLSurfaceView {

    /* renamed from: d, reason: collision with root package name */
    private final b f65439d;

    /* renamed from: e, reason: collision with root package name */
    private MediaPlayer f65440e;

    public VideoPlayView(Context context) {
        this(context, null);
    }

    public void b() {
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.preview.VideoPlayView.1
            @Override // java.lang.Runnable
            public void run() {
                VideoPlayView.this.f65439d.a();
            }
        });
    }

    public void setFrameRenderCallback(a.InterfaceC0565a interfaceC0565a) {
        b bVar = this.f65439d;
        if (bVar != null) {
            bVar.f(interfaceC0565a);
        }
    }

    public void setNeedComposeAlpha(boolean z16) {
        b bVar = this.f65439d;
        if (bVar != null) {
            bVar.g(z16);
        }
    }

    public VideoPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 0, 0);
        b bVar = new b(this);
        this.f65439d = bVar;
        setRenderer(bVar);
        setRenderMode(0);
    }

    public VideoPlayView c(MediaPlayer mediaPlayer) {
        if (mediaPlayer == null) {
            return this;
        }
        MediaPlayer mediaPlayer2 = this.f65440e;
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
            this.f65440e = null;
        }
        this.f65440e = mediaPlayer;
        this.f65439d.h(mediaPlayer);
        return this;
    }
}
