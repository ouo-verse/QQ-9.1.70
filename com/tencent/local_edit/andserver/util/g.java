package com.tencent.local_edit.andserver.util;

import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f119881a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f119882b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f119883c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f119884d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f119885e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f119886f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f119887g;

    static {
        String format = String.format("[a-zA-Z0-9_\\-\\.]%s", "*");
        f119881a = format;
        String format2 = String.format("[a-zA-Z0-9_\\-\\.]%s", Marker.ANY_NON_NULL_MARKER);
        f119882b = format2;
        f119883c = String.format("((/%s)|((/%s)+))|((/%s)+/)", format, format2, format2);
        String format3 = String.format("[a-zA-Z0-9_\\-\\.]%s", Marker.ANY_NON_NULL_MARKER);
        f119884d = format3;
        f119885e = String.format("(%s)(=)(%s)", format3, "(.)*");
        f119886f = String.format("!%s", format3);
        f119887g = String.format("(%s)(!=)(%s)", format3, format2);
    }
}
