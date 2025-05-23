package com.tencent.mobileqq.stt.sub.api.impl;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.stt.sub.api.IVideoSubtitleDialog;
import com.tencent.mobileqq.stt.sub.ui.f;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class VideoSubtitleDialogImpl implements IVideoSubtitleDialog {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "VideoSubtitleDialog";

    public VideoSubtitleDialogImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showEnableSubtitleDialog$0(IVideoSubtitleDialog.a aVar, boolean z16) {
        if (aVar != null) {
            aVar.onDismiss(z16);
        }
    }

    @Override // com.tencent.mobileqq.stt.sub.api.IVideoSubtitleDialog
    public void showEnableSubtitleDialog(Activity activity, final IVideoSubtitleDialog.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) aVar);
        } else {
            if (activity == null) {
                QLog.i(TAG, 1, "showEnableSubtitleDialog, no activity");
                return;
            }
            com.tencent.mobileqq.stt.sub.ui.f fVar = new com.tencent.mobileqq.stt.sub.ui.f(activity);
            fVar.X(new f.b() { // from class: com.tencent.mobileqq.stt.sub.api.impl.a
                @Override // com.tencent.mobileqq.stt.sub.ui.f.b
                public final void onDismiss(boolean z16) {
                    VideoSubtitleDialogImpl.lambda$showEnableSubtitleDialog$0(IVideoSubtitleDialog.a.this, z16);
                }
            });
            fVar.show();
        }
    }

    @Override // com.tencent.mobileqq.stt.sub.api.IVideoSubtitleDialog
    public void showGuideBalloon(@NonNull View view, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, str, Integer.valueOf(i3));
        } else {
            new com.tencent.mobileqq.stt.sub.ui.b(view.getContext()).f(view, str, i3);
        }
    }
}
