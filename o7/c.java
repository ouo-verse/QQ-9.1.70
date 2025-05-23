package o7;

import com.qzone.common.account.LoginData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {
    public static String a() {
        return LocalMultiProcConfig.getString4Uin("FirstVideoFeedCoverPath", "", LoginData.getInstance().getUin());
    }

    public static boolean b() {
        long uin = LoginData.getInstance().getUin();
        boolean z16 = LocalMultiProcConfig.getInt4Uin(LocalMultiProcConfig.QZONE_LOCAL_PHOTO_SCAN_ENABLED, 0, uin) == 1;
        QZLog.i("LocalPhotoScanUtil", "getLocalPhotoScanAuthorizeSwitch uin=" + uin + ",switchState=" + z16);
        return z16;
    }

    public static void c(long j3) {
        LocalMultiProcConfig.putLong4Uin("GuideUploadAlbumLastUploadTime", j3, LoginData.getInstance().getUin());
    }

    public static void d(String str) {
        LocalMultiProcConfig.putString4Uin("FirstVideoFeedCoverPath", str, LoginData.getInstance().getUin());
    }

    public static void e(boolean z16) {
        QLog.i("LocalPhotoScanUtil", 1, "setHasShowGuideUploadAlbumDialog is " + z16);
        LocalMultiProcConfig.putBoolean4Uin("IsShowGuideUploadAlbumDialog", z16, LoginData.getInstance().getUin());
    }

    public static void f(boolean z16) {
        LocalMultiProcConfig.putInt4Uin(LocalMultiProcConfig.QZONE_LOCAL_PHOTO_SCAN_ENABLED, z16 ? 1 : 0, LoginData.getInstance().getUin());
    }
}
