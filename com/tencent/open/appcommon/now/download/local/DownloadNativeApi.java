package com.tencent.open.appcommon.now.download.local;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.intervideo.now.api.INowUtil;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.f;
import com.tencent.open.downloadnew.DownloadInfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DownloadNativeApi {

    /* renamed from: b, reason: collision with root package name */
    private static DownloadNativeApi f340733b;

    /* renamed from: a, reason: collision with root package name */
    private DownloadCallbackNativeImpl f340734a = new DownloadCallbackNativeImpl();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a(com.tencent.open.appcommon.now.download.local.a aVar);

        void b(com.tencent.open.appcommon.now.download.local.a aVar);

        void c(com.tencent.open.appcommon.now.download.local.a aVar);

        void d(com.tencent.open.appcommon.now.download.local.a aVar);
    }

    private DownloadInfo b(b bVar) {
        DownloadInfo downloadInfo = new DownloadInfo(bVar.f340748a, bVar.f340749b);
        downloadInfo.f341186f = bVar.f340751d;
        downloadInfo.I = bVar.f340752e;
        downloadInfo.U = bVar.f340756i;
        downloadInfo.T = bVar.f340757j;
        downloadInfo.f341191i = bVar.f340750c;
        downloadInfo.E = bVar.f340760m;
        downloadInfo.J = bVar.f340759l;
        downloadInfo.K = 0;
        downloadInfo.X = true;
        return downloadInfo;
    }

    public static DownloadNativeApi c() {
        if (f340733b == null) {
            f340733b = new DownloadNativeApi();
        }
        return f340733b;
    }

    private boolean d() {
        return "com.tencent.mobileqq:tool".equals(Common.m());
    }

    public int e(String str) {
        if (!d()) {
            return 401;
        }
        this.f340734a.f(str);
        com.tencent.open.appcommon.now.download.a.e().g(str);
        return 200;
    }

    public void f(final Activity activity, final DownloadInfo downloadInfo, final b bVar) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1

            /* compiled from: P */
            /* renamed from: com.tencent.open.appcommon.now.download.local.DownloadNativeApi$1$a */
            /* loaded from: classes22.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    com.tencent.open.appcommon.now.download.a.e().j(downloadInfo);
                    DownloadNativeApi.this.f340734a.e(bVar);
                    dialogInterface.dismiss();
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.open.appcommon.now.download.local.DownloadNativeApi$1$b */
            /* loaded from: classes22.dex */
            class b implements DialogInterface.OnClickListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    try {
                        dialogInterface.dismiss();
                    } catch (Exception unused) {
                    }
                    DownloadNativeApi.this.f340734a.onDownloadCancel(downloadInfo);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = new a();
                b bVar2 = new b();
                f.e("DownloadNativeApi", "dialog create and show");
                AlertDialog create = new AlertDialog.Builder(activity).setMessage(activity.getString(R.string.af9)).setPositiveButton(R.string.af7, bVar2).setNegativeButton(R.string.af8, aVar).create();
                create.setCanceledOnTouchOutside(false);
                if (!activity.isFinishing()) {
                    create.show();
                }
            }
        });
    }

    public int g(Activity activity, b bVar) {
        if (!d()) {
            return 401;
        }
        if (bVar == null) {
            return 400;
        }
        if (bVar.f340753f && !INowUtil.Now_PKG_NAME.equals(bVar.f340750c)) {
            return 402;
        }
        DownloadInfo b16 = b(bVar);
        b16.S = 2;
        b16.X = true;
        if (HttpUtil.getNetWorkType() != 1 && activity != null && bVar.f340758k) {
            f(activity, b16, bVar);
            return 200;
        }
        com.tencent.open.appcommon.now.download.a.e().j(b16);
        this.f340734a.e(bVar);
        return 200;
    }
}
