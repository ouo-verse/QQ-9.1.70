package com.tencent.luggage.wxa.f6;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/content/Intent;", "kotlin.jvm.PlatformType", "intent", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/va/a;", "callback", "", "a", "(Landroid/content/Intent;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes8.dex */
final class b<InputType, ResultType> implements com.tencent.luggage.wxa.ka.e {

    /* renamed from: a, reason: collision with root package name */
    public static final b f125322a = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f125323a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Application f125324b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ C6197b f125325c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ka.i f125326d;

        public a(Ref.BooleanRef booleanRef, Application application, C6197b c6197b, com.tencent.luggage.wxa.ka.i iVar) {
            this.f125323a = booleanRef;
            this.f125324b = application;
            this.f125325c = c6197b;
            this.f125326d = iVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!this.f125323a.element) {
                w.f("Luggage.ActivityLauncher", "ActivityLauncher onCreate not called, may be missing permission of calling startActivity at background");
                this.f125324b.unregisterActivityLifecycleCallbacks(this.f125325c);
                this.f125326d.a(new com.tencent.luggage.wxa.va.a(false));
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.f6.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6197b implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f125327a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f125328b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f125329c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Application f125330d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ka.i f125331e;

        public C6197b(Class cls, int i3, Ref.BooleanRef booleanRef, Application application, com.tencent.luggage.wxa.ka.i iVar) {
            this.f125327a = cls;
            this.f125328b = i3;
            this.f125329c = booleanRef;
            this.f125330d = application;
            this.f125331e = iVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (this.f125327a.isInstance(activity) && activity.getIntent() != null && activity.getIntent().getIntExtra("__activity_launcher_id", -1) == this.f125328b) {
                this.f125329c.element = true;
                this.f125330d.unregisterActivityLifecycleCallbacks(this);
                this.f125331e.a(new com.tencent.luggage.wxa.va.a(true));
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
        synchronized (com.tencent.luggage.wxa.f6.a.f125299b) {
            i3 = com.tencent.luggage.wxa.f6.a.f125300c;
            com.tencent.luggage.wxa.f6.a.f125300c = i3 + 1;
        }
        Context c16 = z.c();
        ComponentName component = intent.getComponent();
        Intrinsics.checkNotNull(component);
        String className = component.getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "intent.component!!.className");
        Class<?> cls = Class.forName(className);
        Application a16 = com.tencent.luggage.wxa.tn.a.a();
        Intrinsics.checkNotNullExpressionValue(a16, "context()");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        C6197b c6197b = new C6197b(cls, i3, booleanRef, a16, iVar);
        a16.registerActivityLifecycleCallbacks(c6197b);
        Intent putExtra = intent.addFlags(268435456).putExtra("__activity_launcher_id", i3);
        com.tencent.luggage.wxa.fa.b.a(c16, putExtra);
        c16.startActivity(putExtra);
        com.tencent.luggage.wxa.zp.h.f146825d.c(new a(booleanRef, a16, c6197b, iVar), 1000L);
    }
}
