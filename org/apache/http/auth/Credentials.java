package org.apache.http.auth;

import java.security.Principal;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface Credentials {
    String getPassword();

    Principal getUserPrincipal();
}
