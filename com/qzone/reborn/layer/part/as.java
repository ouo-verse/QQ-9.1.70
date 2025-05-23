package com.qzone.reborn.layer.part;

import NS_MOBILE_FEEDS.s_pic_host;
import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_FEEDS.s_picurl;
import NS_MOBILE_QUN.Album;
import NS_MOBILE_QUN.qun_get_photo_list_ex_rsp;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class as extends QZoneFeedxLayerControlPart {
    private String Z = "";

    private ArrayList<PhotoInfo> Ga(ArrayList<s_picdata> arrayList, Album album) {
        String str;
        ArrayList<PhotoInfo> arrayList2 = new ArrayList<>();
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                PhotoInfo photoInfo = new PhotoInfo();
                s_picdata s_picdataVar = arrayList.get(i3);
                if (s_picdataVar != null) {
                    photoInfo.albumId = s_picdataVar.albumid;
                    PictureViewerFactory.f0(photoInfo, s_picdataVar, 1);
                    if (album != null) {
                        if (!TextUtils.isEmpty(album.albumid) && TextUtils.isEmpty(photoInfo.albumId)) {
                            photoInfo.albumId = album.albumid;
                        }
                        photoInfo.albumName = album.name;
                    }
                    if (!TextUtils.isEmpty(photoInfo.orgUrl) && photoInfo.hasLocalOrgFile == null) {
                        photoInfo.hasLocalOrgFile = Boolean.valueOf(ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) != null);
                    }
                    PhotoParam photoParam = this.f57988i;
                    if (photoParam != null && photoParam.appid == 311 && size == 1) {
                        photoInfo.hasPraise = photoParam.isLike;
                    }
                    Map<Integer, s_picurl> map = s_picdataVar.photourl;
                    if (map != null && map.containsKey(-1) && s_picdataVar.photourl.get(-1) != null) {
                        photoInfo.bigUrl = s_picdataVar.photourl.get(-1).url;
                    }
                    Map<Integer, s_picurl> map2 = s_picdataVar.photourl;
                    if (map2 != null && map2.containsKey(1) && s_picdataVar.photourl.get(1) != null) {
                        photoInfo.bigUrl = s_picdataVar.photourl.get(1).url;
                    }
                    Map<Integer, s_picurl> map3 = s_picdataVar.photourl;
                    if (map3 != null && map3.containsKey(0) && s_picdataVar.photourl.get(0) != null) {
                        photoInfo.orgUrl = s_picdataVar.photourl.get(0).url;
                    }
                    Map<Integer, s_picurl> map4 = s_picdataVar.photourl;
                    if (map4 != null && map4.containsKey(14) && s_picdataVar.photourl.get(14) != null && !TextUtils.isEmpty(s_picdataVar.photourl.get(14).url)) {
                        photoInfo.downloadUrl = s_picdataVar.photourl.get(14).url;
                    }
                    photoInfo.shareAlbumRight = 1;
                    photoInfo.shareSpaceRight = 1;
                    s_pic_host s_pic_hostVar = s_picdataVar.pic_host_nick;
                    if (s_pic_hostVar != null) {
                        str = s_pic_hostVar.nick;
                    } else {
                        str = "";
                    }
                    photoInfo.uploadOwner = str;
                    photoInfo.uploaduin = s_pic_hostVar != null ? s_pic_hostVar.uin : 0L;
                    arrayList2.add(photoInfo);
                }
            }
        }
        return arrayList2;
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
        QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder = new QZoneAlbumRequestBuilder();
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = rFWLayerState.getRichMediaDataList().get(rFWLayerState.getSelectedPosition());
        if (rFWLayerItemMediaInfo.getExtraData() instanceof PhotoInfo) {
            PhotoInfo photoInfo = (PhotoInfo) rFWLayerItemMediaInfo.getExtraData();
            if (!TextUtils.isEmpty(photoInfo.lloc)) {
                if (TextUtils.isEmpty(this.Z)) {
                    this.Z = photoInfo.groupId;
                }
                qZoneAlbumRequestBuilder.setGroupId(this.Z).setUploadUin(photoInfo.uploaduin).setAlbumId(photoInfo.albumId).setLloc(photoInfo.lloc).setBigUrl(photoInfo.bigUrl);
            }
        }
        return qZoneAlbumRequestBuilder;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected uk.a aa() {
        return (uk.a) getViewModel(uk.d.class);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected int ea() {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x008e, code lost:
    
        if (r1 != 75) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0121  */
    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void ia(QZoneResult qZoneResult) {
        Bundle bundle;
        ArrayList<s_picdata> arrayList;
        PhotoParam photoParam;
        uk.a aVar;
        int i3;
        PhotoParam photoParam2;
        if (qZoneResult != null && qZoneResult.getSucceed() && (bundle = qZoneResult.getBundle()) != null) {
            int i16 = bundle.getInt("type", 0);
            qun_get_photo_list_ex_rsp qun_get_photo_list_ex_rspVar = (qun_get_photo_list_ex_rsp) bundle.get("response");
            if (qun_get_photo_list_ex_rspVar == null || (arrayList = qun_get_photo_list_ex_rspVar.photolist) == null || arrayList.size() == 0) {
                return;
            }
            Album album = qun_get_photo_list_ex_rspVar.albuminfo;
            if (album != null && (photoParam2 = this.f57988i) != null) {
                photoParam2.albumPriv = album.priv;
            }
            int i17 = qun_get_photo_list_ex_rspVar.index;
            if (i17 < 0) {
                this.H = 0;
                this.J = true;
            } else {
                this.H = i17;
                this.J = qun_get_photo_list_ex_rspVar.left_finish > 0;
            }
            this.K = qun_get_photo_list_ex_rspVar.right_finish > 0;
            RFWLayerState rFWLayerState = new RFWLayerState();
            Album album2 = qun_get_photo_list_ex_rspVar.albuminfo;
            if (album2 != null && (i3 = album2.total) > 0) {
                rFWLayerState.setMediaSum(i3);
            } else {
                rFWLayerState.setMediaSum(qun_get_photo_list_ex_rspVar.photolist.size());
            }
            List<RFWLayerItemMediaInfo> j3 = PictureViewerFactory.j(Ga(qun_get_photo_list_ex_rspVar.photolist, qun_get_photo_list_ex_rspVar.albuminfo));
            if (i16 != 4) {
                if (i16 == 5) {
                    rFWLayerState.setRichMediaDataList(new ArrayList(j3));
                    rFWLayerState.getRichMediaDataList().addAll(this.mLayerViewModel.mRichMediaInfo.getValue().getData().getRichMediaDataList());
                    S9(true, false);
                } else if (i16 == 6) {
                    rFWLayerState.setRichMediaDataList(new ArrayList(this.mLayerViewModel.mRichMediaInfo.getValue().getData().getRichMediaDataList()));
                    rFWLayerState.getRichMediaDataList().addAll(j3);
                    S9(false, true);
                }
                photoParam = this.f57988i;
                if (photoParam != null) {
                    photoParam.appid = qun_get_photo_list_ex_rspVar.appid;
                    photoParam.qunid = String.valueOf(this.Z);
                }
                QLog.i(getTAG(), 1, " handleQZoneResult mRichMediaDataList size:" + rFWLayerState.getRichMediaDataList().size());
                xa(rFWLayerState, UIStateData.obtainSuccess(false));
                aVar = this.T;
                if (aVar != null) {
                    aVar.b2(this.f57988i);
                }
            }
            rFWLayerState.setRichMediaDataList(j3);
            S9(true, true);
            photoParam = this.f57988i;
            if (photoParam != null) {
            }
            QLog.i(getTAG(), 1, " handleQZoneResult mRichMediaDataList size:" + rFWLayerState.getRichMediaDataList().size());
            xa(rFWLayerState, UIStateData.obtainSuccess(false));
            aVar = this.T;
            if (aVar != null) {
            }
        }
        this.I = true;
    }
}
