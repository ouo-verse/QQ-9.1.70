package com.tencent.qqnt.chathistory.ui.base;

import android.R;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import kotlin.Metadata;
import mqq.app.Constants;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/base/BaseChatDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/view/Window;", "window", "", "qh", "", "ph", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onActivityCreated", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class BaseChatDialogFragment extends ReportAndroidXDialogFragment {
    static IPatchRedirector $redirector_;

    public BaseChatDialogFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int ph() {
        return 9216;
    }

    private final void qh(Window window) {
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | ph());
        window.setStatusBarColor(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Window window;
        Window window2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onActivityCreated(savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            com.tencent.qqnt.chathistory.util.d dVar = com.tencent.qqnt.chathistory.util.d.f354054a;
            Dialog dialog2 = getDialog();
            if (dialog2 != null) {
                window2 = dialog2.getWindow();
            } else {
                window2 = null;
            }
            dVar.a("BaseChatHistoryDialog", " initWindow " + window2);
            window.setBackgroundDrawable(new ColorDrawable());
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.width = -1;
            }
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            if (attributes2 != null) {
                attributes2.height = -1;
            }
            WindowManager.LayoutParams attributes3 = window.getAttributes();
            if (attributes3 != null) {
                attributes3.gravity = 51;
            }
            window.getAttributes().windowAnimations = R.style.Animation;
            if (Build.VERSION.SDK_INT >= 28) {
                window.getAttributes().layoutInDisplayCutoutMode = 1;
            }
            window.addFlags(Integer.MIN_VALUE);
            window.getDecorView().setFitsSystemWindows(true);
            qh(window);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
        } else {
            super.onCreate(savedInstanceState);
            setStyle(1, com.tencent.mobileqq.R.style.f246779t);
        }
    }
}
