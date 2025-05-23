package nw;

import android.app.Activity;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.u;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.ad;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.vas.h;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import yt.c;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static long f421445a;

    public static void a(Activity activity) {
        activity.sendBroadcast(new Intent("tencent.video.v2nearbyV.exit"));
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_NEARBY_VIDEO_MULTI_MSG, 2, "exitNearbyVideo");
        }
    }

    public static VideoAppInterface b() {
        return (VideoAppInterface) BaseApplicationImpl.getApplication().getRuntime();
    }

    public static boolean c() {
        VideoAppInterface b16 = b();
        if (b16 != null) {
            return b16.U();
        }
        return false;
    }

    public static void f(long j3) {
        QLog.w("AVPartUtil", 1, "stopRing, mLastPlayRingTime[" + f421445a + "->0]");
        f421445a = 0L;
        if (TraeHelper.I() != null) {
            TraeHelper.I().k0(j3);
        }
    }

    public static boolean d(boolean z16, Activity activity) {
        return !z16 && activity.checkSelfPermission(QQPermissionConstants.Permission.CAMERA) == 0 && (c.c(b().getCurrentAccountUin()) || u.c() || su.a.d());
    }

    public static void e(long j3, VideoAppInterface videoAppInterface, boolean z16, boolean z17, String str) {
        boolean k3 = AVUtil.k(videoAppInterface == null ? null : videoAppInterface.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
            QLog.w("AVPartUtil", 1, "playRing avCallBtnState[" + k3 + "], seq[" + j3 + "]");
        }
        if (!k3 || videoAppInterface == null) {
            return;
        }
        if (ad.m(videoAppInterface.getApplicationContext())) {
            if (!z16 && z17) {
                long currentTimeMillis = System.currentTimeMillis();
                QLog.w("AVPartUtil", 1, "playRing, mIsRingPlaying[" + f421445a + "->" + currentTimeMillis + "], seq[" + j3 + "]");
                if (f421445a != 0) {
                    return;
                }
                f421445a = currentTimeMillis;
                if (TraeHelper.I() != null) {
                    TraeHelper.I().k0(j3);
                }
                long resIdByUin = videoAppInterface.getApp() == null ? 0L : VipFunCallUtil.getResIdByUin(videoAppInterface, videoAppInterface.getAccount(), 3, false, str);
                if (resIdByUin == 0) {
                    TraeHelper.I().e0(j3, videoAppInterface, R.raw.f169424w, -1, null);
                } else {
                    String e16 = h.e(resIdByUin, 3);
                    if (new File(e16).exists()) {
                        TraeHelper.I().f0(j3, videoAppInterface, 0, e16, -1, null);
                        DataReport.T(null, "CliOper", "", "", "0X8005004", "0X8005004", 0, 0, "", resIdByUin + "", "", "");
                    } else {
                        TraeHelper.I().e0(j3, videoAppInterface, R.raw.f169424w, -1, null);
                        if (videoAppInterface.getApp() != null) {
                            Intent intent = new Intent();
                            intent.setAction("tencent.video.v2q.commingRingDownload");
                            intent.setPackage(videoAppInterface.getApp().getPackageName());
                            intent.putExtra("comming_ring_down_key", resIdByUin);
                            videoAppInterface.getApp().sendBroadcast(intent);
                        }
                    }
                }
            }
            TraeHelper.j0(videoAppInterface, false, j3);
            return;
        }
        if (ad.o(videoAppInterface.getApplicationContext())) {
            TraeHelper.j0(videoAppInterface, false, j3);
        }
    }
}
