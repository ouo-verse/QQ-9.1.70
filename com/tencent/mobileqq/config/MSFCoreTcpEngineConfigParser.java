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
public class MSFCoreTcpEngineConfigParser extends BaseConfigParser<ab> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ab defaultConfig() {
        return new ab();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(final ab abVar) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (abVar == null || peekAppRuntime == null || TextUtils.isEmpty(abVar.f202255d)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.MSFCoreTcpEngineConfigParser.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("MSFCoreTcpEngineConfigParser", 1, " [doOnConfigUpdate]: " + abVar.f202255d);
                NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), BuiltInServlet.class);
                newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_MSF_CONFIG);
                newIntent.putExtra(BaseConstants.KEY_CONFIG_CONTENT, abVar.f202255d);
                newIntent.putExtra(BaseConstants.KEY_CONFIG_MANAGER_ID, BaseConstants.MSF_CORE_TCP_ENGINE_CONFIG_MANAGER);
                peekAppRuntime.startServlet(newIntent);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ab parse(byte[] bArr) {
        ab abVar = new ab();
        if (bArr.length > 0) {
            abVar.a(new String(bArr, StandardCharsets.UTF_8));
        }
        QLog.d("MSFCoreTcpEngineConfigParser", 1, "configs parse\uff1a" + abVar.f202255d);
        return abVar;
    }
}
