package com.eclipsesource.mmv8;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class V8ScriptException extends V8RuntimeException {
    private final int contextTag;
    private final int endColumn;
    private final String fileName;
    private final String jsMessage;
    private final String jsStackTrace;
    private final int lineNumber;
    private final String sourceLine;
    private final int startColumn;

    public V8ScriptException(int i3, String str, int i16, String str2, String str3, int i17, int i18, String str4, Throwable th5) {
        this.contextTag = i3;
        this.fileName = str;
        this.lineNumber = i16;
        this.jsMessage = str2;
        this.sourceLine = str3;
        this.startColumn = i17;
        this.endColumn = i18;
        this.jsStackTrace = str4;
        if (th5 != null) {
            initCause(th5);
        }
    }

    private char[] createCharSequence(int i3, char c16) {
        char[] cArr = new char[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            cArr[i16] = c16;
        }
        return cArr;
    }

    private String createJSStackDetails() {
        if (this.jsStackTrace != null) {
            return "\n" + this.jsStackTrace;
        }
        return "";
    }

    private String createMessageDetails() {
        StringBuilder sb5 = new StringBuilder();
        String str = this.sourceLine;
        if (str != null && !str.isEmpty()) {
            sb5.append('\n');
            sb5.append(this.sourceLine);
            sb5.append('\n');
            int i3 = this.startColumn;
            if (i3 >= 0) {
                sb5.append(createCharSequence(i3, TokenParser.SP));
                sb5.append(createCharSequence(this.endColumn - this.startColumn, '^'));
            }
        }
        return sb5.toString();
    }

    private String createMessageLine() {
        return this.fileName + ":" + this.lineNumber + MsgSummary.STR_COLON + this.jsMessage;
    }

    public int getContextTag() {
        return this.contextTag;
    }

    public int getEndColumn() {
        return this.endColumn;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getJSMessage() {
        return this.jsMessage;
    }

    public String getJSStackTrace() {
        return this.jsStackTrace;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return createMessageLine();
    }

    public String getSourceLine() {
        return this.sourceLine;
    }

    public int getStartColumn() {
        return this.startColumn;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return createMessageLine() + createMessageDetails() + createJSStackDetails() + "\n" + getClass().getName();
    }
}
