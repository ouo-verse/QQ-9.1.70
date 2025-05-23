package com.qzone.reborn.layer.part;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.Photo;
import NS_MOBILE_PHOTO.get_photo_list_ex_rsp;
import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.model.PhotoParam;
import java.util.ArrayList;

/* loaded from: classes37.dex */
public class QZoneFeedxSingleVideoControlPart extends QZoneFeedxLayerControlPart {
    private void Ha() {
        String str;
        String str2;
        String str3;
        BusinessFeedData businessFeedData = QZoneFeedUtil.f47421a.get("current_forward_key");
        if (businessFeedData != null) {
            String str4 = "";
            if (businessFeedData.getFeedCommInfo() == null || businessFeedData.getFeedCommInfo().ugckey == null) {
                str = "";
            } else {
                str = businessFeedData.getFeedCommInfo().ugckey;
            }
            if (businessFeedData.getFeedCommInfo() == null || businessFeedData.getFeedCommInfo().feedskey == null) {
                str2 = "";
            } else {
                str2 = businessFeedData.getFeedCommInfo().feedskey;
            }
            if (businessFeedData.getVideoInfo() == null || businessFeedData.getVideoInfo().albumid == null) {
                str3 = "";
            } else {
                str3 = businessFeedData.getVideoInfo().albumid;
            }
            if (businessFeedData.getVideoInfo() != null && businessFeedData.getVideoInfo().videoId != null) {
                str4 = businessFeedData.getVideoInfo().videoId;
            }
            RFWLog.e("QZoneFeedxSingleVideoControlPart", RFWLog.USR, "error photo video, ugcKey is " + str + " feedsKey is " + str2 + " album id is " + str3 + " videoId is " + str4);
        }
    }

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
        return (uk.a) getViewModel(uk.k.class);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected int ea() {
        return 0;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected void ia(QZoneResult qZoneResult) {
        ArrayList<Photo> arrayList;
        QLog.i(getTAG(), 1, " handleQZoneResult " + qZoneResult.getSucceed());
        if (qZoneResult.getSucceed()) {
            Bundle bundle = qZoneResult.getBundle();
            if (bundle == null) {
                QLog.e(getTAG(), 1, " handleQZoneResult data is null");
                return;
            }
            get_photo_list_ex_rsp get_photo_list_ex_rspVar = (get_photo_list_ex_rsp) bundle.get("response");
            if (get_photo_list_ex_rspVar != null && (arrayList = get_photo_list_ex_rspVar.photolist) != null && arrayList.size() != 0) {
                if (tk.h.F(get_photo_list_ex_rspVar.photolist)) {
                    Ga(get_photo_list_ex_rspVar);
                } else {
                    RFWLog.e("QZoneFeedxSingleVideoControlPart", RFWLog.USR, "invalid photo list data");
                    Ha();
                }
            } else {
                RFWLog.e("QZoneFeedxSingleVideoControlPart", RFWLog.USR, "invalid response list data");
                return;
            }
        }
        this.I = true;
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneFeedxSingleVideoControlPart.1
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedxSingleVideoControlPart.this.broadcastMessage("FEEDX_LAYER_SINGLE_VIDEO_INIT_SUCCESS", null);
            }
        });
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QZoneFeedUtil.f47421a.remove("current_forward_key");
        QZoneFeedUtil.f47421a.remove("open_action_panel_ahare_to_qzone_key");
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected boolean ua() {
        return ra();
    }

    private void Ga(get_photo_list_ex_rsp get_photo_list_ex_rspVar) {
        ArrayList<Photo> arrayList;
        int i3;
        PhotoParam photoParam;
        if (get_photo_list_ex_rspVar == null || (arrayList = get_photo_list_ex_rspVar.photolist) == null || arrayList.size() == 0) {
            return;
        }
        Album album = get_photo_list_ex_rspVar.albuminfo;
        if (album != null && (photoParam = this.f57988i) != null) {
            photoParam.albumPriv = album.priv;
        }
        this.J = true;
        this.K = true;
        this.L = get_photo_list_ex_rspVar.photolist;
        RFWLayerState rFWLayerState = new RFWLayerState();
        Album album2 = get_photo_list_ex_rspVar.albuminfo;
        if (album2 != null && (i3 = album2.total) > 0) {
            rFWLayerState.setMediaSum(i3);
        } else {
            rFWLayerState.setMediaSum(get_photo_list_ex_rspVar.photolist.size());
        }
        rFWLayerState.setRichMediaDataList(this.T.R1(get_photo_list_ex_rspVar.photolist, get_photo_list_ex_rspVar.albuminfo));
        S9(true, true);
        QLog.i(getTAG(), 1, " handleQZoneResult mRichMediaDataList size:" + rFWLayerState.getRichMediaDataList().size());
        xa(rFWLayerState, UIStateData.obtainSuccess(false));
    }
}
