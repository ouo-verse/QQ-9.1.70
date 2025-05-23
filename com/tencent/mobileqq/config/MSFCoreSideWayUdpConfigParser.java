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
public class MSFCoreSideWayUdpConfigParser extends BaseConfigParser<aa> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public aa defaultConfig() {
        return new aa();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(final aa aaVar) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (aaVar == null || peekAppRuntime == null || TextUtils.isEmpty(aaVar.f202254d)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.MSFCoreSideWayUdpConfigParser.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("MSFCoreSideWayUdpConfigParser", 1, " [doOnConfigUpdate]: " + aaVar.f202254d);
                NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), BuiltInServlet.class);
                newIntent.putExtra("action", Constants.Action.ACTION_UPDATE_MSF_CONFIG);
                newIntent.putExtra(BaseConstants.KEY_CONFIG_CONTENT, aaVar.f202254d);
                newIntent.putExtra(BaseConstants.KEY_CONFIG_MANAGER_ID, BaseConstants.MSF_CORE_SIDE_WAY_UDP_CONFIG_MANAGER);
                peekAppRuntime.startServlet(newIntent);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public aa parse(byte[] bArr) {
        aa aaVar = new aa();
        if (bArr.length > 0) {
            aaVar.a(new String(bArr, StandardCharsets.UTF_8));
        }
        QLog.d("MSFCoreSideWayUdpConfigParser", 1, "configs parse\uff1a" + aaVar.f202254d);
        return aaVar;
    }
}
