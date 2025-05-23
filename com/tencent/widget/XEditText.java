package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XEditText extends EditText {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "XEditText";
    private static final String WRAP_TOGGLE_NAME = "and_edittext_connection_wrap";
    private Boolean mWrapToggle;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a extends InputConnectionWrapper {
        static IPatchRedirector $redirector_;

        a(InputConnection inputConnection, boolean z16) {
            super(inputConnection, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, XEditText.this, inputConnection, Boolean.valueOf(z16));
            }
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public CharSequence getTextBeforeCursor(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            try {
                return super.getTextBeforeCursor(i3, i16);
            } catch (Exception unused) {
                return "";
            }
        }
    }

    public XEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
    }

    private boolean getWrapToggle() {
        if (this.mWrapToggle == null) {
            this.mWrapToggle = Boolean.valueOf(((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn(WRAP_TOGGLE_NAME));
        }
        return this.mWrapToggle.booleanValue();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (InputConnection) iPatchRedirector.redirect((short) 3, (Object) this, (Object) editorInfo);
        }
        if (getParent() == null) {
            QLog.e(TAG, 1, "createInputConnection to an orphan editText");
        }
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        QLog.i(TAG, 1, "[onCreateInputConnection]: connection is " + onCreateInputConnection);
        if (onCreateInputConnection == null) {
            QLog.i(TAG, 1, "[onCreateInputConnection]: return null");
            return onCreateInputConnection;
        }
        if ((getInputType() & 131072) == 131072 && getImeOptions() != 0) {
            editorInfo.imeOptions &= -1073741825;
            editorInfo.inputType &= -131073;
        }
        if (getWrapToggle()) {
            return new a(onCreateInputConnection, true);
        }
        return onCreateInputConnection;
    }

    public XEditText(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
    }
}
