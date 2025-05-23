package com.qzone.adapter.feedcomponent;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FakeShuoShuoDataCacheHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f41848a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f41849b = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class ReplaceAction implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final List<String> f41850d;

        /* renamed from: e, reason: collision with root package name */
        private final int f41851e;

        /* renamed from: f, reason: collision with root package name */
        private final String f41852f;

        public ReplaceAction(List<String> list, int i3, String str) {
            this.f41850d = list;
            this.f41851e = i3;
            this.f41852f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<String> list = this.f41850d;
            if (list != null && !list.isEmpty()) {
                if (TextUtils.isEmpty(this.f41852f)) {
                    com.qzone.proxy.feedcomponent.b.i("FakeShuoShuoDataCacheHelper", "run, mNewPath is null or empty ");
                    return;
                }
                int size = this.f41850d.size();
                int i3 = this.f41851e;
                if (size <= i3) {
                    com.qzone.proxy.feedcomponent.b.i("FakeShuoShuoDataCacheHelper", "run, mLocalFilePath size less than mIndex: " + this.f41851e);
                    return;
                }
                com.qzone.proxy.feedcomponent.b.i("FakeShuoShuoDataCacheHelper", "run, mIndex: " + this.f41851e + ", mNewPath: " + this.f41852f + ", oldPath: " + this.f41850d.set(i3, this.f41852f));
                return;
            }
            com.qzone.proxy.feedcomponent.b.i("FakeShuoShuoDataCacheHelper", "run, mLocalFilePath is null or empty ");
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public List<String> f41853a = new ArrayList();

        public List<String> a() {
            if (this.f41853a.size() <= 9) {
                return this.f41853a;
            }
            return this.f41853a.subList(0, 9);
        }

        public boolean b() {
            return !this.f41853a.isEmpty();
        }

        public boolean c() {
            int min = Math.min(this.f41853a.size(), 9);
            ArrayList arrayList = new ArrayList();
            boolean z16 = false;
            for (int i3 = 0; i3 < min; i3++) {
                String str = this.f41853a.get(i3);
                String str2 = (String) FakeShuoShuoDataCacheHelper.f41849b.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    com.qzone.proxy.feedcomponent.b.a("FakeShuoShuoDataCacheHelper", "isFileExists, exists map path, filePath: " + str + ", mapPath: " + str2);
                    arrayList.add(new ReplaceAction(this.f41853a, i3, str2));
                    str = str2;
                }
                if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                    com.qzone.proxy.feedcomponent.b.i("FakeShuoShuoDataCacheHelper", "isFileExists, not exists filePath: " + str);
                    break;
                }
            }
            z16 = true;
            if (z16 && !arrayList.isEmpty()) {
                com.qzone.proxy.feedcomponent.b.a("FakeShuoShuoDataCacheHelper", "isFileExists, run replace actions ");
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ReplaceAction) it.next()).run();
                }
            }
            return z16;
        }

        public String toString() {
            return "FakeShuoShuoData{localFilePath=" + this.f41853a + '}';
        }
    }

    public static a b(String str) {
        return f41848a.get(str);
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = f41849b.get(str);
        com.qzone.proxy.feedcomponent.b.i("FakeShuoShuoDataCacheHelper", "getExportMapEndPath, endPath: " + str2);
        return str2;
    }

    private static List<String> d(CellPictureInfo cellPictureInfo) {
        ArrayList<PictureItem> arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (cellPictureInfo != null && (arrayList = cellPictureInfo.pics) != null && !arrayList.isEmpty()) {
            Iterator<PictureItem> it = arrayList.iterator();
            while (it.hasNext()) {
                PictureItem next = it.next();
                if (next.videoflag == 1) {
                    String e16 = e(next.videodata);
                    com.qzone.proxy.feedcomponent.b.a("FakeShuoShuoDataCacheHelper", "getImageUrl, videoUrl: " + e16);
                    if (!TextUtils.isEmpty(e16)) {
                        arrayList2.add(e16);
                    }
                } else {
                    String str = next.localFileUrl;
                    com.qzone.proxy.feedcomponent.b.a("FakeShuoShuoDataCacheHelper", "getImageUrl, imageUrl: " + str);
                    if (!TextUtils.isEmpty(str)) {
                        arrayList2.add(str);
                    }
                }
            }
        }
        return arrayList2;
    }

    private static String e(VideoInfo videoInfo) {
        VideoUrl videoUrl;
        if (videoInfo == null || (videoUrl = videoInfo.videoUrl) == null) {
            return "";
        }
        return videoUrl.url;
    }

    public static void f(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            com.qzone.proxy.feedcomponent.b.i("FakeShuoShuoDataCacheHelper", "put, feedData is null ");
            return;
        }
        CellFeedCommInfo feedCommInfoV2 = businessFeedData.getFeedCommInfoV2();
        if (feedCommInfoV2 == null) {
            com.qzone.proxy.feedcomponent.b.i("FakeShuoShuoDataCacheHelper", "put, feedCommInfoV2 is null ");
            return;
        }
        int i3 = feedCommInfoV2.appid;
        String str = feedCommInfoV2.clientkey;
        com.qzone.proxy.feedcomponent.b.a("FakeShuoShuoDataCacheHelper", "put, appId: " + i3 + ", clientKey: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a aVar = new a();
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        if (videoInfo != null) {
            String e16 = e(videoInfo);
            com.qzone.proxy.feedcomponent.b.a("FakeShuoShuoDataCacheHelper", "put, videoInfo is not null, videoUrl: " + e16);
            if (!TextUtils.isEmpty(e16)) {
                aVar.f41853a.add(e16);
            }
        }
        CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
        if (pictureInfo != null) {
            List<String> d16 = d(pictureInfo);
            com.qzone.proxy.feedcomponent.b.a("FakeShuoShuoDataCacheHelper", "put, pictureInfo is not null, imageUrlList: " + d16);
            if (!d16.isEmpty()) {
                aVar.f41853a.addAll(d16);
            }
        }
        if (aVar.b()) {
            com.qzone.proxy.feedcomponent.b.a("FakeShuoShuoDataCacheHelper", "put, shuoShuoData: " + aVar);
            f41848a.put(str, aVar);
        }
    }

    public static void g(String str, String str2) {
        com.qzone.proxy.feedcomponent.b.i("FakeShuoShuoDataCacheHelper", "putExportMap, originPath: " + str + ", endPath: " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f41849b.put(str, str2);
    }
}
