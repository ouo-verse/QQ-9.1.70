package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(String str) {
        this(new StringReader(str));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z16;
        synchronized (this.lock) {
            try {
                try {
                    try {
                        if (this.parser.peek() != JsonToken.END_DOCUMENT) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                    } catch (MalformedJsonException e16) {
                        throw new JsonSyntaxException(e16);
                    }
                } catch (IOException e17) {
                    throw new JsonIOException(e17);
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        return z16;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public JsonStreamParser(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        this.lock = new Object();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public JsonElement next() throws JsonParseException {
        if (hasNext()) {
            try {
                return Streams.parse(this.parser);
            } catch (JsonParseException e16) {
                if (e16.getCause() instanceof EOFException) {
                    throw new NoSuchElementException();
                }
                throw e16;
            } catch (OutOfMemoryError e17) {
                throw new JsonParseException("Failed parsing JSON source to Json", e17);
            } catch (StackOverflowError e18) {
                throw new JsonParseException("Failed parsing JSON source to Json", e18);
            }
        }
        throw new NoSuchElementException();
    }
}
