package com.tencent.guild.aio.reserve2.busi.chosen.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.guild.aio.reserve2.busi.chosen.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/chosen/menu/RemoveChosenMsgItem;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/menu/g;", "Lcom/tencent/guild/aio/reserve2/busi/chosen/d$a;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "f", "data", "", "r", "view", "", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Lazy;", "Leo0/c;", "g", "Lkotlin/Lazy;", "useCase", "<init>", "()V", tl.h.F, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class RemoveChosenMsgItem extends g<d.ChosenParams> {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Lazy<eo0.c> useCase;

    public RemoveChosenMsgItem() {
        super(R.string.f1649827a);
        Lazy<eo0.c> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<eo0.c>() { // from class: com.tencent.guild.aio.reserve2.busi.chosen.menu.RemoveChosenMsgItem$useCase$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final eo0.c invoke() {
                return new eo0.c(RemoveChosenMsgItem.this.j().getHostContext());
            }
        });
        this.useCase = lazy;
    }

    @Override // com.tencent.guild.aio.reserve2.busi.chosen.menu.g, com.tencent.guild.aio.halfpop.menu.n
    @NotNull
    public View f(@NotNull LayoutInflater inflater, @NotNull Context context, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        View f16 = super.f(inflater, context, container);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(f16, "em_aio_top_sticky_post_more_remove", null);
        return f16;
    }

    @Override // com.tencent.guild.aio.reserve2.busi.chosen.menu.g, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull d.ChosenParams data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Boolean hasTargetSecondaryPermission = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).hasTargetSecondaryPermission(30001, data.getIoaParams().f(), data.getIoaParams().j());
        Intrinsics.checkNotNullExpressionValue(hasTargetSecondaryPermission, "api(IQQGuildUtilApi::cla\u2026ams.peerUid\n            )");
        return hasTargetSecondaryPermission.booleanValue();
    }

    @Override // com.tencent.guild.aio.reserve2.busi.chosen.menu.g, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull View view, @NotNull d.ChosenParams data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        super.b(view, data);
        QLog.i("RemoveChosenMsgItem", 4, "onItemClick data=" + data);
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_sgrp_sticky_post_info");
        hashMap.put("sgrp_channel_id", data.getIoaParams().f());
        hashMap.put("sgrp_sub_channel_id", data.getIoaParams().j());
        hashMap.put("eid", "em_aio_remove_top_sticky");
        VideoReport.reportEvent("dt_clck", hashMap);
        this.useCase.getValue().e(data.getIoaParams().f(), data.getIoaParams().j(), data.getSelectedMsgSeq());
    }
}
