package com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.adapter;

import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.adapter.QuestionAndAnswerAdapter;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class QuestionAndAnswerAdapter$onBindViewHolder$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ QuestionAndAnswerAdapter.a $holder;
    final /* synthetic */ QuestionAndAnswerAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuestionAndAnswerAdapter$onBindViewHolder$3(QuestionAndAnswerAdapter questionAndAnswerAdapter, QuestionAndAnswerAdapter.a aVar) {
        super(0);
        this.this$0 = questionAndAnswerAdapter;
        this.$holder = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QuestionAndAnswerAdapter this$0, QuestionAndAnswerAdapter.a holder, DialogInterface dialogInterface, int i3) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        this$0.p0(holder.getAdapterPosition());
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_datong_page_id", "pg_sgrp_auditset_question"), TuplesKt.to("sgrp_btn_type", 1), TuplesKt.to("sgrp_type", 2));
        iGuildDTReportApi.doReportEvent("ev_sgrp_auditset_delete_pop_and", hashMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DialogInterface dialogInterface, int i3) {
        HashMap hashMapOf;
        dialogInterface.dismiss();
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_datong_page_id", "pg_sgrp_auditset_question"), TuplesKt.to("sgrp_btn_type", 2), TuplesKt.to("sgrp_type", 2));
        iGuildDTReportApi.doReportEvent("ev_sgrp_auditset_delete_pop_and", hashMapOf);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        HashMap hashMapOf;
        final QuestionAndAnswerAdapter questionAndAnswerAdapter = this.this$0;
        final QuestionAndAnswerAdapter.a aVar = this.$holder;
        if (o.c("fastClickGuard")) {
            return;
        }
        if (questionAndAnswerAdapter.mItems.size() == 1) {
            QQToast.makeText(aVar.getDelete().getContext(), aVar.getDelete().getContext().getString(R.string.f147110w0), 0).show();
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(aVar.itemView.getContext(), 230, (String) null, "\u786e\u5b9a\u5220\u9664\u95ee\u9898" + (aVar.getAdapterPosition() + 1) + "\u5417", QQGuildUIUtil.r(R.string.f140850f3), QQGuildUIUtil.r(R.string.f143030kz), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.adapter.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QuestionAndAnswerAdapter$onBindViewHolder$3.c(QuestionAndAnswerAdapter.this, aVar, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.adapter.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QuestionAndAnswerAdapter$onBindViewHolder$3.d(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(holde\u2026 )\n                    })");
        createCustomDialog.show();
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_datong_page_id", "pg_sgrp_auditset_question"), TuplesKt.to("sgrp_type", 1));
        iGuildDTReportApi.doReportEvent("ev_sgrp_auditset_delete_pop_and", hashMapOf);
    }
}
