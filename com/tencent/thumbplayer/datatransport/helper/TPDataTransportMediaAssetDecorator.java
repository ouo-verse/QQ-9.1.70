package com.tencent.thumbplayer.datatransport.helper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.asset.TPMultiMediaAsset;
import com.tencent.thumbplayer.asset.TPUrlMediaAsset;
import java.util.List;

/* loaded from: classes26.dex */
public class TPDataTransportMediaAssetDecorator {
    @Nullable
    public static ITPMediaAsset decorateMediaAsset(@NonNull ITPMediaAsset iTPMediaAsset, @Nullable List<String> list, @Nullable List<String> list2, @NonNull String str, @Nullable String str2) {
        if (iTPMediaAsset instanceof TPMultiMediaAsset) {
            return decorateMultiMediaAsset((TPMultiMediaAsset) iTPMediaAsset, list, list2, str, str2);
        }
        if (iTPMediaAsset instanceof TPUrlMediaAsset) {
            return decorateUrlMediaAsset((TPUrlMediaAsset) iTPMediaAsset, list, list2, str, str2);
        }
        return null;
    }

    @Nullable
    private static ITPMediaAsset decorateMultiMediaAsset(@NonNull TPMultiMediaAsset tPMultiMediaAsset, @Nullable List<String> list, @Nullable List<String> list2, @NonNull String str, @Nullable String str2) {
        String str3;
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        if (list != null && list.size() != list2.size()) {
            return null;
        }
        for (int i3 = 0; i3 < list2.size(); i3++) {
            ITPMediaAsset iTPMediaAsset = null;
            int i16 = i3;
            while (!(iTPMediaAsset instanceof TPUrlMediaAsset)) {
                iTPMediaAsset = tPMultiMediaAsset.getAssetAndClipDurationMsPairList().get(i16).first;
                i16++;
            }
            if (list != null) {
                str3 = list.get(i3);
            } else {
                str3 = list2.get(i3);
            }
            String str4 = list2.get(i3);
            TPUrlMediaAsset tPUrlMediaAsset = (TPUrlMediaAsset) iTPMediaAsset;
            tPUrlMediaAsset.setSystemMediaPlayerUrl(str3);
            tPUrlMediaAsset.setSelfDevPlayerUrl(str4);
            tPUrlMediaAsset.setParam(ITPMediaAsset.TP_ASSET_PARAM_KEY_STRING_OPAQUE, str);
            tPUrlMediaAsset.setHttpVerificationCode(str2);
        }
        return tPMultiMediaAsset;
    }

    @Nullable
    private static ITPMediaAsset decorateUrlMediaAsset(@NonNull TPUrlMediaAsset tPUrlMediaAsset, @Nullable List<String> list, @Nullable List<String> list2, @NonNull String str, @Nullable String str2) {
        String str3;
        if (list2 != null && !list2.isEmpty() && list2.get(0) != null) {
            if (list != null && list.size() > 0 && list.get(0) != null) {
                str3 = list.get(0);
            } else {
                str3 = list2.get(0);
            }
            tPUrlMediaAsset.setSystemMediaPlayerUrl(list2.get(0));
            tPUrlMediaAsset.setSelfDevPlayerUrl(str3);
            tPUrlMediaAsset.setParam(ITPMediaAsset.TP_ASSET_PARAM_KEY_STRING_OPAQUE, str);
            tPUrlMediaAsset.setHttpVerificationCode(str2);
            return tPUrlMediaAsset;
        }
        return null;
    }
}
