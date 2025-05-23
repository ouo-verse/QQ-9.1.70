package com.tencent.qqnt.aio.assistedchat.panel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0011J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002RP\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b`\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/a;", "", "", "chatType", "Lcom/tencent/qqnt/aio/assistedchat/panel/o;", "a", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getLoaderClassMap", "()Ljava/util/HashMap;", "setLoaderClassMap", "(Ljava/util/HashMap;)V", "getLoaderClassMap$annotations", "()V", "loaderClassMap", "Ljava/util/concurrent/ConcurrentHashMap;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "outerLoaderMap", "<init>", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f349144a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/assistedchat/Inject_AssistedChat_Outer_SubPanel_Loader.yml", version = 1)
    @NotNull
    private static HashMap<String, Class<o>> loaderClassMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, o> outerLoaderMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58737);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f349144a = new a();
        loaderClassMap = new HashMap<>();
        outerLoaderMap = new ConcurrentHashMap<>();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final o a(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (o) iPatchRedirector.redirect((short) 2, (Object) this, chatType);
        }
        ConcurrentHashMap<Integer, o> concurrentHashMap = outerLoaderMap;
        o oVar = concurrentHashMap.get(Integer.valueOf(chatType));
        if (oVar != null) {
            return oVar;
        }
        Class<o> cls = loaderClassMap.get(String.valueOf(chatType));
        if (cls != null) {
            o loader = cls.newInstance();
            Integer valueOf = Integer.valueOf(chatType);
            Intrinsics.checkNotNullExpressionValue(loader, "loader");
            concurrentHashMap.put(valueOf, loader);
            return loader;
        }
        return null;
    }
}
