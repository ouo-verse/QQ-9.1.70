package nh;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qqvideoplatform.api.PlatformInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f420131a = RFWApplication.getApplication().getExternalCacheDir() + "/superplayer/170303126";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f420132b = false;

    public static SuperPlayerVideoInfo a(String str, String str2, int i3) {
        if (!h(str2, str)) {
            i(str2, 1);
            int i16 = RFWLog.USR;
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("createSuperVideoInfo error:");
            if (TextUtils.isEmpty(str2)) {
                str2 = "error url";
            }
            sb5.append(str2);
            objArr[0] = sb5.toString();
            RFWLog.e("QZoneVideoUtils", i16, objArr);
            return null;
        }
        i(str2, 2);
        if (!StringUtil.isEmpty(str) && TextUtils.isEmpty(str2)) {
            SuperPlayerVideoInfo createVideoInfoForTVideo = SuperPlayerFactory.createVideoInfoForTVideo(PlatformInfo.ID_QQGAME, str);
            createVideoInfoForTVideo.setVideoDurationMs(i3);
            return createVideoInfoForTVideo;
        }
        String c16 = c(str2, str);
        RFWLog.d("QZoneVideoUtils", RFWLog.USR, "createSuperVideoInfo fileId:", c16, ", url:", str2);
        return b(str2, c16, i3);
    }

    public static SuperPlayerVideoInfo b(String str, String str2, int i3) {
        int i16 = 101;
        if (TextUtils.isEmpty(str)) {
            QLog.e("QZoneVideoUtils", 1, "createVideoInfo url empty");
            return SuperPlayerFactory.createVideoInfoForUrl("", 101, "");
        }
        ArrayList arrayList = new ArrayList();
        String f16 = f(str);
        arrayList.add(str);
        if (str.contains("flv")) {
            i16 = 202;
        } else if (str.contains("rtmp")) {
            i16 = 103;
        } else if (str.contains(".m3u8") || str.contains(".ts")) {
            i16 = 102;
        }
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl((String[]) arrayList.toArray(new String[arrayList.size()]), i16, str2, "");
        createVideoInfoForUrl.setUrlHostList(new ArrayList<>(Arrays.asList(f16)));
        createVideoInfoForUrl.setVideoDurationMs(i3);
        return createVideoInfoForUrl;
    }

    private static String c(String str, String str2) {
        try {
            String str3 = Uri.parse(str).getPathSegments().get(0);
            if (str3.contains(".mp4")) {
                return str3.substring(0, str3.indexOf(".mp4"));
            }
        } catch (Exception e16) {
            QLog.d("QZoneVideoUtils", 1, "getFileIdWithTapPosition exception:" + e16);
        }
        if (TextUtils.isEmpty(str2)) {
            return !TextUtils.isEmpty(str) ? str : "";
        }
        QLog.d("QZoneVideoUtils", 1, "getFileIdWithTapPosition return vid" + str2);
        return str2;
    }

    public static String d(int i3) {
        String valueOf;
        int i16 = i3 / 1000;
        int i17 = i16 / 60;
        int i18 = i16 % 60;
        if (i17 < 10) {
            valueOf = "0" + i17;
        } else {
            valueOf = String.valueOf(i17);
        }
        if (i18 < 10) {
            return String.format("%s:0%s", valueOf, Integer.valueOf(i18));
        }
        return String.format("%s:%s", valueOf, Integer.valueOf(i18));
    }

    public static String e(int i3) {
        int i16 = i3 / 1000;
        return (i16 / 60) + "\u5206" + (i16 % 60) + "\u79d2";
    }

    public static String f(String str) {
        try {
            return Uri.parse(str).getHost();
        } catch (Exception e16) {
            QLog.e("QZoneVideoUtils", 1, "get host failed: " + str + ", error = " + e16.getMessage());
            return null;
        }
    }

    public static boolean h(String str, String str2) {
        if (FileUtils.fileExists(str)) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return !TextUtils.isEmpty(str2);
            }
            Uri parse = Uri.parse(str);
            return (TextUtils.isEmpty(parse.getScheme()) || TextUtils.isEmpty(parse.getHost()) || TextUtils.isEmpty(parse.getPath())) ? false : true;
        } catch (Exception e16) {
            RFWLog.d("QZoneVideoUtils", RFWLog.USR, e16);
            return false;
        }
    }

    public static void i(String str, int i3) {
        TextUtils.isEmpty(str);
    }

    public static String g(String str) {
        int indexOf;
        return (str == null || str.trim().length() == 0 || (indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) == -1) ? str : str.substring(0, indexOf);
    }
}
