package com.tencent.mobileqq.flock.datong;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0007J*\u0010\t\u001a\u00020\b2\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/flock/datong/a;", "", "", "", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "Lcom/tencent/qqlive/module/videoreport/PageParams;", "b", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f210009a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24769);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f210009a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final Map<String, Object> a() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        return hashMap;
    }

    @NotNull
    public final PageParams b(@NotNull HashMap<String, Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PageParams) iPatchRedirector.redirect((short) 2, (Object) this, (Object) params);
        }
        Intrinsics.checkNotNullParameter(params, "params");
        params.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        return new PageParams(params);
    }
}
