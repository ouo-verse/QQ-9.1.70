package com.tencent.qqnt.qbasealbum.inject;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.IPicLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.inject.IPreference;
import com.tencent.qqnt.qbasealbum.inject.b;
import com.tencent.qqnt.qbasealbum.inject.c;
import com.tencent.qqnt.qbasealbum.inject.d;
import com.tencent.qqnt.qbasealbum.inject.f;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.report.a;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0002(\u0003BA\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\b%\u0010&R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u0014\u0010\u001bR\u0017\u0010 \u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u000e\u0010\u001fR\u0017\u0010$\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b\b\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/inject/QBaseAlbumCustomize;", "", "Lcom/tencent/qqnt/qbasealbum/inject/b;", "a", "Lcom/tencent/qqnt/qbasealbum/inject/b;", "()Lcom/tencent/qqnt/qbasealbum/inject/b;", "appSetting", "Lcom/tencent/qqnt/qbasealbum/inject/e;", "b", "Lcom/tencent/qqnt/qbasealbum/inject/e;", "f", "()Lcom/tencent/qqnt/qbasealbum/inject/e;", "threadManager", "Lcom/tencent/qqnt/qbasealbum/report/a;", "c", "Lcom/tencent/qqnt/qbasealbum/report/a;", "e", "()Lcom/tencent/qqnt/qbasealbum/report/a;", "reportCallback", "Lcom/tencent/qqnt/qbasealbum/inject/f;", "d", "Lcom/tencent/qqnt/qbasealbum/inject/f;", "g", "()Lcom/tencent/qqnt/qbasealbum/inject/f;", "toast", "Lcom/tencent/qqnt/qbasealbum/inject/IPreference;", "Lcom/tencent/qqnt/qbasealbum/inject/IPreference;", "()Lcom/tencent/qqnt/qbasealbum/inject/IPreference;", "preference", "Lcom/tencent/qqnt/qbasealbum/inject/d;", "Lcom/tencent/qqnt/qbasealbum/inject/d;", "()Lcom/tencent/qqnt/qbasealbum/inject/d;", "injectMethod", "Lcom/tencent/qqnt/qbasealbum/inject/c;", "Lcom/tencent/qqnt/qbasealbum/inject/c;", "()Lcom/tencent/qqnt/qbasealbum/inject/c;", "editProcessor", "<init>", "(Lcom/tencent/qqnt/qbasealbum/inject/b;Lcom/tencent/qqnt/qbasealbum/inject/e;Lcom/tencent/qqnt/qbasealbum/report/a;Lcom/tencent/qqnt/qbasealbum/inject/f;Lcom/tencent/qqnt/qbasealbum/inject/IPreference;Lcom/tencent/qqnt/qbasealbum/inject/d;Lcom/tencent/qqnt/qbasealbum/inject/c;)V", tl.h.F, "Builder", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QBaseAlbumCustomize {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b appSetting;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e threadManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.qbasealbum.report.a reportCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f toast;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IPreference preference;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d injectMethod;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c editProcessor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b6\u00107J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010(\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010.\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010*\u001a\u0004\b+\u0010,\"\u0004\b\u001b\u0010-R\"\u00105\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b\u0013\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/inject/QBaseAlbumCustomize$Builder;", "", "Lcom/tencent/qqnt/qbasealbum/inject/QBaseAlbumCustomize;", "a", "Lcom/tencent/qqnt/qbasealbum/inject/b;", "Lcom/tencent/qqnt/qbasealbum/inject/b;", "getAppSetting", "()Lcom/tencent/qqnt/qbasealbum/inject/b;", "b", "(Lcom/tencent/qqnt/qbasealbum/inject/b;)V", "appSetting", "Lcom/tencent/qqnt/qbasealbum/inject/e;", "Lcom/tencent/qqnt/qbasealbum/inject/e;", "getThreadManager", "()Lcom/tencent/qqnt/qbasealbum/inject/e;", "e", "(Lcom/tencent/qqnt/qbasealbum/inject/e;)V", "threadManager", "Lcom/tencent/qqnt/qbasealbum/report/a;", "c", "Lcom/tencent/qqnt/qbasealbum/report/a;", "getReportCallback", "()Lcom/tencent/qqnt/qbasealbum/report/a;", "setReportCallback", "(Lcom/tencent/qqnt/qbasealbum/report/a;)V", "reportCallback", "Lcom/tencent/qqnt/qbasealbum/inject/f;", "d", "Lcom/tencent/qqnt/qbasealbum/inject/f;", "getToast", "()Lcom/tencent/qqnt/qbasealbum/inject/f;", "f", "(Lcom/tencent/qqnt/qbasealbum/inject/f;)V", "toast", "Lcom/tencent/qqnt/qbasealbum/inject/IPreference;", "Lcom/tencent/qqnt/qbasealbum/inject/IPreference;", "getPreference", "()Lcom/tencent/qqnt/qbasealbum/inject/IPreference;", "setPreference", "(Lcom/tencent/qqnt/qbasealbum/inject/IPreference;)V", "preference", "Lcom/tencent/qqnt/qbasealbum/inject/d;", "Lcom/tencent/qqnt/qbasealbum/inject/d;", "getInjectMethod", "()Lcom/tencent/qqnt/qbasealbum/inject/d;", "(Lcom/tencent/qqnt/qbasealbum/inject/d;)V", "injectMethod", "Lcom/tencent/qqnt/qbasealbum/inject/c;", "g", "Lcom/tencent/qqnt/qbasealbum/inject/c;", "getEditProcessor", "()Lcom/tencent/qqnt/qbasealbum/inject/c;", "(Lcom/tencent/qqnt/qbasealbum/inject/c;)V", "editProcessor", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class Builder {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.qqnt.qbasealbum.inject.b appSetting;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.qqnt.qbasealbum.inject.e threadManager;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.qqnt.qbasealbum.report.a reportCallback;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.qqnt.qbasealbum.inject.f toast;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private IPreference preference;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.qqnt.qbasealbum.inject.d injectMethod;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.qqnt.qbasealbum.inject.c editProcessor;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/qqnt/qbasealbum/inject/QBaseAlbumCustomize$Builder$a", "Lcom/tencent/qqnt/qbasealbum/inject/b;", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class a implements com.tencent.qqnt.qbasealbum.inject.b {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.b
            public boolean isDebugVersion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
                }
                return b.a.a(this);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.b
            public boolean isPublicVersion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                return b.a.b(this);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/qqnt/qbasealbum/inject/QBaseAlbumCustomize$Builder$b", "Lcom/tencent/qqnt/qbasealbum/inject/c;", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class b implements com.tencent.qqnt.qbasealbum.inject.c {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.c
            @Nullable
            public LocalMediaInfo c(@NotNull Intent intent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (LocalMediaInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
                }
                return c.b.f(this, intent);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.c
            @Nullable
            public LocalMediaInfo d(@NotNull Intent intent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (LocalMediaInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
                }
                return c.b.g(this, intent);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.c
            public void h(@NotNull Activity activity, @NotNull String str, @NotNull com.tencent.qqnt.qbasealbum.preview.fragment.a aVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    iPatchRedirector.redirect((short) 8, this, activity, str, aVar);
                } else {
                    c.b.c(this, activity, str, aVar);
                }
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.c
            public void i(@NotNull Activity activity, @NotNull LocalMediaInfo localMediaInfo, boolean z16, @Nullable String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, this, activity, localMediaInfo, Boolean.valueOf(z16), str);
                } else {
                    c.b.b(this, activity, localMediaInfo, z16, str);
                }
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.c
            public void l(@NotNull Activity activity, @NotNull LocalMediaInfo localMediaInfo, boolean z16, @Nullable String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, this, activity, localMediaInfo, Boolean.valueOf(z16), str);
                } else {
                    c.b.a(this, activity, localMediaInfo, z16, str);
                }
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.c
            @Nullable
            public HashMap<String, LocalMediaInfo> m(@NotNull Intent intent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
                }
                return c.b.e(this, intent);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.c
            public void n(@NotNull Activity activity, @NotNull Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) bundle);
                } else {
                    c.b.d(this, activity, bundle);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/qqnt/qbasealbum/inject/QBaseAlbumCustomize$Builder$c", "Lcom/tencent/qqnt/qbasealbum/inject/d;", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class c implements com.tencent.qqnt.qbasealbum.inject.d {
            static IPatchRedirector $redirector_;

            c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            public boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
                }
                return d.a.a(this);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            @Nullable
            public ComponentName b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                    return (ComponentName) iPatchRedirector.redirect((short) 20, (Object) this);
                }
                return d.a.c(this);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            public boolean e() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
                }
                return d.a.n(this);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            public void f(@NotNull Context context, @NotNull View view) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) view);
                } else {
                    d.a.o(this, context, view);
                }
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            public int g() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                    return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
                }
                return d.a.p(this);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            @Nullable
            public IPicLoader getPicLoader() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                    return (IPicLoader) iPatchRedirector.redirect((short) 10, (Object) this);
                }
                return d.a.d(this);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            public long getServerTimeMillis() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
                }
                return d.a.f(this);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            public int getStatusBarHeight(@NotNull Context context) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context)).intValue();
                }
                return d.a.g(this, context);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            public boolean isCameraResReady() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
                }
                return d.a.j(this);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            public boolean isNowThemeIsNight() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                return d.a.k(this);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            public boolean isSupportMagnifyLongPic() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
                }
                return d.a.m(this);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            @Nullable
            public Drawable j() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                    return (Drawable) iPatchRedirector.redirect((short) 18, (Object) this);
                }
                return d.a.b(this);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            public boolean k() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
                }
                return d.a.i(this);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            public boolean o() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
                }
                return d.a.l(this);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            @Nullable
            public CharSequence p(@NotNull String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                    return (CharSequence) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
                }
                return d.a.e(this, str);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            @Nullable
            public Part q() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                    return (Part) iPatchRedirector.redirect((short) 11, (Object) this);
                }
                return d.a.h(this);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.d
            public int r() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                    return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
                }
                return d.a.q(this);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/qqnt/qbasealbum/inject/QBaseAlbumCustomize$Builder$d", "Lcom/tencent/qqnt/qbasealbum/inject/IPreference;", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class d implements IPreference {
            static IPatchRedirector $redirector_;

            d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.IPreference
            public boolean getBoolean(@NotNull String str, boolean z16, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), Integer.valueOf(i3))).booleanValue();
                }
                return IPreference.a.a(this, str, z16, i3);
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.IPreference
            public void putBoolean(@NotNull String str, boolean z16, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16), Integer.valueOf(i3));
                } else {
                    IPreference.a.b(this, str, z16, i3);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/qqnt/qbasealbum/inject/QBaseAlbumCustomize$Builder$e", "Lcom/tencent/qqnt/qbasealbum/report/a;", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class e implements com.tencent.qqnt.qbasealbum.report.a {
            static IPatchRedirector $redirector_;

            e() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.qqnt.qbasealbum.report.a
            public void onPauseReport() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this);
                } else {
                    a.C9684a.a(this);
                }
            }

            @Override // com.tencent.qqnt.qbasealbum.report.a
            public void onResumeReport() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this);
                } else {
                    a.C9684a.b(this);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/qqnt/qbasealbum/inject/QBaseAlbumCustomize$Builder$f", "Lcom/tencent/qqnt/qbasealbum/inject/f;", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class f implements com.tencent.qqnt.qbasealbum.inject.f {
            static IPatchRedirector $redirector_;

            f() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.qqnt.qbasealbum.inject.f
            public void showToast(@NotNull Context context, @Nullable CharSequence charSequence, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, context, charSequence, Integer.valueOf(i3));
                } else {
                    f.a.a(this, context, charSequence, i3);
                }
            }
        }

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.appSetting = new a();
            this.threadManager = new QBaseAlbumCustomize$Builder$threadManager$1();
            this.reportCallback = new e();
            this.toast = new f();
            this.preference = new d();
            this.injectMethod = new c();
            this.editProcessor = new b();
        }

        @NotNull
        public final QBaseAlbumCustomize a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (QBaseAlbumCustomize) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return new QBaseAlbumCustomize(this.appSetting, this.threadManager, this.reportCallback, this.toast, this.preference, this.injectMethod, this.editProcessor, null);
        }

        public final void b(@NotNull com.tencent.qqnt.qbasealbum.inject.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            } else {
                Intrinsics.checkNotNullParameter(bVar, "<set-?>");
                this.appSetting = bVar;
            }
        }

        public final void c(@NotNull com.tencent.qqnt.qbasealbum.inject.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) cVar);
            } else {
                Intrinsics.checkNotNullParameter(cVar, "<set-?>");
                this.editProcessor = cVar;
            }
        }

        public final void d(@NotNull com.tencent.qqnt.qbasealbum.inject.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) dVar);
            } else {
                Intrinsics.checkNotNullParameter(dVar, "<set-?>");
                this.injectMethod = dVar;
            }
        }

        public final void e(@NotNull com.tencent.qqnt.qbasealbum.inject.e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) eVar);
            } else {
                Intrinsics.checkNotNullParameter(eVar, "<set-?>");
                this.threadManager = eVar;
            }
        }

        public final void f(@NotNull com.tencent.qqnt.qbasealbum.inject.f fVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) fVar);
            } else {
                Intrinsics.checkNotNullParameter(fVar, "<set-?>");
                this.toast = fVar;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/inject/QBaseAlbumCustomize$a;", "", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.inject.QBaseAlbumCustomize$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41557);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ QBaseAlbumCustomize(b bVar, e eVar, com.tencent.qqnt.qbasealbum.report.a aVar, f fVar, IPreference iPreference, d dVar, c cVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, eVar, aVar, fVar, iPreference, dVar, cVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, this, bVar, eVar, aVar, fVar, iPreference, dVar, cVar, defaultConstructorMarker);
    }

    @NotNull
    public final b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.appSetting;
    }

    @NotNull
    public final c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (c) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.editProcessor;
    }

    @NotNull
    public final d c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (d) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.injectMethod;
    }

    @NotNull
    public final IPreference d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (IPreference) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.preference;
    }

    @NotNull
    public final com.tencent.qqnt.qbasealbum.report.a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.qbasealbum.report.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.reportCallback;
    }

    @NotNull
    public final e f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.threadManager;
    }

    @NotNull
    public final f g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (f) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.toast;
    }

    QBaseAlbumCustomize(b bVar, e eVar, com.tencent.qqnt.qbasealbum.report.a aVar, f fVar, IPreference iPreference, d dVar, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, eVar, aVar, fVar, iPreference, dVar, cVar);
            return;
        }
        this.appSetting = bVar;
        this.threadManager = eVar;
        this.reportCallback = aVar;
        this.toast = fVar;
        this.preference = iPreference;
        this.injectMethod = dVar;
        this.editProcessor = cVar;
    }
}
