package com.tencent.superplayer.utils;

import android.text.TextUtils;
import com.tencent.qqlive.superplayer.vinfo.TVKVideoInfo;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPMultiMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset;
import com.tencent.thumbplayer.api.asset.TPMediaAssetFactory;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f {
    public static ITPMediaAsset a(SuperPlayerVideoInfo superPlayerVideoInfo, Map<String, String> map) {
        if (superPlayerVideoInfo.getFormat() == 303) {
            ArrayList<TVKVideoInfo.Section> tVideoSectionList = superPlayerVideoInfo.getTVideoSectionList();
            ITPMultiMediaAsset createMultiMediaAsset = TPMediaAssetFactory.createMultiMediaAsset();
            for (int i3 = 0; i3 < tVideoSectionList.size(); i3++) {
                TVKVideoInfo.Section section = tVideoSectionList.get(i3);
                String url = section.getUrl();
                if (!TextUtils.isEmpty(url)) {
                    ITPUrlMediaAsset createUrlMediaAsset = TPMediaAssetFactory.createUrlMediaAsset(url);
                    createUrlMediaAsset.setHttpHeader(map);
                    createUrlMediaAsset.setParam("dl_param_file_size", String.valueOf(section.getSize()));
                    createUrlMediaAsset.setParam("dl_param_file_duration", String.valueOf(section.getDuration() * 1000.0d));
                    createUrlMediaAsset.setParam("dl_param_play_clip_no", String.valueOf(section.getIdx()));
                    createUrlMediaAsset.setParam("dl_param_play_clip_count", String.valueOf(tVideoSectionList.size()));
                    createUrlMediaAsset.setParam("dl_param_play_clip_keyid", section.getVbkeyId());
                    createMultiMediaAsset.addAsset(createUrlMediaAsset, (long) (section.getDuration() * 1000.0d));
                } else {
                    throw new IllegalArgumentException("generateClipMp4MediaAsset: url of section " + i3 + " is empty");
                }
            }
            return createMultiMediaAsset;
        }
        return null;
    }
}
