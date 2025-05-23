package com.tencent.thumbplayer.asset;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.asset.ITPMediaAssetParamMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPMediaAssetParamMap implements ITPMediaAssetParamMap {
    private final Map<String, String> mParamInsertOrderMap = new LinkedHashMap();

    @Override // com.tencent.thumbplayer.api.asset.ITPMediaAssetParamMap
    public void add(@NonNull String str, @NonNull String str2) {
        synchronized (this.mParamInsertOrderMap) {
            this.mParamInsertOrderMap.remove(str);
            this.mParamInsertOrderMap.put(str, str2);
        }
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPMediaAssetParamMap
    public Map<String, String> getParamMap() {
        LinkedHashMap linkedHashMap;
        synchronized (this.mParamInsertOrderMap) {
            linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(this.mParamInsertOrderMap);
        }
        return linkedHashMap;
    }
}
