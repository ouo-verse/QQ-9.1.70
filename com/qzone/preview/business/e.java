package com.qzone.preview.business;

import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_PHOTO.EditPhoto;
import NS_MOBILE_PHOTO.MarkFaceItemFeed;
import NS_MOBILE_QUN.Album;
import NS_MOBILE_QUN.qun_get_photo_list_ex_rsp;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.service.PictureManager;
import com.qzone.preview.service.RequestSender;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.remote.Callback;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e extends BasePicureViewController {
    private int Q = 0;

    @Override // com.qzone.preview.business.BasePicureViewController
    public void C0(QZoneResult qZoneResult, int i3) {
        Bundle bundle;
        ArrayList<s_picdata> arrayList;
        boolean z16;
        int i16;
        ArrayList<s_picdata> arrayList2;
        if (qZoneResult.getSucceed() && (bundle = qZoneResult.getBundle()) != null) {
            int i17 = bundle.getInt("type", 0);
            qun_get_photo_list_ex_rsp qun_get_photo_list_ex_rspVar = (qun_get_photo_list_ex_rsp) bundle.get("response");
            if (qun_get_photo_list_ex_rspVar == null || (arrayList = qun_get_photo_list_ex_rspVar.photolist) == null || arrayList.size() == 0) {
                return;
            }
            Album album = qun_get_photo_list_ex_rspVar.albuminfo;
            if (album != null) {
                this.f49877g.albumPriv = album.priv;
            }
            int i18 = qun_get_photo_list_ex_rspVar.index;
            if (i18 < 0) {
                this.f49873c = 0;
                this.f49882l = true;
                this.f49883m = qun_get_photo_list_ex_rspVar.right_finish > 0;
            } else {
                this.f49873c = (i18 - this.f49879i) + this.f49873c;
                this.f49879i = i18;
                this.f49882l = qun_get_photo_list_ex_rspVar.left_finish > 0;
                this.f49883m = qun_get_photo_list_ex_rspVar.right_finish > 0;
            }
            if (this.f49883m) {
                QZLog.d("[PhotoAlbum]BasePicureViewController", 4, "get_photo_list_ex_rsp | Reaching the right most of the photo list");
            } else {
                this.f49895y = null;
            }
            Album album2 = qun_get_photo_list_ex_rspVar.albuminfo;
            if (album2 == null || (i16 = album2.total) <= 0 || i16 == this.f49874d) {
                z16 = false;
            } else {
                if (i17 == 75 && (arrayList2 = qun_get_photo_list_ex_rspVar.photolist) != null) {
                    this.f49874d = arrayList2.size();
                } else {
                    this.f49874d = i16;
                }
                this.f49877g.albumid = qun_get_photo_list_ex_rspVar.albuminfo.albumid;
                z16 = true;
            }
            I0(i3);
            PhotoParam photoParam = this.f49877g;
            photoParam.appid = qun_get_photo_list_ex_rspVar.appid;
            photoParam.qunid = this.Q + "";
            v0(qun_get_photo_list_ex_rspVar.photolist, this.f49879i, z16, i17, qun_get_photo_list_ex_rspVar.albuminfo);
        }
        this.f49886p = true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void E0(Handler handler) {
        PhotoInfo b16 = b();
        if (b16 == null) {
            return;
        }
        b16.busi_param.put(12, b16.albumId);
        b16.busi_param.put(1, b16.sloc);
        b16.busi_param.put(15, b16.bigUrl);
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
        if (this.Q == 0) {
            this.Q = b16.appid;
        }
        PictureManager.getInstance().getQzoneQunPhotoListEx(this.Q, Long.valueOf(b16.uploaduin), b16.albumId, b16.lloc, null, 1, b16.bigUrl, new HashMap<>(), callback);
        return true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void r(String str, ArrayList<String> arrayList, String str2, boolean z16, Handler handler, String str3, String str4, String str5) {
        PhotoInfo b16 = b();
        if (b16 == null) {
            return;
        }
        X(b16);
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void z(Handler handler, String str, ArrayList<String> arrayList, EditPhoto editPhoto, int i3, Map<Integer, String> map, String str2) {
        PictureManager.getInstance().getSender().editPhotoDesc(handler, str, arrayList, editPhoto, i3, map, str2);
    }
}
