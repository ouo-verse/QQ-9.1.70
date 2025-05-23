package org.apache.http.cookie;

import java.util.Date;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface SetCookie extends Cookie {
    void setComment(String str);

    void setDomain(String str);

    void setExpiryDate(Date date);

    void setPath(String str);

    void setSecure(boolean z16);

    void setValue(String str);

    void setVersion(int i3);
}
