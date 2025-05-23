package com.google.android.exoplayer2.ext.mediaplayer;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataDecoderFactory;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DefaultRendererProvider implements RendererProvider {
    protected AudioRendererEventListener audioRendererEventListener;
    protected TextRenderer.Output captionListener;
    protected Context context;
    protected DrmSessionManager<FrameworkMediaCrypto> drmSessionManager;
    protected Handler handler;
    protected MetadataRenderer.Output metadataListener;
    protected VideoRendererEventListener videoRendererEventListener;
    protected int droppedFrameNotificationAmount = 50;
    protected int allowedJoiningTimeMs = 5000;

    public DefaultRendererProvider(Context context, Handler handler, TextRenderer.Output output, MetadataRenderer.Output output2, AudioRendererEventListener audioRendererEventListener, VideoRendererEventListener videoRendererEventListener) {
        this.context = context;
        this.handler = handler;
        this.captionListener = output;
        this.metadataListener = output2;
        this.audioRendererEventListener = audioRendererEventListener;
        this.videoRendererEventListener = videoRendererEventListener;
    }

    protected List<Renderer> buildAudioRenderers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MediaCodecAudioRenderer(MediaCodecSelector.DEFAULT, this.drmSessionManager, true, this.handler, this.audioRendererEventListener, AudioCapabilities.getCapabilities(this.context), new AudioProcessor[0]));
        return arrayList;
    }

    protected List<Renderer> buildCaptionRenderers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TextRenderer(this.captionListener, this.handler.getLooper()));
        return arrayList;
    }

    protected List<Renderer> buildMetadataRenderers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MetadataRenderer(this.metadataListener, this.handler.getLooper(), MetadataDecoderFactory.DEFAULT));
        return arrayList;
    }

    protected List<Renderer> buildVideoRenderers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MediaCodecVideoRenderer(this.context, MediaCodecSelector.DEFAULT, this.allowedJoiningTimeMs, this.drmSessionManager, false, this.handler, this.videoRendererEventListener, this.droppedFrameNotificationAmount));
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.RendererProvider
    public List<Renderer> generate() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(buildAudioRenderers());
        arrayList.addAll(buildVideoRenderers());
        return arrayList;
    }

    public void setAllowedVideoJoiningTimeMs(int i3) {
        this.allowedJoiningTimeMs = i3;
    }

    public void setDrmSessionManager(DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        this.drmSessionManager = drmSessionManager;
    }

    public void setDroppedFrameNotificationAmount(int i3) {
        this.droppedFrameNotificationAmount = i3;
    }
}
