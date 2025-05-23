package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.VideoView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FixedSizeVideoView extends VideoView implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private int f185930d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f185931e;

    /* renamed from: f, reason: collision with root package name */
    c f185932f;

    /* renamed from: h, reason: collision with root package name */
    private int f185933h;

    /* renamed from: i, reason: collision with root package name */
    private int f185934i;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements MediaPlayer.OnCompletionListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            FixedSizeVideoView fixedSizeVideoView = FixedSizeVideoView.this;
            if (fixedSizeVideoView.f185932f != null) {
                if (fixedSizeVideoView.f185931e != null) {
                    FixedSizeVideoView.this.f185931e.removeMessages(0);
                }
                FixedSizeVideoView.this.f185932f.b(mediaPlayer);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements MediaPlayer.OnCompletionListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            FixedSizeVideoView fixedSizeVideoView = FixedSizeVideoView.this;
            if (fixedSizeVideoView.f185932f != null) {
                if (fixedSizeVideoView.f185931e != null) {
                    FixedSizeVideoView.this.f185931e.removeMessages(0);
                }
                FixedSizeVideoView.this.f185932f.b(mediaPlayer);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface c {
        void a(FixedSizeVideoView fixedSizeVideoView, int i3, int i16);

        void b(MediaPlayer mediaPlayer);
    }

    public FixedSizeVideoView(Context context) {
        super(context);
        this.f185930d = -1;
        this.f185931e = new Handler(Looper.getMainLooper(), this);
        super.setOnCompletionListener(new a());
    }

    public int b() {
        return this.f185930d;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        c cVar;
        if (message.what == 0 && (cVar = this.f185932f) != null) {
            cVar.a(this, this.f185934i, this.f185930d);
            return true;
        }
        return true;
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public void pause() {
        super.pause();
        this.f185931e.removeMessages(0);
    }

    @Override // android.widget.VideoView
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        throw new RuntimeException("Stub!");
    }

    public void setOnFixVDPlayCompelteListener(c cVar) {
        if (cVar != null) {
            this.f185932f = cVar;
        }
    }

    public void setPlayDuration(int i3) {
        setPlayDuration(0, i3);
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public void start() {
        int currentPosition = this.f185933h - getCurrentPosition();
        if (currentPosition >= 0) {
            super.start();
            this.f185931e.removeMessages(0);
            this.f185931e.sendEmptyMessageDelayed(0, currentPosition);
        }
    }

    public void setPlayDuration(int i3, int i16) {
        try {
            int duration = getDuration();
            if (i3 >= duration) {
                return;
            }
            int i17 = i16 + i3;
            this.f185933h = i17;
            if (i17 > duration) {
                this.f185933h = duration;
            }
            this.f185934i = i3;
            this.f185930d = i16;
            seekTo(i3);
        } catch (Exception unused) {
        }
    }

    public FixedSizeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f185930d = -1;
        this.f185931e = new Handler(Looper.getMainLooper(), this);
        super.setOnCompletionListener(new b());
    }
}
