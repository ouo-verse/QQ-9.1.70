package com.tencent.guild.aio.help;

import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.guild.client.IGuildClientAuthApi;
import com.tencent.mobileqq.guild.mainframe.centerpanel.MFGestureListIntent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppActivity;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005H\u0016R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/help/h;", "Lcom/tencent/aio/main/businesshelper/h;", "", "b", "c", "", "getId", "", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "interestedIn", "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "Lcom/tencent/mvi/base/route/a;", "e", "Lcom/tencent/mvi/base/route/a;", "action", "<init>", "()V", "f", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class h implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.a action = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/help/h$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (!(i3 instanceof MFGestureListIntent.NotifyEvent)) {
                return;
            }
            rr1.i notifyData = ((MFGestureListIntent.NotifyEvent) i3).getNotifyData();
            if (notifyData.f() == 3 && notifyData.c() == 1) {
                IGuildClientAuthApi iGuildClientAuthApi = (IGuildClientAuthApi) QRoute.api(IGuildClientAuthApi.class);
                com.tencent.aio.main.businesshelper.b bVar = h.this.param;
                com.tencent.aio.main.businesshelper.b bVar2 = null;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    bVar = null;
                }
                FragmentActivity activity = bVar.a().c().getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type mqq.app.AppActivity");
                AppActivity appActivity = (AppActivity) activity;
                com.tencent.aio.main.businesshelper.b bVar3 = h.this.param;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    bVar3 = null;
                }
                String f16 = bVar3.a().g().r().c().f();
                com.tencent.aio.main.businesshelper.b bVar4 = h.this.param;
                if (bVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                } else {
                    bVar2 = bVar4;
                }
                iGuildClientAuthApi.showClientGuideAuthDialog(appActivity, f16, bVar2.a().g().r().c().j());
            }
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
    }

    private final void c() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        bVar.a().e().b(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.action);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 8;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "GuildAppAuthorHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 12};
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
            if (state == 12) {
                c();
                return;
            }
            return;
        }
        b();
    }
}
