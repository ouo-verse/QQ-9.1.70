package com.tencent.thumbplayer.asset;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPMediaAssetObjectParam;
import com.tencent.thumbplayer.api.resourceloader.ITPResourceLoader;
import com.tencent.thumbplayer.common.TPStringUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public abstract class TPMediaAsset implements ITPMediaAsset {
    private static final int LINE_LENGTH_LIMIT = 4096;
    private static final int PARAM_LENGTH_LIMIT = 256;
    private ITPResourceLoader mCoreResourceLoader;
    private ITPResourceLoader mUserResourceLoader;
    private final Map<String, String> mStringParamMap = new HashMap();
    private final Map<String, ITPMediaAssetObjectParam> mObjectParamMap = new HashMap();

    private String dumpParam(Map<String, ?> map) {
        String obj;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[");
        String str = "";
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            Object value = entry.getValue();
            sb5.append(str);
            sb5.append(entry.getKey());
            sb5.append(MsgSummary.STR_COLON);
            if (value == null) {
                obj = null;
            } else {
                obj = value.toString();
            }
            sb5.append(TPStringUtils.truncate(obj, 256));
            str = "; ";
        }
        sb5.append("]");
        return sb5.toString();
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public abstract int getAssetType();

    public ITPResourceLoader getCoreResourceLoader() {
        return this.mCoreResourceLoader;
    }

    public ITPMediaAssetObjectParam getObjectParam(String str) {
        return this.mObjectParamMap.get(str);
    }

    public Map<String, ITPMediaAssetObjectParam> getObjectParamMap() {
        return Collections.unmodifiableMap(this.mObjectParamMap);
    }

    public String getParam(String str, String str2) {
        String str3 = this.mStringParamMap.get(str);
        if (str3 != null) {
            return str3;
        }
        return str2;
    }

    public Map<String, String> getParamMap() {
        return Collections.unmodifiableMap(this.mStringParamMap);
    }

    public ITPResourceLoader getResourceLoader() {
        return this.mUserResourceLoader;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public abstract boolean isValid();

    public void setCoreResourceLoader(@NonNull ITPResourceLoader iTPResourceLoader) {
        this.mCoreResourceLoader = iTPResourceLoader;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public void setObjectParam(String str, ITPMediaAssetObjectParam iTPMediaAssetObjectParam) {
        this.mObjectParamMap.put(str, iTPMediaAssetObjectParam);
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public void setParam(String str, String str2) {
        this.mStringParamMap.put(str, str2);
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public void setResourceLoader(@NonNull ITPResourceLoader iTPResourceLoader) {
        this.mUserResourceLoader = iTPResourceLoader;
    }

    public String toString() {
        return TPStringUtils.wrap("TPMediaAsset, userResourceLoader=" + this.mUserResourceLoader + ", coreResourceLoader=" + this.mCoreResourceLoader + ", stringParam=" + dumpParam(this.mStringParamMap) + ", objectParam=" + dumpParam(this.mObjectParamMap), 4096);
    }
}
