package com.qq.wx.voice.recognizer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class InfoSender {
    public static final String DefaultDomain = "api.pr.weixin.qq.com";
    public static final int DefaultPort = 80;
    public static final String DefaultUri = "/cgi-bin/wxvoicereco";
    public static String Domain = "api.pr.weixin.qq.com";
    public static int Port = 80;
    public static String Uri = "/cgi-bin/wxvoicereco";

    public static void resetDomain() {
        Domain = "api.pr.weixin.qq.com";
        Port = 80;
    }

    public static void resetUri() {
        Uri = "/cgi-bin/wxvoicereco";
    }

    public static void setDomain(String str, int i3, String str2) {
        Domain = str;
        Port = i3;
    }

    public static void setUri(String str) {
        Uri = str;
    }
}
