package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\b\u0010\n\u001a\u00020\tH\u0016J7\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/ark/ArkTipsBar;", "Lcom/tencent/mobileqq/aio/notification/e;", "", "f", "g", "j", "l", "k", "i", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "e", "Lcom/tencent/mobileqq/aio/notification/c;", "notificationManager", "", "eventType", "", "", "params", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/aio/notification/c;I[Ljava/lang/Object;)V", "", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", tl.h.F, "d", "Lcom/tencent/mobileqq/aio/notification/c;", "mManager", "", "Ljava/lang/String;", "tipContent", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "uiModel", "", "J", "msgId", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/a;", "mAction1", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ArkTipsBar implements com.tencent.mobileqq.aio.notification.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.notification.c mManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IAIONotificationUIModel uiModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long msgId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String tipContent = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.a mAction1 = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/ark/ArkTipsBar$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "", "sticky", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            QLog.i("ArkTipsBar", 1, "[mAction1] call:" + i3);
            if (i3 instanceof ArkTipsShowEvent) {
                ArkTipsBar arkTipsBar = ArkTipsBar.this;
                ArkTipsShowEvent arkTipsShowEvent = (ArkTipsShowEvent) i3;
                String a16 = arkTipsShowEvent.a();
                Intrinsics.checkNotNullExpressionValue(a16, "i.content");
                arkTipsBar.tipContent = a16;
                ArkTipsBar.this.msgId = arkTipsShowEvent.b();
                ArkTipsBar.this.e();
                ArkTipsBar.this.k();
                return;
            }
            if (i3 instanceof ArkTipsHideEvent) {
                ArkTipsBar.this.i();
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    private final void f() {
        j();
    }

    private final void g() {
        i();
        l();
    }

    private final void j() {
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mvi.base.route.j e16;
        com.tencent.aio.api.runtime.a a17;
        com.tencent.mvi.base.route.j e17;
        com.tencent.mobileqq.aio.notification.c cVar = this.mManager;
        if (cVar != null && (a17 = cVar.a()) != null && (e17 = a17.e()) != null) {
            e17.d(Reflection.getOrCreateKotlinClass(ArkTipsShowEvent.class).getQualifiedName(), this.mAction1);
        }
        com.tencent.mobileqq.aio.notification.c cVar2 = this.mManager;
        if (cVar2 != null && (a16 = cVar2.a()) != null && (e16 = a16.e()) != null) {
            e16.d(Reflection.getOrCreateKotlinClass(ArkTipsHideEvent.class).getQualifiedName(), this.mAction1);
        }
    }

    private final void l() {
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mvi.base.route.j e16;
        com.tencent.aio.api.runtime.a a17;
        com.tencent.mvi.base.route.j e17;
        com.tencent.mobileqq.aio.notification.c cVar = this.mManager;
        if (cVar != null && (a17 = cVar.a()) != null && (e17 = a17.e()) != null) {
            e17.b(Reflection.getOrCreateKotlinClass(ArkTipsShowEvent.class).getQualifiedName(), this.mAction1);
        }
        com.tencent.mobileqq.aio.notification.c cVar2 = this.mManager;
        if (cVar2 != null && (a16 = cVar2.a()) != null && (e16 = a16.e()) != null) {
            e16.b(Reflection.getOrCreateKotlinClass(ArkTipsHideEvent.class).getQualifiedName(), this.mAction1);
        }
    }

    @Override // com.tencent.mobileqq.aio.notification.e
    @NotNull
    public IAIONotificationUIModel e() {
        IAIONotificationUIModel iAIONotificationUIModel = this.uiModel;
        if (iAIONotificationUIModel != null) {
            Intrinsics.checkNotNull(iAIONotificationUIModel, "null cannot be cast to non-null type com.tencent.mobileqq.aio.notification.IAIONotificationUIModel.SimpleUIModel");
            ((IAIONotificationUIModel.b) iAIONotificationUIModel).h(this.tipContent);
            IAIONotificationUIModel iAIONotificationUIModel2 = this.uiModel;
            Intrinsics.checkNotNull(iAIONotificationUIModel2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.notification.IAIONotificationUIModel.SimpleUIModel");
            return (IAIONotificationUIModel.b) iAIONotificationUIModel2;
        }
        IAIONotificationUIModel.b bVar = new IAIONotificationUIModel.b(AIONotificationBusiId.ARK_TIP, this.tipContent, IAIONotificationUIModel.ActionIcon.CLOSE, "", 0, new Function2<IAIONotificationUIModel, Integer, Unit>() { // from class: com.tencent.mobileqq.ark.ArkTipsBar$getNotificationUIModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel3, Integer num) {
                invoke(iAIONotificationUIModel3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable IAIONotificationUIModel iAIONotificationUIModel3, int i3) {
                com.tencent.mobileqq.aio.notification.c cVar;
                com.tencent.aio.api.runtime.a a16;
                com.tencent.mvi.base.route.j e16;
                long j3;
                if (i3 != 1) {
                    if (i3 == 2 || i3 == 100) {
                        ArkTipsBar.this.i();
                        return;
                    }
                    return;
                }
                cVar = ArkTipsBar.this.mManager;
                if (cVar == null || (a16 = cVar.a()) == null || (e16 = a16.e()) == null) {
                    return;
                }
                j3 = ArkTipsBar.this.msgId;
                e16.h(new MsgNavigationEvent.NavigateByIdEvent("other", j3, false, null, false, null, 60, null));
            }
        });
        this.uiModel = bVar;
        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.notification.IAIONotificationUIModel.SimpleUIModel");
        return bVar;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    @NotNull
    public List<AIONotificationBusiId> h() {
        List<AIONotificationBusiId> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(AIONotificationBusiId.ARK_TIP);
        return listOf;
    }

    public final void i() {
        String token;
        com.tencent.mobileqq.aio.notification.c cVar;
        IAIONotificationUIModel iAIONotificationUIModel = this.uiModel;
        if (iAIONotificationUIModel != null && (token = iAIONotificationUIModel.getToken()) != null && (cVar = this.mManager) != null) {
            cVar.g(token);
        }
    }

    public final void k() {
        com.tencent.mobileqq.aio.notification.c cVar;
        IAIONotificationUIModel iAIONotificationUIModel = this.uiModel;
        if (iAIONotificationUIModel != null && (cVar = this.mManager) != null) {
            cVar.c(iAIONotificationUIModel);
        }
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    public void m(@NotNull com.tencent.mobileqq.aio.notification.c notificationManager, int eventType, @NotNull Object... params) {
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        Intrinsics.checkNotNullParameter(params, "params");
        if (eventType != 1004) {
            if (eventType == 1006) {
                this.mManager = notificationManager;
                f();
                return;
            }
            return;
        }
        g();
    }
}
