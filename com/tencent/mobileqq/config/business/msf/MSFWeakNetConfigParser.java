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
public class MSFWeakNetConfigParser extends BaseConfigParser<f> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f defaultConfig() {
        return new f();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(final f fVar) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (fVar != null && peekAppRuntime != null && !TextUtils.isEmpty(fVar.f202693d)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.business.msf.MSFWeakNetConfigParser.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("MSFWeakNetConfigParser", 1, " [doOnConfigUpdate]: " + fVar.f202693d);
                    NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), BuiltInServlet.class);
                    newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_MSF_WEAK_NET_CONFIG);
                    newIntent.putExtra(BaseConstants.KEY_MSF_WEAK_NET_CONFIG_ALL, fVar.f202693d);
                    peekAppRuntime.startServlet(newIntent);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public f parse(@NonNull byte[] bArr) {
        f fVar = new f();
        if (bArr.length > 0) {
            fVar = f.a(new String(bArr, StandardCharsets.UTF_8));
        }
        QLog.d("MSFWeakNetConfigParser", 1, "configs parse\uff1a" + fVar.f202693d);
        return fVar;
    }
}
