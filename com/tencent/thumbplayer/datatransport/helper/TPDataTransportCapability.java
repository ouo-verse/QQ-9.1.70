package com.tencent.thumbplayer.datatransport.helper;

import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.asset.TPAfdMediaAsset;
import com.tencent.thumbplayer.asset.TPMediaAsset;
import com.tencent.thumbplayer.asset.TPMultiMediaAsset;
import com.tencent.thumbplayer.asset.TPPfdMediaAsset;
import com.tencent.thumbplayer.asset.TPRtcMediaAsset;
import com.tencent.thumbplayer.asset.TPUrlMediaAsset;
import com.tencent.thumbplayer.common.TPUrlAnalyzer;
import java.util.Iterator;

/* loaded from: classes26.dex */
public class TPDataTransportCapability {
    public static boolean isMediaAssetSupported(@NonNull ITPMediaAsset iTPMediaAsset) {
        if ((iTPMediaAsset instanceof TPAfdMediaAsset) || (iTPMediaAsset instanceof TPPfdMediaAsset) || (iTPMediaAsset instanceof TPRtcMediaAsset)) {
            return false;
        }
        if ((iTPMediaAsset instanceof TPMediaAsset) && ((TPMediaAsset) iTPMediaAsset).getResourceLoader() != null) {
            return true;
        }
        if ((iTPMediaAsset instanceof TPUrlMediaAsset) && !TPUrlAnalyzer.isOnlineVideoPlayUrl(((TPUrlMediaAsset) iTPMediaAsset).getUrl())) {
            return false;
        }
        if (!(iTPMediaAsset instanceof TPMultiMediaAsset)) {
            return true;
        }
        Iterator<Pair<ITPMediaAsset, Long>> it = ((TPMultiMediaAsset) iTPMediaAsset).getAssetAndClipDurationMsPairList().iterator();
        while (it.hasNext()) {
            ITPMediaAsset iTPMediaAsset2 = it.next().first;
            if ((iTPMediaAsset2 instanceof TPUrlMediaAsset) && TPUrlAnalyzer.isOnlineVideoPlayUrl(((TPUrlMediaAsset) iTPMediaAsset2).getUrl())) {
                return true;
            }
            if ((iTPMediaAsset2 instanceof TPMediaAsset) && ((TPMediaAsset) iTPMediaAsset2).getResourceLoader() != null) {
                return true;
            }
        }
        return false;
    }
}
