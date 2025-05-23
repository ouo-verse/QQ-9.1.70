package com.tencent.mobileqq.config.aio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import java.nio.charset.StandardCharsets;
import ma1.b;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes10.dex */
public class MultiMsgConfParser extends BaseConfigParser<b> {
    private void d() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            return;
        }
        MultiMsgManager.w().I((QQAppInterface) peekAppRuntime);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable b bVar) {
        super.doOnConfigUpdate(bVar);
        d();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b parse(@NonNull byte[] bArr) {
        return b.b(new String(bArr, StandardCharsets.UTF_8));
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onReceive(boolean z16) {
        super.onReceive(z16);
        if (!z16) {
            return;
        }
        d();
    }
}
