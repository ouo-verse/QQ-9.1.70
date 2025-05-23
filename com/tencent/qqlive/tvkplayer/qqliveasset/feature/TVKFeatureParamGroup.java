package com.tencent.qqlive.tvkplayer.qqliveasset.feature;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes23.dex */
public class TVKFeatureParamGroup implements ITVKFeatureParamGroup {
    private ArrayList<ITVKFeatureBase.ITVKFeatureParam> mFeatureParamList = new ArrayList<>();

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup
    public void addFeatureParam(@NonNull ITVKFeatureBase.ITVKFeatureParam iTVKFeatureParam) {
        this.mFeatureParamList.add(iTVKFeatureParam);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup
    public <T extends ITVKFeatureBase.ITVKFeatureParam> T getFeatureParamByClass(@NonNull Class<T> cls) {
        if (this.mFeatureParamList.isEmpty()) {
            return null;
        }
        Iterator<ITVKFeatureBase.ITVKFeatureParam> it = this.mFeatureParamList.iterator();
        while (it.hasNext()) {
            T t16 = (T) it.next();
            if (cls.isInstance(t16)) {
                return t16;
            }
        }
        return null;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup
    public void removeAllFeatureParam() {
        this.mFeatureParamList.clear();
    }
}
