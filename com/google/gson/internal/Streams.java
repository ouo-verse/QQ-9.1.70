package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Streams {
    Streams() {
        throw new UnsupportedOperationException();
    }

    public static JsonElement parse(JsonReader jsonReader) throws JsonParseException {
        boolean z16;
        try {
            try {
                jsonReader.peek();
                z16 = false;
                try {
                    return TypeAdapters.JSON_ELEMENT.read2(jsonReader);
                } catch (EOFException e16) {
                    e = e16;
                    if (z16) {
                        return JsonNull.INSTANCE;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (MalformedJsonException e17) {
                throw new JsonSyntaxException(e17);
            } catch (IOException e18) {
                throw new JsonIOException(e18);
            } catch (NumberFormatException e19) {
                throw new JsonSyntaxException(e19);
            }
        } catch (EOFException e26) {
            e = e26;
            z16 = true;
        }
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new AppendableWriter(appendable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class AppendableWriter extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite = new CurrentWrite();

        /* compiled from: P */
        /* loaded from: classes2.dex */
        static class CurrentWrite implements CharSequence {
            char[] chars;

            CurrentWrite() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i3) {
                return this.chars[i3];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.chars.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i3, int i16) {
                return new String(this.chars, i3, i16 - i3);
            }
        }

        AppendableWriter(Appendable appendable) {
            this.appendable = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i3, int i16) throws IOException {
            CurrentWrite currentWrite = this.currentWrite;
            currentWrite.chars = cArr;
            this.appendable.append(currentWrite, i3, i16 + i3);
        }

        @Override // java.io.Writer
        public void write(int i3) throws IOException {
            this.appendable.append((char) i3);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }
    }
}
