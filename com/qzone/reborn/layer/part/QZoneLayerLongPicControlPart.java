package com.qzone.reborn.layer.part;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.Photo;
import NS_MOBILE_PHOTO.get_photo_list_ex_rsp;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.album.data.model.RecomAlbumList;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.qzone.reborn.layer.recommendphoto.QZoneFeedxLayerRecommendPhotoBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import cooperation.qzone.model.PhotoParam;
import java.util.ArrayList;

/* loaded from: classes37.dex */
public class QZoneLayerLongPicControlPart extends QZoneFeedxLayerControlPart {
    private RecyclerView Z;

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void Aa() {
        MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData;
        RFWLayerViewModel rFWLayerViewModel = this.mLayerViewModel;
        if (rFWLayerViewModel == null || (mutableLiveData = rFWLayerViewModel.mRichMediaInfo) == null || mutableLiveData.getValue() == null) {
            return;
        }
        V9(this.mLayerViewModel.mRichMediaInfo.getValue().getData(), true, true);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected QZoneAlbumRequestBuilder X9(RFWLayerState rFWLayerState, boolean z16, boolean z17) {
        String picId;
        QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder = new QZoneAlbumRequestBuilder();
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = rFWLayerState.getRichMediaDataList().get(rFWLayerState.getSelectedPosition());
        String str = "";
        if (rFWLayerItemMediaInfo.getLayerPicInfo() == null) {
            picId = "";
        } else {
            picId = rFWLayerItemMediaInfo.getLayerPicInfo().getPicId();
        }
        QZoneAlbumRequestBuilder fetchRight = qZoneAlbumRequestBuilder.setPhotoId(picId).setFetchLeft(z16 ? 1 : 0).setFetchRight(z17 ? 1 : 0);
        if (rFWLayerItemMediaInfo.getLayerPicInfo() != null && rFWLayerItemMediaInfo.getLayerPicInfo().getBigPicInfo() != null) {
            str = rFWLayerItemMediaInfo.getLayerPicInfo().getBigPicInfo().getUrl();
        }
        fetchRight.setUrl(str).setPhotoParam(this.f57988i).setPhotoExType(0);
        return qZoneAlbumRequestBuilder;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected uk.a aa() {
        return (uk.a) getViewModel(uk.f.class);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected int ea() {
        return 0;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
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
            get_photo_list_ex_rsp get_photo_list_ex_rspVar = (get_photo_list_ex_rsp) bundle.get("response");
            if (get_photo_list_ex_rspVar == null || (arrayList = get_photo_list_ex_rspVar.photolist) == null || arrayList.size() == 0) {
                return;
            }
            Album album = get_photo_list_ex_rspVar.albuminfo;
            if (album != null && (photoParam = this.f57988i) != null) {
                photoParam.albumPriv = album.priv;
            }
            this.L = get_photo_list_ex_rspVar.photolist;
            this.J = true;
            this.K = true;
            RFWLayerState rFWLayerState = new RFWLayerState();
            Album album2 = get_photo_list_ex_rspVar.albuminfo;
            if (album2 != null && (i3 = album2.total) > 0) {
                rFWLayerState.setMediaSum(i3);
            } else {
                rFWLayerState.setMediaSum(get_photo_list_ex_rspVar.photolist.size());
            }
            this.T.a2(new ArrayList(this.T.S1(get_photo_list_ex_rspVar.photolist, get_photo_list_ex_rspVar.albuminfo)));
            rFWLayerState.setRichMediaDataList(this.T.R1(get_photo_list_ex_rspVar.photolist, get_photo_list_ex_rspVar.albuminfo));
            S9(true, true);
            QLog.i(getTAG(), 1, " handleQZoneResult mRichMediaDataList size:" + rFWLayerState.getRichMediaDataList().size());
            xa(rFWLayerState, UIStateData.obtainSuccess(false));
        }
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    public void xa(final RFWLayerState rFWLayerState, final UIStateData<RFWLayerState> uIStateData) {
        getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneLayerLongPicControlPart.1

            /* renamed from: com.qzone.reborn.layer.part.QZoneLayerLongPicControlPart$1$a */
            /* loaded from: classes37.dex */
            class a extends RecyclerView.OnScrollListener {
                a() {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                    super.onScrollStateChanged(recyclerView, i3);
                    if (i3 == 0) {
                        QZoneLayerLongPicControlPart.this.Z.removeOnScrollListener(this);
                        RFWLog.i(QZoneLayerLongPicControlPart.this.getTAG(), RFWLog.USR, "scroll is idle start setData");
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        QZoneLayerLongPicControlPart.this.Da(rFWLayerState, uIStateData);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                if (QZoneLayerLongPicControlPart.this.Z == null) {
                    return;
                }
                if (QZoneLayerLongPicControlPart.this.Z.getScrollState() == 0) {
                    QZoneLayerLongPicControlPart.this.Da(rFWLayerState, uIStateData);
                } else {
                    RFWLog.i(QZoneLayerLongPicControlPart.this.getTAG(), RFWLog.USR, "isScrolling add listener");
                    QZoneLayerLongPicControlPart.this.Z.addOnScrollListener(new a());
                }
            }
        });
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void Z9(View view) {
        this.Z = (RecyclerView) view.findViewById(R.id.neg);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void R9(RecomAlbumList recomAlbumList) {
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void wa(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean) {
    }
}
