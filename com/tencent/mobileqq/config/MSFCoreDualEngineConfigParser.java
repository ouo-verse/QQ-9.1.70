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
public class MSFCoreDualEngineConfigParser extends BaseConfigParser<o> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o defaultConfig() {
        return new o();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(final o oVar) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (oVar == null || peekAppRuntime == null || TextUtils.isEmpty(oVar.f202889d)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.MSFCoreDualEngineConfigParser.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("MSFCoreDualEngineConfigParser", 1, " [doOnConfigUpdate]: " + oVar.f202889d);
                NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), BuiltInServlet.class);
                newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_MSF_CONFIG);
                newIntent.putExtra(BaseConstants.KEY_CONFIG_CONTENT, oVar.f202889d);
                newIntent.putExtra(BaseConstants.KEY_CONFIG_MANAGER_ID, BaseConstants.MSF_CORE_DUAL_ENGINE_CONFIG_MANAGER);
                newIntent.setWithouLogin(true);
                peekAppRuntime.startServlet(newIntent);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public o parse(byte[] bArr) {
        o oVar = new o();
        if (bArr.length > 0) {
            oVar.a(new String(bArr, StandardCharsets.UTF_8));
        }
        QLog.d("MSFCoreDualEngineConfigParser", 1, "configs parse\uff1a" + oVar.f202889d);
        return oVar;
    }
}
