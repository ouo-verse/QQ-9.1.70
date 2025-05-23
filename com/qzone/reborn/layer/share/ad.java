package com.qzone.reborn.layer.share;

import android.app.Activity;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.model.VideoInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ad extends QZoneShareWXFriendAction {
    public ad(Activity activity) {
        super(activity);
    }

    @Override // com.qzone.reborn.layer.share.c
    protected void G(f fVar) {
        VideoInfo videoInfo;
        PhotoInfo photoInfo = fVar.f58179c;
        PhotoParam photoParam = fVar.f58180d;
        if (photoInfo == null || photoParam == null) {
            return;
        }
        HashMap<Integer, String> hashMap = new HashMap<>(1);
        if (photoInfo.videoflag == 1 && (videoInfo = photoInfo.videodata) != null && videoInfo.videoUrl != null) {
            hashMap.put(1, photoInfo.videodata.videoUrl.url);
            hashMap.put(11, "1");
        }
        Q(photoInfo, photoParam, hashMap);
    }

    @Override // com.qzone.reborn.layer.share.QZoneShareWXFriendAction
    protected void Q(PhotoInfo photoInfo, PhotoParam photoParam, HashMap<Integer, String> hashMap) {
        String str;
        if (photoInfo == null || photoParam == null) {
            return;
        }
        Map<Integer, String> map = photoParam.busi_param;
        if (map != null && map.containsKey(21)) {
            str = photoParam.busi_param.get(21);
        } else {
            str = "";
        }
        QZoneFeedxPictureManager qZoneFeedxPictureManager = QZoneFeedxPictureManager.getInstance();
        QZoneInteractPhotoRequestBuilder iisShareTo = new QZoneInteractPhotoRequestBuilder().setAppId(photoInfo.appid).setUgcType(-1).setCellId(H(photoInfo)).setAlbumId(photoInfo.albumId).setLloc(photoInfo.lloc).setBatchId(str).setIisShareTo(0);
        long j3 = photoParam.ownerUin;
        if (j3 == 0) {
            j3 = photoInfo.uploaduin;
        }
        qZoneFeedxPictureManager.getOutShareUrl(iisShareTo.setOwnerUin(j3).setExtraInfoMap(hashMap), r());
    }
}
