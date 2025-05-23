package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class j {
    static IPatchRedirector $redirector_;

    public static HashMap<String, String> a(HashMap<LocalMediaInfo, LocalMediaInfo> hashMap) {
        if (hashMap == null) {
            return null;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        for (Map.Entry<LocalMediaInfo, LocalMediaInfo> entry : hashMap.entrySet()) {
            hashMap2.put(entry.getKey().path, entry.getValue().path);
        }
        return hashMap2;
    }

    public static LocalMediaInfo b(Context context, String str, boolean z16) {
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.mMediaType = 0;
        localMediaInfo.path = str;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(localMediaInfo.path, options);
        localMediaInfo.mediaWidth = options.outWidth;
        localMediaInfo.mediaHeight = options.outHeight;
        if (z16) {
            localMediaInfo.thumbWidth = 0;
            localMediaInfo.thumbHeight = (int) context.getResources().getDimension(R.dimen.f158877re);
            int i16 = localMediaInfo.mediaWidth;
            if (i16 > 0 && (i3 = localMediaInfo.mediaHeight) > 0) {
                FlowThumbDecoder.determineThumbSize(localMediaInfo, i16, i3);
            }
        } else {
            int i17 = AlbumThumbDownloader.THUMB_WIDHT;
            localMediaInfo.thumbHeight = i17;
            localMediaInfo.thumbWidth = i17;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReplacePhotoDataUtil", 1, "convert to mediaInfo, cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        return localMediaInfo;
    }

    public static LocalMediaInfo c(Map<LocalMediaInfo, LocalMediaInfo> map, String str) {
        for (Map.Entry<LocalMediaInfo, LocalMediaInfo> entry : map.entrySet()) {
            if (str.equals(entry.getValue().path)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static String d(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static HashMap<String, String> e(HashMap<LocalMediaInfo, LocalMediaInfo> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>(hashMap.size());
        for (Map.Entry<LocalMediaInfo, LocalMediaInfo> entry : hashMap.entrySet()) {
            hashMap2.put(entry.getKey().path, entry.getValue().path);
        }
        return hashMap2;
    }

    public static boolean f(String str, HashMap<LocalMediaInfo, LocalMediaInfo> hashMap) {
        Iterator<Map.Entry<LocalMediaInfo, LocalMediaInfo>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().path.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static void g(List<LocalMediaInfo> list, int i3, ArrayList<String> arrayList, HashMap<LocalMediaInfo, LocalMediaInfo> hashMap) {
        LocalMediaInfo localMediaInfo;
        for (Map.Entry<LocalMediaInfo, LocalMediaInfo> entry : hashMap.entrySet()) {
            int i16 = i3;
            while (true) {
                if (i16 < list.size()) {
                    localMediaInfo = list.get(i16);
                    if (localMediaInfo.path.equals(entry.getKey().path)) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    localMediaInfo = null;
                    break;
                }
            }
            if (localMediaInfo != null) {
                int indexOf = list.indexOf(localMediaInfo);
                list.remove(localMediaInfo);
                list.add(indexOf, entry.getValue());
                entry.getValue().position = Integer.valueOf(indexOf);
                if (arrayList != null) {
                    int indexOf2 = arrayList.indexOf(localMediaInfo.path);
                    if (indexOf2 == -1) {
                        QLog.e("ReplacePhotoDataUtil", 1, "mediaList size:" + list.size() + ",mPhotos size:" + arrayList.size());
                    } else {
                        arrayList.remove(localMediaInfo.path);
                        arrayList.add(indexOf2, entry.getValue().path);
                    }
                }
            }
        }
    }

    public static void h(Context context, Intent intent, boolean z16, HashMap<LocalMediaInfo, LocalMediaInfo> hashMap) {
        HashMap hashMap2;
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) intent.getSerializableExtra(PeakConstants.VIDEO_EDIT_OLD_MEDIA);
        LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) intent.getSerializableExtra(PeakConstants.VIDEO_EDIT_NEW_MEDIA);
        if ((localMediaInfo == null || localMediaInfo2 == null) && (hashMap2 = (HashMap) intent.getSerializableExtra(QAlbumConstants.KEY_EDIT_PATHS_MAP)) != null) {
            for (Map.Entry entry : hashMap2.entrySet()) {
                LocalMediaInfo b16 = b(context, (String) entry.getKey(), z16);
                LocalMediaInfo b17 = b(context, (String) entry.getValue(), z16);
                LocalMediaInfo c16 = c(hashMap, (String) entry.getKey());
                if (c16 != null) {
                    b16 = c16;
                }
                hashMap.put(b16, b17);
                b17.picPathBeforeEdit = b16.path;
            }
        }
    }

    public static void i(Context context, HashMap<LocalMediaInfo, LocalMediaInfo> hashMap, List<LocalMediaInfo> list) {
        if (list == null) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        for (LocalMediaInfo localMediaInfo : list) {
            if (!TextUtils.isEmpty(localMediaInfo.picPathBeforeEdit)) {
                hashMap2.put(localMediaInfo.picPathBeforeEdit, localMediaInfo.path);
            }
        }
        j(context, hashMap, hashMap2);
    }

    public static void j(Context context, HashMap<LocalMediaInfo, LocalMediaInfo> hashMap, HashMap<String, String> hashMap2) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        if (hashMap2 != null) {
            for (Map.Entry<String, String> entry : hashMap2.entrySet()) {
                LocalMediaInfo b16 = b(context, entry.getKey(), false);
                LocalMediaInfo b17 = b(context, entry.getValue(), false);
                LocalMediaInfo c16 = c(hashMap, entry.getKey());
                if (c16 != null) {
                    b16 = c16;
                }
                hashMap.put(b16, b17);
                b17.picPathBeforeEdit = b16.path;
            }
        }
    }
}
