package com.tencent.mobileqq.tianshu.red.request;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.config.d;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/tianshu/red/request/b;", "", "", "", "paths", "a", "Lcom/tencent/mobileqq/tianshu/config/d;", "b", "Lcom/tencent/mobileqq/tianshu/config/d;", "requestAdBlackList", "<init>", "()V", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f293126a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final d requestAdBlackList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34438);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f293126a = new b();
            requestAdBlackList = (d) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("tianshu_red_request_black_list");
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final List<String> a(@Nullable List<String> paths) {
        boolean z16;
        boolean z17;
        ArrayList<String> a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) paths);
        }
        StringBuilder sb5 = new StringBuilder("filterAdList:");
        List<String> list = paths;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return paths;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : paths) {
                d dVar = requestAdBlackList;
                if (dVar != null && (a16 = dVar.a()) != null && a16.contains(str)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    sb5.append(str + " in black,");
                } else {
                    sb5.append(str + " in white,");
                    arrayList.add(str);
                }
            }
            QLog.d("RedRequestPathLimitManager", 1, sb5);
            return arrayList;
        } catch (Exception unused) {
            return paths;
        }
    }
}
