package com.tencent.mobileqq.guild.usecase;

import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/usecase/b;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/c;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "invoke", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b implements com.tencent.qqnt.chats.main.vm.usecase.click.c {
    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.c
    public void invoke(@NotNull b.a params) {
        g gVar;
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (b16 instanceof g) {
            gVar = (g) b16;
        } else {
            gVar = null;
        }
        if (gVar != null && ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isDisplayGuildFrameLayout()) {
            IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_channel_id", ex3.a.f(gVar.s()));
            hashMap.put("session_type", Integer.valueOf(gVar.n()));
            Unit unit = Unit.INSTANCE;
            iGuildDTReportApi.doReportEvent("ev_sgrp_subscribe_channel_head_list_clk", hashMap);
        }
    }
}
