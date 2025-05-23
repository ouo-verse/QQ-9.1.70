package com.tencent.mobileqq.app.identity.jwt;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.security.Key;

/* compiled from: P */
/* loaded from: classes11.dex */
public class JwtConsumer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "JwtConsumer";
    private SimpleKeyResolver verificationKeyResolver;

    public JwtConsumer(SimpleKeyResolver simpleKeyResolver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) simpleKeyResolver);
        } else {
            this.verificationKeyResolver = simpleKeyResolver;
        }
    }

    private JwtContext process(String str) {
        JsonWebSignature fromCompactSerialization = JsonWebSignature.fromCompactSerialization(str);
        if (fromCompactSerialization == null) {
            QLog.e(TAG, 1, "format jwt token error");
            return null;
        }
        JwtContext jwtContext = new JwtContext(str, fromCompactSerialization);
        if (!verifySignature(jwtContext)) {
            return null;
        }
        return jwtContext;
    }

    private boolean verifySignature(JwtContext jwtContext) {
        JsonWebSignature joseObject = jwtContext.getJoseObject();
        Key resolveKey = this.verificationKeyResolver.resolveKey();
        if (resolveKey == null) {
            QLog.e(TAG, 1, "verificationKeyResolver.resolveKey() is null");
            return false;
        }
        joseObject.setKey(resolveKey);
        return joseObject.verifySignature();
    }

    public String processToPayload(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        JwtContext process = process(str);
        if (process == null) {
            QLog.e(TAG, 1, "process jwt token error, process is null");
            return null;
        }
        JsonWebSignature joseObject = process.getJoseObject();
        if (joseObject == null) {
            QLog.e(TAG, 1, "process jwt token error, joseObject is null");
            return null;
        }
        return joseObject.getDecryptPayload();
    }
}
