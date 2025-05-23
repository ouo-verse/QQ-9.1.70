package com.qzone.preview.business;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.MarkFaceItemFeed;
import NS_MOBILE_PHOTO.MarkFaceItemMood;
import NS_MOBILE_PHOTO.Photo;
import NS_MOBILE_PHOTO.get_photo_list_ex_rsp;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.album.data.model.RecomAlbumList;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.service.PictureManager;
import com.qzone.preview.service.RequestSender;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.remote.Callback;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends BasePicureViewController {
    private int Q = 1;

    private void l1(get_photo_list_ex_rsp get_photo_list_ex_rspVar, int i3) {
        PhotoInfo[] photoInfoArr;
        if (QZoneConfigHelper.q() && this.f49877g.appid == 311 && (photoInfoArr = this.f49872b) != null && i3 < photoInfoArr.length && get_photo_list_ex_rspVar.index == 0 && i3 != 0) {
            PhotoInfo photoInfo = photoInfoArr[i3];
            if (photoInfo != null && !TextUtils.isEmpty(photoInfo.lloc)) {
                QLog.d("[PhotoAlbum]BasePicureViewController", 1, "tryFixIndexMissError current lloc:", photoInfo.lloc);
                int i16 = 0;
                while (true) {
                    if (i16 < get_photo_list_ex_rspVar.photolist.size()) {
                        Photo photo = get_photo_list_ex_rspVar.photolist.get(i16);
                        if (photo != null && !TextUtils.isEmpty(photo.lloc) && TextUtils.equals(photoInfo.lloc, photo.lloc)) {
                            QLog.d("[PhotoAlbum]BasePicureViewController", 1, "tryFixIndexMissError find match photoInfo target index:", Integer.valueOf(i16));
                            break;
                        }
                        i16++;
                    } else {
                        break;
                    }
                }
                if (i16 > 0) {
                    this.f49873c = i16;
                    this.f49879i = i16;
                    this.f49882l = true;
                    this.f49883m = true;
                    return;
                }
                return;
            }
            QLog.e("[PhotoAlbum]BasePicureViewController", 1, "tryFixIndexMissError curItem is null!");
        }
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void C0(QZoneResult qZoneResult, int i3) {
        Bundle bundle;
        ArrayList<Photo> arrayList;
        int i16;
        if (qZoneResult.getSucceed() && (bundle = qZoneResult.getBundle()) != null) {
            boolean z16 = false;
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
                this.f49873c = i18;
                this.f49879i = i18;
                this.f49882l = get_photo_list_ex_rspVar.left_finish > 0;
                this.f49883m = get_photo_list_ex_rspVar.right_finish > 0;
                l1(get_photo_list_ex_rspVar, i3);
            }
            if (this.f49883m && h0()) {
                QZLog.d("[PhotoAlbum]BasePicureViewController", 4, "get_photo_list_ex_rsp | Reaching the right most of the photo list");
                D0(get_photo_list_ex_rspVar.features);
            } else {
                this.f49895y = null;
            }
            Album album2 = get_photo_list_ex_rspVar.albuminfo;
            if (album2 != null && (i16 = album2.total) > 0 && i16 != this.f49874d) {
                this.f49874d = i16;
                z16 = true;
            }
            boolean z17 = (this.f49877g.appid != 311 || this.f49872b.length >= this.f49874d) ? z16 : true;
            I0(i3);
            u0(get_photo_list_ex_rspVar.photolist, this.f49879i, z17, i17, get_photo_list_ex_rspVar.albuminfo);
        }
        this.f49886p = true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public int D() {
        PhotoParam photoParam = this.f49877g;
        if (photoParam.appid == 4) {
            return super.D();
        }
        return photoParam.commentNum;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.preview.business.BasePicureViewController
    public void D0(Map<Integer, byte[]> map) {
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_ALBUM_GALLERY_SWITCH, 0);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < config) {
            QZLog.i("[PhotoAlbum]BasePicureViewController", 2, "[parseRecomAlbumListForPhotoList] current sdk ", Integer.valueOf(i3), " less than lessSdkVersion ", Integer.valueOf(config));
            return;
        }
        this.f49895y = new RecomAlbumList();
        this.f49895y.parsedFromFeature(map, QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_ALBUM_GALLERY_UPPER_BOUND, -1), QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_ALBUM_GALLERY_DOWNNER_BOUND, 2));
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void E0(Handler handler) {
        int i3;
        int i16;
        PhotoInfo b16 = b();
        if (b16 == null) {
            return;
        }
        if (BasePicureViewController.y0(this.f49878h) && (!this.f49877g.isVideoPicMix || !TextUtils.isEmpty(b16.unikey))) {
            if (!TextUtils.isEmpty(b16.unikey)) {
                if (b16.isIndependentUgc == 0 || this.f49877g.isFriendPhotoBizFeed) {
                    i16 = 1;
                } else {
                    i16 = (b16.opsynflag & (b16.hasPraise ? 1 : 2)) != 0 ? 1 : 0;
                }
                RequestSender sender = PictureManager.getInstance().getSender();
                PhotoParam photoParam = this.f49877g;
                sender.praisePhoto(handler, photoParam.feedId, "", b16.curkey, b16.unikey, b16.hasPraise, photoParam.appid, b16.busi_param, i16, this.f49873c);
                return;
            }
            if (BasePicureViewController.p(b16)) {
                if (b16.busi_param == null) {
                    b16.busi_param = new HashMap();
                }
                b16.busi_param.put(12, b16.albumId);
                b16.busi_param.put(2, b16.lloc);
                PictureManager.getInstance().getSender().praisePhoto(handler, "", "", "", "", b16.hasPraise, this.f49877g.appid, b16.busi_param, 0, -1);
                return;
            }
            return;
        }
        if (b16.isIndependentUgc == 0 || this.f49877g.isFriendPhotoBizFeed) {
            i3 = 1;
        } else {
            i3 = (b16.opsynflag & (b16.hasPraise ? 1 : 2)) != 0 ? 1 : 0;
        }
        RequestSender sender2 = PictureManager.getInstance().getSender();
        PhotoParam photoParam2 = this.f49877g;
        sender2.praisePhoto(handler, photoParam2.feedId, "", photoParam2.curKey, photoParam2.orgKey, b16.hasPraise, photoParam2.appid, b16.busi_param, i3, this.f49873c);
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public int N() {
        PhotoParam photoParam = this.f49877g;
        int i3 = photoParam.appid;
        if (i3 != 4 && i3 != 202) {
            return photoParam.likeNum;
        }
        return super.N();
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean P0(Handler handler) {
        PhotoInfo b16 = b();
        if (b16 == null) {
            return false;
        }
        if (b16.commentCount <= 0 && this.f49877g.commentNum <= 0) {
            return false;
        }
        String str = b16.albumId;
        PictureManager.getInstance().getQzonePhotoComment(b16.lloc, str, b16.busi_param.get(21), this.f49877g, handler);
        return true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean X0() {
        int i3;
        PhotoParam photoParam = this.f49877g;
        if (photoParam != null && ((i3 = photoParam.appid) == 2 || i3 == 6100)) {
            return false;
        }
        PhotoInfo item = getItem(this.f49873c);
        boolean z16 = (item == null || item.unikey == null) ? false : true;
        int i16 = this.f49878h;
        if ((i16 != 2 || this.f49886p) && i16 != 3) {
            return z16;
        }
        return false;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void Y(Bundle bundle) {
        Map<Integer, String> map;
        PhotoParam photoParam;
        super.Y(bundle);
        if (bundle.containsKey(PictureConst.KEY_PHTOTCOUNT) && bundle.getInt(PictureConst.KEY_PHTOTCOUNT) > 0) {
            this.f49874d = bundle.getInt(PictureConst.KEY_PHTOTCOUNT);
        }
        if (bundle.getInt("mode") == 1 && (photoParam = this.f49877g) != null && !TextUtils.isEmpty(photoParam.albumid) && this.f49877g.appid == 4) {
            this.f49878h = 2;
        }
        PhotoParam photoParam2 = this.f49877g;
        if (photoParam2 != null && (map = photoParam2.busi_param) != null) {
            String str = map.get(16);
            if (!TextUtils.isEmpty(str)) {
                this.f49878h = Integer.valueOf(str).intValue();
            }
        }
        ArrayList arrayList = (ArrayList) bundle.getSerializable("picturelist");
        if (arrayList != null && arrayList.size() > 0) {
            this.f49891u = (((PhotoInfo) arrayList.get(0)).opMask & 268435456) == 0;
        } else {
            this.f49891u = true;
        }
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    protected void h1() {
        PhotoInfo[] photoInfoArr = this.f49872b;
        if (photoInfoArr == null) {
            return;
        }
        for (PhotoInfo photoInfo : photoInfoArr) {
            if (photoInfo != null) {
                boolean z16 = photoInfo.hasPraise;
                if (z16) {
                    photoInfo.praiseCount--;
                } else {
                    photoInfo.praiseCount++;
                }
                photoInfo.hasPraise = !z16;
            }
        }
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean s() {
        if (this.f49877g.appid == 311 && F().isIndependentUgc == 0) {
            return this.f49877g.isLike;
        }
        return super.s();
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void u(PhotoInfo photoInfo) {
        super.u(photoInfo);
        if (this.Q == 1) {
            this.f49877g.commentNum++;
        }
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void v() {
        PhotoInfo photoInfo;
        PhotoParam photoParam = this.f49877g;
        if (photoParam.appid == 311 && !TextUtils.isEmpty(photoParam.ugcKey)) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = this.f49880j; i3 < this.f49881k; i3++) {
                if (i3 >= 0) {
                    PhotoInfo[] photoInfoArr = this.f49872b;
                    if (i3 < photoInfoArr.length && ((photoInfo = photoInfoArr[i3]) == null || this.f49877g.ugcKey.equals(photoInfo.pssUgcKey))) {
                        arrayList.add(Integer.valueOf(i3));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                super.v();
                return;
            }
            try {
                this.f49872b = (PhotoInfo[]) com.qzone.util.d.c(this.f49872b, arrayList);
            } catch (Exception e16) {
                QZLog.e("[PhotoAlbum]BasePicureViewController", "catch an exception:", e16);
            }
            int size = arrayList.size();
            Iterator it = arrayList.iterator();
            int i16 = 0;
            while (it.hasNext()) {
                if (((Integer) it.next()).intValue() < this.f49873c) {
                    i16++;
                }
            }
            int i17 = this.f49873c - i16;
            this.f49873c = i17;
            int i18 = this.f49874d;
            if (i17 == i18 - size) {
                this.f49873c = i17 - 1;
            }
            this.f49874d = i18 - size;
            this.f49881k -= size;
            return;
        }
        super.v();
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean g1(int i3, int i16, Callback callback) {
        PhotoInfo b16 = b();
        if (b16 == null) {
            return false;
        }
        if (!BasePicureViewController.y0(this.f49878h) && !this.f49896z) {
            return false;
        }
        PictureManager.getInstance().getQzonePhotoListEx(b16.lloc, i3, i16, b16.bigUrl, this.f49877g, 0L, 0, 0L, callback);
        return true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void r(String str, ArrayList<String> arrayList, String str2, boolean z16, Handler handler, String str3, String str4, String str5) {
        PhotoInfo b16 = b();
        if (b16 == null) {
            return;
        }
        X(b16);
        this.Q = 1;
        if (b16.isIndependentUgc != 0 && (b16.opsynflag & 4) == 0) {
            this.Q = 0;
        }
        boolean k16 = k1(b16);
        if (this.f49877g.appid == 4) {
            RequestSender sender = PictureManager.getInstance().getSender();
            PhotoParam photoParam = this.f49877g;
            sender.commentPhoto(handler, photoParam.feedId, "", b16.lloc, photoParam.appid, photoParam.ownerUin, photoParam.albumid, str, 0, str2, b16.busi_param, this.Q, k16 ? new Pair<>(b16.currentUrl, b16.bigUrl) : null, z16, arrayList, this.f49873c, str3, str4, str5);
        } else {
            RequestSender sender2 = PictureManager.getInstance().getSender();
            PhotoParam photoParam2 = this.f49877g;
            sender2.commentPhoto(handler, photoParam2.feedId, "", b16.lloc, photoParam2.appid, photoParam2.ownerUin, photoParam2.cell_id, str, 0, str2, b16.busi_param, this.Q, k16 ? new Pair<>(b16.currentUrl, b16.bigUrl) : null, z16, arrayList, this.f49873c, str3, str4, str5);
        }
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    protected void d1(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return;
        }
        boolean z16 = photoInfo.hasPraise;
        PhotoParam photoParam = this.f49877g;
        if (z16 != photoParam.isLike) {
            if (z16) {
                photoParam.likeNum++;
            } else {
                photoParam.likeNum--;
            }
            photoParam.isLike = z16;
        }
    }

    private boolean k1(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return false;
        }
        PhotoParam photoParam = this.f49877g;
        int i3 = photoParam.appid;
        if (i3 == 4) {
            if (photoParam.uploadnum <= 1 || (photoInfo.opsynflag & 8) == 0) {
                return false;
            }
        } else {
            if (i3 == 311) {
                return false;
            }
            if ((i3 != 6100 && i3 != 2) || photoParam.uploadnum <= 1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean z0(PhotoInfo photoInfo) {
        return photoInfo != null && photoInfo.isIndependentUgc == 0 && this.f49877g.appid == 311;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void O0(FaceData faceData, int i3, int i16) {
        String str;
        String str2;
        int i17 = this.f49877g.appid;
        if (i17 == 4) {
            MarkFaceItemFeed markFaceItemFeed = new MarkFaceItemFeed();
            markFaceItemFeed.albumid = faceData.album_id;
            markFaceItemFeed.faceinfo = FaceData.FaceDataTostFaceItem(faceData);
            markFaceItemFeed.f25031op = i16;
            markFaceItemFeed.photoid = faceData.photo_id;
            if (b() == null) {
                str2 = "";
            } else {
                str2 = b().unikey;
            }
            QZLog.d("[PhotoAlbum]FaceFuntion", 1, "[sendRequest] albumid:", markFaceItemFeed.albumid, " op:", Integer.valueOf(markFaceItemFeed.f25031op), " photoid:", markFaceItemFeed.photoid, " scene:", 2, " index:", Integer.valueOf(i3), " unikey:", str2);
            PictureManager.getInstance().faceOperation(J(), null, markFaceItemFeed, L(), 2, str2, i3);
            return;
        }
        if (i17 == 311) {
            MarkFaceItemMood markFaceItemMood = new MarkFaceItemMood();
            markFaceItemMood.f25032op = i16;
            markFaceItemMood.faceinfo = FaceData.FaceDataTostFaceItem(faceData);
            markFaceItemMood.shuoshuo_id = this.f49877g.cell_id;
            markFaceItemMood.photo_url = b().bigUrl;
            if (b() == null) {
                str = "";
            } else {
                str = b().unikey;
            }
            QZLog.d("[PhotoAlbum]FaceFuntion", 1, "[sendRequest] shuoshuo_id:", markFaceItemMood.shuoshuo_id, " op:", Integer.valueOf(markFaceItemMood.f25032op), " scene:", 1, " photo_url:", markFaceItemMood.photo_url, " index:", Integer.valueOf(i3), " unikey:", str);
            PictureManager.getInstance().faceOperation(J(), markFaceItemMood, null, L(), 1, str, i3);
        }
    }
}
