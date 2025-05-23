package fd0;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import fd0.a;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes5.dex */
public class b implements fd0.a {

    /* renamed from: a, reason: collision with root package name */
    MediaPlayer f398308a = new ReportMediaPlayer();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements MediaPlayer.OnPreparedListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.e f398309d;

        a(a.e eVar) {
            this.f398309d = eVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            this.f398309d.a(b.this);
        }
    }

    /* compiled from: P */
    /* renamed from: fd0.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C10304b implements MediaPlayer.OnCompletionListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.b f398311d;

        C10304b(a.b bVar) {
            this.f398311d = bVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            this.f398311d.b(b.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements MediaPlayer.OnBufferingUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC10303a f398313d;

        c(a.InterfaceC10303a interfaceC10303a) {
            this.f398313d = interfaceC10303a;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i3) {
            this.f398313d.a(b.this, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class d implements MediaPlayer.OnSeekCompleteListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.f f398315d;

        d(a.f fVar) {
            this.f398315d = fVar;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            this.f398315d.d(b.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class e implements MediaPlayer.OnVideoSizeChangedListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.g f398317d;

        e(a.g gVar) {
            this.f398317d = gVar;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i3, int i16) {
            this.f398317d.a(b.this, i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class f implements MediaPlayer.OnErrorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.c f398319d;

        f(a.c cVar) {
            this.f398319d = cVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            return this.f398319d.d(b.this, i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class g implements MediaPlayer.OnInfoListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.d f398321d;

        g(a.d dVar) {
            this.f398321d = dVar;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i3, int i16) {
            return this.f398321d.c(b.this, i3, i16);
        }
    }

    @Override // fd0.a
    public void a(a.e eVar) {
        a aVar;
        MediaPlayer mediaPlayer = this.f398308a;
        if (eVar == null) {
            aVar = null;
        } else {
            aVar = new a(eVar);
        }
        mediaPlayer.setOnPreparedListener(aVar);
    }

    @Override // fd0.a
    public void b(a.c cVar) {
        f fVar;
        MediaPlayer mediaPlayer = this.f398308a;
        if (cVar == null) {
            fVar = null;
        } else {
            fVar = new f(cVar);
        }
        mediaPlayer.setOnErrorListener(fVar);
    }

    @Override // fd0.a
    public void c(a.g gVar) {
        e eVar;
        MediaPlayer mediaPlayer = this.f398308a;
        if (gVar == null) {
            eVar = null;
        } else {
            eVar = new e(gVar);
        }
        mediaPlayer.setOnVideoSizeChangedListener(eVar);
    }

    @Override // fd0.a
    public void d(a.InterfaceC10303a interfaceC10303a) {
        c cVar;
        MediaPlayer mediaPlayer = this.f398308a;
        if (interfaceC10303a == null) {
            cVar = null;
        } else {
            cVar = new c(interfaceC10303a);
        }
        mediaPlayer.setOnBufferingUpdateListener(cVar);
    }

    @Override // fd0.a
    public void e(a.b bVar) {
        C10304b c10304b;
        MediaPlayer mediaPlayer = this.f398308a;
        if (bVar == null) {
            c10304b = null;
        } else {
            c10304b = new C10304b(bVar);
        }
        mediaPlayer.setOnCompletionListener(c10304b);
    }

    @Override // fd0.a
    public void f(a.d dVar) {
        g gVar;
        MediaPlayer mediaPlayer = this.f398308a;
        if (dVar == null) {
            gVar = null;
        } else {
            gVar = new g(dVar);
        }
        mediaPlayer.setOnInfoListener(gVar);
    }

    @Override // fd0.a
    public void g(a.f fVar) {
        d dVar;
        MediaPlayer mediaPlayer = this.f398308a;
        if (fVar == null) {
            dVar = null;
        } else {
            dVar = new d(fVar);
        }
        mediaPlayer.setOnSeekCompleteListener(dVar);
    }

    @Override // fd0.a
    public int getAudioSessionId() {
        return this.f398308a.getAudioSessionId();
    }

    @Override // fd0.a
    public int getCurrentPosition() {
        return this.f398308a.getCurrentPosition();
    }

    @Override // fd0.a
    public int getDuration() {
        return this.f398308a.getDuration();
    }

    @Override // fd0.a
    public int getVideoHeight() {
        return this.f398308a.getVideoHeight();
    }

    @Override // fd0.a
    public int getVideoWidth() {
        return this.f398308a.getVideoWidth();
    }

    @Override // fd0.a
    public boolean isPlaying() {
        return this.f398308a.isPlaying();
    }

    @Override // fd0.a
    public void pause() throws IllegalStateException {
        this.f398308a.pause();
    }

    @Override // fd0.a
    public void prepareAsync() throws IllegalStateException {
        this.f398308a.prepareAsync();
    }

    @Override // fd0.a
    public void release() {
        this.f398308a.release();
    }

    @Override // fd0.a
    public void reset() {
        try {
            this.f398308a.reset();
        } catch (IllegalStateException e16) {
            com.tencent.qqperf.monitor.crash.catchedexception.a.b(e16);
        }
    }

    @Override // fd0.a
    public void seekTo(int i3) throws IllegalStateException {
        this.f398308a.seekTo(i3);
    }

    @Override // fd0.a
    public void setAudioSessionId(int i3) throws IllegalArgumentException, IllegalStateException {
        this.f398308a.setAudioSessionId(i3);
    }

    @Override // fd0.a
    public void setAudioStreamType(int i3) {
        this.f398308a.setAudioStreamType(i3);
    }

    @Override // fd0.a
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.f398308a.setDataSource(context, uri, map);
    }

    @Override // fd0.a
    public void setLooping(boolean z16) {
        this.f398308a.setLooping(z16);
    }

    @Override // fd0.a
    public void setScreenOnWhilePlaying(boolean z16) {
        this.f398308a.setScreenOnWhilePlaying(z16);
    }

    @Override // fd0.a
    public void setSurface(Surface surface) {
        this.f398308a.setSurface(surface);
    }

    @Override // fd0.a
    public void setVolume(float f16, float f17) {
        this.f398308a.setVolume(f16, f17);
    }

    @Override // fd0.a
    public void start() throws IllegalStateException {
        this.f398308a.start();
    }

    @Override // fd0.a
    public void stop() throws IllegalStateException {
        this.f398308a.stop();
    }
}
