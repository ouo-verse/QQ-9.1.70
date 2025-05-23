package com.eclipsesource.mmv8;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8ScriptExecutionException extends V8ScriptException {
    public V8ScriptExecutionException(String str, int i3, String str2, String str3, int i16, int i17, String str4) {
        this(0, str, i3, str2, str3, i16, i17, str4, null);
    }

    public V8ScriptExecutionException(int i3, String str, int i16, String str2, String str3, int i17, int i18, String str4, Throwable th5) {
        super(i3, str, i16, str2, str3, i17, i18, str4, th5);
    }
}
