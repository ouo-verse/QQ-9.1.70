package com.tencent.mobileqq.perf.memory.preload;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/preload/a;", "", "Lcom/tencent/mobileqq/perf/memory/preload/b;", SessionDbHelper.SESSION_ID, "", "a", "(Lcom/tencent/mobileqq/perf/memory/preload/b;)V", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f257783a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30426);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f257783a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull b session) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) session);
            return;
        }
        Intrinsics.checkNotNullParameter(session, "session");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("processName", String.valueOf(session.c()));
        hashMap.put(TagName.ENTRY_NAME, String.valueOf(session.b()));
        hashMap.put("isHit", String.valueOf(session.e()));
        if (QLog.isColorLevel()) {
            QLog.d("PreloadReport", 2, "reportProcessPreload, " + hashMap);
        }
        com.tencent.mobileqq.perf.process.foregroud.report.a.f257918a.a("report_memory_preload", hashMap);
    }
}
