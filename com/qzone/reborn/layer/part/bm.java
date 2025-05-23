package com.qzone.reborn.layer.part;

import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bm extends w {
    @Override // com.qzone.reborn.layer.part.w
    protected void M9(String str, ArrayList<String> arrayList, boolean z16, String str2, String str3, String str4) {
        uk.j jVar;
        String str5;
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo == null || (jVar = (uk.j) getViewModel(uk.j.class)) == null || jVar.W1() == null) {
            return;
        }
        PhotoParam W1 = jVar.W1();
        P9(photoInfo);
        this.J = 1;
        if (photoInfo.isIndependentUgc != 0 && (photoInfo.opsynflag & 4) == 0) {
            this.J = 0;
        }
        QZoneFeedxPictureManager qZoneFeedxPictureManager = QZoneFeedxPictureManager.getInstance();
        QZoneInteractPhotoRequestBuilder ownerUin = new QZoneInteractPhotoRequestBuilder().setUgcKey(tk.h.u(photoInfo)).setLloc(photoInfo.lloc).setAppId(photoInfo.appid).setOwnerUin(W1.ownerUin);
        if (photoInfo.appid == 4) {
            str5 = photoInfo.albumId;
        } else {
            str5 = photoInfo.pssCellId;
        }
        qZoneFeedxPictureManager.commentPhoto(ownerUin.setSrcId(str5).setContent(str).setContentCacheUniKey(N9()).setExtraInfoMap(photoInfo.busi_param).setSyn(this.J).setIsPrivate(z16).setCommentPics(arrayList).setIndex(this.C).setFontInfo(str2).setSuperFontInfo(str3).setBarrageEffectInfo(str4), A9());
    }
}
