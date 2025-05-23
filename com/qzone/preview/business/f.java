package com.qzone.preview.business;

import NS_MOBILE_PHOTO.MarkFaceItemFeed;
import android.os.Bundle;
import com.qzone.preview.service.PictureManager;
import com.qzone.preview.service.base.PictureConst;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.remote.Callback;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f extends g {
    private int Y = 0;
    private String Z = "";

    /* renamed from: a0, reason: collision with root package name */
    private String f49905a0 = "";

    @Override // com.qzone.preview.business.g, com.qzone.preview.business.BasePicureViewController
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

    @Override // com.qzone.preview.business.g, com.qzone.preview.business.BasePicureViewController
    public void Y(Bundle bundle) {
        super.Y(bundle);
        this.Y = bundle.getInt(PictureConst.KEY_CATEGORY_TYPE, 0);
        this.Z = bundle.getString(PictureConst.KEY_CATEGORY_ID, "");
        this.f49905a0 = bundle.getString(PictureConst.KEY_CATEGORY_PAGESTR, "");
    }

    @Override // com.qzone.preview.business.g
    protected void w1(long j3, int i3, int i16, Callback callback) {
        PictureManager.getInstance().getCacheCategoryPhotoList(j3, this.Y, this.Z, i3, i16, callback);
    }

    @Override // com.qzone.preview.business.g
    protected void x1(long j3, Callback callback) {
        PictureManager.getInstance().getMoreCategoryPhotoList(j3, this.Y, this.Z, this.f49905a0, callback);
    }
}
