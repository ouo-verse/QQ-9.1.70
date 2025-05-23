package com.tencent.tdf.keyboard;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.tdf.TDFEngine;
import com.tencent.tdf.keyboard.KeyboardConfiguration;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class KeyboardChannel {
    static IPatchRedirector $redirector_;
    private NativeKeyboardTarget currentTarget;
    private View dfView;
    private Editable editable;
    private InputMethodManager inputMethodManager;
    private KeyboardConfiguration keyboardConfiguration;
    private InputConnection lastInputConnection;
    private boolean restartAlwaysRequired;
    private boolean restartInputPending;
    private TDFEngine tdfEngine;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class NativeKeyboardTarget {
        static IPatchRedirector $redirector_;
        public int clientId;
        public long nativeKeyboard;

        public NativeKeyboardTarget(int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3));
            } else {
                this.clientId = i3;
                this.nativeKeyboard = j3;
            }
        }
    }

    public KeyboardChannel(View view, TDFEngine tDFEngine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) tDFEngine);
            return;
        }
        this.dfView = view;
        this.tdfEngine = tDFEngine;
        this.inputMethodManager = (InputMethodManager) view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        this.restartAlwaysRequired = isRestartAlwaysRequired();
        this.dfView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.tdf.keyboard.KeyboardChannel.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KeyboardChannel.this);
                }
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, view2, Boolean.valueOf(z16));
                } else {
                    KeyboardChannel keyboardChannel = KeyboardChannel.this;
                    keyboardChannel.onFocusChanged(keyboardChannel.currentTarget.nativeKeyboard, z16);
                }
            }
        });
    }

    private void applyStateToSelection(KeyboardConfiguration.EditingState editingState) {
        int i3 = editingState.selectionBase;
        int i16 = editingState.selectionExtent;
        if (i3 >= 0 && i3 <= this.editable.length() && i16 >= 0 && i16 <= this.editable.length()) {
            Selection.setSelection(this.editable, i3, i16);
        } else {
            Selection.removeSelection(this.editable);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int inputTypeFromTextInputType(KeyboardConfiguration.InputType inputType, boolean z16, boolean z17, boolean z18, int i3) {
        int i16;
        int i17;
        int i18;
        int i19 = inputType.index;
        if (i19 == 4) {
            return 4;
        }
        int i26 = 2;
        if (i19 == 2) {
            if (inputType.isSigned) {
                i26 = 4098;
            }
            if (inputType.isDecimal) {
                return i26 | 8192;
            }
            return i26;
        }
        if (i19 == 3) {
            return 3;
        }
        if (i19 == 1) {
            i16 = IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_TCP_OPEN;
        } else if (i19 == 5) {
            i16 = 33;
        } else if (i19 == 6) {
            i16 = 17;
        } else if (i19 == 7) {
            if (z16) {
                i17 = 128;
            } else {
                i17 = 144;
            }
            i16 = i17 | 1;
        } else {
            i16 = 1;
        }
        if (!z16) {
            if (z17) {
                i16 |= 32768;
            }
            if (z18) {
                i18 = i16;
                if (i3 != 3) {
                    return i18 | 4096;
                }
                if (i3 == 1) {
                    return i18 | 8192;
                }
                if (i3 == 2) {
                    return i18 | 16384;
                }
                return i18;
            }
        }
        i18 = i16 | 524288;
        if (i3 != 3) {
        }
    }

    private native void insertText(long j3, int i3, String str);

    @SuppressLint({"NewApi"})
    private boolean isRestartAlwaysRequired() {
        if (this.inputMethodManager.getCurrentInputMethodSubtype() != null && Build.MANUFACTURER.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING)) {
            return DeviceInfoMonitor.getString(this.dfView.getContext().getContentResolver(), "default_input_method").contains("Samsung");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void onFocusChanged(long j3, boolean z16);

    private native void onKeyboardAction(long j3, int i3, int i16);

    private native void updateEditingState(long j3, int i3, String str, int i16, int i17, int i18, int i19);

    public void clearClient() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.currentTarget = null;
        }
    }

    public InputConnection createInputConnection(View view, EditorInfo editorInfo) {
        int editAction;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (InputConnection) iPatchRedirector.redirect((short) 12, (Object) this, (Object) view, (Object) editorInfo);
        }
        KeyboardConfiguration keyboardConfiguration = this.keyboardConfiguration;
        if (keyboardConfiguration == null) {
            return null;
        }
        int inputTypeFromTextInputType = inputTypeFromTextInputType(keyboardConfiguration.inputType, keyboardConfiguration.obscureText, keyboardConfiguration.autoCorrect, keyboardConfiguration.enableSuggestions, keyboardConfiguration.textCapitalization);
        editorInfo.inputType = inputTypeFromTextInputType;
        editorInfo.imeOptions = 33554432;
        int i3 = this.keyboardConfiguration.inputAction;
        if (i3 == -1) {
            if ((inputTypeFromTextInputType & 131072) != 0) {
                editAction = 1;
            } else {
                editAction = 6;
            }
        } else {
            editAction = KeyboardConfiguration.getEditAction(i3);
        }
        String str = this.keyboardConfiguration.actionLabel;
        if (str != null) {
            editorInfo.actionLabel = str;
            editorInfo.actionId = editAction;
        }
        editorInfo.imeOptions = editAction | editorInfo.imeOptions;
        TDFInputConnection tDFInputConnection = new TDFInputConnection(this, this.currentTarget, view, this.editable, editorInfo, isRestartAlwaysRequired());
        editorInfo.initialSelStart = Selection.getSelectionStart(this.editable);
        editorInfo.initialSelEnd = Selection.getSelectionEnd(this.editable);
        this.lastInputConnection = tDFInputConnection;
        return tDFInputConnection;
    }

    public InputMethodManager getInputMethodManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (InputMethodManager) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.inputMethodManager;
    }

    public InputConnection getLastInputConnection() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (InputConnection) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.lastInputConnection;
    }

    public void hide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.inputMethodManager.hideSoftInputFromWindow(this.dfView.getApplicationWindowToken(), 0);
            this.dfView.clearFocus();
        }
    }

    public void insertText(NativeKeyboardTarget nativeKeyboardTarget, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) nativeKeyboardTarget, (Object) str);
        } else {
            insertText(nativeKeyboardTarget.nativeKeyboard, nativeKeyboardTarget.clientId, str);
        }
    }

    public boolean isShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.dfView.hasFocus();
    }

    public void onKeyboardAction(NativeKeyboardTarget nativeKeyboardTarget, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) nativeKeyboardTarget, i3);
        } else {
            onKeyboardAction(nativeKeyboardTarget.nativeKeyboard, nativeKeyboardTarget.clientId, i3);
        }
    }

    public void sendKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) keyEvent);
        } else {
            this.tdfEngine.getPlatformEventHandler().handleKeyEvent(this.tdfEngine.getPipelineId(), keyEvent);
        }
    }

    public void setClient(int i3, long j3, KeyboardConfiguration keyboardConfiguration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), keyboardConfiguration);
            return;
        }
        this.currentTarget = new NativeKeyboardTarget(i3, j3);
        this.keyboardConfiguration = keyboardConfiguration;
        this.editable = Editable.Factory.getInstance().newEditable("");
        this.inputMethodManager.restartInput(this.dfView);
        this.restartInputPending = true;
        this.dfView.setFocusable(true);
        this.dfView.setFocusableInTouchMode(true);
    }

    public void setEditingState(KeyboardConfiguration.EditingState editingState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) editingState);
            return;
        }
        if (!this.editable.toString().equals(editingState.text)) {
            Editable editable = this.editable;
            editable.replace(0, editable.length(), editingState.text);
        }
        applyStateToSelection(editingState);
        if (!this.restartAlwaysRequired) {
            this.inputMethodManager.updateSelection(this.dfView, Math.max(Selection.getSelectionStart(this.editable), 0), Math.max(Selection.getSelectionEnd(this.editable), 0), BaseInputConnection.getComposingSpanStart(this.editable), BaseInputConnection.getComposingSpanEnd(this.editable));
        } else {
            this.inputMethodManager.restartInput(this.dfView);
        }
    }

    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.dfView.requestFocus();
            this.inputMethodManager.showSoftInput(this.dfView, 0);
        }
    }

    public void updateEditingState(NativeKeyboardTarget nativeKeyboardTarget, String str, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, nativeKeyboardTarget, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            updateEditingState(nativeKeyboardTarget.nativeKeyboard, nativeKeyboardTarget.clientId, str, i3, i16, i17, i18);
        }
    }
}
