package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
/* loaded from: classes2.dex */
public class SimpleExoPlayer implements ExoPlayer, Player.VideoComponent, Player.TextComponent {
    private static final String TAG = "SimpleExoPlayer";
    private AudioAttributes audioAttributes;
    private final CopyOnWriteArraySet<AudioRendererEventListener> audioDebugListeners;
    private DecoderCounters audioDecoderCounters;
    private Format audioFormat;
    private int audioSessionId;
    private float audioVolume;
    private final ComponentListener componentListener;
    private final CopyOnWriteArraySet<MetadataOutput> metadataOutputs;
    private boolean ownsSurface;
    private final ExoPlayer player;
    protected final Renderer[] renderers;
    private Surface surface;
    private SurfaceHolder surfaceHolder;
    private final CopyOnWriteArraySet<TextOutput> textOutputs;
    private TextureView textureView;
    private final CopyOnWriteArraySet<VideoRendererEventListener> videoDebugListeners;
    private DecoderCounters videoDecoderCounters;
    private Format videoFormat;
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.video.VideoListener> videoListeners;
    private int videoScalingMode;

    @Deprecated
    /* loaded from: classes2.dex */
    public interface VideoListener extends com.google.android.exoplayer2.video.VideoListener {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SimpleExoPlayer(RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl) {
        this(renderersFactory, trackSelector, loadControl, Clock.DEFAULT);
    }

