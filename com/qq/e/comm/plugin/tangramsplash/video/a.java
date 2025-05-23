package com.qq.e.comm.plugin.tangramsplash.video;

import android.view.Surface;
import com.qq.e.comm.pi.ITangramDecoderPlayer;
import com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements IPlayer {

    /* renamed from: a, reason: collision with root package name */
    public static Class<? extends ITangramDecoderPlayer> f40372a;

    /* renamed from: b, reason: collision with root package name */
    private ITangramDecoderPlayer f40373b;

    public a(ITangramDecoderPlayer iTangramDecoderPlayer) {
        this.f40373b = iTangramDecoderPlayer;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public int getCurrentPosition() {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            return iTangramDecoderPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public int getDuration() {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            return iTangramDecoderPlayer.getDuration();
        }
        return 0;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public int getVideoHeight() {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            return iTangramDecoderPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public int getVideoWidth() {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            return iTangramDecoderPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public boolean isPlaying() {
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void pause() {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            iTangramDecoderPlayer.pause();
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void prepareAsync() {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            iTangramDecoderPlayer.prepareAsync();
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void release() {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            iTangramDecoderPlayer.release();
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void seekTo(int i3) {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            iTangramDecoderPlayer.seekTo(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setDataSource(String str) {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            iTangramDecoderPlayer.setDataSource(str);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setLooping(boolean z16) {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            iTangramDecoderPlayer.setLooping(z16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setOnCompletionListener(final IPlayer.OnCompletionListener onCompletionListener) {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            iTangramDecoderPlayer.setOnCompletionListener(new ITangramDecoderPlayer.OnCompletionListener() { // from class: com.qq.e.comm.plugin.tangramsplash.video.a.2
                @Override // com.qq.e.comm.pi.ITangramDecoderPlayer.OnCompletionListener
                public void onCompletion(ITangramDecoderPlayer iTangramDecoderPlayer2) {
                    IPlayer.OnCompletionListener onCompletionListener2 = onCompletionListener;
                    if (onCompletionListener2 != null) {
                        onCompletionListener2.onCompletion(a.this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setOnErrorListener(final IPlayer.OnErrorListener onErrorListener) {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            iTangramDecoderPlayer.setOnErrorListener(new ITangramDecoderPlayer.OnErrorListener() { // from class: com.qq.e.comm.plugin.tangramsplash.video.a.3
                @Override // com.qq.e.comm.pi.ITangramDecoderPlayer.OnErrorListener
                public boolean onError(ITangramDecoderPlayer iTangramDecoderPlayer2, int i3, int i16) {
                    IPlayer.OnErrorListener onErrorListener2 = onErrorListener;
                    if (onErrorListener2 != null && onErrorListener2.onError(a.this, i3, i16)) {
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setOnInfoListener(final IPlayer.OnInfoListener onInfoListener) {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            iTangramDecoderPlayer.setOnInfoListener(new ITangramDecoderPlayer.OnInfoListener() { // from class: com.qq.e.comm.plugin.tangramsplash.video.a.4
                @Override // com.qq.e.comm.pi.ITangramDecoderPlayer.OnInfoListener
                public boolean onInfo(ITangramDecoderPlayer iTangramDecoderPlayer2, int i3, int i16) {
                    IPlayer.OnInfoListener onInfoListener2 = onInfoListener;
                    if (onInfoListener2 != null && onInfoListener2.onInfo(a.this, i3, i16)) {
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setOnPreparedListener(final IPlayer.OnPreparedListener onPreparedListener) {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            iTangramDecoderPlayer.setOnPreparedListener(new ITangramDecoderPlayer.OnPreparedListener() { // from class: com.qq.e.comm.plugin.tangramsplash.video.a.1
                @Override // com.qq.e.comm.pi.ITangramDecoderPlayer.OnPreparedListener
                public void onPrepared(ITangramDecoderPlayer iTangramDecoderPlayer2) {
                    IPlayer.OnPreparedListener onPreparedListener2 = onPreparedListener;
                    if (onPreparedListener2 != null) {
                        onPreparedListener2.onPrepared(a.this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setOnSeekCompleteListener(final IPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            iTangramDecoderPlayer.setOnSeekCompleteListener(new ITangramDecoderPlayer.OnSeekCompleteListener() { // from class: com.qq.e.comm.plugin.tangramsplash.video.a.5
                @Override // com.qq.e.comm.pi.ITangramDecoderPlayer.OnSeekCompleteListener
                public void onSeekComplete(ITangramDecoderPlayer iTangramDecoderPlayer2) {
                    IPlayer.OnSeekCompleteListener onSeekCompleteListener2 = onSeekCompleteListener;
                    if (onSeekCompleteListener2 != null) {
                        onSeekCompleteListener2.onSeekComplete(a.this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setSurface(Surface surface) {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            iTangramDecoderPlayer.setSurface(surface);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void setVolume(float f16, float f17) {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            iTangramDecoderPlayer.setVolume(f16, f17);
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void start() {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            iTangramDecoderPlayer.start();
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer
    public void stop() {
        ITangramDecoderPlayer iTangramDecoderPlayer = this.f40373b;
        if (iTangramDecoderPlayer != null) {
            iTangramDecoderPlayer.stop();
        }
    }
}
