package com.tencent.qqnt.kernel.utils;

import com.tencent.mobileqq.injector.x;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R6\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u00058\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/kernel/utils/j;", "", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/kernel/utils/f;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getInject", "()Ljava/util/ArrayList;", "inject", "c", "Lcom/tencent/qqnt/kernel/utils/f;", "a", "()Lcom/tencent/qqnt/kernel/utils/f;", DTConstants.TAG.API, "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f359267a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Service/KernelAdapter/Inject_PerfApi.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<f>> inject;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final f api;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54664);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f359267a = new j();
        ArrayList<Class<f>> arrayList = new ArrayList<>();
        inject = arrayList;
        arrayList.add(x.class);
        f newInstance = arrayList.get(0).newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "inject[0].newInstance()");
        api = newInstance;
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final f a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return api;
    }
}
