package org.apache.http.params;

@Deprecated
/* loaded from: classes29.dex */
public interface HttpParams {
    HttpParams copy();

    boolean getBooleanParameter(String str, boolean z16);

    double getDoubleParameter(String str, double d16);

    int getIntParameter(String str, int i3);

    long getLongParameter(String str, long j3);

    Object getParameter(String str);

    boolean isParameterFalse(String str);

    boolean isParameterTrue(String str);

    boolean removeParameter(String str);

    HttpParams setBooleanParameter(String str, boolean z16);

    HttpParams setDoubleParameter(String str, double d16);

    HttpParams setIntParameter(String str, int i3);

    HttpParams setLongParameter(String str, long j3);

    HttpParams setParameter(String str, Object obj);
}
