package org.apache.http.client;

import java.util.Date;
import java.util.List;
import org.apache.http.cookie.Cookie;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface CookieStore {
    void addCookie(Cookie cookie);

    void clear();

    boolean clearExpired(Date date);

    List<Cookie> getCookies();
}
