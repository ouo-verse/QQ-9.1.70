package com.eclipsesource.mmv8;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8ScriptEvaluateRequest {
    public static final int SCRIPT_TYPE_FD = 1;
    public static final int SCRIPT_TYPE_TEXT = 3;
    public static final int SCRIPT_TYPE_WXA_FD = 2;
    public String cacheCategory;
    public String cacheKey;
    public int cacheType;
    public int lineNumber;
    public V8ScriptFileDescriptor scriptFd;
    public String scriptName;
    public String scriptText;
    public int scriptType;
    public V8ScriptWxaFileDescriptor scriptWxaFd;
}
