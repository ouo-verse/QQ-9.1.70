package com.tencent.tav.asset;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MutableComposition extends Composition<MutableCompositionTrack> {
    public MutableComposition() {
        setNaturalSize(new CGSize(0.0f, 0.0f));
    }

    private int getCorrectTrackID(int i3) {
        boolean z16;
        Iterator it = ((Composition) this).tracks.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((MutableCompositionTrack) it.next()).getTrackID() == i3) {
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16 && i3 > 0) {
            return i3;
        }
        if (i3 == -1) {
            int i16 = this.trackIndex;
            this.trackIndex = i16 + 1;
            return i16;
        }
        int i17 = this.trackIndex;
        if (i17 >= i3) {
            this.trackIndex = i17 + 1;
            return i17;
        }
        this.trackIndex = i3;
        return i3;
    }

    public MutableCompositionTrack addMutableTrackWithMediaType(int i3, int i16) {
        MutableCompositionTrack mutableCompositionTrack = new MutableCompositionTrack(i3, getCorrectTrackID(i16));
        mutableCompositionTrack.setNaturalSize(getNaturalSize());
        ((Composition) this).tracks.add(mutableCompositionTrack);
        this.trackCount++;
        return mutableCompositionTrack;
    }

    @Override // com.tencent.tav.asset.Asset
    public CGSize getNaturalSize() {
        if (this.naturalSize.equals(CGSize.CGSizeZero)) {
            for (CTrack ctrack : ((Composition) this).tracks) {
                if (ctrack.enabled) {
                    return ctrack.getNaturalSize();
                }
            }
        }
        return this.naturalSize;
    }

    @Override // com.tencent.tav.asset.Asset
    public int getPreferRotation() {
        if (this.preferRotation == 0) {
            for (CTrack ctrack : ((Composition) this).tracks) {
                if (ctrack.enabled) {
                    return ctrack.getPreferredRotation();
                }
            }
        }
        return this.preferRotation;
    }

    @Override // com.tencent.tav.asset.Composition, com.tencent.tav.asset.Asset
    @NonNull
    public List<MutableCompositionTrack> getTracks() {
        return ((Composition) this).tracks;
    }

    public void insertEmptyTimeRange(CMTimeRange cMTimeRange) {
        Iterator it = ((Composition) this).tracks.iterator();
        while (it.hasNext()) {
            ((MutableCompositionTrack) it.next()).insertEmptyTimeRange(cMTimeRange);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
    
        if (r4 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        r4 = r3.getMediaType();
        r5 = r9.trackIndex;
        r9.trackIndex = r5 + 1;
        r4 = addMutableTrackWithMediaType(r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0074, code lost:
    
        if (r4.insertTimeRange(r10, r3, r12) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0077, code lost:
    
        r0.add(java.lang.Integer.valueOf(r4.getTrackID()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean insertTimeRange(CMTimeRange cMTimeRange, Asset asset, CMTime cMTime) {
        if (cMTimeRange.getDuration().value <= 0 || asset == null || asset.getTrackCount() == 0) {
            return false;
        }
        List tracks = asset.getTracks();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 < tracks.size()) {
                AssetTrack assetTrack = (AssetTrack) tracks.get(i3);
                int i16 = i3;
                while (true) {
                    if (i16 < ((Composition) this).tracks.size()) {
                        MutableCompositionTrack mutableCompositionTrack = (MutableCompositionTrack) ((Composition) this).tracks.get(i16);
                        if (mutableCompositionTrack.getMediaType() == assetTrack.getMediaType()) {
                            if (!mutableCompositionTrack.insertTimeRange(cMTimeRange, assetTrack, cMTime)) {
                                return false;
                            }
                            arrayList.add(Integer.valueOf(mutableCompositionTrack.getTrackID()));
                        } else {
                            i16++;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
            } else {
                for (CTrack ctrack : ((Composition) this).tracks) {
                    if (!arrayList.contains(Integer.valueOf(ctrack.getTrackID()))) {
                        ctrack.insertEmptyTimeRange(cMTimeRange);
                    }
                }
                return true;
            }
            i3++;
        }
    }

    @Nullable
    public MutableCompositionTrack mutableTrackCompatibleWithTrack(AssetTrack assetTrack) {
        if (assetTrack != null && assetTrack.getAsset() != null) {
            MutableCompositionTrack mutableCompositionTrack = new MutableCompositionTrack(assetTrack.getMediaType(), getCorrectTrackID(-1));
            mutableCompositionTrack.insertTimeRange(assetTrack.getTimeRange(), assetTrack, CMTime.CMTimeZero);
            mutableCompositionTrack.setPreferredTransform(assetTrack.getPreferredTransform());
            mutableCompositionTrack.setPreferredRotation(assetTrack.getPreferredRotation());
            mutableCompositionTrack.setPreferredVolume(assetTrack.getPreferredVolume());
            return mutableCompositionTrack;
        }
        return null;
    }

    public void removeTimeRange(CMTimeRange cMTimeRange) {
        Iterator it = ((Composition) this).tracks.iterator();
        while (it.hasNext()) {
            ((MutableCompositionTrack) it.next()).removeTimeRange(cMTimeRange);
        }
    }

    public void removeTrack(CompositionTrack compositionTrack) {
        int i3 = 0;
        while (i3 < ((Composition) this).tracks.size()) {
            if (((MutableCompositionTrack) ((Composition) this).tracks.get(i3)) == compositionTrack) {
                ((Composition) this).tracks.remove(i3);
                i3--;
            }
            i3++;
        }
    }

    public void scaleTimeRange(CMTimeRange cMTimeRange, CMTime cMTime) {
        Iterator it = ((Composition) this).tracks.iterator();
        while (it.hasNext()) {
            ((MutableCompositionTrack) it.next()).scaleTimeRange(cMTimeRange, cMTime);
        }
    }

    public void setNaturalSize(CGSize cGSize) {
        this.naturalSize = cGSize;
        for (CTrack ctrack : ((Composition) this).tracks) {
            if (ctrack != null && ctrack.getMediaType() == 1 && ctrack.getNaturalSize() == null) {
                ctrack.setNaturalSize(cGSize);
            }
        }
    }

    public void setPreferRotation(int i3) {
        this.preferRotation = i3;
    }

    public void setPreferredVolume(float f16) {
        this.preferredVolume = f16;
    }

    @Override // com.tencent.tav.asset.Asset
    public List<MutableCompositionTrack> tracksWithMediaType(int i3) {
        ArrayList arrayList = new ArrayList();
        for (CTrack ctrack : ((Composition) this).tracks) {
            if (ctrack != null && ctrack.getMediaType() == i3) {
                arrayList.add(ctrack);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.tav.asset.Asset
    @Nullable
    public MutableCompositionTrack trackWithTrackID(int i3) {
        for (CTrack ctrack : ((Composition) this).tracks) {
            if (ctrack != null && ctrack.getTrackID() == i3) {
                return ctrack;
            }
        }
        return null;
    }
}
