package com.tencent.open.base;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import org.apache.http.HttpResponse;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class i {
    public static Object[] a(Context context, String str, String str2) {
        String str3;
        String str4;
        if (QLog.isColorLevel()) {
            QLog.d("Q.share.ShareProcessorUtil", 2, "getRichInfo|targetUrl=" + str);
        }
        int i3 = -1;
        String str5 = null;
        Object[] objArr = {-1, null, null, null};
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                HttpResponse openRequest = HttpUtil.openRequest(context, String.format("https://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s", str2, URLEncoder.encode(str)), null, "GET", null, null, 5000, 5000);
                if (openRequest != null) {
                    int statusCode = openRequest.getStatusLine().getStatusCode();
                    if (statusCode == 200) {
                        String readHttpResponse = HttpUtil.readHttpResponse(openRequest);
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.share.ShareProcessorUtil", 2, "getRichInfo|result=" + readHttpResponse);
                        }
                        if (!TextUtils.isEmpty(readHttpResponse)) {
                            JSONObject jSONObject = new JSONObject(readHttpResponse);
                            if (jSONObject.has("ret")) {
                                i3 = jSONObject.getInt("ret");
                            }
                            if (jSONObject.has("title")) {
                                str3 = jSONObject.getString("title");
                            } else {
                                str3 = null;
                            }
                            if (jSONObject.has("abstract")) {
                                str4 = jSONObject.getString("abstract");
                            } else {
                                str4 = null;
                            }
                            if (jSONObject.has("thumbUrl")) {
                                str5 = jSONObject.getString("thumbUrl");
                            }
                            if (i3 != 0) {
                                QLog.w("Q.share.ShareProcessorUtil", 1, "getRichInfo|ret=" + i3);
                            }
                            return new Object[]{Integer.valueOf(i3), str3, str4, str5};
                        }
                        return objArr;
                    }
                    QLog.w("Q.share.ShareProcessorUtil", 1, "getRichInfo|httpCode=" + statusCode);
                    return objArr;
                }
                return objArr;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.share.ShareProcessorUtil", 2, e16, new Object[0]);
                    return objArr;
                }
                return objArr;
            }
        }
        return objArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006c A[Catch: Exception -> 0x0049, TRY_LEAVE, TryCatch #0 {Exception -> 0x0049, blocks: (B:31:0x0034, B:33:0x003a, B:35:0x0042, B:9:0x0054, B:11:0x005a, B:13:0x0060, B:14:0x0066, B:16:0x006c, B:29:0x0050), top: B:30:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0050 A[Catch: Exception -> 0x0049, TryCatch #0 {Exception -> 0x0049, blocks: (B:31:0x0034, B:33:0x003a, B:35:0x0042, B:9:0x0054, B:11:0x005a, B:13:0x0060, B:14:0x0066, B:16:0x006c, B:29:0x0050), top: B:30:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(boolean z16, String str, String str2, String str3) {
        ImageCacheHelper imageCacheHelper;
        Object g16;
        boolean z17;
        String filePath;
        boolean z18;
        if (QLog.isColorLevel()) {
            QLog.d("Q.share.ShareProcessorUtil", 2, "reuseImageForAIO|oldCache=" + str + ",oldUrl=" + str2 + ",newUrl=" + str3);
        }
        if (str != null) {
            try {
                if (!str.equals(str3) && (g16 = (imageCacheHelper = ImageCacheHelper.f98636a).g(str)) != null) {
                    imageCacheHelper.i(str3, g16, Business.AIO);
                    z17 = true;
                    if (!z16) {
                        filePath = str2;
                    } else {
                        filePath = AbsDownloader.getFilePath(str2);
                    }
                    String filePath2 = AbsDownloader.getFilePath(str3);
                    if (str2 == null && !str2.equals(str3)) {
                        z18 = FileUtils.copyFile(filePath, filePath2);
                    } else {
                        z18 = false;
                    }
                    if (!QLog.isColorLevel()) {
                        QLog.d("Q.share.ShareProcessorUtil", 2, "reuseImageForAIO|cache=" + z17 + ",file=" + z18);
                        return;
                    }
                    return;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.share.ShareProcessorUtil", 2, e16, new Object[0]);
                    return;
                }
                return;
            }
        }
        z17 = false;
        if (!z16) {
        }
        String filePath22 = AbsDownloader.getFilePath(str3);
        if (str2 == null) {
        }
        z18 = false;
        if (!QLog.isColorLevel()) {
        }
    }
}
