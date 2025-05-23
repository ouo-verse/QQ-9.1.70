package com.qzone.proxy.covercomponent;

import cooperation.qzone.model.CoverCacheData;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface ICoverComponentService {
    CoverCacheData fillVideoCoverDataWithLocalData(CoverCacheData coverCacheData, String str, String str2, String str3, int i3, int i16, long j3, String str4, String str5);

    CoverCacheData getCoverFromCache(long j3);

    void getCoverPreviewPictureUrl(CoverCacheData coverCacheData, IOnPictrueLoadListener iOnPictrueLoadListener);

    String getDefaultCover();

    String getRightCoverUrl(CoverCacheData coverCacheData);

    CoverCacheData getRollbackCover(String str);

    int getSuperCoverTrans(long j3);

    CoverCacheData handleLocalVideoCover(CoverCacheData coverCacheData);

    boolean isFakeCover(CoverCacheData coverCacheData);

    boolean isFullScreenCover(CoverCacheData coverCacheData);

    boolean isVideoCoverHanding(CoverCacheData coverCacheData);

    boolean isWebviewLikeCover(CoverCacheData coverCacheData);

    CoverCacheData parseCoverJceJson(JSONObject jSONObject) throws JSONException;

    @Deprecated
    void rollbackCover(String str);

    void saveCoverIntoCache(CoverCacheData coverCacheData);

    void setLoginUserCoverUrl(String str);
}
