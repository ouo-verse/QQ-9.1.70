package com.tencent.mobileqq.aio.notifyservice;

import com.tencent.aio.api.help.d;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.provider.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u000fJ\u001c\u0010\u0006\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020\u00050\u00030\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007RL\u0010\u0010\u001a2\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u000b\u0018\u00010\nj\u0018\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u000b\u0018\u0001`\f8\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\t\u0010\r\u0012\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00110\u000b0\n8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/notifyservice/c;", "", "", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "a", "", "Lcom/tencent/aio/main/businesshelper/h;", "b", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getInjectInputChildVBList$annotations", "()V", "injectInputChildVBList", "Lcom/tencent/aio/api/help/d;", "c", "outerHelperProvider", "<init>", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f193012a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/aio/Inject_notify_service_vb_provider.yml", version = 1)
    @Nullable
    private static ArrayList<Class<com.tencent.aio.base.mvvm.a<?, ?>>> injectInputChildVBList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/helper/Inject_notify_service_aio_helper_provider.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<? extends d>> outerHelperProvider;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54875);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f193012a = new c();
        ArrayList<Class<com.tencent.aio.base.mvvm.a<?, ?>>> arrayList = new ArrayList<>();
        injectInputChildVBList = arrayList;
        arrayList.add(ky.b.class);
        ArrayList<Class<? extends d>> arrayList2 = new ArrayList<>();
        outerHelperProvider = arrayList2;
        arrayList2.add(i.class);
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
        ArrayList<Class<com.tencent.aio.base.mvvm.a<?, ?>>> arrayList2 = injectInputChildVBList;
        if (arrayList2 != null) {
            Iterator<T> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(((Class) it.next()).newInstance());
            }
        }
        return arrayList;
    }

    @NotNull
    public final Collection<h> b() {
        h[] lifeCycleHelper;
        List list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Collection) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = outerHelperProvider.iterator();
        while (it.hasNext()) {
            try {
                d dVar = (d) ((Class) it.next()).getConstructor(new Class[0]).newInstance(new Object[0]);
                if (dVar != null && (lifeCycleHelper = dVar.getLifeCycleHelper()) != null) {
                    list = ArraysKt___ArraysKt.toList(lifeCycleHelper);
                    arrayList.addAll(list);
                }
            } catch (Exception e16) {
                QLog.e("PublicAccountAIOInject", 1, "getOuterHelpers exception:", e16);
            }
        }
        return arrayList;
    }
}
