package com.tencent.tav.asset;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.media.MediaFormat;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class Asset<Track extends AssetTrack> implements AsynchronousKeyValueLoading {
    public static final String TAG = "Asset";
    private boolean canContainFragments;
    private boolean composable;
    private boolean containsFragments;
    private CMTime duration;
    private boolean exportable;
    protected HashMap<String, Object> extraInfo;
    protected AssetExtractor extractor;
    private int extractorRetryCount;

    @NonNull
    private String filePath;
    private boolean hasProtectedContent;
    private String lyrics;
    private MediaFormat mediaFormat;
    private int mirror;
    protected CGSize naturalSize;
    private CMTime overallDurationHint;
    private boolean playable;
    protected int preferRotation;
    private float preferredRate;
    private Matrix preferredTransform;
    protected float preferredVolume;
    private boolean providesPreciseDurationAndTiming;
    private boolean readable;
    private boolean safeInit;
    protected int trackCount;
    private ArrayList<MediaFormat> trackFormats;
    protected int trackIndex;
    protected List<Track> tracks;

    /* JADX INFO: Access modifiers changed from: protected */
    public Asset() {
        this.trackIndex = 0;
        this.trackCount = 0;
        this.duration = CMTime.CMTimeZero;
        this.preferredRate = 1.0f;
        this.preferRotation = 0;
        this.mirror = 0;
        this.preferredVolume = 1.0f;
        this.extraInfo = new HashMap<>();
        this.extractorRetryCount = 3;
    }

    private void initMembers() {
        ArrayList<MediaFormat> mediaFormats = ExtractorUtils.getMediaFormats(this.extractor);
        this.trackFormats = mediaFormats;
        if (!mediaFormats.isEmpty()) {
            this.trackCount = this.trackFormats.size();
            this.duration = getDuration();
            this.naturalSize = ExtractorUtils.getVideoSize(this.trackFormats);
            int preferRotation = ExtractorUtils.getPreferRotation(this.trackFormats);
            this.preferRotation = preferRotation;
            if (preferRotation != 0) {
                this.preferredTransform = new Matrix();
                while (true) {
                    int i3 = this.preferRotation;
                    if (i3 < 0) {
                        this.preferRotation = i3 + 4;
                    } else {
                        int i16 = i3 % 4;
                        this.preferRotation = i16;
                        Matrix matrix = this.preferredTransform;
                        CGSize cGSize = this.naturalSize;
                        DecoderUtils.getRotationMatrix(matrix, i16, cGSize.width, cGSize.height);
                        return;
                    }
                }
            }
        } else {
            throw new RuntimeException("getMediaFormats is empty, path = " + this.filePath);
        }
    }

    private void onInitException(Exception exc) {
        if (this.safeInit) {
            AssetExtractor assetExtractor = this.extractor;
            if (assetExtractor != null) {
                assetExtractor.release();
                this.extractor = null;
            }
            trySleep(100);
            tryInitMembers();
            return;
        }
        throw new RuntimeException(exc);
    }

    private void tryInitMembers() {
        int i3 = this.extractorRetryCount;
        this.extractorRetryCount = i3 - 1;
        if (i3 <= 0) {
            return;
        }
        try {
            initMembers();
        } catch (Exception e16) {
            Logger.e(TAG, "Asset: initMembers failed, path = " + this.filePath, e16);
            onInitException(e16);
        }
        Logger.v(TAG, "tryInitMembers: try count = " + (3 - this.extractorRetryCount));
    }

    private void trySleep(int i3) {
        try {
            LockMethodProxy.sleep(i3);
        } catch (Exception e16) {
            Logger.e(TAG, "tryInitMembers: Thread.sleep(100) ", e16);
        }
    }

    public synchronized void cancelLoading() {
    }

    @TargetApi(16)
    protected void createTracks() {
        int trackCount = this.extractor.getTrackCount();
        if (this.tracks == null) {
            this.tracks = new ArrayList();
        }
        for (int i3 = 0; i3 < trackCount; i3++) {
            String string = this.extractor.getTrackFormat(i3).getString("mime");
            if (string.startsWith("video/")) {
                int i16 = this.trackIndex;
                this.trackIndex = i16 + 1;
                AssetTrack assetTrack = new AssetTrack(this, i16, 1, new CMTimeRange(CMTime.CMTimeZero, getVideoDuration()));
                assetTrack.setPreferredTransform(this.preferredTransform);
                assetTrack.setPreferredRotation(this.preferRotation);
                this.tracks.add(assetTrack);
            } else if (string.startsWith("audio/")) {
                int i17 = this.trackIndex;
                this.trackIndex = i17 + 1;
                AssetTrack assetTrack2 = new AssetTrack(this, i17, 2, new CMTimeRange(CMTime.CMTimeZero, getAudioDuration()));
                assetTrack2.setPreferredVolume(this.preferredVolume);
                this.tracks.add(assetTrack2);
            }
        }
        Logger.d(TAG, "Asset createTracks finish, has track count: " + this.tracks);
    }

    protected CMTime getAudioDuration() {
        return TimeUtil.us2CMTime(ExtractorUtils.getAudioDuration(this.trackFormats));
    }

    public synchronized CMTime getDuration() {
        CMTime cMTime = this.duration;
        if (cMTime == null || cMTime.equalsTo(CMTime.CMTimeZero)) {
            CMTime videoDuration = getVideoDuration();
            if (CMTime.CMTimeZero.equalsTo(videoDuration)) {
                videoDuration = getAudioDuration();
            }
            this.duration = videoDuration;
        }
        return this.duration;
    }

    public HashMap<String, Object> getExtraInfo() {
        return this.extraInfo;
    }

    public synchronized AssetExtractor getExtractor() {
        return this.extractor;
    }

    public String getLyrics() {
        return this.lyrics;
    }

    public MediaFormat getMediaFormat() {
        return this.mediaFormat;
    }

    public CGSize getNaturalSize() {
        return this.naturalSize;
    }

    public CMTime getOverallDurationHint() {
        return this.overallDurationHint;
    }

    public int getPreferRotation() {
        return this.preferRotation;
    }

    public float getPreferredRate() {
        return this.preferredRate;
    }

    public Matrix getPreferredTransform() {
        return this.preferredTransform;
    }

    public float getPreferredVolume() {
        return this.preferredVolume;
    }

    public synchronized String getSourcePath() {
        AssetExtractor assetExtractor = this.extractor;
        if (assetExtractor != null) {
            return assetExtractor.getSourcePath();
        }
        return null;
    }

    public int getTrackCount() {
        return this.trackCount;
    }

    public synchronized MediaFormat getTrackFormat(int i3) {
        AssetExtractor assetExtractor = this.extractor;
        if (assetExtractor != null) {
            return assetExtractor.getTrackFormat(i3);
        }
        return null;
    }

    public List<Track> getTracks() {
        return this.tracks;
    }

    protected CMTime getVideoDuration() {
        return TimeUtil.us2CMTime(ExtractorUtils.getDuration(this.trackFormats));
    }

    public boolean isCanContainFragments() {
        return this.canContainFragments;
    }

    public boolean isComposable() {
        return this.composable;
    }

    public boolean isContainsFragments() {
        return this.containsFragments;
    }

    public boolean isExportable() {
        return this.exportable;
    }

    public boolean isHasProtectedContent() {
        return this.hasProtectedContent;
    }

    public boolean isPlayable() {
        return this.playable;
    }

    public boolean isProvidesPreciseDurationAndTiming() {
        return this.providesPreciseDurationAndTiming;
    }

    public boolean isReadable() {
        return this.readable;
    }

    public void putExtraInfoKeyValue(String str, Object obj) {
        this.extraInfo.put(str, obj);
    }

    public synchronized void selectTrack(int i3) {
        AssetExtractor assetExtractor = this.extractor;
        if (assetExtractor != null) {
            assetExtractor.selectTrack(i3);
        }
    }

    public AssetTrack trackWithTrackID(int i3) {
        List<Track> list = this.tracks;
        if (list != null) {
            for (Track track : list) {
                if (track != null && track.getTrackID() == i3) {
                    return track;
                }
            }
            return null;
        }
        return null;
    }

    public List<AssetTrack> tracksWithMediaCharacteristic(String str) {
        return null;
    }

    public List<AssetTrack> tracksWithMediaType(int i3) {
        if (this.tracks != null) {
            ArrayList arrayList = new ArrayList();
            for (Track track : this.tracks) {
                if (track != null && track.getMediaType() == i3) {
                    arrayList.add(track);
                }
            }
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Asset(@NonNull URL url) {
        this.trackIndex = 0;
        this.trackCount = 0;
        this.duration = CMTime.CMTimeZero;
        this.preferredRate = 1.0f;
        this.preferRotation = 0;
        this.mirror = 0;
        this.preferredVolume = 1.0f;
        this.extraInfo = new HashMap<>();
        this.extractorRetryCount = 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Asset(@NonNull String str) {
        this(str, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Asset(@NonNull String str, boolean z16) {
        this.trackIndex = 0;
        this.trackCount = 0;
        this.duration = CMTime.CMTimeZero;
        this.preferredRate = 1.0f;
        this.preferRotation = 0;
        this.mirror = 0;
        this.preferredVolume = 1.0f;
        this.extraInfo = new HashMap<>();
        this.extractorRetryCount = 3;
        Logger.i(TAG, "Asset() called with: filePath = [" + str + "], safeInit = [" + z16 + "]");
        this.filePath = str;
        this.safeInit = z16;
        AssetExtractor assetExtractor = new AssetExtractor();
        this.extractor = assetExtractor;
        assetExtractor.setDataSource(str);
        tryInitMembers();
        createTracks();
    }
}
