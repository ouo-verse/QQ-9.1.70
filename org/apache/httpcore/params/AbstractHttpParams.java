package org.apache.httpcore.params;

import java.util.Set;

@Deprecated
/* loaded from: classes29.dex */
public abstract class AbstractHttpParams implements HttpParams, HttpParamsNames {
    @Override // org.apache.httpcore.params.HttpParams
    public boolean getBooleanParameter(String str, boolean z16) {
        Object parameter = getParameter(str);
        if (parameter == null) {
            return z16;
        }
        return ((Boolean) parameter).booleanValue();
    }

    @Override // org.apache.httpcore.params.HttpParams
    public double getDoubleParameter(String str, double d16) {
        Object parameter = getParameter(str);
        if (parameter == null) {
            return d16;
        }
        return ((Double) parameter).doubleValue();
    }

    @Override // org.apache.httpcore.params.HttpParams
    public int getIntParameter(String str, int i3) {
        Object parameter = getParameter(str);
        if (parameter == null) {
            return i3;
        }
        return ((Integer) parameter).intValue();
    }

    @Override // org.apache.httpcore.params.HttpParams
    public long getLongParameter(String str, long j3) {
        Object parameter = getParameter(str);
        if (parameter == null) {
            return j3;
        }
        return ((Long) parameter).longValue();
    }

    @Override // org.apache.httpcore.params.HttpParamsNames
    public Set<String> getNames() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.httpcore.params.HttpParams
    public boolean isParameterFalse(String str) {
        return !getBooleanParameter(str, false);
    }

    @Override // org.apache.httpcore.params.HttpParams
    public boolean isParameterTrue(String str) {
        return getBooleanParameter(str, false);
    }

    @Override // org.apache.httpcore.params.HttpParams
    public HttpParams setBooleanParameter(String str, boolean z16) {
        Boolean bool;
        if (z16) {
            bool = Boolean.TRUE;
        } else {
            bool = Boolean.FALSE;
        }
        setParameter(str, bool);
        return this;
    }

    @Override // org.apache.httpcore.params.HttpParams
    public HttpParams setDoubleParameter(String str, double d16) {
        setParameter(str, Double.valueOf(d16));
        return this;
    }

    @Override // org.apache.httpcore.params.HttpParams
    public HttpParams setIntParameter(String str, int i3) {
        setParameter(str, Integer.valueOf(i3));
        return this;
    }

    @Override // org.apache.httpcore.params.HttpParams
    public HttpParams setLongParameter(String str, long j3) {
        setParameter(str, Long.valueOf(j3));
        return this;
    }
}
