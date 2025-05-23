package com.tencent.luggage.wxa.qq;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.luggage.wxa.ar.b1;
import com.tencent.luggage.wxa.ar.p0;
import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.xweb.WebView;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class o {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f139017a;

        public a(String str) {
            this.f139017a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                LockMethodProxy.sleep(5000L);
            } catch (InterruptedException e16) {
                x0.a("XWebSavePageHelper", "savePage, sleep error:", e16);
            }
            b1.a(new File[]{new File(this.f139017a)}, this.f139017a + ".zip");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f139018a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f139019b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f139020c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f139021d;

        public c(WebView webView, String str, String str2, String str3) {
            this.f139018a = webView;
            this.f139019b = str;
            this.f139020c = str2;
            this.f139021d = str3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            o.b(this.f139018a, this.f139019b, this.f139020c, this.f139021d);
        }
    }

    public static void b(WebView webView, String str, String str2, String str3) {
        b1.b(str, str2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str4 = File.separator;
        sb5.append(str4);
        sb5.append(str3.substring(0, str3.lastIndexOf(".zip")));
        sb5.append(str4);
        sb5.append("main.html");
        String sb6 = sb5.toString();
        x0.d("XWebSavePageHelper", "loadSavedPage, htmlPath:" + sb6);
        webView.loadUrl("file://" + sb6);
    }

    public static boolean a(Context context, WebView webView) {
        File externalCacheDir = context.getExternalCacheDir();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(externalCacheDir.getAbsolutePath());
        String str = File.separator;
        sb5.append(str);
        sb5.append("xweb_dump");
        sb5.append(str);
        String sb6 = sb5.toString();
        File file = new File(sb6);
        if (!file.exists()) {
            file.mkdir();
        }
        Date date = new Date();
        String str2 = sb6 + new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss").format(date);
        File file2 = new File(str2);
        if (!file2.exists()) {
            file2.mkdir();
        }
        String str3 = str2 + str + "main.html";
        String str4 = str2 + str + "resource";
        if (webView != null) {
            boolean savePage = webView.savePage(str3, str4, 1);
            x0.d("XWebSavePageHelper", "savePage, result:" + savePage + ", mainFile:" + str3);
            if (!savePage) {
                return false;
            }
        }
        com.tencent.luggage.wxa.lq.d.a(new a(str2));
        return true;
    }

    public static boolean a(Context context, WebView webView, boolean z16) {
        File externalCacheDir = context.getExternalCacheDir();
        File[] listFiles = externalCacheDir.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            String str = externalCacheDir.getAbsolutePath() + File.separator + "xweb_dump";
            try {
                File[] listFiles2 = new File(str).listFiles();
                if (listFiles2 != null && listFiles2.length != 0) {
                    for (int i3 = 0; i3 < listFiles2.length; i3++) {
                        if (listFiles2[i3].getName().endsWith(".zip")) {
                            String absolutePath = listFiles2[i3].getAbsolutePath();
                            String name = listFiles2[i3].getName();
                            new AlertDialog.Builder(context).setTitle("\u63d0\u793a").setMessage("\u786e\u5b9a\u52a0\u8f7d:" + name + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER).setPositiveButton("\u786e\u5b9a", new c(webView, str, absolutePath, name)).setNegativeButton("\u53d6\u6d88", new b()).show();
                            return true;
                        }
                    }
                    p0.a(context, "xweb_dump\u76ee\u5f55\u4e0b\u6ca1\u6709.zip\u6587\u4ef6", z16);
                    return false;
                }
                p0.a(context, "xweb_dump\u76ee\u5f55\u4e0b\u6ca1\u6709.zip\u6587\u4ef6", z16);
                return false;
            } catch (Exception unused) {
                p0.a(context, "\u6ca1\u6709\u627e\u5230xweb_dump\u76ee\u5f55", z16);
                return false;
            }
        }
        p0.a(context, "\u8bf7\u786e\u8ba4\u5e94\u7528\u6743\u9650\uff0c\u518d\u786e\u8ba4\u6307\u5b9a\u76ee\u5f55\u4e0b\u5b58\u5728\u6587\u4ef6", z16);
        return false;
    }

    public static boolean a(Context context, boolean z16) {
        File externalCacheDir = context.getExternalCacheDir();
        File[] listFiles = externalCacheDir.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            String str = externalCacheDir.getAbsolutePath() + File.separator + "xweb_dump";
            w.a(str);
            x0.d("XWebSavePageHelper", "clearSavedPage, delete dir:" + str);
            return true;
        }
        p0.a(context, "\u8bf7\u786e\u8ba4\u5e94\u7528\u6743\u9650\uff0c\u518d\u786e\u8ba4\u6307\u5b9a\u76ee\u5f55\u4e0b\u5b58\u5728\u6587\u4ef6", z16);
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
