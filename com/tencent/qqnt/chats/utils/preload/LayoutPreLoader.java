package com.tencent.qqnt.chats.utils.preload;

import android.content.Context;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 32\u00020\u0001:\u0003\u001a\u001d#B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b1\u00102J0\u0010\u0007\u001a\u00020\u00062\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ-\u0010\r\u001a\u00020\u00042\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0004J$\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\tJ'\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0016H\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR<\u0010%\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010!0 j\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010!`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R8\u0010'\u001a&\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0 j\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010$R0\u0010)\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110 j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0011`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010$R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00064"}, d2 = {"Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader;", "", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "Lkotlinx/coroutines/Job;", "j", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader$c;", "preLoader", "Ljava/util/concurrent/CopyOnWriteArrayList;", "list", "l", "(Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader$c;Ljava/util/concurrent/CopyOnWriteArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "key", "", "preloadSize", "loader", "i", "T", "Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader$b;", "constructParam", "k", "(Ljava/lang/Object;Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader$b;)Ljava/lang/Object;", "a", "Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader$b;", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Ljava/util/HashMap;", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "pools", "d", "loaderList", "e", "remainSize", "Ljava/util/concurrent/atomic/AtomicBoolean;", "f", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isOperating", "g", "Lkotlinx/coroutines/Job;", "preloadJob", "<init>", "(Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader$b;Lkotlinx/coroutines/CoroutineScope;)V", h.F, "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class LayoutPreLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b constructParam;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Object, LinkedBlockingQueue<Object>> pools;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Object, c<?>> loaderList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Object, Integer> remainSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isOperating;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job preloadJob;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.utils.preload.LayoutPreLoader$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader$b;", "", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "a", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", "contextRef", "context", "<init>", "(Landroid/content/Context;)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<Context> contextRef;

        public b(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            } else {
                this.contextRef = new WeakReference<>(context);
            }
        }

        @NotNull
        public final WeakReference<Context> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (WeakReference) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.contextRef;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0019\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader$c;", "T", "", "Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader$b;", "param", "a", "(Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader$b;)Ljava/lang/Object;", "", "b", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface c<T> {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes24.dex */
        public static final class a {
            public static <T> boolean a(@NotNull c<T> cVar) {
                return true;
            }
        }

        @Nullable
        T a(@NotNull b param);

        boolean b();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45820);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LayoutPreLoader(@NotNull b constructParam, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(constructParam, "constructParam");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) constructParam, (Object) scope);
            return;
        }
        this.constructParam = constructParam;
        this.scope = scope;
        this.pools = new HashMap<>();
        this.loaderList = new HashMap<>();
        this.remainSize = new HashMap<>();
        this.isOperating = new AtomicBoolean(false);
    }

    private final Job j(Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new LayoutPreLoader$checkAndAsyncRun$1(this, block, null), 2, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(c<?> cVar, CopyOnWriteArrayList<Object> copyOnWriteArrayList, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        try {
            Object a16 = cVar.a(this.constructParam);
            if (a16 != null) {
                copyOnWriteArrayList.add(a16);
            }
        } catch (Exception e16) {
            QLog.w("LayoutPreLoader", 4, "preloadOne View Failed at sub thread: ", e16);
            Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new LayoutPreLoader$preloadOne$3(cVar, this, copyOnWriteArrayList, null), continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (withContext == coroutine_suspended) {
                return withContext;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(LayoutPreLoader this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.preloadJob != null) {
            return;
        }
        this$0.preloadJob = this$0.j(new LayoutPreLoader$startPreload$1$1(this$0, null));
    }

    public final void i(@NotNull Object key, int preloadSize, @NotNull c<?> loader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, key, Integer.valueOf(preloadSize), loader);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(loader, "loader");
        j(new LayoutPreLoader$addPreLoader$1(this, key, preloadSize, loader, null));
    }

    @MainThread
    @Nullable
    public final <T> T k(@NotNull Object key, @NotNull b constructParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this, key, (Object) constructParam);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(constructParam, "constructParam");
        if (this.loaderList.get(key) == null) {
            return null;
        }
        m();
        LinkedBlockingQueue<Object> linkedBlockingQueue = this.pools.get(key);
        Intrinsics.checkNotNull(linkedBlockingQueue);
        LinkedBlockingQueue<Object> linkedBlockingQueue2 = linkedBlockingQueue;
        if (linkedBlockingQueue2.size() == 0) {
            QLog.d("LayoutPreLoader", 4, "getViewBinding but preload queue is null");
            c<?> cVar = this.loaderList.get(key);
            Intrinsics.checkNotNull(cVar);
            return (T) cVar.a(constructParam);
        }
        return (T) linkedBlockingQueue2.take();
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.chats.utils.preload.a
                @Override // java.lang.Runnable
                public final void run() {
                    LayoutPreLoader.n(LayoutPreLoader.this);
                }
            }, 16, null, false);
        }
    }
}
