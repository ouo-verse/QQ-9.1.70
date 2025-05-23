package com.qzone.preview.business;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.qzone.common.account.LoginData;
import com.qzone.preview.service.PictureManager;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.component.app.common.ParcelableWrapper;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends BasePicureViewController {
    private ArrayList<BusinessFeedData> Q;
    private List<PhotoParam> R = new ArrayList();

    private void k1(ArrayList<BusinessFeedData> arrayList) {
        Iterator<BusinessFeedData> it = arrayList.iterator();
        while (it.hasNext()) {
            BusinessFeedData next = it.next();
            PhotoParam photoParam = new PhotoParam();
            photoParam.appid = next.getFeedCommInfo().appid;
            photoParam.ownerUin = next.getUser().uin;
            photoParam.isLike = next.getLikeInfo().isLiked;
            photoParam.likeNum = next.getLikeInfo().likeNum;
            photoParam.commentNum = next.getCommentInfo().commentNum;
            photoParam.feedUin = next.getUser().uin;
            photoParam.isOnePictureFeed = false;
            photoParam.feedId = next.getIdInfo().cellId;
            photoParam.cell_id = next.getIdInfo().cellId;
            photoParam.ugcKey = next.getFeedCommInfo().ugckey;
            this.R.add(photoParam);
        }
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean B0(PhotoInfo photoInfo, boolean z16, int i3, int i16) {
        int selectedIndex = getSelectedIndex();
        ArrayList<BusinessFeedData> arrayList = this.Q;
        if (arrayList == null) {
            QZLog.w("QzoneFriendVideoPictureViewController", "onReturnFromDetailPage ,feedDatas is null");
            return false;
        }
        BusinessFeedData businessFeedData = arrayList.get(selectedIndex);
        businessFeedData.getLikeInfo().isLiked = z16;
        businessFeedData.getLikeInfo().likeNum = i3;
        businessFeedData.getCommentInfo().commentNum = i16;
        PhotoInfo F = F();
        F.hasPraise = z16;
        F.commentCount = i16;
        F.praiseCount = i3;
        return super.B0(photoInfo, z16, i3, i16);
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void C(String str, String str2, Handler handler) {
        int selectedIndex = getSelectedIndex();
        ArrayList<BusinessFeedData> arrayList = this.Q;
        if (arrayList != null) {
            PictureManager.getInstance().getSender().forwardFriendVideo(handler, arrayList.get(selectedIndex), str2, str);
        }
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public String E() {
        return this.f49877g.ownerUin + "_" + this.f49877g.feedId;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void E0(Handler handler) {
        super.E0(handler);
        PhotoInfo b16 = b();
        if (b16 != null && this.Q != null) {
            BusinessFeedData businessFeedData = this.Q.get(getSelectedIndex());
            businessFeedData.getLikeInfo().isLiked = b16.hasPraise;
            businessFeedData.getCellUserInfo().uniKey = b16.unikey;
            PictureManager.getInstance().getSender().praiseFriendVideo(handler, businessFeedData);
            return;
        }
        QZLog.w("QzoneFriendVideoPictureViewController", "praisePhoto ,photoInfo or feedDatas is null");
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void R0(Intent intent) {
        ParcelableWrapper.putArrayListToIntent(intent, PictureConst.KEY_FRIEND_VIDEO_DATA_LIST, this.Q);
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean X0() {
        return true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void Y(Bundle bundle) {
        super.Y(bundle);
        this.f49891u = true;
        ArrayList<BusinessFeedData> arrayListFromBundle = ParcelableWrapper.getArrayListFromBundle(bundle, PictureConst.KEY_FRIEND_VIDEO_DATA_LIST);
        this.Q = arrayListFromBundle;
        k1(arrayListFromBundle);
    }

    @Override // com.qzone.preview.business.BasePicureViewController, com.tencent.common.galleryactivity.e
    public void a(int i3) {
        super.a(i3);
        if (i3 >= 0 && i3 < this.R.size()) {
            this.f49877g = this.R.get(i3);
            return;
        }
        QZLog.w("QzoneFriendVideoPictureViewController", "OutOfArrayIndex setSelectedIndex:index=" + i3);
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean g() {
        return true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean j() {
        return true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean k() {
        if (LoginData.getInstance().getUin() != this.f49877g.ownerUin) {
            return true;
        }
        return super.k();
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean l() {
        return false;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public boolean n() {
        return true;
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void r(String str, ArrayList<String> arrayList, String str2, boolean z16, Handler handler, String str3, String str4, String str5) {
        super.r(str, arrayList, str2, z16, handler, str3, str4, str5);
        if (b() != null && this.Q != null) {
            PictureManager.getInstance().getSender().commentFriendVideo(handler, this.Q.get(getSelectedIndex()), str2, str, arrayList, z16);
            return;
        }
        QZLog.w("QzoneFriendVideoPictureViewController", "commentPhoto ,photoInfo or feedDatas is null");
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void r0(Context context) {
        super.r0(context);
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    protected void d1(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            QZLog.w("QzoneFriendVideoPictureViewController", "updateFeedPraiseIfNeed ,photoInfo is null");
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
}
