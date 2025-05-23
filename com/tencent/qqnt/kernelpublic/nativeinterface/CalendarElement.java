package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CalendarElement implements Serializable {
    public long expireTimeMs;

    /* renamed from: msg, reason: collision with root package name */
    public String f359317msg;
    public String schema;
    public int schemaType;
    long serialVersionUID;
    public String summary;

    public CalendarElement() {
        this.serialVersionUID = 1L;
        this.summary = "";
        this.f359317msg = "";
        this.schema = "";
    }

    public long getExpireTimeMs() {
        return this.expireTimeMs;
    }

    public String getMsg() {
        return this.f359317msg;
    }

    public String getSchema() {
        return this.schema;
    }

    public int getSchemaType() {
        return this.schemaType;
    }

    public String getSummary() {
        return this.summary;
    }

    public String toString() {
        return "CalendarElement{summary=" + this.summary + ",msg=" + this.f359317msg + ",expireTimeMs=" + this.expireTimeMs + ",schemaType=" + this.schemaType + ",schema=" + this.schema + ",}";
    }

    public CalendarElement(String str, String str2, long j3, int i3, String str3) {
        this.serialVersionUID = 1L;
        this.summary = str;
        this.f359317msg = str2;
        this.expireTimeMs = j3;
        this.schemaType = i3;
        this.schema = str3;
    }
}
