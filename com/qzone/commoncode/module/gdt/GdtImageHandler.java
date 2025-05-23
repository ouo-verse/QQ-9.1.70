package com.qzone.commoncode.module.gdt;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GdtImageHandler {

    /* renamed from: a, reason: collision with root package name */
    private static GdtImageHandler f46183a;

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, String str2, boolean z16, long j3) {
        String str3;
        String str4;
        Uri parse = Uri.parse(str2);
        if (parse == null) {
            return null;
        }
        if ((!new String("http").equalsIgnoreCase(parse.getScheme()) && !new String("https").equalsIgnoreCase(parse.getScheme())) || !new String("canvas.gdt.qq.com").equalsIgnoreCase(parse.getHost())) {
            return null;
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().path("report.huatuo.qq.com/code.cgi").appendQueryParameter("appid", "20134").appendQueryParameter("platform", "android").appendQueryParameter("domain", "canvas.gdt.qq.com").appendQueryParameter("cgi", parse.getPath());
        if (z16) {
            str3 = "1";
        } else {
            str3 = "2";
        }
        Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("type", str3);
        if (z16) {
            str4 = "0";
        } else {
            str4 = "-1";
        }
        return parse.getScheme() + QzoneWebViewOfflinePlugin.STR_DEVIDER + appendQueryParameter2.appendQueryParameter("code", str4).appendQueryParameter("time", String.valueOf(j3)).appendQueryParameter("rate", "1").appendQueryParameter("app", "mqq").appendQueryParameter("uin", str).appendQueryParameter("expansion1", "0").appendQueryParameter("expansion2", "NONE").build().toString();
    }

    public static GdtImageHandler c() {
        if (f46183a == null) {
            synchronized (GdtImageHandler.class) {
                if (f46183a == null) {
                    f46183a = new GdtImageHandler();
                }
            }
        }
        return f46183a;
    }

    private static void e(final String str, final String str2, final boolean z16, final long j3) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.commoncode.module.gdt.GdtImageHandler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String b16 = GdtImageHandler.b(str, str2, z16, j3);
                    if (TextUtils.isEmpty(b16)) {
                        return;
                    }
                    to.e.d(BaseApplication.getContext(), b16);
                    com.qzone.proxy.feedcomponent.b.i("GdtImageHandler", "reportCanvasImageLoadTime:" + str2 + ", success:" + z16 + ", time:" + j3 + "\nreportUrl: " + b16);
                } catch (IOException unused) {
                }
            }
        });
    }

    public void d(String str, String str2, boolean z16, long j3) {
        e(str, str2, z16, j3);
    }
}
