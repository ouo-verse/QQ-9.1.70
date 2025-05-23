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
public class MSFCommonConfigParser extends BaseConfigParser<c> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c defaultConfig() {
        return new c();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(final c cVar) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (cVar != null && peekAppRuntime != null && !TextUtils.isEmpty(cVar.f202690d)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.business.msf.MSFCommonConfigParser.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("MSFCommonConfigParser", 1, " [doOnConfigUpdate]: " + cVar.f202690d);
                    NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), BuiltInServlet.class);
                    newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_MSF_COMMON_CONFIG);
                    newIntent.putExtra(BaseConstants.KEY_MSF_COMMON_CONFIG_STRING, cVar.f202690d);
                    peekAppRuntime.startServlet(newIntent);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c parse(@NonNull byte[] bArr) {
        c cVar = new c();
        if (bArr.length > 0) {
            cVar = c.a(new String(bArr, StandardCharsets.UTF_8));
        }
        QLog.d("MSFCommonConfigParser", 1, "configs parse\uff1a" + cVar.f202690d);
        return cVar;
    }
}
