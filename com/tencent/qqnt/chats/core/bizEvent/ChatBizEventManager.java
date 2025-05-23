package com.tencent.qqnt.chats.core.bizEvent;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.UiThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R(\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010(0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010,R\u0016\u0010.\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001d\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/chats/core/bizEvent/ChatBizEventManager;", "", "Lcom/tencent/qqnt/chats/core/bizEvent/a;", "it", "", "k", "event", "l", "f", "Lcom/tencent/qqnt/chats/core/bizEvent/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "i", "g", h.F, "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "j", "Ljava/lang/Runnable;", "a", "Ljava/lang/Runnable;", "uiHandleJob", "", "b", "J", WadlProxyConsts.LAST_UPDATE_TIME, "", "c", "Z", "isTaskWaiting", "Landroid/os/Handler;", "d", "Landroid/os/Handler;", "uiHandler", "Lcom/tencent/qqnt/chats/core/bizEvent/d;", "e", "Lcom/tencent/qqnt/chats/core/bizEvent/d;", "reportPart", "", "", "Ljava/util/Map;", "cachedEventData", "", "Ljava/util/Set;", "toHandleEvents", "isDestroyed", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatBizEventManager {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final Lazy<ChatBizEventManager> f354749j;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable uiHandleJob;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long lastUpdateTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isTaskWaiting;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler uiHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d reportPart;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<a, List<b>> cachedEventData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<a> toHandleEvents;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isDestroyed;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chats/core/bizEvent/ChatBizEventManager$a;", "", "Lcom/tencent/qqnt/chats/core/bizEvent/ChatBizEventManager;", "INSTANCE$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qqnt/chats/core/bizEvent/ChatBizEventManager;", "getINSTANCE$annotations", "()V", "INSTANCE", "", "TAG", "Ljava/lang/String;", "", "TIME_DIFF_NOTIFY_UPDATE", "J", "<init>", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.bizEvent.ChatBizEventManager$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final ChatBizEventManager a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ChatBizEventManager) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (ChatBizEventManager) ChatBizEventManager.f354749j.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<ChatBizEventManager> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40220);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(ChatBizEventManager$Companion$INSTANCE$2.INSTANCE);
        f354749j = lazy;
    }

    public ChatBizEventManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.uiHandleJob = new Runnable() { // from class: com.tencent.qqnt.chats.core.bizEvent.c
            @Override // java.lang.Runnable
            public final void run() {
                ChatBizEventManager.m(ChatBizEventManager.this);
            }
        };
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.reportPart = new d();
        this.cachedEventData = new LinkedHashMap();
        this.toHandleEvents = new LinkedHashSet();
        this.isDestroyed = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000f, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void k(a it) {
        List list;
        this.toHandleEvents.remove(it);
        List<b> list2 = this.cachedEventData.get(it);
        if (list2 != null && list != null) {
            QLog.d("ChatListReporter", 1, "[handleReportEvent] current event: " + it.getClass().getSimpleName() + ", dataSize: " + list.size());
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ChatBizEventManager$handleReportEvent$1$1(this, it, list, null), 2, null);
            this.cachedEventData.put(it, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(a event) {
        this.toHandleEvents.add(event);
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.lastUpdateTime;
        if (currentTimeMillis - j3 >= 2000) {
            QLog.d("ChatListReporter", 1, "[trySendEvent] trigger to handle immediately");
            this.lastUpdateTime = currentTimeMillis;
            this.uiHandler.post(this.uiHandleJob);
        } else if (this.isTaskWaiting) {
            this.isTaskWaiting = true;
            this.uiHandler.postDelayed(this.uiHandleJob, 2000 - (currentTimeMillis - j3));
            QLog.d("ChatListReporter", 1, "[trySendEvent] trigger to handle delay");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ChatBizEventManager this$0) {
        List list;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.lastUpdateTime = System.currentTimeMillis();
        this$0.isTaskWaiting = false;
        list = CollectionsKt___CollectionsKt.toList(this$0.toHandleEvents);
        this$0.toHandleEvents.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this$0.k((a) it.next());
        }
    }

    public final void f() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.isDestroyed = true;
        this.toHandleEvents.clear();
        this.uiHandler.removeCallbacksAndMessages(null);
        for (Map.Entry<a, List<b>> entry : this.cachedEventData.entrySet()) {
            List<b> value = entry.getValue();
            if (value != null && !value.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                k(entry.getKey());
            }
        }
        this.cachedEventData.clear();
    }

    public final void g(@NotNull b item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (!this.isDestroyed) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new ChatBizEventManager$doClick$1(this, item, null), 2, null);
        }
    }

    public final void h(@NotNull b item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (!this.isDestroyed) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new ChatBizEventManager$doDTAction$1(this, item, null), 2, null);
        }
    }

    public final void i(@NotNull b item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (!this.isDestroyed) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new ChatBizEventManager$doExpo$1(this, item, null), 2, null);
        }
    }

    @UiThread
    public final void j(@NotNull LifecycleCoroutineScope scope, @Nullable LifecycleOwner lifecycleOwner) {
        final Lifecycle lifecycle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) scope, (Object) lifecycleOwner);
            return;
        }
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (!this.isDestroyed) {
            return;
        }
        this.isDestroyed = false;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.addObserver(new LifecycleEventObserver(lifecycle) { // from class: com.tencent.qqnt.chats.core.bizEvent.ChatBizEventManager$doInit$1$1
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Lifecycle f354759e;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f354759e = lifecycle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatBizEventManager.this, (Object) lifecycle);
                    }
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) source, (Object) event);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        ChatBizEventManager.this.f();
                        this.f354759e.removeObserver(this);
                    }
                }
            });
        }
    }
}
