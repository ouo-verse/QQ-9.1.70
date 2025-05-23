package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.luggage.wxa.h1.e;
import com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerActivity0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.o;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Y\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016J-\u0010\b\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\r*\u0004\u0018\u00010\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\b\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0007R\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u000b\u0010\u001eR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010!\u00a8\u0006#"}, d2 = {"com/tencent/luggage/wxa/standalone_open_runtime/ui/WxaEnterWechatInvokeManager$invoke$invokeContext$1", "Lcom/tencent/luggage/wxa/v3/b;", "Landroidx/lifecycle/LifecycleObserver;", "", "getAppId", "Lcom/tencent/luggage/wxa/vo/a;", "target", "", "b", "apiName", "Lcom/tencent/luggage/wxa/xd/o;", "a", "Lcom/tencent/luggage/wxa/h1/b;", "T", "Ljava/lang/Class;", "clazz", "(Ljava/lang/Class;)Lcom/tencent/luggage/wxa/h1/b;", "", h.F, "Landroid/content/Context;", "getContext", "", "d", "j", "f", "Ljava/lang/Runnable;", "runnable", "release", "onActivityResumed", "Lkotlin/Lazy;", "()Ljava/lang/String;", "_callbackActivityClass", "Ljava/util/concurrent/ConcurrentSkipListSet;", "Ljava/util/concurrent/ConcurrentSkipListSet;", "_onResumeListeners", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class WxaEnterWechatInvokeManager$invoke$invokeContext$1 implements com.tencent.luggage.wxa.v3.b, LifecycleObserver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy _callbackActivityClass;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ConcurrentSkipListSet _onResumeListeners;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f140742c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f140743d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f140744a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(0);
            this.f140744a = context;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        
            r0 = r0.baseActivity;
         */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String invoke() {
            String str;
            boolean contains$default;
            ComponentName componentName;
            Context context = this.f140744a;
            if (context instanceof WxaContainerActivity0) {
                return context.getClass().getName();
            }
            if (context instanceof Activity) {
                ActivityManager.RunningTaskInfo a16 = w0.a(context, ((Activity) context).getTaskId());
                if (a16 != null && componentName != null) {
                    str = componentName.getClassName();
                } else {
                    str = null;
                }
                boolean z16 = false;
                if (str != null) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "WxaContainerActivity", false, 2, (Object) null);
                    if (contains$default) {
                        z16 = true;
                    }
                }
                if (z16) {
                    return str;
                }
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        public static final b f140745a = new b();

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(Runnable runnable, Runnable runnable2) {
            return runnable.hashCode() - runnable2.hashCode();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f140746a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WxaEnterWechatInvokeManager$invoke$invokeContext$1 f140747b;

        public c(Context context, WxaEnterWechatInvokeManager$invoke$invokeContext$1 wxaEnterWechatInvokeManager$invoke$invokeContext$1) {
            this.f140746a = context;
            this.f140747b = wxaEnterWechatInvokeManager$invoke$invokeContext$1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LifecycleOwner lifecycleOwner;
            Lifecycle lifecycle;
            Object obj = this.f140746a;
            if (obj instanceof LifecycleOwner) {
                lifecycleOwner = (LifecycleOwner) obj;
            } else {
                lifecycleOwner = null;
            }
            if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.removeObserver(this.f140747b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f140748a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WxaEnterWechatInvokeManager$invoke$invokeContext$1 f140749b;

        public d(Context context, WxaEnterWechatInvokeManager$invoke$invokeContext$1 wxaEnterWechatInvokeManager$invoke$invokeContext$1) {
            this.f140748a = context;
            this.f140749b = wxaEnterWechatInvokeManager$invoke$invokeContext$1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LifecycleOwner lifecycleOwner;
            Lifecycle lifecycle;
            Object obj = this.f140748a;
            if (obj instanceof LifecycleOwner) {
                lifecycleOwner = (LifecycleOwner) obj;
            } else {
                lifecycleOwner = null;
            }
            if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.addObserver(this.f140749b);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WxaEnterWechatInvokeManager$invoke$invokeContext$1(String str, Context context) {
        Lazy lazy;
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        this.f140742c = str;
        this.f140743d = context;
        lazy = LazyKt__LazyJVMKt.lazy(new a(context));
        this._callbackActivityClass = lazy;
        this._onResumeListeners = new ConcurrentSkipListSet(b.f140745a);
        WxaEnterWechatInvokeManager wxaEnterWechatInvokeManager = WxaEnterWechatInvokeManager.f140737a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            if (context instanceof LifecycleOwner) {
                lifecycleOwner = (LifecycleOwner) context;
            } else {
                lifecycleOwner = null;
            }
            if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.addObserver(this);
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.zp.h.f146825d.a(new d(context, this));
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public o a(String apiName) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.vo.b
    public void b(com.tencent.luggage.wxa.vo.a target) {
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public int d() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public String f() {
        return "";
    }

    @Override // com.tencent.luggage.wxa.v3.b
    /* renamed from: getAppId, reason: from getter */
    public String getF140742c() {
        return this.f140742c;
    }

    @Override // com.tencent.luggage.wxa.v3.b
    /* renamed from: getContext, reason: from getter */
    public Context getF140743d() {
        return this.f140743d;
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public boolean h() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public String j() {
        return "";
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onActivityResumed() {
        Iterator it = this._onResumeListeners.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.luggage.wxa.v3.b
    public void release() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        WxaEnterWechatInvokeManager wxaEnterWechatInvokeManager = WxaEnterWechatInvokeManager.f140737a;
        Context context = this.f140743d;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            if (context instanceof LifecycleOwner) {
                lifecycleOwner = (LifecycleOwner) context;
            } else {
                lifecycleOwner = null;
            }
            if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.removeObserver(this);
            }
        } else {
            com.tencent.luggage.wxa.zp.h.f146825d.a(new c(context, this));
        }
        this._onResumeListeners.clear();
    }

    public final String a() {
        return (String) this._callbackActivityClass.getValue();
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public com.tencent.luggage.wxa.h1.b b(Class clazz) {
        return e.a(clazz);
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this._onResumeListeners.add(runnable);
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public String b() {
        String a16 = a();
        return a16 == null ? "" : a16;
    }
}
