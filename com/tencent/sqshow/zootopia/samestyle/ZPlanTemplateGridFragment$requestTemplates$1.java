package com.tencent.sqshow.zootopia.samestyle;

import androidx.fragment.app.FragmentActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/f;", "resp", "", "invoke", "(Lcom/tencent/sqshow/zootopia/samestyle/f;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanTemplateGridFragment$requestTemplates$1 extends Lambda implements Function1<TemplateRsp, Unit> {
    final /* synthetic */ Function5<Boolean, Integer, Integer, Long, List<ZPlanTemplate>, Unit> $callback;
    final /* synthetic */ ZPlanTemplateGridFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ZPlanTemplateGridFragment$requestTemplates$1(ZPlanTemplateGridFragment zPlanTemplateGridFragment, Function5<? super Boolean, ? super Integer, ? super Integer, ? super Long, ? super List<ZPlanTemplate>, Unit> function5) {
        super(1);
        this.this$0 = zPlanTemplateGridFragment;
        this.$callback = function5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FragmentActivity this_apply, Function5 callback, TemplateRsp resp, ZPlanTemplateGridFragment this$0) {
        List Qh;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(resp, "$resp");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this_apply.isFinishing()) {
            return;
        }
        Boolean valueOf = Boolean.valueOf(resp.getErrCode() == 0);
        Integer valueOf2 = Integer.valueOf(resp.getPageIndex());
        Integer valueOf3 = Integer.valueOf(resp.getTotalPage());
        Long valueOf4 = Long.valueOf(resp.getTabId());
        Qh = this$0.Qh(resp.d());
        callback.invoke(valueOf, valueOf2, valueOf3, valueOf4, Qh);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TemplateRsp templateRsp) {
        invoke2(templateRsp);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final TemplateRsp resp) {
        Intrinsics.checkNotNullParameter(resp, "resp");
        final FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            final Function5<Boolean, Integer, Integer, Long, List<ZPlanTemplate>, Unit> function5 = this.$callback;
            final ZPlanTemplateGridFragment zPlanTemplateGridFragment = this.this$0;
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.p
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanTemplateGridFragment$requestTemplates$1.b(FragmentActivity.this, function5, resp, zPlanTemplateGridFragment);
                }
            });
        }
    }
}
