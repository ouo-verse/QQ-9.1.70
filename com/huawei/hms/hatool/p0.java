package com.huawei.hms.hatool;

import java.util.Calendar;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes2.dex */
public class p0 {

    /* renamed from: a, reason: collision with root package name */
    private long f37192a = 1800000;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f37193b = false;

    /* renamed from: c, reason: collision with root package name */
    private a f37194c = null;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class a {

        /* renamed from: a, reason: collision with root package name */
        String f37195a = UUID.randomUUID().toString().replace("-", "");

        /* renamed from: b, reason: collision with root package name */
        boolean f37196b;

        /* renamed from: c, reason: collision with root package name */
        private long f37197c;

        a(long j3) {
            this.f37195a += "_" + j3;
            this.f37197c = j3;
            this.f37196b = true;
            p0.this.f37193b = false;
        }

        private void b(long j3) {
            v.c("hmsSdk", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.f37195a = uuid;
            this.f37195a = uuid.replace("-", "");
            this.f37195a += "_" + j3;
            this.f37197c = j3;
            this.f37196b = true;
        }

        void a(long j3) {
            if (p0.this.f37193b) {
                p0.this.f37193b = false;
                b(j3);
            } else if (b(this.f37197c, j3) || a(this.f37197c, j3)) {
                b(j3);
            } else {
                this.f37197c = j3;
                this.f37196b = false;
            }
        }

        private boolean a(long j3, long j16) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j3);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j16);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        private boolean b(long j3, long j16) {
            return j16 - j3 >= p0.this.f37192a;
        }
    }

    public String a() {
        a aVar = this.f37194c;
        if (aVar != null) {
            return aVar.f37195a;
        }
        v.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j3) {
        a aVar = this.f37194c;
        if (aVar != null) {
            aVar.a(j3);
        } else {
            v.c("hmsSdk", "Session is first flush");
            this.f37194c = new a(j3);
        }
    }

    public boolean b() {
        a aVar = this.f37194c;
        if (aVar != null) {
            return aVar.f37196b;
        }
        v.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
