package com.tencent.qqnt.chats.core.frequencecontroll;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.bus.event.d;
import com.tencent.qqnt.bus.event.e;
import com.tencent.qqnt.kernel.frequencycontrol.c;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$ResourceBody;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$ResourceItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016R)\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/chats/core/frequencecontroll/ChatsRefreshFrequencyControlDispatcher;", "Lcom/tencent/qqnt/kernel/frequencycontrol/c;", "Lcom/tencent/qqnt/kernel/frequencycontrol/pb/FrequencyControlField$ResourceItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/bus/event/d;", "c", "", "getSceneId", "", "resourceItems", "", "a", "", "", "Lkotlin/Lazy;", "b", "()Ljava/util/Map;", "titlePayRegion", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatsRefreshFrequencyControlDispatcher implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy titlePayRegion;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/core/frequencecontroll/ChatsRefreshFrequencyControlDispatcher$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.frequencecontroll.ChatsRefreshFrequencyControlDispatcher$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44778);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatsRefreshFrequencyControlDispatcher() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(ChatsRefreshFrequencyControlDispatcher$titlePayRegion$2.INSTANCE);
            this.titlePayRegion = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Map<Integer, Object> b() {
        return (Map) this.titlePayRegion.getValue();
    }

    private final d c(FrequencyControlField$ResourceItem item) {
        boolean z16;
        Object[] objArr = null;
        if (!item.has()) {
            return null;
        }
        item.scene_id.get();
        String peerId = item.peer_uid.get();
        int i3 = item.chat_type.get();
        List<FrequencyControlField$ResourceBody> resourceList = item.resource_body_list.get();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Intrinsics.checkNotNullExpressionValue(resourceList, "resourceList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : resourceList) {
            if (!b().containsKey(Integer.valueOf(((FrequencyControlField$ResourceBody) obj).business_id.get() / 1000000))) {
                break;
            }
            arrayList.add(obj);
        }
        Iterator it = arrayList.iterator();
        boolean z17 = false;
        while (true) {
            z16 = true;
            if (!it.hasNext()) {
                break;
            }
            FrequencyControlField$ResourceBody frequencyControlField$ResourceBody = (FrequencyControlField$ResourceBody) it.next();
            Object obj2 = b().get(Integer.valueOf(frequencyControlField$ResourceBody.business_id.get() / 1000000));
            if (!z17 && (!frequencyControlField$ResourceBody.update_scope_type.has() || frequencyControlField$ResourceBody.update_scope_type.get() != 222003)) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (obj2 == null) {
                linkedHashSet = null;
            } else if (linkedHashSet != null) {
                linkedHashSet.add(obj2);
            }
        }
        if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(peerId, "peerId");
        if (linkedHashSet != null) {
            objArr = linkedHashSet.toArray(new Object[0]);
            Intrinsics.checkNotNull(objArr, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        return new d(peerId, i3, objArr, z17);
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.c
    public void a(@NotNull List<FrequencyControlField$ResourceItem> resourceItems) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) resourceItems);
            return;
        }
        Intrinsics.checkNotNullParameter(resourceItems, "resourceItems");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = resourceItems.iterator();
        while (it.hasNext()) {
            d c16 = c((FrequencyControlField$ResourceItem) it.next());
            if (c16 != null) {
                arrayList.add(c16);
            }
        }
        if (!arrayList.isEmpty()) {
            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new e(arrayList));
        }
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.c
    public int getSceneId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 221801;
    }
}
