package com.tencent.mobileqq.weather.util.report;

import android.text.TextUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/weather/util/report/p;", "", "", "module", "action", "ext1", "ext2", "ext3", "", "a", "", "rspFromClickTime", "e", "clickTime", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, "", "hitCache", "d", "loadCompleteTime", "fromClickTime", "c", "b", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f313692a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43878);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f313692a = new p();
        }
    }

    p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String module, @NotNull String action, @NotNull String ext1, @NotNull String ext2, @NotNull String ext3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, module, action, ext1, ext2, ext3);
            return;
        }
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(ext1, "ext1");
        Intrinsics.checkNotNullParameter(ext2, "ext2");
        Intrinsics.checkNotNullParameter(ext3, "ext3");
        HashMap hashMap = new HashMap();
        hashMap.put("opername", "mainpage_hippy2022");
        hashMap.put("module", module);
        hashMap.put("action", action);
        hashMap.put("ext11", "1");
        hashMap.put("event_code", "mainpage_hippy2022#" + module + "#" + action);
        hashMap.put("ext1", ext1);
        if (!TextUtils.isEmpty(ext2)) {
            hashMap.put("ext2", ext2);
        }
        if (!TextUtils.isEmpty(ext3)) {
            hashMap.put("ext3", ext3);
        }
        e.f313673a.b(hashMap);
    }

    public final void b(long loadCompleteTime, long rspFromClickTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(loadCompleteTime), Long.valueOf(rspFromClickTime));
        } else {
            a("wholepage_ad_loadcompleted", "load", String.valueOf(loadCompleteTime), String.valueOf(rspFromClickTime), "");
        }
    }

    public final void c(long loadCompleteTime, long fromClickTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(loadCompleteTime), Long.valueOf(fromClickTime));
        } else {
            a("wholepage_loadcompleted", "load", String.valueOf(loadCompleteTime), String.valueOf(fromClickTime), "");
        }
    }

    public final void d(long clickTime, long showTime, boolean hitCache) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(clickTime), Long.valueOf(showTime), Boolean.valueOf(hitCache));
            return;
        }
        long j3 = showTime - clickTime;
        String valueOf = String.valueOf(j3);
        if (hitCache) {
            str = "1";
        } else {
            str = "0";
        }
        a("wholepage_loadcache", "load", valueOf, str, String.valueOf(j3));
        a.f313667a.c(clickTime, showTime);
    }

    public final void e(long rspFromClickTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, rspFromClickTime);
        } else {
            a("wholepage_request1", Const.BUNDLE_KEY_REQUEST, String.valueOf(rspFromClickTime), "", "");
        }
    }
}
