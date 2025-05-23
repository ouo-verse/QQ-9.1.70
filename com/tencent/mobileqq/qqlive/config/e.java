package com.tencent.mobileqq.qqlive.config;

import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static d f271190a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61177);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f271190a = null;
        }
    }

    public static d a() {
        d dVar;
        d dVar2 = f271190a;
        if (dVar2 != null) {
            return dVar2;
        }
        try {
            dVar = d.a(new ai[]{new ai(8380, ht3.a.d("qqlive_task_live_config", "{\n\"liveOnlineRankUrl\": \"https://h5.qzone.qq.com/v2/vip/live/qlive-h5/pages/rank.html?_wv=16777216\",\n\"liveMorePageUrl\": \"https://h5.qzone.qq.com/v2/vip/live/qlive-h5/pages/portal.html?_wv=16777216\",\n\"livePersonalPageUrl\": \"https://h5.qzone.qq.com/v2/vip/live/profile?puin={pUin}&openid={anchorOpenId}&anchorUid={anchorUid}&_wv=16777217\",\n\"lotteryEffectPic\": \"https://qzonestyle.gtimg.cn/qzone/qzact/act/external/PK/PK/prize/kjdh.png?nowebp&nosharpp\",\n\"lotteryPic\": \"https://cdn.yes.qq.com/upload_wuji/20210723_x57zoe200zl.png\",\n\"lotteryPageUrl\": \"https://h5.qzone.qq.com/v2/vip/live/qlive-h5/pages/plat-lottery.html?lotteryId={lotteryId}&roomId={roomId}&programId={programId}&busId={busId}\",\n\"liveVerifyUrl\": \"https://qlive.qq.com/pages/name-auth.html?_wv=16777216\",\n\"reduceLiveLatencyAction8823\": 0,\n\"speedUpRate\": 1.0,\n\"minBufferDuration\": 6000,\n\"player\": {\n\"playerPoolMaxSize\": 3,\n\"enableMaxSize\": true\n}\n}"))});
        } catch (Throwable th5) {
            QLog.e("QQGiftConfigProcessor", 1, th5, new Object[0]);
            dVar = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftConfigProcessor", 2, "loadConfig bean:" + dVar);
        }
        if (dVar == null) {
            dVar = new d();
        }
        f271190a = dVar;
        return dVar;
    }
}
