package com.tencent.ecommerce.base.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/base/ui/d;", "Landroid/app/Dialog;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "show", "dismiss", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "loadingCenterView", "", "D", "Ljava/lang/String;", "tipText", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class d extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private ECStateCenterView loadingCenterView;

    /* renamed from: D, reason: from kotlin metadata */
    private final String tipText;

    public /* synthetic */ d(Context context, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? context.getString(R.string.f169600wj0) : str);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (isShowing()) {
            ECStateCenterView eCStateCenterView = this.loadingCenterView;
            if (eCStateCenterView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingCenterView");
            }
            eCStateCenterView.setSucceededState();
            super.dismiss();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ECStateCenterView eCStateCenterView = new ECStateCenterView(getContext(), null, 0, 6, null);
        this.loadingCenterView = eCStateCenterView;
        setContentView(eCStateCenterView, new ViewGroup.LayoutParams(-1, -1));
        setCanceledOnTouchOutside(false);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        ECStateCenterView eCStateCenterView = this.loadingCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingCenterView");
        }
        eCStateCenterView.setLoadingState(this.tipText);
    }

    public d(Context context, String str) {
        super(context, R.style.f243139);
        this.tipText = str;
    }
}
