package com.tencent.ttpic.openapi.gles;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GLSegSharedData {
    public SegmentDataPipe[] mTexturePile;

    public GLSegSharedData() {
        SegmentDataPipe[] segmentDataPipeArr = new SegmentDataPipe[2];
        this.mTexturePile = segmentDataPipeArr;
        segmentDataPipeArr[0] = new SegmentDataPipe();
        this.mTexturePile[1] = new SegmentDataPipe();
    }

    public void clear() {
        for (SegmentDataPipe segmentDataPipe : this.mTexturePile) {
            segmentDataPipe.release();
        }
    }

    public SegmentDataPipe getCurrentTexturePile() {
        boolean z16;
        boolean z17;
        if (this.mTexturePile[0].getTexureCurrentStatus() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.mTexturePile[1].getTexureCurrentStatus() == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 && z17) {
            SegmentDataPipe[] segmentDataPipeArr = this.mTexturePile;
            SegmentDataPipe segmentDataPipe = segmentDataPipeArr[0];
            long j3 = segmentDataPipe.mTimestamp;
            SegmentDataPipe segmentDataPipe2 = segmentDataPipeArr[1];
            if (j3 >= segmentDataPipe2.mTimestamp) {
                return segmentDataPipe2;
            }
            return segmentDataPipe;
        }
        if (z16) {
            return this.mTexturePile[0];
        }
        if (z17) {
            return this.mTexturePile[1];
        }
        return null;
    }

    public SegmentDataPipe getFreeTexturePileMakeBusy() {
        int i3 = 0;
        while (true) {
            SegmentDataPipe[] segmentDataPipeArr = this.mTexturePile;
            if (i3 < segmentDataPipeArr.length) {
                if (segmentDataPipeArr[i3].getTexureCurrentStatus() == 0) {
                    SegmentDataPipe segmentDataPipe = this.mTexturePile[i3];
                    segmentDataPipe.makeBusy();
                    return segmentDataPipe;
                }
                i3++;
            } else {
                return null;
            }
        }
    }

    public boolean judgeBrotherTextureIsReady(SegmentDataPipe segmentDataPipe) {
        SegmentDataPipe[] segmentDataPipeArr = this.mTexturePile;
        SegmentDataPipe segmentDataPipe2 = segmentDataPipeArr[0];
        if (segmentDataPipe2 == segmentDataPipe) {
            segmentDataPipe2 = segmentDataPipeArr[1];
        }
        if (segmentDataPipe2.getTexureCurrentStatus() != 2) {
            return false;
        }
        return true;
    }

    public void makeBrotherTextureFree(SegmentDataPipe segmentDataPipe) {
        SegmentDataPipe[] segmentDataPipeArr = this.mTexturePile;
        SegmentDataPipe segmentDataPipe2 = segmentDataPipeArr[0];
        if (segmentDataPipe2 == segmentDataPipe) {
            segmentDataPipe2 = segmentDataPipeArr[1];
        }
        segmentDataPipe2.makeFree();
    }

    public void reset() {
        for (SegmentDataPipe segmentDataPipe : this.mTexturePile) {
            segmentDataPipe.makeFree();
        }
    }
}
