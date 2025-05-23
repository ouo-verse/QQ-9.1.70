package com.tencent.qqlive.tvkplayer.api.asset;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKAssetFactory {
    public static TVKAfdAsset createAfdAsset(@NonNull AssetFileDescriptor assetFileDescriptor) {
        return new TVKAfdAsset(assetFileDescriptor);
    }

    public static TVKLivePidAsset createLivePidAsset(@NonNull String str, @Nullable String str2) {
        return new TVKLivePidAsset(str, str2);
    }

    public static TVKLiveSidAsset createLiveSidAsset(@NonNull String str, @Nullable String str2) {
        return new TVKLiveSidAsset(str, str2);
    }

    public static TVKOfflineVodVidAsset createOfflineVodVidAsset(String str, String str2, int i3) {
        return new TVKOfflineVodVidAsset(str, str2, i3);
    }

    public static TVKOnlineSimulatedLiveAsset createOnlineSimulatedLiveAsset(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        return new TVKOnlineSimulatedLiveAsset(str, str2, str3);
    }

    public static TVKOnlineVodQuickPlayAsset createOnlineVodQuickPlayAsset(String str, String str2) {
        return new TVKOnlineVodQuickPlayAsset(str, str2);
    }

    public static TVKOnlineVodVidAsset createOnlineVodVidAsset(String str, String str2) {
        return new TVKOnlineVodVidAsset(str, str2);
    }

    public static TVKOnlineVodXmlAsset createOnlineVodXmlAsset(@NonNull String str) {
        return new TVKOnlineVodXmlAsset(str, "", "");
    }

    public static TVKPfdAsset createPfdAsset(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        return new TVKPfdAsset(parcelFileDescriptor);
    }

    public static TVKUrlAsset createUrlAsset(@NonNull String str) {
        return new TVKUrlAsset(str);
    }

    public static TVKOnlineVodXmlAsset createOnlineVodXmlAsset(@NonNull String str, String str2, String str3) {
        return new TVKOnlineVodXmlAsset(str, str2, str3);
    }
}
