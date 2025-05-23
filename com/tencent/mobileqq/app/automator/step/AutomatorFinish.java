package com.tencent.mobileqq.app.automator.step;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.signature$SignatureKickData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.io.File;
import java.util.HashMap;
import mqq.app.Constants;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AutomatorFinish extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static long f195323d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70075);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f195323d = -1L;
        }
    }

    public AutomatorFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        f195323d = currentTimeMillis;
        T t16 = this.mAutomator;
        long j3 = currentTimeMillis - ((Automator) t16).f195305d;
        vy3.a.f443742k |= 32;
        vy3.a.f443748q = f195323d;
        ((Automator) t16).f195305d = 0L;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_threadOpId", String.valueOf(com.tencent.qqperf.opt.threadpriority.a.c().b()));
        StatisticCollector.getInstance(((Automator) this.mAutomator).E.getApp()).collectPerformance(null, StatisticCollector.TAG_QQ_INIT_TIME, true, j3, ((Automator) this.mAutomator).F2(), hashMap, null);
        Log.i("AutoMonitor", "QQInitialize, cost=" + j3 + ", totalFailCount=" + ((Automator) this.mAutomator).F2());
        try {
            BaseApplicationImpl.sApplication.getClassLoader().loadClass("com.tencent.mobileqq.protect.RtRa");
            z16 = true;
        } catch (Throwable unused) {
            z16 = false;
        }
        if (z16) {
            try {
                StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(((Automator) this.mAutomator).E.getCurrentUin(), "qqDetectAttack", true, 0L, 0L, null, null);
                SharedPreferences sharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("QQDetectAttack", 0);
                int i3 = sharedPreferences.getInt("AttackCount", 0);
                if (i3 >= 10) {
                    Intent intent = new Intent();
                    intent.setAction(NewIntent.ACTION_ACCOUNT_KICKED);
                    intent.putExtra("reason", Constants.LogoutReason.secKicked);
                    signature$SignatureKickData signature_signaturekickdata = new signature$SignatureKickData();
                    signature_signaturekickdata.str_packname.set("pack");
                    signature_signaturekickdata.u32_check_result.set(BaseApplicationImpl.sApplication.getSharedPreferences("SecSig", 0).getInt("SecResEntry", -1) & 18);
                    Resources resources = BaseApplicationImpl.sApplication.getResources();
                    signature_signaturekickdata.str_right_button.set(resources.getString(R.string.f170862av0));
                    signature_signaturekickdata.str_url.set("https://im.qq.com");
                    intent.putExtra("data", signature_signaturekickdata.toByteArray());
                    intent.putExtra("title", resources.getString(R.string.i1h));
                    intent.putExtra("msg", resources.getString(R.string.f171494fi1));
                    MsfSdkUtils.updateSimpleAccount(((Automator) this.mAutomator).getCurrentAccountUin(), false);
                    BaseApplicationImpl.sApplication.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
                    ((Automator) this.mAutomator).E.logout(true);
                    intent.setFlags(872415232);
                    RouteUtils.startActivity(BaseApplicationImpl.sApplication, intent, RouterConstants.UI_ROUTER_NOTIFICATION);
                }
                sharedPreferences.edit().putInt("AttackCount", i3 + 1).commit();
            } catch (Throwable unused2) {
                return 7;
            }
        }
        File file = new File(AppConstants.SDCARD_ROOT + "/tencent/MobileQQ/data/wifi");
        if (file.exists()) {
            file.delete();
            return 7;
        }
        return 7;
    }
}
