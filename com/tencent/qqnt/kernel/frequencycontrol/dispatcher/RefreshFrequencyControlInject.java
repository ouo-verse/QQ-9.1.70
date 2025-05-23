package com.tencent.qqnt.kernel.frequencycontrol.dispatcher;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.frequencycontrol.b;
import com.tencent.qqnt.chats.core.frequencecontroll.ChatsRefreshFrequencyControlDispatcher;
import com.tencent.qqnt.kernel.frequencycontrol.c;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$ResourceItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u000fJ\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R6\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n`\f8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\r\u0012\u0004\b\u000e\u0010\u000fR7\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0011j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b`\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/kernel/frequencycontrol/dispatcher/RefreshFrequencyControlInject;", "", "", WadlProxyConsts.SCENE_ID, "", "Lcom/tencent/qqnt/kernel/frequencycontrol/pb/FrequencyControlField$ResourceItem;", "resourceItems", "", "b", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/kernel/frequencycontrol/c;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getRefreshDispatcherClassList$annotations", "()V", "refreshDispatcherClassList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Lkotlin/Lazy;", "()Ljava/util/HashMap;", "refreshDispatcherMap", "<init>", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class RefreshFrequencyControlInject {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RefreshFrequencyControlInject f359080a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Service/KernelAdapter/Inject_Refresh_Frequency_Control_Dispatcher.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<c>> refreshDispatcherClassList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy refreshDispatcherMap;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54539);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f359080a = new RefreshFrequencyControlInject();
        ArrayList<Class<c>> arrayList = new ArrayList<>();
        refreshDispatcherClassList = arrayList;
        arrayList.add(ChatsRefreshFrequencyControlDispatcher.class);
        arrayList.add(b.class);
        lazy = LazyKt__LazyJVMKt.lazy(RefreshFrequencyControlInject$refreshDispatcherMap$2.INSTANCE);
        refreshDispatcherMap = lazy;
    }

    RefreshFrequencyControlInject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final HashMap<Integer, c> c() {
        return (HashMap) refreshDispatcherMap.getValue();
    }

    public final void b(int sceneId, @NotNull List<FrequencyControlField$ResourceItem> resourceItems) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, sceneId, (Object) resourceItems);
            return;
        }
        Intrinsics.checkNotNullParameter(resourceItems, "resourceItems");
        if (resourceItems.isEmpty()) {
            return;
        }
        c cVar = c().get(Integer.valueOf(sceneId));
        if (cVar == null) {
            QLog.e("RefreshFrequencyControlInject", 1, "[dispatchRefresh]: no matched dispatcher, sceneId is " + sceneId);
            return;
        }
        cVar.a(resourceItems);
    }
}
