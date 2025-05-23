package com.qq.e.comm.net.rr;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.HttpURLConnection;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface Request {
    public static final int METHOD_GET = 1;
    public static final int METHOD_POST = 2;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Method {
    }

    void addHeader(String str, String str2);

    void addQuery(String str, String str2);

    int getConnectionTimeOut();

    int getMethod();

    byte[] getPostData() throws Exception;

    int getPriority();

    Map<String, String> getQuerys();

    int getSocketTimeOut();

    Map<String, String> getUnmodifiableHeaders();

    String getUrl();

    String getUrlWithParas();

    Response initResponse(HttpURLConnection httpURLConnection);

    boolean isAutoClose();

    void setConnectionTimeOut(int i3);

    void setSocketTimeOut(int i3);
}
