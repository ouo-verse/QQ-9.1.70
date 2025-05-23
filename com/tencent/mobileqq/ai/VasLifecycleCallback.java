package com.tencent.mobileqq.ai;

import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 .*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J!\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016R0\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u001ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010 RP\u0010$\u001a>\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\"j\b\u0012\u0004\u0012\u00020\u0005`#0\u001ej\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\"j\b\u0012\u0004\u0012\u00020\u0005`#`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010 R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/ai/VasLifecycleCallback;", "T", "Landroidx/lifecycle/LifecycleEventObserver;", "Lmqq/app/IAccountCallback;", "callback", "", "d", "(Ljava/lang/Object;)I", "Landroidx/lifecycle/LifecycleOwner;", "owner", "c", "", "b", "lifecycleOwner", "f", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/Object;)I", "token", "e", "(I)Ljava/lang/Object;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "Lmqq/app/AppRuntime;", "newRuntime", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "callbackList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "lifecycleMap", "", "Ljava/lang/Object;", "lockObj", "", tl.h.F, "Ljava/lang/String;", "curAccount", "<init>", "()V", "i", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class VasLifecycleCallback<T> implements LifecycleEventObserver, IAccountCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, T> callbackList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, HashSet<Integer>> lifecycleMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object lockObj;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String curAccount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/ai/VasLifecycleCallback$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ai.VasLifecycleCallback$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21647);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public VasLifecycleCallback() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.callbackList = new HashMap<>();
        this.lifecycleMap = new HashMap<>();
        this.lockObj = new Object();
        MobileQQ.sMobileQQ.registerAccountCallback(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        this.curAccount = str;
    }

    private final void b() {
        synchronized (this.lockObj) {
            this.callbackList.clear();
            this.lifecycleMap.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final int c(LifecycleOwner owner) {
        return owner.hashCode();
    }

    private final int d(T callback) {
        if (callback != null) {
            return callback.hashCode();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(LifecycleOwner l3, VasLifecycleCallback this$0) {
        Intrinsics.checkNotNullParameter(l3, "$l");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l3.getLifecycle().addObserver(this$0);
    }

    @Nullable
    public final T e(int token) {
        T remove;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, token);
        }
        synchronized (this.lockObj) {
            remove = this.callbackList.remove(Integer.valueOf(token));
            Unit unit = Unit.INSTANCE;
        }
        return remove;
    }

    public final int f(@Nullable final LifecycleOwner lifecycleOwner, @Nullable T callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) lifecycleOwner, (Object) callback)).intValue();
        }
        int d16 = d(callback);
        if (callback != null) {
            synchronized (this.lockObj) {
                this.callbackList.put(Integer.valueOf(d16), callback);
                if (lifecycleOwner != null) {
                    if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                        QLog.w("VasLifecycleCallback", 2, "store: not in main thread, may cause leak");
                        bg.k(new Runnable() { // from class: com.tencent.mobileqq.ai.k
                            @Override // java.lang.Runnable
                            public final void run() {
                                VasLifecycleCallback.g(LifecycleOwner.this, this);
                            }
                        });
                    } else {
                        lifecycleOwner.getLifecycle().addObserver(this);
                    }
                    int c16 = c(lifecycleOwner);
                    HashSet<Integer> hashSet = this.lifecycleMap.get(Integer.valueOf(c16));
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                    } else {
                        Intrinsics.checkNotNullExpressionValue(hashSet, "lifecycleMap[lifecycleOwnerKey] ?: HashSet()");
                    }
                    hashSet.add(Integer.valueOf(d16));
                    this.lifecycleMap.put(Integer.valueOf(c16), hashSet);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return d16;
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) newRuntime);
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(@Nullable AppRuntime newRuntime) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) newRuntime);
            return;
        }
        String str2 = this.curAccount;
        String str3 = null;
        if (str2 != null) {
            if (newRuntime != null) {
                str = newRuntime.getAccount();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str2, str)) {
                b();
            }
        }
        if (newRuntime != null) {
            str3 = newRuntime.getAccount();
        }
        this.curAccount = str3;
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(@Nullable Constants.LogoutReason reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) reason);
        } else {
            b();
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) source, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            source.getLifecycle().removeObserver(this);
            synchronized (this.lockObj) {
                HashSet<Integer> remove = this.lifecycleMap.remove(Integer.valueOf(c(source)));
                if (remove != null) {
                    Iterator<T> it = remove.iterator();
                    while (it.hasNext()) {
                        this.callbackList.remove(Integer.valueOf(((Number) it.next()).intValue()));
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }
}
