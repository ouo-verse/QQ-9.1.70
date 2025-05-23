package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import cooperation.qzone.model.PhotoInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bk extends QZoneFeedxLayerControlPart {
    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void Aa() {
        MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData;
        RFWLayerViewModel rFWLayerViewModel = this.mLayerViewModel;
        if (rFWLayerViewModel == null || (mutableLiveData = rFWLayerViewModel.mRichMediaInfo) == null || mutableLiveData.getValue() == null) {
            return;
        }
        RFWLayerState data = this.mLayerViewModel.mRichMediaInfo.getValue().getData();
        V9(data, !qa(data), qa(data));
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected QZoneAlbumRequestBuilder X9(RFWLayerState rFWLayerState, boolean z16, boolean z17) {
        QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder = new QZoneAlbumRequestBuilder();
        if (this.f57988i == null) {
            return qZoneAlbumRequestBuilder;
        }
        qZoneAlbumRequestBuilder.setFetchLeft(z16 ? 1 : 0).setFetchRight(z17 ? 1 : 0).setUin(this.f57988i.ownerUin);
        return qZoneAlbumRequestBuilder;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected uk.a aa() {
        return (uk.a) getViewModel(uk.h.class);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected int ea() {
        return 3;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (this.f57988i != null) {
            com.qzone.album.base.Service.a.W().v(this.f57988i.ownerUin);
        }
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void ia(QZoneResult qZoneResult) {
        if (qZoneResult != null && qZoneResult.getBundle() != null && qZoneResult.getSucceed()) {
            Bundle bundle = qZoneResult.getBundle();
            ArrayList<PhotoInfo> parcelableArrayList = bundle.getParcelableArrayList("responseList");
            int i3 = bundle.getInt("direction", -1);
            RFWLog.i("QZoneLayerRecentAlbumTimeLineControlPart", RFWLog.USR, "direction is " + i3);
            if (i3 == -1) {
                return;
            }
            if (i3 == 1) {
                this.K = !bundle.getBoolean("hasMore", false);
            } else if (i3 == 2) {
                this.J = !bundle.getBoolean("hasMore", false);
            }
            Ga(parcelableArrayList, i3);
        }
        this.I = true;
    }

    private void Ga(ArrayList<PhotoInfo> arrayList, int i3) {
        if (arrayList != null && !arrayList.isEmpty()) {
            List<RFWLayerItemMediaInfo> j3 = PictureViewerFactory.j(arrayList);
            RFWLayerState rFWLayerState = new RFWLayerState();
            if (i3 == 1) {
                rFWLayerState.setRichMediaDataList(new ArrayList(this.mLayerViewModel.mRichMediaInfo.getValue().getData().getRichMediaDataList()));
                rFWLayerState.getRichMediaDataList().addAll(j3);
                S9(false, true);
            } else if (i3 == 2) {
                rFWLayerState.setRichMediaDataList(new ArrayList(j3));
                rFWLayerState.getRichMediaDataList().addAll(this.mLayerViewModel.mRichMediaInfo.getValue().getData().getRichMediaDataList());
                S9(true, false);
            }
            RFWLog.i(getTAG(), RFWLog.USR, " handleQZoneResult mRichMediaDataList size:" + rFWLayerState.getRichMediaDataList().size());
            xa(rFWLayerState, UIStateData.obtainSuccess(false));
            return;
        }
        RFWLog.e("QZoneLayerRecentAlbumTimeLineControlPart", RFWLog.USR, "response is null");
    }
}
