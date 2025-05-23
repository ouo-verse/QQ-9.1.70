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
public class QimMusicDownloader {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class DownloadMusicTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        String f66781d;

        /* renamed from: e, reason: collision with root package name */
        String f66782e;

        /* renamed from: f, reason: collision with root package name */
        qs.e f66783f;

        public DownloadMusicTask(String str, String str2, qs.e eVar) {
            this.f66782e = str;
            this.f66781d = str2;
            this.f66783f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.d("MusicProviderView.Downloader", 2, "begin download " + this.f66781d + " " + this.f66782e);
            }
            if (Utils.B() && Utils.z() < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV) {
                qs.e eVar = this.f66783f;
                if (eVar != null) {
                    eVar.f(this.f66782e, false);
                }
                QLog.e("MusicProviderView.Downloader", 1, "download err no space");
                return;
            }
            File file = new File(SdkContext.getInstance().getResources().getAVFilterResource().getMusicResPath());
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(this.f66781d);
            long uptimeMillis = SystemClock.uptimeMillis();
            com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(this.f66782e, file2);
            gVar.Q = true;
            gVar.f313008f = 2;
            gVar.f313004c = this.f66781d;
            gVar.v(512);
            gVar.u(this.f66783f);
            int n3 = DownloaderFactory.n(gVar, null, null);
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            if (QLog.isColorLevel()) {
                QLog.i("MusicProviderView.Downloader", 2, "download cost " + uptimeMillis2 + " result " + n3 + " key " + gVar.f313004c);
            }
        }
    }

    public static void a(String str, String str2, qs.e eVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ThreadManagerV2.post(new DownloadMusicTask(str, str2, eVar), 5, null, false);
            return;
        }
        QLog.e("MusicProviderView.Downloader", 1, "invalid downlaod params " + str + ", " + str2);
    }
}
