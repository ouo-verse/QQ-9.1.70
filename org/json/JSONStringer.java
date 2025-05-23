package org.json;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes29.dex */
public class JSONStringer {
    private final String indent;
    final StringBuilder out;
    private final List<Scope> stack;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum Scope {
        EMPTY_ARRAY,
        NONEMPTY_ARRAY,
        EMPTY_OBJECT,
        DANGLING_KEY,
        NONEMPTY_OBJECT,
        NULL
    }

    public JSONStringer() {
        this.out = new StringBuilder();
        this.stack = new ArrayList();
        this.indent = null;
    }

    private void beforeKey() throws JSONException {
        Scope peek = peek();
        if (peek == Scope.NONEMPTY_OBJECT) {
            this.out.append(',');
        } else if (peek != Scope.EMPTY_OBJECT) {
            throw new JSONException("Nesting problem");
        }
        newline();
        replaceTop(Scope.DANGLING_KEY);
    }

    private void beforeValue() throws JSONException {
        String str;
        if (this.stack.isEmpty()) {
            return;
        }
        Scope peek = peek();
        if (peek == Scope.EMPTY_ARRAY) {
            replaceTop(Scope.NONEMPTY_ARRAY);
            newline();
            return;
        }
        if (peek == Scope.NONEMPTY_ARRAY) {
            this.out.append(',');
            newline();
        } else {
            if (peek == Scope.DANGLING_KEY) {
                StringBuilder sb5 = this.out;
                if (this.indent == null) {
                    str = ":";
                } else {
                    str = MsgSummary.STR_COLON;
                }
                sb5.append(str);
                replaceTop(Scope.NONEMPTY_OBJECT);
                return;
            }
            if (peek == Scope.NULL) {
            } else {
                throw new JSONException("Nesting problem");
            }
        }
    }

    private void newline() {
        if (this.indent == null) {
            return;
        }
        this.out.append("\n");
        for (int i3 = 0; i3 < this.stack.size(); i3++) {
            this.out.append(this.indent);
        }
    }

    private Scope peek() throws JSONException {
        if (!this.stack.isEmpty()) {
            return this.stack.get(r0.size() - 1);
        }
        throw new JSONException("Nesting problem");
    }

    private void replaceTop(Scope scope) {
        this.stack.set(r0.size() - 1, scope);
    }

    private void string(String str) {
        this.out.append("\"");
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt != '\f') {
                if (charAt != '\r') {
                    if (charAt != '\"' && charAt != '/' && charAt != '\\') {
                        switch (charAt) {
                            case '\b':
                                this.out.append("\\b");
                                break;
                            case '\t':
                                this.out.append("\\t");
                                break;
                            case '\n':
                                this.out.append(RedTouch.NEWLINE_CHAR);
                                break;
                            default:
                                if (charAt <= 31) {
                                    this.out.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                                    break;
                                } else {
                                    this.out.append(charAt);
                                    break;
                                }
                        }
                    } else {
                        StringBuilder sb5 = this.out;
                        sb5.append('\\');
                        sb5.append(charAt);
                    }
                } else {
                    this.out.append("\\r");
                }
            } else {
                this.out.append("\\f");
            }
        }
        this.out.append("\"");
    }

    public JSONStringer array() throws JSONException {
        return open(Scope.EMPTY_ARRAY, "[");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONStringer close(Scope scope, Scope scope2, String str) throws JSONException {
        Scope peek = peek();
        if (peek != scope2 && peek != scope) {
            throw new JSONException("Nesting problem");
        }
        this.stack.remove(r3.size() - 1);
        if (peek == scope2) {
            newline();
        }
        this.out.append(str);
        return this;
    }

    public JSONStringer endArray() throws JSONException {
        return close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
    }

    public JSONStringer endObject() throws JSONException {
        return close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
    }

    public JSONStringer key(String str) throws JSONException {
        if (str != null) {
            beforeKey();
            string(str);
            return this;
        }
        throw new JSONException("Names must be non-null");
    }

    public JSONStringer object() throws JSONException {
        return open(Scope.EMPTY_OBJECT, "{");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONStringer open(Scope scope, String str) throws JSONException {
        if (this.stack.isEmpty() && this.out.length() > 0) {
            throw new JSONException("Nesting problem: multiple top-level roots");
        }
        beforeValue();
        this.stack.add(scope);
        this.out.append(str);
        return this;
    }

    public String toString() {
        if (this.out.length() == 0) {
            return null;
        }
        return this.out.toString();
    }

    public JSONStringer value(Object obj) throws JSONException {
        if (!this.stack.isEmpty()) {
            if (obj instanceof JSONArray) {
                ((JSONArray) obj).writeTo(this);
                return this;
            }
            if (obj instanceof JSONObject) {
                ((JSONObject) obj).writeTo(this);
                return this;
            }
            beforeValue();
            if (obj != null && !(obj instanceof Boolean) && obj != JSONObject.NULL) {
                if (obj instanceof Number) {
                    this.out.append(JSONObject.numberToString((Number) obj));
                } else {
                    string(obj.toString());
                }
            } else {
                this.out.append(obj);
            }
            return this;
        }
        throw new JSONException("Nesting problem");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONStringer(int i3) {
        this.out = new StringBuilder();
        this.stack = new ArrayList();
        char[] cArr = new char[i3];
        Arrays.fill(cArr, TokenParser.SP);
        this.indent = new String(cArr);
    }

    public JSONStringer value(boolean z16) throws JSONException {
        if (!this.stack.isEmpty()) {
            beforeValue();
            this.out.append(z16);
            return this;
        }
        throw new JSONException("Nesting problem");
    }

    public JSONStringer value(double d16) throws JSONException {
        if (!this.stack.isEmpty()) {
            beforeValue();
            this.out.append(JSONObject.numberToString(Double.valueOf(d16)));
            return this;
        }
        throw new JSONException("Nesting problem");
    }

    public JSONStringer value(long j3) throws JSONException {
        if (!this.stack.isEmpty()) {
            beforeValue();
            this.out.append(j3);
            return this;
        }
        throw new JSONException("Nesting problem");
    }
}
