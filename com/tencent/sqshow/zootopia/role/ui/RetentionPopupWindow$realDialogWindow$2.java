package com.tencent.sqshow.zootopia.role.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.sqshow.utils.featureswitch.model.CreateRoleRetentionConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class RetentionPopupWindow$realDialogWindow$2 extends Lambda implements Function0<QQCustomDialog> {
    final /* synthetic */ RetentionPopupWindow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetentionPopupWindow$realDialogWindow$2(RetentionPopupWindow retentionPopupWindow) {
        super(0);
        this.this$0 = retentionPopupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RetentionPopupWindow this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final QQCustomDialog invoke() {
        Context context;
        CreateRoleRetentionConfig createRoleRetentionConfig;
        CreateRoleRetentionConfig createRoleRetentionConfig2;
        CreateRoleRetentionConfig createRoleRetentionConfig3;
        CreateRoleRetentionConfig createRoleRetentionConfig4;
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        context = this.this$0.context;
        createRoleRetentionConfig = this.this$0.retentionConfig;
        String title = createRoleRetentionConfig.getTitle();
        createRoleRetentionConfig2 = this.this$0.retentionConfig;
        String text = createRoleRetentionConfig2.getText();
        createRoleRetentionConfig3 = this.this$0.retentionConfig;
        String btnCloseWindowText = createRoleRetentionConfig3.getBtnCloseWindowText();
        createRoleRetentionConfig4 = this.this$0.retentionConfig;
        String btnRandomCreateText = createRoleRetentionConfig4.getBtnRandomCreateText();
        onClickListener = this.this$0.randomCreateInvokerWrapper;
        onClickListener2 = this.this$0.closeWindowInvokerWrapper;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, title, text, btnCloseWindowText, btnRandomCreateText, onClickListener, onClickListener2);
        final RetentionPopupWindow retentionPopupWindow = this.this$0;
        createCustomDialog.setCanceledOnTouchOutside(false);
        createCustomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.sqshow.zootopia.role.ui.d
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                RetentionPopupWindow$realDialogWindow$2.b(RetentionPopupWindow.this, dialogInterface);
            }
        });
        createCustomDialog.getTitleTextView().setTypeface(Typeface.DEFAULT_BOLD);
        createCustomDialog.getBtnLeft().setTypeface(Typeface.DEFAULT_BOLD);
        createCustomDialog.getBtnight().setTypeface(Typeface.DEFAULT_BOLD);
        return createCustomDialog;
    }
}
