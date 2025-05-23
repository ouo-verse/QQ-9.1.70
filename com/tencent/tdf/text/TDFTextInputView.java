package com.tencent.tdf.text;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFTextInputView extends View {
    static IPatchRedirector $redirector_;
    private Configuration configuration;
    private EditorInfo editorInfo;
    private TDFInputConnection inputConnection;
    private TDFInputMethodDelegate inputMethodDelegate;
    private InputMethodManager inputMethodManager;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class Configuration {
        static IPatchRedirector $redirector_;
        public TDFKeyboardEnterKey enterKey;
        public String enterKeyLabel;
        public int inputType;

        public Configuration() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.inputType = 0;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private class TDFInputConnection implements InputConnection {
        static IPatchRedirector $redirector_;
        private TDFKeyboardCharacterRecognizer characterRecognizer;
        private String composingText;
        private TDFInputMethodDelegate delegate;

        public TDFInputConnection(TDFInputMethodDelegate tDFInputMethodDelegate) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TDFTextInputView.this, (Object) tDFInputMethodDelegate);
            } else {
                this.delegate = tDFInputMethodDelegate;
                this.characterRecognizer = new TDFKeyboardCharacterRecognizer();
            }
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean beginBatchEdit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean clearMetaKeyStates(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, i3)).booleanValue();
            }
            return true;
        }

        @Override // android.view.inputmethod.InputConnection
        public void closeConnection() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                iPatchRedirector.redirect((short) 27, (Object) this);
            } else {
                finishComposingText();
            }
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean commitCompletion(CompletionInfo completionInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) completionInfo)).booleanValue();
            }
            return false;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean commitContent(@NonNull InputContentInfo inputContentInfo, int i3, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 28, this, inputContentInfo, Integer.valueOf(i3), bundle)).booleanValue();
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean commitCorrection(CorrectionInfo correctionInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) correctionInfo)).booleanValue();
            }
            return false;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean commitText(CharSequence charSequence, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) charSequence, i3)).booleanValue();
            }
            this.delegate.insertText(String.valueOf(charSequence));
            return true;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
            }
            this.delegate.deleteText(i3, i16);
            return true;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean deleteSurroundingTextInCodePoints(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
            }
            this.delegate.deleteText(i3, i16);
            return true;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean endBatchEdit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean finishComposingText() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
            }
            String str = this.composingText;
            if (str != null) {
                this.delegate.insertText(str);
                this.composingText = null;
                return true;
            }
            return true;
        }

        @Override // android.view.inputmethod.InputConnection
        public int getCursorCapsMode(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
            }
            return 0;
        }

        @Override // android.view.inputmethod.InputConnection
        public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (ExtractedText) iPatchRedirector.redirect((short) 7, (Object) this, (Object) extractedTextRequest, i3);
            }
            return null;
        }

        @Override // android.view.inputmethod.InputConnection
        public Handler getHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (Handler) iPatchRedirector.redirect((short) 26, (Object) this);
            }
            return null;
        }

        @Override // android.view.inputmethod.InputConnection
        public CharSequence getSelectedText(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (CharSequence) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            return null;
        }

        @Override // android.view.inputmethod.InputConnection
        public CharSequence getTextAfterCursor(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (CharSequence) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            return null;
        }

        @Override // android.view.inputmethod.InputConnection
        public CharSequence getTextBeforeCursor(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (CharSequence) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            return null;
        }

        public boolean isComposing() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (this.composingText != null) {
                return true;
            }
            return false;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean performContextMenuAction(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, i3)).booleanValue();
            }
            return false;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean performEditorAction(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, i3)).booleanValue();
            }
            this.delegate.performEnter(0);
            return true;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean performPrivateCommand(String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) str, (Object) bundle)).booleanValue();
            }
            return false;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean reportFullscreenMode(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, z16)).booleanValue();
            }
            return true;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean requestCursorUpdates(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, i3)).booleanValue();
            }
            return false;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) keyEvent)).booleanValue();
            }
            if (keyEvent.getAction() == 0) {
                if (keyEvent.getKeyCode() != 66 && keyEvent.getKeyCode() != 160) {
                    if (keyEvent.getKeyCode() == 67) {
                        this.delegate.performBackwardDelete(keyEvent.getMetaState());
                        return true;
                    }
                    if (keyEvent.getKeyCode() == 112) {
                        this.delegate.performForwardDelete(keyEvent.getMetaState());
                        return true;
                    }
                    int recognizer = this.characterRecognizer.recognizer(keyEvent);
                    if (recognizer != 0 && this.composingText == null) {
                        this.delegate.insertText(String.valueOf((char) recognizer));
                        return true;
                    }
                    return true;
                }
                this.delegate.performEnter(keyEvent.getMetaState());
                return true;
            }
            return true;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean setComposingRegion(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean setComposingText(CharSequence charSequence, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) charSequence, i3)).booleanValue();
            }
            String valueOf = String.valueOf(charSequence);
            this.composingText = valueOf;
            this.delegate.setComposingText(valueOf, charSequence.length());
            return true;
        }

        @Override // android.view.inputmethod.InputConnection
        public boolean setSelection(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface TDFInputMethodDelegate {
        void deleteText(int i3, int i16);

        void insertText(String str);

        void performBackwardDelete(int i3);

        void performEnter(int i3);

        void performForwardDelete(int i3);

        void setComposingText(String str, int i3);
    }

    public TDFTextInputView(Context context, Configuration configuration, TDFInputMethodDelegate tDFInputMethodDelegate) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, configuration, tDFInputMethodDelegate);
            return;
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.configuration = configuration;
        this.inputMethodDelegate = tDFInputMethodDelegate;
        this.inputMethodManager = (InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
    }

    private void updateEditorInfo() {
        EditorInfo editorInfo = this.editorInfo;
        if (editorInfo != null) {
            Configuration configuration = this.configuration;
            editorInfo.inputType = configuration.inputType;
            editorInfo.imeOptions = 33554432;
            TDFKeyboardEnterKey tDFKeyboardEnterKey = configuration.enterKey;
            if (tDFKeyboardEnterKey != null) {
                editorInfo.imeOptions = tDFKeyboardEnterKey.toIMEAction() | 33554432;
                this.editorInfo.actionId = this.configuration.enterKey.toIMEAction();
            }
            String str = this.configuration.enterKeyLabel;
            if (str != null) {
                this.editorInfo.actionLabel = str;
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) keyEvent)).booleanValue();
        }
        this.inputConnection.sendKeyEvent(keyEvent);
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (InputConnection) iPatchRedirector.redirect((short) 2, (Object) this, (Object) editorInfo);
        }
        this.editorInfo = editorInfo;
        updateEditorInfo();
        if (this.inputConnection == null) {
            this.inputConnection = new TDFInputConnection(this.inputMethodDelegate);
        }
        return this.inputConnection;
    }

    public void setConfiguration(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) configuration);
        } else {
            this.configuration = configuration;
            updateEditorInfo();
        }
    }

    public void updateCaretRect(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        } else {
            this.inputMethodManager.updateCursor(this, (int) f16, (int) f17, (int) (f16 + f18), (int) (f17 + f19));
        }
    }

    public void updateSelection(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.inputMethodManager.updateSelection(this, i3, i16, i3, i16);
        }
    }

    public void updateText(String str, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        TDFInputConnection tDFInputConnection = this.inputConnection;
        if (tDFInputConnection == null || !tDFInputConnection.isComposing()) {
            this.inputMethodManager.restartInput(this);
            ExtractedText extractedText = new ExtractedText();
            extractedText.text = str;
            extractedText.startOffset = 0;
            extractedText.selectionStart = i17;
            extractedText.selectionEnd = i18;
            this.inputMethodManager.updateExtractedText(this, 0, extractedText);
            CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
            builder.setComposingText(i16, "");
            this.inputMethodManager.updateCursorAnchorInfo(this, builder.build());
        }
    }
}
