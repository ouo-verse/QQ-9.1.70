package com.tencent.luggage.wxa.yf;

import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class i0 extends com.tencent.luggage.wxa.xd.a {

    @Deprecated
    public static final int CTRL_INDEX = 577;

    @Deprecated
    @NotNull
    public static final String NAME = "showNavigationBar";

    /* renamed from: a, reason: collision with root package name */
    public static final a f145703a = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f145704a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145705b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i0 f145706c;

        public b(com.tencent.luggage.wxa.ic.d dVar, int i3, i0 i0Var) {
            this.f145704a = dVar;
            this.f145705b = i3;
            this.f145706c = i0Var;
        }

        public static final void a(com.tencent.luggage.wxa.ic.d dVar, int i3, i0 i0Var) {
            dVar.a(i3, i0Var.makeReturnJson("fail:page don't exist"));
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.luggage.wxa.kj.v vVar;
            com.tencent.luggage.wxa.ic.d dVar = this.f145704a;
            if (dVar instanceof com.tencent.luggage.wxa.kj.v) {
                vVar = (com.tencent.luggage.wxa.kj.v) dVar;
            } else if (dVar instanceof com.tencent.luggage.wxa.ic.l) {
                vVar = ((com.tencent.luggage.wxa.ic.l) dVar).J();
            } else {
                vVar = null;
            }
            if (vVar == null) {
                a(this.f145704a, this.f145705b, this.f145706c);
            } else {
                vVar.n1();
                this.f145704a.a(this.f145705b, this.f145706c.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        if (dVar == null) {
            return;
        }
        b bVar = new b(dVar, i3, this);
        if (!(dVar instanceof com.tencent.luggage.wxa.kj.v) && dVar.getRuntime().m1()) {
            dVar.getRuntime().c(bVar);
        } else {
            bVar.run();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }
}
