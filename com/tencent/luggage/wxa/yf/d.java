package com.tencent.luggage.wxa.yf;

import com.tencent.luggage.wxa.xd.o1;
import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d extends com.tencent.luggage.wxa.xd.a {

    @Deprecated
    public static final int CTRL_INDEX = 684;

    @Deprecated
    @NotNull
    public static final String NAME = "hideHomeButton";

    /* renamed from: a, reason: collision with root package name */
    public static final a f145643a = new a(null);

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
        public final /* synthetic */ com.tencent.luggage.wxa.kj.v f145644a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f145645b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f145646c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f145647d;

        public b(com.tencent.luggage.wxa.kj.v vVar, com.tencent.luggage.wxa.ic.d dVar, int i3, d dVar2) {
            this.f145644a = vVar;
            this.f145645b = dVar;
            this.f145646c = i3;
            this.f145647d = dVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f145644a.W() == null) {
                this.f145644a.h1();
            } else {
                this.f145644a.E0();
            }
            com.tencent.luggage.wxa.ic.d dVar = this.f145645b;
            Intrinsics.checkNotNull(dVar);
            dVar.a(this.f145646c, this.f145647d.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.kj.v a16 = o1.a(dVar);
        if (a16 == null) {
            Intrinsics.checkNotNull(dVar);
            dVar.a(i3, makeReturnJson("fail:page don't exist"));
        } else {
            com.tencent.luggage.wxa.zp.h.f146825d.a(new b(a16, dVar, i3, this));
        }
    }
}
