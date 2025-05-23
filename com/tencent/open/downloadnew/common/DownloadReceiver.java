package com.tencent.open.downloadnew.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.appcommon.Common;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.appstore.dl.DownloadInfoReport;
import com.tencent.open.base.f;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DownloadReceiver extends BroadcastReceiver {
    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        try {
            Object systemService = context.getSystemService("statusbar");
            systemService.getClass().getMethod("collapsePanels", new Class[0]).invoke(systemService, new Object[0]);
        } catch (Exception e16) {
            f.d("DownloadReceiver", ">>throws exception:", e16);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        String str;
        if (intent != null) {
            try {
                str = intent.getStringExtra("processName");
            } catch (Exception unused) {
                str = "";
            }
            if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(Common.m())) {
                final String action = intent.getAction();
                final NoticeParam noticeParam = (NoticeParam) intent.getParcelableExtra("noticeParam");
                if (noticeParam == null) {
                    return;
                }
                if (noticeParam.I == 1) {
                    return;
                }
                final String replace = str.replace(":", ".");
                if ((c.f341485e + "." + replace).equals(action)) {
                    com.tencent.open.business.base.a.w(context, noticeParam.f341448h);
                    return;
                }
                f.e("vivi", "processName :" + str + " | formatStr:" + replace);
                final String str2 = noticeParam.f341445d;
                final String str3 = noticeParam.f341448h;
                if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                    return;
                }
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                StringBuilder sb5 = new StringBuilder();
                for (int i3 = 1; i3 < stackTrace.length; i3++) {
                    sb5.append(stackTrace[i3].toString());
                }
                if (!TextUtils.isEmpty(str2)) {
                    DownloadInfoReport.f340780a.put(str2, sb5.toString());
                } else if (!TextUtils.isEmpty(noticeParam.f341449i)) {
                    DownloadInfoReport.f340780a.put(noticeParam.f341449i, sb5.toString());
                }
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.downloadnew.common.DownloadReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str4;
                        String str5;
                        String str6;
                        String str7;
                        Bundle extras;
                        Bundle extras2;
                        boolean z16;
                        DownloadInfo w3 = DownloadManager.C().w(str2);
                        if (w3 == null) {
                            w3 = DownloadManager.C().x(str3);
                        }
                        if (w3 == null) {
                            String str8 = noticeParam.f341448h;
                            if (str8 != null && !str8.trim().equals("")) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            String str9 = str2;
                            NoticeParam noticeParam2 = noticeParam;
                            w3 = new DownloadInfo(str9, noticeParam2.f341449i, noticeParam2.f341448h, noticeParam2.f341446e, noticeParam2.G, noticeParam2.F, "biz_src_yyb", z16);
                        } else {
                            if (TextUtils.isEmpty(w3.f341186f)) {
                                str4 = noticeParam.f341449i;
                            } else {
                                str4 = w3.f341186f;
                            }
                            w3.f341186f = str4;
                            if (TextUtils.isEmpty(w3.f341189h)) {
                                str5 = noticeParam.f341448h;
                            } else {
                                str5 = w3.f341189h;
                            }
                            w3.f341189h = str5;
                            if (TextUtils.isEmpty(w3.C)) {
                                str6 = noticeParam.G;
                            } else {
                                str6 = w3.C;
                            }
                            w3.C = str6;
                            if (TextUtils.isEmpty(w3.f341191i)) {
                                str7 = noticeParam.f341446e;
                            } else {
                                str7 = w3.f341191i;
                            }
                            w3.f341191i = str7;
                        }
                        w3.N = noticeParam.H;
                        if ((c.f341482b + "." + replace).equals(action)) {
                            DownloadInfo w16 = DownloadManager.C().w(str2);
                            if (w16 != null && (w16.f() == 2 || w16.f() == 20)) {
                                w3.k(3);
                                DownloadManager.C().K(3, w3);
                            }
                            DownloadManager.C().Q(w3.f341184e);
                            return;
                        }
                        if ((c.f341481a + "." + replace).equals(action)) {
                            DownloadManager.C().d0(w3);
                            return;
                        }
                        if ((c.f341483c + "." + replace).equals(action)) {
                            DownloadManager.C().d0(w3);
                            return;
                        }
                        if ((c.f341484d + "." + replace).equals(action)) {
                            com.tencent.open.business.base.a.r(context, DownloadManager.C().v(str2), DownloadManager.C().z(str2), w3.e(LaunchParam.KEY_REF_ID), w3.e(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE));
                            np3.a.g().i(100, w3);
                            DownloadReceiver.this.b(context);
                            return;
                        }
                        if ((c.f341486f + "." + replace).equals(action)) {
                            if (MyAppApi.z().n() && w3.J == 1) {
                                Intent intent2 = noticeParam.F;
                                if (intent2 == null) {
                                    extras2 = new Bundle();
                                } else {
                                    extras2 = intent2.getExtras();
                                }
                                if (extras2 == null) {
                                    extras2 = new Bundle();
                                }
                                extras2.putString(com.tencent.open.downloadnew.e.f341493b, w3.f341184e);
                                extras2.putString(com.tencent.open.downloadnew.e.f341494c, w3.G);
                                extras2.putString(com.tencent.open.downloadnew.e.f341495d, w3.H);
                                extras2.putString(com.tencent.open.downloadnew.e.f341497f, w3.f341189h);
                                extras2.putInt(com.tencent.open.downloadnew.e.f341496e, w3.I);
                                MyAppApi.z().n0(context.getApplicationContext(), extras2, true, true);
                                return;
                            }
                            Intent intent3 = new Intent();
                            Intent intent4 = noticeParam.F;
                            if (intent4 == null) {
                                extras = new Bundle();
                            } else {
                                extras = intent4.getExtras();
                            }
                            if (extras == null) {
                                extras = new Bundle();
                            }
                            intent3.putExtras(extras);
                            intent3.setClass(com.tencent.open.adapter.a.f().e(), QZoneAppListActivity.class);
                            intent3.putExtra("goto_type", 2);
                            intent3.addFlags(872415232);
                            context.startActivity(intent3);
                        }
                    }
                });
            }
        }
    }
}
