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
public class MSFCorePkgCompressConfigParser extends BaseConfigParser<u> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u defaultConfig() {
        return new u();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(final u uVar) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (uVar == null || peekAppRuntime == null || TextUtils.isEmpty(uVar.f202982d)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.MSFCorePkgCompressConfigParser.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("MSFCoreModifyConfigParser", 1, " [doOnConfigUpdate]: " + uVar.f202982d);
                NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), BuiltInServlet.class);
                newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_MSF_CONFIG);
                newIntent.putExtra(BaseConstants.KEY_CONFIG_CONTENT, uVar.f202982d);
                newIntent.putExtra(BaseConstants.KEY_CONFIG_MANAGER_ID, BaseConstants.MSF_CORE_PKG_COMPRESS_CONFIG_MANAGER);
                newIntent.setWithouLogin(true);
                peekAppRuntime.startServlet(newIntent);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public u parse(byte[] bArr) {
        u uVar = new u();
        if (bArr.length > 0) {
            uVar.a(new String(bArr, StandardCharsets.UTF_8));
        }
        QLog.d("MSFCoreModifyConfigParser", 1, "configs parse\uff1a" + uVar.f202982d);
        return uVar;
    }
}
