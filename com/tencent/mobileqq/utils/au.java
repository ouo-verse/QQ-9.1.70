package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class au {
    public static void a(DownloadInfo downloadInfo) {
        String str;
        String str2;
        int i3;
        if (downloadInfo != null && (str = downloadInfo.urlOriginal) != null && str.length() != 0) {
            if (!downloadInfo.isHttps) {
                str2 = "http://";
            } else {
                str2 = HttpDownloadUtil.PROTOCOL_HTTPS;
            }
            int length = str2.length();
            int indexOf = downloadInfo.urlOriginal.indexOf("/", length);
            String substring = downloadInfo.urlOriginal.substring(length, indexOf);
            if (indexOf <= length && TextUtils.isEmpty(substring)) {
                return;
            }
            if ("imgcache.qq.com".equalsIgnoreCase(substring)) {
                i3 = 12;
            } else if ("imgcache.gtimg.cn".equalsIgnoreCase(substring)) {
                i3 = 13;
            } else if ("i.gtimg.cn".equalsIgnoreCase(substring)) {
                i3 = 14;
            } else if ("cmshow.gtimg.cn".equalsIgnoreCase(substring)) {
                i3 = 17;
            } else {
                downloadInfo.host = null;
                downloadInfo.reqUrl = downloadInfo.urlOriginal;
                downloadInfo.isIPUrl = false;
                if (QLog.isColorLevel()) {
                    QLog.d("Q.emoji.EmoDown", 2, "unknow domain url=" + downloadInfo.isIPUrl);
                    return;
                }
                return;
            }
            String str3 = str2 + "[^/\\s]*/";
            String srvAddr = FMTSrvAddrProvider.getInstance().getSrvAddr(i3);
            if (srvAddr != null && srvAddr.length() > 0) {
                String replaceFirst = downloadInfo.urlOriginal.replaceFirst(str3, srvAddr);
                if (downloadInfo.isHttps && !TextUtils.isEmpty(replaceFirst) && replaceFirst.startsWith("http://")) {
                    replaceFirst = str2 + replaceFirst.substring(7);
                }
                downloadInfo.host = substring;
                downloadInfo.reqUrl = replaceFirst;
                downloadInfo.isIPUrl = true;
                downloadInfo.domainType = i3;
                if (QLog.isColorLevel()) {
                    QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp " + downloadInfo.isIPUrl + " url[" + downloadInfo.urlOriginal + "] resetIP[" + replaceFirst + "] host[" + downloadInfo.host + "]");
                    return;
                }
                return;
            }
            downloadInfo.host = null;
            downloadInfo.reqUrl = downloadInfo.urlOriginal;
            downloadInfo.isIPUrl = false;
            if (QLog.isColorLevel()) {
                QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp false.url[" + downloadInfo.reqUrl + "]");
            }
        }
    }
}
