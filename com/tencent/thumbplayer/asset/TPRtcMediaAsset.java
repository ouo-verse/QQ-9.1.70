package com.tencent.thumbplayer.asset;

import android.text.TextUtils;
import com.tencent.thumbplayer.api.asset.ITPRtcMediaAsset;

/* loaded from: classes26.dex */
public class TPRtcMediaAsset extends TPUrlMediaAsset implements ITPRtcMediaAsset {
    private ITPRtcMediaAsset.ITPRtcSdpExchangeListener mExchangeListener;
    private int mExchangeMode;
    private String mSdpServerUrl;

    public TPRtcMediaAsset(String str) {
        super(str);
        this.mExchangeMode = 0;
    }

    @Override // com.tencent.thumbplayer.asset.TPUrlMediaAsset, com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public int getAssetType() {
        return 4;
    }

    public ITPRtcMediaAsset.ITPRtcSdpExchangeListener getSdpExchangeListener() {
        return this.mExchangeListener;
    }

    public int getSdpExchangeMode() {
        return this.mExchangeMode;
    }

    public String getSdpServerUrl() {
        return this.mSdpServerUrl;
    }

    @Override // com.tencent.thumbplayer.asset.TPUrlMediaAsset, com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public boolean isValid() {
        if (!super.isValid()) {
            return false;
        }
        int i3 = this.mExchangeMode;
        if ((i3 == 0 || i3 == 1) && TextUtils.isEmpty(this.mSdpServerUrl)) {
            return false;
        }
        if (this.mExchangeMode == 2 && this.mExchangeListener == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPRtcMediaAsset
    public void setSdpExchangeListener(ITPRtcMediaAsset.ITPRtcSdpExchangeListener iTPRtcSdpExchangeListener) {
        this.mExchangeListener = iTPRtcSdpExchangeListener;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPRtcMediaAsset
    public void setSdpExchangeMode(int i3) {
        this.mExchangeMode = i3;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPRtcMediaAsset
    public void setSdpServerUrl(String str) {
        this.mSdpServerUrl = str;
    }

    @Override // com.tencent.thumbplayer.asset.TPUrlMediaAsset, com.tencent.thumbplayer.asset.TPMediaAsset
    public String toString() {
        return "TPRtcMediaAsset(" + super.toString() + ")\nsdpServerUrl=" + this.mSdpServerUrl + "\nsdpExchangeMode=" + this.mExchangeMode;
    }
}
