package com.qzone.util.image;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import eipc.EIPCResult;
import java.io.File;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class NetImageInfo implements SmartParcelable {

    @NeedParcel
    public int flag;

    @NeedParcel
    public int height;
    public int index;

    @NeedParcel
    public String lloc;

    @NeedParcel
    public String mAlbumId;

    @NeedParcel
    public String mBigPath;

    @NeedParcel
    public long mFileid;

    @NeedParcel
    public long mMsgTime;

    @NeedParcel
    public String mSmallPath;

    @NeedParcel
    public long mTroopCode;

    @NeedParcel
    public String mUuid;
    public int selectedIndex;

    @NeedParcel
    public PhotoSendParams sendParams;
    public long shoottime;
    public Map<Integer, String> shouzhang_extend_map;

    @NeedParcel
    public int type;
    public long uploadTime;

    @NeedParcel
    public int width;

    public NetImageInfo() {
        this.mUuid = "";
        this.mFileid = 0L;
        this.mMsgTime = 0L;
        this.mTroopCode = 0L;
        this.lloc = "";
        this.type = 0;
        this.selectedIndex = -1;
    }

    private boolean compare(NetImageInfo netImageInfo) {
        String b16 = o6.a.e().b(this.mSmallPath);
        String b17 = o6.a.e().b(netImageInfo.mSmallPath);
        return b16 != null && b17 != null && b16.equals(b17) && this.mAlbumId.equals(netImageInfo.mAlbumId);
    }

    public static NetImageInfo create(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        return new NetImageInfo(str, str2, str3);
    }

    public static void onPicSelectPreSend(Intent intent, PhotoSendParams photoSendParams) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putString("uin", intent.getStringExtra("uin"));
        bundle2.putString("troop_uin", intent.getStringExtra("troop_uin"));
        bundle2.putInt("uintype", intent.getIntExtra("uintype", 1003));
        bundle2.putParcelable(PeakConstants.PHOTO_SEND_QZONE_PIC_PARAMS, photoSendParams);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneIPCModule", QzoneIPCModule.ACTION_QZONE_PIC_PRE_SEND, bundle2);
        boolean z16 = (callServer == null || (bundle = callServer.data) == null) ? false : bundle.getBoolean("qzone_pre_send_result");
        if (QLog.isColorLevel()) {
            QLog.i("onPicSelectPreSend", 2, "onPicSelectPreSend result:" + z16);
        }
    }

    public String getBigPath() {
        if (!TextUtils.isEmpty(this.mBigPath)) {
            return this.mBigPath;
        }
        return this.mSmallPath;
    }

    public String getSmallPath() {
        if (!TextUtils.isEmpty(this.mSmallPath)) {
            return this.mSmallPath;
        }
        return this.mBigPath;
    }

    public int hashCode() {
        return (this.mSmallPath + this.mBigPath + this.mAlbumId).hashCode();
    }

    public boolean isPanorama() {
        int i3 = this.flag;
        return i3 == 32 || i3 == 16;
    }

    public static NetImageInfo create(PhotoCacheData photoCacheData) {
        return create(photoCacheData, false);
    }

    public static NetImageInfo create(PhotoCacheData photoCacheData, boolean z16) {
        NetImageInfo create;
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        File imageFile;
        if (photoCacheData == null) {
            return null;
        }
        String currentUrl = photoCacheData.getCurrentUrl();
        String bigUrl = photoCacheData.getBigUrl();
        if (currentUrl == null || bigUrl == null || (create = create(currentUrl, bigUrl, photoCacheData.albumid)) == null) {
            return null;
        }
        PictureItem pictureItem2 = photoCacheData.picItem;
        if (pictureItem2 != null) {
            create.flag = pictureItem2.flag;
            if (z16) {
                if (photoCacheData.isGif()) {
                    imageFile = ImageManager.getInstance().getImageFile(bigUrl, null);
                    if (imageFile == null || !imageFile.exists()) {
                        QLog.e("[PhotoAlbum]aioSendPhotos", 1, "gif bigPath is null , go to load smallPath");
                        imageFile = ImageManager.getInstance().getImageFile(currentUrl, null);
                    }
                } else {
                    imageFile = ImageManager.getInstance().getImageFile(currentUrl, null);
                }
                String path = (imageFile == null || !imageFile.exists()) ? "" : imageFile.getPath();
                PictureUrl urlForMd5 = photoCacheData.getUrlForMd5();
                if (urlForMd5 != null) {
                    create.sendParams = new PhotoSendParams(path, urlForMd5.md5, "", urlForMd5.size, urlForMd5.height, urlForMd5.width, urlForMd5.url, 1);
                } else {
                    QLog.e("[PhotoAlbum]aioSendPhotos", 1, "pictureUrl == null");
                }
            }
        }
        create.lloc = photoCacheData.lloc;
        create.type = photoCacheData.type;
        create.shoottime = photoCacheData.shoottime;
        create.uploadTime = photoCacheData.uploadtime;
        create.shouzhang_extend_map = photoCacheData.shouzhang_extend_map;
        if (create.isPanorama() && (pictureItem = photoCacheData.picItem) != null && (pictureUrl = pictureItem.originUrl) != null) {
            create.width = pictureUrl.width;
            create.height = pictureUrl.height;
        } else {
            create.width = photoCacheData.getBigPictureUrl() != null ? photoCacheData.getBigPictureUrl().width : 0;
            create.height = photoCacheData.getBigPictureUrl() != null ? photoCacheData.getBigPictureUrl().height : 0;
        }
        return create;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NetImageInfo)) {
            return false;
        }
        return compare((NetImageInfo) obj);
    }

    public NetImageInfo(String str, String str2, String str3) {
        this.mUuid = "";
        this.mFileid = 0L;
        this.mMsgTime = 0L;
        this.mTroopCode = 0L;
        this.lloc = "";
        this.type = 0;
        this.selectedIndex = -1;
        this.mSmallPath = str;
        this.mBigPath = str2;
        this.mAlbumId = str3;
    }

    public NetImageInfo(String str, long j3, long j16) {
        this.mFileid = 0L;
        this.lloc = "";
        this.type = 0;
        this.selectedIndex = -1;
        this.mUuid = str;
        this.mMsgTime = j3;
        this.mTroopCode = j16;
    }

    public NetImageInfo(String str, long j3, long j16, long j17) {
        this(str, j3, j16);
        this.mFileid = j17;
    }

    public NetImageInfo(String str, long j3) {
        this.mFileid = 0L;
        this.mTroopCode = 0L;
        this.lloc = "";
        this.type = 0;
        this.selectedIndex = -1;
        this.mUuid = str;
        this.mMsgTime = j3;
    }
}
