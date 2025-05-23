package com.tencent.mobileqq.setting.main.processor;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.settings.message.NotifyPushSettingFragment;
import com.tencent.mobileqq.widget.listitem.x;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c$d;", "invoke", "()Lcom/tencent/mobileqq/widget/listitem/x;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MsgNotifyItemProcessor$singleLineConfig$2 extends Lambda implements Function0<x<x.b.C8996b, x.c.d>> {
    final /* synthetic */ MsgNotifyItemProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgNotifyItemProcessor$singleLineConfig$2(MsgNotifyItemProcessor msgNotifyItemProcessor) {
        super(0);
        this.this$0 = msgNotifyItemProcessor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MsgNotifyItemProcessor this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity e16 = this$0.e();
        if (e16 != null) {
            PublicFragmentActivity.start(e16, new Intent(), NotifyPushSettingFragment.class);
        }
        com.tencent.mobileqq.setting.utils.o oVar = com.tencent.mobileqq.setting.utils.o.f286768a;
        com.tencent.mobileqq.setting.utils.o.k(oVar, "0X800B830", 0, null, null, null, null, 62, null);
        oVar.c("CliOper", "Setting_tab", "Clk_notifications", (r20 & 8) != 0 ? 0 : 0, (r20 & 16) != 0 ? "" : null, (r20 & 32) != 0 ? "" : null, (r20 & 64) != 0 ? "" : null, (r20 & 128) != 0 ? "" : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MsgNotifyItemProcessor this$0, View it) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        z16 = this$0.firstExposure;
        if (z16) {
            this$0.firstExposure = false;
            com.tencent.mobileqq.setting.utils.o.m(com.tencent.mobileqq.setting.utils.o.f286768a, it, "em_bas_message_notification", null, false, 8, null);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final x<x.b.C8996b, x.c.d> invoke() {
        boolean D;
        String leftText;
        D = this.this$0.D();
        leftText = this.this$0.B();
        Intrinsics.checkNotNullExpressionValue(leftText, "leftText");
        x<x.b.C8996b, x.c.d> xVar = new x<>(new x.b.C8996b(leftText, R.drawable.qui_remind), new x.c.d("", "", true, D));
        final MsgNotifyItemProcessor msgNotifyItemProcessor = this.this$0;
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.setting.main.processor.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MsgNotifyItemProcessor$singleLineConfig$2.c(MsgNotifyItemProcessor.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.main.processor.l
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                MsgNotifyItemProcessor$singleLineConfig$2.d(MsgNotifyItemProcessor.this, view);
            }
        });
        return xVar;
    }
}
