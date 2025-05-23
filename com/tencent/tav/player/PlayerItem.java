package com.tencent.tav.player;

import androidx.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.core.AudioMix;
import com.tencent.tav.core.VideoCompositionDecoderTrack;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.decodecache.CachedVideoDecoderTrack;
import com.tencent.tav.decoder.reverseaudio.ReverseAudioDecoderTrack;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes26.dex */
public class PlayerItem {
    private Asset asset;
    private final AssetExtension assetExtension;
    private AudioCompositionDecoderTrack audioCompositionDecoderTrack;
    private AudioInfo audioInfo;

    @Nullable
    private AudioMix audioMix;
    private int audioRevertCacheSamples;
    private boolean audioRevertModel;

    @Nullable
    private VideoCompositing customVideoCompositor;
    private PlayerLayer layer;
    private int maxCacheSize;
    private PlayerThread playerThreadMain;
    private float rate;
    private IDecoderTrack realVDecoderTrack;
    private IDecoderTrack revertAudioDecoderTrack;
    private final PlayerItemStatus status;
    private final List<PlayerItemTrack> tracks;
    private IDecoderTrack vDecoderTrack;

    @Nullable
    private VideoComposition videoComposition;
    private boolean videoRevertModel;

    /* loaded from: classes26.dex */
    public enum PlayerItemStatus {
        PlayerItemStatusUnknown,
        PlayerItemStatusReadyToPlay,
        PlayerItemStatusFailed
    }

    public PlayerItem(String str) {
        this(new URLAsset(str), null);
    }

    private float getVideoFrameRate() {
        if (this.videoComposition != null) {
            return (r0.getFrameDuration().timeScale * 1.0f) / ((float) this.videoComposition.getFrameDuration().getValue());
        }
        return PlayerDefaultConfigs.DEFAULT_FRAME_DURATION.timeScale;
    }

