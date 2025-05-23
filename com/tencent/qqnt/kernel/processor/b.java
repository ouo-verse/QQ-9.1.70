package com.tencent.qqnt.kernel.processor;

import com.tencent.guild.api.impl.e;
import com.tencent.guild.api.impl.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.kernel.api.ad;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR2\u0010\u000b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u00030\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/kernel/processor/b;", "", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/kernel/api/ad;", "b", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "setSdkStaticCallbackList", "(Ljava/util/ArrayList;)V", "sdkStaticCallbackList", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f359249a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Guild/Inject_AIOGuildKernelConfig.yml", version = 1)
    @NotNull
    private static ArrayList<Class<? extends ad>> sdkStaticCallbackList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54642);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f359249a = new b();
        ArrayList<Class<? extends ad>> arrayList = new ArrayList<>();
        sdkStaticCallbackList = arrayList;
        arrayList.add(a.class);
        sdkStaticCallbackList.add(g.class);
        sdkStaticCallbackList.add(e.class);
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final ArrayList<Class<? extends ad>> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return sdkStaticCallbackList;
    }
}
