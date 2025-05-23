package com.tencent.mobileqq.perf.report.abtag;

import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.RMonitor;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/perf/report/abtag/a;", "", "", "abTagValue", "key", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "a", "(Ljava/lang/String;Ljava/lang/String;Z)V", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f258017a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35187);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f258017a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String abTagValue, @NotNull String key, boolean r142) {
        boolean removeStringFromStringArrayParam;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, abTagValue, key, Boolean.valueOf(r142));
            return;
        }
        Intrinsics.checkNotNullParameter(abTagValue, "abTagValue");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Method declaredMethod = CrashReport.class.getDeclaredMethod("putReservedRequestData", (Class[]) Arrays.copyOf(new Class[]{String.class, String.class}, 2));
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "CrashReport::class.java.\u2026ameterTypes\n            )");
            CrashReport crashReport = new CrashReport();
            declaredMethod.setAccessible(true);
            QLog.d("BugABInner", 1, "putReservedRequestData, key:" + key + ", switch:" + r142 + ", result:" + declaredMethod.invoke(crashReport, "ABTag", abTagValue));
            ICustomDataEditor globalCustomDataEditor = RMonitor.getGlobalCustomDataEditor();
            Intrinsics.checkNotNullExpressionValue(globalCustomDataEditor, "getGlobalCustomDataEditor()");
            if (r142) {
                removeStringFromStringArrayParam = globalCustomDataEditor.addStringToStringArrayParam(ICustomDataEditor.STRING_ARRAY_PARAM_1, key);
            } else {
                removeStringFromStringArrayParam = globalCustomDataEditor.removeStringFromStringArrayParam(ICustomDataEditor.STRING_ARRAY_PARAM_1, key);
            }
            QLog.d("BugABInner", 1, "set customDataEditor, key:" + key + ", switch:" + r142 + ", result:" + Boolean.valueOf(removeStringFromStringArrayParam));
            if (r142) {
                Method declaredMethod2 = CrashReport.class.getDeclaredMethod("triggerUserInfoUpload", new Class[0]);
                Intrinsics.checkNotNullExpressionValue(declaredMethod2, "CrashReport::class.java.\u2026(\"triggerUserInfoUpload\")");
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(crashReport, new Object[0]);
            }
        } catch (NoSuchMethodException e16) {
            QLog.d("BugABInner", 1, "updateABTag fail", e16);
        } catch (Throwable th5) {
            QLog.d("BugABInner", 1, "updateABTag fail", th5);
        }
    }
}
