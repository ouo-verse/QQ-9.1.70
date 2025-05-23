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
public class MSFProbeConfigParser extends BaseConfigParser<ac> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ac defaultConfig() {
        return new ac();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(final ac acVar) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (acVar == null || peekAppRuntime == null || TextUtils.isEmpty(acVar.f202256d)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.MSFProbeConfigParser.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("MSFProbeConfigParser", 1, " [doOnConfigUpdate]: " + acVar.f202256d);
                NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), BuiltInServlet.class);
                newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_MSF_CONFIG);
                newIntent.putExtra(BaseConstants.KEY_CONFIG_CONTENT, acVar.f202256d);
                newIntent.putExtra(BaseConstants.KEY_CONFIG_MANAGER_ID, BaseConstants.MSF_PROBE_CONFIG_MANAGER);
                newIntent.setWithouLogin(true);
                peekAppRuntime.startServlet(newIntent);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ac parse(byte[] bArr) {
        ac acVar = new ac();
        if (bArr.length > 0) {
            acVar.a(new String(bArr, StandardCharsets.UTF_8));
        }
        QLog.d("MSFProbeConfigParser", 1, "configs parse\uff1a" + acVar.f202256d);
        return acVar;
    }
}
