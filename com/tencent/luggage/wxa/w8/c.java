package com.tencent.luggage.wxa.w8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final List f144114a = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f144115a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function1 function1) {
            super(1);
            this.f144115a = function1;
        }

        public final void a(Object obj) {
            try {
                this.f144115a.invoke(obj);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.p8.f.a("MagicBrush", e16, "dispatch failed", new Object[0]);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return Unit.INSTANCE;
        }
    }

    public final List a(Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ArrayList arrayList = new ArrayList();
        synchronized (this.f144114a) {
            Iterator it = this.f144114a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            Unit unit = Unit.INSTANCE;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(block.invoke(it5.next()));
        }
        return arrayList2;
    }

    public final void b(Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        a((Function1) new a(block));
    }

    public final void b(Object obj) {
        synchronized (this.f144114a) {
            this.f144114a.remove(obj);
        }
    }

    public final void a(Object obj) {
        synchronized (this.f144114a) {
            this.f144114a.add(obj);
        }
    }

    public final void a() {
        synchronized (this.f144114a) {
            this.f144114a.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
