package com.tencent.ttpic.baseutils.audio;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.ttpic.baseutils.io.FileUtils;
import java.io.IOException;

/* loaded from: classes27.dex */
public class PlayerUtil {
    private static AudioManager sManager;

    /* loaded from: classes27.dex */
    public static class Player extends ReportMediaPlayer {
        private boolean isPlaying;

        @Override // android.media.MediaPlayer
        public boolean isPlaying() {
            return this.isPlaying;
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer, android.media.MediaPlayer
        public void pause() {
            if (!this.isPlaying) {
                return;
            }
            try {
                super.pause();
                this.isPlaying = false;
            } catch (Exception unused) {
            }
        }

        @Override // android.media.MediaPlayer
        public void release() {
            try {
                super.release();
                this.isPlaying = false;
            } catch (Exception unused) {
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer, android.media.MediaPlayer
        public void reset() {
            try {
                super.reset();
                this.isPlaying = false;
            } catch (Exception unused) {
            }
        }

        @Override // android.media.MediaPlayer
        public void seekTo(int i3) {
            try {
                super.seekTo(i3);
            } catch (Exception unused) {
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer, android.media.MediaPlayer
        public void start() {
            if (this.isPlaying) {
                return;
            }
            try {
                super.start();
                this.isPlaying = true;
            } catch (Exception unused) {
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer, android.media.MediaPlayer
        public void stop() {
            try {
                super.stop();
                this.isPlaying = false;
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes27.dex */
    public static class Recorder extends MediaRecorder {
        private boolean isRecording;

        public boolean isRecording() {
            return this.isRecording;
        }

        @Override // android.media.MediaRecorder
        public void release() {
            try {
                super.release();
                this.isRecording = false;
            } catch (Exception unused) {
            }
        }

        @Override // android.media.MediaRecorder
        public void reset() {
            if (!this.isRecording) {
                return;
            }
            try {
                super.reset();
                this.isRecording = false;
            } catch (Exception unused) {
            }
        }

        @Override // android.media.MediaRecorder
        public void start() {
            if (this.isRecording) {
                return;
            }
            try {
                AudioMonitor.start(this);
                this.isRecording = true;
            } catch (Exception unused) {
            }
        }

        @Override // android.media.MediaRecorder
        public void stop() {
            if (!this.isRecording) {
                return;
            }
            try {
                super.stop();
                this.isRecording = false;
            } catch (Exception unused) {
            }
        }
    }

    public static Player createPlayer(Context context, String str, boolean z16) {
        if (str.startsWith("assets://")) {
            return createPlayerFromAssets(context, FileUtils.getRealPath(str), z16);
        }
        return createPlayerFromUri(context, str, z16);
    }

    public static Player createPlayerFromAssets(Context context, String str, boolean z16) {
        Player player;
        try {
            player = new Player();
            try {
                AssetFileDescriptor openFd = context.getAssets().openFd(str);
                player.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                openFd.close();
                preparePlayer(player, z16);
                return player;
            } catch (IOException unused) {
                destroyPlayer(player);
                return null;
            }
        } catch (IOException unused2) {
            player = null;
        }
    }

    public static Player createPlayerFromUri(Context context, String str, boolean z16) {
        Player player;
        try {
            player = new Player();
        } catch (Exception unused) {
            player = null;
        }
        try {
            player.setDataSource(context, Uri.parse(str));
            preparePlayer(player, z16);
            return player;
        } catch (Exception unused2) {
            destroyPlayer(player);
            return null;
        }
    }

    public static Recorder createRecorder(String str) {
        Recorder recorder;
        try {
            recorder = new Recorder();
        } catch (Exception unused) {
            recorder = null;
        }
        try {
            recorder.setOutputFile(str);
            recorder.setAudioSource(1);
            recorder.setAudioChannels(1);
            recorder.setAudioSamplingRate(44100);
            recorder.setAudioEncodingBitRate(96000);
            recorder.setOutputFormat(2);
            recorder.setAudioEncoder(3);
            recorder.setOnErrorListener(new MediaRecorder.OnErrorListener() { // from class: com.tencent.ttpic.baseutils.audio.PlayerUtil.5
                @Override // android.media.MediaRecorder.OnErrorListener
                public void onError(MediaRecorder mediaRecorder, int i3, int i16) {
                    PlayerUtil.destroyRecorder((Recorder) mediaRecorder);
                }
            });
            recorder.prepare();
            return recorder;
        } catch (Exception unused2) {
            destroyRecorder(recorder);
            return null;
        }
    }

    public static void destroyPlayer(Player player) {
        if (player != null) {
            player.stop();
            player.reset();
            player.release();
        }
    }

    public static void destroyRecorder(Recorder recorder) {
        if (recorder != null) {
            recorder.stop();
            recorder.reset();
            recorder.release();
        }
    }

    private static AudioManager getAudioManager(Context context) {
        if (sManager == null) {
            sManager = (AudioManager) context.getSystemService("audio");
        }
        return sManager;
    }

    public static int getMaxVolume(Context context) {
        return getAudioManager(context).getStreamMaxVolume(3);
    }

    public static int getVolume(Context context) {
        return SystemMethodProxy.getStreamVolume(getAudioManager(context), 3);
    }

    public static boolean isSilentMode(Context context) {
        int ringerMode = getAudioManager(context).getRingerMode();
        if (ringerMode == 0 || ringerMode == 1) {
            return true;
        }
        return false;
    }

    private boolean isSupportedAudioSamplingRate(int i3) {
        if (AudioRecord.getMinBufferSize(i3, 16, 2) > 0) {
            return true;
        }
        return false;
    }

    public static void pauseAndSeekToOrigin(Player player) {
        if (player != null) {
            player.pause();
            player.seekTo(0);
        }
    }

    private static void preparePlayer(Player player, boolean z16) throws IOException {
        player.setAudioStreamType(3);
        player.setLooping(z16);
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tencent.ttpic.baseutils.audio.PlayerUtil.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                ((Player) mediaPlayer).isPlaying = false;
            }
        });
        player.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.tencent.ttpic.baseutils.audio.PlayerUtil.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
                PlayerUtil.destroyPlayer((Player) mediaPlayer);
                return true;
            }
        });
        player.prepare();
    }

    public static void seekPlayer(Player player, int i3) {
        if (player != null) {
            player.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.tencent.ttpic.baseutils.audio.PlayerUtil.4
                @Override // android.media.MediaPlayer.OnSeekCompleteListener
                public void onSeekComplete(MediaPlayer mediaPlayer) {
                    ((Player) mediaPlayer).start();
                }
            });
            player.seekTo(i3);
        }
    }

    public static void setMute(Context context, boolean z16) {
        getAudioManager(context).setStreamMute(3, z16);
    }

    public static void setVolume(Context context, int i3) {
        getAudioManager(context).setStreamVolume(3, Math.min(Math.max(i3, 0), getMaxVolume(context)), 8);
    }

    public static void startPlayer(Player player, boolean z16) {
        if (player != null) {
            if (z16) {
                player.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.tencent.ttpic.baseutils.audio.PlayerUtil.3
                    @Override // android.media.MediaPlayer.OnSeekCompleteListener
                    public void onSeekComplete(MediaPlayer mediaPlayer) {
                        ((Player) mediaPlayer).start();
                    }
                });
                player.seekTo(0);
            } else {
                player.start();
            }
        }
    }

    public static void startRecorder(Recorder recorder) {
        if (recorder != null) {
            recorder.start();
        }
    }

    public static void stopPlayer(Player player) {
        if (player != null) {
            player.pause();
        }
    }
}
