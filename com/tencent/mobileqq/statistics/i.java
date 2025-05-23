package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i {
    static IPatchRedirector $redirector_;

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        String[] strArr = {"/weibo", "/sina/news/save/", "/faceq/", "/newsreader/", "/tieba", "/baidu", "/UCDownloads", "/taobao", "/news_article/", "/sohunewsdown/", "/pitu/", "/pins/", "/tumblr/", "/download"};
        for (int i3 = 0; i3 < 14; i3++) {
            if (str.contains(strArr[i3])) {
                return true;
            }
        }
        return false;
    }
}
