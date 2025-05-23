package com.tencent.mobileqq.guild.feed.util;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedHtmlOfflineUtil {
    public static String a(String str) {
        if (!c()) {
            return str.replace(d(), "");
        }
        return str;
    }

    public static String b(String str) {
        if (!c()) {
            return str.replace(e(), "");
        }
        return str;
    }

    private static boolean c() {
        return true;
    }

    public static String d() {
        return "&_bid=4895";
    }

    public static String e() {
        return "&_bid=4895";
    }

    public static void f() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedHtmlOfflineUtil.1
            @Override // java.lang.Runnable
            public void run() {
                HtmlOffline.k("4895", MobileQQ.sMobileQQ.waitAppRuntime(null), new a(), true, 0, true);
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.guild.feed.util.GuildFeedHtmlOfflineUtil$1$a */
            /* loaded from: classes13.dex */
            class a implements com.tencent.biz.common.offline.a {
                a() {
                }

                @Override // com.tencent.biz.common.offline.a
                public void loaded(String str, int i3) {
                    QLog.d("GuildFeedHtmlOfflineUtil", 1, "load guild feed detail html web resource finish code:" + i3);
                }

                @Override // com.tencent.biz.common.offline.a
                public void progress(int i3) {
                }
            }
        });
    }
}
