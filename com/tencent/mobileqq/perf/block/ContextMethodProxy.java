package com.tencent.mobileqq.perf.block;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ContextThemeWrapper;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.perf.memory.util.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/perf/block/ContextMethodProxy;", "", "()V", "TAG", "", "looperChecker", "com/tencent/mobileqq/perf/block/ContextMethodProxy$looperChecker$1", "Lcom/tencent/mobileqq/perf/block/ContextMethodProxy$looperChecker$1;", "checkConnectivityManager", "Ljava/lang/Object;", "context", "Landroid/content/Context;", "name", "getActivitySystemService", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "getContextSystemService", "Landroid/content/ContextWrapper;", "getContextWrapperSystemService", "Landroid/view/ContextThemeWrapper;", "getSystemService", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ContextMethodProxy {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final ContextMethodProxy INSTANCE;

    @NotNull
    private static final String TAG = "ContextMethodProxy";

    @NotNull
    private static final ContextMethodProxy$looperChecker$1 looperChecker;

    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mobileqq.perf.block.ContextMethodProxy$looperChecker$1] */
    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28765);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new ContextMethodProxy();
            looperChecker = new ThreadLocal<Boolean>() { // from class: com.tencent.mobileqq.perf.block.ContextMethodProxy$looperChecker$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.lang.ThreadLocal
                @NotNull
                public Boolean initialValue() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? Boolean.FALSE : (Boolean) iPatchRedirector.redirect((short) 2, (Object) this);
                }
            };
        }
    }

    ContextMethodProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0067, code lost:
    
        if ((r12 instanceof java.lang.Object) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
    
        if ((r12 instanceof java.lang.Object) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        r3 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x006a, code lost:
    
        r0.set(java.lang.Boolean.FALSE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x006f, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Object checkConnectivityManager(Context context, String name) {
        Object systemService;
        try {
            ContextMethodProxy$looperChecker$1 contextMethodProxy$looperChecker$1 = looperChecker;
            Boolean bool = contextMethodProxy$looperChecker$1.get();
            Boolean bool2 = Boolean.TRUE;
            Object obj = null;
            if (Intrinsics.areEqual(bool, bool2)) {
                systemService = context.getApplicationContext().getSystemService(name);
            } else {
                contextMethodProxy$looperChecker$1.set(bool2);
                if (Intrinsics.areEqual(name, "connectivity") && (context instanceof Activity)) {
                    b.b(b.f257791a, TAG, "get ConnectivityManager with activity as context", false, new Exception(), 4, null);
                } else if (Intrinsics.areEqual(name, WebRTCSDK.PRIVILEGE_SENSOR) && (context instanceof Activity)) {
                    b.b(b.f257791a, TAG, "get SensorManager with activity as context", false, new Exception(), 4, null);
                }
                systemService = context.getSystemService(name);
            }
        } catch (Throwable th5) {
            looperChecker.set(Boolean.FALSE);
            throw th5;
        }
    }

    @JvmStatic
    @Nullable
    public static final Object getActivitySystemService(@NotNull Activity activity, @NotNull String name) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(name, "name");
        return INSTANCE.checkConnectivityManager(activity, name);
    }

    @JvmStatic
    @Nullable
    public static final Object getContextSystemService(@NotNull ContextWrapper context, @NotNull String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return INSTANCE.checkConnectivityManager(context, name);
    }

    @JvmStatic
    @Nullable
    public static final Object getContextWrapperSystemService(@NotNull ContextThemeWrapper context, @NotNull String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return INSTANCE.checkConnectivityManager(context, name);
    }

    @JvmStatic
    @Nullable
    public static final Object getSystemService(@NotNull Context context, @NotNull String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        return INSTANCE.checkConnectivityManager(context, name);
    }
}
