package com.tencent.aio.runtime.launcher;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.QzoneIPCModule;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u0006\u0010\"\u001a\u00020 \u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J&\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J(\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J)\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017R&\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/aio/runtime/launcher/b;", "Lts/a;", "", "d", "Landroid/content/Intent;", "intent", "Landroidx/activity/result/ActivityResultCallback;", "Landroidx/activity/result/ActivityResult;", "callback", "", "a", "requestCode", "c", "", "routePath", "Landroid/os/Bundle;", "argument", "b", QzoneIPCModule.RESULT_CODE, "data", "e", "(IILandroid/content/Intent;)V", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "nextLocalRequestCode", "", "Lcom/tencent/aio/runtime/launcher/a;", "Ljava/util/Map;", "launcherMap", "Lys/a;", "Lys/a;", "routeJumpService", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Lys/a;Landroidx/fragment/app/Fragment;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b implements ts.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger nextLocalRequestCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, a<ActivityResult>> launcherMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ys.a routeJumpService;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Fragment fragment;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/runtime/launcher/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.runtime.launcher.b$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53550);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull ys.a routeJumpService, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(routeJumpService, "routeJumpService");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) routeJumpService, (Object) fragment);
            return;
        }
        this.routeJumpService = routeJumpService;
        this.fragment = fragment;
        this.nextLocalRequestCode = new AtomicInteger();
        this.launcherMap = new LinkedHashMap();
    }

    private final int d() {
        return this.nextLocalRequestCode.getAndIncrement();
    }

    @Override // ts.a
    public void a(@NotNull Intent intent, @NotNull ActivityResultCallback<ActivityResult> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(callback, "callback");
        int d16 = d();
        while (this.launcherMap.containsKey(Integer.valueOf(d16))) {
            d16 = d();
        }
        com.tencent.aio.base.log.a.f69187b.d("AIOLauncherImpl", "generateActivityResultKey  " + d16);
        a<ActivityResult> aVar = new a<>(callback, null, 2, null);
        this.fragment.startActivityForResult(intent, d16);
        this.launcherMap.put(Integer.valueOf(d16), aVar);
    }

    @Override // ts.a
    public void b(@NotNull String routePath, @NotNull ActivityResultCallback<ActivityResult> callback, @Nullable Bundle argument) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, routePath, callback, argument);
            return;
        }
        Intrinsics.checkNotNullParameter(routePath, "routePath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        int d16 = d();
        com.tencent.aio.base.log.a.f69187b.d("AIOLauncherImpl", "generateActivityResultKey  " + d16);
        this.launcherMap.put(Integer.valueOf(d16), new a<>(callback, null, 2, null));
        this.routeJumpService.a(routePath, this.fragment, d16, argument);
    }

    @Override // ts.a
    public void c(@NotNull Intent intent, int requestCode, @NotNull ActivityResultCallback<ActivityResult> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, intent, Integer.valueOf(requestCode), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(callback, "callback");
        a<ActivityResult> aVar = new a<>(callback, null, 2, null);
        this.fragment.startActivityForResult(intent, requestCode);
        this.launcherMap.put(Integer.valueOf(requestCode), aVar);
    }

    public final void e(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d("AIOLauncherImpl", "onActivityResult resultCode " + resultCode + ",  requestCode " + requestCode);
        }
        a<ActivityResult> remove = this.launcherMap.remove(Integer.valueOf(requestCode));
        if (remove != null) {
            remove.onActivityResult(new ActivityResult(resultCode, data));
        }
    }
}
