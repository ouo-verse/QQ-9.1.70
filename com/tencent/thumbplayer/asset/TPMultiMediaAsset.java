package com.tencent.thumbplayer.asset;

import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPMultiMediaAsset;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes26.dex */
public class TPMultiMediaAsset extends TPMediaAsset implements ITPMultiMediaAsset {
    private static final String TAG = "TPMultiMediaAsset";
    private final List<Pair<ITPMediaAsset, Long>> mMediaAssetAndClipDurationMsList = new CopyOnWriteArrayList();

    private void checkArgument(ITPMediaAsset iTPMediaAsset, long j3) throws IllegalArgumentException {
        if (iTPMediaAsset != null) {
            if (iTPMediaAsset instanceof TPUrlMediaAsset) {
                if (iTPMediaAsset.isValid()) {
                    if (j3 > 0) {
                        return;
                    } else {
                        throw new IllegalArgumentException("addAsset failed, clipDurationMs <= 0");
                    }
                }
                throw new IllegalArgumentException("addAsset failed, asset is invalid");
            }
            throw new IllegalArgumentException("addAsset failed, asset= " + iTPMediaAsset + " is not ASSET_TYPE_URL");
        }
        throw new IllegalArgumentException("addAsset failed, asset is null");
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPMultiMediaAsset
    public void addAsset(@NonNull ITPMediaAsset iTPMediaAsset, long j3) throws IllegalArgumentException {
        if (j3 <= 0) {
            TPLogUtil.e(TAG, "clipDurationMs <=0 error");
        } else {
            checkArgument(iTPMediaAsset, j3);
            this.mMediaAssetAndClipDurationMsList.add(new Pair<>(iTPMediaAsset, Long.valueOf(j3)));
        }
    }

    public List<Pair<ITPMediaAsset, Long>> getAssetAndClipDurationMsPairList() {
        return Collections.unmodifiableList(this.mMediaAssetAndClipDurationMsList);
    }

    @Override // com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public int getAssetType() {
        return 6;
    }

    public long getTotalDurationMs() {
        Iterator<Pair<ITPMediaAsset, Long>> it = this.mMediaAssetAndClipDurationMsList.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += it.next().second.longValue();
        }
        return j3;
    }

    @Override // com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public boolean isValid() {
        if (getResourceLoader() != null || this.mMediaAssetAndClipDurationMsList.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.thumbplayer.asset.TPMediaAsset
    public String toString() {
        StringBuilder sb5 = new StringBuilder("TPMultiMediaAsset(" + super.toString() + ")");
        sb5.append("totalDurationMs = ");
        sb5.append(getTotalDurationMs());
        for (int i3 = 0; i3 < this.mMediaAssetAndClipDurationMsList.size(); i3++) {
            sb5.append("\n");
            sb5.append("clip:index_");
            sb5.append(i3);
            sb5.append("\n");
            sb5.append("{");
            sb5.append(this.mMediaAssetAndClipDurationMsList.get(i3));
            sb5.append("}");
        }
        return sb5.toString();
    }
}
