package org.apache.http.cookie;

import java.util.List;
import org.apache.http.Header;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface CookieSpec {
    List<Header> formatCookies(List<Cookie> list);

    int getVersion();

    Header getVersionHeader();

    boolean match(Cookie cookie, CookieOrigin cookieOrigin);

    List<Cookie> parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException;

    void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException;
}
