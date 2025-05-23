package com.tencent.base.runtime.launcher;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000  2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J)\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/base/runtime/launcher/c;", "Lhx/a;", "", "b", "Landroid/content/Intent;", "intent", "Landroidx/activity/result/ActivityResultCallback;", "Landroidx/activity/result/ActivityResult;", "callback", "", "a", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "c", "(IILandroid/content/Intent;)V", "Lix/a;", "Lix/a;", "routeJumpService", "Landroid/app/Activity;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "nextLocalRequestCode", "", "Lcom/tencent/base/runtime/launcher/a;", "d", "Ljava/util/Map;", "launcherMap", "<init>", "(Lix/a;Landroid/app/Activity;)V", "e", "input-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class c implements hx.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ix.a routeJumpService;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicInteger nextLocalRequestCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, a> launcherMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/base/runtime/launcher/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "input-base_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.base.runtime.launcher.c$a, reason: from kotlin metadata */
    /* loaded from: classes2.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38744);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull ix.a routeJumpService, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(routeJumpService, "routeJumpService");
        Intrinsics.checkNotNullParameter(activity, "activity");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) routeJumpService, (Object) activity);
            return;
        }
        this.routeJumpService = routeJumpService;
        this.activity = activity;
        this.nextLocalRequestCode = new AtomicInteger();
        this.launcherMap = new LinkedHashMap();
    }

    private final int b() {
        return this.nextLocalRequestCode.getAndIncrement();
    }

    @Override // hx.a
    public void a(@NotNull Intent intent, @NotNull ActivityResultCallback<ActivityResult> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(callback, "callback");
        int b16 = b();
        com.tencent.base.log.a.f77558a.a("LauncherImpl", "generateActivityResultKey  " + b16);
        a aVar = new a(callback, null, 2, null);
        this.activity.startActivityForResult(intent, b16);
        this.launcherMap.put(Integer.valueOf(b16), aVar);
    }

    public final void c(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        a remove = this.launcherMap.remove(Integer.valueOf(requestCode));
        if (remove != null) {
            remove.onActivityResult(new ActivityResult(resultCode, data));
        }
    }
}
