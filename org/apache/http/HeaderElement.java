package org.apache.http;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HeaderElement {
    String getName();

    NameValuePair getParameter(int i3);

    NameValuePair getParameterByName(String str);

    int getParameterCount();

    NameValuePair[] getParameters();

    String getValue();
}
