package com.tencent.xweb;

/* loaded from: classes27.dex */
public interface IXWebPreferences {
    public static final String REMOTE_DEBUGGING = "remote-debugging";
    public static final String XWEB_HTTP_DNS = "http-dns";
    public static final String XWEB_LANGUAGE = "lang";

    boolean getBooleanValue(String str);

    int getIntegerValue(String str);

    String getStringValue(String str);

    boolean getValue(String str);

    void setValue(String str, int i3);

    void setValue(String str, String str2);

    void setValue(String str, boolean z16);
}
