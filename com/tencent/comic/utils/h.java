package com.tencent.comic.utils;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, String> f99489a = null;

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, String> f99490b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f99491c = false;

    static {
        HashMap hashMap = new HashMap();
        f99490b = hashMap;
        hashMap.put("comicIndex", "https://qc.vip.qq.com/gc/pages/index.html?asyncMode=3");
        f99490b.put("comicCategory", "https://qc.vip.qq.com/gc/pages/category.html?from=1006002&filter=0&categoryType=1&sort=4&_bid=354&_wv=1027&_cwv=4&_webviewtype=4&asyncMode=3&_wvx=3");
        f99490b.put("comicGroup", "https://qc.vip.qq.com/gc/pages/user/home.html?_wv=1091118887&_wvx=3&asyncMode=3&_sharp_v=1&_sonic_xv=32&cancelColorTab=1");
        f99490b.put("comicMore", "https://qc.vip.qq.com/gc/pages/community/square.html?_wv=3&_cwv=4&origin=1&from=10000001");
        f99490b.put("comicPayDownload", "https://cdn.vip.qq.com/club/client/comic/release/html/payDownload.html");
        f99490b.put("comicPayRead", "https://cdn.vip.qq.com/club/client/comic/release/html/payRead.html");
        f99490b.put("comicDetailComic", "https://cdn.vip.qq.com/club/client/comic/release/html/detail.html");
        f99490b.put("comicDetailNovel", "https://cdn.vip.qq.com/club/client/comic/release/html/detail.html");
        f99490b.put("comicDetailVideo", "https://cdn.vip.qq.com/club/client/comic/release/html/video.html");
        f99490b.put("comicMyPic", "https://cdn.vip.qq.com/club/client/comic/release/html/my_pic.html");
        f99490b.put("comicVideoSimple", "https://cdn.vip.qq.com/club/client/comic/release/html/video.html");
        f99490b.put("comicReadShare", "https://cdn.vip.qq.com/club/client/comic/release/html/read_share.html");
        f99490b.put("comicPicShare", "https://cdn.vip.qq.com/club/client/comic/release/html/pic_share.html");
        f99490b.put("comicReport", "https://guanjia.qq.com/online_server/m_report.html");
        f99490b.put("comicCdn", "https://imgcache.gtimg.cn/club/mobile/profile/comic_center/");
        f99490b.put("comicFav", "https://qc.vip.qq.com/gc/pages/user/favorite.html?_wv=3&_cwv=4&asyncMode=3&_sharp_v=1&_sonic_xv=32");
        f99490b.put("comicReaderContent", "https://cdn.vip.qq.com/club/client/comic/release/html/readerIndex.html");
        f99490b.put("comicSearch", "https://cdn.vip.qq.com/club/client/comic/release/html/search.html?platId=109&_bid=354&pos=external&_wv=1027&from=6");
        f99490b.put("comicBarrageList", "https://cdn.vip.qq.com/club/client/comic/release/html/bulletScreen.html");
        f99490b.put("comicQRCode", "https://cdn.vip.qq.com/club/client/comic/release/html/redirect.html");
        f99490b.put("comicReaderContentNew", "https://qc.vip.qq.com/gc/pages/detail/reader-index.html");
        f99490b.put("comicNewDetailPage", "https://qc.vip.qq.com/gc/pages/detail/comicDetail.html");
        f99490b.put("downloadDetail", "https://cdn.vip.qq.com/club/client/comic/release/html/downloadDetail.html");
        f99490b.put("downloadPage", "https://qc.vip.qq.com/gc/pages/download.html");
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str.contains("#")) {
            String[] split = str.split("\\#");
            String str3 = split[0];
            int length = split.length;
            String str4 = "";
            for (int i3 = 1; i3 < length; i3++) {
                str4 = str4 + "#" + split[i3];
            }
            if (str3.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                return str3.replace(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2 + ContainerUtils.FIELD_DELIMITER) + str4;
            }
            return str3 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2 + str4;
        }
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            return str.replace(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2 + ContainerUtils.FIELD_DELIMITER);
        }
        return str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2;
    }

    public static String b(String str, String str2, String str3) {
        String str4;
        if (str.indexOf(str2) == -1) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter(str2, str3);
            str4 = buildUpon.build().toString();
        } else {
            str4 = str;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VipComicUrlHelper", 2, "addUrlField url is " + str + "fieldName is " + str2 + ",Value is " + str3 + ", newUrl is " + str4);
        }
        return str4;
    }

    public static String c(String str) {
        Map<String, String> map = f99489a;
        String str2 = map != null ? map.get(str) : null;
        return str2 == null ? f99490b.get(str) : str2;
    }

    public static synchronized void d(Intent intent) {
        synchronized (h.class) {
            if (f99491c) {
                return;
            }
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra("urlMap");
            if (serializableExtra instanceof HashMap) {
                HashMap hashMap = (HashMap) serializableExtra;
                if (hashMap.isEmpty()) {
                    return;
                }
                if (f99489a == null) {
                    f99489a = new HashMap();
                }
                f99489a.clear();
                f99489a.putAll(hashMap);
                f99491c = true;
            }
        }
    }

    public static String f(String str, String str2, String str3) {
        String str4;
        if (!str.isEmpty() && !str2.isEmpty() && !str3.isEmpty()) {
            str4 = str.replaceAll("(" + str2 + "=[^&]*)", str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3);
        } else {
            str4 = "";
        }
        if (QLog.isColorLevel()) {
            QLog.d("VipComicUrlHelper", 2, "replaceUrlFieldValueReg url is " + str + "fieldName is " + str2 + ",newValue is " + str3 + ", newUrl is " + str4);
        }
        return str4;
    }

    public static boolean e(String str) {
        if (str != null) {
            return (str.indexOf("banSlideToTab=1") == -1 && str.indexOf("bodong.vip.qq.com") == -1 && str.indexOf("qc.vip.qq.com") == -1 && str.indexOf("cdn.vip.qq.com/club/client/comic") == -1) ? false : true;
        }
        return false;
    }
}
