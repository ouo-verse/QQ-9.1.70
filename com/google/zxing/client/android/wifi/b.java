package com.google.zxing.client.android.wifi;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private final ParsedResultType f35983a;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(ParsedResultType parsedResultType) {
        this.f35983a = parsedResultType;
    }

    public static void b(String str, StringBuilder sb5) {
        if (sb5 != null && !TextUtils.isEmpty(str)) {
            if (sb5.length() > 0) {
                sb5.append('\n');
            }
            sb5.append(str);
        }
    }

    public abstract String a();

    public final String toString() {
        return a();
    }
}
