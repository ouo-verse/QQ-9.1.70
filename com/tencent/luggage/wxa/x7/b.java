package com.tencent.luggage.wxa.x7;

import android.content.Context;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.luggage.wxa.n3.t;
import com.tencent.luggage.wxa.s3.h;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@com.tencent.luggage.wxa.fo.b
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0097\u0001J\u0011\u0010\u000b\u001a\n \u0004*\u0004\u0018\u00010\n0\nH\u0096\u0001J\t\u0010\f\u001a\u00020\u0006H\u0096\u0001J\t\u0010\u000e\u001a\u00020\rH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u0011\u001a\n \u0004*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\u0019\u0010\u0012\u001a\u00020\r2\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u0096\u0001J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/luggage/wxa/x7/b;", "Lcom/tencent/luggage/wxa/eo/d;", "Lcom/tencent/luggage/wxa/s3/c;", "Lcom/tencent/luggage/wxa/n3/t$a;", "kotlin.jvm.PlatformType", "p0", "", "a", "Lcom/tencent/luggage/wxa/s3/g;", "p", "Lcom/tencent/luggage/wxa/n3/t;", "k", "B", "", "init", "g", "Lcom/tencent/luggage/wxa/s3/h$d;", UserInfo.SEX_FEMALE, "b", "Landroid/content/Context;", "context", DomainData.DOMAIN_NAME, "<init>", "()V", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class b extends com.tencent.luggage.wxa.eo.d implements com.tencent.luggage.wxa.s3.c {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ a f144611h = a.f144602d;

    @Override // com.tencent.luggage.wxa.s3.c
    public boolean B() {
        return this.f144611h.B();
    }

    @Override // com.tencent.luggage.wxa.s3.c
    public h.d F() {
        return this.f144611h.F();
    }

    @Override // com.tencent.luggage.wxa.s3.c
    public boolean a(t.a p06) {
        a aVar = this.f144611h;
        Intrinsics.checkNotNullExpressionValue(p06, "addTdiSessionCallback(...)");
        return aVar.a(p06);
    }

    @Override // com.tencent.luggage.wxa.s3.c
    public void b(t.a p06) {
        a aVar = this.f144611h;
        Intrinsics.checkNotNullExpressionValue(p06, "removeTdiSessionCallback(...)");
        aVar.b(p06);
    }

    @Override // com.tencent.luggage.wxa.s3.c
    public boolean g() {
        return this.f144611h.g();
    }

    @Override // com.tencent.luggage.wxa.s3.c
    public void init() {
        this.f144611h.init();
    }

    @Override // com.tencent.luggage.wxa.s3.c
    public t k() {
        return this.f144611h.k();
    }

    @Override // com.tencent.luggage.wxa.eo.d
    public void n(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.n(context);
        init();
    }

    @Override // com.tencent.luggage.wxa.s3.c
    public com.tencent.luggage.wxa.s3.g p() {
        return this.f144611h.p();
    }
}
