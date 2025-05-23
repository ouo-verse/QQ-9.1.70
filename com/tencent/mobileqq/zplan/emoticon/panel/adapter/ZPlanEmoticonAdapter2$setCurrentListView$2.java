package com.tencent.mobileqq.zplan.emoticon.panel.adapter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.mobileqq.zplan.aio.panel.page.ActionPage;
import com.tencent.mobileqq.zplan.aio.panel.page.Page;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.mobileqq.zplan.aio.panel.panel.view.AbstractPanelLayout;
import com.tencent.mobileqq.zplan.aio.panel.panel.view.AioPanelLayout;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010\u0004\u001a\u00020\u0003H\u0007\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/panel/adapter/ZPlanEmoticonAdapter2$setCurrentListView$2", "Landroidx/lifecycle/LifecycleObserver;", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "onResume", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanEmoticonAdapter2$setCurrentListView$2 implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ StateFlow<Panel> f333141d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ZPlanEmoticonAdapter2 f333142e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ AioPanelLayout f333143f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ WeakReference<AioPanelLayout> f333144h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZPlanEmoticonAdapter2$setCurrentListView$2(StateFlow<Panel> stateFlow, ZPlanEmoticonAdapter2 zPlanEmoticonAdapter2, AioPanelLayout aioPanelLayout, WeakReference<AioPanelLayout> weakReference) {
        this.f333141d = stateFlow;
        this.f333142e = zPlanEmoticonAdapter2;
        this.f333143f = aioPanelLayout;
        this.f333144h = weakReference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WeakReference ppRef) {
        Intrinsics.checkNotNullParameter(ppRef, "$ppRef");
        AioPanelLayout aioPanelLayout = (AioPanelLayout) ppRef.get();
        if (aioPanelLayout != null) {
            AbstractPanelLayout.e(aioPanelLayout, 0, 0, 3, null);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        for (Page page : this.f333141d.getValue().b()) {
            page.t(false);
            Iterator<com.tencent.mobileqq.zplan.aio.panel.item.b> it = page.c().iterator();
            while (it.hasNext()) {
                it.next().p(false);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        for (Page page : this.f333141d.getValue().b()) {
            page.t(true);
            if (page instanceof ActionPage) {
                this.f333142e.t((ActionPage) page);
            }
        }
        AioPanelLayout aioPanelLayout = this.f333143f;
        final WeakReference<AioPanelLayout> weakReference = this.f333144h;
        aioPanelLayout.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.d
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanEmoticonAdapter2$setCurrentListView$2.b(weakReference);
            }
        }, 500L);
    }
}
