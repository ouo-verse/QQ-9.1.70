package org.apache.http.impl.auth;

import org.apache.http.Header;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.util.CharArrayBuffer;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public abstract class AuthSchemeBase implements AuthScheme {
    public AuthSchemeBase() {
        throw new RuntimeException("Stub!");
    }

    public boolean isProxy() {
        throw new RuntimeException("Stub!");
    }

    protected abstract void parseChallenge(CharArrayBuffer charArrayBuffer, int i3, int i16) throws MalformedChallengeException;

    @Override // org.apache.http.auth.AuthScheme
    public void processChallenge(Header header) throws MalformedChallengeException {
        throw new RuntimeException("Stub!");
    }
}
