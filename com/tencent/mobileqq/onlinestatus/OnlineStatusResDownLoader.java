package com.tencent.mobileqq.onlinestatus;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnlineStatusResDownLoader {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.onlinestatus.utils.ak f255357a = new com.tencent.mobileqq.onlinestatus.utils.ak();

    public static String c(String str, String str2, long j3) {
        return com.tencent.mobileqq.onlinestatus.utils.ak.i(str, str2) + "/" + j3 + "/";
    }

    public static String[] d(long j3) {
        String str = j3 + "/";
        return new String[]{str + LottieLoader.FILE_DATA_JSON, str + LottieLoader.FILE_IMAGES};
    }

    public void b(final AppInterface appInterface) {
        com.tencent.mobileqq.config.business.ai a16 = com.tencent.mobileqq.config.business.ak.f202506a.a();
        if (a16 == null) {
            QLog.d("OnlineStatusResDownLoader", 2, "[OnlineStatus] downloadRes OnlineStatusBean is null");
            return;
        }
        final Set<au> j3 = a16.j();
        if (j3 != null && !j3.isEmpty()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.OnlineStatusResDownLoader.1
                @Override // java.lang.Runnable
                public void run() {
                    for (au auVar : j3) {
                        if (!TextUtils.isEmpty(auVar.f255498k) && !TextUtils.isEmpty(auVar.f255499l)) {
                            String[] d16 = OnlineStatusResDownLoader.d(auVar.f255489b);
                            com.tencent.mobileqq.onlinestatus.utils.ak unused = OnlineStatusResDownLoader.this.f255357a;
                            if (com.tencent.mobileqq.onlinestatus.utils.ak.k(auVar.f255498k, auVar.f255499l, d16)) {
                                QLog.d("OnlineStatusResDownLoader", 2, "[OnlineStatus] downloadRes itemRes is ready item.id=", Long.valueOf(auVar.f255489b));
                            } else {
                                QLog.d("OnlineStatusResDownLoader", 2, "[OnlineStatus] downloadRes itemRes need download item.id=", Long.valueOf(auVar.f255489b));
                                OnlineStatusResDownLoader.this.f255357a.d(appInterface, 10096, PreDownloadConstants.DEPARTMENT_PRD, auVar.f255498k, auVar.f255499l, d16, null);
                            }
                        } else {
                            QLog.d("OnlineStatusResDownLoader", 2, "[OnlineStatus] downloadRes paramError item.id=", Long.valueOf(auVar.f255489b), " item.resUrl=", auVar.f255498k, " item.md5=", auVar.f255499l);
                        }
                    }
                }
            }, 16, null, true);
        } else {
            QLog.d("OnlineStatusResDownLoader", 2, "[OnlineStatus] downloadRes OnlineStatusBean.moodList is empty");
        }
    }

    public void e() {
        QLog.d("OnlineStatusResDownLoader", 2, "[OnlineStatus] onDestroy call destroy zipDownloader");
        this.f255357a.m();
    }
}
