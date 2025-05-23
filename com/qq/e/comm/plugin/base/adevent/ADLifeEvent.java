package com.qq.e.comm.plugin.base.adevent;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ADLifeEvent {

    /* renamed from: a, reason: collision with root package name */
    private final String f39162a;

    /* renamed from: b, reason: collision with root package name */
    private final JSONObject f39163b;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ADLifeEventType {
    }

    public ADLifeEvent(String str, JSONObject jSONObject) {
        this.f39162a = str;
        this.f39163b = jSONObject;
    }

    public String a() {
        return this.f39162a;
    }

    public String toString() {
        return "event<" + this.f39162a + "," + this.f39163b + ">";
    }
}