    private void removeSurfaceCallbacks() {
        TextureView textureView = this.textureView;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.componentListener) {
                Log.w(TAG, "SurfaceTextureListener already unset or replaced.");
            } else {
                this.textureView.setSurfaceTextureListener(null);
            }
            this.textureView = null;
        }
        SurfaceHolder surfaceHolder = this.surfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.componentListener);
            this.surfaceHolder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoSurfaceInternal(Surface surface, boolean z16) {
        ArrayList arrayList = new ArrayList();
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                arrayList.add(this.player.createMessage(renderer).setType(1).setPayload(surface).send());
            }
        }
        Surface surface2 = this.surface;
        if (surface2 != null && surface2 != surface) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((PlayerMessage) it.next()).blockUntilDelivered();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (this.ownsSurface) {
                this.surface.release();
            }
        }
        this.surface = surface;
        this.ownsSurface = z16;
    }

    public void addAudioDebugListener(AudioRendererEventListener audioRendererEventListener) {
        this.audioDebugListeners.add(audioRendererEventListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(Player.EventListener eventListener) {
        this.player.addListener(eventListener);
    }

    public void addMetadataOutput(MetadataOutput metadataOutput) {
        this.metadataOutputs.add(metadataOutput);
    }

    @Override // com.google.android.exoplayer2.Player.TextComponent
    public void addTextOutput(TextOutput textOutput) {
        this.textOutputs.add(textOutput);
    }

    public void addVideoDebugListener(VideoRendererEventListener videoRendererEventListener) {
        this.videoDebugListeners.add(videoRendererEventListener);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void addVideoListener(com.google.android.exoplayer2.video.VideoListener videoListener) {
        this.videoListeners.add(videoListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void blockingSendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        this.player.blockingSendMessages(exoPlayerMessageArr);
    }

    @Deprecated
    public void clearMetadataOutput(MetadataOutput metadataOutput) {
        removeMetadataOutput(metadataOutput);
    }

    @Deprecated
    public void clearTextOutput(TextOutput textOutput) {
        removeTextOutput(textOutput);
    }

    @Deprecated
    public void clearVideoListener(VideoListener videoListener) {
        removeVideoListener(videoListener);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurface() {
        setVideoSurface(null);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null && surfaceHolder == this.surfaceHolder) {
            setVideoSurfaceHolder(null);
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        SurfaceHolder holder;
        if (surfaceView == null) {
            holder = null;
        } else {
            holder = surfaceView.getHolder();
        }
        clearVideoSurfaceHolder(holder);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoTextureView(TextureView textureView) {
        if (textureView != null && textureView == this.textureView) {
            setVideoTextureView(null);
        }
    }

    protected ExoPlayer createExoPlayerImpl(Renderer[] rendererArr, TrackSelector trackSelector, LoadControl loadControl, Clock clock) {
        return new ExoPlayerImpl(rendererArr, trackSelector, loadControl, clock);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public PlayerMessage createMessage(PlayerMessage.Target target) {
        return this.player.createMessage(target);
    }

    public AudioAttributes getAudioAttributes() {
        return this.audioAttributes;
    }

    public DecoderCounters getAudioDecoderCounters() {
        return this.audioDecoderCounters;
    }

    public Format getAudioFormat() {
        return this.audioFormat;
    }

    public int getAudioSessionId() {
        return this.audioSessionId;
    }

    @Deprecated
    public int getAudioStreamType() {
        return Util.getStreamTypeForAudioUsage(this.audioAttributes.usage);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getBufferedPercentage() {
        return this.player.getBufferedPercentage();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        return this.player.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        return this.player.getContentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        return this.player.getCurrentAdGroupIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        return this.player.getCurrentAdIndexInAdGroup();
    }

    @Override // com.google.android.exoplayer2.Player
    public Object getCurrentManifest() {
        return this.player.getCurrentManifest();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        return this.player.getCurrentPeriodIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        return this.player.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        return this.player.getCurrentTimeline();
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackGroupArray getCurrentTrackGroups() {
        return this.player.getCurrentTrackGroups();
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackSelectionArray getCurrentTrackSelections() {
        return this.player.getCurrentTrackSelections();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        return this.player.getCurrentWindowIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        return this.player.getDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getNextWindowIndex() {
        return this.player.getNextWindowIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        return this.player.getPlayWhenReady();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Looper getPlaybackLooper() {
        return this.player.getPlaybackLooper();
    }

    @Override // com.google.android.exoplayer2.Player
    public PlaybackParameters getPlaybackParameters() {
        return this.player.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        return this.player.getPlaybackState();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPreviousWindowIndex() {
        return this.player.getPreviousWindowIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererCount() {
        return this.player.getRendererCount();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererType(int i3) {
        return this.player.getRendererType(i3);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        return this.player.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        return this.player.getShuffleModeEnabled();
    }

    public DecoderCounters getVideoDecoderCounters() {
        return this.videoDecoderCounters;
    }

    public Format getVideoFormat() {
        return this.videoFormat;
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public int getVideoScalingMode() {
        return this.videoScalingMode;
    }

    public float getVolume() {
        return this.audioVolume;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isCurrentWindowDynamic() {
        return this.player.isCurrentWindowDynamic();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isCurrentWindowSeekable() {
        return this.player.isCurrentWindowSeekable();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        return this.player.isLoading();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        return this.player.isPlayingAd();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource) {
        this.player.prepare(mediaSource);
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        this.player.release();
        removeSurfaceCallbacks();
        Surface surface = this.surface;
        if (surface != null) {
            if (this.ownsSurface) {
                surface.release();
            }
            this.surface = null;
        }
    }

    public void removeAudioDebugListener(AudioRendererEventListener audioRendererEventListener) {
        this.audioDebugListeners.remove(audioRendererEventListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(Player.EventListener eventListener) {
        this.player.removeListener(eventListener);
    }

    public void removeMetadataOutput(MetadataOutput metadataOutput) {
        this.metadataOutputs.remove(metadataOutput);
    }

    @Override // com.google.android.exoplayer2.Player.TextComponent
    public void removeTextOutput(TextOutput textOutput) {
        this.textOutputs.remove(textOutput);
    }

    public void removeVideoDebugListener(VideoRendererEventListener videoRendererEventListener) {
        this.videoDebugListeners.remove(videoRendererEventListener);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void removeVideoListener(com.google.android.exoplayer2.video.VideoListener videoListener) {
        this.videoListeners.remove(videoListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(long j3) {
        this.player.seekTo(j3);
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToDefaultPosition() {
        this.player.seekToDefaultPosition();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void sendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        this.player.sendMessages(exoPlayerMessageArr);
    }

    public void setAudioAttributes(AudioAttributes audioAttributes) {
        this.audioAttributes = audioAttributes;
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 1) {
                this.player.createMessage(renderer).setType(3).setPayload(audioAttributes).send();
            }
        }
    }

    @Deprecated
    public void setAudioDebugListener(AudioRendererEventListener audioRendererEventListener) {
        this.audioDebugListeners.clear();
        if (audioRendererEventListener != null) {
            addAudioDebugListener(audioRendererEventListener);
        }
    }

    @Deprecated
    public void setAudioStreamType(int i3) {
        int audioUsageForStreamType = Util.getAudioUsageForStreamType(i3);
        setAudioAttributes(new AudioAttributes.Builder().setUsage(audioUsageForStreamType).setContentType(Util.getAudioContentTypeForStreamType(i3)).build());
    }

    @Deprecated
    public void setMetadataOutput(MetadataOutput metadataOutput) {
        this.metadataOutputs.clear();
        if (metadataOutput != null) {
            addMetadataOutput(metadataOutput);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z16) {
        this.player.setPlayWhenReady(z16);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaybackParameters(@Nullable PlaybackParameters playbackParameters) {
        this.player.setPlaybackParameters(playbackParameters);
    }

    @TargetApi(23)
    @Deprecated
    public void setPlaybackParams(@Nullable PlaybackParams playbackParams) {
        PlaybackParameters playbackParameters;
        if (playbackParams != null) {
            playbackParams.allowDefaults();
            playbackParameters = new PlaybackParameters(playbackParams.getSpeed(), playbackParams.getPitch());
        } else {
            playbackParameters = null;
        }
        setPlaybackParameters(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i3) {
        this.player.setRepeatMode(i3);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setSeekParameters(@Nullable SeekParameters seekParameters) {
        this.player.setSeekParameters(seekParameters);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z16) {
        this.player.setShuffleModeEnabled(z16);
    }

    @Deprecated
    public void setTextOutput(TextOutput textOutput) {
        this.textOutputs.clear();
        if (textOutput != null) {
            addTextOutput(textOutput);
        }
    }

    @Deprecated
    public void setVideoDebugListener(VideoRendererEventListener videoRendererEventListener) {
        this.videoDebugListeners.clear();
        if (videoRendererEventListener != null) {
            addVideoDebugListener(videoRendererEventListener);
        }
    }

    @Deprecated
    public void setVideoListener(VideoListener videoListener) {
        this.videoListeners.clear();
        if (videoListener != null) {
            addVideoListener(videoListener);
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoScalingMode(int i3) {
        this.videoScalingMode = i3;
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(4).setPayload(Integer.valueOf(i3)).send();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoSurface(Surface surface) {
        removeSurfaceCallbacks();
        setVideoSurfaceInternal(surface, false);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        removeSurfaceCallbacks();
        this.surfaceHolder = surfaceHolder;
        Surface surface = null;
        if (surfaceHolder == null) {
            setVideoSurfaceInternal(null, false);
            return;
        }
        surfaceHolder.addCallback(this.componentListener);
        Surface surface2 = surfaceHolder.getSurface();
        if (surface2 != null && surface2.isValid()) {
            surface = surface2;
        }
        setVideoSurfaceInternal(surface, false);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        SurfaceHolder holder;
        if (surfaceView == null) {
            holder = null;
        } else {
            holder = surfaceView.getHolder();
        }
        setVideoSurfaceHolder(holder);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoTextureView(TextureView textureView) {
        SurfaceTexture surfaceTexture;
        removeSurfaceCallbacks();
        this.textureView = textureView;
        Surface surface = null;
        if (textureView == null) {
            setVideoSurfaceInternal(null, true);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w(TAG, "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.componentListener);
        if (textureView.isAvailable()) {
            surfaceTexture = textureView.getSurfaceTexture();
        } else {
            surfaceTexture = null;
        }
        if (surfaceTexture != null) {
            surface = new Surface(surfaceTexture);
        }
        setVideoSurfaceInternal(surface, true);
    }

    public void setVolume(float f16) {
        this.audioVolume = f16;
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 1) {
                this.player.createMessage(renderer).setType(2).setPayload(Float.valueOf(f16)).send();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop() {
        this.player.stop();
    }

    protected SimpleExoPlayer(RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, Clock clock) {
        ComponentListener componentListener = new ComponentListener();
        this.componentListener = componentListener;
        this.videoListeners = new CopyOnWriteArraySet<>();
        this.textOutputs = new CopyOnWriteArraySet<>();
        this.metadataOutputs = new CopyOnWriteArraySet<>();
        this.videoDebugListeners = new CopyOnWriteArraySet<>();
        this.audioDebugListeners = new CopyOnWriteArraySet<>();
        Renderer[] createRenderers = renderersFactory.createRenderers(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), componentListener, componentListener, componentListener, componentListener);
        this.renderers = createRenderers;
        this.audioVolume = 1.0f;
        this.audioSessionId = 0;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.videoScalingMode = 1;
        this.player = createExoPlayerImpl(createRenderers, trackSelector, loadControl, clock);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurface(Surface surface) {
        if (surface == null || surface != this.surface) {
            return;
        }
        setVideoSurface(null);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource, boolean z16, boolean z17) {
        this.player.prepare(mediaSource, z16, z17);
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i3, long j3) {
        this.player.seekTo(i3, j3);
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToDefaultPosition(int i3) {
        this.player.seekToDefaultPosition(i3);
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop(boolean z16) {
        this.player.stop(z16);
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.TextComponent getTextComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.VideoComponent getVideoComponent() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class ComponentListener implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
        ComponentListener() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public boolean isNeedAudioData() {
            if (SimpleExoPlayer.this.audioDebugListeners.size() > 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderInitialized(String str, long j3, long j16) {
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioDecoderInitialized(str, j3, j16);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDisabled(DecoderCounters decoderCounters) {
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioDisabled(decoderCounters);
            }
            SimpleExoPlayer.this.audioFormat = null;
            SimpleExoPlayer.this.audioDecoderCounters = null;
            SimpleExoPlayer.this.audioSessionId = 0;
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioEnabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.audioDecoderCounters = decoderCounters;
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioEnabled(decoderCounters);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioInputFormatChanged(Format format) {
            SimpleExoPlayer.this.audioFormat = format;
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioInputFormatChanged(format);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSessionId(int i3) {
            SimpleExoPlayer.this.audioSessionId = i3;
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioSessionId(i3);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSinkUnderrun(int i3, long j3, long j16) {
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioSinkUnderrun(i3, j3, j16);
            }
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(List<Cue> list) {
            Iterator it = SimpleExoPlayer.this.textOutputs.iterator();
            while (it.hasNext()) {
                ((TextOutput) it.next()).onCues(list);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onDroppedFrames(int i3, long j3) {
            Iterator it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((VideoRendererEventListener) it.next()).onDroppedFrames(i3, j3);
            }
        }

        @Override // com.google.android.exoplayer2.metadata.MetadataOutput
        public void onMetadata(Metadata metadata) {
            Iterator it = SimpleExoPlayer.this.metadataOutputs.iterator();
            while (it.hasNext()) {
                ((MetadataOutput) it.next()).onMetadata(metadata);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onRenderAudioData(byte[] bArr) {
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onRenderAudioData(bArr);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onRenderedFirstFrame(Surface surface) {
            if (SimpleExoPlayer.this.surface == surface) {
                Iterator it = SimpleExoPlayer.this.videoListeners.iterator();
                while (it.hasNext()) {
                    ((com.google.android.exoplayer2.video.VideoListener) it.next()).onRenderedFirstFrame();
                }
            }
            Iterator it5 = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it5.hasNext()) {
                ((VideoRendererEventListener) it5.next()).onRenderedFirstFrame(surface);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(new Surface(surfaceTexture), true);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(null, true);
            return true;
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderInitialized(String str, long j3, long j16) {
            Iterator it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((VideoRendererEventListener) it.next()).onVideoDecoderInitialized(str, j3, j16);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDisabled(DecoderCounters decoderCounters) {
            Iterator it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((VideoRendererEventListener) it.next()).onVideoDisabled(decoderCounters);
            }
            SimpleExoPlayer.this.videoFormat = null;
            SimpleExoPlayer.this.videoDecoderCounters = null;
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoEnabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.videoDecoderCounters = decoderCounters;
            Iterator it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((VideoRendererEventListener) it.next()).onVideoEnabled(decoderCounters);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoInputFormatChanged(Format format) {
            SimpleExoPlayer.this.videoFormat = format;
            Iterator it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((VideoRendererEventListener) it.next()).onVideoInputFormatChanged(format);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoSizeChanged(int i3, int i16, int i17, float f16) {
            Iterator it = SimpleExoPlayer.this.videoListeners.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.video.VideoListener) it.next()).onVideoSizeChanged(i3, i16, i17, f16);
            }
            Iterator it5 = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it5.hasNext()) {
                ((VideoRendererEventListener) it5.next()).onVideoSizeChanged(i3, i16, i17, f16);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(null, false);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        }
    }
}
