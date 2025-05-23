package com.qzone.album.util;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.ParentingAlbumData;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.album.data.model.TimeEvent;
import com.qzone.album.data.model.TimeLine;
import com.qzone.album.data.model.TravelAlbumData;
import com.qzone.util.image.NetImageInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {
    public static String a(PhotoPoiArea photoPoiArea, long j3) {
        if (photoPoiArea == null) {
            return "";
        }
        double d16 = ((photoPoiArea.startShootTime * 1000) - j3) / 8.64E7d;
        if (d16 >= 0.0d) {
            int ceil = (int) Math.ceil(d16);
            if (ceil == 0) {
                return HiAnalyticsConstant.KeyAndValue.NUMBER_01;
            }
            if (ceil < 10) {
                return "0" + ceil;
            }
            return ceil + "";
        }
        return com.qzone.util.l.a(R.string.f171549j31) + (-((int) Math.floor(d16))) + com.qzone.util.l.a(R.string.f171550j32);
    }

    public static ArrayList<String> b(ArrayList<String> arrayList, ArrayList<NetImageInfo> arrayList2, String str) {
        HashMap hashMap = new HashMap();
        if (arrayList2 != null) {
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                hashMap.put(arrayList2.get(i3).getBigPath(), arrayList2.get(i3));
            }
        }
        ArrayList<String> arrayList3 = new ArrayList<>(arrayList2 != null ? arrayList2.size() : 0);
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            if (!arrayList.get(i16).startsWith("http")) {
                arrayList3.add(arrayList.get(i16));
            } else if (hashMap.get(arrayList.get(i16)) != null) {
                arrayList3.add(((NetImageInfo) hashMap.get(arrayList.get(i16))).lloc);
            }
        }
        return arrayList3;
    }

    public static HashMap<String, PhotoSendParams> d(ArrayList<NetImageInfo> arrayList) {
        HashMap<String, PhotoSendParams> hashMap = new HashMap<>(1);
        if (arrayList != null && arrayList.size() > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).sendParams != null) {
                    hashMap.put(arrayList.get(i3).getBigPath(), arrayList.get(i3).sendParams);
                }
            }
        }
        return hashMap;
    }

    public static int e(x4.a aVar, Calendar calendar) {
        Calendar f16;
        int ceil;
        AlbumCacheData g16 = aVar.g();
        if (g16 == null) {
            return 0;
        }
        long j3 = g16.birthDateTime;
        if (j3 <= 0 || (f16 = QZoneAlbumUtil.f(j3)) == null || calendar == null) {
            return 0;
        }
        double timeInMillis = ((calendar.getTimeInMillis() - f16.getTimeInMillis()) + 1000) / 8.64E7d;
        if (timeInMillis < 0.0d || (ceil = (int) Math.ceil(timeInMillis)) <= 0) {
            return 0;
        }
        return ceil;
    }

    public static PhotoPoiArea f(x4.a aVar, PhotoCacheData photoCacheData) {
        List synchronizedList;
        TravelAlbumData i3 = i(aVar);
        if (i3 == null || i3.photoPoiAreaList == null || (synchronizedList = Collections.synchronizedList(i(aVar).photoPoiAreaList)) == null) {
            return null;
        }
        for (Object obj : synchronizedList) {
            if (!(obj instanceof PhotoPoiArea)) {
                QLog.e("[PhotoAlbum]AdapterUtil", 1, "getPhotoPoiAreaFitPhoto, Invalid type in list: " + obj);
            } else {
                PhotoPoiArea photoPoiArea = (PhotoPoiArea) obj;
                if (photoCacheData != null) {
                    long j3 = photoCacheData.shoottime;
                    if (j3 >= photoPoiArea.startShootTime && j3 <= photoPoiArea.endShootTime) {
                        return photoPoiArea;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public static TimeLine h(x4.a aVar, PhotoCacheData photoCacheData) {
        AlbumCacheData g16 = aVar.g();
        if (g16 == null) {
            com.qzone.proxy.feedcomponent.b.i("[PhotoAlbum]AdapterUtil", "albumCacheData");
            return null;
        }
        ParentingAlbumData parentingAlbumData = g16.parentingData;
        if (parentingAlbumData == null) {
            com.qzone.proxy.feedcomponent.b.i("[PhotoAlbum]AdapterUtil", "the albumCacheData  parentData is null");
            return null;
        }
        ArrayList<TimeLine> arrayList = parentingAlbumData.timeLineList;
        if (arrayList == null) {
            com.qzone.proxy.feedcomponent.b.i("[PhotoAlbum]AdapterUtil", "timeLineList is null");
            return null;
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            TimeLine timeLine = arrayList.get(i3);
            if (photoCacheData != null && timeLine != null) {
                long j3 = photoCacheData.shoottime;
                if (j3 >= timeLine.beginTime && j3 <= timeLine.endTime) {
                    return timeLine;
                }
            }
        }
        return null;
    }

    public static boolean j(x4.a aVar, List<PhotoCacheData> list, int i3, int i16) {
        PhotoCacheData photoCacheData = list.get(i3);
        PhotoCacheData photoCacheData2 = list.get(i16);
        if (photoCacheData == null || photoCacheData2 == null) {
            return true;
        }
        PhotoPoiArea f16 = f(aVar, photoCacheData);
        return (f16 == null || f16.equals(f(aVar, photoCacheData2))) ? false : true;
    }

    public static boolean l(List<PhotoCacheData> list, int i3, int i16) {
        long j3;
        long j16;
        PhotoCacheData photoCacheData = list.get(i3);
        PhotoCacheData photoCacheData2 = list.get(i16);
        if (photoCacheData == null || photoCacheData2 == null) {
            return true;
        }
        long j17 = photoCacheData.shoottime;
        if (j17 == 0 && photoCacheData2.shoottime == 0) {
            j3 = photoCacheData.uploadtime * 1000;
            j16 = photoCacheData2.uploadtime;
        } else {
            j3 = j17 * 1000;
            j16 = photoCacheData2.shoottime;
        }
        long j18 = j16 * 1000;
        if (g.l(j3, j18) || j3 <= 0) {
            return j3 == 0 && j18 > 0;
        }
        return true;
    }

    public static boolean m(List<PhotoCacheData> list, int i3, int i16, boolean z16) {
        long j3;
        long j16;
        PhotoCacheData photoCacheData = list.get(i3);
        PhotoCacheData photoCacheData2 = list.get(i16);
        if (photoCacheData == null || photoCacheData2 == null) {
            return true;
        }
        if (z16) {
            j3 = photoCacheData.shoottime * 1000;
            j16 = photoCacheData2.shoottime;
        } else {
            j3 = photoCacheData.uploadtime * 1000;
            j16 = photoCacheData2.uploadtime;
        }
        long j17 = j16 * 1000;
        if (g.l(j3, j17) || j3 <= 0) {
            return j3 == 0 && j17 > 0;
        }
        return true;
    }

    public static ArrayList<String> c(List<PhotoCacheData> list) {
        if (list == null) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            arrayList.add(list.get(i3).lloc);
        }
        return arrayList;
    }

    public static TimeEvent g(AlbumCacheData albumCacheData, long j3) {
        ArrayList<TimeEvent> arrayList;
        if (albumCacheData != null && (arrayList = albumCacheData.timeEventData) != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                TimeEvent timeEvent = arrayList.get(i3);
                if (timeEvent != null && g.l(QZoneAlbumUtil.m(timeEvent.f43879d), j3)) {
                    return timeEvent;
                }
            }
        }
        return null;
    }

    public static boolean k(x4.a aVar, PhotoCacheData[] photoCacheDataArr, PhotoCacheData[] photoCacheDataArr2) {
        if (photoCacheDataArr != null && photoCacheDataArr.length > 0 && photoCacheDataArr2 != null && photoCacheDataArr2.length > 0) {
            TimeLine h16 = h(aVar, photoCacheDataArr[0]);
            TimeLine h17 = h(aVar, photoCacheDataArr2[0]);
            if (h16 != null && h16.equals(h17)) {
                return true;
            }
        }
        return false;
    }

    public static boolean n(x4.a aVar) {
        if (aVar == null || aVar.E() || aVar.b() != 0) {
            return (aVar == null || aVar.c()) ? false : true;
        }
        return true;
    }

    public static TravelAlbumData i(x4.a aVar) {
        if (aVar == null) {
            return null;
        }
        AlbumCacheData g16 = aVar.g();
        if (g16 == null) {
            QZLog.d("[PhotoAlbum]AdapterUtil", 2, "album == null");
            return null;
        }
        TravelAlbumData travelAlbumData = g16.travelData;
        if (travelAlbumData != null) {
            return travelAlbumData;
        }
        QZLog.d("[PhotoAlbum]AdapterUtil", 2, "travelData == null");
        return null;
    }
}
