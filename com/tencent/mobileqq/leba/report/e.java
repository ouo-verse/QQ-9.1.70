package com.tencent.mobileqq.leba.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import java.util.HashMap;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002J\"\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/leba/report/e;", "", "", "isNewDiskCache", "", "elapse", "", "pluginCount", "isFeeds", "", "a", "from", "", "reason", "isFeed", "b", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f240760a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19142);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f240760a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(boolean isNewDiskCache, long elapse, int pluginCount, boolean isFeeds) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isNewDiskCache), Long.valueOf(elapse), Integer.valueOf(pluginCount), Boolean.valueOf(isFeeds));
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (isNewDiskCache) {
            str = "LebaLoadDisk";
        } else {
            str = "LebaLoadOldDisk";
        }
        HashMap hashMap = new HashMap();
        String str3 = "1";
        if (pluginCount <= 0) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("success", str2);
        hashMap.put("elapse", String.valueOf(elapse));
        hashMap.put("pluginCount", String.valueOf(pluginCount));
        String currentUin = peekAppRuntime.getCurrentUin();
        if (currentUin == null) {
            currentUin = "unknown";
        }
        hashMap.put("account", currentUin);
        if (isFeeds) {
            str3 = "2";
        }
        hashMap.put("style", str3);
        QQBeaconReport.report(peekAppRuntime.getCurrentUin(), str, hashMap);
    }

    public final void b(int from, @Nullable String reason, boolean isFeed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(from), reason, Boolean.valueOf(isFeed));
        }
    }
}
