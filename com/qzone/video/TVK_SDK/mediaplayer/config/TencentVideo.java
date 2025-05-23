package com.qzone.video.TVK_SDK.mediaplayer.config;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.video.TVK_SDK.mediaplayer.utils.c;
import com.qzone.video.TVK_SDK.mediaplayer.utils.e;

/* compiled from: P */
/* loaded from: classes37.dex */
public class TencentVideo {

    /* renamed from: a, reason: collision with root package name */
    private static String f59851a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f59852b = "";

    /* renamed from: c, reason: collision with root package name */
    private static Context f59853c = null;

    /* renamed from: d, reason: collision with root package name */
    private static String f59854d = "";

    public static Context a() {
        return f59853c;
    }

    public static String b() {
        if (!TextUtils.isEmpty(f59852b)) {
            return f59852b;
        }
        return "";
    }

    public static synchronized void c(Context context, String str) {
        synchronized (TencentVideo.class) {
            if (context == null) {
                com.qzone.video.TVK_SDK.mediaplayer.utils.b.c("SdkConfigHelper.java", 0, 20, "MediaPlayerMgr", "context is null", new Object[0]);
                return;
            }
            f59853c = context.getApplicationContext();
            f59854d = context.getPackageName();
            if (TextUtils.isEmpty(str)) {
                f59851a = "";
            } else {
                f59851a = str;
            }
            c.f59897g.execute(new Runnable() { // from class: com.qzone.video.TVK_SDK.mediaplayer.config.TencentVideo.1
                @Override // java.lang.Runnable
                public void run() {
                    TencentVideo.d(e.h(TencentVideo.a()), false);
                }
            });
        }
    }

    public static void d(String str, boolean z16) {
        String str2;
        if ((z16 || (str2 = f59852b) == null || TextUtils.isEmpty(str2)) && !TextUtils.isEmpty(str)) {
            f59852b = str;
        }
    }
}
