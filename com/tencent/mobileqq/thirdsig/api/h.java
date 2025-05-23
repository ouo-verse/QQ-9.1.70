package com.tencent.mobileqq.thirdsig.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004JJ\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0003R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/thirdsig/api/h;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "domains", "", "a", "", "uin", "sigType", "", "loginAppid", "result", "errMsg", "b", "", "Ljava/util/List;", "Pt4TokenWhiteListDomains", "<init>", "()V", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f292822a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> Pt4TokenWhiteListDomains;

    static {
        List<String> listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36600);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f292822a = new h();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"gamecenter.qq.com", "imgcache.qq.com", "vip.qq.com", "haoma.qq.com", "ivac.qq.com", "hall.qq.com"});
        Pt4TokenWhiteListDomains = listOf;
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull ArrayList<String> domains) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) domains);
        } else {
            Intrinsics.checkNotNullParameter(domains, "domains");
        }
    }

    public final void b(long uin, @NotNull String sigType, int loginAppid, @Nullable ArrayList<String> domains, int result, @NotNull String errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(uin), sigType, Integer.valueOf(loginAppid), domains, Integer.valueOf(result), errMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(sigType, "sigType");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        try {
            QLog.d("ThirdSigReport", 1, "reportThirdSigRequestResult() called with: uin = " + uin + ", sigType = " + sigType + ", loginAppid = " + loginAppid + ", domains = " + domains + ", result = " + result + ", errMsg = " + errMsg);
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103240", false)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("sig_type", sigType);
            hashMap.put("appid", String.valueOf(loginAppid));
            hashMap.put("domains", String.valueOf(domains));
            hashMap.put("fetch_result", String.valueOf(result));
            hashMap.put("err_message", errMsg);
            QQBeaconReport.report(String.valueOf(uin), "wt_third_sig_request_result", hashMap);
        } catch (Exception e16) {
            QLog.e("ThirdSigReport", 1, e16, new Object[0]);
        }
    }
}
