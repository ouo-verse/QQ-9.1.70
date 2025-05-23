package cooperation.vip.ad;

import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {
    public static final int MSG_CLOSE_ACTIVITY = 1;
    public static final int MSG_CUSTOM_CLICK = 2;
    public static final int MSG_CUSTOM_JUMP = 3;
    public static final int MSG_CUSTOM_REPORT = 6;
    public static final int MSG_HIPPY_FIRST_SCREEN_TECH_REPORT = 7;
    public static final int MSG_VIDEO_PREPARED = 5;
    private static final String TAG = "BaseDialogHelper";
    protected static int adid;
    protected static String traceInfo;
    protected UserLeadingDialogModel[] dialogModels;
    protected Intent intent;
    protected int intervalTime = -1;

    public static void closeLayer() {
        QLog.d(TAG, 1, "closeLayer....");
        SimpleEventBus.getInstance().dispatchEvent(new VideoMessage(1, ""));
    }

    public static void register() {
        g.b().register();
    }

    public static void tianshuReportbyId(int i3) {
        try {
            i.n(null, i3, String.valueOf(adid), traceInfo);
        } catch (Exception unused) {
            QLog.d(TAG, 1, "TianshuReport error,error action_id is" + i3);
        }
    }

    public static void unRegister() {
        g.b().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fillTechInfoToIntent(int i3, long j3) {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return;
        }
        long f16 = o.f(i3);
        int g16 = o.g(i3);
        QLog.i(TAG, 1, "fillTechInfoToIntent, adId=" + i3 + ", durationFromLastTryShow=" + j3 + ", preStartTime=" + f16 + ", preEndTime=" + f16 + ",requestNum=" + g16);
        Intent intent = this.intent;
        if (intent == null) {
            QLog.e(TAG, 1, "fillTechInfoToIntent intent == null, return");
            return;
        }
        intent.putExtra(ProfileCardDtReportUtil.DT_REPORT_PARAM_TIANSHU_AD_ID, i3);
        this.intent.putExtra("last_load_time", j3);
        this.intent.putExtra("pre_load_start", f16);
        this.intent.putExtra("pre_load_end", f16);
        this.intent.putExtra("request_num", g16);
    }

    public void initHelper() {
        register();
    }

    public void onDestroy() {
        unRegister();
    }
}
