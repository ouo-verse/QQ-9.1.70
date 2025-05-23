package com.tencent.mobileqq.sharepanel.channel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\rJ\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002RN\u0010\u000e\u001a6\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\b0\u0007j\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\b`\t8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u0012\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/channel/b;", "", "", "channelId", "Lcom/tencent/mobileqq/sharepanel/channel/handler/e;", "Lcom/tencent/mobileqq/sharepanel/channel/handler/f;", "a", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getHandlerClassMap$annotations", "()V", "handlerClassMap", "<init>", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f287179a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/SharePanel/Inject_ShareChannelHandlerFactory.yml", version = 1)
    @NotNull
    private static final HashMap<String, Class<com.tencent.mobileqq.sharepanel.channel.handler.e<com.tencent.mobileqq.sharepanel.channel.handler.f>>> handlerClassMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31826);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f287179a = new b();
        HashMap<String, Class<com.tencent.mobileqq.sharepanel.channel.handler.e<com.tencent.mobileqq.sharepanel.channel.handler.f>>> hashMap = new HashMap<>();
        handlerClassMap = hashMap;
        hashMap.put("qqfriend", com.tencent.mobileqq.sharepanel.channel.handler.d.class);
        hashMap.put("directForward", com.tencent.mobileqq.sharepanel.channel.handler.b.class);
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final com.tencent.mobileqq.sharepanel.channel.handler.e<com.tencent.mobileqq.sharepanel.channel.handler.f> a(@NotNull String channelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.sharepanel.channel.handler.e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) channelId);
        }
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Class<com.tencent.mobileqq.sharepanel.channel.handler.e<com.tencent.mobileqq.sharepanel.channel.handler.f>> cls = handlerClassMap.get(channelId);
        if (cls != null) {
            return cls.newInstance();
        }
        return null;
    }
}
