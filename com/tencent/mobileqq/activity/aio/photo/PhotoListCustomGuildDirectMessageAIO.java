package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes33.dex */
public class PhotoListCustomGuildDirectMessageAIO extends PhotoListCustomizationAIO {
    public static final String U = "com.tencent.mobileqq.activity.aio.photo.PhotoListCustomGuildDirectMessageAIO";

    PhotoListCustomGuildDirectMessageAIO(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
    }

    private Intent T0() {
        Intent intent = this.D.getIntent();
        Bundle extras = intent.getExtras();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        ArrayList<String> arrayList2 = photoCommonBaseData.selectedPhotoList;
        HashMap<String, LocalMediaInfo> hashMap = photoCommonBaseData.selectedMediaInfoHashMap;
        HashMap<String, LocalMediaInfo> hashMap2 = photoCommonBaseData.allMediaInfoHashMap;
        boolean z16 = ((com.tencent.mobileqq.activity.photo.album.h) this.f184311f).f184248f == 2;
        Iterator<String> it = arrayList2.iterator();
        while (it.hasNext()) {
            String next = it.next();
            LocalMediaInfo localMediaInfo = hashMap.get(next);
            if (localMediaInfo == null) {
                localMediaInfo = hashMap2.get(next);
            }
            if (localMediaInfo != null) {
                localMediaInfo.isRwa = z16;
                arrayList.add(localMediaInfo);
            }
        }
        extras.putParcelableArrayList(PeakConstants.GUILD_ALBUM_SELECT_PHOTOS, arrayList);
        intent.putExtras(extras);
        return intent;
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        MediaFileFilter mediaFileFilter;
        super.E(intent);
        this.f184310e.customSendBtnText = intent.getStringExtra(QAlbumConstants.CUSTOM_SENDBTN_TEXT);
        if (!intent.getBooleanExtra(PeakConstants.PHOTOLIST_KEY_FILTER_VIDEO, false) || (mediaFileFilter = this.f184310e.filter) == null) {
            return;
        }
        mediaFileFilter.needVideo = false;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void O(View view) {
        Intent T0 = T0();
        T0.putExtra(PeakConstants.GUILD_ALBUM_QUALITY, ((com.tencent.mobileqq.activity.photo.album.h) this.f184311f).f184248f == 2);
        this.D.setResult(-1, T0);
        this.D.finish();
        QAlbumUtil.anim(this.D, false, false);
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void R(Intent intent) {
        this.D.startActivityForResult(intent, 10014);
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void G(int i3, int i16, Intent intent) {
        if (i3 != 10014) {
            super.G(i3, i16, intent);
        } else if (i16 == -1) {
            this.D.setResult(-1, intent);
            this.D.finish();
            QAlbumUtil.anim(this.D, false, false);
        }
    }
}
