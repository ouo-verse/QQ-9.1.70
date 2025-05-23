package com.tencent.qqnt.chats.main.api.impl;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.bus.event.b;
import com.tencent.qqnt.bus.event.f;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.api.IMainChatsUnreadHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016R \u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/chats/main/api/impl/MainChatsUnreadHelperImpl;", "Lcom/tencent/qqnt/chats/main/api/IMainChatsUnreadHelper;", "Landroid/view/View;", "view", "", "bindView", "unbindView", "notifyClearAll", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "notifyClearItem", "", "getBindViews", "", "Ljava/lang/ref/WeakReference;", "dragViews", "Ljava/util/List;", "Lcom/tencent/qqnt/bus/api/IBusManager;", "eventBus$delegate", "Lkotlin/Lazy;", "getEventBus", "()Lcom/tencent/qqnt/bus/api/IBusManager;", "eventBus", "<init>", "()V", "Companion", "a", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MainChatsUnreadHelperImpl implements IMainChatsUnreadHelper {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "MainChatsUnreadHelper";

    @NotNull
    private final List<WeakReference<View>> dragViews;

    /* renamed from: eventBus$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy eventBus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/main/api/impl/MainChatsUnreadHelperImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.api.impl.MainChatsUnreadHelperImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44905);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MainChatsUnreadHelperImpl() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.dragViews = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(MainChatsUnreadHelperImpl$eventBus$2.INSTANCE);
        this.eventBus = lazy;
    }

    private final IBusManager getEventBus() {
        return (IBusManager) this.eventBus.getValue();
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatsUnreadHelper
    public void bindView(@NotNull View view) {
        Object obj;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Iterator<T> it = this.dragViews.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                WeakReference weakReference = (WeakReference) obj;
                if (weakReference.get() != null && Intrinsics.areEqual(weakReference.get(), view)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj == null) {
            this.dragViews.add(new WeakReference<>(view));
        }
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatsUnreadHelper
    @NotNull
    public List<View> getBindViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        List<WeakReference<View>> list = this.dragViews;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            View view = (View) ((WeakReference) it.next()).get();
            if (view != null) {
                arrayList.add(view);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatsUnreadHelper
    public void notifyClearAll() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.dragViews.iterator();
        while (it.hasNext()) {
            View view = (View) ((WeakReference) it.next()).get();
            g gVar = null;
            if (view != null) {
                obj = view.getTag(R.id.f70873mm);
            } else {
                obj = null;
            }
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            if (gVar != null) {
                arrayList.add(new f(gVar.k(), gVar.l(), gVar.n()));
            }
        }
        this.dragViews.clear();
        if (!arrayList.isEmpty()) {
            getEventBus().sendEvent(new b(arrayList));
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "notifyClearAll");
        }
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatsUnreadHelper
    public void notifyClearItem(@NotNull g item) {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        IBusManager eventBus = getEventBus();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new f(item.k(), item.l(), item.n()));
        eventBus.sendEvent(new b(listOf));
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "notifyClearItem");
        }
    }

    @Override // com.tencent.qqnt.chats.main.api.IMainChatsUnreadHelper
    public void unbindView(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Iterator<WeakReference<View>> it = this.dragViews.iterator();
        while (it.hasNext()) {
            WeakReference<View> next = it.next();
            if (next.get() == null || Intrinsics.areEqual(next.get(), view)) {
                it.remove();
            }
        }
    }
}
