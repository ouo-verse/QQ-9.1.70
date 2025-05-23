package com.airbnb.lottie.parser.moshi;

import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class JsonReader implements Closeable {
    private static final String[] REPLACEMENT_CHARS = new String[128];
    boolean failOnUnknown;
    boolean lenient;
    int stackSize;
    int[] scopes = new int[32];
    String[] pathNames = new String[32];
    int[] pathIndices = new int[32];

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class Options {
        final okio.Options doubleQuoteSuffix;
        final String[] strings;

        Options(String[] strArr, okio.Options options) {
            this.strings = strArr;
            this.doubleQuoteSuffix = options;
        }

        public static Options of(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    JsonReader.string(buffer, strArr[i3]);
                    buffer.readByte();
                    byteStringArr[i3] = buffer.readByteString();
                }
                return new Options((String[]) strArr.clone(), okio.Options.of(byteStringArr));
            } catch (IOException e16) {
                throw new AssertionError(e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

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
    }

    public static JsonReader of(BufferedSource bufferedSource) {
        return new JsonUtf8Reader(bufferedSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void string(BufferedSink bufferedSink, String str) throws IOException {
        String str2;
        String[] strArr = REPLACEMENT_CHARS;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            char charAt = str.charAt(i16);
            if (charAt < '\u0080') {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
                if (i3 < i16) {
                    bufferedSink.writeUtf8(str, i3, i16);
                }
                bufferedSink.writeUtf8(str2);
                i3 = i16 + 1;
            } else {
                if (charAt == '\u2028') {
                    str2 = "\\u2028";
                } else if (charAt == '\u2029') {
                    str2 = "\\u2029";
                }
                if (i3 < i16) {
                }
                bufferedSink.writeUtf8(str2);
                i3 = i16 + 1;
            }
        }
        if (i3 < length) {
            bufferedSink.writeUtf8(str, i3, length);
        }
        bufferedSink.writeByte(34);
    }

    public abstract void beginArray() throws IOException;

    public abstract void beginObject() throws IOException;

    public abstract void endArray() throws IOException;

    public abstract void endObject() throws IOException;

    public final String getPath() {
        return JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices);
    }

    public abstract boolean hasNext() throws IOException;

    public abstract boolean nextBoolean() throws IOException;

    public abstract double nextDouble() throws IOException;

    public abstract int nextInt() throws IOException;

    public abstract String nextName() throws IOException;

    public abstract String nextString() throws IOException;

    public abstract Token peek() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void pushScope(int i3) {
        int i16 = this.stackSize;
        int[] iArr = this.scopes;
        if (i16 == iArr.length) {
            if (i16 != 256) {
                this.scopes = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.pathNames;
                this.pathNames = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.pathIndices;
                this.pathIndices = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.scopes;
        int i17 = this.stackSize;
        this.stackSize = i17 + 1;
        iArr3[i17] = i3;
    }

    public abstract int selectName(Options options) throws IOException;

    public abstract void skipName() throws IOException;

    public abstract void skipValue() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JsonEncodingException syntaxError(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }
}
