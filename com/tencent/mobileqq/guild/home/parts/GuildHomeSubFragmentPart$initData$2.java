package com.tencent.mobileqq.guild.home.parts;

import android.os.Handler;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.event.GuildHomeFragmentOnRefreshEvent;
import com.tencent.mobileqq.guild.home.subhome.c;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupListModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.FetchRoleGroupParam;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.api.IRuntimeService;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lef1/a;", "", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lef1/a;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeSubFragmentPart$initData$2 extends Lambda implements Function1<ef1.a<Boolean>, Unit> {
    final /* synthetic */ GuildHomeSubFragmentPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeSubFragmentPart$initData$2(GuildHomeSubFragmentPart guildHomeSubFragmentPart) {
        super(1);
        this.this$0 = guildHomeSubFragmentPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ri1.a aVar, RoleGroupListModel roleGroupListModel) {
        Intrinsics.checkNotNullParameter(aVar, "<anonymous parameter 0>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(GuildHomeSubFragmentPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9().finishRefresh();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ef1.a<Boolean> aVar) {
        invoke2(aVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ef1.a<Boolean> aVar) {
        c.GuildHomeSubTabData guildHomeSubTabData;
        if (Intrinsics.areEqual(aVar.b(this.this$0), Boolean.TRUE)) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String str = this.this$0.z9().f227656e;
            Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
            GuildHomeFragmentOnRefreshEvent guildHomeFragmentOnRefreshEvent = new GuildHomeFragmentOnRefreshEvent(str);
            guildHomeFragmentOnRefreshEvent.mHashCode = this.this$0.getContext().hashCode();
            simpleEventBus.dispatchEvent(guildHomeFragmentOnRefreshEvent);
            IRuntimeService S0 = com.tencent.mobileqq.guild.util.ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            ((IGPSService) S0).refreshPollingData(this.this$0.z9().f227656e, 0);
            IRoleGroupListRepository p16 = com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p();
            String str2 = this.this$0.z9().f227656e;
            Intrinsics.checkNotNullExpressionValue(str2, "facadeArgsData.guildId");
            p16.h(new FetchRoleGroupParam(str2, null, false, 100, 6, null), new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.home.parts.bw
                @Override // com.tencent.mobileqq.guild.base.repository.h
                public final void a(ri1.a aVar2, Object obj) {
                    GuildHomeSubFragmentPart$initData$2.c(aVar2, (RoleGroupListModel) obj);
                }
            });
            Logger.f235387a.d().i("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "startRefresh");
        }
        guildHomeSubTabData = this.this$0.currentSubTab;
        if (guildHomeSubTabData != null && guildHomeSubTabData.getType() == 1) {
            return;
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final GuildHomeSubFragmentPart guildHomeSubFragmentPart = this.this$0;
        uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.bx
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeSubFragmentPart$initData$2.d(GuildHomeSubFragmentPart.this);
            }
        }, 500L);
    }
}
