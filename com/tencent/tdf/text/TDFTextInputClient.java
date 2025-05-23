package com.tencent.tdf.text;

import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.text.TDFTextInputView;
import com.tencent.tdf.utils.PlatformThread;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFTextInputClient implements TDFTextInputView.TDFInputMethodDelegate {
    static IPatchRedirector $redirector_;
    private TDFTextInputView.Configuration configuration;
    private ViewGroup containerView;
    private TDFTextInputView inputView;
    private long objectId;

    public TDFTextInputClient(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
        } else {
            this.objectId = j3;
        }
    }

    private native void deleteText(long j3, int i3, int i16);

    private native void insertText(long j3, String str);

    private native void performBackwardDelete(long j3, int i3);

    private native void performEnter(long j3, int i3);

    private native void performForwardDelete(long j3, int i3);

    private native void setComposingText(long j3, String str, int i3);

    public void activate(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup);
        } else {
            this.containerView = viewGroup;
            PlatformThread.post(new Runnable(viewGroup, this) { // from class: com.tencent.tdf.text.TDFTextInputClient.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ViewGroup val$containerView;
                final /* synthetic */ TDFTextInputView.TDFInputMethodDelegate val$delegate;

                {
                    this.val$containerView = viewGroup;
                    this.val$delegate = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TDFTextInputClient.this, viewGroup, this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.val$containerView == null) {
                        return;
                    }
                    if (TDFTextInputClient.this.inputView == null) {
                        TDFTextInputClient.this.inputView = new TDFTextInputView(this.val$containerView.getContext(), TDFTextInputClient.this.configuration, this.val$delegate);
                        this.val$containerView.addView(TDFTextInputClient.this.inputView);
                    }
                    TDFTextInputClient.this.inputView.requestFocus();
                    ((InputMethodManager) TDFTextInputClient.this.inputView.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(TDFTextInputClient.this.inputView, 0);
                }
            });
        }
    }

    public void deactivate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            PlatformThread.post(new Runnable(z16) { // from class: com.tencent.tdf.text.TDFTextInputClient.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$needsHideKeyboard;

                {
                    this.val$needsHideKeyboard = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TDFTextInputClient.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (TDFTextInputClient.this.inputView == null) {
                        return;
                    }
                    if (this.val$needsHideKeyboard) {
                        ((InputMethodManager) TDFTextInputClient.this.inputView.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(TDFTextInputClient.this.inputView.getApplicationWindowToken(), 0);
                    }
                    TDFTextInputClient.this.inputView.clearFocus();
                    TDFTextInputClient.this.containerView.removeView(TDFTextInputClient.this.inputView);
                    TDFTextInputClient.this.inputView = null;
                }
            });
        }
    }

    @Override // com.tencent.tdf.text.TDFTextInputView.TDFInputMethodDelegate
    public void deleteText(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            deleteText(this.objectId, i3, i16);
        }
    }

    @Override // com.tencent.tdf.text.TDFTextInputView.TDFInputMethodDelegate
    public void insertText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            insertText(this.objectId, str);
        }
    }

    @Override // com.tencent.tdf.text.TDFTextInputView.TDFInputMethodDelegate
    public void performBackwardDelete(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            performBackwardDelete(this.objectId, i3);
        }
    }

    @Override // com.tencent.tdf.text.TDFTextInputView.TDFInputMethodDelegate
    public void performEnter(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            performEnter(this.objectId, i3);
        }
    }

    @Override // com.tencent.tdf.text.TDFTextInputView.TDFInputMethodDelegate
    public void performForwardDelete(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            performForwardDelete(this.objectId, i3);
        }
    }

    @Override // com.tencent.tdf.text.TDFTextInputView.TDFInputMethodDelegate
    public void setComposingText(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
        } else {
            setComposingText(this.objectId, str, i3);
        }
    }

    public void setConfiguration(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        TDFTextInputView.Configuration configuration = new TDFTextInputView.Configuration();
        this.configuration = configuration;
        configuration.inputType = i3;
        configuration.enterKey = new TDFKeyboardEnterKey(i16);
        this.configuration.enterKeyLabel = str;
        PlatformThread.post(new Runnable() { // from class: com.tencent.tdf.text.TDFTextInputClient.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TDFTextInputClient.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (TDFTextInputClient.this.inputView != null) {
                    TDFTextInputClient.this.inputView.setConfiguration(TDFTextInputClient.this.configuration);
                }
            }
        });
    }

    public void updateCaretRect(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        } else {
            PlatformThread.post(new Runnable(f16, f17, f18, f19) { // from class: com.tencent.tdf.text.TDFTextInputClient.6
                static IPatchRedirector $redirector_;
                final /* synthetic */ float val$height;
                final /* synthetic */ float val$width;
                final /* synthetic */ float val$x;
                final /* synthetic */ float val$y;

                {
                    this.val$x = f16;
                    this.val$y = f17;
                    this.val$width = f18;
                    this.val$height = f19;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TDFTextInputClient.this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (TDFTextInputClient.this.inputView != null) {
                        TDFTextInputClient.this.inputView.updateCaretRect(this.val$x, this.val$y, this.val$width, this.val$height);
                    }
                }
            });
        }
    }

    public void updateSelection(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            PlatformThread.post(new Runnable(i3, i16) { // from class: com.tencent.tdf.text.TDFTextInputClient.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$selectionEnd;
                final /* synthetic */ int val$selectionStart;

                {
                    this.val$selectionStart = i3;
                    this.val$selectionEnd = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TDFTextInputClient.this, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (TDFTextInputClient.this.inputView != null) {
                        TDFTextInputClient.this.inputView.updateSelection(this.val$selectionStart, this.val$selectionEnd);
                    }
                }
            });
        }
    }

    public void updateText(String str, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            PlatformThread.post(new Runnable(str, i3, i16, i17, i18) { // from class: com.tencent.tdf.text.TDFTextInputClient.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$composingRangeEnd;
                final /* synthetic */ int val$composingRangeStart;
                final /* synthetic */ int val$selectionEnd;
                final /* synthetic */ int val$selectionStart;
                final /* synthetic */ String val$text;

                {
                    this.val$text = str;
                    this.val$composingRangeStart = i3;
                    this.val$composingRangeEnd = i16;
                    this.val$selectionStart = i17;
                    this.val$selectionEnd = i18;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TDFTextInputClient.this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (TDFTextInputClient.this.inputView != null) {
                        TDFTextInputClient.this.inputView.updateText(this.val$text, this.val$composingRangeStart, this.val$composingRangeEnd, this.val$selectionStart, this.val$selectionEnd);
                    }
                }
            });
        }
    }
}
