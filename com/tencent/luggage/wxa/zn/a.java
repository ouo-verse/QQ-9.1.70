package com.tencent.luggage.wxa.zn;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static final C6993a f146756b = new C6993a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final a f146757c = new a("NO_CHANGE");

    /* renamed from: d, reason: collision with root package name */
    public static final a f146758d = new a("INSERT");

    /* renamed from: e, reason: collision with root package name */
    public static final a f146759e = new a(QzoneDataUpdateAction.UPDATE);

    /* renamed from: f, reason: collision with root package name */
    public static final a f146760f = new a("DELETE");

    /* renamed from: g, reason: collision with root package name */
    public static final a f146761g = new a("BATCH");

    /* renamed from: a, reason: collision with root package name */
    public final String f146762a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.zn.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6993a {
        public C6993a() {
        }

        public /* synthetic */ C6993a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            return a.f146761g;
        }

        public final a b() {
            return a.f146760f;
        }

        public final a c() {
            return a.f146758d;
        }

        public final a d() {
            return a.f146757c;
        }

        public final a e() {
            return a.f146759e;
        }
    }

    public a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f146762a = name;
    }

    public String toString() {
        return this.f146762a;
    }
}
