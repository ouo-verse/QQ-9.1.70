package com.tencent.luggage.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.ga.a;
import com.tencent.luggage.wxa.hn.se;
import com.tencent.luggage.wxa.lo.m;
import com.tencent.luggage.wxa.n3.g0;
import com.tencent.luggage.wxa.tn.r;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.plugin.appbrand.ui.WxaDefaultIcon;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0002\t\u000eB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0013\u0010\t\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0002R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/luggage/ui/WxaAppLibNotSupportTipsUI;", "Landroid/app/Activity;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "finish", "Lcom/tencent/luggage/wxa/fd/n0;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "color", "", "b", "Ljava/lang/String;", "appId", "Lkotlinx/coroutines/CoroutineScope;", "c", "Lkotlinx/coroutines/CoroutineScope;", "mainScope", "<init>", "()V", "d", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public class WxaAppLibNotSupportTipsUI extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public String appId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public CoroutineScope mainScope;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.ui.WxaAppLibNotSupportTipsUI$a, reason: from kotlin metadata */
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, String appId) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Activity a16 = com.tencent.luggage.wxa.bo.a.a(context);
            Intent intent = new Intent(z.c(), (Class<?>) WxaAppLibNotSupportTipsUI.class);
            intent.putExtra("KEY_APPID", appId);
            if (a16 != null) {
                com.tencent.luggage.wxa.fa.b.a(a16, intent);
                a16.startActivity(intent);
            } else {
                intent.addFlags(268435456);
                Context c16 = z.c();
                com.tencent.luggage.wxa.fa.b.a(c16, intent);
                c16.startActivity(intent);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b extends com.tencent.luggage.wxa.on.c {

        /* renamed from: d, reason: collision with root package name */
        public final String f120299d;

        /* renamed from: e, reason: collision with root package name */
        public final String f120300e;

        public b(String wxaAppId, String wxaAppUsername) {
            Intrinsics.checkNotNullParameter(wxaAppId, "wxaAppId");
            Intrinsics.checkNotNullParameter(wxaAppUsername, "wxaAppUsername");
            this.f120299d = wxaAppId;
            this.f120300e = wxaAppUsername;
        }

        public final String d() {
            return this.f120300e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (Intrinsics.areEqual(this.f120299d, bVar.f120299d) && Intrinsics.areEqual(this.f120300e, bVar.f120300e)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f120299d.hashCode() * 31) + this.f120300e.hashCode();
        }

        public String toString() {
            return "EventOnUserRequestedRedirectToWechat(wxaAppId=" + this.f120299d + ", wxaAppUsername=" + this.f120300e + ')';
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f120302b;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class a implements e.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WxaAppLibNotSupportTipsUI f120303a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CancellableContinuation f120304b;

            public a(WxaAppLibNotSupportTipsUI wxaAppLibNotSupportTipsUI, CancellableContinuation cancellableContinuation) {
                this.f120303a = wxaAppLibNotSupportTipsUI;
                this.f120304b = cancellableContinuation;
            }

            @Override // com.tencent.luggage.wxa.xo.e.c
            public final void a(se seVar) {
                n0 b16 = c.b(this.f120303a);
                if (b16 != null) {
                    CancellableContinuation cancellableContinuation = this.f120304b;
                    if (cancellableContinuation.isActive()) {
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(b16));
                    }
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class b extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.e f120305a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(com.tencent.luggage.wxa.xo.e eVar) {
                super(1);
                this.f120305a = eVar;
            }

            public final void a(Throwable th5) {
                this.f120305a.stop();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return Unit.INSTANCE;
            }
        }

        public c(CancellableContinuation cancellableContinuation) {
            this.f120302b = cancellableContinuation;
        }

        public static final n0 b(WxaAppLibNotSupportTipsUI wxaAppLibNotSupportTipsUI) {
            o0 a16 = o0.a();
            String str = wxaAppLibNotSupportTipsUI.appId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appId");
                str = null;
            }
            return a16.a(str, "brandIconURL", "nickname", "username", "appId");
        }

        @Override // java.lang.Runnable
        public final void run() {
            n0 b16 = b(WxaAppLibNotSupportTipsUI.this);
            if (b16 == null) {
                String str = WxaAppLibNotSupportTipsUI.this.appId;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appId");
                    str = null;
                }
                this.f120302b.invokeOnCancellation(new b(g0.a(str, null, 2, null).a(new a(WxaAppLibNotSupportTipsUI.this, this.f120302b))));
                return;
            }
            CancellableContinuation cancellableContinuation = this.f120302b;
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(b16));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class d extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public Object f120306a;

        /* renamed from: b, reason: collision with root package name */
        public int f120307b;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n0 f120309a;

            public a(n0 n0Var) {
                this.f120309a = n0Var;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                String str = this.f120309a.f138467f;
                Intrinsics.checkNotNullExpressionValue(str, "wxaAttributes.field_appId");
                String str2 = this.f120309a.f138465d;
                Intrinsics.checkNotNullExpressionValue(str2, "wxaAttributes.field_username");
                new b(str, str2).c();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public d(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new d(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            View view;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f120307b;
            if (i3 != 0) {
                if (i3 == 1) {
                    view = (View) this.f120306a;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                View findViewById = WxaAppLibNotSupportTipsUI.this.findViewById(R.id.tg9);
                if (findViewById != null) {
                    findViewById.setEnabled(false);
                }
                WxaAppLibNotSupportTipsUI wxaAppLibNotSupportTipsUI = WxaAppLibNotSupportTipsUI.this;
                this.f120306a = findViewById;
                this.f120307b = 1;
                Object a16 = wxaAppLibNotSupportTipsUI.a(this);
                if (a16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                view = findViewById;
                obj = a16;
            }
            n0 n0Var = (n0) obj;
            ImageView imageView = (ImageView) WxaAppLibNotSupportTipsUI.this.findViewById(R.id.y_r);
            if (imageView != null) {
                AppBrandSimpleImageLoader.instance().attach(imageView, n0Var.f138473l, WxaDefaultIcon.get(), WxaIconTransformation.INSTANCE);
            }
            TextView textView = (TextView) WxaAppLibNotSupportTipsUI.this.findViewById(R.id.f112636og);
            if (textView != null) {
                textView.setText(n0Var.f138469h);
            }
            if (view != null) {
                view.setEnabled(true);
                view.setOnClickListener(new a(n0Var));
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class e extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f120310a;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static final class a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f120312a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ WxaAppLibNotSupportTipsUI f120313b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(WxaAppLibNotSupportTipsUI wxaAppLibNotSupportTipsUI, Continuation continuation) {
                super(2, continuation);
                this.f120313b = wxaAppLibNotSupportTipsUI;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.f120313b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f120312a == 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        Context applicationContext = this.f120313b.getApplicationContext();
                        PackageManager packageManager = applicationContext.getPackageManager();
                        return packageManager.getApplicationLabel(packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)).toString();
                    } catch (Exception unused) {
                        return null;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public e(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new e(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            boolean z16;
            TextView textView;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f120310a;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io5 = Dispatchers.getIO();
                a aVar = new a(WxaAppLibNotSupportTipsUI.this, null);
                this.f120310a = 1;
                obj = BuildersKt.withContext(io5, aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            String str = (String) obj;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && (textView = (TextView) WxaAppLibNotSupportTipsUI.this.findViewById(R.id.f167043k74)) != null) {
                textView.setText(z.a(R.string.f242357uc, str));
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            WxaAppLibNotSupportTipsUI.this.finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public final void a(int color) {
        com.tencent.luggage.wxa.lo.f.a((Activity) this, color);
        com.tencent.luggage.wxa.lo.f.b(getWindow(), !m.a(color));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.luggage.wxa.ga.a, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.f154490m0, R.anim.f154492m2);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.luggage.wxa.ga.a, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        boolean z16;
        CoroutineScope coroutineScope;
        CoroutineScope coroutineScope2;
        setTheme(R.style.ajq);
        super.onCreate(savedInstanceState);
        String a16 = r.a(getIntent(), "KEY_APPID");
        if (a16 == null) {
            a16 = "";
        }
        this.appId = a16;
        if (a16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            finish();
            return;
        }
        setContentView(R.layout.dr6);
        a(ContextCompat.getColor(this, R.color.agv));
        overridePendingTransition(R.anim.m3, R.anim.f154490m0);
        CoroutineScope MainScope = CoroutineScopeKt.MainScope();
        this.mainScope = MainScope;
        if (MainScope == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainScope");
            coroutineScope = null;
        } else {
            coroutineScope = MainScope;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new d(null), 3, null);
        CoroutineScope coroutineScope3 = this.mainScope;
        if (coroutineScope3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainScope");
            coroutineScope2 = null;
        } else {
            coroutineScope2 = coroutineScope3;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new e(null), 3, null);
        View findViewById = findViewById(R.id.dum);
        if (findViewById != null) {
            findViewById.setOnClickListener(new f());
        }
    }

    @Override // com.tencent.luggage.wxa.ga.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CoroutineScope coroutineScope = this.mainScope;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel(coroutineScope, new CancellationException(MosaicConstants$JsFunction.FUNC_ON_DESTROY));
        }
    }

    public final Object a(Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        h.f146825d.d(new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
