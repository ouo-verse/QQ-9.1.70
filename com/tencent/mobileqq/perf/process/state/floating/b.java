package com.tencent.mobileqq.perf.process.state.floating;

import android.os.Process;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/perf/process/state/floating/b;", "", "", "wrapperClassName", "", "c", "b", "name", "", "pid", "a", "", "Ljava/util/Set;", "currentFloatWrapper", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f257940a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<String> currentFloatWrapper;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33274);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f257940a = new b();
            currentFloatWrapper = new LinkedHashSet();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a(@NotNull String name, int pid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) name, pid);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        return name + util.base64_pad_url + pid;
    }

    public final void b(@NotNull String wrapperClassName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) wrapperClassName);
            return;
        }
        Intrinsics.checkNotNullParameter(wrapperClassName, "wrapperClassName");
        Set<String> set = currentFloatWrapper;
        if (!set.contains(wrapperClassName)) {
            return;
        }
        set.remove(wrapperClassName);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeStringSet("float_window_state", set);
        from.removeKey("process_prefix_" + wrapperClassName);
        QLog.i("FloatingStateRecorder", 1, "removeState, " + wrapperClassName + ", current:" + set + ", " + MobileQQ.processName);
    }

    public final void c(@NotNull String wrapperClassName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) wrapperClassName);
            return;
        }
        Intrinsics.checkNotNullParameter(wrapperClassName, "wrapperClassName");
        Set<String> set = currentFloatWrapper;
        if (set.contains(wrapperClassName)) {
            return;
        }
        set.add(wrapperClassName);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeStringSet("float_window_state", set);
        String processName = MobileQQ.processName;
        Intrinsics.checkNotNullExpressionValue(processName, "processName");
        from.encodeString("process_prefix_" + wrapperClassName, a(processName, Process.myPid()));
        QLog.i("FloatingStateRecorder", 1, "writeState, " + wrapperClassName + ", current:" + set + ", " + MobileQQ.processName);
    }
}
