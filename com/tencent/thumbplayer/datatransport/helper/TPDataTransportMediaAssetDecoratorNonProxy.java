package com.tencent.thumbplayer.datatransport.helper;

import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.asset.TPAfdMediaAsset;
import com.tencent.thumbplayer.asset.TPDrmMediaAsset;
import com.tencent.thumbplayer.asset.TPMediaAsset;
import com.tencent.thumbplayer.asset.TPMultiMediaAsset;
import com.tencent.thumbplayer.asset.TPPfdMediaAsset;
import com.tencent.thumbplayer.asset.TPRtcMediaAsset;
import com.tencent.thumbplayer.asset.TPUrlMediaAsset;
import java.util.Iterator;

/* loaded from: classes26.dex */
public class TPDataTransportMediaAssetDecoratorNonProxy {
    @Nullable
    public static ITPMediaAsset decorateMediaAsset(ITPMediaAsset iTPMediaAsset) {
        if ((iTPMediaAsset instanceof TPMediaAsset) && ((TPMediaAsset) iTPMediaAsset).getResourceLoader() != null) {
            return null;
        }
        if (!(iTPMediaAsset instanceof TPAfdMediaAsset) && !(iTPMediaAsset instanceof TPPfdMediaAsset)) {
            if (iTPMediaAsset instanceof TPRtcMediaAsset) {
                TPRtcMediaAsset tPRtcMediaAsset = (TPRtcMediaAsset) iTPMediaAsset;
                tPRtcMediaAsset.setSystemMediaPlayerUrl(tPRtcMediaAsset.getUrl());
                tPRtcMediaAsset.setSelfDevPlayerUrl(tPRtcMediaAsset.getUrl());
                return iTPMediaAsset;
            }
            if (iTPMediaAsset instanceof TPDrmMediaAsset) {
                TPDrmMediaAsset tPDrmMediaAsset = (TPDrmMediaAsset) iTPMediaAsset;
                tPDrmMediaAsset.setSystemMediaPlayerUrl(tPDrmMediaAsset.getUrl());
                tPDrmMediaAsset.setSelfDevPlayerUrl(tPDrmMediaAsset.getUrl());
                return iTPMediaAsset;
            }
            if (iTPMediaAsset instanceof TPUrlMediaAsset) {
                TPUrlMediaAsset tPUrlMediaAsset = (TPUrlMediaAsset) iTPMediaAsset;
                tPUrlMediaAsset.setSystemMediaPlayerUrl(tPUrlMediaAsset.getUrl());
                tPUrlMediaAsset.setSelfDevPlayerUrl(tPUrlMediaAsset.getUrl());
                return iTPMediaAsset;
            }
            if (iTPMediaAsset instanceof TPMultiMediaAsset) {
                Iterator<Pair<ITPMediaAsset, Long>> it = ((TPMultiMediaAsset) iTPMediaAsset).getAssetAndClipDurationMsPairList().iterator();
                while (it.hasNext()) {
                    ITPMediaAsset iTPMediaAsset2 = it.next().first;
                    if (iTPMediaAsset2 instanceof TPUrlMediaAsset) {
                        TPUrlMediaAsset tPUrlMediaAsset2 = (TPUrlMediaAsset) iTPMediaAsset2;
                        tPUrlMediaAsset2.setSystemMediaPlayerUrl(tPUrlMediaAsset2.getUrl());
                        tPUrlMediaAsset2.setSelfDevPlayerUrl(tPUrlMediaAsset2.getUrl());
                    }
                }
            }
        }
        return iTPMediaAsset;
    }
}
