package com.tencent.tav.asset;

import android.annotation.TargetApi;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.tav.asset.AsynchronousKeyValueLoading;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class Composition<CTrack extends CompositionTrack> extends Asset {
    protected List<CTrack> tracks;

    /* JADX INFO: Access modifiers changed from: protected */
    public Composition() {
        this.tracks = new ArrayList();
    }

    @Override // com.tencent.tav.asset.Asset
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
                this.tracks.add(new CompositionTrack(this, i16, 1, new CMTimeRange(CMTime.CMTimeZero, getVideoDuration())));
            } else if (string.startsWith("audio/")) {
                int i17 = this.trackIndex;
                this.trackIndex = i17 + 1;
                this.tracks.add(new CompositionTrack(this, i17, 2, new CMTimeRange(CMTime.CMTimeZero, getAudioDuration())));
            }
        }
        Log.e(Asset.TAG, " Composition createTracks finish, has track count: " + this.tracks);
    }

    @Override // com.tencent.tav.asset.Asset
    protected CMTime getAudioDuration() {
        CMTime cMTime = CMTime.CMTimeZero;
        for (CTrack ctrack : this.tracks) {
            if (ctrack.getMediaType() == 2) {
                CMTime duration = ctrack.getDuration();
                if (duration.bigThan(cMTime)) {
                    cMTime = duration;
                }
            }
        }
        return cMTime;
    }

    @Override // com.tencent.tav.asset.Asset
    public List<CTrack> getTracks() {
        return this.tracks;
    }

    @Override // com.tencent.tav.asset.Asset
    protected CMTime getVideoDuration() {
        CMTime cMTime = CMTime.CMTimeZero;
        for (CTrack ctrack : this.tracks) {
            if (ctrack.getMediaType() == 1) {
                CMTime duration = ctrack.getDuration();
                if (duration.bigThan(cMTime)) {
                    cMTime = duration;
                }
            }
        }
        return cMTime;
    }

    @Override // com.tencent.tav.asset.AsynchronousKeyValueLoading
    public int statusOfValueForKey(String str) throws Exception {
        return 1;
    }

    public String toString() {
        return "Composition{\ntracks=" + this.tracks + "\ntrackCount=" + this.trackCount + '}';
    }

    protected Composition(@NonNull URL url) {
        super(url);
        this.tracks = new ArrayList();
    }

    protected Composition(@NonNull String str) {
        super(str);
        this.tracks = new ArrayList();
    }

    @Override // com.tencent.tav.asset.AsynchronousKeyValueLoading
    public void loadValuesAsynchronouslyForKeys(List<String> list, AsynchronousKeyValueLoading.loadCallback loadcallback) {
    }
}
