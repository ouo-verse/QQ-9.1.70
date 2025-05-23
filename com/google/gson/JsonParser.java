package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* loaded from: classes2.dex */
public final class JsonParser {
    public JsonElement parse(String str) throws JsonSyntaxException {
        return parse(new StringReader(str));
    }

    public JsonElement parse(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement parse = parse(jsonReader);
            if (!parse.isJsonNull() && jsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return parse;
        } catch (MalformedJsonException e16) {
            throw new JsonSyntaxException(e16);
        } catch (IOException e17) {
            throw new JsonIOException(e17);
        } catch (NumberFormatException e18) {
            throw new JsonSyntaxException(e18);
        }
    }

    public JsonElement parse(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            try {
                return Streams.parse(jsonReader);
            } catch (OutOfMemoryError e16) {
                throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e16);
            } catch (StackOverflowError e17) {
                throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e17);
            }
        } finally {
            jsonReader.setLenient(isLenient);
        }
    }
}
