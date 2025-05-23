package com.tencent.mobileqq.ark;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.template.IPositionMsgApi;
import com.tencent.mobileqq.ark.api.IArkQQApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import com.tencent.util.QQCustomArkDialogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0019B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/ark/r;", "Lcom/tencent/mobileqq/utils/QQCustomDialogWtihEmoticonInput;", "Lcom/tencent/mobileqq/ark/api/IArkQQApi$a;", "Landroid/os/Bundle;", "bundle", "", "w0", "Landroid/widget/LinearLayout$LayoutParams;", "layoutParams", "x0", "Landroid/content/Context;", "context", "u", "Landroid/content/DialogInterface;", "dialogInterface", "onDismiss", "Landroid/view/View;", "d0", "Landroid/view/View;", "contentView", "", "theme", "<init>", "(Landroid/content/Context;I)V", "e0", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class r extends QQCustomDialogWtihEmoticonInput implements IArkQQApi.a {

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final View contentView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.contentView = ((IPositionMsgApi) QRoute.api(IPositionMsgApi.class)).createPositionMsgView(context);
    }

    private final void w0(Bundle bundle) {
        IPositionMsgApi iPositionMsgApi = (IPositionMsgApi) QRoute.api(IPositionMsgApi.class);
        Context context = getContext();
        View view = this.contentView;
        String string = bundle.getString(QQCustomArkDialogUtil.META_DATA);
        if (string == null) {
            return;
        }
        iPositionMsgApi.bindPositionMsgView(context, view, string);
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    private final void x0(LinearLayout.LayoutParams layoutParams) {
        layoutParams.setMargins(1, 1, 1, 1);
        LinearLayout linearLayout = this.bodyLayout;
        if (linearLayout != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setStroke(1, 436207616);
            linearLayout.setBackground(gradientDrawable);
        }
    }

    @Override // com.tencent.mobileqq.ark.api.IArkQQApi.a
    public void u(Context context, Bundle bundle) {
        if (context == null || bundle == null) {
            return;
        }
        p0(7);
        setContentView(R.layout.f167864jw);
        w0(bundle);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        x0(layoutParams);
        addCenterView(this.contentView, layoutParams);
    }
}
