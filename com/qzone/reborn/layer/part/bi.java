package com.qzone.reborn.layer.part;

import NS_MOBILE_PHOTO.get_all_feedsphoto_ex_rsp;
import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bi extends QZoneFeedxLayerControlPart {
    private int Ga() {
        return Math.max(this.H - 1, 0);
    }

    private int Ha() {
        return Math.max(this.H - 50, 0);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void Aa() {
        MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData;
        RFWLayerViewModel rFWLayerViewModel = this.mLayerViewModel;
        if (rFWLayerViewModel == null || (mutableLiveData = rFWLayerViewModel.mRichMediaInfo) == null || mutableLiveData.getValue() == null) {
            return;
        }
        RFWLayerState data = this.mLayerViewModel.mRichMediaInfo.getValue().getData();
        if (this.K) {
            return;
        }
        V9(data, false, true);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected QZoneAlbumRequestBuilder X9(RFWLayerState rFWLayerState, boolean z16, boolean z17) {
        QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder = new QZoneAlbumRequestBuilder();
        if (this.f57988i == null) {
            return qZoneAlbumRequestBuilder;
        }
        qZoneAlbumRequestBuilder.setFetchLeft(z16 ? 1 : 0).setFetchRight(z17 ? 1 : 0).setStartIndex(Ha()).setEndIndex(Ga()).setUin(this.f57988i.ownerUin);
        return qZoneAlbumRequestBuilder;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected uk.a aa() {
        return (uk.a) getViewModel(uk.i.class);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected int ea() {
        return 3;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void ia(QZoneResult qZoneResult) {
        if (qZoneResult.getSucceed()) {
            Bundle bundle = qZoneResult.getBundle();
            if (bundle == null) {
                return;
            }
            get_all_feedsphoto_ex_rsp get_all_feedsphoto_ex_rspVar = (get_all_feedsphoto_ex_rsp) bundle.get("response");
            bundle.getParcelableArrayList("responseList");
            bundle.getParcelableArrayList("cacheList");
            if (get_all_feedsphoto_ex_rspVar != null) {
                Ia(get_all_feedsphoto_ex_rspVar);
            }
        }
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart, com.qzone.reborn.layer.part.ap
    public void initIntentData(Bundle bundle) {
        com.qzone.album.base.Service.a.W().R0();
        this.K = !bundle.getBoolean(PictureConst.KEY_HAS_MORE, true);
        super.initIntentData(bundle);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart, com.qzone.reborn.layer.part.ap, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (this.f57988i != null) {
            com.qzone.album.base.Service.a.W().u(this.f57988i.ownerUin);
            com.qzone.album.base.Service.a.W().S0();
        }
    }

    private void Ia(get_all_feedsphoto_ex_rsp get_all_feedsphoto_ex_rspVar) {
        if (get_all_feedsphoto_ex_rspVar == null || this.T == null) {
            return;
        }
        this.K = get_all_feedsphoto_ex_rspVar.hasmore == 0;
        ArrayList<PhotoInfo> t16 = com.qzone.preview.business.g.t1(get_all_feedsphoto_ex_rspVar.all_applist_data);
        if (ArrayUtils.isOutOfArrayIndex(0, t16)) {
            RFWLog.e("QZoneFeedxLayerRecentAlbumControlPart", RFWLog.USR, "response list from rsp is empty");
            return;
        }
        List<RFWLayerItemMediaInfo> j3 = PictureViewerFactory.j(t16);
        ArrayList<PhotoParam> ba5 = ba(get_all_feedsphoto_ex_rspVar.all_applist_data);
        RFWLayerState rFWLayerState = new RFWLayerState();
        rFWLayerState.setRichMediaDataList(new ArrayList(this.mLayerViewModel.mRichMediaInfo.getValue().getData().getRichMediaDataList()));
        rFWLayerState.getRichMediaDataList().addAll(j3);
        ArrayList<PhotoParam> arrayList = this.f57986f;
        if (arrayList != null) {
            arrayList.addAll(ba5);
        }
        xa(rFWLayerState, UIStateData.obtainSuccess(false));
        S9(false, true);
    }
}
