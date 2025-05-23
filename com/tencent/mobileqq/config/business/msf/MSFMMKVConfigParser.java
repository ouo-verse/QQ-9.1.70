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
public class MSFMMKVConfigParser extends BaseConfigParser<d> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d defaultConfig() {
        return new d();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(final d dVar) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (dVar != null && peekAppRuntime != null && !TextUtils.isEmpty(dVar.f202691d)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.business.msf.MSFMMKVConfigParser.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("MSFMMKVConfigParser", 1, " [doOnConfigUpdate]: " + dVar.f202691d);
                    NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), BuiltInServlet.class);
                    newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_MSF_MMKV_CONFIG);
                    newIntent.putExtra(BaseConstants.KEY_MSF_MMKV_CONFIG, dVar.f202691d);
                    peekAppRuntime.startServlet(newIntent);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public d parse(@NonNull byte[] bArr) {
        d dVar = new d();
        if (bArr.length > 0) {
            dVar = d.a(new String(bArr, StandardCharsets.UTF_8));
        }
        QLog.d("MSFMMKVConfigParser", 1, "configs parse\uff1a" + dVar.f202691d);
        return dVar;
    }
}
