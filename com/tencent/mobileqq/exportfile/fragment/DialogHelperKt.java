package com.tencent.mobileqq.exportfile.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.exportfile.global.ExportFileExitEvent;
import com.tencent.mobileqq.exportfile.global.QFileBridgeService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeClientState;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\u0018\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\u001a\u0010\r\u001a\u00020\f*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t\u001a\b\u0010\u000f\u001a\u00020\u000eH\u0002\u00a8\u0006\u0010"}, d2 = {"Landroidx/fragment/app/Fragment;", "", "j", "g", "Landroid/content/Context;", "context", "", "records", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "titleId", "contentId", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "i", "", tl.h.F, "wifiphoto_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class DialogHelperKt {
    public static final void g(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        QFileBridgeService qFileBridgeService = QFileBridgeService.f205517a;
        if (qFileBridgeService.B()) {
            return;
        }
        qFileBridgeService.O(true);
        CoroutineScope f16 = com.tencent.mobileqq.exportfile.fragment.filelist.b.f(0, 1, null);
        BuildersKt__Builders_commonKt.launch$default(f16, null, null, new DialogHelperKt$checkUnCompletedTask$1(f16, fragment, null), 3, null);
    }

    private static final boolean h() {
        if (QFileBridgeService.f205517a.y() == FileBridgeClientState.KFILETRANSFERING) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final QQCustomDialog i(@NotNull Fragment fragment, int i3, int i16) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        QQCustomDialog qQCustomDialog = new QQCustomDialog(fragment.requireActivity());
        Window window = qQCustomDialog.getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        Window window2 = qQCustomDialog.getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
        qQCustomDialog.setContentView(R.layout.custom_dialog);
        qQCustomDialog.setTitle(i3);
        qQCustomDialog.setMessage(i16);
        return qQCustomDialog;
    }

    public static final void j(@NotNull Fragment fragment) {
        int i3;
        String str;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        if (context == null) {
            return;
        }
        if (h()) {
            i3 = R.string.zww;
        } else {
            i3 = R.string.zwu;
        }
        if (h()) {
            str = context.getString(R.string.zwv);
        } else {
            str = null;
        }
        DialogUtil.createCustomDialog(context, str, context.getString(i3), context.getString(R.string.cancel), context.getString(R.string.zw7), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                DialogHelperKt.k(dialogInterface, i16);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                DialogHelperKt.l(dialogInterface, i16);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        com.tencent.qqnt.kernel.api.p A = QFileBridgeService.f205517a.A();
        if (A != null) {
            A.disconnect(10003);
        }
        SimpleEventBus.getInstance().dispatchEvent(new ExportFileExitEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Context context, final byte[] bArr) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, null, context.getString(R.string.zwt), context.getString(R.string.cancel), context.getString(R.string.zws), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogHelperKt.n(bArr, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogHelperKt.o(bArr, dialogInterface, i3);
            }
        });
        createCustomDialog.setCanceledOnTouchOutside(false);
        createCustomDialog.setCancelable(false);
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(byte[] records, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(records, "$records");
        dialogInterface.dismiss();
        com.tencent.qqnt.kernel.api.p A = QFileBridgeService.f205517a.A();
        if (A != null) {
            A.resumeUncompleteDownloadRecords(records);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(byte[] records, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(records, "$records");
        dialogInterface.dismiss();
        com.tencent.qqnt.kernel.api.p A = QFileBridgeService.f205517a.A();
        if (A != null) {
            A.clearUncompleteDownloadRecords(records, new IOperateCallback() { // from class: com.tencent.mobileqq.exportfile.fragment.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    DialogHelperKt.p(i16, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(int i3, String str) {
        QLog.d("DialogHelper", 1, "showUncompletedTaskDialog clearUncompleteDownloadRecords result: " + i3 + ", msg: " + str);
    }
}
