package com.tencent.luggage.wxa.k5;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.luggage.wxa.tn.w;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends ViewModel {

    /* renamed from: h, reason: collision with root package name */
    public static final b f131477h = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public final n f131478a;

    /* renamed from: b, reason: collision with root package name */
    public final MutableLiveData f131479b;

    /* renamed from: c, reason: collision with root package name */
    public final LiveData f131480c;

    /* renamed from: d, reason: collision with root package name */
    public final MutableLiveData f131481d;

    /* renamed from: e, reason: collision with root package name */
    public final LiveData f131482e;

    /* renamed from: f, reason: collision with root package name */
    public final MutableLiveData f131483f;

    /* renamed from: g, reason: collision with root package name */
    public final LiveData f131484g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public Object f131485a;

        /* renamed from: b, reason: collision with root package name */
        public int f131486b;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f131488d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Continuation continuation) {
            super(2, continuation);
            this.f131488d = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new a(this.f131488d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            MutableLiveData mutableLiveData;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f131486b;
            try {
                if (i3 != 0) {
                    if (i3 == 1) {
                        mutableLiveData = (MutableLiveData) this.f131485a;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    MutableLiveData mutableLiveData2 = f.this.f131479b;
                    com.tencent.luggage.wxa.rk.a aVar = com.tencent.luggage.wxa.rk.a.f139822a;
                    String str = this.f131488d;
                    this.f131485a = mutableLiveData2;
                    this.f131486b = 1;
                    Object a16 = aVar.a(str, this);
                    if (a16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableLiveData = mutableLiveData2;
                    obj = a16;
                }
                mutableLiveData.setValue(obj);
            } catch (Exception e16) {
                w.f("MicroMsg.AppBrand.UserInfoRevokeViewModel", "<init>, getUsageInfo fail since " + e16);
                f.this.f131478a.finish();
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends ViewModelProvider.NewInstanceFactory {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f131489a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f131490b;

            public a(n nVar, String str) {
                this.f131489a = nVar;
                this.f131490b = str;
            }

            @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
            public ViewModel create(Class modelClass) {
                Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                if (Intrinsics.areEqual(f.class, modelClass)) {
                    return new f(this.f131489a, this.f131490b, null);
                }
                ViewModel create = super.create(modelClass);
                Intrinsics.checkNotNullExpressionValue(create, "super.create(modelClass)");
                return create;
            }
        }

        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ViewModelProvider a(n host, String appId) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(appId, "appId");
            return new ViewModelProvider(host, new a(host, appId));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f131491a;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.i5.h f131493c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.tencent.luggage.wxa.i5.h hVar, Continuation continuation) {
            super(2, continuation);
            this.f131493c = hVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new c(this.f131493c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f131491a;
            try {
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    f.this.f131483f.setValue(com.tencent.luggage.wxa.i5.g.DOING);
                    if (this.f131493c.b() != null) {
                        com.tencent.luggage.wxa.rk.a aVar = com.tencent.luggage.wxa.rk.a.f139822a;
                        String str = this.f131493c.a().f127725d;
                        String str2 = this.f131493c.b().f127725d;
                        String str3 = this.f131493c.c().f128271d;
                        this.f131491a = 1;
                        if (aVar.a(str, str2, str3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        com.tencent.luggage.wxa.rk.a aVar2 = com.tencent.luggage.wxa.rk.a.f139822a;
                        String str4 = this.f131493c.a().f127725d;
                        String str5 = this.f131493c.c().f128271d;
                        this.f131491a = 2;
                        if (aVar2.a(str4, str5, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                this.f131493c.c().f128273f = 7;
                f.this.f131479b.setValue(f.this.f131479b.getValue());
                f.this.f131483f.setValue(com.tencent.luggage.wxa.i5.g.SUCCESS);
            } catch (Exception e16) {
                w.f("MicroMsg.AppBrand.UserInfoRevokeViewModel", "onRevokeBtnClick, revoke fail since " + e16);
                f.this.f131483f.setValue(com.tencent.luggage.wxa.i5.g.FAILURE);
            }
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ f(n nVar, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(nVar, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d() {
        w.d("MicroMsg.AppBrand.UserInfoRevokeViewModel", "onManageBtnClick");
        com.tencent.luggage.wxa.i5.f fVar = (com.tencent.luggage.wxa.i5.f) this.f131481d.getValue();
        if (fVar == null) {
            fVar = com.tencent.luggage.wxa.i5.f.NORMAL;
        }
        Intrinsics.checkNotNullExpressionValue(fVar, "_pageModeObservable.valu\u2026InfoRevokePageMode.NORMAL");
        MutableLiveData mutableLiveData = this.f131481d;
        com.tencent.luggage.wxa.i5.f fVar2 = com.tencent.luggage.wxa.i5.f.NORMAL;
        if (fVar2 == fVar) {
            fVar2 = com.tencent.luggage.wxa.i5.f.MANAGE;
        }
        mutableLiveData.setValue(fVar2);
    }

    public f(n nVar, String str) {
        this.f131478a = nVar;
        MutableLiveData mutableLiveData = new MutableLiveData(null);
        this.f131479b = mutableLiveData;
        this.f131480c = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData(com.tencent.luggage.wxa.i5.f.NORMAL);
        this.f131481d = mutableLiveData2;
        this.f131482e = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData(null);
        this.f131483f = mutableLiveData3;
        this.f131484g = mutableLiveData3;
        w.d("MicroMsg.AppBrand.UserInfoRevokeViewModel", "<init>, appId: " + str);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(nVar), null, null, new a(str, null), 3, null);
    }

    public final LiveData a() {
        return this.f131482e;
    }

    public final LiveData b() {
        return this.f131484g;
    }

    public final LiveData c() {
        return this.f131480c;
    }

    public final void a(com.tencent.luggage.wxa.i5.h usageInfoItem) {
        Intrinsics.checkNotNullParameter(usageInfoItem, "usageInfoItem");
        if (com.tencent.luggage.wxa.i5.a.f129468a.a()) {
            w.a("MicroMsg.AppBrand.UserInfoRevokeViewModel", "onRevokeBtnClick, usageInfoItem: " + usageInfoItem);
        } else {
            w.d("MicroMsg.AppBrand.UserInfoRevokeViewModel", "onRevokeBtnClick");
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f131478a), null, null, new c(usageInfoItem, null), 3, null);
    }
}
