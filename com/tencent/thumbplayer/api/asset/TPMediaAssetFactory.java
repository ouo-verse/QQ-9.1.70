package com.tencent.thumbplayer.api.asset;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.asset.ITPSimulatedLiveMediaAsset;
import com.tencent.thumbplayer.asset.TPAfdMediaAsset;
import com.tencent.thumbplayer.asset.TPDrmMediaAsset;
import com.tencent.thumbplayer.asset.TPMediaAssetParamMap;
import com.tencent.thumbplayer.asset.TPMultiMediaAsset;
import com.tencent.thumbplayer.asset.TPPfdMediaAsset;
import com.tencent.thumbplayer.asset.TPRtcMediaAsset;
import com.tencent.thumbplayer.asset.TPSimulatedLiveMediaAsset;
import com.tencent.thumbplayer.asset.TPUrlMediaAsset;

/* loaded from: classes26.dex */
public class TPMediaAssetFactory {
    @NonNull
    public static ITPAfdMediaAsset createAfdMediaAsset(@NonNull AssetFileDescriptor assetFileDescriptor) {
        return new TPAfdMediaAsset(assetFileDescriptor);
    }

    @NonNull
    public static ITPDrmMediaAsset createDrmMediaAsset(@NonNull String str, int i3) {
        return createDrmMediaAsset(str, i3, null, null);
    }

    @NonNull
    public static ITPMediaAssetParamMap createMediaAssetParamMap() {
        return new TPMediaAssetParamMap();
    }

    @NonNull
    public static ITPMultiMediaAsset createMultiMediaAsset() {
        return new TPMultiMediaAsset();
    }

    @NonNull
    public static ITPPfdMediaAsset createPfdMediaAsset(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        return new TPPfdMediaAsset(parcelFileDescriptor);
    }

    @NonNull
    public static ITPRtcMediaAsset createRtcMediaAsset(@NonNull String str) {
        return new TPRtcMediaAsset(str);
    }

    @NonNull
    public static ITPSimulatedLiveMediaAsset createSimulatedLiveMediaAsset(ITPMediaAsset iTPMediaAsset, ITPSimulatedLiveMediaAsset.ITPSimulatedLiveListener iTPSimulatedLiveListener) {
        TPSimulatedLiveMediaAsset tPSimulatedLiveMediaAsset = new TPSimulatedLiveMediaAsset();
        tPSimulatedLiveMediaAsset.setStartAsset(iTPMediaAsset);
        tPSimulatedLiveMediaAsset.setSimulatedLiveListener(iTPSimulatedLiveListener);
        return tPSimulatedLiveMediaAsset;
    }

    @NonNull
    public static ITPUrlMediaAsset createUrlMediaAsset(@NonNull String str) {
        return new TPUrlMediaAsset(str);
    }

    @NonNull
    public static ITPDrmMediaAsset createDrmMediaAsset(@NonNull String str, int i3, String str2, String str3) {
        TPDrmMediaAsset tPDrmMediaAsset = new TPDrmMediaAsset(str, i3);
        tPDrmMediaAsset.setCertificateUrl(str2);
        tPDrmMediaAsset.setLicenseUrl(str3);
        return tPDrmMediaAsset;
    }
}
