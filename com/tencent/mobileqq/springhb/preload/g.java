package com.tencent.mobileqq.springhb.preload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\t\b\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&J\u001c\u0010\t\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H&J\u001c\u0010\u000b\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H&J\u001c\u0010\f\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H&\u0082\u0001\u0006\u0010\u0011\u0012\u0013\u0014\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/springhb/preload/g;", "", "", "", "", "keyDrawableIdMap", "", "f", "keyPathMap", "e", "keyUrlMap", "g", tl.h.F, "<init>", "()V", "a", "Lcom/tencent/mobileqq/springhb/preload/a;", "Lcom/tencent/mobileqq/springhb/preload/b;", "Lcom/tencent/mobileqq/springhb/preload/c;", "Lcom/tencent/mobileqq/springhb/preload/d;", "Lcom/tencent/mobileqq/springhb/preload/e;", "Lcom/tencent/mobileqq/springhb/preload/f;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Map<String, Integer> f289503b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Map<String, String> f289504c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Map<String, String> f289505d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Map<String, String> f289506e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/springhb/preload/g$a;", "", "", "", "", "drawableMap", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "assetMap", "a", "urlMap", "d", "urlAssetMap", "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.preload.g$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final Map<String, String> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return g.f289504c;
            }
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @NotNull
        public final Map<String, Integer> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return g.f289503b;
            }
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @NotNull
        public final Map<String, String> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return g.f289506e;
            }
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @NotNull
        public final Map<String, String> d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return g.f289505d;
            }
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61192);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        f289503b = new LinkedHashMap();
        f289504c = new LinkedHashMap();
        f289505d = new LinkedHashMap();
        f289506e = new LinkedHashMap();
        g[] gVarArr = {b.f289497f, d.f289499f, f.f289501f, c.f289498f, e.f289500f, a.f289496f};
        for (int i3 = 0; i3 < 6; i3++) {
            g gVar = gVarArr[i3];
            gVar.f(f289503b);
            gVar.e(f289504c);
            gVar.g(f289505d);
            gVar.h(f289506e);
        }
    }

    public /* synthetic */ g(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    public abstract void e(@NotNull Map<String, String> keyPathMap);

    public abstract void f(@NotNull Map<String, Integer> keyDrawableIdMap);

    public abstract void g(@NotNull Map<String, String> keyUrlMap);

    public abstract void h(@NotNull Map<String, String> keyUrlMap);

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
