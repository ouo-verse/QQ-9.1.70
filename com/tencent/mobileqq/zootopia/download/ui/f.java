package com.tencent.mobileqq.zootopia.download.ui;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/f;", "", "Landroid/content/DialogInterface$OnDismissListener;", "onDismissListener", "", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f {

    /* renamed from: a */
    public static final f f328286a = new f();

    f() {
    }

    public static final void d(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    public final void b(DialogInterface.OnDismissListener onDismissListener) {
        String string = BaseApplication.context.getResources().getString(R.string.xiu);
        Intrinsics.checkNotNullExpressionValue(string, "res.getString(R.string.z\u2026_download_file_corrupted)");
        Activity topActivity = Foreground.getTopActivity();
        QLog.i("ZootopiaDownloadHintUtil_", 1, "showMd5CheckFailedDialog context " + topActivity);
        if (topActivity == null) {
            QQToast.makeText(BaseApplication.context, 1, string, 0).show();
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(topActivity, 230);
        createCustomDialog.setMessage(string);
        createCustomDialog.setPositiveButton(R.string.xqq, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.ui.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                f.d(dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton((String) null, (DialogInterface.OnClickListener) null);
        createCustomDialog.setCancelable(true);
        createCustomDialog.setOnDismissListener(onDismissListener);
        createCustomDialog.show();
    }

    public static /* synthetic */ void c(f fVar, DialogInterface.OnDismissListener onDismissListener, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            onDismissListener = null;
        }
        fVar.b(onDismissListener);
    }
}
