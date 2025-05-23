package com.tencent.mobileqq.config.business.msf;

import android.text.TextUtils;
import androidx.annotation.NonNull;
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

/* loaded from: classes10.dex */
public class MSFSampleRateConfigParser extends BaseConfigParser<e> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e defaultConfig() {
        return new e();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(final e eVar) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (eVar != null && peekAppRuntime != null && !TextUtils.isEmpty(eVar.f202692d)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.business.msf.MSFSampleRateConfigParser.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("MSFSampleRateConfigParser", 1, " [doOnConfigUpdate]: " + eVar.f202692d);
                    NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), BuiltInServlet.class);
                    newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_MSF_CONFIG);
                    newIntent.putExtra(BaseConstants.KEY_CONFIG_CONTENT, eVar.f202692d);
                    newIntent.putExtra(BaseConstants.KEY_CONFIG_MANAGER_ID, BaseConstants.MSF_SAMPLE_RATE_CONFIG_MANAGER);
                    peekAppRuntime.startServlet(newIntent);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public e parse(@NonNull byte[] bArr) {
        e eVar = new e();
        if (bArr.length > 0) {
            eVar = e.a(new String(bArr, StandardCharsets.UTF_8));
        }
        QLog.d("MSFSampleRateConfigParser", 1, "configs parse\uff1a" + eVar.f202692d);
        return eVar;
    }
}
