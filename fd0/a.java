package fd0;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: fd0.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC10303a {
        void a(a aVar, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void b(a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        boolean d(a aVar, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
        boolean c(a aVar, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface e {
        void a(a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface f {
        void d(a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface g {
        void a(a aVar, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface h {
    }

    void a(e eVar);

    void b(c cVar);

    void c(g gVar);

    void d(InterfaceC10303a interfaceC10303a);

    void e(b bVar);

    void f(d dVar);

    void g(f fVar);

    int getAudioSessionId();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void pause() throws IllegalStateException;

    void prepareAsync() throws IllegalStateException;

    void release();

    void reset();

    void seekTo(int i3) throws IllegalStateException;

    void setAudioSessionId(int i3) throws IllegalArgumentException, IllegalStateException;

    void setAudioStreamType(int i3);

    void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setLooping(boolean z16);

    void setScreenOnWhilePlaying(boolean z16);

    void setSurface(Surface surface);

    void setVolume(float f16, float f17);

    void start() throws IllegalStateException;

    void stop() throws IllegalStateException;
}
