package com.google.gson;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class DefaultDateTypeAdapter extends TypeAdapter<Date> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final Class<? extends Date> dateType;
    private final DateFormat enUsFormat;
    private final DateFormat localFormat;

    DefaultDateTypeAdapter(Class<? extends Date> cls) {
        this(cls, DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    private Date deserializeToDate(String str) {
        Date parse;
        synchronized (this.localFormat) {
            try {
                try {
                    try {
                        parse = this.localFormat.parse(str);
                    } catch (ParseException unused) {
                        return this.enUsFormat.parse(str);
                    }
                } catch (ParseException unused2) {
                    return ISO8601Utils.parse(str, new ParsePosition(0));
                }
            } catch (ParseException e16) {
                throw new JsonSyntaxException(str, e16);
            }
        }
        return parse;
    }

    public String toString() {
        return SIMPLE_NAME + '(' + this.localFormat.getClass().getSimpleName() + ')';
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public Date read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        Date deserializeToDate = deserializeToDate(jsonReader.nextString());
        Class<? extends Date> cls = this.dateType;
        if (cls == Date.class) {
            return deserializeToDate;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(deserializeToDate.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(deserializeToDate.getTime());
        }
        throw new AssertionError();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this.localFormat) {
            jsonWriter.value(this.enUsFormat.format(date));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultDateTypeAdapter(Class<? extends Date> cls, String str) {
        this(cls, new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    DefaultDateTypeAdapter(Class<? extends Date> cls, int i3) {
        this(cls, DateFormat.getDateInstance(i3, Locale.US), DateFormat.getDateInstance(i3));
    }

    public DefaultDateTypeAdapter(int i3, int i16) {
        this((Class<? extends Date>) Date.class, DateFormat.getDateTimeInstance(i3, i16, Locale.US), DateFormat.getDateTimeInstance(i3, i16));
    }

    public DefaultDateTypeAdapter(Class<? extends Date> cls, int i3, int i16) {
        this(cls, DateFormat.getDateTimeInstance(i3, i16, Locale.US), DateFormat.getDateTimeInstance(i3, i16));
    }

    DefaultDateTypeAdapter(Class<? extends Date> cls, DateFormat dateFormat, DateFormat dateFormat2) {
        if (cls != Date.class && cls != java.sql.Date.class && cls != Timestamp.class) {
            throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
        }
        this.dateType = cls;
        this.enUsFormat = dateFormat;
        this.localFormat = dateFormat2;
    }
}
