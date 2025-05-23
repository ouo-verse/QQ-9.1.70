package com.tencent.luggage.wxa.mc;

import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s extends Exception {
    public s(String str) {
        super(String.format(Locale.US, "%s not found", str));
    }
}
