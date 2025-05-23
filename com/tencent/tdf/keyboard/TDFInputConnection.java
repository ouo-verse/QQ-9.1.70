package com.tencent.tdf.keyboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.tdf.keyboard.KeyboardChannel;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFInputConnection extends BaseInputConnection {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TDFInputConnection";
    private int batchBeginComposingEnd;
    private int batchBeginComposingStart;
    private int batchBeginSelectionEnd;
    private int batchBeginSelectionStart;
    private String batchBeginText;
    private int batchCount;
    private int combiningCharacter;
    private Editable editable;
    private EditorInfo editorInfo;
    private InputMethodManager inputMethodManager;
    private boolean isSamsung;
    private KeyboardChannel keyboardChannel;
    private Layout layout;
    private KeyboardChannel.NativeKeyboardTarget target;
    private View view;

    public TDFInputConnection(KeyboardChannel keyboardChannel, KeyboardChannel.NativeKeyboardTarget nativeKeyboardTarget, View view, Editable editable, EditorInfo editorInfo, boolean z16) {
        super(view, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, keyboardChannel, nativeKeyboardTarget, view, editable, editorInfo, Boolean.valueOf(z16));
            return;
        }
        this.keyboardChannel = keyboardChannel;
        this.view = view;
        this.editable = editable;
        this.editorInfo = editorInfo;
        this.batchCount = 0;
        this.target = nativeKeyboardTarget;
        this.inputMethodManager = (InputMethodManager) view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        this.isSamsung = z16;
        this.layout = new DynamicLayout(editable, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    private Character applyCombiningCharacterToBaseCharacter(int i3) {
        boolean z16;
        char c16 = (char) i3;
        if ((Integer.MIN_VALUE & i3) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            int i16 = i3 & Integer.MAX_VALUE;
            int i17 = this.combiningCharacter;
            if (i17 != 0) {
                this.combiningCharacter = KeyCharacterMap.getDeadChar(i17, i16);
            } else {
                this.combiningCharacter = i16;
            }
        } else {
            int i18 = this.combiningCharacter;
            if (i18 != 0) {
                int deadChar = KeyCharacterMap.getDeadChar(i18, i3);
                if (deadChar > 0) {
                    c16 = (char) deadChar;
                }
                this.combiningCharacter = 0;
            }
        }
        return Character.valueOf(c16);
    }

    private static int clampIndexToEditable(int i3, Editable editable) {
        int max = Math.max(0, Math.min(editable.length(), i3));
        if (max != i3) {
            Log.d(TAG, "Text selection index was clamped (" + i3 + "->" + max + ") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
        }
        return max;
    }

    private boolean doContextMenuAction(int i3) {
        if (i3 == 16908319) {
            this.keyboardChannel.onKeyboardAction(this.target, 17);
            return true;
        }
        if (i3 == 16908320) {
            int selectionStart = Selection.getSelectionStart(this.editable);
            int selectionEnd = Selection.getSelectionEnd(this.editable);
            if (selectionStart != selectionEnd) {
                ClipboardMonitor.setPrimaryClip((ClipboardManager) this.view.getContext().getSystemService("clipboard"), ClipData.newPlainText("text label?", this.editable.subSequence(Math.min(selectionStart, selectionEnd), Math.max(selectionStart, selectionEnd))));
                this.keyboardChannel.onKeyboardAction(this.target, 15);
            }
            return true;
        }
        if (i3 == 16908321) {
            int selectionStart2 = Selection.getSelectionStart(this.editable);
            int selectionEnd2 = Selection.getSelectionEnd(this.editable);
            if (selectionStart2 != selectionEnd2) {
                ClipboardMonitor.setPrimaryClip((ClipboardManager) this.view.getContext().getSystemService("clipboard"), ClipData.newPlainText("text label?", this.editable.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
                this.keyboardChannel.onKeyboardAction(this.target, 14);
            }
            return true;
        }
        if (i3 != 16908322) {
            return false;
        }
        ClipData primaryClip = ClipboardMonitor.getPrimaryClip((ClipboardManager) this.view.getContext().getSystemService("clipboard"));
        if (primaryClip != null) {
            this.keyboardChannel.insertText(this.target, primaryClip.getItemAt(0).coerceToText(this.view.getContext()).toString());
            this.keyboardChannel.onKeyboardAction(this.target, 16);
        }
        return true;
    }

    private void updateEditingState(String str, int i3, int i16, int i17, int i18) {
        this.inputMethodManager.updateSelection(this.view, i3, i16, i17, i18);
        this.keyboardChannel.updateEditingState(this.target, str, i3, i16, i17, i18);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        int i3 = this.batchCount + 1;
        this.batchCount = i3;
        if (i3 == 1) {
            this.batchBeginText = this.editable.toString();
            this.batchBeginSelectionStart = Selection.getSelectionStart(this.editable);
            this.batchBeginSelectionEnd = Selection.getSelectionEnd(this.editable);
            this.batchBeginComposingStart = BaseInputConnection.getComposingSpanStart(this.editable);
            this.batchBeginComposingEnd = BaseInputConnection.getComposingSpanEnd(this.editable);
        }
        return super.beginBatchEdit();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) charSequence, i3)).booleanValue();
        }
        beginBatchEdit();
        boolean commitText = super.commitText(charSequence, i3);
        endBatchEdit();
        return commitText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if (Selection.getSelectionStart(this.editable) == -1) {
            return true;
        }
        return super.deleteSurroundingText(i3, i16);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        boolean endBatchEdit = super.endBatchEdit();
        int i3 = this.batchCount;
        if (i3 == 0) {
            Log.e(TAG, "editing state should not be changed in a listener callback");
            return endBatchEdit;
        }
        if (i3 == 1) {
            int selectionStart = Selection.getSelectionStart(this.editable);
            int selectionEnd = Selection.getSelectionEnd(this.editable);
            int composingSpanStart = BaseInputConnection.getComposingSpanStart(this.editable);
            int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(this.editable);
            String obj = this.editable.toString();
            if (selectionStart != this.batchBeginSelectionStart || selectionEnd != this.batchBeginSelectionEnd || composingSpanStart != this.batchBeginComposingStart || composingSpanEnd != this.batchBeginComposingEnd || !obj.equals(this.batchBeginText)) {
                updateEditingState(obj, selectionStart, selectionEnd, composingSpanStart, composingSpanEnd);
            }
        }
        this.batchCount--;
        return endBatchEdit;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        boolean finishComposingText = super.finishComposingText();
        if (this.isSamsung) {
            CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
            builder.setComposingText(-1, "");
            this.inputMethodManager.updateCursorAnchorInfo(this.view, builder.build());
        }
        return finishComposingText;
    }

    @Override // android.view.inputmethod.BaseInputConnection
    public Editable getEditable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Editable) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.editable;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, i3)).booleanValue();
        }
        beginBatchEdit();
        boolean doContextMenuAction = doContextMenuAction(i3);
        endBatchEdit();
        return doContextMenuAction;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) keyEvent)).booleanValue();
        }
        keyEvent.getAction();
        applyCombiningCharacterToBaseCharacter(keyEvent.getUnicodeChar()).toString();
        this.keyboardChannel.sendKeyEvent(keyEvent);
        if (keyEvent.getAction() != 0) {
            return false;
        }
        if ((keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) && (this.editorInfo.inputType & 131072) == 0) {
            this.keyboardChannel.onKeyboardAction(this.target, 12);
            return true;
        }
        int unicodeChar = keyEvent.getUnicodeChar();
        if (unicodeChar != 0) {
            int max = Math.max(0, Selection.getSelectionStart(this.editable));
            int max2 = Math.max(0, Selection.getSelectionEnd(this.editable));
            int min = Math.min(max, max2);
            int max3 = Math.max(max, max2);
            beginBatchEdit();
            if (min != max3) {
                this.editable.delete(min, max3);
            }
            this.editable.insert(min, String.valueOf((char) unicodeChar));
            int i3 = min + 1;
            setSelection(i3, i3);
            endBatchEdit();
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        return super.setComposingRegion(i3, i16);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i3) {
        boolean composingText;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) charSequence, i3)).booleanValue();
        }
        beginBatchEdit();
        if (charSequence.length() == 0) {
            composingText = super.commitText(charSequence, i3);
        } else {
            composingText = super.setComposingText(charSequence, i3);
        }
        endBatchEdit();
        return composingText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setSelection(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        beginBatchEdit();
        boolean selection = super.setSelection(i3, i16);
        endBatchEdit();
        return selection;
    }
}
