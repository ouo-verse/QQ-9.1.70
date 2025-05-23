package com.tencent.qqnt.aio.bottombar.sectionbar.loader;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R<\u0010\f\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b`\t8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR0\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/loader/a;", "", "", "chatType", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/loader/c;", "a", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "mLoaderClzMap", "c", "mLoaderInstantMap", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f349818a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/bottombar/Inject_bottom_section_bar_loader.yml", version = 3)
    @NotNull
    private static final HashMap<String, Class<c>> mLoaderClzMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, c> mLoaderInstantMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65539);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f349818a = new a();
        HashMap<String, Class<c>> hashMap = new HashMap<>();
        mLoaderClzMap = hashMap;
        hashMap.put("119", com.tencent.qqnt.aio.assistedchat.bottombar.sectionbar.loader.b.class);
        hashMap.put("104", com.tencent.qqnt.aio.assistedchat.bottombar.sectionbar.loader.a.class);
        hashMap.put("8", com.tencent.qqnt.aio.mycomputer.sectionbar.loader.a.class);
        hashMap.put("1", b.class);
        mLoaderInstantMap = new HashMap<>();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final c a(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, chatType);
        }
        HashMap<Integer, c> hashMap = mLoaderInstantMap;
        c cVar = hashMap.get(Integer.valueOf(chatType));
        if (cVar != null) {
            return cVar;
        }
        Class<c> cls = mLoaderClzMap.get(String.valueOf(chatType));
        if (cls != null) {
            c newInstance = cls.newInstance();
            if (newInstance != null) {
                hashMap.put(Integer.valueOf(chatType), newInstance);
            }
            return newInstance;
        }
        return null;
    }
}
