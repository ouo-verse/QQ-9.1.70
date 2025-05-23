package com.tencent.mobileqq.activity.aio.stickerrecommended.ad;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import x61.b;
import x61.c;

/* loaded from: classes10.dex */
public class AdEmoConfigProcessor extends BaseConfigParser<c> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c defaultConfig() {
        return new c();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable c cVar) {
        super.doOnConfigUpdate(cVar);
        if (cVar == null) {
            QLog.d("AdEmoConfigProcessor", 1, "doOnConfigUpdate adEmoConfigBean is null");
            return;
        }
        AppInterface d16 = d();
        if (d16 != null) {
            b.d(d16.getApp(), d16.getCurrentUin(), cVar.f447285d);
            QLog.d("AdEmoConfigProcessor", 1, "doOnConfigUpdate AdEmoCfgProvider.updateCfgStr adEmoConfigBean.mAdEmoCfg " + cVar.f447285d);
        }
    }

    public AppInterface d() {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getApp, runtime is null ?  ");
            if (peekAppRuntime == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(" , runtime instanceof QQAppInterface ? ");
            sb5.append(peekAppRuntime instanceof AppInterface);
            QLog.d("AdEmoConfigProcessor", 2, sb5.toString());
        }
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c parse(@NonNull byte[] bArr) {
        String str = new String(bArr, StandardCharsets.UTF_8);
        QLog.i("AdEmoConfigProcessor", 1, " AdEmoConfigBean parse " + str);
        if (TextUtils.isEmpty(str)) {
            return new c();
        }
        return c.a(str);
    }
}
