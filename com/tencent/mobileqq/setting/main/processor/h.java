package com.tencent.mobileqq.setting.main.processor;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.setting.utils.ExitCurrentAccountUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.listitem.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/setting/main/processor/h;", "Lcom/tencent/mobileqq/setting/processor/c;", "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "g", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", tl.h.F, "Z", "mIsFirstExitShow", "<init>", "(Landroid/content/Context;)V", "i", "a", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class h extends com.tencent.mobileqq.setting.processor.c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFirstExitShow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context) {
        super(context, 22);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mIsFirstExitShow = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(h this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mIsFirstExitShow) {
            ReportController.y(this$0.f(), "0X800B7D8");
            ReportController.y(this$0.f(), "0X800B7D9");
        }
        this$0.mIsFirstExitShow = false;
        ReportController.y(this$0.f(), "0X800B83B");
        ReportController.y(this$0.f(), "0X800C620");
        com.tencent.mobileqq.setting.utils.o oVar = com.tencent.mobileqq.setting.utils.o.f286768a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.setting.utils.o.g(oVar, it, "em_bas_log_out_of_current_account", null, 4, null);
        ExitCurrentAccountUtil.f286732a.n(this$0.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.setting.utils.o.f286768a.l(it, "em_bas_log_out_of_current_account", null, false);
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        String string = this.context.getString(R.string.c6n);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.logout_exit_account)");
        x xVar = new x(new x.b.C8996b(string, R.drawable.qui_sign_out), new x.c.g("", true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.setting.main.processor.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.x(h.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.main.processor.g
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                h.y(view);
            }
        });
        return xVar;
    }
}
