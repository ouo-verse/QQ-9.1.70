package com.tencent.biz.qqcircle.immersive.personal.bean;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;

/* loaded from: classes4.dex */
public class QFSPersonalCollectBoxDetailBean extends QCircleInitBean {

    /* renamed from: d, reason: collision with root package name */
    private transient FeedCloudFavoritessvr$FavoritesInfo f88413d;
    private byte[] mFavoritesInfoByte;

    public FeedCloudFavoritessvr$FavoritesInfo getFavoritesInfo() {
        if (this.f88413d == null) {
            FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo = new FeedCloudFavoritessvr$FavoritesInfo();
            this.f88413d = feedCloudFavoritessvr$FavoritesInfo;
            try {
                this.f88413d = feedCloudFavoritessvr$FavoritesInfo.mergeFrom(this.mFavoritesInfoByte);
            } catch (Exception e16) {
                QLog.e("QFSPersonalCollectBoxDetailBean", 1, "invalid favoritesInfoByte bytes", e16);
            }
        }
        return this.f88413d;
    }

    public void setFavoritesInfo(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo) {
        this.f88413d = feedCloudFavoritessvr$FavoritesInfo;
        this.mFavoritesInfoByte = feedCloudFavoritessvr$FavoritesInfo.toByteArray();
    }
}
