package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* loaded from: classes10.dex */
public class MSFConfigParser extends BaseConfigParser<v> {
    public static boolean d() {
        v vVar = (v) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("msf_common_config");
        if (vVar != null) {
            return vVar.a();
        }
        return false;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v defaultConfig() {
        return new v();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(final v vVar) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (vVar != null && peekAppRuntime != null && !TextUtils.isEmpty(vVar.f202840d)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.business.MSFConfigParser.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("MSFConfigProcessor", 1, " [doOnConfigUpdate]: " + vVar.f202840d);
                    NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), BuiltInServlet.class);
                    newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_MSF_CONFIG);
                    newIntent.putExtra(BaseConstants.KEY_CONFIG_CONTENT, vVar.f202840d);
                    newIntent.putExtra(BaseConstants.KEY_CONFIG_MANAGER_ID, BaseConstants.MSF_CONFIG_MANAGER);
                    peekAppRuntime.startServlet(newIntent);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public v parse(@NonNull byte[] bArr) {
        v vVar = new v();
        if (bArr.length > 0) {
            vVar.b(new String(bArr, StandardCharsets.UTF_8));
        }
        QLog.d("MSFConfigProcessor", 1, "configs parse\uff1a" + vVar.f202840d);
        return vVar;
    }
}
