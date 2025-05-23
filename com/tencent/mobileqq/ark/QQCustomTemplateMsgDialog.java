package com.tencent.mobileqq.ark;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.template.ITemplateMsgApi;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.api.IArkQQApi;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0019\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/ark/QQCustomTemplateMsgDialog;", "Lcom/tencent/mobileqq/utils/QQCustomDialogWtihEmoticonInput;", "Lcom/tencent/mobileqq/ark/api/IArkQQApi$a;", "Landroid/os/Bundle;", "bundle", "", "z0", "Landroid/widget/LinearLayout$LayoutParams;", "layoutParams", "y0", "Landroid/content/Context;", "context", "u", "Landroid/content/DialogInterface;", "dialogInterface", "onDismiss", "Lcom/tencent/mobileqq/aio/msg/template/a;", "d0", "Lcom/tencent/mobileqq/aio/msg/template/a;", "contentView", "Lkotlinx/coroutines/Job;", "e0", "Lkotlinx/coroutines/Job;", "loadingJob", "", "theme", "<init>", "(Landroid/content/Context;I)V", "f0", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQCustomTemplateMsgDialog extends QQCustomDialogWtihEmoticonInput implements IArkQQApi.a {

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.aio.msg.template.a contentView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private Job loadingJob;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQCustomTemplateMsgDialog(Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.contentView = ((ITemplateMsgApi) QRoute.api(ITemplateMsgApi.class)).createTemplateMsgView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(Bundle bundle) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        y0(bundle, layoutParams);
        com.tencent.mobileqq.aio.msg.template.a aVar = this.contentView;
        addCenterView(aVar != null ? aVar.d() : null, layoutParams);
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        Job job = this.loadingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    private final void y0(Bundle bundle, LinearLayout.LayoutParams layoutParams) {
        layoutParams.setMargins(1, 1, 1, 1);
        if (this.bodyLayout != null) {
            String string = bundle.getString("appName");
            if (string == null) {
                string = "";
            }
            String string2 = bundle.getString(QQCustomArkDialogUtil.APP_VIEW);
            String str = string2 != null ? string2 : "";
            d91.b arkAIKeyWordConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkAIKeyWordConfig();
            boolean z16 = false;
            if (((arkAIKeyWordConfig != null ? arkAIKeyWordConfig.c().d(string) : false) && !ArkMsgUtils.isMultiMsg(string, str)) && ArkMsgUtils.shouldShowBorderInSetSize(string, str)) {
                z16 = true;
            }
            if (z16) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setStroke(1, 436207616);
                this.bodyLayout.setBackground(gradientDrawable);
            }
        }
    }

    @Override // com.tencent.mobileqq.ark.api.IArkQQApi.a
    public void u(Context context, Bundle bundle) {
        Job launch$default;
        if (context == null || bundle == null) {
            return;
        }
        p0(7);
        setContentView(R.layout.f167864jw);
        launch$default = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new QQCustomTemplateMsgDialog$init$1(bundle, this, context.getResources().getDimensionPixelSize(R.dimen.f158688md) - (context.getResources().getDimensionPixelSize(R.dimen.f158691mg) * 2), null), 2, null);
        this.loadingJob = launch$default;
    }
}
