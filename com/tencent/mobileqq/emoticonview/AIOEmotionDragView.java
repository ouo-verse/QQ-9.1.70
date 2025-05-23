package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.DragView;

/* compiled from: P */
/* loaded from: classes12.dex */
public class AIOEmotionDragView extends DragView {
    static IPatchRedirector $redirector_;

    public AIOEmotionDragView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.DragView
    public void startQuitAnim() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        View curView = getCurView();
        if (curView != null && curView.getWidth() > 0 && curView.getHeight() > 0) {
            try {
                super.startQuitAnim();
            } catch (Throwable th5) {
                QLog.w("DragView", 1, "[startQuitAnim] error. stack=", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.DragView
    public void startReleaseAnim() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        View curView = getCurView();
        if (curView != null && curView.getWidth() > 0 && curView.getHeight() > 0) {
            try {
                super.startReleaseAnim();
            } catch (Throwable th5) {
                QLog.w("DragView", 1, "[startReleaseAnim] error. stack=", th5);
            }
        }
    }

    public AIOEmotionDragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }
}
