package com.qzone.proxy.feedcomponent.util;

import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes39.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f50902a = Pattern.compile("http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?", 2);

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f50903b = Pattern.compile("href=\"http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?\"", 2);

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f50904c = Pattern.compile("@?\\{uin:.*?,nick:.*?\\}");

    /* renamed from: d, reason: collision with root package name */
    public static final StringBuffer f50905d;

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f50906e;

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f50907f;

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f50908g;

    static {
        StringBuffer stringBuffer = new StringBuffer("\\[em\\]e\\d{1,}\\[/em\\]");
        f50905d = stringBuffer;
        f50906e = Pattern.compile(stringBuffer.toString(), 2);
        f50907f = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
        f50908g = Pattern.compile("\\[em2\\]e\\d{1,},\\d{1,},\\d{1,}\\[/em2\\]", 2);
    }

    public static String a(String str) {
        return str.replace("%", "%25").replace(",", "%2C").replace("}", "%7D").replace("{", "%7B").replace(":", "%3A");
    }

    public static boolean b(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        return str.equals(str2);
    }
}
