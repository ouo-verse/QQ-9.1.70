package com.tencent.mobileqq.config.business;

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
public class MsfMultiTcpParser extends BaseConfigParser<z> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public z defaultConfig() {
        return new z();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(final z zVar) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (zVar != null && peekAppRuntime != null && !TextUtils.isEmpty(zVar.f202853d)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.business.MsfMultiTcpParser.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("MsfMultiTcpProcessor", 1, " [doOnConfigUpdate]: " + zVar.f202853d);
                    NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), BuiltInServlet.class);
                    newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_MSF_CONFIG);
                    newIntent.putExtra(BaseConstants.KEY_CONFIG_CONTENT, zVar.f202853d);
                    newIntent.putExtra(BaseConstants.KEY_CONFIG_MANAGER_ID, BaseConstants.MSF_MULTI_TCP_CONFIG_MANAGER);
                    peekAppRuntime.startServlet(newIntent);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public z parse(@NonNull byte[] bArr) {
        z zVar = new z();
        if (bArr.length > 0) {
            zVar.a(new String(bArr, StandardCharsets.UTF_8));
        }
        QLog.d("MsfMultiTcpProcessor", 1, "configs parse\uff1a" + zVar.f202853d);
        return zVar;
    }
}
