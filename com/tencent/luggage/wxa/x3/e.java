package com.tencent.luggage.wxa.x3;

import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class e implements b {

    /* renamed from: e, reason: collision with root package name */
    public static final a f144563e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final g f144564b;

    /* renamed from: c, reason: collision with root package name */
    public final int f144565c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedList f144566d;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e(g sessionHolder) {
        Intrinsics.checkNotNullParameter(sessionHolder, "sessionHolder");
        this.f144564b = sessionHolder;
        this.f144565c = 1000;
        this.f144566d = new LinkedList();
    }

    @Override // com.tencent.luggage.wxa.x3.b
    public void a(d dVar) {
        h a16;
        if (dVar == null || dVar.a().isEmpty() || (a16 = this.f144564b.a()) == null) {
            return;
        }
        if (b()) {
            a();
            for (c cVar : dVar.a()) {
                a16.writeKvData(cVar.b(), cVar.c(), cVar.d(), cVar.f(), cVar.a(), cVar.e());
            }
            return;
        }
        synchronized (this.f144566d) {
            this.f144566d.addAll(dVar.a());
        }
    }

    public final boolean b() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.x3.h
    public void writeKvData(int i3, byte[] reportContent, boolean z16, int i16, boolean z17, int i17) {
        Intrinsics.checkNotNullParameter(reportContent, "reportContent");
        h a16 = this.f144564b.a();
        if (a16 == null) {
            return;
        }
        if (b()) {
            a();
            a16.writeKvData(i3, reportContent, z16, i16, z17, i17);
            return;
        }
        synchronized (this.f144566d) {
            this.f144566d.addLast(new c(i3, reportContent, z16, i16, z17, i17));
            if (this.f144566d.size() > this.f144565c) {
                this.f144566d.pollFirst();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.x3.a
    public void a() {
        LinkedList<c> linkedList;
        h a16 = this.f144564b.a();
        if (a16 == null) {
            return;
        }
        synchronized (this.f144566d) {
            linkedList = new LinkedList(this.f144566d);
            this.f144566d.clear();
            Unit unit = Unit.INSTANCE;
        }
        for (c cVar : linkedList) {
            a16.writeKvData(cVar.b(), cVar.c(), cVar.d(), cVar.f(), cVar.a(), cVar.e());
        }
    }
}
