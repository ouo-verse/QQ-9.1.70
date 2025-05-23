package com.tencent.qqlive.tvkplayer.richmedia.utils;

import com.tencent.qqlive.tvkplayer.api.richmedia.response.TVKRichMediaFeatureData;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaData;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKRichMediaDataConverter {
    public static TVKRichMediaFeatureData convertToTVKRichMediaFeatureData(TPRichMediaData tPRichMediaData) {
        if (tPRichMediaData != null && tPRichMediaData.getContentList() != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<TPRichMediaData.TPRichMediaContent> it = tPRichMediaData.getContentList().iterator();
            while (it.hasNext()) {
                TPRichMediaData.TPRichMediaContent next = it.next();
                arrayList.add(new TVKRichMediaFeatureData.TVKRichMediaContent(next.getTimeRange().getStartTimeMs(), next.getTimeRange().getEndTimeMs(), next.getContent()));
            }
            return new TVKRichMediaFeatureData(tPRichMediaData.getFeatureType(), tPRichMediaData.getEnv(), tPRichMediaData.getVersion(), arrayList);
        }
        return null;
    }
}
