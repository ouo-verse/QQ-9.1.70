package com.tencent.tav.decoder.decodecache;

import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.ITexturePool;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
class CacheSegment {
    public volatile List<CacheFrame> cacheFrameList = new ArrayList();
    public volatile CMTimeRange segmentTimeRange;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheSegment(CMTimeRange cMTimeRange) {
        this.segmentTimeRange = null;
        this.segmentTimeRange = cMTimeRange;
    }

    private boolean isCacheFrameUsable(CacheFrame cacheFrame) {
        CMSampleBuffer cMSampleBuffer = cacheFrame.sampleBuffer;
        if (cMSampleBuffer != null && cMSampleBuffer.getTextureInfo() != null) {
            return true;
        }
        return false;
    }

    public void clear() {
        for (CacheFrame cacheFrame : this.cacheFrameList) {
            if (isCacheFrameUsable(cacheFrame)) {
                cacheFrame.texturePool.pushTexture(cacheFrame.sampleBuffer.getTextureInfo());
                cacheFrame.sampleBuffer = null;
            }
        }
        this.cacheFrameList.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CMTime getLastFrameTime() {
        if (this.cacheFrameList.size() > 0) {
            return this.cacheFrameList.get(this.cacheFrameList.size() - 1).frameTime;
        }
        return this.segmentTimeRange.getEnd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheFrame popFrame(CMTime cMTime) {
        while (this.cacheFrameList.size() > 0) {
            CacheFrame cacheFrame = this.cacheFrameList.get(0);
            if (!cacheFrame.frameTime.smallThan(cMTime)) {
                return this.cacheFrameList.get(0);
            }
            if (isCacheFrameUsable(cacheFrame)) {
                ITexturePool iTexturePool = cacheFrame.texturePool;
                if (iTexturePool == null) {
                    cacheFrame.sampleBuffer.getTextureInfo().release();
                } else {
                    iTexturePool.pushTexture(cacheFrame.sampleBuffer.getTextureInfo());
                }
                cacheFrame.sampleBuffer = null;
            }
            this.cacheFrameList.remove(0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pushFrame(CacheFrame cacheFrame) {
        for (int i3 = 0; i3 < this.cacheFrameList.size(); i3++) {
            if (this.cacheFrameList.get(i3).frameTime.bigThan(cacheFrame.frameTime)) {
                this.cacheFrameList.add(i3, cacheFrame);
                return;
            }
        }
        this.cacheFrameList.add(cacheFrame);
    }
}
