package com.qzone.reborn.layer.part;

import android.os.Handler;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import com.qzone.reborn.event.QZoneFeedxLayerPraiseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import cooperation.qzone.model.PhotoInfo;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bp extends ad {
    @Override // com.qzone.reborn.layer.part.ad
    public boolean P9() {
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo == null) {
            return false;
        }
        return photoInfo.hasPraise;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ad
    public int Q9() {
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo == null) {
            return 0;
        }
        return photoInfo.praiseCount;
    }

    @Override // com.qzone.reborn.layer.part.ad
    protected void T9() {
        SimpleEventBus.getInstance().dispatchEvent(new QZoneFeedxLayerPraiseEvent(P9(), Q9(), this.f57984d.lloc), true);
    }

    @Override // com.qzone.reborn.layer.part.ad
    protected boolean U9(PhotoInfo photoInfo) {
        return false;
    }

    @Override // com.qzone.reborn.layer.part.ad
    protected void V9(Handler handler) {
        PhotoInfo photoInfo = this.f57984d;
        uk.j jVar = (uk.j) getViewModel(uk.j.class);
        if (photoInfo == null || jVar == null || jVar.W1() == null) {
            return;
        }
        if (photoInfo.busi_param == null) {
            photoInfo.busi_param = new HashMap();
        }
        photoInfo.busi_param.put(20, jVar.W1().feedId);
        QZoneFeedxPictureManager.getInstance().praisePhoto(handler, new QZoneInteractPhotoRequestBuilder().setUgcKey(tk.h.u(photoInfo)).setCurKey(tk.h.n(photoInfo)).setUniKey(tk.h.v(photoInfo)).setIsLike(photoInfo.hasPraise).setOwnerUin(jVar.W1().ownerUin).setAppId(photoInfo.appid).setExtraInfoMap(photoInfo.busi_param).setIsTodayInHisFeed(false).setSyn(1).setClickScene(1).setIndex(this.C));
    }
}
