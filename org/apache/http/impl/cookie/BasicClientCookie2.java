package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.cookie.SetCookie2;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class BasicClientCookie2 extends BasicClientCookie implements SetCookie2 {
    public BasicClientCookie2(String str, String str2) {
        super(null, null);
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.BasicClientCookie
    public Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.BasicClientCookie, org.apache.http.cookie.Cookie
    public String getCommentURL() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.BasicClientCookie, org.apache.http.cookie.Cookie
    public int[] getPorts() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.BasicClientCookie, org.apache.http.cookie.Cookie
    public boolean isExpired(Date date) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.BasicClientCookie, org.apache.http.cookie.Cookie
    public boolean isPersistent() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.SetCookie2
    public void setCommentURL(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.SetCookie2
    public void setDiscard(boolean z16) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.SetCookie2
    public void setPorts(int[] iArr) {
        throw new RuntimeException("Stub!");
    }
}
