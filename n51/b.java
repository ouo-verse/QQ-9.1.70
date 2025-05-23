package n51;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.minibox.loader.core.PluginVersionManager;
import com.tencent.minibox.loader.core.e;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p51.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006H\u0002R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Ln51/b;", "", "Landroid/app/Application;", "application", "", "c", "Landroid/content/Context;", "b", "context", "", "a", "Landroid/app/Application;", "sApplication", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static Application sApplication;

    /* renamed from: b, reason: collision with root package name */
    public static final b f418383b = new b();

    b() {
    }

    private final boolean a(Context context) {
        if (PluginVersionManager.f151646b.g(context) != null) {
            return true;
        }
        return false;
    }

    @JvmStatic
    @NotNull
    public static final Context b() {
        Application application = sApplication;
        if (application == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sApplication");
        }
        return application;
    }

    @JvmStatic
    public static final void c(@NotNull Application application) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        if (c.f425348c.c(application)) {
            return;
        }
        if (!f418383b.a(application)) {
            LogUtils.e("MiniBoxProcess", "onMiniBoxProcessInit check plugin invalid");
            SystemMethodProxy.killProcess(Process.myPid());
            return;
        }
        sApplication = application;
        e.f151663b.b(application);
        com.tencent.minibox.loader.core.a aVar = com.tencent.minibox.loader.core.a.f151655b;
        aVar.c();
        aVar.d(application, new Bundle());
    }
}
