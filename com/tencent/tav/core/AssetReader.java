package com.tencent.tav.core;

import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetReaderOutput;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AssetReader implements AssetReaderOutput.StatusListener {
    private Asset asset;
    private IContextCreate contextCreate;
    private CMTimeRange timeRange;
    private AVAssetReaderStatus status = AVAssetReaderStatus.AssetReaderStatusUnknown;
    private String errMsg = "";
    private List<AssetReaderOutput> outputs = new ArrayList();
    private HashMap<AssetReaderOutput, AVAssetReaderStatus> outputStatusHashMap = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum AVAssetReaderStatus {
        AssetReaderStatusUnknown,
        AssetReaderStatusReading,
        AssetReaderStatusCompleted,
        AssetReaderStatusFailed,
        AssetReaderStatusCancelled
    }

    public AssetReader(Asset asset) {
        this.asset = asset;
    }

    private void updateAssetStatus() {
        boolean z16;
        Iterator<AssetReaderOutput> it = this.outputs.iterator();
        boolean z17 = true;
        while (true) {
            boolean z18 = false;
            if (!it.hasNext()) {
                break;
            }
            if (this.outputStatusHashMap.get(it.next()) == AVAssetReaderStatus.AssetReaderStatusCompleted) {
                z18 = true;
            }
            z17 &= z18;
        }
        if (z17) {
            this.status = AVAssetReaderStatus.AssetReaderStatusCompleted;
            return;
        }
        boolean z19 = true;
        for (AssetReaderOutput assetReaderOutput : this.outputs) {
            if (this.outputStatusHashMap.get(assetReaderOutput) != AVAssetReaderStatus.AssetReaderStatusReading && this.outputStatusHashMap.get(assetReaderOutput) != AVAssetReaderStatus.AssetReaderStatusCompleted) {
                z16 = false;
            } else {
                z16 = true;
            }
            z19 &= z16;
        }
        if (z19) {
            this.status = AVAssetReaderStatus.AssetReaderStatusReading;
            return;
        }
        Iterator<AssetReaderOutput> it5 = this.outputs.iterator();
        while (it5.hasNext()) {
            AVAssetReaderStatus aVAssetReaderStatus = this.outputStatusHashMap.get(it5.next());
            AVAssetReaderStatus aVAssetReaderStatus2 = AVAssetReaderStatus.AssetReaderStatusFailed;
            if (aVAssetReaderStatus == aVAssetReaderStatus2) {
                this.status = aVAssetReaderStatus2;
                return;
            }
        }
        Iterator<AssetReaderOutput> it6 = this.outputs.iterator();
        while (it6.hasNext()) {
            AVAssetReaderStatus aVAssetReaderStatus3 = this.outputStatusHashMap.get(it6.next());
            AVAssetReaderStatus aVAssetReaderStatus4 = AVAssetReaderStatus.AssetReaderStatusCancelled;
            if (aVAssetReaderStatus3 == aVAssetReaderStatus4) {
                this.status = aVAssetReaderStatus4;
                return;
            }
        }
    }

    public void addOutput(AssetReaderOutput assetReaderOutput) {
        if (canAddOutput(assetReaderOutput)) {
            this.outputs.add(assetReaderOutput);
        }
    }

    public boolean canAddOutput(AssetReaderOutput assetReaderOutput) {
        if (assetReaderOutput != null && !this.outputs.contains(assetReaderOutput)) {
            return true;
        }
        return false;
    }

    public void cancelReading() {
        for (AssetReaderOutput assetReaderOutput : this.outputs) {
            this.outputStatusHashMap.put(assetReaderOutput, AVAssetReaderStatus.AssetReaderStatusCancelled);
            assetReaderOutput.release();
        }
        updateAssetStatus();
    }

    public Asset getAsset() {
        return this.asset;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public List<AssetReaderOutput> getOutputs() {
        return this.outputs;
    }

    public AVAssetReaderStatus getStatus() {
        return this.status;
    }

    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    public void setTimeRange(CMTimeRange cMTimeRange) {
        this.timeRange = cMTimeRange;
    }

    public boolean startReading(IContextCreate iContextCreate) {
        this.contextCreate = iContextCreate;
        for (AssetReaderOutput assetReaderOutput : this.outputs) {
            this.outputStatusHashMap.put(assetReaderOutput, AVAssetReaderStatus.AssetReaderStatusReading);
            if (assetReaderOutput.mediaType == 1) {
                assetReaderOutput.start(iContextCreate, this);
            } else {
                assetReaderOutput.start(null, this);
            }
            assetReaderOutput.addStatusListener(this);
        }
        updateAssetStatus();
        if (this.outputs.size() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tav.core.AssetReaderOutput.StatusListener
    public void statusChanged(AssetReaderOutput assetReaderOutput, AVAssetReaderStatus aVAssetReaderStatus) {
        this.outputStatusHashMap.put(assetReaderOutput, aVAssetReaderStatus);
        updateAssetStatus();
    }
}
