package com.qzone.reborn.layer.part;

import android.os.Handler;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import cooperation.qzone.model.PhotoInfo;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aw extends ad {
    @Override // com.qzone.reborn.layer.part.ad
    protected void V9(Handler handler) {
        PhotoInfo photoInfo = this.f57984d;
        uk.d dVar = (uk.d) getViewModel(uk.d.class);
        if (photoInfo == null || dVar == null || dVar.W1() == null) {
            return;
        }
        if (photoInfo.busi_param == null) {
            photoInfo.busi_param = new HashMap();
        }
        photoInfo.busi_param.put(12, photoInfo.albumId);
        photoInfo.busi_param.put(1, photoInfo.sloc);
        photoInfo.busi_param.put(15, photoInfo.bigUrl);
        QZoneFeedxPictureManager.getInstance().praisePhoto(handler, new QZoneInteractPhotoRequestBuilder().setUgcKey(dVar.W1().feedId).setCurKey(photoInfo.curkey).setUniKey(photoInfo.unikey).setIsLike(photoInfo.hasPraise).setAppId(dVar.W1().appid).setExtraInfoMap(photoInfo.busi_param).setIndex(this.C));
    }
}
