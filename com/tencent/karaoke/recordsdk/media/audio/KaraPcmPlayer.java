package com.tencent.karaoke.recordsdk.media.audio;

import android.media.AudioTrack;
import com.tencent.component.utils.LogUtil;
import java.io.IOException;

/* loaded from: classes7.dex */
public class KaraPcmPlayer extends l {

    /* loaded from: classes7.dex */
    private class PlaybackThread extends AudioThread {
        private boolean C;
        private boolean D;
        final /* synthetic */ KaraPcmPlayer this$0;

        private int v() throws IOException {
            if (this.C) {
                return -1;
            }
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
            try {
                int v3 = v();
                int w3 = w();
                if (v3 == -1) {
                    if (w3 == -1) {
                        LogUtil.i("KaraPcmPlayer", "getAudioData -> both PCM file eof");
                        throw null;
                    }
                    throw null;
                }
                throw null;
            } catch (IOException e16) {
                LogUtil.i("KaraPcmPlayer", "getAudioData -> file read error:" + e16.getMessage());
                throw null;
            }
        }

        @Override // com.tencent.karaoke.recordsdk.media.audio.AudioThread
        protected int r() {
            LogUtil.i("KaraPcmPlayer", "initResource begin.");
            try {
                throw null;
            } catch (IOException e16) {
                LogUtil.e("KaraPcmPlayer", "initResource -> " + e16.getMessage());
                throw null;
            }
        }

        @Override // com.tencent.karaoke.recordsdk.media.audio.AudioThread, com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            LogUtil.i("KaraPcmPlayer", "playback thread begin");
            if (r() < 0) {
                LogUtil.w("KaraPcmPlayer", "run -> initResource error");
            }
            throw null;
        }

        @Override // com.tencent.karaoke.recordsdk.media.audio.AudioThread
        protected int s() {
            if (KaraPcmPlayer.d(null).getPlayState() == 2) {
                KaraPcmPlayer.d(null).play();
                LogUtil.i("KaraPcmPlayer", "outputAudioData -> start AudioTrack Play");
            }
            KaraPcmPlayer.d(null);
            throw null;
        }

        @Override // com.tencent.karaoke.recordsdk.media.audio.AudioThread
        protected int t() {
            throw null;
        }

        @Override // com.tencent.karaoke.recordsdk.media.audio.AudioThread
        protected int u() {
            throw null;
        }
    }

    static /* synthetic */ AudioTrack d(KaraPcmPlayer karaPcmPlayer) {
        throw null;
    }
}
