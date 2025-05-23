package com.tencent.mobileqq.aio.shop;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.publicaccount.title.QQShopPATitleVB;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020\u00050\u00030\u0002RF\u0010\f\u001a2\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\b\u0018\u00010\u0007j\u0018\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\b\u0018\u0001`\t8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/shop/c;", "", "", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "a", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "injectTitleChildVBList", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f193705a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQShop/Inject_AIO_Shop_VB_Delegate.yml", version = 1)
    @Nullable
    private static ArrayList<Class<com.tencent.aio.base.mvvm.a<?, ?>>> injectTitleChildVBList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57677);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f193705a = new c();
        ArrayList<Class<com.tencent.aio.base.mvvm.a<?, ?>>> arrayList = new ArrayList<>();
        injectTitleChildVBList = arrayList;
        arrayList.add(QQShopPATitleVB.class);
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<Class<com.tencent.aio.base.mvvm.a<?, ?>>> arrayList2 = injectTitleChildVBList;
        if (arrayList2 != null) {
            Iterator<T> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(((Class) it.next()).newInstance());
            }
        }
        return arrayList;
    }
}
