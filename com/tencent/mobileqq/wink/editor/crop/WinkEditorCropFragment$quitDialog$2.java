package com.tencent.mobileqq.wink.editor.crop;

import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkEditorCropFragment$quitDialog$2 extends Lambda implements Function0<QQCustomDialog> {
    final /* synthetic */ WinkEditorCropFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorCropFragment$quitDialog$2(WinkEditorCropFragment winkEditorCropFragment) {
        super(0);
        this.this$0 = winkEditorCropFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(WinkEditorCropFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cancel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final QQCustomDialog invoke() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.this$0.getContext(), 230);
        final WinkEditorCropFragment winkEditorCropFragment = this.this$0;
        createCustomDialog.setMessage(winkEditorCropFragment.getString(R.string.f239207lu));
        createCustomDialog.setPositiveButton(winkEditorCropFragment.getString(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.crop.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorCropFragment$quitDialog$2.c(WinkEditorCropFragment.this, dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton(winkEditorCropFragment.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.crop.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorCropFragment$quitDialog$2.d(dialogInterface, i3);
            }
        });
        return createCustomDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DialogInterface dialogInterface, int i3) {
    }
}
