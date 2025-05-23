package com.tencent.qqnt.aio.shortcutbar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002RP\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b`\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/shortcutbar/k;", "", "", "chatType", "Lcom/tencent/qqnt/aio/shortcutbar/e;", "a", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getLoaderClassMap", "()Ljava/util/HashMap;", "setLoaderClassMap", "(Ljava/util/HashMap;)V", "getLoaderClassMap$annotations", "()V", "loaderClassMap", "Ljava/util/concurrent/ConcurrentHashMap;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "loaderMap", "<init>", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f352115a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/shortcutbar/Inject_Shortcutbar_Loader.yml", version = 1)
    @NotNull
    private static HashMap<String, Class<e>> loaderClassMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, e> loaderMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47801);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f352115a = new k();
        HashMap<String, Class<e>> hashMap = new HashMap<>();
        loaderClassMap = hashMap;
        hashMap.put("119", ba2.c.class);
        loaderClassMap.put("8", com.tencent.qqnt.aio.mycomputer.e.class);
        loaderClassMap.put("117", com.tencent.aio.stranger.impl.shortcut.f.class);
        loaderClassMap.put("115", com.tencent.aio.stranger.impl.shortcut.e.class);
        loaderClassMap.put("113", wq3.d.class);
        loaderClassMap.put("111", com.tencent.aio.stranger.impl.shortcut.e.class);
        loaderClassMap.put("106", com.tencent.aio.stranger.impl.shortcut.d.class);
        loaderClassMap.put("105", com.tencent.aio.stranger.impl.shortcut.b.class);
        loaderClassMap.put("104", com.tencent.aio.stranger.impl.shortcut.c.class);
        loaderClassMap.put("102", com.tencent.aio.stranger.impl.shortcut.a.class);
        loaderClassMap.put("101", com.tencent.aio.stranger.impl.shortcut.e.class);
        loaderClassMap.put("100", com.tencent.aio.stranger.impl.shortcut.e.class);
        loaderClassMap.put("2", com.tencent.mobileqq.aio.shortcurtbar.d.class);
        loaderMap = new ConcurrentHashMap<>();
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final e a(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this, chatType);
        }
        ConcurrentHashMap<String, e> concurrentHashMap = loaderMap;
        if (concurrentHashMap.containsKey(String.valueOf(chatType))) {
            e eVar = concurrentHashMap.get(String.valueOf(chatType));
            Intrinsics.checkNotNull(eVar);
            return eVar;
        }
        if (loaderClassMap.containsKey(String.valueOf(chatType))) {
            Class<e> cls = loaderClassMap.get(String.valueOf(chatType));
            Intrinsics.checkNotNull(cls);
            e loader = cls.newInstance();
            QLog.i("ShortcutBarLoaderFactory", 1, "load " + chatType + " to loaderMap");
            String valueOf = String.valueOf(chatType);
            Intrinsics.checkNotNullExpressionValue(loader, "loader");
            concurrentHashMap.put(valueOf, loader);
            return loader;
        }
        return new c();
    }
}
