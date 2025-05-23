package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes18.dex */
public class QuickPinyinEditText extends EditText {
    public static final String SOGOU_ACTION_ENTER = "com.sohu.inputmethod.sogou.search.enter";
    public static final String SOGOU_ACTION_SEND_INPUT = "com.sohu.inputmethod.sogou.send.input";
    public static final String SOGOU_INPUT_METHOD_ID = "com.sohu.inputmethod.sogou";
    private static final String TAG = "QuickPinyinEditText";
    private static String lastPinyin;
    private volatile String lastTextWhileCommit;
    private volatile boolean mIsInputtingPinYin;
    public int mMaxTextLen;

    public QuickPinyinEditText(Context context) {
        super(context);
        this.mIsInputtingPinYin = false;
        this.lastTextWhileCommit = "";
        this.mMaxTextLen = 200;
    }

    private void updateInputtingStatus(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateInputtingStatus : " + str);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
            this.mIsInputtingPinYin = true;
        } else {
            this.mIsInputtingPinYin = false;
        }
    }

    private void updateInputtingText(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateInputtingText : " + str);
        }
        updateInputtingStatus(str);
        if (str == null) {
            return;
        }
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        Editable text = getText();
        if (text.length() + str.length() > this.mMaxTextLen) {
            return;
        }
        if (selectionEnd > selectionStart) {
            text.replace(selectionStart, selectionEnd, str);
            setSelection(selectionStart, str.length() + selectionStart);
            lastPinyin = str;
        } else if (selectionEnd == selectionStart && selectionEnd != -1) {
            text.insert(selectionStart, str);
            setSelection(selectionStart, str.length() + selectionStart);
            lastPinyin = str;
        }
    }

    public boolean isInputtingPinYin() {
        boolean z16;
        String obj = getText().toString();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("isInputtingPinYin :  currentText= ");
            sb5.append(obj);
            sb5.append("  isInputting=");
            if (obj.startsWith(this.lastTextWhileCommit) && !obj.equals(this.lastTextWhileCommit)) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (!isSougouInput()) {
            return false;
        }
        return this.mIsInputtingPinYin;
    }

    public boolean isSougouInput() {
        return false;
    }

    public void notifyInputMethodSuggestCommit() {
        if (!TextUtils.isEmpty(lastPinyin) && isSougouInput()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "notifyInputMethodSuggestCommit : ");
            }
            ((InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).sendAppPrivateCommand(this, SOGOU_ACTION_ENTER, null);
            setSelection(getText().length());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onCreateInputConnection : ");
        }
        return super.onCreateInputConnection(editorInfo);
    }

    @Override // android.widget.TextView
    public boolean onPrivateIMECommand(String str, Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("req");
            if (SOGOU_ACTION_SEND_INPUT.equals(str) && isSougouInput()) {
                updateInputtingText(string);
            } else {
                updateInputtingStatus(string);
            }
        }
        return super.onPrivateIMECommand(str, bundle);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onTouchEvent : ");
        }
        notifyInputMethodSuggestCommit();
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public void setCursorVisible(boolean z16) {
        super.setCursorVisible(z16);
        QLog.i("ashionTest", 1, "QuickPinyinEditText  setCursorVisible=" + z16);
    }

    public QuickPinyinEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsInputtingPinYin = false;
        this.lastTextWhileCommit = "";
        this.mMaxTextLen = 200;
    }

    public QuickPinyinEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mIsInputtingPinYin = false;
        this.lastTextWhileCommit = "";
        this.mMaxTextLen = 200;
    }
}
