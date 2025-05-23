package com.tencent.luggage.wxa.uk;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f142672a = {QQPermissionConstants.Permission.BLUETOOTH_SCAN, QQPermissionConstants.Permission.BLUETOOTH_CONNECT};

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f142673a;

        static {
            int[] iArr = new int[i0.values().length];
            iArr[i0.REQUEST_FAIL.ordinal()] = 1;
            iArr[i0.DENIED.ordinal()] = 2;
            iArr[i0.GRANTED.ordinal()] = 3;
            f142673a = iArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements e0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f142674a;

        public b(Continuation continuation) {
            this.f142674a = continuation;
        }

        @Override // com.tencent.luggage.wxa.uk.e0
        public final void a(i0 result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f142674a.resumeWith(Result.m476constructorimpl(result));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements ActivityCompat.OnRequestPermissionsResultCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f142675a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f142676b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f142677c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e0 f142678d;

        public c(int i3, String str, String str2, e0 e0Var) {
            this.f142675a = i3;
            this.f142676b = str;
            this.f142677c = str2;
            this.f142678d = e0Var;
        }

        @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
        public void onRequestPermissionsResult(int i3, String[] permissions, int[] grantResults) {
            Object orNull;
            Integer orNull2;
            int i16;
            i0 i0Var;
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(grantResults, "grantResults");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onRequestPermissionsResult, requestCode: ");
            sb5.append(i3);
            sb5.append(", permissions: ");
            String arrays = Arrays.toString(permissions);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            sb5.append(arrays);
            sb5.append(", grantResults: ");
            String arrays2 = Arrays.toString(grantResults);
            Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
            sb5.append(arrays2);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandEnvExt", sb5.toString());
            if (i3 != this.f142675a) {
                return;
            }
            com.tencent.luggage.wxa.rj.q.b(this.f142676b, this);
            String str = this.f142677c;
            boolean z16 = false;
            orNull = ArraysKt___ArraysKt.getOrNull(permissions, 0);
            if (Intrinsics.areEqual(str, orNull)) {
                orNull2 = ArraysKt___ArraysKt.getOrNull(grantResults, 0);
                if (orNull2 != null) {
                    i16 = orNull2.intValue();
                } else {
                    i16 = -1;
                }
                if (i16 == 0) {
                    z16 = true;
                }
                e0 e0Var = this.f142678d;
                if (z16) {
                    i0Var = i0.GRANTED;
                } else {
                    i0Var = i0.DENIED;
                }
                e0Var.a(i0Var);
                return;
            }
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandEnvExt", "onRequestPermissionsResult, permission not found");
            this.f142678d.a(i0.DENIED);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f142679a;

        /* renamed from: b, reason: collision with root package name */
        public Object f142680b;

        /* renamed from: c, reason: collision with root package name */
        public Object f142681c;

        /* renamed from: d, reason: collision with root package name */
        public Object f142682d;

        /* renamed from: e, reason: collision with root package name */
        public int f142683e;

        /* renamed from: f, reason: collision with root package name */
        public int f142684f;

        /* renamed from: g, reason: collision with root package name */
        public int f142685g;

        /* renamed from: h, reason: collision with root package name */
        public /* synthetic */ Object f142686h;

        /* renamed from: i, reason: collision with root package name */
        public int f142687i;

        public d(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f142686h = obj;
            this.f142687i |= Integer.MIN_VALUE;
            return f.a((com.tencent.luggage.wxa.xd.d) null, (String[]) null, 0, (String) null, (String) null, this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public Object f142688a;

        /* renamed from: b, reason: collision with root package name */
        public int f142689b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e0 f142690c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f142691d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String[] f142692e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f142693f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f142694g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f142695h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(e0 e0Var, com.tencent.luggage.wxa.xd.d dVar, String[] strArr, int i3, String str, String str2, Continuation continuation) {
            super(2, continuation);
            this.f142690c = e0Var;
            this.f142691d = dVar;
            this.f142692e = strArr;
            this.f142693f = i3;
            this.f142694g = str;
            this.f142695h = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new e(this.f142690c, this.f142691d, this.f142692e, this.f142693f, this.f142694g, this.f142695h, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            e0 e0Var;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f142689b;
            if (i3 != 0) {
                if (i3 == 1) {
                    e0Var = (e0) this.f142688a;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                e0 e0Var2 = this.f142690c;
                com.tencent.luggage.wxa.xd.d dVar = this.f142691d;
                String[] strArr = this.f142692e;
                int i16 = this.f142693f;
                String str = this.f142694g;
                String str2 = this.f142695h;
                this.f142688a = e0Var2;
                this.f142689b = 1;
                Object a16 = f.a(dVar, strArr, i16, str, str2, this);
                if (a16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                e0Var = e0Var2;
                obj = a16;
            }
            e0Var.a((i0) obj);
            return Unit.INSTANCE;
        }
    }

    public static final CoroutineScope a(com.tencent.luggage.wxa.xd.d dVar) {
        Lifecycle lifecycle;
        LifecycleCoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        LifecycleOwner lifecycleOwner = dVar.getLifecycleOwner();
        return (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null || (coroutineScope = LifecycleKt.getCoroutineScope(lifecycle)) == null) ? com.tencent.luggage.wxa.mn.a.a() : coroutineScope;
    }

    public static final void a(com.tencent.luggage.wxa.xd.d dVar, String permission, int i3, String reasonTitle, String reasonMsg, e0 callback) {
        boolean contains;
        i0 i0Var;
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(reasonTitle, "reasonTitle");
        Intrinsics.checkNotNullParameter(reasonMsg, "reasonMsg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (com.tencent.luggage.wxa.h6.k.a(com.tencent.luggage.wxa.tn.z.c(), dVar, permission)) {
            callback.a(i0.GRANTED);
            return;
        }
        contains = ArraysKt___ArraysKt.contains(f142672a, permission);
        if (contains && com.tencent.luggage.wxa.aa.a.a(31)) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandEnvExt", "requestPermissionAsync, request " + permission + " is blocked");
            if (com.tencent.luggage.wxa.h6.k.a(dVar.getContext(), dVar, permission)) {
                i0Var = i0.GRANTED;
            } else {
                i0Var = i0.REQUEST_FAIL;
            }
            callback.a(i0Var);
            return;
        }
        Context context = dVar.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandEnvExt", "requestPermissionAsync, activity is null");
            callback.a(i0.REQUEST_FAIL);
            return;
        }
        String appId = dVar.getAppId();
        if (appId == null) {
            appId = "";
        }
        c cVar = new c(i3, appId, permission, callback);
        com.tencent.luggage.wxa.rj.q.a(appId, cVar);
        if (com.tencent.luggage.wxa.h6.k.a(activity, dVar, permission, i3, reasonTitle, reasonMsg)) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandEnvExt", "requestPermissionAsync, not need");
            com.tencent.luggage.wxa.rj.q.b(appId, cVar);
            callback.a(i0.GRANTED);
        } else {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandEnvExt", "requestPermissionAsync, do request, myRequestCode: " + i3);
        }
    }

    public static final Object a(com.tencent.luggage.wxa.xd.d dVar, String str, int i3, String str2, String str3, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        a(dVar, str, i3, str2, str3, new b(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x006c -> B:11:0x00b5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006f -> B:11:0x00b5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0096 -> B:10:0x00a1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(com.tencent.luggage.wxa.xd.d dVar, String[] strArr, int i3, String str, String str2, Continuation continuation) {
        d dVar2;
        Object coroutine_suspended;
        int i16;
        String[] strArr2;
        d dVar3;
        Object obj;
        int length;
        int i17;
        int i18;
        String str3;
        String str4;
        i0 i0Var;
        com.tencent.luggage.wxa.xd.d dVar4;
        if (continuation instanceof d) {
            dVar2 = (d) continuation;
            int i19 = dVar2.f142687i;
            if ((i19 & Integer.MIN_VALUE) != 0) {
                dVar2.f142687i = i19 - Integer.MIN_VALUE;
                Object obj2 = dVar2.f142686h;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = dVar2.f142687i;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    i0 i0Var2 = i0.GRANTED;
                    strArr2 = strArr;
                    dVar3 = dVar2;
                    obj = coroutine_suspended;
                    length = strArr2.length;
                    i17 = 0;
                    i18 = i3;
                    str3 = str;
                    str4 = str2;
                    i0Var = i0Var2;
                    dVar4 = dVar;
                    if (i17 < length) {
                    }
                } else {
                    if (i16 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i26 = dVar2.f142685g;
                    int i27 = dVar2.f142684f;
                    int i28 = dVar2.f142683e;
                    String[] strArr3 = (String[]) dVar2.f142682d;
                    String str5 = (String) dVar2.f142681c;
                    String str6 = (String) dVar2.f142680b;
                    com.tencent.luggage.wxa.xd.d dVar5 = (com.tencent.luggage.wxa.xd.d) dVar2.f142679a;
                    ResultKt.throwOnFailure(obj2);
                    int i29 = i28;
                    i0Var = (i0) obj2;
                    dVar4 = dVar5;
                    i17 = i27;
                    str4 = str5;
                    obj = coroutine_suspended;
                    str3 = str6;
                    length = i26;
                    strArr2 = strArr3;
                    dVar3 = dVar2;
                    i18 = i29;
                    i17++;
                    if (i17 < length) {
                        String str7 = strArr2[i17];
                        int i36 = a.f142673a[i0Var.ordinal()];
                        if (i36 != 1 && i36 != 2) {
                            if (i36 != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            dVar3.f142679a = dVar4;
                            dVar3.f142680b = str3;
                            dVar3.f142681c = str4;
                            dVar3.f142682d = strArr2;
                            dVar3.f142683e = i18;
                            dVar3.f142684f = i17;
                            dVar3.f142685g = length;
                            dVar3.f142687i = 1;
                            Object a16 = a(dVar4, str7, i18, str3, str4, dVar3);
                            if (a16 == obj) {
                                return obj;
                            }
                            int i37 = i17;
                            dVar5 = dVar4;
                            obj2 = a16;
                            i28 = i18;
                            dVar2 = dVar3;
                            strArr3 = strArr2;
                            i26 = length;
                            str6 = str3;
                            coroutine_suspended = obj;
                            str5 = str4;
                            i27 = i37;
                            int i292 = i28;
                            i0Var = (i0) obj2;
                            dVar4 = dVar5;
                            i17 = i27;
                            str4 = str5;
                            obj = coroutine_suspended;
                            str3 = str6;
                            length = i26;
                            strArr2 = strArr3;
                            dVar3 = dVar2;
                            i18 = i292;
                        }
                        i17++;
                        if (i17 < length) {
                            return i0Var;
                        }
                    }
                }
            }
        }
        dVar2 = new d(continuation);
        Object obj22 = dVar2.f142686h;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = dVar2.f142687i;
        if (i16 != 0) {
        }
    }

    public static final void a(com.tencent.luggage.wxa.xd.d dVar, String[] permissions, int i3, String reasonTitle, String reasonMsg, e0 callback) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(reasonTitle, "reasonTitle");
        Intrinsics.checkNotNullParameter(reasonMsg, "reasonMsg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(a(dVar), null, null, new e(callback, dVar, permissions, i3, reasonTitle, reasonMsg, null), 3, null);
    }
}
