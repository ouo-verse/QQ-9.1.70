package com.tencent.mobileqq.config;

import android.text.TextUtils;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* loaded from: classes33.dex */
public class MSFCoreMonitorConfigParser extends BaseConfigParser<q> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q defaultConfig() {
        return new q();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(final q qVar) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (qVar == null || peekAppRuntime == null || TextUtils.isEmpty(qVar.f202904d)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.MSFCoreMonitorConfigParser.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("MSFCoreMonitorConfigParser", 1, " [doOnConfigUpdate]: " + qVar.f202904d);
                NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), BuiltInServlet.class);
                newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_MSF_CONFIG);
                newIntent.putExtra(BaseConstants.KEY_CONFIG_CONTENT, qVar.f202904d);
                newIntent.putExtra(BaseConstants.KEY_CONFIG_MANAGER_ID, BaseConstants.MSF_CORE_MONITOR_CONFIG_MANAGER);
                peekAppRuntime.startServlet(newIntent);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public q parse(byte[] bArr) {
        q qVar = new q();
        if (bArr.length > 0) {
            qVar.a(new String(bArr, StandardCharsets.UTF_8));
        }
        QLog.d("MSFCoreMonitorConfigParser", 1, "configs parse\uff1a" + qVar.f202904d);
        return qVar;
    }
}
