package com.qzone.reborn.layer.part;

import android.os.Handler;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ca extends ad {
    @Override // com.qzone.reborn.layer.part.ad
    protected void V9(Handler handler) {
        String str;
        PhotoInfo photoInfo = this.f57984d;
        uk.j jVar = (uk.j) getViewModel(uk.j.class);
        if (photoInfo == null || this.f57988i == null || jVar == null || jVar.W1() == null) {
            return;
        }
        if (photoInfo.busi_param == null) {
            photoInfo.busi_param = new HashMap();
        }
        photoInfo.busi_param.put(20, this.f57988i.feedId);
        QZoneFeedxPictureManager qZoneFeedxPictureManager = QZoneFeedxPictureManager.getInstance();
        QZoneInteractPhotoRequestBuilder ugcKey = new QZoneInteractPhotoRequestBuilder().setUgcKey(this.f57988i.feedId);
        PhotoParam photoParam = this.f57988i;
        if (photoParam.isSharedFeeds) {
            str = photoParam.orgKey;
        } else {
            str = photoParam.curKey;
        }
        qZoneFeedxPictureManager.praisePhoto(handler, ugcKey.setCurKey(str).setUniKey(this.f57988i.orgKey).setIsLike(photoInfo.hasPraise).setOwnerUin(this.f57988i.ownerUin).setAppId(this.f57988i.appid).setExtraInfoMap(this.f57988i.busi_param).setIsTodayInHisFeed(false).setSyn(1).setClickScene(1).setIndex(this.C));
    }

    @Override // com.qzone.reborn.layer.part.ad
    protected void N9(PhotoInfo photoInfo) {
        PhotoParam photoParam;
        if (photoInfo == null || (photoParam = this.f57988i) == null) {
            return;
        }
        boolean z16 = photoParam.isLike;
        if (!z16) {
            photoParam.likeNum++;
            photoInfo.praiseCount++;
        } else {
            photoParam.likeNum--;
            photoInfo.praiseCount--;
        }
        photoParam.isLike = !z16;
        photoInfo.hasPraise = !z16;
    }
}
