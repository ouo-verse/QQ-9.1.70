package com.tencent.mobileqq.sharepanel.channel;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class ShareChannelHandlerFragment$uiHandler$2 extends Lambda implements Function0<Handler> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ShareChannelHandlerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareChannelHandlerFragment$uiHandler$2(ShareChannelHandlerFragment shareChannelHandlerFragment) {
        super(0);
        this.this$0 = shareChannelHandlerFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) shareChannelHandlerFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean b(ShareChannelHandlerFragment this$0, Message msg2) {
        WeakReference weakReference;
        Dialog dialog;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 != 1) {
            if (i3 == 2) {
                try {
                    weakReference = this$0.loadingDialogRef;
                    if (weakReference != null && (dialog = (Dialog) weakReference.get()) != null) {
                        dialog.dismiss();
                    }
                } catch (Exception e16) {
                    QLog.e("ShareChannelHandlerFragment", 1, "dismiss loading dialog error: ", e16);
                }
                this$0.loadingDialogRef = null;
            }
        } else {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                try {
                    Dialog showLoadingDialog = DialogUtil.showLoadingDialog(activity, "\u52a0\u8f7d\u4e2d", true);
                    if (showLoadingDialog != null) {
                        showLoadingDialog.show();
                    }
                    this$0.loadingDialogRef = new WeakReference(showLoadingDialog);
                } catch (Exception e17) {
                    QLog.e("ShareChannelHandlerFragment", 1, "show loading dialog error: ", e17);
                }
            }
        }
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Handler invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Handler) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Looper mainLooper = Looper.getMainLooper();
        final ShareChannelHandlerFragment shareChannelHandlerFragment = this.this$0;
        return new Handler(mainLooper, new Handler.Callback() { // from class: com.tencent.mobileqq.sharepanel.channel.f
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean b16;
                b16 = ShareChannelHandlerFragment$uiHandler$2.b(ShareChannelHandlerFragment.this, message);
                return b16;
            }
        });
    }
}
