package com.tencent.qqnt.aio.factory;

import com.tencent.mobileqq.aio.msglist.AIOMsgItemFactoryExtProvider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.aio.msglist.AIOMsgItemFactoryBusinessProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000bJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R8\u0010\f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u0005j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006`\u00078\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\b\u0010\t\u0012\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/factory/c;", "", "", "Lz71/a;", "a", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getMFactoryProviderList$annotations", "()V", "mFactoryProviderList", "<init>", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f349918a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/msg/aio_msgItem_factory_provider.yml", version = 2)
    @NotNull
    private static ArrayList<Class<z71.a>> mFactoryProviderList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51070);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f349918a = new c();
        ArrayList<Class<z71.a>> arrayList = new ArrayList<>();
        mFactoryProviderList = arrayList;
        arrayList.add(AIOMsgItemFactoryExtProvider.class);
        mFactoryProviderList.add(AIOMsgItemFactoryBusinessProvider.class);
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final List<z71.a> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = mFactoryProviderList.iterator();
        while (it.hasNext()) {
            arrayList.add(((Class) it.next()).newInstance());
        }
        return arrayList;
    }
}
