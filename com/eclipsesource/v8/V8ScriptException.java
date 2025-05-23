package com.eclipsesource.v8;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class V8ScriptException extends V8RuntimeException {
    private final int endColumn;
    private final String fileName;
    private final String jsMessage;
    private final String jsStackTrace;
    private final int lineNumber;
    private final String sourceLine;
    private final int startColumn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public V8ScriptException(String str, int i3, String str2, String str3, int i16, int i17, String str4, Throwable th5) {
        this.fileName = str;
        this.lineNumber = i3;
        this.jsMessage = str2;
        this.sourceLine = str3;
        this.startColumn = i16;
        this.endColumn = i17;
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

    protected String getClassName() {
        return "V8ScriptException";
    }

    public int getEndColumn() {
        return this.endColumn;
    }

    public String getErrorMessage() {
        StringBuilder sb5 = new StringBuilder();
        String className = getClassName();
        sb5.append("className: ");
        sb5.append(className);
        sb5.append(", ");
        if (!TextUtils.isEmpty(this.fileName)) {
            sb5.append("fileName: ");
            sb5.append(this.fileName);
            sb5.append(", ");
        }
        sb5.append("lineName: ");
        sb5.append(this.lineNumber);
        sb5.append(", ");
        if (!TextUtils.isEmpty(this.jsMessage)) {
            sb5.append("jsMessage: ");
            sb5.append(this.jsMessage);
            sb5.append("\n");
        }
        sb5.append("startColumn: ");
        sb5.append(this.startColumn);
        sb5.append(", endColumn: ");
        sb5.append(this.endColumn);
        if (!TextUtils.isEmpty(this.jsStackTrace)) {
            sb5.append(", jsStack: ");
            sb5.append(this.jsStackTrace);
        }
        return sb5.toString();
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
        StringBuilder sb5 = new StringBuilder();
        sb5.append(createMessageLine());
        sb5.append(createMessageDetails());
        sb5.append(createJSStackDetails());
        sb5.append("\n");
        if (this.jsMessage != null) {
            sb5.append("jsMessage: ");
            sb5.append(this.jsMessage);
            sb5.append("\n");
        }
        sb5.append(getClassName());
        return sb5.toString();
    }
}
