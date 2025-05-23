package com.tencent.guild.aio.help;

import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.guild.aio.util.ex.ContainerType;
import com.tencent.guild.api.ILocalFocusService;
import com.tencent.mobileqq.guild.mainframe.centerpanel.MFGestureListIntent;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import cr0.GuildActiveInfo;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\b*\u0001\u001a\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/guild/aio/help/q;", "Lcom/tencent/aio/main/businesshelper/h;", "", "b", "e", "c", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "g", "Lrr1/i;", "notifyData", tl.h.F, "", "state", "j", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "com/tencent/guild/aio/help/q$b", "Lcom/tencent/guild/aio/help/q$b;", "action", "<init>", "()V", "f", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class q implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/help/q$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            q.this.g(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    private final void b() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        bVar.a().e().d(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.action);
        j(0);
    }

    private final void c() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        bVar.a().e().b(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.action);
        j(12);
    }

    private final void e() {
        i();
        j(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(MsgIntent i3) {
        if (i3 instanceof MFGestureListIntent.NotifyEvent) {
            h(((MFGestureListIntent.NotifyEvent) i3).getNotifyData());
        }
    }

    private final void h(rr1.i notifyData) {
        boolean z16;
        AppRuntime peekAppRuntime;
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        AIOParam g16 = bVar.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g16);
        if (b16 != null && b16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ILocalFocusService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IL\u2026va, ProcessConstant.MAIN)");
        ILocalFocusService iLocalFocusService = (ILocalFocusService) runtimeService;
        int f16 = notifyData.f();
        if (f16 != 1) {
            if (f16 == 3) {
                if (notifyData.c() != 1 && notifyData.c() != 2) {
                    iLocalFocusService.setActiveChannel(new GuildActiveInfo(new GuildActiveInfo.UniqueKey(b16, null, 2, null), 1, false));
                    QLog.i("LocalFocusHelper", 1, "onNotifyActiveChannel channelId: " + b16 + " bActive:false");
                    return;
                }
                iLocalFocusService.setActiveChannel(new GuildActiveInfo(new GuildActiveInfo.UniqueKey(b16, null, 2, null), 1, true));
                QLog.i("LocalFocusHelper", 1, "onNotifyActiveChannel channelId: " + b16 + " bActive:true");
                return;
            }
            return;
        }
        if ((notifyData.a() == 3 && notifyData.d() == 2) || (notifyData.a() == 2 && notifyData.d() == 1)) {
            iLocalFocusService.setActiveChannel(new GuildActiveInfo(new GuildActiveInfo.UniqueKey(b16, null, 2, null), 1, true));
            QLog.i("LocalFocusHelper", 1, "onNotifyActiveChannel channelId: " + b16 + " bActive:true");
        }
    }

    private final void i() {
        boolean z16;
        AppRuntime peekAppRuntime;
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        if (com.tencent.guild.aio.util.ex.a.c(bVar.a()) != ContainerType.MF_TYPE) {
            return;
        }
        com.tencent.aio.main.businesshelper.b bVar2 = this.param;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar2 = null;
        }
        AIOParam g16 = bVar2.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g16);
        if (b16 != null && b16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        com.tencent.aio.main.businesshelper.b bVar3 = this.param;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar3 = null;
        }
        if (!com.tencent.guild.aio.util.ex.a.g(bVar3.a()) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ILocalFocusService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IL\u2026va, ProcessConstant.MAIN)");
        ((ILocalFocusService) runtimeService).setActiveChannel(new GuildActiveInfo(new GuildActiveInfo.UniqueKey(b16, null, 2, null), 1, true));
        QLog.i("LocalFocusHelper", 1, "setActiveChannelInGuildChatFragmentOnResume channelId: " + b16 + " bActive:true");
    }

    private final void j(int state) {
        boolean z16;
        AppRuntime peekAppRuntime;
        int i3;
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        Integer num = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        if (com.tencent.guild.aio.util.ex.a.c(bVar.a()) == ContainerType.MF_TYPE) {
            return;
        }
        com.tencent.aio.main.businesshelper.b bVar2 = this.param;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar2 = null;
        }
        AIOParam g16 = bVar2.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g16);
        if (b16 != null && b16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        String str = "";
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ILocalFocusService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IL\u2026va, ProcessConstant.MAIN)");
        ILocalFocusService iLocalFocusService = (ILocalFocusService) runtimeService;
        com.tencent.aio.main.businesshelper.b bVar3 = this.param;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar3 = null;
        }
        if (com.tencent.guild.aio.util.ex.a.b(bVar3.a())) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        if (i3 == 2) {
            com.tencent.aio.main.businesshelper.b bVar4 = this.param;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar4 = null;
            }
            FragmentActivity activity = bVar4.a().c().getActivity();
            if (activity != null) {
                num = Integer.valueOf(activity.hashCode());
            }
            str = String.valueOf(num);
        }
        if (state != 0 && state != 3) {
            if (state == 12) {
                iLocalFocusService.setActiveChannel(new GuildActiveInfo(new GuildActiveInfo.UniqueKey(b16, str), i3, false));
                return;
            }
            return;
        }
        iLocalFocusService.setActiveChannel(new GuildActiveInfo(new GuildActiveInfo.UniqueKey(b16, str), i3, true));
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "LocalFocusHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 3, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 0) {
            if (state != 3) {
                if (state == 12) {
                    c();
                    return;
                }
                return;
            }
            e();
            return;
        }
        b();
    }
}
