package mt1;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import androidx.fragment.app.DialogFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lmt1/a;", "Lcom/google/android/material/bottomsheet/a;", "Landroidx/fragment/app/DialogFragment;", "hostFragment", "", "N", "dismiss", "Landroid/os/Message;", "msg", "setCancelMessage", "setDismissMessage", "Landroid/content/DialogInterface$OnCancelListener;", "listener", "setOnCancelListener", "Landroid/content/DialogInterface$OnDismissListener;", "setOnDismissListener", "Landroid/content/DialogInterface$OnShowListener;", "setOnShowListener", "Ljava/lang/ref/WeakReference;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/ref/WeakReference;", "hostFragmentReference", "Landroid/content/Context;", "context", "", "themeResId", "<init>", "(Landroid/content/Context;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends com.google.android.material.bottomsheet.a {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private WeakReference<DialogFragment> hostFragmentReference;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void N(@NotNull DialogFragment hostFragment) {
        Intrinsics.checkNotNullParameter(hostFragment, "hostFragment");
        this.hostFragmentReference = new WeakReference<>(hostFragment);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        DialogFragment dialogFragment;
        super.dismiss();
        WeakReference<DialogFragment> weakReference = this.hostFragmentReference;
        if (weakReference != null && (dialogFragment = weakReference.get()) != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
    }

    @Override // android.app.Dialog
    public void setCancelMessage(@Nullable Message msg2) {
    }

    @Override // android.app.Dialog
    public void setDismissMessage(@Nullable Message msg2) {
    }

    @Override // android.app.Dialog
    public void setOnCancelListener(@Nullable DialogInterface.OnCancelListener listener) {
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener listener) {
    }

    @Override // android.app.Dialog
    public void setOnShowListener(@Nullable DialogInterface.OnShowListener listener) {
    }
}
