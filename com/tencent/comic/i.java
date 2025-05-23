package com.tencent.comic;

import android.os.SystemClock;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static long f99376a;

    public static void b(AppRuntime appRuntime) {
        if (QLog.isColorLevel()) {
            QLog.w("VipComicSoHelper", 2, "download comic qgplayer, the apk is for cup 64, but not supported for now");
        }
    }

    public static void c(AppRuntime appRuntime, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("VipComicSoHelper", 2, "onSoDownloadCompleted");
        }
        if (VasSoUtils.unCompressSo(a() + "libQGamePlayer.zip", a(), "libqgplayer_841.so")) {
            if (QLog.isColorLevel()) {
                QLog.d("VipComicSoHelper", 2, "comic player unCompressSo success");
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("VipComicSoHelper", 2, "comic player unCompressSo failure");
        }
        try {
            DcReportUtil.c(appRuntime, "sendtdbank|b_sng_qqvip_qqcomic|soDownload", "2|" + (SystemClock.elapsedRealtime() - f99376a) + "|" + i3, true);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static String a() {
        QQVasUpdateBusiness<?> newBusiness = VasUpdateConstants.getNewBusiness(1004L);
        if (newBusiness != null) {
            return newBusiness.getSavePath(VasUpdateConstants.SCID_COMIC_PLAYER_SO) + "/";
        }
        return new File(com.tencent.comic.utils.a.b().getFilesDir(), "comic_so").getAbsolutePath() + File.separator;
    }
}
