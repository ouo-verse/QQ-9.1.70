package kt3;

import com.tencent.qqlive.playerinterface.IQAdPlayerView;
import com.tencent.qqlive.playerinterface.QAdUserInfo;
import com.tencent.qqlive.playerinterface.QAdVideoItem;
import java.io.IOException;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface b {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void f(int i3, int i16);

        void m();

        void n(int i3);
    }

    /* compiled from: P */
    /* renamed from: kt3.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC10678b {
        void onEvent(int i3, int i16, int i17, Object obj);
    }

    void a(IQAdPlayerView iQAdPlayerView);

    void b() throws IllegalStateException;

    void c(long j3) throws IllegalStateException;

    void d(List<QAdVideoItem> list, long j3) throws IllegalArgumentException, IllegalStateException, IOException;

    @Deprecated
    void e(QAdUserInfo qAdUserInfo);

    long f();

    void g(InterfaceC10678b interfaceC10678b);

    long getCurrentPositionMs();

    @Deprecated
    boolean isPlaying();

    void pause() throws IllegalStateException;

    void release();

    void setAudioGainRatio(float f16);

    boolean setLoopPlay(boolean z16);

    boolean setOutputMute(boolean z16);

    void start() throws IllegalStateException;

    void stop() throws IllegalStateException;
}
