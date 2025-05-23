package com.eclipsesource.v8;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8ScriptExecutionException extends V8ScriptException {
    private static final String TAG = "V8ScriptExecutionException";

    V8ScriptExecutionException(String str, int i3, String str2, String str3, int i16, int i17, String str4) {
        this(str, i3, str2, str3, i16, i17, str4, null);
    }

    @Override // com.eclipsesource.v8.V8ScriptException
    protected String getClassName() {
        return TAG;
    }

    V8ScriptExecutionException(String str, int i3, String str2, String str3, int i16, int i17, String str4, Throwable th5) {
        super(str, i3, str2, str3, i16, i17, str4, th5);
    }
}