    private void initVideoCompositionDecoderTrack() {
        VideoCompositionDecoderTrack videoCompositionDecoderTrack = new VideoCompositionDecoderTrack(this.asset, this.assetExtension, 1);
        int i3 = 24;
        for (PlayerItemTrack playerItemTrack : this.tracks) {
            if (playerItemTrack != null && playerItemTrack.isEnabled() && playerItemTrack.getAssetTrack().getMediaType() == 1) {
                videoCompositionDecoderTrack.addTrack(playerItemTrack.getAssetTrack());
                i3 = (int) Math.min(playerItemTrack.getCurrentVideoFrameRate(), i3);
            }
        }
        VideoComposition videoComposition = this.videoComposition;
        if (videoComposition != null && videoComposition.getFrameDuration() != null) {
            i3 = (int) (this.videoComposition.getFrameDuration().timeScale / this.videoComposition.getFrameDuration().value);
        }
        if (i3 <= 0) {
            i3 = PlayerDefaultConfigs.DEFAULT_FRAME_RATE;
        }
        videoCompositionDecoderTrack.setVideoComposition(this.videoComposition);
        VideoCompositing videoCompositing = this.customVideoCompositor;
        if (videoCompositing != null) {
            videoCompositionDecoderTrack.setVideoCompositing(videoCompositing);
        }
        videoCompositionDecoderTrack.setFrameRate(i3);
        videoCompositionDecoderTrack.setFrameDuration(new CMTime(1L, i3));
        this.realVDecoderTrack = videoCompositionDecoderTrack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bindLayer(PlayerLayer playerLayer) {
        boolean z16;
        IDecoderTrack iDecoderTrack;
        this.layer = playerLayer;
        if (this.playerThreadMain == null) {
            return;
        }
        float f16 = this.rate;
        if (f16 >= 0.0f && !this.videoRevertModel) {
            iDecoderTrack = this.realVDecoderTrack;
        } else {
            IDecoderTrack iDecoderTrack2 = this.realVDecoderTrack;
            if (f16 >= 0.0f && !this.videoRevertModel) {
                z16 = false;
            } else {
                z16 = true;
            }
            CachedVideoDecoderTrack cachedVideoDecoderTrack = new CachedVideoDecoderTrack(iDecoderTrack2, z16);
            this.vDecoderTrack = cachedVideoDecoderTrack;
            cachedVideoDecoderTrack.setMaxFrameCacheSize(this.maxCacheSize);
            iDecoderTrack = this.vDecoderTrack;
        }
        this.playerThreadMain.bindSurface(iDecoderTrack, playerLayer);
    }

    public Asset getAsset() {
        return this.asset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IDecoderTrack getAudioCompositionDecoderTrack() {
        if (this.audioRevertModel) {
            ReverseAudioDecoderTrack reverseAudioDecoderTrack = new ReverseAudioDecoderTrack(this.audioCompositionDecoderTrack, this.audioRevertCacheSamples);
            this.revertAudioDecoderTrack = reverseAudioDecoderTrack;
            return reverseAudioDecoderTrack;
        }
        return this.audioCompositionDecoderTrack;
    }

    public AudioInfo getAudioInfo() {
        return this.audioInfo;
    }

    @Nullable
    public AudioMix getAudioMix() {
        return this.audioMix;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public VideoCompositing getCustomVideoCompositor() {
        return this.customVideoCompositor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerThread getPlayerThreadMain() {
        return this.playerThreadMain;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CGSize getPresentationSize() {
        return this.asset.getNaturalSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IDecoderTrack getRealDecoderTrack() {
        boolean z16;
        float f16 = this.rate;
        if (f16 >= 0.0f && !this.videoRevertModel) {
            return this.realVDecoderTrack;
        }
        IDecoderTrack iDecoderTrack = this.realVDecoderTrack;
        if (f16 >= 0.0f && !this.videoRevertModel) {
            z16 = false;
        } else {
            z16 = true;
        }
        CachedVideoDecoderTrack cachedVideoDecoderTrack = new CachedVideoDecoderTrack(iDecoderTrack, z16);
        this.vDecoderTrack = cachedVideoDecoderTrack;
        cachedVideoDecoderTrack.setMaxFrameCacheSize(this.maxCacheSize);
        return this.vDecoderTrack;
    }

    public PlayerItemStatus getStatus() {
        return this.status;
    }

    @Nullable
    public VideoComposition getVideoComposition() {
        return this.videoComposition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioCompositionDecoderTrack initAudioCompositionDecoderTrack() {
        this.audioCompositionDecoderTrack = new AudioCompositionDecoderTrack(2);
        for (PlayerItemTrack playerItemTrack : this.tracks) {
            if (playerItemTrack != null && playerItemTrack.isEnabled() && playerItemTrack.getAssetTrack().getMediaType() == 2) {
                this.audioCompositionDecoderTrack.addTrack(playerItemTrack.getAssetTrack());
            }
        }
        this.audioCompositionDecoderTrack.setAudioMix(this.audioMix);
        AudioInfo audioInfo = this.audioInfo;
        if (audioInfo != null) {
            this.audioCompositionDecoderTrack.setAudioInfo(audioInfo);
        }
        return this.audioCompositionDecoderTrack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        PlayerLayer playerLayer = this.layer;
        if (playerLayer != null) {
            playerLayer.release();
        }
        AudioMix audioMix = this.audioMix;
        if (audioMix != null) {
            audioMix.release();
        }
    }

    public void setAudioInfo(AudioInfo audioInfo) {
        if (audioInfo != null) {
            this.audioInfo = audioInfo;
            AudioCompositionDecoderTrack audioCompositionDecoderTrack = this.audioCompositionDecoderTrack;
            if (audioCompositionDecoderTrack != null) {
                audioCompositionDecoderTrack.setAudioInfo(audioInfo);
            }
        }
    }

    public void setAudioMix(@Nullable AudioMix audioMix) {
        this.audioMix = audioMix;
        AudioCompositionDecoderTrack audioCompositionDecoderTrack = this.audioCompositionDecoderTrack;
        if (audioCompositionDecoderTrack != null) {
            audioCompositionDecoderTrack.setAudioMix(audioMix);
        }
    }

    public void setAudioRevertCacheSamples(int i3) {
        this.audioRevertCacheSamples = i3;
    }

    public void setAudioRevertMode(boolean z16) {
        this.audioRevertModel = z16;
    }

    public void setRate(float f16) {
        setRate(f16, this.maxCacheSize);
    }

    public void setVideoComposition(@Nullable VideoComposition videoComposition) {
        this.videoComposition = videoComposition;
        if (videoComposition != null) {
            this.customVideoCompositor = videoComposition.getCustomVideoCompositor();
        }
    }

    public void setVideoRevertMode(boolean z16) {
        this.videoRevertModel = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void start(Player player) {
        IDecoderTrack iDecoderTrack;
        IDecoderTrack iDecoderTrack2;
        initVideoCompositionDecoderTrack();
        initAudioCompositionDecoderTrack();
        if (this.layer == null) {
            iDecoderTrack = null;
        } else {
            iDecoderTrack = this.vDecoderTrack;
        }
        if (this.audioRevertModel) {
            this.revertAudioDecoderTrack = new ReverseAudioDecoderTrack(this.audioCompositionDecoderTrack, this.audioRevertCacheSamples);
        }
        if (this.audioRevertModel) {
            iDecoderTrack2 = this.revertAudioDecoderTrack;
        } else {
            iDecoderTrack2 = this.audioCompositionDecoderTrack;
        }
        PlayerThread playerThread = new PlayerThread(iDecoderTrack, iDecoderTrack2, player);
        this.playerThreadMain = playerThread;
        playerThread.setRate(this.rate);
        VideoComposition videoComposition = this.videoComposition;
        if (videoComposition != null) {
            this.playerThreadMain.setFrameDuration(videoComposition.getFrameDuration());
        }
    }

    public void updateComposition(Asset asset) {
        this.asset = asset;
        this.tracks.clear();
        for (AssetTrack assetTrack : asset.getTracks()) {
            PlayerItemTrack playerItemTrack = new PlayerItemTrack();
            playerItemTrack.setAssetTrack(assetTrack);
            playerItemTrack.setCurrentVideoFrameRate(getVideoFrameRate());
            playerItemTrack.setEnabled(true);
            this.tracks.add(playerItemTrack);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateDecoderTrack() {
        initVideoCompositionDecoderTrack();
        initAudioCompositionDecoderTrack();
    }

    public PlayerItem(Asset asset) {
        this(asset, new AssetExtension("play"));
    }

    public void setRate(float f16, int i3) {
        this.rate = f16;
        this.maxCacheSize = i3;
        PlayerThread playerThread = this.playerThreadMain;
        if (playerThread != null) {
            playerThread.setRate(f16);
        }
    }

    public PlayerItem(Asset asset, AssetExtension assetExtension) {
        this.status = PlayerItemStatus.PlayerItemStatusUnknown;
        this.tracks = new ArrayList();
        this.rate = 1.0f;
        this.audioRevertModel = false;
        this.audioRevertCacheSamples = 30;
        this.videoRevertModel = false;
        this.layer = null;
        this.maxCacheSize = 60;
        this.asset = asset;
        this.assetExtension = assetExtension;
        for (AssetTrack assetTrack : asset.getTracks()) {
            PlayerItemTrack playerItemTrack = new PlayerItemTrack();
            playerItemTrack.setAssetTrack(assetTrack);
            playerItemTrack.setCurrentVideoFrameRate(getVideoFrameRate());
            playerItemTrack.setEnabled(true);
            this.tracks.add(playerItemTrack);
        }
    }
}
