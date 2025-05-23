package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.Service;
import java.util.logging.Logger;

/* compiled from: P */
@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class a implements Service {

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f35161b = Logger.getLogger(a.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final Service f35162a = new C0247a();

    /* compiled from: P */
    /* renamed from: com.google.common.util.concurrent.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0247a extends e {
        C0247a() {
        }

        @Override // com.google.common.util.concurrent.e
        protected void c() {
            a.this.f();
        }

        public String toString() {
            return a.this.toString();
        }
    }

    protected a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b() throws Exception;

    protected String c() {
        return getClass().getSimpleName();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.f35162a.state();
    }

    public String toString() {
        return c() + " [" + state() + "]";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() throws Exception {
    }

    protected void f() {
    }
}
