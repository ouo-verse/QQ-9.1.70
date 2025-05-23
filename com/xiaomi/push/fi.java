package com.xiaomi.push;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.PrintStream;
import java.io.PrintWriter;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fi extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private fe f388878a;

    /* renamed from: a, reason: collision with other field name */
    private ff f24720a;

    /* renamed from: a, reason: collision with other field name */
    private Throwable f24721a;

    public fi() {
        this.f388878a = null;
        this.f24720a = null;
        this.f24721a = null;
    }

    public Throwable a() {
        return this.f24721a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        fe feVar;
        ff ffVar;
        String message = super.getMessage();
        if (message == null && (ffVar = this.f24720a) != null) {
            return ffVar.toString();
        }
        if (message == null && (feVar = this.f388878a) != null) {
            return feVar.toString();
        }
        return message;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb5.append(message);
            sb5.append(MsgSummary.STR_COLON);
        }
        ff ffVar = this.f24720a;
        if (ffVar != null) {
            sb5.append(ffVar);
        }
        fe feVar = this.f388878a;
        if (feVar != null) {
            sb5.append(feVar);
        }
        if (this.f24721a != null) {
            sb5.append("\n  -- caused by: ");
            sb5.append(this.f24721a);
        }
        return sb5.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f24721a != null) {
            printStream.println("Nested Exception: ");
            this.f24721a.printStackTrace(printStream);
        }
    }

    public fi(String str) {
        super(str);
        this.f388878a = null;
        this.f24720a = null;
        this.f24721a = null;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f24721a != null) {
            printWriter.println("Nested Exception: ");
            this.f24721a.printStackTrace(printWriter);
        }
    }

    public fi(Throwable th5) {
        this.f388878a = null;
        this.f24720a = null;
        this.f24721a = th5;
    }

    public fi(fe feVar) {
        this.f24720a = null;
        this.f24721a = null;
        this.f388878a = feVar;
    }

    public fi(String str, Throwable th5) {
        super(str);
        this.f388878a = null;
        this.f24720a = null;
        this.f24721a = th5;
    }
}
