package com.tencent.karaoke.recordsdk.media.audio;

import android.media.AudioTrack;
import android.os.Process;
import com.tencent.component.utils.LogUtil;
import java.io.IOException;

/* loaded from: classes7.dex */
public class KaraPcmM4aPlayer extends l {

    /* loaded from: classes7.dex */
    private class PlaybackThread extends AudioThread {
        private boolean C;
        private boolean D;
        final /* synthetic */ KaraPcmM4aPlayer this$0;

        private int v() {
            if (this.C) {
                return -1;
            }
            KaraPcmM4aPlayer.d(null);
            throw null;
        }

        private int w() throws IOException {
            if (this.D) {
                return -1;
            }
            throw null;
        }

        @Override // com.tencent.karaoke.recordsdk.media.audio.AudioThread
        protected boolean o() {
            return false;
        }

        @Override // com.tencent.karaoke.recordsdk.media.audio.AudioThread
        protected int q() {
            if (v() < 0) {
                throw null;
            }
            try {
                w();
                throw null;
            } catch (IOException e16) {
                LogUtil.w("KaraPcmM4aPlayer", "getAudioData io error-> " + e16.getMessage());
                throw null;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:?, code lost:
        
            throw null;
         */
        @Override // com.tencent.karaoke.recordsdk.media.audio.AudioThread
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected int r() {
            LogUtil.i("KaraPcmM4aPlayer", "initResource begin.");
            try {
                throw null;
            } catch (IOException unused) {
                throw null;
            }
        }

        @Override // com.tencent.karaoke.recordsdk.media.audio.AudioThread, com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            LogUtil.i("KaraPcmM4aPlayer", getName() + " begin");
            Process.setThreadPriority(-19);
            if (r() < 0) {
                LogUtil.w("KaraPcmM4aPlayer", "run -> initResource error");
            }
            throw null;
        }

        @Override // com.tencent.karaoke.recordsdk.media.audio.AudioThread
        protected int s() {
            if (KaraPcmM4aPlayer.e(null).getPlayState() == 2) {
                KaraPcmM4aPlayer.e(null).play();
            }
            KaraPcmM4aPlayer.e(null);
            throw null;
        }

        @Override // com.tencent.karaoke.recordsdk.media.audio.AudioThread
        protected int t() {
            throw null;
        }

        @Override // com.tencent.karaoke.recordsdk.media.audio.AudioThread
        protected int u() {
            LogUtil.i("KaraPcmM4aPlayer", "releaseResource begin.");
            throw null;
        }
    }

    static /* synthetic */ sz0.a d(KaraPcmM4aPlayer karaPcmM4aPlayer) {
        throw null;
    }

    static /* synthetic */ AudioTrack e(KaraPcmM4aPlayer karaPcmM4aPlayer) {
        throw null;
    }
}
