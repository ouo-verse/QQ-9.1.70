package com.tencent.sqshow.zootopia.nativeui.view.action;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.ue.u;
import java.util.HashMap;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import n74.ah;
import uv4.az;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Luv4/az;", "activeItem", "", "invoke", "(Luv4/az;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MainPanelTopOptView$initDetailOberver$1 extends Lambda implements Function1<az, Unit> {
    final /* synthetic */ ah $binding;
    final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j $panelChannel;
    final /* synthetic */ MainPanelTopOptView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainPanelTopOptView$initDetailOberver$1(MainPanelTopOptView mainPanelTopOptView, ah ahVar, com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
        super(1);
        this.this$0 = mainPanelTopOptView;
        this.$binding = ahVar;
        this.$panelChannel = jVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(az azVar) {
        invoke2(azVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final az azVar) {
        boolean z16;
        z16 = this.this$0.z();
        if (z16) {
            if (azVar == null) {
                this.$binding.f418616e.setVisibility(8);
                return;
            }
            final HashMap hashMap = new HashMap();
            hashMap.put("zplan_item_id", r94.b.K(azVar));
            ZplanViewReportHelper mReporter = this.$panelChannel.getReporter().getMReporter();
            ImageView imageView = this.$binding.f418616e;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.itemDetailIgv");
            mReporter.g(imageView, "em_zplan_item_detail", (r16 & 4) != 0 ? null : hashMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            this.$binding.f418616e.setVisibility(0);
            ImageView imageView2 = this.$binding.f418616e;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.itemDetailIgv");
            final com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.$panelChannel;
            final ah ahVar = this.$binding;
            final MainPanelTopOptView mainPanelTopOptView = this.this$0;
            com.tencent.sqshow.zootopia.utils.aa.d(imageView2, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainPanelTopOptView$initDetailOberver$1.b(com.tencent.sqshow.zootopia.nativeui.data.j.this, ahVar, hashMap, mainPanelTopOptView, azVar, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.tencent.sqshow.zootopia.nativeui.data.j panelChannel, ah binding, HashMap params, MainPanelTopOptView this$0, az azVar, View view) {
        ga4.g a16;
        Intrinsics.checkNotNullParameter(panelChannel, "$panelChannel");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZplanViewReportHelper mReporter = panelChannel.getReporter().getMReporter();
        ImageView imageView = binding.f418616e;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.itemDetailIgv");
        mReporter.e(imageView, "em_zplan_item_detail", params);
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = this$0.getMChannel();
        if (mChannel != null && u.a.a(mChannel.getUeStatusController(), false, 1, null)) {
            ga4.j jVar = ga4.j.f401682a;
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            a16 = jVar.a(3, panelChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(azVar, null, null, null, null, 0, 62, null), (r22 & 16) != 0 ? false : false);
            a16.show();
        }
    }
}
