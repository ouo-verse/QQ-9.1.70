package com.tencent.qqperf.crashdefend;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.config.AppSetting;
import com.tencent.freesia.ILogger;
import com.tencent.freesia.https.HttpsPipe;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.crashdefend.report.ReportSaveInfoHelper;
import com.tencent.trpcprotocol.group_pro.configdistribution.config_distribution_svr.configDistributionSvr;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qqperf.crashdefend.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class C9708a implements ILogger {
        C9708a() {
        }

        @Override // com.tencent.freesia.ILogger
        public void d(@NonNull String str, @NonNull String str2) {
            if (QLog.isColorLevel()) {
                QLog.d(str, 2, str2);
            }
        }

        @Override // com.tencent.freesia.ILogger
        public void e(@NonNull String str, @NonNull String str2) {
            QLog.e(str, 1, str2);
        }

        @Override // com.tencent.freesia.ILogger
        public void i(@NonNull String str, @NonNull String str2) {
            if (QLog.isColorLevel()) {
                QLog.i(str, 2, str2);
            }
        }
    }

    @Nullable
    public static configDistributionSvr.RespConfig a() {
        return b(0);
    }

    @Nullable
    private static configDistributionSvr.RespConfig b(int i3) {
        String currentAccountUin;
        try {
            ReportSaveInfoHelper.g(BaseApplication.context);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                currentAccountUin = "";
            } else {
                currentAccountUin = peekAppRuntime.getCurrentAccountUin();
            }
            String str = currentAccountUin;
            String c16 = ReportSaveInfoHelper.e().c();
            if (TextUtils.isEmpty(c16)) {
                QLog.e("ConfigFetcher", 1, "qimei is empty");
            }
            configDistributionSvr.GetConfigRsp fetch = new HttpsPipe(new C9708a()).fetch("10028", AppSetting.f(), AppSetting.f99551k, str, c16, "105628");
            if (fetch != null && !fetch.configs.isEmpty()) {
                return fetch.configs.get(0);
            }
            return null;
        } catch (Throwable th5) {
            QLog.e("ConfigFetcher", 1, th5, new Object[0]);
            if (i3 == 0) {
                return b(i3 + 1);
            }
            return null;
        }
    }
}
