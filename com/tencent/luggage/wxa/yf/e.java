package com.tencent.luggage.wxa.yf;

import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class e extends com.tencent.luggage.wxa.xd.a {

    @Deprecated
    public static final int CTRL_INDEX = 578;

    @Deprecated
    @NotNull
    public static final String NAME = "hideNavigationBar";

    /* renamed from: a, reason: collision with root package name */
    public static final a f145652a = new a(null);

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
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f145653a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145654b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f145655c;

        public b(com.tencent.luggage.wxa.ic.d dVar, int i3, e eVar) {
            this.f145653a = dVar;
            this.f145654b = i3;
            this.f145655c = eVar;
        }

        public static final void a(com.tencent.luggage.wxa.ic.d dVar, int i3, e eVar) {
            dVar.a(i3, eVar.makeReturnJson("fail:page don't exist"));
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.luggage.wxa.kj.v vVar;
            com.tencent.luggage.wxa.ic.d dVar = this.f145653a;
            if (dVar instanceof com.tencent.luggage.wxa.kj.v) {
                vVar = (com.tencent.luggage.wxa.kj.v) dVar;
            } else if (dVar instanceof com.tencent.luggage.wxa.ic.l) {
                vVar = ((com.tencent.luggage.wxa.ic.l) dVar).J();
            } else {
                vVar = null;
            }
            if (vVar == null) {
                a(this.f145653a, this.f145654b, this.f145655c);
            } else {
                vVar.F0();
                this.f145653a.a(this.f145654b, this.f145655c.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
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
