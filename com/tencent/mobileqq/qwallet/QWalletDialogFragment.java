package com.tencent.mobileqq.qwallet;

import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qwallet/QWalletDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroidx/fragment/app/FragmentManager;", "manager", "", "tag", "", "show", "dismiss", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public class QWalletDialogFragment extends ReportAndroidXDialogFragment {
    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        try {
            super.dismiss();
        } catch (IllegalStateException e16) {
            QLog.e("QWalletBottomSheetDialogFragment", 1, "dismiss error", e16);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(@NotNull FragmentManager manager, @Nullable String tag) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        try {
            super.show(manager, tag);
        } catch (IllegalStateException e16) {
            QLog.e("QWalletBottomSheetDialogFragment", 1, "show error", e16);
        }
    }
}
