package com.tencent.mobileqq.ai;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\rJ\u0018\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002RR\u0010\u000e\u001a:\u0012\u0004\u0012\u00020\u0007\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\b0\u0006j\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\b`\t8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u0012\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R@\u0010\u0014\u001a.\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0006j\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/ai/a;", "", "", "type", "Lcom/tencent/mobileqq/ai/i;", "a", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getRenderClazzMap$annotations", "()V", "renderClazzMap", "", "c", "Z", "hadInit", "d", "renderMap", "<init>", "vas-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f187656a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Vas/Inject_AIAvatarInject.yml", version = 1)
    @NotNull
    private static final HashMap<String, Class<i<?, ?>>> renderClazzMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean hadInit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, i<?, ?>> renderMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29965);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f187656a = new a();
        HashMap<String, Class<i<?, ?>>> hashMap = new HashMap<>();
        renderClazzMap = hashMap;
        hashMap.put("1", n53.c.class);
        renderMap = new HashMap<>();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final i<?, ?> a(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (i) iPatchRedirector.redirect((short) 2, (Object) this, type);
        }
        if (!hadInit) {
            for (Map.Entry<String, Class<i<?, ?>>> entry : renderClazzMap.entrySet()) {
                HashMap<String, i<?, ?>> hashMap = renderMap;
                String key = entry.getKey();
                i<?, ?> newInstance = entry.getValue().newInstance();
                Intrinsics.checkNotNullExpressionValue(newInstance, "it.value.newInstance()");
                hashMap.put(key, newInstance);
            }
            hadInit = true;
        }
        return renderMap.get(String.valueOf(type));
    }
}
