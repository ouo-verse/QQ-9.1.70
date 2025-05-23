package com.tencent.mobileqq.proavatar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.dynamic.DynamicResourceFetcher;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002RH\u0010\u000f\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\b8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/proavatar/f;", "", "", "a", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lcom/tencent/qqnt/avatar/core/a;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getResourceFetcherMap", "()Ljava/util/HashMap;", "getResourceFetcherMap$annotations", "()V", "resourceFetcherMap", "<init>", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f259594a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQAvatarImpl/Inject_ProAvatarComponentInit.yml", version = 1)
    @NotNull
    private static final HashMap<String, Class<com.tencent.qqnt.avatar.core.a>> resourceFetcherMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17490);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f259594a = new f();
        HashMap<String, Class<com.tencent.qqnt.avatar.core.a>> hashMap = new HashMap<>();
        resourceFetcherMap = hashMap;
        hashMap.put("5", q30.c.class);
        hashMap.put("4", com.tencent.mobileqq.app.face.g.class);
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1, new DynamicResourceFetcher(1));
        linkedHashMap.put(2, new l());
        linkedHashMap.put(3, new VasPendantResourceFetcher());
        for (Map.Entry<String, Class<com.tencent.qqnt.avatar.core.a>> entry : resourceFetcherMap.entrySet()) {
            try {
                int parseInt = Integer.parseInt(entry.getKey());
                com.tencent.qqnt.avatar.core.a fetcher = entry.getValue().newInstance();
                Integer valueOf = Integer.valueOf(parseInt);
                Intrinsics.checkNotNullExpressionValue(fetcher, "fetcher");
                linkedHashMap.put(valueOf, fetcher);
            } catch (Exception e16) {
                QLog.e("ProAvatarComponentInit", 1, "create resource fetcher error:", e16);
            }
        }
        com.tencent.qqnt.avatar.g.f352801a.q(linkedHashMap);
    }
}
