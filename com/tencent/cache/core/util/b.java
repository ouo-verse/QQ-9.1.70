package com.tencent.cache.core.util;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static int f98828a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static List<String> f98829b;

    /* renamed from: c, reason: collision with root package name */
    public static com.tencent.cache.core.manager.api.d f98830c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f98831d;

    /* renamed from: e, reason: collision with root package name */
    public static final Map<String, Long> f98832e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final b f98833f;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a implements com.tencent.cache.core.manager.api.d {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.cache.core.manager.api.d
        public void d(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Log.d(tag, msg2);
        }

        @Override // com.tencent.cache.core.manager.api.d
        public void e(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Log.e(tag, msg2);
        }

        @Override // com.tencent.cache.core.manager.api.d
        public void i(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Log.i(tag, msg2);
        }

        @Override // com.tencent.cache.core.manager.api.d
        public void e(@NotNull String tag, @NotNull String msg2, @NotNull Throwable tr5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, tag, msg2, tr5);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(tr5, "tr");
            Log.e(tag, msg2, tr5);
        }
    }

    static {
        List<String> emptyList;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14739);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f98833f = new b();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        f98829b = emptyList;
        f98830c = new a();
        f98832e = new LinkedHashMap();
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final Object a(@NotNull String tag, @NotNull String method, boolean z16, @NotNull Function0<? extends Object> task) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, this, tag, method, Boolean.valueOf(z16), task);
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(task, "task");
        if (f() && f98829b.contains(tag)) {
            long currentTimeMillis = System.currentTimeMillis();
            Object invoke = task.invoke();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (z16) {
                str = "result:" + invoke + ',';
            } else {
                str = "";
            }
            d(tag, 3, method + " completed, " + str + " cost: " + currentTimeMillis2 + " ms");
            return invoke;
        }
        return task.invoke();
    }

    public final void b(@NotNull String tag, int i3, @Nullable String str, @Nullable Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, tag, Integer.valueOf(i3), str, th5);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (g(tag, i3)) {
            if (th5 == null) {
                com.tencent.cache.core.manager.api.d dVar = f98830c;
                String str2 = "MemoryControl_" + tag;
                if (str == null) {
                    str = "";
                }
                dVar.e(str2, str);
                return;
            }
            com.tencent.cache.core.manager.api.d dVar2 = f98830c;
            String str3 = "MemoryControl_" + tag;
            if (str == null) {
                str = "";
            }
            dVar2.e(str3, str, th5);
        }
    }

    public final void c(@NotNull String tag, int i3, @Nullable Throwable th5, @NotNull Object... msg2) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, tag, Integer.valueOf(i3), th5, msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (g(tag, i3)) {
            int length = msg2.length * 30;
            if (th5 == null) {
                i16 = 0;
            } else {
                i16 = 128;
            }
            StringBuilder sb5 = new StringBuilder(length + i16);
            for (Object obj : msg2) {
                if (obj != null) {
                    sb5.append(obj);
                }
            }
            b(tag, i3, sb5.toString(), th5);
        }
    }

    public final void d(@NotNull String tag, int i3, @NotNull Object... msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, tag, Integer.valueOf(i3), msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (g(tag, i3)) {
            StringBuilder sb5 = new StringBuilder(msg2.length * 30);
            for (Object obj : msg2) {
                if (obj != null) {
                    sb5.append(obj);
                }
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
            f98830c.d("MemoryControl_" + tag, sb6);
        }
    }

    public final void e(@NotNull String tag, @NotNull String method, @NotNull Function0<Unit> task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, tag, method, task);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(task, "task");
        if (f() && f98829b.contains(tag)) {
            long currentTimeMillis = System.currentTimeMillis();
            task.invoke();
            d(tag, 3, method + " completed, cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return;
        }
        task.invoke();
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (f98828a == 3) {
            return true;
        }
        return false;
    }

    public final boolean g(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, i3)).booleanValue();
        }
        if (f98828a < i3) {
            return false;
        }
        if (i3 == 3) {
            return f98829b.contains(str);
        }
        return true;
    }

    public final void h(@NotNull String tag, int i3, @NotNull Object... msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, tag, Integer.valueOf(i3), msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (g(tag, i3)) {
            c(tag, i3, null, Arrays.copyOf(msg2, msg2.length));
        }
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (f98828a == 4) {
            return true;
        }
        return false;
    }

    public final void j(@NotNull String tag, int i3, @NotNull Object... msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, tag, Integer.valueOf(i3), msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (g(tag, i3)) {
            StringBuilder sb5 = new StringBuilder(msg2.length * 30);
            for (Object obj : msg2) {
                if (obj != null) {
                    sb5.append(obj);
                }
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
            f98830c.i("MemoryControl_" + tag, sb6);
        }
    }
}
