package com.tencent.karaoke.recordsdk.media.audio;

import android.media.AudioTrack;
import com.tencent.component.utils.LogUtil;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes7.dex */
public class KaraLocalM4aPlayer extends l {

    /* loaded from: classes7.dex */
    private class PlaybackThread extends BaseThread {
        final /* synthetic */ KaraLocalM4aPlayer this$0;

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            LogUtil.i("KaraLocalM4aPlayer", "playback(LocalM4a) thread begin");
            int minBufferSize = AudioTrack.getMinBufferSize(44100, 12, 2);
            if (minBufferSize != -2 && minBufferSize != -1) {
                if (minBufferSize < 8192) {
                    minBufferSize = 8192;
                }
                KaraLocalM4aPlayer.g(null, new ReportAudioTrack(3, 44100, 12, 2, minBufferSize * 2, 1));
                if (KaraLocalM4aPlayer.f(null).getState() == 1) {
                    KaraLocalM4aPlayer.e(null, true);
                    KaraLocalM4aPlayer.f(null).play();
                    try {
                        try {
                            try {
                                try {
                                    synchronized (KaraLocalM4aPlayer.h(null)) {
                                        new StringBuilder().append("current state: ");
                                        throw null;
                                    }
                                } catch (IOException e16) {
                                    LogUtil.w("KaraLocalM4aPlayer", e16);
                                    throw null;
                                }
                            } catch (FileNotFoundException e17) {
                                LogUtil.w("KaraLocalM4aPlayer", e17);
                                throw null;
                            }
                        } catch (IllegalStateException e18) {
                            LogUtil.w("KaraLocalM4aPlayer", e18);
                            throw null;
                        }
                    } catch (Throwable unused) {
                        KaraLocalM4aPlayer.k(null, -1);
                        if (KaraLocalM4aPlayer.f(null).getState() == 1) {
                            KaraLocalM4aPlayer.f(null).flush();
                            KaraLocalM4aPlayer.f(null).stop();
                            KaraLocalM4aPlayer.f(null).release();
                            KaraLocalM4aPlayer.g(null, null);
                        }
                        KaraLocalM4aPlayer.i(null).release();
                        KaraLocalM4aPlayer.j(null, null);
                        synchronized (KaraLocalM4aPlayer.h(null)) {
                            boolean d16 = KaraLocalM4aPlayer.d(null);
                            KaraLocalM4aPlayer.e(null, false);
                            if (d16) {
                                throw null;
                            }
                            throw null;
                        }
                    }
                }
                LogUtil.w("KaraLocalM4aPlayer", "AudioTrack isn't STATE_INITIALIZED");
                KaraLocalM4aPlayer.e(null, false);
                KaraLocalM4aPlayer.f(null).release();
                KaraLocalM4aPlayer.g(null, null);
                throw null;
            }
            LogUtil.w("KaraLocalM4aPlayer", "AudioTrack.getMinBufferSize failed: " + minBufferSize);
            KaraLocalM4aPlayer.e(null, false);
            throw null;
        }
    }

    static /* synthetic */ boolean d(KaraLocalM4aPlayer karaLocalM4aPlayer) {
        throw null;
    }

    static /* synthetic */ boolean e(KaraLocalM4aPlayer karaLocalM4aPlayer, boolean z16) {
        throw null;
    }

    static /* synthetic */ AudioTrack f(KaraLocalM4aPlayer karaLocalM4aPlayer) {
        throw null;
    }

    static /* synthetic */ AudioTrack g(KaraLocalM4aPlayer karaLocalM4aPlayer, AudioTrack audioTrack) {
        throw null;
    }

    static /* synthetic */ Object h(KaraLocalM4aPlayer karaLocalM4aPlayer) {
        throw null;
    }

    static /* synthetic */ sz0.a i(KaraLocalM4aPlayer karaLocalM4aPlayer) {
        throw null;
    }

    static /* synthetic */ sz0.a j(KaraLocalM4aPlayer karaLocalM4aPlayer, sz0.a aVar) {
        throw null;
    }

    static /* synthetic */ int k(KaraLocalM4aPlayer karaLocalM4aPlayer, int i3) {
        throw null;
    }
}
