package com.tencent.mobileqq.startup.task;

import android.content.Context;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.startup.BrowserAutomator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import com.tencent.smtt.sdk.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/startup/task/l;", "Lcom/tencent/qqnt/startup/task/NtTask;", "Landroid/content/Context;", "context", "", TencentLocation.RUN_MODE, "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class l extends NtTask {
    static IPatchRedirector $redirector_;

    public l() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r9, ":", 0, false, 6, (java.lang.Object) null);
     */
    @Override // com.tencent.qqnt.startup.task.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run(@NotNull Context context) {
        boolean contains$default;
        int lastIndexOf$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (MobileQQ.sProcessId == 7) {
            BrowserAutomator.G.j(com.tencent.mobileqq.webview.swift.startup.b.STEPS_X5ENV_INIT);
        }
        if (MobileQQ.sProcessId != 1) {
            String processName = MobileQQ.processName;
            Intrinsics.checkNotNullExpressionValue(processName, "processName");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) processName, (CharSequence) ":", false, 2, (Object) null);
            if (contains$default && lastIndexOf$default >= 0 && lastIndexOf$default < processName.length() - 1) {
                String substring = processName.substring(lastIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                WebView.setDataDirectorySuffix(substring);
                if (QLog.isDevelopLevel()) {
                    QLog.d("BrowserGlobalSettingTask", 1, "setDataDirectorySuffix: " + substring);
                }
            }
        }
    }
}
