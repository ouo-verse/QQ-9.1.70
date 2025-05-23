package com.tencent.timi.game.liveroom.impl.room.view;

import android.content.Context;
import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lrr4/e;", "kotlin.jvm.PlatformType", "groupInfo", "", "invoke", "(Lrr4/e;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes26.dex */
final class AnchorTopAreaView$setLiveExtraInfo$1$1 extends Lambda implements Function1<rr4.e, Unit> {
    final /* synthetic */ AnchorTopAreaView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorTopAreaView$setLiveExtraInfo$1$1(AnchorTopAreaView anchorTopAreaView) {
        super(1);
        this.this$0 = anchorTopAreaView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AnchorTopAreaView this$0, rr4.e eVar, View it) {
        long j3;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.timi.game.liveroom.impl.room.fansqqgroup.a aVar = com.tencent.timi.game.liveroom.impl.room.fansqqgroup.a.f377629a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str = eVar.f432117b;
        Intrinsics.checkNotNullExpressionValue(str, "groupInfo.url");
        j3 = this$0.mRoomId;
        aVar.a(context, str, j3);
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        a.C11346a.a((ug4.a) b16, it, false, null, "em_qqlive_fansgroup_room", null, 22, null);
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(rr4.e eVar) {
        invoke2(eVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final rr4.e eVar) {
        View L;
        View L2;
        View L3;
        if (!eVar.f432116a) {
            L3 = this.this$0.L();
            L3.setVisibility(8);
            return;
        }
        L = this.this$0.L();
        L.setVisibility(0);
        L2 = this.this$0.L();
        final AnchorTopAreaView anchorTopAreaView = this.this$0;
        L2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorTopAreaView$setLiveExtraInfo$1$1.b(AnchorTopAreaView.this, eVar, view);
            }
        });
    }
}
