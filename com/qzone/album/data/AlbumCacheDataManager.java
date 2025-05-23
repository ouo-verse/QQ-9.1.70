package com.qzone.album.data;

import NS_MOBILE_MATERIAL.CustomAlbumTemplate;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_PHOTO.Album;
import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.m;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.AlbumSocialInfoCacheData;
import com.qzone.album.data.model.FacePhotoCacheData;
import com.qzone.album.data.model.MaterialCateCacheData;
import com.qzone.album.data.model.ParentingAlbumData;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoCategoryControlInfo;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.qzone.album.data.model.PicContInfoCacheData;
import com.qzone.album.data.model.TimeLine;
import com.qzone.album.data.model.TravelAlbumData;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import s4.c;
import t5.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AlbumCacheDataManager {

    /* renamed from: a, reason: collision with root package name */
    private long f43875a;

    /* renamed from: b, reason: collision with root package name */
    private ReadWriteLock f43876b = new ReentrantReadWriteLock();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final AlbumCacheDataManager f43877a = new AlbumCacheDataManager();
    }

    AlbumCacheDataManager() {
    }

    public static final AlbumCacheDataManager J() {
        return a.f43877a;
    }

    private ArrayList<AlbumCacheData> c0(ArrayList<AlbumCacheData> arrayList, ArrayList<AlbumCacheData> arrayList2) {
        HashMap hashMap = new HashMap();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<AlbumCacheData> it = arrayList.iterator();
            while (it.hasNext()) {
                AlbumCacheData next = it.next();
                if (next != null && !TextUtils.isEmpty(next.albumid)) {
                    hashMap.put(next.albumid, next);
                }
            }
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<AlbumCacheData> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                AlbumCacheData next2 = it5.next();
                if (next2 != null && !TextUtils.isEmpty(next2.albumid)) {
                    hashMap.put(next2.albumid, next2);
                }
            }
        }
        if (hashMap.size() == 0) {
            return null;
        }
        return new ArrayList<>(hashMap.values());
    }

    public AlbumSocialInfoCacheData A(String str) {
        m dbCacheManager = CacheHolder.TABLE_ALBUM_SOCIAL_INFO.getDbCacheManager();
        if (dbCacheManager != null) {
            return (AlbumSocialInfoCacheData) dbCacheManager.k("albumid=?", new String[]{str});
        }
        return null;
    }

    public void A0(String str, ArrayList<PhotoCacheData> arrayList) {
        m dbCacheManager = CacheHolder.TABLE_PHOTO.getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.l("albumid=?");
            dbCacheManager.i(new String[]{str});
            dbCacheManager.h(arrayList);
        }
    }

    public void B0(long j3, ArrayList<AlbumCacheData> arrayList, boolean z16) {
        m dbCacheManager = CacheHolder.TABLE_RECENT_ALBUM.getDbCacheManager();
        if (dbCacheManager != null) {
            if (z16) {
                dbCacheManager.h(arrayList);
            } else {
                b0(T(j3), arrayList);
                dbCacheManager.h(arrayList);
            }
        }
    }

    public ArrayList<PhotoCacheData> C(String str, boolean z16) {
        m dbCacheManager = CacheHolder.TABLE_PHOTO.getDbCacheManager();
        ArrayList<PhotoCacheData> H = z16 ? H(str) : null;
        if (dbCacheManager == null) {
            return H;
        }
        dbCacheManager.l("albumid=?");
        dbCacheManager.i(new String[]{str});
        ArrayList<PhotoCacheData> arrayList = (ArrayList) dbCacheManager.e(null, null);
        if (H == null) {
            return arrayList;
        }
        H.addAll(arrayList);
        return H;
    }

    public void C0(ArrayList<PhotoCacheData> arrayList, boolean z16) {
        m dbCacheManager = CacheHolder.TABLE_RECENTLIST_ALL.getDbCacheManager();
        if (dbCacheManager != null) {
            if (z16) {
                dbCacheManager.h(arrayList);
            } else {
                dbCacheManager.m(arrayList);
            }
        }
    }

    public ArrayList<PhotoCacheData> D(String str, boolean z16) {
        m dbCacheManager = CacheHolder.TABLE_PHOTO.getDbCacheManager();
        ArrayList<PhotoCacheData> H = z16 ? H(str) : null;
        if (dbCacheManager == null) {
            return H;
        }
        dbCacheManager.l("albumid=? and video_flag=?");
        dbCacheManager.i(new String[]{str, String.valueOf(0)});
        ArrayList<PhotoCacheData> arrayList = (ArrayList) dbCacheManager.e(null, null);
        if (H == null) {
            return arrayList;
        }
        H.addAll(arrayList);
        return H;
    }

    public void D0(ArrayList<PhotoCacheData> arrayList, boolean z16) {
        m dbCacheManager = CacheHolder.TABLE_VIDEO_LIST.getDbCacheManager();
        if (dbCacheManager != null) {
            if (z16) {
                dbCacheManager.h(arrayList);
            } else {
                dbCacheManager.m(arrayList);
            }
        }
    }

    public ArrayList<PhotoCacheData> E(String str) {
        m dbCacheManager;
        if (TextUtils.isEmpty(str) || (dbCacheManager = CacheHolder.TABLE_ALBUM_SEARCH_RESULT_PHOTO.getDbCacheManager()) == null) {
            return null;
        }
        dbCacheManager.l("albumid=?");
        dbCacheManager.i(new String[]{str});
        return (ArrayList) dbCacheManager.e(null, null);
    }

    public void F0(ArrayList<PhotoCategorySinglePicInfo> arrayList, boolean z16, long j3, int i3, int i16) {
        m dbCacheManager;
        if (arrayList.isEmpty() || (dbCacheManager = CacheHolder.TABLE_PHOTO_CAGETORY_SINGLE.getDbCacheManager()) == null) {
            return;
        }
        dbCacheManager.l("uin=? and categoryType=? and usageType=?");
        dbCacheManager.i(new String[]{j3 + "", i3 + "", i16 + ""});
        if (z16) {
            dbCacheManager.h(arrayList);
        } else {
            dbCacheManager.m(arrayList);
        }
    }

    public ArrayList<AlbumCacheData> G(long j3) {
        m dbCacheManager = CacheHolder.TABLE_CAGETORY_ALBUMLIST.getDbCacheManager();
        if (dbCacheManager == null) {
            return null;
        }
        dbCacheManager.l("loginUin=?");
        dbCacheManager.i(new String[]{j3 + ""});
        return (ArrayList) dbCacheManager.e(null, null);
    }

    public void G0(ArrayList<PhotoCategorySinglePicInfo> arrayList, boolean z16, long j3, int i3, String str, int i16) {
        m dbCacheManager;
        if (arrayList.isEmpty() || (dbCacheManager = CacheHolder.TABLE_PHOTO_CAGETORY_SINGLE.getDbCacheManager()) == null) {
            return;
        }
        dbCacheManager.l("uin=? and categoryType=? and categoryId=? and usageType=?");
        dbCacheManager.i(new String[]{j3 + "", i3 + "", str, i16 + ""});
        if (z16) {
            dbCacheManager.h(arrayList);
        } else {
            dbCacheManager.m(arrayList);
        }
    }

    public ArrayList<PhotoCacheData> H(String str) {
        ArrayList<PhotoCacheData> arrayList = null;
        if (x(com.qzone.album.env.common.a.m().s(), str) == null) {
            return null;
        }
        m dbCacheManager = CacheHolder.TABLE_FAKE_PHOTO.getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.l("owner_uin=? and albumid=?");
            dbCacheManager.i(new String[]{com.qzone.album.env.common.a.m().s() + "", str});
            dbCacheManager.c("uploadtime DESC");
            arrayList = (ArrayList) dbCacheManager.e(null, null);
        }
        if (arrayList != null) {
            QLog.d("AlbumCacheDataManager", 1, "getFakePhotoCacheData albumId:" + str + "before filter count:" + arrayList.size());
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<PhotoCacheData> it = arrayList.iterator();
            while (it.hasNext()) {
                PhotoCacheData next = it.next();
                if ((currentTimeMillis / 1000) - next.uploadtime >= 3600) {
                    k0(next.clientKey);
                    it.remove();
                }
            }
            QLog.d("AlbumCacheDataManager", 1, "getFakePhotoCacheData albumId:" + str + "after filter count:" + arrayList.size());
        }
        return arrayList;
    }

    public ArrayList<PhotoCacheData> I() {
        m dbCacheManager = CacheHolder.TABLE_FAKE_VIDEO_LIST.getDbCacheManager();
        ArrayList<PhotoCacheData> arrayList = null;
        if (dbCacheManager != null) {
            dbCacheManager.l("owner_uin=?");
            dbCacheManager.i(new String[]{com.qzone.album.env.common.a.m().s() + ""});
            dbCacheManager.c("uploadtime DESC");
            arrayList = (ArrayList) dbCacheManager.e(null, null);
        }
        if (arrayList != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<PhotoCacheData> it = arrayList.iterator();
            while (it.hasNext()) {
                PhotoCacheData next = it.next();
                if ((currentTimeMillis / 1000) - next.uploadtime >= 3600) {
                    n0(next.clientKey);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public MaterialCateCacheData K() {
        ArrayList arrayList;
        m dbCacheManager = CacheHolder.TABLE_MATERIAL_CATE.getDbCacheManager();
        if (dbCacheManager == null || (arrayList = (ArrayList) dbCacheManager.e(null, null)) == null || arrayList.size() == 0) {
            return null;
        }
        return (MaterialCateCacheData) arrayList.get(0);
    }

    public ArrayList<PhotoCategoryControlInfo> L(long j3) {
        m dbCacheManager = CacheHolder.TABLE_PHOTO_CAGETORY.getDbCacheManager();
        if (dbCacheManager == null) {
            return null;
        }
        dbCacheManager.l("uin=?");
        dbCacheManager.i(new String[]{j3 + ""});
        return (ArrayList) dbCacheManager.e(null, null);
    }

    public PhotoCategorySinglePicInfo M(long j3, int i3, String str, int i16) {
        m dbCacheManager = CacheHolder.TABLE_PHOTO_CAGETORY_SINGLE.getDbCacheManager();
        if (dbCacheManager == null) {
            return null;
        }
        return (PhotoCategorySinglePicInfo) dbCacheManager.k("uin=? and categoryType=? and categoryId=? and usageType=?", new String[]{j3 + "", i3 + "", str, i16 + ""});
    }

    public ArrayList<PhotoCategorySinglePicInfo> N(long j3, int i3, int i16) {
        m dbCacheManager = CacheHolder.TABLE_PHOTO_CAGETORY_SINGLE.getDbCacheManager();
        if (dbCacheManager == null) {
            return null;
        }
        dbCacheManager.l("uin=? and categoryType=? and usageType=?");
        dbCacheManager.i(new String[]{j3 + "", i3 + "", i16 + ""});
        return (ArrayList) dbCacheManager.e(null, null);
    }

    public ArrayList<PhotoCategorySinglePicInfo> O(long j3, int i3, String str, int i16, int i17, int i18) {
        m dbCacheManager = CacheHolder.TABLE_PHOTO_CAGETORY_SINGLE.getDbCacheManager();
        if (dbCacheManager == null) {
            return null;
        }
        dbCacheManager.l("uin=? and categoryType=? and categoryId=? and usageType=?");
        dbCacheManager.i(new String[]{j3 + "", i3 + "", str, i16 + ""});
        return (ArrayList) dbCacheManager.g(null, null, i17, i18);
    }

    public ArrayList<PhotoCategorySummaryInfo> Q(long j3, int i3, String str) {
        m dbCacheManager = CacheHolder.TABLE_CATEGORY_SUMMARY_INFO.getDbCacheManager();
        if (dbCacheManager == null) {
            return null;
        }
        dbCacheManager.l("uin=? and categoryType=? and categoryId=?");
        dbCacheManager.i(new String[]{j3 + "", i3 + "", str});
        return (ArrayList) dbCacheManager.g(null, null, 0, 0);
    }

    public int R(String str) {
        m dbCacheManager = CacheHolder.TABLE_PHOTO.getDbCacheManager();
        if (dbCacheManager == null) {
            return 0;
        }
        dbCacheManager.l("albumid=?");
        dbCacheManager.i(new String[]{str});
        return dbCacheManager.getCount();
    }

    public ArrayList<PicContInfoCacheData> S(String str) {
        m dbCacheManager = CacheHolder.TABLE_PHOTO_MD5.getDbCacheManager();
        ArrayList<PicContInfoCacheData> arrayList = new ArrayList<>(1);
        if (dbCacheManager != null) {
            dbCacheManager.l("albumid=?");
            dbCacheManager.i(new String[]{str});
            arrayList.addAll((ArrayList) dbCacheManager.e(null, null));
        }
        return arrayList;
    }

    public ArrayList<AlbumCacheData> T(long j3) {
        m dbCacheManager = CacheHolder.TABLE_RECENT_ALBUM.getDbCacheManager();
        if (dbCacheManager == null) {
            return null;
        }
        dbCacheManager.l("ownerUin=?");
        dbCacheManager.i(new String[]{j3 + ""});
        return (ArrayList) dbCacheManager.e(null, null);
    }

    public ArrayList<PhotoCacheData> V(long j3, int i3) {
        ArrayList<PhotoCacheData> arrayList;
        if (i3 == 1) {
            m dbCacheManager = CacheHolder.TABLE_RECENTLIST_ALL.getDbCacheManager();
            if (dbCacheManager == null) {
                return null;
            }
            dbCacheManager.l("owner_uin=?");
            dbCacheManager.i(new String[]{j3 + ""});
            return (ArrayList) dbCacheManager.e(null, null);
        }
        if (i3 == 3) {
            m dbCacheManager2 = CacheHolder.TABLE_FRIEND_VIDEO_LIST.getDbCacheManager();
            ArrayList<PhotoCacheData> arrayList2 = new ArrayList<>();
            com.qzone.album.env.common.a.m().b("[PhotoAlbum]fakeOperation", "[get fake datas] fake friendvideolist size:", Integer.valueOf(arrayList2.size()));
            if (dbCacheManager2 == null) {
                return null;
            }
            arrayList2.addAll((ArrayList) dbCacheManager2.e(null, null));
            com.qzone.album.env.common.a.m().b("[PhotoAlbum]fakeOperation", "[get fake datas] all friendvideolist size:", Integer.valueOf(arrayList2.size()));
            return arrayList2;
        }
        m dbCacheManager3 = CacheHolder.TABLE_VIDEO_LIST.getDbCacheManager();
        ArrayList<PhotoCacheData> I = I();
        com.qzone.album.env.common.a m3 = com.qzone.album.env.common.a.m();
        Object[] objArr = new Object[2];
        objArr[0] = "[get fake datas] fake videolist size:";
        objArr[1] = Integer.valueOf(I != null ? I.size() : 0);
        m3.b("[PhotoAlbum]fakeOperation", objArr);
        if (dbCacheManager3 == null) {
            return null;
        }
        dbCacheManager3.l("owner_uin=? AND video_flag=?");
        dbCacheManager3.i(new String[]{j3 + "", "1"});
        Collection<? extends PhotoCacheData> collection = (ArrayList) dbCacheManager3.e(null, null);
        if (I == null) {
            arrayList = collection;
        } else {
            I.addAll(collection);
            arrayList = I;
        }
        com.qzone.album.env.common.a m16 = com.qzone.album.env.common.a.m();
        Object[] objArr2 = new Object[2];
        objArr2[0] = "[get fake datas] all videolist size:";
        objArr2[1] = Integer.valueOf(arrayList != null ? arrayList.size() : 0);
        m16.b("[PhotoAlbum]fakeOperation", objArr2);
        return arrayList;
    }

    public void X(long j3) {
        CacheHolder cacheHolder = CacheHolder.TABLE_ALBUMLIST;
        synchronized (cacheHolder) {
            this.f43875a = j3;
            cacheHolder.getDbCacheManager().c(AlbumCacheData.SORTORDER);
        }
    }

    public ArrayList<PhotoCategorySummaryInfo> Z(long j3, int i3) {
        m dbCacheManager = CacheHolder.TABLE_CATEGORY_SUMMARY_INFO.getDbCacheManager();
        ArrayList<PhotoCategorySummaryInfo> arrayList = null;
        if (dbCacheManager != null) {
            dbCacheManager.l("uin=? and categoryType=?");
            dbCacheManager.i(new String[]{j3 + "", i3 + ""});
            QZLog.i(QZLog.TO_DEVICE_TAG, 2, "AlbumCacheDataManagerPhotoCategoryController begin query summary info");
            arrayList = (ArrayList) dbCacheManager.g(null, null, 0, 0);
            QZLog.i(QZLog.TO_DEVICE_TAG, 2, "AlbumCacheDataManagerPhotoCategoryController end query summary info");
        }
        if (arrayList != null && arrayList.size() > 0) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 2, "AlbumCacheDataManagerPhotoCategoryController begin query photo info");
            ArrayList<PhotoCategorySinglePicInfo> N = N(j3, i3, 0);
            QZLog.i(QZLog.TO_DEVICE_TAG, 2, "AlbumCacheDataManagerPhotoCategoryController end query photo info");
            Iterator<PhotoCategorySummaryInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().previewPhotos = new ArrayList<>();
            }
            if (N != null && N.size() > 0) {
                Iterator<PhotoCategorySinglePicInfo> it5 = N.iterator();
                while (it5.hasNext()) {
                    PhotoCategorySinglePicInfo next = it5.next();
                    if (next != null) {
                        String str = next.categoryId;
                        for (int i16 = 0; i16 < arrayList.size(); i16++) {
                            if (arrayList.get(i16) != null && arrayList.get(i16).categoryId.equals(str)) {
                                arrayList.get(i16).previewPhotos.add(next);
                            }
                        }
                    }
                }
            }
            QZLog.i(QZLog.TO_DEVICE_TAG, 2, "AlbumCacheDataManagerPhotoCategoryController end put photo info");
        }
        return arrayList;
    }

    public ArrayList<PhotoCategorySinglePicInfo> a0(long j3, int i3, String str, int i16, int i17, int i18) {
        return O(j3, i3, str, i16, i17, i18);
    }

    public void b(long j3, int i3, ArrayList<PhotoCategorySummaryInfo> arrayList) {
        m dbCacheManager = CacheHolder.TABLE_CATEGORY_SUMMARY_INFO.getDbCacheManager();
        dbCacheManager.l("uin=? and categoryType=?");
        dbCacheManager.i(new String[]{j3 + "", i3 + ""});
        dbCacheManager.m(arrayList);
    }

    public void c(String str, ArrayList<PhotoCacheData> arrayList) {
        m dbCacheManager = CacheHolder.TABLE_FAKE_PHOTO.getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.l("albumid='" + str + "'");
            dbCacheManager.m(arrayList);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("addFakePhotoCacheData count:");
            sb5.append(arrayList != null ? arrayList.size() : -1);
            QLog.d("[PhotoAlbum]QZoneAlbumService", 1, sb5.toString());
        }
    }

    public void d(c cVar) {
        m dbCacheManager = CacheHolder.TABLE_FAKE_RECENTLIST.getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.appendData(cVar);
        }
    }

    public void d0(PhotoCategorySummaryInfo photoCategorySummaryInfo) {
        CacheHolder.TABLE_CATEGORY_SUMMARY_INFO.getDbCacheManager().n(photoCategorySummaryInfo, "uin=? and categoryType=? and categoryId=?", new String[]{String.valueOf(photoCategorySummaryInfo.uin), String.valueOf(photoCategorySummaryInfo.categoryType), photoCategorySummaryInfo.categoryId});
    }

    public void e(long j3, ArrayList<PhotoCacheData> arrayList) {
        if (arrayList == null) {
            QZLog.e("[PhotoAlbum]fakeOperation", "[write fake datas] datas == null");
            return;
        }
        if (QZLog.isDevelopLevel()) {
            QZLog.d("[PhotoAlbum]fakeOperation", 4, "[write fake datas] datas:" + arrayList.size());
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (arrayList.get(i3).isVideo()) {
                arrayList2.add(arrayList.get(i3));
            }
        }
        m dbCacheManager = CacheHolder.TABLE_FAKE_VIDEO_LIST.getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.l("owner_uin= ?");
            dbCacheManager.i(new String[]{j3 + ""});
            dbCacheManager.m(arrayList2);
        }
    }

    public void e0(PhotoCategorySummaryInfo photoCategorySummaryInfo, String str) {
        CacheHolder.TABLE_CATEGORY_SUMMARY_INFO.getDbCacheManager().n(photoCategorySummaryInfo, "uin=? and categoryType=? and categoryId=?", new String[]{String.valueOf(photoCategorySummaryInfo.uin), String.valueOf(photoCategorySummaryInfo.categoryType), str});
    }

    public void f(ArrayList<PhotoCacheData> arrayList) {
        CacheHolder cacheHolder = CacheHolder.TABLE_PHOTO;
        m dbCacheManager = cacheHolder.getDbCacheManager();
        if (dbCacheManager != null) {
            synchronized (cacheHolder) {
                dbCacheManager.m(arrayList);
            }
        }
    }

    public void f0(PhotoCategorySinglePicInfo photoCategorySinglePicInfo, int i3) {
        CacheHolder.TABLE_PHOTO_CAGETORY_SINGLE.getDbCacheManager().n(photoCategorySinglePicInfo, "uin=? and categoryType=? and usageType=? and categoryId=? and lloc=? and sloc=?", new String[]{String.valueOf(photoCategorySinglePicInfo.uin), String.valueOf(photoCategorySinglePicInfo.categoryType), String.valueOf(i3), photoCategorySinglePicInfo.categoryId, photoCategorySinglePicInfo.lloc, photoCategorySinglePicInfo.sloc});
    }

    public void g(ArrayList<PicContInfoCacheData> arrayList) {
        CacheHolder cacheHolder = CacheHolder.TABLE_PHOTO_MD5;
        m dbCacheManager = cacheHolder.getDbCacheManager();
        if (dbCacheManager != null) {
            synchronized (cacheHolder) {
                dbCacheManager.m(arrayList);
            }
        }
    }

    public void g0(PhotoCategorySinglePicInfo photoCategorySinglePicInfo, int i3, String str) {
        CacheHolder.TABLE_PHOTO_CAGETORY_SINGLE.getDbCacheManager().n(photoCategorySinglePicInfo, "uin=? and categoryType=? and usageType=? and categoryId=? and lloc=? and sloc=?", new String[]{String.valueOf(photoCategorySinglePicInfo.uin), String.valueOf(photoCategorySinglePicInfo.categoryType), String.valueOf(i3), str, photoCategorySinglePicInfo.lloc, photoCategorySinglePicInfo.sloc});
    }

    public void h(String str, ArrayList<PhotoCacheData> arrayList) {
        CacheHolder cacheHolder;
        if (!TextUtils.isEmpty(str) && arrayList != null && !arrayList.isEmpty() && (cacheHolder = CacheHolder.TABLE_ALBUM_SEARCH_RESULT_PHOTO) != null) {
            m dbCacheManager = cacheHolder.getDbCacheManager();
            if (dbCacheManager != null) {
                synchronized (cacheHolder) {
                    dbCacheManager.l("albumid=?");
                    dbCacheManager.i(new String[]{str + ""});
                    dbCacheManager.m(arrayList);
                }
                return;
            }
            return;
        }
        QZLog.e("AlbumCacheDataManager", "appendSearchResultTmpCache, passing INVALID album id or INVALID photoDataList");
    }

    public void h0(PhotoCacheData photoCacheData, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            CacheHolder.TABLE_ALBUM_SEARCH_RESULT_PHOTO.getDbCacheManager().n(photoCacheData, "lloc=? and albumid=?", new String[]{str, str2});
        } else {
            QZLog.e("AlbumCacheDataManager", "modifySearchResultTmpPhotoDescInfo, passing INVALID photoid or albumId");
        }
    }

    public void i(long j3) {
        m dbCacheManager = CacheHolder.TABLE_FRIEND_VIDEO_LIST.getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.l("owner_uin=?");
            dbCacheManager.i(new String[]{j3 + ""});
            dbCacheManager.clearData();
        }
    }

    public void j(String str) {
        m dbCacheManager = CacheHolder.TABLE_PHOTO.getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.l("albumid=?");
            dbCacheManager.i(new String[]{str + ""});
            dbCacheManager.clearData();
        }
    }

    public void j0(AlbumCacheData albumCacheData) {
        m dbCacheManager = CacheHolder.TABLE_ALBUMLIST.getDbCacheManager();
        if (dbCacheManager == null || albumCacheData == null) {
            return;
        }
        if (((com.qzone.component.cache.database.a) dbCacheManager.k("albumid=?", new String[]{albumCacheData.albumid})) != null) {
            dbCacheManager.n(albumCacheData, "albumid=?", new String[]{albumCacheData.albumid});
        } else {
            dbCacheManager.appendData(albumCacheData);
        }
    }

    public void k(long j3) {
        m dbCacheManager = CacheHolder.TABLE_RECENTLIST_ALL.getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.l("owner_uin=?");
            dbCacheManager.i(new String[]{j3 + ""});
            dbCacheManager.clearData();
            if (QZLog.isColorLevel()) {
                QZLog.i("AlbumCacheDataManager", 4, "clearRecentPhotoCache clear db");
            }
        }
    }

    public void k0(String str) {
        m dbCacheManager;
        QLog.d("[PhotoAlbum]QZoneAlbumService", 1, "removeFakePhotoCacheData clientKey:" + str);
        if (TextUtils.isEmpty(str) || (dbCacheManager = CacheHolder.TABLE_FAKE_PHOTO.getDbCacheManager()) == null) {
            return;
        }
        QLog.d("[PhotoAlbum]QZoneAlbumService", 1, "removeFakePhotoCacheData filter count:" + dbCacheManager.deleteData("owner_uin=? and client_key=?", new String[]{"" + com.qzone.album.env.common.a.m().s(), str}));
    }

    public void l(String str) {
        if (!TextUtils.isEmpty(str)) {
            m dbCacheManager = CacheHolder.TABLE_ALBUM_SEARCH_RESULT_PHOTO.getDbCacheManager();
            if (dbCacheManager != null) {
                dbCacheManager.l("albumid=?");
                dbCacheManager.i(new String[]{str + ""});
                dbCacheManager.clearData();
                return;
            }
            return;
        }
        QZLog.e("AlbumCacheDataManager", "clearSearchResultTmpCache, passing INVALID album id");
    }

    public void l0(String str) {
        m dbCacheManager;
        QLog.d("[PhotoAlbum]QZoneAlbumService", 1, "removeFakePhotoCacheDataList clientKeyList:" + str);
        if (TextUtils.isEmpty(str) || (dbCacheManager = CacheHolder.TABLE_FAKE_PHOTO.getDbCacheManager()) == null) {
            return;
        }
        QLog.d("[PhotoAlbum]QZoneAlbumService", 1, "removeFakePhotoCacheDataList filter count:" + dbCacheManager.deleteData("owner_uin=? and " + str, new String[]{"" + com.qzone.album.env.common.a.m().s()}));
    }

    public void m(long j3) {
        m dbCacheManager = CacheHolder.TABLE_VIDEO_LIST.getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.l("owner_uin=?");
            dbCacheManager.i(new String[]{j3 + ""});
            dbCacheManager.clearData();
        }
    }

    public void m0(String str) {
        m dbCacheManager;
        if (TextUtils.isEmpty(str) || (dbCacheManager = CacheHolder.TABLE_FAKE_RECENTLIST.getDbCacheManager()) == null) {
            return;
        }
        dbCacheManager.deleteData("ownerUin=? and client_key=?", new String[]{"" + com.qzone.album.env.common.a.m().s(), str});
    }

    public void n(String str) {
        m dbCacheManager = CacheHolder.TABLE_ALBUMLIST.getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.deleteData("albumid=?", new String[]{str});
        }
    }

    public void n0(String str) {
        m dbCacheManager;
        if (QZLog.isDevelopLevel()) {
            QZLog.d("[PhotoAlbum]fakeOperation", 4, "[remove fake datas] clientKey:" + str);
        }
        if (TextUtils.isEmpty(str) || (dbCacheManager = CacheHolder.TABLE_FAKE_VIDEO_LIST.getDbCacheManager()) == null) {
            return;
        }
        dbCacheManager.deleteData("owner_uin=? and client_key=?", new String[]{"" + com.qzone.album.env.common.a.m().s(), str});
    }

    public void o(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        v(CacheHolder.TABLE_PHOTO.getDbCacheManager(), "albumid=?", new String[]{str});
    }

    public void p(String str) {
        m dbCacheManager = CacheHolder.TABLE_ALBUM_SOCIAL_INFO.getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.deleteData("albumid=?", new String[]{str});
        }
    }

    public void p0(long j3, String str, int i3) {
        ArrayList<PhotoCacheData> V;
        if (TextUtils.isEmpty(str) || (V = V(j3, i3)) == null || V.isEmpty()) {
            return;
        }
        Iterator<PhotoCacheData> it = V.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            PhotoCacheData next = it.next();
            if (next == null || str.equals(next.pssUgcKey)) {
                it.remove();
                z16 = true;
            }
        }
        if (z16) {
            i0(i3, V);
        }
    }

    public void q(String str, String str2) {
        AlbumCacheData albumCacheData;
        m dbCacheManager = CacheHolder.TABLE_PHOTO.getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.deleteData("lloc=?", new String[]{str});
        }
        m dbCacheManager2 = CacheHolder.TABLE_ALBUMLIST.getDbCacheManager();
        if (dbCacheManager2 == null || TextUtils.isEmpty(str2) || (albumCacheData = (AlbumCacheData) dbCacheManager2.k("albumid=?", new String[]{str2})) == null) {
            return;
        }
        albumCacheData.albumnum--;
        dbCacheManager2.n(albumCacheData, "albumid=?", new String[]{str2});
    }

    public void q0(long j3, String str, String str2, int i3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str2);
        r0(j3, str, arrayList, i3);
    }

    public void r(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            m dbCacheManager = CacheHolder.TABLE_ALBUM_SEARCH_RESULT_PHOTO.getDbCacheManager();
            if (dbCacheManager != null) {
                dbCacheManager.deleteData("lloc=? and albumid=?", new String[]{str, str2});
                return;
            }
            return;
        }
        QZLog.e("AlbumCacheDataManager", "delPhotoByPhotoIdInSearchResultTmpCache, passing INVALID photoid or albumId");
    }

    public void r0(long j3, String str, ArrayList<String> arrayList, int i3) {
        ArrayList<PhotoCacheData> V;
        if (TextUtils.isEmpty(str) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next())) {
                it.remove();
            }
        }
        if (arrayList.isEmpty() || (V = V(j3, i3)) == null || V.isEmpty()) {
            return;
        }
        Iterator<PhotoCacheData> it5 = V.iterator();
        boolean z16 = false;
        while (it5.hasNext()) {
            PhotoCacheData next = it5.next();
            if (next == null) {
                it5.remove();
                z16 = true;
            } else if (str.equals(next.albumid)) {
                Iterator<String> it6 = arrayList.iterator();
                boolean z17 = false;
                while (it6.hasNext()) {
                    String next2 = it6.next();
                    if (!z17 && next2.equals(next.lloc)) {
                        it5.remove();
                        z16 = true;
                        z17 = true;
                    }
                }
            }
        }
        if (z16) {
            i0(i3, V);
        }
    }

    public void s(long j3, int i3) {
        m dbCacheManager = CacheHolder.TABLE_CATEGORY_SUMMARY_INFO.getDbCacheManager();
        dbCacheManager.l("uin=? and categoryType=?");
        dbCacheManager.i(new String[]{j3 + "", i3 + ""});
        dbCacheManager.deleteData("uin=? and categoryType=?", new String[]{j3 + "", i3 + ""});
    }

    public void t(PhotoCategorySummaryInfo photoCategorySummaryInfo) {
        CacheHolder.TABLE_CATEGORY_SUMMARY_INFO.getDbCacheManager().deleteData("uin=? and categoryType=? and categoryId=?", new String[]{photoCategorySummaryInfo.uin + "", photoCategorySummaryInfo.categoryType + "", photoCategorySummaryInfo.categoryId});
    }

    public void t0(AlbumCacheData albumCacheData) {
        m dbCacheManager = CacheHolder.TABLE_ALBUMLIST.getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.n(albumCacheData, "albumid=?", new String[]{albumCacheData.albumid});
        }
    }

    public void u(PhotoCategorySummaryInfo photoCategorySummaryInfo, String str) {
        CacheHolder.TABLE_CATEGORY_SUMMARY_INFO.getDbCacheManager().deleteData("uin=? and categoryType=? and categoryId=? and avatarUrl=?", new String[]{photoCategorySummaryInfo.uin + "", photoCategorySummaryInfo.categoryType + "", photoCategorySummaryInfo.categoryId, str});
    }

    public void u0(String str, ArrayList<PhotoCacheData> arrayList) {
        if (!TextUtils.isEmpty(str) && arrayList != null && !arrayList.isEmpty()) {
            m dbCacheManager = CacheHolder.TABLE_ALBUM_SEARCH_RESULT_PHOTO.getDbCacheManager();
            if (dbCacheManager != null) {
                dbCacheManager.l("albumid=?");
                dbCacheManager.i(new String[]{str});
                dbCacheManager.h(arrayList);
                return;
            }
            return;
        }
        QZLog.e("AlbumCacheDataManager", "replaceSearchResultTmpCache, passing INVALID album id or INVALID photoDataList");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0025, code lost:
    
        if (r4 != 11) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v0(String str, String str2, Map<Integer, String> map) {
        m dbCacheManager = CacheHolder.TABLE_ALBUMLIST.getDbCacheManager();
        AlbumCacheData albumCacheData = (AlbumCacheData) dbCacheManager.k("albumid=?", new String[]{str});
        if (albumCacheData != null) {
            int albumThemeTypeValue = albumCacheData.getAlbumThemeTypeValue();
            if (albumThemeTypeValue != 8) {
                if (albumThemeTypeValue == 9) {
                    TravelAlbumData travelAlbumData = albumCacheData.travelData;
                    if (travelAlbumData != null) {
                        travelAlbumData.attach_info = str2;
                        travelAlbumData.busi_param = map;
                    }
                }
                dbCacheManager.n(albumCacheData, "albumid=?", new String[]{albumCacheData.albumid});
            }
            ParentingAlbumData parentingAlbumData = albumCacheData.parentingData;
            if (parentingAlbumData != null) {
                parentingAlbumData.attach_info = str2;
                parentingAlbumData.busi_param = map;
            }
            dbCacheManager.n(albumCacheData, "albumid=?", new String[]{albumCacheData.albumid});
        }
    }

    public void w(PhotoCategorySinglePicInfo photoCategorySinglePicInfo, int i3) {
        CacheHolder.TABLE_PHOTO_CAGETORY_SINGLE.getDbCacheManager().deleteData("uin=? and categoryType=? and albumId=? and categoryId=? and usageType=? and sloc=? and lloc=?", new String[]{photoCategorySinglePicInfo.uin + "", photoCategorySinglePicInfo.categoryType + "", photoCategorySinglePicInfo.albumId, photoCategorySinglePicInfo.categoryId, i3 + "", photoCategorySinglePicInfo.sloc, photoCategorySinglePicInfo.lloc});
    }

    public void w0(long j3, ArrayList<AlbumCacheData> arrayList, boolean z16) {
        m dbCacheManager = CacheHolder.TABLE_ALBUMLIST.getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.l("ownerUin=?");
            dbCacheManager.i(new String[]{j3 + ""});
            if (!z16) {
                dbCacheManager.h(arrayList);
            } else {
                dbCacheManager.m(arrayList);
            }
        }
    }

    public AlbumCacheData x(long j3, String str) {
        m dbCacheManager = CacheHolder.TABLE_ALBUMLIST.getDbCacheManager();
        if (dbCacheManager != null) {
            return (AlbumCacheData) dbCacheManager.k("albumid=?", new String[]{str});
        }
        return null;
    }

    public void x0(long j3, ArrayList<PhotoCategoryControlInfo> arrayList) {
        m dbCacheManager = CacheHolder.TABLE_PHOTO_CAGETORY.getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.l("uin=?");
            dbCacheManager.i(new String[]{j3 + ""});
            dbCacheManager.h(arrayList);
        }
    }

    public Object y(long j3, String str, String str2) {
        m dbCacheManager = CacheHolder.TABLE_ALBUMLIST.getDbCacheManager();
        if (dbCacheManager != null) {
            return dbCacheManager.p(str2, "albumid=?", new String[]{String.valueOf(str)}, null);
        }
        return null;
    }

    public void y0(long j3, int i3, ArrayList<PhotoCategorySummaryInfo> arrayList) {
        m dbCacheManager = CacheHolder.TABLE_CATEGORY_SUMMARY_INFO.getDbCacheManager();
        dbCacheManager.l("uin=? and categoryType=?");
        dbCacheManager.i(new String[]{j3 + "", i3 + ""});
        dbCacheManager.h(arrayList);
    }

    public ArrayList<AlbumCacheData> z(long j3) {
        m dbCacheManager = CacheHolder.TABLE_ALBUMLIST.getDbCacheManager();
        if (dbCacheManager == null) {
            return null;
        }
        dbCacheManager.l("ownerUin=?");
        dbCacheManager.i(new String[]{j3 + ""});
        return (ArrayList) dbCacheManager.e(null, null);
    }

    public void z0(ArrayList<PhotoCacheData> arrayList, boolean z16) {
        m dbCacheManager = CacheHolder.TABLE_FRIEND_VIDEO_LIST.getDbCacheManager();
        if (dbCacheManager != null) {
            if (z16) {
                dbCacheManager.h(arrayList);
            } else {
                dbCacheManager.m(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public enum CacheHolder {
        TABLE_ALBUMLIST("TABLE_ALBUMLIST", AlbumCacheData.class),
        TABLE_ALBUM_SOCIAL_INFO("TABLE_ALBUM_SOCIAL_INFO", AlbumSocialInfoCacheData.class),
        TABLE_PHOTO("TABLE_PHOTO", PhotoCacheData.class),
        TABLE_RECENTLIST_ALL("TABLE_RECENTLIST_ALL", PhotoCacheData.class),
        TABLE_RECENT_ALBUM("TABLE_RECENT_ALBUM", AlbumCacheData.class),
        TABLE_MATERIAL_CATE("TABLE_MATERIAL_CATE", MaterialCateCacheData.class),
        TABLE_FAKE_PHOTO("TABLE_FAKE_PHOTO", PhotoCacheData.class),
        TABLE_FAKE_RECENTLIST("TABLE_FAKE_RECENTLIST", c.class),
        TABLE_PHOTO_CAGETORY("TABLE_PHOTO_CAGETORY", PhotoCategoryControlInfo.class),
        TABLE_PHOTO_CAGETORY_SINGLE("TABLE_PHOTO_CAGETORY_SINGLE", PhotoCategorySinglePicInfo.class),
        TABLE_CAGETORY_ALBUMLIST("TABLE_CAGETORY_ALBUMLIST", AlbumCacheData.class),
        TABLE_VIDEO_LIST("TABLE_VIDEO_LIST", PhotoCacheData.class),
        TABLE_FAKE_VIDEO_LIST("TABLE_FAKE_VIDEO_LIST", PhotoCacheData.class),
        TABLE_CATEGORY_SUMMARY_INFO("TABLE_CATEGORY_SUMMARY_INFO", PhotoCategorySummaryInfo.class),
        TABLE_ALBUM_FACE_PHOTO("TABLE_ALBUM_FACE_PHOTO", FacePhotoCacheData.class),
        TABLE_PHOTO_MD5("TABLE_PHOTO_MD5", PicContInfoCacheData.class),
        TABLE_FRIEND_VIDEO_LIST("TABLE_FRIEND_VIDEO_LIST", PhotoCacheData.class),
        TABLE_ALBUM_SEARCH_RESULT_PHOTO("TABLE_ALBUM_SEARCH_RESULT_PHOTO", PhotoCacheData.class);

        m cache;
        Class clazz;
        String table;
        long uin;

        CacheHolder(String str, Class cls) {
            this.table = str;
            this.clazz = cls;
        }

        private void ensureCacheHolder() {
            m mVar;
            long s16 = com.qzone.album.env.common.a.m().s();
            if (s16 != this.uin || (mVar = this.cache) == null || mVar.isClosed()) {
                this.uin = s16;
                this.cache = FeedGlobalEnv.g().obtainDbManager(this.clazz, s16, this.table);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public m getDbCacheManager() {
            ensureCacheHolder();
            return this.cache;
        }

        public void reset() {
            this.uin = 0L;
            this.cache = null;
            this.clazz = null;
        }
    }

    public ArrayList<PhotoCacheData> B(String str) {
        return C(str, true);
    }

    public ArrayList<PhotoCacheData> U(long j3) {
        return V(j3, 1);
    }

    public void o0(long j3, String str) {
        p0(j3, str, 1);
    }

    private void b0(ArrayList<AlbumCacheData> arrayList, ArrayList<AlbumCacheData> arrayList2) {
        if (arrayList == null || arrayList.isEmpty() || arrayList2 == null) {
            return;
        }
        Iterator<AlbumCacheData> it = arrayList.iterator();
        while (it.hasNext()) {
            AlbumCacheData next = it.next();
            if (H0(next, arrayList2)) {
                arrayList2.add(next);
            }
        }
    }

    private void v(m mVar, String str, String[] strArr) {
        if (mVar != null) {
            mVar.deleteData(str, strArr);
        }
    }

    public void E0(ArrayList<AlbumCacheData> arrayList, long j3, boolean z16) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        m dbCacheManager = CacheHolder.TABLE_CAGETORY_ALBUMLIST.getDbCacheManager();
        dbCacheManager.l("loginUin=?");
        dbCacheManager.i(new String[]{j3 + ""});
        if (z16) {
            dbCacheManager.h(arrayList);
        } else {
            dbCacheManager.h(c0(G(j3), arrayList));
        }
    }

    public void s0(long j3, ArrayList<String> arrayList, int i3) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        ArrayList<PhotoCacheData> V = V(j3, i3);
        if (V == null || V.isEmpty()) {
            return;
        }
        boolean z16 = false;
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                Iterator<PhotoCacheData> it5 = V.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    PhotoCacheData next2 = it5.next();
                    if (next2 == null) {
                        it5.remove();
                        z16 = true;
                    } else {
                        VideoInfo videoInfo = next2.videodata;
                        if (videoInfo != null && !TextUtils.isEmpty(videoInfo.videoId) && next.equals(next2.videodata.videoId)) {
                            it5.remove();
                            z16 = true;
                            break;
                        }
                    }
                }
            }
        }
        if (z16) {
            i0(i3, V);
        }
    }

    private boolean H0(AlbumCacheData albumCacheData, ArrayList<AlbumCacheData> arrayList) {
        String str;
        if (albumCacheData == null || albumCacheData.albumid == null || arrayList == null) {
            return false;
        }
        Iterator<AlbumCacheData> it = arrayList.iterator();
        while (it.hasNext()) {
            AlbumCacheData next = it.next();
            if (next != null && (str = next.albumid) != null && str.equals(albumCacheData.albumid)) {
                return false;
            }
        }
        return true;
    }

    private void i0(int i3, ArrayList<PhotoCacheData> arrayList) {
        m dbCacheManager = i3 == 1 ? CacheHolder.TABLE_RECENTLIST_ALL.getDbCacheManager() : i3 == 3 ? CacheHolder.TABLE_FRIEND_VIDEO_LIST.getDbCacheManager() : CacheHolder.TABLE_VIDEO_LIST.getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.h(arrayList);
            com.qzone.album.base.Service.a.W().N0(8);
        }
    }

    public void I0(AlbumCacheData albumCacheData) {
        m dbCacheManager;
        if (albumCacheData == null || (dbCacheManager = CacheHolder.TABLE_ALBUMLIST.getDbCacheManager()) == null) {
            return;
        }
        dbCacheManager.n(albumCacheData, "albumid=?", new String[]{albumCacheData.albumid});
    }

    public void K0(AlbumCacheData albumCacheData) {
        if (albumCacheData == null) {
            return;
        }
        a(albumCacheData, com.qzone.album.env.common.a.m().s());
    }

    public void L0(AlbumSocialInfoCacheData albumSocialInfoCacheData) {
        m dbCacheManager;
        if (albumSocialInfoCacheData == null || (dbCacheManager = CacheHolder.TABLE_ALBUM_SOCIAL_INFO.getDbCacheManager()) == null) {
            return;
        }
        dbCacheManager.appendData(albumSocialInfoCacheData);
    }

    public void a(AlbumCacheData albumCacheData, long j3) {
        if (albumCacheData == null) {
            return;
        }
        AlbumCacheData x16 = x(j3, albumCacheData.albumid);
        if (albumCacheData.individual == 1 && x16 != null) {
            MaterialItem materialItem = x16.albumTemplate;
            albumCacheData.albumTemplate = materialItem;
            if (materialItem != null) {
                albumCacheData.albumTemplateData = (CustomAlbumTemplate) b.b(CustomAlbumTemplate.class, materialItem.strExtFields);
            }
        }
        if ((albumCacheData.getAlbumThemeTypeValue() == 8 || albumCacheData.getAlbumThemeTypeValue() == 11) && x16 != null) {
            albumCacheData.parentingData = x16.parentingData;
        }
        if (albumCacheData.getAlbumThemeTypeValue() == 9 && x16 != null) {
            albumCacheData.travelData = x16.travelData;
        }
        if (x16 != null) {
            albumCacheData.createTime = x16.createTime;
            ArrayList<TimeLine> arrayList = x16.commonPhotoTimeLineList;
            if (arrayList != null) {
                albumCacheData.commonPhotoTimeLineList = arrayList;
            }
        }
        int i3 = albumCacheData.albumtype;
        if (i3 == 1 || i3 == 0) {
            albumCacheData.albumtype = 1;
        }
        m dbCacheManager = CacheHolder.TABLE_ALBUMLIST.getDbCacheManager();
        if (x16 != null) {
            dbCacheManager.n(albumCacheData, "albumid=?", new String[]{albumCacheData.albumid});
        } else {
            dbCacheManager.appendData(albumCacheData);
        }
    }

    public ArrayList<PhotoCacheData> F(String str, int i3, int i16) {
        ArrayList<PhotoCacheData> E;
        if (i3 >= i16 || (E = E(str)) == null || i3 >= E.size()) {
            return null;
        }
        if (i16 > E.size()) {
            i16 = E.size();
        }
        ArrayList<PhotoCacheData> arrayList = new ArrayList<>(i16 - i3);
        while (i3 < i16) {
            arrayList.add(E.get(i3));
            i3++;
        }
        return arrayList;
    }

    public AlbumCacheData J0(Album album) {
        if (album == null) {
            return null;
        }
        AlbumCacheData createFromResponse = AlbumCacheData.createFromResponse(album);
        a(createFromResponse, com.qzone.album.env.common.a.m().s());
        return createFromResponse;
    }

    public ArrayList<PhotoCacheData> W(long j3, int i3, int i16, int i17) {
        ArrayList<PhotoCacheData> V;
        if (i3 >= i16 || (V = V(j3, i17)) == null || i3 >= V.size()) {
            return null;
        }
        if (i16 > V.size()) {
            i16 = V.size();
        }
        ArrayList<PhotoCacheData> arrayList = new ArrayList<>(i16 - i3);
        while (i3 < i16) {
            arrayList.add(V.get(i3));
            i3++;
        }
        return arrayList;
    }

    public ArrayList<PhotoCategorySinglePicInfo> P(long j3, int i3, String str, int i16, int i17, int i18) {
        ArrayList<PhotoCategorySinglePicInfo> O;
        int i19 = i17;
        int i26 = i18;
        if (i19 >= i26 || (O = O(j3, i3, str, i16, 0, 0)) == null || i19 >= O.size()) {
            return null;
        }
        if (i26 > O.size()) {
            i26 = O.size();
        }
        ArrayList<PhotoCategorySinglePicInfo> arrayList = new ArrayList<>(i26 - i19);
        while (i19 < i26) {
            arrayList.add(O.get(i19));
            i19++;
        }
        return arrayList;
    }

    public void Y(long j3, int i3) {
    }
}
