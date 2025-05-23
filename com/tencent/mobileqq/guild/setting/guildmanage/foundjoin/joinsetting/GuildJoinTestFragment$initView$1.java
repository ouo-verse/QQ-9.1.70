package com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting;

import android.os.Handler;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.adapter.GuildJoinTestAdapter;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildChoiceQuestionItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildJoinTestFragment$initView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GuildJoinTestFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildJoinTestFragment$initView$1(GuildJoinTestFragment guildJoinTestFragment) {
        super(0);
        this.this$0 = guildJoinTestFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildJoinTestFragment this$0) {
        NestedScrollView nestedScrollView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        nestedScrollView = this$0.scrollview;
        if (nestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollview");
            nestedScrollView = null;
        }
        nestedScrollView.fullScroll(130);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        GuildJoinTestAdapter guildJoinTestAdapter;
        GuildJoinTestAdapter guildJoinTestAdapter2;
        GuildJoinTestAdapter guildJoinTestAdapter3;
        q qVar;
        GuildJoinTestAdapter guildJoinTestAdapter4;
        Handler handler;
        q qVar2;
        GuildJoinTestAdapter guildJoinTestAdapter5;
        final GuildJoinTestFragment guildJoinTestFragment = this.this$0;
        if (com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            return;
        }
        guildJoinTestAdapter = guildJoinTestFragment.adapter;
        GuildJoinTestAdapter guildJoinTestAdapter6 = null;
        if (guildJoinTestAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            guildJoinTestAdapter = null;
        }
        if (guildJoinTestAdapter.getItems().size() < 8) {
            guildJoinTestAdapter2 = guildJoinTestFragment.adapter;
            if (guildJoinTestAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                guildJoinTestAdapter2 = null;
            }
            List<GWGProJoinGuildChoiceQuestionItem> items = guildJoinTestAdapter2.getItems();
            GWGProJoinGuildChoiceQuestionItem gWGProJoinGuildChoiceQuestionItem = new GWGProJoinGuildChoiceQuestionItem();
            gWGProJoinGuildChoiceQuestionItem.setQuestion("");
            gWGProJoinGuildChoiceQuestionItem.setCorrectAnswer("");
            items.add(gWGProJoinGuildChoiceQuestionItem);
            guildJoinTestAdapter3 = guildJoinTestFragment.adapter;
            if (guildJoinTestAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                guildJoinTestAdapter3 = null;
            }
            guildJoinTestAdapter3.notifyDataSetChanged();
            qVar = guildJoinTestFragment.mViewModel;
            if (qVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                qVar = null;
            }
            guildJoinTestAdapter4 = guildJoinTestFragment.adapter;
            if (guildJoinTestAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                guildJoinTestAdapter4 = null;
            }
            qVar.R1(guildJoinTestAdapter4.getItems().size());
            handler = guildJoinTestFragment.handler;
            if (handler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("handler");
                handler = null;
            }
            handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.ac
                @Override // java.lang.Runnable
                public final void run() {
                    GuildJoinTestFragment$initView$1.b(GuildJoinTestFragment.this);
                }
            }, 200L);
            qVar2 = guildJoinTestFragment.mViewModel;
            if (qVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                qVar2 = null;
            }
            guildJoinTestAdapter5 = guildJoinTestFragment.adapter;
            if (guildJoinTestAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                guildJoinTestAdapter6 = guildJoinTestAdapter5;
            }
            qVar2.X1(guildJoinTestAdapter6.getItems());
            return;
        }
        QQToast.makeText(guildJoinTestFragment.getContext(), guildJoinTestFragment.requireContext().getString(R.string.f147090vy), 0).show();
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        LinearLayout linearLayout = guildJoinTestFragment.llPlus;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llPlus");
            linearLayout = null;
        }
        iGuildDTReportApi.reportDtEventManual(linearLayout, "em_sgrp_toast", "imp", null);
    }
}
