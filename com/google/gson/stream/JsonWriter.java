package com.google.gson.stream;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class JsonWriter implements Closeable, Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    private static final String[] REPLACEMENT_CHARS = new String[128];
    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls;
    private int[] stack = new int[32];
    private int stackSize = 0;

    static {
        for (int i3 = 0; i3 <= 31; i3++) {
            REPLACEMENT_CHARS[i3] = String.format("\\u%04x", Integer.valueOf(i3));
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = RedTouch.NEWLINE_CHAR;
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        HTML_SAFE_REPLACEMENT_CHARS = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer != null) {
            this.out = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    private void beforeName() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.out.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        replaceTop(4);
    }

    private void beforeValue() throws IOException {
        int peek = peek();
        if (peek != 1) {
            if (peek != 2) {
                if (peek != 4) {
                    if (peek != 6) {
                        if (peek == 7) {
                            if (!this.lenient) {
                                throw new IllegalStateException("JSON must have only one top-level value.");
                            }
                        } else {
                            throw new IllegalStateException("Nesting problem.");
                        }
                    }
                    replaceTop(7);
                    return;
                }
                this.out.append((CharSequence) this.separator);
                replaceTop(5);
                return;
            }
            this.out.append(',');
            newline();
            return;
        }
        replaceTop(2);
        newline();
    }

    private JsonWriter close(int i3, int i16, String str) throws IOException {
        int peek = peek();
        if (peek != i16 && peek != i3) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.deferredName == null) {
            this.stackSize--;
            if (peek == i16) {
                newline();
            }
            this.out.write(str);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.deferredName);
    }

    private void newline() throws IOException {
        if (this.indent == null) {
            return;
        }
        this.out.write("\n");
        int i3 = this.stackSize;
        for (int i16 = 1; i16 < i3; i16++) {
            this.out.write(this.indent);
        }
    }

    private JsonWriter open(int i3, String str) throws IOException {
        beforeValue();
        push(i3);
        this.out.write(str);
        return this;
    }

    private int peek() {
        int i3 = this.stackSize;
        if (i3 != 0) {
            return this.stack[i3 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void push(int i3) {
        int i16 = this.stackSize;
        int[] iArr = this.stack;
        if (i16 == iArr.length) {
            int[] iArr2 = new int[i16 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i16);
            this.stack = iArr2;
        }
        int[] iArr3 = this.stack;
        int i17 = this.stackSize;
        this.stackSize = i17 + 1;
        iArr3[i17] = i3;
    }

    private void replaceTop(int i3) {
        this.stack[this.stackSize - 1] = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        String[] strArr;
        String str2;
        if (this.htmlSafe) {
            strArr = HTML_SAFE_REPLACEMENT_CHARS;
        } else {
            strArr = REPLACEMENT_CHARS;
        }
        this.out.write("\"");
        int length = str.length();
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            char charAt = str.charAt(i16);
            if (charAt < '\u0080') {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
                if (i3 < i16) {
                    this.out.write(str, i3, i16 - i3);
                }
                this.out.write(str2);
                i3 = i16 + 1;
            } else {
                if (charAt == '\u2028') {
                    str2 = "\\u2028";
                } else if (charAt == '\u2029') {
                    str2 = "\\u2029";
                }
                if (i3 < i16) {
                }
                this.out.write(str2);
                i3 = i16 + 1;
            }
        }
        if (i3 < length) {
            this.out.write(str, i3, length - i3);
        }
        this.out.write("\"");
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            beforeName();
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    public JsonWriter beginArray() throws IOException {
        writeDeferredName();
        return open(1, "[");
    }

    public JsonWriter beginObject() throws IOException {
        writeDeferredName();
        return open(3, "{");
    }

    public JsonWriter endArray() throws IOException {
        return close(1, 2, "]");
    }

    public JsonWriter endObject() throws IOException {
        return close(3, 5, "}");
    }

    public void flush() throws IOException {
        if (this.stackSize != 0) {
            this.out.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public JsonWriter jsonValue(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        this.out.append((CharSequence) str);
        return this;
    }

    public JsonWriter name(String str) throws IOException {
        if (str != null) {
            if (this.deferredName == null) {
                if (this.stackSize != 0) {
                    this.deferredName = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) {
            if (this.serializeNulls) {
                writeDeferredName();
            } else {
                this.deferredName = null;
                return this;
            }
        }
        beforeValue();
        this.out.write("null");
        return this;
    }

    public final void setHtmlSafe(boolean z16) {
        this.htmlSafe = z16;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
        } else {
            this.indent = str;
            this.separator = MsgSummary.STR_COLON;
        }
    }

    public final void setLenient(boolean z16) {
        this.lenient = z16;
    }

    public final void setSerializeNulls(boolean z16) {
        this.serializeNulls = z16;
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        string(str);
        return this;
    }

    public JsonWriter value(boolean z16) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(z16 ? "true" : "false");
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i3 = this.stackSize;
        if (i3 <= 1 && (i3 != 1 || this.stack[i3 - 1] == 7)) {
            this.stackSize = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        this.out.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public JsonWriter value(double d16) throws IOException {
        writeDeferredName();
        if (!this.lenient && (Double.isNaN(d16) || Double.isInfinite(d16))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d16);
        }
        beforeValue();
        this.out.append((CharSequence) Double.toString(d16));
        return this;
    }

    public JsonWriter value(long j3) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(Long.toString(j3));
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        writeDeferredName();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.out.append((CharSequence) obj);
        return this;
    }
}
