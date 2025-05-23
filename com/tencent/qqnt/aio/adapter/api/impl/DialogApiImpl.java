package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqnt.aio.adapter.api.IDialogApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J8\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/DialogApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IDialogApi;", "Landroid/content/Context;", "context", "", "title", "content", "Lcom/tencent/qqnt/aio/adapter/api/IDialogApi$a;", "listener", "", "showAlert", "leftButtonText", "rightButtonText", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DialogApiImpl implements IDialogApi {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAlert$lambda$0(IDialogApi.a listener, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onConfirm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAlert$lambda$2(IDialogApi.a listener, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onConfirm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAlert$lambda$3(IDialogApi.a listener, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onCancel();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IDialogApi
    public void showAlert(Context context, String title, String content, final IDialogApi.a listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(listener, "listener");
        DialogUtil.createCustomDialog(context, 230, title, content, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.adapter.api.impl.ag
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogApiImpl.showAlert$lambda$0(IDialogApi.a.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.adapter.api.impl.ah
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogApiImpl.showAlert$lambda$1(dialogInterface, i3);
            }
        }).show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IDialogApi
    public void showAlert(Context context, String title, String content, String leftButtonText, String rightButtonText, final IDialogApi.a listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(leftButtonText, "leftButtonText");
        Intrinsics.checkNotNullParameter(rightButtonText, "rightButtonText");
        Intrinsics.checkNotNullParameter(listener, "listener");
        DialogUtil.createCustomDialog(context, 230, title, content, leftButtonText, rightButtonText, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.adapter.api.impl.ai
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogApiImpl.showAlert$lambda$2(IDialogApi.a.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.adapter.api.impl.aj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogApiImpl.showAlert$lambda$3(IDialogApi.a.this, dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAlert$lambda$1(DialogInterface dialogInterface, int i3) {
    }
}
