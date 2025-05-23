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
public class MSFCorePkgStatisticsConfigParser extends BaseConfigParser<v> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v defaultConfig() {
        return new v();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(final v vVar) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (vVar == null || peekAppRuntime == null || TextUtils.isEmpty(vVar.f202983d)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.MSFCorePkgStatisticsConfigParser.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("MSFCorePkgStatisticsConfigParser", 1, " [doOnConfigUpdate]: " + vVar.f202983d);
                NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), BuiltInServlet.class);
                newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_MSF_CONFIG);
                newIntent.putExtra(BaseConstants.KEY_CONFIG_CONTENT, vVar.f202983d);
                newIntent.putExtra(BaseConstants.KEY_CONFIG_MANAGER_ID, BaseConstants.MSF_CORE_PKG_STATISTICS_CONFIG_MANAGER);
                peekAppRuntime.startServlet(newIntent);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public v parse(byte[] bArr) {
        v vVar = new v();
        if (bArr.length > 0) {
            vVar.a(new String(bArr, StandardCharsets.UTF_8));
        }
        QLog.d("MSFCorePkgStatisticsConfigParser", 1, "configs parse\uff1a" + vVar.f202983d);
        return vVar;
    }
}
