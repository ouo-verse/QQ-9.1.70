package com.google.android.exoplayer2.ext.mediaplayer;

import android.util.Log;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DefaultAllocator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class QLoadControl extends DefaultLoadControl {
    public static final String LOG_TAG = "QLoadControl";
    private static int sBufferForPlaybackMs = 2500;
    private static int sBufferForPlaybackRebufferMs = 5000;
    private static int sBufferSegmentSize = 65536;
    private static int sMaxBufferMs = 30000;
    private static int sMinBufferMs = 15000;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Config {
        private int bufferSegmentSize = 65536;
        private int minBufferMs = 15000;
        private int maxBufferMs = 30000;
        private int bufferForPlaybackMs = 2500;
        private int bufferForPlaybackRebufferMs = 5000;

        public String toString() {
            return "QLoadControl.Config[bufferSegmentSize=" + this.bufferSegmentSize + ",minBufferMs=" + this.minBufferMs + ",maxBufferMs=" + this.maxBufferMs + ",bufferForPlaybackMs=" + this.bufferForPlaybackMs + ",bufferForPlaybackRebufferMs=" + this.bufferForPlaybackRebufferMs + "]";
        }
    }

    public QLoadControl() {
        super(new DefaultAllocator(true, sBufferSegmentSize), sMinBufferMs, sMaxBufferMs, sBufferForPlaybackMs, sBufferForPlaybackRebufferMs, -1, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void updateConfig(Config config) {
        if (config == null) {
            Log.v(LOG_TAG, "updateConfig config null");
            return;
        }
        sBufferSegmentSize = config.bufferSegmentSize;
        sMinBufferMs = config.minBufferMs;
        sMaxBufferMs = config.maxBufferMs;
        sBufferForPlaybackMs = config.bufferForPlaybackMs;
        sBufferForPlaybackRebufferMs = config.bufferForPlaybackRebufferMs;
        Log.v(LOG_TAG, "updateConfig with config " + config);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.DefaultLoadControl
    public int calculateTargetBufferSize(Renderer[] rendererArr, TrackSelectionArray trackSelectionArray) {
        return super.calculateTargetBufferSize(rendererArr, trackSelectionArray);
    }

    @Override // com.google.android.exoplayer2.DefaultLoadControl, com.google.android.exoplayer2.LoadControl
    public boolean shouldContinueLoading(long j3, float f16) {
        return super.shouldContinueLoading(j3, f16);
    }

    @Override // com.google.android.exoplayer2.DefaultLoadControl, com.google.android.exoplayer2.LoadControl
    public boolean shouldStartPlayback(long j3, float f16, boolean z16) {
        return super.shouldStartPlayback(j3, f16, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void updateConfig(String str) {
        Log.v(LOG_TAG, "updateConfig configStr=" + str);
        String[] split = str.split(",");
        Config config = new Config();
        try {
            if (split.length > 0) {
                config.bufferSegmentSize = Integer.parseInt(split[0]);
            }
            if (split.length > 1) {
                config.minBufferMs = Integer.parseInt(split[1]);
            }
            if (split.length > 2) {
                config.maxBufferMs = Integer.parseInt(split[2]);
            }
            if (split.length > 3) {
                config.bufferForPlaybackMs = Integer.parseInt(split[3]);
            }
            if (split.length > 4) {
                config.bufferForPlaybackRebufferMs = Integer.parseInt(split[4]);
            }
            updateConfig(config);
        } catch (Exception unused) {
            Log.v(LOG_TAG, "invalid qloadcontrol configStr=" + str);
        }
    }
}
