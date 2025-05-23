package com.tencent.widget.verifycode;

import android.content.ClipboardManager;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VerifyCodeItemView extends AppCompatEditText {
    static IPatchRedirector $redirector_;
    private OnTextContextMenuItemListener mOnTextContextMenuItemListener;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnTextContextMenuItemListener {
        boolean onTextContextMenuItem(int i3, String str);
    }

    public VerifyCodeItemView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) keyEvent)).booleanValue();
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 23 && keyCode != 66) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        if (i3 == 16908322) {
            this.mOnTextContextMenuItemListener.onTextContextMenuItem(i3, ClipboardMonitor.getText((ClipboardManager) getContext().getSystemService("clipboard")).toString());
            return false;
        }
        return false;
    }

    public void setTextContentListener(OnTextContextMenuItemListener onTextContextMenuItemListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onTextContextMenuItemListener);
        } else {
            this.mOnTextContextMenuItemListener = onTextContextMenuItemListener;
        }
    }

    public VerifyCodeItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public VerifyCodeItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
