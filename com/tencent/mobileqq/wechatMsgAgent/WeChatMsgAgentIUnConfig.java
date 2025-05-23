package com.tencent.mobileqq.wechatMsgAgent;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WeChatMsgAgentIUnConfig extends BaseConfigParser<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public final String f315065d;

    public WeChatMsgAgentIUnConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f315065d = "WeChatMsgAgentIUnconfig";
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        }
        a aVar = new a();
        if (bArr != null) {
            a a16 = a.a(new String(bArr, StandardCharsets.UTF_8));
            QLog.d("WeChatMsgAgentIUnconfig", 1, "configs parse\uff1a" + a16);
            return a16;
        }
        return aVar;
    }
}
