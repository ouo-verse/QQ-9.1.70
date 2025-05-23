package com.eclipsesource.v8;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8ScriptCompilationException extends V8ScriptException {
    private static final String TAG = "V8ScriptCompilationException";

    V8ScriptCompilationException(String str, int i3, String str2, String str3, int i16, int i17) {
        super(str, i3, str2, str3, i16, i17, null, null);
    }

    @Override // com.eclipsesource.v8.V8ScriptException
    protected String getClassName() {
        return TAG;
    }
}
