package com.tencent.luggage.wxa.t6;

import com.tencent.luggage.wxa.ic.u;
import com.tencent.luggage.wxa.q7.y;
import com.tencent.luggage.wxa.tn.z;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@com.tencent.luggage.wxa.fo.b
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/luggage/wxa/t6/c;", "Lcom/tencent/luggage/wxa/eo/d;", "Lcom/tencent/luggage/wxa/ic/u;", "", "J", "", "I", "Lcom/tencent/luggage/wxa/ic/u$a;", "callback", "a", "v", "<init>", "()V", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.eo.d implements u {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u.a f140868a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u.a aVar) {
            super(0);
            this.f140868a = aVar;
        }

        public final void a() {
            u.a aVar = this.f140868a;
            if (aVar != null) {
                aVar.onSuccess();
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.ic.u
    public boolean I() {
        return y.f138216a.j();
    }

    @Override // com.tencent.luggage.wxa.ic.u
    public void J() {
        if (z.m()) {
            com.tencent.luggage.wxa.u6.a.f142122a.b();
        }
    }

    @Override // com.tencent.luggage.wxa.ic.u
    public void a(u.a callback) {
        y.f138216a.a(new a(callback));
    }

    @Override // com.tencent.luggage.wxa.ic.u
    public boolean v() {
        return false;
    }
}
