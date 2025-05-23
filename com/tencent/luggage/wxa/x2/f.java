package com.tencent.luggage.wxa.x2;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.ic.v;
import com.tencent.luggage.wxa.kj.p;
import com.tencent.luggage.wxa.lo.i;
import com.tencent.luggage.wxa.ok.j;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0014J\b\u0010\f\u001a\u00020\u0002H\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/luggage/wxa/x2/f;", "Lcom/tencent/luggage/wxa/p5/f;", "", "l2", "Lcom/tencent/luggage/wxa/ok/j;", "r", "p0", "Lcom/tencent/luggage/wxa/kj/p;", "t", "Lcom/tencent/luggage/wxa/a6/a;", "m2", "S0", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/luggage/wxa/ic/v;", ParseCommon.CONTAINER, "<init>", "(Lcom/tencent/luggage/wxa/ic/v;)V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class f extends com.tencent.luggage.wxa.p5.f {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0004"}, d2 = {"com/tencent/luggage/wxa/x2/f$a", "Lcom/tencent/luggage/wxa/a6/a;", "", ExifInterface.LATITUDE_SOUTH, "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class a extends com.tencent.luggage.wxa.a6.a {
        public a(Class<e> cls) {
            super(cls);
        }

        @Override // com.tencent.luggage.wxa.r4.d, com.tencent.luggage.wxa.ic.l
        public boolean S() {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends g.x {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.ic.g.x
        public void c() {
            f.this.n2();
            d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull v container) {
        super(container);
        Intrinsics.checkNotNullParameter(container, "container");
    }

    public static final void b(f fVar) {
        fVar.D();
    }

    @Override // com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.ic.g
    public void S0() {
        super.S0();
        I().i();
    }

    @Override // com.tencent.luggage.wxa.p5.f
    public void l2() {
        b((g.x) new b());
    }

    @Override // com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.ic.g
    /* renamed from: m2, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.a6.a u() {
        return new a(e.class);
    }

    public final void n2() {
        com.tencent.luggage.wxa.j4.g a16 = c.f144546a.a(this);
        if (a16 == null) {
            b(this);
            return;
        }
        J().add(a16);
        com.tencent.luggage.wxa.fd.b a17 = com.tencent.luggage.wxa.fd.b.a(getAppId(), "{}", "{}", false, i.g());
        a17.S = S().f125813f;
        a(a17);
        a(new com.tencent.luggage.wxa.rj.c((com.tencent.luggage.wxa.ic.g) this, -1, true));
        b(true);
        j2();
    }

    @Override // com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.ic.g
    public j r() {
        j hVar;
        com.tencent.luggage.wxa.r5.a S = S();
        Intrinsics.checkNotNull(S, "null cannot be cast to non-null type com.tencent.luggage.jsapi.navigate.JsApiNavigateToMiniProgramBridged.BridgedRuntimeInitConfig");
        if (((d) S).v()) {
            Context L = L();
            if (L == null) {
                L = F();
            }
            hVar = new g(L);
        } else {
            Context L2 = L();
            if (L2 == null) {
                L2 = F();
            }
            hVar = new h(L2, this, null);
        }
        return hVar;
    }

    @Override // com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.ic.g
    public p t() {
        Context appContext = F();
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        return new com.tencent.luggage.wxa.x2.a(appContext, this);
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void p0() {
    }
}
