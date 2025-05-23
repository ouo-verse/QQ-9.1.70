package kw;

import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.e;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.confighandler.QAVFunCallConfig;
import com.tencent.mobileqq.utils.confighandler.QAVFunCallHandler;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static int a(AppRuntime appRuntime, String str, boolean z16, boolean z17) {
        return b(appRuntime, str, z16, z17, str);
    }

    public static int b(AppRuntime appRuntime, String str, boolean z16, boolean z17, String str2) {
        QAVFunCallHandler qAVFunCallHandler;
        int i3 = 0;
        if (VasToggle.isEnable(VasToggle.VAS_FUN_CALL_VIDEO_MODE, false) || z17) {
            if (z16) {
                i3 = VipFunCallUtil.getResIdByUin(appRuntime, str, 6, z16, str);
            } else {
                i3 = VipFunCallUtil.getResIdByUin(appRuntime, appRuntime.getAccount(), 6, z16, str2);
            }
        }
        if (i3 != 0) {
            if (e.k()) {
                QLog.w(QAVFunCallConfig.TAG, 1, "getFunVideoId, \u5df2\u7ecf\u6709\u9ed8\u8ba4\u914d\u7f6e, fcId[" + i3 + "]");
            }
            return i3;
        }
        BusinessCommonConfig businessCommonConfig = BusinessCommonConfig.getInstance(appRuntime);
        if (businessCommonConfig != null) {
            qAVFunCallHandler = (QAVFunCallHandler) businessCommonConfig.getConfigHandler(382);
        } else {
            qAVFunCallHandler = new QAVFunCallHandler(appRuntime.getAccount());
        }
        QAVFunCallConfig configDirect = qAVFunCallHandler.getConfigDirect();
        if (configDirect != null) {
            i3 = configDirect.getActivityFCId();
        }
        if (e.j() || i3 > 0) {
            QLog.w(QAVFunCallConfig.TAG, 1, "getFunVideoId, fcId[" + i3 + "]");
        }
        return i3;
    }

    public static void c(VideoAppInterface videoAppInterface, int i3) {
        Intent intent = new Intent();
        intent.setAction("tencent.video.v2q.AnnimateDownloadStart");
        intent.setPackage(videoAppInterface.getApp().getPackageName());
        intent.putExtra("callId", i3);
        videoAppInterface.getApp().sendBroadcast(intent);
    }
}
