package com.tencent.mtt.hippy.d;

import java.io.IOException;
import java.net.ProtocolException;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f337201a;

    /* renamed from: b, reason: collision with root package name */
    public final String f337202b;

    public c(int i3, String str) {
        this.f337201a = i3;
        this.f337202b = str;
    }

    public static c a(String str) throws IOException {
        int i3;
        String str2;
        if (str.startsWith("HTTP/1.")) {
            i3 = 9;
            if (str.length() >= 9 && str.charAt(8) == ' ') {
                int charAt = str.charAt(7) - '0';
                if (charAt != 0 && charAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            i3 = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i16 = i3 + 3;
        if (str.length() >= i16) {
            try {
                int parseInt = Integer.parseInt(str.substring(i3, i16));
                if (str.length() > i16) {
                    if (str.charAt(i16) == ' ') {
                        str2 = str.substring(i3 + 4);
                    } else {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                } else {
                    str2 = "";
                }
                return new c(parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        }
        throw new ProtocolException("Unexpected status line: " + str);
    }
}
