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
public class BeforeMsgSyncControlConfigParser extends BaseConfigParser<a> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(final a aVar) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (aVar != null && peekAppRuntime != null && !TextUtils.isEmpty(aVar.f202688d)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.business.msf.BeforeMsgSyncControlConfigParser.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("BeforeMsgSyncControlConfigParser", 1, " [doOnConfigUpdate]: " + aVar.f202688d);
                    NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), BuiltInServlet.class);
                    newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_BEFORE_MSG_SYNC_CONTROL_CONFIG);
                    newIntent.putExtra(BaseConstants.KEY_BEFORE_MSG_SYNC_CONFIG_ALL, aVar.f202688d);
                    peekAppRuntime.startServlet(newIntent);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        a aVar = new a();
        if (bArr.length > 0) {
            aVar = a.a(new String(bArr, StandardCharsets.UTF_8));
        }
        QLog.d("BeforeMsgSyncControlConfigParser", 1, "configs parse\uff1a" + aVar.f202688d);
        return aVar;
    }
}
