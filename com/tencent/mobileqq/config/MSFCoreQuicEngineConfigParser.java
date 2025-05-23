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
public class MSFCoreQuicEngineConfigParser extends BaseConfigParser<w> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public w defaultConfig() {
        return new w();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(final w wVar) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (wVar == null || peekAppRuntime == null || TextUtils.isEmpty(wVar.f202984d)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.MSFCoreQuicEngineConfigParser.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("MSFCoreQuicEngineConfigParser", 1, " [doOnConfigUpdate]: " + wVar.f202984d);
                NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), BuiltInServlet.class);
                newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_MSF_CONFIG);
                newIntent.putExtra(BaseConstants.KEY_CONFIG_CONTENT, wVar.f202984d);
                newIntent.putExtra(BaseConstants.KEY_CONFIG_MANAGER_ID, BaseConstants.MSF_CORE_QUIC_ENGINE_CONFIG_MANAGER);
                newIntent.setWithouLogin(true);
                peekAppRuntime.startServlet(newIntent);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public w parse(byte[] bArr) {
        w wVar = new w();
        if (bArr.length > 0) {
            wVar.a(new String(bArr, StandardCharsets.UTF_8));
        }
        QLog.d("MSFCoreQuicEngineConfigParser", 1, "configs parse\uff1a" + wVar.f202984d);
        return wVar;
    }
}
