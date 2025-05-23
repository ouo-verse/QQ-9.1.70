package cooperation.vip.ad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes28.dex */
public class y extends a {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [cooperation.vip.ad.UserLeadingDialogModel[], java.io.Serializable] */
    public y(TianShuAccess.AdItem adItem, QQAppInterface qQAppInterface, Activity activity) {
        if (qQAppInterface != null && activity != null) {
            this.dialogModels = ai.a(adItem.argList.get());
            this.intervalTime = ai.b(adItem.argList.get());
            a.adid = adItem.iAdId.get();
            a.traceInfo = adItem.traceinfo.get();
            boolean c16 = ai.c(adItem.argList.get());
            QLog.i("UserLeadingDialogHelper", 1, "UserLeadingDialogHelper, pageSize=" + this.dialogModels.length + "intervalTime=" + this.intervalTime + "adid=" + a.adid + "needHideTitleArea=" + c16);
            initHelper();
            this.intent = new Intent(activity, (Class<?>) UserLeadingActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("dialogModels", this.dialogModels);
            bundle.putInt(WinkDaTongReportConstant.ElementParamKey.ADID, a.adid);
            bundle.putString(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, a.traceInfo);
            bundle.putLong("startTime", new Date().getTime());
            bundle.putString("nickName", com.tencent.mobileqq.utils.ac.y(qQAppInterface, qQAppInterface.getCurrentAccountUin()));
            bundle.putInt("intervalTime", this.intervalTime);
            bundle.putBoolean("hideTitleArea", c16);
            this.intent.addFlags(603979776);
            this.intent.setFlags(65536);
            this.intent.putExtras(bundle);
            return;
        }
        QLog.e("UserLeadingDialogHelper", 1, "UserLeadingDialogHelper  param error   | app = " + qQAppInterface + " | app = " + qQAppInterface);
    }

    public void showLayer(Activity activity) {
        o.h(a.adid);
        long j3 = o.j(a.adid);
        if (com.tencent.mobileqq.splashad.l.l()) {
            QLog.i("UserLeadingDialogHelper", 1, "showLayer, hasBizSplash, so return");
            a.tianshuReportbyId(213);
        } else if (activity != null && this.intent != null) {
            fillTechInfoToIntent(a.adid, j3);
            activity.startActivity(this.intent);
            o.d(a.adid);
            o.c(a.adid);
        }
    }
}
