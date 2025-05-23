package com.tencent.luggage.wxa.b;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends RuntimeException {
    public b(String str, String[] strArr, String[] strArr2) {
        super("Could not find '" + str + "'. Looked for: " + Arrays.toString(strArr) + ", but only found: " + Arrays.toString(strArr2) + ".");
    }
}
