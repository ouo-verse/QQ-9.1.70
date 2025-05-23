package com.tencent.qqnt.pluspanel.processor;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/ListenTogetherOnClickProcessor;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "", "uin", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/aio/api/runtime/a;", "context", "", "c", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ListenTogetherOnClickProcessor implements com.tencent.qqnt.pluspanel.logic.b {

    /* renamed from: a, reason: collision with root package name */
    private static final a f360475a = new a(null);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/ListenTogetherOnClickProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, final com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        context.e().h(PlusPanelEvent.UpdatePlusPanel.f360444d);
        com.tencent.qqnt.pluspanel.processor.util.a.f360544a.a(context, new Function2<Long, QQAppInterface, Unit>() { // from class: com.tencent.qqnt.pluspanel.processor.ListenTogetherOnClickProcessor$onClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l3, QQAppInterface qQAppInterface) {
                invoke(l3.longValue(), qQAppInterface);
                return Unit.INSTANCE;
            }

            public final void invoke(long j3, QQAppInterface app) {
                Intrinsics.checkNotNullParameter(app, "app");
                ListenTogetherOnClickProcessor.this.c(j3, app, context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(long uin, QQAppInterface app, com.tencent.aio.api.runtime.a context) {
        int i3;
        boolean z16;
        String str;
        FragmentActivity requireActivity = context.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
        String valueOf = String.valueOf(uin);
        int e16 = context.g().r().c().e();
        int i16 = 2;
        if (e16 == 1) {
            i3 = 2;
            z16 = false;
        } else {
            if (e16 != 2) {
                return;
            }
            z16 = true;
            i3 = 1;
        }
        IRuntimeService runtimeService = app.getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        TroopInfo troopInfo = ((ITroopInfoService) runtimeService).getTroopInfo(valueOf);
        String currentAccountUin = app.getCurrentAccountUin();
        if (!z16) {
            i16 = -1;
        } else if (troopInfo.isTroopOwner(currentAccountUin)) {
            i16 = 0;
        } else if (troopInfo.isTroopAdmin(currentAccountUin)) {
            i16 = 1;
        }
        d72.b.o(app, requireActivity, i3, valueOf, 0);
        if (!z16 && d72.b.l(app, "listen_together_c2c_aio_red_dot_show", true, false)) {
            d72.b.v(app, "listen_together_c2c_aio_red_dot_show", false, false);
        }
        if (!z16) {
            str = "c2c_AIO";
        } else {
            str = "Grp_AIO";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i16);
        String sb6 = sb5.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(i16);
        ReportController.o(null, "dc00899", str, "", "music_tab", "clk_panelmusic", 0, 0, valueOf, sb6, sb7.toString(), "");
    }
}
