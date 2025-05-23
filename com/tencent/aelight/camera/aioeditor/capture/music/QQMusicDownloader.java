package com.tencent.aelight.camera.aioeditor.capture.music;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQMusicDownloader {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class DownloadMusicTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        com.tencent.mobileqq.vip.g f66775d;

        /* renamed from: e, reason: collision with root package name */
        qs.e f66776e;

        public DownloadMusicTask(com.tencent.mobileqq.vip.g gVar, qs.e eVar) {
            this.f66775d = gVar;
            this.f66776e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.d("QQMusicDownloader", 2, "begin download " + this.f66775d.f313004c);
            }
            if (Utils.B() && Utils.z() < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV) {
                qs.e eVar = this.f66776e;
                if (eVar != null) {
                    eVar.f(this.f66775d.f313004c, false);
                }
                QLog.e("QQMusicDownloader", 1, "download err no space");
                return;
            }
            String q16 = com.tencent.biz.qqstory.utils.d.q();
            if (SdkContext.getInstance() != null && SdkContext.getInstance().getResources() != null && SdkContext.getInstance().getResources().getAVFilterResource() != null && SdkContext.getInstance().getResources().getAVFilterResource().getMusicResPath() != null) {
                q16 = SdkContext.getInstance().getResources().getAVFilterResource().getMusicResPath();
            }
            File file = new File(q16);
            if (!file.exists()) {
                file.mkdirs();
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            int n3 = DownloaderFactory.n(this.f66775d, null, null);
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            if (QLog.isColorLevel()) {
                QLog.i("QQMusicDownloader", 2, "download cost " + uptimeMillis2 + " result " + n3 + " key " + this.f66775d.f313004c);
            }
        }
    }

    public static void a(com.tencent.mobileqq.vip.g gVar) {
        if (QLog.isColorLevel()) {
            QLog.i("QQMusicDownloader", 2, "cancel task " + gVar.f313004c);
        }
        gVar.c(true);
    }

    public static com.tencent.mobileqq.vip.g b(String str, String str2, qs.e eVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(str, new File(str2));
            gVar.Q = true;
            gVar.f313008f = 2;
            gVar.f313004c = str2;
            gVar.v(512);
            gVar.u(eVar);
            return gVar;
        }
        QLog.e("QQMusicDownloader", 1, "invalid downlaod params " + str + ", " + str2);
        return null;
    }

    public static void c(com.tencent.mobileqq.vip.g gVar, qs.e eVar) {
        ThreadManagerV2.post(new DownloadMusicTask(gVar, eVar), 5, null, false);
    }
}
