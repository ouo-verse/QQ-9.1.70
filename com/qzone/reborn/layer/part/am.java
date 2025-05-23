package com.qzone.reborn.layer.part;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.Photo;
import NS_MOBILE_PHOTO.get_photo_list_ex_rsp;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.business.BasePicureViewController;
import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import com.tencent.util.ArrayUtils;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.model.PhotoParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class am extends QZoneFeedxLayerControlPart {
    private get_photo_list_ex_rsp Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f57983a0;

    public am() {
    }

    private String Ha(RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        if (rFWLayerItemMediaInfo == null) {
            return "";
        }
        if (rFWLayerItemMediaInfo.getLayerPicInfo() != null && rFWLayerItemMediaInfo.getLayerPicInfo().getBigPicInfo() != null && !TextUtils.isEmpty(rFWLayerItemMediaInfo.getLayerPicInfo().getBigPicInfo().getUrl())) {
            return rFWLayerItemMediaInfo.getLayerPicInfo().getBigPicInfo().getUrl();
        }
        if (rFWLayerItemMediaInfo.getLayerPicInfo() == null || rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo() == null || TextUtils.isEmpty(rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo().getUrl())) {
            return "";
        }
        return rFWLayerItemMediaInfo.getLayerPicInfo().getCurrentPicInfo().getUrl();
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void Aa() {
        MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData;
        RFWLayerViewModel rFWLayerViewModel = this.mLayerViewModel;
        if (rFWLayerViewModel == null || (mutableLiveData = rFWLayerViewModel.mRichMediaInfo) == null || mutableLiveData.getValue() == null) {
            return;
        }
        RFWLayerState data = this.mLayerViewModel.mRichMediaInfo.getValue().getData();
        if (BasePicureViewController.y0(this.G)) {
            V9(data, true, true);
        } else {
            Fa();
        }
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void T9(RFWLayerState rFWLayerState, RFWLayerState rFWLayerState2, boolean z16) {
        PhotoParam photoParam;
        get_photo_list_ex_rsp get_photo_list_ex_rspVar = this.Z;
        if (get_photo_list_ex_rspVar == null || rFWLayerState == null || rFWLayerState2 == null) {
            return;
        }
        if (z16) {
            if (get_photo_list_ex_rspVar.index <= rFWLayerState2.getSelectedPosition() || (photoParam = this.f57988i) == null || photoParam.appid != 4) {
                return;
            }
            rFWLayerState2.setPositionOffset(((this.Z.index - rFWLayerState2.getSelectedPosition()) + rFWLayerState.getSelectedPosition()) - this.X);
            RFWLog.i(getTAG(), RFWLog.USR, "response index is " + this.Z.index + ", mSelectedPosition is " + rFWLayerState2.getSelectedPosition() + ", pre position is " + rFWLayerState.getSelectedPosition() + ", initialIndex is " + this.X);
            return;
        }
        if (get_photo_list_ex_rspVar.index > rFWLayerState.getSelectedPosition()) {
            get_photo_list_ex_rsp get_photo_list_ex_rspVar2 = this.Z;
            rFWLayerState2.setPositionOffset(((get_photo_list_ex_rspVar2.index - get_photo_list_ex_rspVar2.indexInVec) + rFWLayerState.getSelectedPosition()) - this.X);
            RFWLog.i(getTAG(), RFWLog.USR, "response index is " + this.Z.index + " indexInVec is " + rFWLayerState2.getSelectedPosition() + ", pre position is " + rFWLayerState.getSelectedPosition() + ", initialIndex is " + this.X);
        }
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected QZoneAlbumRequestBuilder X9(RFWLayerState rFWLayerState, boolean z16, boolean z17) {
        String picId;
        QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder = new QZoneAlbumRequestBuilder();
        if (this.f57988i != null && rFWLayerState != null && rFWLayerState.getRichMediaDataList() != null) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = rFWLayerState.getRichMediaDataList().get(rFWLayerState.getSelectedPosition());
            if (rFWLayerItemMediaInfo.getLayerPicInfo() == null) {
                picId = "";
            } else {
                picId = rFWLayerItemMediaInfo.getLayerPicInfo().getPicId();
            }
            this.f57983a0 = picId;
            QLog.i("QZoneLayerAlbumAndFeedControlPart", 1, "fetch lloc is " + this.f57983a0);
            qZoneAlbumRequestBuilder.setPhotoId(this.f57983a0).setFetchLeft(z16 ? 1 : 0).setFetchRight(z17 ? 1 : 0).setUrl(Ha(rFWLayerItemMediaInfo)).setPhotoParam(this.f57988i).setAlbumType((long) this.f57988i.albumType).setPhotoExType(0);
        }
        return qZoneAlbumRequestBuilder;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected uk.a aa() {
        return (uk.a) getViewModel(uk.b.class);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected int ea() {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ef, code lost:
    
        if (r0 != 75) goto L62;
     */
    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void ia(QZoneResult qZoneResult) {
        ArrayList<Photo> arrayList;
        int i3;
        PhotoParam photoParam;
        QLog.i(getTAG(), 1, " handleQZoneResult " + qZoneResult.getSucceed());
        if (qZoneResult.getSucceed()) {
            Bundle bundle = qZoneResult.getBundle();
            if (bundle == null) {
                QLog.e(getTAG(), 1, " handleQZoneResult data is null");
                return;
            }
            int i16 = bundle.getInt("type", 0);
            get_photo_list_ex_rsp get_photo_list_ex_rspVar = (get_photo_list_ex_rsp) bundle.get("response");
            if (get_photo_list_ex_rspVar == null || (arrayList = get_photo_list_ex_rspVar.photolist) == null || arrayList.size() == 0) {
                return;
            }
            Ga(i16, get_photo_list_ex_rspVar.photolist);
            this.Z = get_photo_list_ex_rspVar;
            Album album = get_photo_list_ex_rspVar.albuminfo;
            if (album != null && (photoParam = this.f57988i) != null) {
                photoParam.albumPriv = album.priv;
            }
            int i17 = get_photo_list_ex_rspVar.index;
            if (i17 < 0) {
                this.H = 0;
                this.J = true;
                this.K = get_photo_list_ex_rspVar.right_finish > 0;
            } else {
                this.H = i17;
                this.J = get_photo_list_ex_rspVar.left_finish > 0;
                this.K = get_photo_list_ex_rspVar.right_finish > 0;
            }
            if (this.K && (F9() || QZoneConfigHelper.L0())) {
                QLog.d(getTAG(), 4, "get_photo_list_ex_rsp | Reaching the right most of the photo list");
                this.R = new QZoneFeedxLayerControlPart.ParseAlbumTask(this, get_photo_list_ex_rspVar.features);
            } else {
                this.M = null;
            }
            this.L = get_photo_list_ex_rspVar.photolist;
            RFWLayerState rFWLayerState = new RFWLayerState();
            Album album2 = get_photo_list_ex_rspVar.albuminfo;
            if (album2 != null && (i3 = album2.total) > 0) {
                rFWLayerState.setMediaSum(i3);
            } else {
                rFWLayerState.setMediaSum(get_photo_list_ex_rspVar.photolist.size());
            }
            List<RFWLayerItemMediaInfo> R1 = this.T.R1(get_photo_list_ex_rspVar.photolist, get_photo_list_ex_rspVar.albuminfo);
            if (i16 != 4) {
                if (i16 == 5) {
                    rFWLayerState.setRichMediaDataList(new ArrayList(R1));
                    rFWLayerState.getRichMediaDataList().addAll(this.mLayerViewModel.mRichMediaInfo.getValue().getData().getRichMediaDataList());
                    S9(true, false);
                } else if (i16 == 6) {
                    rFWLayerState.setRichMediaDataList(new ArrayList(this.mLayerViewModel.mRichMediaInfo.getValue().getData().getRichMediaDataList()));
                    rFWLayerState.getRichMediaDataList().addAll(R1);
                    S9(false, true);
                }
                QLog.i(getTAG(), 1, " handleQZoneResult mRichMediaDataList size:" + rFWLayerState.getRichMediaDataList().size());
                xa(rFWLayerState, UIStateData.obtainSuccess(false));
            }
            rFWLayerState.setRichMediaDataList(R1);
            S9(true, true);
            QLog.i(getTAG(), 1, " handleQZoneResult mRichMediaDataList size:" + rFWLayerState.getRichMediaDataList().size());
            xa(rFWLayerState, UIStateData.obtainSuccess(false));
        }
        this.I = true;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected boolean ua() {
        return ra();
    }

    public am(ve.l lVar) {
        super(lVar);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void U9(RFWLayerState rFWLayerState, RFWLayerState rFWLayerState2) {
        if (rFWLayerState == null || rFWLayerState2 == null) {
            return;
        }
        if (this.Z == null) {
            rFWLayerState2.setSelectedPosition(rFWLayerState.getSelectedPosition());
            return;
        }
        RFWLog.i(getTAG(), RFWLog.USR, "response indexInVec is " + this.Z.indexInVec + " response index is " + this.Z.index + " pre index is " + rFWLayerState.getSelectedPosition());
        if (this.Z.indexInVec >= rFWLayerState.getSelectedPosition()) {
            rFWLayerState2.setSelectedPosition(this.Z.indexInVec);
        } else if (this.Z.index >= rFWLayerState.getSelectedPosition()) {
            rFWLayerState2.setSelectedPosition(this.Z.index);
        } else {
            rFWLayerState2.setSelectedPosition(rFWLayerState.getSelectedPosition());
        }
    }

    private void Ga(int i3, ArrayList<Photo> arrayList) {
        if ((i3 == 5 || i3 == 6) && !ArrayUtils.isOutOfArrayIndex(0, arrayList)) {
            Iterator<Photo> it = arrayList.iterator();
            while (it.hasNext()) {
                Photo next = it.next();
                if (TextUtils.equals(next.lloc, this.f57983a0)) {
                    QLog.i("QZoneLayerAlbumAndFeedControlPart", 1, "filter lloc is " + this.f57983a0);
                    arrayList.remove(next);
                    return;
                }
            }
        }
    }
}
