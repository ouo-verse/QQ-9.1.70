package com.qzone.album.util;

import NS_MOBILE_MATERIAL.CustomAlbumItem;
import NS_MOBILE_MATERIAL.MaterialFile;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_MATERIAL.PhotoFrameView;
import android.text.TextUtils;
import com.qzone.album.data.model.AlbumCacheData;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {
    public static String a(AlbumCacheData albumCacheData) {
        MaterialItem materialItem;
        MaterialFile materialFile;
        if (!f(albumCacheData) || (materialItem = albumCacheData.albumTemplate) == null || (materialFile = materialItem.stBanner) == null || TextUtils.isEmpty(materialFile.strUrl)) {
            return null;
        }
        return albumCacheData.albumTemplate.stBanner.strUrl;
    }

    public static String b(AlbumCacheData albumCacheData) {
        MaterialFile materialFile;
        if (!f(albumCacheData) || (materialFile = albumCacheData.albumTemplateData.stTmpBgImageLarge) == null || TextUtils.isEmpty(materialFile.strUrl)) {
            return null;
        }
        return albumCacheData.albumTemplateData.stTmpBgImageLarge.strUrl;
    }

    public static ArrayList<CustomAlbumItem> c(AlbumCacheData albumCacheData) {
        ArrayList<CustomAlbumItem> arrayList;
        if (!f(albumCacheData) || (arrayList = albumCacheData.albumTemplateData.vecItems) == null || arrayList.isEmpty()) {
            return null;
        }
        return albumCacheData.albumTemplateData.vecItems;
    }

    public static ArrayList<PhotoFrameView> d(AlbumCacheData albumCacheData) {
        ArrayList<PhotoFrameView> arrayList;
        if (!f(albumCacheData) || (arrayList = albumCacheData.albumTemplateData.vecPhotoFrameView) == null || arrayList.isEmpty()) {
            return null;
        }
        return albumCacheData.albumTemplateData.vecPhotoFrameView;
    }

    public static CustomAlbumItem e(AlbumCacheData albumCacheData) {
        ArrayList<CustomAlbumItem> c16 = c(albumCacheData);
        if (c16 != null && !c16.isEmpty()) {
            Iterator<CustomAlbumItem> it = c16.iterator();
            while (it.hasNext()) {
                CustomAlbumItem next = it.next();
                if (next != null && next.iItemType == 5) {
                    return next;
                }
            }
        }
        return null;
    }

    public static boolean f(AlbumCacheData albumCacheData) {
        return (albumCacheData == null || albumCacheData.individual == 0 || QZoneAlbumUtil.r(albumCacheData.albumtype) != 1 || albumCacheData.albumTemplate == null || albumCacheData.albumTemplateData == null) ? false : true;
    }
}
