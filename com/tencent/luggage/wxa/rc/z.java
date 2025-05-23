package com.tencent.luggage.wxa.rc;

import com.tencent.luggage.wxa.rc.r;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;

/* compiled from: P */
/* loaded from: classes8.dex */
public class z extends FileStructStat implements r.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f139590a;

    public z(String str) {
        this.f139590a = str;
    }

    @Override // com.tencent.luggage.wxa.rc.r.a
    public String a() {
        return this.f139590a;
    }

    @Override // com.tencent.luggage.wxa.rc.r.a
    public long b() {
        return this.st_size;
    }

    @Override // com.tencent.luggage.wxa.rc.r.a
    public long lastModified() {
        return this.st_mtime;
    }
}
