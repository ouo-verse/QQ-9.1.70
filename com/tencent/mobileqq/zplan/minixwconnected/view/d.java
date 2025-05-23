package com.tencent.mobileqq.zplan.minixwconnected.view;

import android.content.Context;
import com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 $2\u00020\u0001:\u0001\u0007B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/d;", "Lcom/tencent/mobileqq/zplan/minixwconnected/c;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectInviteView;", "inviteView", "", "friendUin", "", "a", "", "param", OperateCustomButton.OPERATE_CREATE, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "resume", "pause", "destroy", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "c", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "getController", "()Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "controller", "d", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectInviteView;", "<init>", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;)V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d implements com.tencent.mobileqq.zplan.minixwconnected.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope scope;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final MiniHomeConnectedController controller;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private MiniHomeConnectInviteView inviteView;

    public d(Context context, CoroutineScope scope, MiniHomeConnectedController controller) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.context = context;
        this.scope = scope;
        this.controller = controller;
    }

    public final void a(MiniHomeConnectInviteView inviteView, long friendUin) {
        this.inviteView = inviteView;
        if (inviteView != null) {
            inviteView.c(this.scope, friendUin);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void createView() {
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void destroy() {
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void pause() {
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void resume() {
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void create(Object param) {
    }
}
