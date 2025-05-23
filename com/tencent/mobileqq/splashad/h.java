package com.tencent.mobileqq.splashad;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/splashad/h;", "", "Lcom/tencent/mobileqq/splashad/g;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f288777a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60491);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f288777a = new h();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final g a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (g) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            long i3 = SplashADUtil.i(BaseApplicationImpl.getApplication());
            List<String> k3 = com.tencent.mobileqq.vassplash.common.c.k(BaseApplication.getContext(), i3);
            if (k3 != null && k3.size() > 0) {
                BaseApplication context = BaseApplication.getContext();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(i3);
                Set<String> j3 = com.tencent.mobileqq.vassplash.common.c.j(context, sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append(i3);
                HashMap<String, o43.a> a16 = com.tencent.mobileqq.vassplash.common.c.a(sb6.toString(), j3);
                for (String str : k3) {
                    if (a16.containsKey(str)) {
                        o43.a aVar = a16.get(str);
                        boolean z16 = false;
                        if (aVar != null && true == aVar.h()) {
                            z16 = true;
                        }
                        if (z16) {
                            if (QLog.isColorLevel()) {
                                QLog.i("SplashAdDataHelper", 2, "vassplash should show kill");
                            }
                            String str2 = aVar.f421927c;
                            Intrinsics.checkNotNullExpressionValue(str2, "entry.mBeginTime");
                            long parseLong = Long.parseLong(str2);
                            String str3 = aVar.f421929d;
                            Intrinsics.checkNotNullExpressionValue(str3, "entry.mEndTime");
                            return new g(1, parseLong, Long.parseLong(str3));
                        }
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable th5) {
            QLog.e("SplashAdDataHelper", 2, "erro", th5);
            return null;
        }
    }
}
