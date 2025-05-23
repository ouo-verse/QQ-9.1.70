package com.tencent.mobileqq.app.message.filescan;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.ForegroundUtil;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/app/message/filescan/b;", "", "", "thr", "", "b", QzoneZipCacheHelper.DIR, "", "operateType", "", "isPublicFile", "", "a", "", "c", "<init>", "()V", "storage-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f195977a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18954);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f195977a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Map<String, String> a(String dir, int operateType, boolean isPublicFile, Throwable thr) {
        boolean isAppOnForeground = ForegroundUtil.isAppOnForeground();
        StorageConfigHelper storageConfigHelper = StorageConfigHelper.f195972a;
        boolean e16 = storageConfigHelper.e(dir);
        boolean d16 = storageConfigHelper.d(dir);
        HashMap hashMap = new HashMap();
        hashMap.put("key_open_file_path", dir);
        hashMap.put("key_operate_type", String.valueOf(operateType));
        hashMap.put("dir_size", String.valueOf(a.f195976a.a(dir, 3)));
        hashMap.put("dir_type", String.valueOf(storageConfigHelper.b(dir)));
        hashMap.put("is_white", String.valueOf(e16 ? 1 : 0));
        hashMap.put("is_in_clear_cache_list", String.valueOf(d16 ? 1 : 0));
        hashMap.put("key_is_foreground", String.valueOf(isAppOnForeground ? 1 : 0));
        hashMap.put("key_stack", f195977a.b(thr));
        hashMap.put("key_is_public_file", String.valueOf(isPublicFile ? 1 : 0));
        return hashMap;
    }

    private final String b(Throwable thr) {
        StringBuilder sb5 = new StringBuilder();
        StackTraceElement[] stackTrace = thr.getStackTrace();
        int min = Math.min(33, stackTrace.length);
        for (int i3 = 13; i3 < min; i3++) {
            sb5.append(stackTrace[i3]);
            sb5.append("\n");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stack.toString()");
        return sb6;
    }

    public final void c(@NotNull String dir, int operateType, boolean isPublicFile, @NotNull Throwable thr) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, dir, Integer.valueOf(operateType), Boolean.valueOf(isPublicFile), thr);
            return;
        }
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(thr, "thr");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        Map<String, String> a16 = a(dir, operateType, isPublicFile, thr);
        QQBeaconReport.report(str, "FileRWMonitor", a16);
        QLog.d("FileMonitorReporter", 1, "doReport reportMap:" + a16);
    }
}
