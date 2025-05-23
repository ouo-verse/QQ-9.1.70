package com.tencent.luggage.wxa.uf;

import com.tencent.upload.report.UploadQualityReportBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends com.tencent.luggage.wxa.uf.a {
    public static final int CTRL_INDEX = 812;

    @NotNull
    public static final String NAME = "NFCConnect";

    /* renamed from: c, reason: collision with root package name */
    public static final b f142327c = new b(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f142328a = new a();

        public a() {
            super(3, com.tencent.luggage.wxa.vf.f.class, UploadQualityReportBuilder.STATE_CONNECT, "connect(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", 0);
        }

        public final void a(com.tencent.luggage.wxa.vf.f p06, String p16, Function1 p26) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            Intrinsics.checkNotNullParameter(p26, "p2");
            p06.b(p16, p26);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            a((com.tencent.luggage.wxa.vf.f) obj, (String) obj2, (Function1) obj3);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f() {
        super(a.f142328a);
    }
}
