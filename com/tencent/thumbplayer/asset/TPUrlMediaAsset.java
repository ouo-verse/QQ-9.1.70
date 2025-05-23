package com.tencent.thumbplayer.asset;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes26.dex */
public class TPUrlMediaAsset extends TPMediaAsset implements ITPUrlMediaAsset {
    private static final String TAG = "TPUrlMediaAsset";
    private String mHttpVerificationCode;
    private String mSelfDevPlayerUrl;
    private String mSystemPlayerUrl;
    private String mUrl;
    private final Map<String, String> mHttpHeaderMap = new HashMap();
    private final List<Pair<String, Map<String, String>>> mBackUrlAndHttpHeaderPairList = new CopyOnWriteArrayList();

    public TPUrlMediaAsset(String str) {
        this.mUrl = str;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset
    public void addBackUrl(String str) {
        addBackUrl(str, null);
    }

    @Override // com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public int getAssetType() {
        return 3;
    }

    @NonNull
    public List<Pair<String, Map<String, String>>> getBackUrlAndHttpHeaderPairList() {
        return Collections.unmodifiableList(this.mBackUrlAndHttpHeaderPairList);
    }

    @NonNull
    public Map<String, String> getHttpHeader() {
        return this.mHttpHeaderMap;
    }

    public String getHttpVerificationCode() {
        return this.mHttpVerificationCode;
    }

    public String getSelfDevPlayerUrl() {
        if (TextUtils.isEmpty(this.mSelfDevPlayerUrl)) {
            return this.mUrl;
        }
        return this.mSelfDevPlayerUrl;
    }

    public String getSystemMediaPlayerUrl() {
        if (TextUtils.isEmpty(this.mSystemPlayerUrl)) {
            return this.mUrl;
        }
        return this.mSystemPlayerUrl;
    }

    @Nullable
    public String getUrl() {
        return this.mUrl;
    }

    @Override // com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public boolean isValid() {
        return !TextUtils.isEmpty(this.mUrl);
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset
    public void setHttpHeader(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.mHttpHeaderMap.putAll(map);
        }
    }

    public void setHttpVerificationCode(String str) {
        this.mHttpVerificationCode = str;
    }

    public void setSelfDevPlayerUrl(String str) {
        this.mSelfDevPlayerUrl = str;
    }

    public void setSystemMediaPlayerUrl(String str) {
        this.mSystemPlayerUrl = str;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset
    public void setUrl(String str) {
        setUrl(str, null);
    }

    @Override // com.tencent.thumbplayer.asset.TPMediaAsset
    public String toString() {
        return "TPUrlMediaAsset(" + super.toString() + ")\nurl=" + this.mUrl + "\nhttpHeader=" + this.mHttpHeaderMap + "\nbackUrlAndHttpHeaderList=" + this.mBackUrlAndHttpHeaderPairList + "\nselfDevPlayerUrl=" + this.mSelfDevPlayerUrl + "\nsystemPlayerUrl=" + this.mSystemPlayerUrl;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset
    public void addBackUrl(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            TPLogUtil.w(TAG, "addBackUrl failed, url is empty");
        } else {
            this.mBackUrlAndHttpHeaderPairList.add(new Pair<>(str, map));
        }
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset
    public void setUrl(String str, Map<String, String> map) {
        this.mUrl = str;
        if (map == null || map.isEmpty()) {
            return;
        }
        this.mHttpHeaderMap.putAll(map);
    }
}
