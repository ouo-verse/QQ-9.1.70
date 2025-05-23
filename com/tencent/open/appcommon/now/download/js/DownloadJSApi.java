package com.tencent.open.appcommon.now.download.js;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.f;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.e;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DownloadJSApi {
    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Activity activity, final Bundle bundle, final String str, final ApkUpdateDetail apkUpdateDetail, final int i3) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.appcommon.now.download.js.DownloadJSApi.2

            /* compiled from: P */
            /* renamed from: com.tencent.open.appcommon.now.download.js.DownloadJSApi$2$a */
            /* loaded from: classes22.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    bundle.putBoolean(e.f341510s, false);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    DownloadJSApi.d(activity, bundle, str, apkUpdateDetail, i3);
                    dialogInterface.dismiss();
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.open.appcommon.now.download.js.DownloadJSApi$2$b */
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
                    String string = bundle.getString(e.f341493b);
                    String string2 = bundle.getString(e.f341501j);
                    String string3 = bundle.getString(e.f341497f);
                    String string4 = bundle.getString(e.f341500i);
                    DownloadManager.C().K(10, new DownloadInfo(string, string2.trim(), string3, bundle.getString(e.f341503l), string4, null, str, bundle.getBoolean(e.f341516y, true)));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = new a();
                b bVar = new b();
                f.e("DownloadJSApi", "dialog create and show");
                AlertDialog create = new AlertDialog.Builder(activity).setMessage(activity.getString(R.string.af9)).setPositiveButton(R.string.af7, bVar).setNegativeButton(R.string.af8, aVar).create();
                create.setCanceledOnTouchOutside(false);
                if (!activity.isFinishing()) {
                    create.show();
                }
            }
        });
    }

    public static int c(Bundle bundle, String str, ApkUpdateDetail apkUpdateDetail) {
        int i3;
        int i16;
        f.h("DownloadJSApi", "doDownloadActionBySDK pParmas =" + bundle);
        String string = bundle.getString(e.f341493b);
        String string2 = bundle.getString(e.f341501j);
        String string3 = bundle.getString(e.f341497f);
        int i17 = bundle.getInt(e.f341502k);
        String string4 = bundle.getString(e.f341500i);
        String string5 = bundle.getString(e.f341503l);
        bundle.getString(e.f341504m);
        String string6 = bundle.getString(e.F);
        int i18 = bundle.getInt(e.J);
        String string7 = bundle.getString(e.K);
        boolean z16 = bundle.getBoolean(e.f341506o);
        boolean z17 = bundle.getBoolean(e.f341516y, true);
        boolean z18 = bundle.getBoolean(e.f341499h, true);
        boolean z19 = bundle.getBoolean(e.f341515x);
        int i19 = bundle.getInt(e.E, 0);
        boolean z26 = bundle.getBoolean(e.L, false);
        if (i17 != 2) {
            if (i17 != 3) {
                if (i17 != 5) {
                    if (i17 != 10) {
                        if (i17 != 12) {
                            if (i17 == 13) {
                                DownloadInfo downloadInfo = new DownloadInfo(string, string2.trim(), string3, string5, string4, null, str, z17);
                                downloadInfo.S = i17;
                                downloadInfo.I = bundle.getInt(e.f341496e);
                                downloadInfo.U = z19;
                                com.tencent.open.appcommon.now.download.a.e().h(downloadInfo);
                            }
                            return 0;
                        }
                        DownloadInfo downloadInfo2 = new DownloadInfo(string, string2.trim(), string3, string5, string4, null, str, z17);
                        downloadInfo2.S = i17;
                        downloadInfo2.T = z18;
                        downloadInfo2.U = z19;
                        downloadInfo2.K = 0;
                        int i26 = bundle.getInt(e.f341496e);
                        downloadInfo2.I = i26;
                        downloadInfo2.f341181c0 = string7;
                        if (apkUpdateDetail != null && i26 != (i16 = apkUpdateDetail.versioncode) && i16 != 0) {
                            downloadInfo2.I = i16;
                        }
                        boolean h16 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).h("Common_QQ_Patch_Switch");
                        if (!z16) {
                            com.tencent.open.appcommon.now.download.a.e().j(downloadInfo2);
                        } else if (h16) {
                            com.tencent.open.appcommon.now.download.a.e().k(downloadInfo2, apkUpdateDetail);
                        } else {
                            com.tencent.open.appcommon.now.download.a.e().j(downloadInfo2);
                        }
                        f.a("DownloadJSApi", "doDownloadAction action == Downloader.ACTION_UPDATE " + z16);
                    } else {
                        com.tencent.open.appcommon.now.download.a.e().c(string);
                    }
                } else if (z17) {
                    com.tencent.open.business.base.e.h("305", string4, string, string7);
                    com.tencent.open.appcommon.now.download.a.e().f(string, string3);
                }
            } else {
                com.tencent.open.appcommon.now.download.a.e().g(string);
            }
            return 0;
        }
        DownloadInfo downloadInfo3 = new DownloadInfo(string, string2.trim(), string3, string5, string4, null, str, z17);
        downloadInfo3.S = i17;
        if (z17) {
            downloadInfo3.T = z18;
            downloadInfo3.U = z19;
            i3 = 0;
        } else {
            i3 = 0;
            downloadInfo3.T = false;
            downloadInfo3.U = true;
            downloadInfo3.E = 2;
        }
        downloadInfo3.W = i19;
        downloadInfo3.Y = string6;
        downloadInfo3.Z = i18;
        downloadInfo3.f341181c0 = string7;
        downloadInfo3.f341183d0 = z26;
        downloadInfo3.K = i3;
        downloadInfo3.I = bundle.getInt(e.f341496e);
        f.a("DownloadJSApi", "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
        com.tencent.open.appcommon.now.download.a.e().j(downloadInfo3);
        return i3;
    }

    public static void d(final Activity activity, final Bundle bundle, final String str, final ApkUpdateDetail apkUpdateDetail, final int i3) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appcommon.now.download.js.DownloadJSApi.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                boolean z17;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("doDownloadAction pParams=");
                sb5.append(bundle);
                sb5.append(" source=");
                sb5.append(str);
                sb5.append(" myAppConfig=");
                sb5.append(i3);
                sb5.append(" ac==null is");
                boolean z18 = false;
                if (activity == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                f.h("DownloadJSApi", sb5.toString());
                Bundle bundle2 = bundle;
                if (bundle2 == null) {
                    f.c("DownloadJSApi", "doDownloadAction pParams == null return");
                    return;
                }
                String string = bundle2.getString(e.f341493b);
                bundle.putString(e.f341511t, str);
                bundle.putInt(e.G, 1);
                String string2 = bundle.getString(e.D);
                String string3 = bundle.getString(e.f341500i);
                if (TextUtils.isEmpty(string2) || string2.equals("0")) {
                    bundle.putString(e.D, "");
                }
                DownloadInfo w3 = DownloadManager.C().w(string);
                if (w3 != null && !TextUtils.isEmpty(string3)) {
                    w3.C = string3;
                }
                ApkUpdateDetail apkUpdateDetail2 = apkUpdateDetail;
                if (apkUpdateDetail2 != null && apkUpdateDetail2.updatemethod == 2 && TextUtils.isEmpty(bundle.getString(e.f341501j)) && !TextUtils.isEmpty(apkUpdateDetail.url)) {
                    bundle.putString(e.f341501j, apkUpdateDetail.url);
                }
                boolean a16 = com.tencent.open.base.a.a(com.tencent.open.adapter.a.f().e());
                boolean k3 = com.tencent.open.base.a.k(com.tencent.open.adapter.a.f().e());
                if (w3 != null && w3.f() != 1) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (activity == null) {
                    z18 = true;
                }
                f.h("DownloadJSApi", "check wifi dialog isWifiActive=" + k3 + " isFirstDownload=" + z17 + " acIsNull=" + z18);
                if (a16 && !z18 && !k3 && z17 && bundle.getBoolean(e.f341510s)) {
                    DownloadJSApi.b(activity, bundle, str, apkUpdateDetail, i3);
                } else {
                    DownloadJSApi.c(bundle, str, apkUpdateDetail);
                }
            }
        });
    }
}
