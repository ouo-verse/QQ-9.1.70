package com.tencent.luggage.wxa.x7;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.luggage.wxa.hn.v4;
import com.tencent.luggage.wxa.n3.r;
import com.tencent.luggage.wxa.n3.t;
import com.tencent.luggage.wxa.o3.e;
import com.tencent.luggage.wxa.o3.g;
import com.tencent.luggage.wxa.o3.l;
import com.tencent.luggage.wxa.p3.p;
import com.tencent.luggage.wxa.q7.s;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxaapi.TdiAuthErrCode;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.io.IOException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class g implements e.b {

    /* renamed from: e, reason: collision with root package name */
    public static final a f144625e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f144626a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxaapi.i f144627b;

    /* renamed from: c, reason: collision with root package name */
    public final String f144628c;

    /* renamed from: d, reason: collision with root package name */
    public e.c f144629d;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(byte[] tdiAuthBuffer, com.tencent.luggage.wxaapi.i iVar) {
            Intrinsics.checkNotNullParameter(tdiAuthBuffer, "tdiAuthBuffer");
            l.f136139a.a(new g(tdiAuthBuffer, iVar, null), null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f144630a;

        static {
            int[] iArr = new int[TdiAuthErrCode.values().length];
            iArr[TdiAuthErrCode.WechatTdi_Auth_Err_System.ordinal()] = 1;
            iArr[TdiAuthErrCode.WechatTdi_Auth_Err_InvalidArgs.ordinal()] = 2;
            f144630a = iArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v4 f144632b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f144633c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e.c f144634d;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f144635a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v4 f144636b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f144637c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(g gVar, v4 v4Var, String str) {
                super(1);
                this.f144635a = gVar;
                this.f144636b = v4Var;
                this.f144637c = str;
            }

            public final void a(t it) {
                Intrinsics.checkNotNullParameter(it, "it");
                w.d(this.f144635a.f144628c, "login() before invoke TdiApiProto.thirdAppLogin()");
                String str = this.f144636b.f128880d;
                Intrinsics.checkNotNullExpressionValue(str, "pb.ilink_auth_code");
                it.a(str, this.f144637c);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((t) obj);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class b extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f144638a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e.c f144639b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(g gVar, e.c cVar) {
                super(1);
                this.f144638a = gVar;
                this.f144639b = cVar;
            }

            public final void a(int i3) {
                w.d(this.f144638a.f144628c, "login() thirdAppLogin return errCode=" + i3);
                if (i3 == 0) {
                    t k3 = com.tencent.luggage.wxa.x7.a.f144602d.k();
                    Intrinsics.checkNotNull(k3);
                    r createCloneSession = k3.createCloneSession();
                    com.tencent.luggage.wxa.o3.j jVar = new com.tencent.luggage.wxa.o3.j();
                    s.d dVar = s.d.f138074a;
                    jVar.e(dVar.b());
                    jVar.b(new com.tencent.luggage.wxa.y8.h(createCloneSession.getUin()).a());
                    jVar.f("LoginByTdiCloneSession");
                    String d16 = w0.d("");
                    Intrinsics.checkNotNullExpressionValue(d16, "nullAsNil(\"\")");
                    jVar.c(d16);
                    jVar.a(Integer.MAX_VALUE);
                    dVar.a(createCloneSession.getUin());
                    ((com.tencent.luggage.wxa.p3.d) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.p3.d.class)).a(new p(createCloneSession));
                    this.f144639b.a(jVar);
                    g.a(this.f144638a, TdiAuthErrCode.WechatTdi_Auth_Err_OK, null, 2, null);
                    return;
                }
                this.f144638a.a(TdiAuthErrCode.WechatTdi_Auth_Err_NormalErr, "InternalError:" + i3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((Number) obj).intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(v4 v4Var, String str, e.c cVar) {
            super(1);
            this.f144632b = v4Var;
            this.f144633c = str;
            this.f144634d = cVar;
        }

        public final void a(boolean z16) {
            if (z16) {
                h.b(com.tencent.luggage.wxa.x7.a.f144602d, new a(g.this, this.f144632b, this.f144633c), new b(g.this, this.f144634d));
            } else {
                w.b(g.this.f144628c, "login failed by !deviceLoginOk");
                g.this.a(TdiAuthErrCode.WechatTdi_Auth_Err_System, "Inactivated");
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ g(byte[] bArr, com.tencent.luggage.wxaapi.i iVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, iVar);
    }

    public g(byte[] bArr, com.tencent.luggage.wxaapi.i iVar) {
        this.f144626a = bArr;
        this.f144627b = iVar;
        this.f144628c = "Luggage.LoginByWechatOpenSDKOauth[" + hashCode() + ']';
    }

    public final String a() {
        try {
            Cursor query = ContactsMonitor.query(z.c().getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/getWCProbeWaid"), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int columnIndex = query.getColumnIndex("waid");
                        if (columnIndex < 0) {
                            CloseableKt.closeFinally(query, null);
                            return null;
                        }
                        String string = query.getString(columnIndex);
                        CloseableKt.closeFinally(query, null);
                        return string;
                    }
                } finally {
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query, null);
        } catch (Throwable th5) {
            w.b(this.f144628c, "getWCProbeWaid() by provider failed by e:" + th5);
        }
        return null;
    }

    public static /* synthetic */ void a(g gVar, TdiAuthErrCode tdiAuthErrCode, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        gVar.a(tdiAuthErrCode, str);
    }

    public final void a(TdiAuthErrCode tdiAuthErrCode, String str) {
        int i3 = b.f144630a[tdiAuthErrCode.ordinal()];
        e.c cVar = null;
        if (i3 == 1) {
            e.c cVar2 = this.f144629d;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wxaAccountLoginCallback");
            } else {
                cVar = cVar2;
            }
            cVar.a(g.d.f136117j);
        } else if (i3 != 2) {
            e.c cVar3 = this.f144629d;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wxaAccountLoginCallback");
            } else {
                cVar = cVar3;
            }
            cVar.a(g.c.f136116j);
        } else {
            e.c cVar4 = this.f144629d;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wxaAccountLoginCallback");
            } else {
                cVar = cVar4;
            }
            cVar.a(g.b.f136115j);
        }
        w.d(this.f144628c, "END_CALL, errCode:" + tdiAuthErrCode + " tdiAuthErrMsg:" + str);
        com.tencent.luggage.wxaapi.i iVar = this.f144627b;
        if (iVar != null) {
            iVar.onAuthFinish(tdiAuthErrCode, str);
        }
    }

    @Override // com.tencent.luggage.wxa.o3.e.b
    public void a(e.c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f144629d = callback;
        try {
            v4 v4Var = new v4();
            v4Var.a(this.f144626a);
            String a16 = a();
            String str = this.f144628c;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("login with host_appid:");
            s.d dVar = s.d.f138074a;
            sb5.append(dVar.b());
            sb5.append(", ilink_appid:");
            sb5.append(v4Var.f128881e);
            sb5.append(", ilink_auth_code:");
            sb5.append(v4Var.f128880d);
            sb5.append(", lkid:");
            sb5.append(a16);
            w.d(str, sb5.toString());
            f fVar = f.f144620c;
            String b16 = dVar.b();
            String str2 = v4Var.f128881e;
            Intrinsics.checkNotNullExpressionValue(str2, "pb.ilink_appid");
            fVar.a(b16, str2);
            com.tencent.luggage.wxa.x7.a aVar = com.tencent.luggage.wxa.x7.a.f144602d;
            com.tencent.luggage.wxa.x7.a.a(aVar, false, false, 2, null);
            aVar.a(new c(v4Var, a16, callback));
        } catch (IOException e16) {
            w.b(this.f144628c, "login with invalid buffer, parse exception:" + e16);
            a(this, TdiAuthErrCode.WechatTdi_Auth_Err_InvalidArgs, null, 2, null);
        }
    }
}
