package com.tencent.open.appstore.notice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.appcommon.Common;
import com.tencent.open.appstore.dl.DownloadInfoReport;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.common.NoticeParam;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;

/* compiled from: P */
/* loaded from: classes22.dex */
public class NoticeReceiver extends BroadcastReceiver {
    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        try {
            Object systemService = context.getSystemService("statusbar");
            systemService.getClass().getMethod("collapsePanels", new Class[0]).invoke(systemService, new Object[0]);
        } catch (Exception e16) {
            com.tencent.open.base.f.d("NoticeReceiver", ">>throws exception:", e16);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("processName");
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase(Common.m())) {
                final String action = intent.getAction();
                final NoticeParam noticeParam = (NoticeParam) intent.getParcelableExtra("noticeParam");
                if (noticeParam == null || noticeParam.I == 1) {
                    return;
                }
                final String replace = stringExtra.replace(":", ".");
                if ((com.tencent.open.downloadnew.common.c.f341485e + "." + replace).equals(action)) {
                    com.tencent.open.business.base.a.w(context, noticeParam.f341448h);
                    return;
                }
                com.tencent.open.base.f.e("NoticeReceiver", "processName :" + stringExtra + " | formatStr:" + replace);
                String str = noticeParam.f341448h;
                final String str2 = noticeParam.f341449i;
                if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                    return;
                }
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.appstore.notice.NoticeReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadInfo S = DownloadManagerV2.V().S(str2);
                        if (S == null) {
                            com.tencent.open.base.f.e("NoticeReceiver", "downloadInfo is null.");
                            return;
                        }
                        if ((com.tencent.open.downloadnew.common.c.f341482b + "." + replace).equals(action)) {
                            DownloadManagerV2.V().o0(str2);
                            DownloadInfoReport.f(5, str2, 100, S, noticeParam.J);
                            return;
                        }
                        if ((com.tencent.open.downloadnew.common.c.f341481a + "." + replace).equals(action)) {
                            DownloadManagerV2.V().z0(S);
                            DownloadInfoReport.f(4, str2, 100, S, noticeParam.J);
                            return;
                        }
                        if ((com.tencent.open.downloadnew.common.c.f341483c + "." + replace).equals(action)) {
                            DownloadManagerV2.V().z0(S);
                            DownloadInfoReport.f(4, str2, 100, S, noticeParam.J);
                            return;
                        }
                        if ((com.tencent.open.downloadnew.common.c.f341484d + "." + replace).equals(action)) {
                            com.tencent.open.business.base.a.r(context, DownloadManagerV2.V().M(S.f341182d), S.M, S.e(LaunchParam.KEY_REF_ID), S.e(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE));
                            S.f341199o0 = BaseApplicationImpl.getApplication().getQQProcessName();
                            DownloadManagerV2.V().v(S, true);
                            NoticeReceiver.this.b(context);
                            AppCenterReporter.u(S);
                            DownloadInfoReport.f(6, str2, 100, S, noticeParam.J);
                        }
                    }
                });
            }
        }
    }
}
