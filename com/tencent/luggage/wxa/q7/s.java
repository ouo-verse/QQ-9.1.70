package com.tencent.luggage.wxa.q7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.luggage.wxa.fk.a;
import com.tencent.luggage.wxa.gk.a;
import com.tencent.luggage.wxa.n3.q0;
import com.tencent.luggage.wxa.tn.r0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.l0;
import com.tencent.luggage.wxa.v3.f;
import com.tencent.luggage.wxa.v7.h;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.luggage.wxa.z4.f;
import com.tencent.luggage.wxaapi.InitDynamicPkgResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppWithShortLinkResult;
import com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResult;
import com.tencent.luggage.wxaapi.TdiAuthErrCode;
import com.tencent.luggage.wxaapi.TdiAuthState;
import com.tencent.luggage.wxaapi.UploadLogResultCode;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate;
import com.tencent.luggage.wxaapi.WxaExtendApiJSBridge;
import com.tencent.luggage.wxaapi.WxaPrefetchApi;
import com.tencent.luggage.wxaapi.internal.WxaBackgroundAudioApiImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendTdiAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt__CharJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.api.ProcessConstant;
import oicq.wlogin_sdk.tools.util;
import org.apache.commons.lang.StringUtils;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class s implements WxaApi {

    /* renamed from: j, reason: collision with root package name */
    public static final c f138054j = new c(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f138055a;

    /* renamed from: b, reason: collision with root package name */
    public final int f138056b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f138057c;

    /* renamed from: d, reason: collision with root package name */
    public final IWXAPI f138058d;

    /* renamed from: e, reason: collision with root package name */
    public final Lazy f138059e;

    /* renamed from: f, reason: collision with root package name */
    public final Lazy f138060f;

    /* renamed from: g, reason: collision with root package name */
    public final Lazy f138061g;

    /* renamed from: h, reason: collision with root package name */
    public WxaAppCustomActionSheetDelegate f138062h;

    /* renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap f138063i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements f.c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f138064a = new a();

        @Override // com.tencent.luggage.wxa.v3.f.c
        public final String a(BaseResp baseResp) {
            if (baseResp instanceof WXLaunchWxaRedirectingPage.Resp) {
                return ((WXLaunchWxaRedirectingPage.Resp) baseResp).invokeTicket;
            }
            return "";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a0 extends Lambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f138065a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f138066b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f138067c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxaapi.j f138068d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxaapi.j f138069a;

            public a(com.tencent.luggage.wxaapi.j jVar) {
                this.f138069a = jVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxaapi.j jVar = this.f138069a;
                if (jVar != null) {
                    jVar.a(UploadLogResultCode.Fail);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(int i3, int i16, Ref.BooleanRef booleanRef, com.tencent.luggage.wxaapi.j jVar) {
            super(2);
            this.f138065a = i3;
            this.f138066b = i16;
            this.f138067c = booleanRef;
            this.f138068d = jVar;
        }

        public final void a(boolean z16, String str) {
            com.tencent.luggage.wxa.n3.t tVar;
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "requestUploadLogFiles, waitForUserLoginDone, get bool:" + z16 + ", str:" + str);
            if (z16) {
                try {
                    tVar = com.tencent.luggage.wxa.x7.a.f144602d.k();
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "requestUploadLogFiles, get tdiSession, exception=" + e16);
                    tVar = null;
                }
                if (tVar != null) {
                    int i3 = this.f138065a;
                    int i16 = this.f138066b;
                    Ref.BooleanRef booleanRef = this.f138067c;
                    com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "requestUploadLogFiles impl");
                    tVar.requestUploadLogfiles(i3, i16);
                    booleanRef.element = true;
                    return;
                }
                return;
            }
            com.tencent.luggage.wxa.tn.c0.a(new a(this.f138068d));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Boolean) obj).booleanValue(), (String) obj2);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxaapi.i f138070a;

        /* renamed from: b, reason: collision with root package name */
        public final IWXAPIEventHandler f138071b;

        public b(com.tencent.luggage.wxaapi.i iVar, IWXAPIEventHandler iWXAPIEventHandler) {
            this.f138070a = iVar;
            this.f138071b = iWXAPIEventHandler;
        }

        public final com.tencent.luggage.wxaapi.i a() {
            return this.f138070a;
        }

        public final IWXAPIEventHandler b() {
            return this.f138071b;
        }

        public /* synthetic */ b(com.tencent.luggage.wxaapi.i iVar, IWXAPIEventHandler iWXAPIEventHandler, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(iVar, (i3 & 2) != 0 ? null : iWXAPIEventHandler);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b0 implements com.tencent.luggage.wxaapi.i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxaapi.i f138072a;

        public b0(com.tencent.luggage.wxaapi.i iVar) {
            this.f138072a = iVar;
        }

        @Override // com.tencent.luggage.wxaapi.i
        public final void onAuthFinish(TdiAuthErrCode authErrCode, String str) {
            Intrinsics.checkNotNullParameter(authErrCode, "authErrCode");
            if (authErrCode != TdiAuthErrCode.WechatTdi_Auth_Err_OK) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "sendAuth: fail: [%s, %s]", authErrCode.name(), str);
            } else {
                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "sendAuth:: success");
            }
            com.tencent.luggage.wxaapi.i iVar = this.f138072a;
            if (iVar != null) {
                iVar.onAuthFinish(authErrCode, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c0 implements com.tencent.luggage.wxaapi.i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxaapi.i f138073a;

        public c0(com.tencent.luggage.wxaapi.i iVar) {
            this.f138073a = iVar;
        }

        @Override // com.tencent.luggage.wxaapi.i
        public final void onAuthFinish(TdiAuthErrCode authErrCode, String str) {
            Intrinsics.checkNotNullParameter(authErrCode, "authErrCode");
            if (authErrCode != TdiAuthErrCode.WechatTdi_Auth_Err_OK) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "sendCombineAuth: fail: [%s, %s]", authErrCode.name(), str);
            } else {
                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "sendCombineAuth success");
            }
            com.tencent.luggage.wxaapi.i iVar = this.f138073a;
            if (iVar != null) {
                iVar.onAuthFinish(authErrCode, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f138078a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f138079b;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.n3.c0.values().length];
            iArr[com.tencent.luggage.wxa.n3.c0.LOGIN_SUCCESS.ordinal()] = 1;
            iArr[com.tencent.luggage.wxa.n3.c0.REQUIRE_AUTO_LOGIN.ordinal()] = 2;
            iArr[com.tencent.luggage.wxa.n3.c0.LOGIN_UNKNOWN.ordinal()] = 3;
            f138078a = iArr;
            int[] iArr2 = new int[com.tencent.luggage.wxa.fk.c.values().length];
            iArr2[com.tencent.luggage.wxa.fk.c.SUCCESS.ordinal()] = 1;
            iArr2[com.tencent.luggage.wxa.fk.c.ILLEGAL_LINK.ordinal()] = 2;
            iArr2[com.tencent.luggage.wxa.fk.c.DECODE_LINK_FAIL.ordinal()] = 3;
            iArr2[com.tencent.luggage.wxa.fk.c.USER_CANCEL.ordinal()] = 4;
            iArr2[com.tencent.luggage.wxa.fk.c.CONTEXT_RELEASE.ordinal()] = 5;
            iArr2[com.tencent.luggage.wxa.fk.c.INTERRUPT.ordinal()] = 6;
            iArr2[com.tencent.luggage.wxa.fk.c.LAUNCH_PHASE_FAIL.ordinal()] = 7;
            f138079b = iArr2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public static final f f138080a = new f();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.e {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f138081a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f138082b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f138083c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ boolean f138084d;

            public a(String str, String str2, int i3, boolean z16) {
                this.f138081a = str;
                this.f138082b = str2;
                this.f138083c = i3;
                this.f138084d = z16;
            }

            @Override // com.tencent.luggage.wxa.jq.e
            public boolean a() {
                return false;
            }

            @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
            public String getKey() {
                return "";
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.luggage.wxa.f7.a aVar = new com.tencent.luggage.wxa.f7.a(null, null, 0, null, 0, null, 0L, 0, 255, null);
                    String str = this.f138082b;
                    int i3 = this.f138083c;
                    String str2 = this.f138081a;
                    boolean z16 = this.f138084d;
                    d dVar = d.f138074a;
                    aVar.c(dVar.b());
                    aVar.e(str);
                    aVar.a(i3 + 1);
                    aVar.b(str2);
                    aVar.c(z16 ? 1 : 0);
                    aVar.d(com.tencent.luggage.wxa.tn.z.h());
                    aVar.a(dVar.c());
                    aVar.b(603979777);
                    aVar.c();
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "reportCallApi, name:" + this.f138081a + ", get exception:" + e16);
                }
            }
        }

        public static /* synthetic */ void a(f fVar, String str, boolean z16, String str2, int i3, int i16, Object obj) {
            if ((i16 & 4) != 0) {
                str2 = null;
            }
            if ((i16 & 8) != 0) {
                i3 = 0;
            }
            fVar.a(str, z16, str2, i3);
        }

        public final void a(String name, boolean z16, String str, int i3) {
            Intrinsics.checkNotNullParameter(name, "name");
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "reportCallApi, name:" + name + ", isSuccess:" + z16 + ", wxaAppID:" + str + ", wxaAppVersionType:" + i3);
            com.tencent.luggage.wxa.zp.h.f146825d.b(new a(name, str, i3, z16), "WxaApiUtils.reportCallApi");
        }

        public final long a() {
            return com.tencent.luggage.wxa.m3.a.f134071a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxaapi.h f138086b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s f138087a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxaapi.h f138088b;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.q7.s$g$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6628a extends SuspendLambda implements Function2 {

                /* renamed from: a, reason: collision with root package name */
                public int f138089a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxaapi.h f138090b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ s f138091c;

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.q7.s$g$a$a$a, reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public static final class C6629a extends SuspendLambda implements Function2 {

                    /* renamed from: a, reason: collision with root package name */
                    public int f138092a;

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ s f138093b;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C6629a(s sVar, Continuation continuation) {
                        super(2, continuation);
                        this.f138093b = sVar;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                        return ((C6629a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new C6629a(this.f138093b, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.f138092a;
                        if (i3 != 0) {
                            if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            s sVar = this.f138093b;
                            this.f138092a = 1;
                            obj = sVar.a(this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return obj;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C6628a(com.tencent.luggage.wxaapi.h hVar, s sVar, Continuation continuation) {
                    super(2, continuation);
                    this.f138090b = hVar;
                    this.f138091c = sVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((C6628a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new C6628a(this.f138090b, this.f138091c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.f138089a;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
                        C6629a c6629a = new C6629a(this.f138091c, null);
                        this.f138089a = 1;
                        obj = BuildersKt.withContext(coroutineDispatcher, c6629a, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    TdiAuthState tdiAuthState = (TdiAuthState) obj;
                    com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "checkAuthState " + tdiAuthState);
                    com.tencent.luggage.wxaapi.h hVar = this.f138090b;
                    if (hVar != null) {
                        hVar.onStateChecked(tdiAuthState, null);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(s sVar, com.tencent.luggage.wxaapi.h hVar) {
                super(1);
                this.f138087a = sVar;
                this.f138088b = hVar;
            }

            public final void a(boolean z16) {
                BuildersKt__Builders_commonKt.launch$default(this.f138087a.a(), null, null, new C6628a(this.f138088b, this.f138087a, null), 3, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(com.tencent.luggage.wxaapi.h hVar) {
            super(0);
            this.f138086b = hVar;
        }

        public final void a() {
            com.tencent.luggage.wxa.x7.a.f144602d.a(new a(s.this, this.f138086b));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends Lambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f138094a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Continuation continuation) {
            super(2);
            this.f138094a = continuation;
        }

        public final void a(boolean z16, String str) {
            TdiAuthState tdiAuthState;
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "checkAuthStateSuspended()-waitForUserLoginDone, get bool:" + z16 + ", str:" + str);
            Continuation continuation = this.f138094a;
            Result.Companion companion = Result.INSTANCE;
            if (z16) {
                tdiAuthState = TdiAuthState.WechatTdi_Auth_State_OK;
            } else {
                tdiAuthState = TdiAuthState.WechatTdi_Auth_State_NoAuth;
            }
            continuation.resumeWith(Result.m476constructorimpl(tdiAuthState));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Boolean) obj).booleanValue(), (String) obj2);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final i f138095a = new i();

        public i() {
            super(0);
        }

        public final void a() {
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "clearAuth success");
            com.tencent.luggage.wxa.x7.a.f144602d.b(true, true);
            Unit unit = Unit.INSTANCE;
            f.a(f.f138080a, "clearAuth", true, null, 0, 12, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final j f138096a = new j();

        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineScope invoke() {
            return CoroutineScopeKt.MainScope();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class l implements com.tencent.luggage.wxaapi.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxaapi.d f138099a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f138100b;

        public l(com.tencent.luggage.wxaapi.d dVar, String str) {
            this.f138099a = dVar;
            this.f138100b = str;
        }

        @Override // com.tencent.luggage.wxaapi.d
        public final void onLaunchResult(String str, int i3, long j3, LaunchWxaAppResult launchWxaAppResult) {
            boolean z16;
            if (str != null) {
                com.tencent.luggage.wxa.q7.u.f138189a.a(str);
            }
            com.tencent.luggage.wxaapi.d dVar = this.f138099a;
            if (dVar != null) {
                dVar.onLaunchResult(str, i3, j3, launchWxaAppResult);
            }
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "launchByQRCodeRawData, onLaunchResult:" + launchWxaAppResult + ", codeRawData:" + this.f138100b + ", timestamp:" + j3);
            f fVar = f.f138080a;
            if (launchWxaAppResult == LaunchWxaAppResult.OK) {
                z16 = true;
            } else {
                z16 = false;
            }
            fVar.a("launchByQRRawData", z16, str, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class m extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f138102b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f138103c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f138104d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Map f138105e;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements com.tencent.luggage.wxaapi.h {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f138106a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f138107b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ s f138108c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Context f138109d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Map f138110e;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.q7.s$m$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public /* synthetic */ class C6630a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f138111a;

                static {
                    int[] iArr = new int[TdiAuthState.values().length];
                    iArr[TdiAuthState.WechatTdi_Auth_State_OK.ordinal()] = 1;
                    f138111a = iArr;
                }
            }

            public a(String str, long j3, s sVar, Context context, Map map) {
                this.f138106a = str;
                this.f138107b = j3;
                this.f138108c = sVar;
                this.f138109d = context;
                this.f138110e = map;
            }

            @Override // com.tencent.luggage.wxaapi.h
            public final void onStateChecked(TdiAuthState authState, String str) {
                Intrinsics.checkNotNullParameter(authState, "authState");
                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "launchByQRRawData authState:" + authState + ", codeRawData:" + this.f138106a + ", timestamp:" + this.f138107b);
                if (C6630a.f138111a[authState.ordinal()] == 1) {
                    com.tencent.luggage.wxa.u6.a.f142122a.b();
                    f.a aVar = com.tencent.luggage.wxa.z4.f.f146283b;
                    if (aVar.b()) {
                        aVar.a(false);
                        aVar.d();
                    }
                    com.tencent.luggage.wxa.q7.c cVar = com.tencent.luggage.wxa.q7.c.f137897a;
                    cVar.a(this.f138108c);
                    Context context = this.f138109d;
                    if (context == null) {
                        context = com.tencent.luggage.wxa.tn.z.c();
                    }
                    Context context2 = context;
                    Intrinsics.checkNotNullExpressionValue(context2, "context ?: MMApplicationContext.getContext()");
                    cVar.a(context2, this.f138106a, this.f138107b, this.f138110e);
                    return;
                }
                com.tencent.luggage.wxa.u7.b.f142127a.a(this.f138107b, LaunchWxaAppResult.FailNoAuth);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(String str, long j3, Context context, Map map) {
            super(0);
            this.f138102b = str;
            this.f138103c = j3;
            this.f138104d = context;
            this.f138105e = map;
        }

        public final void a() {
            s sVar = s.this;
            sVar.checkAuthState(new a(this.f138102b, this.f138103c, sVar, this.f138104d, this.f138105e));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class n implements com.tencent.luggage.wxaapi.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxaapi.d f138112a;

        public n(com.tencent.luggage.wxaapi.d dVar) {
            this.f138112a = dVar;
        }

        @Override // com.tencent.luggage.wxaapi.d
        public final void onLaunchResult(String str, int i3, long j3, LaunchWxaAppResult launchWxaAppResult) {
            boolean z16;
            if (str != null) {
                com.tencent.luggage.wxa.q7.u.f138189a.a(str);
            }
            com.tencent.luggage.wxaapi.d dVar = this.f138112a;
            if (dVar != null) {
                dVar.onLaunchResult(str, i3, j3, launchWxaAppResult);
            }
            f fVar = f.f138080a;
            if (launchWxaAppResult == LaunchWxaAppResult.OK) {
                z16 = true;
            } else {
                z16 = false;
            }
            fVar.a("launchByQRScanCode", z16, str, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class o extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f138114b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f138115c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map f138116d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements com.tencent.luggage.wxaapi.h {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s f138117a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context f138118b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f138119c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Map f138120d;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.q7.s$o$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public /* synthetic */ class C6631a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f138121a;

                static {
                    int[] iArr = new int[TdiAuthState.values().length];
                    iArr[TdiAuthState.WechatTdi_Auth_State_OK.ordinal()] = 1;
                    f138121a = iArr;
                }
            }

            public a(s sVar, Context context, long j3, Map map) {
                this.f138117a = sVar;
                this.f138118b = context;
                this.f138119c = j3;
                this.f138120d = map;
            }

            @Override // com.tencent.luggage.wxaapi.h
            public final void onStateChecked(TdiAuthState authState, String str) {
                Intrinsics.checkNotNullParameter(authState, "authState");
                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "launchByQRScanCode authState:" + authState);
                if (C6631a.f138121a[authState.ordinal()] == 1) {
                    com.tencent.luggage.wxa.u6.a.f142122a.b();
                    f.a aVar = com.tencent.luggage.wxa.z4.f.f146283b;
                    if (aVar.b()) {
                        aVar.a(false);
                        aVar.d();
                    }
                    com.tencent.luggage.wxa.q7.c cVar = com.tencent.luggage.wxa.q7.c.f137897a;
                    cVar.a(this.f138117a);
                    Context context = this.f138118b;
                    if (context == null) {
                        context = com.tencent.luggage.wxa.tn.z.c();
                    }
                    Intrinsics.checkNotNullExpressionValue(context, "context ?: MMApplicationContext.getContext()");
                    cVar.a(context, this.f138119c, this.f138120d);
                    return;
                }
                com.tencent.luggage.wxa.u7.b.f142127a.a(this.f138119c, LaunchWxaAppResult.FailNoAuth);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(Context context, long j3, Map map) {
            super(0);
            this.f138114b = context;
            this.f138115c = j3;
            this.f138116d = map;
        }

        public final void a() {
            s sVar = s.this;
            sVar.checkAuthState(new a(sVar, this.f138114b, this.f138115c, this.f138116d));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class p implements com.tencent.luggage.wxaapi.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxaapi.b f138122a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f138123b;

        public p(com.tencent.luggage.wxaapi.b bVar, String str) {
            this.f138122a = bVar;
            this.f138123b = str;
        }

        @Override // com.tencent.luggage.wxaapi.d
        public final void onLaunchResult(String str, int i3, long j3, LaunchWxaAppResult launchWxaAppResult) {
            boolean z16;
            com.tencent.luggage.wxaapi.b bVar = this.f138122a;
            if (bVar != null) {
                bVar.onLaunchResult(str, i3, j3, launchWxaAppResult);
            }
            f fVar = f.f138080a;
            if (launchWxaAppResult == LaunchWxaAppResult.OK) {
                z16 = true;
            } else {
                z16 = false;
            }
            fVar.a("launchByUsername", z16, this.f138123b, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class q implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f138124a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f138125b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f138126c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map f138127d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f138128e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f138129f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f138130g;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s f138131a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f138132b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f138133c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Map f138134d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Context f138135e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ long f138136f;

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ int f138137g;

            /* renamed from: h, reason: collision with root package name */
            public final /* synthetic */ String f138138h;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.q7.s$q$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6632a implements com.tencent.luggage.wxaapi.h {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f138139a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f138140b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ Map f138141c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ Context f138142d;

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ long f138143e;

                /* renamed from: f, reason: collision with root package name */
                public final /* synthetic */ int f138144f;

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ String f138145g;

                /* renamed from: h, reason: collision with root package name */
                public final /* synthetic */ s f138146h;

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.q7.s$q$a$a$a, reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public static final class RunnableC6633a implements Runnable {

                    /* renamed from: a, reason: collision with root package name */
                    public static final RunnableC6633a f138147a = new RunnableC6633a();

                    @Override // java.lang.Runnable
                    public final void run() {
                        StringBuilder sb5 = new StringBuilder();
                        d dVar = d.f138074a;
                        sb5.append(dVar.b());
                        sb5.append('#');
                        sb5.append(dVar.c());
                        com.tencent.luggage.wxa.t9.v.a(sb5.toString());
                    }
                }

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.q7.s$q$a$a$b */
                /* loaded from: classes8.dex */
                public /* synthetic */ class b {

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f138148a;

                    static {
                        int[] iArr = new int[TdiAuthState.values().length];
                        iArr[TdiAuthState.WechatTdi_Auth_State_OK.ordinal()] = 1;
                        f138148a = iArr;
                    }
                }

                public C6632a(String str, String str2, Map map, Context context, long j3, int i3, String str3, s sVar) {
                    this.f138139a = str;
                    this.f138140b = str2;
                    this.f138141c = map;
                    this.f138142d = context;
                    this.f138143e = j3;
                    this.f138144f = i3;
                    this.f138145g = str3;
                    this.f138146h = sVar;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.tencent.luggage.wxaapi.h
                public final void onStateChecked(TdiAuthState authState, String str) {
                    byte b16;
                    com.tencent.luggage.wxa.i3.n nVar;
                    String str2;
                    Intrinsics.checkNotNullParameter(authState, "authState");
                    com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "launchByUsername username:" + this.f138139a + " appId:" + this.f138140b + " authState:" + authState);
                    boolean z16 = true;
                    if (b.f138148a[authState.ordinal()] == 1) {
                        com.tencent.luggage.wxa.u6.a.f142122a.b();
                        f.a aVar = com.tencent.luggage.wxa.z4.f.f146283b;
                        boolean z17 = false;
                        if (aVar.b()) {
                            aVar.a(false);
                            aVar.d();
                        }
                        com.tencent.luggage.wxa.q7.u uVar = com.tencent.luggage.wxa.q7.u.f138189a;
                        String appId = this.f138140b;
                        Intrinsics.checkNotNullExpressionValue(appId, "appId");
                        uVar.a(appId);
                        com.tencent.luggage.wxa.zp.h.f146825d.c(RunnableC6633a.f138147a);
                        Map map = this.f138141c;
                        if (map != null && !map.isEmpty()) {
                            b16 = true;
                        } else {
                            b16 = false;
                        }
                        String str3 = null;
                        byte b17 = 0;
                        if (b16 != false) {
                            nVar = new com.tencent.luggage.wxa.i3.n(this.f138141c, z17, 2, (DefaultConstructorMarker) (b17 == true ? 1 : 0));
                        } else {
                            nVar = null;
                        }
                        Context context = this.f138142d;
                        com.tencent.luggage.wxa.d6.b bVar = new com.tencent.luggage.wxa.d6.b();
                        String str4 = this.f138140b;
                        int i3 = this.f138144f;
                        String str5 = this.f138145g;
                        long j3 = this.f138143e;
                        Map map2 = this.f138141c;
                        bVar.f124086d = str4;
                        bVar.f124090h = i3;
                        bVar.f124089g = str5;
                        bVar.f124095m = j3;
                        if (map2 == null || map2.isEmpty()) {
                            z16 = false;
                        }
                        if (z16) {
                            if (nVar != null) {
                                str2 = nVar.c();
                            } else {
                                str2 = null;
                            }
                            bVar.f124100r = str2;
                        }
                        com.tencent.luggage.wxa.bk.e eVar = new com.tencent.luggage.wxa.bk.e();
                        s sVar = this.f138146h;
                        eVar.f122984c = 1168;
                        if (nVar != null) {
                            str3 = nVar.b();
                        }
                        eVar.f122985d = w0.b(str3, sVar.f138055a);
                        Unit unit = Unit.INSTANCE;
                        com.tencent.luggage.wxa.i3.t.a(context, bVar, eVar, null, false, 24, null);
                        return;
                    }
                    com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "launchWxaApp rejected, authState:" + authState);
                    com.tencent.luggage.wxa.u7.b.f142127a.a(this.f138143e, LaunchWxaAppResult.FailNoAuth);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(s sVar, String str, String str2, Map map, Context context, long j3, int i3, String str3) {
                super(0);
                this.f138131a = sVar;
                this.f138132b = str;
                this.f138133c = str2;
                this.f138134d = map;
                this.f138135e = context;
                this.f138136f = j3;
                this.f138137g = i3;
                this.f138138h = str3;
            }

            public final void a() {
                s sVar = this.f138131a;
                sVar.checkAuthState(new C6632a(this.f138132b, this.f138133c, this.f138134d, this.f138135e, this.f138136f, this.f138137g, this.f138138h, sVar));
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public q(long j3, s sVar, String str, Map map, Context context, int i3, String str2) {
            this.f138124a = j3;
            this.f138125b = sVar;
            this.f138126c = str;
            this.f138127d = map;
            this.f138128e = context;
            this.f138129f = i3;
            this.f138130g = str2;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(String str) {
            if (str == null || str.length() == 0) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "launchByUsername fail, appId is null");
                com.tencent.luggage.wxa.u7.b.f142127a.a(this.f138124a, LaunchWxaAppResult.FailWxaAppIdSync);
            } else {
                com.tencent.luggage.wxa.v7.d.f143293b.a(new a(this.f138125b, this.f138126c, str, this.f138127d, this.f138128e, this.f138124a, this.f138129f, this.f138130g));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class r implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f138149a;

        public r(long j3) {
            this.f138149a = j3;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "launchByUserName fail: " + obj);
            com.tencent.luggage.wxa.u7.b.f142127a.a(this.f138149a, LaunchWxaAppResult.FailWxaAppIdSync);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.q7.s$s, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6634s implements com.tencent.luggage.wxaapi.d, com.tencent.luggage.wxaapi.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxaapi.d f138150a;

        public C6634s(com.tencent.luggage.wxaapi.d dVar) {
            this.f138150a = dVar;
        }

        @Override // com.tencent.luggage.wxaapi.e
        public void onLaunchResourcePrepareCompleted(String str, int i3, long j3) {
            com.tencent.luggage.wxaapi.e eVar;
            com.tencent.luggage.wxaapi.d dVar = this.f138150a;
            if (dVar instanceof com.tencent.luggage.wxaapi.e) {
                eVar = (com.tencent.luggage.wxaapi.e) dVar;
            } else {
                eVar = null;
            }
            if (eVar != null) {
                eVar.onLaunchResourcePrepareCompleted(str, i3, j3);
            }
        }

        @Override // com.tencent.luggage.wxaapi.d
        public void onLaunchResult(String str, int i3, long j3, LaunchWxaAppResult launchWxaAppResult) {
            boolean z16;
            if (str != null) {
                com.tencent.luggage.wxa.q7.u.f138189a.a(str);
            }
            com.tencent.luggage.wxaapi.d dVar = this.f138150a;
            if (dVar != null) {
                dVar.onLaunchResult(str, i3, j3, launchWxaAppResult);
            }
            f fVar = f.f138080a;
            if (launchWxaAppResult == LaunchWxaAppResult.OK) {
                z16 = true;
            } else {
                z16 = false;
            }
            fVar.a("launchWxaApp", z16, str, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class t extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f138152b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f138153c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f138154d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f138155e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f138156f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f138157g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f138158h;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements com.tencent.luggage.wxaapi.h {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f138159a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Map f138160b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Context f138161c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ long f138162d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ int f138163e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ String f138164f;

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ String f138165g;

            /* renamed from: h, reason: collision with root package name */
            public final /* synthetic */ s f138166h;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.q7.s$t$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class RunnableC6635a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public static final RunnableC6635a f138167a = new RunnableC6635a();

                @Override // java.lang.Runnable
                public final void run() {
                    StringBuilder sb5 = new StringBuilder();
                    d dVar = d.f138074a;
                    sb5.append(dVar.b());
                    sb5.append('#');
                    sb5.append(dVar.c());
                    com.tencent.luggage.wxa.t9.v.a(sb5.toString());
                }
            }

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public /* synthetic */ class b {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f138168a;

                static {
                    int[] iArr = new int[TdiAuthState.values().length];
                    iArr[TdiAuthState.WechatTdi_Auth_State_OK.ordinal()] = 1;
                    f138168a = iArr;
                }
            }

            public a(String str, Map map, Context context, long j3, int i3, String str2, String str3, s sVar) {
                this.f138159a = str;
                this.f138160b = map;
                this.f138161c = context;
                this.f138162d = j3;
                this.f138163e = i3;
                this.f138164f = str2;
                this.f138165g = str3;
                this.f138166h = sVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.luggage.wxaapi.h
            public final void onStateChecked(TdiAuthState authState, String str) {
                byte b16;
                com.tencent.luggage.wxa.i3.n nVar;
                String str2;
                Intrinsics.checkNotNullParameter(authState, "authState");
                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "launchWxaApp wxaAppID:" + this.f138159a + " authState:" + authState);
                boolean z16 = true;
                if (b.f138168a[authState.ordinal()] == 1) {
                    com.tencent.luggage.wxa.u6.a.f142122a.b();
                    f.a aVar = com.tencent.luggage.wxa.z4.f.f146283b;
                    boolean z17 = false;
                    if (aVar.b()) {
                        aVar.a(false);
                        aVar.d();
                    }
                    com.tencent.luggage.wxa.zp.h.f146825d.c(RunnableC6635a.f138167a);
                    Map map = this.f138160b;
                    if (map != null && !map.isEmpty()) {
                        b16 = true;
                    } else {
                        b16 = false;
                    }
                    String str3 = null;
                    byte b17 = 0;
                    if (b16 != false) {
                        nVar = new com.tencent.luggage.wxa.i3.n(this.f138160b, z17, 2, (DefaultConstructorMarker) (b17 == true ? 1 : 0));
                    } else {
                        nVar = null;
                    }
                    Context context = this.f138161c;
                    com.tencent.luggage.wxa.d6.b bVar = new com.tencent.luggage.wxa.d6.b();
                    String str4 = this.f138159a;
                    int i3 = this.f138163e;
                    String str5 = this.f138164f;
                    String str6 = this.f138165g;
                    long j3 = this.f138162d;
                    s sVar = this.f138166h;
                    Map map2 = this.f138160b;
                    bVar.f124086d = str4;
                    bVar.f124090h = i3;
                    bVar.f124089g = str5;
                    bVar.f124097o = str6;
                    bVar.f124095m = j3;
                    bVar.f124098p = !sVar.getDebugApi().isMultiTaskModeEnabledForWxaApp();
                    if (map2 == null || map2.isEmpty()) {
                        z16 = false;
                    }
                    if (z16) {
                        if (nVar != null) {
                            str2 = nVar.c();
                        } else {
                            str2 = null;
                        }
                        bVar.f124100r = str2;
                    }
                    com.tencent.luggage.wxa.bk.e eVar = new com.tencent.luggage.wxa.bk.e();
                    s sVar2 = this.f138166h;
                    eVar.f122984c = 1168;
                    if (nVar != null) {
                        str3 = nVar.b();
                    }
                    eVar.f122985d = w0.b(str3, sVar2.f138055a);
                    Unit unit = Unit.INSTANCE;
                    com.tencent.luggage.wxa.i3.t.a(context, bVar, eVar, null, false, 24, null);
                    return;
                }
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "launchWxaApp rejected, authState:" + authState);
                com.tencent.luggage.wxa.u7.b.f142127a.a(this.f138162d, LaunchWxaAppResult.FailNoAuth);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(String str, Map map, Context context, long j3, int i3, String str2, String str3) {
            super(0);
            this.f138152b = str;
            this.f138153c = map;
            this.f138154d = context;
            this.f138155e = j3;
            this.f138156f = i3;
            this.f138157g = str2;
            this.f138158h = str3;
        }

        public final void a() {
            s sVar = s.this;
            sVar.checkAuthState(new a(this.f138152b, this.f138153c, this.f138154d, this.f138155e, this.f138156f, this.f138157g, this.f138158h, sVar));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class u extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxaapi.f f138169a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f138170b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ s f138171c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ v f138172d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(com.tencent.luggage.wxaapi.f fVar, String str, s sVar, v vVar) {
            super(1);
            this.f138170b = str;
            this.f138171c = sVar;
            this.f138172d = vVar;
        }

        public final void a(com.tencent.luggage.wxa.fk.c errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.fk.c) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class v extends com.tencent.luggage.wxa.fk.a {

        /* renamed from: c, reason: collision with root package name */
        public LaunchWxaAppResult f138173c;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f138175e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Map f138176f;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements com.tencent.luggage.wxaapi.d {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1 f138178b;

            public a(Function1 function1) {
                this.f138178b = function1;
            }

            @Override // com.tencent.luggage.wxaapi.d
            public final void onLaunchResult(String str, int i3, long j3, LaunchWxaAppResult launchWxaAppResult) {
                boolean z16;
                if (str != null) {
                    com.tencent.luggage.wxa.q7.u.f138189a.a(str);
                }
                v.this.a(launchWxaAppResult);
                Function1 function1 = this.f138178b;
                if (launchWxaAppResult == LaunchWxaAppResult.OK) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                function1.invoke(Boolean.valueOf(z16));
            }
        }

        public v(String str, Map map) {
            this.f138175e = str;
            this.f138176f = map;
        }

        public final void a(LaunchWxaAppResult launchWxaAppResult) {
            this.f138173c = launchWxaAppResult;
        }

        public final LaunchWxaAppResult c() {
            return this.f138173c;
        }

        @Override // com.tencent.luggage.wxa.fk.a
        public void a(Context ctx, a.b params, Function1 launchResultCallback) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(launchResultCallback, "launchResultCallback");
            s.this.a(ctx, params.a(), params.d(), params.b(), this.f138175e, this.f138176f, new a(launchResultCallback));
        }

        @Override // com.tencent.luggage.wxa.fk.a
        public a.b a() {
            return a.b.BusinessTypeOpenSdk;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class w extends Lambda implements Function0 {
        public w() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxaapi.a invoke() {
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "getDebugApi");
            if (com.tencent.luggage.wxa.q7.r.f138048a.b()) {
                return new com.tencent.luggage.wxa.t7.b(s.this);
            }
            return new com.tencent.luggage.wxa.t7.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class x extends Lambda implements Function0 {
        public x() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.q7.b0 invoke() {
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "getPrefetchApi");
            return new com.tencent.luggage.wxa.q7.b0(s.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class y extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxaapi.g f138182b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f138183c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements com.tencent.luggage.wxaapi.g {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f138184a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxaapi.g f138185b;

            public a(int i3, com.tencent.luggage.wxaapi.g gVar) {
                this.f138184a = i3;
                this.f138185b = gVar;
            }

            @Override // com.tencent.luggage.wxaapi.g
            public final void onPreloadResult(PreloadWxaProcessEnvResult preloadWxaProcessEnvResult) {
                boolean z16;
                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "preloadWxaProcessEnv: " + this.f138184a + " result:" + preloadWxaProcessEnvResult);
                com.tencent.luggage.wxaapi.g gVar = this.f138185b;
                if (gVar != null) {
                    gVar.onPreloadResult(preloadWxaProcessEnvResult);
                }
                f fVar = f.f138080a;
                if (preloadWxaProcessEnvResult != PreloadWxaProcessEnvResult.Preload_Fail) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                f.a(fVar, "preloadWxaProcessEnv", z16, null, 0, 12, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(com.tencent.luggage.wxaapi.g gVar, int i3) {
            super(0);
            this.f138182b = gVar;
            this.f138183c = i3;
        }

        public final void a() {
            if (!s.this.isDynamicPkgLoaded()) {
                com.tencent.luggage.wxaapi.g gVar = this.f138182b;
                if (gVar != null) {
                    gVar.onPreloadResult(PreloadWxaProcessEnvResult.Preload_NotLoadDynamicPkg);
                    return;
                }
                return;
            }
            com.tencent.luggage.wxa.u6.a.f142122a.b();
            f.a aVar = com.tencent.luggage.wxa.z4.f.f146283b;
            if (aVar.b()) {
                aVar.a(false);
                aVar.d();
            }
            com.tencent.luggage.wxa.q7.c0 c0Var = com.tencent.luggage.wxa.q7.c0.f137935a;
            int i3 = this.f138183c;
            c0Var.a(i3, new a(i3, this.f138182b));
            if (this.f138183c == 1) {
                g0.f137975e.a();
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class z extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxaapi.j f138186a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxaapi.j f138187a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f138188b;

            public a(com.tencent.luggage.wxaapi.j jVar, int i3) {
                this.f138187a = jVar;
                this.f138188b = i3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                UploadLogResultCode uploadLogResultCode;
                com.tencent.luggage.wxaapi.j jVar = this.f138187a;
                if (jVar != null) {
                    int i3 = this.f138188b;
                    if (i3 != -101) {
                        if (i3 != 0) {
                            uploadLogResultCode = UploadLogResultCode.Fail;
                        } else {
                            uploadLogResultCode = UploadLogResultCode.OK;
                        }
                    } else {
                        uploadLogResultCode = UploadLogResultCode.FailNetworkType;
                    }
                    jVar.a(uploadLogResultCode);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(com.tencent.luggage.wxaapi.j jVar) {
            super(1);
            this.f138186a = jVar;
        }

        public final void a(int i3) {
            com.tencent.luggage.wxa.tn.c0.a(new a(this.f138186a, i3));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).intValue());
            return Unit.INSTANCE;
        }
    }

    public s(Context context, String hostAppID, int i3, boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        boolean z17;
        int checkRadix;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hostAppID, "hostAppID");
        this.f138055a = hostAppID;
        this.f138056b = i3;
        this.f138057c = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new w());
        this.f138059e = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new x());
        this.f138060f = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(j.f138096a);
        this.f138061g = lazy3;
        d dVar = d.f138074a;
        dVar.a(hostAppID);
        dVar.a(this);
        com.tencent.luggage.wxa.r6.k.a(new com.tencent.luggage.wxa.f7.h());
        if (2 == i3) {
            z17 = true;
        } else {
            z17 = false;
        }
        com.tencent.luggage.wxa.tn.e.f141567i = z17;
        com.tencent.luggage.wxa.q7.y.f138216a.a(i3);
        String str = "ProcessStartupFactory.initialize process:" + com.tencent.luggage.wxa.tn.z.a(context);
        com.tencent.luggage.wxa.e5.g gVar = com.tencent.luggage.wxa.e5.g.f124544a;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.tencent.luggage.wxa.v7.f.f143304a.a(context, z16);
        String obj = Unit.INSTANCE.toString();
        obj = obj == null ? "" : obj;
        boolean a16 = l0.a();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime2 > 32 && a16) {
            com.tencent.luggage.wxa.tn.w.f("Luggage.Utils.Profile", "block main thread and skip " + ((int) (elapsedRealtime2 / 16)) + " frames! runProfiled:log:" + str + " cost " + elapsedRealtime2 + " ms result:" + obj + " isMainThread: " + a16 + TokenParser.SP);
        } else {
            com.tencent.luggage.wxa.tn.w.d("Luggage.Utils.Profile", "runProfiled:log:" + str + " cost " + elapsedRealtime2 + " ms result:" + obj + " isMainThread: " + a16 + TokenParser.SP);
        }
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, hostAppID, !com.tencent.luggage.wxa.q7.r.f138048a.d());
        Intrinsics.checkNotNullExpressionValue(createWXAPI, "createWXAPI(context, hos\u2026s.IS_DEBUG_WX_ACCEPTABLE)");
        this.f138058d = createWXAPI;
        com.tencent.luggage.wxa.v3.f.a(createWXAPI);
        com.tencent.luggage.wxa.v3.f.a(WXLaunchWxaRedirectingPage.Resp.class, a.f138064a);
        if (com.tencent.luggage.wxa.tn.z.m()) {
            com.tencent.luggage.wxa.x7.f fVar = com.tencent.luggage.wxa.x7.f.f144620c;
            fVar.b(hostAppID);
            fVar.a(i3);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("<init> process:");
        sb5.append(com.tencent.luggage.wxa.tn.z.i());
        sb5.append(", version:");
        sb5.append(d.a());
        sb5.append("(0x");
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(603979777, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        sb5.append(num);
        sb5.append("), hostAppID:");
        sb5.append(hostAppID);
        sb5.append(", abiType:");
        sb5.append(i3);
        sb5.append(", apiLevel:");
        sb5.append(Build.VERSION.SDK_INT);
        String sb6 = sb5.toString();
        Log.i("Luggage.WxaApiImpl", sb6);
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", sb6);
        this.f138063i = new ConcurrentHashMap();
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public void addLaunchWxaAppPerformanceMetricsListener(com.tencent.luggage.wxaapi.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.luggage.wxa.u7.b.f142127a.a(listener);
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public void addWxaAppCloseEventListener(com.tencent.luggage.wxaapi.k kVar) {
        com.tencent.luggage.wxa.q7.u.f138189a.a(kVar);
    }

    public void addWxaAppNavigateEventListener(com.tencent.luggage.wxaapi.n nVar) {
        com.tencent.luggage.wxa.q7.w.f138211a.a(nVar);
    }

    public final com.tencent.luggage.wxaapi.a c() {
        return (com.tencent.luggage.wxaapi.a) this.f138059e.getValue();
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public void checkAuthState(com.tencent.luggage.wxaapi.h hVar) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "checkAuthState start");
        if (!com.tencent.luggage.wxa.tn.z.m()) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "checkAuthStateSync() return NoAuth in non-main process");
            if (hVar != null) {
                hVar.onStateChecked(TdiAuthState.WechatTdi_Auth_State_NoAuth, null);
            }
            f.a(f.f138080a, "checkAuthState", false, null, 0, 12, null);
            return;
        }
        if (!com.tencent.luggage.wxa.x7.e.f144619a.a()) {
            if (hVar != null) {
                hVar.onStateChecked(TdiAuthState.WechatTdi_Auth_State_Dynamic_Pkg_Not_Loaded, null);
            }
            f.a(f.f138080a, "checkAuthState", false, null, 0, 12, null);
        } else {
            com.tencent.luggage.wxa.v7.d.f143293b.a(new g(hVar));
            f.a(f.f138080a, "checkAuthState", true, null, 0, 12, null);
        }
    }

    public boolean checkIfWechatSupportWxaApi() {
        boolean c16 = com.tencent.luggage.wxa.v3.m.f143124a.c();
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "checkIfWechatSupportWxaApi " + c16);
        f.a(f.f138080a, "checkIfWechatSupportWxaApi", true, null, 0, 12, null);
        return c16;
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public void clearAuth() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "clearAuth start");
        if (!com.tencent.luggage.wxa.tn.z.m()) {
            return;
        }
        com.tencent.luggage.wxa.v7.d.f143293b.a(i.f138095a);
    }

    public void closeWxaApp(String wxaAppID, boolean z16) {
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "closeWxaApp wxaAppID:" + wxaAppID + " allowBackgroundRunning:" + z16);
        if (!com.tencent.luggage.wxa.tn.z.m()) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "closeWxaApp wxaAppID:" + wxaAppID + ", allowBackgroundRunning:" + z16 + ", not supported in non-main process");
            f.a(f.f138080a, "closeWxaApp", false, wxaAppID, 0, 8, null);
            return;
        }
        com.tencent.luggage.wxa.u6.a.f142122a.b();
        if (!z16) {
            com.tencent.luggage.wxa.z4.f.a(com.tencent.luggage.wxa.z4.f.f146283b.a(), wxaAppID, -1, false, 0, 12, (Object) null);
        } else {
            com.tencent.luggage.wxa.z4.f.f146283b.a().a(wxaAppID, -1);
        }
        f.a(f.f138080a, "closeWxaApp", true, wxaAppID, 0, 8, null);
    }

    public final WxaPrefetchApi d() {
        return (WxaPrefetchApi) this.f138060f.getValue();
    }

    public final IWXAPI e() {
        return this.f138058d;
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public com.tencent.luggage.wxaapi.a getDebugApi() {
        return c();
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public WxaExtendApiJSBridge getExtendApiJSBridge() {
        if (StringUtils.contains(com.tencent.luggage.wxa.tn.z.i(), ProcessConstant.WXA_CONTAINER)) {
            return com.tencent.luggage.wxa.q7.i.f137989a;
        }
        if (com.tencent.luggage.wxa.tn.z.m()) {
            return com.tencent.luggage.wxa.q7.j.f138007a;
        }
        com.tencent.luggage.wxa.q7.k.f138011a.c("WxaApi", "getExtendApiJSBridge() called in incorrect process.");
        return (WxaExtendApiJSBridge) com.tencent.luggage.wxa.uk.o.a("Luggage.WxaApiImpl.WxaExtendApiJSBridge", WxaExtendApiJSBridge.class);
    }

    public WxaApi.MiniGameRenderMode getMiniGameRenderMode() {
        WxaApi.MiniGameRenderMode a16 = com.tencent.luggage.wxa.q7.l.f138013a.a();
        f.a(f.f138080a, "getMiniGameRenderMode", true, null, 0, 12, null);
        return a16;
    }

    public WxaPrefetchApi getPrefetchApi() {
        return d();
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public String getSDKVersion() {
        String a16 = d.a();
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "getSDKVersion " + a16);
        f.a(f.f138080a, "getSDKVersion", true, null, 0, 12, null);
        return a16;
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public int getSDKVersionInt() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "getSDKVersionInt: 603979777");
        f.a(f.f138080a, "getSDKVersionInt", true, null, 0, 12, null);
        return 603979777;
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public String getTdiUserId() {
        String a16 = com.tencent.luggage.wxa.n3.e0.f135163b.a(d.f138074a.c());
        f.a(f.f138080a, "getTdiUserId", true, null, 0, 12, null);
        return a16;
    }

    public com.tencent.luggage.wxaapi.o getWxaBackgroundAudioApi() {
        return WxaBackgroundAudioApiImpl.f146882a;
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public boolean handleIntent(Context context, Intent intent) {
        Object obj;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleIntent: ctx [");
        Object obj2 = "null";
        if (context == null) {
            obj = "null";
        } else {
            obj = Integer.valueOf(context.hashCode());
        }
        sb5.append(obj);
        sb5.append("], intent [");
        if (intent != null) {
            obj2 = Integer.valueOf(intent.hashCode());
        }
        sb5.append(obj2);
        sb5.append(']');
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", sb5.toString());
        return a(context, intent);
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public InitDynamicPkgResult initDynamicPkg(String dynamicPkgPath) {
        boolean z16;
        Intrinsics.checkNotNullParameter(dynamicPkgPath, "dynamicPkgPath");
        if (!com.tencent.luggage.wxa.tn.z.m()) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "initDynamicPkg() return false in non-main process");
            return InitDynamicPkgResult.FailNotInMainProcess;
        }
        InitDynamicPkgResult e16 = com.tencent.luggage.wxa.q7.y.f138216a.e(dynamicPkgPath);
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "initDynamicPkg dynamicPkgPath: " + e16);
        f fVar = f.f138080a;
        if (InitDynamicPkgResult.OK == e16) {
            z16 = true;
        } else {
            z16 = false;
        }
        f.a(fVar, "initDynamicPkg", z16, null, 0, 12, null);
        return e16;
    }

    public boolean isDynamicPkgLoaded() {
        if (!com.tencent.luggage.wxa.tn.z.m()) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "isDynamicPkgLoaded() return false in non-main process");
            return false;
        }
        boolean j3 = com.tencent.luggage.wxa.q7.y.f138216a.j();
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "isDynamicPkgLoaded " + j3);
        f.a(f.f138080a, "isDynamicPkgLoaded", j3, null, 0, 12, null);
        return j3;
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public long launchByQRRawData(Context context, String qrRawData, Map map, com.tencent.luggage.wxaapi.d dVar) {
        boolean z16;
        Intrinsics.checkNotNullParameter(qrRawData, "qrRawData");
        long a16 = f.f138080a.a();
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "launchByQRCodeRawData, codeRawData:" + qrRawData + ", timestamp:" + a16);
        com.tencent.luggage.wxa.u7.b bVar = com.tencent.luggage.wxa.u7.b.f142127a;
        com.tencent.luggage.wxa.u7.b.a(bVar, a16, null, null, 0, new l(dVar, qrRawData), 14, null);
        if (qrRawData.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            bVar.a(a16, LaunchWxaAppResult.FailQRCodeInvalid);
            return a16;
        }
        if (!isDynamicPkgLoaded()) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "launchByQRCodeRawData rejected, dynamic pkg not loaded");
            bVar.a(a16, LaunchWxaAppResult.FailNotLoadDynamicPkg);
            return a16;
        }
        com.tencent.luggage.wxa.v7.d.f143293b.a(new m(qrRawData, a16, context, map));
        return a16;
    }

    public long launchByQRScanCode(Context context, com.tencent.luggage.wxaapi.d dVar) {
        return launchByQRScanCode(context, null, dVar);
    }

    public long launchByUsername(Context context, String username, int i3, String str, com.tencent.luggage.wxaapi.b bVar) {
        Intrinsics.checkNotNullParameter(username, "username");
        return launchByUsername(context, username, i3, str, null, bVar);
    }

    public long launchWxaApp(Context context, String wxaAppID, int i3, String str, com.tencent.luggage.wxaapi.d dVar) {
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        return a(context, wxaAppID, i3, str, "", null, dVar);
    }

    public void launchWxaByShortLink(Activity ctx, String shortLink, boolean z16, com.tencent.luggage.wxaapi.f fVar) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(shortLink, "shortLink");
        launchWxaByShortLink(ctx, shortLink, z16, null, fVar);
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public void preloadWxaProcessEnv(int i3, com.tencent.luggage.wxaapi.g gVar) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "preloadWxaProcessEnv: " + i3 + " start");
        com.tencent.luggage.wxa.v7.d.f143293b.a(new y(gVar, i3));
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public com.tencent.luggage.wxaapi.r queryWxaProfileForAppId(String str) {
        return d0.INSTANCE.a(str);
    }

    public void removeLaunchWxaAppPerformanceMetricsListener(com.tencent.luggage.wxaapi.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.luggage.wxa.u7.b.f142127a.b(listener);
    }

    public void removeWxaAppCloseEventListener(com.tencent.luggage.wxaapi.k kVar) {
        com.tencent.luggage.wxa.q7.u.f138189a.b(kVar);
    }

    public void removeWxaAppNavigateEventListener(com.tencent.luggage.wxaapi.n nVar) {
        com.tencent.luggage.wxa.q7.w.f138211a.b(nVar);
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public void requestUploadLogFiles(int i3, int i16, com.tencent.luggage.wxaapi.j jVar) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "requestUploadLogFiles, start: %d, end: %d", Integer.valueOf(i3), Integer.valueOf(i16));
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        try {
            if (i3 > 0 && i16 > 0) {
                if (i16 < i3) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "end time must be later then start time!");
                    if (jVar != null) {
                        jVar.a(UploadLogResultCode.FailParamsError);
                    }
                    booleanRef.element = false;
                    f.a(f.f138080a, "requestUploadLogFiles", false, null, 0, 12, null);
                    return;
                }
                i0.f138000a.a(new z(jVar));
                q0.f135244a.a(new a0(i3, i16, booleanRef, jVar));
                return;
            }
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "time value is illegal");
            if (jVar != null) {
                jVar.a(UploadLogResultCode.FailParamsError);
            }
            booleanRef.element = false;
            f.a(f.f138080a, "requestUploadLogFiles", false, null, 0, 12, null);
        } finally {
            f.a(f.f138080a, "requestUploadLogFiles", booleanRef.element, null, 0, 12, null);
        }
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public void sendAuth(com.tencent.luggage.wxaapi.i iVar) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "sendAuth: start");
        a(new b0(iVar));
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public void sendCombineAuth(SendAuth.Req req, IWXAPIEventHandler iWXAPIEventHandler, com.tencent.luggage.wxaapi.i iVar) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "sendCombineAuth start");
        a(req, iWXAPIEventHandler, new c0(iVar));
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public void setDebugLogImpl(com.tencent.luggage.wxaapi.q qVar) {
        com.tencent.luggage.wxa.q7.k.f138011a.a(qVar);
    }

    public void setMaxCachedWxaPkgStorageSize(long j3) {
        if (j3 <= 0) {
            return;
        }
        com.tencent.luggage.wxa.r7.a.f139412e.a(j3);
        f.a(f.f138080a, "setMaxCachedWxaPkgStorageSize", true, null, 0, 12, null);
    }

    public void setMiniGameRenderMode(WxaApi.MiniGameRenderMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        com.tencent.luggage.wxa.q7.l.f138013a.a(mode);
        f.a(f.f138080a, "setMiniGameRenderMode", true, null, 0, 12, null);
    }

    public void setOpenSdkCallbackClassName(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        com.tencent.luggage.wxa.v3.f.b(className);
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public void setSystemPropertiesExtensionImpl(com.tencent.luggage.wxaapi.s sVar) {
        e0.f137956a.a(sVar);
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public void setWxaAppActionSheetDelegate(WxaAppCustomActionSheetDelegate wxaAppCustomActionSheetDelegate) {
        this.f138062h = wxaAppCustomActionSheetDelegate;
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public void setWxaProcessMaxCount(int i3) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "setWxaProcessMaxCount: maxCount:" + i3);
        com.tencent.luggage.wxa.u6.a aVar = com.tencent.luggage.wxa.u6.a.f142122a;
        aVar.b();
        boolean z16 = true;
        if (i3 > 5) {
            i3 = 5;
        } else if (i3 < 1) {
            i3 = 1;
        }
        if (!com.tencent.luggage.wxa.tn.z.m()) {
            return;
        }
        h.a aVar2 = com.tencent.luggage.wxa.v7.h.f143309k;
        if (i3 == aVar2.a().j().length) {
            return;
        }
        ArrayList arrayList = new ArrayList(aVar2.a().b(i3));
        if (arrayList.size() < i3) {
            arrayList.addAll(aVar.a().subList(arrayList.size(), i3));
        }
        if (arrayList.size() != i3) {
            z16 = false;
        }
        com.tencent.luggage.wxa.er.a.b(z16);
        f.a aVar3 = com.tencent.luggage.wxa.z4.f.f146283b;
        Object[] array = arrayList.toArray(new com.tencent.luggage.wxa.l3.g[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        aVar3.b(new com.tencent.luggage.wxa.v7.h((com.tencent.luggage.wxa.l3.g[]) array));
        f.a(f.f138080a, "setWxaProcessMaxCount", true, null, 0, 12, null);
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public void setWxaSensitiveApiInvokeHandler(com.tencent.luggage.wxaapi.u handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        f0.a(handler);
    }

    public void testSensitiveInvoke() {
        com.tencent.luggage.wxaapi.t.a(com.tencent.luggage.wxa.tn.z.c());
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public void updateDeviceInfo(String str, String str2, String str3) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "updateDeviceInfo imei:" + str + " imei0:" + str2 + " imei1:" + str3);
        com.tencent.luggage.wxa.q2.c.b(str);
        com.tencent.luggage.wxa.q2.c.a(0, str2);
        com.tencent.luggage.wxa.q2.c.a(1, str3);
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public void updateTuringAIDTicket(String str) {
        com.tencent.luggage.wxa.q7.k.f138011a.b("WxaApiImpl", "updateTuringAIDTicket " + str);
        com.tencent.luggage.wxa.t9.v.b(str);
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public void updateTuringOAID(String str) {
        com.tencent.luggage.wxa.q7.k.f138011a.b("WxaApiImpl", "updateTuringOAID " + str);
        com.tencent.luggage.wxa.t9.v.c(str);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final d f138074a = new d();

        /* renamed from: b, reason: collision with root package name */
        public static String f138075b;

        /* renamed from: c, reason: collision with root package name */
        public static long f138076c;

        /* renamed from: d, reason: collision with root package name */
        public static s f138077d;

        static {
            r0.f141700a = 603979777;
            r0.f141701b = 3;
            r0.f141702c = true;
            r0.f141703d = false;
            f138075b = "";
        }

        public final void a(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "set hostAppID " + f138075b + " -> " + value + ']');
            f138075b = value;
        }

        public final String b() {
            return f138075b;
        }

        public final long c() {
            com.tencent.luggage.wxa.n3.t tVar;
            if (f138076c == 0) {
                if (com.tencent.luggage.wxa.tn.z.m()) {
                    try {
                        tVar = com.tencent.luggage.wxa.x7.a.f144602d.Z();
                    } catch (Exception e16) {
                        com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "getILinkUIN, get tdiSession, exception=" + e16 + ", stack=" + Log.getStackTraceString(e16));
                        tVar = null;
                    }
                    if (tVar != null) {
                        long uin = tVar.getUin();
                        f138076c = uin;
                        if (0 == uin) {
                            f138076c = com.tencent.luggage.wxa.x7.f.f144620c.c();
                            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "getILinkUIN by mmkv, uin=" + com.tencent.luggage.wxa.n3.e0.f135163b.b(f138076c));
                        } else {
                            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "getILinkUIN by active tdiSession, uin=" + com.tencent.luggage.wxa.n3.e0.f135163b.b(f138076c));
                            com.tencent.luggage.wxa.x7.f.f144620c.a(f138076c);
                        }
                    }
                } else {
                    f138076c = com.tencent.luggage.wxa.x7.f.f144620c.c();
                    com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "getILinkUIN by mmkv, uin=" + com.tencent.luggage.wxa.n3.e0.f135163b.b(f138076c));
                }
            }
            return f138076c;
        }

        public final s d() {
            return f138077d;
        }

        public final void a(long j3) {
            f138076c = j3;
            if (com.tencent.luggage.wxa.tn.z.m()) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "setILinkUIN by setter, uin=" + com.tencent.luggage.wxa.n3.e0.f135163b.b(j3));
                com.tencent.luggage.wxa.x7.f.f144620c.a(j3);
            }
        }

        public static final String a() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("4.0.0");
            sb5.append(com.tencent.luggage.wxa.q7.r.a() ? " #143" : "");
            return sb5.toString();
        }

        public final void a(s sVar) {
            f138077d = sVar;
        }
    }

    public final WxaAppCustomActionSheetDelegate b() {
        return this.f138062h;
    }

    public long launchByQRScanCode(Context context, Map map, com.tencent.luggage.wxaapi.d dVar) {
        if (!com.tencent.luggage.wxa.y3.a.f145414a.a()) {
            if (dVar == null) {
                return -1L;
            }
            dVar.onLaunchResult(null, 0, 0L, LaunchWxaAppResult.Fail);
            return -1L;
        }
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "launchByQRScanCode");
        long a16 = f.f138080a.a();
        com.tencent.luggage.wxa.u7.b bVar = com.tencent.luggage.wxa.u7.b.f142127a;
        com.tencent.luggage.wxa.u7.b.a(bVar, a16, null, null, 0, new n(dVar), 14, null);
        if (!isDynamicPkgLoaded()) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "launchByQRScanCode rejected, dynamic pkg not loaded");
            bVar.a(a16, LaunchWxaAppResult.FailNotLoadDynamicPkg);
            return a16;
        }
        com.tencent.luggage.wxa.v7.d.f143293b.a(new o(context, a16, map));
        return a16;
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public long launchByUsername(Context context, String username, int i3, String str, Map map, com.tencent.luggage.wxaapi.b bVar) {
        Intrinsics.checkNotNullParameter(username, "username");
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "launchByUsername username:" + username + " versionType:" + i3 + " enterPath:" + str + " hostExtraData:" + map + " start");
        long a16 = f.f138080a.a();
        com.tencent.luggage.wxa.u7.b bVar2 = com.tencent.luggage.wxa.u7.b.f142127a;
        bVar2.a(a16, "", username, i3, new p(bVar, username));
        if (!isDynamicPkgLoaded()) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "launchByUsername rejected, dynamic pkg not loaded");
            bVar2.a(a16, LaunchWxaAppResult.FailNotLoadDynamicPkg);
            return a16;
        }
        com.tencent.luggage.wxa.i3.m.f129333a.a(username).a(new q(a16, this, username, map, context, i3, str)).a(new r(a16));
        return a16;
    }

    @Override // com.tencent.luggage.wxaapi.WxaApi
    public long launchWxaApp(Context context, String wxaAppID, int i3, String str, Map map, com.tencent.luggage.wxaapi.d dVar) {
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        return a(context, wxaAppID, i3, str, "", map, dVar);
    }

    public void launchWxaByShortLink(Activity ctx, String shortLink, boolean z16, Map map, com.tencent.luggage.wxaapi.f fVar) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(shortLink, "shortLink");
        v vVar = new v(shortLink, map);
        vVar.a(ctx, shortLink, z16, new u(fVar, shortLink, this, vVar));
    }

    public final CoroutineScope a() {
        return (CoroutineScope) this.f138061g.getValue();
    }

    public final void a(com.tencent.luggage.wxaapi.i iVar) {
        boolean z16;
        if (!com.tencent.luggage.wxa.x7.e.f144619a.a()) {
            if (iVar != null) {
                iVar.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_Dynamic_Pkg_Not_Loaded, "not invoke initDynamicPkg");
                return;
            }
            return;
        }
        try {
            IWXAPIEventHandler iWXAPIEventHandler = null;
            byte b16 = 0;
            if (!this.f138058d.isWXAppInstalled()) {
                if (iVar != null) {
                    iVar.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_WechatNotInstalled, null);
                }
                f.a(f.f138080a, "sendAuth", false, null, 0, 12, null);
                return;
            }
            if (!checkIfWechatSupportWxaApi()) {
                if (iVar != null) {
                    iVar.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_WechatVersionTooLow, null);
                }
                f.a(f.f138080a, "sendAuth", false, null, 0, 12, null);
                return;
            }
            SendAuth.Req req = new SendAuth.Req();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(hashCode());
            sb5.append(util.base64_pad_url);
            sb5.append(w0.c());
            req.transaction = sb5.toString();
            req.scope = "snsapi_runtime_sdk";
            Boolean d16 = com.tencent.luggage.wxa.v3.f.d();
            Intrinsics.checkNotNullExpressionValue(d16, "useOpenSdkCallbackClassName()");
            if (d16.booleanValue()) {
                SendAuth.Options options = new SendAuth.Options();
                options.callbackClassName = com.tencent.luggage.wxa.v3.f.a();
                req.options = options;
            }
            ConcurrentHashMap concurrentHashMap = this.f138063i;
            String str = req.transaction;
            Intrinsics.checkNotNullExpressionValue(str, "this.transaction");
            concurrentHashMap.put(str, new b(iVar, iWXAPIEventHandler, 2, b16 == true ? 1 : 0));
            boolean sendReq = this.f138058d.sendReq(req);
            if (!sendReq && iVar != null) {
                try {
                    iVar.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_NormalErr, null);
                } catch (Throwable th5) {
                    th = th5;
                    z16 = sendReq;
                    f.a(f.f138080a, "sendAuth", z16, null, 0, 12, null);
                    throw th;
                }
            }
            f.a(f.f138080a, "sendAuth", sendReq, null, 0, 12, null);
        } catch (Throwable th6) {
            th = th6;
            z16 = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0084 A[Catch: all -> 0x00ea, TRY_ENTER, TryCatch #1 {all -> 0x00ea, blocks: (B:15:0x0021, B:18:0x002c, B:21:0x0040, B:24:0x0048, B:27:0x005c, B:29:0x0060, B:35:0x006e, B:38:0x0084, B:40:0x00bc, B:41:0x00c9), top: B:14:0x0021 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(SendAuth.Req req, IWXAPIEventHandler iWXAPIEventHandler, com.tencent.luggage.wxaapi.i iVar) {
        boolean z16;
        if (req == null) {
            if (iVar != null) {
                iVar.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_InvalidArgs, "req is null");
                return;
            }
            return;
        }
        if (!com.tencent.luggage.wxa.x7.e.f144619a.a()) {
            if (iVar != null) {
                iVar.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_Dynamic_Pkg_Not_Loaded, "not invoke initDynamicPkg");
                return;
            }
            return;
        }
        boolean z17 = false;
        try {
            if (!this.f138058d.isWXAppInstalled()) {
                if (iVar != null) {
                    iVar.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_WechatNotInstalled, null);
                }
                f.a(f.f138080a, "sendCombineAuth", false, null, 0, 12, null);
                return;
            }
            if (!checkIfWechatSupportWxaApi()) {
                if (iVar != null) {
                    iVar.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_WechatVersionTooLow, null);
                }
                f.a(f.f138080a, "sendCombineAuth", false, null, 0, 12, null);
                return;
            }
            String str = req.transaction;
            if (str != null && str.length() != 0) {
                z16 = false;
                if (!z16) {
                    if (iVar != null) {
                        iVar.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_InvalidArgs, "Should define your req.transaction and ensure unique");
                    }
                    f.a(f.f138080a, "sendCombineAuth", false, null, 0, 12, null);
                    return;
                }
                req.scope += ",snsapi_runtime_sdk";
                ConcurrentHashMap concurrentHashMap = this.f138063i;
                String str2 = req.transaction;
                Intrinsics.checkNotNullExpressionValue(str2, "req.transaction");
                concurrentHashMap.put(str2, new b(iVar, iWXAPIEventHandler));
                Boolean d16 = com.tencent.luggage.wxa.v3.f.d();
                Intrinsics.checkNotNullExpressionValue(d16, "useOpenSdkCallbackClassName()");
                if (d16.booleanValue()) {
                    SendAuth.Options options = new SendAuth.Options();
                    options.callbackClassName = com.tencent.luggage.wxa.v3.f.a();
                    req.options = options;
                }
                boolean sendReq = this.f138058d.sendReq(req);
                if (!sendReq && iVar != null) {
                    try {
                        iVar.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_NormalErr, null);
                    } catch (Throwable th5) {
                        th = th5;
                        z17 = sendReq;
                        f.a(f.f138080a, "sendCombineAuth", z17, null, 0, 12, null);
                        throw th;
                    }
                }
                f.a(f.f138080a, "sendCombineAuth", sendReq, null, 0, 12, null);
                return;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k implements IWXAPIEventHandler {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean[] f138098b;

        public k(boolean[] zArr) {
            this.f138098b = zArr;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResp(BaseResp resp) {
            SendTdiAuth.Resp resp2;
            Bundle b16;
            Intrinsics.checkNotNullParameter(resp, "resp");
            b bVar = (b) s.this.f138063i.remove(resp.transaction);
            if (bVar != null) {
                boolean[] zArr = this.f138098b;
                com.tencent.luggage.wxaapi.i a16 = bVar.a();
                IWXAPIEventHandler b17 = bVar.b();
                boolean z16 = false;
                zArr[0] = true;
                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "handleIntentImpl, resp.transaction=" + resp.transaction);
                byte[] bArr = null;
                if (resp instanceof SendTdiAuth.Resp) {
                    resp2 = (SendTdiAuth.Resp) resp;
                } else {
                    resp2 = null;
                }
                if (resp2 != null) {
                    bArr = resp2.tdiAuthBuffer;
                }
                if (bArr != null) {
                    if (bArr.length == 0) {
                        z16 = true;
                    }
                    if (!z16) {
                        try {
                            com.tencent.luggage.wxa.x7.g.f144625e.a(bArr, a16);
                        } catch (Exception e16) {
                            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "handleIntentImpl fail, e:" + e16);
                            if (a16 != null) {
                                a16.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_System, resp.errStr);
                            }
                        }
                        if (b17 == null) {
                            SendAuth.Resp resp3 = new SendAuth.Resp();
                            b16 = com.tencent.luggage.wxa.q7.t.b(resp);
                            resp3.fromBundle(b16);
                            b17.onResp(resp3);
                            return;
                        }
                        return;
                    }
                }
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "handleIntentImpl, tdiAuthBuffer invalid, resp.errCode=" + resp.errCode + ", resp.errStr=" + resp.errStr);
                int i3 = resp.errCode;
                if (i3 != -4) {
                    if (i3 != -2) {
                        if (a16 != null) {
                            a16.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_System, resp.errStr);
                        }
                    } else if (a16 != null) {
                        a16.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_UserCanceled, resp.errStr);
                    }
                } else if (a16 != null) {
                    a16.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_UserDenied, resp.errStr);
                }
                if (b17 == null) {
                }
            }
        }

        @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
        public void onReq(BaseReq baseReq) {
        }
    }

    public final boolean a(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (com.tencent.luggage.wxa.v3.f.a(context, intent)) {
            f.a(f.f138080a, "handleIntent", true, null, 0, 12, null);
            return true;
        }
        boolean[] zArr = {false};
        this.f138058d.handleIntent(intent, new k(zArr));
        boolean z16 = zArr[0];
        f.a(f.f138080a, "handleIntent", z16, null, 0, 12, null);
        return z16;
    }

    public final Object a(Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        com.tencent.luggage.wxa.o3.l lVar = com.tencent.luggage.wxa.o3.l.f136139a;
        if (!lVar.c()) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "checkAuthStateSuspended() return NoAuth by not login");
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(TdiAuthState.WechatTdi_Auth_State_NoAuth));
        } else {
            com.tencent.luggage.wxa.n3.t k3 = com.tencent.luggage.wxa.x7.a.f144602d.k();
            if (k3 == null) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "checkAuthStateSuspended() return NoAuth by NULL tdiSession");
                Result.Companion companion2 = Result.INSTANCE;
                safeContinuation.resumeWith(Result.m476constructorimpl(TdiAuthState.WechatTdi_Auth_State_NoAuth));
            } else {
                com.tencent.luggage.wxa.n3.c0 loginStatus = k3.getLoginStatus();
                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", "checkAuthStateSuspended() tdiLoginStatus=" + loginStatus.name());
                int i3 = e.f138078a[loginStatus.ordinal()];
                if (i3 == 1 || i3 == 2) {
                    Result.Companion companion3 = Result.INSTANCE;
                    safeContinuation.resumeWith(Result.m476constructorimpl(TdiAuthState.WechatTdi_Auth_State_OK));
                } else if (i3 != 3) {
                    Result.Companion companion4 = Result.INSTANCE;
                    safeContinuation.resumeWith(Result.m476constructorimpl(TdiAuthState.WechatTdi_Auth_State_NoAuth));
                } else if (lVar.c()) {
                    q0.f135244a.a(new h(safeContinuation));
                } else {
                    Result.Companion companion5 = Result.INSTANCE;
                    safeContinuation.resumeWith(Result.m476constructorimpl(TdiAuthState.WechatTdi_Auth_State_NoAuth));
                }
            }
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final LaunchWxaAppWithShortLinkResult a(com.tencent.luggage.wxa.fk.c cVar) {
        switch (e.f138079b[cVar.ordinal()]) {
            case 1:
                return LaunchWxaAppWithShortLinkResult.SUCCESS;
            case 2:
                return LaunchWxaAppWithShortLinkResult.ILLEGAL_LINK;
            case 3:
                return LaunchWxaAppWithShortLinkResult.DECODE_LINK_FAIL;
            case 4:
                return LaunchWxaAppWithShortLinkResult.USER_CANCEL;
            case 5:
                return LaunchWxaAppWithShortLinkResult.CONTEXT_RELEASE;
            case 6:
                return LaunchWxaAppWithShortLinkResult.INTERRUPT;
            case 7:
                return LaunchWxaAppWithShortLinkResult.LAUNCH_PHASE_FAIL;
            default:
                return LaunchWxaAppWithShortLinkResult.UNKNOWN;
        }
    }

    public final long a(Context context, String str, int i3, String str2, String str3, Map map, com.tencent.luggage.wxaapi.d dVar) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("launchWxaApp wxaAppID:");
        sb5.append(str);
        sb5.append(" versionType:");
        sb5.append(i3);
        sb5.append(" enterPath:");
        sb5.append(str2);
        sb5.append(" shortLink:");
        sb5.append(str3 == null ? "" : str3);
        sb5.append(" hostExtraData.size:");
        sb5.append(map != null ? map.size() : 0);
        sb5.append(" start");
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaApiImpl", sb5.toString());
        long a16 = f.f138080a.a();
        com.tencent.luggage.wxa.u7.b bVar = com.tencent.luggage.wxa.u7.b.f142127a;
        bVar.a(a16, str, "", i3, new C6634s(dVar));
        if (str.length() == 0) {
            bVar.a(a16, LaunchWxaAppResult.FailWxaAppIdSync);
            return a16;
        }
        com.tencent.luggage.wxa.gi.b.b(com.tencent.luggage.wxa.ik.a.class, str);
        com.tencent.luggage.wxa.gi.b.a(com.tencent.luggage.wxa.ik.a.class, str, "Network:" + com.tencent.luggage.wxa.tn.h0.e(com.tencent.luggage.wxa.tn.z.c()));
        if (!isDynamicPkgLoaded()) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaApiImpl", "launchWxaApp rejected, dynamic pkg not loaded");
            bVar.a(a16, LaunchWxaAppResult.FailNotLoadDynamicPkg);
            com.tencent.luggage.wxa.gi.b.a(com.tencent.luggage.wxa.ik.a.class, str);
            return a16;
        }
        com.tencent.luggage.wxa.v7.d.f143293b.a(new t(str, map, context, a16, i3, str2, str3));
        return a16;
    }
}
