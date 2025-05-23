package com.tencent.qcircle.tavcut.cover;

import android.graphics.Bitmap;
import com.tencent.qcircle.tavcut.timeline.TimelineCoverGenerator;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavkit.composition.TAVSource;
import java.util.List;

/* loaded from: classes22.dex */
public class CoverProvider {
    private static final String TAG = "CoverProvider";
    private CoverCache mCoverCache;
    private ICoverGenerator mCoverGenerator;
    private CoverListener mCoverListener;
    private RenderContextParams mRenderContextParams;

    public Bitmap getCover(int i3) {
        Bitmap cover;
        CoverCache coverCache = this.mCoverCache;
        if (coverCache != null && (cover = coverCache.getCover(i3)) != null && !cover.isRecycled()) {
            return this.mCoverCache.getCover(i3);
        }
        return null;
    }

    public void getCoverByIndexRange(int i3, int i16) {
        Logger.d(TAG, "getCoverByIndexRange: startIndex is " + i3);
        Logger.d(TAG, "getCoverByIndexRange: endIndex is " + i16);
        ICoverGenerator iCoverGenerator = this.mCoverGenerator;
        if (iCoverGenerator != null) {
            iCoverGenerator.generateCoverByIndexRange(i3, i16);
        }
    }

    public void getCoverByTimeRange(long j3, long j16) {
        Logger.d(TAG, "getCoverByTimeRange: startDurationMs is " + j3);
        Logger.d(TAG, "getCoverByTimeRange: endDurationMs is " + j16);
        ICoverGenerator iCoverGenerator = this.mCoverGenerator;
        if (iCoverGenerator != null) {
            iCoverGenerator.generateCoverByTimeRange(j3, j16);
        }
    }

    public void init(TAVSource tAVSource, long j3, int i3, int i16, int i17) {
        Logger.d(TAG, "init: itemDurationMs is " + j3);
        Logger.d(TAG, "init: coverWidth is " + i16);
        Logger.d(TAG, "init: coverHeight is " + i17);
        CoverCache coverCache = new CoverCache();
        this.mCoverCache = coverCache;
        CoverListener coverListener = this.mCoverListener;
        if (coverListener != null) {
            coverCache.setClipCoverListener(coverListener);
        }
        TimelineCoverGenerator timelineCoverGenerator = new TimelineCoverGenerator();
        this.mCoverGenerator = timelineCoverGenerator;
        timelineCoverGenerator.setCoverCache(this.mCoverCache);
        this.mCoverGenerator.setRenderContextParamas(this.mRenderContextParams);
        this.mCoverGenerator.init(tAVSource, j3, i3, i16, i17);
    }

    public void pause() {
        ICoverGenerator iCoverGenerator = this.mCoverGenerator;
        if (iCoverGenerator != null) {
            iCoverGenerator.pause();
        }
    }

    public void release() {
        ICoverGenerator iCoverGenerator = this.mCoverGenerator;
        if (iCoverGenerator != null) {
            iCoverGenerator.release();
            this.mCoverGenerator = null;
        }
        CoverCache coverCache = this.mCoverCache;
        if (coverCache != null) {
            coverCache.release();
            this.mCoverCache = null;
        }
        this.mCoverListener = null;
    }

    public void resume() {
        ICoverGenerator iCoverGenerator = this.mCoverGenerator;
        if (iCoverGenerator != null) {
            iCoverGenerator.resume();
        }
    }

    public void setCoverListener(CoverListener coverListener) {
        this.mCoverListener = coverListener;
    }

    public void setRenderContextParams(RenderContextParams renderContextParams) {
        this.mRenderContextParams = renderContextParams;
    }

    public void init(TAVSource tAVSource, long j3, int i3, int i16, int i17, ICoverGenerator iCoverGenerator) {
        Logger.d(TAG, "init: itemDurationMs is " + j3);
        Logger.d(TAG, "init: coverWidth is " + i16);
        Logger.d(TAG, "init: coverHeight is " + i17);
        CoverCache coverCache = new CoverCache();
        this.mCoverCache = coverCache;
        CoverListener coverListener = this.mCoverListener;
        if (coverListener != null) {
            coverCache.setClipCoverListener(coverListener);
        }
        this.mCoverGenerator = iCoverGenerator;
        iCoverGenerator.setCoverCache(this.mCoverCache);
        this.mCoverGenerator.init(tAVSource, j3, i3, i16, i17);
    }

    public void init(TAVSource tAVSource, List<CMTime> list, int i3, int i16) {
        Logger.d(TAG, "init: generateTimeList is " + list);
        Logger.d(TAG, "init: coverWidth is " + i3);
        Logger.d(TAG, "init: coverHeight is " + i16);
        CoverCache coverCache = new CoverCache();
        this.mCoverCache = coverCache;
        CoverListener coverListener = this.mCoverListener;
        if (coverListener != null) {
            coverCache.setClipCoverListener(coverListener);
        }
        EditCoverGenerator editCoverGenerator = new EditCoverGenerator();
        this.mCoverGenerator = editCoverGenerator;
        editCoverGenerator.setCoverCache(this.mCoverCache);
        this.mCoverGenerator.init(tAVSource, list, i3, i16);
    }
}
