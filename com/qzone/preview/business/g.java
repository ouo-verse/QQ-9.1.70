package com.qzone.preview.business;

import NS_MOBILE_FEEDS.cell_comm;
import NS_MOBILE_FEEDS.cell_comment;
import NS_MOBILE_FEEDS.cell_id;
import NS_MOBILE_FEEDS.cell_like;
import NS_MOBILE_FEEDS.cell_operation;
import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.EditPhoto;
import NS_MOBILE_PHOTO.MarkFaceItemFeed;
import NS_MOBILE_PHOTO.MarkFaceItemMood;
import NS_MOBILE_PHOTO.Photo;
import NS_MOBILE_PHOTO.PhotoFeedsData;
import NS_MOBILE_PHOTO.get_all_feedsphoto_ex_rsp;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.preview.service.PictureManager;
import com.qzone.preview.service.RequestSender;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.util.Pair;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.remote.Callback;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class g extends BasePicureViewController {
    protected long Q;
    protected ArrayList<PhotoParam> R;
    protected int S;
    protected boolean T;
    protected boolean U;
    protected long V;
    protected ClassLoader W;
    private int X;

    private void l1() {
        int i3;
        String str;
        String str2;
        PhotoInfo b16 = b();
        if (b16 != null && (str = b16.albumId) != null && !str.equals(this.f49877g.albumid)) {
            Iterator<PhotoParam> it = this.R.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PhotoParam next = it.next();
                if (next != null && (str2 = next.albumid) != null && str2.equals(b16.albumId)) {
                    this.f49877g = next;
                    break;
                }
            }
        }
        if (b16 == null || (i3 = b16.appid) != 311) {
            return;
        }
        PhotoParam photoParam = this.f49877g;
        photoParam.appid = i3;
        photoParam.cell_id = b16.pssCellId;
        photoParam.cell_subId = b16.pssCellSubId;
        String str3 = b16.pssUgcKey;
        photoParam.feedId = str3;
        photoParam.ugcKey = str3;
        photoParam.subid = b16.pssSubId;
        photoParam.curKey = b16.pssCurLikeKey;
        photoParam.orgKey = b16.pssOrgLikeKey;
        photoParam.busi_param = b16.pssBusiParam;
        photoParam.isLike = b16.pssHasFeedPraise;
        photoParam.likeNum = b16.praiseCount;
        photoParam.commentNum = b16.commentCount;
    }

    private void n1() {
        int i3 = this.f49873c + 10;
        int i16 = this.f49874d;
        if (i3 > i16 - 1) {
            y1(i16 + 100);
        } else if (this.f49881k + 10 > i16 - 1) {
            y1(i16 + 100);
        }
    }

    private void q1() {
        Iterator<PhotoParam> it = this.R.iterator();
        while (it.hasNext()) {
            PhotoParam next = it.next();
            if (next == null || next.albumid == null) {
                it.remove();
            }
        }
    }

    private ArrayList<PhotoInfo> r1(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<PhotoInfo> arrayList = new ArrayList<>();
        for (PhotoInfo photoInfo : this.f49872b) {
            if (photoInfo != null && str.equals(photoInfo.pssUgcKey)) {
                arrayList.add(photoInfo);
            }
        }
        return arrayList;
    }

    private PhotoParam u1(Album album) {
        PhotoParam photoParam = new PhotoParam();
        long j3 = album.uin;
        photoParam.ownerUin = j3;
        photoParam.feedUin = j3;
        photoParam.albumid = album.albumid;
        photoParam.albumType = album.type;
        int i3 = album.total;
        photoParam.albumnum = i3;
        photoParam.uploadnum = i3;
        photoParam.albumPriv = album.priv;
        String str = album.answer;
        photoParam.albumanswer = str;
        if (str == null) {
            photoParam.albumanswer = "";
        }
        photoParam.loginUin = LoginData.getInstance().getUin();
        photoParam.cell_id = photoParam.albumid;
        Map<Integer, String> map = album.busi_param;
        photoParam.busi_param = map;
        if (map != null) {
            photoParam.orgKey = map.get(5);
            photoParam.curKey = photoParam.busi_param.get(6);
        }
        photoParam.mFromRecent = true;
        return photoParam;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void C0(QZoneResult qZoneResult, int i3) {
        Bundle bundle;
        int i16;
        if (qZoneResult.getSucceed() && (bundle = qZoneResult.getBundle()) != null) {
            ClassLoader classLoader = this.W;
            if (classLoader != null) {
                bundle.setClassLoader(classLoader);
            }
            get_all_feedsphoto_ex_rsp get_all_feedsphoto_ex_rspVar = (get_all_feedsphoto_ex_rsp) bundle.get("response");
            ArrayList<PhotoInfo> parcelableArrayList = bundle.getParcelableArrayList("responseList");
            ArrayList<PhotoInfo> parcelableArrayList2 = bundle.getParcelableArrayList("cacheList");
            if (get_all_feedsphoto_ex_rspVar != null) {
                this.f49883m = get_all_feedsphoto_ex_rspVar.hasmore == 0;
                ArrayList<PhotoInfo> t16 = t1(get_all_feedsphoto_ex_rspVar.all_applist_data);
                if (t16 != null && !t16.isEmpty()) {
                    k1(t16);
                    ArrayList<PhotoParam> s16 = s1(get_all_feedsphoto_ex_rspVar.all_applist_data);
                    if (s16 != null && !s16.isEmpty()) {
                        this.R.addAll(s16);
                    }
                }
            } else if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                this.f49883m = !bundle.getBoolean("hasMore", false);
                k1(parcelableArrayList);
                ArrayList parcelableArrayList3 = bundle.getParcelableArrayList("photoParamList");
                if (parcelableArrayList3 != null && !parcelableArrayList3.isEmpty()) {
                    this.R.addAll(parcelableArrayList3);
                }
            } else if (parcelableArrayList2 != null && !parcelableArrayList2.isEmpty() && (i16 = bundle.getInt("start", 0)) >= 0) {
                if ((parcelableArrayList2.size() + i16) - 1 < this.f49880j) {
                    p1(i16, parcelableArrayList2);
                } else if (i16 > this.f49881k) {
                    k1(parcelableArrayList2);
                    this.f49883m = this.f49881k >= this.S - 1 && !this.T;
                }
            }
            if (this.f49883m) {
                m1();
            }
        }
        this.f49886p = true;
        this.U = false;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void K0(Bundle bundle) {
        super.K0(bundle);
        this.Q = bundle.getLong("key_owner_uin", 0L);
        ArrayList<PhotoParam> parcelableArrayList = bundle.getParcelableArrayList("key_photo_param_list");
        this.R = parcelableArrayList;
        if (parcelableArrayList == null) {
            this.R = new ArrayList<>();
        }
        this.S = bundle.getInt("key_photo_info_cache_count", 0);
        this.T = bundle.getBoolean("key_has_more_network_data", true);
        this.f49884n = 3;
        this.f49886p = true;
        this.W = bundle.getClassLoader();
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void M0(Bundle bundle) {
        super.M0(bundle);
        bundle.putLong("key_owner_uin", this.Q);
        bundle.putParcelableArrayList("key_photo_param_list", this.R);
        bundle.putInt("key_photo_info_cache_count", this.S);
        bundle.putBoolean("key_has_more_network_data", this.T);
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void Q(Callback callback) {
        int i3 = this.f49873c;
        int i16 = this.f49884n;
        if (i3 - i16 > this.f49880j && i3 + i16 < this.f49881k) {
            this.f49890t = true;
        } else {
            super.Q(callback);
        }
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean X0() {
        return this.f49886p;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void Y(Bundle bundle) {
        super.Y(bundle);
        this.f49891u = true;
        this.Q = bundle.getLong("key_uin");
        this.R = bundle.getParcelableArrayList(PictureConst.KEY_PHOTO_PARAM_LIST);
        this.X = bundle.getInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        if (this.R == null) {
            this.R = new ArrayList<>();
        } else {
            q1();
        }
        this.T = bundle.getBoolean(PictureConst.KEY_HAS_MORE, true);
        boolean z16 = false;
        int i3 = bundle.getInt(PictureConst.KEY_INDEX_OFFSET, 0);
        this.f49885o = i3;
        if (i3 < 0) {
            this.f49885o = 0;
        }
        int i16 = this.f49874d;
        y1(this.f49885o + i16);
        int i17 = this.f49873c;
        int i18 = this.f49885o;
        this.f49873c = i17 + i18;
        this.f49880j = i18;
        this.f49885o = 0;
        this.f49882l = i18 <= 0;
        this.f49881k = (i18 + i16) - 1;
        int i19 = bundle.getInt(PictureConst.KEY_CACHE_COUNT, 0);
        this.S = i19;
        int i26 = this.f49881k;
        if (i19 <= i26 + 1) {
            this.S = i26 + 1;
        }
        if (i26 >= this.S - 1 && !this.T) {
            z16 = true;
        }
        this.f49883m = z16;
        this.f49884n = 3;
        this.f49886p = true;
        if (!z16) {
            n1();
        }
        this.W = bundle.getClassLoader();
    }

    @Override // com.qzone.preview.business.BasePicureViewController, com.tencent.common.galleryactivity.e
    public void a(int i3) {
        super.a(i3);
        l1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k1(ArrayList<PhotoInfo> arrayList) {
        o1(arrayList.size());
        int i3 = this.f49881k + 1;
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            int i17 = i3 + i16;
            PhotoInfo[] photoInfoArr = this.f49872b;
            if (i17 >= photoInfoArr.length) {
                break;
            }
            photoInfoArr[i17] = arrayList.get(i16);
        }
        this.f49881k += arrayList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m1() {
        y1(this.f49881k + 1);
        int i3 = this.f49873c;
        int i16 = this.f49874d;
        if (i3 > i16 - 1) {
            this.f49873c = i16 - 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o1(int i3) {
        int i16 = this.f49881k + i3 + 10;
        int i17 = this.f49874d;
        if (i16 > i17 - 1) {
            y1(i17 + 100);
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
                e16.printStackTrace();
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

    protected void w1(long j3, int i3, int i16, Callback callback) {
        PictureManager.getInstance().getCacheRecentPhotoList(j3, i3, i16, this.X, callback);
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void x0(Callback callback) {
        if (!this.f49883m) {
            n1();
        }
        super.x0(callback);
        if (this.f49873c + this.f49884n <= this.f49881k || this.f49883m || this.U) {
            return;
        }
        g1(0, 1, callback);
        this.f49879i = this.f49873c;
    }

    protected void x1(long j3, Callback callback) {
        PictureManager.getInstance().getMoreRecentPhotoList(j3, this.X, callback);
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void z(Handler handler, String str, ArrayList<String> arrayList, EditPhoto editPhoto, int i3, Map<Integer, String> map, String str2) {
        PictureManager.getInstance().getSender().editPhotoDesc(handler, str, arrayList, editPhoto, i3, map, str2);
    }

    private ArrayList<PhotoParam> s1(ArrayList<PhotoFeedsData> arrayList) {
        Album album;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList<PhotoParam> arrayList2 = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            PhotoFeedsData photoFeedsData = arrayList.get(i3);
            if (photoFeedsData != null && (album = photoFeedsData.album) != null && z1(album)) {
                arrayList2.add(u1(album));
            }
        }
        return arrayList2;
    }

    public static ArrayList<PhotoInfo> t1(ArrayList<PhotoFeedsData> arrayList) {
        ArrayList<Photo> arrayList2;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList<PhotoInfo> arrayList3 = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            PhotoFeedsData photoFeedsData = arrayList.get(i3);
            if (photoFeedsData != null && (arrayList2 = photoFeedsData.photolist) != null && !arrayList2.isEmpty()) {
                Album album = photoFeedsData.album;
                ArrayList<Photo> arrayList4 = photoFeedsData.photolist;
                for (int i16 = 0; i16 < arrayList4.size(); i16++) {
                    Photo photo = arrayList4.get(i16);
                    if (photo != null) {
                        PhotoInfo photoInfo = new PhotoInfo();
                        PictureViewerFactory.g0(photoInfo, photo, album != null ? album.type : 1);
                        String str = photo.albumid;
                        photoInfo.albumId = str;
                        if (album != null) {
                            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(album.albumid)) {
                                photoInfo.albumId = album.albumid;
                            }
                            photoInfo.allow_share = album.allow_share;
                            photoInfo.opMask = album.opmask;
                            photoInfo.albumName = album.name;
                        }
                        if (!TextUtils.isEmpty(photoInfo.orgUrl) && photoInfo.hasLocalOrgFile == null) {
                            photoInfo.hasLocalOrgFile = Boolean.valueOf(ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) != null);
                        }
                        int i17 = photoFeedsData.appid;
                        photoInfo.appid = i17;
                        if (i17 == 311) {
                            cell_id cell_idVar = photoFeedsData.pss_cell_id;
                            if (cell_idVar != null) {
                                photoInfo.pssCellId = cell_idVar.cellid;
                                photoInfo.pssCellSubId = cell_idVar.subid;
                            }
                            cell_comm cell_commVar = photoFeedsData.pss_cell_comm;
                            if (cell_commVar != null) {
                                photoInfo.pssUgcKey = cell_commVar.ugckey;
                                photoInfo.pssSubId = cell_commVar.subid;
                                photoInfo.pssCurLikeKey = cell_commVar.curlikekey;
                                photoInfo.pssOrgLikeKey = cell_commVar.orglikekey;
                            }
                            cell_operation cell_operationVar = photoFeedsData.pss_cell_operation;
                            if (cell_operationVar != null) {
                                photoInfo.pssBusiParam = cell_operationVar.busi_param;
                            }
                            cell_like cell_likeVar = photoFeedsData.pss_cell_like;
                            if (cell_likeVar != null) {
                                photoInfo.pssHasFeedPraise = cell_likeVar.isliked == 1;
                                photoInfo.praiseCount = cell_likeVar.num;
                            }
                            cell_comment cell_commentVar = photoFeedsData.pss_cell_comment;
                            if (cell_commentVar != null) {
                                photoInfo.commentCount = cell_commentVar.num;
                            }
                        }
                        BasePicureViewController.B(photoInfo, photo);
                        arrayList3.add(photoInfo);
                    }
                }
            }
        }
        return arrayList3;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean B0(PhotoInfo photoInfo, boolean z16, int i3, int i16) {
        if (photoInfo == null || photoInfo.appid != 311) {
            return false;
        }
        ArrayList<PhotoInfo> r16 = r1(photoInfo.pssUgcKey);
        if (r16 != null && !r16.isEmpty()) {
            Iterator<PhotoInfo> it = r16.iterator();
            while (it.hasNext()) {
                PhotoInfo next = it.next();
                if (next != null) {
                    if (next.isIndependentUgc == 0) {
                        next.hasPraise = z16;
                    }
                    next.pssHasFeedPraise = z16;
                    next.praiseCount = i3;
                    next.commentCount = i16;
                }
            }
        }
        return true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void E0(Handler handler) {
        PhotoInfo b16 = b();
        if (b16 == null) {
            return;
        }
        PhotoParam photoParam = this.f49877g;
        if (photoParam.appid == 311) {
            int i3 = 1;
            if (b16.isIndependentUgc != 0 && !photoParam.isFriendPhotoBizFeed) {
                if (((b16.hasPraise ? 1 : 2) & b16.opsynflag) == 0) {
                    i3 = 0;
                }
            }
            RequestSender sender = PictureManager.getInstance().getSender();
            PhotoParam photoParam2 = this.f49877g;
            sender.praisePhoto(handler, photoParam2.feedId, "", photoParam2.curKey, photoParam2.orgKey, b16.hasPraise, photoParam2.appid, b16.busi_param, i3, this.f49873c);
            return;
        }
        RequestSender sender2 = PictureManager.getInstance().getSender();
        PhotoParam photoParam3 = this.f49877g;
        sender2.praisePhoto(handler, photoParam3.feedId, "", b16.curkey, b16.unikey, b16.hasPraise, photoParam3.appid, b16.busi_param, 0, this.f49873c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p1(int i3, ArrayList<PhotoInfo> arrayList) {
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            this.f49872b[i3 + i16] = arrayList.get(i16);
        }
        this.f49880j = i3;
        this.f49882l = i3 <= 0;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void r(String str, ArrayList<String> arrayList, String str2, boolean z16, Handler handler, String str3, String str4, String str5) {
        PhotoInfo b16 = b();
        if (b16 == null) {
            return;
        }
        X(b16);
        if (this.f49877g.appid == 311) {
            Pair<String, String> pair = v1(b16) ? new Pair<>(b16.currentUrl, b16.bigUrl) : null;
            RequestSender sender = PictureManager.getInstance().getSender();
            PhotoParam photoParam = this.f49877g;
            sender.commentPhoto(handler, photoParam.feedId, "", b16.lloc, photoParam.appid, photoParam.ownerUin, photoParam.cell_id, str, 0, str2, b16.busi_param, 0, pair, z16, arrayList, this.f49873c, str3, str4, str5);
            return;
        }
        RequestSender sender2 = PictureManager.getInstance().getSender();
        PhotoParam photoParam2 = this.f49877g;
        sender2.commentPhoto(handler, photoParam2.feedId, "", b16.lloc, photoParam2.appid, photoParam2.ownerUin, photoParam2.albumid, str, 0, str2, b16.busi_param, 0, null, z16, arrayList, this.f49873c, str3, str4, str5);
    }

    protected void y1(int i3) {
        if (i3 <= 0 || i3 < this.f49881k + 1 || i3 == this.f49874d) {
            return;
        }
        this.f49874d = i3;
        PhotoInfo[] photoInfoArr = this.f49872b;
        this.f49872b = new PhotoInfo[i3];
        if (photoInfoArr != null) {
            int length = photoInfoArr.length;
            for (int i16 = 0; i16 < length; i16++) {
                int i17 = this.f49885o;
                if (i16 + i17 >= 0 && i16 + i17 < this.f49874d) {
                    this.f49872b[i17 + i16] = photoInfoArr[i16];
                }
            }
        }
    }

    private boolean z1(Album album) {
        String str;
        if (album == null || album.albumid == null) {
            return false;
        }
        Iterator<PhotoParam> it = this.R.iterator();
        while (it.hasNext()) {
            PhotoParam next = it.next();
            if (next != null && (str = next.albumid) != null && str.equals(album.albumid)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean g1(int i3, int i16, Callback callback) {
        if ((i3 != 0 && this.f49882l) || this.f49873c - this.f49884n > this.f49880j) {
            i3 = 0;
        }
        if ((i16 != 0 && this.f49883m) || this.f49873c + this.f49884n < this.f49881k) {
            i16 = 0;
        }
        if (i3 == 0 && i16 == 0) {
            return false;
        }
        if ((this.U && System.currentTimeMillis() - this.V < 180000) || b() == null) {
            return false;
        }
        long j3 = this.Q;
        if (j3 < 10001) {
            j3 = this.f49877g.ownerUin;
        }
        if (i3 != 0) {
            int i17 = this.f49880j;
            int i18 = i17 - 50;
            w1(j3, i18 < 0 ? 0 : i18, i17, callback);
        }
        if (i16 != 0) {
            int i19 = this.f49881k;
            int i26 = this.S;
            if (i19 < i26 - 1) {
                int i27 = i19 + 1;
                int i28 = i27 + 50;
                w1(j3, i27, i28 > i26 ? i26 : i28, callback);
            } else {
                x1(j3, callback);
            }
        }
        this.U = true;
        this.V = System.currentTimeMillis();
        return true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void u(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return;
        }
        if (photoInfo.appid != 311) {
            super.u(photoInfo);
            return;
        }
        ArrayList<PhotoInfo> r16 = r1(photoInfo.pssUgcKey);
        if (r16 == null || r16.isEmpty()) {
            return;
        }
        Iterator<PhotoInfo> it = r16.iterator();
        while (it.hasNext()) {
            PhotoInfo next = it.next();
            if (next != null) {
                next.commentCount++;
            }
        }
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void w(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return;
        }
        if (photoInfo.appid != 311) {
            super.w(photoInfo);
            return;
        }
        boolean z16 = !photoInfo.hasPraise;
        photoInfo.hasPraise = z16;
        if (photoInfo.isIndependentUgc == 0 || (z16 && !photoInfo.pssHasFeedPraise)) {
            photoInfo.pssHasFeedPraise = z16;
            ArrayList<PhotoInfo> r16 = r1(photoInfo.pssUgcKey);
            if (r16 == null || r16.isEmpty()) {
                return;
            }
            Iterator<PhotoInfo> it = r16.iterator();
            while (it.hasNext()) {
                PhotoInfo next = it.next();
                if (next != null) {
                    boolean z17 = photoInfo.pssHasFeedPraise;
                    next.pssHasFeedPraise = z17;
                    if (next.isIndependentUgc == 0) {
                        next.hasPraise = z17;
                    }
                    if (z17) {
                        next.praiseCount++;
                    } else {
                        next.praiseCount--;
                    }
                }
            }
        }
    }

    private boolean v1(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return false;
        }
        PhotoParam photoParam = this.f49877g;
        int i3 = photoParam.appid;
        return (i3 == 311 || i3 == 6100 || i3 == 2) && photoParam.uploadnum > 1;
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
