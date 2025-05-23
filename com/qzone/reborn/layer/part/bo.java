package com.qzone.reborn.layer.part;

import NS_MOBILE_PHOTO.PhotoFeedsData;
import NS_MOBILE_PHOTO.get_all_feedsphoto_ex_rsp;
import android.app.Activity;
import android.os.Bundle;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import cooperation.qzone.model.PhotoParam;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bo extends QZoneFeedxLayerControlPart {
    private void Ga(get_all_feedsphoto_ex_rsp get_all_feedsphoto_ex_rspVar) {
        ArrayList<PhotoFeedsData> arrayList = get_all_feedsphoto_ex_rspVar.all_applist_data;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.J = true;
            this.K = get_all_feedsphoto_ex_rspVar.hasmore == 0;
            List<RFWLayerItemMediaInfo> j3 = PictureViewerFactory.j(com.qzone.preview.business.g.t1(get_all_feedsphoto_ex_rspVar.all_applist_data));
            ArrayList<PhotoParam> ba5 = ba(get_all_feedsphoto_ex_rspVar.all_applist_data);
            RFWLayerState rFWLayerState = new RFWLayerState();
            rFWLayerState.setRichMediaDataList(new ArrayList(this.mLayerViewModel.mRichMediaInfo.getValue().getData().getRichMediaDataList()));
            rFWLayerState.getRichMediaDataList().addAll(j3);
            RFWLog.d("QZoneLayerRecentVideoControlPart", RFWLog.USR, "new list size is " + j3.size() + "total size is " + rFWLayerState.getRichMediaDataList().size());
            ArrayList<PhotoParam> arrayList2 = this.f57986f;
            if (arrayList2 != null) {
                arrayList2.addAll(ba5);
            }
            xa(rFWLayerState, UIStateData.obtainSuccess(false));
            S9(false, true);
            return;
        }
        S9(false, true);
    }

    private void Ha(Bundle bundle) {
        com.qzone.album.base.Service.a.W().R0();
        PhotoParam photoParam = this.f57988i;
        if (photoParam == null || this.T == null) {
            return;
        }
        photoParam.ownerUin = bundle.getLong("key_uin");
        this.f57988i.appid = 311;
        com.qzone.album.base.Service.a.W().w(this.f57988i.ownerUin);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected QZoneAlbumRequestBuilder X9(RFWLayerState rFWLayerState, boolean z16, boolean z17) {
        QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder = new QZoneAlbumRequestBuilder();
        uk.a aVar = this.T;
        if (aVar != null && aVar.W1() != null) {
            qZoneAlbumRequestBuilder.setFetchLeft(z16 ? 1 : 0).setFetchRight(z17 ? 1 : 0).setUin(this.T.W1().ownerUin);
        }
        return qZoneAlbumRequestBuilder;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected uk.a aa() {
        return (uk.a) getViewModel(uk.j.class);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected int ea() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart, com.qzone.reborn.layer.part.ap
    public void initIntentData(Bundle bundle) {
        Ha(bundle);
        super.initIntentData(bundle);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart, com.qzone.reborn.layer.part.ap, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        uk.a aVar = this.T;
        if (aVar == null || aVar.W1() == null) {
            return;
        }
        com.qzone.album.base.Service.a.W().w(this.T.W1().ownerUin);
        com.qzone.album.base.Service.a.W().S0();
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void Aa() {
        this.J = true;
        this.I = true;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void ia(QZoneResult qZoneResult) {
        if (qZoneResult == null) {
            return;
        }
        if (qZoneResult.getSucceed()) {
            if (!(qZoneResult.getData() instanceof Bundle)) {
                return;
            }
            get_all_feedsphoto_ex_rsp get_all_feedsphoto_ex_rspVar = (get_all_feedsphoto_ex_rsp) ((Bundle) qZoneResult.getData()).get("response");
            if (get_all_feedsphoto_ex_rspVar != null) {
                Ga(get_all_feedsphoto_ex_rspVar);
            }
        }
        this.I = true;
    }
}
