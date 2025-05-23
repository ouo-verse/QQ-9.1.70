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
public class ComplexConnectConfigParser extends BaseConfigParser<b> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(final b bVar) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (bVar != null && peekAppRuntime != null && !TextUtils.isEmpty(bVar.f202689d)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.business.msf.ComplexConnectConfigParser.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("ComplexConnectConfigParser", 1, " [doOnConfigUpdate]: " + bVar.f202689d);
                    NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), BuiltInServlet.class);
                    newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_COMPLEX_CONNECT_CONFIG);
                    newIntent.putExtra(BaseConstants.KEY_COMPLEX_CONNECT_CONFIG_ALL, bVar.f202689d);
                    peekAppRuntime.startServlet(newIntent);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b parse(@NonNull byte[] bArr) {
        b bVar = new b();
        if (bArr.length > 0) {
            bVar = b.a(new String(bArr, StandardCharsets.UTF_8));
        }
        QLog.d("ComplexConnectConfigParser", 1, "configs parse\uff1a" + bVar.f202689d);
        return bVar;
    }
}
