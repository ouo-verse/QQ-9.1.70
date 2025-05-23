package com.tencent.qqnt.kernel.processor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UIConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002RB\u0010\u000e\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\bj\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t`\n8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u0012\u0004\b\f\u0010\rR0\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/kernel/processor/c;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UIConfig;", "cfg", "Lcx3/a;", "b", "", "a", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getSKernelUIConfigProcessorClassMap$annotations", "()V", "sKernelUIConfigProcessorClassMap", "c", "sKernelUIConfigProcessorMap", "<init>", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f359251a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Service/KernelAdapter/Inject_Kernel_UI_Config_Processor.yml", version = 4)
    @NotNull
    private static final HashMap<String, Class<cx3.a>> sKernelUIConfigProcessorClassMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, cx3.a> sKernelUIConfigProcessorMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54643);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f359251a = new c();
        HashMap<String, Class<cx3.a>> hashMap = new HashMap<>();
        sKernelUIConfigProcessorClassMap = hashMap;
        hashMap.put("KTOFUCFG", com.tencent.qqnt.aio.predownload.pic.config.c.class);
        hashMap.put("KDATALINEAUTODOWNLOADCFG", com.tencent.qqnt.aio.predownload.pic.config.c.class);
        hashMap.put("KREVEALCFG", com.tencent.qqnt.chats.main.lightbusiness.reveal.c.class);
        hashMap.put("KLITEACTIONCFG", com.tencent.qqnt.lightbusinesskit.b.class);
        hashMap.put("KAVIFDOWNLOADCFG", com.tencent.qqnt.aio.predownload.pic.config.c.class);
        hashMap.put("KXGAUTODOWNLOADPIC", com.tencent.qqnt.aio.predownload.pic.config.c.class);
        hashMap.put("KGIFCFG", com.tencent.qqnt.aio.predownload.pic.config.c.class);
        hashMap.put("KAIOPICCFG", com.tencent.qqnt.aio.predownload.pic.config.c.class);
        hashMap.put("KAUTODOWNLOADPICCFG", com.tencent.qqnt.aio.predownload.pic.config.c.class);
        sKernelUIConfigProcessorMap = new HashMap<>();
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final synchronized String a(@NotNull UIConfig cfg) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cfg);
        }
        Intrinsics.checkNotNullParameter(cfg, "cfg");
        cx3.a b16 = b(cfg);
        if (b16 != null) {
            str = b16.a(cfg);
        } else {
            str = null;
        }
        return str;
    }

    @Nullable
    public final synchronized cx3.a b(@NotNull UIConfig cfg) {
        cx3.a newInstance;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (cx3.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cfg);
        }
        Intrinsics.checkNotNullParameter(cfg, "cfg");
        Class<cx3.a> cls = sKernelUIConfigProcessorClassMap.get(cfg.name());
        if (cls == null) {
            return null;
        }
        String key = cls.getSimpleName();
        HashMap<String, cx3.a> hashMap = sKernelUIConfigProcessorMap;
        cx3.a aVar = hashMap.get(key);
        if (aVar == null) {
            try {
                newInstance = cls.newInstance();
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                hashMap.put(key, newInstance);
                aVar = newInstance;
            } catch (Throwable th6) {
                th = th6;
                aVar = newInstance;
                QLog.e("KernelUIConfigProcessor", 1, "getConfig error! cfg=" + cfg, th);
                return aVar;
            }
        }
        return aVar;
    }
}
