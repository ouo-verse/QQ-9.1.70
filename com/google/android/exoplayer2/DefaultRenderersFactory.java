package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DefaultRenderersFactory implements RenderersFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    protected static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    private static final String TAG = "DefaultRenderersFactory";
    private final long allowedVideoJoiningTimeMs;
    private final Context context;

    @Nullable
    private final DrmSessionManager<FrameworkMediaCrypto> drmSessionManager;
    private final int extensionRendererMode;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ExtensionRendererMode {
    }

    public DefaultRenderersFactory(Context context) {
        this(context, null);
    }

    protected AudioProcessor[] buildAudioProcessors() {
        return new AudioProcessor[0];
    }

    protected void buildAudioRenderers(Context context, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, AudioProcessor[] audioProcessorArr, Handler handler, AudioRendererEventListener audioRendererEventListener, int i3, ArrayList<Renderer> arrayList) {
        int i16;
        arrayList.add(new MediaCodecAudioRenderer(MediaCodecSelector.DEFAULT, drmSessionManager, true, handler, audioRendererEventListener, AudioCapabilities.getCapabilities(context), audioProcessorArr));
        if (i3 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i3 == 2) {
            size--;
        }
        try {
            try {
                i16 = size + 1;
            } catch (ClassNotFoundException unused) {
            }
            try {
                try {
                    arrayList.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(handler, audioRendererEventListener, audioProcessorArr));
                    Log.i(TAG, "Loaded LibopusAudioRenderer.");
                } catch (ClassNotFoundException unused2) {
                    size = i16;
                    i16 = size;
                    try {
                        int i17 = i16 + 1;
                        try {
                            arrayList.add(i16, (Renderer) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(handler, audioRendererEventListener, audioProcessorArr));
                            Log.i(TAG, "Loaded LibflacAudioRenderer.");
                        } catch (ClassNotFoundException unused3) {
                            i16 = i17;
                            i17 = i16;
                            arrayList.add(i17, (Renderer) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(handler, audioRendererEventListener, audioProcessorArr));
                            Log.i(TAG, "Loaded FfmpegAudioRenderer.");
                        }
                        arrayList.add(i17, (Renderer) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(handler, audioRendererEventListener, audioProcessorArr));
                        Log.i(TAG, "Loaded FfmpegAudioRenderer.");
                    } catch (Exception e16) {
                        throw new RuntimeException("Error instantiating FLAC extension", e16);
                    }
                }
                arrayList.add(i17, (Renderer) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(handler, audioRendererEventListener, audioProcessorArr));
                Log.i(TAG, "Loaded FfmpegAudioRenderer.");
            } catch (ClassNotFoundException unused4) {
                return;
            } catch (Exception e17) {
                throw new RuntimeException("Error instantiating FFmpeg extension", e17);
            }
            try {
                int i172 = i16 + 1;
                arrayList.add(i16, (Renderer) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioProcessor[].class).newInstance(handler, audioRendererEventListener, audioProcessorArr));
                Log.i(TAG, "Loaded LibflacAudioRenderer.");
            } catch (ClassNotFoundException unused5) {
            }
        } catch (Exception e18) {
            throw new RuntimeException("Error instantiating Opus extension", e18);
        }
    }

    protected void buildMetadataRenderers(Context context, MetadataOutput metadataOutput, Looper looper, int i3, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
    }

    protected void buildTextRenderers(Context context, TextOutput textOutput, Looper looper, int i3, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    protected void buildVideoRenderers(Context context, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, long j3, Handler handler, VideoRendererEventListener videoRendererEventListener, int i3, ArrayList<Renderer> arrayList) {
        arrayList.add(new MediaCodecVideoRenderer(context, MediaCodecSelector.DEFAULT, j3, drmSessionManager, false, handler, videoRendererEventListener, 50));
        if (i3 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i3 == 2) {
            size--;
        }
        try {
            arrayList.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Boolean.TRUE, Long.valueOf(j3), handler, videoRendererEventListener, 50));
            Log.i(TAG, "Loaded LibvpxVideoRenderer.");
        } catch (ClassNotFoundException unused) {
        } catch (Exception e16) {
            throw new RuntimeException("Error instantiating VP9 extension", e16);
        }
    }

    @Override // com.google.android.exoplayer2.RenderersFactory
    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        ArrayList<Renderer> arrayList = new ArrayList<>();
        buildVideoRenderers(this.context, this.drmSessionManager, this.allowedVideoJoiningTimeMs, handler, videoRendererEventListener, this.extensionRendererMode, arrayList);
        buildAudioRenderers(this.context, this.drmSessionManager, buildAudioProcessors(), handler, audioRendererEventListener, this.extensionRendererMode, arrayList);
        buildTextRenderers(this.context, textOutput, handler.getLooper(), this.extensionRendererMode, arrayList);
        buildMetadataRenderers(this.context, metadataOutput, handler.getLooper(), this.extensionRendererMode, arrayList);
        buildMiscellaneousRenderers(this.context, handler, this.extensionRendererMode, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[arrayList.size()]);
    }

    public DefaultRenderersFactory(Context context, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        this(context, drmSessionManager, 0);
    }

    public DefaultRenderersFactory(Context context, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, int i3) {
        this(context, drmSessionManager, i3, 5000L);
    }

    public DefaultRenderersFactory(Context context, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, int i3, long j3) {
        this.context = context;
        this.drmSessionManager = drmSessionManager;
        this.extensionRendererMode = i3;
        this.allowedVideoJoiningTimeMs = j3;
    }

    protected void buildMiscellaneousRenderers(Context context, Handler handler, int i3, ArrayList<Renderer> arrayList) {
    }
}
