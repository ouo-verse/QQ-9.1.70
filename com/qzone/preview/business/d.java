package com.qzone.preview.business;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.EditPhoto;
import NS_MOBILE_PHOTO.MarkFaceItemFeed;
import NS_MOBILE_PHOTO.Photo;
import NS_MOBILE_PHOTO.get_photo_list_ex_rsp;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.service.PictureManager;
import com.qzone.preview.service.RequestSender;
import com.qzone.util.ToastUtil;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.remote.Callback;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d extends BasePicureViewController {
    @Override // com.qzone.preview.business.BasePicureViewController
    public void C0(QZoneResult qZoneResult, int i3) {
        ArrayList<Photo> arrayList;
        boolean z16;
        int i16;
        ArrayList<Photo> arrayList2;
        if (qZoneResult.getSucceed()) {
            Bundle bundle = qZoneResult.getBundle();
            if (bundle != null) {
                int i17 = bundle.getInt("type", 0);
                get_photo_list_ex_rsp get_photo_list_ex_rspVar = (get_photo_list_ex_rsp) bundle.get("response");
                if (get_photo_list_ex_rspVar == null || (arrayList = get_photo_list_ex_rspVar.photolist) == null || arrayList.size() == 0) {
                    return;
                }
                Album album = get_photo_list_ex_rspVar.albuminfo;
                if (album != null) {
                    this.f49877g.albumPriv = album.priv;
                }
                int i18 = get_photo_list_ex_rspVar.index;
                if (i18 < 0) {
                    this.f49873c = 0;
                    this.f49882l = true;
                    this.f49883m = get_photo_list_ex_rspVar.right_finish > 0;
                } else {
                    if (i17 == 75) {
                        this.f49873c = (get_photo_list_ex_rspVar.indexInVec - this.f49879i) + this.f49873c;
                    } else {
                        this.f49873c = (i18 - this.f49879i) + this.f49873c;
                    }
                    this.f49879i = i18;
                    this.f49882l = get_photo_list_ex_rspVar.left_finish > 0;
                    this.f49883m = get_photo_list_ex_rspVar.right_finish > 0;
                }
                if (this.f49883m) {
                    QZLog.d("[PhotoAlbum]BasePicureViewController", 4, "get_photo_list_ex_rsp | Reaching the right most of the photo list");
                    D0(get_photo_list_ex_rspVar.features);
                } else {
                    this.f49895y = null;
                }
                Album album2 = get_photo_list_ex_rspVar.albuminfo;
                if (album2 == null || (i16 = album2.total) <= 0 || i16 == this.f49874d) {
                    z16 = false;
                } else {
                    if (i17 == 75 && (arrayList2 = get_photo_list_ex_rspVar.photolist) != null) {
                        this.f49874d = arrayList2.size();
                    } else {
                        this.f49874d = i16;
                    }
                    z16 = true;
                }
                I0(i3);
                u0(get_photo_list_ex_rspVar.photolist, this.f49879i, z16, i17, get_photo_list_ex_rspVar.albuminfo);
            }
        } else if (-11545 == qZoneResult.getReturnCode()) {
            ToastUtil.s("errorCode: -11545", 4);
        }
        this.f49886p = true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void E0(Handler handler) {
        PhotoInfo b16 = b();
        if (b16 == null) {
            return;
        }
        RequestSender sender = PictureManager.getInstance().getSender();
        PhotoParam photoParam = this.f49877g;
        sender.praisePhoto(handler, photoParam.feedId, "", b16.curkey, b16.unikey, b16.hasPraise, photoParam.appid, b16.busi_param, 0, this.f49873c);
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void O0(FaceData faceData, int i3, int i16) {
        String str;
        if (this.f49877g.appid == 4) {
            MarkFaceItemFeed markFaceItemFeed = new MarkFaceItemFeed();
            markFaceItemFeed.albumid = faceData.album_id;
            markFaceItemFeed.faceinfo = FaceData.FaceDataTostFaceItem(faceData);
            markFaceItemFeed.photoid = faceData.photo_id;
            markFaceItemFeed.f25031op = i16;
            if (b() != null) {
                str = b().unikey;
            } else {
                str = "";
            }
            String str2 = str;
            QZLog.d("[PhotoAlbum]FaceFuntion", 1, "[sendRequest] albumid:", markFaceItemFeed.albumid, " op:", Integer.valueOf(markFaceItemFeed.f25031op), " photoid:", markFaceItemFeed.photoid, " scene:", 3, " index:", Integer.valueOf(i3), " unikey:", str2);
            PictureManager.getInstance().faceOperation(J(), null, markFaceItemFeed, L(), 3, str2, i3);
        }
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean P0(Handler handler) {
        PhotoInfo b16 = b();
        if (b16 == null) {
            return false;
        }
        String str = b16.albumId;
        PictureManager.getInstance().getQzonePhotoComment(b16.lloc, str, b16.busi_param.get(21), this.f49877g, handler);
        return true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean X0() {
        return this.f49886p;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void Y(Bundle bundle) {
        super.Y(bundle);
        this.f49891u = true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean g1(int i3, int i16, Callback callback) {
        PhotoInfo b16 = b();
        if (b16 == null || TextUtils.isEmpty(b16.lloc)) {
            return false;
        }
        PictureManager pictureManager = PictureManager.getInstance();
        String str = b16.lloc;
        String str2 = b16.bigUrl;
        PhotoParam photoParam = this.f49877g;
        pictureManager.getQzonePhotoListEx(str, i3, i16, str2, photoParam, photoParam.albumType, photoParam.getPhotoExType, photoParam.sharer, callback);
        return true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void z(Handler handler, String str, ArrayList<String> arrayList, EditPhoto editPhoto, int i3, Map<Integer, String> map, String str2) {
        PictureManager.getInstance().getSender().editPhotoDesc(handler, str, arrayList, editPhoto, i3, map, str2);
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void r(String str, ArrayList<String> arrayList, String str2, boolean z16, Handler handler, String str3, String str4, String str5) {
        PhotoInfo b16 = b();
        if (b16 == null) {
            return;
        }
        X(b16);
        RequestSender sender = PictureManager.getInstance().getSender();
        PhotoParam photoParam = this.f49877g;
        sender.commentPhoto(handler, photoParam.feedId, "", b16.lloc, photoParam.appid, photoParam.ownerUin, photoParam.albumid, str, 0, str2, b16.busi_param, 0, null, z16, arrayList, this.f49873c, str3, str4, str5);
    }
}
