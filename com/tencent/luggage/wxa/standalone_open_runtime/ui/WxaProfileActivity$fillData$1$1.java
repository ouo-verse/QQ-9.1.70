package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.hn.se;
import com.tencent.luggage.wxa.k7.d;
import com.tencent.luggage.wxa.n3.g0;
import com.tencent.luggage.wxa.tn.w0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity$fillData$1$1", f = "WxaProfileActivity.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class WxaProfileActivity$fillData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f140761a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f140762b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WxaProfileActivity f140763c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity$fillData$1$1$1", f = "WxaProfileActivity.kt", i = {}, l = {200, 236}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity$fillData$1$1$1, reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f140764a;

        /* renamed from: b, reason: collision with root package name */
        public int f140765b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f140766c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ WxaProfileActivity f140767d;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/luggage/wxa/fd/n0;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity$fillData$1$1$1$1", f = "WxaProfileActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity$fillData$1$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C67281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super n0>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f140768a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f140769b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ WxaProfileActivity f140770c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C67281(String str, WxaProfileActivity wxaProfileActivity, Continuation continuation) {
                super(2, continuation);
                this.f140769b = str;
                this.f140770c = wxaProfileActivity;
            }

            public static final n0 a(String str, WxaProfileActivity wxaProfileActivity) {
                n0 a16 = o0.a().a(str, "appId", "username", "nickname", "signature", "brandIconURL", "dynamicInfo", "versionInfo", "appInfo", "registerSource", "bindWxaInfo");
                if (a16 != null) {
                    String str2 = a16.f138465d;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.field_username");
                    wxaProfileActivity.wxaUsername = str2;
                    String str3 = a16.f138467f;
                    Intrinsics.checkNotNullExpressionValue(str3, "it.field_appId");
                    wxaProfileActivity.wxaAppID = str3;
                }
                return a16;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C67281(this.f140769b, this.f140770c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f140768a == 0) {
                    ResultKt.throwOnFailure(obj);
                    n0 a16 = a(this.f140769b, this.f140770c);
                    if (a16 == null) {
                        se a17 = g0.a(g0.f135177a, this.f140769b, null, 2, null);
                        o0.a().b(this.f140769b, a17);
                        return a(this.f140769b, this.f140770c);
                    }
                    return a16;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super n0> continuation) {
                return ((C67281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, WxaProfileActivity wxaProfileActivity, Continuation continuation) {
            super(2, continuation);
            this.f140766c = str;
            this.f140767d = wxaProfileActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.f140766c, this.f140767d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            String b16;
            WxaProfileActivity wxaProfileActivity;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f140765b;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        wxaProfileActivity = (WxaProfileActivity) this.f140764a;
                        ResultKt.throwOnFailure(obj);
                        wxaProfileActivity.a(((Number) obj).doubleValue());
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io5 = Dispatchers.getIO();
                C67281 c67281 = new C67281(this.f140766c, this.f140767d, null);
                this.f140765b = 1;
                obj = BuildersKt.withContext(io5, c67281, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            n0 n0Var = (n0) obj;
            if (n0Var != null) {
                WxaProfileActivity wxaProfileActivity2 = this.f140767d;
                String str = n0Var.f138469h;
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                wxaProfileActivity2.e(str);
                String str3 = n0Var.f138473l;
                if (str3 == null) {
                    str3 = "";
                }
                wxaProfileActivity2.d(str3);
                String str4 = n0Var.f138481t;
                if (str4 == null) {
                    str4 = "";
                }
                wxaProfileActivity2.c(str4);
                wxaProfileActivity2.b(n0Var.g().f125894a.M);
                try {
                    if (!w0.c(n0Var.f138485x)) {
                        String it = new JSONObject(n0Var.f138485x).optString("RegisterBody", "");
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        wxaProfileActivity2.b(it);
                    }
                } catch (Exception unused) {
                }
                b16 = d.b(n0Var.g().f125895b);
                wxaProfileActivity2.a(b16);
                String str5 = n0Var.f138465d;
                if (str5 != null) {
                    str2 = str5;
                }
                this.f140764a = wxaProfileActivity2;
                this.f140765b = 2;
                obj = com.tencent.luggage.wxa.s6.a.a(str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                wxaProfileActivity = wxaProfileActivity2;
                wxaProfileActivity.a(((Number) obj).doubleValue());
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WxaProfileActivity$fillData$1$1(String str, WxaProfileActivity wxaProfileActivity, Continuation continuation) {
        super(2, continuation);
        this.f140762b = str;
        this.f140763c = wxaProfileActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WxaProfileActivity$fillData$1$1(this.f140762b, this.f140763c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.f140761a;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f140762b, this.f140763c, null);
            this.f140761a = 1;
            if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WxaProfileActivity$fillData$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
