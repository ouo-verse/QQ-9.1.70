package com.tencent.qqnt.util;

import com.tencent.mobileqq.injector.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/util/a;", "", "", "b", "Lcom/tencent/mobileqq/inject/b;", "Lcom/tencent/mobileqq/inject/b;", "a", "()Lcom/tencent/mobileqq/inject/b;", "setSAppSetting", "(Lcom/tencent/mobileqq/inject/b;)V", "sAppSetting", "<init>", "()V", "nt_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f362973a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Component/nt_util_kit/Inject_AppSetting.yml", version = 1)
    @Nullable
    private static com.tencent.mobileqq.inject.b sAppSetting;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f362975c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38777);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f362975c = arrayList;
        arrayList.add(d.class);
        f362973a = new a();
        b();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @QAutoInitMethod
    public static final void b() {
        sAppSetting = (com.tencent.mobileqq.inject.b) com.tencent.mobileqq.qroute.utils.b.a(f362975c);
    }

    @Nullable
    public final com.tencent.mobileqq.inject.b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.inject.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return sAppSetting;
    }
}
