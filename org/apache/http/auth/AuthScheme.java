package org.apache.http.auth;

import org.apache.http.Header;
import org.apache.http.HttpRequest;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface AuthScheme {
    Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException;

    String getParameter(String str);

    String getRealm();

    String getSchemeName();

    boolean isComplete();

    boolean isConnectionBased();

    void processChallenge(Header header) throws MalformedChallengeException;
}
