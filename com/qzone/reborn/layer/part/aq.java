package com.qzone.reborn.layer.part;

import android.text.TextUtils;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aq extends w {
    private String X9(PhotoParam photoParam) {
        String str;
        if (photoParam == null) {
            return "";
        }
        if (TextUtils.isEmpty(photoParam.qunid)) {
            int i3 = RFWLog.USR;
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("group id is empty, error lloc is ");
            PhotoInfo photoInfo = this.f57984d;
            if (photoInfo == null) {
                str = "";
            } else {
                str = photoInfo.lloc;
            }
            sb5.append(str);
            objArr[0] = sb5.toString();
            RFWLog.e("QZoneLayerGroupAlbumCommentInputPart", i3, objArr);
            return "";
        }
        return photoParam.qunid;
    }

    @Override // com.qzone.reborn.layer.part.w
    protected void M9(String str, ArrayList<String> arrayList, boolean z16, String str2, String str3, String str4) {
        uk.d dVar;
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo == null || (dVar = (uk.d) getViewModel(uk.d.class)) == null || dVar.W1() == null) {
            return;
        }
        P9(photoInfo);
        QZoneFeedxPictureManager.getInstance().commentGroupPhoto(new QZoneInteractPhotoRequestBuilder().setGroupId(X9(dVar.W1())).setFeedId(dVar.W1().feedId).setFeedKey("").setLloc(photoInfo.lloc).setAppId(dVar.W1().appid).setUploadUin(photoInfo.uploaduin).setAlbumId(photoInfo.albumId).setCommentText(str).setIsVerified(0).setContentCacheUniKey(N9()).setExtraInfoMap(photoInfo.busi_param).setSyn(0).setIsPrivate(z16).setCommentPics(arrayList).setIndex(this.C).setFontInfo(str2).setSuperFontInfo(str3).setBarrageEffectInfo(str4), A9());
    }

    @Override // com.qzone.reborn.layer.part.w
    protected boolean Q9() {
        return false;
    }
}
