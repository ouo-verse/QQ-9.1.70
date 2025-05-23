package com.tencent.luggage.wxa.f6;

import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Consumer;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import java.util.HashMap;
import kotlin.Metadata;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends AppCompatActivity {

    /* renamed from: c, reason: collision with root package name */
    public static int f125300c;

    /* renamed from: a, reason: collision with root package name */
    public static final C6194a f125298a = new C6194a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final Object f125299b = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static HashMap f125301d = new HashMap();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.f6.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6194a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.f6.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6195a extends Exception {
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.f6.a$a$b */
        /* loaded from: classes8.dex */
        public static final class b {

            /* renamed from: a, reason: collision with root package name */
            public final Function0 f125302a;

            /* renamed from: b, reason: collision with root package name */
            public final Function1 f125303b;

            public b(Function0 function0, Function1 callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                this.f125302a = function0;
                this.f125303b = callback;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.f6.a$a$c */
        /* loaded from: classes8.dex */
        public static final class c extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f125304a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context f125305b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Intent f125306c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ LuggageActivityHelper.d f125307d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Consumer f125308e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Context context, Intent intent, LuggageActivityHelper.d dVar, Consumer consumer, Continuation continuation) {
                super(2, continuation);
                this.f125305b = context;
                this.f125306c = intent;
                this.f125307d = dVar;
                this.f125308e = consumer;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new c(this.f125305b, this.f125306c, this.f125307d, this.f125308e, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f125304a;
                try {
                    if (i3 != 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        C6194a c6194a = a.f125298a;
                        Context context = this.f125305b;
                        Intent intent = this.f125306c;
                        this.f125304a = 1;
                        obj = C6194a.a(c6194a, context, intent, null, this, 4, null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    ActivityResult activityResult = (ActivityResult) obj;
                    this.f125307d.a(activityResult.getResultCode(), activityResult.getData());
                } catch (Exception e16) {
                    Consumer consumer = this.f125308e;
                    if (consumer != null) {
                        consumer.accept(e16);
                    }
                    w.b("Luggage.ActivityLauncher", "startActivityForResult failed, intent: " + this.f125306c + ", " + e16);
                }
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.f6.a$a$d */
        /* loaded from: classes8.dex */
        public static final class d implements LuggageActivityHelper.d {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Continuation f125309a;

            public d(Continuation continuation) {
                this.f125309a = continuation;
            }

            @Override // com.tencent.luggage.util.LuggageActivityHelper.d
            public final void a(int i3, Intent intent) {
                Continuation continuation = this.f125309a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(new ActivityResult(i3, intent)));
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/content/Intent;", "kotlin.jvm.PlatformType", "intent", "Lcom/tencent/luggage/wxa/ka/i;", "Landroid/os/Bundle;", "callback", "", "a", "(Landroid/content/Intent;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
        /* renamed from: com.tencent.luggage.wxa.f6.a$a$e */
        /* loaded from: classes8.dex */
        public static final class e<InputType, ResultType> implements com.tencent.luggage.wxa.ka.f {

            /* renamed from: a, reason: collision with root package name */
            public static final e f125310a = new e();

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.f6.a$a$e$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6196a extends Lambda implements Function0 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.ka.i f125311a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C6196a(com.tencent.luggage.wxa.ka.i iVar) {
                    super(0);
                    this.f125311a = iVar;
                }

                public final void a() {
                    com.tencent.luggage.wxa.ka.i iVar = this.f125311a;
                    Bundle bundle = new Bundle();
                    bundle.putInt("start", 3);
                    iVar.a(bundle);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return Unit.INSTANCE;
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.f6.a$a$e$b */
            /* loaded from: classes8.dex */
            public static final class b extends Lambda implements Function1 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.ka.i f125312a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(com.tencent.luggage.wxa.ka.i iVar) {
                    super(1);
                    this.f125312a = iVar;
                }

                public final void a(Object obj) {
                    com.tencent.luggage.wxa.ka.i iVar = this.f125312a;
                    Bundle bundle = new Bundle();
                    if (Result.m483isSuccessimpl(obj)) {
                        bundle.putInt("start", 1);
                        if (Result.m482isFailureimpl(obj)) {
                            obj = null;
                        }
                        Intrinsics.checkNotNull(obj);
                        bundle.putParcelable("activityResult", (Parcelable) obj);
                    } else {
                        bundle.putInt("start", 2);
                    }
                    iVar.a(bundle);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a(((Result) obj).getValue());
                    return Unit.INSTANCE;
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.f6.a$a$e$c */
            /* loaded from: classes8.dex */
            public static final class c implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Ref.BooleanRef f125313a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Application f125314b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ d f125315c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.ka.i f125316d;

                public c(Ref.BooleanRef booleanRef, Application application, d dVar, com.tencent.luggage.wxa.ka.i iVar) {
                    this.f125313a = booleanRef;
                    this.f125314b = application;
                    this.f125315c = dVar;
                    this.f125316d = iVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (!this.f125313a.element) {
                        w.f("Luggage.ActivityLauncher", "ActivityLauncher onCreate not called, may be missing permission of calling startActivity at background");
                        this.f125314b.unregisterActivityLifecycleCallbacks(this.f125315c);
                        com.tencent.luggage.wxa.ka.i iVar = this.f125316d;
                        Bundle bundle = new Bundle();
                        bundle.putInt("start", 0);
                        iVar.a(bundle);
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.f6.a$a$e$d */
            /* loaded from: classes8.dex */
            public static final class d implements Application.ActivityLifecycleCallbacks {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ int f125317a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Ref.BooleanRef f125318b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ Application f125319c;

                public d(int i3, Ref.BooleanRef booleanRef, Application application) {
                    this.f125317a = i3;
                    this.f125318b = booleanRef;
                    this.f125319c = application;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    boolean z16;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    if (a.class.isInstance(activity)) {
                        Intent intent = activity.getIntent();
                        if (intent != null && intent.getIntExtra("__activity_launcher_id", -1) == this.f125317a) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            this.f125318b.element = true;
                            this.f125319c.unregisterActivityLifecycleCallbacks(this);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Intrinsics.checkNotNullParameter(outState, "outState");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                }
            }

            @Override // com.tencent.luggage.wxa.ka.f
            public final void a(Intent intent, com.tencent.luggage.wxa.ka.i iVar) {
                int i3;
                synchronized (a.f125299b) {
                    i3 = a.f125300c;
                    a.f125300c = i3 + 1;
                }
                a.f125301d.put(Integer.valueOf(i3), new b(new C6196a(iVar), new b(iVar)));
                Context c16 = z.c();
                Application a16 = com.tencent.luggage.wxa.tn.a.a();
                Intrinsics.checkNotNullExpressionValue(a16, "context()");
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                d dVar = new d(i3, booleanRef, a16);
                a16.registerActivityLifecycleCallbacks(dVar);
                Intent addFlags = new Intent(c16, (Class<?>) a.class).putExtra("__activity_launcher_id", i3).putExtra("intent", intent).addFlags(268435456);
                com.tencent.luggage.wxa.fa.b.a(c16, addFlags);
                c16.startActivity(addFlags);
                com.tencent.luggage.wxa.zp.h.f146825d.c(new c(booleanRef, a16, dVar, iVar), 1000L);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.f6.a$a$f */
        /* loaded from: classes8.dex */
        public static final class f extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Continuation f125320a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function0 f125321b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(Continuation continuation, Function0 function0) {
                super(1);
                this.f125320a = continuation;
                this.f125321b = function0;
            }

            public final void a(Bundle result) {
                Function0 function0;
                Intrinsics.checkNotNullParameter(result, "result");
                int i3 = result.getInt("start", 0);
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3 && (function0 = this.f125321b) != null) {
                                function0.invoke();
                                return;
                            }
                            return;
                        }
                        Continuation continuation = this.f125320a;
                        Result.Companion companion = Result.INSTANCE;
                        continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new ActivityNotFoundException())));
                        return;
                    }
                    Continuation continuation2 = this.f125320a;
                    Result.Companion companion2 = Result.INSTANCE;
                    Parcelable parcelable = result.getParcelable("activityResult");
                    Intrinsics.checkNotNull(parcelable);
                    continuation2.resumeWith(Result.m476constructorimpl(parcelable));
                    return;
                }
                Continuation continuation3 = this.f125320a;
                Result.Companion companion3 = Result.INSTANCE;
                continuation3.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new C6195a())));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Bundle) obj);
                return Unit.INSTANCE;
            }
        }

        public C6194a() {
        }

        public /* synthetic */ C6194a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, Intent intent, LuggageActivityHelper.d callback, Consumer consumer) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(callback, "callback");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new c(context, intent, callback, consumer, null), 3, null);
        }

        public final Object a(Context context, Intent intent, Function0 function0, Continuation continuation) {
            Continuation intercepted;
            Object coroutine_suspended;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            if (context instanceof Activity) {
                com.tencent.luggage.wxa.er.a.b(context instanceof LuggageActivityHelper.g);
                LuggageActivityHelper.FOR(context).startActivityForResult(intent, new d(safeContinuation));
            } else {
                String g16 = z.g();
                Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
                com.tencent.luggage.wxa.ka.b.a(g16, intent, e.f125310a, new f(safeContinuation, function0));
            }
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }

        public static /* synthetic */ Object a(C6194a c6194a, Context context, Intent intent, Function0 function0, Continuation continuation, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                function0 = null;
            }
            return c6194a.a(context, intent, function0, continuation);
        }
    }

    public static final void a(Context context, Intent intent, LuggageActivityHelper.d dVar, Consumer consumer) {
        f125298a.a(context, intent, dVar, consumer);
    }
}
