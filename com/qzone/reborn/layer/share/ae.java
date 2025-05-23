package com.qzone.reborn.layer.share;

import android.app.Activity;
import com.qzone.business.share.ShareUtils;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ae extends af {
    public ae(Activity activity) {
        super(activity);
    }

    @Override // com.qzone.reborn.layer.share.c
    protected void G(f fVar) {
        PhotoInfo photoInfo = fVar.f58179c;
        PhotoParam photoParam = fVar.f58180d;
        if (photoInfo == null || photoParam == null) {
            return;
        }
        HashMap<Integer, String> hashMap = new HashMap<>(1);
        hashMap.put(1, photoInfo.bigUrl);
        hashMap.put(2, "0");
        hashMap.put(10, "1");
        R(photoInfo, photoParam, hashMap);
    }

    @Override // com.qzone.reborn.layer.share.af
    protected int O(f fVar) {
        return ShareUtils.b(com.qzone.preview.d.d(fVar.f58180d), this.f58109d.shareSpaceRight, this.f58110e.videoUgcRight, true);
    }

    @Override // com.qzone.reborn.layer.share.af
    protected void R(PhotoInfo photoInfo, PhotoParam photoParam, HashMap<Integer, String> hashMap) {
        if (photoInfo == null || photoParam == null) {
            return;
        }
        QZoneFeedxPictureManager qZoneFeedxPictureManager = QZoneFeedxPictureManager.getInstance();
        QZoneInteractPhotoRequestBuilder iisShareTo = new QZoneInteractPhotoRequestBuilder().setAppId(photoInfo.appid).setUgcType(-1).setCellId(H(photoInfo)).setAlbumId(photoInfo.albumId).setLloc(photoInfo.lloc).setBatchId(photoParam.busi_param.get(21)).setIisShareTo(0);
        long j3 = photoParam.ownerUin;
        if (j3 == 0) {
            j3 = photoInfo.uploaduin;
        }
        qZoneFeedxPictureManager.getOutShareUrl(iisShareTo.setOwnerUin(j3).setExtraInfoMap(hashMap), r());
    }
}
